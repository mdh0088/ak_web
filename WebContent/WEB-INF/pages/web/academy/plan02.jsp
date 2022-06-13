<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />

<script>
$(document).ready(function() {
	if(Number('${list_size}') > 0)
	{
		if(nullChk('${list[0].IMAGE_PIC}') != "")
		{
			$(".upload-name").val('${list[0].IMAGE_PIC}');
		}
		var etc_arr = '${list[0].ETC}'.split("|");
		
		for(var i = 0; i < etc_arr.length-1; i++)
		{
			add_contents();
			var lect_cnt = etc_arr[i].split('회차 : ')[0];
			var lect_contents = etc_arr[i].split('회차 : ')[1];
			$("#lect_cnt"+(i+1)).val(lect_cnt);
			$("#lect_contents"+(i+1)).val(lect_contents);
		}
	}
});
var contents_cnt = 1;
function add_contents()
{
	var inner = "";
	var lect_cnt = Number('${data.LECT_CNT}');
	inner += '<div class="cu-inp" id="contents_tr_'+contents_cnt+'">';
	inner += '	<select de-data="1회차" id="lect_cnt'+contents_cnt+'" name="lect_cnt">';
	for(var i = 1; i <= lect_cnt; i++)
	{
		inner += '		<option value="'+i+'">'+i+'회차</option>';
	}
	inner += '	</select>';
	inner += '	<input type="text" id="lect_contents'+contents_cnt+'" name="lect_contents" placeholder="내용을 입력해주세요.">';
	inner += '	<div class="td-btn">';
	inner += '		<a class="btn-add" onclick="javascript:add_contents();">추가</a>';
	inner += '		<a class="btn-del" onclick="remove_contents('+contents_cnt+')">삭제</a>';
	inner += '	</div>';
	inner += '</div>';
	$("#target_contents").append(inner);
	contents_cnt ++;
}
function remove_contents(idx)
{
	$("#contents_tr_"+idx).remove();
}
function fncSubmit()
{
	var validationFlag = "Y";
	$(".notEmpty").each(function() 
	{
		if ($(this).val() == "" || $(this).val() == "0") 
		{
			alert(this.dataset.name+"을(를) 입력해주세요.");
			$(this).focus();
			validationFlag = "N";
			return false;
		}
	});
	if(validationFlag == "Y")
	{
		var lect_cnt_list = "";
		$("[name='lect_cnt']").each(function() 
		{
			lect_cnt_list += $(this).val()+"|";
		});
		$("#lect_cnt_list").val(lect_cnt_list);
		
		
		var lect_contents_list = "";
		$("[name='lect_contents']").each(function() 
		{
			lect_contents_list += $(this).val()+"|";
		});
		$("#lect_contents_list").val(lect_contents_list);
		
		$("#fncForm").ajaxSubmit({
			success: function(data)
			{
				console.log(data);
				var result = JSON.parse(data);
	    		if(result.isSuc == "success")
	    		{
	    			alert(result.msg);
	    			location.reload();
	    		}
	    		else
	    		{
	    			alert(result.msg);
	    		}
			}
		});
	}
}

$(window).ready(function(){
	$("#attach").on('change',function(){
	  var fileName = $("#attach").val();
	  $(".upload-name").val(fileName);
	});
	
})
</script>
<div class="lnb-top">
	<p class="lnb-entit eff-t">AK Academy.</p>
	<p class="lnb-kotit eff-t">강의 계획서 등록/수정</p>
</div>


<div class="lect-sec bg-gray">
	<div class="mu-grid">
		<div class="plan-title">
			<em>Lecture Informations</em>
			${data.SUBJECT_NM}
			<span>${data.WEB_LECTURER_NM} 강사</span>
		</div>

		<div class="lect-wr03">			
			<form id="fncForm" name="fncForm" method="POST" action="./plan02_proc" enctype="multipart/form-data">
				<table>
					<colgroup>
						<col style="width:18%;" />
						<col style="width:32%;" />
						<col style="width:18%;" />
						<col style="width:32%;" />
	
					</colgroup>
					<tr>
						<th>성명</th>
						<td>${login_name}</td>
						<th>지점</th>
						<td>${data.STORE_NAME}</td>
					</tr>
					<tr>
						<th>강의 일정</th>
						<td>
							<fmt:parseDate value="${data.START_YMD}" var="START_YMD" pattern="yyyyMMdd"/><fmt:formatDate value="${START_YMD}" pattern="yyyy년 MM월 dd일"/>
							~
							<fmt:parseDate value="${data.END_YMD}" var="END_YMD" pattern="yyyyMMdd"/><fmt:formatDate value="${END_YMD}" pattern="yyyy년 MM월 dd일"/>
						</td>
						<th>횟수</th>
						<td>${data.LECT_CNT}회</td>
					</tr>
					<tr>
						<th>강의 시간</th>
						<td>
						<c:set var="day_flag" value="${data.DAY_FLAG }"/>
						<script>
						var yoil = "";
						var day_flag = '${day_flag}';
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
						document.write(yoil);
						</script>
						(${fn:substring(data.LECT_HOUR,0,2)}:${fn:substring(data.LECT_HOUR,2,4)}~${fn:substring(data.LECT_HOUR,4,6)}:${fn:substring(data.LECT_HOUR,6,8)})
						</td>
						<th>재료비</th>
						<td><fmt:formatNumber value="${data.FOOD_AMT}" pattern="###, &nbsp###"/></td>
					</tr>
					<tr>
						<th>이미지</th>
						<td colspan="3">		
							<div class="filebox"> 
								<label for="attach"><img src="/img/img insert.png" /> </label> 
								<input type="file" id="attach" name="attach"> 
								
								<input class="upload-name" value="이미지를 첨부해주세요.">
								<span>* 최대 5MB의 이미지 파일을 등록할 수 있습니다.(이미지 사이즈 1284x238 권장)</span>
							</div>
						</td>					
					</tr>
						<tr>
						<th>대표약력</th>
						<td colspan="3">		
							<textarea placeholder="내용을 입력해주세요." id="lecturer_career" name="lecturer_career" style="height: 200px; margin-top: 15px;"  class="inputDisabled" readOnly>${list[0].LECTURER_CAREER}</textarea>
						</td>					
					</tr>
					<tr>
						<th>강의 개요</th>
						<td colspan="3">		
							<textarea placeholder="내용을 입력해주세요." id="lecture_content" name="lecture_content" style="height: 200px; margin-top: 15px;"  class="inputDisabled" readOnly>${list[0].LECTURE_CONTENT}</textarea>
						</td>					
					</tr>
					<tr>
						<th>컬리큘럼</th>
						<td colspan="3" id="target_contents">	
							
						</td>					
					</tr>
				</table>
				<input type="hidden" id="lect_cnt_list" name="lect_cnt_list">
				<input type="hidden" id="lect_contents_list" name="lect_contents_list">
				<input type="hidden" id="store" name="store" value="${store}">
				<input type="hidden" id="period" name="period" value="${period}">
				<input type="hidden" id="subject_cd" name="subject_cd" value="${subject_cd}">
				<input type="hidden" id="subject_nm" name="subject_nm" value="${data.SUBJECT_NM}">
			</form>
		</div>
		<div class="btn-center">
			<a class="btn btn01" onclick="#">목록으로</a>
			<a class="btn btn02" onclick="javascript:fncSubmit();">제출하기</a>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />