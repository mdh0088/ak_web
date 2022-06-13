<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/course/lnb01.jsp" />

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<p class="sub-tit">수강신청</p>
		<div class="cour-left">
			<p class="cour-txt">- 자녀강좌 내역을 보시려면 우측의 수강자변경 버튼을 클릭하여 실제 수강자명으로 변경 바랍니다.</p>
			<p class="cour-txt">- 각 강좌는 정원에 따라 선착순으로 접수, 마감되며 강좌 개강에 필요한 최소인원에 미달할 경우 폐강될 수 있습니다.</p>
		</div>

		<div class="course-apl">
			<p class="sub-stit">정규강좌 안내</p>
			<table class="table01">
				<tr>
					<th>수업횟수</th>
					<td>기본 주 1회, 3개월 10~12회<span class="color-r">(법정공휴일, 백화점 휴점일에는 수업을 진행하지 않습니다.)</span></td>
				</tr>
				<tr>
					<th>수강료</th>
					<td>3개월 분(재료비 별도)</td>
				</tr>				
			</table>
		</div>
		<!-- 
		<div class="course-apl">
			<p class="sub-stit">결제수단 안내</p>
			<p class="cour-txt">현금, 신용카드, 상품권 (요리강좌 제외)</p>
			<table class="table01">
				<tr>
					<th>방문신청</th>
					<td>기본 주 1회, 3개월 10~12회(법정공휴일 휴강, 별도보강 없음)</td>
				</tr>
				<tr>
					<th>인터넷신청</th>
					<td>신용카드</td>
				</tr>				
			</table>
		</div>
		<div class="course-apl">
			<p class="sub-stit">정규강좌 안내</p>
			<p class="cour-txt">중도수강은 정규강좌(10~12회)에 한하며 일부강좌의 경우 중도수강이 불가능할 수 있습니다.</p>
			<p class="cour-txt">단기강좌(2회~9회) 중도수강 시 수강료를 전액 지불하셔야 합니다.</p>
			<table class="table01">
				<tr>
					<th>개강 첫달</th>
					<td>수강료 100% 지불</td>
				</tr>
				<tr>
					<th>개강 다음달 첫주까지</th>
					<td>2개월 분 수강료 지불</td>
				</tr>
				<tr>
					<th>개강 다음달 첫주 이후</th>
					<td>중도수강 불가</td>
				</tr>
			</table>
		</div>
		 -->
	</div>
</div>

<jsp:include page="/inc/footer.jsp" />

