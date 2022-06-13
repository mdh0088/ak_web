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
	
	var cust_no = "${cust_no}";	
	
	$.ajax({
		type : "POST", 
		url : "./getEncdlist",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			order_by : order_by,
			sort_type : sort_type,
			listSize : '5',
			
			cust_no : cust_no
			
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
				inner +='	<td>'+(i+1)+'</td>';
				
				if (result.list[i].USE_YN=='N') {
					inner +='	<td>미사용</td>';
				}else{
					inner +='	<td>사용</td>';
				}
				
				if (result.list[i].ENURI_FG=='2') {
					inner +='	<td>'+comma(result.list[i].ENURI)+'원</td>';
				}else{
					inner +='	<td>'+result.list[i].ENURI+'% ';
					if (result.list[i].LIMITED_AMT > 0) {
						inner +='(최대 : '+comma(result.list[i].LIMITED_AMT)+'원)';
					}
					inner +='</td>';
				}
				
				if (result.list[i].DISCOUNT_PERIOD_START !=null) {
					inner +='<td>'+result.list[i].DISCOUNT_PERIOD_START+' - '+result.list[i].DISCOUNT_PERIOD_END+'</td>';
				}else{
					inner +='<td>-</td>'
				}
				
				inner +='	<td><div class="colist-info"><b>'+result.list[i].STORE_NM+'</b></div></td>';
		
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

</script>

<div class="lnb-top">
	<p class="lnb-entit eff-t">My Academy.</p>
	<p class="lnb-kotit eff-t">할인쿠폰 내역</p>
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<p class="sub-tit">현재수강자 <b>정길동(분당)님께서</b> 할인권 내역입니다.</p>
		<div class="cour-left">
			<p class="cour-txt">다른 수강자의 내역을 보시려면 우측의 수강자변경 버튼을 클릭하여 다른 수강자로 변경 바랍니다. </p>
			<a href="#" class="myaca-change">수강자변경<img src="/img/myaca-i04.png" alt="수강자변경 아이콘"/></a>
		</div>
		<div class="colist-wr myaca-wr01">
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>사용구분</th>
						<th>금액</th>
						<th>유효기간</th>
						<th>지점</th>
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

