<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb05.jsp" />
<script>
var loginChk = "${resultCd}";
if (loginChk=="-1") {
	alert("${resultMsg}");
	location.href="${resultURL}";
}


</script>
<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		
		<div class="lect-step_wrap">
			<ul>
				<li>
					<div class="img"><img src="/img/lect-step01.png" /></div>
					<div class="txt"><em>step 01</em>개인정보 수집동의</div>
				</li>
				<li>
					<div class="img"><img src="/img/lect-step02.png" /></div>
					<div class="txt"><em>step 02</em>기본정보 작성</div>
				</li>
				<li>
					<div class="img"><img src="/img/lect-step03.png" /></div>
					<div class="txt"><em>step 03</em>강의계획서 작성</div>
				</li>
				<li class="on">
					<div class="img"><img src="/img/lect-step04_on.png" /></div>
					<div class="txt"><em>step 04</em>최종제출 완료</div>
				</li>
			</ul>
		</div>

		<div class="lect-wr05">
			<p class="p1">강사지원이 완료되었습니다.</p>
			<p class="p2"><span>[지원서 수정/결과]</span>에서 지원서 수정 및 합격 여부를 확인하실 수 있습니다.</p>
		</div>


		<div class="btn-center">
			<a class="btn btn01" href="/academy/result01">지원서 수정/결과</a>
			<a class="btn btn02" href="/">메인으로 돌아가기</a>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />