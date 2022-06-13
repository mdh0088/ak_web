<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />


<script>
$(document).ready(function() {
	getList();
	getSeason();

});


function getList(type) 
{	
	$.ajax({
		type : "POST", 
		url : "./getContractInfo",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			order_by : order_by,
			sort_type : sort_type,
			listSize : '10',
			store : $('#store').val(),
			start_ymd : nullChk($('#start_ymd').val()),
			end_ymd : nullChk($('#end_ymd').val())
			
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
			
			
			for(var i = 0; i < result.list.length; i++){
				inner +='<tr>';
				if (result.list[i].CONFIRM_YN=='Y' && result.list[i].SUBMIT_FG=='Y') {					
					inner +='	<td><p class="f-gray">계약완료</p></td>';
				}else if(result.list[i].CONFIRM_YN=='N' && result.list[i].SUBMIT_FG=='Y'){
					inner +='	<td><p class="f-redline">계약전</p></td>';
				}
				
				inner +='	<td>'+result.list[i].SEASON_NM+'</td>';
				inner +='	<td>'+result.list[i].STORE_NM+'</td>';
				//inner +='	<td>'+result.list[i].WEB_LECTURER_NM+'</td>';
				inner +='	<td>'+result.list[i].SUBJECT_NM+'</td>';
				if (nullChk(result.list[i].CONTRACT_DAY)!='') {					
					inner +='	<td>'+result.list[i].CONTRACT_DAY+'</td>';
				}else{
					inner +='	<td>-</td>';
				}
					inner +='	<td><div class="write-btn" onclick="location.href=\'/academy/contract02?store='+result.list[i].STORE+'&period='+result.list[i].PERIOD+'&subject_cd='+result.list[i].SUBJECT_CD+'\'"><img src="/img/rec-i.png" /></div></td>';
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

function getSeason(idx) 
{
	var store = nullChk($(idx).val());
	if (store=="") {
		store='03';
	}
	
	$.ajax({
		type : "POST", 
		url : "./getSeason",
		dataType : "text",
		async : false,
		data : 
		{
			store : store
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			$("#start_ymd").val('');
			$("#end_ymd").val('');
			$('.start_ymd').text('');
			$('.end_ymd').text('');
			
			var result = JSON.parse(data);
			var inner ="";
			var inner_li="";
			if (result.list.length>0) {		
				$("#start_ymd").empty();
				$("#end_ymd").empty();
				$('.start_ymd_ul').empty();
				$('.end_ymd_ul').empty();
				
				for(var i = 0; i < result.list.length; i++){
					inner +='<option value="'+result.list[i].PERIOD+'">'+result.list[i].WEB_TEXT+'</option>';
					inner_li += '<li>'+result.list[i].WEB_TEXT+'</li>';
				}
			}
			$("#start_ymd").html(inner);
			$("#end_ymd").html(inner);
			$('.start_ymd_ul').html(inner_li);
			$('.end_ymd_ul').html(inner_li);
		}
	});		
}

</script>


<div class="lnb-top">
	<p class="lnb-entit eff-t">AK Academy.</p>
	<p class="lnb-kotit eff-t">강사계약</p>
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<div class="cour-seartop cour-seartop02">
			<div class="myaca-sear table">
				<div class="myaca-s myaca-s_s">
					<div class="search-box">
						<select de-data="분당점" id="store" onchange='getSeason(this)'>
							<c:forEach var="i" items="${branchList}" varStatus="loop">
								<c:if test="${i.SUB_CODE eq '03' }">
									<option value="${i.SUB_CODE}">${i.SHORT_NAME }</option>
								</c:if>
								<c:if test="${i.SUB_CODE ne '03' }">
									<option value="${i.SUB_CODE}">${i.SHORT_NAME }</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="myaca-s">
					<div class="search-box">
						<select de-data="전체" id="start_ymd">
							
						</select>
					</div>
				</div>
				<div class="myaca-dash">
					-
				</div>
				<div class="myaca-s">
					<div class="search-box disable">
						<select de-data="전체" id="end_ymd">

						</select>
					</div>
				</div>
				<div class="search-r">
					<a class="cour-searbtn" onclick="Javascript:getList()">SEARCH</a>
				</div>
			</div>
		</div>
		
		<div class="colist-wr myaca-wr attend-wr02">
			<table>
				<thead>
					<tr>
						<th>계약 상태</th>
						<th>강좌 기간</th>
						<th>지점</th>
						<th>강좌명</th>
						<th>계약 일시</th>
						<th>계약서 보기</th>
						
					</tr>
				</thead>
				<tbody id="list_target">
					
					
				</tbody>
			</table>
			
		</div>
		<div class="pagination-wr">
			<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/>
		</div>
	</div>
</div>


<jsp:include page="/inc/footer.jsp" />

