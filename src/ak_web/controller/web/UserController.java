package ak_web.controller.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nets.websso.ssoclient.authcheck.SSOConfig;
import ak_web.model.web.CommonDAO;
import ak_web.model.web.LectureVo;
//
import ak_web.model.web.UserDAO;
import ak_web.classes.Utils;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserDAO user_dao;
	@Autowired
	private CommonDAO common_dao;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/user/login");
		
		Enumeration params = request.getParameterNames();
		System.out.println("----------------------------");
		while (params.hasMoreElements()){
		    String name = (String)params.nextElement();
		    System.out.println(name + " : " +request.getParameter(name));
		}
		System.out.println("----------------------------");


		
		return mav;
	}
	@RequestMapping("/login_proc")
	public ModelAndView login_proc(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/user/login_proc");
		
		String login_id = Utils.checkNullString(request.getParameter("userID"));
		String login_pw = Utils.checkNullString(request.getParameter("password"));
		System.out.println(login_id);
		System.out.println(login_pw);
		//login_pw = Utils.getHashString(login_pw);
		HashMap<String, Object> data = user_dao.loginCheck(login_id, login_pw);
		if(data != null) {
			if(Utils.checkNullString(data.get("LEAVE_YN")).equals("N"))
			{
				String[] searchList = null;
				
				
				mav.addObject("isSuc", "success");
				mav.addObject("msg", "환영합니다.");
				System.out.println("data.get(\"CUST_NO\") : "+Utils.checkNullString(data.get("CUST_NO")));
				HttpSession session = request.getSession();
				session.setAttribute("login_id", Utils.checkNullString(data.get("ID")));
				session.setAttribute("login_name", Utils.checkNullString(data.get("KOR_NM")));
				session.setAttribute("login_seq", Utils.checkNullString(data.get("CUST_NO")));
				session.setAttribute("login_store", Utils.checkNullString(data.get("STORE")));
				session.setAttribute("login_store_nm", Utils.checkNullString(data.get("STORE_NM")));
				session.setAttribute("login_cust", Utils.checkNullString(data.get("CUST_NO")));
				session.setAttribute("login_birth", Utils.checkNullString(data.get("BMD")));
				session.setAttribute("login_cus", Utils.checkNullString(data.get("CUS_NO")));
				session.setAttribute("login_card", Utils.checkNullString(data.get("CARD_NO")));
				session.setAttribute("login_ci", Utils.checkNullString(data.get("CI")));
				
				session.setAttribute("h_phone_no_1", Utils.checkNullString(data.get("H_PHONE_NO_1")));
				session.setAttribute("h_phone_no_2", Utils.checkNullString(data.get("H_PHONE_NO_2")));
				session.setAttribute("h_phone_no_3", Utils.checkNullString(data.get("H_PHONE_NO_3")));
				session.setAttribute("marry_fg", Utils.checkNullString(data.get("MARRY_FG")));
				session.setAttribute("sns_url", Utils.checkNullString(data.get("SNS_URL")));
				session.setAttribute("email_addr", Utils.checkNullString(data.get("EMAIL_ADDR")));
				
				String ip_addr = Utils.getClientIP(request);
				session.setAttribute("login_ip", ip_addr);
				//결제한 적 잇으면 기존, 없으면 신규
				int pereCnt = common_dao.getPereCnt(Utils.checkNullString(data.get("CUST_NO")));
				if(pereCnt > 0)
				{
					session.setAttribute("isNew", "N");
				}
				else
				{
					session.setAttribute("isNew", "Y");
				}
				
				System.out.println("*********************");
				System.out.println(Utils.checkNullString(data.get("PTL_ID")));
				System.out.println("*********************");
				
				String period = user_dao.retrievePeriod(Utils.checkNullString(data.get("STORE")));
				session.setAttribute("login_period", period);
				
				String memType = Utils.checkNullString(user_dao.retrieveMemType(Utils.checkNullString(data.get("ID"))));
				System.out.println("*********************");
				System.out.println(memType);
				System.out.println("*********************");
				session.setAttribute("memType", memType);
				
				String birthymd = Utils.checkNullString(data.get("BIRTH_YMD"));
				int iAge =  Integer.parseInt(Utils.getCurrentDate().substring(0,4)) - Integer.parseInt(birthymd.substring(0,4));
				System.out.println("LectureAction.java -- selectlist() >>>>>> iAge: "+iAge);      
				String sAgeYYYY   = null ;
				String sSex       = null ;
				String sSAgeGubun = null ;
				
				// 나이 기준 변경 만 20세 → 19세 (2014.02.06 김인숙 요청)
				if ( iAge >= 19  ) { // 성인 강좌 가능 
					sSAgeGubun = "A" ;
				}else {  // 영유아 강좌 가능 
					sSAgeGubun = "C" ;
				}
				System.out.println(sSAgeGubun);
				
				session.setAttribute("birthymd", birthymd);
				session.setAttribute("sSAgeGubun", sSAgeGubun);
				
				
				session.setAttribute("searchList", searchList);
				//session.setAttribute("last_login", data.get("LAST_LOGIN"));
				//user_dao.upLastLogin(data.get("SEQ_NO").toString());
				
				
				HashMap<String, Object> list = user_dao.retrieveCustNo(Utils.checkNullString(data.get("STORE")),Utils.checkNullString(data.get("CI"))); 
				String rsBA_Custno = "";
				String rsAKmem_Cardno = "";
				String rsAKmem_Cusno = "";
				String rsDi = "";
				String rsCi = "";
				String rsBrith_ymd = "";
				
				if(list.size()!= 0){
					rsBA_Custno = Utils.checkNullString(list.get("BA_CUST_NO"));
					rsAKmem_Cardno = Utils.checkNullString(list.get("AKMEM_CARD_NO"));
					rsAKmem_Cusno = Utils.checkNullString(list.get("AKMEM_CUSNO"));
					rsDi    = Utils.checkNullString(list.get("DI"));             
					rsCi    = Utils.checkNullString(list.get("CI"));             
					rsBrith_ymd = Utils.checkNullString(list.get("BIRTH_YMD"));  
					
					
					session.setAttribute("BA_Custno", Utils.checkNullString(data.get("BA_CUST_NO")));
					session.setAttribute("AKmem_Cardno", Utils.checkNullString(data.get("AKMEM_CARD_NO")));
					session.setAttribute("AKmem_Cusno", Utils.checkNullString(data.get("AKMEM_CUSNO")));
					session.setAttribute("Di", Utils.checkNullString(data.get("DI")));
					session.setAttribute("Ci", Utils.checkNullString(data.get("CI")));
					session.setAttribute("Brith_ymd", Utils.checkNullString(data.get("BIRTH_YMD")));
				}
				//
				session.setAttribute("UnifyYn", "Y"); //통합사용자 : Y 미통합 사용자 :N
				/*
            System.out.println("rsBA_Custno : "+rsBA_Custno);
            System.out.println("rsAKmem_Cardno : "+rsAKmem_Cardno);
            System.out.println("rsAKmem_Cusno : "+rsAKmem_Cusno);
            System.out.println("rsDi : "+rsDi);
            System.out.println("rsCi : "+rsCi);
            System.out.println("rsBrith_ymd : "+rsBrith_ymd);
				 */
				
				
			}else {
				mav.addObject("isSuc", "fail");
				mav.addObject("msg", "로그인에 실패하였습니다.");
			}
		}
		else
		{	
			mav.addObject("isSuc", "fail");
			mav.addObject("msg", "로그인에 실패하였습니다.");
		}
		return mav;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/user/logout");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return mav;
	}
	
}