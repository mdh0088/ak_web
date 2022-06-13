<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb06.jsp" />

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		
		<p class="sub-tit">발급 내역</p>
		<div class="cour-left">
			<p class="cour-txt">- [발급완료] 버튼을 클릭하시면 요청하신 문서를 확인하실 수 있습니다 .</p>
		</div>

		<div class="colist-wr myaca-wr">
			<table>
				<thead>
					<tr>
						<th>NO.</th>
						<th>발급처</th>
						<th>신청 서류</th>
						<th>용도</th>
						<th>제출처</th>
						<th>발급 내역 보기</th>						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>AK문화아카데미 분당점</td>
						<td>출강증명서</td>
						<td>타회사 제출용</td>
						<td>AK문화아카데미 원주점</td>
						<td><div class="write-btn"><img src="/img/rec-i.png" /></div></td>
					</tr>
					<tr>
						<td>1</td>
						<td>AK문화아카데미 분당점</td>
						<td>출강증명서</td>
						<td>타회사 제출용</td>
						<td>AK문화아카데미 원주점</td>
						<td><div class="write-btn"><img src="/img/rec-i.png" /></div></td>
					</tr>
					<tr>
						<td>1</td>
						<td>AK문화아카데미 분당점</td>
						<td>출강증명서</td>
						<td>타회사 제출용</td>
						<td>AK문화아카데미 원주점</td>
						<td><div class="write-btn"><img src="/img/rec-i.png" /></div></td>
					</tr>
					
				</tbody>
			</table>
			
		</div>
		<div class="pagination-wr">
			
			<ul class="paging">
				<li><a href="#" class="paging-prev"><img src="/img/cours-prev.png" alt="이전"></a></li>
				<li><a href="#" class="active">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#" class="paging-next"><img src="/img/cours-next.png" alt="다음"></a></li>
			</ul>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />