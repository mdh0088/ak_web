$( document ).ready(function() {
	$('.inputDisabled').attr('readOnly', true);
});
function setBundang()
{
	$("#selBranch").val("03");
	$(".selBranch").html("분당점");
}

function cutDate2(dd)
{
	if(dd != '' && dd != null)
	{
		var year = dd.substring(0,4);
		var month = dd.substring(4,6);
		var day = dd.substring(6,8);
		return year+"-"+month+"-"+day;
	}
}

function get_label(fld) {
	var id = fld;
	var labels = document.getElementsByTagName('label');
	var el = null;
	var text = '';
	for (i = 0; i < labels.length; i++) {
		if (id == labels[i].htmlFor) {
			el = labels[i];
			break;
		}
	}
	if (el != null) {
		text = el.innerHTML;
	}
	return text;
}
function excuteEnter(excuteFunc)
{
	if(event.keyCode == 13){
		excuteFunc();
		return;
	}
}
function excuteEnter_param(excuteFunc, param1, param2)
{
	if(event.keyCode == 13){
		excuteFunc(param1, param2);
		return;
	}
}

function calcAge(birth) {                 

    var date = new Date();
    var year = date.getFullYear();
    var month = (date.getMonth() + 1);
    var day = date.getDate();       
    if (month < 10) month = '0' + month;
    if (day < 10) day = '0' + day;
    var monthDay = month + day;
    birth = birth.replace('-', '').replace('-', '');
    var birthdayy = birth.substr(0, 4);
    var birthdaymd = birth.substr(4, 4);
    var age = monthDay < birthdaymd ? year - birthdayy - 1 : year - birthdayy;

    return age;
}

function getInputDayLabel(dd) {
    
    var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');
    
    var today = new Date(dd).getDay();
    var todayLabel = week[today];
    
    return todayLabel;
}
function cutDate(dd)
{
	if(dd == "" || dd == null || dd == 'null' || dd == undefined)
	{
		return "";
	}
	else
	{
		if(trim(dd).length == 8)
		{
			var year = dd.substring(0,4);
			var month = dd.substring(4,6);
			var day = dd.substring(6,8);
			return year+"-"+month+"-"+day;
		}
		else if(trim(dd).length == 14)
		{
			var year = dd.substring(0,4);
			var month = dd.substring(4,6);
			var day = dd.substring(6,8);
			var hour = dd.substring(8,10);
			var min = dd.substring(10,12);
			var sec = dd.substring(12,14);
			return year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec;
		}
		else
		{
			return dd;
		}
	}
}

function nullChk(d)
{
	if(d == "" || d == null || d == 'null' || d == undefined)
	{
		return "";
	}
	else
	{
		return d;
	}
}
function nullChkZero(d)
{
	if(d == "" || d == null || d == 'null' || d == undefined)
	{
		return "0";
	}
	else
	{
		return d;
	}
}
function convInt(d)
{
	return Math.ceil(nullChkZero(d));
}
function comma(x) {
    return nullChkZero(x).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
function comma2(x) {
    return nullChkZero(x).toString().replace(/\B(?=(\d{2})+(?!\d))/g, ".");
}
var setCookie = function(name, value, exp) 
{
	var date = new Date();
	date.setTime(date.getTime() + exp*24*60*60*1000);
	document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
};
var getCookie = function(name) 
{
	var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
	return value? value[2] : null;
};
function getNow()
{
	var date = new Date(); 
	var year = date.getFullYear(); 
	var month = new String(date.getMonth()+1); 
	var day = new String(date.getDate()); 

	// 한자리수일 경우 0을 채워준다. 
	if(month.length == 1){ 
	  month = "0" + month; 
	} 
	if(day.length == 1){ 
	  day = "0" + day; 
	} 
	return year + "" + month + "" + day;
}
function getTime()
{
	var date = new Date(); 
	var h = date.getHours();
	var m = date.getMinutes();
	var s = date.getSeconds();
	// 한자리수일 경우 0을 채워준다. 
	if(h.length == 1){ 
	  h = "0" + h.toString(); 
	} 
	if(m.length == 1){ 
	  m = "0" + m.toString(); 
	} 
	if(s.length == 1){ 
		s = "0" + s.toString(); 
	} 
	return h + "" + m + "" + s;
}
function cutLectHour(lecthour)
{
	if(lecthour.length != 8)
	{
		return "";
	}
	else
	{
		var lect1 = "";
		var lect2 = "";
		var lect3 = "";
		var lect4 = "";
		
		lect1 = lecthour.substring(0,2);
		lect2 = lecthour.substring(2,4);
		lect3 = lecthour.substring(4,6);
		lect4 = lecthour.substring(6,8);
		
		return lect1 + ":" + lect2 + "~" + lect3 + ":" + lect4;
	}
}
function cutYoil(day_flag)
{
	var yoil = "";
	if(day_flag.split('')[0] == "1")
	{
		yoil += ",월";
	}
	if(day_flag.split('')[1] == "1")
	{
		yoil += ",화";
	}
	if(day_flag.split('')[2] == "1")
	{
		yoil += ",수";
	}
	if(day_flag.split('')[3] == "1")
	{
		yoil += ",목";
	}
	if(day_flag.split('')[4] == "1")
	{
		yoil += ",금";
	}
	if(day_flag.split('')[5] == "1")
	{
		yoil += ",토";
	}
	if(day_flag.split('')[6] == "1")
	{
		yoil += ",일";
	}
	yoil = yoil.substring(1, yoil.length);
	return yoil;
}
function trim(stringToTrim) {
    return nullChk(stringToTrim).toString().replace(/^\s+|\s+$/g,"");
}
function ck_age(age) { 
  var year=parseInt(new Date().getFullYear()); 
  var ck=parseInt(age.substring(0,4)); 
  return (year-ck)+1; // 우리나라 나이 표시 +1 더함 
}

function show_address(post, addr) {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            document.getElementById(post).value = data.zonecode;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
	            document.getElementById(addr).value = roadAddr;
               // document.getElementById("extraAddress").value = extraRoadAddr;
            } else {
	            document.getElementById(addr).value = data.jibunAddress;
               // document.getElementById("extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
            	
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                //guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
               // guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
            	
                var expJibunAddr = data.autoJibunAddress;
               //guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
               // guideTextBox.style.display = 'block';
            } else {
            	
               // guideTextBox.innerHTML = '';
               // guideTextBox.style.display = 'none';
            }
        }
    }).open();
}
function repWord(dd)
{
	dd = dd.replace(/&amt;/gi, "&");
	dd = dd.replace(/&lt;/gi, "<");
	dd = dd.replace(/&gt;/gi, ">");
	dd = dd.replace(/&quot;/gi, "\"");
	dd = dd.replace(/&#039;/gi, "\'");
	dd = dd.replace(/<br>/gi, "\n");
	
	return dd;
	
}
//6자리 uid생성
function generateUID() {
	var ranNum = Math.floor(Math.random()*(999999-100000+1)) + 100000;
	return String(ranNum);
}
//계좌실명조회
function coocon_api(bank_cd, search_acct_no, acnm_no){
	if(nullChk(bank_cd) == "" || nullChk(search_acct_no == "") || nullChk(acnm_no) == ""){
		alert("필요 정보가 부족합니다");
		return false;
	}
   	const SECR_KEY = "26ITwrC3lVJCeh3XeBYr";
	const KEY = "ACCTNM_RCMS_WAPI";
    var REQ_DATA = new Object();
        REQ_DATA.BANK_CD = bank_cd;		//은행코드
        REQ_DATA.SEARCH_ACCT_NO = search_acct_no;	//계좌번호
        REQ_DATA.ACNM_NO = acnm_no;		//증명번호 ex)사업자번호 10자리 or 생년월일 6자리
        REQ_DATA.TRSC_SEQ_NO = "7"+generateUID();	//거래일련번호

    var JSONData = new Object();
    JSONData.SECR_KEY = SECR_KEY;
    JSONData.KEY = KEY;
    JSONData.REQ_DATA = [];
    JSONData.REQ_DATA.push(REQ_DATA);
    
    var acct_nm = "";
    $.ajax({
        type: "POST",
        url: "/common/coocon_api",
        async: false,
        data:{
            JSONData: JSON.stringify(JSONData)
        },
        success: function(data){
        	var result = JSON.parse(data.res);
        	if(result.RSLT_CD != "000"){	//000을 제외하면 오류
        		alert(result.RSLT_MSG+"\n"+result.RSLT_CD);
        		return false;
        	}else{
        		acct_nm = result.RESP_DATA[0].ACCT_NM; //예금주명(최대 20byte)
        		if(nullChk(acct_nm) == ""){	//거래일련번호 중복시 데이터조회가 안되어 추가함
        			alert("일시적인 오류입니다. 다시 시도해 주세요.");
        			return false;
        		}
        	}
        }
    });
    return acct_nm;
}
function nice_api(gubun, reqNum){
	if((gubun != "A") && (gubun != "B")){
		alert("데이터를 정확히 입력해주세요");
		return false;
	}
	if((gubun == "A" && reqNum.length != 10) || (gubun == "B" && reqNum.length != 13)){
		alert("데이터를 정확히 입력해주세요");
		return false;
	}
	$.ajax({
        type: "POST",
        url: "/common/nice_api",
        async: false,
        data:{
            gubun: gubun,	//사업자번호=A, 법인번호=B
            reqNum: reqNum	//요청값
        },
        success: function(data){
        	console.log(data);
        	if(data.isSuc == "success"){
        		alert("조회성공");
        		console.log(data.msg); 	//기업상태
        		console.log(data.compName);	//기업명
        		console.log(data.repName);	//대표자명
        	}else if(data.isSuc == "failed" || nullChk(data.errCode) == "-9"){
        		var inner = '조회에 실패하였습니다. 입력한 정보를 다시 확인하여주세요.\n';
        			inner += '\n';
        			inner += '같은 오류가 계속 발생할경우\n';
        			inner += '나이스 DB에 법인 정보를 등록/재등록 요청해주세요\n';
        			inner += ' * 영업일 기준 평균 1~2시간 소요\n';
        			inner += ' * 확인 버튼 클릭시 요청페이지로 이동합니다.(팝업 허용 필요)';
        		if(confirm(inner)){
        			window.open('https://www.niceid.co.kr/front/personal/corporate/corporate_register.jsp?menu_num=1&page_num=0&page_num_1=4', '_blank');
        		}
        	}else{
        		alert("시스템 에러: "+data.errCode);
        	}
        }
    });
}
// AK사업자번호로 테스트
// nice_api("A", "1258129907"); 
// data.msg: 정상
// data.compName: 에이케이에스앤디(주)
// data.rep: 심상보
var child1_no = "";
var child2_no = "";
var child3_no = "";
function goBookBag(store,subject_cd,main_cd,sect_cd)
{
	$("#bag_layer").remove();
	var is_two = false;
	$.ajax({
		type : "POST", 
		url : "/course/getIsTwo",
		dataType : "text",
		async : false,
		data : 
		{
			store : store,
			subject_cd : subject_cd
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{	
			console.log(data);
			if(data == "Y")
			{
				is_two = true;
			}
			else
			{
				is_two = false;
			}
		}
	});	
	$.ajax({
		type : "POST", 
		url : "/course/findChildByCust",
		dataType : "text",
		async : false,
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{	
			console.log(data);
			var result = JSON.parse(data);
			if(main_cd == "2" || main_cd == "3") //베이비면 체크박스, 아니면 라디오
			{
				if(result.list.length == 0) 
				{
					if (confirm("님은 자녀강좌를 신청할 수 없습니다. \n\n자녀강좌는 자녀회원등록후 자녀를 수강자로 선택하신 후 등록하십시오.\n\n수강자 변경을 하시겠습니까?")) 
					{
						location.href = "/academy/academy06";
					}
				}
			}
			var inner = "";
			inner += '<div class="edit-popup" id="bag_layer" >';
			inner += '	<div class="edit-bg"></div>'; 
			inner += '	<div class="edit-wrap edit-wrap02">';
			inner += '		<div class="exit" onclick="javascript:$(\'#bag_layer\').fadeOut(200);"><img src="/img/exit.png" alt="close" /></div>';
			inner += '		<h3>분당점 수강 회원 선택</h3>';
			inner += '		<p class="h3-p">수강 신청 대상 회원을 선택하세요.<br>';
			inner += '		자녀가 등록되어 있지 않은 경우 자녀회원 등록에서 등록 후 선택할 수 있습니다.';
			inner += '		</p>';
			
			inner += '		<div class="bag-popwr">';
			inner += '			<ul class="td-chk02">';
			if(main_cd == "2") //베이비면 체크박스, 아니면 라디오
			{
				
				inner += '<li><label for="bag_type"><input type="checkbox" id="selChild_0" name="selChild" value="S" checked="checked" disabled="true"><span class="bagbor">본인</span>'+result.cust_nm+' <span class="bag-birth">'+cutDate(result.bmd)+'</span></label></li>';
				for(var i = 0; i < result.list.length; i++)
				{
					var gender = result.list[i].GENDER == "M" ? '아들':'딸';
					inner += '<li><label for="bag_type"><input type="checkbox" id="selChild_'+result.list[i].CHILD_NO+'" name="selChild" value="S" ><span class="bagbor">'+gender+'</span>'+result.list[i].CHILD_NM+' <span class="bag-birth">'+cutDate(result.list[i].BIRTH)+'</span></label></li>';
				}
			}
			else if(main_cd == "3" && is_two) //베이비면 체크박스, 아니면 라디오
			{
				for(var i = 0; i < result.list.length; i++)
				{
					var gender = result.list[i].GENDER == "M" ? '아들':'딸';
					inner += '<li><label for="bag_type"><input type="checkbox" id="selChild_'+result.list[i].CHILD_NO+'" name="selChild" value="S" ><span class="bagbor">'+gender+'</span>'+result.list[i].CHILD_NM+' <span class="bag-birth">'+cutDate(result.list[i].BIRTH)+'</span></label></li>';
				}
			}
			else if(main_cd == "3" && !is_two) //베이비면 체크박스, 아니면 라디오
			{
				for(var i = 0; i < result.list.length; i++)
				{
					var gender = result.list[i].GENDER == "M" ? '아들':'딸';
					inner += '<li><label for="bag_type"><input type="radio" name="selChild" value="'+result.list[i].CHILD_NO+'" ><span class="bagbor">'+gender+'</span>'+result.list[i].CHILD_NM+' <span class="bag-birth">'+cutDate(result.list[i].BIRTH)+'</span></label></li>';
				}
			}
			else
			{
				inner += '<li><label for="bag_type"><input type="radio" id="selChild_0" name="selChild" value="0" checked="checked"><span class="bagbor">본인</span>'+result.cust_nm+' <span class="bag-birth">'+cutDate(result.bmd)+'</span></label></li>';
				for(var i = 0; i < result.list.length; i++)
				{
					var gender = result.list[i].GENDER == "M" ? '아들':'딸';
					inner += '<li><label for="bag_type"><input type="radio" name="selChild" value="'+result.list[i].CHILD_NO+'" ><span class="bagbor">'+gender+'</span>'+result.list[i].CHILD_NM+' <span class="bag-birth">'+cutDate(result.list[i].BIRTH)+'</span></label></li>';
				}
			}
			inner += '			</ul>';
			inner += '		</div>';
			inner += '		<div class="btn-center">';
			inner += '			<a class="btn btn01" href="../academy/academy06">자녀회원 등록하기 <img src="/img/myaca-i04.png" alt="수강자변경 아이콘"></a>';
			inner += '			<a class="btn btn02" onclick="goBookBag2(\''+store+'\',\''+subject_cd+'\',\''+main_cd+'\',\''+sect_cd+'\',\''+is_two+'\')">선텍완료</a>';
			inner += '		</div>';
			inner += '	</div>';
			inner += '</div>';
			$("body").append(inner);
			
			$("#bag_layer").fadeIn("200");
		}
	});	
	getBookCnt();
	
	
	
}

function goBookBag2(store,subject_cd,main_cd,sect_cd,is_two)
{
	child1_no = "";
	child2_no = "";
	child3_no = "";
	
	if(main_cd == "2")
	{
		child1_no = 0;
		var chkList = "";
		var childCnt = 0;
		$("input:checkbox[name='selChild']").each(function(){
			var child_no = $(this).attr('id').replace('selChild_', '');
		    if($(this).is(":checked") && child_no != '0')
	    	{
		    	if(childCnt == 0) {child2_no = child_no;}
		    	else if(childCnt == 1) {child3_no = child_no;}
		    	childCnt ++;
	    	}
		});
		if(childCnt > 2)
		{
			alert("자녀는 두명까지 선택가능합니다.");
			return;
		}
		else if(childCnt == 0)
		{
			alert("자녀 한명은 필수로 선택하셔야합니다.");
			return;
		}
	}
	else if(main_cd == "3" && is_two == "true")
	{
		var chkList = "";
		var childCnt = 0;
		$("input:checkbox[name='selChild']").each(function(){
			var child_no = $(this).attr('id').replace('selChild_', '');
			if($(this).is(":checked") && child_no != '0')
			{
				if(childCnt == 0) {child1_no = child_no;}
				else if(childCnt == 1) {child2_no = child_no;}
				childCnt ++;
			}
		});
		if(childCnt > 2)
		{
			alert("자녀는 두명까지 선택가능합니다.");
			return;
		}
		else if(childCnt == 0)
		{
			alert("자녀 한명은 필수로 선택하셔야합니다.");
			return;
		}
	}
	else
	{
		child1_no = $('input[name="selChild"]:checked').val();
	}
	//var pageUrlFlag = "HttpUtil.getPageUrl(request, requestPathParam, "SB") "; 이부분 java단에서 실어서 jstl로 처리하면 될 듯
//	var pageUrlFlag = "${pageUrlFlag}";
//	if (pageUrlFlag == "S-LyPop") {
//		alert('기존회원입니다.');	
//	}else{
	$("#bag_layer").fadeOut("200");
		$.ajax({
			type : "POST", 
			url : "/course/goBookBag",
			dataType : "text",
			async : false,
			data : 
			{
				store : store,
				//period : period,
				subject_cd : subject_cd,
				main_cd:main_cd,
				sect_cd:sect_cd,
				child1_no:child1_no,
				child2_no:child2_no,
				child3_no:child3_no
				//sect_nm:sect_nm
			},
			error : function() 
			{
				console.log("AJAX ERROR");
			},
			success : function(data) 
			{	
				console.log(data);
				var result = JSON.parse(data);
				retval = result.ajaxResultCd;
				
				if(retval.indexOf("OK::") > -1)
				{
					var resultCd = retval.split("::");
					if(resultCd[1] == "01"){
						if(confirm("수강자 선택 후 책가방 담기가 가능합니다.\n\n수강자를 선택 하시겠습니까?")){
							//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);
							location.href="/academy/academy06";	
						}
						
					}else if(resultCd[1] == "02"){
						
						if(confirm("해당강좌와 수강자-지점이 일치하지 않습니다.\n\n변경하시겠습니까?")){ 
							//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);
							location.href="/academy/academy06";	
						}
						
					}else if(resultCd[1] == "11" || resultCd[1] == "12"){
			         // alert("겨울학기 회원모집은 [분당: 10/25(금) 오전 10시 / 수원,구로,평택: 10/25(금) 오전 10시 30분]부터 진행됩니다."); 
						// 메르스 alert("회원모집 기간\n\n [기존회원] 4/22(수)10시 30분~ [신규회원] 4/24(금) 10시 30분~ 단,분당점 10시부터.  ");
						//alert("회원모집 기간\n\n 7/13(월) 10시이후부터");
						//alert("기존회원 재수강 기간입니다.\n\n신규 회원 수강 기간은 4/22(금)10시 30분~");
			     		//  alert("전(前)학기 수강회원 재수강 기간 입니다.\n\n수강신청 일정을 참조하시기 바랍니다.\n\n강좌검색은 하실 수 있습니다.");
						//if(store.equals("05")){
						//	alert("회원모집 기간\n\n 5/30(월) 10시 30분 이후부터");	
						//}else{
							alert("기존회원 재수강 기간입니다.\n\n신규 회원 수강 기간은 10/24(목) 10시 30분~");	
						//}
							
					}
//					else if(resultCd[1] == "13"){
//						if(confirm("님은 자녀강좌를 신청할 수 없습니다. \n\n자녀강좌는 자녀회원등록 후 자녀를 수강자로 선택하신 후 등록하십시오.\n\n수강자 변경을 하시겠습니까?")){
//							//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);	
//							location.href="/academy/academy06";	
//						}
//					}
					else if(resultCd[1] == "14"){
						 if(confirm("님은 성인 강좌를 신청할수 없습니다.")){
						 	//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);
							 location.href="/academy/academy06";	
						 }
					}else if(resultCd[1] == "21"){
						alert("이미 결제완료된 강좌입니다.");
					}else if(resultCd[1] == "22"){
						alert("이미 책가방에 담긴 강좌입니다.");
					}else if(resultCd[1] == "23"){
						alert("정원이 마감된 강좌입니다.");
					}else if(resultCd[1] == "24"){
						alert("책가방 담기에 실패하였습니다.");
					}else{
						if(confirm("책가방에 담겼습니다.\n\n나의 책가방으로 이동하시겠습니까?")){
							//location.href="/cult/lecture.do?method=templist&number=03&menu_num=3_4&hq=00&store="+store;
							location.href="/academy/academy04";	
						}
					}
				}else{
					if(retval.indexOf("FAIL::") > -1){
						alert("로그인 후 책가방에 담아 주세요.");
						//culture.global.goLogInForm();
						location.href="/user/login";	
					}
				}

			}
		});	
//	}
	
}

function goWaitAdd(store,subject_cd,main_cd,sect_cd){
	
	if(!confirm("대기회원으로 등록하시겠습니까?\n대기회원등록은 1인 5강좌까지 등록 가능합니다."))
		return;
	
	$.ajax({
		type : "POST", 
		url : "/course/goWaitAdd",
		dataType : "text",
		async : false,
		data : 
		{
			store : store,
			//period : period,
			subject_cd : subject_cd,
			main_cd:main_cd,
			sect_cd:sect_cd
			//sect_nm:sect_nm
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			var result = JSON.parse(data);
			retval = result.ajaxResultCd;
			
			if(retval.indexOf("OK::") > -1)
			{
				var resultCd = retval.split("::");
				if(resultCd[1] == "01"){
					
					if(confirm("수강자 선택 후 대기자 등록이 가능합니다.\n\n수강자를 선택 하시겠습니까?")){
						//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);
						location.href="/academy/academy06";	
					}
					
				}else if(resultCd[1] == "02"){
					
					if(confirm("해당강좌와 수강자-지점이 일치하지 않습니다.\n\n변경하시겠습니까?")){ 
						//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);
						location.href="/academy/academy06";	
					}
					
				}else if(resultCd[1] == "11" || resultCd[1] == "12"){
		         // alert("겨울학기 회원모집은 [분당: 10/25(금) 오전 10시 / 수원,구로,평택: 10/25(금) 오전 10시 30분]부터 진행됩니다."); 
					// 메르스 alert("회원모집 기간\n\n [기존회원] 4/22(수)10시 30분~ [신규회원] 4/24(금) 10시 30분~ 단,분당점 10시부터.  ");
					//alert("회원모집 기간\n\n 7/13(월) 10시이후부터");
					//alert("기존회원 재수강 기간입니다.\n\n신규 회원 수강 기간은 4/22(금)10시 30분~");
		     		//  alert("전(前)학기 수강회원 재수강 기간 입니다.\n\n수강신청 일정을 참조하시기 바랍니다.\n\n강좌검색은 하실 수 있습니다.");
					//if(store.equals("05")){
					//	alert("회원모집 기간\n\n 5/30(월) 10시 30분 이후부터");	
					//}else{
						alert("회원모집 기간\n\n [기존회원] 7/23(화) 10시 30분~ [신규회원] 10/24(목) 10시 30분~");	
					//}
						
				}else if(resultCd[1] == "13"){
					if(confirm("님은 자녀강좌를 신청할 수 없습니다. \n\n자녀강좌는 자녀회원등록 후 자녀를 수강자로 선택하신 후 등록하십시오.\n\n수강자 변경을 하시겠습니까?")){
						//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);	
						location.href="/academy/academy06";	
					}
					
				}else if(resultCd[1] == "14"){
					 if(confirm("님은 성인 강좌를 신청할수 없습니다.")){
					 	//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);
						 location.href="/academy/academy06";	
					 }
				}else if(resultCd[1] == "21" || resultCd[1] == "reg"){
					alert("이미 결제완료된 강좌입니다.\n\n다른 수강자로 신청하시려면 가족회원 등록에서 수강자 변경 바랍니다.");
				}else if(resultCd[1] == "22"){
					alert("이미 책가방에 담긴 강좌입니다.");
				}else if(resultCd[1] == "23"){
					alert("정원이 마감된 강좌입니다.");
				}else if(resultCd[1] == "24"){
					alert("대기자 등록에 실패하였습니다.");
				}else if(resultCd[1] == "full"){
					alert("대기회원은 1인 5강좌까지 등록 가능합니다. 이미 모두 등록하셨습니다.");
				}else if(resultCd[1] == "wait"){
					alert("선택하신\n[test]\n강좌는 이미 대기회원으로 등록되어 있습니다.");
				}else if(resultCd[1] == "wait"){
					alert("선택하신\n[test]\n강좌는 이미 결제하신 강좌입니다.");
				}else if(resultCd[1] == ""){
					alert("선택하신\n[test]\n강좌에 대기회원으로 등록되었습니다.");
				}else{
					
					alert("알수 없는 오류 입니다.");
				}
			}else{
				if(retval.indexOf("FAIL::") > -1){
					alert("로그인 후 대기 신청이 가능합니다.");
					//culture.global.goLogInForm();
					location.href="/user/login";	
				}
			}

		}
	});	
}
//자바스크립트 해시맵
HashMap = function(){  
    this.map = new Array();
};  
HashMap.prototype = {  
    put : function(key, value){  
        this.map[key] = value;
    },  
    get : function(key){  
        return this.map[key];
    },  
    getAll : function(){  
        return this.map;
    },  
    clear : function(){  
        this.map = new Array();
    },  
    isEmpty : function(){    
         return (this.map.size() == 0);
    },
    remove : function(key){    
         delete this.map[key];
    },
    toString : function(){
        var temp = '';
        for(i in this.map){  
            temp = temp + ',' + i + ':' +  this.map[i];
        }
        temp = temp.replace(',','');
          return temp;
    },
    keySet : function(){  
        var keys = new Array();  
        for(i in this.map){  
            keys.push(i);
        }  
        return keys;
    }
};
//자바스크립트 해시맵