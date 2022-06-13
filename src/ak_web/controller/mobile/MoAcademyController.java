package ak_web.controller.mobile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ak_web.classes.AKCommon;
import ak_web.classes.BABatchRun;
import ak_web.classes.Utils;
import ak_web.classes.XmlPropertyManager;
import ak_web.model.web.AcademyDAO;
import ak_web.model.web.CommonDAO;
import ak_web.model.web.CourseDAO;
import ak_web.model.web.LectureVo;
import ak_web.model.web.MainDAO;
import ak_web.model.web.UserDAO;
import oracle.sql.BLOB; 
@Controller
@RequestMapping("/mobile/academy/*")
public class MoAcademyController {
	
	@Value("${upload_dir}")
	private String upload_dir;
	
	@Value("${image_dir}")
	private String image_dir;
	
	@Autowired
	private AcademyDAO ac_dao;
	
	@Autowired
	private CourseDAO course_dao;
	
	@Autowired
	private CommonDAO common_dao;
	
	@Autowired
	private MainDAO main_dao;

	@Autowired
	private UserDAO user_dao;
	

	
	@RequestMapping("/lector01")
	public ModelAndView lector01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/lector01");
		HttpSession session = request.getSession();
		if("".equals(Utils.checkNullString(session.getAttribute("login_id")))){
			mav.addObject("loginChk","false");
		}else {
			mav.addObject("memType",session.getAttribute("memType"));
			mav.addObject("loginChk",session.getAttribute("login_id"));
		}
		
		return mav;
	}
	
	@RequestMapping("/lector02")
	public ModelAndView lector02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/lector02");
		HttpSession session = request.getSession();
		
		if("".equals(Utils.checkNullString(session.getAttribute("login_id")))){
			System.out.println(">>>>>>>>>>>>>>로그인이 필요 합니다<<<<<<<<<<<<<<");
			mav.addObject("resultCd", "-1");
			mav.addObject("resultMsg", "로그인이 필요 합니다.");
			mav.addObject("resultURL", "/user/login");
			return mav;
		}
		
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String reg_no = Utils.checkNullString(request.getParameter("reg_no"));
		
		String last_chk = ac_dao.last_chk(cust_no,reg_no); 
		if (!last_chk.equals("N")) {
			System.out.println(">>>>>>>>>>>>>>이미 제출되었습니다.<<<<<<<<<<<<<<");
			mav.addObject("resultCd", "-1");
			mav.addObject("resultMsg", "이미 제출되었습니다.");
			mav.addObject("resultURL", "/main");
			return mav;
		}
		
		mav.addObject("reg_no", reg_no);
		
		return mav;
	}
	
	@RequestMapping("/lector03")
	
	public ModelAndView lector03(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/lector03");
		HttpSession session = request.getSession();
		
		if("".equals(Utils.checkNullString(session.getAttribute("login_id")))){
			System.out.println(">>>>>>>>>>>>>>로그인이 필요 합니다<<<<<<<<<<<<<<");
			mav.addObject("resultCd", "-1");
			mav.addObject("resultMsg", "로그인이 필요 합니다.");
			mav.addObject("resultURL", "/user/login");
			return mav;
		}
		
		
		String image_path = image_dir+"recruit/";
		String sUsrId = Utils.checkNullString(session.getAttribute("login_id"));
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String skor_nm = Utils.checkNullString(session.getAttribute("login_name"));
		String sbirth_ymd = Utils.checkNullString(session.getAttribute("birthymd"));
		String smarry_fg = Utils.checkNullString(session.getAttribute("marry_fg"));
		String semail_addr = Utils.checkNullString(session.getAttribute("email_addr"));
		String sh_phone_no_1 = Utils.checkNullString(session.getAttribute("h_phone_no_1"));
		String sh_phone_no_2 = Utils.checkNullString(session.getAttribute("h_phone_no_2"));
		String sh_phone_no_3 = Utils.checkNullString(session.getAttribute("h_phone_no_3"));
		String user_id = Utils.checkNullString(request.getParameter("user_id"));
		String reg_no = Utils.checkNullString(request.getParameter("reg_no"));
		
		String last_chk = ac_dao.last_chk(cust_no,reg_no); 
		if (!last_chk.equals("N")) {
			System.out.println(">>>>>>>>>>>>>>이미 제출되었습니다.<<<<<<<<<<<<<<");
			mav.addObject("resultCd", "-1");
			mav.addObject("resultMsg", "이미 제출되었습니다.");
			mav.addObject("resultURL", "/main");
			return mav;
		}
		
		HashMap<String, Object> data = ac_dao.getMarrySNS(cust_no);
		String marry_fg = Utils.checkNullString(data.get("MARRY_FG"));
		String sns_url = Utils.checkNullString(data.get("SNS_URL"));
		
		HashMap<String, Object> usr_info = new HashMap<>();
		HashMap<String, Object> list = ac_dao.ApplyListInfo(reg_no, cust_no); 
		
		mav.addObject("skor_nm", skor_nm);
		mav.addObject("sbirth_ymd", sbirth_ymd);
		mav.addObject("marry_fg", marry_fg);
		mav.addObject("sns_url", sns_url);
		mav.addObject("semail_addr", semail_addr);
		mav.addObject("sh_phone_no_1", sh_phone_no_1);
		mav.addObject("sh_phone_no_2", sh_phone_no_2);
		mav.addObject("sh_phone_no_3", sh_phone_no_3);
		mav.addObject("image_path", image_path);
		mav.addObject("user_id", user_id);
		mav.addObject("reg_no", reg_no);
	
		for (String key : list.keySet()) {
			System.out.println(key+":"+list.get(key));				
			mav.addObject(key, list.get(key));
		}
		
		
		return mav;
	}
	
	@RequestMapping("/lector04")
	public ModelAndView lector04(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/lector04");
		
		HttpSession session = request.getSession();
		
		if("".equals(Utils.checkNullString(session.getAttribute("login_id")))){
			System.out.println(">>>>>>>>>>>>>>로그인이 필요 합니다<<<<<<<<<<<<<<");
			mav.addObject("resultCd", "-1");
			mav.addObject("resultMsg", "로그인이 필요 합니다.");
			mav.addObject("resultURL", "/user/login");
			return mav;
		}
		
		String sUsrId = Utils.checkNullString(session.getAttribute("login_id"));
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String reg_no = Utils.checkNullString(request.getParameter("reg_no"));
		String returnURL = Utils.checkNullString(request.getParameter("returnURL"));
		String last_chk = ac_dao.last_chk(cust_no,reg_no); 
		
		if (!last_chk.equals("N")) {
			System.out.println(">>>>>>>>>>>>>>이미 제출되었습니다.<<<<<<<<<<<<<<");
			mav.addObject("resultCd", "-1");
			mav.addObject("resultMsg", "이미 제출되었습니다.");
			mav.addObject("resultURL", "/main");
			return mav;
		}
		
			
		HashMap<String, Object> usr_info = new HashMap<>();			
		HashMap<String, Object> list = ac_dao.ApplyListInfo2(reg_no, cust_no); 
		
		mav.addObject("reg_no", reg_no);
		for (String key : list.keySet()) {
			System.out.println(key+":"+list.get(key));				
			mav.addObject(key, list.get(key));
		}
		//mav.addObject("result", list);
		System.out.println("lector4 list : "+ list);
		
		return mav;
	}
	
	@RequestMapping("/lector05")
	public ModelAndView lector05(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/lector05");
		HttpSession session = request.getSession();

		if("".equals(Utils.checkNullString(session.getAttribute("login_id")))){
			System.out.println(">>>>>>>>>>>>>>로그인이 필요 합니다<<<<<<<<<<<<<<");
			mav.addObject("resultCd", "-1");
			mav.addObject("resultURL", "/user/login");
			mav.addObject("resultMsg", "로그인이 필요 합니다.");
			return mav;
		}
		return mav;
	}
	
	@RequestMapping("/goNewsWrite")
	public ModelAndView goNewsWrite(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		
		if("".equals(Utils.checkNullString(session.getAttribute("login_id")))){
			System.out.println(">>>>>>>>>>>>>>로그인이 필요 합니다<<<<<<<<<<<<<<");
			mav.addObject("resultCd", "-1");
			mav.addObject("resultMsg", "로그인이 필요 합니다.");
			mav.addObject("resultURL", "/user/login");
			mav.setViewName("/WEB-INF/pages/web/academy/lector02");
			return mav;
		}
		
		String sUsrId = Utils.checkNullString(session.getAttribute("login_id"));
		String sCi = Utils.checkNullString(session.getAttribute("Ci"));
		String check = Utils.checkNullString(ac_dao.Check(sCi));
		
		if(check.equals("N")){
				List<HashMap<String, Object>> list = ac_dao.Result(sUsrId,sCi);
                mav.addObject("check", "N");
                mav.addObject("result", list);
                mav.setViewName("/WEB-INF/pages/web/academy/result01");
			
		}else if(check.equals("Y")){
			String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
			String reg_no = ac_dao.getRegNo(cust_no);
			
			HashMap<String, Object> usr_info = new HashMap<>();
			usr_info = ac_dao.usr_info(cust_no);
			usr_info.put("reg_no", reg_no);
			usr_info.put("User_id", sUsrId);			
			
			ac_dao.insWBREC(usr_info);
			ac_dao.insWBPLA(usr_info);
		
			mav.addObject("reg_no", reg_no);
			System.out.println("create new reg_no :"+ reg_no);
			mav.setViewName("redirect:/mobile/academy/lector02");	
		}
		return mav;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println("save start");
		HttpSession session = request.getSession();
		
        int sizeLimit = 10*1024*1024; //10메가 까지 가능
        String uploadPath = upload_dir+"recruit/"; 
        File dir = new File(uploadPath);
		if (!dir.exists()) { // 디렉토리가 존재하지 않으면
			dir.mkdirs(); // 디렉토리 생성
		}
        
        
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
			HashMap<String, Object> param = new HashMap<>();
			Enumeration paramList = multi.getParameterNames();
			while(paramList.hasMoreElements()) {
			  String name = (String) paramList.nextElement();
			  param.put(name, Utils.checkNullString(multi.getParameter(name)));
			}
			
			String returnURL = Utils.checkNullString(multi.getParameter("returnURL"));
			mav.setViewName("/WEB-INF/pages/mobile/academy/"+returnURL);
			
			if("".equals(Utils.checkNullString(session.getAttribute("login_id")))){	//로그인chk
				System.out.println(">>>>>>>>>>>>>>로그인이 필요 합니다<<<<<<<<<<<<<<");
				mav.addObject("resultCd", "-1");
				mav.addObject("resultMsg", "로그인이 필요 합니다.");
				mav.addObject("resultURL", "/user/login");
				return mav;
			}
			String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
			String last_chk = ac_dao.last_chk(cust_no,Utils.checkNullString(param.get("reg_no"))); 
			if (!last_chk.equals("N")) {
				System.out.println(">>>>>>>>>>>>>>이미 제출되었습니다.<<<<<<<<<<<<<<");
				mav.addObject("resultCd", "-1");
				mav.addObject("resultMsg", "이미 제출되었습니다.");
				mav.addObject("resultURL", "/main");
				return mav;
			}
			
			String sUsrId = Utils.checkNullString(session.getAttribute("login_id"));

			ac_dao.uptMarrySNS(cust_no,Utils.checkNullString(param.get("marry_fg")),Utils.checkNullString(param.get("sns_url")));
			
			////////////////////////////////////////////file start ///////////////////////////////////////////////////////////////
			String filename = Utils.convertFileName(Utils.checkNullString(multi.getOriginalFileName("photo_nm")), uploadPath, 1);
			String filename_ori = Utils.checkNullString(multi.getOriginalFileName("photo_nm"));
			
			if("".equals(filename))
			{
				HashMap<String, Object> data = ac_dao.getNewsFileName(cust_no,Utils.checkNullInt(param.get("reg_no")));
				if(data != null && data.get("FILE_NM") != null && data.get("FILE_ORI") != null)
				{
					filename = Utils.checkNullString(data.get("FILE_NM"));
					filename_ori = Utils.checkNullString(data.get("FILE_ORI"));
				}
			}
			///////////////////////////////////////////file end ///////////////////////////////////////////////////////////////
			param.put("cust_no", cust_no);
			param.put("file_nm", filename);
			param.put("file_ori", filename_ori);
			ac_dao.Save(param);
			
			mav.setViewName("redirect:/mobile/academy/"+returnURL);
			mav.addObject("reg_no", Utils.checkNullString(param.get("reg_no")));
		} catch (IOException ex) {
			mav.addObject("result", null);
			mav.addObject("error", "file");
			mav.addObject("exception", ex);
		} catch (Exception ex) {
			throw ex;
		}
		
		return mav;
	}
	
	@RequestMapping("/save02")
	public ModelAndView save02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		int sizeLimit = 10*1024*1024; //10메가 까지 가능
        String uploadPath = upload_dir+"recruit/attach/"; 
        File dir = new File(uploadPath);
		if (!dir.exists()) { // 디렉토리가 존재하지 않으면
			dir.mkdirs(); // 디렉토리 생성
		}
		

		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

			HashMap<String, Object> param = new HashMap<>();
			Enumeration paramList = multi.getParameterNames();
			while(paramList.hasMoreElements()) {
			  String name = (String) paramList.nextElement();
			  param.put(name, Utils.checkNullString(multi.getParameter(name)));
			}
			
			String returnURL = Utils.checkNullString(multi.getParameter("returnURL"));
			mav.setViewName("/WEB-INF/pages/mobile/academy/"+returnURL);
			
			if("".equals(Utils.checkNullString(session.getAttribute("login_id")))){
				System.out.println(">>>>>>>>>>>>>>로그인이 필요 합니다<<<<<<<<<<<<<<");
				mav.addObject("resultCd", "-1");
				mav.addObject("resultMsg", "로그인이 필요 합니다.");
				mav.addObject("resultURL", "/user/login");
				return mav;
			}
			String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
			String last_chk = ac_dao.last_chk(cust_no,Utils.checkNullString(param.get("reg_no"))); 
			if (!last_chk.equals("N")) {
				System.out.println(">>>>>>>>>>>>>>이미 제출되었습니다.<<<<<<<<<<<<<<");
				mav.addObject("resultCd", "-1");
				mav.addObject("resultMsg", "이미 제출되었습니다.");
				mav.addObject("resultURL", "/main");
				return mav;
			}
			
			String sUsrId = Utils.checkNullString(session.getAttribute("login_id"));
			
			////////////////////////////////////////////file start ///////////////////////////////////////////////////////////////
			String filename = Utils.convertFileName(Utils.checkNullString(multi.getOriginalFileName("file_nm")), uploadPath, 1);
			String filename_ori = Utils.checkNullString(multi.getOriginalFileName("file_nm"));
			
			System.out.println("filename : "+filename);
			System.out.println("filename_ori : "+filename_ori);
			
			if("".equals(filename))
			{
				HashMap<String, Object> data = ac_dao.getNewsFileName2(cust_no,Utils.checkNullInt(param.get("reg_no")));
				if(data != null && data.get("FILE_NM") != null && data.get("FILE_ORI") != null)
				{
	

					filename = Utils.checkNullString(data.get("FILE_NM"));
					filename_ori = Utils.checkNullString(data.get("FILE_ORI"));
				}
			}
			///////////////////////////////////////////file end ///////////////////////////////////////////////////////////////
			
			param.put("cust_no", cust_no);
			param.put("file_nm", filename);
			param.put("file_ori", filename_ori);
			ac_dao.Save02(param);
			
			if (returnURL.equals("lector05")) {
				ac_dao.lastSubmit(cust_no,Utils.checkNullString(multi.getParameter("reg_no")));
			}
			
			mav.addObject("reg_no", Utils.checkNullString(multi.getParameter("reg_no")));
			mav.setViewName("redirect:/mobile/academy/"+returnURL);
		} catch (IOException ex) {
			mav.addObject("result", null);
			mav.addObject("error", "file");
			mav.addObject("exception", ex);
		} catch (Exception ex) {
			throw ex;
		}
		
		return mav;
	}
	
	@RequestMapping("/delAply")
	@ResponseBody
	public HashMap<String, Object> delAply(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String reg_no = Utils.checkNullString(request.getParameter("reg_no"));


		int result = ac_dao.delAply(cust_no,reg_no);
		String msg="";
		System.out.println("result :"+ result);
		if (result>=2) {
			msg="정상 처리되었습니다.";
		}else {
			msg="관리자에게 문의해주세요";
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("msg", msg);
		map.put("resultNum", result);
		
		return map;
	}
	
	@RequestMapping("/result01")
	public ModelAndView result01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/result01");
		HttpSession session = request.getSession();
		
		if("".equals(Utils.checkNullString(session.getAttribute("login_id")))){
			System.out.println(">>>>>>>>>>>>>>로그인이 필요 합니다<<<<<<<<<<<<<<");
			mav.addObject("resultCd", "-1");
			mav.addObject("resultMsg", "로그인이 필요 합니다.");
			mav.addObject("resultURL", "/user/login");
			return mav;
		}
		mav.addObject("endPoint", "5");
		
		return mav;
	}
	
	@RequestMapping("/getApplyResult")
	@ResponseBody
	public HashMap<String, Object> getApplyResult(HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		
		
		List<HashMap<String, Object>> listCnt = ac_dao.getApplyResultCount(cust_no);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int e_point = Integer.parseInt(Utils.checkNullString(request.getParameter("endPoint")));
		System.out.println("e_point : "+e_point);
	
		List<HashMap<String, Object>> list = ac_dao.getApplyResult(0, e_point, cust_no); 
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		map.put("list", list);
		map.put("e_point", e_point);
		
		return map;
	}

}