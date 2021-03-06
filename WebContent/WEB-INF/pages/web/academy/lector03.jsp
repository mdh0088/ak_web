<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb05.jsp" />
<jsp:include page="/inc/date_picker/date_picker.html"/>
<script>
var loginChk = "${resultCd}";
if (loginChk=="-1") {
	alert("${resultMsg}");
	location.href="${resultURL}";
}

var cnt = 1;
$( document ).ready(function() {		
	if (nullChk("${marry_fg}")!="") {
		("${marry_fg}"=="1") ? document.getElementsByName("marry_fg")[0].checked = true : document.getElementsByName("marry_fg")[1].checked = true;
	}
	
	if (nullChk("${SCH_LEVEL}")!="") {
		$('#school_type').val(trim("${SCH_LEVEL}")).prop("selected",true);
		$('.school_type_ul li:eq('+trim("${SCH_LEVEL}")+')').prop("selected",true);
		//alert($('.school_type_ul li:eq('+trim("${SCH_LEVEL}")+')').text());
		var seq = ${SCH_LEVEL} -1;
		$('.school_type').text($('#school_type option:eq('+seq+')').text());
	}
	
	if (nullChk("${CAR2_FROM}")!="") {
		addCareer();
		$('#s_career_'+(cnt-1)).val("${CAR2_FROM}");
		$('#e_career_'+(cnt-1)).val("${CAR2_TO}");
		$('#career_detail_'+(cnt-1)).val("${CAR2_DETAIL}");
	}
	
	if (nullChk("${CAR3_FROM}")!="") {
		addCareer();
		$('#s_career_'+(cnt-1)).val("${CAR3_FROM}");
		$('#e_career_'+(cnt-1)).val("${CAR3_TO}");
		$('#career_detail_'+(cnt-1)).val("${CAR3_DETAIL}");
	}
	
	if (nullChk("${CAR4_FROM}")!="") {
		addCareer();
		$('#s_career_'+(cnt-1)).val("${CAR4_FROM}");
		$('#e_career_'+(cnt-1)).val("${CAR4_TO}");
		$('#career_detail_'+(cnt-1)).val("${CAR4_DETAIL}");
	}
	
	if (nullChk("${CAR5_FROM}")!="") {
		addCareer();
		$('#s_career_'+(cnt-1)).val("${CAR5_FROM}");
		$('#e_career_'+(cnt-1)).val("${CAR5_TO}");
		$('#career_detail_'+(cnt-1)).val("${CAR5_DETAIL}");
	}

	if (nullChk("${AWAD2_DATE}")!="") {
		addAward();
		$('#award_date_'+(cnt-1)).val("${AWAD2_DATE}");
		$('#award_from_'+(cnt-1)).val("${AWAD2_FROM}");
		$('#award_detail_'+(cnt-1)).val("${AWAD2_DETAIL}");
	}
	
	if (nullChk("${AWAD3_DATE}")!="") {
		addAward();
		$('#award_date_'+(cnt-1)).val("${AWAD3_DATE}");
		$('#award_from_'+(cnt-1)).val("${AWAD3_FROM}");
		$('#award_detail_'+(cnt-1)).val("${AWAD3_DETAIL}");
	}
	
	if (nullChk("${AWAD4_DATE}")!="") {
		addAward();
		$('#award_date_'+(cnt-1)).val("${AWAD4_DATE}");
		$('#award_from_'+(cnt-1)).val("${AWAD4_FROM}");
		$('#award_detail_'+(cnt-1)).val("${AWAD4_DETAIL}");
	}
	
	if (nullChk("${AWAD5_DATE}")!="") {
		addAward();
		$('#award_date_'+(cnt-1)).val("${AWAD5_DATE}");
		$('#award_from_'+(cnt-1)).val("${AWAD5_FROM}");
		$('#award_detail_'+(cnt-1)).val("${AWAD5_DETAIL}");
	}
	
	if (nullChk("${CERT2_DATE}")!="") {
		addCert();
		$('#cert_date_'+(cnt-1)).val("${CERT2_DATE}");
		$('#cert_from_'+(cnt-1)).val("${CERT2_FROM}");
		$('#cert_detail_'+(cnt-1)).val("${CERT2_DETAIL}");
	}
	
	if (nullChk("${CERT3_DATE}")!="") {
		addCert();
		$('#cert_date_'+(cnt-1)).val("${CERT3_DATE}");
		$('#cert_from_'+(cnt-1)).val("${CERT3_FROM}");
		$('#cert_detail_'+(cnt-1)).val("${CERT3_DETAIL}");
	}
	
	if (nullChk("${CERT4_DATE}")!="") {
		addCert();
		$('#cert_date_'+(cnt-1)).val("${CERT4_DATE}");
		$('#cert_from_'+(cnt-1)).val("${CERT4_FROM}");
		$('#cert_detail_'+(cnt-1)).val("${CERT4_DETAIL}");
	}
	
	if (nullChk("${CERT5_DATE}")!="") {
		addCert();
		$('#cert_date_'+(cnt-1)).val("${CERT5_DATE}");
		$('#cert_from_'+(cnt-1)).val("${CERT5_FROM}");
		$('#cert_detail_'+(cnt-1)).val("${CERT5_DETAIL}");
	}
});


function addCareer(){
	var len = document.getElementsByName("s_career").length;
	if (len==5) {
		alert("5?????? ???????????????.");
		return;
	}
	
	var inner='';
	inner +='<div id="career_area_'+cnt+'">';
	inner +='	<div>';
	inner +='		<input type="text" class="date-i cal-inp" id="s_career_'+cnt+'" name="s_career" value="">';
	inner +='		<span class="p-bar">-</span>';
	inner +='		<input type="text" class="date-i cal-inp" id="e_career_'+cnt+'" name="e_career" value="">';
	inner +='	</div>';
	inner +='	<div class="inp-btn">';
	inner +='		<input type="text" id="career_detail_'+cnt+'" name="career_detail" maxLength="50" placeholder="????????? ??????????????????.">';
	inner +='		<div class="td-btn">';
	inner +='			<a onclick="javascript:delCareer('+cnt+');" class="btn-del">??????</a>';
	inner +='		</div>';
	inner +='	</div>';
	inner +='</div>';
	cnt++;
	$('#target_career').append(inner);
	dateInit();
}
function delCareer(cnt){
	$('#career_area_'+cnt).remove();
}

function addAward(){
	var len = document.getElementsByName("award_date").length;
	if (len==5) {
		alert("5?????? ???????????????.");
		return;
	}
	
	var inner='';
	inner +='<div id="award_area_'+cnt+'">';
	inner +='	<input type="text" id="award_date_'+cnt+'" class="date-i cal-inp" name="award_date" value="">';
	inner +='	<input type="text" id="award_from_'+cnt+'"  maxLength="30" class="inp-m10" name="award_from" placeholder="?????? ????????? ??????????????????.">';
	inner +='	<input type="text" id="award_detail_'+cnt+'" maxLength="30" name="award_detail" placeholder="??????????????? ??????????????????.">';
	inner +='	<div class="td-btn">';
	inner +='		<a onclick="javascript:delAward('+cnt+');" class="btn-del">??????</a>';
	inner +='	</div>';
	inner +='</div>';
	cnt++;
	$('#target_award').append(inner);
	dateInit();
}
function delAward(cnt){
	$('#award_area_'+cnt).remove();
}

function addCert(){
	var len = document.getElementsByName("cert_date").length;
	if (len==5) {
		alert("5?????? ???????????????.");
		return;
	}
	
	var inner='';
	inner +='<div id="cert_area_'+cnt+'">';
	inner +='	<input type="text" id="cert_date_'+cnt+'" class="date-i cal-inp" name="cert_date" value="">';
	inner +='	<input type="text" id="cert_from_'+cnt+'" maxLength="30" class="inp-m10" name="cert_from" placeholder="?????? ????????? ??????????????????.">';
	inner +='	<input type="text" id="cert_detail_'+cnt+'" maxLength="30" name="cert_detail" placeholder="??????????????? ??????????????????.">';
	inner +='	<div class="td-btn">';
	inner +='		<a onclick="javascript:delCert('+cnt+');" class="btn-del">??????</a>';
	inner +='	</div>';
	inner +='</div>';
	cnt++;
	$('#target_cert').append(inner);
	dateInit();
}
function delCert(cnt){
	$('#cert_area_'+cnt).remove();
}

function save(way){
	
	
	
	var f = document.recruit;
	
	
	if (f.photo_nm.value=="" && "${FILE_NM}"=="") {
		alert("?????? ????????? ??????????????????.");
		return;
	}
	
	
	if ($('.school_type').text()=="??????") {
		alert('??????????????? ??????????????????.');	
		return;
	}

	if (f.school_nm.value=="") {
		alert("???????????? ???????????? ??????????????????.");
		f.school_nm.focus();
		return;
	}
	
	if (f.major.value=="") {
		alert("???????????? ???????????? ??????????????????.");
		f.major.focus();
		return;
	}
	
	if (f.school_from.value=="") {
		alert("?????? ???????????? ??????????????????.");
		f.school_from.focus();
		return;
	}
	
	if (f.school_yy_s.value=="") {
		alert("??????????????? ??????????????????.");
		f.school_yy_s.focus();
		return;
	}
	
	if (f.school_yy_e.value=="") {
		alert("??????????????? ??????????????????.");
		f.school_yy_e.focus();
		return;
	}
	
	var chkflag=false;
	for (var i = 0; i < f.school_state.length; i++) {
		if (f.school_state[i].checked==true) {
			chkflag=true;
		}
	}
	
	if (chkflag==false) {
		alert("??????????????? ??????????????????.");
		return;
	}	
	
	var len = $("input[name='s_career']").length;
	
	for (var i = 0; i < len; i++) {
		if ($('input[name="s_career"]')[i].value=="") {
			alert("?????? ???????????? ??????????????????.");
			$('input[name="s_career"]')[i].focus();
			return;
		}
		
		if ($('input[name="e_career"]')[i].value=="") {
			alert("?????? ???????????? ??????????????????.");
			$('input[name="e_career"]')[i].focus();
			return;
		}
		
		if ($('input[name="career_detail"]')[i].value=="") {
			alert("?????? ????????? ??????????????????.");
			$('input[name="career_detail"]')[i].focus();
			return;
		}
		
		
		$('input[name="s_career_0'+(i+1)+'"]').val($('input[name="s_career"]')[i].value);
		$('input[name="e_career_0'+(i+1)+'"]').val($('input[name="e_career"]')[i].value);
		$('input[name="c_detail_0'+(i+1)+'"]').val($('input[name="career_detail"]')[i].value);
	}
	
	len = $("input[name='award_date']").length;
	for (var i = 0; i < len; i++) {
		
		if ($('input[name="award_date"]')[i].value=="") {
			alert("?????? ????????? ??????????????????.");
			$('input[name="award_date"]')[i].focus();
			return;
		}
		
		if ($('input[name="award_from"]')[i].value=="") {
			alert("?????? ???????????????????????????.");
			$('input[name="award_from"]')[i].focus();
			return;
		}
		
		if ($('input[name="award_detail"]')[i].value=="") {
			alert("??????????????? ??????????????????.");
			$('input[name="award_detail"]')[i].focus();
			return;
		}
		
		$('input[name="award_date_0'+(i+1)+'"]').val($('input[name="award_date"]')[i].value);
		$('input[name="award_from_0'+(i+1)+'"]').val($('input[name="award_from"]')[i].value);
		$('input[name="award_detail_0'+(i+1)+'"]').val($('input[name="award_detail"]')[i].value);
	}
	
	len = $("input[name='cert_date']").length;
	for (var i = 0; i < len; i++) {
		
		if ($('input[name="cert_date"]')[i].value=="") {
			alert("????????? ?????? ????????? ??????????????????.");
			$('input[name="cert_date"]')[i].focus();
			return;
		}
		
		if ($('input[name="cert_from"]')[i].value=="") {
			alert("????????? ?????? ????????? ??????????????????.");
			$('input[name="cert_from"]')[i].focus();
			return;
		}
		
		if ($('input[name="cert_detail"]')[i].value=="") {
			alert("??????????????? ??????????????????.");
			$('input[name="cert_detail"]')[i].focus();
			return;
		}
		
		$('input[name="cert_date_0'+(i+1)+'"]').val($('input[name="cert_date"]')[i].value);
		$('input[name="cert_from_0'+(i+1)+'"]').val($('input[name="cert_from"]')[i].value);
		$('input[name="cert_detail_0'+(i+1)+'"]').val($('input[name="cert_detail"]')[i].value);
	}
	
	if (way!='next') {
		if(!confirm("???????????? ?????????????????????????"))
		{
			return;
		}	
	}
	f.submit();
	
}

function save_next(){
	if(!confirm("???????????? ????????? ??? ?????????????????????????"))
	{
		return;
	}
	$('input[name="returnURL"]').val("lector04");
	save('next');
}

</script>

<div class="lect-sec bg-gray">
	<div class="mu-grid">
		
		<div class="lect-step_wrap">
			<ul>
				<li>
					<div class="img"><img src="/img/lect-step01.png" /></div>
					<div class="txt"><em>step 01</em>???????????? ????????????</div>
				</li>
				<li class="on">
					<div class="img"><img src="/img/lect-step02_on.png" /></div>
					<div class="txt"><em>step 02</em>???????????? ??????</div>
				</li>
				<li>
					<div class="img"><img src="/img/lect-step03.png" /></div>
					<div class="txt"><em>step 03</em>??????????????? ??????</div>
				</li>
				<li>
					<div class="img"><img src="/img/lect-step04.png" /></div>
					<div class="txt"><em>step 04</em>???????????? ??????</div>
				</li>
			</ul>
		</div>

		<form name ="recruit" action='/academy/save' method='post' enctype="multipart/form-data">
			 <input type='hidden' name='method' value='save'/>
		     
		     <input type='hidden' name='school_level'/> <!-- x -->
		     
		     
		     <input type='hidden' name='s_career_01'/> <!-- x -->
		     <input type='hidden' name='e_career_01'/> <!-- x -->
		     <input type='hidden' name='c_detail_01'/> <!-- x -->
		     
		     <input type='hidden' name='s_career_02'/> <!-- x -->
		     <input type='hidden' name='e_career_02'/> <!-- x --> 
		     <input type='hidden' name='c_detail_02'/> <!-- x -->
		     
		     <input type='hidden' name='s_career_03'/> <!-- x -->
		     <input type='hidden' name='e_career_03'/> <!-- x -->
		     <input type='hidden' name='c_detail_03'/> <!-- x -->
		     
		     <input type='hidden' name='s_career_04'/> <!-- x -->
		     <input type='hidden' name='e_career_04'/> <!-- x -->
		     <input type='hidden' name='c_detail_04'/> <!-- x -->
		     
		     <input type='hidden' name='s_career_05'/> <!-- x -->
		     <input type='hidden' name='e_career_05'/> <!-- x -->
		     <input type='hidden' name='c_detail_05'/> <!-- x -->
		     
		     <input type='hidden' name='award_date_01'/> 
		     <input type='hidden' name='award_from_01'/> 
		     <input type='hidden' name='award_detail_01'/> 
		     
		     <input type='hidden' name='award_date_02'/> 
		     <input type='hidden' name='award_from_02'/> 
		     <input type='hidden' name='award_detail_02'/> 
		     
		     <input type='hidden' name='award_date_03'/> 
		     <input type='hidden' name='award_from_03'/> 
		     <input type='hidden' name='award_detail_03'/> 
		     
		     <input type='hidden' name='award_date_04'/> 
		     <input type='hidden' name='award_from_04'/> 
		     <input type='hidden' name='award_detail_04'/> 
		     
		     <input type='hidden' name='award_date_05'/> 
		     <input type='hidden' name='award_from_05'/> 
		     <input type='hidden' name='award_detail_05'/> 
		     
		     <input type='hidden' name='cert_date_01'/> 
		     <input type='hidden' name='cert_from_01'/> 
		     <input type='hidden' name='cert_detail_01'/> 
		     
		     <input type='hidden' name='cert_date_02'/> 
		     <input type='hidden' name='cert_from_02'/> 
		     <input type='hidden' name='cert_detail_02'/> 
		     
		     <input type='hidden' name='cert_date_03'/> 
		     <input type='hidden' name='cert_from_03'/> 
		     <input type='hidden' name='cert_detail_03'/> 
		     
		     <input type='hidden' name='cert_date_04'/> 
		     <input type='hidden' name='cert_from_04'/> 
		     <input type='hidden' name='cert_detail_04'/> 
		     
		     <input type='hidden' name='cert_date_05'/> 
		     <input type='hidden' name='cert_from_05'/> 
		     <input type='hidden' name='cert_detail_05'/> 
		     
		     <input type='hidden' name='reg_no' value='${reg_no}'/>
		     <input type='hidden' name='returnURL' value="lector03"/> 
		     
		
		
			<div class="lect-wr03">
				<p class="sub-tit beno"><b>????????????</b></p>
				<table>
					<tr class="PhotoTd">
						
						<th class="img_file" rowspan="3">
							<div>
								<img id="user_img" src="${image_path}${FILE_NM}">
							</div>
							<label style="width:100px; height:24px; padding: 0px; font-size:24px; overflow:hidden; background:url('/img/news_picture_btn.gif') no-repeat;">
								<input type='file' id="photo_nm" name=photo_nm class="file"/>
          					</label>
						</th>
						
						
						<th>??????</th>
						<td>${skor_nm}</td>
						
						<th>?????????</th>
						<td>${sh_phone_no_1}-${sh_phone_no_2}-${sh_phone_no_3}</td>
						
					</tr>
					<tr>
						<th>????????????</th>
						<td>${fn:substring(sbirth_ymd,0,4)}??? ${fn:substring(sbirth_ymd,4,6)}??? ${fn:substring(sbirth_ymd,6,8)}???</td>
						<th>?????????</th>
						<td>${semail_addr}</td>
					</tr>
	
					<tr>
						<th>????????????</th>
						<td>		
							<ul class="td-chk">
								<li><label for="marry_fg"><input type="radio" name="marry_fg" value="1" checked>??????</label></li>
								<li><label for="marry_fg"><input type="radio" name="marry_fg" value="2">??????</label></li>
							</ul>					
						</td>
						<th>?????????/SNS URL</th>
						<td><input type="text" name="sns_url" class="inp100" value="${sns_url}" placeholder="URL ??????"></td>
					</tr>
	
	
				</table>
			</div>
	
			<div class="lect-wr03">
				<p class="sub-tit beno"><b>????????????</b></p>
				<table>
					<tr>
						<th>????????????</th>
						<td class="td-school">
							<select id="school_type" class="sch-inp" name="school_type" de-data="??????">
								<option value="1">????????????</option>
								<option value="2">??????</option>
								<option value="3">?????????</option>
								<option value="4">?????????</option>
							</select>
							<span class="sch-sp">????????? </span>
							<input type="text" name="school_nm" maxLength="10" value="${SCH_NM}" placeholder="????????? ??????????????????.">
							<input type="text" name="major" maxLength="10" value="${SCH_MAJOR}" placeholder="????????? ??????????????????."> <span>??????</span>
	
						</td>
					</tr>
					<tr>
						<th>???????????????</th>
						<td>
							<input type="text" name="school_from" value="${SCH_PLACE}"  placeholder="???????????? ??????????????????."> 
	
						</td>
					</tr>
					<tr>
						<th>????????????</th>
						<td>
							<div>
								<input type="text" class="date-i cal-inp" name="school_yy_s" value="${SCH_START_YY}">
								<span class="p-bar">-</span>
								<input type="text" class="date-i cal-inp" name="school_yy_e" value="${SCH_START_YY}">
							</div>
						</td>
					</tr>
					<tr>
						<th>????????????</th>
						<td>
							<ul class="td-chk">
								<li><label for="school_state"><input type="radio" value="1" name="school_state" ${fn:trim(SCH_STATE) == '1' ? 'checked' : ''}>??????</label></li>
								<li><label for="school_state"><input type="radio" value="2" name="school_state" ${fn:trim(SCH_STATE) == '2' ? 'checked' : ''}>??????</label></li>
								<li><label for="school_state"><input type="radio" value="3" name="school_state" ${fn:trim(SCH_STATE) == '3' ? 'checked' : ''}>??????</label></li>
								<li><label for="school_state"><input type="radio" value="4" name="school_state" ${fn:trim(SCH_STATE) == '4' ? 'checked' : ''}>??????</label></li>
							</ul>	
						</td>
					</tr>
				</table>
			</div>
	
			<div class="lect-wr03">
				<p class="sub-tit beno"><b>????????????</b></p>
				<table class="lect-addt">
					<tr>
						<th>????????????</th>
						<td id="target_career">
							<div>
								<div>
									<input type="text" class="date-i cal-inp" name="s_career" value="${CAR1_FROM}">
									<span class="p-bar">-</span>
									<input type="text" class="date-i cal-inp" name="e_career" value="${CAR1_TO}">
								</div>
								<div class="inp-btn">
									<input type="text" name="career_detail" maxLength="50" value="${CAR1_DETAIL}" placeholder="????????? ??????????????????.">
									<div class="td-btn">
										<a onclick="javascript:addCareer();" class="btn-add">??????</a>
									</div>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<th>????????????</th>
						<td id="target_award">			
							<div>			
								<input type="text" class="date-i cal-inp" name="award_date" value="${AWAD1_DATE}">					
								<input type="text" class="inp-m10" name="award_from" value="${AWAD1_FROM}" maxLength="30" placeholder="?????? ????????? ??????????????????.">					
								<input type="text" name="award_detail" value="${AWAD1_DETAIL}" maxLength="30" placeholder="??????????????? ??????????????????.">
								<div class="td-btn">
									<a onclick="javascript:addAward();" class="btn-add">??????</a>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<th>?????????</th>
						<td id="target_cert">			
							<div>			
								<input type="text" class="date-i cal-inp" name="cert_date" value="${CERT1_DATE}">					
								<input type="text" class="inp-m10" name="cert_from" value="${CERT1_FROM}" maxLength="30" placeholder="?????? ????????? ??????????????????.">					
								<input type="text" name="cert_detail" value="${CERT1_DETAIL}" maxLength="30" placeholder="??????????????? ??????????????????.">
								<div class="td-btn">
									<a onclick="javascript:addCert();" class="btn-add">??????</a>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</form>

		<div class="btn-center">
			<a class="btn btn01" onclick="javascript:save();">????????????</a>
			<a class="btn btn02" onclick="javascript:save_next();">?????? ?????????</a>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />