<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/pages/web/common/header.jsp" />
<jsp:include page="/inc/breadcrumb.jsp" />
<jsp:include page="/inc/cs/lnb01.jsp" />

<div class="cours-sec cours-sec01 bg-gray">
	<div class="mu-grid">
		<div class="colist-wr news-list faq-list">
			<table>
				<colgroup>
					<col width=100px>
					<col width=150px>
					<col />
				</colgroup>
				<tbody>
					<tr class="faq-q">
						<td>01</td>
						<td><p class="news-cate">회원가입</p></td>
						<td><p class="news-subj">회원가입은 어떻게 하나요?</p></td>
					</tr>
					<tr class="faq-a">
						<td></td>
						<td class="faq-ans">Answer</td>
						<td>
							<p>AK멤버스 홈페이지(www.akmembers.com)로 들어오셔서 회원가입을 하시면 별도의 가입 없이 문화아카데미를  이용하실 수 있습니다.</p>
							<p>문화아카데미로 직접 방문하시는 경우, 각 점 AK멤버스 데스크에서 회원가입 후 이용하시면 됩니다.</p>
						</td>
					</tr>
					<tr class="faq-q">
						<td>01</td>
						<td><p class="news-cate">회원가입</p></td>
						<td><p class="news-subj">회원가입은 어떻게 하나요?</p></td>
					</tr>
					<tr class="faq-a">
						<td></td>
						<td class="faq-ans">Answer</td>
						<td>
							<p>AK멤버스 홈페이지(www.akmembers.com)로 들어오셔서 회원가입을 하시면 별도의 가입 없이 문화아카데미를  이용하실 수 있습니다.</p>
							<p>문화아카데미로 직접 방문하시는 경우, 각 점 AK멤버스 데스크에서 회원가입 후 이용하시면 됩니다.</p>
						</td>
					</tr>
					<tr class="faq-q">
						<td>03</td>
						<td><p class="news-cate">회원가입</p></td>
						<td><p class="news-subj">회원가입은 어떻게 하나요?</p></td>
					</tr>
					<tr class="faq-a">
						<td></td>
						<td class="faq-ans">Answer</td>
						<td>
							<p>AK멤버스 홈페이지(www.akmembers.com)로 들어오셔서 회원가입을 하시면 별도의 가입 없이 문화아카데미를  이용하실 수 있습니다.</p>
							<p>문화아카데미로 직접 방문하시는 경우, 각 점 AK멤버스 데스크에서 회원가입 후 이용하시면 됩니다.</p>
						</td>
					</tr>
				</tbody>
			</table>
			
		</div>
		<div class="pagination-wr">
			<ul class="paging">
				<li><a href="#" class="paging-prev"><img src="/img/cours-prev.png" alt="이전"></a></li>
				<li><a href="#" class="active">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#" class="paging-next"><img src="/img/cours-next.png" alt="다음"></a></li>
			</ul>
		</div>
		
	</div>
</div>

<script>
	$(function(){
		$(".faq-q").click(function(){
			var $this = $(this);
			var chk = $(this).next().css("display");
			$(".faq-q").removeClass("on");
			$(".faq-a").slideUp();

			if(chk == "none"){
				$this.addClass("on");
				$this.next().slideDown();
			}
			
		})
	})
</script>

<jsp:include page="/inc/footer.jsp" />

