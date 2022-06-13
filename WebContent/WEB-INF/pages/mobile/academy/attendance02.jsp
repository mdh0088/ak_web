<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/inc/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<div class="lnb-top">
	<p class="lnb-entit eff-t">My Academy.</p>
	<p class="lnb-kotit eff-t">출석부 관리</p>
	<jsp:include page="/inc/academy/lnb01.jsp" />
</div>


<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">

		<div class="plan-title">
			<span>
				<b>목</b>11:00 - 12:00
			</span>
			미드로 배우는 스크린 영어
		</div>

		<div class="attend-wr myaca-wr01">
			<table>
				<thead>
					<tr>
						<th>회원명</th>
						<th>1강</th>
						<th class="td-10">비고</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>이호걸</td>
						<td><input type="checkbox" checked></td>
						<td><input class="attend-inp" type="text"/></td>						
					</tr>
					<tr>
						<td>이호걸</td>
						<td><input type="checkbox" checked></td>
						<td><input class="attend-inp" type="text"/></td>			
					</tr>
					<tr>
						<td>이호걸</td>
						<td><input type="checkbox" checked></td>
						<td><input class="attend-inp" type="text"/></td>			
					</tr>
					<tr>
						<td>이호걸</td>
						<td><input type="checkbox" checked></td>
						<td><input class="attend-inp" type="text"/></td>			
					</tr>					
				</tbody>
			</table>
			
		</div>
		<div class="btn-center">
			<a class="btn btn02" href="#">더보기</a>
		</div>
		<!--
		<div class="btn-right">
			<a class="btn btn02" href="#">저장</a>
		</div>
		-->


	</div>
</div>
<jsp:include page="/inc/footer.jsp" />