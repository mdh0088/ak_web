<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>

function choose_branch(idx){
	search_store =idx;
	$.ajax({
		type : "POST", 
		url : "./getMain",
		dataType : "text",
		async : false,
		data : 
		{
			store : idx
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

			for (var i = 0; i < result.mainlist.length; i++) {
				inner +='<li><a onclick="javascript:choose_main_cd(\''+result.mainlist[i].SUB_CODE+'\')">'+result.mainlist[i].SHORT_NAME+'</a>';
				inner +='</li>';
			}
			$('#main_cd_target').html(inner);

		}
	});	
	
}

function choose_main_cd(idx){
	search_main_cd = idx;
	$.ajax({
		type : "POST", 
		url : "./getSect",
		dataType : "text",
		async : false,
		data : 
		{
			sub_code : idx
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

			for (var i = 0; i < result.sectlist.length; i++) {
				inner +='<li><a onclick="javascript:choose_sect_cd(\''+result.sectlist[i].SECT_CD+'\');">'+result.sectlist[i].SECT_NM+'</a>';
				inner +='</li>';
			}
			$('#sect_cd_target').html(inner);

		}
	});	
}

function choose_sect_cd(idx){
	search_sect_cd = idx;
}

function choose_yoil(idx){
	search_yoil="";
	if (idx!='all') {
		search_yoil=idx;
	}
}

function search_reset(){
	search_store="";
	search_main_ce="";
	search_sect_cd="";
	search_yoil="";
	$('#month_val').val('');
}
</script>
<div class="lnb-top">
	<p class="lnb-entit eff-t">Course Search.</p>
	<p class="lnb-kotit eff-t">강좌검색</p>
</div>

<div class="filter-wrap">
	<div class="filter-bg"></div>
	<div class="filter-wr">
		<div class="filter-close"><img src="/img/filter-icon03.png" alt="닫기"/></div>
		<p class="filter-tit">Filter</p>
		<div class="filt-row">
			<div class="search-box search-box02">
				<p>가까운 지점 선택</p>
				<ul class="sear-ul">
					<c:forEach var="i" items="${branchList}" varStatus="loop">
						<li><a onclick="javascript:choose_branch('${i.SUB_CODE}');">${i.SHORT_NAME}</a></li>
					</c:forEach>
				</ul>
				<div class="search-box search-box02">
					<select id="main_cd_target" class="sch-inp" name="main_cd_target" de-data="가까운 지점 선택">
						<c:forEach var="i" items="${branchList}" varStatus="loop">
							<option value="javascript:choose_branch('${i.SUB_CODE}');">${i.SHORT_NAME}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="filt-row">
			<div id="main_cd_area" class="search-box search-box02">
				<select id="main_cd_target" class="sch-inp" name="main_cd_target" de-data="강좌 분야 선택">
					<option value="1">고등학교</option>
				</select>
			</div>
		</div>
		<div class="filt-row">
			<div id="sect_cd_area" class="search-box search-box02">
				<select id="sect_cd_area" class="sch-inp" name="" de-data="강좌 분야 세부 선택">
					<option value="1">고등학교</option>
				</select>
			</div>
		</div>
		<div class="filt-row">
			<div class="search-box search-box02">
				<p>요일 선택</p>
				<ul class="sear-ul">
					<li><a onclick="javascript:choose_yoil('1');">월요일</a></li>
					<li><a onclick="javascript:choose_yoil('2');">화요일</a></li>
					<li><a onclick="javascript:choose_yoil('3');">수요일</a></li>
					<li><a onclick="javascript:choose_yoil('4');">목요일</a></li>
					<li><a onclick="javascript:choose_yoil('5');">금요일</a></li>
					<li><a onclick="javascript:choose_yoil('6');">토요일</a></li>
					<li><a onclick="javascript:choose_yoil('7');">일요일</a></li>
					<li><a onclick="javascript:choose_yoil('');">전체</a></li>
				</ul>
				<selectclass="sch-inp" name="" de-data="강좌요일 선택">
					<option value="1">월요일</option>
				</select>
			</div>
		</div>
		<div class="filt-row">
			<div class="fil-child table">
				<div class="lect-chk">
					<label><input type="checkbox">유아 개월 수 </label>
				</div>
				<div class="fil-chinp"><input type="text" id="month_val" class="chinp-input"/>개월</div>
			</div>
		</div>
		<div class="filt-btnwr">
			<a onclick="javascript:search_reset();" class="btn btn01"><img src="/img/filter-icon01.png" alt="리셋"/>RESET</a>
			<a onclick="javascript:getList();" class="btn btn02">적용</a>
		</div>
	</div>
</div>

<Script>
	$(function(){
		$(".cour-filter").click(function(){
			$(".filter-wrap").fadeIn(200);	
		})
		$(".filter-close").click(function(){
			$(".filter-wrap").hide();
		})
	})
</script>