<%
/**************************************************************************************************************************
* Program Name  : 본인확인 결과 수신 JSP
* File Name     : PccV4_result1.jsp
* Comment       : 
* History       :  위변조 검증 
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
    // 변수 -------------------------------------------------------------------------------------------------------------
    String rec_cert		= "";																//결과수신DATA

	String k_certNum	= "";                                                       		//파라미터로 수신한 요청번호
	String certNum		= "";																// 요청번호
    String date			= "";																// 요청일시
	String CI	    	= "";																// 연계정보(CI)
	String DI	    	= "";																// 중복가입확인정보(DI)
    String phoneNo		= "";																// 휴대폰번호
	String phoneCorp	= "";																// 이동통신사
	String birthDay		= "";																// 생년월일
	String gender		= "";																// 성별
	String nation		= "";																// 내국인
	String name			= "";																// 성명
	String M_name		= "";																// 미성년자 성명
	String M_birthDay	= "";																// 미성년자 생년월일
	String M_Gender		= "";																// 미성년자 성별
	String M_nation		= "";																// 미성년자 내외국인
    String result		= "";																// 결과값

    String certMet		= "";																// 인증방법
    String ip			= "";																// ip주소
	String plusInfo		= "";

	String encPara		= "";
	String encMsg1		= "";
	String encMsg2		= "";
	String msgChk       = ""; 
    //-----------------------------------------------------------------------------------------------------------------
	System.out.println("param >>>>>>>>>>>>>>결과 시작 페이지>>>>>>>>>>> :");
    try
    {
    	// Parameter 수신 --------------------------------------------------------------------
        rec_cert       = request.getParameter("rec_cert").trim();
        k_certNum      = request.getParameter("certNum").trim(); 
        System.out.println("param >>>>>>>>>>>>>>암호화 모듈 시작 전>>>>>>>>>>> :");
		//01. 암호화 모듈 (jar) Loading
		com.icert.comm.secu.IcertSecuManager seed = new com.icert.comm.secu.IcertSecuManager();
        System.out.println("param >>>>>>>>>>>>>>암호화 모듈 시작 전끝>>>>>>>>>>> :");
		//02. 1차 복호화
		//수신된 certNum를 이용하여 복호화
		rec_cert  = seed.getDec(rec_cert, k_certNum);
		
		//03. 1차 파싱
		int inf1 = rec_cert.indexOf("/",0);
		int inf2 = rec_cert.indexOf("/",inf1+1);
		
		encPara  = rec_cert.substring(0,inf1);         //암호화된 통합 파라미터
		encMsg1  = rec_cert.substring(inf1+1,inf2);    //암호화된 통합 파라미터의 Hash값
        System.out.println("param >>>>>>>>>>>>>>위변조 검증 전>>>>>>>>>>> :");
		//04. 위변조 검증
		encMsg2  = seed.getMsg(encPara);
		
		if(encMsg2.equals(encMsg1)){
		    msgChk="Y";
		}
		
		if(msgChk.equals("N")){
		%>
		    <script language=javascript>
		    alert("비정상적인 접근입니다.!!<%=msgChk%>");
		    </script>
		<%
			return;
		}
		System.out.println("param >>>>>>>>>>>>>> 복호화 전>>>>>>>>>>> :");
		//05. 2차 복호화
		rec_cert  = seed.getDec(encPara, k_certNum);
		
		//06. 2차 파싱
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
		System.out.println("param >>>>>>>>>1>>>>> 복호화 전>>>>>>>>>>> :");
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
		System.out.println("param >>>>>>>>>>>>>> 복호화 전2>>>>>>>>>>> :");
		//07. CI, DI 복호화
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
			
// 			System.out.println("join 핸드폰 인증 완료 NAME======>" + name);
// 			System.out.println("join 핸드폰 인증 완료 DI======>" + DI);
// 			System.out.println("join 핸드폰 인증 완료 CI======>" + CI);

// 			sessionForm.setSessionName(name);
// 			//sessionForm.setSessionDistinguishid(DI);
// 			sessionForm.setSessionCi(CI);
// 			Hsession.setAttribute("JoinAuth", sessionForm);
		
			//정상접근
			%>
		    <!-- 정상 -->
			<script language='javascript'>
			
			opener.CalForm.ci.value = "<%=CI%>";
			window.close();
			</script>
<%
		} else {
			//비정상적인접근
			%>
			<script language=javascript>
            alert("비정상적인 접근입니다.!!");
            window.close();
		    </script>
<%
		}
		
    }catch(Exception ex){
          System.out.println("[pcc] Receive Error -"+ex.getMessage());
    }
%>