<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />

<div class="content_wrap">
	<div class="content_var"></div>
		<div class="content_textbox">
			<p class="content_text1"><span class="text_color">정은미</span> 님의 기본 이용점은 <span class="text_color">미설정 상태</span>입니다.</p>
			<p class="content_text2">회원님의 이용 지점을 설정해 주시기 바랍니다.<br>기본점을 설정하시면 강좌조회, 수강결제 등 메뉴들을 더욱 편리하게 이용하실 수 있습니다.</p>
		    <p class="content_text3"><img src="/img/notice_icon.png" alt="icon" class="notice">선택하신 지점으로 설정됩니다.</p>
		</div>
		<div class="check">
			<div class="check_wrap">
				<div class="cb_wrap">
					<input type="checkbox" id="cb1">
					<label for="cb1">
						<span></span>분당점
					</label>
				</div>
				<div class="cb_wrap">
					<input type="checkbox" id="cb2">
					<label for="cb2">
						<span></span>수원점
					</label>
				</div>
				<div class="cb_wrap">
					<input type="checkbox" id="cb3">
					<label for="cb3">
						<span></span>구로본점
					</label>
				</div>
				<div class="cb_wrap">
					<input type="checkbox" id="cb4">
					<label for="cb4">
						<span></span>평택점
					</label>
				</div>
				<div class="cb_wrap">
					<input type="checkbox" id="cb5">
					<label for="cb5">
						<span></span>원주점
					</label>	
				</div>			
			</div>
		</div>
		<div class="mnbtn_wrap">
			<a class="mnbtn1" href="/">메인으로 돌아가기</a>
			<a class="mnbtn2">확인</a>
		</div>
</div>

<jsp:include page="/inc/footer.jsp" />

