<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/web/course/site_conf_inc.jsp"%>
<%@ page import="ak_web.classes.*" %>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="<%= g_conf_js_url %>"></script>
<%
String number = "03"; //점 
double tot_regis_fee = 1000; //수강료
double tot_food_amt = 500; //재료비
double AKTotal_fee = 1200; //할인적용 총금액
double tot_total_fee = AKTotal_fee;
double enuri_percent = 20; 
String AKmemCardStatus = "00";
double dayEnuri = 0;
double NotAKTotal_fee = 0;
String buyr_name = "정기영";
String tot_subject_cd = "000002";
String ssoCi = "asdflkjl3k4j6lkjlksdf";
double free_fee = 0;
double AKmemPoint = 0;
boolean AKmemUsePointYn = false;
%>
<script>
function jsf__chk_plugin()
{
    // IE 일경우 기존 로직을 타게끔
    if ((navigator.userAgent.indexOf('MSIE') > 0) || (navigator.userAgent.indexOf('Trident/7.0') > 0))
    {
        if ( document.Payplus.object != null )
        {
			    	
        }
    }
    // 그 외 브라우져에서는 체크로직이 변경됩니다.
    else
    {
        var inst = 0;
        for (var i = 0; i < navigator.plugins.length; i++)
        {
            if (navigator.plugins[i].name == "KCP")
            {
                inst = 1;
            }
        }

        if (inst == 1)
        {
            //window.location = "order.jsp";
        }
        else
        {
            document.location.href=GetInstallFile();
        }
    }
}
function init_orderid(){
    var today = new Date();
    var year  = today.getFullYear();
    var month = today.getMonth() + 1;
    var date  = today.getDate();
    var time  = today.getTime();

    if(parseInt(month) < 10) {
        month = "0" + month;
    }

    if(parseInt(date) < 10) {
        date = "0" + date;
    }

    var order_idxx = "CULT" + year + "" + month + "" + date + "" + time;

    document.CalForm.ordr_idxx.value = order_idxx;

	// display 버튼 설치 모듈 
    // setTimeout("init_pay_button();",300);
}

function onSubmit()
{
	f = document.CalForm; 
	jsf__pay(f); 
}


function jsf__pay(form) {
// 	var RetVal = false;

// 	/* Payplus Plugin 실행 */
// 	if (MakePayMessage(form) == true) {
// 		RetVal = true;
// 	} else {
// 		/*  res_cd와 res_msg변수에 해당 오류코드와 오류메시지가 설정됩니다.
// 		    ex) 고객이 Payplus Plugin에서 취소 버튼 클릭시 res_cd=3001, res_msg=사용자 취소
// 		    값이 설정됩니다.
// 		 */
// 		res_cd = document.CalForm.res_cd.value;
// 		res_msg = document.CalForm.res_msg.value;
// 	}

// 	if (RetVal == false) {
// 		document.all["view_button"].style.display = "";
// 	}
// 	return RetVal;
	try
	{
		KCP_Pay_Execute(form);
	}
	catch (e)
	{
		alert(e);
	}
}

function ck_akcardtype(val){ // AK 신한카드 제휴 여부 체크
    
 	// 일반카드일시
 	if(val == "1" && document.all["ak_card_type"].ak_card_type[0].checked){	     
			document.CalForm.good_mny.value = document.CalForm.NotAKTotal_fee.value;
			document.all["ak_amount"].style.display = "none";			
			document.all["normal_amount"].style.display = "";			
			document.CalForm.akcard_yn.value = "N";
			document.CalForm.akKBcard_yn.value = "N";
			document.CalForm.used_card_YN.value = "N";		
			document.CalForm.site_cd.value = document.CalForm.site_cd_normal.value;
			document.CalForm.site_key.value = document.CalForm.site_key_normal.value;			
 	}else if(val == "2" && document.all["ak_card_type"].ak_card_type[1].checked) {
     		document.CalForm.good_mny.value = document.CalForm.AKTotal_fee.value;
			document.all["ak_amount"].style.display = "";			
			document.all["normal_amount"].style.display = "none";
			document.CalForm.akcard_yn.value = "Y";
			document.CalForm.akKBcard_yn.value = "N";
			document.CalForm.used_card_YN.value = "Y";
			document.CalForm.used_card.value = "CCLG";  //신한
			document.CalForm.site_cd.value = document.CalForm.site_cd_ak.value;
			document.CalForm.site_key.value = document.CalForm.site_key_ak.value;	
	}else if(val == "3" && document.all["ak_card_type"].ak_card_type[2].checked) {
     		document.CalForm.good_mny.value = document.CalForm.AKTotal_fee.value;
			document.all["ak_amount"].style.display = "";			
			document.all["normal_amount"].style.display = "none";
			document.CalForm.akcard_yn.value = "N";
			document.CalForm.akKBcard_yn.value = "Y";
			document.CalForm.used_card_YN.value = "Y";	//1가지 결제여부 선택
			document.CalForm.used_card.value = "CCKM"; //국민
			document.CalForm.site_cd.value = document.CalForm.site_cd_akkb.value;
			document.CalForm.site_key.value = document.CalForm.site_key_akkb.value;	
		}
	else if(val == "4" && document.all["ak_card_type"].ak_card_type[3].checked) {
 		document.CalForm.good_mny.value = document.CalForm.AKTotal_fee.value;
		document.all["ak_amount"].style.display = "";			
		document.all["normal_amount"].style.display = "none";
		document.CalForm.akcard_yn.value = "N";
		document.CalForm.akKBcard_yn.value = "N";
		document.CalForm.akWBcard_yn.value = "Y";
		document.CalForm.used_card_YN.value = "Y";	//1가지 결제여부 선택
		document.CalForm.used_card.value = "CCPH"; //우리
		document.CalForm.site_cd.value = document.CalForm.site_cd_akwb.value;
		document.CalForm.site_key.value = document.CalForm.site_key_akwb.value;	
		}
}
</script>
<form name="CalForm" method="post" action="">

	<input type="hidden" name="store" value="<%=number%>" /> 
	<input type="hidden" name="number" value="<%=number%>" /> 
	<input type="hidden" name="dRegiAmt" id="dRegiAmt" value="<%=tot_regis_fee%>" />
	<input type="hidden" name="dFoodAmt" value="<%=tot_food_amt%>" /> 
	<input type="hidden" name="dTotAmt" id="dTotAmt" value="<%= tot_regis_fee + tot_food_amt %>" /> 
	<input type="hidden" name="dTotalAmt" id="dTotalAmt" value="<%= AKTotal_fee %>" />
	<!--40기 20%에누리를 위해 적용한 hidden value 이거 변경했는데 확인필요 다른뎃 쓰는지 이게 최종결제금액-->
	<input type="hidden" name="dEnuriper" value="<%= enuri_percent %>" />
	<!--신설강좌  20%에누리를 위해 적용한 hidden value (11.02.02)-->
	<input type="hidden" name="dNewEnuriAmt" value="<%= tot_regis_fee + tot_food_amt - tot_total_fee %>" />
	<!--신설강좌  20%에누리를 위해 적용한 hidden value (11.02.02)-->
	<input type="hidden" name="akmem_card_status" value="<%=AKmemCardStatus%>" />
	<!--akmembers 카드상태(정상카드이면 00)-->
	<input type="hidden" name="dayEnuri" value="<%=dayEnuri%>" />
	<!--기간할인에누리금액추가 2015.10.17-->

	<!-- ★☆  추가  결제 준비 필수 값-->
	<input type="hidden" name="req_tx" value="pay" /> 
	<input type="hidden" name="site_name" value="<%= g_conf_site_name %>" /> 
	<input type="hidden" name="site_cd" value="<%= g_conf_site_cd	%>" /> 
	<input type="hidden" name="site_cd_normal" value="<%= g_conf_site_cd %>" /> 
	<input type="hidden" name="site_cd_ak" value="<%= g_conf_site_cd_ak %>" /> 
	<input type="hidden" name="site_key" value="<%= g_conf_site_key %>" /> 
	<input type="hidden" name="site_key_normal" value="<%= g_conf_site_key %>" />
	<input type="hidden" name="site_key_ak" value="<%= g_conf_site_key_ak %>" /> 
	<input type="hidden" name="site_cd_akkb" value="<%= g_conf_site_cd_akkb %>" /> 
	<input type="hidden" name="site_key_akkb" value="<%= g_conf_site_key_akkb %>" />

	<input type="hidden" name="ordr_idxx" value="" /> 
	<input type="hidden" name="pay_method" value="100000000000" /> 
	<input type="hidden" name="good_name" value="문화아카데미 강좌결제" /> 
	<input type="hidden" name="good_mny" id="good_mny" value="<%= (int) AKTotal_fee %>" maxlength="9" /> 
	<input type="hidden" name="currency" value="WON" /> 
	<input type="hidden" name="quotaopt" value="12" /> 
	<input type="hidden" name="shop_user_id" value="" /> 
	<input type="hidden" name="NotAKTotal_fee" id="NotAKTotal_fee" value="<%= (int) NotAKTotal_fee %>" /> 
	<input type="hidden" name="AKTotal_fee" id="AKTotal_fee" value="<%= (int) AKTotal_fee %>" />
	<input type="hidden" name="akcard_yn" value="Y" /> 
	<input type="hidden" name="akKBcard_yn" value="Y" /> 
	<input type="hidden" name="used_card_YN" value="N" /> 
	<input type="hidden" name="used_card" value="CCLG" /> 
	<input type="hidden" name="buyr_name" value="<%= buyr_name%>" /> 
	<input type="hidden" name="skin_indx" value="3">
	<!-- ★☆  추가  결제 결과 필수 값-->
	<input type="hidden" name="res_cd" value="" /> 
	<input type="hidden" name="res_msg" value="" /> 
	<input type="hidden" name="reg_en_msg" value="" /> 
	<input type="hidden" name="enc_data" value="" /> 
	<input type="hidden" name="enc_info" value="" /> 
	<input type="hidden" name="tran_cd" value="" /> 
	<input type="hidden" name="tot_subject_cd" id="tot_subject_cd" value="<%=tot_subject_cd%>" /> 
	<input type="hidden" name="sat_fg" id="sat_fg" value="" /> 
	<input type="hidden" name="NotAKTotal_fee_old" id="NotAKTotal_fee_old" value="<%= (int) NotAKTotal_fee %>" /> 
	<input type="hidden" name="AKTotal_fee_old" id="AKTotal_fee_old" value="<%= (int) AKTotal_fee %>" /> 
	<input type="hidden" name="dTotAmt_old" id="dTotAmt_old" value="<%= AKTotal_fee %>" /> 
	<input type="hidden" name="ssoCi" id="ssoCi" value="<%= ssoCi %>" /> 
	<input type="hidden" name="upointAmt" id="upointAmt" value="0" /> 
	<input type="hidden" name="free_fee2" id="" value="<%=free_fee %>" />
	 <input type="hidden" name="ci" id="ci" value="" />

	<table cellpadding="0" cellspacing="0" summary="결제수단 신용카드" class="UserList UserList03 mgTop0">
		<caption>결제 수단 선택</caption>
		<colgroup>
			<col width="200" />
			<col width="500" />
		</colgroup>
		<tr>
			<th scope="row" class="firstLine">결제수단</th>
			<td>
				<p>
					<input type="radio" id="card_type" name="card_type" value="yes" onclick="ck_cardtype('1');" checked title="신용카드 선택" /> 
					<label for="card_type">신용카드</label>
				</p>
				<p>
					<input type="radio" id="card_type" name="card_type" value="yes" onclick="ck_cardtype('2');" title="AK GIFT CARD 선택" style="display: none;" /> 
					<label for="card_type" style="display: none;">AK GIFT CARD</label>
				</p>
			</td>
		</tr>
		<tr>
			<th scope="row" class="firstLine">카드선택</th>
			<td>
				<p>
					<input type="radio" id="ak_card_type" name="ak_card_type" onclick="ck_akcardtype('1');" checked title="일반카드 선택" /><label>일반카드</label>
				</p>
				<p>
					<input type="radio" id="ak_card_type" name="ak_card_type" onclick="ck_akcardtype('2');" title="AK제휴카드 선택" /><label>AK신한카드</label>
				</p>
				<p>
					<input type="radio" id="ak_card_type" name="ak_card_type" onclick="ck_akcardtype('3');" title="AK KB제휴카드 선택" /><label>AK KB국민카드</label>
				</p>
				<p>
					<input type="radio" id="ak_card_type" name="ak_card_type" onclick="ck_akcardtype('4');" title="AK WB제휴카드 선택" /><label>AK 우리카드</label>
				</p>
			</td>
		</tr>
	</table>
	<table cellpadding="0" cellspacing="0" summary="결제금액,AKGIFT카드번호,비밀번호,현금영수증발행휴대폰번호" class="UserList UserList03 mgTop0" id="akgiftcard_table">
		<caption>결제 정보입력</caption>
		<colgroup>
			<col width="200" />
			<col width="500" />
		</colgroup>
		<tbody>

			<tr>
				<th scope="row" class="firstLine">결제금액</th>
				<td><strong><%= Utils.roundFixUp(tot_total_fee ,0, true)%>원</strong></td> 
			</tr>
			<tr> 
				<th scope="row" class="firstLine">AK GIFT 카드번호</th>
				<td>
					<input name="sCardNo1" type="text" style="width: 90px;" class="txtInput" maxlength="4" title="카드번호 앞자리 입력" /> 
					<input name="sCardNo2" type="text" class="txtInput" style="width: 90px;" maxlength="4" title="카드번호 두번째 입력" /> 
					<input name="sCardNo3" type="password" style="width: 90px;" class="txtInput" maxlength="4" title="카드번호 세번째 입력" /> 
					<input name="sCardNo4" type="password" style="width: 90px;" class="txtInput" maxlength="4" title="카드번호 네번재 입력" />
				</td>
			</tr>
			<tr>
				<th scope="row" class="firstLine">비밀번호</th>
				<td><input type='password' name="sPwdNo" maxlength='6' class="txtInput" style="width: 50px" /> (좌측 스크래치 긁은 후 6자리 )</td>
			</tr>
			<tr>
				<th scope="row" class="firstLine">현금영수증발행 휴대폰번호</th>
				<td><input type='cellphone' name="sCellPhone" maxlength='15' class="txtInput" style="width: 150px" /></td>
			</tr>


			<tr>
				<th scope="row" class="firstLine">AK멤버스 마일리지</th>
				<td><strong><%=Utils.roundFixUp(AKmemPoint ,0, true)%>M</strong></td>
			</tr>
			<tr>
				<td colspan="2" class="footBg02">
					<dl>
						<dt>
							<img src="/images/common/ico_confirm.gif" alt="확인하세요!" />
						</dt>
						<dd>
							<ul>
								<li class="Point01">AK 신한카드, AK KB국민카드 이용안내</li>
								<li>AK 신한카드, AK KB국민카드 결제시 결제시 0.5%마일리지 적립 가능</li>
								<li>상시 2~3개월 무이자 할부 가능 (5만원이상 결제시)</li>
								<li>마일리지는 10M 단위로 사용 가능합니다.</li>
								<li>재료비가 포함된 강좌는 마일리지 사용이 불가 합니다.</li>
							</ul>
						</dd>
					</dl>
				</td>
			</tr>
		</tbody>

	</table>
	<table cellpadding="0" cellspacing="0" summary="결제금액,신용카드번호,카드 유효기간,일시불/할부." class="UserList UserList03 mgTop0" id="creditcard_table">
		<caption>결제 정보입력</caption>
		<colgroup>
			<col width="200" />
			<col width="500" />
		</colgroup>
		<tbody>
			<tr>
				<th scope="row" class="firstLine">결제금액</th>
				<td id="ak_amount"><strong><%= Utils.roundFixUp(AKTotal_fee ,0, true)%>원</strong></td>
				<td id="normal_amount" style="display: none;"><strong><%= Utils.roundFixUp(NotAKTotal_fee ,0, true)%>원</strong></td>
			</tr>
			<tr>
				<th scope="row" class="firstLine">일시불/할부</th>
				<td>
					(결제금액 5만원이상 무이자 할부 가능) 
					<a onclick="javascript:acct_flag();"><img src="/images/btn/btn_card.gif" alt="무이자할부카드 안내" /></a>
				</td>
			</tr>
			<tr>
				<th scope="row" class="firstLine">AK멤버스 마일리지</th>
				<td id="upointAmt2"><strong><%=Utils.roundFixUp(AKmemPoint ,0, true)%>M</strong></td>
			</tr>
			<%
			if(AKmemUsePointYn && tot_food_amt < 1 ){
			%>
			<tr>
				<th scope="row" class="firstLine">사용 마일리지</th>
				<td>
					<div class="PoRel">
						<%
							String upointReadOnly ="";
							if(AKmemPoint < 9){
								upointReadOnly = "readOnly";
							}
						%>
						<input type="text" name="upointAmt3" id="upointAmt3" title="사용 마일리지" <%=upointReadOnly %> value="0" maxlength="8" onFocusOut="javascript:pointOnFocusOut();" onFocus="javascript:pointOnFocus();" onkeyUp="onlyNumber(this,0);usePointCheck();" class="txtInput" style="width: 100px; text-align: right;" /> M
						<div class="m01">
							<input type="checkbox" name="chkPoint" value="N" id="chkPoint" onClick="javascript:allPoint();" /><label for="chkPoint">마일리지 모두사용</label>
						</div>
					</div>
				</td>
			</tr>
			<%
			}
			%>
			<tr>
				<td colspan="2" class="footBg02">
					<dl>
						<dt>
							<img src="/images/common/ico_confirm.gif" alt="확인하세요!" />
						</dt>
						<dd>
							<ul>
								<li class="Point01">AK 신한카드, AK KB국민카드 이용안내</li>
								<li>AK 신한카드, AK KB국민카드 결제시 0.5%마일리지 적립 가능</li>
								<li>상시 2~3개월 무이자 할부 가능 (5만원이상 결제시)</li>
								<li>마일리지는 10M 단위로 사용 가능합니다.</li>
								<li>재료비가 포함된 강좌는 마일리지 사용이 불가 합니다.</li>
							</ul>
						</dd>
					</dl>
				</td>
			</tr>
		</tbody>

	</table>
</form>
<div id="view_button" class="btnBox02">
	<a onclick="javascript:onSubmit();"><img src="/images/btn/btn_confirm.gif" alt="승인"/></a> <a href="/cult/lecture.do?method=templist&menu_num=3_4"><img src="/images/btn/btn_cancel.gif" alt="취소"/></a>
</div>
<script>
// StartSmartUpdate();
// setTimeout("jsf__chk_plugin()","1000");
init_orderid();
</script>