<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/course/lnb01.jsp" />

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<p class="sub-tit">강좌변경 및 취소</p>
		<div class="cour-left">
			<p class="cour-txt">- 강좌의 변경 및 취소는 개강 1일전까지 가능하며, 연기 또는 양도는 불가합니다. </p>
   			<p class="cour-txt cour-txt02">단, 재료준비가 필요한 강좌 (요리,플라워,공예 등)는 개강 3일전, 여행/소수정예 강좌는 7일 전까지만 취소/변경 가능합니다.  </p>
			<p class="cour-txt">- 방문취소의 경우 오전 10:30~오후 7:00까지 가능하며 취소 시 영수증과 결제카드를 지참해주시기 바랍니다.</p>
			<p class="cour-txt">- 방문하여 신청한 강좌는 신청하신 해당 지점에 방문하셔야 취소 가능합니다.</p>
			<p class="cour-txt">- 강좌 개강일 이후 개인사정에 의한 취소 시에는 '평생교육법 시행령 제23조'에 의거하여 환불해 드립니다.</p>
		</div>

		<div class="course-apl">
			<table class="table02">
				<colgroup>
					<col width="320px">
					<col />
					<col/>
					<col />
				</colgroup>
				<tr>
					<th>전액 환불</th>
					<td colspan="3">강좌 개강일 1일 전까지 취소시 적용되며, 강좌 개강 당일은 수업참여 여부와 관계없이 전액 환불 불가합니다.</td>
				</tr>
				<tr>
					<th rowspan="2">부분 환불</th>
					<td rowspan="2">해당 강좌 개강일 이후 취소</td>
					<td align="center">1개월 이내 강좌</td>
					<td>
						강좌 진행 1/3 경과 전 수강료의 2/3 환불 <br>
						강좌 진행 1/2 경과 전 수강료의 1/2 환불 <br>
						강좌 진행 1/2 경과 후 환불 불가
					</td>
				</tr>
				<tr>
					<td align="center">1개월 초과 강좌</td>
					<td>
						1개월 이내 기준 적용 환불 + 잔여월분 환불
					</td>
				</tr>	
			</table>
		</div>
	</div>
</div>

<jsp:include page="/inc/footer.jsp" />

