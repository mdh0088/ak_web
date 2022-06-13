<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<script>
var loginChk = "${resultCd}";
if (loginChk=="-1") {
	alert("${resultMsg}");
	location.href="${resultURL}";
}

$(document).ready(function() {
	getList();
});

function getList(type) 
{
	$.ajax({
		type : "POST", 
		url : "./getApplyResult",
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
			
			
			for(var i = 0; i < result.list.length; i++){
				
				inner +='<tr>';
				
				inner +='	<td>'+(i+1)+'</td>';
				inner +='	<td>'+nullChk(result.list[i].KOR_NM)+'</td>';
				inner +='	<td>'+nullChk(result.list[i].LEC_NM)+'</td>';
				inner +='	<td>'+nullChk(result.list[i].SUBMIT_DATE)+'</td>';
				
				if (result.list[i].STATUS1=='심사완료') {
					inner +='<td><p class="finish">심사 완료</p></td>';
				}else if(result.list[i].STATUS1=='진행중'){
					inner +='<td><p class="f-gray">진행중</p></td>';
				}else if(result.list[i].STATUS1=='접수중'){
					inner +='<td><p class="f-redline" onclick="javascript:location.href=\'/academy/lector03?reg_no='+result.list[i].REG_NO+'\'">접수중</p></td>';
				}
				
				inner +='	<td>'+nullChk(result.list[i].STATUS2)+'</td>';
				
				inner +='	<td><span class="mod-btn" onclick="modBtn('+result.list[i].REG_NO+');"><img src="/img/mod-icon.png" alt="수정하기"/></span></td>';
				if (result.list[i].STATUS2!="합격" && result.list[i].STATUS2!="불합격") {					
					inner +='	<td><span class="myaca-del" onclick="delAply('+result.list[i].REG_NO+')"><img src="/img/myaca-i05.png" alt="삭제하기"/></span></td>';
				}

				inner +='</tr>';
			}
			
			order_by = result.order_by;
			sort_type = result.sort_type;
			listSize = result.listSize;

			$("#list_target").html(inner);
			
			$(".paging").html(makePaging(result.page, result.s_page, result.e_page, result.pageNum, 1));
			
		}
	});		
}

function delAply(reg_no){
	if(!confirm("정말 삭제하시겠습니까?"))
	{
		return;
	}	
	
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
			alert(result.msg);
			getList();
		}
	});	
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
			<p class="cour-txt">- [접수중]을 클릭하시면 저장된 지원서를 수정하실 수 있습니다. </p>
			<p class="cour-txt">- 최종제출한 지원서는 [접수완료]로 나타납니다. </p>
			<p class="cour-txt">- 담당자가 검토중인 지원서는 [진행중], 검토가 완료된 지원서는 [심사완료]로 나타납니다. </p>
			<p class="cour-txt">- 심사결과와 합격 여부를 확인하실 수 있습니다. </p>
			
			<!--<ul class="dot-ul">
				<li>- [접수중]을 클릭하시면 저장된 지원서를 수정하실 수 있습니다.</li>
				<li>- 최종제출한 지원서는 [접수완료]로 나타납니다.</li>
				<li>- 담당자가 검토중인 지원서는 [진행중], 검토가 완료된 지원서는 [심사완료]로 나타납니다.</li>
				<li>- 심사결과와 합격 여부를 확인하실 수 있습니다.</li>
			</ul> -->
		</div>
		<div class="colist-wr myaca-wr01 attend-wr02">
			<table>
				<thead>
					<tr>
						<th>No.</th>
						<th>강사명</th>
						<th>강좌명</th>
						<th>접수일자</th>
						<th>접수상태</th>
						<th>심사결과</th>
						<th>추가 정보 작성</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="list_target">
					
				</tbody>
			</table>
			
		</div>
		<div class="pagination-wr">
			<jsp:include page="/WEB-INF/pages/common/paging_new.jsp"/>
		</div>
	</div>
</div>

<div class="edit-popup" id="add_layer">
	<div class="edit-bg"></div> 
	<div class="edit-wrap edit-wrap02">
		<div class="exit" onclick="javascript:$('#add_layer').fadeOut(200);"><img src="/img/exit.png" alt="close" /></div>
		<h3>추가 정보 작성</h3>
		<p class="h3-p">강사료 지급을 위한 정보 입력 페이지입니다. 해당사항을 정확하게 기재바랍니다.</p>

		<div class="add-widwr">
			<div class="add-wid5">
				<div class="edi-tablewr add-boxwr">
					<table>
						<tr>
							<th>등록지점</th>
							<td>
								<div class="search-box search-box02">
									<select de-data="분당점">
										<option value="">선택</option>
										<option value="">선택</option>
										<option value="">선택</option>
										<option value="">선택</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<th>개인/법인 구분</th>
							<td>
								<div class="search-box search-box02">
									<select de-data="개인/법인 구분">
										<option value="">개인</option>
										<option value="">법인</option>
										<option value="">선택</option>
										<option value="">선택</option>
									</select>
								</div>
							</td>
						</tr>
						<tr class="regi-tr">
							<th>주민등록번호</th>
							<td>
								<div>
									<input type="text">
									<span class="p-bar">-</span>
									<input type="text">
								</div>
							</td>
						</tr>
						<tr class="back-tr">
							<th>입금 희망 계좌</th>
							<td>
								<div>
									<div class="search-box search-box02">
										<select de-data="은행선택">
											<option value="">국민은행</option>
											<option value="">국민은행</option>
										</select>
									</div>
									<div class="search-box search-box02">
										<select de-data="예금주 선택">
											<option value="">이호걸</option>
											<option value="">이호걸</option>
										</select>
									</div>	
									
								</div>
								<div>
									<input type="text" placeholder="계좌번호 입력">
									<div class="bank-btn">
										<button>조회</button>
										<span><img src="/img/check-i.png" />계좌 확인 완료</span>
									</div>
								</div>
							</td>
						</tr>
					</table>
					
				</div>

				<div class="btn-center">
					<a class="btn btn01 close-btn">취소</a>
					<a class="btn btn02" href="#">저장</a>
				</div>
			</div>
			
			<div class="add-wid5_last">
				<div class="edi-tablewr add-boxwr">
					<table>
						<tr class="back-tr">
							<th>사업자 번호</th>
							<td>
								<div>
									<input type="text" placeholder="계좌번호 입력">
									<div class="bank-btn">
										<button>조회</button>
										<span><img src="/img/check-i.png" />계좌 확인 완료</span>
									</div>
								</div>
							</td>
						</tr>

						<tr>
							<th>상호</th>
							<td>
								<input type="text">
							</td>
						</tr>
						<tr>
							<th>대표자명</th>
							<td>
								<input type="text">
							</td>
						</tr>
						<tr>
							<th>업태</th>
							<td>
								<input type="text">
							</td>
						</tr>
						<tr>
							<th>업종</th>
							<td>
								<input type="text">
							</td>
						</tr>
						<tr class="addr-tr">
							<th>사업장주소</th>
							<td>
								<div><input type="text"><button>우편번호 검색</button></div>
								<input type="text" placeholder="상세주소 입력">
							</td>
						</tr>

						
					</table>
					
				</div>
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

