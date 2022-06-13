<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb03.jsp" />
<script>
$(document).ready(function() {
	getList();

});

function getList(type) 
{
	$.ajax({
		type : "POST", 
		url : "./getchild",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			order_by : order_by,
			sort_type : sort_type,
			listSize : '10'
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			
			var result = JSON.parse(data);

			var inner = "";
			
			inner +='<tr>';
			inner +='	<td>본인</td>';
			inner +='	<td>'+result.selflist[0].KOR_NM+'</td>';
			inner +='	<td>'+result.selflist[0].BIRTH_YMD+'</td>';
			inner +='	<td></td>';
			inner +='</tr>';
			
			
			for(var i = 0; i < result.list.length; i++){
				inner +='<tr>';
				inner +='	<td>자녀</td>';
				inner +='	<td>'+result.list[i].CHILD_NM+'</td>';
				inner +='	<td>'+cutDate(result.list[i].BIRTH)+'</td>';
				inner +='	<td><span class="myaca-del" onclick="delChild(\''+result.selflist[0].CUST_NO+'_'+result.list[i].CHILD_NO+'\')"><img src="/img/myaca-i05.png" alt="삭제하기"/></span></td>';
				inner +='</tr>';
			}
			
			order_by = result.order_by;
			sort_type = result.sort_type;
			listSize = result.listSize;

			$("#list_target").html(inner);
			
			$(".paging").html(makePaging(result.page, result.s_page, result.e_page, result.pageNum, 1));
			
		}
	});		
}

function add_child(){
	
	var len = $('#list_target > tr').length;
	if (len >= 4) {
		alert('추가할 수 있는 자녀의 수는 최대 3명입니다.');
		return;
	}
	
	var birth_ymd = $('#birth_y').val()+''+$('#birth_m').val()+''+$('#birth_d').val();
	
	$.ajax({
		type : "POST", 
		url : "./addchild",
		dataType : "text",
		async : false,
		data : 
		{
			gender : $('#gender').val(),
			child_nm : $('#child_nm').val(),
			birth_ymd : birth_ymd
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			
			var result = JSON.parse(data);
			alert(result.msg);
			location.reload();
			
		}
	});	
	

}

function delChild(idx){
	if(!confirm("삭제 하시겠습니까?")){
		return;
	}
	
	var arr = idx.split('_');
	$.ajax({
		type : "POST", 
		url : "./delChild",
		dataType : "text",
		data : 
		{
			cust_no : arr[0],
			child_no : arr[1]
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			var result = JSON.parse(data);
			alert(result.msg);
			getList();
			
		}
	});	
	
}

function onSelectCust(){
	
	if($(".selcust:checked").length==0) {
		alert("수강자를 선택하세요.");

		return;
	}
	
	$.ajax({
		type : "POST", 
		url : "./chkCustNoForAjax",
		dataType : "text",
		async : false,
		data : 
		{
			cust_no : $(".selcust:checked").data("sel")
			
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			
			var result = JSON.parse(data);
			location.reload();
			
		}
	});	
	
	
	
}
</script>
<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<p class="sub-tit dis-no">현재 선택된 수강자는 <b>김길동(분당)님</b> 입니다.</p>
		<div class="colist-wr myaca-wr">
			<table>
				<thead>
					<tr>
						<th>관계</th>
						<th>성명</th>
						<th>생년월일</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="list_target">
				<!-- 
					<tr>
						<td><span class="chk-btn"><input type="checkbox" id="number" /><label for="number"></label></span></td>
						<td>본인</td>
						<td>정길동</td>
						<td>2020.09.11</td>
						<td>010-7414-2313</td>
						<td>895461331</td>
						<td><span class="myaca-del"><img src="/img/myaca-i05.png" alt="삭제하기"/></span></td>
					</tr>
					<tr>
						<td><span class="chk-btn"><input type="checkbox" id="number" /><label for="number"></label></span></td>
						<td>본인</td>
						<td>정길동</td>
						<td>2020.09.11</td>
						<td>010-7414-2313</td>
						<td>895461331</td>
						<td><span class="myaca-del"><img src="/img/myaca-i05.png" alt="삭제하기"/></span></td>
					</tr>
				 -->
				</tbody>
			</table>
			
		</div>
		<div class="pagination-wr">
			<div class="btn-right">
				<a class="btn btn02" onclick="javascript:onSelectCust();">확인</a>
			</div>
			<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/>
		</div>
		<div class="myaca-bot">
			<div class="table">
				<div>
					<ul class="margin-auto">
						<li>자녀회원 등록은 만 14세 미만 자녀에 한해 가능합니다.</li>
					</ul>
				</div>
				<div class="myacabot-tit">
					<a class="btn btn05" onclick="modBtn();">자녀회원 등록하기 <img src="/img/myaca-i04.png" alt="수강자변경 아이콘"></a>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="edit-popup children-pop" id="add_layer">
	<div class="edit-bg"></div> 
	<div class="edit-wrap edit-wrap02">
		<div class="exit" onclick="javascript:$('#add_layer').fadeOut(200);"><img src="/img/exit.png" alt="close" /></div>
		<h3>자녀회원 등록</h3>
		<div class="cour-left-pop">
<!-- 			<p class="cour-txt">- 현재 선택하신 점은 <span class="color-37"><분당점></span>입니다.</p> -->
			<p class="cour-txt">- 자녀회원 등록은 만 14세 미만 자녀에 한해 가능합니다.</p>
		</div>
		
		<div class="edi-tablewr add-boxwr">
			<table>
				<tr>
					<th>관계</th>
					<td>
	                  <div class="search-box search-box02">
	                     <select id="gender" de-data="아들">
	                        <option value="M">아들</option>
	                        <option value="F">딸</option>
	                     </select>
	                  </div>
					</td>
				</tr>
				<tr>
					<th>성명</th>
					<td>
						<input id="child_nm" type="text">
					</td>
				</tr>
				<tr class="regi-tr">
					<th>생년월일</th>
					<td>
						<div class="table verti-mid">
							<div>
		                        <div class="search-box search-box02">
		                           <select id="birth_y" de-data="2020">
		                           <c:set var="now" value="<%=new java.util.Date()%>" />
									<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
		                           <c:forEach var="i" begin="0" end="${sysYear-1940}">
		                             	<c:set var="yearOption" value="${sysYear-i}" />
    									<option value="${yearOption}">${yearOption}</option>
		                           </c:forEach>
		                           </select>
		                        </div>
							</div>
							<div class="line-sp">년</div>
							<div>
		                        <div class="search-box search-box02">
		                           <select id="birth_m" de-data="01">
			                           <c:forEach var="i"  varStatus="status" begin="1" end="12">
			                            
	    									<option value="<fmt:formatNumber minIntegerDigits="2" value="${i}" />">
	    										<fmt:formatNumber minIntegerDigits="2" value="${i}" />
	    									</option>
	    									
			                           </c:forEach>
		                           </select>
		                        </div>
							</div>
							<div class="line-sp">월</div>
							<div>
		                        <div class="search-box search-box02">
		                           <select id="birth_d" de-data="01">
			                           <c:forEach var="i" varStatus="status"  begin="1" end="31">
	    									<option value="<fmt:formatNumber minIntegerDigits="2" value="${i}" />">
	    										<fmt:formatNumber minIntegerDigits="2" value="${i}" />
	    									</option>
			                           </c:forEach>
		                           </select>
		                        </div>
							</div>
							<div class="line-sp">일</div>
						</div>
					</td>
				</tr>
			
			</table>
			
		</div>

		<div class="btn-center">
			<a class="btn btn01 close-btn">취소</a>
			<a class="btn btn02" onclick="javascript:add_child();">저장</a>
		</div>
	</div>
</div>

<script>
	function modBtn(){
		$('#add_layer').fadeIn(200);	
	}
</script>
<jsp:include page="/inc/footer.jsp" />

