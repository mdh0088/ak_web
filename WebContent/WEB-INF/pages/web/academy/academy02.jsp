<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*" %>
<%@ page import="ak_web.classes.*" %>
<%@ include file="/WEB-INF/pages/web/course/site_conf_inc.jsp"%>
<script type="text/javascript" src="<%= g_conf_js_url %>"></script>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb02.jsp" />
<%
String buyr_name = Utils.checkNullString(session.getAttribute("login_name"));
String number = Utils.checkNullString(session.getAttribute("login_store"));

String AKmemCardNo = null;
HashMap AKmemRead ;
String AKmemCardStatus = null;

CmAKmembers cmAKmembers = new CmAKmembers();
AKmemCardNo = Utils.checkNullString(session.getAttribute("login_card")); //AKmembers 카드 번호

if(!"".equals(AKmemCardNo)){
	  AKmemRead = cmAKmembers.getAKmemRead( number, AKmemCardNo);
	  
	//   //정상적인 카드번호인지 확인
	  AKmemCardStatus = cmAKmembers.getAKmemStatus(AKmemRead);
}

%>
<script>
var store ='${number}';
$(document).ready(function() {
	getList();	
	getSeason();
	
	
	$('.store').click(function(){
		var temp = $(this).attr("id").split('_');
		$('.store').removeClass('active');
		$(this).addClass('active');
		store = temp[1];
		getList();
		getSeason();
	});
	
	$(".filter-close").click(function(){
		$(".filter-wrap").hide();
	})
	
});


var tmp_tid = "";
function getList(type) 
{
	$.ajax({
		type : "POST", 
		url : "./getMylectureList",
		dataType : "text",
		async : false,
		data : 
		{
			store : store ,
			start_ymd : $('#start_ymd').val(),
			end_ymd : $('#end_ymd').val()
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			
			var result = JSON.parse(data);

			var inner = "";
			
			if (result.length!=0) {
				for(var i = 0; i < result.length; i++){
					var tid = result[i].TID; //같은 TID는 묶음 취소 하기위함.
					var rowspan = 0; //같은 TID는 셀 합쳐줄거임.
					for(var j = 0; j < result.length; j++)
					{
						if(result[j].TID == tid)
						{
							if(tmp_tid != tid && nullChk(tid) != "")
							{
								rowspan ++;
							}
						}
					}
					if(nullChk(tid) == "")
					{
						rowspan ++;
					}
					inner +='<tr>';
					inner +='	<td>'+result[i].WEB_TEXT+'</td>';
					inner +='	<td>'+result[i].CUST_NM+'</td>';
					inner +='	<td>'+result[i].PAY_YMD+'</td>';
					inner +='	<td>'+result[i].SUBJECT_NM+'</td>';
					inner +='	<td>'+cutDate(result[i].START_YMD)+' ~ '+cutDate(result[i].END_YMD)+'</td>';
					inner +='	<td>'+result[i].LECTURER_NM+'</td>';
					inner +='	<td>('+result[i].DAY+') '+result[i].LECT_HOUR+'</td>';
					inner +='	<td>'+result[i].REGIS_FEE+'원</td>';
					inner +='	<td>';
					inner +='		<span class="mod-btn print-btn" >';
					if (result[i].REGIS_FEE!='0') {
						var receipt_info = result[i].STORE+'_'+result[i].SALE_YMD+'_'+result[i].POS_NO+'_'+result[i].RECPT_NO+'_'+result[i].CUST_NO;
						inner +='<img src="/img/print-icon.png" alt="수정하기" onclick=print_receipt(\''+receipt_info+'\');>';					
					}
					inner +='		</span>';
					inner +='	</td>';
					if (result[i].REGIS_CANCEL_FG=='2') {
						inner +='	<td colspan="2">';
						inner +='		취소일자 : '+result[i].CANCEL_YMD;
						inner +='	</td>';
					}else{
						var cancel_info = result[i].STORE+'_'+result[i].PERIOD+'_'+result[i].SALE_YMD+'_'+result[i].POS_NO+'_'+result[i].RECPT_NO+'_'
										+result[i].CUST_NO+'_'+result[i].TID+'_'+result[i].AKCARD_YN+'_'+result[i].AKKBCARD_YN+'_'+result[i].AKWBCARD_YN;
								
						if(tmp_tid != tid || nullChk(tid) == "")
						{
							inner +='	<td rowspan="'+rowspan+'">';
// 							if(rowspan > 1) //복합인경우
// 							{
								inner +='		<a class="de-btn btn03" onclick="javascript:allCancel(\''+nullChk(tid)+'\',\''+result[i].STORE+'\');">취소</a>'; 
// 							}
// 							else
// 							{
// 								inner +='		<a class="de-btn btn03" onclick="javascript:allCancel(\''+tid+'\',\''+result[i].STORE+'\');">취소</a>';
// 							}
							
							inner +='	</td>';
							rowspan = 0; //셀합치기 초기화
							tmp_tid = tid; //한번 뿌린애 기억하기위해
							
						}
						inner +='	<td>';				
						inner +='		<a class="de-btn btn02" onclick="javascript:getReview(\''+result[i].STORE+'_'+result[i].GET_PERIOD+'_'+result[i].SUBJECT_CD+'_'+result[i].CUST_NO+'\')">후기등록</a>';
						inner +='	</td>';
					}
					inner +='</tr>';
				}
			}else{
				inner +='<tr>';
				inner +='	<td colspan="10">수강내역이 없습니다.</td>';
				inner +='</tr>';
			}
			 

			$("#list_target").html(inner);
			
			
		}
	});		
}
function allCancel(tid, store)
{
	$("#payment_layer").fadeIn(200);	
	$.ajax({
		type : "POST", 
		url : "./getPaymentListByTid",
		dataType : "text",
		async : false,
		data : 
		{
			tid : tid,
			store : store
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			
			var result = JSON.parse(data);

			var inner = "";
			
			if (result.length!=0) {
				for(var i = 0; i < result.length; i++)
				{
					inner +='<tr>';
					inner +='	<td><label><input id="chk_'+result[i].STORE+'_'+result[i].PERIOD+'_'+result[i].SUBJECT_CD+'_'+nullChk(result[i].TID)+'" name="chk_val" type="checkbox"></label></td>';
					inner +='	<td>'+result[i].SUBJECT_NM+'</td>';
					inner +='</tr>';
				}
			}
			

			$("#filter_target").html(inner);
		}
	});	
}
function halfPayment()
{
	var onList = "";
	var offList = "";
	var tot_subject_cd = "";
	var store = "";
	var tid = "";
	
	$("input:checkbox[name='chk_val']").each(function(){
	    if($(this).is(":checked"))
    	{
	    	onList += $(this).attr("id").replace("chk_", "")+"|";
    	}
	    else
	    {
	    	offList += $(this).attr("id").replace("chk_", "")+"|";
	    }
	    tot_subject_cd += ",\'"+$(this).attr("id").split("_")[3]+"\'";
	    tid = $(this).attr("id").split("_")[4];
	});
	
	$("#tid").val(tid);
	
	tot_subject_cd = tot_subject_cd.substring(1, tot_subject_cd.length);
	
	$.ajax({
		type : "POST", 
		url : "./getHalfPaymentPrice",
		dataType : "text",
		async : false,
		data : 
		{
			onList : onList,
			offList : offList
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			
			var result = JSON.parse(data);
			var tot = Number(result.tot_regis_fee) + Number(result.tot_food_amt);
			$("#good_mny").val(tot);
			$("#dTotAmt").val(tot);
			$("#dRegiAmt").val(result.tot_regis_fee);
			$("#dFoodAmt").val(result.tot_food_amt);
			
			$("#onList").val(onList);
			$("#offList").val(offList);
			
			$("#tot_subject_cd").val(tot_subject_cd);
			
			if(tot > 0)
			{
				$("#is_payment").val('Y');
				onSubmit(); //결제
			}
			else
			{
				$("#is_payment").val('N');
				$("#CalForm").ajaxSubmit({
					success: function(data)
					{
						console.log(data);
// 						var result = JSON.parse(data);
// 			    		if(result.isSuc == "success")
// 			    		{
// 			    			alert(result.msg);
// 		 	    			location.reload();
// 			    		}
// 			    		else
// 			    		{
// 				    		alert(result.msg);
// 			    		}
					}
				});
			}

		}
	});	
}

function getSeason() 
{
	$.ajax({
		type : "POST", 
		url : "./getSeason",
		dataType : "text",
		async : false,
		data : 
		{
			store : store
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			$("#start_ymd").val('');
			$("#end_ymd").val('');
			$('.start_ymd').text('');
			$('.end_ymd').text('');
			
			var result = JSON.parse(data);
			var inner ="";
			var inner_li="";
			for(var i = 0; i < result.list.length; i++){
				inner +='<option value="'+result.list[i].PERIOD+'">'+result.list[i].WEB_TEXT+'</option>';
				inner_li += '<li>'+result.list[i].WEB_TEXT+'</li>';
			}
			$("#start_ymd").html(inner);
			$("#end_ymd").html(inner);
			$('.start_ymd_ul').html(inner_li);
			$('.end_ymd_ul').html(inner_li);
		}
	});		
}

function print_receipt(idx){
	console.log(idx);
}

function cancel(idx){
	
	var arr = idx.split('_');
	$.ajax({
		type : "POST", 
		url : "./lectureCancel",
		dataType : "text",
		async : false,
		data : 
		{
			store:		arr[0],
			period:		arr[1],
			sale_ymd:	arr[2],
			pos_no:		arr[3],
			recpt_no:	arr[4],
			cust_no:	arr[5],
			tid:		arr[6],
			akcard_yn:	arr[7],
			akkbcard_yn:arr[8],
			akwbcard_yn:arr[9]
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			
			var result = JSON.parse(data);

			var inner = "";
			
			
		}
	});	
}

function courseSearch()
{
	$('#search_layer').fadeIn(200);	
}

$(function(){
	$(".td-chk input").each(function(){
		$(this).click(function(){
			var chk = $(this).val();
			if(chk=="decum1"){
				$(".btn-docu02").hide();
				$(".btn-docu01").show();
			}else{
				$(".btn-docu01").hide();
				$(".btn-docu02").show();
			}
		})
		
	})
})



var arr="";
function getReview(idx){
	$('#search_layer').fadeIn(200);
	arr = idx.split('_');
	
	$.ajax({
		type : "POST", 
		url : "./getReview",
		dataType : "text",
		async : false,
		data : 
		{
			store:		arr[0],
			period:		arr[1],
			subject_cd:	arr[2],
			cust_no:	arr[3]
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			
			var result = JSON.parse(data);

			if (result.length!=0) {
				$('#content').val(nullChk(result.CONTENT));
				if (result.RECO_YN=='Y') {
					document.getElementById("reco_yn").checked=true;
				}else{
					document.getElementById("reco_yn").checked=false;
				}
			}
			
			
		}
	});	
}


function uptReview(){
	var reco_yn="";
	if (document.getElementById("reco_yn").checked==true) {
		reco_yn="Y";
	}else{
		reco_yn="N";
	}
	$.ajax({
		type : "POST", 
		url : "./uptReview",
		dataType : "text",
		async : false,
		data : 
		{
			store:		arr[0],
			period:		arr[1],
			subject_cd:	arr[2],
			cust_no:	arr[3],
			reco_yn :	reco_yn,
			content :   $('#content').val()
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
			getReview(arr[0]+'_'+arr[1]+'_'+arr[2]+'_'+arr[3]);			
		}
	});	
}

function delReview(){
	$.ajax({
		type : "POST", 
		url : "./delReview",
		dataType : "text",
		async : false,
		data : 
		{
			store:		arr[0],
			period:		arr[1],
			subject_cd:	arr[2],
			cust_no:	arr[3]
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
			getReview(arr[0]+'_'+arr[1]+'_'+arr[2]+'_'+arr[3]);	
			
			
		}
	});	
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
function jsf__pay(form) {
	KCP_Pay_Execute(form);
}
function onSubmit() {
    
    this.disabled=true;
    
	f = document.CalForm; 
	jsf__pay(f);    
}
</script>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<div class="cour-seartop">
			<div class="myaca-sear table">
				<div class="myaca-s">
					<div class="search-box">
						<select id="start_ymd">
							
						</select>
					</div>
				</div>
				<div class="myaca-dash">
					-
				</div>
				<div class="myaca-s">
					<div class="search-box disable">
						<select id="end_ymd">
							
						</select>
					</div>
				</div>
				<div class="search-r">
					<a class="cour-searbtn" onclick='javascript:getList()'>SEARCH</a>
				</div>
			</div>
		</div>
		<p class="sub-tit"><b>${kor_nm}님의</b> 수강/취소 내역 입니다.</p>
		<div class="cour-left">
			<p class="cour-txt">일부 강좌의 수강을 원하시는 경우에는 전체 취소 후 책가방 화면에서 수강할 강좌를 선택하여 결제하시면 됩니다.</p>
		</div>
		<div class="colist-wr myaca-wr">
			<table>
				<thead>
					<tr>
						<th>학기</th>
						<th>수강회원</th>
						<th>결제일</th>
						<th>강좌명</th>
						<th>강좌 기간</th>
						<th>강사명</th>
						<th>요일/시간</th>
						<th>결제금액</th>
						<th>영수증 인쇄</th>
						<th colspan="2">접수현황</th>
					</tr>
				</thead>
				<tbody id="list_target">
					
				</tbody>
			</table>
			
		</div>
		<div class="pagination-wr">
			<div class="btn-right">
				<a class="btn btn02" href="#">수강·취소 내역 인쇄</a>
			</div>
<%-- 			<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/> --%>
		</div>
		<div class="myaca-bot">
			<div class="table">
				<div class="myacabot-tit">
					<p>확인하세요!</p>
				</div>
				<div>
					<ul>
						<li>인터넷 수강취소는 인터넷으로 강좌를 신청하신 분들에 한하여 가능합니다.</li>
						<li>인터넷으로 다수의 강좌를 동시에 결제하신 경우, 일부 강좌를 취소하는 것은 불가능합니다. <br>
일부 강좌의 수강을 원하시는 경우에는 전체 취소 후 책가방 화면에서 수강할 강좌를 선택하여 결제하시면 됩니다. <br>
이 과정에서 수강을 원하시는 강좌가 이미 마감되었을 경우, 대기접수만 가능하오니 이점 유념해주시기 바랍니다.</li>
						<li>인터넷으로 신청하신 강좌의 카드결제 취소는 카드사에 따라 처리기간에 다소 차이가 있으며, 최종 취소 승인은 <br>
인터넷 취소 시점에서 10일 후에 확인하실 수 있습니다.</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="edit-popup" id="search_layer">
	<div class="edit-bg"></div> 
	<div class="edit-wrap edit-wrap02">
		<div class="exit" onclick="javascript:$('#search_layer').fadeOut(200);"><img src="/img/exit.png" alt="close" /></div>
		<h3>후기등록</h3>

		<div class="edi-tablewr">
			<div class="lect-chk revi-chk">
				<label><input id="reco_yn" type="checkbox">이 강의를 추천합니다.</label>
			</div>
			<div class="revi-row">
				<p class="revi-tit">강좌후기</p>
				<div class="revi-box">
					<textarea id="content" placeholder="내용을 입력해주세요.(1,000자 이상)"></textarea>
				</div>
			</div>

		</div>

		<div class="btn-center">
			<a class="btn btn01" onclick="javascript:delReview();">삭제</a>
			<a class="btn btn02" onclick="javascript:uptReview();">등록/수정</a>
		</div>
	</div>
</div>


<!-- 부분입금 팝업 끝 -->
<div class="edit-popup" id="payment_layer">
	<div class="edit-bg"></div> 
	<div class="edit-wrap edit-wrap02">
		<div class="exit" onclick="javascript:$('#payment_layer').fadeOut(200);"><img src="/img/exit.png" alt="close" /></div>
		<h3>취소 후 재결제</h3>
		<p class="h3-p">취소할 강좌를 선택해주세요.<br>
		시작일이 경과한 강좌 일 경우 진행한 횟수 만큼 재결제 하셔야 정상 취소처리 됩니다.<br>
		*묶음 결제한 강좌일 경우 취소금액을 제외한 수강료만큼 재결제하시면 전체취소 됩니다. 
		</p>
		
		<table>
			<thead>
				<tr>
					<th></th>
					<th>강좌명</th>
				</tr>
			</thead>
			<tbody id="filter_target">
				
			</tbody>
		</table>

		<div class="btn-center">
			<a class="btn btn01" onclick="javascript:delReview();">삭제</a>
			<a class="btn btn02" onclick="javascript:halfPayment();">결제하기</a>
		</div>
	</div>
</div>
<!-- 부분입금 팝업 끝 -->

<form id="CalForm" name="CalForm" method="post" action="./half_order_end">
	<input type="hidden" name="store" value="<%=number%>"/>
	<input type="hidden" name="tid" id="tid"        value=""/>
	<input type="hidden" id="onList" name="onList"          value=""/>
	<input type="hidden" id="offList" name="offList"          value=""/>
	
	<!-- 결제할 금액이 있으면 결제후취소, 없다면 그냥 취소하기위함 -->
	<input type="hidden" id="is_payment" name="is_payment"          value=""/>
     <!-- ★☆  추가  결제 준비 필수 값-->     
     <input type="hidden" name="req_tx"          value="pay"/>
     <input type="hidden" name="site_name"       value="<%= g_conf_site_name %>"/>
     <input type="hidden" name="site_cd"         value="<%= g_conf_site_cd	%>"/>
     <input type="hidden" name="site_cd_normal"  value="<%= g_conf_site_cd %>"/>
     <input type="hidden" name="site_cd_ak"      value="<%= g_conf_site_cd_ak %>"/>
     <input type="hidden" name="site_key"        value="<%= g_conf_site_key %>"/>
     <input type="hidden" name="site_key_normal"  value="<%= g_conf_site_key %>"/>
     <input type="hidden" name="site_key_ak"      value="<%= g_conf_site_key_ak %>"/>
     <input type="hidden" name="dRegiAmt" id="dRegiAmt" value=""/>
    <input type="hidden" name="dFoodAmt" id="dFoodAmt" value=""/>
    <input type="hidden" name="dTotAmt" id="dTotAmt" value=""/>
    <input type="hidden" name="tot_subject_cd"  id="tot_subject_cd" value=""/>
     <input type="hidden" name="akmem_card_status" value="<%=AKmemCardStatus%>" /><!--akmembers 카드상태(정상카드이면 00)-->
     <input type="hidden" name="ordr_idxx"       value=""/>
     <input type="hidden" name="pay_method"      value="100000000000"/>
     <input type="hidden" name="good_name"       value="문화아카데미 강좌결제"/>
     <input type="hidden" name="good_mny"   id="good_mny"     value="" maxlength="9"/>
     <input type="hidden" name="currency"        value="WON"/>
     <input type="hidden" name="quotaopt"        value="12"/>
     <input type="hidden" name="shop_user_id"    value=""/>
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
     
     
</form>

<iframe id="calFrame" name="calFrame"></iframe>

<jsp:include page="/inc/footer.jsp" />


<script>
// StartSmartUpdate();
// setTimeout("jsf__chk_plugin()","1000");
init_orderid();
</script>