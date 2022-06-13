package ak_web.classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import ak_web.model.web.CommonDAO;
import ak_web.model.web.CourseDAO;
import ak_web.model.web.MainDAO;
import nets.websso.ssoclient.authcheck.AuthStatus;

public class HttpUtils {	
	


	public static String getPageUrl(HttpServletRequest request, String url, String procMethod) throws Exception
	{
	    //접근제한 방식(기본 : URL방식)
	    procMethod = StringUtil.nvl(procMethod, "URL");
	    
	    //세션에서 회원구분을 추출하여 저장(2016.02.03)
	    String processResult = "Pass"; //S-LyPop :레이어팝업 실행, T-Pass : 통합회원-기존처리방식 유지, Pass :기존처리방식 유지
	    String memType="";
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));;
		
		
	    //AuthStatus status = (AuthStatus)request.getAttribute("status");
	    //SessionManager sessionManager = new SessionManager(request);
	    
	    //로그인 여부 확인	    
	    //if(status == AuthStatus.SSOSuccess)
	    if (!cust_no.equals(""))
	    {
	    	memType = Utils.checkNullString(session.getAttribute("memType"));;
	        System.out.println(">>>>>>>>>>> getPageUrl memType=" + memType);
	        System.out.println(">>>>>>>>>>> aKAccessRestrictUtil.getProcessResult url=" + url);
	        
	        //접근제한 처리
	        AKAccessRestrictUtil aKAccessRestrictUtil = AKAccessRestrictUtil.getInstance();
	        processResult = aKAccessRestrictUtil.getProcessResult(url, memType, procMethod); //S-LyPop :레이어팝업 실행, T-Pass : 통합회원-기존처리방식 유지, Pass :기존처리방식 유지	        
	        
	        System.out.println(">>>>>>>>>>> aKAccessRestrictUtil.getProcessResult processResult=" + processResult);	        
	    }
	    	    	    
	    return processResult;
	}

}
