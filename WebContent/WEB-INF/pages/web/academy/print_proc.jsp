<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="http://malsup.github.io/min/jquery.form.min.js"></script>
<script src="/inc/js/function.js"></script>
<script>
function comma(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
var per_cnt=0;
function guessSchedule(start_ymd, type)
{
	
	
   console.log(start_ymd.substring(0, 4));
   console.log(start_ymd.substring(4,6)-1);
   console.log(start_ymd.substring(6,8));
   console.log(start_ymd.substring(0,8));
   
   var date_start = new Date(start_ymd.substring(0, 4), start_ymd.substring(4,6)-1, start_ymd.substring(6,8) ,00 ,00 );
   //var date_start = new Date(start_ymd.substring(0, 4), start_ymd.substring(4,6)-1, start_ymd.substring(6,8) ,11 ,59 );
   var current_date = new Date();
 
   console.log("DATE START : "+date_start);
   console.log("CURRENT START : "+current_date);
   
   var typex = type;	
   if(current_date < date_start || start_ymd=="X")
   {
      typex = "";
   }else{
	   per_cnt++;
   }
   
   
   return typex; 
}

$(document).ready(function(){
	var day_chk_arr ="${day_value}".split('|');
	var inner ="";
	inner +='<tr>';
	inner +='	<th class="td-chk">No.</th>';
	inner +='	<th onclick="reSortAjax(\'sort_kor_nm\')">회원명<img src="/img/th_up.png" id="sort_kor_nm"></th>';
	inner +='	<th onclick="reSortAjax(\'sort_ptl_id\')">포털ID <img src="/img/th_up.png" id="sort_ptl_id"></th> ';
	inner +='	<th onclick="reSortAjax(\'sort_phone_no\')">전화번호 <img src="/img/th_up.png" id="sort_phone_no"></th>';
	inner +='	<th onclick="reSortAjax(\'sort_sex_fg\')">성별 <img src="/img/th_up.png" id="sort_sex_fg"></th> ';
	inner +='	<th onclick="reSortAjax(\'sort_cust_date\')">가입일<img src="/img/th_up.png" id="sort_cust_date"></th>';
	inner +='	<th onclick="reSortAjax(\'sort_cust_fg\')">형태 <img src="/img/th_up.png" id="sort_cust_fg"></th>';
	for (var i = 0; i < day_chk_arr.length-1; i++) {
		inner +='<th class="chk-date">';
		inner +='	'+day_chk_arr[i].substr(4,2)+'/'+day_chk_arr[i].substr(6,2)+'';
		inner +='</th>'
	}
	inner +='<th>비고</th>';
	inner +='</tr>';
	$('#list_head_target').html(inner);
	
	
	
	
	var result = JSON.parse('${result}');
	
	inner = "";
	var day_chk_arr = "${day_value}".split('|');
	var dayChk = ""; //출석체크 값 세팅
	
	if(result.list.length > 0)
	{
		for(var i = 0; i < result.list.length; i++)
		{
			dayChk = result.list[i].DAY_CHK.split('|');
			
			inner += '<tr>';
			inner += '	<td class="td-chk">'+(i+1)+'</td>';
			inner += '	<td>'+nullChk(result.list[i].KOR_NM)+'</td>';
			inner += '	<td>'+nullChk(result.list[i].PTL_ID)+'</td>';
			inner += '	<td>'+nullChk(result.list[i].PHONE_NO)+'</td>';
			
			inner += '	<td>'+nullChk(result.list[i].SEX_FG)+'</td>';
			inner += '	<td>'+cutDate2(nullChk(result.list[i].CUST_DATE))+'</td>';
			inner += '	<td>'+nullChk(result.list[i].CUST_FG)+'</td>';
			
			for (var j = 0; j < dayChk.length-1; j++) {
				
				inner += '	<td>'+guessSchedule(day_chk_arr[j],nullChk(dayChk[j]))+'</td>';
			}
			inner += '	<td>'+nullChk(result.list[i].CONTENT)+'</td>';
			//inner += '	<td>'+guessSchedule("${DAY2}",nullChk(result.list[i].DAY2))+'</td>';
	
			inner += '</tr>';
		
		}
	}
	else
	{
		inner += '<tr>';
		inner += '	<td colspan="'+(7+day_chk_arr.length)+'"><div class="no-data">수강생이 없습니다.</div></td>';
		inner += '</tr>';
	}
	
	$("#list_target").html(inner);
	window.print();
});
</script>
<style type="text/css">
	@media print {
	table td, table th {
		border: 1px solid #e0e0e0;
		padding:5px;
	}
	table {
	    border-collapse: separate;
	    border-spacing: 0;
	    width: 100%;
	}
	body {
		font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
	}
}
</style>
<table id="excelTable">
	<colgroup>
		<col width="5%" />
		<col width="10%" />
		<col width="10%" />
		<col width="18%" />
		<col width="7%" />
		<col width="15%" />
		<col width="7%" />
	</colgroup>
	<thead id="list_head_target">
		<tr>
			<th>NO. </th>
			<th>회원명 </th>
			<th>포털ID </th>
			<th>전화번호 </th>
			<th>성별 </th>
			<th>가입일</th>
			<th>형태 </th>
		</tr>
	</thead>
	<tbody id="list_target">
	</tbody>
</table>