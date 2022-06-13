<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/mobile/inc/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<script>
var loginChk = "${resultCd}";
if (loginChk=="-1") {
	alert("${resultMsg}");
	location.href="${resultURL}";
}


function all_chker(){
	if ( $('#all').prop("checked")==true )  {
		$('.number').prop("checked",true);
	}else{
		$('.number').prop("checked",false);			
	}
}

var endPoint='${endPoint}';

$(document).ready(function() {
	getList();
});

function getList() 
{
	$.ajax({
		type : "POST", 
		url : "./getApplyResult",
		dataType : "text",
		async : false,
		data : 
		{
			endPoint : endPoint,
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
			
			for(var i = 0; i < result.list.length; i++){
				
				inner +='<tr>';
				if (nullChk(result.list[i].STATUS2)=='') {
					inner +='	<td><span class="chk-btn"><input type="checkbox" id="number'+i+'" name="number" class="number" value="'+result.list[i].REG_NO+'"><label for="number'+i+'"></label></span></td>';					
				}else{
					inner +='<td></td>';
				}
				inner +='	<td>'+nullChk(result.list[i].LEC_NM)+'</td>';
				
				if (result.list[i].STATUS1=='심사완료') {
					inner +='<td><p class="finish">심사 완료</p></td>';
				}else if(result.list[i].STATUS1=='진행중'){
					inner +='<td><p class="f-gray">진행중</p></td>';
				}else if(result.list[i].STATUS1=='접수중'){
					inner +='<td><p class="f-redline" onclick="javascript:location.href=\'/mobile/academy/lector03?reg_no='+result.list[i].REG_NO+'\'">접수중</p></td>';
				}
				
				inner +='	<td>'+nullChk(result.list[i].STATUS2)+'</td>';
				
				inner +='	<td><span class="mod-btn" onclick="modBtn('+result.list[i].REG_NO+');"><img src="/img/mod-icon.png" alt="수정하기"/></span></td>';
				

				inner +='</tr>';
			}

			$("#list_target").html(inner);
			endPoint = (result.e_point)+5;
		}
	});		
}

function delAply(){
	if(!confirm("정말 삭제하시겠습니까?"))
	{
		return;
	}	
	
	var len = document.getElementsByName("number").length
	
	var reg_no="";
	var chk_flag =false;
	for (var i = 0; i < len; i++) 
	{
		if (document.getElementsByName("number")[i].checked == true) 
		{
			chk_flag=true;
			reg_no = document.getElementsByName("number")[i].value;
			
			$.ajax({
				type : "POST", 
				url : "./delAply",
				dataType : "text",
				async : false,
				data : 
				{
					reg_no:reg_no
				},
				error : function() 
				{
					console.log("AJAX ERROR");
				},
				success : function(data) 
				{
					console.log(data);
					var result = JSON.parse(data);
				}
			});	
		}
	}
	if (chk_flag==false)
	{
		alert('삭제할 지원서를 선택해주세요.');
		return;
	}
	else
	{
		getList();		
	}
}
</script>


<div class="lnb-top">
	<p class="lnb-entit eff-t">My Academy.</p>
	<p class="lnb-kotit eff-t">지원서 수정/결과</p>
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<p class="sub-tit">지원서 수정/결과</p>
		<div class="cour-left">
			<ul class="lect-ul">
				<li>[접수중]을 클릭하시면 저장된 지원서를 수정하실 수 있습니다.</li>
				<li>최종제출한 지원서는 [접수완료]로 나타납니다.</li>
				<li>담당자가 검토중인 지원서는 [진행중], 검토가 완료된 지원서는 [심사완료]로 나타납니다.</li>
				<li>심사결과와 합격 여부를 확인하실 수 있습니다.</li>
			</ul>
			
			
			<a  class="myaca-change myaca-del" onclick="delAply()">선택 강좌 삭제</a>
		</div>
		<div class="colist-wr myaca-wr01 attend-wr02">
			<table>
				<thead>
					<tr>
						<th><span class="chk-btn"><input type="checkbox" id="all" onclick="all_chker()"><label for="all"></label></span></th>
						<th>강좌명</th>
						<th>접수상태</th>
						<th>심사결과</th>
						<th>추가정보</th>
					</tr>
				</thead>
				<tbody id="list_target">
					
				</tbody>
			</table>
			
		</div>
		<div class="btn-center">
			<a class="btn btn02" onclick="getList()">더보기</a>
		</div>
	</div>
</div>

<div class="edit-popup" id="add_layer">
	<div class="edit-bg"></div> 
	<div class="edit-wrap edit-wrap02">
		<div class="exit" onclick="javascript:$('#add_layer').fadeOut(200);"><img src="/img/exit.png" alt="close" /></div>
		<h3>추가 정보 작성</h3>
		

		<div class="add-widwr">
			<div class="add-wid5">
				<div class="edi-tablewr add-boxwr">
					<div class="row-wr">
						<div class="row">
							<p class="row-tit">등록지점</p>
							<div>
								<select name="분당점">
									<option value="">선택</option>
									<option value="">선택</option>
									<option value="">선택</option>
								</select>
							</div>
						</div>
						<div class="row">
							<p class="row-tit">개인/법인 구분</p>
							<div>
								<select name="개인/법인 구분">
									<option value="">개인</option>
									<option value="">법인</option>
								</select>
							</div>
						</div>
						<div class="regi-tr row">
							<p class="row-tit">주민등록번호</p>
							<div>
								<div class="table">
									<div>
										<input type="text" id="sns" value="901102">
									</div>
									<div class="p-bar">
										-
									</div>
									<div>
										<input type="text" id="sns" value="2222222">
									</div>
								</div>
							</div>
						</div>
						<div class="back-tr row">
							<p class="row-tit">입금 희망 계좌</p>
							<div>
								<div>
									<select name="은행선택">
										<option value="">국민은행</option>
										<option value="">신한은행</option>
									</select>
									<select name="예금주 선택">
										<option value="">이호걸</option>
										<option value="">이호걸</option>
									</select>
								</div>
								<div class="table">
									<div><input type="text" placeholder="계좌번호 입력"></div>
									<div class="bank-btn ">
										<button>조회</button>
									</div>
									<div class="bank-btn-r">
										<span><img src="/img/check-i.png" />계좌 확인 완료</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					
				</div>
			</div>
			
			<div class="add-wid5_last">
				<div class="edi-tablewr add-boxwr">
					<div class="row-wr row-wr02">
						<div class="back-tr">
							<p class="row-tit">사업자 번호</p>
							<div>
								<div class="table">
									<div><input type="text" placeholder="계좌번호 입력"></div>
									<div class="bank-btn ">
										<button>조회</button>
									</div>
									<div class="bank-btn-r">
										<span><img src="/img/check-i.png" />계좌 확인 완료</span>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<p class="row-tit">상호</p>
							<div>
								<input type="text">
							</div>
						</div>
						<div class="row">
							<p class="row-tit">대표자명</p>
							<div>
								<input type="text">
							</div>
						</div>
						<div class="row">
							<p class="row-tit">업태</p>
							<div>
								<input type="text">
							</div>
						</div>
						<div class="row">
							<p class="row-tit">업종</p>
							<div>
								<input type="text">
							</div>
						</div>
						<div class="addr-tr">
							<p class="row-tit">사업장주소</p>
							<div>
								<div class="table">
									<div><input type="text"></div>
									<div class="post-btn">
										<button>우편번호 검색</button>
									</div>
								</div>
								<input type="text" placeholder="상세주소 입력">
							</div>
						</div>

						
					</div>
				</div>
			</div>

			<div class="btn-center">
				<a class="btn btn01 close-btn">취소</a>
				<a class="btn btn02" href="#">저장</a>
			</div>
		</div> <!-- // add-widwr end -->



	</div>
</div>

<script>
	function modBtn(){
		$('#add_layer').fadeIn(200);	
	}
</script>
<jsp:include page="/inc/footer.jsp" />

