<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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


	<body>
		
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
						<li><a href="../course/course01">수강신청</a></li>
						<li class="dis-no"><a>MY아카데미</a></li>
						<li><a href="../cs/contact">고객서비스</a></li>
						<li class="not-li"><a href="#">AK멤버스</a></li>
					</ul>
					<ul class="nav-ul nav-ul02">
						<li><a href="../academy/academy04"><img src="/img/gnb-icon01.png" alt="ak문화아카데미 아이콘"/><span class="cart-count">3</span></a></li>
						<li><a href="#"><img src="/img/gnb-icon02.png" alt="ak문화아카데미 아이콘"/><span class="log-on"></span></a></li>
						<li><a href="../academy/catalog"><img src="/img/gnb-icon03.png" alt="ak문화아카데미 아이콘"/><span class="catal-i">E카탈로그</span></a></li>
					</ul>
				</div>	
				<div class="nav-r">
					<ul class="nav-ul nav-ul03">
						<li><a href="#" class="acad-btn"><img src="/img/gnb-icon04.png" alt="ak문화아카데미 아이콘"/><span class="en-txt03">MY</span> 아카데미 바로가기</a></li>
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
										<li><a href="../cs/faq">FAQ</a></li>
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
						<p class="aca-tit"><span class="name">홍길동</span> 고객님 안녕하세요.</p>
						<div class="mile-wr mile-wr01">
							<p class="myac-tit"><span><img src="/img/my-aca02.png" alt="ak아이콘"/>총 마일리지</span></p>
							<p class="mile-pri">653,500<span class="won">원</span></p>
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