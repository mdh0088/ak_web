<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ak_web.classes.XmlPropertyManager" %>
<%@ page import="java.net.InetAddress" %>
<%
	//  공통 시작  2014.07
    InetAddress inet = InetAddress.getLocalHost();
    String inet_ip = inet.getHostAddress();
    boolean g_conf_server    = false;
    

    String g_conf_site_name = XmlPropertyManager.getSystemProperty("g_conf_site_name");
    
    String g_conf_gw_port   = "8090";        // 포트번호(변경불가)
	String module_type      = "01";          // 변경불가
    int    g_conf_tx_mode   = 0;             // 변경불가
    
    //  공통 끝  2014.07
    
    String g_conf_js_url    = "";
    String g_conf_site_cd   = ""; 
	String g_conf_site_cd_ak   = ""; 
	String g_conf_site_key   = ""; 
	String g_conf_site_key_ak   = "";
	
	//KB국민제휴 추가20170926
	String g_conf_site_cd_akkb   = "";
	String g_conf_site_key_akkb   = "";
	
	String session_attend_store = "03"; //뮤자인 임시
    
//     if (inet_ip.equals(XmlPropertyManager.getSystemProperty("dev_was"))) { // 개발서버인 경우..
    	
//         out.println("개발서버에서 실행................................. ");
        g_conf_js_url    = XmlPropertyManager.getSystemProperty("g_conf_js_url_test");
     	g_conf_site_cd   = XmlPropertyManager.getSystemProperty("g_conf_site_cd_test"); 
     	g_conf_site_cd_ak   = XmlPropertyManager.getSystemProperty("g_conf_site_cd_test"); 
     	g_conf_site_cd_akkb = XmlPropertyManager.getSystemProperty("g_conf_site_cd_test"); 
     	g_conf_site_key   = XmlPropertyManager.getSystemProperty("g_conf_site_key_test");
     	g_conf_site_key_ak   = XmlPropertyManager.getSystemProperty("g_conf_site_key_test");
     	g_conf_site_key_akkb = XmlPropertyManager.getSystemProperty("g_conf_site_key_test");
    	
//     } else if (inet_ip.equals(XmlPropertyManager.getSystemProperty("front_was1")) || inet_ip.equals(XmlPropertyManager.getSystemProperty("front_was2"))) {
    	
//     	out.println("운영서버에서 실행................................. ");
//     	g_conf_js_url    = XmlPropertyManager.getSystemProperty("g_conf_js_url");
//     	g_conf_site_cd   = XmlPropertyManager.getSystemProperty("g_conf_site_cd_"+session_attend_store); 
//     	g_conf_site_cd_ak   = XmlPropertyManager.getSystemProperty("g_conf_site_cd_"+session_attend_store+"_AK"); 
//     	g_conf_site_key   = XmlPropertyManager.getSystemProperty("g_conf_site_key_"+session_attend_store); 
//     	g_conf_site_key_ak   = XmlPropertyManager.getSystemProperty("g_conf_site_key_"+session_attend_store+"_AK");
    	
//     	g_conf_site_cd_akkb   = XmlPropertyManager.getSystemProperty("g_conf_site_cd_"+session_attend_store+"_AKKB");
//     	g_conf_site_key_akkb   = XmlPropertyManager.getSystemProperty("g_conf_site_key_"+session_attend_store+"_AKKB");
    	
//     }
    %>
