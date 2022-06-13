<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/inc/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />

<div class="lnb-top">
	<p class="lnb-entit eff-t">AK Academy.</p>
	<p class="lnb-kotit eff-t">강의 계획서 등록/수정</p>
	<jsp:include page="/inc/academy/lnb01.jsp" />
</div>


<div class="lect-sec bg-gray">
	<div class="mu-grid">
		<div class="plan-title">
			<span>이문화 강사</span>
			미드로 배우는 스크린 영어
		</div>

		<div class="lect-wr03">			
			<table>
				<colgroup>
					<col style="width:18%;" />
					<col style="width:32%;" />
					<col style="width:18%;" />
					<col style="width:32%;" />

				</colgroup>
				<tr>
					<th>성명</th>
					<td>이문화</td>
					<th>지점</th>
					<td>분당점</td>
				</tr>
				<tr>
					<th>강의 일정</th>
					<td>1989년 2월 13일</td>
					<th>횟수</th>
					<td>4회</td>
				</tr>
				<tr>
					<th>강의 시간</th>
					<td>금 (19:00 - 19:50)</td>
					<th>수강 대상</th>
					<td>성인</td>
				</tr>
				<tr>
					<th>재료비</th>
					<td>없음</td>
					<th></th>
					<td></td>
				</tr>
			</table>
			<div class="row-wr">
				<div class="row">
					<p class="row-tit">재료비 내용</p>
					<div>
						<input type="text" id="sns" class="inp100" placeholder="내용을 입력해주세요.">
					</div>
				</div>
				<div class="row">
					<p class="row-tit">강의 개요</p>
					<div>		
						<textarea placeholder="내용을 입력해주세요.(1,000자 이상)"></textarea>
					</div>					
				</div>
				<div class="row">
					<p class="row-tit">컬리큘럼</p>
					<div>	
						<div class="cu-inp">
							<div class="search-box select">
								<p class="">회차</p>
								<ul class="sear-ul" >
									<li><a>1회차</a></li>
									<li><a>2회차</a></li>
								</ul>
							</div>
							<div class="inp-btn table">
								<div>
									<input type="text" id="sns" placeholder="내용을 입력해주세요.">
								</div>
								<div class="wid-3">
									<div class="td-btn table">
										<div>
											<a class="btn-add">추가</a>
										</div>
										<div>
											<a class="btn-del">삭제</a>
										</div>
									</div>
								</div>
							</div>
							
						</div>
						<div class="cu-inp">
							<div class="search-box select">
								<p class="">회차</p>
								<ul class="sear-ul" >
									<li><a>1회차</a></li>
									<li><a>2회차</a></li>
								</ul>
							</div>
							<div class="inp-btn table">
								<div>
									<input type="text" id="sns" placeholder="내용을 입력해주세요.">
								</div>
								<div class="wid-3">
									<div class="td-btn table">
										<div>
											<a class="btn-add">추가</a>
										</div>
										<div>
											<a class="btn-del">삭제</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="cu-inp">
							<div class="search-box select">
								<p class="">회차</p>
								<ul class="sear-ul" >
									<li><a>1회차</a></li>
									<li><a>2회차</a></li>
								</ul>
							</div>
							<div class="inp-btn table">
								<div>
									<input type="text" id="sns" placeholder="내용을 입력해주세요.">
								</div>
								<div class="wid-3">
									<div class="td-btn table">
										<div>
											<a class="btn-add">추가</a>
										</div>
										<div>
											<a class="btn-del">삭제</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<textarea placeholder="내용을 입력해주세요.(1,000자 이상)"></textarea>
					</div>					
				</div>
				<div class="row">
					<p class="row-tit">유의사항</p>
					<div>		
						<textarea placeholder="내용을 입력해주세요.(1,000자 이상)"></textarea>
					</div>					
				</div>
			</div>
		</div>
		<div class="btn-center">
			<a class="btn btn01" href="#">목록으로</a>
			<a class="btn btn02" href="#">제출하기</a>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />