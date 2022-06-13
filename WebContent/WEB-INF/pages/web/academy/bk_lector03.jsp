<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb05.jsp" />
<jsp:include page="/inc/date_picker/date_picker.html"/>
					
<script>
var blob = "${recruitPhoto}";

$( document ).ready(function() {
	console.log("di : ${di}");
	console.log("ci : ${ci}");
	console.log("user_id : ${user_id}");
	console.log("check : ${check}");
	console.log("reg_no : ${reg_no}");
	console.log("returnURL : ${returnURL}");
	console.log("recruitPhoto : ${recruitPhoto}");
	console.log("recruitFileInfo : ${recruitFileInfo}");
	console.log("result : ${result}");
	
});

var returnURL = "${returnURL}";

if (returnURL!="N") {
	document.location.href=returnURL;
}


//function goFindPostCode() {
	/* 미사용 새주소 변경으로  goFindPostCode(section) 이용
	// 구주소/신주소 구분하여 검색(2012.02.22)
	
	var f = document.recruit;  
	if(f.h_new_addr_yn.value=="1") {
		window.open('/cult/postcodelist.do?method=view', 'recruit', 'width=510,height=405');
		//window.open("/cult/postcodelist.do?method=oldlist&postCode1=postCode1&postCode2=postCode2&address1=address1&address2=address2", "postCode", "width=402, height=350");	
	}else if(f.h_new_addr_yn.value=="2") {
		//window.open('/cult/postcodelist.do?method=newlist', 'recruit', 'width=800,height=500');
		window.open("/cult/postcodelist.do?method=newlist&postcode1=postcode1&postcode2=postcode2&address1=address1&address2=address2", "postcode", "width=795, height=364");		
	}else {
		alert("자택주소 구주소/신주소 선택해주세요 .");
      	return;
	}
	
	*/	

	//window.open("/cult/juso_pop/jusoA.jsp", "postCode", "width=548, height=698, scrollbars=no");
	/*
	 * 카카오/행안부 API 적용
	*/

	/*
	var width = 480;
	var height = 623;
	var posLeft = (screen.width - (width * 1)) / 2;
	var posTop = (screen.height - (height * 1)) / 2;
	var url = "/common/search_addr";
	
	var win = window.open(url, "juso", "toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=" + width + ",height=" + height + ",top=" + posTop + ",left=" + posLeft);
	win.focus();
}
*/


/*
function emailSet(obj) {
	
	var f = document.recruit;
	
	if(obj.value=="Input") {
		f.email_02.readOnly = false;
		f.email_02.value = "";
		f.email_02.focus();
	} else {
		f.email_02.readOnly = true;
		switch(obj.value) {
			case "chol.com" : f.email_02.value = "chol.com"; break;
			case "korea.com" : f.email_02.value = "korea.com"; break;
			case "paran.com" : f.email_02.value = "paran.com"; break;
			case "hanafos.com" : f.email_02.value = "hanafos.com"; break;
			case "gmail.com" : f.email_02.value = "gmail.com"; break;
			case "dreamwiz.com" : f.email_02.value = "dreamwiz.com"; break;
			case "empal.com" : f.email_02.value = "empal.com"; break;
			case "freechal.com" : f.email_02.value = "freechal.com"; break;
			case "hanmir.com" : f.email_02.value = "hanmir.com"; break;
			case "hotmail.com" : f.email_02.value = "hotmail.com"; break;
			case "lycos.co.kr" : f.email_02.value = "lycos.co.kr"; break;
			case "msn.com" : f.email_02.value = "msn.com"; break;
			case "nate.com" : f.email_02.value = "nate.com"; break;
			case "naver.com" : f.email_02.value = "naver.com"; break;
			case "yahoo.co.kr" : f.email_02.value = "yahoo.co.kr"; break;
		
		}
	}
}
*/


/*
function emailChange() {
	var f = document.recruit;
	f.email_03.value = "Input";
	f.email_02.value = "";
}
*/


/*
function OnlyNumber(obj) {
	  e = window.event; 
	 
	  if( ( e.keyCode >=  48 && e.keyCode <=  57 ) ||   //숫자열 0 ~ 9 : 48 ~ 57
	      ( e.keyCode >=  96 && e.keyCode <= 105 ) ||   //키패드 0 ~ 9 : 96 ~ 105
	        e.keyCode ==   8 ||    //BackSpace
	        e.keyCode ==  46 ||    //Delete
	        e.keyCode ==  37 ||    //좌 화살표
	        e.keyCode ==  39 ||    //우 화살표
	        e.keyCode ==  35 ||    //End 키
	        e.keyCode ==  36 ||    //Home 키
	        e.keyCode ==   9       //Tab 키
	    ) {
	  		return;
	    }
	    	else 
	 {
	  e.returnValue=false;
	  e.value = "";
	  alert('숫자만 입력가능합니다');
	  
	 }
}
*/

function OnlyChar(obj){
	e = window.event; 
	
	if( ( e.keyCode >=  48 && e.keyCode <=  57 ) ||   //숫자열 0 ~ 9 : 48 ~ 57
      ( e.keyCode >=  96 && e.keyCode <= 105 )){    //키패드 0 ~ 9 : 96 ~ 105{
  		e.returnValue= false;
 			e.value = "";
 			 alert('숫자는 입력 불가능 합니다');
    }
    	else 
	 {
	 		return;
	 }
}
	
/*
function check(obj){
	
	if (event.keyCode==34 || event.keyCode==39 ||event.keyCode == 64) {
		event.returnValue = false;
		alert('정확한 메일을 입력해 주세요');
	}else{
	 return;
		}
	}
	
	function block(obj){
	if (event.keyCode==34 || event.keyCode==39){ 
	event.returnValue = false;
	 alert('입력하실수 없는 글자입니다');
	}else{
	 return;
		}
}
*/
	
function save(){
		
		var f = document.recruit;
				
		
			
	  		f.s_career_01.value = f.s_career.value.substring(0,4) + f.s_career.value.substring(5,7); 
	  		f.s_career_02.value = f.s_career02.value.substring(0,4) + f.s_career02.value.substring(5,7); 
	  		f.s_career_03.value = f.s_career03.value.substring(0,4) + f.s_career03.value.substring(5,7); 
	  		f.s_career_04.value = f.s_career04.value.substring(0,4) + f.s_career04.value.substring(5,7); 
	  		f.s_career_05.value = f.s_career05.value.substring(0,4) + f.s_career05.value.substring(5,7); 
	  		
	  		f.e_career_01.value = f.e_career.value.substring(0,4) + f.e_career.value.substring(5,7); 
	  		f.e_career_02.value = f.e_career02.value.substring(0,4) + f.e_career02.value.substring(5,7); 
	  		f.e_career_03.value = f.e_career03.value.substring(0,4) + f.e_career03.value.substring(5,7); 
	  		f.e_career_04.value = f.e_career04.value.substring(0,4) + f.e_career04.value.substring(5,7); 
	  		f.e_career_05.value = f.e_career05.value.substring(0,4) + f.e_career05.value.substring(5,7);
	  		
	  		f.s_lecture_01.value = f.s_lecture.value.substring(0,4) + f.s_lecture.value.substring(5,7);  
	  		f.s_lecture_02.value = f.s_lecture02.value.substring(0,4) + f.s_lecture02.value.substring(5,7);
	  		f.s_lecture_03.value = f.s_lecture03.value.substring(0,4) + f.s_lecture03.value.substring(5,7);
	  		f.s_lecture_04.value = f.s_lecture04.value.substring(0,4) + f.s_lecture04.value.substring(5,7);
	  		f.s_lecture_05.value = f.s_lecture05.value.substring(0,4) + f.s_lecture05.value.substring(5,7);
	  		
	  		f.e_lecture_01.value = f.e_lecture.value.substring(0,4) + f.e_lecture.value.substring(5,7);  
	  		f.e_lecture_02.value = f.e_lecture02.value.substring(0,4) + f.e_lecture02.value.substring(5,7);
	  		f.e_lecture_03.value = f.e_lecture03.value.substring(0,4) + f.e_lecture03.value.substring(5,7);
	  		f.e_lecture_04.value = f.e_lecture04.value.substring(0,4) + f.e_lecture04.value.substring(5,7);
	  		f.e_lecture_05.value = f.e_lecture05.value.substring(0,4) + f.e_lecture05.value.substring(5,7);
		
			f.accept_01.value = f.accept.value.substring(0,4) + f.accept.value.substring(5,7);
			f.accept_02.value = f.accept02.value.substring(0,4) + f.accept02.value.substring(5,7);
			f.accept_03.value = f.accept03.value.substring(0,4) + f.accept03.value.substring(5,7);
			f.accept_04.value = f.accept04.value.substring(0,4) + f.accept04.value.substring(5,7);
			f.accept_05.value = f.accept05.value.substring(0,4) + f.accept05.value.substring(5,7);
			
		if(!confirm("지원서를 저장한 후 이동하시겠습니까?"))
		{
			return;
		}	
		f.submit();
}
		
	function save_next()
	{   
		//주민번호  register_no 대신 DI 대체(2013.04.09)
		//document.recruit.returnURL.value="/cult/recruit.do?method=plan&ci= ci &resi_no= resi_no &register_no= register_no &user_id= user_id &menu_num=1_5";
		// 2014.04.29 BY KSM 주민번호 제거
		//document.recruit.returnURL.value="/cult/recruit.do?method=plan&ci= ci &register_no= register_no &user_id= user_id &menu_num=1_5";
		document.recruit.returnURL.value="/academy/lector04?ci=${ci}&register_no=${reg_no}&user_id=${user_id}&menu_num=1_5";
		save();
		
	}
</script>

<div class="lect-sec bg-gray lect-app">
	<div class="mu-grid">
		
		<div class="lect-step_wrap">
			<ul>
				<li>
					<div class="img"><img src="/img/lect-step01.png" /></div>
					<div class="txt"><em>step 01</em>개인정보 수집동의</div>
				</li>
				<li class="on">
					<div class="img"><img src="/img/lect-step02_on.png" /></div>
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

		<form name ="recruit" action='/academy/save' method='post' enctype="multipart/form-data">
						 <input type='hidden' name='method' value='save'/>
					     <input type='hidden' name='email'/>
					     <input type='hidden' name='s_career_01'/>
					     <input type='hidden' name='e_career_01'/>
					     <input type='hidden' name='s_career_02'/>
					     <input type='hidden' name='e_career_02'/>
					     <input type='hidden' name='s_career_03'/>
					     <input type='hidden' name='e_career_03'/>
					     <input type='hidden' name='s_career_04'/>
					     <input type='hidden' name='e_career_04'/>
					     <input type='hidden' name='s_career_05'/>
					     <input type='hidden' name='e_career_05'/>
					     <input type='hidden' name='s_lecture_01'/>
					     <input type='hidden' name='e_lecture_01'/>
					     <input type='hidden' name='s_lecture_02'/>
					     <input type='hidden' name='e_lecture_02'/>
					     <input type='hidden' name='s_lecture_03'/>
					     <input type='hidden' name='e_lecture_03'/>
					     <input type='hidden' name='s_lecture_04'/>
					     <input type='hidden' name='e_lecture_04'/>
					     <input type='hidden' name='s_lecture_05'/>
					     <input type='hidden' name='e_lecture_05'/>
					     <input type='hidden' name='accept_01'/>
					     <input type='hidden' name='accept_02'/>
					     <input type='hidden' name='accept_03'/>
					     <input type='hidden' name='accept_04'/>
					     <input type='hidden' name='accept_05'/>
					     <input type='hidden' name='sch_state'/>
					     <input type='hidden' name='uni_state'/>
					     <input type='hidden' name='gra_state'/>
					     <input type='hidden' name='user_id' value='${user_id}'/>
					     <input type='hidden' name='returnURL' value='${returnURL}'/>
					     <input type='hidden' name='photo_nm' value=''/>
					     <input type='hidden' name='register_no' value='${reg_no}'/>
					     <input type='hidden' name='di' value='${di}'/>
					     <input type='hidden' name='ci' value='${ci}'/>
					     <input type='hidden' name='resi_no' value=''/>
					     <input type='hidden' name='menu_num' value='1_5'/>
		
		
		
			<div class="lect-wr03 lect-wr-info">
				<p class="sub-tit beno"><b>기본정보</b></p>
				<table>
					<tr class="PhotoTd">
					
						<style>
						input.file {
								position: relative;
								width:100px;
								height:24px;
								padding: 0px;
								-moz-opacity:0 ;
								filter:alpha(opacity: 0);
								opacity: 0;
								z-index: 100;
								border-width:0px;
							}
						</style>
						
						<th class="img_file" rowspan="3"><div></div>
							<label style="width:100px; height:24px; padding: 0px; font-size:24px; overflow:hidden; background:url('/img/news_picture_btn.gif') no-repeat;">
								<input type='file' id="pho_path" name="pho_path" class="file"/>
          					</label>
						</th>
						
						
						
						<th>성명</th>
						<td><input name="kor_nm" type="text" title="성명" maxLength="10"></td>
						
						<tr>
							<th>전화번호</th>
							<td colspan="3">
								<p class="td-tel-tit">휴대폰</p>
								<div class="table td-tel">
									<div>
										<select name="mobile" style="width:70px;" title="휴대폰 앞자리 선택">
											<option selected value="010" >010</option>
											<option value="011" >011</option>
											<option value="016" >016</option>
											<option value="017" >017</option>
											<option value="018" >018</option>
											<option value="019" >019</option>
										</select>
									</div>
									<div class="email-sp">-</div>
									<div><input name="mobile_01" type="text" maxLength="4" title="휴대폰 중간번호 입력"/></div>
									<div class="email-sp">-</div>
									<div><input name="mobile_02" type="text" maxLength="4" title="휴대폰 뒷번호 입력"/></div>
								</div>
							</td>
						</tr>
						
						<th>성별</th>
                        <td class="ApTd02">
	                        <select name="sex_fg" title="성별 선택" style="width:90px;">
		                        <option value="M">남자</option>
								<option value="F">여자</option>
                        </select>
                        </td>
					</tr>
					
					<tr>
						<th>생년월일</th>
						<td colspan="3">
							<input name="birth_ymd" type="text" title="생년월일" class="date-i cal-inp" maxLength="8">
						</td>
					</tr>
					
					<tr>
						<th>이메일</th>
						<td colspan="3">
							<div class="table td-email">
								<div><input name="email_01" type="text" title="이메일주소 앞부분 입력" maxLength="24" /></div>
								<div class="email-sp">@</div>
								<div><input name="email_02" type="text" title="이메일주소 뒷부분 입력" maxLength="24" /></div>
								<div>
									<select name="email_03" title="이메일주소 뒷부분 선택" style="width:100px;" class="SlctPd" onChange="emailSet(this)">
										<option>선택하세요</option>
										<option value="korea.com">korea.com</option>
										<option value="chol.com">chol.com</option>
										<option value="paran.com">paran.com</option>
										<option value="hanafos.com">hanafos.com</option>
										<option value="gmail.com">gmail.com</option>
										<option value="dreamwiz.com">dreamwiz.com</option>
										<option value="empal.com">empal.com</option>
										<option value="freechal.com">freechal.com</option>
										<option value="hanmir.com">hanmir.com</option>
										<option value="hotmail.com">hotmail.com</option>
										<option value="lycos.co.kr">lycos.co.kr</option>
										<option value="msn.com">msn.com</option>
										<option value="nate.com">nate.com</option>
										<option value="naver.com">naver.com</option>
										<option value="yahoo.co.kr">yahoo.co.kr</option>
										<option value="Input">직접입력</option>
									</select>
								</div>
							</div>
						</td>
					</tr>
						

	
					<tr>
						<th>결혼유무</th>
						<td>		
							<ul class="td-chk">
								<li><label><input type="radio" checked>미혼</label></li>
								<li><label><input type="radio">기혼</label></li>
							</ul>					
						</td>
						<th>블로그/SNS URL</th>
						<td><input type="text" id="sns" class="inp100" placeholder="URL 입력"></td>
					</tr>
	
				</table>
			</div>
	
			<div class="lect-wr03">
				<p class="sub-tit beno"><b>최종학력</b></p>
				<table>
					<tr>
						<th>최종학력</th>
						<td class="td-school">
						
						<!-- 고등학교 start -->
							<div class="td-school01">
								<input name="school_01" type="text" title="고등학교 이름 입력" maxLength="10" value="" />
							    <span>고등학교</span>
								<input name="major_01" type="text" title="전공 입력" maxLength="10" value=""/> 
								<span>전공</span>
								<input type="text" name="yy_01" title="년도 선택" class="date-i cal-inp">
								<span>재학년도</span>
							</div>
							<div class="td-school02">
								<ul class="td-chk">
									<li>
										<label>
											<input id="r21" name="gr1" title="졸업" type="radio" value="Y" class="RDBdNone">졸업
										</label>
									</li>
									
									<li>
										<label>
											<input id="r22" name="gr1" title="수료" type="radio" value="N" class="RDBdNone">수료
										</label>
									</li>
								</ul>
								<span>소재지</span> 
								<input name="place_01" type="text" value="" maxLength="10" title="소재지 입력"/>
							</div>
						<!-- 고등학교 end -->
						
						<!-- 대학교 start -->
							<div class="td-school01">
								<input name="school_02" type="text" maxLength="10" value="" title="대학교 이름 입력"/>
								<span>대학교</span>
								<input name="major_02" type="text" maxLength="10" value="" title="전공 입력"/> 
								<span>전공</span>
								<input type="text" name="yy_02" title="년도 선택" class="date-i cal-inp">
								<span>재학년도</span>
							</div>
							<div class="td-school02">	
								<ul class="td-chk">
									<li>
										<label>
											<input name="gr2" title="졸업" type="radio" maxLength="10" value="Y" class="RDBdNone"/>졸업
										</label>
									</li>
									<li>
										<label>
											<input name="gr2" title="수료" type="radio" maxLength="10" value="N" class="RDBdNone" />수료
										</label>
									</li>

								</ul>
								<span>소재지</span> 
								<input name="place_02" type="text" value="" maxLength="10" title="소재지 입력"/>
								
							</div>
						<!-- 대학교 end -->
						
						<!-- 대학원 start -->
							<div class="td-school01">
								<input name="school_03" type="text" maxLength="10" value="" title="대학원 이름 입력" />
								<span>대학원</span>
								<input name="major_03" type="text" maxLength="10" value="" title="전공 입력"/> 
								<span>학과</span>
								<input type="text" name="yy_03" title="년도 선택" class="date-i cal-inp">
								<span>재학년도</span>
							</div>
							<div class="td-school02">	
								<ul class="td-chk">
									<li>
										<label>
											<input id="g21" name="gr3" title="졸업" type="radio" maxLength="10" value="Y" class="RDBdNone"/>졸업
										</label>
									</li>
									<li>
										<label>
											<input id="g22" name="gr3" title="수료" type="radio" maxLength="10" value="N" class="RDBdNone" />수료
										</label>
									</li>
								</ul>
								
								<span>소재지</span> 
								<input name="place_03" type="text" value="" maxLength="10" title="소재지 입력"/>
							</div>
						<!-- 대학원 end -->
						
						</td>
					</tr>
				</table>
			</div>
	
			<div class="lect-wr03">
				<p class="sub-tit beno"><b>경력사항</b></p>
				<table>
					<tr>
						<th>주요경력</th>
						<td>
							<div>
								<input type="text" class="date-i cal-inp" name="s_career" title="주요경력 기간 시작 년도 선택">
								<span class="p-bar">-</span>
								<input type="text" class="date-i cal-inp" name="e_career" title="주요경력 기간 시작 월 선택">
							</div>
							<div class="inp-btn">
								<input name="detail_01" type="text" maxLength="50" value="" title="주요경력 내용"/>
	
							</div>
							
							<div>
								<input type="text" class="date-i cal-inp" name="s_career02" title="주요경력 기간 시작 년도 선택">
								<span class="p-bar">-</span>
								<input type="text" class="date-i cal-inp" name="e_career02" title="주요경력 기간 시작 월 선택">
							</div>
							<div class="inp-btn">
								<input name="detail_02" type="text" maxLength="50" value="" title="주요경력 내용"/>
							</div>
							
							<div>
								<input type="text" class="date-i cal-inp" name="s_career03" title="주요경력 기간 시작 년도 선택">
								<span class="p-bar">-</span>
								<input type="text" class="date-i cal-inp" name="e_career03" title="주요경력 기간 시작 월 선택">
							</div>
							<div class="inp-btn">
								<input name="detail_03" type="text" maxLength="50" value="" title="주요경력 내용"/>
							</div>
							
							<div>
								<input type="text" class="date-i cal-inp" name="s_career04" title="주요경력 기간 시작 년도 선택">
								<span class="p-bar">-</span>
								<input type="text" class="date-i cal-inp" name="e_career04" title="주요경력 기간 시작 월 선택">
							</div>
							<div class="inp-btn">
								<input name="detail_04" type="text" maxLength="50" value="" title="주요경력 내용"/>
							</div>
							
							<div>
								<input type="text" class="date-i cal-inp" name="s_career05" title="주요경력 기간 시작 년도 선택">
								<span class="p-bar">-</span>
								<input type="text" class="date-i cal-inp" name="e_career05" title="주요경력 기간 시작 월 선택">
							</div>
							<div class="inp-btn">
								<input name="detail_05" type="text" maxLength="50" value="" title="주요경력 내용"/>
							</div>
							
						</td>
					</tr>
					
					<tr>
						<th>강의경력</th>
						<td>
							<div>
								<input type="text" name="s_lecture" title="주요경력 기간 시작 년도 선택" class="date-i cal-inp">
								<span class="p-bar">-</span>
								<input type="text" name="e_lecture" title="주요경력 기간 마지막 년도 선택" class="date-i cal-inp">
							</div>
							<div class="inp-btn">
								<input name="lec_detail_01" type="text" maxLength="50" value="" title="주요경력 내용"/>
							</div>
							
							<div>
								<input type="text" name="s_lecture02" title="주요경력 기간 시작 년도 선택" class="date-i cal-inp">
								<span class="p-bar">-</span>
								<input type="text" name="e_lecture02" title="주요경력 기간 마지막 년도 선택" class="date-i cal-inp">
							</div>
							<div class="inp-btn">
								<input name="lec_detail_02" type="text" maxLength="50" value="" title="주요경력 내용"/>
							</div>
							
							<div>
								<input type="text" name="s_lecture03" title="주요경력 기간 시작 년도 선택" class="date-i cal-inp">
								<span class="p-bar">-</span>
								<input type="text" name="e_lecture03" title="주요경력 기간 마지막 년도 선택" class="date-i cal-inp">
							</div>
							<div class="inp-btn">
								<input name="lec_detail_03" type="text" maxLength="50" value="" title="주요경력 내용"/>
							</div>
							
							<div>
								<input type="text" name="s_lecture04" title="주요경력 기간 시작 년도 선택" class="date-i cal-inp">
								<span class="p-bar">-</span>
								<input type="text" name="e_lecture04" title="주요경력 기간 마지막 년도 선택" class="date-i cal-inp">
							</div>
							<div class="inp-btn">
								<input name="lec_detail_04" type="text" maxLength="50" value="" title="주요경력 내용"/>
							</div>
							
							<div>
								<input type="text" name="s_lecture05" title="주요경력 기간 시작 년도 선택" class="date-i cal-inp">
								<span class="p-bar">-</span>
								<input type="text" name="e_lecture05" title="주요경력 기간 마지막 년도 선택" class="date-i cal-inp">
							</div>
							<div class="inp-btn">
								<input name="lec_detail_05" type="text" maxLength="50" value="" title="주요경력 내용"/>
							</div>
							
						</td>
					</tr>
					
					<tr>
						<th>자격증</th>
						<td>		
							<div class="table td-certi">
								<div>		
									<input name="agency_01" type="text" maxLength="10" title="자격증 발행기간 입력" value=""/>
								</div>
								<div>						
									<input name="certi_detail_01" type="text" maxLength="50" title="자격증 내용 입력" value=""/>
								</div>
								<div>
									<input type="text" name="accept" title="자격증 발급 년도 선택" class="date-i cal-inp">			
								</div>		
							</div>
							<div class="table td-certi">
								<div>		
									<input name="agency_02" type="text" maxLength="10" title="자격증 발행기간 입력" value=""/>
								</div>
								<div>						
									<input name="certi_detail_02" type="text" maxLength="50" title="자격증 내용 입력" value=""/>
								</div>
								<div>
									<input type="text" name="accept02" title="자격증 발급 년도 선택" class="date-i cal-inp">			
								</div>		
							</div>
							<div class="table td-certi">
								<div>		
									<input name="agency_03" type="text" maxLength="10" title="자격증 발행기간 입력" value=""/>
								</div>
								<div>						
									<input name="certi_detail_03" type="text" maxLength="50" title="자격증 내용 입력" value=""/>
								</div>
								<div>
									<input type="text" name="accept03" title="자격증 발급 년도 선택" class="date-i cal-inp">			
								</div>		
							</div>
							<div class="table td-certi">
								<div>		
									<input name="agency_04" type="text" maxLength="10" title="자격증 발행기간 입력" value=""/>
								</div>
								<div>						
									<input name="certi_detail_04" type="text" maxLength="50" title="자격증 내용 입력" value=""/>
								</div>
								<div>
									<input type="text" name="accept04" title="자격증 발급 년도 선택" class="date-i cal-inp">			
								</div>		
							</div>
							<div class="table td-certi">
								<div>		
									<input name="agency_05" type="text" maxLength="10" title="자격증 발행기간 입력" value=""/>
								</div>
								<div>						
									<input name="certi_detail_05" type="text" maxLength="50" title="자격증 내용 입력" value=""/>
								</div>
								<div>
									<input type="text" name="accept05" title="자격증 발급 년도 선택" class="date-i cal-inp">			
								</div>		
							</div>
							
						</td>
					</tr>
				</table>
			</div>
		</form>


		<div class="btn-center">
			<a class="btn btn01" onclick="javascript:save();">저장</a>
			<a class="btn btn02" onclick="javascript:save_next();">다음 단계로</a>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />