<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>AK문화센터</title>
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
		<script src="/inc/js/mo_musign.js"></script>
		<script src="/inc/js/function.js"></script>
		<!-- 추가플러그인 -->
		<script src="/inc/js/swiper.js"></script>
		<link rel="stylesheet" href="/css/mo_swiper.css">
		<!-- 뮤자인 -->
		<link rel="stylesheet" href="/css/mo_mu_layout.css">

		
	</head>

	<script>
	
	function setCookie( name, value, expiredays ) {
        var todayDate = new Date();
        todayDate.setDate( todayDate.getDate() + expiredays ); 
        document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
    }
    function closePop() {
        if ( $("#today-not").prop("checked")==true){
        	setCookie( "maindiv", "done" , 1 );
        }
        
        $('#sign_popup').hide();
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
			<div class="header-wr">
				<div class="logo">
					<div class="logo-wr">
						<a href="/"><img src="/img/mo-logo.png" alt="ak문화센터"/></a>
					</div>
				</div>
				<div class="nav-wr">
					<ul class="nav-ul nav-ul02">
						<li><a href="#"><img width="21" src="/img/mo-icon01.png" alt="ak문화센터 아이콘"/><span class="log-on"></span></a></li>
					</ul>
				</div>
			</div>

			<div class="menu-ham">
				<div class="hambtn">
					<span></span>
					<span></span>
					<span></span>
				</div>
				<div class="menu-wrap">
					<div class="menu-wr">
						<div>
							<ul class="menu-ul" id="sitemaps">
								<li><a href="/mobile/academy/lector01">강사 지원</a>
									<ul class="dis-no">
										<li><a href="/mobile/academy/lector02">개인정보 수집동의</a></li>
										<li><a href="/mobile/academy/lector03">기본정보 작성</a></li>
										<li><a href="/mobile/academy/lector04">강의계획서 작성</a></li>
										<li><a href="/mobile/academy/lector05">최종제출 완료</a></li>
									</ul>
								</li>
								<li><a href="/mobile/academy/result01">지원서 수정/결과</a></li>
								<li><a href="/mobile/academy/contract01">강사 계약</a>
									<ul class="dis-no">
										<li><a href="/mobile/academy/contract02">강사 계약</a></li>
									</ul>
								</li>
								<li><a href="/mobile/academy/plan01">강의 계획서 등록/수정</a></li>
								<li><a href="/mobile/academy/attendance01">출석부 관리</a></li>
								<li><a>증명서 발급<span>- 신청 내역</span></a>
									<ul class="dep02">
										<li><a href="">출강증명서 조회</a></li>
										<li><a href="">신청 내역</a></li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
					<div class="app-btn"><a href="#"><img class="app-i" width="31" src="/img/app-icon.png" alt="앱아이콘"/>앱으로 돌아가기 <img width="13" src="/img/back-icon.png" alt="돌아가기"/></a></div>
				</div><!-- //menu-wrap -->
			</div><!-- //menu-ham -->

			<div class="myaca-wrap">
				<div class="aca-clo"><img src="/img/x-btn.png" alt="닫기"/></div>
				<div class="aca-wr">
					<div class="aca-cont">
						<p class="aca-tit"><span class="name">홍길동</span> 고객님 안녕하세요.</p>
						<div class="mile-wr mile-wr01">
							<p class="myac-tit"><span><img src="/img/my-aca02.png" alt="ak아이콘"/>총 마일리지</span></p>
							<p class="mile-pri">653,500<span class="won">원</span></p>
							<a class="bor-btn mile-btn" href="#">마일리지 내역 보기</a>
							<div class="myin-btnwr">
								<a class="btn" href="#">회원정보 수정 <img src="/img/my-aca01.png" alt="ak아이콘"/></a>
								<a class="btn" href="#">자녀회원 등록 <img src="/img/my-aca01.png" alt="ak아이콘"/></a>
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
									<table class="myin-body">
										<colgroup>
											<col width="5%">
											<col width="15%">
											<col width="15%">
											<col width="15%">
											<col/>
											<col width="15%">
										</colgroup>
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
										</tr>
										<tr>
											<td><span class="chk-d"></span></td>
											<td>082</td>
											<td>홍길동</td>
											<td>20-03-24</td>
											<td>사진촬영 고급기법 클래스</td>
											<td>이지영</td>
										</tr>
									</table>
								</div>
								<div class="myin-btnwr">
									<a class="btn" href="#">자세히 보기 <img src="/img/my-aca01.png" alt="ak아이콘"/></a>
								</div>
							</div>
						</div>
						<div class="mile-wr mile-wr03">
							<p class="myac-tit"><span><img src="/img/my-aca04.png" alt="ak아이콘"/>수강정보</span></p>
							<div class="myin-info">
								<a href="#"><img src="/img/my-aca05.png" alt="ak아이콘"/>나의 책가방</a>
								<a href="#"><img src="/img/my-aca06.png" alt="ak아이콘"/>대기강좌 내역</a>
								<a href="#"><img src="/img/my-aca07.png" alt="ak아이콘"/>할인권 내역</a>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		
		<div class="all-wrap">