package ak_web.controller.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

import ak_web.classes.HolidayUtil;
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
@RequestMapping("/academy/*")
public class AcademyController {
	
	@Value("${upload_dir}")
	private String upload_dir;
	
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
	
	@Value("${image_dir}")
	private String image_dir;
	
	//@RequestMapping({"/", "/news"})
	@RequestMapping("/news")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/news");
		Utils.setSearchVal(mav, main_dao);
		return mav;
	}
	
	@RequestMapping("/academy01")
	public ModelAndView academy01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/academy01");
		
		return mav;
	}
	
	@RequestMapping("/academy02")
	public ModelAndView academy02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/academy02");
		HttpSession session = request.getSession();
		String kor_nm = Utils.checkNullString(session.getAttribute("login_name"));
		
		//List<HashMap<String, Object>> seasonList = ac_dao.getSeason();
		//mav.addObject("seasonList", seasonList);
		mav.addObject("kor_nm", kor_nm);
		return mav;
	}
	
	@RequestMapping("/academy03")
	public ModelAndView academy03(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/academy03");
		
		return mav;
	}
	
	@RequestMapping("/academy04")
	public ModelAndView academy04(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/academy04");
		
		
		HttpSession session = request.getSession();
		//String cust_no = session.getAttribute("login_seq").toString();
		String kor_nm = Utils.checkNullString(session.getAttribute("login_name"));
		
		String store = Utils.checkNullString(session.getAttribute("login_store"));
		String store_nm="";
		
		if (store.equals("01")) {
			store_nm="구로";
		}else if (store.equals("02")) {
			store_nm="수원";
		}else if (store.equals("03")) {
			store_nm="분당";
		}else if (store.equals("04")) {
			store_nm="평택";
		}else if (store.equals("05")) {
			store_nm="원주";
		}

		mav.addObject("kor_nm", kor_nm);
		mav.addObject("store_nm", store_nm);
		
		return mav;
	}
	
	@RequestMapping("/academy05")
	public ModelAndView academy05(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/academy05");
		
		return mav;
	}
	
	@RequestMapping("/academy06")
	public ModelAndView academy06(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/academy06");
		
		return mav;
	}
	
	@RequestMapping("/attendance01")
	public ModelAndView attendance01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/attendance01");
		
		return mav;
	}
	
	@RequestMapping("/attendance02")
	public ModelAndView attendance02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/attendance02");
		
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(request.getParameter("period"));
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		
		HashMap<String, Object> list = ac_dao.getLecrInfo(store,period,subject_cd);
		for (String key : list.keySet()) {
			System.out.println(key+":"+list.get(key));				
			mav.addObject(key, list.get(key));
		}
		
		
		mav.addObject("store", store);
		mav.addObject("period", period);
		mav.addObject("subject_cd", subject_cd);
		
		
		
		return mav;
	}
	
	@RequestMapping("/catalog")
	public ModelAndView catalog(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/catalog");
		
		return mav;
	}
	
	@RequestMapping("/certificate01")
	public ModelAndView certificate01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/certificate01");
		
		List<HashMap<String, Object>> branchList = common_dao.getBranch();
		mav.addObject("branchList", branchList);
		mav.addObject("year", Utils.getDateNow("year"));
		return mav;
	}
	
	@RequestMapping("/certificate02")
	public ModelAndView certificate02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/certificate02");
		
		return mav;
	}
	
	@RequestMapping("/certificate03")
	public ModelAndView certificate03(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/certificate03");
		
		return mav;
	}
	
	@RequestMapping("/contract01")
	public ModelAndView contract01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/contract01");
		
		List<HashMap<String, Object>> branchList = common_dao.getBranch();
		mav.addObject("branchList", branchList);
		
		//List<HashMap<String, Object>> seasonList = ac_dao.getSeason();
		//mav.addObject("seasonList", seasonList);
		
		return mav;
	}
	
	@RequestMapping("/contract02")
	public ModelAndView contract02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/contract02");
		
		HttpSession session = request.getSession();
		String cus_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(request.getParameter("period"));
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		
		System.out.println("cus_no : "+cus_no);
		System.out.println("store : "+store);
		System.out.println("period : "+period);
		System.out.println("subject_cd : "+subject_cd);
		
		HashMap<String, Object> data = ac_dao.getContractInfo02(store,period,cus_no,subject_cd);
		for (String key : data.keySet()) {
			System.out.println(key+":"+data.get(key));				
			mav.addObject(key, data.get(key));
		}
		
		
		String cont_day =  Utils.checkNullString(data.get("CONTRACT_DAY"));
		
		if (!cont_day.equals("")) {
			mav.addObject("CONT_YEAR", cont_day.substring(0, 4));
			mav.addObject("CONT_MON", cont_day.substring(4, 6));
			mav.addObject("CONT_DAY", cont_day.substring(6, 8));
		}
		else
		{
			mav.addObject("CONT_YEAR", "0000");
			mav.addObject("CONT_MON", "00");
			mav.addObject("CONT_DAY", "00");
		}
		
		
		
		
		int regis_fee = Utils.checkNullInt(data.get("REGIS_FEE"));
	      int food_amt = 0;
	      if("Y".equals(Utils.checkNullString(data.get("FOOD_YN"))))
	      {
	         food_amt = Utils.checkNullInt(data.get("FOOD_AMT"));
	      }
	      int lect_cnt =Utils.checkNullInt(data.get("LECT_CNT"));
	      int mid_regis_fee = (int) Math.round((double)regis_fee / lect_cnt );
	      mid_regis_fee = (mid_regis_fee + 5)/10 * 10; //일의자리 반올림하기위함 
	      
	      
	      int mid_food_amt = 0;
	      if("Y".equals(Utils.checkNullString(data.get("FOOD_YN"))))
	      {
	         mid_food_amt = (int) Math.round((double)food_amt / lect_cnt);
	         mid_food_amt = (mid_food_amt + 5)/10 * 10; //일의자리 반올림하기위함 
	      }
		
	      mav.addObject("lect_cnt", lect_cnt);
	      mav.addObject("regis_fee", regis_fee);
	      mav.addObject("mid_regis_fee", mid_regis_fee);
	      mav.addObject("mid_food_amt", mid_food_amt);
		
		return mav;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/detail");
		String seq = Utils.checkNullString(request.getParameter("seq"));
		HashMap<String, Object> data = ac_dao.getNewsOne(seq);
		
		ac_dao.upNewsViews(seq); //조회수 업데이트
		mav.addObject("data", data);
		mav.addObject("image_dir", image_dir);
		return mav;
	}
	
	@RequestMapping("/lector01")
	public ModelAndView lector01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/lector01");
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
		mav.setViewName("/WEB-INF/pages/web/academy/lector02");
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
		mav.setViewName("/WEB-INF/pages/web/academy/lector03");
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
		mav.setViewName("/WEB-INF/pages/web/academy/lector04");
		
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
		System.out.println("lector4 list : "+ list);
		
		return mav;
	}
	
	@RequestMapping("/lector05")
	public ModelAndView lector05(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/lector05");
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
	
	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println("save start");
		HttpSession session = request.getSession();
		
		
        
		int sizeLimit = 10*1024*1024; //10메가 까지 가능
        String uploadPath = upload_dir+"recruit/"; 
        System.out.println("uploadPath : "+uploadPath);
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
			
			String returnURL = Utils.checkNullString(multi.getParameter("returnURL")); //returnURL 세팅
			mav.setViewName("/WEB-INF/pages/web/academy/"+returnURL);
			
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
			
			mav.setViewName("redirect:/academy/"+returnURL);
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
			mav.setViewName("/WEB-INF/pages/web/academy/"+returnURL);
			
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
		    mav.setViewName("redirect:/academy/"+returnURL);	
		} catch (IOException ex) {
			mav.addObject("result", null);
			mav.addObject("error", "file");
			mav.addObject("exception", ex);
		} catch (Exception ex) {
			throw ex;
		}
		
		return mav;
	}
	
	@RequestMapping("/order")
	public ModelAndView order(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/order");
		
		
		HttpSession session = request.getSession();
		LectureVo actionobj = new LectureVo();
		actionobj.setHq(Utils.removeNULL(request.getParameter("hq"),"00")); //그룹구분(00은 애경유통그룹)
        actionobj.setStore(Utils.removeNULL(session.getAttribute("login_store"),"")); //점구분
        actionobj.setPeriod(Utils.removeNULL(session.getAttribute("login_period"),Utils.checkNullString(common_dao.retrievePeriod(Utils.removeNULL(session.getAttribute("login_store"),"")).get("PERIOD")))); //강좌차수
        actionobj.setAttendCustNo(Utils.checkNullString(session.getAttribute("login_cust"))); //수강자 고객번호
        actionobj.setSessionId(Utils.checkNullString(session.getAttribute("login_id"))); //세션 id
        
        String subject_cd[] = Utils.removeNULL(request.getParameter("subject_cd"),"").split("_");
        String tot_subject_cd = "";
        
        for(int i = 0; i < subject_cd.length; i++)
        {
        	if(i != 0 ) {tot_subject_cd += ",";}
        	tot_subject_cd += subject_cd[i];
        }
        System.out.println("tot_subject_cd : "+tot_subject_cd);
        actionobj.setTot_subject_cd(tot_subject_cd); //접수 강좌코드
        
		
		boolean strFlag = true;
        boolean strFlag2 = true;
        boolean strFlag7 = true;
        boolean strFlag4 = true;
        
        int CheckGiftCnt = ac_dao.selectLectGift(actionobj);
        
        if(CheckGiftCnt == 0){  // 존재 해야 사용가능 
            strFlag4  = false;
        }
        
        /* 연속수강자 무료수강권 사용여부 체크 (2011.01.11) */
        boolean strFlag5 = true;      
        int CheckFreeUseCnt = ac_dao.selectFreeUse(actionobj);
        
        if(CheckFreeUseCnt > 0){  // 존재하면 추가 사용 불가 
            strFlag5  = false;
        }
        
        /* 정기강좌 단기강좌 존재여부 체크  (2011.04.18) */     
        // 11.11.29  수원점 내부 리뉴얼 공사로 6회이상으로 변경(이소진)
        // ★ 전점 10회이상으로 이전동일하게 수정 (2012.01.11) 윤정희대리 확인
        boolean strFlag1 = true;
        int CheckLectCnt = ac_dao.selectLectCntUse(actionobj);
        
        if(CheckLectCnt == 0){  // 정기강좌 단기강좌 존재여부 체크  (10회 이상 강좌 존재시 True)
            strFlag1  = false;
        }
        
        /* 신설 에누리 강좌 존재 여부 체크 (2011.04.18) */        
        boolean strFlag6 = true;
        int CheckSubjectEnuriCnt = ac_dao.selectSubjectEnuriUse(actionobj);
        
        if(CheckSubjectEnuriCnt <= 0){  // 신설 에누리 강좌가 존재하면 Ture 
            strFlag6  = false;
        }

        /* 기간 할인 사용여부 체크 (2016.01.14) */
        boolean strFlag9 = true;
        int CheckPeriodSaleCnt = ac_dao.selectPeriodSale(actionobj);
        
        if(CheckPeriodSaleCnt > 0){  // 존재하면 추가 사용 불가 
        	System.out.println("CheckPeriodSaleCnt:::"+CheckPeriodSaleCnt);
        	strFlag9  = false;
        }
        
        /* 기간,회원 할인 존재 여부 체크 (2015.10.16) */
        //시간이 없이 개발하는 과정 두번 vo에 담아서 처리할 이유가 없는데 추후 확인후 다시수정 일단 오픈이 목적
        //그리고 쿼리에서 vo에 담았기에 다시 안담아도 되는지도 테스트해야됨 낼 하자!!!!!!!!!!!!!
        boolean strFlag8 = true;
        List list8 = ac_dao.selectGiftEnuri(actionobj);
        for(int i = 0 ; i < list8.size(); i++){
        	LectureVo vo8 = (LectureVo)list8.get(i);
        	actionobj.setGift_enuri_fg(vo8.getGift_enuri_fg());
    		actionobj.setGift_user_enuri(vo8.getGift_user_enuri());
    		actionobj.setGift_date_enuri(vo8.getGift_date_enuri());
    		actionobj.setGift_date_enuri2(vo8.getGift_date_enuri2());
    		actionobj.setGift_date_from(vo8.getGift_date_from());
    		actionobj.setGift_date_from2(vo8.getGift_date_from2());
    		actionobj.setGift_date_to(vo8.getGift_date_to());
    		actionobj.setGift_date_to2(vo8.getGift_date_to2());
        }
        if(list8.size() <= 0){  // 기간 회원할인 존재 Ture 
        	strFlag8  = false;
        }
        //이거 안나오면 밑에다가 넣고 다시 조회
        
        /* 6인이하 소수정예강좌  제외 (2017.04.12) */
        boolean strFlag11 = true;
        
        actionobj.setFlag1(strFlag1);
        actionobj.setFlag4(strFlag4);
        actionobj.setFlag5(strFlag5);
        actionobj.setFlag6(strFlag6);
        actionobj.setFlag8(strFlag8);
        actionobj.setFlag9(strFlag9);
        actionobj.setFlag11(strFlag11);
        
        
        System.out.println (" Action-settle-strFlag1 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag1);
        System.out.println (" Action-settle-strFlag4 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag4);
        System.out.println (" Action-settle-strFlag5 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag5);
        System.out.println (" Action-settle-strFlag6 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag6);
        System.out.println (" Action-settle-strFlag8 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag8);
        System.out.println (" Action-settle-strFlag9 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag9);
        
    	List list = ac_dao.selectPayIngView(actionobj);
    	actionobj.setList(list);
    	for(int i = 0 ; i < list.size(); i++)
		{
    		LectureVo lectureVo = new LectureVo();
    		lectureVo = (LectureVo)list.get(i);
    		lectureVo.setHq(Utils.removeNULL(request.getParameter("hq"),"00")); //그룹구분(00은 애경유통그룹)
    		lectureVo.setStore(Utils.removeNULL(session.getAttribute("login_store"),"")); //점구분
    		lectureVo.setPeriod(Utils.removeNULL(session.getAttribute("login_period"),Utils.checkNullString(common_dao.retrievePeriod(Utils.removeNULL(session.getAttribute("login_store"),"")).get("PERIOD")))); //강좌차수
    		lectureVo.setAttendCustNo(Utils.removeNULL(session.getAttribute("login_cust"),"")); //수강자 고객번호
    		lectureVo.setSessionId(Utils.checkNullString(session.getAttribute("login_id"))); //세션 id
//        		★  12.01.11 기존로직대로 전점 10회이상 통일(윤정희대리 확인함)
            if (lectureVo.getLect_cnt() < 10) {   // 정규강좌 여부 체크 정규강좌 있으면 TURE
                strFlag = false;                
            }
            if (lectureVo.getLect_cnt() >= 10) {  // 단기강좌 여부 체크 단기강좌 있으면 TURE
                strFlag2 = false;
            }
            
            if ((int)lectureVo.getEnuri_per() <= 0 ) { // 신설에누리 강좌  존재하면  TURE   신설강좌 존재여부 체크 (2011.04.13)
                strFlag6  = false;
            }
            
            if ((int)lectureVo.getEnuri_per() > 0 ) { // 신설에누리 강좌  미존재 하면 TURE   신설강좌 존재여부 체크 (2011.04.13)
                strFlag7  = false;
            }
            
            if ((int)lectureVo.getCapacity_no() < 7 ) { // 정원수 6인이하 여부 체크 (2011.04.13)
                strFlag11  = false;
            }
            
    		try {
    			// 결제 시 책가방 결제일자   UPdate
    			ac_dao.tempPayDateSet(lectureVo);
    		} 
    		catch(Exception e)
    		{
    			if(e.getMessage().indexOf("::EXNO::")!=-1)
    			{
    				//정원초과
    		        mav.addObject("checkBack","Y");
			        mav.addObject("msg","결제할 강좌 중 정원이 마감된 강좌가 있습니다.\\\\n\\\\n마감된 강좌를 삭제하고 결제를 진행해 주세요.");
    				break;
    			}
    			else
    				throw e;
    		}
        	
        	try{
	        	/* AK신한 5%할인 일정 체크 추가 (10.11.24) */
	            boolean strFlag3 = true;      
	            int CheckSinCnt = ac_dao.selectLectSin(actionobj);
	            
	            if(CheckSinCnt == 0){
	                strFlag3  = false;
	            }   
	            
	            /*  신설에누리 강좌  존재하고 신설 에누리강좌 미존재 하면  (복합책가방 담기) 분리 메시지 띄움(2011.04.13) */
	            if (!strFlag6 && !strFlag7) {
	            	
	            	mav.addObject("checkBack","Y");
			        mav.addObject("msg","할인강좌는 중복할인 불가하며 [책가방 담기]시 해당강좌만 분리하여 결제하시기 바랍니다");
			        
			        throw new Exception("");
	            }else { 
	                if ((strFlag4)&& (strFlag5) && !(strFlag) && !(strFlag2)) {
	                	mav.addObject("checkBack","Y");
	    		        mav.addObject("msg","수강할인권 사용  대상회원입니다. 정규강좌(강좌횟수 10회 이상)에 한해 적용되오니 [책가방 담기]시 정규강좌/단기강좌로 나누어 결제하시기 바랍니다.");
	    		        throw new Exception("");           
	                }else if ((strFlag8) && !(strFlag)) {
	                	mav.addObject("gift_enuri_fg", 0);
	                }
	                
	                
	            }            
	            
	            actionobj.setFlag1(strFlag);
	            actionobj.setFlag2(strFlag2);
	            actionobj.setFlag3(strFlag3);  /* AK신한 5%할인 일정 체크 추가 (10.11.24) */
	            actionobj.setFlag4(strFlag4);  /* 진행기수 -1 (이전기수) 무료수강권 대상고객 여부 체크(2011.01.03) */
	            actionobj.setFlag5(strFlag5);  /* 수강 할인권  대상 고객으로 사용 여부 체크(2011.01.03) */
	            actionobj.setFlag6(strFlag6);  /* 신설강좌 존재여부 체크 - 존재시 true (2011.04.13) */
	            actionobj.setFlag7(strFlag7);  /* 신설강좌 존재여부 체크 - 미존재시 ture (2011.04.13) */
	            
	            actionobj.setFlag7(strFlag8); //기간 할인
	            actionobj.setFlag9(strFlag9); //기간 할인 여부
	            actionobj.setFlag11(strFlag11); //6인이하 여부
	            
	            String sReturn = "";
	            /* 결제 예상금액 호출 */
	            sReturn = ac_dao.setLectCalcPredict(actionobj);
	           
	            
	            String check = sReturn.substring(0, 1);
	            
	            if(check.equals("E")){ //결제중 오류
	            	mav.addObject("checkBack", "Y");
	            	mav.addObject("msg", sReturn.substring(1, sReturn.length()));
    		        throw new Exception("");   
	            }        	
	            
	    	} catch(Exception e){
	
			}
        	
        }
		mav.addObject("result", actionobj);
		
		return mav;
	}
	@RequestMapping("/order_end")
	public ModelAndView order_end(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/order_end");
		

		HttpSession session = request.getSession();
        /* session mgr start */
        String sUsrId = Utils.checkNullString(session.getAttribute("login_id")); //session UserId
        
        LectureVo actionobj = new LectureVo();
        //마일리지 전액 사용 시 (결제 금액과 같은 경우 사용 변수) 20190515 김동현 
        String sUsrCi = Utils.checkNullString(session.getAttribute("login_ci"));
        String rUsrCi = Utils.removeNULL(request.getParameter("ci"),"");
        String rSatFg = Utils.removeNULL(request.getParameter("sat_fg"),"");
        
        actionobj.setHq(Utils.removeNULL(request.getParameter("hq"),"00")); //그룹구분(00은 애경유통그룹)
        actionobj.setStore(Utils.removeNULL(request.getParameter("store"),"")); //점구분
        actionobj.setPeriod(Utils.removeNULL(request.getParameter("period"),ac_dao.retrievePeriod(Utils.removeNULL(request.getParameter("store"),"")))); //강좌차수
        actionobj.setAttendCustNo(Utils.removeNULL(session.getAttribute("login_cust"),"")); //수강자 코드
        actionobj.setAttendCustNm(Utils.removeNULL(session.getAttribute("login_name"),"")); //수강자 명
        actionobj.setSessionId(Utils.checkNullString(session.getAttribute("login_id"))); //세션 id
        actionobj.setIpAddress(Utils.checkNullString(session.getAttribute("login_ip"))); //ip주소
        actionobj.setAKmemCardNo(Utils.checkNullString(session.getAttribute("login_card")));

        actionobj.setDRegiAmt(Double.parseDouble(Utils.removeNULL(request.getParameter("dRegiAmt"),"00")));
        actionobj.setDFoodAmt(Double.parseDouble(Utils.removeNULL(request.getParameter("dFoodAmt"),"00")));
        actionobj.setDTotAmt(Double.parseDouble(Utils.removeNULL(request.getParameter("dTotAmt"),"00")));
        actionobj.setDTotalAmt(Double.parseDouble(Utils.removeNULL(request.getParameter("dTotalAmt"),"00")));  //40기 20%에누리를 위해 적용한
        actionobj.setEnuri_per(Double.parseDouble(Utils.removeNULL(request.getParameter("dEnuriper"),"00"))); // 신설강좌 에누리율 추가(11.02.02)
        actionobj.setNew_enuri_amt(Double.parseDouble(Utils.removeNULL(request.getParameter("dNewEnuriAmt"),"00"))); // 신설강좌 에누리금액 추가(11.02.02)
        actionobj.setDayEnuri(Double.parseDouble(Utils.removeNULL(request.getParameter("dayEnuri"),"0"))); // 신설강좌 에누리금액 추가(11.02.02)
        actionobj.setUPointAmt(Double.parseDouble(Utils.removeNULL(request.getParameter("upointAmt"),"00"))); // 사용 마일리지금액 추가(19.04.25)
        actionobj.setFree_fee2(Double.parseDouble(Utils.removeNULL(request.getParameter("free_fee2"),"00"))); // 사용 마일리지금액 추가(19.04.25)
        actionobj.setSat_fg(Utils.removeNULL(request.getParameter("sat_fg"),"")); // 전액 사용 마일리지 변수 추가(19.05.15)
        
        //System.out.println("LectureAction.java -- regist() >>>> 최종 결제금액 율  SET ==============================>" +request.getParameter("dTotAmt") + Double.parseDouble(Utils.removeNULL(request.getParameter("dTotAmt"),"00")));
        //System.out.println("LectureAction.java -- regist() >>>> 신설강좌 마일리지 율  SET ==============================>" +request.getParameter("upointAmt") + Double.parseDouble(Utils.removeNULL(request.getParameter("upointAmt"),"00")));
        
        // ★☆ 추가 2014.07
        
        actionobj.setAkcard_yn(Utils.removeNULL(request.getParameter("akcard_yn"),"N"));
        actionobj.setAkKBcard_yn(Utils.removeNULL(request.getParameter("akKBcard_yn"),"N")); //국민제휴추가 (2017.09)
        actionobj.setGood_mny(Double.parseDouble(Utils.removeNULL(request.getParameter("good_mny"),"00"))); // kcp요청 승인 금액(2014.07)
        actionobj.setEnc_data(Utils.removeNULL(request.getParameter("enc_data"),""));
        actionobj.setEnc_info(Utils.removeNULL(request.getParameter("enc_info"),""));
        actionobj.setTran_cd(Utils.removeNULL(request.getParameter("tran_cd"),""));
        actionobj.setSite_cd(Utils.removeNULL(request.getParameter("site_cd"),""));
        actionobj.setSite_key(Utils.removeNULL(request.getParameter("site_key"),""));
        actionobj.setOrdr_idxx(Utils.removeNULL(request.getParameter("ordr_idxx"),""));
        actionobj.setTot_subject_cd(Utils.removeNULL(request.getParameter("tot_subject_cd"),""));
        actionobj.setTot_enuri1_cd(Utils.removeNULL(request.getParameter("tot_enuri1_cd"),""));
        actionobj.setTot_enuri2_cd(Utils.removeNULL(request.getParameter("tot_enuri2_cd"),""));
        actionobj.setTot_enuri1_amt(Utils.removeNULL(request.getParameter("tot_enuri1_amt"),""));
        actionobj.setTot_enuri2_amt(Utils.removeNULL(request.getParameter("tot_enuri2_amt"),""));
        actionobj.setAkmem_card_status(Utils.removeNULL(request.getParameter("akmem_card_status"),"")); //카드상태        
        
        actionobj.setAttendCustNm(Utils.removeNULL(session.getAttribute("login_name"),"")); //결제 금액 전액 마일리지 사용 변수
        
        //System.out.println("LectureAction.java -- regist() >>>> 신설강좌 에누리 율  SET ==============================>" +request.getParameter("dEnuriper") + Double.parseDouble(Utils.removeNULL(request.getParameter("dEnuriper"),"00")));
        
        //20190515 김동현 전액 마일리지 사용 시 본인인증 절차 비교 후 처리
        
        System.out.println("마일리지 전액 사용 여부            : "+rSatFg);
        System.out.println("마일리지 전액 사용 로그인 Ci  : "+sUsrCi);
        System.out.println("마일리지 전액 사용 본인인증 Ci: "+rUsrCi);
        
//        if(rSatFg.equals("P")){ 
//        	//가족 회원 조회
//        	if(!rUsrCi.equals("")){
//        		String searchCi = ac_dao.searchUserCi(actionobj);
//                if(!searchCi.equals("")){ //조회된 가족 회원 ci 값과 일치 하지 않음(부모꺼) 
//                	if(!rUsrCi.equals(searchCi)){
//                		mav.addObject("checkBack","Y");
//                        mav.addObject("msg", "본인 인증 절차가 정상적으로 진행 되지 않았습니다.!!!");
//                        mav.addObject("result", actionobj);
//                        
//                        return mav;
//                	}
//                } else { //조회 된 ci 값 없음
//                	mav.addObject("checkBack","Y");
//                    mav.addObject("msg", "본인 인증 절차가 정상적으로 진행 되지 않았습니다.!!");
//                    mav.addObject("result", actionobj);
//                    
//                    return mav;
//                }
//        	}
//        	
//        	//본인인증 절자 
//        	if(!sUsrCi.equals(rUsrCi)){
//        		List<HashMap<String, Object>> list = ac_dao.selectPayIngView(actionobj);
//        		actionobj.setList(list);
//                mav.addObject("checkBack","Y");
//                mav.addObject("msg", "본인 인증 절차가 정상적으로 진행 되지 않았습니다.");
//                mav.addObject("result", actionobj);
//                
//                return mav;
//        	}
//        }
        
        List paylist = ac_dao.selectPayIngView(actionobj);
        boolean strFlag = true;
        boolean strFlag2 = true;
        
        /*신설강좌 존재여부 체크 (2011.04.13) */ 
        boolean strFlag6 = true;
        boolean strFlag7 = true;
        
        for(int i=0; i<paylist.size();i++) {
            LectureVo vo = (LectureVo)paylist.get(i);
            
            //★  12.01.11 기존로직대로 전점 10회이상 통일(윤정희대리 확인함)
            if (vo.getLect_cnt() < 10) {   // 정규강좌 여부 체크 정규강좌 있으면 TURE
                strFlag = false;                
            }
            if (vo.getLect_cnt() >= 10) {  // 단기강좌 여부 체크 단기강좌 있으면 TURE
                strFlag2 = false;
            }
            
            if ((int)vo.getEnuri_per() <= 0 ) { // 신설에누리 강좌  존재하면  TURE   신설강좌 존재여부 체크 (2011.04.13)
                strFlag6  = false;
            }
            
            if ((int)vo.getEnuri_per() > 0 ) { // 신설에누리 강좌  미존재 하면 TURE   신설강좌 존재여부 체크 (2011.04.13)
                strFlag7  = false;
            }
            
        }
        
        //System.out.println("strFlag  정규강좌 체크 존재시 Trure >>>>>>>>>>>>>>>> :"+strFlag + "   strFlag2 단기강좌 체크  존재시 Trure>>>>>>>>>>>>> :"+strFlag2);
        //System.out.println("strFlag6  신설에누리 강좌 체크 존재시 Trure >>>>>>>>>>>>>>>> :"+strFlag6 + "   strFlag7 신설 미존재강좌  체크  존재시 Trure >>>>>>>>>>>>> :"+strFlag7);
        
        String sReturn = null;
        String cardfg = ""; //service.selectLect822(Utils.removeNULL(request.getParameter("sCardNo"),"")); //카드사 코드 조회(신한제휴,애경삼성,일반카드사)
        
        /* AK신한 5%할인 일정 체크 추가 (10.11.24) */
        boolean strFlag3 = true;        
        //if(!rSatFg.equals("P")){ //전액 마일이지 사용이 아니라면 체크 20190515 김동현 
        	int CheckSinCnt = ac_dao.selectLectSin(actionobj);

            if(CheckSinCnt == 0){
                strFlag3  = false;
            }
        //}  
        
        /* 연속수강자  무료수강권 대상고객 여부 체크 [진행기수 -1 (이전기수)](2011.01.03) */
        boolean strFlag4 = true;        
        int CheckGiftCnt = ac_dao.selectLectGift(actionobj);

        if(CheckGiftCnt == 0){  // 존재 해야 사용가능 
            strFlag4  = false;
        }
        
        /* 연속수강자 무료수강권 사용여부 체크 (2011.01.11) */
        boolean strFlag5 = true;        
        int CheckFreeUseCnt = ac_dao.selectFreeUse(actionobj);

        if(CheckFreeUseCnt > 0){  // 존재하면 추가 사용 불가 
            strFlag5  = false;
        }
        
        boolean strFlag8 = true;
        List<HashMap<String, Object>> list8 = ac_dao.selectGiftEnuri(actionobj);
        
        if(list8.size() <= 0){  // 기간 회원할인 존재 Ture 
        	strFlag8  = false;
        }
        
        //책가방내역과 결제내역 compare
        boolean strFlag10 = true;
        //할인, 2인수강 등 가격에 변수가 많아 이부분 제외
//        String list10_rlt = ac_dao.selectTempCompare(actionobj.getSessionId(),actionobj.getAttendCustNo(),actionobj.getStore(),actionobj.getPeriod(),actionobj.getDTotAmt(),actionobj.getTot_subject_cd());
        
//        if(list10_rlt.equals("fail")){  // 책가방,결제금액 상이 False 
//        	strFlag10  = false;
//        }
        

        /* actionobj 에 결과 obj를 담는다 */
        actionobj.setNumber(Utils.removeNULL(request.getParameter("number"),"")); //임의 점 구분코드
        
        /* 사용자가 선택한 AK제휴 여부가 Y일 경우 822로 셋팅 */
        if(actionobj.getAkcard_yn().equals("Y")){
        	actionobj.setCardfg("822"); //카드사코드
        }else if(actionobj.getAkKBcard_yn().equals("Y")){
        	actionobj.setCardfg("042"); //카드사코드
        }
        
        System.out.println (" act_regist-strFlag  >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag);
        System.out.println (" act_regist-strFlag2 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag2);
        System.out.println (" act_regist-strFlag3 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag3);
        System.out.println (" act_regist-strFlag4 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag4);
        System.out.println (" act_regist-strFlag5 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag5);
        System.out.println (" act_regist-strFlag6 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag6);
        System.out.println (" act_regist-strFlag7 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag7);
        System.out.println (" act_regist-strFlag8 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag8);
        System.out.println (" act_regist-strFlag10 >>>>>>>>>>>>>>>>>>>>>>>> " + strFlag10);
        
        /*  신설에누리 강좌  존재하고 신설 에누리강좌 미존재 하면  (복합책가방 담기) 분리 메시지 띄움(2011.04.13) */
        if (!strFlag6 && !strFlag7) {
             sReturn = "할인강좌는 중복할인 불가하며 [책가방 담기]시 해당강좌만 분리하여 결제하시기 바랍니다";
             
             actionobj.setList(paylist);
             mav.addObject("msg", sReturn);
             mav.addObject("result", actionobj);
             
             return mav;
        }else { 
            if (strFlag3) {  /* AK신한 5%할인 일정 체크 추가 (10.11.24) */
            
                if(cardfg.equals("822") && !(strFlag) && !(strFlag2)) {
                	sReturn = "AK신한카드 5%할인은  정규강좌(강좌횟수 10회 이상)에 한해 적용되오니 [책가방 담기]시 정규강좌/단기강좌로 나누어 결제하시기 바랍니다!";
                    actionobj.setList(paylist);
                    mav.addObject("msg", sReturn);
                    mav.addObject("result", actionobj);
                     
                     return mav;
                    
                }else if ((strFlag4)&& (strFlag5) && !(strFlag) && !(strFlag2)) {
                	sReturn = "수강할인권 사용  대상회원입니다. 정규강좌(강좌횟수 10회 이상)에 한해 적용되오니 [책가방 담기]시 정규강좌/단기강좌로 나누어 결제하시기 바랍니다!";
                    actionobj.setList(paylist);
                    mav.addObject("msg", sReturn);
                    mav.addObject("result", actionobj);
                     
                     return mav;
                    
                }
            // 연속수강자 무료수강 할인 대상자 체크 추가 (11.01.11)
            }else if ((strFlag4)&& (strFlag5) && !(strFlag) && !(strFlag2)) {
            	sReturn = "수강할인권 사용  대상회원입니다. 정규강좌(강좌횟수 10회 이상)에 한해 적용되오니 [책가방 담기]시 정규강좌/단기강좌로 나누어 결제하시기 바랍니다.";
                actionobj.setList(paylist);
                mav.addObject("msg", sReturn);
                mav.addObject("result", actionobj);
                 
                 return mav;
           }else if(strFlag10== false){
        	   actionobj.setList(paylist);
        	   sReturn = "책가방내역과 결제내역이 상이합니다. 나의책가방 내역을 확인 후  결제하시기 바랍니다.";
               mav.addObject("msg", sReturn);
               mav.addObject("result", actionobj);
               
        	   return mav;
           }else if ((strFlag8) && !(strFlag)) { 
        	 //이거는 제외일수도 있음
        	   actionobj.setGift_enuri_fg(0);
           }
        }
        
        actionobj.setFlag1(strFlag);
        actionobj.setFlag2(strFlag2);
        actionobj.setFlag3(strFlag3);  /* AK신한 5%할인 일정 체크 추가 (10.11.24) */
        actionobj.setFlag4(strFlag4);  /* 진행기수 -1 (이전기수) 무료수강권 대상고객 여부 체크(2011.01.03) */
        actionobj.setFlag5(strFlag5);  /* 수강 할인권  대상 고객으로 사용 여부 체크(2011.01.03) */
        actionobj.setFlag6(strFlag6);  /* 신설강좌 존재여부 체크 - 존재시 true (2011.04.13) */
        actionobj.setFlag7(strFlag7);  /* 신설강좌 존재여부 체크 - 미존재시 ture (2011.04.13) */
        actionobj.setFlag7(strFlag8); //기간 할인
        actionobj.setUser_id(sUsrId);  /* 로그인 아이디 ( 메일발송시 자녀경우 부모 메일주소 조회시 필요 2013.02.22)*/
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>  결제 호출 시작  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        /* 결제 호출 */
        sReturn = setLectCalc(actionobj); 
        
        System.out.println(" <<<<<<<<<<< LectureAction.java - regist() - 결제완료여부  >>>>>>>>>>>>>>> sReturn : "+sReturn);
            
        //if(sReturn == null || sReturn.equals("")){
        if(sReturn.equals("N")){
            sReturn = "[결제 실패] 매출 등록 중 오류가 발생 하였습니다.";
           //sReturn = "결제중 오류가 발생하였습니다!";
       }else if(sReturn.equals("T")){
       	sReturn = "[결제 실패] 결제하실 내역과 책가방 정보가 맞지 않습니다.\\n\\n결제를 다시 시도하시기 바랍니다.";
           mav.addObject("msg", sReturn);
           return mav;
       }       	
        String check = sReturn.substring(0, 1);
        
        if(check.equals("X")){ //CmLectCheckout.jsp //결제완료page
            mav.addObject("result", actionobj);
            mav.addObject("msg", sReturn);
            return mav;
            
        }else if(check.equals("Y")){ //CmLectCheckout.jsp //결제완료page
        	
            mav.addObject("result", actionobj);
            return mav;
            
        }else if(check.equals("E")){ //결제중 오류
        	
        	List list = ac_dao.selectPayIngView(actionobj);
            actionobj.setList(list);
            mav.addObject("checkBack","Y");
            mav.addObject("msg", sReturn.substring(1, sReturn.length()));
            mav.addObject("result", actionobj);
            return mav;
            
        }else{ //CmLectRegist.jsp //결제page로 다시이동
        	
            List list = ac_dao.selectPayIngView(actionobj);
            actionobj.setList(list);
            mav.addObject("msg", sReturn);
            mav.addObject("result", actionobj);
            return mav;
        }
    
		
	}
	@RequestMapping("/half_order_end")
	public ModelAndView half_order_end(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/half_order_end");
		
		String onList[] = Utils.checkNullString(request.getParameter("onList")).split("\\|");
		String offList[] = Utils.checkNullString(request.getParameter("offList")).split("\\|");
		
		
		System.out.println("request.getParameter(\"onList\") : "+request.getParameter("onList"));
		System.out.println("request.getParameter(\"offList\") : "+request.getParameter("offList"));
     
		HttpSession session = request.getSession();
		LectureVo actionobj = new LectureVo();
		actionobj.setHq(Utils.removeNULL(request.getParameter("hq"),"00")); //그룹구분(00은 애경유통그룹)
		actionobj.setStore(Utils.removeNULL(request.getParameter("store"),"")); //점구분
		actionobj.setPeriod(Utils.removeNULL(request.getParameter("period"),ac_dao.retrievePeriod(Utils.removeNULL(request.getParameter("store"),"")))); //강좌차수
		actionobj.setAttendCustNo(Utils.removeNULL(session.getAttribute("login_cust"),"")); //수강자 코드
        actionobj.setAttendCustNm(Utils.removeNULL(session.getAttribute("login_name"),"")); //수강자 명
        actionobj.setSessionId(Utils.checkNullString(session.getAttribute("login_id"))); //세션 id
        actionobj.setIpAddress(Utils.checkNullString(session.getAttribute("login_ip"))); //ip주소
        actionobj.setAKmemCardNo(Utils.checkNullString(session.getAttribute("login_card")));
        
        actionobj.setDRegiAmt(Double.parseDouble(Utils.removeNULL(request.getParameter("dRegiAmt"),"00")));
        actionobj.setDFoodAmt(Double.parseDouble(Utils.removeNULL(request.getParameter("dFoodAmt"),"00")));
        actionobj.setDTotAmt(Double.parseDouble(Utils.removeNULL(request.getParameter("dTotAmt"),"00")));
        actionobj.setDTotalAmt(actionobj.getDTotAmt());  //40기 20%에누리를 위해 적용한
        actionobj.setEnuri_per(Double.parseDouble(Utils.removeNULL(request.getParameter("dEnuriper"),"00"))); // 신설강좌 에누리율 추가(11.02.02)
        actionobj.setNew_enuri_amt(Double.parseDouble(Utils.removeNULL(request.getParameter("dNewEnuriAmt"),"00"))); // 신설강좌 에누리금액 추가(11.02.02)
        actionobj.setDayEnuri(Double.parseDouble(Utils.removeNULL(request.getParameter("dayEnuri"),"0"))); // 신설강좌 에누리금액 추가(11.02.02)
        actionobj.setUPointAmt(Double.parseDouble(Utils.removeNULL(request.getParameter("upointAmt"),"00"))); // 사용 마일리지금액 추가(19.04.25)
        actionobj.setFree_fee2(Double.parseDouble(Utils.removeNULL(request.getParameter("free_fee2"),"00"))); // 사용 마일리지금액 추가(19.04.25)
        actionobj.setSat_fg(Utils.removeNULL(request.getParameter("sat_fg"),"")); // 전액 사용 마일리지 변수 추가(19.05.15)
        
        actionobj.setAkcard_yn(Utils.removeNULL(request.getParameter("akcard_yn"),"N"));
        actionobj.setAkKBcard_yn(Utils.removeNULL(request.getParameter("akKBcard_yn"),"N")); //국민제휴추가 (2017.09)
        actionobj.setGood_mny(Double.parseDouble(Utils.removeNULL(request.getParameter("good_mny"),"00"))); // kcp요청 승인 금액(2014.07)
        actionobj.setEnc_data(Utils.removeNULL(request.getParameter("enc_data"),""));
        actionobj.setEnc_info(Utils.removeNULL(request.getParameter("enc_info"),""));
        actionobj.setTran_cd(Utils.removeNULL(request.getParameter("tran_cd"),""));
        actionobj.setSite_cd(Utils.removeNULL(request.getParameter("site_cd"),""));
        actionobj.setSite_key(Utils.removeNULL(request.getParameter("site_key"),""));
        actionobj.setOrdr_idxx(Utils.removeNULL(request.getParameter("ordr_idxx"),""));
        actionobj.setTot_subject_cd(Utils.removeNULL(request.getParameter("tot_subject_cd"),""));
        
        actionobj.setAkmem_card_status(Utils.removeNULL(request.getParameter("akmem_card_status"),"")); //카드상태        
        
        actionobj.setAttendCustNm(Utils.removeNULL(session.getAttribute("login_name"),"")); //결제 금액 전액 마일리지 사용 변수
		
       
        String sReturn = "";
        String is_payment = Utils.checkNullString(request.getParameter("is_payment"));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>  결제 호출 시작  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        /* 결제 호출 */
        String check = "";
        if("Y".equals(is_payment))
        {
        	sReturn = setLectCalc_half(actionobj); 
        	
        	System.out.println(" <<<<<<<<<<< LectureAction.java - regist() - 결제완료여부  >>>>>>>>>>>>>>> sReturn : "+sReturn);
        	
        	//if(sReturn == null || sReturn.equals("")){
        	if(sReturn.equals("N")){
        		sReturn = "[결제 실패] 매출 등록 중 오류가 발생 하였습니다.";
        		//sReturn = "결제중 오류가 발생하였습니다!";
        	}else if(sReturn.equals("T")){
        		sReturn = "[결제 실패] 결제하실 내역과 책가방 정보가 맞지 않습니다.\\n\\n결제를 다시 시도하시기 바랍니다.";
        		mav.addObject("msg", sReturn);
        		return mav;
        	}       	
        	check = sReturn.substring(0, 1);
        	System.out.println("check : "+check);
        	System.out.println("sReturn : "+sReturn);
        }
        else
        {
        	check = "Y";
        }
        
        if(check.equals("X")){ //CmLectCheckout.jsp //결제완료page
//            mav.addObject("result", actionobj);
            mav.addObject("msg", sReturn);
            return mav;
            
        }else if(check.equals("Y")){ //CmLectCheckout.jsp //결제완료page
        	
        	String tid = Utils.checkNullString(request.getParameter("tid"));
    		String store = Utils.checkNullString(request.getParameter("store"));
    		
    		lectureCancel_half(store, tid, request); //결제취소
//            mav.addObject("result", actionobj);
            return mav;
            
        }else if(check.equals("E")){ //결제중 오류
        	
//        	List list = ac_dao.selectPayIngView(actionobj);
//            actionobj.setList(list);
            mav.addObject("checkBack","Y");
            mav.addObject("msg", sReturn.substring(1, sReturn.length()));
//            mav.addObject("result", actionobj);
            return mav;
            
        }else{ //CmLectRegist.jsp //결제page로 다시이동
        	
//            List list = ac_dao.selectPayIngView(actionobj);
//            actionobj.setList(list);
//            mav.addObject("msg", sReturn);
//            mav.addObject("result", actionobj);
            return mav;
        }
    
		
	}
	
	@RequestMapping("/plan01")
	public ModelAndView plan01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/plan01");
		Utils.setSearchVal(mav, main_dao);
		mav.addObject("year", Utils.getDateNow("year"));
		return mav;
	}
	@RequestMapping("/getPlanList")
	@ResponseBody
	public HashMap<String, Object> getPlanList(HttpServletRequest request) {
			
		String search_store = Utils.checkNullString(request.getParameter("search_store"));
		String start_season = Utils.checkNullString(request.getParameter("start_season"));
		String end_season = Utils.checkNullString(request.getParameter("end_season"));
		
		String start_peri = Utils.checkNullString(ac_dao.selPeriBySeason(search_store, start_season));
		String end_peri = Utils.checkNullString(ac_dao.selPeriBySeason(search_store, start_season));
		HttpSession session = request.getSession();
		String login_cus = Utils.checkNullString(session.getAttribute("login_cus"));
		
		
		List<HashMap<String, Object>> listCnt = ac_dao.getPlanListCount(search_store,start_peri,end_peri,login_cus);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int page = 1;
		if(!"".equals(Utils.checkNullString(request.getParameter("page"))))
		{
			page = Integer.parseInt(Utils.checkNullString(request.getParameter("page")));
		}
		int listSize = 20;
		if(!"".equals(Utils.checkNullString(request.getParameter("listSize"))))
		{
			listSize = Integer.parseInt(Utils.checkNullString(request.getParameter("listSize")));
		}
		
		
		int block = 3;
		int pageNum = (int)Math.ceil((double)listCount/listSize);
		int nowBlock = (int)Math.ceil((double)page/block);
		int s_page = (nowBlock * block) - (block-1);
		if (s_page <= 1) 
		{
			s_page = 1;
		}
		int e_page = nowBlock*block;
		if (pageNum <= e_page) {
			e_page = pageNum;
		}
		
		int s_point = (page-1) * listSize;
		
		List<HashMap<String, Object>> list = ac_dao.getPlanList(s_point, listSize*page, search_store,start_peri,end_peri,login_cus); 
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		map.put("list", list);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		
		return map;
	}
	
	@RequestMapping("/plan02")
	public ModelAndView plan02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/plan02");
		
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(request.getParameter("period"));
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		
		List<HashMap<String, Object>> list = ac_dao.getPlanDetail(store, period, subject_cd);
		HashMap<String, Object> data = ac_dao.getPeltOne(store, period, subject_cd);
		
		
		if(list.size() > 0)
		{
			list.get(0).put("ETC", Utils.checkNullString(list.get(0).get("ETC")).replaceAll("\n", "\\|"));
		}
		
		mav.addObject("list_size", list.size());
		mav.addObject("data", data);
		mav.addObject("list", list);
		mav.addObject("store", store);
		mav.addObject("period", period);
		mav.addObject("subject_cd", subject_cd);
		return mav;
	}
	@RequestMapping("/plan02_proc")
	public ModelAndView plan02_proc(HttpServletRequest request) throws IOException {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("/WEB-INF/pages/web/academy/plan02_proc");
		
		int sizeLimit = 10*1024*1024; //10메가 까지 가능
        String uploadPath = upload_dir+"wlect/";
        
        File dir = new File(uploadPath);
		if (!dir.exists()) { // 디렉토리가 존재하지 않으면
			dir.mkdirs(); // 디렉토리 생성
		}
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		String store = Utils.checkNullString(multi.getParameter("store"));
		String period = Utils.checkNullString(multi.getParameter("period"));
		String subject_cd = Utils.checkNullString(multi.getParameter("subject_cd"));
		String subject_nm = Utils.checkNullString(multi.getParameter("subject_nm"));
		
		
		String lecturer_career = Utils.checkNullString(multi.getParameter("lecturer_career"));
		String lecture_content = Utils.checkNullString(multi.getParameter("lecture_content"));
		
		String lect_cnt = Utils.checkNullString(multi.getParameter("lect_cnt_list"));
		String lect_contents = Utils.checkNullString(multi.getParameter("lect_contents_list"));
		
		String etc = "";
		String lect_cnt_arr[] = lect_cnt.split("\\|");
		String lect_contents_arr[] = lect_contents.split("\\|");
		for(int i = 0; i < lect_cnt_arr.length; i++)
		{
			etc += lect_cnt_arr[i]+"회차 : "+lect_contents_arr[i]+"\n";
		}
		
		
		HttpSession session = request.getSession();
		String login_seq = Utils.checkNullString(session.getAttribute("login_seq"));
		String lecturer_nm = Utils.checkNullString(session.getAttribute("login_name"));
		String filename = Utils.convertFileName(Utils.checkNullString(multi.getOriginalFileName("attach")), uploadPath, 1);
		List<HashMap<String, Object>> list = ac_dao.getPlanDetail(store, period, subject_cd);
		if(list.size() > 0)
		{
			if("".equals(filename) && list.get(0).get("IMAGE_PIC") != null)
			{
				filename = Utils.checkNullString(list.get(0).get("IMAGE_PIC"));
			}
			ac_dao.upPlan(store, period, subject_cd, subject_nm, lecturer_nm, lecturer_career, lecture_content, etc, login_seq, filename);
		}
		else
		{
			ac_dao.insPlan(store, period, subject_cd, subject_nm, lecturer_nm, lecturer_career, lecture_content, etc, login_seq, filename);
		}
		
		
		
		mav.addObject("isSuc", "success");
		mav.addObject("msg", "저장되었습니다.");
		return mav;
	}
	@RequestMapping("/recommend")
	public ModelAndView recommend(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/recommend");
		
		List<HashMap<String, Object>> list = ac_dao.getRecoList(0, 9999, "");
		
		//태그들 불러오기위함
		String tagList = ","; //구분하기위해 ,로 시작
		for(int i = 0; i < list.size(); i++)
		{
			String tag = "";
			if(list.get(i) != null && list.get(i).get("TAG") != null)
			{
				tag =  Utils.checkNullString(list.get(i).get("TAG"));
				String tagArr[] = tag.split("\\|");
				for(int z = 0; z < tagArr.length; z++)
				{
					if(tagList.indexOf(","+tagArr[z]) == -1)
					{
						tagList += tagArr[z]+",";
					}
				}
			}
		}
		if(!",".equals(tagList))
		{
			tagList = tagList.substring(1, tagList.length()-1);
		}
		else
		{
			tagList = "";
		}
		
		mav.addObject("tagList", tagList);
		mav.addObject("image_dir", image_dir);
		
		return mav;
	}
	
	@RequestMapping("/result01")
	public ModelAndView result01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/result01");
		HttpSession session = request.getSession();
		
		if("".equals(Utils.checkNullString(session.getAttribute("login_id")))){
			System.out.println(">>>>>>>>>>>>>>로그인이 필요 합니다<<<<<<<<<<<<<<");
			mav.addObject("resultCd", "-1");
			mav.addObject("resultMsg", "로그인이 필요 합니다.");
			mav.addObject("resultURL", "/user/login");
			return mav;
		}
		
		return mav;
	}
	
	@RequestMapping("/store01")
	public ModelAndView store01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/store01");
		
		return mav;
	}
	
	@RequestMapping("/store02")
	public ModelAndView store02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/store02");
		
		return mav;
	}
	
	@RequestMapping("/store03")
	public ModelAndView store03(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/store03");
		
		return mav;
	}
	
	@RequestMapping("/store04")
	public ModelAndView store04(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/store04");
		
		return mav;
	}

	
	@RequestMapping("/getBookList")
	@ResponseBody
	public HashMap<String, Object> getBookList(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String order_by = Utils.checkNullString(request.getParameter("order_by"));
		String sort_type = Utils.checkNullString(request.getParameter("sort_type"));
		
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String cust_nm = Utils.checkNullString(session.getAttribute("login_name"));
		String cust_id = Utils.checkNullString(session.getAttribute("login_id"));
		String cust_store = Utils.checkNullString(session.getAttribute("login_store"));
		
		//강좌 리스트 먼저라 잠시 대기 20200730.17:32
		
		
		String birthymd = Utils.checkNullString(session.getAttribute("birthymd"));
		String sSAgeGubun = Utils.checkNullString(session.getAttribute("sSAgeGubun"));
		
		String period = Utils.checkNullString(common_dao.retrievePeriod(cust_store).get("PERIOD")); //현재 화성화된 기수 
		
		
		List<HashMap<String, Object>> listCnt = ac_dao.getBookCount(cust_no,cust_store,period,cust_id);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int page = 1;
		if(!"".equals(Utils.checkNullString(request.getParameter("page"))))
		{
			page = Integer.parseInt(Utils.checkNullString(request.getParameter("page")));
		}
		int listSize = 20;
		if(!"".equals(Utils.checkNullString(request.getParameter("listSize"))))
		{
			listSize = Integer.parseInt(Utils.checkNullString(request.getParameter("listSize")));
		}
		
		
		int block = 3;
		int pageNum = (int)Math.ceil((double)listCount/listSize);
		int nowBlock = (int)Math.ceil((double)page/block);
		int s_page = (nowBlock * block) - (block-1);
		if (s_page <= 1) 
		{
			s_page = 1;
		}
		int e_page = nowBlock*block;
		if (pageNum <= e_page) {
			e_page = pageNum;
		}
		
		int s_point = (page-1) * listSize;
		
		List<HashMap<String, Object>> list = ac_dao.getBookList(s_point, listSize*page, order_by, sort_type,cust_no,cust_store,period,cust_id); 
		List<HashMap<String, Object>> enterPeriod = new ArrayList<HashMap<String, Object>>();
		
		HashMap<String, Object> temp_1 = new HashMap<>();
		HashMap<String, Object> temp_2 = new HashMap<>();
		
		for (int i = 0; i < list.size(); i++) {
			temp_1 = Utils.enterPeriod(common_dao,Utils.checkNullString(list.get(i).get("STORE")));
			temp_2.put("okWebReceiptEnd", temp_1.get("okWebReceiptEnd"));
			temp_2.put("okWebReceipt", temp_1.get("okWebReceipt"));
			temp_2.put("sCurrentDate", temp_1.get("sCurrentDate"));
			enterPeriod.add(temp_2);
		}
		
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		map.put("list", list);
		map.put("enterPeriod", enterPeriod);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		map.put("order_by", order_by);
		map.put("sort_type", sort_type);
		
		return map;
	}
	
	
	@RequestMapping("/delBookList")
	public ModelAndView toMyBookSelf(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/course/isChk");

	
		
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(request.getParameter("period"));
		String subject_cd =  Utils.checkNullString(request.getParameter("subject_cd"));
		
		
		int cnt = ac_dao.del_bookshelf(store, period, subject_cd, cust_no,"1");
		if (cnt==0) {
			cnt = ac_dao.del_bookshelf(store, period, subject_cd, cust_no,"0");
		}
		
		ac_dao.upt_regi_no(cnt,store,period,subject_cd);
		
		
		
		mav.addObject("msg", "처리 완료되었습니다.");
		
		
		return mav;
	}
	
	
	
	
	@RequestMapping("/getchild")
	@ResponseBody
	public HashMap<String, Object> getchild(HttpServletRequest request) {
		
		String order_by = Utils.checkNullString(request.getParameter("order_by"));
		String sort_type = Utils.checkNullString(request.getParameter("sort_type"));
		

		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));

		
		
		List<HashMap<String, Object>> listCnt = ac_dao.getchildCount(cust_no);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int page = 1;
		if(!"".equals(Utils.checkNullString(request.getParameter("page"))))
		{
			page = Integer.parseInt(Utils.checkNullString(request.getParameter("page")));
		}
		int listSize = 20;
		if(!"".equals(Utils.checkNullString(request.getParameter("listSize"))))
		{
			listSize = Integer.parseInt(Utils.checkNullString(request.getParameter("listSize")));
		}
		
		
		int block = 5;
		int pageNum = (int)Math.ceil((double)listCount/listSize);
		int nowBlock = (int)Math.ceil((double)page/block);
		int s_page = (nowBlock * block) - (block-1);
		if (s_page <= 1) 
		{
			s_page = 1;
		}
		int e_page = nowBlock*block;
		if (pageNum <= e_page) {
			e_page = pageNum;
		}
		
		int s_point = (page-1) * listSize;
		
		List<HashMap<String, Object>> list = ac_dao.getchild(s_point, listSize*page, order_by, sort_type,cust_no); 
		List<HashMap<String, Object>> selflist = ac_dao.getmyinfo(cust_no); 
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		
		map.put("list", list);
		map.put("selflist", selflist);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		map.put("order_by", order_by);
		map.put("sort_type", sort_type);
		
		return map;
	}
	
	@RequestMapping("/addchild")
	public ModelAndView addchild(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("/WEB-INF/pages/web/common/isChk");
		
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String gender = Utils.checkNullString(request.getParameter("gender"));
		String child_nm = Utils.checkNullString(request.getParameter("child_nm"));
		String birth_ymd = Utils.checkNullString(request.getParameter("birth_ymd"));
		//int child_no = ac_dao.getlast_childNo(cust_no); 
		
	    int result = ac_dao.saveChild(child_nm,gender,birth_ymd,cust_no);
		if (result > 0) {
			mav.addObject("isSuc", "fail");		
			mav.addObject("msg", "저장되었습니다.");			
		}else {
			mav.addObject("isSuc", "success");	
			mav.addObject("msg", "관리자에게 문의해주세요.");
		}
			
		return mav;
	}
	
	@RequestMapping("/getEncdlist")
	@ResponseBody
	public HashMap<String, Object> getEncdlist(HttpServletRequest request) {
		
		String order_by = Utils.checkNullString(request.getParameter("order_by"));
		String sort_type = Utils.checkNullString(request.getParameter("sort_type"));
		
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String store = Utils.checkNullString(session.getAttribute("login_store"));
		
		
		List<HashMap<String, Object>> listCnt = ac_dao.getencdCount(cust_no,store);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int page = 1;
		if(!"".equals(Utils.checkNullString(request.getParameter("page"))))
		{
			page = Integer.parseInt(Utils.checkNullString(request.getParameter("page")));
		}
		int listSize = 20;
		if(!"".equals(Utils.checkNullString(request.getParameter("listSize"))))
		{
			listSize = Integer.parseInt(Utils.checkNullString(request.getParameter("listSize")));
		}
		
		int block = 5;
		int pageNum = (int)Math.ceil((double)listCount/listSize);
		int nowBlock = (int)Math.ceil((double)page/block);
		int s_page = (nowBlock * block) - (block-1);
		if (s_page <= 1) 
		{
			s_page = 1;
		}
		int e_page = nowBlock*block;
		if (pageNum <= e_page) {
			e_page = pageNum;
		}
		
		int s_point = (page-1) * listSize;
		
		List<HashMap<String, Object>> list = ac_dao.getencd(s_point, listSize*page, order_by, sort_type,cust_no,store); 

		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		
		map.put("list", list);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		map.put("order_by", order_by);
		map.put("sort_type", sort_type);
		
		return map;
	}
	
	@RequestMapping("/getwait")
	@ResponseBody
	public HashMap<String, Object> getwait(HttpServletRequest request) {
		
		String order_by = Utils.checkNullString(request.getParameter("order_by"));
		String sort_type = Utils.checkNullString(request.getParameter("sort_type"));
		

		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String store = Utils.checkNullString(session.getAttribute("login_store"));
		
		
		List<HashMap<String, Object>> listCnt = ac_dao.getwaitCount(cust_no,store);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int page = 1;
		if(!"".equals(Utils.checkNullString(request.getParameter("page"))))
		{
			page = Integer.parseInt(Utils.checkNullString(request.getParameter("page")));
		}
		int listSize = 20;
		if(!"".equals(Utils.checkNullString(request.getParameter("listSize"))))
		{
			listSize = Integer.parseInt(Utils.checkNullString(request.getParameter("listSize")));
		}
		
		
		int block = 5;
		int pageNum = (int)Math.ceil((double)listCount/listSize);
		int nowBlock = (int)Math.ceil((double)page/block);
		int s_page = (nowBlock * block) - (block-1);
		if (s_page <= 1) 
		{
			s_page = 1;
		}
		int e_page = nowBlock*block;
		if (pageNum <= e_page) {
			e_page = pageNum;
		}
		
		int s_point = (page-1) * listSize;
		
		List<HashMap<String, Object>> list = ac_dao.getwait(s_point, listSize*page, order_by, sort_type,cust_no,store); 
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		
		map.put("list", list);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		map.put("order_by", order_by);
		map.put("sort_type", sort_type);
		
		return map;
	}
	
	@RequestMapping("/del_wait")
	public ModelAndView del_wait(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("/WEB-INF/pages/web/common/isChk");
		
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String wait_info = Utils.checkNullString(request.getParameter("wait_info"));

		String store ="";
		String period ="";
		String subject_cd ="";
		String[] arr =null;
		
		System.out.println(wait_info);
		if (wait_info.indexOf("|")!=-1) {
			arr = wait_info.split("\\|");
			System.out.println(arr[0]);
			for (int i = 0; i < arr.length; i++) {
				
				store = arr[i].split("_")[0];
				period = arr[i].split("_")[1];
				subject_cd = arr[i].split("_")[2];

				ac_dao.del_wait(cust_no,store,period,subject_cd);
			}
		}else {
			arr = wait_info.split("_");
			store = arr[0];
			period = arr[1];
			subject_cd = arr[2];
			
			ac_dao.del_wait(cust_no,store,period,subject_cd);		
		}
	   
		
		mav.addObject("msg", "저장되었습니다.");
		return mav;
	}
	
	
	
	@RequestMapping("/getMylectureList")
	@ResponseBody
	public List<HashMap<String, Object>> getMylectureList(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String cust_no = "";
		if(!"".equals(Utils.checkNullString(session.getAttribute("login_seq"))))
		{
			cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		}
		
		String store = Utils.checkNullString(request.getParameter("store"));
		if (store.equals("") && session.getAttribute("login_store") != null) {
			store = Utils.checkNullString(session.getAttribute("login_store"));
		}
		String start_ymd = Utils.checkNullString(request.getParameter("start_ymd"));
		String end_ymd = Utils.checkNullString(request.getParameter("end_ymd"));
		
		
		
		List<HashMap<String, Object>> list = ac_dao.getMylectureList(cust_no,store,start_ymd,end_ymd); 

		
		return list;
	}
	@RequestMapping("/getPaymentListByTid")
	@ResponseBody
	public List<HashMap<String, Object>> getPaymentListByTid(HttpServletRequest request) {
		
		String tid = Utils.checkNullString(request.getParameter("tid"));
		String store = Utils.checkNullString(request.getParameter("store"));
		
		HttpSession session = request.getSession();
		String cust_no = "";
		if(!"".equals(Utils.checkNullString(session.getAttribute("login_cust"))))
		{
			cust_no = Utils.checkNullString(session.getAttribute("login_cust"));
		}
		
		List<HashMap<String, Object>> list = ac_dao.getPaymentListByTid(tid, store, cust_no); 
		
		return list;
	}
	@RequestMapping("/getHalfPaymentPrice")
	@ResponseBody
	public HashMap<String, Object> getHalfPaymentPrice(HttpServletRequest request) throws ParseException {
		
		String onList[] = Utils.checkNullString(request.getParameter("onList")).split("\\|");
		String offList[] = Utils.checkNullString(request.getParameter("offList")).split("\\|");
		
		int on_food_amt = 0;
		int on_regis_fee = 0;
		int off_food_amt = 0;
		int off_regis_fee = 0;
		for(int i = 0; i < offList.length; i++)
		{
			if(!"".equals(offList[i]))
			{
				String store = offList[i].split("_")[0];
				String period = offList[i].split("_")[1];
				String subject_cd = offList[i].split("_")[2];
				List<HashMap<String, Object>> list = ac_dao.getPeltMid(store, period, subject_cd);
				
				int regis_fee = Utils.checkNullInt(list.get(0).get("REGIS_FEE"));
				int food_amt = 0;
				if("Y".equals(Utils.checkNullString(list.get(0).get("FOOD_YN"))))
				{
					food_amt = Utils.checkNullInt(list.get(0).get("FOOD_AMT"));
				}
				off_regis_fee += regis_fee;
				off_food_amt += food_amt;
			}
			
		}
		for(int i = 0; i < onList.length; i++)
		{
			if(!"".equals(onList[i]))
			{
				String store = onList[i].split("_")[0];
				String period = onList[i].split("_")[1];
				String subject_cd = onList[i].split("_")[2];
				List<HashMap<String, Object>> list = ac_dao.getPeltMid(store, period, subject_cd);
				
				String yoil = "";
				String day_flag = Utils.checkNullString(list.get(0).get("DAY_FLAG"));
				if(day_flag.split("")[0].equals("1")){yoil += ",월";}
				if(day_flag.split("")[1].equals("1")){yoil += ",화";}
				if(day_flag.split("")[2].equals("1")){yoil += ",수";}
				if(day_flag.split("")[3].equals("1")){yoil += ",목";}
				if(day_flag.split("")[4].equals("1")){yoil += ",금";}
				if(day_flag.split("")[5].equals("1")){yoil += ",토";}
				if(day_flag.split("")[6].equals("1")){yoil += ",일";}
				yoil = yoil.substring(1, yoil.length());
				
				List<HashMap<String, Object>> holiList = ac_dao.getHoliday(store, period);
				String cancled_list_pelt = "";
				String cancled_list_peri = "";
				if(list.size() > 0 && list.get(0).get("CANCLED_LIST") != null)
				{
					cancled_list_pelt = Utils.checkNullString(list.get(0).get("CANCLED_LIST")).replaceAll("-", "");
				}
				if(holiList.size() > 0 && holiList.get(0).get("CANCLED_LIST") != null)
				{
					cancled_list_peri = Utils.checkNullString(holiList.get(0).get("CANCLED_LIST"));
				}
				
				final String DATE_PATTERN = "yyyyMMdd";
				String inputStartDate = Utils.checkNullString(list.get(0).get("START_YMD"));
				String inputEndDate = Utils.getCurrentDate();
				
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
				Date startDate = sdf.parse(inputStartDate);
				Date endDate = sdf.parse(inputEndDate);
				ArrayList<String> dates = new ArrayList<String>();
				Date currentDate = startDate;
				
				while (currentDate.compareTo(endDate) <= 0) 
				{
					for(int j = 0; j < yoil.split(",").length; j++)
					{
						int we = HolidayUtil.getDayOfWeek(Utils.checkNullString(sdf.format(currentDate)));
						String convWe = "";
						if(we == 1) {convWe = "일";}
						if(we == 2) {convWe = "월";}
						if(we == 3) {convWe = "화";}
						if(we == 4) {convWe = "수";}
						if(we == 5) {convWe = "목";}
						if(we == 6) {convWe = "금";}
						if(we == 7) {convWe = "토";}
						if(convWe.equals(yoil.split(",")[j]))
						{
							//기수 휴강일 제외, 강좌 휴강일 제외, 오늘날짜 제외
							if(cancled_list_pelt.indexOf(sdf.format(currentDate)) == -1 && cancled_list_peri.indexOf(sdf.format(currentDate)) == -1)
							{
								dates.add(sdf.format(currentDate));
							}
						}
					}
					Calendar c = Calendar.getInstance();
					c.setTime(currentDate);
					c.add(Calendar.DAY_OF_MONTH, 1);
					currentDate = c.getTime();
				}
				
				//강의료 계산
				int regis_fee = Utils.checkNullInt(list.get(0).get("REGIS_FEE"));
				int food_amt = 0;
				if("Y".equals(Utils.checkNullString(list.get(0).get("FOOD_YN"))))
				{
					food_amt = Utils.checkNullInt(list.get(0).get("FOOD_AMT"));
				}
				int lect_cnt = Utils.checkNullInt(list.get(0).get("LECT_CNT"));
				int mid_regis_fee = (int) Math.round((double)regis_fee / lect_cnt * dates.size());
				mid_regis_fee = (mid_regis_fee + 5)/10 * 10; //일의자리 반올림하기위함 
				
				
				int mid_food_amt = 0;
				if("Y".equals(Utils.checkNullString(list.get(0).get("FOOD_YN"))))
				{
					mid_food_amt = (int) Math.round((double)food_amt / lect_cnt * dates.size());
					mid_food_amt = (mid_food_amt + 5)/10 * 10; //일의자리 반올림하기위함 
				}
				
				on_regis_fee += mid_regis_fee;
				on_food_amt += mid_food_amt;
			}
		}
		System.out.println(on_regis_fee);
		System.out.println(on_food_amt);
		System.out.println(off_regis_fee);
		System.out.println(off_food_amt);
		
		int tot_regis_fee = on_regis_fee + off_regis_fee;
		int tot_food_amt = on_food_amt + off_food_amt;
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("tot_regis_fee", tot_regis_fee);
		map.put("tot_food_amt", tot_food_amt);
		
		return map;
	}
	
	@RequestMapping("/lectureCancel")
	public ModelAndView lectureCancel(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("/WEB-INF/pages/web/common/isChk");
		
		HttpSession session = request.getSession();
		String sUsrId = Utils.checkNullString(session.getAttribute("login_id")); // session UserId
		// 20170529 String sUsrRegno = sessionForm.getSessionRegno(); //session Regno
		String sAttendCustNo = Utils.checkNullString(session.getAttribute("login_cust")); // attend session custno
		// String sUnifyYn = sessionForm.getSessionUnifyYn(); //attend session custno
		String sUsrNm = Utils.checkNullString(session.getAttribute("login_name"));
		String sCi = Utils.checkNullString(session.getAttribute("login_ci")); // CI추가 20170525 - DI 추가 (2013.04.05);

		LectureVo actionobj = new LectureVo();
		
		
		actionobj.setHq(Utils.removeNULL(request.getParameter("hq"),"00")); //그룹구분(00은 애경유통그룹)
        actionobj.setStore(Utils.removeNULL(request.getParameter("store"),"")); //점구분
        actionobj.setPeriod(Utils.removeNULL(session.getAttribute("login_period"),Utils.checkNullString(common_dao.retrievePeriod(Utils.removeNULL(session.getAttribute("login_store"),"")).get("PERIOD")))); //강좌차수
        actionobj.setAttendCustNo(Utils.removeNULL(sAttendCustNo,"")); //수강자 코드
        actionobj.setAttendCustNm(Utils.removeNULL(sUsrNm,"")); //수강자 명
        actionobj.setSessionId(sUsrId); //세션 id
        actionobj.setIpAddress(Utils.checkNullString(session.getAttribute("login_ip"))); //ip주소
        actionobj.setAKmemCardNo(Utils.checkNullString(session.getAttribute("login_card")));
        actionobj.setHq(Utils.removeNULL(request.getParameter("hq"),"00")); //그룹구분(00은 애경유통그룹)
        actionobj.setSale_ymd(Utils.removeNULL(request.getParameter("sale_ymd"),"")); //결제일자
        actionobj.setPos_no(Utils.removeNULL(request.getParameter("pos_no"),"")); //포스번호
        actionobj.setRecpt_no(Utils.removeNULL(request.getParameter("recpt_no"),"")); //영수증번호
        actionobj.setCustNo(Utils.removeNULL(request.getParameter("cust_no"),""));    //결재자 회원번호
        actionobj.setBackpack(Utils.removeNULL(request.getParameter("backpack"),""));    //책가방 담기 여부
        actionobj.setTid(Utils.removeNULL(request.getParameter("tid"),""));    //취소시 PG사 도입 TID (2014.07)
        actionobj.setAkcard_yn(Utils.removeNULL(request.getParameter("akcard_yn"),"N"));    //취소시 SITE_CD를 가져오기 위해  도입 (2014.07)
        actionobj.setAkKBcard_yn(Utils.removeNULL(request.getParameter("akKBcard_yn"),"N"));    //취소시 SITE_CD를 가져오기 위해  도입 (2017.09)
        actionobj.setAkWBcard_yn(Utils.removeNULL(request.getParameter("akWBcard_yn"),"N"));    //취소시 SITE_CD를 가져오기 위해  도입 (2017.09)
        
        System.out.println("act_cancel_request.getParameter(tid) : " + request.getParameter("tid"));
        
        actionobj.setUser_id(sUsrId);  /* 로그인 아이디 ( 메일발송시 자녀경우 부모 메일주소 조회시 필요 2013.02.22)*/
        
        
        String sReturn = ac_dao.setLectCanCelCalc(actionobj);
        
        System.out.println("sReturn1 : "+sReturn);
        
        if(sReturn.equals("N1")){   //1.결제내역 체크
            sReturn = "정상적으로 결제한 내역이 없습니다.";
            
        }else if(sReturn.equals("N2")){  //2.수강취소 중복방지 체크
            sReturn = "이미 취소된 수강내역입니다."; 
            
        }else if(sReturn.equals("N3")){  //3.결제취소마감일 체크
            sReturn = "고객님께서는 결제하신 강좌중 개강일 또는 취소 기준일이 지난B       강좌(일일특강,요리,여행강좌)가 포함되어 있습니다.B                해당점에 방문하여 취소 부탁드립니다.B                            고맙습니다.";
            
        }else if(sReturn.equals("N4")){   //4.이미 시작된 강좌여부 체크 
            sReturn = "고객님께서는 결제하신 강좌중 개강일 또는 취소 기준일이 지난B       강좌(일일특강,요리,여행강좌)가 포함되어 있습니다.B                해당점에 방문하여 취소 부탁드립니다.B                            고맙습니다.";
            
        }else if(sReturn.equals("N8")){   //4-1. 해당 기수의 마감일자 확인 BAPERITB END_YMD  
            sReturn = "해당 기수의 취소 기한이 마감되었습니다. 고맙습니다.";
            
        }else if(sReturn.equals("N5")){  // 5.무료강좌 존재여부 체크
            sReturn = "무료강좌는 온라인 취소가 불가능 합니다.";	
            
        }else if(sReturn.equals("N6")){  // 6.사은품 반납여부 체크(지급 경우 취소불가-내방필요! 미지급상태만 가능- 취소로 변경
            sReturn = "고객님께서는 사은품을 지급 받은 내역이 있습니다. 해당점을 방문하셔야 취소가 가능합니다.";
            
        }else if(sReturn.equals("N7")){  // 6.무료수강권 사용내역이 있으나 정규강좌 수강내역 존재가 없다면 무료수강권 원복 처리 로직중 ★★★★★★★  장애발생!!! ★★★★★★★★
            sReturn = "연속수강자 정규강좌 수강해당자 무료수강권 미사용 원복중 에러가 발생했습니다.";
            
        }else if(sReturn.equals("N")){ 
            sReturn = "[결제취소실패] 오류가 발생하였습니다!";   
        }else if(sReturn.equals("N9")){ 
            sReturn = "[결제취소실패] 회원 인증 오류가 발생 했습니다. AK PLAZA 전산실 문의 바랍니다.";   
        }else if(sReturn.equals("N10")){ 
            sReturn = "[결제취소실패] 마일리지 조회 시 오류가 발생 했습니다. AK PLAZA 전산실 문의 바랍니다.";   
        }else if(sReturn.equals("N11")){ 
            sReturn = "[결제취소실패] 마일리지 부족으로 반품 불가하니, AK멤버스센터에 문의하세요";   
        }
        System.out.println("sReturn2 : "+sReturn);
        String check = sReturn.substring(0, 1); 
        
//        System.out.println("lectureaction <<<<<<< cancle  최종결과 값 >>>>>> check     --------check---------->  "+check);
        

        /* actionobj 에 결과 obj를 담는다 */
        actionobj.setNumber(Utils.removeNULL(request.getParameter("number"),"")); //임의 점 구분코드
        
        
        /* 사은품체크 해당자 안내표시 비활성화요청으로 체크 차단 (2012.07.19) 백혜정,이소진 Review중 확정 
        if(check.equals("X")){ //CmLectCheckout.jsp //결제완료page
            
            mav.addObject("result", actionobj);
            mav.addObject("msg", sReturn);
            return mapping.findForward("successLectCancel");
            
        }else 
        */
        
        System.out.println(" CHECK >>>>> page         <<<<<<<<<<<< :"+Utils.removeNULL(request.getParameter("page"),"1"));
        System.out.println(" CHECK >>>>> store        <<<<<<<<<<<< :"+Utils.removeNULL(request.getParameter("store"),""));
        System.out.println(" CHECK >>>>> number       <<<<<<<<<<<< :"+Utils.removeNULL(request.getParameter("number"),""));
        System.out.println(" CHECK >>>>> period_start <<<<<<<<<<<< :"+Utils.removeNULL(request.getParameter("period_start"),""));
        System.out.println(" CHECK >>>>> period_end   <<<<<<<<<<<< :"+Utils.removeNULL(request.getParameter("period_end"),""));
        
        
        // http://tculture.akplaza.com/cult/lecturelist.do?method=list&hq=00&store=03&menu_num=5_4&page=1&period_start=060&period_end=060
        if(check.equals("Y")){ //CmLectCheckout.jsp //결제완료page
       	
        	if (actionobj.getBackpack() != null  && actionobj.getBackpack().equals("Y")){
        		mav.addObject("msg", "결제취소가 완료되었습니다.\\n\\n취소하신 강좌는 책가방으로 이동되어 1일(24시간)동안만 보관됩니다.");	
        	}else{
        		mav.addObject("msg", "결제취소가 완료되었습니다.");	
        	}
        	
            mav.addObject("result", actionobj);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/cult/lecturelist.do?method=list&menu_num=3_5&hq=00&store="+request.getParameter("store")+"&period_start="+request.getParameter("period_start")+"&period_end="+request.getParameter("period_end")+"&page="+Common.removeNULL(request.getParameter("page"),"1"));
//            dispatcher.forward(request,response);
            return mav;
            
        }else{ //CmLectRegist.jsp  //결제page로 다시이동
            mav.addObject("msg", sReturn);
            mav.addObject("result", actionobj);
            
            // 수강내역 리스트  페이지로 이동
//             RequestDispatcher dispatcher = request.getRequestDispatcher("/cult/lecturelist.do?method=list&menu_num=3_5&hq=00&store="+request.getParameter("store")+"&period_start="+request.getParameter("period_start")+"&period_end="+request.getParameter("period_end")+"&page="+Common.removeNULL(request.getParameter("page"),"1"));
//            dispatcher.forward(request,response);
            return mav;
        }
		
	}
	public HashMap<String, Object> lectureCancel_half(String store, String tid, HttpServletRequest request) throws Exception {
		
		System.out.println("aaaaaa");
		HttpSession session = request.getSession();
		String sUsrId = Utils.checkNullString(session.getAttribute("login_id")); // session UserId
		// 20170529 String sUsrRegno = sessionForm.getSessionRegno(); //session Regno
		String sAttendCustNo = Utils.checkNullString(session.getAttribute("login_cust")); // attend session custno
		// String sUnifyYn = sessionForm.getSessionUnifyYn(); //attend session custno
		String sUsrNm = Utils.checkNullString(session.getAttribute("login_name"));
		String sCi = Utils.checkNullString(session.getAttribute("login_ci")); // CI추가 20170525 - DI 추가 (2013.04.05);

		List<HashMap<String, Object>> list = ac_dao.getPaymentListByTid(tid, store, sAttendCustNo);
		
		HashMap<String, Object> map = new HashMap<>();
		System.out.println("sdfsdfa : "+list.size());
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println("123123123123");
			String period = Utils.checkNullString(list.get(i).get("PERIOD"));
			String sale_ymd = Utils.checkNullString(list.get(i).get("SALE_YMD"));
			String pos_no = Utils.checkNullString(list.get(i).get("POS_NO"));
			String recpt_no = Utils.checkNullString(list.get(i).get("RECPT_NO"));
			String cust_no = sAttendCustNo;
			String akcard_yn = Utils.checkNullString(list.get(i).get("AKCARD_YN"));
			String akkbcard_yn = Utils.checkNullString(list.get(i).get("AKKBCARD_YN"));
			String akwbcard_yn = Utils.checkNullString(list.get(i).get("AKWBCARD_YN"));
			
			LectureVo actionobj = new LectureVo();
			
			
			actionobj.setHq("00"); //그룹구분(00은 애경유통그룹)
			actionobj.setStore(store); //점구분
			actionobj.setPeriod(period); //강좌차수
			actionobj.setAttendCustNo(Utils.removeNULL(sAttendCustNo,"")); //수강자 코드
			actionobj.setAttendCustNm(Utils.removeNULL(sUsrNm,"")); //수강자 명
			actionobj.setSessionId(sUsrId); //세션 id
			actionobj.setIpAddress(Utils.checkNullString(session.getAttribute("login_ip"))); //ip주소
			actionobj.setAKmemCardNo(Utils.checkNullString(session.getAttribute("login_card")));
			actionobj.setSale_ymd(Utils.removeNULL(sale_ymd,"")); //결제일자
			actionobj.setPos_no(Utils.removeNULL(pos_no,"")); //포스번호
			actionobj.setRecpt_no(Utils.removeNULL(recpt_no,"")); //영수증번호
			actionobj.setCustNo(Utils.removeNULL(cust_no,""));    //결재자 회원번호
			actionobj.setBackpack(Utils.removeNULL(request.getParameter("backpack"),""));    //책가방 담기 여부
			actionobj.setTid(Utils.removeNULL(tid,""));    //취소시 PG사 도입 TID (2014.07)
			actionobj.setAkcard_yn(Utils.removeNULL(akcard_yn,"N"));    //취소시 SITE_CD를 가져오기 위해  도입 (2014.07)
			actionobj.setAkKBcard_yn(Utils.removeNULL(akkbcard_yn,"N"));    //취소시 SITE_CD를 가져오기 위해  도입 (2017.09)
			actionobj.setAkWBcard_yn(Utils.removeNULL(akwbcard_yn,"N"));    //취소시 SITE_CD를 가져오기 위해  도입 (2017.09)
			
			System.out.println("act_cancel_request.getParameter(tid) : " + request.getParameter("tid"));
			
			actionobj.setUser_id(sUsrId);  /* 로그인 아이디 ( 메일발송시 자녀경우 부모 메일주소 조회시 필요 2013.02.22)*/
			
			System.out.println("1111111111111");
			String sReturn = ac_dao.setLectCanCelCalc_half(actionobj);
			
			System.out.println("sReturn1 : "+sReturn);
			
			if(sReturn.equals("N1")){   //1.결제내역 체크
				sReturn = "정상적으로 결제한 내역이 없습니다.";
				
			}else if(sReturn.equals("N2")){  //2.수강취소 중복방지 체크
				sReturn = "이미 취소된 수강내역입니다."; 
				
			}else if(sReturn.equals("N3")){  //3.결제취소마감일 체크
				sReturn = "고객님께서는 결제하신 강좌중 개강일 또는 취소 기준일이 지난B       강좌(일일특강,요리,여행강좌)가 포함되어 있습니다.B                해당점에 방문하여 취소 부탁드립니다.B                            고맙습니다.";
				
			}else if(sReturn.equals("N4")){   //4.이미 시작된 강좌여부 체크 
				sReturn = "고객님께서는 결제하신 강좌중 개강일 또는 취소 기준일이 지난B       강좌(일일특강,요리,여행강좌)가 포함되어 있습니다.B                해당점에 방문하여 취소 부탁드립니다.B                            고맙습니다.";
				
			}else if(sReturn.equals("N8")){   //4-1. 해당 기수의 마감일자 확인 BAPERITB END_YMD  
				sReturn = "해당 기수의 취소 기한이 마감되었습니다. 고맙습니다.";
				
			}else if(sReturn.equals("N5")){  // 5.무료강좌 존재여부 체크
				sReturn = "무료강좌는 온라인 취소가 불가능 합니다.";	
				
			}else if(sReturn.equals("N6")){  // 6.사은품 반납여부 체크(지급 경우 취소불가-내방필요! 미지급상태만 가능- 취소로 변경
				sReturn = "고객님께서는 사은품을 지급 받은 내역이 있습니다. 해당점을 방문하셔야 취소가 가능합니다.";
				
			}else if(sReturn.equals("N7")){  // 6.무료수강권 사용내역이 있으나 정규강좌 수강내역 존재가 없다면 무료수강권 원복 처리 로직중 ★★★★★★★  장애발생!!! ★★★★★★★★
				sReturn = "연속수강자 정규강좌 수강해당자 무료수강권 미사용 원복중 에러가 발생했습니다.";
				
			}else if(sReturn.equals("N")){ 
				sReturn = "[결제취소실패] 오류가 발생하였습니다!";   
			}else if(sReturn.equals("N9")){ 
				sReturn = "[결제취소실패] 회원 인증 오류가 발생 했습니다. AK PLAZA 전산실 문의 바랍니다.";   
			}else if(sReturn.equals("N10")){ 
				sReturn = "[결제취소실패] 마일리지 조회 시 오류가 발생 했습니다. AK PLAZA 전산실 문의 바랍니다.";   
			}else if(sReturn.equals("N11")){ 
				sReturn = "[결제취소실패] 마일리지 부족으로 반품 불가하니, AK멤버스센터에 문의하세요";   
			}
			System.out.println("sReturn2 : "+sReturn);
			String check = sReturn.substring(0, 1); 
			
//        System.out.println("lectureaction <<<<<<< cancle  최종결과 값 >>>>>> check     --------check---------->  "+check);
			
			
			/* actionobj 에 결과 obj를 담는다 */
			actionobj.setNumber(Utils.removeNULL(request.getParameter("number"),"")); //임의 점 구분코드
			
			
			/* 사은품체크 해당자 안내표시 비활성화요청으로 체크 차단 (2012.07.19) 백혜정,이소진 Review중 확정 
        if(check.equals("X")){ //CmLectCheckout.jsp //결제완료page
            
            mav.addObject("result", actionobj);
            mav.addObject("msg", sReturn);
            return mapping.findForward("successLectCancel");
            
        }else 
			 */
			
			System.out.println(" CHECK >>>>> page         <<<<<<<<<<<< :"+Utils.removeNULL(request.getParameter("page"),"1"));
			System.out.println(" CHECK >>>>> store        <<<<<<<<<<<< :"+Utils.removeNULL(request.getParameter("store"),""));
			System.out.println(" CHECK >>>>> number       <<<<<<<<<<<< :"+Utils.removeNULL(request.getParameter("number"),""));
			System.out.println(" CHECK >>>>> period_start <<<<<<<<<<<< :"+Utils.removeNULL(request.getParameter("period_start"),""));
			System.out.println(" CHECK >>>>> period_end   <<<<<<<<<<<< :"+Utils.removeNULL(request.getParameter("period_end"),""));
			
			
			// http://tculture.akplaza.com/cult/lecturelist.do?method=list&hq=00&store=03&menu_num=5_4&page=1&period_start=060&period_end=060
			if(check.equals("Y")){ //CmLectCheckout.jsp //결제완료page
				
				if (actionobj.getBackpack() != null  && actionobj.getBackpack().equals("Y")){
					map.put("msg", "결제취소가 완료되었습니다.\\n\\n취소하신 강좌는 책가방으로 이동되어 1일(24시간)동안만 보관됩니다.");	
				}else{
					map.put("msg", "결제취소가 완료되었습니다.");	
				}
				
				map.put("result", actionobj);
				return map;
				
			}else{ //CmLectRegist.jsp  //결제page로 다시이동
				map.put("msg", sReturn);
				map.put("result", actionobj);
				
				return map;
			}
		}
		return map;
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
		String check = Utils.checkNullString(ac_dao.Check(sCi));//ams_cus 테이블 회원 값 있는지 확인
		
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
			
			ac_dao.insWBREC(usr_info);	//지원서1 insert
			ac_dao.insWBPLA(usr_info);  //지원서2 insert
			
			mav.addObject("reg_no", reg_no);
			System.out.println("create new reg_no :"+ reg_no);
			mav.setViewName("redirect:/academy/lector02");	
		}
		return mav;
	}
	
	
	@RequestMapping("/GetAkmemCustInfo")
	@ResponseBody
	public HashMap<String, Object> GetAkmemCustInfo(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		String login_seq = Utils.checkNullString(session.getAttribute("login_seq"));
		String recv_buff = null;
        String sApprovNo = null;
        String sMessage = null;

        String AKmem_Send_Str = Utils.checkNullString(request.getParameter("send_data"));
        
        String AKmem_Resp_No = null; // akmembers 응답코드(00:정상 else 오류)
        String AKmem_Resp_Msg = null; // akmembers 응답메세지
        String AKmem_CardNo = null; // akmembers 카드번호
        String AKmem_CustNo = null; // akmembers 회원번호
        String AKmem_Family_CustNo = null; // akmembers 가족번호
        String AKmem_CustName = null; // akmembers 회원이름
        String AKmem_CustLevel = null; // akmembers 회원등급
        String AKmem_total_point = null; // akmembers 가용포인트
        String AKmem_use_yn = null; // akmembers 고객등록여부
        String AKmem_Card_Type = null; // akmembers
                                        // 카드타입(1:단순멤버스,2:신한제휴,3:드림카드,4:플러스카드,5:VIP카드,8국민제휴)
        String AKmem_RegiCard_yn = null; // akmembers 등록된 신용카드
                                            // 유무(0:등록카드없음,1:카드있음)
        String AKmem_RegiCard_no = null; // akmembers 등록된 신용카드 List (max
                                            // 10pcs)
        String AKmem_Use_Min_Point = null; // akmembers 최소사용 포인트
        String AKmem_Use_Max_Point = null; // akmembers 최대사용 포인트
        String AKmem_Use_hurdle = null; // akmembers 사용단위(허들) 포인트
        String AKmem_Stf_div = null; // akmembers 직원구분
        String AKmem_SaveApproveNo = null; // akmembers 멤버스 승인번호
        String AKmem_SaveApproveNo_POS = null; // akmembers 참여사 승인번호(POS)
        String AKmem_SaveApprove_Point = null; // akmembers 가용 포인트
        String AKmem_CustGrade = null; // akmembers 회원등급

        String hq = Utils.checkNullString(request.getParameter("hq"));
        String store = Utils.checkNullString(request.getParameter("store"));
        String pos_no = Utils.checkNullString(request.getParameter("pos_no"));
        String recpt_no = Utils.checkNullString(request.getParameter("recpt_no"));
        String total_pay = Utils.checkNullString(request.getParameter("total_pay"));
        String total_enuri_amt = Utils.checkNullString(request.getParameter("total_enuri_amt"));
        String total_regis_fee = Utils.checkNullString(request.getParameter("total_regis_fee"));
        String akmem_card_no = Utils.checkNullString(request.getParameter("akmem_card_no"));
        String akmem_point_amt = Utils.checkNullString(request.getParameter("akmem_point_amt"));
        
        String total_show_amt = Utils.checkNullString(request.getParameter("total_show_amt"));
        String akmem_cust_no = Utils.checkNullString(request.getParameter("akmem_cust_no"));
        String akmem_family_cust_no = Utils.checkNullString(request.getParameter("akmem_family_cust_no"));
        String akmem_recpt_point = Utils.checkNullString(request.getParameter("akmem_recpt_point"));
        String recpt_pos_no = Utils.checkNullString(request.getParameter("recpt_pos_no")); //적립취소시 원승인번호
        
        
        String akmem_encCardNo_send_str = Utils.checkNullString(request.getParameter("akmem_encCardNo_send_str"));

        String akmem_cardno_des = null; // akmembers card_no 암호화 추가(10.02.09)
        String AKmem_Pswd = null;       // akmembers 비밀번호 (2019.03.11 ljs 추가)
        String AKmem_Use_Point = "0";   // akmembers 사용마일리지 (2019.03.11 ljs 추가)
        String rsUseDivCd = "1";        // akmembers 적용사용구분(1 : 정상, 2 : 취소)(2019.04.16 ljs 추가)  
        String Slip_Cnt = null;         // akmembers 적용사용구분(1 : 정상, 2 : 취소)(2019.04.16 ljs 추가) 

        BABatchRun acard = new BABatchRun();
        
        if("00".equals(hq) && "01".equals(store))
		{
            // 구로점
            acard.setHost("172.10.1.71", 9302);
        }
		else if("00".equals(hq) && "02".equals(store))
		{
            // 수원점
            acard.setHost("173.10.1.71", 9302);
        }
		else if("00".equals(hq) && "03".equals(store))
		{
            // 분당점
            acard.setHost("91.3.105.15", 9302);
//            acard.setHost("127.0.0.1", 9999);
        }
		else if("00".equals(hq) && "04".equals(store))
		{
            // 평택점
            acard.setHost("174.10.1.71", 9302);
        }
		else if("00".equals(hq) && "05".equals(store))
		{
            // 원주점
            acard.setHost("175.10.1.71", 9302);
        }
        HashMap<String, Object> map = new HashMap<>();
        
        AKmem_Send_Str = AKmem_Send_Str.replaceAll("@@@@@@@@@@@@@@", AKCommon.getCurrentDate() + AKCommon.getCurrentTime());

        // 통신체크
        if(acard.start().equals("OK")){
        	
            
         // AK멤버스 회원인증
            if("XA241S".equals(AKmem_Send_Str.trim().substring(0, 6)) // 여전법 이전 전문IC 여전법 이후  XA241S = MS거래
                    || "XB241S".equals(AKmem_Send_Str.trim().substring(0, 6))){ // 여전법  이후XA241S = IC거래
                String encst = AKmem_Send_Str.substring(185,269);
                String encDt = AKmem_Send_Str.substring(0,185);
                
                // IC 카드 인증시 
                if(encst.trim().length()>0){
                    for(int i = 0; i < encst.length();i++){
                        int chPoint = ((int)encst.charAt(i))-1;
                        if(chPoint < 0) chPoint = 126;
                        char encChar = (char)chPoint;
                        encDt+= String.valueOf(encChar);
                    }
                    encDt += AKCommon.LPAD("",50,' ') ;
                    AKmem_Send_Str = encDt;
                }
                recv_buff = acard.encCardNo_run(AKmem_Send_Str);
                System.out.println("AKmem_Send_Str : "+AKmem_Send_Str);
                System.out.println("recv_buff : "+recv_buff);

                AKmem_Resp_No = AKCommon.ByteSubStr(recv_buff, 25, 2); // akmembers 응답코드(00:정상 else기타)
                AKmem_Resp_Msg = AKCommon.ByteSubStr(recv_buff, 181, 64); // akmembers 응답메세지
                AKmem_CardNo = AKCommon.ByteSubStr(recv_buff, 51, 16); // akmembers 카드번호
                AKmem_CustNo = AKCommon.ByteSubStr(recv_buff, 121, 9); // akmembers 회원번호
                AKmem_Family_CustNo = AKCommon.ByteSubStr(recv_buff, 130,10); // akmembers 가족번호
                AKmem_CustName = AKCommon.ByteSubStr(recv_buff, 362, 40); // akmembers 회원명
                AKmem_CustLevel = AKCommon.ByteSubStr(recv_buff, 254, 7); // akmembers 회원등급
                AKmem_total_point = AKCommon.ByteSubStr(recv_buff, 159, 10); // akmembers 가용포인트
                AKmem_use_yn = AKCommon.ByteSubStr(recv_buff, 245, 1); // akmembers 고객등록여부
                AKmem_Card_Type = AKCommon.ByteSubStr(recv_buff, 246, 1); // akmembers 카드타입(1:단순멤버스,2:신한제휴,3:드림카드,4:플러스카드,5:VIP카드,8:국민제휴)
                AKmem_RegiCard_yn = AKCommon.ByteSubStr(recv_buff, 290, 1); // akmembers 등록된 신용카드 유무(0:등록카드없음,1:카드있음)
                AKmem_RegiCard_no = AKCommon.ByteSubStr(recv_buff, 710, 160); // akmembers 등록된 신용카드 List (max 10pcs)
                AKmem_Stf_div = AKCommon.ByteSubStr(recv_buff, 289, 1); // akmembers 직원구분(1,2,3)
                AKmem_Use_Min_Point = AKCommon.ByteSubStr(recv_buff, 291,10); // akmembers 최소사용 포인트
                AKmem_Use_Max_Point = AKCommon.ByteSubStr(recv_buff, 301,10); // akmembers 최대사용 포인트
                AKmem_Use_hurdle = AKCommon.ByteSubStr(recv_buff, 311, 10); // akmembers 사용단위(허들) 포인트
                AKmem_Pswd = AKCommon.ByteSubStr(recv_buff, 88, 16); // akmembers 비밀번호 (2019.03.11 ljs 추가)
                
                if(AKmem_CustLevel != "" || AKmem_CustLevel != null){
                	AKmem_CustGrade = ac_dao.GetAkmemGrade(AKmem_CustLevel);
                }
                //2019.06.24 ljs "*"포함된 카드번호 복호화 처리
                if(!(akmem_encCardNo_send_str == null || "".equals(akmem_encCardNo_send_str))){
               	AKmem_CardNo =  AKCommon.GetCustEncCardNoDecStr(store, akmem_encCardNo_send_str);
               }
                
                map.put("sApprovNo", AKmem_Resp_No);
                map.put("sMessage", AKmem_Resp_Msg);
                map.put("AKmem_Resp_No", AKmem_Resp_No);
                map.put("AKmem_Resp_Msg", AKmem_Resp_Msg);
                map.put("AKmem_CardNo", AKmem_CardNo);
                map.put("AKmem_CustNo", AKmem_CustNo);
                map.put("AKmem_Family_CustNo", AKmem_Family_CustNo);
                map.put("AKmem_CustName", AKmem_CustName);
                map.put("AKmem_CustLevel", AKmem_CustLevel);
                map.put("AKmem_total_point", AKmem_total_point);
                map.put("AKmem_use_yn", AKmem_use_yn);
                map.put("AKmem_Card_Type", AKmem_Card_Type);
                map.put("AKmem_RegiCard_yn", AKmem_RegiCard_yn);
                map.put("AKmem_RegiCard_no", AKmem_RegiCard_no);
                map.put("AKmem_Use_Min_Point", AKmem_Use_Min_Point);
                map.put("AKmem_Use_Max_Point", AKmem_Use_Max_Point);
                map.put("AKmem_Use_hurdle", AKmem_Use_hurdle);
                map.put("AKmem_CustGrade", AKmem_CustGrade);
                map.put("point_amt", "0");            // point_amt 사용포인트 (2019.03.11 ljs 추가)
                map.put("point_approve_yn", "N");     // 사용포인트승인여부  (2019.03.11 ljs 추가)
                map.put("AKmem_Pswd", AKmem_Pswd);    // akmembers 비밀번호 (2019.03.11 ljs 추가)

            }
            else if("XA242S".equals(AKmem_Send_Str.trim().substring(0, 6))
                    ||"XB242S".equals(AKmem_Send_Str.trim().substring(0, 6))){
            String encst = AKCommon.ByteSubStr(AKmem_Send_Str,882,84);
            String encDt = AKCommon.ByteSubStr(AKmem_Send_Str,0,882);
            // IC 카드 인증시 
            if(encst.trim().length()>0){
                for(int i = 0; i < encst.length();i++){
                    int chPoint = ((int)encst.charAt(i))-1;
                    if(chPoint < 0) chPoint = 126;
                    char encChar = (char)chPoint;
                    encDt+= String.valueOf(encChar);
                }
                encDt += AKCommon.LPAD("",142,' ') ;
                AKmem_Send_Str = encDt;
            }
            
            recv_buff = acard.encCardNo_run(AKmem_Send_Str);  //asis :  AKmem_run

            AKmem_Resp_No = AKCommon.ByteSubStr(recv_buff, 25, 2); // akmembers 응답코드(00:정상  else 기타)
            AKmem_Resp_Msg = AKCommon.ByteSubStr(recv_buff, 270, 64); // akmembers  응답메세지
            AKmem_SaveApproveNo = AKCommon.ByteSubStr(recv_buff, 107,31); // akmembers 멤버스 승인번호
            AKmem_SaveApproveNo_POS = AKCommon.ByteSubStr(recv_buff,152, 9); // akmembers 참여사 승인번호(POS)
            AKmem_SaveApprove_Point = AKCommon.ByteSubStr(recv_buff,250, 10); // akmembers 가용 포인트

            map.put("sApprovNo", AKmem_Resp_No);
            map.put("sMessage", AKmem_Resp_Msg);
            map.put("AKmem_SaveApproveNo", AKmem_SaveApproveNo);
            map.put("AKmem_SaveApproveNo_POS", AKmem_SaveApproveNo_POS);
            map.put("AKmem_SaveApprove_Point", AKmem_SaveApprove_Point);

            // DB Log insert
            if("00".equals(AKmem_Resp_No)){

                map.put("AKmem_sale_ymd", AKCommon.ByteSubStr(recv_buff, 138, 8));

                // 10.02.09 암호화 기존소스 백업
                // **********************************************************************
                // map.put("AKmem_cardno",
                // AKCommon.ByteSubStr(recv_buff,51,37));
                //여전법 이전 akmem_cardno_des = param.getParameter("akmem_cardno_des"); // 암호화된  // 카드번호추가(10.02.09)
                //map.put("AKmem_cardno", akmem_cardno_des);
                
                if(!(akmem_encCardNo_send_str == null || "".equals(akmem_encCardNo_send_str))){
                   	AKmem_CardNo =  AKCommon.GetCustEncCardNoDecStr(store, akmem_encCardNo_send_str);
                   }

                // 10.02.09 암호화
                // **********************************************************************

                map.put("AKmem_CustNo", AKCommon.ByteSubStr(recv_buff, 88, 9));
                map.put("AKmem_Family_CustNo", "");
                map.put("AKmem_recpt_point", AKCommon.ByteSubStr(recv_buff, 175, 10));
                map.put("AKmem_SaveApproveNo_POS",AKmem_SaveApproveNo_POS);
                map.put("AKmem_SaveApprove_Point",AKmem_SaveApprove_Point); // 누적 마일리지 금액 추가 (2013.09.05)

                // 18.02.19 여전법 이후 KSN+encData로 카드번호 찾아오기
                // **********************************************************************
                // if(AKmem_Send_Str.substring(840, 924).trim() != ""){
                // AKmem_Send_Str = "XB245S"+AKmem_Send_Str.substring(6,
                // 42)+ AKmem_Send_Str.substring(840, 924);
                // recv_buff = acard.AKmem_run(AKmem_Send_Str);
                // System.out.println("recv_buff>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>["
                // + recv_buff+"]");
                // akmem_cardno_des = recv_buff.substring(42, 126).trim();
                // map.put("AKmem_cardno", akmem_cardno_des);
                // }
                
                //2019.05.29 ljs  : 전성민대리님 소스변경 내역 반영
                /*운영 로직으로 대사 처리시 입력된 POS번호와 전문의 POS번호가 달라 대사처리시 문제가 발생 
                 * [처리사항]
					 * 1. 모바일 결제 -> DESK 취소
                 *    - BAPTCATB 취소 영수증 : 취소 DESK POS번호 입력 -> 원거래로 변경
                 *    - 마일리지 취소 전문 : 원거래 POS번호 입력(070014)
                 * 2. WEB 결제 -> DESK 취소 시
                 *    - BAPTCATB 취소 영수증 : 취소 DESK POS번호 등록 -> 원거래로 변경
                 *    - 마일리지 취소 전문 : 취소 DESK POS번호 등록 -> 원거래로 변경
                 */
                //이건 취소 시 사용하는 변수인것같다.
                map.put("recpt_pos_no", recpt_pos_no);
                
                //2019.04.04 ljs : 사용마일리지 처리후 적립마일리지 update 처리 START
                AKmem_Use_Point = akmem_point_amt; //받아오는 값 앞자리 의미없는 "0" 제거
                
                map.put("store", store);
                map.put("pos_no", pos_no);
                map.put("recpt_no", recpt_no);
                map.put("total_show_amt", total_show_amt);
                map.put("total_enuri_amt", total_enuri_amt);
                map.put("total_regis_fee", total_regis_fee);
                map.put("AKmem_cardno", akmem_card_no);
                map.put("akmem_point_amt", akmem_point_amt);
                map.put("login_seq", login_seq);
                int saveResult = ac_dao.saveAKmembersPointLog(map);
            }


        // AK멤버스 마일리지 사용  (2019.03.25 ljs 추가) start
        }
            else if("XA243S".equals(AKmem_Send_Str.trim().substring(0, 6))
                    ||"XB243S".equals(AKmem_Send_Str.trim().substring(0, 6))){
            String encst = AKCommon.ByteSubStr(AKmem_Send_Str,383,84);
            String encDt = AKCommon.ByteSubStr(AKmem_Send_Str,0,383);
            
            // IC 카드 인증시 
            if(encst.trim().length()>0){
                for(int i = 0; i < encst.length();i++){
                    int chPoint = ((int)encst.charAt(i))-1;
                    if(chPoint < 0) chPoint = 126;
                    char encChar = (char)chPoint;
                    encDt+= String.valueOf(encChar);
                }
                encDt += AKCommon.LPAD("",50,' ') ;        //마일리지사용 POS전문 요청부분  FILLER항목 길이
                AKmem_Send_Str = encDt;
            }
            
            recv_buff = acard.encCardNo_run(AKmem_Send_Str);


            AKmem_Resp_No = AKCommon.ByteSubStr(recv_buff, 25, 2); // akmembers 응답코드(00:정상  else 기타)
            AKmem_Resp_Msg = AKCommon.ByteSubStr(recv_buff, 270, 64); // akmembers  응답메세지
            AKmem_SaveApproveNo = AKCommon.ByteSubStr(recv_buff, 107,31); // akmembers 멤버스 승인번호
            AKmem_SaveApproveNo_POS = AKCommon.ByteSubStr(recv_buff,152, 9); // akmembers 참여사 승인번호(POS)
            AKmem_Use_Point = AKCommon.ByteSubStr(recv_buff,175, 10); // akmembers 사용 포인트
            AKmem_SaveApprove_Point = AKCommon.ByteSubStr(recv_buff,250, 10); // akmembers 가용 포인트
            String AKmem_vat_use_pt = AKCommon.ByteSubStr(recv_buff,334, 10); // 부가세포함 사용포인트
            String AKmem_vat_ext_use_pt = AKCommon.ByteSubStr(recv_buff,344, 10); // 부가세제외 사용포인트

            map.put("sApprovNo", AKmem_Resp_No);
            map.put("sMessage", AKmem_Resp_Msg);
            map.put("AKmem_SaveApproveNo", AKmem_SaveApproveNo);
            map.put("AKmem_SaveApproveNo_POS", AKmem_SaveApproveNo_POS);
            map.put("AKmem_SaveApprove_Point", AKmem_SaveApprove_Point);
            

            // DB Log insert
            if("00".equals(AKmem_Resp_No)){
            	
            	map.put("AKmem_sale_ymd", AKCommon.ByteSubStr(recv_buff, 138, 8));

                if(!(akmem_encCardNo_send_str == null || "".equals(akmem_encCardNo_send_str))){
                   	AKmem_CardNo =  AKCommon.GetCustEncCardNoDecStr(store, akmem_encCardNo_send_str);
                }

                if(AKmem_Use_Point == null || "".equals(AKmem_Use_Point))
                {
                	AKmem_Use_Point = "0";
                }
                
                if(AKmem_vat_use_pt == null || "".equals(AKmem_vat_use_pt))
                {
                	AKmem_vat_use_pt = "0";
                }
                
                if(AKmem_vat_ext_use_pt == null || "".equals(AKmem_vat_ext_use_pt))
                {
                	AKmem_vat_ext_use_pt = "0";
                }
                
                AKmem_Use_Point = String.valueOf(Integer.valueOf(AKmem_Use_Point)); //받아오는 값 앞자리 의미없는 "0" 제거
                AKmem_vat_use_pt = String.valueOf(Integer.valueOf(AKmem_vat_use_pt)); //받아오는 값 앞자리 의미없는 "0" 제거
                AKmem_vat_ext_use_pt = String.valueOf(Integer.valueOf(AKmem_vat_ext_use_pt)); //받아오는 값 앞자리 의미없는 "0" 제거
                
                map.put("AKmem_CustNo", AKCommon.ByteSubStr(recv_buff, 88, 9));
                map.put("AKmem_Family_CustNo", "");                      
                map.put("AKmem_SaveApproveNo_POS",AKmem_SaveApproveNo_POS);
                map.put("AKmem_SaveApprove_Point",AKmem_SaveApprove_Point); // 누적 마일리지 금액 추가 (2013.09.05)
                map.put("AKmem_Use_Point", AKmem_Use_Point);
                map.put("AKmem_vat_use_pt",AKmem_vat_use_pt);    
                map.put("AKmem_vat_ext_use_pt",AKmem_vat_ext_use_pt);
                
                //2019.05.29 ljs  : 전성민대리님 소스변경 내역 반영
                /*운영 로직으로 대사 처리시 입력된 POS번호와 전문의 POS번호가 달라 대사처리시 문제가 발생 
                 * [처리사항]
					 * 1. 모바일 결제 -> DESK 취소
                 *    - BAPTCATB 취소 영수증 : 취소 DESK POS번호 입력 -> 원거래로 변경
                 *    - 마일리지 취소 전문 : 원거래 POS번호 입력(070014)
                 * 2. WEB 결제 -> DESK 취소 시
                 *    - BAPTCATB 취소 영수증 : 취소 DESK POS번호 등록 -> 원거래로 변경
                 *    - 마일리지 취소 전문 : 취소 DESK POS번호 등록 -> 원거래로 변경
                 */
                map.put("recpt_pos_no",AKmem_vat_ext_use_pt);
                
                
                AKmem_CustNo = Utils.checkNullString(map.get("AKmem_CustNo"));
                AKmem_Family_CustNo = Utils.checkNullString(map.get("AKmem_Family_CustNo"));
                
                ac_dao.useAKmembersPointLog(hq, store, pos_no, recpt_no, total_pay, total_enuri_amt, total_regis_fee, 
                		akmem_card_no, AKmem_CustNo, AKmem_Family_CustNo,
                		AKmem_Use_Point, AKmem_vat_use_pt, AKmem_vat_ext_use_pt, AKmem_SaveApprove_Point, AKmem_SaveApproveNo_POS, akmem_point_amt, login_seq
                		
                		);
            }

            
        // AK멤버스 마일리지 사용  (2019.03.25 ljs 추가) end   
        }
            else {
                // 전문요청 ERR
                sApprovNo = "Fail0000";
                sMessage = "Header ERROR";
                map.put("sApprovNo", sApprovNo);
                map.put("sMessage", sMessage);
                System.out.println("HEADER FORMAT ERROR");
            }
        } else {
            sApprovNo = "Fail0000";
            sMessage = "AKmembers 통신오류발생";
            map.put("sApprovNo", sApprovNo);
            map.put("sMessage", sMessage);
            System.out.println("XA241S 통신 ERROR");
        }
        acard.stop();

        return map;
	}
	public String setLectCalc(LectureVo actionobj) throws Exception {
        try {

            String result = "";
            String rlt = "N"; // 결제실패시 return값            
            
            // 1.장바구니 체크
            int tempCheckCnt = ac_dao.retrieveTempCheck(actionobj);
            System.out.println("tempCheckCnt 0이면 out--------------------> "+ tempCheckCnt);
            if (tempCheckCnt == 0) {
                result = "등록할 정보가 없습니다.";
                return rlt;
            }
            
            // 1-2 결제전.후 장바구니 체크 여기서 대부분 처리
//            String tempCheck = ac_dao.tempAsCheck(actionobj);
//            System.out.println("tempCheck fall이면 out--------------------> "+ tempCheck);
//            if (tempCheck.equals("fail")) { // 결제된 강좌 존재
//                rlt = "T";
//                return rlt;
//            }
            
            // 2.결제 중복 체크
            String settleCheckRslt = ac_dao.retrieveSettleCheck(actionobj);
            System.out.println("settleCheckRslt fall이면 out--------------------> "+ settleCheckRslt);
            if (settleCheckRslt.equals("fail")) { // 결제된 강좌 존재
                result = "이미 결제된 강좌가 있습니다.";
                return rlt;
            }

            // 3.결제 금액 체크
            //할인, 2인수강 등 가격변동 요소가 많아 이부분 주석처리
//            String totAmtCheckRslt = ac_dao.retrieveTotAmtCheck(actionobj);
//            System.out.println("totAmtCheckRslt fall이면 out--------------------> "+ totAmtCheckRslt);
//            if (totAmtCheckRslt.equals("fail")) { // 결제 금액 상이
//                //result = "결제하실 금액이 맞지 않습니다.";
//            	result = "결제 중 오류가 발생하였습니다.\\n\\n나의 책가방으로 이동합니다.\\n\\n결제를 다시 시도하시기 바랍니다.";
//                rlt = "E"+result;
//                return rlt;
//            }
            
            // 진행기수 -1 (이전기수) 연속수강 사은품 대상자 무료수강권 여부체크(2011.01.03) 존재하면 true
            int free_fee = 0;

            if (actionobj.isFlag4()) {
            	// ★ 2012년 겨울학기 접수 로직(구로점 5,000원 나머지 10,000원) 조은혜

                    free_fee = 10000;  // 전점 무료수강권 10,000원권 (20160111)

                    actionobj.setFree_fee(free_fee);
//                System.out.println("LectureDao.java - setLectCalc 연속수강권  : free_fee >>>>>>>>>>>>>>>>>>>:"+ free_fee);
            }

            // 3-1 AK신한카드 경우 결제금액 변경 (10.10.28)
            // 10회미만인게 없어야되고(true), 10회이상인것만 있어야됨(false)
            // AK신한카드 5%할인 일정체크 추가(10.11.25)
            Double dRealtotlAmt = 0.0;

            /*
             * 신설에누리 강좌 존재하고 isFlag6 = ture 신설 에누리강좌 미존재 하면 isFlag7 = true
             * (복합책가방 담기) 분리 메시지 띄움(2011.04.13)
             */
            if (!actionobj.isFlag6() && actionobj.isFlag7()) {
                if (actionobj.isFlag3()) { // AK신한카드 일정 해당하면 true
                	if ((actionobj.getCardfg()!= null && actionobj.getCardfg().equals("822")) && (actionobj.getDTotalAmt() > 0) && actionobj.isFlag1() && !actionobj.isFlag2()) {

                    	
                		actionobj.setF_regis_fee(actionobj.getDTotalAmt());
                        
                        // 연속수강자 수강 할인권 사용 + AK신한 할인 로직추가(11.01.11) START
                        if (actionobj.isFlag4() && actionobj.isFlag5()) {
                            // ★★★★★★★★ 신설강좌 할인경우 조건 추가(2011.02.02)
                        	if (actionobj.getNew_enuri_amt() > 0) {
                                // ((수강료 - 신설강좌 할인금액 - 수강할인권) *0.95) + 재료비
                                // 신설강좌 존재시 할인 제외(2011.04.13)
                                // dRealtotlAmt = ((( Integer.parseInt(map.get("DRegiAmt").toString()) -
                                // actionobj.getNew_enuri_amt()-
                                // Integer.parseInt(map.get("Free_fee").toString()) ) * 0.95) +
                                // Integer.parseInt(map.get("DFoodAmt").toString())); // 결제 할인된 최종금액
                            } else {
                                // ((수강료 - 수강할인권) *0.95) + 재료비
                            	dRealtotlAmt = (((actionobj.getDRegiAmt() - actionobj.getFree_fee()) *0.95) + actionobj.getDFoodAmt() - actionobj.getUPointAmt()); // 결제 할인된 최종금액 ★☆ 0.95 차후 수
                            }
                            System.out.println("LectureDao.java - setLectCalc AK신한 카드+연속수강자  /  AK신한 일정기간 적용  : dRealtotlAmt >>>>>>>>>>>>>>>>>>>:"
                                            + dRealtotlAmt);

                            // AK신한 할인 로직(11.01.11)
                        } else {
                            // ★★★★★★★★ 신설강좌 할인경우 조건 추가(2011.02.02)
                            // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
                        	if (actionobj.getNew_enuri_amt() > 0) {
                                // ((수강료 - 신설강좌 할인금액) * 5%할인 ) + 재료비
                                // 신설강좌 존재시 할인 제외(2011.04.13)
                                // dRealtotlAmt = (((Integer.parseInt(map.get("DRegiAmt").toString())-
                                // actionobj.getNew_enuri_amt()) * 0.95) +
                                // Integer.parseInt(map.get("DFoodAmt").toString())); // 결제 할인된 최종금액
                            } else {
                                // (수강료 * 5%할인 )+재료비
                            	dRealtotlAmt = ((actionobj.getDRegiAmt() * 0.95) + actionobj.getDFoodAmt() - actionobj.getUPointAmt()); // 결제 할인된 최종금액 ★☆ AK신한 5% 할인 추후 수정 0.95
                            }
                            System.out.println("LectureDao.java - setLectCalc AK신한 카드 /  AK신한 일정기간 적용  : dRealtotlAmt >>>>>>>>>>>>>>>>>>>:" + dRealtotlAmt);
                        }
                        // ----------------------------------------------- END
                        
                        actionobj.setDTotalAmt(dRealtotlAmt);

                        System.out.println("LectureDao.java - setLectCalc - dRealtotlAmt (결제금액) >>>>>>>>>>>>>>>>>>>:"+ dRealtotlAmt);

                	} else if ((actionobj.isFlag4()) && (actionobj.isFlag5())
                            && (actionobj.getDTotalAmt() > 0)
                            && actionobj.isFlag1() && !actionobj.isFlag2()) {
                        // ★★★★★★★★ 신설강좌 할인경우 조건 추가(2011.02.02)
                        if (actionobj.getNew_enuri_amt() > 0) {
                            // 수강료 - 신설강좌 할인금액 - 무료수강권 + 재료비
                            // 신설강좌 존재시 할인 제외(2011.04.13)
                            // dRealtotlAmt = ( actionobj.getDRegiAmt() - actionobj.getNew_enuri_amt() - actionobj.getFree_fee() + actionobj.getDFoodAmt()); // 결제 할인된 최종금액
                        } else {
                            // 수강료 - 무료수강권 + 재료비
                            dRealtotlAmt = (actionobj.getDRegiAmt() - actionobj.getFree_fee() - actionobj.getDayEnuri() + actionobj.getDFoodAmt() - actionobj.getUPointAmt()); // 결제 할인된 최종금액

                        }
                        
                        actionobj.setDTotalAmt(dRealtotlAmt);

                        System.out.println("LectureDao.java - setLectCalc 타사카드 /  AK신한 일정기간 적용  : dRealtotlAmt >>>>>>>>>>>>>>>>>>>:" + dRealtotlAmt);
                    }
                    // 연속수강자 수강 할인권 사용 로직추가(11.01.11) (수강료 - 무료수강권 + 재료비)
                } else if ((actionobj.isFlag4()) && (actionobj.isFlag5())
                        && (actionobj.getDTotalAmt() > 0)
                        && actionobj.isFlag1() && !actionobj.isFlag2()) {
                    // ★★★★★★★★ 신설강좌 할인경우 조건 추가(2011.02.02)
                    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
                    if (actionobj.getNew_enuri_amt() > 0) {
                        // 수강료 - 신설강좌 할인금액 - 무료수강권 + 재료비
                        // 신설강좌 존재시 할인 제외(2011.04.13)
                        // dRealtotlAmt = ( actionobj.getDRegiAmt() -
                        // actionobj.getNew_enuri_amt() -
                        // actionobj.getFree_fee() + actionobj.getDFoodAmt());
                        // // 결제 할인된 최종금액
                    } else {
                        // 수강료 - 신설강좌 할인금액 - 무료수강권 + 재료비
                    	dRealtotlAmt = (actionobj.getDRegiAmt() - actionobj.getFree_fee() - actionobj.getDayEnuri() + actionobj.getDFoodAmt() - actionobj.getUPointAmt()); // 결제 할인된 최종금액

                    }
                    
                    actionobj.setDTotalAmt(dRealtotlAmt);

                    System.out.println("LectureDao.java - setLectCalc 타사카드 또는 AK신한카드 /  AK신한 일정기간 제외  : dRealtotlAmt >>>>>>>>>>>>>>>>>>>:"+ dRealtotlAmt);
                }
            }
            
            // 3.5 화면에서 끌어온 값과, 새로 계산한 값이 다를 경우 
            if(actionobj.getDTotalAmt() != actionobj.getGood_mny())
            {
            	result = "결제 대상 금액의 오류 발생! 새로 결제를 시도해주세요.";
                return rlt;
            }
            
            // 4.승인처리 및 매출임시테이블 저장
            String settleProcessRslt = ac_dao.settleProcess(actionobj);
            System.out.println("settleProcessRslt1 fall이면 out--------------------> "+ settleProcessRslt);
            if(settleProcessRslt.equals("Wrong Card")){
            	return "결제하신 카드 정보가 맞는지 확인 후 다시 시도해 주세요\\nAK신한카드일 경우 [AK신한카드],AKKB국민카드일 경우 [AKKB국민카드], 일반 신한카드,국민카드일 경우 [일반카드]를 선택하셔야 합니다.";
            	
            } else if (!settleProcessRslt.equals("success")) { // 승인처리 및 매출임시테이블 저장 실패
                result = settleProcessRslt;
                return rlt;
            }

            // 5.사은품
//            String giftProcessRslt = ac_dao.giftProcess(actionobj);
//            System.out.println("giftProcessRslt fall이면 out--------------------> "+ giftProcessRslt);
//            if (giftProcessRslt.equals("fail")) { // 사은품 처리 실패
//                result = giftProcessRslt;
//                return rlt;
//            }
            String giftProcessRslt = "Y"; //나중에 동동이가 처리해주겠지

         // 6.장바구니 삭제
            int tempDeleteCnt = ac_dao.tempDeleteProcess(actionobj);
            System.out.println("tempDeleteCnt 0이면 out--------------------> "+ tempDeleteCnt);
            if (tempDeleteCnt == 0) { // 장바구니 삭제 에러
                result = "책가방 삭제 시 에러가 발생하였습니다.";
                return rlt;
            }
            
         // isFlag2단기강좌 여부 체크 단기강좌 있으면 TURE
         // isFlag1정규강좌 여부 체크 정규강좌 있으면 TURE
            // 7. 연속수강자 수강 할인권 사용 저장 (2011.01.11 추가) (연속수강자 대상자 + 지급여부 미지급 + 정규강좌만 )
            if (actionobj.isFlag4() && actionobj.isFlag5() && (actionobj.getDTotalAmt() > 0) && actionobj.isFlag1() && !actionobj.isFlag2()// 신설에누리 강좌 존재여부 추가(신설강좌경우 무료수강권 사용 불가(2011.04.18)
                    && !actionobj.isFlag6() && actionobj.isFlag7()) {
                String freeUseInsert = ac_dao.freeUseInsert(actionobj);
                System.out.println("freeUseInsert out--------------------> "+ freeUseInsert);
                if (freeUseInsert != "SUCCESS") { // 연속수강자 수강 할인권 사용 저장 에러
                    result = "연속수강자 수강 할인권 사용 저장시 에러가 발생하였습니다.";
                    return rlt;
                }
            }

            // 8. 결제 메일발송 내역 저장
            String EmailInsert = ac_dao.EmailInsert(actionobj);
            System.out.println("EmailInsert <<<<<<<<<< 결제 >>>>>>>>>>>>>>> fall이면 out--------------------> " + EmailInsert);
            if (EmailInsert != "SUCCESS") { // 연속수강자 수강 할인권 사용 저장 에러
                result = "결제 메일발송 내역  저장시 에러가 발생하였습니다.";
                return rlt;
            }

//            System.out.println("sResult ------------------------> "+ giftProcessRslt);
            return giftProcessRslt;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	public String setLectCalc_half(LectureVo actionobj) throws Exception {
        try {

            String result = "";
            String rlt = "N"; // 결제실패시 return값            
            
            
            // 4.승인처리 및 매출임시테이블 저장
            String settleProcessRslt = ac_dao.settleProcess_half(actionobj);
            System.out.println("settleProcessRslt1 fall이면 out--------------------> "+ settleProcessRslt);
            if(settleProcessRslt.equals("Wrong Card")){
            	return "결제하신 카드 정보가 맞는지 확인 후 다시 시도해 주세요\\nAK신한카드일 경우 [AK신한카드],AKKB국민카드일 경우 [AKKB국민카드], 일반 신한카드,국민카드일 경우 [일반카드]를 선택하셔야 합니다.";
            	
            } else if (!settleProcessRslt.equals("success")) { // 승인처리 및 매출임시테이블 저장 실패
                result = settleProcessRslt;
                return rlt;
            } else if (settleProcessRslt.equals("success")) { // 승인처리 및 매출임시테이블 저장 실패
                result = "Y";
            }
            

            // 5.사은품
//            String giftProcessRslt = ac_dao.giftProcess(actionobj);
//            System.out.println("giftProcessRslt fall이면 out--------------------> "+ giftProcessRslt);
//            if (giftProcessRslt.equals("fail")) { // 사은품 처리 실패
//                result = giftProcessRslt;
//                return rlt;
//            }
            
         
            return result;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	@RequestMapping("/getSubjectTax")
	@ResponseBody
	public List<HashMap<String, Object>> getSubjectTax(HttpServletRequest request) {
		
		String year = Utils.checkNullString(request.getParameter("year"));
		String season = Utils.checkNullString(request.getParameter("season"));
		String branch = Utils.checkNullString(request.getParameter("branch"));
		HttpSession session = request.getSession();
		String login_cus = Utils.checkNullString(session.getAttribute("login_cus"));
		branch = branch.substring(0, branch.length()-1);
		
		String web_text = year + "년도 "+season;
		
		
		
		List<HashMap<String, Object>> list = ac_dao.getSubjectTax(branch, web_text, login_cus);
		
		return list;
	}
	@RequestMapping("/getSubjectCert")
	@ResponseBody
	public List<HashMap<String, Object>> getSubjectCert(HttpServletRequest request) {
		
		String start_ymd = Utils.checkNullString(request.getParameter("start_ymd")).replaceAll("-", "");
		String end_ymd = Utils.checkNullString(request.getParameter("end_ymd")).replaceAll("-", "");
		String branch = Utils.checkNullString(request.getParameter("branch"));
		HttpSession session = request.getSession();
		String login_cus = Utils.checkNullString(session.getAttribute("login_cus"));
		branch = branch.substring(0, branch.length()-1);
		
		
		
		List<HashMap<String, Object>> list = ac_dao.getSubjectCert(branch, start_ymd, end_ymd, login_cus);
		
		return list;
	}
	@RequestMapping("/viewTax")
	public ModelAndView viewTax(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/viewTax");
		
		String cv = Utils.checkNullString(request.getParameter("cv"));
		HttpSession session = request.getSession();
		String login_cus = Utils.checkNullString(session.getAttribute("login_cus"));
		
		HashMap<String, Object> data = ac_dao.getLecrByCus(login_cus);
		String corp_fg =  Utils.checkNullString(data.get("CORP_FG"));
		String lecturer_cd =  Utils.checkNullString(data.get("LECTURER_CD"));
		String tb = "";
		String cus_address = "";
		String biz_nm = "";
		if("1".equals(corp_fg))
		{
			tb = "co";
		}
		else if("2".equals(corp_fg))
		{
			tb = "pr";
		}
		
		String cvArr[] = cv.split("\\|");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for(int i = 0; i < cvArr.length; i++)
		{
			String store = cvArr[i].split("_")[0];
			String period = cvArr[i].split("_")[1];
			String subject_cd = cvArr[i].split("_")[2];
			
			List<HashMap<String, Object>> jrList = ac_dao.getJr(store, period, subject_cd, lecturer_cd, tb); 
			for(int z = 0; z < jrList.size(); z++)
			{
				list.add(jrList.get(z));
			}
			
		}
		
		mav.addObject("lecturer_nm", Utils.checkNullString(data.get("LECTURER_KOR_NM")));
		mav.addObject("lecturer_cd",lecturer_cd);
		mav.addObject("cus_address",Utils.checkNullString(data.get("PNADD"))+" "+Utils.checkNullString(data.get("DTS_ADDR")));
		mav.addObject("biz_nm",Utils.checkNullString(data.get("BIZ_NM")));
		mav.addObject("biz_no", Utils.checkNullString(data.get("BIZ_NO")));
		mav.addObject("biz_addr_tx",Utils.checkNullString(data.get("BIZ_ADDR")));
		mav.addObject("list",list);
		mav.addObject("y",Utils.getDateNow("year"));
		mav.addObject("m",Utils.getDateNow("month"));
		mav.addObject("d",Utils.getDateNow("day"));
		
		return mav;
	}
	@RequestMapping("/viewCert")
	public ModelAndView viewCert(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/viewCert");
		
		HttpSession session = request.getSession();
		String cv = Utils.checkNullString(request.getParameter("cv"));
		String login_cus = Utils.checkNullString(session.getAttribute("login_cus"));
		
		HashMap<String, Object> data = ac_dao.getLecrByCus(login_cus);
		String lecturer_cd =  Utils.checkNullString(data.get("LECTURER_CD"));
		String lecturer_nm =  Utils.checkNullString(data.get("LECTURER_KOR_NM"));
		String cus_addr = Utils.checkNullString(data.get("PNADD"))+" "+Utils.checkNullString(data.get("DTS_ADDR"));
		
		if(lecturer_cd.length() == 13)
		{
			lecturer_cd = lecturer_cd.substring(0, 6)+"-"+lecturer_cd.substring(6, 13);
		}
		
		String subject_list = "";
		String cvArr[] = cv.split("\\|");
		for(int i = 0; i < cvArr.length; i++)
		{
			String store = cvArr[i].split("_")[0];
			String period = cvArr[i].split("_")[1];
			String subject_cd = cvArr[i].split("_")[2];
			
			if(i != 0)
			{
				subject_list += ", ";
			}
			subject_list += ac_dao.getSubjectNm(store, period, subject_cd);
		}
		mav.addObject("subject_list", subject_list);
		mav.addObject("lecturer_cd", lecturer_cd);
		mav.addObject("lecturer_nm", lecturer_nm);
		mav.addObject("cus_addr", cus_addr);
		
		
		return mav;
	}
	@RequestMapping("/getNewsList")
	@ResponseBody
	public HashMap<String, Object> getNewsList(HttpServletRequest request) {
			
		String search_store = Utils.checkNullString(request.getParameter("search_store"));
		String search_type = Utils.checkNullString(request.getParameter("search_type"));
		String search_name = Utils.checkNullString(request.getParameter("search_name"));
		
		List<HashMap<String, Object>> listCnt = ac_dao.getNewsCount(search_store,search_type,search_name);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int page = 1;
		if(!"".equals(Utils.checkNullString(request.getParameter("page"))))
		{
			page = Integer.parseInt(Utils.checkNullString(request.getParameter("page")));
		}
		int listSize = 20;
		if(!"".equals(Utils.checkNullString(request.getParameter("listSize"))))
		{
			listSize = Integer.parseInt(Utils.checkNullString(request.getParameter("listSize")));
		}
		
		
		int block = 3;
		int pageNum = (int)Math.ceil((double)listCount/listSize);
		int nowBlock = (int)Math.ceil((double)page/block);
		int s_page = (nowBlock * block) - (block-1);
		if (s_page <= 1) 
		{
			s_page = 1;
		}
		int e_page = nowBlock*block;
		if (pageNum <= e_page) {
			e_page = pageNum;
		}
		
		int s_point = (page-1) * listSize;
		
		List<HashMap<String, Object>> list = ac_dao.getNewsList(s_point, listSize*page, search_store,search_type,search_name); 
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		map.put("list", list);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		
		return map;
	}
	
	
	@RequestMapping("/getApplyResult")
	@ResponseBody
	public HashMap<String, Object> getApplyResult(HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		
		List<HashMap<String, Object>> listCnt = ac_dao.getApplyResultCount(cust_no);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int page = 1;
		if(!"".equals(Utils.checkNullString(request.getParameter("page"))))
		{
			page = Integer.parseInt(Utils.checkNullString(request.getParameter("page")));
		}
		int listSize = 20;
		if(!"".equals(Utils.checkNullString(request.getParameter("listSize"))))
		{
			listSize = Integer.parseInt(Utils.checkNullString(request.getParameter("listSize")));
		}
		
		
		int block = 3;
		int pageNum = (int)Math.ceil((double)listCount/listSize);
		int nowBlock = (int)Math.ceil((double)page/block);
		int s_page = (nowBlock * block) - (block-1);
		if (s_page <= 1) 
		{
			s_page = 1;
		}
		int e_page = nowBlock*block;
		if (pageNum <= e_page) {
			e_page = pageNum;
		}
		
		int s_point = (page-1) * listSize;
		
		List<HashMap<String, Object>> list = ac_dao.getApplyResult(s_point, listSize*page, cust_no); 
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		map.put("list", list);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		
		return map;
	}
	
	@RequestMapping("/getContractInfo")
	@ResponseBody
	public HashMap<String, Object> getContractInfo(HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		String cus_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String store = Utils.checkNullString(request.getParameter("store"));
		String start_ymd = Utils.checkNullString(request.getParameter("start_ymd"));
		String end_ymd = Utils.checkNullString(request.getParameter("end_ymd"));
		
		System.out.println("store : "+store);
		System.out.println("start_ymd : "+start_ymd);
		System.out.println("end_ymd : "+end_ymd);
		
		List<HashMap<String, Object>> listCnt = ac_dao.getContractInfoCount(cus_no,store,start_ymd,end_ymd);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int page = 1;
		if(!"".equals(Utils.checkNullString(request.getParameter("page"))))
		{
			page = Integer.parseInt(Utils.checkNullString(request.getParameter("page")));
		}
		int listSize = 20;
		if(!"".equals(Utils.checkNullString(request.getParameter("listSize"))))
		{
			listSize = Integer.parseInt(Utils.checkNullString(request.getParameter("listSize")));
		}
		
		
		int block = 3;
		int pageNum = (int)Math.ceil((double)listCount/listSize);
		int nowBlock = (int)Math.ceil((double)page/block);
		int s_page = (nowBlock * block) - (block-1);
		if (s_page <= 1) 
		{
			s_page = 1;
		}
		int e_page = nowBlock*block;
		if (pageNum <= e_page) {
			e_page = pageNum;
		}
		
		int s_point = (page-1) * listSize;
		
		List<HashMap<String, Object>> list = ac_dao.getContractInfo(s_point, listSize*page, cus_no,store,start_ymd,end_ymd); 
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		map.put("list", list);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		
		return map;
	}
	
	@RequestMapping("/confirm")
	@ResponseBody
	public HashMap<String, Object> confirm(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String cus_no = Utils.checkNullString(session.getAttribute("login_cus"));
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(request.getParameter("period"));
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		String info_yn = Utils.checkNullString(request.getParameter("info_yn"));
		String naver_yn = Utils.checkNullString(request.getParameter("naver_yn"));
		if (naver_yn.equals("")) {
			naver_yn ="N";
		}
		
		int result = ac_dao.confirm(store,period,cus_no,subject_cd,naver_yn,info_yn);
		String msg="";
		if (result>0) {
			msg="저장되었습니다.";
		}else {
			msg="관리자에게 문의해주세요";
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("msg", msg);
		
		return map;
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
		
		return map;
	}

	

	@RequestMapping("/getLectList")
	@ResponseBody
	public HashMap<String, Object> getLectList(HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		String cus_no = Utils.checkNullString(session.getAttribute("login_cus"));
		
		
		String store = Utils.checkNullString(request.getParameter("store"));
		
		List<HashMap<String, Object>> listCnt = ac_dao.getLectListCount(cus_no,store);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int page = 1;
		if(!"".equals(Utils.checkNullString(request.getParameter("page"))))
		{
			page = Integer.parseInt(Utils.checkNullString(request.getParameter("page")));
		}
		int listSize = 20;
		if(!"".equals(Utils.checkNullString(request.getParameter("listSize"))))
		{
			listSize = Integer.parseInt(Utils.checkNullString(request.getParameter("listSize")));
		}
		
		
		int block = 5;
		int pageNum = (int)Math.ceil((double)listCount/listSize);
		int nowBlock = (int)Math.ceil((double)page/block);
		int s_page = (nowBlock * block) - (block-1);
		if (s_page <= 1) 
		{
			s_page = 1;
		}
		int e_page = nowBlock*block;
		if (pageNum <= e_page) {
			e_page = pageNum;
		}
		
		int s_point = (page-1) * listSize;
		
		List<HashMap<String, Object>> list = ac_dao.getLectList(s_point, listSize*page, cus_no,store); 
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		map.put("list", list);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		
		return map;
	}
	
	
	@RequestMapping("/getAttendList")
	@ResponseBody
	public HashMap<String, Object> getAttendList(HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		String cus_no = Utils.checkNullString(session.getAttribute("login_cus"));
		
		
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(request.getParameter("period"));
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		
		List<HashMap<String, Object>> listCnt = ac_dao.getAttendListCount(store,period,subject_cd);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int page = 1;
		if(!"".equals(Utils.checkNullString(request.getParameter("page"))))
		{
			page = Integer.parseInt(Utils.checkNullString(request.getParameter("page")));
		}
		int listSize = 20;
		if(!"".equals(Utils.checkNullString(request.getParameter("listSize"))))
		{
			listSize = Integer.parseInt(Utils.checkNullString(request.getParameter("listSize")));
		}
		
		
		int block = 3;
		int pageNum = (int)Math.ceil((double)listCount/listSize);
		int nowBlock = (int)Math.ceil((double)page/block);
		int s_page = (nowBlock * block) - (block-1);
		if (s_page <= 1) 
		{
			s_page = 1;
		}
		int e_page = nowBlock*block;
		if (pageNum <= e_page) {
			e_page = pageNum;
		}
		
		int s_point = (page-1) * listSize;
		
		List<HashMap<String, Object>> list = ac_dao.getAttendList(s_point, listSize*page,store,period,subject_cd); 
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		map.put("list", list);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		
		return map;
	}
	
	@RequestMapping("/print_proc")
	public ModelAndView print_proc(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("/WEB-INF/pages/web/academy/print_proc");
		
		mav.addObject("result",  Utils.checkNullString(request.getParameter("result")));
		mav.addObject("day_value",  Utils.checkNullString(request.getParameter("day_value")));
		return mav;
	}
	
	@RequestMapping("/uptAttendList")
	@ResponseBody
	public HashMap<String, Object> uptAttendList(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		//String cust_no = session.getAttribute("login_seq").toString();
		
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(request.getParameter("period"));
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		String custList[] = Utils.checkNullString(request.getParameter("custList")).split("\\|");
		String chklist[] = Utils.checkNullString(request.getParameter("chklist")).split("@");
		String contentList[] = Utils.checkNullString(request.getParameter("contentList")).split("\\|");
		
		System.out.println("custList.length : "+custList.length);
		for (int i = 0; i < custList.length; i++) {
			/*
			System.out.println("custlist : "+custList[i]);
			System.out.println("chklist : "+chklist[i]);
			System.out.println("contentList : "+contentList[i]);
			*/
			try {
				ac_dao.uptAttendList(store,period,subject_cd,custList[i],chklist[i],contentList[i]);				
			} catch (Exception e) {
				System.out.println("error : "+e);
				ac_dao.uptAttendList(store,period,subject_cd,custList[i],chklist[i],"");	
			}
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("msg", "저장되었습니다.");
		
		return map;
	}
	
	@RequestMapping("/getReview")
	@ResponseBody
	public HashMap<String, Object> getReview(HttpServletRequest request) {
				
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(request.getParameter("period"));
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		String cust_no = Utils.checkNullString(request.getParameter("cust_no"));

		//HashMap<String, Object> data = ac_dao.getLecrByCus(login_cus);
		HashMap<String, Object> data = ac_dao.getReview(store,period,subject_cd,cust_no);
		
		return data;
	}
	
	@RequestMapping("/uptReview")
	@ResponseBody
	public HashMap<String, Object> uptReview(HttpServletRequest request) {
		
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(request.getParameter("period"));
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		String cust_no = Utils.checkNullString(request.getParameter("cust_no"));
		String reco_yn = Utils.checkNullString(request.getParameter("reco_yn"));
		String content = Utils.checkNullString(request.getParameter("content"));
		
		HashMap<String, Object> data = ac_dao.getReview(store,period,subject_cd,cust_no);

		int result = 0;
		if(data != null)
		{
			result = ac_dao.uptReview(store,period,subject_cd,cust_no,reco_yn,content);
		}
		else
		{
			result = ac_dao.insReview(store,period,subject_cd,cust_no,reco_yn,content);
		}
		String msg="";
		if (result>0) {
			msg="저장되었습니다.";
		}else {
			msg="관리자에게 문의해주세요";
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("msg", msg);
		
		return map;
	}
	
	@RequestMapping("/delReview")
	@ResponseBody
	public HashMap<String, Object> delReview(HttpServletRequest request) {
		
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(request.getParameter("period"));
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		String cust_no = Utils.checkNullString(request.getParameter("cust_no"));
		String reco_yn = Utils.checkNullString(request.getParameter("reco_yn"));
		String content = Utils.repWord(Utils.checkNullString(request.getParameter("content")));

		int result = ac_dao.delReview(store,period,subject_cd,cust_no);
		String msg="";
		if (result>0) {
			msg="저장되었습니다.";
		}else {
			msg="관리자에게 문의해주세요";
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("msg", msg);
		
		return map;
	}
	@RequestMapping("/getRecoList")
	@ResponseBody
	public HashMap<String, Object> getRecoList(HttpServletRequest request) {
			
		String tag = Utils.checkNullString(request.getParameter("tag"));
		
		List<HashMap<String, Object>> listCnt = ac_dao.getRecoCount(tag);
		int listCount = Utils.checkNullInt(listCnt.get(0).get("CNT"));
		int page = 1;
		if(!"".equals(Utils.checkNullString(request.getParameter("page"))))
		{
			page = Integer.parseInt(Utils.checkNullString(request.getParameter("page")));
		}
		int listSize = 20;
		if(!"".equals(Utils.checkNullString(request.getParameter("listSize"))))
		{
			listSize = Integer.parseInt(Utils.checkNullString(request.getParameter("listSize")));
		}
		
		
		int block = 3;
		int pageNum = (int)Math.ceil((double)listCount/listSize);
		int nowBlock = (int)Math.ceil((double)page/block);
		int s_page = (nowBlock * block) - (block-1);
		if (s_page <= 1) 
		{
			s_page = 1;
		}
		int e_page = nowBlock*block;
		if (pageNum <= e_page) {
			e_page = pageNum;
		}
		
		int s_point = (page-1) * listSize;
		
		List<HashMap<String, Object>> list = ac_dao.getRecoList(s_point, listSize*page, tag); 
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		map.put("list", list);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		
		return map;
	}
	
	@RequestMapping("/getSeason")
	@ResponseBody
	public HashMap<String, Object> getSeason(HttpServletRequest request) {
		
		String store = Utils.checkNullString(request.getParameter("store"));
		List<HashMap<String, Object>> list = ac_dao.getSeason(store);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", list);

		
		return map;
	}
	
	@RequestMapping("/delChild")
	@ResponseBody
	public HashMap<String, Object> delChild(HttpServletRequest request) {	
		HashMap<String, Object> map = new HashMap<>();
		
		String cust_no = Utils.checkNullString(request.getParameter("cust_no"));
		String child_no = Utils.checkNullString(request.getParameter("child_no"));
		
		
		int result = ac_dao.delChild(cust_no, child_no); 
		if (result > 0) {			
			map.put("msg", "저장되었습니다.");
		}else {
			map.put("msg", "관리자에게 문의해주세요.");
		}
	    return map;
	}
	
	@RequestMapping("/print_contract")
	public ModelAndView print_contract(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("/WEB-INF/pages/web/academy/print_contract");
		mav.addObject("result",  Utils.checkNullString(request.getParameter("result")));
		return mav;
	}

	@RequestMapping("/academy07")
	public ModelAndView academy07(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/academy/academy07");
		
		return mav;
	}
}