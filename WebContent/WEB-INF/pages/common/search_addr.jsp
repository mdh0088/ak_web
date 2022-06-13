<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//String sec = request.getParameter("sec");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>문화아카데미 주소 검색</title>
		<style type="text/css">
			html{overflow-x: hidden; overflow-y: hidden;}
		</style>
		<link rel="stylesheet" type="text/css" href="/css/juso.css" />
		<script src="/inc/js/juso_jquery-1.9.1.min.js"></script>
		<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	</head>
	<body style="overflow: hidden;">
		<%--<input type="hidden" id="sec" name="sec" value="<%=sec %>" />--%>
		<div class="popWindow">
			<div id="newAddr"></div>
			<div  class="addrlink_wrap" id="addrlink">
				<div class="newaddr_go">희망하는 주소를 찾지 못하셨다면<br/>행정안전부 검색화면으로
 					<a href="#" onclick="jusoInit();"><strong>이동을 눌러주세요</strong></a>
 				</div>
			</div>
			<div id="jusoArea" class="popBody addrFindBj popSize01 center" style="display:none;">
				<form id = "jusoFrm" name = "jusoFrm" method = "post" >
					<fieldset>
						<legend>도로명 주소 정보입력</legend>
						<div class="section">
							<div class="search_wrap">
								<span class="ip_wrap">
									<input type="text" id="kw" name="kw" placeholder="예) 황새울로 326" class="ip_s09" onkeydown="if(event.keyCode === 13){ getAddr(); return false; }" />
								</span>
								<span class="btnType01 btn_search2" >
									<input type="button" value="검색" title="검색" onclick="getAddr();" />
								</span>
							</div>
						</div>
						<p class="sh_total" id = "jusoTotalDesc"></p>
						<!--검색방법안내-->
						<div class="section" id="step1" style="display:block;">
							<h2 class="p_stit02" style="font-size: 20px;">tip</h2>
							
							<div class="p_stit09">아래와 같은 조합으로 검색을 하시면 더욱 정확한 결과가 검색됩니다.</div>
							<ul class="p_noti">
								<li>- 도로명 +건물번호 : <span class="c_blue">   예) 황새울로 326</span></li>
								<li>- 건물명 : <span class="c_blue">   예) 서현빌딩</span></li>
								<li>- 지번 : <span class="c_blue">   예) 서현동 270-1</span></li>
							</ul>
						</div>
						<!--//검색방법안내-->   
						<!--결과리스트-->
						<div class="address_list">
							<div id="jusoresult"></div>
							<!-- paging -->
							<div class="contentAjax">
								<div class="paging" id="jusoPaging"></div>
							</div>
						</div>
						<!--//결과리스트-->
						<input type="hidden" name="keyword"      value="" id="keyword"/>
						<input type="hidden" name="confmKey"     value="U01TX0FVVEgyMDE5MDYyNjA5NTcxMTEwODgzNTU=" id="confmKey"/>
						<input type="hidden" name="currentPage"  value="1" id="currentPage"/>
						<input type="hidden" name="countPerPage" value="10" id="countPerPage"/>
						<input type="hidden" name="resultType"   value="json" id="resultType"/>
					</fieldset>
				</form>
			</div>
		</div>
		<script type="text/javascript">
		//var sec = document.getElementById('sec').value;
		
		var daumView = $('#newAddr', '#addrlink')
		   ,daumInit = function() {
		   		daumView.show();
		   		$('#jusoArea').hide();
		   }	
			   
		var juso_list = $('.jusoresult, .sh_total, .paging2')
		   ,jusoInit = function() { 
		   		daumView.hide();
		   		$('#jusoArea').show();
				juso_list.hide();
				window.resizeTo(480, 623);
			}
		   ,jusoListShow = function(){
				juso_list.show();
		    };
		    
			daumInit();
			
		$(document).ready(function(){
			
			if(typeof(daum) != 'undefined'){
				try{
					var element_wrap = document.getElementById('newAddr');
					daum.postcode.load(function(){
					    new daum.Postcode({
					    	height : '475px',
					    	width : '464px',
					        oncomplete: function(data) {
					        	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
								
								var zonecode = data.zonecode;
								var postCode1 = zonecode.substring(0,3);
								var postCode2 = zonecode.substring(3, zonecode.length);
								var address1 = "";
								var home_new_addr_yn = "";
								var home_areaCd = "";
								var home_bdCd = "";
								
								if(data.userSelectedType == 'J') {
									address1 = data.jibunAddress;
									home_new_addr_yn = '1'
								} else if(data.userSelectedType == 'R') {
									address1 = data.roadAddress;	
									home_new_addr_yn = '2'
								} else {
									alert("주소를 다시 검색해 주세요.");
									return;
								}
								
								home_areaCd = data.bcode;
								home_bdCd = data.buildingCode;

								var guideTextBox = opener.document.getElementById("home_guide");
								// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
								if(data.autoRoadAddress) {
									var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
									guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
									guideTextBox.style.display = 'block';

								} else if(data.autoJibunAddress) {
									var expJibunAddr = data.autoJibunAddress;
									guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
									guideTextBox.style.display = 'block';
								} else {
									guideTextBox.innerHTML = '';
									guideTextBox.style.display = 'none';
								}
								
								setAddr(zonecode, address1, home_new_addr_yn);
					        }
					       
					    }).embed(element_wrap, {autoClose: false});
					});
				}catch(e){
					console.log(e);
				}	
			}else{
				window.onload = function(){
					jusoInit();
				}
			}
		});
		
		function gojuso() {
			$.ajax({
				 url : '/popup/getJusoApiKey.do',
				 type : 'post',
				 async : true,
				 cache : false,
				 dataType : 'json',
				 success : function(data) {
					if ( data.errorCode == "0" ){
						$("#confmKey").val(data.jusoApiKey);
	
					}else{
						alert('고객님 죄송합니다.\n현재 이용이 불가합니다.'); return false;
					}
				},
				error : function(response) {
			    	alert("일시적으로 서비스가 지연되고 있습니다.\n잠시후에 다시 시도해주세요."); return false;
			    }
			});
		}
		
		function getAddr(){
			$('input[name="kw"]').val($('input[name="kw"]').val().trim());
			if ( checkSearchedWord(document.jusoFrm.kw) == true ){
				$('input[name="keyword"]').val($('input[name="kw"]').val());
				$('input[name="currentPage"]').val("1");
				callJusoApi();
			} else {
	    		return;
	    	}
		}
	
		
		function paging(page){
			$('input[name="currentPage"]').val(page);
			callJusoApi();
		}
	
		function callJusoApi() {
			var descHtml = '<p style="font-weight:bold;">검색결과가 많습니다.</p>'+
			'<p>아래와 같은 조합으로 검색을 하시면 더욱 정확한 결과가 검색됩니다.</p>'+
			'<p>- 도로명 +건물번호 : <span class="c_blue">   예) 황새울로 326</span></p>'+
			'<p>- 건물명 : <span class="c_blue">   예) 서현빌딩</span></p>'+
			'<p>- 지번 : <span class="c_blue">   예) 서현동 270-1</span></p>';
			$.ajax({
				 url :"https://www.juso.go.kr/addrlink/addrLinkApiJsonp.do"
				,type:"post"
				,data:$("#jusoFrm").serialize()
				,dataType:"jsonp"
				,crossDomain:true
				,cache:false
				,success:function(jsonStr){
					var errCode = jsonStr.results.common.errorCode;
					var errDesc = jsonStr.results.common.errorMessage;
					var totalCnt = jsonStr.results.common.totalCount;
					if(errCode != "0"){
						console.log(errCode+"="+errDesc);
					}else{
						$('#jusoTotalDesc').html('');
						$('#jusoTotalDesc').css({'border-bottom':'', 'padding-top':'', 'padding-bottom':''});
						if(jsonStr != null && totalCnt > 10){
							$('#jusoTotalDesc').html(descHtml);
							$('#jusoTotalDesc').css({'border-bottom':'1px solid #ebebeb', 'padding-top':'10px', 'padding-bottom':'10px'});
							makeListJson(jsonStr);
							$('#step1').hide();
						}else if(jsonStr != null && totalCnt > 0){
							makeListJson(jsonStr);
							$('#step1').hide();
						}else{
							jusoInit();
							if(totalCnt == 0){
								alert('검색결과가 없습니다.\n검색어 예시를 다시 확인해주세요.');
							}
						}
					}
					$('input[name="kw"]').val($('input[name="keyword"]').val());
					
				}
			    ,error: function(xhr,status,error){
			    	alert("일시적으로 서비스가 지연되고 있습니다.\n잠시후에 다시 시도해주세요."); return false;
			    }
			});
	    }
		
		function makeListJson(jsonStr){
			var htmlStr = "";
			
			$(jsonStr.results.juso).each(function(){
				htmlStr += "<dl style=\"cursor: pointer;\" onclick=\"setAddr('"+this.zipNo+"','"+this.roadAddrPart1+"','2');return false;\">";
				htmlStr += "<dt>"+this.zipNo+"</dt>";
				htmlStr += 		"<dd>";
	 			htmlStr += 	  	"<li><span>도로명</span>"+this.roadAddr+"</li>";
	 			htmlStr += 	  	"<li><span>지번</span>"+this.jibunAddr+"</li>";
	 			htmlStr += 		"</dd>";
				htmlStr += "</dl>";
			});

			$("#jusoresult").html(htmlStr);
			
			if(Number(jsonStr.results.common.totalCount) > 10){
				var pagingHtml = "";
				var total_count = Number(jsonStr.results.common.totalCount); if(total_count == ""){ total_count = 0; }
				var rowsPerPage = 10;
				var pageSize = 5;
				var currentPage = Number($('input[name="currentPage"]').val()); if(1 > currentPage){ currentPage = 1; }
				var pageRemain = Math.floor(total_count % (rowsPerPage * pageSize)); if(pageRemain > 0){ pageRemain = 1; }
				var pageGroupNumber = Math.floor(currentPage / pageSize + 1); if(currentPage % pageSize == 0) { pageGroupNumber = pageGroupNumber - 1 }
				var pageCount = Math.floor(total_count / rowsPerPage); if((total_count % rowsPerPage) > 0){ pageCount = pageCount + 1; }
				var startPage = (pageSize * (pageGroupNumber - 1 )) + 1;
				var endPage = startPage + pageSize - 1; if(endPage > pageCount) { endPage = pageCount; }
				
				
				
				if (currentPage == 1){
					pagingHtml += "<a class='btn fstPage' onclick='javascript:;' onclick='return fasle;'>처음</a>";
				}else{
					pagingHtml += "<a class='btn fstPage' onclick='javascript:;' onclick='paging(1);'>처음</a>";
				}
				
				var preIndex = currentPage - 1;
				if(currentPage == 1){
					pagingHtml += "<a class='btn prevPage' onclick='javascript:;' onclick='return false;'>이전</a>";
				}else{
					pagingHtml += "<a class='btn prevPage' onclick='javascript:;' onclick='paging("+preIndex+")'>이전</a>";
				}
		
				pagingHtml += "<span class='pagenum'>";
				for (var index=startPage; endPage>=index; index++) {
					 
					if( currentPage == index ){ 
						pagingHtml += "<a href='#none' class='active' onclick='return false;'>"+index+"</a>";
					}else{
						pagingHtml += "<a onclick='javascript:;' onclick='paging("+index+")' >"+index+"</a>";
						
					}
				}
				pagingHtml += "</span>";
				
				
				var nextIndex = currentPage + 1;
				if(pageCount > currentPage){
					pagingHtml += "<a class='btn nextPage' onclick='javascript:;' onclick='paging(";
					if(currentPage > pageCount){ 
						pagingHtml += ""+pageCount; 
					}else{ 
						pagingHtml += ""+nextIndex; 
					} 
					pagingHtml += ")'>다음</a>";
				}
				
				if(pageCount > currentPage){
					pagingHtml += "<a class='btn lstPage' onclick='javascript:;' onclick='paging("+pageCount+")'>마지막</a>";
				}
				
				$('#jusoPaging').html(pagingHtml);
			}
			jusoListShow();
		}
		
		function checkSearchedWord(obj){
			if(obj.value.length >0){
							var expText = /[%=><]/ ; 			if(expText.test(obj.value) == true){ 
					alert("특수문자를 입력 할수 없습니다.") ;
					obj.value = obj.value.split(expText).join(""); 
					return false;
				}
				
							var sqlArray = new Array("OR", "SELECT", "INSERT", "DELETE", "UPDATE", "CREATE", "DROP", "EXEC",
		             		 "UNION",  "FETCH", "DECLARE", "TRUNCATE" 
				);
				
				var regex ;
				var regex_plus ;
				for(var i=0; i<sqlArray.length; i++){ 				regex = new RegExp("\\s" + sqlArray[i] + "\\s","gi") ;
					if (regex.test(obj.value)) {
					    alert("\"" + sqlArray[i]+"\"와(과) 같은 특정문자로 검색할 수 없습니다.");
						obj.value =obj.value.replace(regex, "");
						return false;
					}
					
					regex_plus = new RegExp( "\\+" + sqlArray[i] + "\\+","gi") ;
					if (regex_plus.test(obj.value)) {
					    alert("\"" + sqlArray[i]+"\"와(과) 같은 특정문자로 검색할 수 없습니다.");
						obj.value =obj.value.replace(regex_plus, "");
						return false;
					}
				}
			}
			return true ;
		}
		
		function setAddr(postCode, address1, new_addr_yn){
			
			var postCode1 = "";
			var postCode2 = "";
			
			if(postCode.length > 0) {
				postCode1 = postCode.substring(0,3);
				postCode2 = postCode.substring(3, postCode.length);
			}
			
			/*if(sec == "home") {
				opener.document.getElementById("postCode1").value = postCode1;
				opener.document.getElementById("postCode2").value = postCode2;
				opener.document.getElementById("address1").value = address1;
				opener.document.getElementById("home_new_addr_yn").value = new_addr_yn;
				opener.document.getElementById("home_areaCd").value = areaCd;
				opener.document.getElementById("home_bdCd").value = bdCd;
				opener.document.getElementById("address2").value = '';
				opener.document.getElementById("address2").focus();
			} else if(sec == "company") {
				opener.document.getElementById("companyPostCode1").value = postCode1;
				opener.document.getElementById("companyPostCode2").value = postCode2;
				opener.document.getElementById("companyAddress1").value = address1;
				opener.document.getElementById("off_new_addr_yn").value = new_addr_yn;
				opener.document.getElementById("company_areaCd").value = areaCd;
				opener.document.getElementById("company_bdCd").value = bdCd;
				opener.document.getElementById("companyAddress2").value = '';
				opener.document.getElementById("companyAddress2").focus();
			}*/
			
			opener.document.getElementById("postcode1").value = postCode1;
			opener.document.getElementById("postcode2").value = postCode2;
			opener.document.getElementById("address1").value = address1;
			opener.document.getElementById("h_new_addr_yn").value = new_addr_yn;
			opener.document.getElementById("address2").value = '';
			opener.document.getElementById("address2").focus();
			
	        self.close();
	    }
		
		$(window).load(function() {
			window.resizeTo(480, 623);
		});
	</script>
	</body>
</html>
