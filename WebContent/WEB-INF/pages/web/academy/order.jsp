<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/web/course/site_conf_inc.jsp"%>
<%@ page import="ak_web.classes.*" %>
<%@ page import="ak_web.model.web.LectureVo" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat"%> 
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb07.jsp" />
<script type="text/javascript" src="<%= g_conf_js_url %>"></script>

<%
String subStore = Utils.checkNullString(session.getAttribute("login_store"));
%>
<script language='javascript'>
$("#selBranch").val('<%=subStore%>');
</script>
<%
String tot_subject_cd = "";	//지점
LectureVo lectureVo = (LectureVo)request.getAttribute("result");

String payResultText = "";
String cardBenefitText = "";


List list = lectureVo.getList();
String number = Utils.checkNullString(session.getAttribute("login_store"));
String buyr_name = Utils.checkNullString(session.getAttribute("login_name"));
String ssoCi = Utils.checkNullString(session.getAttribute("login_ci"));
String msg = Utils.removeNULL((String)request.getAttribute("msg"),"");
System.out.println("number >>>>>>>>>>>>>>>>>>>>>>>>> :" +number);
System.out.println("msg >>>>>>>>>>>>>>>>>>>>>>>>>:" +msg);

//주의사항 AK신한할인을 한다면 밑에    AK할인 구하는데에서부터 수정해서 전체적으로 수정해야됨
//현재 AK할인 적용안됨
//기간 고객할인
int gift_enuri_fg = 0;
int gift_user_enuri = 0;
int gift_date_enuri = 0;
int gift_date_enuri2 = 0;
String gift_date_from = "";
String gift_date_to ="";
String gift_date_from2 ="";
String gift_date_to2 = "";
int gift_enuri = 0;
double gift_enuri_rateV =0;  //기간할인율
double dayEnuri = 0;

//할인문구
String strGift_date_enuri = ""; //할인문구1
String strGift_date_enuri2 = ""; //할인문구2
String strGift_date_from = "";
String strGift_date_to="";
String strGift_date_from2 = "";
String strGift_date_to2 = "";


String toDate = Utils.getCurrentDate();
String sum_cnt = "0";	//오늘무료

	// 원주점 김혜영님 요청으로 강좌수 제한 주석 처리함. (2019.07.23)
	/* if(lectureVo.getStore().equals("05")){
		lectureVo.setMain_cd("6");
   		lectureVo.setSect_cd("02");
		sum_cnt = ls.selectSubcnt(lectureVo);
	} */
	
   System.out.println("sum_cnt==="+sum_cnt);

gift_enuri_fg = lectureVo.getGift_enuri_fg();   //에누리 구분 (0:미사용,1:할인율,2:할인금액)
gift_user_enuri = lectureVo.getGift_user_enuri();   //사은행사 고객 에누리
gift_date_enuri = lectureVo.getGift_date_enuri();    //행사기간 에누리
gift_date_enuri2 = lectureVo.getGift_date_enuri2();   //행사기간2 에누리
gift_date_from =Utils.removeNULL(lectureVo.getGift_date_from(),"0000");  //행사기간 시작일
gift_date_to =Utils.removeNULL(lectureVo.getGift_date_to(),"0000");    //행사기간 종료일
gift_date_from2 =Utils.removeNULL(lectureVo.getGift_date_from2(),"0000");  //행사기간 시작일2
gift_date_to2 =Utils.removeNULL(lectureVo.getGift_date_to2(),"0000");  //행사기간 종료일2


//추후 고객 할인 추가 현재 급해서 그냥 할인율로 함 20151017
if(gift_enuri_fg > 0){
	
	if(Integer.parseInt(gift_date_from) <= Integer.parseInt(toDate) && Integer.parseInt(gift_date_to) >= Integer.parseInt(toDate) ){
		gift_enuri = gift_date_enuri; //1번기간 에누리
		
	}else if(Integer.parseInt(gift_date_from2) <= Integer.parseInt(toDate) && Integer.parseInt(gift_date_to2) >= Integer.parseInt(toDate)){
		gift_enuri = gift_date_enuri2; //2번기간 에누리
		
	}
	
	//할인율 gift_enuri_rate = 1 - gift_enuri * 0.01;
	gift_enuri_rateV = gift_enuri * 0.01;
	System.out.println("gift_enuri_rateV >>>>>>>>>>>>>>>>>>>>>>>>>:" +gift_enuri_rateV);
	
	//할인 안내문구
	if(gift_enuri_fg == 1){
		strGift_date_enuri = gift_date_enuri + "%";
		strGift_date_enuri2 = gift_date_enuri2 + "%";
	}else if(gift_enuri_fg == 2){
		strGift_date_enuri = gift_date_enuri + "원";
		strGift_date_enuri2 = gift_date_enuri2 + "원";
	}

	 strGift_date_from =gift_date_from.substring(4,6) + "/" + gift_date_from.substring(6) + "(" + Utils.getDayOfWeekKOR(gift_date_from) + ")";
	 strGift_date_to=gift_date_to.substring(4,6) + "/" + gift_date_to.substring(6) + "(" + Utils.getDayOfWeekKOR(gift_date_to) + ") " + strGift_date_enuri;
	 strGift_date_from2 = gift_date_from2.substring(4,6) + "/"+ gift_date_from2.substring(6) + "(" +Utils.getDayOfWeekKOR(gift_date_from2) + ")";
	 strGift_date_to2 = gift_date_to2.substring(4,6) + "/"+ gift_date_to2.substring(6) + "(" + Utils.getDayOfWeekKOR(gift_date_to2) +") " + strGift_date_enuri2;
	
}


Calendar today = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
String day = sdf.format(today.getTime());

java.util.Random ran = new Random(); 
//랜덤 문자 길이
int numLength = 6;
String randomStr = "";

for (int i = 0; i < numLength; i++) {
    //0 ~ 9 랜덤 숫자 생성
    randomStr += ran.nextInt(10);
}

/*
String id       = "AKSM1001";                              				 	// 본인실명확인 회원사 아이디
String srvNo    = "029001";                            						// 본인실명확인 서비스번호
String reqNum   = pccCookie;               								// 본인실명확인 요청번호
String certGb   = "H";                           							// 본인실명확인 요청시간
String certDate = DateUtil.getKSTDateTime();               					// 본인실명확인 본인확인 인증수단
String addVar   = "join";													// 본인실명확인 추가 파라메터
String exVar    = "0000000000000000";                                       // 복호화용 임시필드
*/

String cpId = "AKSM1001";													//회원사 ID
String urlCode = "029002";													//URL코드
String certNum = day + randomStr;											//요청번호, reqNum은 최대 40byte 까지 사용 가능
String date = day;															//요청일시
String certMet = "M";														//본인인증방법 (M-휴대폰인증)
String name = "";															//이용자성명
String phoneNo = "";														//휴대폰번호
String phoneCorp = "";														//이동통신사
String birthDay = "";														//생년월일
String gender = "";															//성별
String nation = "";															//내외국인정보
String plusInfo = "join";													//추가DATA정보
String extendVar = "0000000000000000";										//확장변수

String tr_cert = Utils.createEncStringV3(cpId, urlCode, certNum, date, certMet, name, phoneNo, phoneCorp, birthDay, gender, nation, plusInfo, extendVar);


%>

<%//@ include file="/cult/common/enterPeriod.jsp" %>

<% if(!msg.equals("")) { %>
		<script language='javascript'>
			
			alert("<%=msg%>");
<% 
		String checkBack = Utils.removeNULL((String)request.getAttribute("checkBack"),"");
		if(checkBack.equals("Y")){
%>
			location.href = "/main";
<%			
			
		}
%>
	</script>
<%			
	} 

//int AKmemPoint = 0;
double AKmemPoint = 0;
String AKmemCardStatus = null;
HashMap AKmemRead ;
String AKmemCardNo = null;

// AKmembers getAKmemPoint 마일리지 조회
CmAKmembers cmAKmembers = new CmAKmembers();

AKmemCardNo = Utils.checkNullString(session.getAttribute("login_card")); //AKmembers 카드 번호

boolean AKmemUsePointYn = false;

//카드번호가 존재시 마일리지 read

if(!"".equals(AKmemCardNo)){
  AKmemRead = cmAKmembers.getAKmemRead( number, AKmemCardNo);
  
//   //정상적인 카드번호인지 확인
  AKmemCardStatus = cmAKmembers.getAKmemStatus(AKmemRead);
  if ( "00".equals(AKmemCardStatus) ){
    AKmemPoint  = cmAKmembers.getAKmemPoint(AKmemRead);
    
    AKmemUsePointYn = true;
  }else{
    %>
      <script language='javascript'>alert('[멤버스 정보오류] 유효한 카드가 아니라 마일리지 적립은 불가능 합니다');</script>
    <%
  }
}
// ★☆ AK 신한 및 일반 결제시 금액 Setting
double AKTotal_fee = 0;
double NotAKTotal_fee = 0; 

int free_fee = 0;
// 에누리가 X, 수강 할인권 미사용 대상자, 정규 강좌일시
if (!lectureVo.isFlag6() && lectureVo.isFlag4() && lectureVo.isFlag5() && lectureVo.isFlag1()) {
		
        free_fee = 10000;  // 전점 무료수강권 10,000원권(20160111)
}

String subject_arr = "";
String regis_fee_arr = "";
String food_amt_arr = "";
for(int i=0; i<list.size(); i++){
	LectureVo vo = (LectureVo)list.get(i);
	subject_arr += vo.getSubject_cd()+"|";
	regis_fee_arr += vo.getRegis_fee()+"|";
	food_amt_arr += vo.getFood_amt()+"|";
}

%>
<script>
var tmpCheck = "N"; 
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
function jsf__pay(form) {
	KCP_Pay_Execute(form);
}
function onSubmit() {
	var tot_enuri1_cd = "";
	var tot_enuri2_cd = "";
	var tot_enuri1_amt = "";
	var tot_enuri2_amt = "";
	var tmp_subject_arr = subject_arr.split("|");
	for(var i = 0; i < tmp_subject_arr.length-1; i++)
	{
		if(i != 0)
		{
			tot_enuri1_cd += ",";
			tot_enuri2_cd += ",";
			tot_enuri1_amt += ",";
			tot_enuri2_amt += ",";
		}
		tot_enuri1_cd += encd1_no.get(tmp_subject_arr[i]);
		tot_enuri2_cd += encd2_no.get(tmp_subject_arr[i]);
		tot_enuri1_amt += nullChkZero(encd1_amt.get(tmp_subject_arr[i]));
		tot_enuri2_amt += nullChkZero(encd2_amt.get(tmp_subject_arr[i]));
	}
	$("#tot_enuri1_cd").val(tot_enuri1_cd);
	$("#tot_enuri2_cd").val(tot_enuri2_cd);
	$("#tot_enuri1_amt").val(tot_enuri1_amt);
	$("#tot_enuri2_amt").val(tot_enuri2_amt);
	
	var sum_cnt = parseInt("<%=sum_cnt%>");
	
	if(sum_cnt > 5){
		alert("무료 패밀리 이벤트의 신청강좌수가 1일 5개로 제한됩니다.");
		return;
	}
    
    this.disabled=true;
    
	f = document.CalForm; 
	
<%-- 	var payResultText = "<%=payResultText%>"; --%>
	var payResultText = "[관리]강좌의 취소/변경은 개강 전일까지 가능합니다.<br/>다수 강좌 묶음 결제 시, 취소시점에 개강한 강좌가 포함될 경우 방문 취소만 가능합니다.";
	var sStore = "<%=subStore%>";
	
	if(payResultText!=""){
	payResultText= payResultText.replace(/<br[\/]>/gi,"\n");
   		
		}else{
    		payResultText = "온라인 수강취소 및 변경은 개강 전일까지 가능하며, 이후 취소/변경은 신청점을 방문하셔야만 합니다.\n"+
   			"(단, 요리강좌 개강 3일전 및 여행강좌 개강 7일전까지 취소가능) \n\n"+
			">>>>>>>>> 결제하시겠습니까? <<<<<<<<<";
	}
	
	var temp_sat_fg = $("#sat_fg").val();
        var temp_ssoCi = $("#ssoCi").val();
        var temp_Ci = $("#ci").val();
	
	if (confirm(payResultText) ) {
  	
// 	document.all["view_button"].style.display = "none";
		if(temp_sat_fg == "P"){ //마일리지 전액 사용 결제 금액과 동일 하면 무료 로직
// 			if(temp_Ci == ""){
// 				alert("마일리지 전액 사용 시 본인 인증은 필수입니다.");
// 				document.all["view_button"].style.display = "";
// 				return;
// 			} else {
				modalSubmit();
// 			}
		} else {      	
			jsf__pay(f);    
			
// 			if(f.res_cd.value == "0000"){
// 				modalSubmit();
// 			}else{
// 				alert("결제가 취소 되었습니다");
// // 				document.all["view_button"].style.display = "";
// 			}
		}
	}
}
function m_Completepayment( FormOrJson, closeEvent ) 
{
    var frm = document.CalForm; 
 
    /********************************************************************/
    /* FormOrJson은 가맹점 임의 활용 금지                               */
    /* frm 값에 FormOrJson 값이 설정 됨 frm 값으로 활용 하셔야 됩니다.  */
    /* FormOrJson 값을 활용 하시려면 기술지원팀으로 문의바랍니다.       */
    /********************************************************************/
    GetField( frm, FormOrJson ); 
    if( frm.res_cd.value == "0000" )
    {
// 	    alert("결제 승인 요청 전,\n\n반드시 결제창에서 고객님이 결제 인증 완료 후\n\n리턴 받은 ordr_chk 와 업체 측 주문정보를\n\n다시 한번 검증 후 결제 승인 요청하시기 바랍니다."); //업체 연동 시 필수 확인 사항.
        /*
            가맹점 리턴값 처리 영역
        */
        modalSubmit();
//         frm.submit(); 
    }
    else
    {
        alert( "[" + frm.res_cd.value + "] " + frm.res_msg.value );
        
        closeEvent();
    }
}
function modalPopup(){ 
	var objectName = new Object(); // object 선언 modal의 이름이 된다. 
	var site = "/popup/payment/pop_payment.html"; 
	var style ="status:no;dialogWidth:430px;dialogHeight:375px"; // 사이즈등 style을 선언 
	window.showModalDialog(site, self ,style ); // modal 실행 window.showModalDialog 포인트!! 
	
}
	
	
function modalSubmit(){ 
	
	f = document.CalForm; 
	
	f.submit();  
} 
function goDivView( field ) {
    
    document.CalForm.sResi_no.value = "" ;      
    document.CalForm.sBiz_no.value  = "" ;       
    document.all["card_resi_no"].style.display = "none";
    document.all["card_biz_no" ].style.display = "none";
    
    if ( field.value == '1' ) {
          document.all["card_resi_no"].style.display = "";
    } else {
          document.all["card_biz_no" ].style.display = "";
    }
  }

  function ck_halbu(val){
      var f = document.CalForm;
      var totamt = f.dTotalAmt.value;
      
      if(val == "1"){
          if(f.sAllot1 != null){
              f.sAllot1.disabled = true;
          }
          f.sAllot.value = "00";
      }else{
          f.sAllot1.disabled = false;
      }
  
  }
  
  function acct_flag() {
  	window.open('https://admin8.kcp.co.kr/html/popup/event_thismonth.html','acct_flag','width=520,height=700,scrollbars=yes, titlebar=no, status=no, location=no');
   }
   
   function ck_cardtype(val){ // AK GIFT OR 신용카드 선택시 보여지는 부분 수정 
   
	     	if(val == "2"){
		     	document.all["creditcard_table"].style.display = "none";
		     	document.all["akgiftcard_table"].style.display = "";
	     	}else{
	     	 	document.all["creditcard_table"].style.display = "";
	     	 	document.all["akgiftcard_table"].style.display = "none";
	     	}
   }
   
   //AK 제휴 할인 기간일시 금액 조정 
   function ck_akcardtype(val){ // AK 신한카드 제휴 여부 체크
 	// 일반카드일시
 	if(val == "1" && document.all["ak_card_type"][0].checked){	     
			document.CalForm.good_mny.value = document.CalForm.NotAKTotal_fee.value;
			document.CalForm.akcard_yn.value = "N";
			document.CalForm.akKBcard_yn.value = "N";
			document.CalForm.used_card_YN.value = "N";		
			document.CalForm.site_cd.value = document.CalForm.site_cd_normal.value;
			document.CalForm.site_key.value = document.CalForm.site_key_normal.value;			
 	}else if(val == "2" && document.all["ak_card_type"][1].checked) {
     		document.CalForm.good_mny.value = document.CalForm.AKTotal_fee.value;
			document.CalForm.akcard_yn.value = "Y";
			document.CalForm.akKBcard_yn.value = "N";
			document.CalForm.used_card_YN.value = "Y";
			document.CalForm.used_card.value = "CCLG";  //신한
			document.CalForm.site_cd.value = document.CalForm.site_cd_ak.value;
			document.CalForm.site_key.value = document.CalForm.site_key_ak.value;	
	}else if(val == "3" && document.all["ak_card_type"][2].checked) {
     		document.CalForm.good_mny.value = document.CalForm.AKTotal_fee.value;
			document.CalForm.akcard_yn.value = "N";
			document.CalForm.akKBcard_yn.value = "Y";
			document.CalForm.used_card_YN.value = "Y";	//1가지 결제여부 선택
			document.CalForm.used_card.value = "CCKM"; //국민
			document.CalForm.site_cd.value = document.CalForm.site_cd_akkb.value;
			document.CalForm.site_key.value = document.CalForm.site_key_akkb.value;	
		}
	else if(val == "4" && document.all["ak_card_type"][3].checked) {
 		document.CalForm.good_mny.value = document.CalForm.AKTotal_fee.value;
		document.CalForm.akcard_yn.value = "N";
		document.CalForm.akKBcard_yn.value = "N";
		document.CalForm.akWBcard_yn.value = "Y";
		document.CalForm.used_card_YN.value = "Y";	//1가지 결제여부 선택
		document.CalForm.used_card.value = "CCPH"; //우리
		document.CalForm.site_cd.value = document.CalForm.site_cd_akwb.value;
		document.CalForm.site_key.value = document.CalForm.site_key_akwb.value;	
		}
}
   
  /********************************************************
	*   문화 아카데비 20190405 마일리지 사용 로직 추가  시작 , 김동현
	*********************************************************/
	function pointOnFocus(){

		var tmpAkRpointAmt = Number("<%=AKmemPoint%>");

		if(tmpAkRpointAmt > 9){
			pointInit();
		}else{
			//alert("마일리지는 10M 단위로 사용 가능합니다.");
			//return;
// 			$("#chkPoint").focus();
		}
	}
   
	function pointOnFocusOut(){
			
		var tmpAkRpointAmt = Number("<%=AKmemPoint%>");

	 	if(tmpAkRpointAmt > 9){
	 	//	pointInit();
		 //입력된 점수가 0보다 크고 10 보다 작으면 초기화 포커스
			var tmpUsePoint = $("#upointAmt3").val();
			if(Number(tmpUsePoint) < 10 ){
				pointInit();
				//alert("마일리지는 10M 단위로 사용 가능합니다.");
			}
	    }
	}

	function pointInit(){
		//alert("마일리지 금액 계산");
		var tmpTotAmt = Number($("#AKTotal_fee_old").val());
		var tmpTotAmt2 = commaMask(tmpTotAmt)+" 원";
		$("#ak_amount").html(tmpTotAmt2);
		$("#final_point_amt").val("0");
		$("#final_amt").html(tmpTotAmt2);
		$("#final_amt2").html(tmpTotAmt2);
		$("#normal_amount").html("<strong>"+tmpTotAmt2+"</strong>");
		$("#upointAmt3").val(0);
		$("#upointAmt").val(0);
			
		//넘겨주는 파라메터 값들도 변경 해줘됨
		//$("#dRegiAmt").val(tmpTotAmt);			
		//$("#dTotAmt").val(tmpTotAmt);			
		$("#dTotalAmt").val(tmpTotAmt);			
		$("#good_mny").val(tmpTotAmt);			
		$("#NotAKTotal_fee").val(tmpTotAmt);			
		$("#AKTotal_fee").val(tmpTotAmt);	
	}
	
	/********************************************************
	 *   13. 숫자만 입력 체크-Event( ex> onkeyUp="onlyNumber(this)" )<-- 0,자연수만 가능
	 *          - param  field   숫자만 입력 체크할 input
	 *          - return   X
	*********************************************************/
	function onlyNumber(field, def) {
	    var str  = field.value;
	    var def1 = (def == null)? "" : 0;
	    var myRegExp = new RegExp('[^0-9]');
	    var index = str.search(myRegExp);
	    if (index != -1 ) {
	        alert("숫자만 입력가능합니다.");
	        if ( def != null ) {
	            field.value = ( isNaN(str.substring(0, index)) || str.substring(0, index) == '' )? def1 : parseInt(str.substring(0, index));
	        } else {
	            field.value = str.substring(0, index);
	        }
	        return false;
	    } else {
	        if ( def != null ) {
	            field.value = (isNaN(field.value) || field.value == '' )? def1 : parseInt( field.value );
	        }
	    }
	    return true;
	}
	
	//마일리지
	function usePointCheck(){
		//입력된수가 보유포인트보다 많은지
		var tmpUsePoint = $("#upointAmt3").val();
			
		var tmpAkRpointAmt = Number("<%=AKmemPoint%>");
		
		if(tmpUsePoint == null || tmpUsePoint == "") tmpUsePoint ="0";
		tmpUsePoint = Number(tmpUsePoint);
		if( tmpUsePoint > tmpAkRpointAmt){
			pointInit();
			alert("마일리지가 부족 합니다.");
		}else{
			var tmpUsePointCheck = $("#upointAmt3").val().substr(-1,1);

			if(tmpUsePointCheck > 0){
				pointInit();
				alert("마일리지는 10M 단위로 사용 가능합니다.");
				return;
			}
			
			//총결제 금액 조정
			var tmpTotAmt = "";
			var tmpPoint = "";
			
			tmpTotAmt = Number($("#dTotAmt_old").val()) - Number($("#upointAmt3").val());
			if(tmpTotAmt < 0){
				pointInit();
				alert("사용마일리지가 총 결제 금액보다 많이 사용할 수 없습니다.");
				return;
			}
			
			if(tmpTotAmt < 400){
				pointInit();
				alert("총 결제 금액 400원 이상 되어야 합니다.");
				return;			
			}
			
			//아래 결제수단 막는다.
			if(tmpTotAmt == 0){
// 				$("#chkPoint").attr("checked",true);
// 			    $("#upointAmt3").attr('disabled',true);
				$("#sat_fg").val("P");
				tmpCheck = "Y";
				
				if(tmpCheck == "Y"){
// 					openPccV3Window();	
				}
				
// 				$("#view_button").focus();
			}
			//실최종결제금액 
			//$("#tradeAmt").val(tmpTotAmt);
			//화면 출력
			var tmpTotAmt2 = tmpTotAmt;
			tmpTotAmt = commaMask(tmpTotAmt)+" 원";
			//$("#totAmtDiv").html(tmpTotAmt);
			//$("#upointAmt2").html(tmpTotAmt);
			$("#ak_amount").html(tmpTotAmt);
			$("#final_point_amt").val(commaMask(tmpUsePoint));
			$("#final_amt").html(tmpTotAmt);						
			$("#final_amt2").html(tmpTotAmt);						
			$("#normal_amount").html("<strong>"+tmpTotAmt+"</strong>");
			//tmpPoint = "(-) "+commaMask(tmpUsePoint)+" 원";
			$("#upointAmt").val(tmpUsePoint); 
			
			//넘겨주는 파라메터 값들도 변경 해줘됨
			//$("#dRegiAmt").val(tmpTotAmt2);			
			//$("#dTotAmt").val(tmpTotAmt2);			
			$("#dTotalAmt").val(tmpTotAmt2);			
			$("#good_mny").val(tmpTotAmt2);			
			$("#NotAKTotal_fee").val(tmpTotAmt2);			
			$("#AKTotal_fee").val(tmpTotAmt2);	
		
		}
		
	}
	
	/********************************************************
	 *	 22. commaMask() : 콤마찍기
	 *			- param str 코마찍을 숫자
	 *			- return    콤마찍은 문자
	*********************************************************/
	function commaMask(str) {
		
		var txtNumber = '' + str;
		
	    if (isNaN(txtNumber) || txtNumber == "") {
	        return str;
	    } else {
	        var rxSplit = new RegExp('([0-9])([0-9][0-9][0-9][,.])');
	        var arrNumber = txtNumber.split('.');
	        arrNumber[0] += '.';
	        do {
	            arrNumber[0] = arrNumber[0].replace(rxSplit, '$1,$2');
	        } while (rxSplit.test(arrNumber[0]));
	
	        if (arrNumber.length > 1) {
	            return arrNumber.join('');
	        } else {
	            return arrNumber[0].split('.')[0];
	        }
	   }
	}
	
	function allPoint(){

		//총마일리지가 0 보다 큰지
		//전체 금액보다 큰지
		//포인트로만 전체 결제를 하면 결제수단 none
			//보유포인트가 10 이상일 경우 가능
	    var tmpAkRpointAmt = Number("<%=AKmemPoint%>");
		
		if(tmpAkRpointAmt > 9){
			var tmpUsePoint = "";
			var tmpTotAmt = "";
			//전체 마일리지가 결제금액보다 크거나 같은 경우
			if(tmpAkRpointAmt >= Number($("#dTotAmt_old").val())){
				tmpUsePoint = Number($("#dTotAmt_old").val());
				$("#upointAmt").val(tmpUsePoint);
				$("#upointAmt3").val(tmpUsePoint);
				tmpTotAmt = "0";
				//마일리지로 전체 결제시 결제수단 
				tmpCheck = "Y";
				//$("#sat_fg").val(tmpCheck);
				
				//$("#payMethod").css("display","none");	//결제수단타이틀
				//$(".PaySelBox02").css("display","none");//결제수단
				//document.form.sat_fg_value.value="P";
				//hide_others(1);
			}else{
				tmpUsePoint = tmpAkRpointAmt;
				$("#upointAmt3").val(tmpAkRpointAmt);
				$("#upointAmt").val(tmpAkRpointAmt);
				tmpTotAmt = Number($("#dTotAmt_old").val()) - tmpAkRpointAmt;
			}
			//실제 결제금액
			//$("#tradeAmt").val(tmpTotAmt);	//결제프로세스값
			var tmpTotAmt2 = tmpTotAmt;
			tmpTotAmt = commaMask(tmpTotAmt)+" 원";
			
// 			$("#ak_amount").html(tmpTotAmt);
			
			
			$("#final_point_amt").val(commaMask(tmpUsePoint));
			$("#final_amt").html(tmpTotAmt);						
// 			$("#normal_amount").html("<strong>"+tmpTotAmt+"</strong>");
			//tmpPoint = "(-) "+commaMask(tmpUsePoint)+" 원";
			//$("#upointAmt").html(tmpPoint);
			
			//넘겨주는 파라메터 값들도 변경 해줘됨
			//$("#dRegiAmt").val(tmpTotAmt2);			
			//$("#dTotAmt").val(tmpTotAmt2);			
			$("#dTotalAmt").val(tmpTotAmt2);			
			$("#good_mny").val(tmpTotAmt2);			
			$("#NotAKTotal_fee").val(tmpTotAmt2);			
			$("#AKTotal_fee").val(tmpTotAmt2);	
			$("#sat_fg").val("P");
			$("#upointAmt3").attr('disabled',true);
			if(tmpCheck == "Y"){
// 				openPccV3Window();	
			}
			
		}else{
			//$("#chkPoint").attr("checked",false);
			$("#chkPoint").val("N");
			alert("마일리지는 10M 단위로 사용 가능합니다.");
			pointInit();
		} 
		
	}
	
	function openPccV3Window()
  { 
  	PCCV3Window = window.open('', 'PCCV3Window', 'width=450, height=550, resizable=0, scrollbars=yes, status=0, titlebar=0, toolbar=0, left=435, top=250' );
	
      if(PCCV3Window == null){ 
			alert(" ※ 윈도우 XP SP2 또는 인터넷 익스플로러 7 사용자일 경우에는 \n    화면 상단에 있는 팝업 차단 알림줄을 클릭하여 팝업을 허용해 주시기 바랍니다. \n\n※ MSN,야후,구글 팝업 차단 툴바가 설치된 경우 팝업허용을 해주시기 바랍니다.");
      }

      document.reqPCCV3Form.action = 'https://www.kmcert.com/kmcis/web/kmcisReq.jsp';
      document.reqPCCV3Form.target = 'PCCV3Window';
      document.reqPCCV3Form.submit();
  }
  		
  /********************************************************
	*   문화 아카데비 20190405 마일리지 사용 로직 추가  끝 , 김동현
	*********************************************************/
	
	
	//할인권 불러오기
	function getEncdList(subject_cd)
	{
		$.ajax({
			type : "POST", 
			url : "/common/getEncdList",
			dataType : "text",
			async:false,
			data : 
			{
				store : $("#selBranch").val(),
				period : $("#selPeri").val(),
				cust_no : $("#cust_no").val(),
				subject_cd : subject_cd
			},
			error : function() 
			{
				console.log("AJAX ERROR");
			},
			success : function(data) 
			{
				var result = JSON.parse(data);
				console.log(data);
				if(result.isSuc != "success")
	    		{
	    			alert(result.msg);
	    		}
	    		else
	    		{
					if(result.list.length > 0)
					{
						$("#encd_layer").fadeIn(200);
						$("#target_encd1").html('');
						$("#target_encd2").html('');
						for(var i = 0; i < result.list.length; i++)
						{
							var inner = "";
							inner += '<div style="">';
							inner += '	<input type="checkbox" id="enuri_cd_'+subject_cd+'_'+result.list[i].ENURI_CD+'_'+result.list[i].DUPL_YN+'_'+result.list[i].ENURI_FG+'_'+result.list[i].ENURI+'" name="enuri_cd_'+subject_cd+'"><label for="enuri_cd_'+subject_cd+'_'+result.list[i].ENURI_CD+'_'+result.list[i].DUPL_YN+'_'+result.list[i].ENURI_FG+'_'+result.list[i].ENURI+'"></label>';
							inner += '	할인코드명 : '+result.list[i].ENURI_NM+'<br>';
							if(result.list[i].ENURI_FG == '1')
							{
								inner += '	할인구분 : 정률<br>';
								inner += '	할인금액 : '+result.list[i].ENURI+'%<br>';
							}
							else
							{
								inner += '	할인구분 : 정액<br>';
								inner += '	할인금액 : '+result.list[i].ENURI+'<br>';
							}
							inner += '</div>';
							if(result.list[i].DUPL_YN == "N")
							{
								$("#target_encd1").append(inner);
							}
							else
							{
								$("#target_encd2").append(inner);
							}
							
						}
						var chk_id_arr = chk_id.split("|");
						for(var i = 0; i < chk_id_arr.length-1; i++)
						{
							if(document.getElementById(chk_id_arr[i]))
							{
								$("input:checkbox[id='"+chk_id_arr[i]+"']").attr("checked", true);
							}
						}
					}
					else
					{
						alert("가능한 할인코드가 없습니다.");
					}
					var inner = '';
					inner += '';
					inner += '<div class="btn-center">';
					inner += '	<a class="btn btn01" onclick="javascript:$(\'#encd_layer\').fadeOut(200);">취소</a>';
					inner += '	<a class="btn btn02" onclick="javascript:encdSubmit(\''+subject_cd+'\');">확인</a>';
					inner += '</div>';
					$("#target_encd3").html(inner);
	    		}
			}
		});
	}
	//할인권 불러오기

var encd1_no = new HashMap();
var encd2_no = new HashMap();
var encd1_amt = new HashMap();
var encd2_amt = new HashMap();

var subject_arr = '<%=subject_arr%>';
var regis_fee_arr = '<%=regis_fee_arr%>';
var food_amt_arr = '<%=food_amt_arr%>';


var chk_id = ""; //다시띄울때 보여주기위해 저장해놓자.
function encdSubmit(subject_cd)
{
	var chk_id_arr = chk_id.split("|");
	for(var i = 0; i < chk_id_arr.length-1; i++) //해당강좌 체크목록 지우기
	{
		if(chk_id_arr[i].indexOf(subject_cd) > -1)
		{
			chk_id.replace(chk_id_arr[i], "");
		}
	}
	var chkList = "";
	$("input:checkbox[name='enuri_cd_"+subject_cd+"']").each(function(){
	    if($(this).is(":checked"))
    	{
	    	chk_id += $(this).attr("id")+"|";
    		chkList += $(this).attr("id").replace("enuri_cd_", "")+"|";
    	}
	});
	
	var chkArr = chkList.split("|");
	if(chkArr.length-1 > 2)
	{
		alert("할인코드는 최대 두개까지 선택 가능합니다.");
		return;
	}
	var dupl_n = 0;
	var enuri_fg_1 = 0;
	var enuri_fg_2 = 0;
	for(var i = 0; i < chkArr.length-1; i++)
	{
		var chkDetail = chkArr[i].split("_");
		var dupl_yn = chkDetail[2];
		var enuri_fg = chkDetail[3];
		if(dupl_yn == "N")
		{
			dupl_n ++;
		}
		if(enuri_fg == "1")
		{
			enuri_fg_1 ++;
		}
		else
		{
			enuri_fg_2 ++;
		}
	}
	if(dupl_n > 1)
	{
		alert("중복이 불가한 할인코드가 있습니다.");
		return;
	}
	else
	{
		var tmp_subject_arr = subject_arr.split("|");
		var tmp_regis_fee_arr = regis_fee_arr.split("|");
		var encd_regis_fee_arr = regis_fee_arr.split("|");
		if(enuri_fg_1 > 0 && enuri_fg_2 > 0) //정액 정률이 섞여있다면 정액 먼저 할인
		{
			var tmp_amt = 0;
			for(var i = 0; i < chkArr.length-1; i++)
			{
				var chkDetail = chkArr[i].split("_");
				var subject_cd = chkDetail[0];
				var enuri_cd = chkDetail[1];
				var dupl_yn = chkDetail[2];
				var enuri_fg = chkDetail[3];
				var enuri = chkDetail[4];
				if(enuri_fg == "2")
				{
					for(var z = 0; z < tmp_subject_arr.length-1; z++)
					{
						if(subject_cd == tmp_subject_arr[z])
						{
							encd_regis_fee_arr[z] = convInt(Number(encd_regis_fee_arr[z]) - Number(enuri));
							encd1_no.put(subject_cd, enuri_cd);
							encd1_amt.put(subject_cd, convInt(Number(tmp_regis_fee_arr[z]) - Number(encd_regis_fee_arr[z])));
							tmp_amt = encd_regis_fee_arr[z];
						}
					}
				}
			}
			for(var i = 0; i < chkArr.length-1; i++)
			{
				var chkDetail = chkArr[i].split("_");
				var subject_cd = chkDetail[0];
				var enuri_cd = chkDetail[1];
				var dupl_yn = chkDetail[2];
				var enuri_fg = chkDetail[3];
				var enuri = chkDetail[4];
				if(enuri_fg == "1")
				{
					for(var z = 0; z < tmp_subject_arr.length-1; z++)
					{
						if(subject_cd == tmp_subject_arr[z])
						{
							encd_regis_fee_arr[z] = convInt(Number(encd_regis_fee_arr[z]) / 100 * (100-Number(enuri)));
							encd2_no.put(subject_cd, enuri_cd);
							encd2_amt.put(subject_cd, convInt(Number(tmp_amt) - Number(encd_regis_fee_arr[z])));
						}
					}
				}
			}
		}
		else
		{
			var tmp_amt = 0;
			for(var i = 0; i < chkArr.length-1; i++)
			{
				var chkDetail = chkArr[i].split("_");
				var subject_cd = chkDetail[0];
				var enuri_cd = chkDetail[1];
				var dupl_yn = chkDetail[2];
				var enuri_fg = chkDetail[3];
				var enuri = chkDetail[4];
				for(var z = 0; z < tmp_subject_arr.length-1; z++)
				{
					if(subject_cd == tmp_subject_arr[z])
					{
						
						if(i == 0)
						{
							if(enuri_fg == "1")
							{
								encd_regis_fee_arr[z] = convInt(Number(encd_regis_fee_arr[z]) / 100 * (100-Number(enuri)));
							}
							else
							{
								encd_regis_fee_arr[z] = convInt(Number(encd_regis_fee_arr[z]) - Number(enuri));
							}
							encd1_no.put(subject_cd, enuri_cd);
							encd1_amt.put(subject_cd, convInt(Number(tmp_regis_fee_arr[z]) - Number(encd_regis_fee_arr[z])));
							tmp_amt = encd_regis_fee_arr[z];
						}
						else
						{
							if(enuri_fg == "1")
							{
								encd_regis_fee_arr[z] = convInt(Number(encd_regis_fee_arr[z]) / 100 * (100-Number(enuri)));
							}
							else
							{
								encd_regis_fee_arr[z] = convInt(Number(encd_regis_fee_arr[z]) - Number(enuri));
							}
							encd2_no.put(subject_cd, enuri_cd);
							encd2_amt.put(subject_cd, convInt(Number(tmp_amt) - Number(encd_regis_fee_arr[z])));
						}
					}
				}
			}
		}
		var final_pay = 0;
		var encd_pay = 0;
		for(var i = 0; i < tmp_subject_arr.length-1; i++)
		{
			final_pay += convInt((Number(tmp_regis_fee_arr[i]) - Number(nullChkZero(encd1_amt.get(tmp_subject_arr[i]))) - Number(nullChkZero(encd2_amt.get(tmp_subject_arr[i])))));
			final_pay += convInt(Number(food_amt_arr.split("|")[i]));
			encd_pay += convInt(Number(nullChkZero(encd1_amt.get(tmp_subject_arr[i]))) + Number(nullChkZero(encd2_amt.get(tmp_subject_arr[i]))));
		}
		$("#tot_encd_pay").html(comma(encd_pay) + '<span class="font-80">원</span>');
		$("#AKTotal_fee_old").val(final_pay);
		$("#dTotAmt_old").val(final_pay);
		var tmpTotAmt = Number($("#AKTotal_fee_old").val());
		var tmpTotAmt2 = commaMask(tmpTotAmt)+" 원";
		$("#ak_amount").html(tmpTotAmt2);
		$("#final_amt").html(tmpTotAmt2);
		$("#final_amt2").html(tmpTotAmt2);
		$("#normal_amount").html("<strong>"+tmpTotAmt2+"</strong>");
			
		$("#dTotalAmt").val(tmpTotAmt);			
		$("#good_mny").val(tmpTotAmt);			
		$("#NotAKTotal_fee").val(tmpTotAmt);			
		$("#AKTotal_fee").val(tmpTotAmt);	
		
		$('#encd_layer').fadeOut(200);
	}
}
</script>
<form name="reqPCCV3Form" method="post" action="">
    <input type="hidden" name="tr_cert"     value = "<%=tr_cert%>"/>
    <input type="hidden" name="tr_url"      value = "http://<%=request.getServerName()%>/pccV3_popup_1.jsp"/>
</form> 
<form name="CalForm" method="post" action="./order_end">
	
	<div class="cours-sec cours-sec01 bg-gray">
		<div class="mu-grid">
			
			<p class="sub-tit">결제 강좌 확인</p>
			<div class="colist-wr myaca-wr">
				<table>
					<thead>
						<tr>
							<th>강좌명</th>
							<th>수강료</th>
							<th>재료비</th>
							<th>할인권</th>
							<th>합계</th>
						</tr>
					</thead>
					<tbody>
					
<%
double tot_regis_fee = 0;
double tot_food_amt  = 0;
double tot_amt       = 0;
double tot_total_fee = 0;
double enuri2_amt    = 0;
double regis_fee     = 0;
double enuri_percent = 0;
double sumEnuri      = 0;
String sSubject_cd   = null;
int lecture_count = list.size();

int lect_cnt = 0;

for(int i=0; i<list.size(); i++){
	  LectureVo vo = (LectureVo)list.get(i);
    //1. 에누리율 적용
    sSubject_cd    = vo.getSubject_cd();
    regis_fee      = vo.getRegis_fee();
    enuri_percent  = vo.getEnuri_per();
    if(i != 0)
    {
    	tot_subject_cd += ",";	
    }
    tot_subject_cd += vo.getSubject_cd();
    
    
    //강좌별 에누리     
    if(enuri_percent == 0) {
        enuri2_amt  = 0;
    } else {
        enuri2_amt  = (regis_fee * enuri_percent)/100;
        regis_fee   = regis_fee - enuri2_amt;
    }

    tot_regis_fee += vo.getRegis_fee();
    tot_food_amt  += vo.getFood_amt();
    tot_amt = regis_fee + vo.getFood_amt();          
    tot_total_fee += tot_amt;
          
%>      
						<tr>
							<td><%= vo.getSubject_nm() %> 강좌횟수:<%= vo.getLect_cnt() %> </td>
    <%  
        if(enuri_percent == 0) {
    %>
        <td><%= Utils.roundFixUp(vo.getRegis_fee(),0, true) %></td>
    <%
        } else {
    %>
      	<td><%= Utils.roundFixUp(vo.getRegis_fee(),0, true) %><font color="#FF6600" bold>(<%=Utils.roundFixUp(enuri_percent , 0, true)%>%할인)</td>                    
    <%
        }
    %>    
							<td><img class="th-icon" src="/img/small_plus.png" alt="더하기"/><%= Utils.roundFixUp(vo.getFood_amt(),0, true) %></td>
							<td onclick="getEncdList('<%=vo.getSubject_cd() %>')">할인</td>
							<td><%= Utils.roundFixUp(tot_amt ,0, true) %></td>
						</tr>
<%
      }
%>
						<tr class="total-tr">
							<td colspan="5">
								<div class="order-todiv table">
									<div>총 <%=list.size()%>개의  강좌수강료<p class="ord-to"><%= Utils.roundFixUp(tot_regis_fee,0, true) %><span class="font-80">원</span></p></div>
									<div class="ord-i"><img src="/img/big_plus.png" alt="ak"/></div>
									<div>총 <%=list.size()%>개의  강좌재료비<p class="ord-to"><%= Utils.roundFixUp(tot_food_amt,0, true) %><span class="font-80">원</span></p></div>
									<div class="ord-i"><img src="/img/big_minus.png" alt="ak"/></div>
									<div>총 할인금액<p class="ord-to" id="tot_encd_pay">0<span class="font-80">원</span></p></div>
									<div class="ord-i"><img src="/img/big_to.png" alt="ak"/></div>
									<div>총 결제금액<p class="ord-to color-g" id="final_amt"><%= Utils.roundFixUp(tot_total_fee,0, true) %><span class="font-80">원</span></p></div>
								</div>
								
																	<%
									  NotAKTotal_fee = tot_total_fee-free_fee;
									  // AK 신한 카드 결제시 금액 재 측정 (AK신한 카드 할인 이면서, 정규 강좌이면서, 에누리 없는 강좌일시 
									  if(lectureVo.isFlag3() && lectureVo.isFlag1() && !lectureVo.isFlag6())
									  {
										  System.out.println("AK신한 카드 할인 중");
										  AKTotal_fee = ((tot_regis_fee - free_fee) * 0.95) + tot_food_amt; // 1 => 0.95로 추후 수정 
									  }else{
										  AKTotal_fee = NotAKTotal_fee; 										  
									  }
									  
									  if(free_fee > 0 && lectureVo.isFlag4() && lectureVo.isFlag5()){
									%>
										<dt>수강할인권 :</dt>
                    					<dd>(-)<%= Utils.roundFixUp(free_fee,0, true) %>원</dd>
                    				<%
										}
                    				
										if(gift_enuri > 0 && gift_enuri_fg > 0){
											if(lectureVo.isFlag11()){
											
											//  기간할인금액 계산
											//연속수강자 계산된금액에서 기간할인구함
											if(lectureVo.isFlag9()){
												if(gift_enuri_fg == 1){
													 dayEnuri  = (regis_fee-free_fee) * gift_enuri_rateV;
												}else{
													 dayEnuri  = gift_enuri;
												}
											}
											//에누리금액의 합은 20000원이하 여야함
											if(lecture_count > 1) dayEnuri = 0;
												
											
											//연속할인 + 기간할인
											sumEnuri = dayEnuri + free_fee;
												
											if(sumEnuri > 20000){
												dayEnuri = 20000 - free_fee;
											}

											//수강권 할인된금액에서 기간할인적용하고 재료비 더함											 
											NotAKTotal_fee = ((tot_regis_fee-free_fee) - dayEnuri) + tot_food_amt;
											AKTotal_fee = NotAKTotal_fee;
											 
											System.out.println("===결제예상jsp 기간 할인 적용==============");											 
											System.out.println("===기간할인금액 : "+dayEnuri);
											System.out.println("===강좌결제금액 : "+tot_regis_fee);
											System.out.println("===수강할인금액 : "+free_fee);
											System.out.println("===재료결제금액 : "+tot_food_amt);
											System.out.println("===NotAKTotal_fee결제금액 : "+NotAKTotal_fee);
											System.out.println("===AK결제금액 : "+AKTotal_fee);
											
											if(lectureVo.isFlag9() && lecture_count == 1){			 
									%>
										<dt>기간할인 :</dt>
                    					<dd>(-)<%= Utils.roundFixUp(dayEnuri,0, true) %>원</dd>
                    				<%
											}
										
											}
										}
                    				%>
							
							</td>
						</tr>
					</tbody>
				</table>
				
			</div>
			<p class="sub-tit">결제 하기</p>
			<div class="certi-wr order-view">
				<table>
					<tr>
						<th>결제 수단</th>
						<td>
							<ul class="td-chk02">
								<li><input type="radio" id="card_type" name="card_type" value="yes" onclick="ck_cardtype('1');" checked	title="신용카드 선택"/> <label for="card_type">신용카드</label></li>
							</ul>	
						</td>
					</tr>
	
					<tr>
						<th>카드 선택</th>
						<td>
							<ul class="td-chk02">
								<li><input type="radio" id="ak_card_type" name="ak_card_type" onclick="ck_akcardtype('1');" checked title="일반카드 선택" /><label>일반카드</label></li>
								<li><input type="radio" id="ak_card_type" name="ak_card_type" onclick="ck_akcardtype('2');" title="AK제휴카드 선택" /><label>AK신한카드</label></li>
								<li><input type="radio" id="ak_card_type" name="ak_card_type" onclick="ck_akcardtype('3');" title="AK KB제휴카드 선택" /><label>AK KB국민카드</label></li>
								<li><input type="radio" id="ak_card_type" name="ak_card_type" onclick="ck_akcardtype('4');" title="AK WB제휴카드 선택" /><label>AK 우리카드</label></li>
							</ul>	
						</td>
					</tr>
	
					<tr>
						<th>결제금액</th>
						<td>
							<p><strong class="total-price" id="final_amt2"><%= Utils.roundFixUp(tot_total_fee ,0, true)%></strong>원</p>
						</td>
					</tr>
	
					<tr>
						<th>일시불/할부</th>
						<td>
							(결제금액 5만원이상 무이자 할부 가능)<span class="card-info">무이자할부카드 안내</span>
						</td>
					</tr>
					<%
						if(AKmemUsePointYn && tot_food_amt < 1 ){
							String upointReadOnly ="";
						  	if(AKmemPoint < 9){
						  		upointReadOnly = "readOnly";
						  	}
					%> 
					<tr>
						<th>AK멤버스 마일리지 사용</th>
						<td class="milearea-wr">
							<div><input type="text" class="mile-inp <%=upointReadOnly %>" value="0" id="upointAmt3" maxlength="8" onFocusOut="javascript:pointOnFocusOut();" onFocus="javascript:pointOnFocus();" onkeyUp="onlyNumber(this,0);usePointCheck();"></div><div class="card-info mileuse-btn" onclick="javascript:allPoint();">전액사용</div> 
							<div class="mile-com">(보유마일리지 : <strong class="mileage"><%=Utils.roundFixUp(AKmemPoint ,0, true)%></strong>원) <span>* 1,000원부터 3,000원까지 사용 가능합니다.</span></div>
						</td>
					</tr>
					<%
						}
					%>  
	
				</table>
			
			
			</div>
			<div class="myaca-bot order-vibot">
				<div class="table">
					<div class="myacabot-tit">
						<p>확인하세요!</p>
					</div>
					<div>
						<p class="order-ulp">AK 신한카드, AK KB국민카드 이용안내</p>
						<ul>
							<li>AK 신한카드, AK KB국민카드 결제시 0.5%마일리지 적립 가능합니다.</li>
							<li>상시 2~3개월 무이자 할부 가능합니다. (5만원이상 결제시)</li>
							<li>마일리지는 10M 단위로 사용 가능합니다.</li>
							<li>재료비가 포함된 강좌는 마일리지 사용이 불가 합니다.</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="btn-center">
				<a class="btn btn01" onclick="#">취소</a>
				<a class="btn btn02" onclick="javascript:onSubmit();">승인</a>
			</div>
		</div>
	</div>
	<input type="hidden" name="store" value="<%=number%>"/>
    <input type="hidden" name="number" value="<%=number%>"/>
    <input type="hidden" name="dRegiAmt" id="dRegiAmt" value="<%=tot_regis_fee%>"/>
    <input type="hidden" name="dFoodAmt" value="<%=tot_food_amt%>"/>
    <input type="hidden" name="dTotAmt" id="dTotAmt" value="<%= tot_regis_fee + tot_food_amt %>"/>
    <input type="hidden" name="dTotalAmt" id="dTotalAmt" value="<%= AKTotal_fee %>"/><!--40기 20%에누리를 위해 적용한 hidden value 이거 변경했는데 확인필요 다른뎃 쓰는지 이게 최종결제금액-->
    <input type="hidden" name="dEnuriper" value="<%= enuri_percent %>"/><!--신설강좌  20%에누리를 위해 적용한 hidden value (11.02.02)-->
    <input type="hidden" name="dNewEnuriAmt" value="<%= tot_regis_fee + tot_food_amt - tot_total_fee %>"/><!--신설강좌  20%에누리를 위해 적용한 hidden value (11.02.02)-->
    <input type="hidden" name="akmem_card_status" value="<%=AKmemCardStatus%>" /><!--akmembers 카드상태(정상카드이면 00)-->
    <input type="hidden" name="dayEnuri" value="<%=dayEnuri%>" /><!--기간할인에누리금액추가 2015.10.17-->
    
     <!-- ★☆  추가  결제 준비 필수 값-->     
     <input type="hidden" name="req_tx"          value="pay"/>
     <input type="hidden" name="site_name"       value="<%= g_conf_site_name %>"/>
     <input type="hidden" name="site_cd"         value="<%= g_conf_site_cd	%>"/>
     <input type="hidden" name="site_cd_normal"  value="<%= g_conf_site_cd %>"/>
     <input type="hidden" name="site_cd_ak"      value="<%= g_conf_site_cd_ak %>"/>
     <input type="hidden" name="site_key"        value="<%= g_conf_site_key %>"/>
     <input type="hidden" name="site_key_normal"  value="<%= g_conf_site_key %>"/>
     <input type="hidden" name="site_key_ak"      value="<%= g_conf_site_key_ak %>"/>
     
     <input type="hidden" name="site_cd_akkb"      value="<%= g_conf_site_cd_akkb %>"/>
     <input type="hidden" name="site_key_akkb"      value="<%= g_conf_site_key_akkb %>"/>
     
     <input type="hidden" name="ordr_idxx"       value=""/>
     <input type="hidden" name="pay_method"      value="100000000000"/>
     <input type="hidden" name="good_name"       value="문화아카데미 강좌결제"/>
     <input type="hidden" name="good_mny"   id="good_mny"     value="<%= (int) AKTotal_fee %>" maxlength="9"/>
     <input type="hidden" name="currency"        value="WON"/>
     <input type="hidden" name="quotaopt"        value="12"/>
     <input type="hidden" name="shop_user_id"    value=""/>
     <input type="hidden" name="NotAKTotal_fee" id="NotAKTotal_fee" value="<%= (int) NotAKTotal_fee %>"/>
     <input type="hidden" name="AKTotal_fee"   id="AKTotal_fee"  value="<%= (int) AKTotal_fee %>"/>
     <input type="hidden" name="akcard_yn"        value="Y"/>
     <input type="hidden" name="akKBcard_yn"        value="Y"/>
     <input type="hidden" name="used_card_YN"     value="N"/>
     <input type="hidden" name="used_card"        value="CCLG"/>
     <input type="hidden" name="buyr_name"        value="<%= buyr_name%>"/>
     <input type="hidden" name="skin_indx"        value="3"> 
      <!-- ★☆  추가  결제 결과 필수 값-->     
     <input type="hidden" name="res_cd"          value=""/>
     <input type="hidden" name="res_msg"         value=""/>
     <input type="hidden" name="reg_en_msg"      value=""/>
     <input type="hidden" name="enc_data"        value=""/>
     <input type="hidden" name="enc_info"        value=""/>
     <input type="hidden" name="tran_cd"        value=""/>
     <input type="hidden" name="tot_subject_cd"  id="tot_subject_cd" value="<%=tot_subject_cd%>"/>
     <input type="hidden" name="tot_enuri1_cd"  id="tot_enuri1_cd" value=""/>
     <input type="hidden" name="tot_enuri2_cd"  id="tot_enuri2_cd" value=""/>
     <input type="hidden" name="tot_enuri1_amt"  id="tot_enuri1_amt" value=""/>
     <input type="hidden" name="tot_enuri2_amt"  id="tot_enuri2_amt" value=""/>
     
     <input type="hidden" name="sat_fg" id="sat_fg"    value=""/>
     <input type="hidden" name="NotAKTotal_fee_old" id="NotAKTotal_fee_old" value="<%= (int) NotAKTotal_fee %>"/>
     <input type="hidden" name="AKTotal_fee_old" id="AKTotal_fee_old" value="<%= (int) AKTotal_fee %>"/>
     <input type="hidden" name="dTotAmt_old" id="dTotAmt_old" value="<%= AKTotal_fee %>"/>
     <input type="hidden" name="ssoCi" id="ssoCi" value="<%= ssoCi %>"/>
     <input type="hidden" name="upointAmt" id="upointAmt" value="0"/>
     <input type="hidden" name="free_fee2" id="" value="<%=free_fee %>"/>
     <input type="hidden" name="ci" id="ci"    value = ""/>   
</form>
<div class="edit-popup" id="encd_layer">
	<div class="edit-bg"></div> 
	<div class="edit-wrap edit-wrap02">
		<div class="exit" onclick="javascript:$('#encd_layer').fadeOut(200);"><img src="/img/exit.png" alt="close" /></div>
		<h3>할인코드 (최대 2개까지 선택가능합니다)</h3>
		
		<div>
			<h3 class="text-center">즉시할인</h3>
			<div id="target_encd1">
			</div>
			<h3 class="text-center">중복할인</h3>
			<div id="target_encd2">
			</div>
			<div id="target_encd3" class="text-center">
			</div>
     	</div>
	</div>
</div>

<jsp:include page="/inc/footer.jsp" />

<script>
// StartSmartUpdate();
// setTimeout("jsf__chk_plugin()","1000");
init_orderid();
</script>