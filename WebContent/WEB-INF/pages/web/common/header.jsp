<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="ak_web.classes.*" %>
<%@ page import="java.util.*" %>

<%
String cust_no = Utils.checkNullString(session.getAttribute("login_cust"));
double AKmemPoint = 0;
String AKmemCardStatus = null;
HashMap AKmemRead ;
String AKmemCardNo = null;
String number = Utils.checkNullString(session.getAttribute("login_store"));
String store_nm = Utils.checkNullString(session.getAttribute("login_store_nm"));
CmAKmembers cmAKmembers = new CmAKmembers();
AKmemCardNo = Utils.checkNullString(session.getAttribute("login_card"));

boolean AKmemUsePointYn = false;

//카드번호가 존재시 마일리지 read

if(!"".equals(AKmemCardNo)){
  AKmemRead = cmAKmembers.getAKmemRead( number, AKmemCardNo);
  
//   //정상적인 카드번호인지 확인
  AKmemCardStatus = cmAKmembers.getAKmemStatus(AKmemRead);
  if ( "00".equals(AKmemCardStatus) ){
    AKmemPoint  = cmAKmembers.getAKmemPoint(AKmemRead);
    
    AKmemUsePointYn = true;
  }
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>AK문화아카데미</title>
		<meta charset="UTF-8">
		<meta name="generator" content="editplus" />
		<meta name="author" content="" />
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="http://malsup.github.io/min/jquery.form.min.js"></script>
		<script src="/inc/js/jquery.nicescroll.min.js"></script>
		<script src="/inc/js/animation.js"></script>
		<script src="/inc/js/musign.js"></script>
		<script src="/inc/js/function.js"></script>
		<!-- 추가플러그인 -->
		<script src="/inc/js/swiper.js"></script>
		<link rel="stylesheet" href="/css/swiper.css">
		<!-- 뮤자인 -->
		<link rel="stylesheet" href="/css/mu_layout.css">
		
	</head>
	<script>
	 
	var needLogin = ['/academy/academy04', '/cs/contact'];
	$(document).ready(function(){
		var lohr = location.href;
		for(var i = 0; i < needLogin.length; i++)
		{
			if(lohr.indexOf(needLogin[i]) > -1)
			{
				if('<%=cust_no%>' == '')
				{
					alert("로그인이 필요한 페이지입니다.");
					location.href="/user/login";
					return;
				}
			}
		}
		getBookCnt();
		getMylectureList();
		/*
		cookiedata = document.cookie;   
	    if ( cookiedata.indexOf("maindiv=done") < 0 ){     
	       //$('#sign_popup').show();
	    }
	    else {
	    	$('#sign_popup').hide();
	    	
	    }
	    */
		
		$('.main_store > li').click(function() {
			change_main_store($(this).val());
		});

	});

		function getMylectureList() {

			$.ajax({
				type : "POST",
				url : "/academy/getMylectureList",
				dataType : "text",
				async : false,
				error : function() {
					console.log("AJAX ERROR");
				},
				success : function(data) {
					console.log(data);

					var result = JSON.parse(data);
					var inner = "";
					if (result.length > 0) {
						for (var i = 0; i < result.length; i++) {
							inner += '<tr>';
							inner += '	<td><span class="chk-d"></span></td>';
							inner += '	<td>' + result[i].PERIOD + '</td>';
							inner += '	<td>' + result[i].CUST_NM + '</td>';
							inner += '	<td>' + result[i].START_YMD + '</td>';
							inner += '	<td>' + result[i].SUBJECT_NM + '</td>';
							inner += '	<td>' + result[i].LECTURER_NM + '</td>';
							inner += '</tr>';
						}
					} else {
						inner += '<tr><td colspan="6">수강내역이 없습니다.</td></tr>';
					}

					$("#MyLect_list").html(inner);
				}
			});
		}

		function getBookCnt() {

			$.ajax({
				type : "POST",
				url : "/common/getBook_cnt",
				dataType : "text",
				async : false,
				error : function() {
					console.log("AJAX ERROR");
				},
				success : function(data) {
					console.log(data);

					var result = JSON.parse(data);
					$('.cart-count').text(result.cnt);
				}
			});
		}

		function setCookie(name, value, expiredays) {
			var todayDate = new Date();
			todayDate.setDate(todayDate.getDate() + expiredays);
			document.cookie = name + "=" + escape(value) + "; path=/; expires="
					+ todayDate.toGMTString() + ";"
		}
		function closePop() {
			if ($("#today-not").prop("checked") == true) {
				setCookie("maindiv", "done", 1);
			}

			$('#sign_popup').hide();
		}

		function change_main_store(val) {
			$.ajax({
				type : "POST",
				url : "/common/change_main_store",
				dataType : "text",
				async : false,
				error : function() {
					console.log("AJAX ERROR");
				},
				data : {
					store : "0"+val
				},
				success : function(data) {
					console.log(data);

					var result = JSON.parse(data);
					if (result.isSuc == "success") {
						location.reload();
					} else {
						alert(result.msg);
					}
				}
			});
		}
	</script>


	<body>

		<div id="sign_popup" class="popup" style="display:none;">
			<div class="popup-wr">
				<img src="/img/popup-img.jpg" alt="통합멤버스 팝업"/>
				<div class="popup-bot">
					<div class="pop-chk">
						<span class="chk-btn"><input type="checkbox" id="today-not" name="today-not" value="오늘하루열지않기"><label for="today-not">오늘하루열지않기</label></span>
					</div>
					<div class="pop-cls" onclick="javascript:closePop();">
						닫기
					</div>
				</div>
			</div>
		</div>
		
		
		<div id="header" class="header">
			<div class="header-wr table">
				<div class="logo">
					<div class="logo-wr">
						<a href="/"><img src="/img/logo.png" alt="ak문화아카데미"/></a>
					</div>
				</div>
				<div class="nav-wr">
					<ul class="nav-ul nav-ul01">
						<li><a href="../academy/news">AK아카데미</a></li>
						<li><a href="../course/list01">수강신청</a></li>
						<li class="dis-no"><a>MY아카데미</a></li>
						<li><a href="../cs/contact">고객서비스</a></li>
						<li class="not-li"><a href="#">AK멤버스</a></li>
					</ul>
					<ul class="nav-ul nav-ul02">
						<li><a href="../academy/academy04"><img src="/img/gnb-icon01.png" alt="ak문화아카데미 아이콘"/><span class="cart-count"></span></a></li>
						<%
						if(!"".equals(Utils.checkNullString(session.getAttribute("login_cust"))))
						{
							%>
							<li><a href="/user/logout"><img src="/img/gnb-icon02.png" alt="ak문화아카데미 아이콘"/><span class="log-on"></span></a></li>
							<%
						}
						else
						{
							%>
							<li><a href="/user/login"><img src="/img/gnb-icon02-notpoint.png" alt="ak문화아카데미 아이콘"/><span class="log-on"></span></a></li>
							<%
						}
						%>
						<li><a href="../academy/catalog"><img src="/img/gnb-icon03.png" alt="ak문화아카데미 아이콘"/><span class="catal-i">E카탈로그</span></a></li>
					</ul>
				</div>	
				<div class="nav-r">
					<ul class="nav-ul nav-ul03">
						<%
						if(!"".equals(Utils.checkNullString(session.getAttribute("login_cust"))))
						{
							%>
							<li><a class="acad-btn"><img src="/img/gnb-icon04.png" alt="ak문화아카데미 아이콘"/><span class="en-txt03">MY</span> 아카데미 바로가기</a></li>
							<%
						}
						else
						{
							%>
							<li><a href="/user/login" class="acad-btn"><img src="/img/gnb-icon04.png" alt="ak문화아카데미 아이콘"/><span class="en-txt03">MY</span> 아카데미 바로가기</a></li>
							<%
						}
						%>
					</ul>
				</div>
			</div>

			<div class="gnb-depth">
				<div class="gnb-depwr"></div>
			</div>

			<div class="menu-ham">
				<div class="hambtn">
					<span></span>
					<span></span>
					<span class="ham-txt">Menu</span>
				</div>
				<div class="menu-wrap">
					<div class="menu-wr">
						<div>
							<ul class="menu-ul" id="sitemaps">
								<li class="menu-li menu-li01"><A href="#">AK아카데미</a>
									<ul class="dep02">
										<li><a href="../academy/news">아카데미 뉴스</a></li>
										<li><a href="../academy/recommend">추천 강좌</a></li>
										<li><a href="../academy/catalog">E-카탈로그</a></li>
										<li><a href="../academy/store01">지점 안내</a>
											<ul class="dep03 dis-no">
												<li><a href="/academy/store01">분당점</a></li>
												<li><a href="/academy/store02">수원점</a></li>
												<li><a href="/academy/store03">평택점</a></li>
												<li><a href="/academy/store04">원주점</a></li>
											</ul>
										</li>
										<li><a href="../academy/lector01">강사 전용</a>
											<ul class="dep03">
												<li><a href="../academy/lector01">강사 지원</a></li>
												<li><a href="../academy/result01">지원서 수정/결과</a></li>
												<li><a href="../academy/contract01">강사 계약</a></li>
												<li><a href="../academy/plan01">강의 계획서 등록/수정</a></li>
												<li><a href="../academy/attendance01">출석부 관리</a></li>
												<li><a href="../academy/certificate01">증명서 발급<span>- 신청 내역</span></a></li>
											</ul>
										</li>
									</ul>
								</li>
								<li class="menu-li menu-li02"><A href="#">수강신청</a>
									<ul class="dep02">
										<li><a href="../course/list01">강좌검색</a></li>
										<li><a href="../course/course01">수강신청 가이드</a>
											<ul class="dep03">
												<li><a href="../course/course01">수강안내</a></li>
												<li><a href="../course/course05">온라인 신청 안내</a></li>
												<li><a href="../course/course06">자녀회원 등록 안내</a></li>
											</ul>
										</li>
									</ul>
								</li>
								<li class="menu-li menu-li03"><A href="#">MY아카데미</a>
									<ul class="dep02">
										<li><a href="../academy/academy01">회원정보 수정</a></li>
										<li><a href="../academy/academy06">자녀회원 등록</a></li>
										<li><a href="../academy/academy02">수강 정보</a>
											<ul class="dep03">
												<li><a href="../academy/academy04">나의 책가방</a></li>
												<li><a href="../academy/academy03">대기강좌 내역</a></li>
												<li><a href="../academy/academy05">할인쿠폰 내역</a></li>
											</ul>
										</li>
									</ul>
								</li>
								<li class="menu-li menu-li04"><A href="#">고객서비스</a>
									<ul class="dep02">
										<li><a href="../cs/contact">고객의 소리</a></li>
<!-- 										<li><a href="../cs/faq">FAQ</a></li> 2021-01-26 요청으로 메뉴 삭제 기영-->
									</ul>
								</li>
								<li class="menu-li menu-li05"><A href="#">AK멤버스</a></li>
							</ul>
						</div>
					</div>
					<div class="menu-img">
						<img src="/img/menu-img.jpg" alt="메뉴이미지"/>
						<a href="../academy/recommend" class="rec-btn">추천강좌 페이지 바로가기<img src="/img/rec-bg.png" alt="추천강좌 바로가기 아이콘"/></a>
					</div>
					<div class="bg-line">
						<span></span>
						<span></span>
						<span></span>
						<span></span>
						<span></span>
					</div>
					<div class="msli-sns">
						<p class="msli-p">Share</p>
						<ul>
							<li><A href="https://www.facebook.com/AKplazaM" target="_blank"><img src="/img/sns-icon02.png" alt="페이스북"></a></li>
							<li><A href="https://twitter.com/AKPlaza_HQ" target="_blank"><img src="/img/sns-icon01.png" alt="트위터"></a></li>
						</ul>
					</div>
				</div><!-- //menu-wrap -->
			</div><!-- //menu-ham -->

			<div class="myaca-wrap">
				<div class="aca-clo"><img src="/img/x-btn.png" alt="닫기"/></div>
				<div class="aca-wr">
					<div class="aca-cont">
						<p class="aca-tit"><span class="name"><%=Utils.checkNullString(session.getAttribute("login_name")) %></span> 고객님 안녕하세요.</p>
						<%
						if(!"".equals(Utils.checkNullString(session.getAttribute("login_cust"))))
						{
							%>
								<div class="mile-wr mile-wr01">
									<div class="myin-btnwr info-btnwr">
<%-- 										<select id="main_store" name="main_store" de-data="<%=Utils.checkNullString(session.getAttribute("login_store_nm"))%>" onchange="change_main_store()"> --%>
<!-- 											<option value="02">수원점</option> -->
<!-- 											<option value="03">분당점</option> -->
<!-- 											<option value="04">평택점</option> -->
<!-- 											<option value="05">원주점</option> -->
<!-- 										</select> -->
										<div class="select-box select-box-no ">
											<div class="selectedOption sub_target"><%=store_nm%></div>
											<ul class="sear-ul main_store" >
												<li value="02">수원점</li>
												<li value="03">분당점</li>
												<li value="04">평택점</li>
												<li value="05">원주점</li>
											</ul>
										</div>
									</div>
									<p class="myac-tit"><span><img src="/img/my-aca02.png" alt="ak아이콘"/>총 마일리지</span></p>
									<p class="mile-pri"><%=Utils.roundFixUp(AKmemPoint ,0, true) %><span class="won">원</span></p>
									<a class="bor-btn mile-btn" href="#">마일리지 내역 보기</a>
									<div class="myin-btnwr">
										<a class="btn" href="../academy/academy01">회원정보 수정 <img src="/img/my-aca01.png" alt="ak아이콘"/></a>
										<a class="btn" href="../academy/academy06">자녀회원 등록 <img src="/img/my-aca01.png" alt="ak아이콘"/></a>
									</div>
								</div>
								<div class="mile-wr mile-wr02">
									<p class="myac-tit"><span><img src="/img/my-aca03.png" alt="ak아이콘"/>수강내역</span></p>
									<div class="myin-ta">
										<table class="myin-head">
											<colgroup>
												<col width="5%">
												<col width="15%">
												<col width="15%">
												<col width="15%">
												<col/>
												<col width="15%">
											</colgroup>
											<tr>
												<td></td>
												<td>학기</td>
												<td>수강자</td>
												<td>시작일</td>
												<td>강좌명</td>
												<td>강사명</td>
											</tr>
										</table>
										<div class="myin-scr">
											<table id="MyLect_list" class="myin-body">
												<colgroup>
													<col width="5%">
													<col width="15%">
													<col width="15%">
													<col width="15%">
													<col/>
													<col width="15%">
												</colgroup>
												
											<!-- 	<tr>
													<td><span class="chk-d"></span></td>
													<td>082</td>
													<td>홍길동</td>
													<td>20-03-24</td>
													<td>사진촬영 고급기법 클래스</td>
													<td>이지영</td>
												</tr>
												
												<tr>
													<td><span class="chk-d"></span></td>
													<td>082</td>
													<td>홍길동</td>
													<td>20-03-24</td>
													<td>사진촬영 고급기법 클래스</td>
													<td>이지영</td>
												</tr>
												
												<tr>
													<td><span class="chk-d"></span></td>
													<td>082</td>
													<td>홍길동</td>
													<td>20-03-24</td>
													<td>사진촬영 고급기법 클래스</td>
													<td>이지영</td>
												</tr>
												
												<tr>
													<td><span class="chk-d"></span></td>
													<td>082</td>
													<td>홍길동</td>
													<td>20-03-24</td>
													<td>사진촬영 고급기법 클래스</td>
													<td>이지영</td>
												</tr>
												
												<tr>
													<td><span class="chk-d"></span></td>
													<td>082</td>
													<td>홍길동</td>
													<td>20-03-24</td>
													<td>사진촬영 고급기법 클래스</td>
													<td>이지영</td>
												</tr> -->
												
											</table>
										</div>
										<div class="myin-btnwr">
											<a class="btn" href="../academy/academy02">자세히 보기 <img src="/img/my-aca01.png" alt="ak아이콘"/></a>
										</div>
									</div>
								</div>
								<div class="mile-wr mile-wr03">
									<p class="myac-tit"><span><img src="/img/my-aca04.png" alt="ak아이콘"/>수강정보</span></p>
									<div class="myin-info">
										<a href="../academy/academy04"><img src="/img/my-aca05.png" alt="ak아이콘"/>나의 책가방</a>
										<a href="../academy/academy03"><img src="/img/my-aca06.png" alt="ak아이콘"/>대기강좌 내역</a>
										<a href="../academy/academy05"><img src="/img/my-aca07.png" alt="ak아이콘"/>할인권 내역</a>
									</div>
								</div>
							<%
						}
						else
						{
							%>
							로그인 후 이용가능합니다.
							<%
						}
						%>
						
						
					</div>
				</div>
			</div>
		</div>
		
		<div class="bg-line">
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			<span></span>
		</div>
		
		
		<div class="all-wrap">