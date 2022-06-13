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
function getList() 
{
	$.ajax({
		type : "POST", 
		url : "./getNewsList",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			search_store : $("#search_store").val(),
			search_type : $("#search_type").val(),
			search_name : $("#search_name").val(),
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
			if(result.list.length > 0)
			{
				for(var i = 0; i < result.list.length; i++)
				{
					inner += '<tr onclick="location.href=\'detail?seq='+result.list[i].SEQ+'\'">';
					inner += '	<td>'+result.list[i].RNUM+'</td>';
					inner += '	<td><p class="news-cate">'+result.list[i].CATEGORY+'</p></td>';
					inner += '	<td><p class="news-subj">'+result.list[i].TITLE+'</p></td>';
					inner += '	<td><div class="colist-info"><b>'+result.list[i].STORE_NM+'</b></div></td>';
					inner += '	<td class="td-date">'+cutDate(result.list[i].END_YMD)+'</td>';
					inner += '</tr>';
				}
			}
			else
			{
				inner += '<tr>';
				inner += '	<td colspan="10"></td>';
				inner += '</tr>';
			}
			$("#list_target").html(inner);
			
			$(".paging").html(makePaging(result.page, result.s_page, result.e_page, result.pageNum, 1));
		}
	});	
}
</script>
<div class="lnb-top">
	<p class="lnb-entit eff-t">AK Academy.</p>
	<p class="lnb-kotit eff-t">아카데미 뉴스</p>
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<div class="cour-seartop news-seartop">
			<div class="myaca-sear table">
				<div class="myaca-s myaca-s01">
					<div class="search-box">
						<select id="search_store" name="search_store" de-data="지점">
							<option value="">지점</option>
							<c:forEach var="i" items="${branchList}" varStatus="loop">
								<option value="${i.SUB_CODE}">${i.SHORT_NAME}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="myaca-s myaca-s01">
					<div class="search-box">
						<select id="search_type" name="search_type" de-data="제목">
							<option value="title">제목</option>
							<option value="contents">내용</option>
						</select>
					</div>
				</div>
				<div class="myaca-s myaca-s02">
					<input type="text" class="myaca-search" id="search_name" name="search_name">
				</div>
				<div class="search-r">
					<a class="cour-searbtn" onclick="javascript:getList();">SEARCH</a>
				</div>
			</div>
		</div>
		<div class="colist-wr myaca-wr01 news-list">
			<table>
				<tbody id="list_target">
<!-- 					<tr onclick="location.href='detail'"> -->
<!-- 						<td>1</td> -->
<!-- 						<td><p class="news-cate">NOTICE</p></td> -->
<!-- 						<td><p class="news-subj">전문가가 알려주는 인테리어 비밀 속지 않는 인테리어 꿀팁 노하우</p></td> -->
<!-- 						<td><div class="colist-info"><b>분당점</b></div></td> -->
<!-- 						<td class="td-date">2020.01.20</td> -->
<!-- 					</tr> -->
<!-- 					<tr onclick="location.href='detail'"> -->
<!-- 						<td>1</td> -->
<!-- 						<td><p class="news-cate">EVENT</p></td> -->
<!-- 						<td><p class="news-subj">전문가가 알려주는 인테리어 비밀 속지 않는 인테리어 꿀팁 노하우</p></td> -->
<!-- 						<td><div class="colist-info"><b>전점</b></div></td> -->
<!-- 						<td class="td-date">2020.01.20</td> -->
<!-- 					</tr> -->
<!-- 					<tr onclick="location.href='detail'"> -->
<!-- 						<td>1</td> -->
<!-- 						<td><p class="news-cate">NOTICE</p></td> -->
<!-- 						<td><p class="news-subj">전문가가 알려주는 인테리어 비밀 속지 않는 인테리어 꿀팁 노하우</p></td> -->
<!-- 						<td><div class="colist-info"><b>분당점</b></div></td> -->
<!-- 						<td class="td-date">2020.01.20</td> -->
<!-- 					</tr> -->
				</tbody>
			</table>
			
		</div>
<!-- 		<div class="pagination-wr"> -->
<!-- 			<ul class="paging"> -->
<!-- 				<li><a href="#" class="paging-prev"><img src="/img/cours-prev.png" alt="이전"></a></li> -->
<!-- 				<li><a href="#" class="active">1</a></li> -->
<!-- 				<li><a href="#">2</a></li> -->
<!-- 				<li><a href="#">3</a></li> -->
<!-- 				<li><a href="#" class="paging-next"><img src="/img/cours-next.png" alt="다음"></a></li> -->
<!-- 			</ul> -->
<!-- 		</div> -->
		<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/>
	</div>
</div>


<jsp:include page="/inc/footer.jsp" />

