<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb06.jsp" />

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
							<li><label><input type="checkbox" checked>분당</label></li>
							<li><label><input type="checkbox">수원</label></li>
							<li><label><input type="checkbox">평택</label></li>
							<li><label><input type="checkbox">원주</label></li>
						</ul>	
					</td>
				</tr>

				<tr>
					<th>신청 서류</th>
					<td>
						<ul class="td-chk02">
							<li><label><input type="radio">원천징수영수증</label></li>
							<li><label><input type="radio" checked>출강증명서</label></li>
						</ul>	
					</td>
				</tr>

				<tr>
					<th>용도</th>
					<td>
						<select name="용도">
							<option value="">선택</option>
							<option value="">선택</option>
							<option value="">선택</option>
						</select>
					</td>
				</tr>

				<tr>
					<th>신청 기간</th>
					<td>
						<div>
							<input type="text" class="cal-inp" id="sns" value="2001-01-01">
							<span class="p-bar">-</span>
							<input type="text" class="cal-inp" id="sns" value="2005-01-01">
						</div>
					</td>
				</tr>

			</table>
		
		
		</div>


		<div class="btn-center">
			<a class="btn btn02" href="#">조회하기</a>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />