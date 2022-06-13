<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />

<div class="lnb-top">
	<p class="lnb-entit eff-t">Course Search.</p>
	<p class="lnb-kotit eff-t">온라인 신청 안내</p>
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<p class="sub-tit">온라인신청 안내</p>
		
		<div class="apply-wr">
			<!-- Add Arrows -->
			<div class="swiper-button swiper-button-next"></div>
			<div class="swiper-button swiper-button-prev"></div>
			<div class="swiper-container">
				<div class="swiper-scrollbar"></div>
				<!-- Add Pagination -->
				<div class="swiper-pagination"></div>
				<div class="swiper-wrapper">
					<!-- apply-div -->
					<div class="apply-div swiper-slide">
						<div class="tab table verti-mid">
							<div class="tab-cont">
								<div class="apply-img active">
									<img src="/img/online-img01.png" alt="온라인신청"/>
								</div>
								<div class="apply-img">
									<img src="/img/online-img02.png" alt="온라인신청"/>
								</div>
								<div class="apply-img">
									<img src="/img/online-img03.png" alt="온라인신청"/>
								</div>
							</div>
							<div class="apply-txt">
								<ul class="tab-ul">
									<li class="active"><span>01</span>화면 상단의 로그인클릭 </li>
									<li><span>02</span>AK멤버스 회원가입 필수
										<p class="dot-bg">미성년 자녀는 자녀회원으로 <br>등록 후 수강신청</p>
									</li>
									<li><span>03</span>[마이페이지]의 [자녀회원 등록]에서 <br>
										수강자 선택 본인(성인)강좌 신청 시 <br>
										본인 "홍길동" 선택
										<p class="dot-bg">자녀회원 등록 시 <자녀회원 등록방법> 참조</p>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- apply-div -->
					<div class="apply-div swiper-slide">
						<div class="tab table verti-mid">
							<div class="tab-cont">
								<div class="apply-img active">
									<img src="/img/online-img04.png" alt="온라인신청"/>
								</div>
								<div class="apply-img">
									<img src="/img/online-img05.png" alt="온라인신청"/>
								</div>
								<div class="apply-img">
									<img src="/img/online-img06.png" alt="온라인신청"/>
								</div>
							</div>
							<div class="apply-txt">
								<ul class="tab-ul">
									<li class="active"><span>04</span>
										강좌 선택 후 확인버튼 클릭
									</li>
									<li><span>05</span>
										검색조건 입력 후 조회 클릭
									</li>
									<li><span>06</span>
										접수가능한 강좌 확인 후 강좌명 클릭
									</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- apply-div -->
					<div class="apply-div swiper-slide">
						<div class="tab table verti-mid">
							<div class="tab-cont">
								<div class="apply-img active">
									<img src="/img/online-img07.png" alt="온라인신청"/>
								</div>
								<div class="apply-img">
									<img src="/img/online-img08.png" alt="온라인신청"/>
								</div>
								<div class="apply-img">
									<img src="/img/online-img09.png" alt="온라인신청"/>
								</div>
							</div>
							<div class="apply-txt">
								<ul class="tab-ul">
									<li class="active"><span>07</span>
										강좌 내용 확인 후 책가방 담기 클릭
									</li>
									<li><span>08</span>
										결제할 강좌 선택 후 결제하기 클릭
									</li>
									<li><span>09</span>
										결제정보 입력 후 승인 클릭
									</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- apply-div -->
					<div class="apply-div swiper-slide">
						<div class="tab table verti-mid">
							<div class="tab-cont">
								<div class="apply-img active">
									<img src="/img/online-img10.jpg" alt="온라인신청"/>
								</div>
							</div>
							<div class="apply-txt">
								<ul class="tab-ul">
									<li class="active"><span>10</span>
										수강신청이 완료되면 해당 페이지 출력
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	$(function(){
		var swiper2 = new Swiper('.apply-wr .swiper-container', {
			slidesPerView: 1,
			scrollbar: {
				el: '.swiper-scrollbar',
				draggable: true,
			},
			navigation: {
				nextEl: '.swiper-button-next',
				prevEl: '.swiper-button-prev',
			},
			pagination: {
				el: '.swiper-pagination',
				type: 'fraction',
			},
		});
	})
</script>

<jsp:include page="/inc/footer.jsp" />

