<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/mobile/inc/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb05.jsp" />
<jsp:include page="/inc/date_picker/date_picker.html"/>

<script>
var loginChk = "${resultCd}";
if (loginChk=="-1") {
	alert("${resultMsg}");
	location.href="${resultURL}";
}

$(document).ready(function(){ 
	var fileTarget = $('.filebox .upload-hidden'); 
	
	fileTarget.on('change', function(){ // 값이 변경되면 
	if(window.FileReader){ // modern browser 
		var filename = $(this)[0].files[0].name;
	} else { // old IE 
		var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출 
	} 
	// 추출한 파일명 삽입 
	$(this).siblings('.upload-name').val(filename);
	}); 
	
	
	var f = document.recruit;
	if (nullChk("${APLY_TYPE}")!="") {
		("${APLY_TYPE}"=="C") ? f.class_type[0].checked = true : f.class_type[1].checked = true;
	}
	
	if (nullChk("${APLY_STORE}")!="") {
		var store = "${APLY_STORE}".split('|');
		for (var i = 0; i < store.length-1; i++) {
			if (store[i]=='03') {f.lec_store[0].checked = true;}
			if (store[i]=='02') {f.lec_store[1].checked = true;}
			if (store[i]=='04') {f.lec_store[2].checked = true;}
			if (store[i]=='05') {f.lec_store[3].checked = true;}
		}
	}
	
	if (nullChk("${APLY_DAY}")!="") {
		var day_flag = "${APLY_DAY}";
		for (var i = 0; i < day_flag.length; i++) {
			if(day_flag.charAt(i)==1){f.yoil_chk[i].checked=true;}
		}
		
	}
	
	if (nullChk("${APLY_LECT_HOUR}")!="") {
		var lect_hour1 = "${APLY_LECT_HOUR}".substring(0,2);
		var lect_hour2 = "${APLY_LECT_HOUR}".substring(2,4);
		var lect_hour3 = "${APLY_LECT_HOUR}".substring(4,6);
		var lect_hour4 = "${APLY_LECT_HOUR}".substring(6,8);
		
		f.lect_hour1.value = lect_hour1;
		$('.lect_hour1').text(f.lect_hour1.value);
		
		f.lect_hour2.value = lect_hour2;
		$('.lect_hour2').text(f.lect_hour2.value);
		
		f.lect_hour3.value = lect_hour3;
		$('.lect_hour3').text(f.lect_hour3.value);
		
		f.lect_hour4.value = lect_hour4;
		$('.lect_hour4').text(f.lect_hour4.value);
		
	}
	
	if (nullChk("${APLY_TYPE}")!="") {
		$("input:radio[name='class_type']:radio[value='${APLY_TYPE}']").prop('checked', true);
	}
	choosetype("${APLY_TYPE}");
	
	if (nullChk("${LEC_MAIN_CD}")!="") {
		var main_cd = "${LEC_MAIN_CD}".split('|');
		for (var i = 0; i < main_cd.length-1; i++) {
			if (main_cd[i]=='1') {f.lec_main[0].checked = true;}
			if (main_cd[i]=='4') {f.lec_main[1].checked = true;}
			if (main_cd[i]=='3') {f.lec_main[2].checked = true;}
			if (main_cd[i]=='2') {f.lec_main[3].checked = true;}
		}
	}
	
	if (nullChk("${SUBJECT_FG}")!="") {
		var subject_fg = "${SUBJECT_FG}".split('|');
		for (var i = 0; i < subject_fg.length-1; i++) {
			if (subject_fg[i]=='1') {f.lec_fg[0].checked = true;}
			if (subject_fg[i]=='2') {f.lec_fg[1].checked = true;}
			if (subject_fg[i]=='3') {f.lec_fg[2].checked = true;}
			
		}
	}
});


function choosetype(type){
	if (type=='C') {
		$('#signiture_area').hide();
	}else{
		$('#signiture_area').show();
	}
}

function save02(){
var f = document.recruit;
	
	var chkflag=false;
	f.store.value="";
	for(i=0;i<f.lec_store.length;i++){
		if(f.lec_store[i].checked==true){
			chkflag=true;
			f.store.value+=f.lec_store[i].value+"|";
		}
	}
	
	if (chkflag==false) {
		alert("희망 지점을 선택해주세요.");
		return;
	}
	
	chkflag=false;
	f.yoil.value="";
	for(i=0;i<f.yoil_chk.length;i++){
		if(f.yoil_chk[i].checked==true){
			f.yoil.value+=""+1;
			chkflag=true;
		}else{ 
			f.yoil.value+=""+0;
		}
	}	
	
	if (chkflag==false) {
		alert("희망 요일을 선택해주세요.");
		return;
	}

	
	
	f.lect_hour.value = f.lect_hour1.value+""+f.lect_hour2.value+""+f.lect_hour3.value+""+f.lect_hour4.value;
	if (f.lect_hour.value=="00000000") {
		alert("희망 시간대를 선택해주세요.");
		return;
	}
	
	
	f.main_cd.value="";
	for(i=0;i<f.lec_main.length;i++){
		if(f.lec_main[i].checked==true){
			f.main_cd.value+=f.lec_main[i].value+"|";
		}
	}	
	
	f.subject_fg.value="";
	for(i=0;i<f.lec_fg.length;i++){
		if(f.lec_fg[i].checked==true){
			f.subject_fg.value+=f.lec_fg[i].value+"|";
		}
	}	
	
	if (f.lect_nm.value=="") {
		alert("강좌명을 입력해주세요.");
		f.lect_nm.focus();
		return;
	}
	
	if (f.lect_info.value=="") {
		alert("강좌 소개 및 특징을 입력해주세요.");
		f.lect_info.focus();
		return;
	}
	
	
	
	if (f.class_type.value=="S" && f.sig_info.value=="") {
		alert("시그니처 클래스 지원이유를 작성해주세요.");
		f.sig_info.focus();
		return;
	}
	
	chkflag=false;
	f.lec_main.value="";
	for(i=0;i<f.lec_main.length;i++){
		if(f.lec_main[i].checked==true){
			chkflag=true;
		}
	}
	
	if (chkflag==false) {
		alert("수강 대상을 선택해주세요.");
		return;
	}
	
	chkflag=false;
	f.lec_fg.value="";
	for(i=0;i<f.lec_fg.length;i++){
		if(f.lec_fg[i].checked==true){
			chkflag=true;
		}
	}
	
	if (chkflag==false) {
		alert("진행 횟수를 선택해주세요.");
		return;
	}
	
	
	if(!confirm("지원서를 저장한 후 이동하시겠습니까?"))
	{
		return;
	}	
	
	f.submit();	
	
}


function save_next(){
	
	$('input[name="returnURL"]').val("lector05");
	save02();
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
				<li class="on">
					<div class="img"><img src="/img/lect-step03_on.png" /></div>
					<div class="txt"><em>step 03</em>강의계획서 작성</div>
				</li>
				<li>
					<div class="img"><img src="/img/lect-step04.png" /></div>
					<div class="txt"><em>step 04</em>최종제출 완료</div>
				</li>
			</ul>
		</div>

		<form name ="recruit" action='/mobile/academy/save02' method='post' enctype="multipart/form-data">
			<input type="hidden" name="store">
			<input type="hidden" name="lect_hour">
			<input type="hidden" name="yoil">
			<input type="hidden" name="main_cd">
			<input type="hidden" name="subject_fg">
			<input type='hidden' name='reg_no' value='${reg_no}'/>
			<input type='hidden' name='returnURL' value='lector04'/>
			
			
			<div class="lect-wr03">
				<p class="sub-tit beno"><b>지원정보</b></p>
				<div class="row-wr">
					<div class="row">
						<p class="row-tit">지원분야 </p>
						<div>
							<ul class="td-chk">
								<li><label for="class_type"><input type="radio"  name="class_type" value="S" onclick='choosetype("S")' checked>AK시그니처 클래스</label></li>
								<li><label for="class_type"><input type="radio"  name="class_type" value="C" onclick='choosetype("C")' >일반 클래스</label></li>
							</ul>	
							<ul class="impor-ul">
								<li><span>※</span>시그니처 클래스 : 문화기획자와 1:1로 함께 만들어가는 AK만의 특별한 클래스입니다.
								<br>문화 콘텐츠 시장이 생소하시거나 브랜딩, 독창적인 커리큘럼이 필요하신 분들께 추천합니다.</li>
								<li><span>※</span>일반 클래스 : 이미 갖추어진 커리큘럼이 있고 즉시 출강이 가능하실 경우 지원 가능합니다.</li>
							</ul>
						</div>
					</div>
					<div class="row">
						<p class="row-tit">희망 지점 <span class="ro-chkinfo">(중복선택 가능)</span></p>
						<div>
							<ul class="td-chk td-chk-4">
								<li><label><input class="store" name="lec_store" value="03" type="checkbox" checked>분당</label></li>
								<li><label><input class="store" name="lec_store" value="02" type="checkbox">수원</label></li>
								<li><label><input class="store" name="lec_store" value="04" type="checkbox">평택</label></li>
								<li><label><input class="store" name="lec_store" value="05" type="checkbox">원주</label></li>
							</ul>	
						</div>
					</div>
					<div class="row">
						<p class="row-tit">희망 요일 <span class="ro-chkinfo">(중복선택 가능)</span></p>
						<div>
							<ul class="td-chk td-chk-4">
								<li><label for="yoil_mon"><input id="yoil_mon" name="yoil_chk" type="checkbox" checked>월</label></li>
								<li><label for="yoil_tue"><input id="yoil_tue" name="yoil_chk" type="checkbox">화</label></li>
								<li><label for="yoil_wed"><input id="yoil_wed" name="yoil_chk" type="checkbox">수</label></li>
								<li><label for="yoil_thu"><input id="yoil_thu" name="yoil_chk" type="checkbox">목</label></li>
							</ul>
							<ul class="td-chk td-chk-4">
								<li><label for="yoil_fri"><input id="yoil_fri" name="yoil_chk" type="checkbox">금</label></li>
								<li><label for="yoil_sat"><input id="yoil_sat" name="yoil_chk" type="checkbox">토</label></li>
								<li><label for="yoil_sun"><input id="yoil_sun" name="yoil_chk" type="checkbox">일</label></li>
							</ul>	
						</div>
					</div>
					<div class="row">
						<p class="row-tit">희망시간</p>
						<div class="table">
							<div>
								<div class="table">
									<div class="time-input time-input180 sel-scr">
									
										<select de-data="0" id="lect_hour1" name="lect_hour1">
											<c:forEach var="i" begin="0" end="23" varStatus="loop">
												<fmt:formatNumber value="${loop.index}" type="number" var="loop_index" />
												<c:if test="${fn:length(loop_index) eq 1}">
													<option value="0${loop_index}">${loop_index}</option>
												</c:if>
												<c:if test="${fn:length(loop_index) ne 1}">
													<option value="${loop_index}">${loop_index}</option>
												</c:if>
											</c:forEach>
										</select>
										
									</div>
									<div class="time-dash">:</div>
									<div class="time-input time-input180">
										<select de-data="0" id="lect_hour2" name="lect_hour2">
											<option value="00">0</option>
											<option value="10">10</option>
											<option value="20">20</option>
											<option value="30">30</option>
											<option value="40">40</option>
											<option value="50">50</option>
										</select>
									</div>
								</div>
							</div>
							<div class="time-two">ㅡ</div>
							<div>
								<div class="table">
									<div class="time-input time-input180 sel-scr">
										<select de-data="0" id="lect_hour3" name="lect_hour3">
											<c:forEach var="i" begin="0" end="23" varStatus="loop">
												<fmt:formatNumber value="${loop.index}" type="number" var="loop_index" />
												<c:if test="${fn:length(loop_index) == 1}">
													<c:set var="loop_val" value="0${loop.index}"/>
												</c:if>
												<c:if test="${fn:length(loop_index) != 1}">
													<c:set var="loop_val" value="${loop.index}"/>
												</c:if>
												<option value="${loop_val}">${loop.index}</option>
											</c:forEach>
										</select>
									</div>
									<div class="time-dash">:</div>
									<div class="time-input time-input180">
										<select de-data="0" id="lect_hour4" name="lect_hour4">
											<option value="00">0</option>
											<option value="10">10</option>
											<option value="20">20</option>
											<option value="30">30</option>
											<option value="40">40</option>
											<option value="50">50</option>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	
	
			<div class="lect-wr02">
				<p class="sub-tit beno"><b>강의계획서 작성</b></p>
				<div class="row-wr">
					<div class="row">
						<p class="row-tit">강좌명</p>
						<div>
							<input type="text" name="lect_nm" class="inp100" value="${LEC_NM}" placeholder="강좌명을 입력해주세요.">
						</div>
					</div>
					<div class="row">
						<p class="row-tit">강좌 소개 및 특징 요약</p>
						<div>
							<textarea name="lect_info" placeholder="내용을 입력해주세요.(1,000자 이상)">${LEC_INFO}</textarea>
						</div>
					</div>
					<div class="row" id="signiture_area">
						<p class="row-tit">시그니처 클래스에 지원한 이유</p>
						<div>
							<textarea name="sig_info" placeholder="내용을 입력해주세요.(1,000자 이상)">${SIG_INFO}</textarea>
						</div>
					</div>
					<div class="row">
						<p class="row-tit">수강 대상 <span class="ro-chkinfo">(중복선택 가능)</span></p>
						<div>
							<ul class="td-chk">
								<li><label><input name="lec_main" value="1" type="checkbox" checked>성인</label></li>
								<li><label><input name="lec_main" value="4" type="checkbox">초등</label></li>
								<li><label><input name="lec_main" value="3" type="checkbox">유아</label></li>
								<li><label><input name="lec_main" value="2" type="checkbox">엄마랑 아가랑</label></li>
							</ul>	
						</div>
					</div>
					<div class="row">
						<p class="row-tit">진행 횟수 <span class="ro-chkinfo">(중복선택 가능)</span></p>
						<div>
							<ul class="td-chk">
								<li><label><input name="lec_fg" value="1" type="checkbox" checked>정규</label></li>
								<li><label><input name="lec_fg" value="2" type="checkbox">단기</label></li>
								<li><label><input name="lec_fg" value="3" type="checkbox">특강</label></li>
							</ul>	
							<p>*정규 8~12회 , 단기 2회~8회, 특강 1회 </p>
						</div>
					</div>
					<div class="row">
						<p class="row-tit">첨부 파일</p>
						<div>
							<div class="filebox">
								<label for="file_nm">파일첨부</label>
								<input class="upload-name" value="${FILE_NM eq null ? '선택한 파일이 없습니다.' : FILE_ORI}" disabled="disabled">										
								<input type="file" id="file_nm" name="file_nm" class="upload-hidden">
							</div>
							<p>*각 첨부파일 당 10mb까지 업로드 가능합니다.<br>
							*작품 혹은 홍보하고 싶은 이미지를 등록해주세요.</p>
	
						</div>
					</div>
				</div>
			</div>
		</form>

		<div class="btn-center">
			<a class="btn btn01" onclick="javascript:save02();">임시저장</a>
			<a class="btn btn02" onclick="javascript:save_next();">지원하기</a>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />