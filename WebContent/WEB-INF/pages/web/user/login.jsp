<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="nets.websso.ssoclient.authcheck.*" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="ak_web.classes.*" %>
<%@ page import="ak_web.model.web.LectureVo" %>


<%
// 	String addUrl = (String)request.getAttribute("REQUEST_URI");
// 	if(request.getQueryString() != null && request.getQueryString()!="")
// 	{
// 		addUrl = (String)request.getAttribute("REQUEST_URI")+"?"+request.getQueryString();
// 	}
// 	AuthCheck auth = (AuthCheck)request.getAttribute("auth");
// 	String returnUrl = "";
// 	String ret = request.getParameter(SSOConfig.ReturnURLTagName());
//     if(ret != null && ret != "")
//     {
//         returnUrl = URLEncoder.encode(ret, "UTF8");
//     }
//     else
//     {
//          if(request.getRequestURL() != null)
//             returnUrl = URLEncoder.encode(request.getRequestURL().toString(), "UTF8");
//         else
//             returnUrl = URLEncoder.encode(request.getRequestURL().toString(), "UTF8");
//     }
//     String requestURI = "http://" + request.getServerName() + (String)request.getAttribute("REQUEST_URI") + (request.getQueryString()==null || request.getQueryString().equals("") ? "" : "?"+request.getQueryString());
//     returnUrl = requestURI;
//     //일반 logOff URL
//     String logoffString = "";
//     //logoffString = SSOConfig.LogoffPage() + "?" + SSOConfig.ReturnURLTagName() + "=" + URLEncoder.encode(auth.ThisURL(), "UTF8");	
//     logoffString = SSOConfig.LogoffPage() + "?" + SSOConfig.ReturnURLTagName() + "=" + URLEncoder.encode("http://" + request.getServerName(), "UTF8");  //로그오프시 메인페이로 이동할것.
//     //미동의 logOff URL        
//     String UnifyYNlogoffString = "";
//     String UnifyYNreturnURL = "http://" + request.getServerName() + "/home/commonjsp.do?pageskin=common.unifyinfo";
//     UnifyYNlogoffString = SSOConfig.LogoffPage() + "?" + SSOConfig.ReturnURLTagName() + "=" + URLEncoder.encode(UnifyYNreturnURL, "UTF8"); 
    
//     Context ctx = new InitialContext();
//     Object value = ctx.lookup("java:comp/env/SITESERVER_DNS");
//     String siteDNS = value.toString();

//     String ssositeValue = "?" + SSOConfig.RequestSSOSiteParam + "=" + siteDNS;
    
//     AuthStatus status = (AuthStatus)request.getAttribute("status");
// 	String unifyYN = (String)request.getAttribute("unifyYN");	
// 	int errorNumber = (Integer)request.getAttribute("errorNumber");
	
// 	String resultMsg = StringUtil.nvl((String)request.getAttribute("resultMsg"),"");
	
// 	String cookieId = "";
// 	Cookie[] getCookie = request.getCookies();
// 	if(getCookie != null){
// 		for(int i=0;i < getCookie.length;i++){
// 			if(getCookie[i].getName().equals("cultureID")){
// 				cookieId = getCookie[i].getValue();
// 			}
// 		}
// 	}
// 	AuthStatus status = (AuthStatus)request.getAttribute("status");
// 	String unifyYN = (String)request.getAttribute("unifyYN");	
// 	int errorNumber = (Integer)request.getAttribute("errorNumber");
// 	String nextUrl = request.getParameter("nextUrl");
	

	
%>

<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://malsup.github.io/min/jquery.form.min.js"></script>
<script src="/inc/js/function.js"></script>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<script>

var isLogin = '<%=session.getAttribute("login_id")%>';
var link = location.href;
if (isLogin != null && isLogin != "null" && link.indexOf("/web/user/login") > -1) {
	location.href="/main";
}

var resultMsg = "${resultMsg}";
if (resultMsg!="") {
	alert(resultMsg);
}

function fncSubmit()
{
	var validationFlag = "Y";
	$(".notEmpty").each(function() 
	{
		if ($(this).val() == "") 
		{
			alert(this.dataset.name+"을(를) 입력해주세요.");
			$(this).focus();
			validationFlag = "N";
			return false;
		}
	});
	if(validationFlag == "Y")
	{
// 		document.fncForm.submit();
		$("#fncForm").ajaxSubmit({
			success: function(data)
			{
				console.log(data);
				var result = JSON.parse(data);
	    		if(result.isSuc == "success")
	    		{
	    			alert('환영합니다.');
	    			location.href="/main";
	    		}
	    		else
	    		{
	    			alert(result.msg);
	    		}
			}
		});

	}
}

</script>
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
						<li class="menu-li menu-li01"><a href="#">AK아카데미</a>
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
						<li class="menu-li menu-li02"><a href="#">수강신청</a>
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
										<li><a href="../academy/academy04">나의 책가방</a>
											<ul class="dep04">
												<li><a href="../academy/order">결제하기</a></li>
												<li><a href="../academy/order_end">결제완료</a></li>
											</ul>
										</li>
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
						<a class="btn btn03" href="../academy/academy01">회원정보 수정 <img src="/img/my-aca01.png" alt="ak아이콘"/></a>
						<a class="btn btn03" href="../academy/academy06">자녀회원 등록 <img src="/img/my-aca01.png" alt="ak아이콘"/></a>
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
							<a class="btn btn03" href="/academy/academy02">자세히 보기 <img src="/img/my-aca01.png" alt="ak아이콘"/></a>
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
<script src="/inc/js/jquery.breadcrumbs-generator.js"></script>
<script>
	$(function() {
	  $('#breadcrumbs').breadcrumbsGenerator();
	});
</script>

	<div class="breadcrumb-wr">
		<ul id="breadcrumbs" class="breadcrumb"></ul>
	</div>
	
	<div class="login-wrap">
	
		<div class="lnb-top">
			<p class="lnb-entit eff-t">login</p>
			<p class="lnb-kotit_sm eff-t">AK PLAZA 문화아카데미 홈페이지를 방문해 주셔서 감사합니다.</p>
		</div>
		
		<div class="inner">
<!-- 			<form id="fncForm" name="fncForm" method="POST" action="https://sso.akmembers.com/WebSSO/AuthWeb/Logon.aspx?ssosite=culture.akplaza.com&userId=chaplin"> -->
			<form id="fncForm" name="fncForm" method="POST" action="./login_proc">
				<input type="hidden" name="credType" value="BASIC" />
				<input type="hidden" name="returnURL" value="http://localhost:8080/user/login" />
				<input type="hidden" name="sitecode" value="culture" />
				<div class="log-inp">
					<div class="inp">
						<input type="text" id="txtUserID" name="userID" placeholder="아이디" />
						<input type="password" name="password" placeholder="비밀번호" />
					</div>
					<div class="button">
						<button type="button" class="en-txt" onclick="fncSubmit();">login</button>
					</div>
				</div>
			</form>
	
			
			<div class="login-memwr">
				<ul>
					<li><a href="https://www.akmembers.com/home/idpass.do?nav=1_3_0_0" target="_blank">아이디 찾기</a></li>
					<li><a href="https://www.akmembers.com/home/idpass.do?nav=1_3_0_0" target="_blank">비밀번호 찾기</a></li>
				</ul>
	
				<div>
					<label><input type="checkbox">아이디 저장</label>
				</div>
			</div>
	
			<div class="log-box">
				<p class="txt">인터넷접수를 처음 이용하시거나 아직 회원이 아니신가요?</p>
				<a href="https://www.akmembers.com/member/member.do?method=verificationform&nav=1_1_0_0" target="_blank">회원가입 <img src="/img/log-arrow.png" /></a>
			</div>
		</div>
	</div>
</div><!-- all-wrap -->
<jsp:include page="/inc/footer_inc.jsp"/>	

