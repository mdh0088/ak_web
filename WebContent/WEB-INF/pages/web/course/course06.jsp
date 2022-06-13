<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />

<div class="lnb-top">
	<p class="lnb-entit eff-t">Course Search.</p>
	<p class="lnb-kotit eff-t">자녀회원 등록 안내</p>
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<p class="sub-tit">자녀회원 등록 안내</p>
		
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
									<img src="/img/family-img01.png" alt="온라인신청"/>
								</div>
								<div class="apply-img">
									<img src="/img/family-img02.png" alt="온라인신청"/>
								</div>
								<!-- 
								<div class="apply-img">
									<img src="/img/family-img03.png" alt="온라인신청"/>
								</div>
								 -->
								<div class="apply-img">
									<img src="/img/family-img04.png" alt="온라인신청"/>
								</div>
							</div>
							<div class="apply-txt">
								<ul class="tab-ul">
									<li class="active"><span>01</span>화면 상단의 MY아카데미 바로가기 버튼 클릭 </li>
									<li><span>02</span>자녀회원 등록 버튼 클릭</p>
									</li>
									<!-- 
									<li><span>03</span>
										원하는 지점을 선택
									</li>
									 -->
									<li><span>03</span>
										자녀회원 등록하기 클릭
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
									<img src="/img/family-img05.png" alt="온라인신청"/>
								</div>
								<div class="apply-img">
									<img src="/img/family-img06.png" alt="온라인신청"/>
								</div>
							</div>
							<div class="apply-txt">
								<ul class="tab-ul">
									<li class="active"><span>04</span>
										자녀명, 생년월일, 성별 등록 후 저장 클릭
									</li>
									<li><span>05</span>
										등록 완료
										<p class="dot-bg">수강자 선택 후 수강신청 진행</p>
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

