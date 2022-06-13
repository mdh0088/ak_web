<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="ak_web.classes.*" %>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb06.jsp" />
<jsp:include page="/inc/date_picker/date_picker.html"/>

<script>
function init()
{
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
}
function courseSearch()
{
	$('#search_layer').fadeIn(200);	
	var cl = "";
	$("[name='chkBranch']").each(function() 
	{
		if( $(this).prop("checked")==true )
		{
			cl += $(this).val()+",";
		}
	});
	if(cl == "")
	{
		alert("지점을 선택해주세요.");
		return;
	}
	if($('input[name="decum"]:checked').val() == "decum1")//원천징수영수증
	{
		$.ajax({
			type : "POST", 
			url : "./getSubjectTax",
			dataType : "text",
			async : false,
			data : 
			{
				year : $("#selYear").val(),
				season : $("#selSeason").val(),
				branch : cl
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
				
				
				if(result.length > 0)
				{
					for(var i = 0; i < result.length; i++)
					{
						inner += '<tr>';
						inner += '	<td><input type="checkbox" id="chk_'+result[i].STORE+'_'+result[i].PERIOD+'_'+trim(result[i].SUBJECT_CD)+'" name="chk_val" value=""></td>';
						inner += '	<td>'+$("#selYear").val()+'년도 '+$("#selSeason").val()+'</td>';
						inner += '	<td>'+result[i].STORE_NM+'</td>';
						inner += '	<td>'+result[i].SUBJECT_NM+'</td>';
						inner += '	<td>'+cutYoil(result[i].DAY_FLAG)+' ('+cutLectHour(result[i].LECT_HOUR)+')</td>';
						inner += '</tr>';
					}
				}
				else
				{
					inner += '<tr>';
					inner += '	<td colspan="5"><div class="no-data">검색결과가 없습니다.</div></td>';
					inner += '</tr>';
				}
				
				$("#subject_target").html(inner);
				init();
			}
		});
	}
	else if($('input[name="decum"]:checked').val() == "decum2")//출강증명서
	{
		$.ajax({
			type : "POST", 
			url : "./getSubjectCert",
			dataType : "text",
			async : false,
			data : 
			{
				start_ymd : $("#start_ymd").val(),
				end_ymd : $("#end_ymd").val(),
				branch : cl
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
				
				
				if(result.length > 0)
				{
					for(var i = 0; i < result.length; i++)
					{
						inner += '<tr>';
						inner += '	<td><input type="checkbox" id="chk_'+result[i].STORE+'_'+result[i].PERIOD+'_'+trim(result[i].SUBJECT_CD)+'" name="chk_val" value=""></td>';
						inner += '	<td>'+$("#selYear").val()+'년도 '+$("#selSeason").val()+'</td>';
						inner += '	<td>'+result[i].STORE_NM+'</td>';
						inner += '	<td>'+result[i].SUBJECT_NM+'</td>';
						inner += '	<td>'+cutYoil(result[i].DAY_FLAG)+' ('+cutLectHour(result[i].LECT_HOUR)+')</td>';
						inner += '</tr>';
					}
				}
				else
				{
					inner += '<tr>';
					inner += '	<td colspan="5"><div class="no-data">검색결과가 없습니다.</div></td>';
					inner += '</tr>';
				}
				
				$("#subject_target").html(inner);
				init();
			}
		});
	}
}
function fncSubmit()
{
	var cv = "";
	$("[name='chk_val']").each(function() 
	{
		if( $(this).prop("checked")==true )
		{
			cv += $(this).attr("id").replace("chk_", "")+"|";
		}
	});
	
	if(cv == "")
	{
		alert("강좌를 선택해주세요.");
		return
	}
	else
	{
		$("#cv").val(cv);
		if($('input[name="decum"]:checked').val() == "decum1")//원천징수영수증
		{
			$("#fncForm").attr("action", "./viewTax");
		}
		if($('input[name="decum"]:checked').val() == "decum2")//출강증명서
		{
			$("#fncForm").attr("action", "./viewCert");
		}
		$("#fncForm").submit();
	}
}
$(function(){
	$(".td-chk02 input").each(function(){
		$(this).click(function(){
			if($(this).attr("type") == "radio")
			{
				var chk = $(this).val();
				if(chk=="decum1"){
					$(".btn-docu02").hide();
					$(".btn-docu01").show();
				}else{
					$(".btn-docu01").hide();
					$(".btn-docu02").show();
				}
			}
		})
		
	})
})
</script>
<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		
		<p class="sub-tit">증명서 발급 신청</p>
		<div class="cour-left">
			<p class="cour-txt">증명서는 신청일자부터 일주일 후 신청 지점에서 발급 받으실 수 있습니다. </p>
		</div>

		<div class="certi-wr">
			<table>
				<tr>
					<th>신청 지점</th>
					<td>
						<ul class="td-chk02">
							<c:forEach var="i" items="${branchList}" varStatus="loop">
								<c:if test="${i.SUB_CODE eq '03' }">
									<li><label><input type="checkbox" name="chkBranch" value="${i.SUB_CODE}" checked>${i.SHORT_NAME }</label></li>
								</c:if>
								<c:if test="${i.SUB_CODE ne '03' }">
									<li><label><input type="checkbox" name="chkBranch" value="${i.SUB_CODE}">${i.SHORT_NAME }</label></li>
								</c:if>
								
							</c:forEach>
						</ul>	
					</td>
				</tr>

				<tr>
					<th>신청 서류</th>
					<td>
						<ul class="td-chk02">
							<li><label><input type="radio" name="decum" value="decum1" checked>원천징수영수증</label></li>
							<li><label><input type="radio" name="decum" value="decum2">출강증명서</label></li>
						</ul>	
					</td>
				</tr>

				<tr>
					<th>용도</th>
					<td>
						<select de-data="용도">
							<option value="">선택</option>
							<option value="">선택</option>
							<option value="">선택</option>
						</select>
					</td>
				</tr>

				<tr class="btn-docu01">
					<th>신청 기간</th>
					<td>
						<span class="txt">연도 </span>
						<select class="y-sel" id="selYear" name="selYear" de-data="${year}">
							<%
							int year = Utils.checkNullInt(request.getAttribute("year"));
							for(int i = year+1; i > 1980; i--)
							{
								if(i == year)
								{
									%>
									<option value="<%=i%>" selected><%=i%></option>
									<%
								}
								else
								{
									%>
									<option value="<%=i%>"><%=i%></option>
									<%
								}
							}
							%>
						</select>
						<span class="txt y-sels">학기 </span>
						<select de-data="봄학기" id="selSeason" name="selSeason" onchange="">
							<option value="봄학기">봄학기</option> 
							<option value="여름학기">여름학기</option> 
							<option value="가을학기">가을학기</option> 
							<option value="겨울학기">겨울학기</option> 
						</select>
					</td>
				</tr>
				<tr class="btn-docu02">
					<th>신청 기간</th>
					<td>
						<div>
							<input type="text" class="date-i ready-i cal-inp" id="start_ymd" name="start_ymd"/>
							<span class="p-bar">-</span>
							<input type="text" class="date-i ready-i cal-inp" id="end_ymd" name="end_ymd"/>
						</div>
					</td>
				</tr>

			</table>
		</div>


		<!-- 기본 -->
		<div class="btn-center btn-docu01">
			<a class="btn btn01" href="#">취소</a>
			<a class="btn btn02" onclick="javascript:courseSearch()">발급하기</a>
		</div>
		<!-- 출강증명서 -->
		<div class="btn-center btn-docu02">
			<a class="btn btn02" onclick="javascript:courseSearch()">조회하기</a>
		</div>
	</div>
</div>



<div class="edit-popup" id="search_layer">
	<div class="edit-bg"></div> 
	<div class="edit-wrap">
		<div class="exit" onclick="javascript:$('#search_layer').fadeOut(200);"><img src="/img/exit.png" alt="close" /></div>
		<h3>강좌내역</h3>

		<div class="edi-tablewr">
			<table>
				<thead>
					<tr>
						<th><input type="checkbox" id="chk_all" name="chk_all" value="chk_val"><label for="chk_all"></label></th>
						<th>강좌 기간</th>
						<th>지점</th>
						<th>강좌명</th>
						<th>강의 시간</th>
					</tr>
				</thead>
				<tbody id="subject_target">
					
				</tbody>

			</table>
		</div>

		<div class="btn-center">
			<a class="btn btn01 close-btn">취소</a>
			<a class="btn btn02" onclick="javascript:fncSubmit();">발급하기</a>
		</div>
	</div>
</div>
<form id="fncForm" name="fncForm" method="POST" action="">
	<input type="hidden" id="cv" name="cv">
	<input type="hidden" id="docType" name="docType">
</form>
<jsp:include page="/inc/footer.jsp" />