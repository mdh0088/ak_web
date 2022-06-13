<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb05.jsp" />

<script>

function goNewsWrite(){
 	var loginChk="${loginChk}";
	var memType ="${memType}";
	
	if (loginChk=="false" ) {
		alert("로그인 후 지원해주세요.");	
		return;
	}
	
	if (memType=="S") {
		$('#sign_popup').show();
		return;
	}
	
	if (loginChk!="false" && memType != "S") {		
		location.href='goNewsWrite';
	}
	
}
</script>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<p class="sub-tit">강사지원</p>

		<div class="lect-wr">
			<table class="table">
				<tbody>
					<tr>
						<th>지원대상</th>
						<td>
							<ul class="lect-ul">
								<li>- 해당분야 우수 경력 소유자</li>
								<li>- 교육 프로그램 운영 업체</li>
							</ul>
						</td>
					</tr>
					<tr>
						<th>지원방법</th>
						<td>
							<ul class="lect-ul">
								<li>- AK멤버스 가입 후 지원 가능합니다. <span>[개인정보 수집 동의 > 지원서 작성 > 최종제출]</span></li>
							</ul>
						</td>
					</tr>
					<tr>
						<th>지원 결과 확인</th>
						<td>
							<ul class="lect-ul">
								<li>- 합격자에 한해 개별연락 드리며, 이후 담당자와 채용관련 협의를 별도 진행합니다.</li>
							</ul>
						</td>
					</tr>
					<tr>
						<th>지원서 작성 시 유의사항</th>
						<td>
							<ul class="lect-ul">
								<li>- 강사지원을 위해 개인정보 수집ㆍ이용 동의를 하셔야 합니다.</li>
								<li>- 지원서 내용이 사실과 다를 경우 채용이 취소 될 수 있습니다.</li>
							</ul>
						</td>
					</tr>
					
				</tbody>
			</table>
		</div>
		<div class="btn-center">
			<a class="btn btn03" onclick="javascript:goNewsWrite()">지원서 작성하기</a>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />