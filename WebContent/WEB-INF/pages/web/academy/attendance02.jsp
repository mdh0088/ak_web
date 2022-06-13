<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />

<script>
$(document).ready(function() {
	getList();
	
});

var lect_cnt="";
var custList="";
function getList(type) 
{
	var store='';
    var size = document.getElementsByName("store").length;
    for(var i = 0; i < size; i++){
        if(document.getElementsByName("store")[i].checked == true){
        	store=document.getElementsByName("store")[i].value;
        }
    }
    custList="";
	$.ajax({
		type : "POST", 
		url : "./getAttendList",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			order_by : order_by,
			sort_type : sort_type,
			listSize : '10',
			store : "${store}",
			period : "${period}",
			subject_cd : "${subject_cd}"
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			$("#result").val(data);
			var result = JSON.parse(data);
			var inner = "";
			var dayChk = result.list[0].DAY_CHK.split('|'); //출석체크 값 세팅
			lect_cnt = dayChk.length-1;
			inner ='<tr>';
			inner +='	<th>NO.</th>';
			inner +='	<th>회원명</th>';
			inner +='	<th>성별</th>';
			
			for (var i = 0; i < dayChk.length-1; i++) {
				inner +='<th>'+(i+1)+'강</th>';
			}
			inner +='	<th class="td-10">비고</th>';
			inner += '</tr>';
			$("#list_head_target").html(inner);
			
			
			inner = '';
			if(result.list.length > 0)
			{
			
				for(var i = 0; i < result.list.length; i++){
					custList +=result.list[i].CUST_NO+"|";
					dayChk = result.list[i].DAY_CHK.split('|');
					inner +='<tr>';
					inner +='	<td>'+(i+1)+'</td>';	
					inner +='	<td>'+result.list[i].KOR_NM+'</td>';		
					inner +='	<td>'+result.list[i].SEX_FG+'</td>';			
					//inner +='	<input type="hidden" value="'+result.list[i].CUST_NO+'"  name="day_chk">';	
					for (var j = 0; j < dayChk.length-1; j++) {
						
						inner +='	<td><input type="checkbox" value="'+dayChk[j]+'"  name="day_chk"></td>';	
					}
					inner +='	<td><input class="attend-inp" name="content" type="text"/ value="'+nullChk(result.list[i].CONTENT)+'"></td>';	
					inner +='</tr>';
				}
			}else{
				inner += '<tr>';
				inner += '	<td colspan="16"><div class="no-data">지원자가 없습니다.</div></td>';
				inner += '</tr>';
			}
			order_by = result.order_by;
			sort_type = result.sort_type;
			listSize = result.listSize;

			$("#list_target").html(inner);
			
			$(".paging").html(makePaging(result.page, result.s_page, result.e_page, result.pageNum, 1));
			
			
			
		    var size = document.getElementsByName("day_chk").length;
		    for(var i = 0; i < size; i++){
		        if(document.getElementsByName("day_chk")[i].value == "O"){
		        	document.getElementsByName("day_chk")[i].checked=true;
		        }
		    }
			
			
			
		}
	});		
	
}
function save(){
	var chklist="";
	var size = document.getElementsByName("day_chk").length;
	
	
    for(var i = 0; i < size; i++)
    {
        if(document.getElementsByName("day_chk")[i].checked != true)
        {
        	if (document.getElementsByName("day_chk")[i].value=='O') 
        	{
        		document.getElementsByName("day_chk")[i].value='X';	
			}
        	chklist+=document.getElementsByName("day_chk")[i].value+'|';				
        }
        else
        {
        	chklist+='O|';
        }
    	if ( (i+1) % lect_cnt==0) 
    	{
    		chklist+='@';
		}
        
    }
    
   
    var size = document.getElementsByName("content").length;
    var contentList ="";
    for (var i = 0; i < size; i++) {
    	contentList +=document.getElementsByName("content")[i].value+"|";
		
	}
	
	if (custList=="") {
		alert("저장할 회원이 없습니다.");
		return;
	}
    
	
	
	$.ajax({
		type : "POST", 
		url : "./uptAttendList",
		dataType : "text",
		async : false,
		data : 
		{
			store : "${store}",
			period : "${period}",
			subject_cd : "${subject_cd}",
			custList : custList,
			chklist : chklist,
			contentList : contentList
				
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			
			var result = JSON.parse(data);
			alert(result.msg);
			getList();
			
		}
	});
	
    
}

function goPrint()
{
	document.getElementById("printForm").target = "printFrame";
	document.getElementById("printForm").submit();
}
</script>

<form id="printForm" name="printForm" method="post" action="./print_proc">
	<input type="hidden" id="result" name="result">
	<input type="hidden" id="day_value" name="day_value" value="${DAY_CHK}">
</form>
<iframe id="printFrame" name="printFrame" style="display:none;"></iframe>


<div class="lnb-top">
	<p class="lnb-entit eff-t">My Academy.</p>
	<p class="lnb-kotit eff-t">출석부 관리</p>
</div>


<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">

		<div class="plan-title">
			<em>Lecture Informations</em>
			${SUBJECT_NM}
			<span>
				<b>${DAY}</b>${LECT_HOUR_SET}
			</span>
		</div>

		<div class="attend-wr myaca-wr01">
			<table>
				<thead id="list_head_target">

				</thead>
				<tbody id="list_target">
					
					
				</tbody>
			</table>
			
		</div>
		<div class="pagination-wr">
			<div class="btn-right">
				<a class="btn btn02" onclick="Javascript:goPrint()">인쇄</a>
				<a class="btn btn02" onclick="Javascript:save()">저장</a>
			</div>
			<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/>
		</div>




	</div>
</div>
<jsp:include page="/inc/footer.jsp" />
