<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/inc/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />

<div class="lnb-top">
	<p class="lnb-entit eff-t">AK Academy.</p>
	<p class="lnb-kotit eff-t">강의 계획서 등록/수정</p>
	<jsp:include page="/inc/academy/lnb01.jsp" />
</div>

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<div class="cour-seartop cour-seartop02">
			<p class="mysear-t">지점선택</p>
			<div class="myaca-sear table">
				<div class="myaca-s myaca-s_s">
					<div class="search-box">
						<ul class="td-chk">
							<li class="radio-wr"><input type="radio" name="store" id="store01" checked=""><label for="store01">분당점</label></li>
							<li class="radio-wr"><input type="radio" name="store" id="store02"><label for="store02">수원점</label></li>
							<li class="radio-wr"><input type="radio" name="store" id="store03"><label for="store03">평택점</label></li>
							<li class="radio-wr"><input type="radio" name="store" id="store04"><label for="store04">원주점</label></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="myaca-sear table">
				<div class="myaca-s">
					<div class="search-box">
						<p>2019년도 여름학기</p>
						<ul class="sear-ul">
							<li><a>분당점</a></li>
							<li><a>분당점</a></li>
							<li><a>분당점</a></li>
							<li><a>분당점</a></li>
							<li><a>분당점</a></li>
						</ul>
					</div>
				</div>
				<div class="myaca-dash">
					-
				</div>
				<div class="myaca-s">
					<div class="search-box disable">
						<p>2019년도 여름학기</p>
						<ul class="sear-ul">
							<li><a>분당점</a></li>
							<li><a>분당점</a></li>
							<li><a>분당점</a></li>
							<li><a>분당점</a></li>
							<li><a>분당점</a></li>
						</ul>
					</div>

				</div>
			</div>
		</div>
		
		<div class="colist-wr myaca-wr">
			<table>
				<thead>
					<tr>
						<th>강좌명</th>
						<th>강의 시간</th>
						<th>계획서 작성 내역</th>
						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>(정규)미드로 배우는 스크린 영어</td>
						<td>목 (11:00 -12:00)</td>
						<td><div class="write-btn" onclick="location.href='plan02'"><img src="/img/write-i.png" /></div></td>
					</tr>
					<tr>
						<td>(정규)미드로 배우는 스크린 영어</td>
						<td>목 (11:00 -12:00)</td>
						<td><div class="write-btn" onclick="location.href='plan02'"><img src="/img/write-i.png" /></div></td>
					</tr>
					<tr>
						<td>(정규)미드로 배우는 스크린 영어</td>
						<td>목 (11:00 -12:00)</td>
						<td><div class="write-btn" onclick="location.href='plan02'"><img src="/img/write-i.png" /></div></td>
					</tr>					
				</tbody>
			</table>
			
		</div>
		<div class="btn-center">
			<a class="btn btn02" href="#">더보기</a>
		</div>
	</div>
</div>

<jsp:include page="/inc/footer.jsp" />

