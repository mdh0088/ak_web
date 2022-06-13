package ak_web.controller.web;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ak_web.model.web.AcademyDAO;
import ak_web.model.web.CommonDAO;
import ak_web.model.web.CourseDAO;
import ak_web.model.web.MainDAO;
//
import ak_web.model.web.UserDAO;
import ak_web.classes.Utils;

@Controller
@RequestMapping("/common/*")
public class CommonController {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private CommonDAO common_dao;
	
	@Autowired
	private CourseDAO course_dao;
	
	@Autowired
	private AcademyDAO ac_dao;
	
	@Autowired
	private MainDAO main_dao;
	
	@RequestMapping("/getBook_cnt")
	@ResponseBody
	public ModelAndView getBook_cnt(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/common/get_book_cnt");
		
		HttpSession session = request.getSession();
		String cust_no = Utils.checkNullString(session.getAttribute("login_seq"));
		String cust_nm = Utils.checkNullString(session.getAttribute("login_name"));
		String cust_id = Utils.checkNullString(session.getAttribute("login_id"));
		String cust_store = Utils.checkNullString(session.getAttribute("login_store"));
		if(!"".equals(cust_id))
		{
			String period = Utils.checkNullString(common_dao.retrievePeriod(cust_store).get("PERIOD")); //현재 화성화된 기수 
			List<HashMap<String, Object>> listCnt = ac_dao.getBookCount(cust_no,cust_store,period,cust_id);
			
			int cnt=Utils.checkNullInt(listCnt.get(0).get("CNT"));
			
			mav.addObject("cnt", cnt);
		}
		else
		{
			mav.addObject("cnt", 0);
		}
		mav.addObject("isSuc", "success");
		
		return mav;
	}
	@RequestMapping("/change_main_store")
	@ResponseBody
	public HashMap<String, Object> change_main_store(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HashMap<String, Object> map = new HashMap<>(); 
		String store = Utils.checkNullString(request.getParameter("store"));
		String cust_no = Utils.checkNullString(session.getAttribute("login_cust"));
		String ci = Utils.checkNullString(session.getAttribute("login_ci"));
		try
		{
			int cnt = common_dao.change_main_store(store, cust_no);
			if(cnt > 0)
			{
				cnt = common_dao.change_main_store2(store, cust_no, ci);
				if(cnt > 0)
				{
					map.put("isSuc", "success");
					session.setAttribute("login_store", store);
					session.setAttribute("login_store_nm", common_dao.getStoreNm(store));
					System.out.println(store);
					System.out.println(common_dao.getStoreNm(store));
					System.out.println(session.getAttribute("login_store"));
					System.out.println(session.getAttribute("login_store_nm"));
				}
				else
				{
					map.put("isSuc", "fail");
					map.put("msg", "대표점 변경에 실패하였습니다.");
				}
			}
			else
			{
				map.put("isSuc", "fail");
				map.put("msg", "대표점 변경에 실패하였습니다.");
			}
		}
		catch(Exception e)
		{
			map.put("isSuc", "fail");
			map.put("msg", "알 수 없는 오류가 발생하였습니다.");
		}
		
		return map;
	}
	@RequestMapping("/getEncdList")
	@ResponseBody
	public HashMap<String, Object> getEncdList(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession();
		String store = Utils.removeNULL(session.getAttribute("login_store"),"");
		String period = Utils.removeNULL(session.getAttribute("login_period"),Utils.checkNullString(common_dao.retrievePeriod(Utils.removeNULL(session.getAttribute("login_store"),"")).get("PERIOD")));
		String cust_no = Utils.checkNullString(session.getAttribute("login_cust"));
		String subject_cd = Utils.checkNullString(request.getParameter("subject_cd"));
		String enuri_yn = common_dao.getisEncdYN(store,period,subject_cd);
		if("Y".equals(enuri_yn))
		{
			map.put("isSuc", "success");
			List<HashMap<String, Object>> list = common_dao.getEncdList(store,period,cust_no,subject_cd);
			map.put("list", list);
		}
		else
		{
			map.put("isSuc", "fail");
			map.put("msg", "할인이 불가한 강좌입니다.");
		}
		return map;
	}
	
	@RequestMapping("/search_addr")
	public ModelAndView academy01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/common/search_addr");
		
		return mav;
	}
	
}