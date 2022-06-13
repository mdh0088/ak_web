<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<script>
function fncSubmit()
{
	var validationFlag = "Y";
	if(!$("#agree").is(":checked"))
	{
		alert("이용약관에 동의해주세요");
		return;
	}
	else
	{
		$(".notEmpty").each(function() 
		{
			if ($(this).val() == "") 
			{
				alert(this.dataset.name+"을(를) 입력해주세요.");
				$(this).focus();
				validationFlag = "N";
				return false;
			}
		});
		if(validationFlag == "Y")
		{
			if($("#user_phone2").val().length != 3 && $("#user_phone2").val().length != 4)
			{
				alert("연락처를 확인해주세요.");
				$("#user_phone2").focus();
				validationFlag = "N";
				return false;
			}
			if($("#user_phone3").val().length != 4)
			{
				alert("연락처를 확인해주세요.");
				$("#user_phone3").focus();
				validationFlag = "N";
				return false;
			}
			if(isNaN($("#user_phone2").val()))
			{
				alert("연락처는 숫자만 입력해주세요.");
				$("#user_phone2").focus();
				validationFlag = "N";
				return false;
			}
			if(isNaN($("#user_phone3").val()))
			{
				alert("연락처는 숫자만 입력해주세요.");
				$("#user_phone3").focus();
				validationFlag = "N";
				return false;
			}
			if(nullChk($('input[name="user_store"]:checked').val()) == "")
			{
				alert("지점구분을 선택해주세요.");
				$("#user_store1").focus();
				validationFlag = "N";
				return false;
			}
			if(nullChk($('input[name="user_type"]:checked').val()) == "")
			{
				alert("질의유형을 선택해주세요.");
				$("#user_type1").focus();
				validationFlag = "N";
				return false;
			}
		}
		if(validationFlag == "Y")
		{
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
}
function selEmail()
{
	var email3 = $("#user_email3").val();
	$("#user_email2").val(email3);
}
</script>
<div class="lnb-top">
	<p class="lnb-entit eff-t">Customer Service.</p>
	<p class="lnb-kotit eff-t">고객의 소리</p>
</div>
<form id="fncForm" name="fncForm" method="POST" action="./contact_proc">
	<div class="cours-sec cours-sec01 bg-gray">
		<div class="mu-grid">
			<div class="conform-top">
				<p class="conform-tit">회원님의 의견에 귀 기울이는 <br><span class="conf-sp"><b class="color-g">문화아카데미</b>가 되겠습니다.</span></p>
				<div class="conform-r">
					<em class="confri-tit">AK Customer Service.</em>
					<p>문의사항, 불편사항, 희망 강좌 등 회원님의 의견을 자유롭게 작성해 주시기 바랍니다.
					<p>보내주신 의견은 담당자가 확인하여 빠른 시일 내에 이메일로 답변을 드리겠습니다.</p>
				</div>
			</div>
			<div class="conform-bot">
	
				<div class="conform-wr">
					<p class="sub-tit"><b>개인정보 보호를 </b> 위한 이용자 동의사항</p>
					<p class="cour-txt">내용을 확인하신 후 동의여부를 표시해 주세요..</p>
					<div class="agree-box scroll-d">
						■ 개인정보 수집 및 이용목적<br><br>
	
						- 서비스 이용에 따른 본인 확인 절차에 이용<br>
						- 고지사항 전달, 불만 처리 등 원활한 의사소통 경로의 확보<br><br>
	
						■ 수집하는 개인정보의 항목
					</div>
					<div class="agree-chk">
						<span class="chk-btn"><input type="checkbox" id="agree" value="동의합니다"/><label for="agree">동의합니다.</label></span>
					</div>
				</div>
	
				<div class="conform-wr">
					<table class="table01">
						<tbody>
							<tr>
								<th>성명</th>
								<td><input type="text" data-name="성명" id="user_name" name="user_name" class="notEmpty"/></td>
							</tr>
							<tr>
								<th>연락처</th>
								<td>
									<div class="table phone-t">
										<div class="phone-select">
											<select de-data="010" id="user_phone1" name="user_phone1" >
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
												<option value="017">017</option>
												<option value="018">018</option>
												<option value="019">019</option>
												<option value="02">02</option>
												<option value="031">031</option>
												<option value="032">032</option>
												<option value="033">033</option>
												<option value="041">041</option>
												<option value="042">042</option>
												<option value="043">043</option>
												<option value="043">044</option>
												<option value="051">051</option>
												<option value="052">052</option>
												<option value="053">053</option>
												<option value="054">054</option>
												<option value="055">055</option>
												<option value="061">061</option>
												<option value="062">062</option>
												<option value="063">063</option>
												<option value="064">064</option>
												<option value="070">070</option>
											</select>
											
										</div>
										<div><input type="text" data-name="연락처" id="user_phone2" name="user_phone2" class="notEmpty"/></div>
										<div class="phone-dash">-</div>
										<div><input type="text" data-name="연락처" id="user_phone3" name="user_phone3" class="notEmpty"/></div>
									</div>
									<!-- 기존화면과 똑같이 맞춰야하기때문에 2021-01-26 기영 삭제 -->
<!-- 									<p class="con-cap"><span class="chk-btn"><input type="checkbox" id="sms-agree" value="동의합니다"/><label for="sms-agree">정보/이벤트 SMS 수신에 동의합니다.</label></span></p> -->
								</td>
							</tr>				
							<tr>
								<th>이메일</th>
								<td>
									<div class="table phone-t">
										<div><input type="text" data-name="이메일" id="user_email1" name="user_email1" class="notEmpty"/></div>
										<div class="phone-dash">@</div>
										<div><input type="text" data-name="이메일" id="user_email2" name="user_email2" class="notEmpty"/></div>
										<div class="phone-select">
											<select de-data="직접입력" id="user_email3" name="user_email3" onchange="selEmail();">
												<option value="">직접입력</option>
												<option value="gmail.com">gmail.com</option>
												<option value="naver.com">naver.com</option>
												<option value="nate.com">nate.com</option>
												<option value="daum.net">daum.net</option>
												<option value="dreamwiz.com">dreamwiz.com</option>
												<option value="lycos.co.kr">lycos.co.kr</option>
												<option value="empal.com">empal.com</option>
												<option value="yahoo.com">yahoo.com</option>
												<option value="chol.com">chol.com</option>
												<option value="korea.com">korea.com</option>
												<option value="paran.com">paran.com</option>
												<option value="hanafos.com">hanafos.com</option>
												<option value="hanmir.com">hanmir.com</option>
												<option value="hotmail.com">hotmail.com</option>
												<option value="hanmail.net">hanmail.net</option>
											</select>
										</div>
									</div>
									<!-- 기존화면과 똑같이 맞춰야하기때문에 2021-01-26 기영 삭제 -->
<!-- 									<p class="con-cap"><span class="chk-btn"><input type="checkbox" id="mail-agree" value="동의합니다"/><label for="mail-agree">정보/이벤트 메일 수신에 동의합니다. </label></span></p> -->
								</td>
							</tr>
							<tr>
								<th>지점구분</th>
								<td>
									<ul class="chk-ul">							
										<li>
											<input type="radio" id="user_store1" name="user_store" value="03" >
											<label for="user_store1">분당점</label>
										</li>									
										<li>
											<input type="radio" id="user_store2" name="user_store" value="02" >
											<label for="user_store2">수원점</label>
										</li>									
										<li>
											<input type="radio" id="user_store3" name="user_store" value="04" >
											<label for="user_store3">평택점</label>
										</li>									
										<li>
											<input type="radio" id="user_store4" name="user_store" value="05" >
											<label for="user_store4">원주점</label>
										</li>									
									</ul>
								</td>
							</tr>
							<tr>
								<th>질의유형</th>
								<td>
									<ul class="chk-ul">							
										<li>
											<input type="radio" id="user_type1" name="user_type" value="01" >
											<label for="user_type1">칭찬</label>
										</li>
										<li>
											<input type="radio" id="user_type2" name="user_type" value="10" >
											<label for="user_type2">문의</label>
										</li>
										<li>
											<input type="radio" id="user_type3" name="user_type" value="07" >
											<label for="user_type3">불만</label>
										</li>
										<li>
											<input type="radio" id="user_type4" name="user_type" value="11" >
											<label for="user_type4">기타</label>
										</li>
									</ul>
								</td>
							</tr>
							<tr>
								<th>제목</th>
								<td><input type="text" data-name="제목" id="user_title" name="user_title" class="notEmpty" placeholder="제목을 입력해주세요." /></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea data-name="내용" id="user_content" name="user_content" class="notEmpty" placeholder="내용을 입력해주세요."></textarea></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="btn-wr">
					<a class="btn btn01" href="/main">취소</a>
					<a class="btn btn02" onclick="fncSubmit()">등록</a>
				</div>
			</div>
		</div>
	</div>
</form>
<jsp:include page="/inc/footer.jsp" />

