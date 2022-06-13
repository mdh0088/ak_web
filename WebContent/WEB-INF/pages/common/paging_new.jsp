<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
var page = 1;
var order_by = "";
var sort_type = "";
var scr_stat = getCookie("scr_stat");
$(document).ready(function(){
// 	if(scr_stat == "ON")
// 	{
// 		$(".listSize").hide();
// 		jQuery(window).scroll(function() {
// 			var scrollTop = $(this).scrollTop();
// 	        var innerHeight = $(this).innerHeight();
// 	        var scrollHeight = $(this).prop('scrollHeight');
	
// 	        if($(document).height() <= $(window).scrollTop() + $(window).height())
// 	        {
// 	        	page = page + 1;
// 	        	pageMoveScroll(page);
// 	        }
// 		});
// 	}
// 	else
// 	{
// 		$(".listSize").show();
// 	}
})
function makePaging(nowPage, s_page, e_page, pageNum, val)
{
	page = nowPage;
	var inner = "";
// 	if(scr_stat == "ON")
// 	{
// 		inner += '<div class="page_num" style="display:none;">';
// 	}
// 	else
// 	{
		inner += '<ul class="page_num" style="display:block;">';
// 	}
	if(Number(page) > 5)
	{
		//inner += '		<li><a class="first" onclick="javascript:pageMoveAjax(1);"> ◀◀ </a></li>';
		//inner += '    	<li><a class="prev" onclick="javascript:pageMoveAjax('+(Number(s_page)-1)+');"> ◀ </a></li>';
		inner += '    	<li><a class="paging-prev" onclick="javascript:pageMoveAjax('+(Number(s_page)-1)+');"> <img src="/img/cours-prev.png" alt="이전"> </a></li>';
	}
	var pagingCnt = 0;
	if(e_page != '0')
	{
		for(var i = Number(s_page); i <= Number(e_page); i++)
		{
			pagingCnt ++;
			if(i == page)
			{
				inner += '			<li><a onclick="javascript:pageMoveAjax('+i+');" id="p_'+i+'" class="p_btn active">'+i+'</a></li>';
			}
			else
			{
				inner += '			<li><a onclick="javascript:pageMoveAjax('+i+');" id="p_'+i+'" class="p_btn">'+i+'</a></li>';
			}
		}
	}
	if(e_page == '0')
	{
		inner += '		 <li><a onclick="javascript:pageMoveAjax(1);" id="p_1" class="p_btn active">1</a></li>';
	}
	if(pageNum != page)
	{
		if(Number(pageNum) > 5)
		{
			if(pagingCnt > 4)
			{
				if(Number(e_page)+1 > Number(pageNum))
				{
					inner += '            		<li><a class="paging-next" onclick="javascript:pageMoveAjax('+pageNum+');"> <img src="/img/cours-next.png" alt="다음"> </a></li>'; 
					//inner += '            		<li><a class="next" onclick="javascript:pageMoveAjax('+pageNum+');"> ▶ </a></li>'; 
					//inner += '            		<li><a class="last" onclick="javascript:pageMoveAjax('+pageNum+');"> ▶▶ </a></li>'; 
				}
				else
				{
					inner += '					<li><a class="paging-next" onclick="javascript:pageMoveAjax('+(Number(e_page)+1)+');"> <img src="/img/cours-next.png" alt="다음"> </a></li>';
					//inner += '					<li><a class="next" onclick="javascript:pageMoveAjax('+(Number(e_page)+1)+');"> ▶ </a></li>';
					//inner += '            		<li><a class="last" onclick="javascript:pageMoveAjax('+pageNum+');"> ▶▶ </a></li>'; 
				}
			}
		}
	}
	inner += '</ul>';
	return inner;
}
function reSortAjax(act)
{
	sort_type = act.replace("sort_", "");
	console.log(sort_type);
	console.log(order_by);
	if(order_by == "")
	{
		order_by = "desc";
		$("#"+act).attr("src", "/img/th_down.png");
	}
	else if(order_by == "desc")
	{
		order_by = "asc";
		$("#"+act).attr("src", "/img/th_up.png");
	}
	else if(order_by == "asc")
	{
		order_by = "desc";
		$("#"+act).attr("src", "/img/th_down.png");
	}
	page = 1;
	getList();
}
function pageMoveAjax(nowPage)
{
	page = nowPage;
	getList();
}
function pageMoveScroll(nowPage)
{
	page = nowPage;
	getList('scroll');
}

</script>
<div class="paging"></div>