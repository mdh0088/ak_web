<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/WEB-INF/pages/web/common/lnb02.jsp" />
<script src="/inc/js/function.js"></script>
<script>


window.onload = function(){
	getList();
	$("#canc_target").html(nullChk('${canc_contents}'));
}

// function goBookBag(store,subject_cd,main_cd,sect_cd,sect_nm){
	
// 	var pageUrlFlag = "${pageUrlFlag}";
	
// 	if (pageUrlFlag == "S-LyPop") {
// 		alert('기존회원입니다.');	
// 	}else{
// 		$.ajax({
// 			type : "POST", 
// 			url : "./goBookBag",
// 			dataType : "text",
// 			async : false,
// 			data : 
// 			{
// 				store : store,
// 				//period : period,
// 				subject_cd : subject_cd,
// 				main_cd:main_cd,
// 				sect_cd:sect_cd,
// 				sect_nm:sect_nm
// 			},
// 			error : function() 
// 			{
// 				console.log("AJAX ERROR");
// 			},
// 			success : function(data) 
// 			{
// 				console.log(data);
// 				var result = JSON.parse(data);
// 				retval = result.ajaxResultCd;
				
// 				if(retval.indexOf("OK::") > -1)
// 				{
// 					var resultCd = retval.split("::");
// 					if(resultCd[1] == "01"){
						
// 						if(confirm("수강자 선택 후 책가방 담기가 가능합니다.\n\n수강자를 선택 하시겠습니까?")){
// 							//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);
// 							location.href="/academy/academy06";	
// 						}
						
// 					}else if(resultCd[1] == "02"){
						
// 						if(confirm("해당강좌와 수강자-지점이 일치하지 않습니다.\n\n변경하시겠습니까?")){ 
// 							//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);
// 							location.href="/academy/academy06";	
// 						}
						
// 					}else if(resultCd[1] == "11"){
// 							alert("수강신청 기간이 아닙니다. \n\n기존 회원 수강 기간은 "+result.sAdult_s_bgndate+" 10시 30분~");	
							
// 					}else if(resultCd[1] == "12"){
// 							alert("기존회원 재수강 기간입니다.\n\n신규 회원 수강 기간은 "+result.sAdult_f_bgndate+" 10시 30분~");	
							
// 					}
// 					else if(resultCd[1] == "13"){
// 						if(confirm("님은 자녀강좌를 신청할 수 없습니다. \n\n자녀강좌는 자녀회원등록 후 자녀를 수강자로 선택하신 후 등록하십시오.\n\n수강자 변경을 하시겠습니까?")){
// 							//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);	
// 							location.href="/academy/academy06";	
// 						}
						
// 					}else if(resultCd[1] == "14"){
// 						 if(confirm("님은 성인 강좌를 신청할수 없습니다.")){
// 						 	//location.href="/cult/mypagejoin.do?method=list&hq=00&store="+store+"&menu_num=3_3&rurl="+escape(location);
// 							 location.href="/academy/academy06";	
// 						 }
// 					}else if(resultCd[1] == "21"){
// 						alert("이미 결제완료된 강좌입니다.");
// 					}else if(resultCd[1] == "22"){
// 						alert("이미 책가방에 담긴 강좌입니다.");
// 					}else if(resultCd[1] == "23"){
// 						alert("정원이 마감된 강좌입니다.");
// 					}else if(resultCd[1] == "24"){
// 						alert("책가방 담기에 실패하였습니다.");
// 					}else{
// 						if(confirm("책가방에 담겼습니다.\n\n나의 책가방으로 이동하시겠습니까?")){
// 							//location.href="/cult/lecture.do?method=templist&number=03&menu_num=3_4&hq=00&store="+store;
// 							location.href="/academy/academy04";	
// 						}
// 					}
// 				}else{
// 					if(retval.indexOf("FAIL::") > -1){
// 						alert("로그인 후 책가방에 담아 주세요.");
// 						//culture.global.goLogInForm();
// 						location.href="/user/login";	
// 					}
// 				}
	
// 			}
// 		});	
// 	}
// }

function goWaitAdd(store,subject_cd,main_cd,sect_cd,sect_nm){
	
	if(!confirm("대기회원으로 등록하시겠습니까?\n대기회원등록은 1인 5강좌까지 등록 가능합니다."))
		return;
	
	$.ajax({
		type : "POST", 
		url : "./goWaitAdd",
		dataType : "text",
		async : false,
		data : 
		{
			store : store,
			period : period,
			subject_cd : subject_cd,
			main_cd:main_cd,
			sect_cd:sect_cd,
			sect_nm:sect_nm
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
					alert("이미 결제완료된 강좌입니다.\n\n다른 수강자로 신청하시려면 자녀회원 등록에서 수강자 변경 바랍니다.");
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


function toBRString(str){
	var value ="";
	var dest ="";
	
	for (var i = 0; i < (str.length-1); i++) {
		if (str.charAt(i) ==' ') {
			dest.append("&nbsp;");
		}else if (str.charAt(i) == '\n') {
			dest.append("<br/>");
		}else{
			dest.append(str.charAt(i));
		}
		
	}	
}


function getList(type) 
{
	$.ajax({
		type : "POST", 
		url : "./getReviewList",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			sort_type : sort_type,
			listSize : '9',
			
			
			store : "${lecture.STORE}",
			period : "${lecture.PERIOD}",
			subject_cd : "${lecture.SUBJECT_CD}"
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
			$("#reviewCnt").html(result.list.length);
			if(result.list.length > 0)
			{
				for(var i = 0; i < result.list.length; i++)
				{
					var content = repWord(nullChk(result.list[i].CONTENT));
					if(content.length > 20)
					{
						content = content.substring(0,20)+"..";
					}
					inner +='<tr onclick="viewReview(\''+encodeURI(JSON.stringify(result.list[i]))+'\')">';
					inner +='	<td>'+(i+1)+'</td>';
					inner +='	<td>'+content+'</td>';
					inner +='	<td>'+result.list[i].KOR_NM+'</td>';
					inner +='	<td>'+result.list[i].CREATE_DATE+'</td>';
					inner +='	<td>'+nullChkZero(result.list[i].VIEWS)+'</td>';
					inner +='</tr>';
					
				}
			}
			else
			{
				inner +='<tr>';
				inner += '	<td colspan="5">등록된 후기가 없습니다.</td>';
				inner +='</tr>';
			}
			
			sort_type = result.sort_type;
			listSize = result.listSize;

			$("#list_target").html(inner);
		
			
			$(".paging").html(makePaging(result.page, result.s_page, result.e_page, result.pageNum, 1));
			
		}
	});			
}
function viewReview(ret)
{
	$("#review_layer").fadeIn(200);
	var result = JSON.parse(decodeURI(ret));
	
	$("#review_content").val(repWord(nullChk(result.CONTENT)));
	
	//조회수업데이트
	$.ajax({
		type : "POST", 
		url : "./upReviewViews",
		dataType : "text",
		data : 
		{
			store : "${lecture.STORE}",
			period : "${lecture.PERIOD}",
			subject_cd : "${lecture.SUBJECT_CD}",
			cust_no : result.CUST_NO
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			getList();
		}
	});		
}



</script>
<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<div class="cour-detail">
			<div class="code-titwr">
			
				<p class="code-tit">
					<em class="color-g">Course Informations</em>
					<span id="lect_nm">${lecture.SUBJECT_NM}</span> 
					<strong class="code-titr">
						<span id="lect_schedule">${fn:substring(lecture.START_YMD, 4,6)}/${fn:substring(lecture.START_YMD, 6,8)} - ${fn:substring(lecture.END_YMD, 4,6)}/${fn:substring(lecture.END_YMD, 6,8)}</span>
						<span id="lect_cnt">${lecture.LECT_CNT}회</span>
					</strong>				
				</p>
			</div>
			
			<div class="cour-detop table">
				<div class="court-img">
					<img src="${image_dir}wlect/${lecture.THUMBNAIL_IMG}" alt="수강신청 상세" style="width:250px; height:333px;"/>
				</div>
				<div>
					<table class="table01">
						<tbody>
							<tr>
								<th>지점</th>
								<td>${lecture.STORE_NM}</td>
								<th>강의시간</th>
								<td>${lecture.DAY} (${lecture.LECT_HOUR})</td>
							</tr>
							<tr>
								<th>수강대상</th>
								<td>${lecture.MAIN_NM}</td>
								<th>강좌분야</th>
								<td>${lecture.SECT_NM}</td>
							</tr>
							<tr>
								<th>수강료</th>
								<td><fmt:formatNumber value="${lecture.REGIS_FEE}" pattern="#,###"/>원</td>
								<th>재료비(1인 1회)</th>
								<td><fmt:formatNumber value="${lecture.FOOD_AMT}" pattern="#,###"/>원</td>
							</tr>	
						</tbody>
					</table>
				</div>
			</div>

			<div class="cour-debot tab">
				<div class="order-type">
					<ul class="tab-ul">
						<li>강좌소개</li>
						<li class="active">강좌 상세정보</li>
						<li>수강후기(<span id="reviewCnt"></span>)</li>
						<li>취소/환불규정</li>
					</ul>
				</div>
				<div class="tab-cont">
					<div>
						${lecture.LECTURE_CONTENT}<br>
						<img src="${image_dir}wlect/${lecture.DETAIL_IMG}" alt="수강신청 상세" onerror="this.src='/img/noimg_lect.png'" />
					</div>
					<div class="active">
						<table class="table01">
							<tbody>
								<tr>
									<th>강사명</th>
									<td id="lecturer_nm">${lecture.LECTURER_NM}</td>
								</tr>
								<tr>
									<th>강의개요</th>
									<% pageContext.setAttribute("newLineChar", "\n"); %>
									<td id="lect_info">${fn:replace(fn:replace(fn:replace(fn:replace({lecture.LECTURE_CONTENT}, newLineChar, '<br/>'),' ','&nbsp;'), '[', ''), ']', '')}</td>
								</tr>
								<tr>
									<th>커리큘럼</th>
									<td>
										<div id="lect_info_area">
										${fn:replace(fn:replace(fn:replace(fn:replace({lecture.ETC}, newLineChar, '<br/>'),' ','&nbsp;'), '[', ''), ']', '')}
										</div>
									</td>
								</tr>
<!-- 								<tr> -->
<!-- 									<th>유의사항</th> -->
<!-- 									<td> -->
<%-- 										<p id="lect_warning">＊ 재료비 회당${lecture.FOOD_AMT}원</p> --%>
<!-- 										<ul class="line-ul"> -->
<!-- 											<li>선착순 사전접수</li> -->
<!-- 											<li>강좌는 수업 1일 전까지 취소 가능합니다.(당일 취소불가) <br> -->
<!-- 		     									 단, 재료 준비 강좌의 경우 개강 3일 전까지만 강의 취소/변경 가능합니다. </li> -->
<!-- 											<li>다중 결제 시 부분 취소가 어려울 수 있습니다. <br> -->
<!-- 		   										(날짜가 지난 강좌가 포함된 다중 결제 취소건은 내방해주셔야 환불 가능합니다.)</li> -->
<!-- 											<li>수강 신청 인원 미달 시 폐강될 수 있으니 양해 바랍니다.</li> -->
<!-- 											<li>유선상으로 접수/취소 불가능합니다. </li> -->
<!-- 										</ul> -->
<!-- 									</td> -->
<!-- 								</tr> -->
							</tbody>
						</table>
					</div>
					<div>
						<div class="colist-wr">
							<table>
								<thead>
									<tr>
										<th>No.</th>
										<th>제목</th>
										<th>작성자</th>
										<th>작성일</th>
										<th>조회</th>
									</tr>
								</thead>
								<tbody id="list_target">
									<tr>
										<td>1</td>
										<td>완강이 코 앞이네요. 한달동안 수업들으면서 차근차근 따라가보니 음식금손이 되었어용</td>
										<td>김길동</td>
										<td>2020.06.20</td>
										<td>100</td>
									</tr>
									<tr>
										<td>2</td>
										<td>완강이 코 앞이네요. 한달동안 수업들으면서 차근차근 따라가보니 음식금손이 되었어용</td>
										<td>김길동</td>
										<td>2020.06.20</td>
										<td>100</td>
									</tr>
									<tr>
										<td>3</td>
										<td>완강이 코 앞이네요. 한달동안 수업들으면서 차근차근 따라가보니 음식금손이 되었어용</td>
										<td>김길동</td>
										<td>2020.06.20</td>
										<td>100</td>
									</tr>
								</tbody>
							</table>
							
						</div>
						<!--  
						<div class="pagination-wr">
							<ul class="paging">
								<li><a href="#" class="paging-prev"><img src="/img/cours-prev.png" alt="이전"></a></li>
								<li><a href="#" class="active">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#" class="paging-next"><img src="/img/cours-next.png" alt="다음"></a></li>
							</ul>
						</div>
						-->
						<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/>
						
						<c:if test="${listenOK ne 0}">
							<div class="btnwr text-right">
								<a class="btn btn03">후기쓰기</a>
							</div>
						</c:if>
						
						
					</div>
					<div>
						<table class="table01">
							<tbody>
								<tr>
									<td><div id="canc_target"></div></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="btn-right">
					<c:choose>
					    <c:when test="${lecture.POSSIBLE_NO eq '0'}">
					       <a class="btn btn02" onclick="goWaitAdd('${lecture.STORE}','${lecture.SUBJECT_CD}','${lecture.MAIN_CD}','${lecture.SECT_CD}','${lecture.SECT_NM}');" >
					   		책가방 담기	<img src="/img/cart-icon.png" alt="책가방아이콘" />
					       </a>
					    </c:when>
					    <c:otherwise>
					    	<a class="btn btn02" onclick="goBookBag('${lecture.STORE}','${lecture.SUBJECT_CD}','${lecture.MAIN_CD}','${lecture.SECT_CD}','${lecture.SECT_NM}');">
							책가방 담기 <img src="/img/cart-icon.png" alt="책가방아이콘"  />
							</a>
					    </c:otherwise>
					</c:choose>			
				
				<a href="/course/list01" class="btn btn05">강좌목록으로<img src="/img/myaca-i04.png" alt="수강자변경 아이콘"></a>	
			</div>
			
		</div>
	</div>
</div>

<div class="edit-popup" id="review_layer" >
	<div class="edit-bg"></div> 
	<div class="edit-wrap edit-wrap02">
		<div class="exit" onclick="javascript:$('#review_layer').fadeOut(200);"><img src="/img/exit.png" alt="close" /></div>
		<h3>수강 후기</h3>	
		<div class="bag-popwr">
			<textarea id="review_content" readonly></textarea>
		</div>
		<div class="btn-center">
			<a class="btn btn02" onclick="javascript:$('#review_layer').fadeOut(200);">닫기</a>
		</div>
	</div>
</div>

<jsp:include page="/inc/footer.jsp" />
