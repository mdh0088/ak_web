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
var selSect="${selSect}";
var day_flag="${day_flag}";
var subject_fg="${subject_fg}";
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
			sect_cd : selSect,
			yoil : day_flag,
			subject_fg : subject_fg,
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
					
					inner +='<div class="colist-div">';
					if (result.list[i].POSSIBLE_NO < 1) {
						inner +='<div class="qui-cart"><img src="/img/cart-icon2.png" alt="장바구니담기" onclick="goWaitAdd(\''+result.list[i].STORE+'\',\''+result.list[i].SUBJECT_CD+'\',\''+result.list[i].MAIN_CD+'\',\''+result.list[i].SECT_CD+'\')"></div>';
						
					}else{						
						inner +='<div class="qui-cart" onclick="goBookBag(\''+result.list[i].STORE+'\',\''+result.list[i].SUBJECT_CD+'\',\''+result.list[i].MAIN_CD+'\',\''+result.list[i].SECT_CD+'\')"><img src="/img/cart-icon.png" alt="장바구니담기"></div>';
					}
					inner +='	<div class="rec-box" onclick="javascript:lecture_view(\''+result.list[i].START_YMD+'\',\'/course/detail?store='+search_store+'&sSubject_cd='+result.list[i].SUBJECT_CD+'\')">';
					inner +='		<p class="rec-data">';
					inner +='			<span class="open">'+comma2(result.list[i].START_YMD.substring(4,8))+'</span>';
					inner +='			<span class="close">-'+comma2(result.list[i].END_YMD.substring(4,8))+'</span>';
					inner +='			<span class="year">'+result.list[i].START_YMD.substring(0,4)+'</span>';
					inner +='		</p>';
					
					inner +='		<div class="ani-eff image">';
					inner +='			<img src="'+result.image_dir+'wlect/'+result.list[i].THUMBNAIL_IMG+'" alt="이미지" onerror="this.src=\'/img/noimg_lect.png\'" style="width:302px; height:226px;">';
					inner +='		</div>';
					
					inner +='		<p class="rec-tit">'+result.list[i].SUBJECT_NM+'</p>';
					inner +='		<ul class="rec-ul">';
					
					inner +='			<li>';
					inner +='				<b class="colist-sta colist-sta03">';
					
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
					
					inner +='				</b>';
					inner +='				<span>'+store_nm+'</span>'+result.list[i].SUBJECT_FG_NM+' '+result.list[i].MAIN_NM;
					inner +='			</li>';
					
					inner +='			<li><span>'+result.list[i].LECTURER_NM+'</span>'+result.list[i].DAY+' '+result.list[i].LECT_HOUR+'</li>';
					inner +='			<li>';
					inner +='				<span>'+result.list[i].LECT_CNT+'회</span>'+comma(result.list[i].REGIS_FEE)+'원';
					inner +='				(재료비 ';
					
					if (result.list[i].FOOD_YN=='R') {
						inner +='별도)';
					}else if(result.list[i].FOOD_YN=='N'){
						inner +='없음)';
					}else{
						inner += comma(result.list[i].FOOD_AMT)+'원)';						
					}
					inner +='			</li>';
					
					inner +='		</ul>';
					
					inner +='	</div>';
					inner +='</div>';
				}
			}
			else
			{
				inner += '<div>';
				inner += '	등록된 강좌가 없습니다.';
				inner += '</div>';
			}
			
			sort_type = result.sort_type;
			listSize = result.listSize;

			$("#list_target").html(inner);
		
			
			$(".paging").html(makePaging(result.page, result.s_page, result.e_page, result.pageNum, 1));
			
		}
	});	
	
	
	
}

function reSort(act)
{	
	
	$('.sort').removeClass('active');
	$('#'+act).addClass('active');
	sort_type = act.replace("sort_", "");
	console.log(sort_type);
	
	getList();
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
				<li><a href="list01" class="active"><img src="/img/cours-list01.png" alt="갤러리형"/></a></li>
				<li><a href="list02"><img src="/img/cours-list02.png" alt="리스트형"/></a></li>
			</ul>
		</div>
		<div class="order-type">
			<ul>
				<li id="sort_reco_cnt"  class="sort active" onclick="reSort('sort_reco_cnt')">추천순</li>
				<li id="sort_regis_no"  class="sort" onclick="reSort('sort_regis_no')">인기순</li>
				<li id="sort_start_ymd" class="sort" onclick="reSort('sort_start_ymd')">최신순</li>
				<li id="sort_regis_fee" class="sort" onclick="reSort('sort_regis_fee')">가격순</li>
			</ul>
		</div>
		<div id="list_target" class="colist-wr reclist-wr">
		

		</div>
		
		<!--  
		<div class="pagination-wr">
			<ul class="paging">
				<li><a href="#" class="paging-prev"><img src="/img/cours-prev.png" alt="이전"/></a></li>
				<li><A href="#" class="active">1</a></li>
				<li><A href="#" >2</a></li>
				<li><A href="#" >3</a></li>
				<li><a href="#" class="paging-next"><img src="/img/cours-next.png" alt="다음"/></a></li>
			</ul>
		</div>
		-->
		<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/>
		
	</div>
</div>



<jsp:include page="/inc/footer.jsp" />

