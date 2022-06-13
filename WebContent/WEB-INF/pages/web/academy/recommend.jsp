<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />

<script>
$(document).ready(function(){
	getList('');
})
function getList(tag) 
{
	$("li").removeClass("active");
	$("#li_"+tag).addClass("active");
	$.ajax({
		type : "POST", 
		url : "./getRecoList",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			tag : tag,
			listSize : '10'
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
			if(result.list.length > 0)
			{
				for(var i = 0; i < result.list.length; i++)
				{
					inner += '<div class="colist-div">';
					if (result.list[i].POSSIBLE_NO < 1) {
						inner +='		<div class="qui-cart" onclick="goWaitAdd(\''+result.list[i].STORE+'\',\''+result.list[i].SUBJECT_CD+'\',\''+result.list[i].MAIN_CD+'\',\''+result.list[i].SECT_CD+'\')"><img src="/img/cart-icon2.png" alt="장바구니담기"></div>';
						
					}else{						
						inner +='		<div class="qui-cart" onclick="goBookBag(\''+result.list[i].STORE+'\',\''+result.list[i].SUBJECT_CD+'\',\''+result.list[i].MAIN_CD+'\',\''+result.list[i].SECT_CD+'\')"><img src="/img/cart-icon.png" alt="장바구니담기"></div>';
					}
					inner += '	<div class="rec-box" onclick="location.href=\'/course/detail?store='+result.list[i].STORE+'&main_cd='+result.list[i].MAIN_CD+'&sSubject_cd='+result.list[i].SUBJECT_CD+'\'">';
					inner += '		<P class="rec-data">';
					inner += '			<span class="open">'+result.list[i].START_YMD.substring(4,6)+'.'+result.list[i].START_YMD.substring(6,8)+'</span>';
					inner += '			<span class="close">-'+result.list[i].END_YMD.substring(4,6)+'.'+result.list[i].END_YMD.substring(6,8)+'</span>';
					inner += '			<span class="year">'+result.list[i].START_YMD.substring(0,4)+'</span>';
					inner += '		</p>';
					inner += '		<div class="ani-eff image">';
					inner += '			<img src="${image_dir}wlect/'+result.list[i].THUMBNAIL+'" alt="이미지" onerror="this.src=\'/img/noimg_lect.png\'" style="width:302px; height:226px;"/>';
					inner += '		</div>';
					inner += '		<p class="rec-tit">'+result.list[i].SUBJECT_NM+'</p>';
					inner += '		<ul class="rec-ul">';
					inner += '			<li><span>'+result.list[i].STORE_NM+'</span>'+result.list[i].SUBJECT_FG_NM+' '+result.list[i].MAIN_NM+'</li>';
					inner += '			<li><span>'+result.list[i].WEB_LECTURER_NM+'</span>'+cutYoil(result.list[i].DAY_FLAG)+' '+cutLectHour(result.list[i].LECT_HOUR)+'</li>';
					inner += '			<li><span>'+result.list[i].LECT_CNT+'회</span>'+comma(nullChkZero(result.list[i].REGIS_FEE))+'원 (재료비 '+comma(nullChkZero(result.list[i].FOOD_AMT))+'원)</li>';
					inner += '		</ul>';
					inner += '	</div>';	
					inner += '</div>';
				}
			}
			else
			{
			}
			$("#list_target").html(inner);
			
			$(".paging").html(makePaging(result.page, result.s_page, result.e_page, result.pageNum, 1));
		}
	});	
}
</script>

<div class="lnb-top">
	<p class="lnb-entit eff-t">AK Academy</p>
	<p class="lnb-kotit eff-t">추천강좌</p>
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<div class="rec-ptabwr">
			<ul class="rec-tab">
				<c:forEach items="${fn:split(tagList, ',') }" var="item">
					<li id="li_${item}"><a onclick="javascript:getList('${item}');">#${item}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="colist-wr reclist-wr" id="list_target">
		</div>
		<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/>
	</div>
</div>


<jsp:include page="/inc/footer.jsp" />

