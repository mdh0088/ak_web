<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/WEB-INF/pages/web/common/lnb02.jsp" />

<script>
var jb = {};
var search_arry =new Array();

var search_store="${search_store}";
var search_main_cd="${search_main_cd}";
var search_sect_cd="${search_sect_cd}";
var search_yoil="${search_yoil}";
var search_monthVal ="${month_no}";
var search_name="${search_val}";
var sort_type ="reco_cnt";


$(document).ready(function() {
	getSeachList(); 
	console.log(search_arry);
	
	if (search_monthVal!="") {
		$('#month_val').val(search_monthVal);
	}
	
	getList();

	
});


function getSeachList(){ 
	
	search_arry=[];
	var get_list = JSON.parse(sessionStorage.getItem("searchList"));
	if (get_list!=null) { 
		
		for (var i = 0; i < get_list.list.length; i++) {
			search_arry.push(get_list.list[i]);
		}
	
		var inner="";
		for (var i = 0; i < search_arry.length; i++) {
			inner +='<li id="search_list_'+i+'"><span  onclick="searhByList(\''+search_arry[i]+'\');">'+search_arry[i];
			inner +='</span><b class="exit-img" onclick="search_list_del('+i+');"><img src="/img/cours-icon10.png" alt="태그삭제"/ ></b></li>';
		}
		$("#search_iist_target").html(inner);
	}
}

function searhByList(idx){
	search_name=idx;
	getList('search');
}

function search_list_del(idx){
	search_arry.splice(idx,1); 
	jb.list = search_arry; 
	sessionStorage.setItem("searchList", JSON.stringify(jb)); 
	$('#search_list_'+idx).remove(); 
	getSeachList(); 
}


//현재 시간과 비교후 강좌 종료일이 과거일시 접수가 종료 되었다는 ALERT 실행 2014.05.30 BY KSM
//course/detail?
function lecture_view(start_ymd, url)
{
	console.log(start_ymd.substring(0, 4));
	console.log(start_ymd.substring(4,6)-1);
	console.log(start_ymd.substring(6,8));
	
	var date_start = new Date(start_ymd.substring(0, 4), start_ymd.substring(4,6)-1, start_ymd.substring(6,8) ,11 ,59 );
	var current_date = new Date();
	
	
	console.log(date_start);
	console.log(current_date);
	
	var expired = "F";

	if(date_start <= current_date)
	{
		alert("접수가 종료 되었습니다.");
		var expired = "T";
	}
	location.href = url+"&expired="+expired;	
	
}

function getList(type) 
{
	if (type!="search") {
		search_name = $('#search_name').val();
		if (search_name!="") {
			search_arry.push(search_name);
			jb.list = search_arry;
			sessionStorage.setItem("searchList", JSON.stringify(jb));	
		}
		getSeachList();
	}
	
	if (search_store=="") {
		search_store="03";
	}
	
	$.ajax({
		type : "POST", 
		url : "./getPeltList",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			sort_type : sort_type,
			listSize : '9',
			
			search_name : search_name,
			store : search_store,
			main_cd : search_main_cd,
			sect_cd : search_sect_cd,
			yoil : search_yoil,
			month_val : $('#month_val').val()
			
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
			var yoil = "";
			var day_flag = '';
			var store_nm="";
			
			if(result.list.length > 0)
			{
				for(var i = 0; i < result.list.length; i++)
				{				
					if(result.list[i].STORE=='01'){
						store_nm='구로점';
					}else if(result.list[i].STORE=='02'){
						store_nm='수원점';
					}else if(result.list[i].STORE=='03'){
						store_nm='분당점';						
					}else if(result.list[i].STORE=='04'){
						store_nm='평택점';
					}else if(result.list[i].STORE=='05'){
						store_nm='원주점';
					}
					
					inner +='<tr onclick="javascript:lecture_view(\''+result.list[i].START_YMD+'\',\'/course/detail?store='+search_store+'&sSubject_cd='+result.list[i].SUBJECT_CD+'\')">';
					inner +='	<td><div class="colist-info"><b>'+store_nm+'</b></div></td>';
					inner +='	<td>'+result.list[i].MAIN_NM+'</td>';
					inner +='	<td>('+result.list[i].SUBJECT_FG_NM+')'+result.list[i].SUBJECT_NM+'</td>';
					inner +='	<td>'+result.list[i].LECTURER_NM+'</td>';
					inner +='	<td>('+result.list[i].DAY+')'+result.list[i].LECT_HOUR+'</td>';
					inner +='	<td>'+result.list[i].START_YMD.substring(0,4)+'. '+comma2(result.list[i].START_YMD.substring(4,8))+' - '+comma2(result.list[i].END_YMD.substring(4,8))+'</td>';
					inner +='	<td>('+result.list[i].LECT_CNT+'회)'+result.list[i].REGIS_FEE+'원</td>';
					inner +='	<td>'+result.list[i].FOOD_AMT+'</td>';
					inner +='	<td><span class="colist-save"><img src="/img/cours-icon11.png" alt="담기"/></span></td>';
					inner +='	<td>';
					if (result.list[i].START_YMD <= result.sCurrentDate) {
						if (result.list[i].POSSIBLE_NO > 0 && result.list[i].END_YMD >= (result.sCurrentDate-3)) {
							inner +='전화문의';
						}else{
							inner +='접수종료';
						}
					}else if(result.okWebReceiptEnd=="true"){
						inner +='방문접수';
						if (result.list[i].POSSIBLE_NO < 1) {
							inner +=' 마감';
						}
					}else if(result.list[i].POSSIBLE_NO < 1){
						inner +='마감'; //책가방 -> 대기로 바꿔야함
					}else if(result.list[i].POSSIBLE_NO < 4){
						inner +='마감임박';
					}else if(result.okWebReceipt=="true"){
						inner +='접수가능';
					}else{
						inner +='접수 前';
					}
					inner +='	</td>';
					
					inner +='</tr>';
					
				}
			}
			else
			{
				inner += '<tr>';
				inner += '	<td colspan="10">등록된 강좌가 없습니다.</td>';
				inner += '</tr>';
			}
			
			sort_type = result.sort_type;
			listSize = result.listSize;

			$("#list_target").html(inner);
		
			
			$(".paging").html(makePaging(result.page, result.s_page, result.e_page, result.pageNum, 1));
			
		}
	});	
	
	
	
}
</script>
<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<div class="cour-seartop">
			<div class="cour-sear table">
				<div class="search-l">
					<input type="text" id="search_name" class="cour-search" placeholder="강사명 또는 강좌명을 검색해주세요. ">
					<img class="cour-filter" src="/img/cours-icon06.png" alt="필터"/>
				</div>
				<div class="search-r">
					<a class="cour-searbtn" onclick="javascript:getList();" >SEARCH</a>
				</div>
			</div>
			<ul id="search_iist_target" class="cour-tag">
				
			</ul>
		</div>
		<div class="list-typeul">
			<ul class="type-ul">
				<li><a href="list01"><img src="/img/cours-list01.png" alt="갤러리형"/></a></li>
				<li><a href="list02" class="active"><img src="/img/cours-list02.png" alt="리스트형"/></a></li>
			</ul>
		</div>
		<div class="colist-wr cour-list02">
			<table>
				<thead>
					<tr>
						<th>지점</th>
						<th>대상</th>
						<th>강좌명</th>
						<th>강사명</th>
						<th>시간</th>
						<th>강의기간</th>
						<th>수강료</th>
						<th>재료비</th>
						<th>접수현황</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="list_target">
					<tr onclick="location.href='/course/detail.php'">
						<td><div class="colist-info"><b>분당점</b></div></td>
						<td>성인</td>
						<td>(정규)사진 촬영 고급 기법 클래스</td>
						<td>강민영</td>
						<td>(화)13:00-14:10</td>
						<td>2019. 03.09 - 03.30</td>
						<td>(12회)210,000원</td>
						<td>40,000원</td>
						<td><p class="colist-sta colist-sta02">마감</p></td>
						<td><span class="colist-save"><img src="/img/cours-icon11.png" alt="담기"/></span></td>
					</tr>
					<tr onclick="location.href='/course/detail.php'">
						<td><div class="colist-info"><b>분당점</b></div></td>
						<td>성인</td>
						<td>(정규)사진 촬영 고급 기법 클래스</td>
						<td>강민영</td>
						<td>(화)13:00-14:10</td>
						<td>2019. 03.09 - 03.30</td>
						<td>(12회)210,000원</td>
						<td>40,000원</td>
						<td><p class="colist-sta colist-sta01">마감임박</p></td>
						<td><span class="colist-save"><img src="/img/cours-icon11.png" alt="담기"/></span></td>
					</tr>
					<tr onclick="location.href='/course/detail.php'">
						<td><div class="colist-info"><b>분당점</b></div></td>
						<td>성인</td>
						<td>(정규)사진 촬영 고급 기법 클래스</td>
						<td>강민영</td>
						<td>(화)13:00-14:10</td>
						<td>2019. 03.09 - 03.30</td>
						<td>(12회)210,000원</td>
						<td>40,000원</td>
						<td><p class="colist-sta colist-sta03">접수중</p></td>
						<td><span class="colist-save"><img src="/img/cours-icon11.png" alt="담기"/></span></td>
					</tr>
				</tbody>
			</table>
			
		</div>
		<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/>
	</div>
</div>


<jsp:include page="/inc/footer.jsp" />

