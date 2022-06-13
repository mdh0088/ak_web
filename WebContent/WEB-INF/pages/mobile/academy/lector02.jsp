<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/mobile/inc/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb05.jsp" />

<script>
var loginChk = "${resultCd}";
if (loginChk=="-1") {
	alert("${resultMsg}");
	location.href="/user/login";
}

function pageMove(idx){
	var reg_no = idx;
	
	if (document.getElementsByName("agree_chk")[0].checked == true) {
		location.href='/mobile/academy/lector03?reg_no='+idx;
	}else{
		alert("동의를 해주세요.");
		return;
	}
}

function delAply(reg_no){
	if(!confirm("지원을 취소하시겠습니까?"))
	{
		return;
	}	
	
	$.ajax({
		type : "POST", 
		url : "./delAply",
		dataType : "text",
		async : false,
		data : 
		{
			reg_no:reg_no
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			var result = JSON.parse(data);
			alert(result.msg);
			location.href="/main";
		}
	});	
}

</script>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		
		<div class="lect-step_wrap">
			<ul>
				<li class="on">
					<div class="img"><img src="/img/lect-step01_on.png" /></div>
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
				<li>
					<div class="img"><img src="/img/lect-step04.png" /></div>
					<div class="txt"><em>step 04</em>최종제출 완료</div>
				</li>
			</ul>
		</div>


		<p class="sub-tit beno"><b>개인정보 수집 · 이용 동의서</b></p>
		<p class="sub-font17">1. 개인정보 수집항목, 수집목적 및 보유/이용 기간</p>
		
		<div class="lect-wr02">
			<table>
				<colgroup>
					<col style="width:15%" />
					<col style="width:10%" />
					<col />
				</colgroup>
				<tr>
					<th rowspan="3">지원 대상</th>
					<td class="bold" rowspan="2">필수</td>
					<td>성명,  생년월일, 성별,  사진, 학력/경력 <Br> 연락처, 주소, 이메일</td>
				</tr>
				<tr>
					<td><b class="font-120 color-blue text-deco">고유식별 정보(주민등록 번호)</b>, 계좌정보 <br>
					※ 출강확정 강사에 한함</td>
				</tr>
				<tr>
					<td class="bold">선택</td>
					<td>자격증, 수상내역</td>
				</tr>
				<tr>
					<th rowspan="3">목적</th>
					<td class="bold" rowspan="2">필수</td>
					<td><b class="font-120 color-blue text-deco">강사 지원자 자격 검토, 강좌 진행시 기본 프로필 제공 공지 및 강좌관련 협의 시 소통 경로 확보</b></td>
				</tr>
				<tr>
					<td><b class="font-120 color-blue">세무신고, 원천징수영수증 발급</b><b>[국세기본법 시행령 제68조, 소득세법 제145조, 164조 의거] </b></td>
				</tr>
				<tr>
					<td class="bold">선택</td>
					<td><b class="text-deco">강사 출강 자격 검토 시 추가고려</b></td>
				</tr>
				<tr>
					<th colspan="2" >지원 대상</th>
					<td>
						<ul>
							<li class="font-120 color-blue text-deco">지원자 요청 시 즉시 파기</li>
							<li class="font-120 color-blue text-deco">- <span>불합격</span> : 심사완료  14일 후 삭제</li>
							<li class="font-120 color-blue text-deco">- <span>합격</span> : 출강종료  5년 후 삭제</li>
						</ul>
					</td>
				</tr>

			</table>
		</div>

		<p class="sub-font17">2. 위 개인정보는 AK문화아카데미 운영 외에는 다른 용도로 사용하지 않습니다.</p>
		<p class="sub-font17">3. 개인정보 수집ㆍ이용 동의는 거부하실 수 있으며, 다만 이 경우 강사지원이 제한 됩니다.</p>
		
		<div class="lect-chk">
			<label><input name="agree_chk" type="checkbox">본인은 위 내용을 이해하고 동의합니다.</label>
		</div>

		<div class="btn-center">
			<a class="btn btn01" onclick="javascript:delAply(${reg_no})">지원취소</a>
			<a class="btn btn02" onclick="javascript:pageMove(${reg_no})">다음 단계로</a>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />