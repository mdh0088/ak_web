<%
/**************************************************************************************************************************
* Program Name  : ����Ȯ�� ��� ���� JSP
* File Name     : PccV4_result1.jsp
* Comment       : 
* History       :  ������ ���� 
*
**************************************************************************************************************************/
%>

<%@ page  contentType = "text/html;charset=ksc5601"%>
<%@ page import = "java.util.*" %> 
<%-- <%@ page import="com.ams.frame.session.SessionForm" %> --%>
<%-- <%@ page import="com.ams.portal.member.service.MemberService" %> --%>
<%-- <%@ page import="com.ams.frame.util.INCSeedX" %> --%>
<%-- <%@ page import="com.ams.frame.util.HttpUtil"%> --%>
<%
    // ���� -------------------------------------------------------------------------------------------------------------
    String rec_cert		= "";																//�������DATA

	String k_certNum	= "";                                                       		//�Ķ���ͷ� ������ ��û��ȣ
	String certNum		= "";																// ��û��ȣ
    String date			= "";																// ��û�Ͻ�
	String CI	    	= "";																// ��������(CI)
	String DI	    	= "";																// �ߺ�����Ȯ������(DI)
    String phoneNo		= "";																// �޴�����ȣ
	String phoneCorp	= "";																// �̵���Ż�
	String birthDay		= "";																// �������
	String gender		= "";																// ����
	String nation		= "";																// ������
	String name			= "";																// ����
	String M_name		= "";																// �̼����� ����
	String M_birthDay	= "";																// �̼����� �������
	String M_Gender		= "";																// �̼����� ����
	String M_nation		= "";																// �̼����� ���ܱ���
    String result		= "";																// �����

    String certMet		= "";																// �������
    String ip			= "";																// ip�ּ�
	String plusInfo		= "";

	String encPara		= "";
	String encMsg1		= "";
	String encMsg2		= "";
	String msgChk       = ""; 
    //-----------------------------------------------------------------------------------------------------------------
	System.out.println("param >>>>>>>>>>>>>>��� ���� ������>>>>>>>>>>> :");
    try
    {
    	// Parameter ���� --------------------------------------------------------------------
        rec_cert       = request.getParameter("rec_cert").trim();
        k_certNum      = request.getParameter("certNum").trim(); 
        System.out.println("param >>>>>>>>>>>>>>��ȣȭ ��� ���� ��>>>>>>>>>>> :");
		//01. ��ȣȭ ��� (jar) Loading
		com.icert.comm.secu.IcertSecuManager seed = new com.icert.comm.secu.IcertSecuManager();
        System.out.println("param >>>>>>>>>>>>>>��ȣȭ ��� ���� ����>>>>>>>>>>> :");
		//02. 1�� ��ȣȭ
		//���ŵ� certNum�� �̿��Ͽ� ��ȣȭ
		rec_cert  = seed.getDec(rec_cert, k_certNum);
		
		//03. 1�� �Ľ�
		int inf1 = rec_cert.indexOf("/",0);
		int inf2 = rec_cert.indexOf("/",inf1+1);
		
		encPara  = rec_cert.substring(0,inf1);         //��ȣȭ�� ���� �Ķ����
		encMsg1  = rec_cert.substring(inf1+1,inf2);    //��ȣȭ�� ���� �Ķ������ Hash��
        System.out.println("param >>>>>>>>>>>>>>������ ���� ��>>>>>>>>>>> :");
		//04. ������ ����
		encMsg2  = seed.getMsg(encPara);
		
		if(encMsg2.equals(encMsg1)){
		    msgChk="Y";
		}
		
		if(msgChk.equals("N")){
		%>
		    <script language=javascript>
		    alert("���������� �����Դϴ�.!!<%=msgChk%>");
		    </script>
		<%
			return;
		}
		System.out.println("param >>>>>>>>>>>>>> ��ȣȭ ��>>>>>>>>>>> :");
		//05. 2�� ��ȣȭ
		rec_cert  = seed.getDec(encPara, k_certNum);
		
		//06. 2�� �Ľ�
		int info1  = rec_cert.indexOf("/",0);
		int info2  = rec_cert.indexOf("/",info1+1);
		int info3  = rec_cert.indexOf("/",info2+1);
		int info4  = rec_cert.indexOf("/",info3+1);
		int info5  = rec_cert.indexOf("/",info4+1);
		int info6  = rec_cert.indexOf("/",info5+1);
		int info7  = rec_cert.indexOf("/",info6+1);
		int info8  = rec_cert.indexOf("/",info7+1);
		int info9  = rec_cert.indexOf("/",info8+1);
		int info10 = rec_cert.indexOf("/",info9+1);
		int info11 = rec_cert.indexOf("/",info10+1);
		int info12 = rec_cert.indexOf("/",info11+1);
		int info13 = rec_cert.indexOf("/",info12+1);
		int info14 = rec_cert.indexOf("/",info13+1);
		int info15 = rec_cert.indexOf("/",info14+1);
		int info16 = rec_cert.indexOf("/",info15+1);
		int info17 = rec_cert.indexOf("/",info16+1);
		int info18 = rec_cert.indexOf("/",info17+1);
		System.out.println("param >>>>>>>>>1>>>>> ��ȣȭ ��>>>>>>>>>>> :");
		certNum		= rec_cert.substring(0,info1);
		date		= rec_cert.substring(info1+1,info2);
		CI			= rec_cert.substring(info2+1,info3);
		phoneNo		= rec_cert.substring(info3+1,info4);
		phoneCorp	= rec_cert.substring(info4+1,info5);
		birthDay	= rec_cert.substring(info5+1,info6);
		gender		= rec_cert.substring(info6+1,info7);
		if(gender.equals("0")){
			gender = "M";
		}else if(gender.equals("1")){
			gender = "F";
		}
		nation		= rec_cert.substring(info7+1,info8);
		name		= rec_cert.substring(info8+1,info9);
		result		= rec_cert.substring(info9+1,info10);
		certMet		= rec_cert.substring(info10+1,info11);
		ip			= rec_cert.substring(info11+1,info12);
		M_name		= rec_cert.substring(info12+1,info13);
		M_birthDay	= rec_cert.substring(info13+1,info14);
		M_Gender	= rec_cert.substring(info14+1,info15);
		M_nation	= rec_cert.substring(info15+1,info16);
		plusInfo	= rec_cert.substring(info16+1,info17);
		DI      	= rec_cert.substring(info17+1,info18);
		System.out.println("param >>>>>>>>>>>>>> ��ȣȭ ��2>>>>>>>>>>> :");
		//07. CI, DI ��ȣȭ
		CI  = seed.getDec(CI, k_certNum);
		DI  = seed.getDec(DI, k_certNum);

// 		MemberService service = new MemberService();
		
		if(result.equals("N"))
		{
			%>
			<script language=javascript>
            window.close();
		    </script>
		    <%
		    
		    return;
		}
		
		if(plusInfo.equals("join")) 
		{
// 			SessionForm sessionForm = new SessionForm();
// 			HttpSession Hsession = request.getSession();
			
// 			System.out.println("join �ڵ��� ���� �Ϸ� NAME======>" + name);
// 			System.out.println("join �ڵ��� ���� �Ϸ� DI======>" + DI);
// 			System.out.println("join �ڵ��� ���� �Ϸ� CI======>" + CI);

// 			sessionForm.setSessionName(name);
// 			//sessionForm.setSessionDistinguishid(DI);
// 			sessionForm.setSessionCi(CI);
// 			Hsession.setAttribute("JoinAuth", sessionForm);
		
			//��������
			%>
		    <!-- ���� -->
			<script language='javascript'>
			
			opener.CalForm.ci.value = "<%=CI%>";
			window.close();
			</script>
<%
		} else {
			//��������������
			%>
			<script language=javascript>
            alert("���������� �����Դϴ�.!!");
            window.close();
		    </script>
<%
		}
		
    }catch(Exception ex){
          System.out.println("[pcc] Receive Error -"+ex.getMessage());
    }
%>