package ak_web.controller.web;

import java.io.IOException;
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

import ak_web.classes.HttpUtils;
import ak_web.classes.Utils;
import ak_web.model.web.CommonDAO;
import ak_web.model.web.CourseDAO;
import ak_web.model.web.MainDAO;
import nets.websso.ssoclient.authcheck.SSOConfig;
import oracle.sql.BLOB;
@Controller
@RequestMapping("/course/*")
public class CourseController {
	
	@Autowired
	private CourseDAO course_dao;
	
	@Value("${image_dir}")
	private String image_dir;
	
	@Autowired
	private CommonDAO common_dao;
	
	@Autowired
	private MainDAO main_dao;
	
//	@RequestMapping({"/", "/course01"})
	@RequestMapping("/course01")
	public ModelAndView course01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/course/course01");
		
		return mav;
	}
	
	@RequestMapping("/course02")
	public ModelAndView course02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/course/course02");
		
		return mav;
	}
	
	@RequestMapping("/course03")
	public ModelAndView course03(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/course/course03");
		
		return mav;
	}
	
	@RequestMapping("/course04")
	public ModelAndView course04(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/course/course04");
		
		return mav;
	}
	
	@RequestMapping("/course05")
	public ModelAndView course05(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/course//course05");
		
		return mav;
	}
	
	@RequestMapping("/course06")
	public ModelAndView course06(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/course/course06");
		
		return mav;
	}
	
	@RequestMapping("/list01")
	public ModelAndView list01(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/course/list01");
		Utils.setSearchVal(mav, main_dao);
		
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String cust_store = Utils.checkNullString(session.getAttribute("login_store"));
		
		
		String search_store = Utils.checkNullString(request.getParameter("search_store"));
		String search_main_cd = Utils.checkNullString(request.getParameter("main_target"));
		String selSect = Utils.checkNullString(request.getParameter("selSect"));
		String month_no = Utils.checkNullString(request.getParameter("month_no"));
		String search_val = Utils.checkNullString(request.getParameter("search_val"));
		
		String subject_fg_1 = Utils.checkNullString(request.getParameter("subject_fg_1"));
		String subject_fg_2 = Utils.checkNullString(request.getParameter("subject_fg_2"));
		String subject_fg_3 = Utils.checkNullString(request.getParameter("subject_fg_3"));
		
		
		String subject_fg = "";
		
		if("on".equals(Utils.checkNullString(request.getParameter("subject_fg_1"))))
		{
			if(!"".equals(subject_fg))
			{
				subject_fg += ",";
			}
			subject_fg += "1";
			
		}
		if("on".equals(Utils.checkNullString(request.getParameter("subject_fg_2"))))
		{
			if(!"".equals(subject_fg))
			{
				subject_fg += ",";
			}
			subject_fg += "2";
			
		}
		if("on".equals(Utils.checkNullString(request.getParameter("subject_fg_3"))))
		{
			if(!"".equals(subject_fg))
			{
				subject_fg += ",";
			}
			subject_fg += "3";
		}
		
		String mon = "0";
		String tue = "0";
		String wed = "0";
		String thu = "0";
		String fri = "0";
		String sat = "0";
		String sun = "0";
		
		String day_flag = "";
		if("on".equals(Utils.checkNullString(request.getParameter("yoil_mon"))))
		{
			mon = "1";
		}
		if("on".equals(Utils.checkNullString(request.getParameter("yoil_tue"))))
		{
			tue = "1";
		}
		if("on".equals(Utils.checkNullString(request.getParameter("yoil_wed"))))
		{
			wed = "1";
		}
		if("on".equals(Utils.checkNullString(request.getParameter("yoil_thu"))))
		{
			thu = "1";
		}
		if("on".equals(Utils.checkNullString(request.getParameter("yoil_fri"))))
		{
			fri = "1";
		}
		if("on".equals(Utils.checkNullString(request.getParameter("yoil_sat"))))
		{
			sat = "1";
		}
		if("on".equals(Utils.checkNullString(request.getParameter("yoil_sun"))))
		{
			sun = "1";
		}
		day_flag = mon+""+tue+""+wed+""+thu+""+fri+""+sat+""+sun;
		
		String requestPathParam = "/course/list01" + (cust_no==null || cust_no.equals("") ? "" : "?store="+cust_store+""); // /cult/main.do?method=list&number=01 형태의 정보(2016.03.03)
		
		System.out.println("test********************");
		System.out.println(requestPathParam);
		System.out.println("test********************");
		
		String getPageUrl = HttpUtils.getPageUrl(request, requestPathParam, "SB");
		
		mav.addObject("search_store", search_store);
		mav.addObject("subject_fg", subject_fg);
		mav.addObject("search_main_cd", search_main_cd);
		mav.addObject("selSect", selSect);
		mav.addObject("day_flag", day_flag);
		//search_monthVal
		mav.addObject("month_no", month_no);
		mav.addObject("search_val", search_val);
		mav.addObject("pageUrlFlag", getPageUrl);
		return mav;
	}
	
	@RequestMapping("/list02")
	public ModelAndView list02(HttpServletRequest request) throws Exception  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/course/list02");
		Utils.setSearchVal(mav, main_dao);
		
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String cust_store = Utils.checkNullString(session.getAttribute("login_store"));
		
		
		String search_store = Utils.checkNullString(request.getParameter("search_store"));
		String search_main_cd = Utils.checkNullString(request.getParameter("main_target"));
		String search_sect_cd = Utils.checkNullString(request.getParameter("sub_target"));
		String search_yoil = Utils.checkNullString(request.getParameter("search_yoil"));
		String month_no = Utils.checkNullString(request.getParameter("month_no"));
		String search_val = Utils.checkNullString(request.getParameter("search_val"));
		
		List<HashMap<String, Object>> list = course_dao.test(); 
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println("강좌명 : "+list.get(i).get("SUBJECT_NM"));
		}
		String requestPathParam = "/course/list01" + (cust_no==null || cust_no.equals("") ? "" : "?store="+cust_store+""); // /cult/main.do?method=list&number=01 형태의 정보(2016.03.03)
		
		System.out.println("test********************");
		System.out.println(requestPathParam);
		System.out.println("test********************");
		
		String getPageUrl = HttpUtils.getPageUrl(request, requestPathParam, "SB");
		
		mav.addObject("search_store", search_store);
		mav.addObject("search_main_cd", search_main_cd);
		mav.addObject("search_sect_cd", search_sect_cd);
		mav.addObject("search_yoil", search_yoil);
		//search_monthVal
		mav.addObject("month_no", month_no);
		mav.addObject("search_val", search_val);
		mav.addObject("pageUrlFlag", getPageUrl);
		return mav;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/WEB-INF/pages/web/course/detail");
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(common_dao.retrievePeriod(store).get("PERIOD")); //현재 화성화된 기수 
		String subject_cd = Utils.checkNullString(request.getParameter("sSubject_cd"));
		//String main_cd = Utils.checkNullString(request.getParameter("main_cd"));
		//String sSect_cd = Utils.checkNullString(request.getParameter("sSect_cd"));
		//String sSect_nm = Utils.checkNullString(request.getParameter("sSect_nm"));
		
		
		//List<HashMap<String, Object>> list = course_dao.retrieveListLecture(store,period,main_cd);
		HashMap<String, Object> lecture = course_dao.retrieveLecture(store, period,subject_cd);

		System.out.println("CourseController.java >>>>>>>>>>>>>>>>>>>>>>> tempAlter() START <<<<<<<<<<<<<<<<<<<<<<<<");
		course_dao.tempAlter();
		System.out.println("CourseController.java >>>>>>>>>>>>>>>>>>>>>>> tempAlter() END <<<<<<<<<<<<<<<<<<<<<<<<<");
		
		
		BLOB blob = course_dao.lecturePhoto(store,subject_cd); //강사사진 조회
		
		String requestPathParam = "/course/detail" + (request.getQueryString()==null || request.getQueryString().equals("") ? "" : "?"+request.getQueryString()); // /cult/main.do?method=list&number=01 형태의 정보(2016.03.03)
		//System.out.println("test********************");
		//System.out.println(requestPathParam);
		//System.out.println("test********************");
		
		String getPageUrl = HttpUtils.getPageUrl(request, requestPathParam, "SB");
		
		
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		
		int chk = course_dao.courseChk(store,period,subject_cd,cust_no);
		System.out.println("chk test***");
		System.out.println(chk);
		//mav.addObject("list", list);
		mav.addObject("listenOK", chk);
		mav.addObject("lecture", lecture);
		mav.addObject("lecturePhoto", blob);
		mav.addObject("pageUrlFlag", getPageUrl);
		mav.addObject("image_dir", image_dir);
		
		//취소환불규
		String contents = course_dao.getCanc();
		
		mav.addObject("canc_contents", contents);
		//취소환불규정
		
		return mav;
	}
	
	/*
	@RequestMapping("/toMyBookSelf")
	public ModelAndView toMyBookSelf(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/course/isChk");
		String idx = Utils.checkNullString(request.getParameter("idx"));
		String arr[] = idx.split("_");
	
		String store = arr[0];
		String period = arr[1];
		String subject_cd = arr[2];
		
		HttpSession session = request.getSession();
		String cust_no = session.getAttribute("login_seq").toString();
		
		String msg;
		
		HashMap<String, Object> chk_bookshelf = course_dao.chk_bookshelf(store, period, subject_cd, cust_no);
		
		if (chk_bookshelf.get("CNT").toString().equals("0")) {
			mav.addObject("msg", "정상 처리 되었습니다.");
			course_dao.ins_bookshelf(store, period, subject_cd, cust_no);			
		}else {
			mav.addObject("msg", "이미 처리된 강좌입니다.");
		}
		
		return mav;
	}
	*/
	
	@RequestMapping("/toMyBookSelf")
	public ModelAndView toMyBookSelf(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/course/isChk");
		String idx = Utils.checkNullString(request.getParameter("idx"));
		String arr[] = idx.split("_");
	
		String store = arr[0];
		String period = arr[1];
		String subject_cd = arr[2];
		
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String user_id = Utils.checkNullString(session.getAttribute("login_id"));
		
		
		String result="FAIL";
		//결제취소 확인
		List<HashMap<String, Object>> chk_cancel = course_dao.chk_cancel(store, period, subject_cd, cust_no);
		if (!chk_cancel.isEmpty()) {
			result = "ENDDUP";
			mav.addObject("msg", result);
			return mav;
		}
		
		// 접속한 SESSION ID와 현재 장바구니에 존재하는 SESSION ID가 다른 경우.. 장바구니에 있는 상품 모두 삭제
		List<HashMap<String, Object>> chk_session_id = course_dao.chk_session_id(store,cust_no,user_id);
		if (!chk_session_id.isEmpty() && Utils.checkNullInt(chk_session_id.get(0).get("CNT")) >0) {
		//	temp_clear(store, period, subject_cd, cust_no);
		}
		
		
		mav.addObject("msg", result);
		return mav;
	}
	
	
	
	//public void temp_clear(String store,String period, String subject_cd, String cust_no)  {
		//List<HashMap<String, Object>> get_list = course_dao.get_clear_list(store,cust_no,user_id);
	//}
	
	
	@RequestMapping("/getPeltList")
	@ResponseBody
	public HashMap<String, Object> getPeltList(HttpServletRequest request) {
		
		System.out.println("여기 왜 안타지");
		
		String sort_type = Utils.checkNullString(request.getParameter("sort_type"));
		if (sort_type.equals("")) {
			sort_type="reco_cnt";
		}

		String search_name = Utils.checkNullString(request.getParameter("search_name"));
		
		String store  = Utils.checkNullString(request.getParameter("store"));
		String main_cd  = Utils.checkNullString(request.getParameter("main_cd"));
		String sect_cd  = Utils.checkNullString(request.getParameter("sect_cd"));
		String yoil  = Utils.checkNullString(request.getParameter("yoil"));
		String subject_fg  = Utils.checkNullString(request.getParameter("subject_fg"));
		String month_val  = Utils.checkNullString(request.getParameter("month_val"));
		
		if (store.equals("")) {
			store="03";
		}
		System.out.println("yoil : "+yoil);
		System.out.println("subject_fg : "+subject_fg);
		String period = Utils.checkNullString(common_dao.retrievePeriod(store).get("PERIOD")); //현재 화성화된 기수 
		
		List<HashMap<String, Object>> listCnt = course_dao.getPeltCount(store,period,month_val,yoil,search_name,main_cd,sect_cd,subject_fg);
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
		
		List<HashMap<String, Object>> list = course_dao.getPelt(s_point, listSize*page, sort_type,
																store,period,month_val,yoil,search_name,main_cd,sect_cd,subject_fg); 
		
		HashMap<String, Object> enterPeriod = new HashMap<>();
		enterPeriod = Utils.enterPeriod(common_dao,store);
		
        //okWebReceiptEnd
        //okWebReceipt
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		
		map.put("list", list);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		map.put("sort_type", sort_type);
		map.put("okWebReceiptEnd", enterPeriod.get("okWebReceiptEnd"));
		map.put("okWebReceipt", enterPeriod.get("okWebReceipt"));
		map.put("sCurrentDate", enterPeriod.get("sCurrentDate"));
		map.put("image_dir", image_dir);
		
		return map;
	}
	
	@RequestMapping("/getReviewList")
	@ResponseBody
	public HashMap<String, Object> getReviewList(HttpServletRequest request) {
		

		
		String store  = Utils.checkNullString(request.getParameter("store"));
		String period  = Utils.checkNullString(request.getParameter("period"));
		//String period = common_dao.retrievePeriod(store).get("PERIOD").toString(); //현재 화성화된 기수 
		String subject_cd  = Utils.checkNullString(request.getParameter("subject_cd"));
		
		System.out.println(store);
		System.out.println(period);
		System.out.println(subject_cd);
	
		
		
		List<HashMap<String, Object>> listCnt = course_dao.getReviewCount(store,period,subject_cd);
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
		
		List<HashMap<String, Object>> list = course_dao.getReview(s_point, listSize*page,store,period,subject_cd); 
		
		
        //okWebReceiptEnd
        //okWebReceipt
		HashMap<String, Object> map = new HashMap<>();
		map.put("listCnt", listCnt.get(0).get("CNT"));
		
		map.put("list", list);
		map.put("page", page);
		map.put("s_page", s_page);
		map.put("e_page", e_page);
		map.put("pageNum", pageNum);
		
		return map;
	}
	@RequestMapping("/upReviewViews")
	@ResponseBody
	public void upReviewViews(HttpServletRequest request) {
		
		try
		{
			String store  = Utils.checkNullString(request.getParameter("store"));
			String period  = Utils.checkNullString(request.getParameter("period"));
			String subject_cd  = Utils.checkNullString(request.getParameter("subject_cd"));
			String cust_no  = Utils.checkNullString(request.getParameter("cust_no"));
			course_dao.upReviewViews(store,period,subject_cd,cust_no);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getMain")
	@ResponseBody
	public HashMap<String, Object> getMain(HttpServletRequest request) {
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("/WEB-INF/pages/basic/gift/listed");
		//Utils.setPeriController(mav, common_dao);
		
		
		String store = Utils.checkNullString(request.getParameter("store"));
		List<HashMap<String, Object>> mainlist = main_dao.get1Depth();

		HashMap<String, Object> map = new HashMap<>();
		map.put("mainlist", mainlist);

		return map;
	}
	
	@RequestMapping("/getSect")
	@ResponseBody
	public HashMap<String, Object> getSect(HttpServletRequest request) {
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("/WEB-INF/pages/basic/gift/listed");
		//Utils.setPeriController(mav, common_dao);
		
		
		String sub_code = Utils.checkNullString(request.getParameter("sub_code"));

		
		List<HashMap<String, Object>> sectlist = course_dao.getSecCd(sub_code);
			
		HashMap<String, Object> map = new HashMap<>();
		map.put("sectlist", sectlist);

		return map;
	}
	
	@RequestMapping("/goBookBag")
	@ResponseBody
	public HashMap<String, Object> goBookBag(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		
		
		HttpSession session = request.getSession();
		
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String cust_nm = Utils.checkNullString(session.getAttribute("login_name"));
		String cust_id = Utils.checkNullString(session.getAttribute("login_id"));
		String cust_store = Utils.checkNullString(session.getAttribute("login_store"));
		String birthymd = Utils.checkNullString(session.getAttribute("birthymd"));
		String sSAgeGubun = Utils.checkNullString(session.getAttribute("sSAgeGubun"));
		
		//String period = Utils.checkNullString(request.getParameter("period"));
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(common_dao.retrievePeriod(store).get("PERIOD")); //현재 화성화된 기수 
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		String main_cd = Utils.checkNullString(request.getParameter("main_cd"));
		String sect_cd = Utils.checkNullString(request.getParameter("sect_cd"));
		String child1_no = Utils.checkNullString(request.getParameter("child1_no"));
		String child2_no = Utils.checkNullString(request.getParameter("child2_no"));
		String child3_no = Utils.checkNullString(request.getParameter("child3_no"));
		String p_cust = "";
		String c_cust1 = "";
		String c_cust2 = "";
		
		System.out.println("child1_no : "+child1_no);
		if("0".equals(child1_no))
		{
			p_cust = cust_no;
			c_cust1 = child2_no;
			c_cust2 = child3_no;
		}
		else
		{
			c_cust1 = child1_no;
			c_cust2 = child2_no;
		}
		//String sect_nm = Utils.checkNullString(request.getParameter("sect_nm"));
		String Lecttempfg ="N";
		
		String ajaxResultCd="";
		
		String sResult ="";
		String rMessage = "";
		
		HashMap<String, Object> enterPeriod = new HashMap<>();
		enterPeriod = Utils.enterPeriod(common_dao,store);
		//List<HashMap<String, Object>> LectReceiptDayList=null;
		
		
		
		if (!cust_no.equals("")) { //로그인 세션이 있다면	
			if (cust_nm.equals("") || cust_no.equals("")) {
				ajaxResultCd="01";
				System.out.println(">>>>>>>>>>>tempadd error 01");
			}else if(!cust_store.equals(store)){
				ajaxResultCd="02";
				System.out.println(">>>>>>>>>>>tempadd error 02");
			}else {
				
				System.out.println("Boolean.valueOf((boolean)enterPeriod.get(\"okWebReceiptAdultF\")) : "+Boolean.valueOf((boolean)enterPeriod.get("okWebReceiptAdultF")));
				System.out.println("session.getAttribute(\"isNew\").toString() : "+Utils.checkNullString(session.getAttribute("isNew")));
				
				if (Boolean.valueOf((boolean)enterPeriod.get("okWebReceipt")) == false){ // 수강신청기간이 아닌경우 
					System.out.println(">>>>>>>>>>>tempadd error 11");
					ajaxResultCd="11";
				}
				else if (Boolean.valueOf((boolean)enterPeriod.get("okWebReceiptAdultS")) == false){  //기존회원
					ajaxResultCd="11";
					map.put("sAdult_s_bgndate", Utils.checkNullString(enterPeriod.get("sAdult_s_bgndate")));
					System.out.println(">>>>>>>>>>>tempadd error 11");
				}
				else if (Boolean.valueOf((boolean)enterPeriod.get("okWebReceiptAdultF")) == false  && "Y".equals(Utils.checkNullString(session.getAttribute("isNew")))){  //신규회원
					ajaxResultCd="12";
					map.put("sAdult_f_bgndate", Utils.checkNullString(enterPeriod.get("sAdult_f_bgndate")));
					System.out.println(">>>>>>>>>>>tempadd error 12");
				}
//				else if ((main_cd.equals("2")||main_cd.equals("3") || main_cd.equals("4") || main_cd.equals("7")|| main_cd.equals("8")) && sSAgeGubun.equals("A")){
//					
//		        	ajaxResultCd="13";
//		        	System.out.println(">>>>>>>>>>>tempadd error 13");
//		        	// 성인은 유아/아동 강좌 신청이 불가능합니다.
//				}
				else if (main_cd.equals("1") && sSAgeGubun.equals("C")){
		        	ajaxResultCd="14";
		        	System.out.println(">>>>>>>>>>>tempadd error 14");
				}else {
					
					sResult = tempAdd(store,period,cust_no,subject_cd,cust_id,"0",p_cust,c_cust1,c_cust2);
					
				    if (sResult.equals("ENDDUP")){
				    	ajaxResultCd="21";
				        //rMessage = "이미 결재완료된 강좌입니다.";
				    }else if(sResult.equals("TMPDUP")){
				    	ajaxResultCd="22";
				        //rMessage = "이미 책가방에 담긴 강좌입니다.";
				    }else if(sResult.equals("EXNO")){
				    	ajaxResultCd="23";
				        //rMessage = "정원이 마감된 강좌입니다.";
				    }else if(sResult.equals("FAIL")){
				    	ajaxResultCd="24";
				        //rMessage = "책가방 담기에 실패하였습니다.";
				    }
				    else
				    {
				    	ajaxResultCd=sResult;
				    }
					
				}
			}
			map.put("ajaxResultCd", "OK::"+ajaxResultCd+"::");
		}else {
			map.put("ajaxResultCd", "FAIL::"+ajaxResultCd+"::");
		}
		System.out.println(enterPeriod.get("okWebReceipt"));
		System.out.println(">>>>>>>>>>>common_ajax_euckr.jsp_tempadd end");
		
		
		//map.put("list", LectReceiptDayList);
		
		return map;
	}
	@RequestMapping("/changeStudent")
	@ResponseBody
	public HashMap<String, Object> changeStudent(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		
		
		HttpSession session = request.getSession();
		
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String cust_nm = Utils.checkNullString(session.getAttribute("login_name"));
		String cust_id = Utils.checkNullString(session.getAttribute("login_id"));
		String cust_store = Utils.checkNullString(session.getAttribute("login_store"));
		String birthymd = Utils.checkNullString(session.getAttribute("birthymd"));
		String sSAgeGubun = Utils.checkNullString(session.getAttribute("sSAgeGubun"));
		
		//String period = Utils.checkNullString(request.getParameter("period"));
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(common_dao.retrievePeriod(store).get("PERIOD")); //현재 화성화된 기수 
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		String main_cd = Utils.checkNullString(request.getParameter("main_cd"));
		String sect_cd = Utils.checkNullString(request.getParameter("sect_cd"));
		String child1_no = Utils.checkNullString(request.getParameter("child1_no"));
		String child2_no = Utils.checkNullString(request.getParameter("child2_no"));
		String child3_no = Utils.checkNullString(request.getParameter("child3_no"));
		String p_cust = "";
		String c_cust1 = "";
		String c_cust2 = "";
		
		System.out.println("child1_no : "+child1_no);
		if("0".equals(child1_no))
		{
			p_cust = cust_no;
			c_cust1 = child2_no;
			c_cust2 = child3_no;
		}
		else
		{
			c_cust1 = child1_no;
			c_cust2 = child2_no;
		}
		try
		{
			int cnt = course_dao.upToTemp("0",cust_no,subject_cd,cust_id,store,p_cust,c_cust1,c_cust2);
			if(cnt > 0)
			{
				map.put("isSuc", "success");
				map.put("msg", "저장되었습니다.");
			}
			else
			{
				map.put("isSuc", "fail");
				map.put("msg", "알 수 없는 오류 발생");
			}
		}
		catch(Exception e)
		{
			map.put("isSuc", "fail");
			map.put("msg", "알 수 없는 오류 발생");
			e.printStackTrace();
		}
		
		
		return map;
	}

	public String tempAdd(String store,String period,String scust_no,String subject_cd,String scust_id, String ipAddress, String p_cust, String c_cust1, String c_cust2){
		String result="FAIL";

		//결제한 강좌인지 체크
		List<HashMap<String, Object>> temp_chklist_1 = course_dao.temp_chklist_1(store, period, scust_no, subject_cd);
		if (!temp_chklist_1.isEmpty()) {
			result = "ENDDUP";
			return result;
		}
		
		
        // 접속한 SESSION ID와 현재 장바구니에 존재하는 SESSION ID가 다른 경우.. 장바구니에 있는 상품 모두
        // 삭제.. 2009.10.19
		List<HashMap<String, Object>> temp_chklist_2 = course_dao.temp_chklist_2(store,scust_no,scust_id);
		if (!temp_chklist_2.isEmpty() && Utils.checkNullInt(temp_chklist_2.get(0).get("CNT")) > 0) {
			tempClear(store,period,scust_no,subject_cd);
		}
		
		
		// 이미 등록한 강좌인지 체크
		List<HashMap<String, Object>> temp_chklist_3 = course_dao.temp_chklist_3(store,scust_no,subject_cd,ipAddress,scust_id);
		if (!temp_chklist_3.isEmpty() && Utils.checkNullInt(temp_chklist_3.get(0).get("CNT")) > 0) {
			result = "TMPDUP";
            return result;
		}
		
		
	     // check regis_no
		System.out.println("test******************************test");
		System.out.println(subject_cd);
		System.out.println("test******************************test");
		
		
		List<HashMap<String, Object>> temp_chklist_4 = course_dao.temp_chklist_4(store,period,subject_cd, true);
		
		
		System.out.println(temp_chklist_4.get(0).get("CAPACITY_NO"));
		System.out.println(temp_chklist_4.get(0).get("REGIS_NO"));
		System.out.println(Utils.checkNullInt(temp_chklist_4.get(0).get("CAPACITY_NO")));
		System.out.println(Utils.checkNullInt(temp_chklist_4.get(0).get("REGIS_NO")));
		
		if (Utils.checkNullInt(temp_chklist_4.get(0).get("CAPACITY_NO")) <= Utils.checkNullInt(temp_chklist_4.get(0).get("REGIS_NO"))) {
			System.out.println("1******************************test");
			result = "EXNO";
            return result;
		}
		
		System.out.println("2******************************test");
		course_dao.addToTemp(ipAddress,scust_no,subject_cd,scust_id,store,p_cust,c_cust1,c_cust2);
		System.out.println("3******************************test");
		course_dao.tempDateUpdate(store,scust_no);
		System.out.println("4******************************test");

		result = "SUCCESS";
		
		
		return result;

	}
	
    /**
     * 책가방 내용 삭제
     * 
     * @param actionobj
     * @return
     * @throws SystemException
     * @throws IOException
     */
    public void tempClear(String store, String period, String cust_no, String subject_cd) {
    	
    	//int getTempList = course_dao.getTempList(store,cust_no);
    }
    
	@RequestMapping("/goWaitAdd")
	@ResponseBody
	public HashMap<String, Object> goWaitAdd(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		
		
		HttpSession session = request.getSession();
		
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String cust_nm = Utils.checkNullString(session.getAttribute("login_name"));
		String cust_id = Utils.checkNullString(session.getAttribute("login_id"));
		String cust_store = Utils.checkNullString(session.getAttribute("login_store"));
		String birthymd = Utils.checkNullString(session.getAttribute("birthymd"));
		String sSAgeGubun = Utils.checkNullString(session.getAttribute("sSAgeGubun"));
		
		//String period = Utils.checkNullString(request.getParameter("period"));
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(common_dao.retrievePeriod(store).get("PERIOD")); //현재 화성화된 기수 
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		String main_cd = Utils.checkNullString(request.getParameter("main_cd"));
		String sect_cd = Utils.checkNullString(request.getParameter("sect_cd"));
		//String sect_nm = Utils.checkNullString(request.getParameter("sect_nm"));
		String Lecttempfg ="N";
		
		String ajaxResultCd="";
		
		String sResult ="";
		String rMessage = "";
		
		
		//결제한 강좌인지 체크
		List<HashMap<String, Object>> temp_chklist_1 = course_dao.temp_chklist_1(store, period, cust_no, subject_cd);
		if (!temp_chklist_1.isEmpty()) {
			sResult = "ENDDUP";
		}
		
		// 이미 등록한 강좌인지 체크
		List<HashMap<String, Object>> temp_chklist_3 = course_dao.temp_chklist_3(store,cust_no,subject_cd,"0",cust_id);
		if (!temp_chklist_3.isEmpty() && Utils.checkNullInt(temp_chklist_3.get(0).get("CNT")) > 0) {
			sResult = "TMPDUP";
		}	
		
		HashMap<String, Object> enterPeriod = new HashMap<>();
		enterPeriod = Utils.enterPeriod(common_dao,store);
		
		
		if (!cust_no.equals("")) { //로그인 세션이 있다면	
			if (cust_nm.equals("") || cust_no.equals("")) {
				ajaxResultCd="01";
				System.out.println(">>>>>>>>>>>tempadd error 01");
			}else if(!cust_store.equals(store)){
				ajaxResultCd="02";
				System.out.println(">>>>>>>>>>>tempadd error 02");
			}else {
				
				
				if (Boolean.valueOf((boolean)enterPeriod.get("okWebReceipt")) == false){ // 수강신청기간이 아닌경우 
					System.out.println(">>>>>>>>>>>tempadd error 11");
					ajaxResultCd="11";
				}else if (Boolean.valueOf((boolean)enterPeriod.get("okWebReceiptChildF")) == false  && Boolean.valueOf((boolean)enterPeriod.get("isPreAttend")) == false){  // 5.6.7세 및 청소년  기존/신규회원 접수 시작일   
					ajaxResultCd="12";
					System.out.println(">>>>>>>>>>>tempadd error 12");
				}else if ((main_cd.equals("2")||main_cd.equals("3") || main_cd.equals("4") || main_cd.equals("7")|| main_cd.equals("8")) && sSAgeGubun.equals("A")){
					
		        	ajaxResultCd="13";
		        	System.out.println(">>>>>>>>>>>tempadd error 13");
		        	// 성인은 유아/아동 강좌 신청이 불가능합니다.
				}else if (main_cd.equals("1") && sSAgeGubun.equals("C")){
		        	ajaxResultCd="14";
		        	System.out.println(">>>>>>>>>>>tempadd error 14");
				}else {
					
					sResult = checkWait(sResult,store,period,cust_no,subject_cd,main_cd,sect_cd);
					
				    if (sResult.equals("ENDDUP")){
				    	ajaxResultCd="21";
				        //rMessage = "이미 결재완료된 강좌입니다.";
				    }else if(sResult.equals("TMPDUP")){
				    	ajaxResultCd="22";
				        //rMessage = "이미 책가방에 담긴 강좌입니다.";
				    }else if(sResult.equals("EXNO")){
				    	ajaxResultCd="23";
				        //rMessage = "정원이 마감된 강좌입니다.";
				    }else if(sResult.equals("FAIL")){
				    	ajaxResultCd="24";
				        //rMessage = "책가방 담기에 실패하였습니다.";
				    }
				    else
				    {
				    	ajaxResultCd=sResult;
				    }
					
				}
			}
			map.put("ajaxResultCd", "OK::"+ajaxResultCd+"::");
		}else {
			map.put("ajaxResultCd", "FAIL::"+ajaxResultCd+"::");
		}
		System.out.println(enterPeriod.get("okWebReceipt"));
		System.out.println(">>>>>>>>>>>common_ajax_euckr.jsp_tempadd end");
		
		
		//map.put("list", LectReceiptDayList);
		
		return map;
	}
	
	public String checkWait(String result,String store, String period, String cust_no, String subject_cd, String main_cd, String sect_cd){
		
		
		
		//LectureDao dao = new LectureDao();
		
		//String retval = dao.checkWait(actionobj);
		
		if(result.equals(""))
		{
			//대기강좌 개수 체크 (1인 5강좌 까지)
	    	int waitCnt = course_dao.selectWaitLectureCnt(cust_no,period);
	    	if(waitCnt > 4)
	    	{
	    		
	    		return "full";
	    		
	    	}
	    	//대기자 현황 여부 체크 (1:대기, 2:등록, 3:취소)
	    	String stateCode = Utils.checkNullString(course_dao.selectWaitState(store,period,subject_cd,cust_no));
	    	if(stateCode.equals("1")) //이미 해당강좌 대기
	    	{
	    		return "wait";
	    		
	    	}
	    	else if(stateCode.equals("2"))//등록완료
	    	{
	    		return "reg";
	    		
	    	}
	    	else if(stateCode.equals("3"))//대기자 추가(기존 대기자)
	    	{
	    		course_dao.updateWaitState(store,period,subject_cd,cust_no,main_cd,sect_cd);
	    		return "";
	    		
	    	}
	    	else//대기자 추가 (신규 대기자)
	    	{
	    		course_dao.addWaitLecture(store,period,subject_cd,cust_no,main_cd,sect_cd);
	    		return "";
		    	
	    	}
		}
		return result;
		//return "";
    	
	}
	@RequestMapping("/findChildByCust")
	@ResponseBody
	public HashMap<String, Object> findChildByCust(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		
		HttpSession session = request.getSession();
		
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String cust_nm = Utils.checkNullString(session.getAttribute("login_name"));
		String bmd = Utils.checkNullString(session.getAttribute("login_birth"));
		List<HashMap<String, Object>> list = course_dao.findChildByCust(cust_no);
		
		map.put("list", list);
		map.put("cust_nm", cust_nm);
		map.put("bmd", bmd);
		return map;
	}
	@RequestMapping("/getIsTwo")
	@ResponseBody
	public String getIsTwo(HttpServletRequest request) {
		
		String store = Utils.checkNullString(request.getParameter("store"));
		String period = Utils.checkNullString(common_dao.retrievePeriod(store).get("PERIOD")); //현재 화성화된 기수 
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		
		return course_dao.getIsTwo(store, period, subject_cd);
	}
	
}