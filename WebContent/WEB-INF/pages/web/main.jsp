<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<script src="/inc/js/TweenMax.min.js"></script>
<script src="/inc/js/smooth-scrollbar.js"></script>
<script src="/inc/js/ScrollMagic.js"></script>
<script src="/inc/js/animation.gsap.js"></script>
<script src="/inc/js/function.js"></script>
<!--<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.2/TimelineMax.min.js"></script>-->

<!-- 뮤자인 -->

<link rel="stylesheet" href="/css/main_in.css">
<script src="/inc/js/main.js"></script>


<script>
$(document).ready(function(){
	getList('');
	getMain();
	
	$("#yoil_all").change(function() {
		if($("input:checkbox[name='yoil_all']").is(":checked"))
		{
			$("input:checkbox[name='yoil_mon']").prop("checked", true);
			$("input:checkbox[name='yoil_tue']").prop("checked", true);
			$("input:checkbox[name='yoil_wed']").prop("checked", true);
			$("input:checkbox[name='yoil_thu']").prop("checked", true);
			$("input:checkbox[name='yoil_fri']").prop("checked", true);
			$("input:checkbox[name='yoil_sat']").prop("checked", true);
			$("input:checkbox[name='yoil_sun']").prop("checked", true);
			
		}
		else
		{
			$("input:checkbox[name='yoil_mon']").prop("checked", false);
			$("input:checkbox[name='yoil_tue']").prop("checked", false);
			$("input:checkbox[name='yoil_wed']").prop("checked", false);
			$("input:checkbox[name='yoil_thu']").prop("checked", false);
			$("input:checkbox[name='yoil_fri']").prop("checked", false);
			$("input:checkbox[name='yoil_sat']").prop("checked", false);
			$("input:checkbox[name='yoil_sun']").prop("checked", false);
		}
	});
	$("#subject_fg_all").change(function() {
		if($("input:checkbox[name='subject_fg_all']").is(":checked"))
		{
			$("input:checkbox[name='subject_fg_1']").prop("checked", true);
			$("input:checkbox[name='subject_fg_2']").prop("checked", true);
			$("input:checkbox[name='subject_fg_3']").prop("checked", true);
			
		}
		else
		{
			$("input:checkbox[name='subject_fg_1']").prop("checked", false);
			$("input:checkbox[name='subject_fg_2']").prop("checked", false);
			$("input:checkbox[name='subject_fg_3']").prop("checked", false);
		}
	});
	sectInit();
})
function sectInit()
{
	$("#sect_all").change(function() {
		if($("input:checkbox[name='sect_all']").is(":checked"))
		{
			$("input:checkbox[name='sect']").prop("checked", true);
		}
		else
		{
			$("input:checkbox[name='sect']").prop("checked", false);
		}
	});
}
function getList(tag) 
{
	$("li").removeClass("active");
	$("#li_"+tag).addClass("active");
	$.ajax({
		type : "POST", 
		url : "/academy/getRecoList",
		dataType : "text",
		async : false,
		data : 
		{
			page : 1,
			tag : tag,
			listSize : '9999'
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
			if(result.list.length > 0)
			{
				for(var i = 0; i < result.list.length; i++)
				{
					inner += '<div class="rec-box swiper-slide" onclick="location.href=\'/course/detail?store='+result.list[i].STORE+'&main_cd='+result.list[i].MAIN_CD+'&sSubject_cd='+result.list[i].SUBJECT_CD+'\'" style="cursor:pointer;">';
					if (result.list[i].POSSIBLE_NO < 1) {
						inner +='		<div class="qui-cart"><img src="/img/cart-icon2.png" alt="장바구니담기" onclick="goWaitAdd(\''+result.list[i].STORE+'\',\''+result.list[i].SUBJECT_CD+'\',\''+result.list[i].MAIN_CD+'\',\''+result.list[i].SECT_CD+'\')"></div>';
						
					}else{						
						inner +='		<div class="qui-cart"><img src="/img/cart-icon.png" alt="장바구니담기" onclick="goBookBag(\''+result.list[i].STORE+'\',\''+result.list[i].SUBJECT_CD+'\',\''+result.list[i].MAIN_CD+'\',\''+result.list[i].SECT_CD+'\')"></div>';
					}
					inner += '		<P class="rec-data">';
					inner += '			<span class="open">'+result.list[i].START_YMD.substring(4,6)+'.'+result.list[i].START_YMD.substring(6,8)+'</span>';
					inner += '			<span class="close">-'+result.list[i].END_YMD.substring(4,6)+'.'+result.list[i].END_YMD.substring(6,8)+'</span>';
					inner += '			<span class="year">'+result.list[i].START_YMD.substring(0,4)+'</span>';
					inner += '		</p>';
					inner += '	<div class="ani-eff image" >';
					inner += '		<img src="${image_dir}wlect/'+result.list[i].THUMBNAIL+'" alt="이미지" onerror="this.src=\'/img/noimg_lect.png\'" style="width:302px; height:226px;"/>';
					inner += '	</div>';
					inner += '	<p class="rec-stit">'+result.list[i].SECT_NM+'</p>';
					inner += '	<p class="rec-tit">'+result.list[i].SUBJECT_NM+'</p>';
					inner += '	<ul class="rec-ul">';
					inner += '		<li><span>'+result.list[i].STORE_NM+'</span>'+result.list[i].SUBJECT_FG_NM+' '+result.list[i].MAIN_NM+'</li>';
					inner += '		<li><span>'+result.list[i].WEB_LECTURER_NM+'</span>'+cutYoil(result.list[i].DAY_FLAG)+' '+cutLectHour(result.list[i].LECT_HOUR)+'</li>';
					inner += '		<li><span>'+result.list[i].LECT_CNT+'회</span>'+comma(nullChkZero(result.list[i].REGIS_FEE))+'원 (재료비 '+comma(nullChkZero(result.list[i].FOOD_AMT))+'원)</li>';
					inner += '	</ul>';
					inner += '</div>';	
					
				}
			}
			else
			{
			}
			$("#list_target").html(inner);
		}
	});	
}
$(function(){
	var swiper1 = new Swiper('.main-slide', {
		slidesPerView: 1,
		loop: true,
		/*
		autoplay: {
			delay: 10000,
			disableOnInteraction: false,
		},
		*/
		effect: 'fade',
		pagination: {
			el: '.swiper-pagination',
		},
	});
})
$(function(){
	var swiper2 = new Swiper('.rec-bot .swiper-container', {
		slidesPerView: 3,
		scrollbar: {
			el: '.swiper-scrollbar',
			draggable: true,
		},
	});
})

function getMain(){
	$.ajax({
		type : "POST", 
		url : "./getMain",
		dataType : "text",
		async : false,
		data : 
		{
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			var result = JSON.parse(data);
			var inner ="";
			var inner_li ="";

			for (var i = 0; i < result.mainlist.length; i++) {
				inner +='<option value="'+result.mainlist[i].SUB_CODE+'">'+result.mainlist[i].SHORT_NAME+'</option>';
				inner_li += '<li onmouseover="get_sect(\''+result.mainlist[i].SUB_CODE+'\')">'+result.mainlist[i].SHORT_NAME+'</li>';
			}
			$('#main_target').html(inner);
			$('.main_target_ul').html(inner_li);
		}
	});	
}

function get_sect(idx){
	
	$.ajax({
		type : "POST", 
		url : "./getSect",
		dataType : "text",
		async : false,
		data : 
		{
			main_cd : idx
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			var result = JSON.parse(data);
			var inner ="";
			var inner_li ="";

			inner +='<li option-data="0"><input type="checkbox" id="sect_all" name="sect_all"/>전체</li>';
			for (var i = 0; i < result.sectlist.length; i++) {
				inner +='<li option-data="'+(i+1)+'"><input type="checkbox" id="sect_'+result.sectlist[i].SECT_CD+'" name="sect"/>'+result.sectlist[i].SECT_NM+'</li>';
// 				inner +='<option value="'+result.sectlist[i].SECT_CD+'">'+result.sectlist[i].SECT_NM+'</option>';
// 				inner_li += '<li>'+result.sectlist[i].SECT_NM+'</li>';
			}
			$('#sub_target').html(inner);
			sectInit();
// 			$('.sub_target_ul').html(inner_li);
		}
	});	
}	
	
function fncSubmit(){
	var chkSect = "";
	$("[name='sect']").each(function() 
	{
		if( $(this).prop("checked")==true )
		{
			chkSect += '\''+$(this).attr("id").replace("sect_", "")+"\',";
		}
	});
	chkSect = chkSect.substring(0, chkSect.length-1);
	$("#selSect").val(chkSect);
	$("#fncForm").submit();
}

function goMBanner(f)
{
	$("#file_nm").val(f);
	$("#fileForm").submit();
}
</script>

<div>
	<form id="fncForm" name="fncForm" method="post" action="/course/list01">
		<input type="hidden" id="selSect" name="selSect">
		<div class="right-line">
			<span class="rline-h"></span>
		</div>
	
		<div class="container main" id="container-scroll">
			<div class="contain">				
				<div class="main-slidewr">
					<div class="main-slide swiper-container">
						<div class="swiper-wrapper">
							<c:forEach var="i" items="${mbList}" varStatus="loop">
								<div class="swiper-slide">
									<div class="slide-cot">
										<span></span>
										<span></span>
										<span></span>
										<span></span>
										<span></span>
									</div>
									<div class="slide-img" onclick="javascript:location.href='${image_dir}main_banner/${i.ATTACH}'" >
										<img src="${image_dir}main_banner/${i.BANNER}" alt="슬라이드이미지" onerror="this.src='/img/noimg.png'" style="width:1066px; height:880px;"/>
									</div>
									<div class="slide-text">
										<h1>${i.MAIN_TITLE}</h1>
										<p class="h1-stit">${i.SUB_TITLE}</p>
										<p>${i.DESCRIPTION }</p>
										<c:if test="${i.IS_BTN_SHOW eq 'Y'}">
											<div class="more-wr">
												<c:if test="${i.CON_TYPE eq 'file'}">
													<a class="more-btn" onclick="goMBanner('${i.ATTACH}')"><span class="line"></span><span class="text">${i.BTN_NM }</span></a>
												</c:if>
												<c:if test="${i.CON_TYPE eq 'url'}">
													<a class="more-btn" href="javascript:location.href='${i.BANNER_LINK}'"><span class="line"></span><span class="text">${i.BTN_NM }</span></a>
												</c:if>
											</div>
										</c:if>
									</div>
								</div>
							</c:forEach>
<!-- 							<div class="swiper-slide"> -->
<!-- 								<div class="slide-cot"> -->
<!-- 									<span></span> -->
<!-- 									<span></span> -->
<!-- 									<span></span> -->
<!-- 									<span></span> -->
<!-- 									<span></span> -->
<!-- 								</div> -->
<!-- 								<div class="slide-img"> -->
<!-- 									<img src="/img/slide-img01-1.png" alt="슬라이드이미지"/> -->
<!-- 								</div> -->
<!-- 								<div class="slide-text"> -->
<!-- 									<h1>Life, Atelier</h1> -->
<!-- 									<p class="h1-stit">어느 봄날의 아틀리에</p> -->
<!-- 									<p>2020년에는 삶이 더욱 풍성해지도록 당신의 삶에 리듬을 더해보세요. <br> -->
<!-- 									생애 가장 젊은 날인 오늘도, <br> -->
<!-- 									AK 문화아카데미가 당신의 리드미컬 라이프를 응원합니다. -->
<!-- 									</p> -->
<!-- 									<div class="more-wr"> -->
<!-- 										<a class="more-btn" href="#"><span class="line"></span><span class="text">VIEW MORE</span></a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
						</div>
						<div class="swiper-pagination"></div>
						<div class="msli-sns">
							<p class="msli-p">Share</p>
							<ul>
								<li><A href="https://www.facebook.com/AKplazaM" target="_blank"><img src="/img/sns-icon02.png" alt="페이스북"></a></li>
								<li><A href="https://twitter.com/AKPlaza_HQ" target="_blank"><img src="/img/sns-icon01.png" alt="트위터"></a></li>
							</ul>
						</div>
					</div>
					<div class="main-search">
						<div class="main-sein">
							<div class="msear-dwr msear-dwr01">
								
								<div class="msear-bar table">
									<div>
										<p class="msear-tit">Step 01</p>
										<div class="search-box">
											<p><b>수강 대상</b>을 선택해주세요.</p>
											<select id="main_target" name="main_target" de-data="가까운 지점을 선택해주세요.">
		
											</select>
										</div>
										<p class="hash-tag">
											<span id="store_nm"></span>
										</p>
									</div>
									<div>
										<p class="msear-tit">Step 02</p>
										<div class="search-box search-box-two">
											<p><b>강좌 분야</b>를 선택해주세요.</p>
											
											<div class="select-box select-box-no">
												<div class="selectedOption sub_target">강좌 유형을 선택해주세요.</div>
												<ul class="sear-ul subject_fg" tabindex="5" id="sub_target">
													
												</ul>
											</div>
											
			
										</div>
										<p class="hash-tag">
											<span id="main_nm"></span>
											<span id="sect_nm"></span>
										</p>
									</div>
									<div class="stepbox03">
										<p class="msear-tit">Step 03</p>
										<div class="search-box disable">
											<p><b>원하는 요일</b>을선택해주세요.</p>
											<div class="select-box select-box-no">
												<div class="selectedOption sub_target">원하는 요일을 선택해주세요.</div>
												<ul class="sear-ul search_yoil_ul" tabindex="4">
													<li option-data=""><input type="checkbox" id="yoil_all" name="yoil_all"/>전체</li>
													<li option-data="1"><input type="checkbox" id="yoil_mon" name="yoil_mon"/>월요일</li>
													<li option-data="2"><input type="checkbox" id="yoil_tue" name="yoil_tue"/>화요일</li>
													<li option-data="3"><input type="checkbox" id="yoil_wed" name="yoil_wed"/>수요일</li>
													<li option-data="4"><input type="checkbox" id="yoil_thu" name="yoil_thu"/>목요일</li>
													<li option-data="5"><input type="checkbox" id="yoil_fri" name="yoil_fri"/>금요일</li>
													<li option-data="6"><input type="checkbox" id="yoil_sat" name="yoil_sat" />토요일</li>
													<li option-data="7"><input type="checkbox" id="yoil_sun" name="yoil_sun" />일요일</li>
												</ul>
											</div>
<!-- 											<select id="search_yoil" name="search_yoil" de-data="원하는 요일을 선택해주세요."> -->
<!-- 												<option value="1"></option> -->
<!-- 												<option value="2">화요일</option> -->
<!-- 												<option value="3">수요일</option> -->
<!-- 												<option value="4">목요일</option> -->
<!-- 												<option value="5">금요일</option> -->
<!-- 												<option value="6">토요일</option> -->
<!-- 												<option value="7">일요일</option> -->
<!-- 												<option value="">ALL</option> -->
<!-- 											</select> -->	 
										</div>
										<p class="hash-tag">
											<span id="yoil_nm"></span>
										</p>
									</div>
									<div class="stepbox03">
										<p class="msear-tit">Step 04</p>
										<div class="search-box disable">
											<p><b>강좌 유형</b>을 선택해주세요.</p>
											<div class="select-box select-box-no">
												<div class="selectedOption sub_target">강좌 유형을 선택해주세요.</div>
												<ul class="sear-ul subject_fg" tabindex="5">
													<li option-data="1"><input type="checkbox" id="subject_fg_all" name="subject_fg_all"/>전체</li>
													<li option-data="2"><input type="checkbox" id="subject_fg_1" name="subject_fg_1"/>정규</li>
													<li option-data="3"><input type="checkbox" id="subject_fg_2" name="subject_fg_2"/>단기</li>
													<li option-data="4"><input type="checkbox" id="subject_fg_3" name="subject_fg_3"/>특강</li>
												</ul>
											</div>
<!-- 											<select id="subject_fg" name="subject_fg" de-data="원하는 요일을 선택해주세요."> -->
<!-- 												<option value="">전체</option> -->
<!-- 												<option value="1">정규</option> -->
<!-- 												<option value="2">단기</option> -->
<!-- 												<option value="3">특강</option> -->
<!-- 											</select> -->
											 
			
										</div>
										<p class="hash-tag">
											<span id="yoil_nm"></span>
										</p>
									</div>
								</div>						
							</div>
							<div class="msear-dwr msear-dwr02">
								<div class="msear-bar table">
									<div class="msear-div05">
										<div class="search-box">
											<p><b>강좌명/강사명/유아 개월</b>을 검색해주세요.</p>
											<div class="input-sear">
												<input type="text" id="search_val" name="search_val" placeholder="#봄 제철재료 브런치 플래터" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="search-btn" onclick="fncSubmit();">
							SEARCH
						</div>	
					</div>
				</div>
				<!-- main-sec01 -->
				<div class="main-sec main-sec01">
					<div class="quick-mn mu-grid ani-eff text">
						<div>
							<a class="quick-href" href="/academy/catalog"></a>
							<img src="/img/quick-i01.png" alt="ak문화아카데미 버튼이미지"/>
							<h4>E-카탈로그</h4>
							<p>한 눈에 보는 다양한 강좌정보</p>
						</div>
						<div>
							<a class="quick-href" href="/course/course01"></a>
							<img src="/img/quick-i02.png" alt="ak문화아카데미 버튼이미지"/>
							<h4>수강신청</h4>
							<p>원하는 수업 바로 신청하기</p>
						</div>
						<div>
							<a class="quick-href" href="/academy/academy04"></a>
							<img src="/img/quick-i03.png" alt="ak문화아카데미 버튼이미지"/>
							<h4>나의 책가방</h4>
							<p>내가 관심 있었던 강좌 확인하기</p>
						</div>
						<div>
							<a class="quick-href" href="/academy/store01"></a>
							<img src="/img/quick-i04.png" alt="ak문화아카데미 버튼이미지"/>
							<h4>지점안내</h4>
							<p>한 눈에 보는 <br>AK 문화아카데미 지점 </p>
						</div>
						<div>
							<a class="quick-href" href="/academy/lector01"></a>
							<img src="/img/quick-i05.png" alt="ak문화아카데미 버튼이미지"/>
							<h4>강사지원</h4>
							<p>열정 가득 실력있는 강사님 모집</p>
						</div>
					</div>
				</div>
				<!-- //main-sec01 -->
	
				<!-- main-sec02 -->
				<div class="main-sec main-sec02 ani-eff text">
					<div class="rec-top mu-grid">
						<div class="rec-tabwr">
							<h1 class="en-txt eff-t">Recomendation</h1>
							<ul class="rec-tab">
								<c:forEach items="${fn:split(tagList, ',') }" var="item">
									<li id="li_${item}"><a onclick="javascript:getList('${item}');">#${item}</a></li>
								</c:forEach>
							</ul>
							<a class="more-btn" href="/academy/recommend"><span class="line"></span><span class="text">VIEW MORE</span></a>
						</div>
					</div>
					<div class="rec-bot">
						<div class="swiper-container">
							<div class="swiper-scrollbar"></div>
							<div class="swiper-wrapper" id="list_target">
								<!-- rec-box -->
								<!-- //rec-box -->
							</div>
						</div>
					</div>
				</div>
				<!-- //main-sec02 -->
	
				<!-- main-sec03 -->
				<div class="main-sec03 ani-eff text">
					<div class="eve-txtwr">
						<p class="eve-ban"><span class="en-txt">${sbList[0].BANNER_NAME}</span></p>
						<p>${sbList[0].BANNER_DESC}</p>
					</div>
					<div class="ani-eff image">
						<c:if test="${sbList[0].BANNER_POP eq 'now'}">
							<img src="${image_dir}sub_banner/${sbList[0].BANNER}" alt="혜택배너" onerror="this.src='/img/noimg.png'" onclick="javascript:location.href='${image_dir}sub_banner/${sbList[0].DETAIL}'" style="width:1284px; height:238px;"/>
						</c:if>
						<c:if test="${sbList[0].BANNER_POP eq 'new'}">
							<img src="${image_dir}sub_banner/${sbList[0].BANNER}" alt="혜택배너" onerror="this.src='/img/noimg.png'" onclick="javascript:window.open('${image_dir}sub_banner/${sbList[0].DETAIL}');" style="width:1284px; height:238px;"/>
						</c:if>
					</div>
				</div>
				<!-- //main-sec03 -->
	
				<!-- main-sec04 -->
				<div class="main-sec04 ani-eff text">
					<div class="text-center">
						<h1 class="en-txt eff-t">AK Culture Now</h1>
						<p class="h1-sp eff-t">AK 문화아카데미의 새로운 소식들을 함께 만나보세요!</p>
					</div>
					<div class="main-noti mu-grid">
						<c:forEach var="i" items="${newsList}" varStatus="loop">
							<div onclick="javascript:location.href='http://localhost:9090/academy/detail?seq=${i.SEQ}'">
								<div class="noti-info">
									<span class="noti-t">${i.CATEGORY}</span>
									<span>${fn:substring(i.CREATE_DATE,0,4)}.${fn:substring(i.CREATE_DATE,4,6)}.${fn:substring(i.CREATE_DATE,6,8)}</span>
								</div>
								<p class="subject">${i.TITLE}</p>
								<p class="contents">
									${fn:substring(i.CONTENTS,0,100)}...
								</p>
							</div>
						</c:forEach>
<!-- 						<div> -->
<!-- 							<div class="noti-info"> -->
<!-- 								<span class="noti-t">NOTICE</span> -->
<!-- 								<span>2020.03.20</span> -->
<!-- 							</div> -->
<!-- 							<p class="subject">모바일 수강신청 가이드</p> -->
<!-- 							<p class="contents"> -->
<!-- 								AK문화아카데미 모바일(http://m.akplaza.com) 또는 앱 다운 받으시고 회원가입 하시면 수강신청을 편리하게 이용하실 수 있습니다.  -->
<!-- 							</p> -->
<!-- 						</div> -->
<!-- 						<div> -->
<!-- 							<div class="noti-info"> -->
<!-- 								<span class="noti-t">NOTICE</span> -->
<!-- 								<span>2020.03.20</span> -->
<!-- 							</div> -->
<!-- 							<p class="subject">모바일 수강신청 가이드</p> -->
<!-- 							<p class="contents"> -->
<!-- 								AK문화아카데미 모바일(http://m.akplaza.com) 또는 앱 다운 받으시고 회원가입 하시면 수강신청을 편리하게 이용하실 수 있습니다.  -->
<!-- 							</p> -->
<!-- 						</div> -->
					</div>
					<div class="more-wr">
						<a class="more-btn" href="/academy/news"><span class="line"></span><span class="text">VIEW MORE</span></a>
					</div>
				</div>
				<!-- //main-sec04 -->
				<jsp:include page="/inc/footer_inc.jsp"/>	
				
				<c:forEach var="i" items="${popList}" varStatus="loop">
					<c:if test="${i.IS_CENTER eq 'N' }">
						<div id="main_popup" class="main_popup pop_idx${i.SEQ}" style="position: absolute; z-index: 10000; top: ${i.MARGIN_TOP}px; left: ${i.MARGIN_LEFT}px; display:none;">
							<c:if test="${i.POPUP_POP eq 'now'}">		
								<div class="" onclick="javascript:location.href='${i.POPUP_LINK}'">
									<img src="${image_dir}popup/${i.POPUP_IMG}" alt="" onerror="this.src='/img/noimg.png'" />
								</div>
							</c:if>
							<c:if test="${i.POPUP_POP eq 'new'}">		
								<div class="" onclick="javascript:window.open('${i.POPUP_LINK}');" >
									<img src="${image_dir}popup/${i.POPUP_IMG}" alt="" onerror="this.src='/img/noimg.png'" />
								</div>
							</c:if>
							<div class="popup_bottom">
								<c:if test="${i.NOT_TODAY eq 'Y' }">
									<span class="close_popup_day" onclick="pop_todayclose('${i.SEQ}')">오늘하루 열지않기</span>
								</c:if>
								<div class="event-pop" onclick="pop_close('${i.SEQ}')"">닫기</div>
							</div>
						</div>
					</c:if>
					<c:if test="${i.IS_CENTER eq 'Y' }">
						<div id="main_popup" class="main_popup pop_idx${i.SEQ}" style="position: absolute; z-index: 10000; top: 50%; left:50%; display:none;">
							<c:if test="${i.POPUP_POP eq 'now'}">		
								<div class="" onclick="javascript:location.href='${i.POPUP_LINK}'">
									<img src="${image_dir}popup/${i.POPUP_IMG}" alt="" onerror="this.src='/img/noimg.png'"/>
								</div>
							</c:if>
							<c:if test="${i.POPUP_POP eq 'new'}">		
								<div class="" onclick="javascript:window.open('${i.POPUP_LINK}');" >
									<img src="${image_dir}popup/${i.POPUP_IMG}" alt="" onerror="this.src='/img/noimg.png'"/>
								</div>
							</c:if>
							<div class="popup_bottom">
								<c:if test="${i.NOT_TODAY eq 'Y' }">
									<span class="close_popup_day" onclick="pop_todayclose('${i.SEQ}')">오늘하루 열지않기</span>
								</c:if>
								<div class="event-pop" onclick="pop_close('${i.SEQ}')">닫기</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
				
				<script>
				var openPopCnt = 0;
				
				$(window).ready(function(){
					var pop_idx='';
					var pop_idx_arry=[];
					$('.main_popup').each(function(){ 
						pop_idx = $(this).attr('class').replace('main_popup','').trim();
						pop_idx_arry.push(pop_idx);
					})
				
					for (var i = 0; i < $('.main_popup').length+1; i++) {
						if(getCookie(pop_idx_arry[i])!="Y"){
							$("."+pop_idx_arry[i]).show('fade');
							if(pop_idx_arry[i] != undefined)
							{
				    			openPopCnt ++;	
							}
						}
					}
					if(openPopCnt > 0)
					{
						$("#main_popup_bg").show();
					}
				});
				function pop_todayclose(idx){
					var	notToday = getCookie("pop_idx"+idx);
					alert(notToday);
					if(notToday == "Y"){
						$(".pop_idx"+idx).hide('fade');
					}else{
						setCookie("pop_idx"+idx,'Y', 1);
						$(".pop_idx"+idx).hide('fade');
					}
					openPopCnt --;
					if(openPopCnt == 0)
					{
						$("#main_popup_bg").hide();
					}
				}
				function pop_close(idx){
					$(".pop_idx"+idx).hide('fade');
					openPopCnt --;
					if(openPopCnt == 0)
					{
						$("#main_popup_bg").hide();
					}
				}
				</script>
			</div>
		</div><!-- //container -->
	</form>
</div><!-- all-wrap -->

<form id="fileForm" name="fileForm" method="post" action="./mbanner">
	<input type="hidden" id="file_nm" name="file_nm" value=""/>
</form>
