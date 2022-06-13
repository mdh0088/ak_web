<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />

<script>
$(document).ready(function() {
	getList();

});

function getList(type) 
{
	$.ajax({
		type : "POST", 
		url : "./getwait",
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
						
			
			for(var i = 0; i < result.list.length; i++){
				inner +='<tr>';
				inner +='	<td><span class="chk-btn"> <input type="checkbox" class="chk_num" id="chk_num_'+(i+1)+'"/ value="'+result.list[i].STORE+'_'+result.list[i].PERIOD+'_'+result.list[i].SUBJECT_CD+'"><label for="chk_num_'+(i+1)+'"></label></span></td>';
				inner +='	<td><div class="colist-info"><b>'+result.list[i].STORE_NM+'</b></div></td>';
				inner +='	<td>'+result.list[i].REGI_DATE+'</td>';
				inner +='	<td>'+result.list[i].SUBJECT_NM+'</td>';
				inner +='	<td>'+result.list[i].WEB_LECTURER_NM+'</td>';
				inner +='	<td>('+cutYoil(result.list[i].DAY_FLAG)+') '+cutLectHour(result.list[i].LECT_HOUR)+'</td>';
				inner +='	<td>'+result.list[i].START_YMD+' ~ '+result.list[i].END_YMD+'</td>';
				inner +='	<td>'+comma(result.list[i].REGIS_FEE)+'원</td>';
				inner +='	<td>'+comma(result.list[i].FOOD_AMT)+'원</td>';
				inner +='	<td>'+result.list[i].RNUM+'</td>';
				inner +='	<td><span class="myaca-del" onclick="del_wait(\''+result.list[i].STORE+'_'+result.list[i].PERIOD+'_'+result.list[i].SUBJECT_CD+'\')"><img src="/img/myaca-i05.png" alt="삭제하기"/></span></td>';
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
function del_wait(idx){
	var wait_info="";
	
	if (idx=='chk') {
		$('.chk_num').each(function(){ 
			if ( $(this).prop('checked') ) {
				wait_info += $(this).val()+'|';
			}
		})
		
	}else{
		wait_info = idx;
	}
	
	$.ajax({
		type : "POST", 
		url : "./del_wait",
		dataType : "text",
		async : false,
		data : 
		{
			wait_info : wait_info
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
			getList();
			
						
			
		}
	});	
	
}
</script>


<div class="lnb-top">
	<p class="lnb-entit eff-t">My Academy.</p>
	<p class="lnb-kotit eff-t">대기강좌 내역</p>
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<p class="sub-tit">현재수강자 <b>정길동(분당)님의</b> 대기강좌 내역입니다.</p>
		<div class="cour-left">
			<p class="cour-txt">신청하신 강좌의 공석이 발생할 경우, 회원정보에 등록되어 있는 연락처로 대기회원 순번에 따라 연락을 드립니다.</p>
			<p class="cour-txt">다른 수강자의 내역을 보시려면 우측의 수강자변경 버튼을 클릭하여 다른 수강자로 변경 바랍니다. </p>
			<a href="#" class="myaca-change">수강자변경<img src="/img/myaca-i04.png" alt="수강자변경 아이콘"/></a>
		</div>
		<div class="colist-wr myaca-wr01">
			<table>
				<thead>
					<tr>
						<th><span class="chk-btn"><input type="checkbox" id="all" /><label for="all"></label></span></th>
						<th>지점</th>
						<th>등록일</th>
						<th>강좌명</th>
						<th>강사명</th>
						<th>시간</th>
						<th>강의기간</th>
						<th>수강료</th>
						<th>재료비</th>
						<th>순번</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="list_target">
					<tr>
						<td><span class="chk-btn"><input type="checkbox" id="number" /><label for="number"></label></span></td>
						<td><div class="colist-info"><b>분당점</b></div></td>
						<td>2020.09.11</td>
						<td>사진 촬영 고급 기법 클래스</td>
						<td>강민영</td>
						<td>(수) 13:00-14:10</td>
						<td>2020.09.11 ~2020.010.01</td>
						<td>210,000원</td>
						<td>40,000원</td>
						<td>10</td>
						<td><span class="myaca-del"><img src="/img/myaca-i05.png" alt="삭제하기"/></span></td>
					</tr>
					<tr>
						<td><span class="chk-btn"><input type="checkbox" id="number" /><label for="number"></label></span></td>
						<td><div class="colist-info"><b>분당점</b></div></td>
						<td>2020.09.11</td>
						<td>사진 촬영 고급 기법 클래스</td>
						<td>강민영</td>
						<td>(수) 13:00-14:10</td>
						<td>2020.09.11 ~2020.010.01</td>
						<td>210,000원</td>
						<td>40,000원</td>
						<td>10</td>
						<td><span class="myaca-del"><img src="/img/myaca-i05.png" alt="삭제하기"/></span></td>
					</tr>
					<tr>
						<td><span class="chk-btn"><input type="checkbox" id="number" /><label for="number"></label></span></td>
						<td><div class="colist-info"><b>분당점</b></div></td>
						<td>2020.09.11</td>
						<td>사진 촬영 고급 기법 클래스</td>
						<td>강민영</td>
						<td>(수) 13:00-14:10</td>
						<td>2020.09.11 ~2020.010.01</td>
						<td>210,000원</td>
						<td>40,000원</td>
						<td>10</td>
						<td><span class="myaca-del"><img src="/img/myaca-i05.png" alt="삭제하기"/></span></td>
					</tr>
				</tbody>
			</table>
			
		</div>
		<div class="pagination-wr">
			<div class="btn-right">
				<a class="btn btn01" onclick="javascript:del_wait('chk');">선택강좌 삭제</a>
				<a class="btn btn02" onclick="#">수강신청</a>
			</div>

			<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/>

		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />



