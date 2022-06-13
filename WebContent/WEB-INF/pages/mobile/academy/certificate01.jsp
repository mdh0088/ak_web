<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/inc/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/academy/lnb06.jsp" />

<script>
function courseSearch()
{
	$('#search_layer').fadeIn(200);	
}
$(function(){
	$(".td-chk input").each(function(){
		$(this).click(function(){
			var chk = $(this).val();
			if(chk=="decum1"){
				$(".btn-docu02").hide();
				$(".btn-docu01").show();
			}else{
				$(".btn-docu01").hide();
				$(".btn-docu02").show();
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
			<div class="row-wr">
				<div class="row">
					<p class="row-tit">신청 지점</p>
					<div>
						<ul class="td-chk">
							<li><label><input type="checkbox" checked>분당</label></li>
							<li><label><input type="checkbox">수원</label></li>
							<li><label><input type="checkbox">평택</label></li>
							<li><label><input type="checkbox">원주</label></li>
						</ul>	
					</div>
				</div>

				<div class="row">
					<p class="row-tit">신청 서류</p>
					<div>
						<ul class="td-chk">
							<li><label><input type="radio" name="decum" value="decum1" checked>원천징수영수증</label></li>
							<li><label><input type="radio" name="decum" value="decum2">출강증명서</label></li>
						</ul>	
					</div>
				</div>

				<div class="row">
					<p class="row-tit">용도</p>
					<div>
						<div class="search-box select">
							<p class="">용도</p>
							<ul class="sear-ul">
								<li><a>선택</a></li>
								<li><a>선택</a></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="row btn-docu01">
					<p class="row-tit">신청 기간</p>
					<div>
						<div class="table">
							<div class="txt">연도 </div>
							<div>
								<div class="search-box select">
									<p class="">연도</p>
									<ul class="sear-ul">
										<li><a>2020</a></li>
										<li><a>2019</a></li>
										<li><a>2018</a></li>
										<li><a>2017</a></li>
									</ul>
								</div>
							</div>
							<div class="txt text-right">학기 </div>
							<div>
								<div class="search-box select">
									<p class="">학기</p>
									<ul class="sear-ul">
										<li><a>봄</a></li>
										<li><a>여름</a></li>
										<li><a>가을</a></li>
										<li><a>겨울</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row btn-docu02">
					<p class="row-tit">신청 기간</p>
					<div>
						<div class="table">
							<div>
								<input type="text" class="cal-inp" id="sns" value="2001-01-01">
							</div>
							<div class="p-bar">
								-
							</div>
							<div>
								<input type="text" class="cal-inp" id="sns" value="2005-01-01">
							</div>
						</div>
					</div>
				</div>

			</div>
		
		
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
						<th><input type="checkbox" checked></th>
						<th>강좌 기간</th>
						<th>지점</th>
						<th>강좌명</th>
						<th>강의 시간</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox"></td>
						<td>2019 겨울학기</td>
						<td>분당점</td>
						<td>(정규)미드로 배우는 스크린 영어</td>
						<td>목 (11:00 -12:00)</td>
					</tr>
					<tr>
						<td><input type="checkbox"></td>
						<td>2019 겨울학기</td>
						<td>분당점</td>
						<td>(정규)미드로 배우는 스크린 영어</td>
						<td>목 (11:00 -12:00)</td>
					</tr>
					<tr>
						<td><input type="checkbox"></td>
						<td>2019 겨울학기</td>
						<td>분당점</td>
						<td>(정규)미드로 배우는 스크린 영어</td>
						<td>목 (11:00 -12:00)</td>
					</tr>
				</tbody>

			</table>
		</div>

		<div class="btn-center">
			<a class="btn btn01 close-btn">취소</a>
			<a class="btn btn02" href="#">발급하기</a>
		</div>
	</div>
</div>
<jsp:include page="/inc/footer.jsp" />