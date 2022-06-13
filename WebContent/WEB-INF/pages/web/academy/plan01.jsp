<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="ak_web.classes.*" %>
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
		url : "./getPlanList",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			search_store : $("#search_store").val(),
			start_season : $("#start_season").val(),
			end_season : $("#end_season").val(),
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
					
					inner += '<tr>';
					inner += '	<td>'+result.list[i].WEB_TEXT+'</td>';
					inner += '	<td>'+result.list[i].STORE_NM+'</td>';
					inner += '	<td>('+result.list[i].SUBJECT_FG_NM+')'+result.list[i].SUBJECT_NM+'</td>';
					inner += '	<td>'+cutYoil(result.list[i].DAY_FLAG)+' ('+cutLectHour(result.list[i].LECT_HOUR)+')</td>';
					inner += '	<td><div class="write-btn" onclick="location.href=\'plan02?store='+result.list[i].STORE+'&period='+result.list[i].PERIOD+'&subject_cd='+result.list[i].SUBJECT_CD+'\'"><img src="/img/write-i.png" /></div></td>';
					inner += '</tr>';
				}
			}
			else
			{
				inner += '<tr>';
				inner += '	<td colspan="5">검색결과가 없습니다.</td>';
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
	<p class="lnb-kotit eff-t">강의 계획서 등록/수정</p>
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<div class="cour-seartop cour-seartop02">
			<div class="myaca-sear table">
				<div class="myaca-s myaca-s_s">
					<div class="search-box">
						<select id="search_store" name="search_store" de-data="${branchList[0].SHORT_NAME}">
							<c:forEach var="i" items="${branchList}" varStatus="loop">
								<option value="${i.SUB_CODE}">${i.SHORT_NAME}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="myaca-s">
					<div class="search-box">
						<select de-data="${year}년도 봄학기" id="start_season" name="start_season" onchange="">
							<%
							int year = Utils.checkNullInt(request.getAttribute("year"));
							String season[] = {"봄","여름","가을","겨울"};
							for(int i = year+1; i > 2019; i--)
							{
								for(int z = 0; z < 4; z++)
								{
									if(i == year && z == 0)
									{
										%>
										<option value="<%=i%>년도 <%=season[z]%>학기" selected><%=i%>년도 <%=season[z]%>학기</option>
										<%
									}
									else
									{
										%>
										<option value="<%=i%>년도 <%=season[z]%>학기"><%=i%>년도 <%=season[z]%>학기</option>
										<%
									}
								}
							}
							%>
						</select>
					</div>
				</div>
				<div class="myaca-dash">
					-
				</div>
				<div class="myaca-s">
					<div class="search-box disable">
						<select de-data="${year}년도 봄학기" id="end_season" name="end_season" onchange="">
							<%
							for(int i = year+1; i > 2019; i--)
							{
								for(int z = 0; z < 4; z++)
								{
									if(i == year && z == 0)
									{
										%>
										<option value="<%=i%>년도 <%=season[z]%>학기" selected><%=i%>년도 <%=season[z]%>학기</option>
										<%
									}
									else
									{
										%>
										<option value="<%=i%>년도 <%=season[z]%>학기"><%=i%>년도 <%=season[z]%>학기</option>
										<%
									}
								}
							}
							%>
						</select>
					</div>
				</div>
				<div class="search-r">
					<a class="cour-searbtn" onclick="javascript:getList();">SEARCH</a>
				</div>
			</div>
		</div>
		
		<div class="colist-wr myaca-wr">
			<table>
				<thead>
					<tr>
						<th>강좌 기간</th>
						<th>지점</th>
						<th>강좌명</th>
						<th>강의 시간</th>
						<th>계획서 작성 내역</th>
						
					</tr>
				</thead>
				<tbody id="list_target">
					<tr>
						<td>봄 학기</td>
						<td>분당점</td>
						<td>(정규)미드로 배우는 스크린 영어</td>
						<td>목 (11:00 -12:00)</td>
						<td><div class="write-btn" onclick="location.href='plan02'"><img src="/img/write-i.png" /></div></td>
					</tr>
					<tr>
						<td>봄 학기</td>
						<td>분당점</td>
						<td>(정규)미드로 배우는 스크린 영어</td>
						<td>목 (11:00 -12:00)</td>
						<td><div class="write-btn" onclick="location.href='plan02'"><img src="/img/write-i.png" /></div></td>
					</tr>
					<tr>
						<td>봄 학기</td>
						<td>분당점</td>
						<td>(정규)미드로 배우는 스크린 영어</td>
						<td>목 (11:00 -12:00)</td>
						<td><div class="write-btn" onclick="location.href='plan02'"><img src="/img/write-i.png" /></div></td>
					</tr>

					
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

