<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="lnb-top">
	<p class="lnb-entit eff-t">Course Search.</p>
	<p class="lnb-kotit eff-t">????</p>
</div>

<div class="filter-wrap">
	<div class="filter-bg"></div>
	<div class="filter-wr">
		<div class="filter-close"><img src="/img/filter-icon03.png" alt="??"/></div>
		<p class="filter-tit">Filter</p>
		<div class="filt-row">
			<div class="search-box search-box02">
				<select de-data="??? ?? ??">
					<option value="">???</option>
					<option value="">???</option>
					<option value="">???</option>
				</select>
			</div>
		</div>
		<div class="filt-row">
			<div class="search-box search-box02">
				<select de-data="?? ?? ??">
					<option value="">???</option>
					<option value="">???</option>
					<option value="">???</option>
				</select>
			</div>
		</div>
		<div class="filt-row">
			<div class="search-box search-box02 disable">
				<select de-data="?? ?? ?? ??">
					<option value="">???</option>
					<option value="">???</option>
					<option value="">???</option>
				</select>
			</div>
		</div>
		<div class="filt-row">
			<div class="search-box search-box02">
				<select de-data="?? ??">
					<option value="">???</option>
					<option value="">???</option>
					<option value="">???</option>
					<option value="">???</option>
					<option value="">???</option>
				</select>
			</div>
		</div>
		<div class="filt-row">
			<div class="fil-child table">
				<div class="lect-chk">
					<label><input type="checkbox">?? ?? ? </label>
				</div>
				<div class="fil-chinp"><input type="text" class="chinp-input"/>??</div>
			</div>
		</div>
		<div class="filt-btnwr">
			<a href="#" class="btn btn01"><img src="/img/filter-icon01.png" alt="??"/>RESET</a>
			<a href="#" class="btn btn02">??</a>
		</div>
	</div>
</div>

<Script>
	$(function(){
		$(".cour-filter").click(function(){
			$(".filter-wrap").fadeIn(200);	
		})
		$(".filter-close").click(function(){
			$(".filter-wrap").hide();
		})
	})
</script>