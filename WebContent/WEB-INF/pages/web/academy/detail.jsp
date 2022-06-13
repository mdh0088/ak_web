<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<div class="lnb-top">
	<p class="lnb-entit eff-t">My Academy.</p>
	<p class="lnb-kotit eff-t">아카데미 뉴스</p>
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<div class="colist-wr myaca-wr01 news-detail">
			
			<div class="detail-tit">
				<span>Academy News</span>
				<p>${data.TITLE}</p>
			</div>
			<div class="table detail-info">
				<div class="deinfo-l">${data.STORE_NM}</div>
				<div class="deinfo-r">
					<p>
						<span>등록일</span>
						<fmt:parseDate var="create_date" value="${data.CREATE_DATE}" pattern="yyyyMMddHHmmss" />
						<fmt:formatDate value="${create_date}" pattern="yyyy.MM.dd" />
					</p>
					<p><span>조회수</span>${data.NVL_VIEWS}</p>
				</div>
			</div>
			<c:if test="${data.FILENAME ne null}">
				<p class="attach-p"><b><img src="/img/attach-icon.png" alt="첨부파일"/>첨부파일</b>
					<a href="${image_dir}news/${data.FILENAME}" download>${data.FILENAME_ORI}</a></p>
			</c:if>
			<div class="de-contents">
				${data.CONTENTS}
			</div>
			<div class="pagination-table">
				<table>
					<tbody>
						
							
							<c:if test="${data.PRE_NO eq null}">
								<tr>
									<td>이전글<img src="/img/detail-prev.png" alt="이전"/></td>
									<td></td>
									<td><p class="news-subj">${data.PRE_TITLE }</p></td>
									<td></td>
									<td class="td-date"></td>
								</tr>
							</c:if>
							<c:if test="${data.PRE_NO ne null}">
								<tr onclick="javascript:location.href='/academy/detail?seq=${data.PRE_NO}'">
									<td>이전글<img src="/img/detail-prev.png" alt="이전"/></td>
									<td><p class="news-cate">${data.PRE_CATEGORY }</p></td>
									<td><p class="news-subj">${data.PRE_TITLE }</p></td>
									<td><div class="colist-info"><b>${data.PRE_STORE_NM}</b></div></td>
									<td class="td-date">
										<fmt:parseDate var="pre_create_date" value="${data.PRE_CREATE_DATE}" pattern="yyyyMMddHHmmss" />
										<fmt:formatDate value="${pre_create_date}" pattern="yyyy.MM.dd" />
									</td>
								</tr>
							</c:if>
						
							<c:if test="${data.NEXT_NO eq null}">
								<tr>
									<td>다음글<img src="/img/detail-prev.png" alt="다음"/></td>
									<td></td>
									<td><p class="news-subj">${data.NEXT_TITLE }</p></td>
									<td></td>
									<td class="td-date"></td>
								</tr>
							</c:if>
							<c:if test="${data.NEXT_NO ne null}">
								<tr onclick="javascript:location.href='/academy/detail?seq=${data.NEXT_NO}'">
									<td>다음글<img src="/img/detail-prev.png" alt="다음"/></td>
									<td><p class="news-cate">${data.NEXT_CATEGORY }</p></td>
									<td><p class="news-subj">${data.NEXT_TITLE }</p></td>
									<td><div class="colist-info"><b>${data.NEXT_STORE_NM}</b></div></td>
									<td class="td-date">
										<fmt:parseDate var="next_create_date" value="${data.NEXT_CREATE_DATE}" pattern="yyyyMMddHHmmss" />
										<fmt:formatDate value="${next_create_date}" pattern="yyyy.MM.dd" />
									</td>
								</tr>
							</c:if>
					</tbody>
				</table>
			</div>
		</div>
		<div class="course-btnwr">
			<a class="btn btn02" href="news">목록으로 돌아가기</a>
		</div>
	</div>
</div>

<jsp:include page="/inc/footer.jsp" />

