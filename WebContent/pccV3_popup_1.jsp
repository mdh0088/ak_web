<%@ page  contentType = "text/html;charset=ksc5601"%>
<%@ page import="ak_web.classes.Utils" %>
<%
	response.setHeader("Cache-Control","no-cache");     
	response.setHeader("Pragma","no-cache");
%>
<%
	String rec_cert      = "";  // �����(��ȣȭ)
	String certNum       = "";  // certNum
	String param         = "";  // rec_cert, certNum ������ ���� �ӽ� ����

    rec_cert = request.getParameter("rec_cert").trim();
	certNum  = request.getParameter("certNum").trim(); 
	param    = "?rec_cert="+rec_cert + "&certNum=" + certNum;

	String pageUrl = Utils.getPageUrl2(request,"/pccV3_result_1.jsp",true); //���߱�
	//String pageUrl = Utils.getPageUrl2(request,"/pccV3_result_1.jsp",false); //����
	//String pageUrl = "http://tculture.akplaza.com/home/member/pccV3_result_1.jsp";	
%>
<html>
<head>
<script language="JavaScript">
	function end() {
		location.href = '<%=pageUrl + param%>';
	}
</script>
</head>
<body onload="javascript:end()">
</body>
</html>