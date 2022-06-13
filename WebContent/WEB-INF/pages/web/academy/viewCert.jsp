<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="attend_wrap">
	<div class="attend_box">
		<p class="p1">문서번호 : 문출 2017-10-25</p>
		<h3>출 강 증 명 서</h3>
		
		<div class="attend-content">
			<div><span>성 명</span>: <p>${lecturer_nm}</p></div>
			<div><span>주 민 등 록 번 호</span>: <p>${lecturer_cd}</p></div>
			<div><span>주 소</span>: <p>${cus_addr}</p></div>
			<div><span>강 좌 명</span>: <p>${subject_list}</p></div>
			<div><span>출 강 기 간</span>: <p>2020<span>년</span> 1<span>월</span> 1<span>일</span> ~ 2020<span>년</span> 3<span>월</span> 3<span>일</span></p></div>
			<div><span>용 도</span>: <p>기관제출용</p></div>
		</div><!-- //attend-content end -->
		
		<p class="p2">위의 사실을 증명합니다.</p>
		<p class="p3">2017<span>년</span> 10<span>월</span> 25<span>일</span></p>
		<p class="p4">문화아카데미 분당점<span>인</span></p>
		<div class="logo"><img src="/img/ak-logo_attend.png" /></div>
	</div><!--  //attend_box end -->
</div><!-- //attend_wrap end -->







<style>
*{
	/*font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";*/
	font-family:"바탕체",BatangChe;
	font-size:16px;
	letter-spacing:1px;
	line-height:1.6;
	padding:0;
	margin:0;
	box-sizing:border-box;
}
.attend_box{
    max-width: 800px;
    border: 1px solid #000;
    padding: 80px;
    margin: 0 auto;
}
h3{
	font-size:30px;
	font-weight:bold;
	text-align:center;
	margin-top:50px;
}
.p1{
	
}
.p2{
	text-align:center;
}
.p3{
	text-align:center;
	margin:50px 0;
}
.p4{
	text-align:center;
	font-size:22px;
	font-weight:bold;
	padding-left:80px;
}
.p4 span{
	width:80px;
	height:80px;
	border:3px solid #ddd;
	text-align:right;
	color:#ddd;
	display:inline-block;
	padding:23px 0;
	padding-right:5px;
	vertical-align:middle;
	margin-left:30px;
}
.logo{
	text-align:center;
}
.attend-content{
	margin:80px 0;
}
.attend-content > div{
	margin:15px 0;
}
.attend-content > div > span{
	width: 150px;
    text-align: justify;
    display: inline-block;
    vertical-align: middle;
    margin-right: 5px;
}
.attend-content > div > span:after{
    content: '';
    display: inline-block;
    width: 100%;
}
.attend-content p{
    display: inline-block;
    vertical-align: middle;
}
.attend-content p span, .p3 span{
	padding:0 5px 0 3px;
}
</style>




