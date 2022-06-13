<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/WEB-INF/pages/web/common/lnb02.jsp" />





<script>
var jb = {}; //객체 선언
var search_arry =new Array();

$(document).ready(function() {
	//sessionStorage.clear();

	var get_list = JSON.parse(sessionStorage.getItem("searchList"));

	if (get_list!=null) {
		for (var i = 0; i < get_list.list.length; i++) {
			search_arry.push(get_list.list[i]);
		}
	
		var inner="";
		for (var i = 0; i < search_arry.length; i++) {
			inner +='<li id="search_list_'+i+'">'+search_arry[i]+'<img src="/img/cours-icon10.png" alt="태그삭제"/ onclick="search_list_del('+i+');"></li>';
		}
		$("#search_iist_target").html(inner);
	}
	//console.log(search_arry);
	console.log(jb);
	getList();

	
});

var click_cnt=0;
function search_list_del(idx){
	if (click_cnt!=0) {
		click_cnt=click_cnt+idx;
	}
	click_cnt++;
	search_arry[idx]="";
	console.log(jb);
	
	search_arry  = search_arry.filter(function(item) {
		return item !== null && item !== undefined && item !== '';
	});
	jb.list = search_arry;
	
	sessionStorage.setItem("searchList", JSON.stringify(jb));
	$('#search_list_'+idx).remove();
}

function getList(paging_type) 
{
	
	var sessionData = $('#search_name').val(); //객체에 값 넣어줌
	if (sessionData!="") {
		search_arry.push(sessionData);
		jb.list = search_arry;
		sessionStorage.setItem("searchList", JSON.stringify(jb));	
	}
	
	/*
	$.ajax({
		type : "POST", 
		url : "./getPeltList",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			order_by : order_by,
			sort_type : sort_type,
			listSize : '9',
			
			search_name : $("#search_name").val()
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
			if(result.list.length > 0)
			{
				for(var i = 0; i < result.list.length; i++)
				{
					yoil="";
					day_flag=result.list[i].DAY_FLAG;
					if(day_flag.split('')[0] == "1")
					{
						yoil += ",월";
					}
					if(day_flag.split('')[1] == "1")
					{
						yoil += ",화";
					}
					if(day_flag.split('')[2] == "1")
					{
						yoil += ",수";
					}
					if(day_flag.split('')[3] == "1")
					{
						yoil += ",목";
					}
					if(day_flag.split('')[4] == "1")
					{
						yoil += ",금";
					}
					if(day_flag.split('')[5] == "1")
					{
						yoil += ",토";
					}
					if(day_flag.split('')[6] == "1")
					{
						yoil += ",일";
					}
					yoil = yoil.substring(1, yoil.length);
					
					inner += '<div class="colist-div" onclick="location.href=\'/course/detail?store='+result.list[i].STORE+'&period='+result.list[i].PERIOD+'&subject_cd='+result.list[i].SUBJECT_CD+'\'">';
					inner += '	<div class="colist-data">';
					inner += '		<p><span>'+result.list[i].START_YMD+'</span> - '+result.list[i].END_YMD+'</p>'; //시작일 종료일 start_ymd end_ymd
					inner += '		<span>'+result.list[i].OPEN_YEAR+'</span>';//오픈연도 start_ymd 앞에잘라서
					inner += '	</div>';
					inner += '	<p class="colist-tit">'+result.list[i].SUBJECT_NM+'</p>'; //강좌명 subject_nm
					inner += '	<div class="colist-info">';
					inner += '		<b>'+result.list[i].STORE_NM+'</b>';	//store
					inner += '		<span>'+result.list[i].SUBJECT_FG_NM+'</span>';	//subject_Fg
					inner += '		<span>'+result.list[i].MAIN_NM+'</span>';	//main_cd
					inner += '	</div>';
					inner += '	<div class="colist-p">';
					inner += '		<p>'+result.list[i].WEB_LECTURER_NM+'</p>';		//web_lecturer
					inner += '		<p>'+yoil+' '+result.list[i].START_HOUR+' - '+result.list[i].END_HOUR+'</p>';		//lect_hour
					inner += '		<p>'+result.list[i].LECT_CNT+'회 '+result.list[i].REGIS_FEE+'원 (재료비 '+result.list[i].FOOD_AMT+'원)</p>';	//regist_fee, food_amt
					inner += '	</div>';
					
					if (result.list[i].LECT_STATE=='접수중') {
						inner += '	<p class="colist-sta colist-sta03">';	//전체 100에서 10%남으면 마감임박 						
					}else if (result.list[i].LECT_STATE=='마감임박') {
						inner += '	<p class="colist-sta colist-sta01">';
					}else{
						inner += '	<p class="colist-sta colist-sta02">';
					}
					inner += '	'+result.list[i].LECT_STATE+'</p>';
					inner += '</div>';
				}
			}
			else
			{
				inner += '<div>';
				inner += '	등록된 강좌가 없습니다.';
				inner += '</div>';
			}
			order_by = result.order_by;
			sort_type = result.sort_type;
			listSize = result.listSize;
			if(paging_type == "scroll")
			{
				if(result.list.length > 0)
				{
					$("#list_target").append(inner);
				}
			}
			else
			{
				$("#list_target").html(inner);
			}
			
			$(".paging").html(makePaging(result.page, result.s_page, result.e_page, result.pageNum, 1));
		}
	});	
	*/
	
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
		<div id="list_target" class="colist-wr">
		
			<div class="colist-div" onclick="location.href='/course/detail'">
			
				<div class="colist-data">
					<p><span>03.09</span> - 03.30</p>
					<span>2020</span>
				</div>
				<p class="colist-tit">사진 촬영 고급 기법 클래스</p>
				<div class="colist-info">
					<b>분당점</b>
					<span>정규</span>
					<span>성인</span>
				</div>
				<div class="colist-p">
					<p>강민영</p>
					<p>화 13:00 -14:10</p>
					<p>12회 210,000원 (재료비 40,000원)</p>
				</div>
				<p class="colist-sta colist-sta01">마감임박</p>
				
			</div>
			
			<div class="colist-div" onclick="location.href='/course/detail'">
				<div class="colist-data">
					<p><span>03.09</span> - 03.30</p>
					<span>2020</span>
				</div>
				<p class="colist-tit">사진 촬영 고급 기법 클래스</p>
				<div class="colist-info">
					<b>분당점</b>
					<span>정규</span>
					<span>성인</span>
				</div>
				<div class="colist-p">
					<p>강민영</p>
					<p>화 13:00 -14:10</p>
					<p>12회 210,000원 (재료비 40,000원)</p>
				</div>
				<p class="colist-sta colist-sta02">마감</p>
			</div>
			<div class="colist-div" onclick="location.href='/course/detail'">
				<div class="colist-data">
					<p><span>03.09</span> - 03.30</p>
					<span>2020</span>
				</div>
				<p class="colist-tit">사진 촬영 고급 기법 클래스</p>
				<div class="colist-info">
					<b>분당점</b>
					<span>정규</span>
					<span>성인</span>
				</div>
				<div class="colist-p">
					<p>강민영</p>
					<p>화 13:00 -14:10</p>
					<p>12회 210,000원 (재료비 40,000원)</p>
				</div>
				<p class="colist-sta colist-sta03">접수중</p>
			</div>
			<div class="colist-div" onclick="location.href='/course/detail'">
				<div class="colist-data">
					<p><span>03.09</span> - 03.30</p>
					<span>2020</span>
				</div>
				<p class="colist-tit">사진 촬영 고급 기법 클래스</p>
				<div class="colist-info">
					<b>분당점</b>
					<span>정규</span>
					<span>성인</span>
				</div>
				<div class="colist-p">
					<p>강민영</p>
					<p>화 13:00 -14:10</p>
					<p>12회 210,000원 (재료비 40,000원)</p>
				</div>
				<p class="colist-sta colist-sta01">마감임박</p>
			</div>
			<div class="colist-div" onclick="location.href='/course/detail'">
				<div class="colist-data">
					<p><span>03.09</span> - 03.30</p>
					<span>2020</span>
				</div>
				<p class="colist-tit">사진 촬영 고급 기법 클래스</p>
				<div class="colist-info">
					<b>분당점</b>
					<span>정규</span>
					<span>성인</span>
				</div>
				<div class="colist-p">
					<p>강민영</p>
					<p>화 13:00 -14:10</p>
					<p>12회 210,000원 (재료비 40,000원)</p>
				</div>
				<p class="colist-sta colist-sta02">마감</p>
			</div>
			<div class="colist-div" onclick="location.href='/course/detail'">
				<div class="colist-data">
					<p><span>03.09</span> - 03.30</p>
					<span>2020</span>
				</div>
				<p class="colist-tit">사진 촬영 고급 기법 클래스</p>
				<div class="colist-info">
					<b>분당점</b>
					<span>정규</span>
					<span>성인</span>
				</div>
				<div class="colist-p">
					<p>강민영</p>
					<p>화 13:00 -14:10</p>
					<p>12회 210,000원 (재료비 40,000원)</p>
				</div>
				<p class="colist-sta colist-sta03">접수중</p>
			</div>
			<div class="colist-div" onclick="location.href='/course/detail'">
				<div class="colist-data">
					<p><span>03.09</span> - 03.30</p>
					<span>2020</span>
				</div>
				<p class="colist-tit">사진 촬영 고급 기법 클래스</p>
				<div class="colist-info">
					<b>분당점</b>
					<span>정규</span>
					<span>성인</span>
				</div>
				<div class="colist-p">
					<p>강민영</p>
					<p>화 13:00 -14:10</p>
					<p>12회 210,000원 (재료비 40,000원)</p>
				</div>
				<p class="colist-sta colist-sta01">마감임박</p>
			</div>
			<div class="colist-div" onclick="location.href='/course/detail'">
				<div class="colist-data">
					<p><span>03.09</span> - 03.30</p>
					<span>2020</span>
				</div>
				<p class="colist-tit">사진 촬영 고급 기법 클래스</p>
				<div class="colist-info">
					<b>분당점</b>
					<span>정규</span>
					<span>성인</span>
				</div>
				<div class="colist-p">
					<p>강민영</p>
					<p>화 13:00 -14:10</p>
					<p>12회 210,000원 (재료비 40,000원)</p>
				</div>
				<p class="colist-sta colist-sta02">마감</p>
			</div>
			<div class="colist-div" onclick="location.href='/course/detail'">
				<div class="colist-data">
					<p><span>03.09</span> - 03.30</p>
					<span>2020</span>
				</div>
				<p class="colist-tit">사진 촬영 고급 기법 클래스</p>
				<div class="colist-info">
					<b>분당점</b>
					<span>정규</span>
					<span>성인</span>
				</div>
				<div class="colist-p">
					<p>강민영</p>
					<p>화 13:00 -14:10</p>
					<p>12회 210,000원 (재료비 40,000원)</p>
				</div>
				<p class="colist-sta colist-sta03">접수중</p>
			</div>
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

