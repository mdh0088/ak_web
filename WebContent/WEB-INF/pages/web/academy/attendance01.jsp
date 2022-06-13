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
	 
	var store='';
    var size = document.getElementsByName("store").length;
    for(var i = 0; i < size; i++){
        if(document.getElementsByName("store")[i].checked == true){
        	store=document.getElementsByName("store")[i].value;
        }
    }

	$.ajax({
		type : "POST", 
		url : "./getLectList",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			order_by : order_by,
			sort_type : sort_type,
			listSize : '10',
			store : store
			
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
			if(result.list.length > 0)
			{
			
				for(var i = 0; i < result.list.length; i++){
					inner +='<tr>';
					inner +='	<td>'+(i+1)+'</td>';	
					inner +='	<td>'+result.list[i].WEB_TEXT+'</td>';		
					inner +='	<td>'+result.list[i].STORE_NM+'</td>';		
					inner +='	<td>'+result.list[i].SUBJECT_NM+'</td>';		
					inner +='	<td>'+result.list[i].DAY+'('+result.list[i].LECT_HOUR+')</td>';		
					inner +='	<td><div class="write-btn" onclick="location.href=\'attendance02?store='+result.list[i].STORE+'&period='+result.list[i].PERIOD+'&subject_cd='+result.list[i].SUBJECT_CD+'\'"><img src="/img/rec-i.png" /></div></td>';
					inner +='</tr>';
				}
			}else{
				inner += '<tr>';
				inner += '	<td colspan="6"><div class="no-data">검색결과가 없습니다.</div></td>';
				inner += '</tr>';
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
	<p class="lnb-kotit eff-t">출석부 관리</p>
</div>


<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">

		<div class="point-title">
			<p class="en-txt04">지점선택</p>
			<ul class="poi-chk">
				<li><label for="store"><input type="radio" name="store" value="03" onclick="getList();" checked><span>분당점</span></label></li>
				<li><label for="store"><input type="radio" name="store" value="02" onclick="getList();"><span>수원점</span></label></li>
				<li><label for="store"><input type="radio" name="store" value="04" onclick="getList();"><span>평택점</span></label></li>
				<li><label for="store"><input type="radio" name="store" value="05" onclick="getList();"><span>원주점</span></label></li>
				
			</ul>	
		</div>

		<div class="colist-wr myaca-wr01">
			<table>
				<thead>
					<tr>
						<th>NO.</th>
						<th>강좌 기간</th>
						<th>지점</th>
						<th>강좌명</th>
						<th>강의 시간</th>
						<th>출석부 보기</th>
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
