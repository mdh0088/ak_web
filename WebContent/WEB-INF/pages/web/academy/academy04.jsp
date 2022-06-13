<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />

<jsp:include page="/inc/breadcrumb.jsp" />
<script>

$(document).ready(function() {
	$("#chk_all").change(function() {
		if($("input:checkbox[name='chk_all']").is(":checked"))
		{
			$("input:checkbox[name='"+$("#chk_all").val()+"']").prop("checked", true);
		}
		else
		{
			$("input:checkbox[name='"+$("#chk_all").val()+"']").prop("checked", false);
		}
	});
	getList();
});
function getList() 
{
	$.ajax({
		type : "POST", 
		url : "./getBookList",
		dataType : "text",
		async : false,
		data : 
		{
			page : page,
			order_by : order_by,
			sort_type : sort_type,
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
				var lect_state='';
				var lect_state_nm='';
				for(var i = 0; i < result.list.length; i++)
				{
					
					lect_state ='sta02';
					if (result.list[i].START_YMD <= result.enterPeriod[i].sCurrentDate) {
						if (result.list[i].POSSIBLE_NO > 0 && result.list[i].END_YMD >= (result.enterPeriod[i].sCurrentDate-3)) {
							lect_state_nm ='전화문의';
						}else{
							lect_state_nm ='접수종료';
						}
					}else if(result.enterPeriod[i].okWebReceiptEnd=="true"){
						lect_state_nm ='방문접수';
						if (result.list[i].POSSIBLE_NO < 1) {
							lect_state_nm =' 마감';
						}
					}else if(result.list[i].POSSIBLE_NO < 1){
						lect_state_nm =' 마감'; //책가방 -> 대기로 바꿔야함
					}else if(result.list[i].POSSIBLE_NO < 4){
						lect_state='sta01';
						lect_state_nm =' 마감';
					}else if(result.enterPeriod[i].okWebReceipt=="true"){
						lect_state='sta03';
						lect_state_nm ='접수가능';
					}else{
						lect_state='sta03';
						lect_state_nm ='접수 前';
					}
					
					if (result.list[i].LECT_STATE=='마감') {
						lect_state='sta02';
					}else if(result.list[i].LECT_STATE=='마감임박'){
						lect_state='sta01';
					}else{
						lect_state='sta03';
					}
					
					inner +='<tr>';
					inner +='	<td class="td-chk">';
					inner +='		<input type="checkbox" id="chk_'+result.list[i].SUBJECT_CD+'" name="chk_val" value="">';
					inner +='		<label for="chk_'+result.list[i].SUBJECT_CD+'"></label>';
					inner +='	</td>';
					inner +='	<td><div class="colist-info"><b>'+result.list[i].STORE_NM+'</b></div></td>'
					inner +='	<td>'+result.list[i].SUBJECT_NM+'</td>';
					inner +='	<td>'+result.list[i].LECTURER_NM+'</td>';
					inner +='	<td>'+result.list[i].LECT_HOUR+'</td>';
					inner +='	<td>'+cutDate(result.list[i].START_YMD)+' ~ '+cutDate(result.list[i].END_YMD)+'</td>';
					inner +='	<td>'+comma(nullChkZero(result.list[i].REGIS_FEE))+'원</td>';
					inner +='	<td>'+comma(nullChkZero(result.list[i].FOOD_AMT))+'원</td>';
					
					var student_nm = "";
					if(nullChk(result.list[i].P_NM) != "")
					{
						student_nm += result.list[i].P_NM+",";
					}
					if(nullChk(result.list[i].C_NM1) != "")
					{
						student_nm += result.list[i].C_NM1+",";
					}
					if(nullChk(result.list[i].C_NM2) != "")
					{
						student_nm += result.list[i].C_NM2+",";
					}
					if(student_nm.length > 0)
					{
						student_nm = student_nm.substring(0, student_nm.length -1);
					}
					inner +='	<td>'+student_nm+'<br><a style="min-width: 55px;height: 32px;line-height: 33px;" class="btn btn02" onclick="changeStudent(\''+result.list[i].STORE+'\',\''+result.list[i].SUBJECT_CD+'\',\''+result.list[i].MAIN_CD+'\',\''+result.list[i].SECT_CD+'\')">변경</a></td>';
					inner +='	<td><p class="colist-sta colist-'+lect_state+'">'+lect_state_nm+'</p></td>';
					
					inner +='	<td><span class="myaca-del" onclick="goCartDelete(\''+result.list[i].SUBJECT_CD+'\')";><img src="/img/myaca-i05.png" alt="삭제하기"/></span>';
					
					inner +='		<input type="hidden" name="subjectCheckBox" value="'+result.list[i].SUBJECT_CD+'">';
					inner +='		<input type="hidden" id="store_'+result.list[i].SUBJECT_CD+'" value="'+result.list[i].STORE+'">';
					inner +='		<input type="hidden" id="period_'+result.list[i].SUBJECT_CD+'" value="'+result.list[i].PERIOD+'">';
					inner +='		<input type="hidden" id="subjectNm_'+result.list[i].SUBJECT_CD+'" value="'+result.list[i].SUBJECT_NM+'">';
					inner +='		<input type="hidden" id="start_ymd" value="'+result.list[i].START_YMD+'">';
					inner +='	</td>';
					
					inner +='</tr>';
				}
			}
			else
			{
				inner += '<tr>';
				inner += '	<td colspan="10"></td>';
				inner += '</tr>';
			}
			
			order_by = result.order_by;
			sort_type = result.sort_type;
			listSize = result.listSize;

			$("#list_target").html(inner);
			
			$(".paging").html(makePaging(result.page, result.s_page, result.e_page, result.pageNum, 1));
		}
	});	
}
var child1_no = "";
var child2_no = "";
var child3_no = "";
function changeStudent(store,subject_cd,main_cd,sect_cd)
{
	$("#bag_layer").remove();
	var is_two = false;
	$.ajax({
		type : "POST", 
		url : "/course/getIsTwo",
		dataType : "text",
		async : false,
		data : 
		{
			store : store,
			subject_cd : subject_cd
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{	
			console.log(data);
			if(data == "Y")
			{
				is_two = true;
			}
			else
			{
				is_two = false;
			}
		}
	});	
	$.ajax({
		type : "POST", 
		url : "/course/findChildByCust",
		dataType : "text",
		async : false,
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{	
			console.log(data);
			var result = JSON.parse(data);
			if(main_cd == "2" || main_cd == "3") //베이비면 체크박스, 아니면 라디오
			{
				if(result.list.length == 0) 
				{
					if (confirm("님은 자녀강좌를 신청할 수 없습니다. \n\n자녀강좌는 자녀회원등록후 자녀를 수강자로 선택하신 후 등록하십시오.\n\n수강자 변경을 하시겠습니까?")) 
					{
						location.href = "/academy/academy06";
					}
				}
			}
			var inner = "";
			inner += '<div class="edit-popup" id="bag_layer" >';
			inner += '	<div class="edit-bg"></div>'; 
			inner += '	<div class="edit-wrap edit-wrap02">';
			inner += '		<div class="exit" onclick="javascript:$(\'#bag_layer\').fadeOut(200);"><img src="/img/exit.png" alt="close" /></div>';
			inner += '		<h3>분당점 수강 회원 선택</h3>';
			inner += '		<p class="h3-p">수강 신청 대상 회원을 선택하세요.<br>';
			inner += '		자녀가 등록되어 있지 않은 경우 자녀회원 등록에서 등록 후 선택할 수 있습니다.';
			inner += '		</p>';
			
			inner += '		<div class="bag-popwr">';
			inner += '			<ul class="td-chk02">';
			if(main_cd == "2") //베이비면 체크박스, 아니면 라디오
			{
				
				inner += '<li><label for="bag_type"><input type="checkbox" id="selChild_0" name="selChild" value="S" checked="checked" disabled="true"><span class="bagbor">본인</span>'+result.cust_nm+' <span class="bag-birth">'+cutDate(result.bmd)+'</span></label></li>';
				for(var i = 0; i < result.list.length; i++)
				{
					var gender = result.list[i].GENDER == "M" ? '아들':'딸';
					inner += '<li><label for="bag_type"><input type="checkbox" id="selChild_'+result.list[i].CHILD_NO+'" name="selChild" value="S" ><span class="bagbor">'+gender+'</span>'+result.list[i].CHILD_NM+' <span class="bag-birth">'+cutDate(result.list[i].BIRTH)+'</span></label></li>';
				}
			}
			else if(main_cd == "3" && is_two) //베이비면 체크박스, 아니면 라디오
			{
				for(var i = 0; i < result.list.length; i++)
				{
					var gender = result.list[i].GENDER == "M" ? '아들':'딸';
					inner += '<li><label for="bag_type"><input type="checkbox" id="selChild_'+result.list[i].CHILD_NO+'" name="selChild" value="S" ><span class="bagbor">'+gender+'</span>'+result.list[i].CHILD_NM+' <span class="bag-birth">'+cutDate(result.list[i].BIRTH)+'</span></label></li>';
				}
			}
			else if(main_cd == "3" && !is_two) //베이비면 체크박스, 아니면 라디오
			{
				for(var i = 0; i < result.list.length; i++)
				{
					var gender = result.list[i].GENDER == "M" ? '아들':'딸';
					inner += '<li><label for="bag_type"><input type="radio" name="selChild" value="'+result.list[i].CHILD_NO+'" ><span class="bagbor">'+gender+'</span>'+result.list[i].CHILD_NM+' <span class="bag-birth">'+cutDate(result.list[i].BIRTH)+'</span></label></li>';
				}
			}
			else
			{
				inner += '<li><label for="bag_type"><input type="radio" id="selChild_0" name="selChild" value="0" checked="checked"><span class="bagbor">본인</span>'+result.cust_nm+' <span class="bag-birth">'+cutDate(result.bmd)+'</span></label></li>';
				for(var i = 0; i < result.list.length; i++)
				{
					var gender = result.list[i].GENDER == "M" ? '아들':'딸';
					inner += '<li><label for="bag_type"><input type="radio" name="selChild" value="'+result.list[i].CHILD_NO+'" ><span class="bagbor">'+gender+'</span>'+result.list[i].CHILD_NM+' <span class="bag-birth">'+cutDate(result.list[i].BIRTH)+'</span></label></li>';
				}
			}
			inner += '			</ul>';
			inner += '		</div>';
			inner += '		<div class="btn-center">';
			inner += '			<a class="btn btn01" href="../academy/academy06">자녀회원 등록하기 <img src="/img/myaca-i04.png" alt="수강자변경 아이콘"></a>';
			inner += '			<a class="btn btn02" onclick="changeStudent2(\''+store+'\',\''+subject_cd+'\',\''+main_cd+'\',\''+sect_cd+'\',\''+is_two+'\')">선텍완료</a>';
			inner += '		</div>';
			inner += '	</div>';
			inner += '</div>';
			$("body").append(inner);
			
			$("#bag_layer").fadeIn("200");
		}
	});	
	getBookCnt();
	
}
function changeStudent2(store,subject_cd,main_cd,sect_cd,is_two)
{
	child1_no = "";
	child2_no = "";
	child3_no = "";
	
	if(main_cd == "2")
	{
		child1_no = 0;
		var chkList = "";
		var childCnt = 0;
		$("input:checkbox[name='selChild']").each(function(){
			var child_no = $(this).attr('id').replace('selChild_', '');
		    if($(this).is(":checked") && child_no != '0')
	    	{
		    	if(childCnt == 0) {child2_no = child_no;}
		    	else if(childCnt == 1) {child3_no = child_no;}
		    	childCnt ++;
	    	}
		});
		if(childCnt > 2)
		{
			alert("자녀는 두명까지 선택가능합니다.");
			return;
		}
		else if(childCnt == 0)
		{
			alert("자녀 한명은 필수로 선택하셔야합니다.");
			return;
		}
	}
	else if(main_cd == "3" && is_two == "true")
	{
		var chkList = "";
		var childCnt = 0;
		$("input:checkbox[name='selChild']").each(function(){
			var child_no = $(this).attr('id').replace('selChild_', '');
			if($(this).is(":checked") && child_no != '0')
			{
				if(childCnt == 0) {child1_no = child_no;}
				else if(childCnt == 1) {child2_no = child_no;}
				childCnt ++;
			}
		});
		if(childCnt > 2)
		{
			alert("자녀는 두명까지 선택가능합니다.");
			return;
		}
		else if(childCnt == 0)
		{
			alert("자녀 한명은 필수로 선택하셔야합니다.");
			return;
		}
	}
	else
	{
		child1_no = $('input[name="selChild"]:checked').val();
	}
	$("#bag_layer").fadeOut("200");
		$.ajax({
			type : "POST", 
			url : "/course/changeStudent",
			dataType : "text",
			async : false,
			data : 
			{
				store : store,
				subject_cd : subject_cd,
				main_cd:main_cd,
				sect_cd:sect_cd,
				child1_no:child1_no,
				child2_no:child2_no,
				child3_no:child3_no
			},
			error : function() 
			{
				console.log("AJAX ERROR");
			},
			success : function(data) 
			{	
				console.log(data);
				var result = JSON.parse(data);
				
				if(result.isSuc == "success")
	    		{
	    			alert(result.msg);
	    			getList();
	    		}
	    		else
	    		{
	    			alert(result.msg);
	    		}
			}
		});	
	
}
function goCartDelete(subCd){
	var result = confirm('정말 취소하시겠습니까?');

	if(result) {
		$.ajax({
			type : "POST", 
			url : "./delBookList",
			dataType : "text",
			async : false,
			data : 
			{
				subject_cd : subCd,
				store : $('#store_'+subCd).val(),
				period : $('#period_'+subCd).val()
				
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
				
				getBookCnt();
				
				
			}
		});	
	}else{
		return;
	}
}
function goOrder()
{
	var chkList = "";
	$("input:checkbox[name='chk_val']").each(function(){
	    if($(this).is(":checked"))
    	{
    		chkList += $(this).attr("id").replace("chk_", "")+"_";
    	}
	});
	if(chkList == "")
	{
		alert("선택된 강좌가 없습니다.");
	}
	else
	{
		location.href="/academy/order?subject_cd="+chkList;
	}
}
</script>

<div class="lnb-top">
	<p class="lnb-entit eff-t">My Academy.</p>
	<p class="lnb-kotit eff-t">나의 책가방</p>
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<p class="sub-tit"><b>${kor_nm}(${store_nm})님께서</b> 책가방에 담아놓은 강좌내역입니다.</p>
		<div class="cour-left">
			<p class="cour-txt">다른 수강자의 내역을 보시려면 우측의 수강자변경 버튼을 클릭하여 다른 수강자로 변경 바랍니다.</p>
<!-- 			<a href="/academy/academy06" class="myaca-change">수강자변경<img src="/img/myaca-i04.png" alt="수강자변경 아이콘"/></a> -->
		</div>
		<div class="colist-wr myaca-wr01">
			<table>
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="chk_all" name="chk_all" value="chk_val"><label for="chk_all"></label>
						</th>
						<th>지점</th>
						<th>강좌명</th>
						<th>강사명</th>
						<th>시간</th>
						<th>강의기간</th>
						<th>수강료</th>
						<th>재료비</th>
						<th>수강회원</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="list_target">

				</tbody>
			</table>
			
		</div>
		<!--
 		<div class="pagination-wr">
			<div class="btn-right">
				<a class="btn btn02" href="#">강좌추가하기</a>
			</div>
			<ul class="paging">
				<li><a href="#" class="paging-prev"><img src="/img/cours-prev.png" alt="이전"></a></li>
				<li><a href="#" class="active">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#" class="paging-next"><img src="/img/cours-next.png" alt="다음"></a></li>
			</ul>
		</div>
		 -->
		<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/>
		<div class="btn-right">
				<a class="btn btn02" onclick="javascript:goOrder();">수강신청</a>
			</div>
		
		<div class="myaca-bot">
			<div class="table">
				<div class="myacabot-tit">
					<p>확인하세요!</p>
				</div>
				<div>
					<ul>
						<li>책가방에 담긴 강좌는 1일(24시간) 보관된 후 자동 삭제됩니다.</li>
						<li>여러 회원을 동시에 수강신청 할 수 없습니다.</li>
						<li>자녀회원 수강신청은 [자녀회원 등록]에서 자녀를 선택하신 후 신청해 주시기 바랍니다</li>
						<li>나의 책가방에 담긴 모든 강좌는 [결제하기] 버튼을 누르면 모두 한번에 결제진행 됩니다.</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />

