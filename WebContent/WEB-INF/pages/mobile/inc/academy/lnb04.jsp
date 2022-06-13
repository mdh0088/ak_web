<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="lnb-top">
	<p class="lnb-entit eff-t">My Academy.</p>
	<p class="lnb-kotit eff-t">지점안내</p>
	<ul class="lnb-ul">
		<li><a href="/academy/store01.php">분당점</a></li>
		<li><a href="/academy/store02.php">수원점</a></li>
		<li><a href="/academy/store03.php">평택점</a></li>
		<li><a href="/academy/store04.php">원주점</a></li>
	</ul>
</div>
<Script>
	$(window).load(function(){
		var act = $(".lnb-ul li.active").index();
		var prev = $(".lnb-ul li").eq(act-1).find("a").attr("href");
		var next = $(".lnb-ul li").eq(act+1).find("a").attr("href");
		var first = $(".lnb-ul li").first().find("a").attr("href");
		var last = $(".lnb-ul li").last().find("a").attr("href");

		if(act == 0){
			$(".loca-top").append('<a class="loca-btn loca-prev" href="'+last+'"></a>');
		}else{
			$(".loca-top").append('<a class="loca-btn loca-prev" href="'+prev+'"></a>');
		}
		if(act == 3){
			$(".loca-top").append('<a class="loca-btn loca-next" href="'+first+'"></a>');
		}else{
			$(".loca-top").append('<a class="loca-btn loca-next" href="'+next+'"></a>');
		}
		
	})
</script>