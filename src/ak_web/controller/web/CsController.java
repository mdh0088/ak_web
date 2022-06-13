package ak_web.controller.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ak_web.classes.Utils;
import ak_web.model.web.CsDAO;

@Controller
@RequestMapping("/cs/*")
public class CsController {
	@Autowired
	private CsDAO cs_dao;
	
	@RequestMapping("/contact")
	public ModelAndView contact(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/cs/contact");
		
		return mav;
	}
	
	@RequestMapping("/faq")
	public ModelAndView faq(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/cs/faq");
		
		return mav;
	}
	@RequestMapping("/contact_proc")
	public ModelAndView plan02_proc(HttpServletRequest request) throws IOException {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("/WEB-INF/pages/web/cs/contact_proc");
		
		try
		{
			HashMap<String, Object> map = new HashMap<>();
			map.put("user_name", Utils.checkNullString(request.getParameter("user_name")));
			map.put("user_phone1", Utils.checkNullString(request.getParameter("user_phone1")));
			map.put("user_phone2", Utils.checkNullString(request.getParameter("user_phone2")));
			map.put("user_phone3", Utils.checkNullString(request.getParameter("user_phone3")));
			map.put("user_email", Utils.checkNullString(request.getParameter("user_email1"))+"@"+Utils.checkNullString(request.getParameter("user_email2")));
			map.put("user_store", Utils.checkNullString(request.getParameter("user_store")));
			map.put("user_type", Utils.checkNullString(request.getParameter("user_type")));
			map.put("user_title", Utils.checkNullString(request.getParameter("user_title")));
			map.put("user_content", Utils.checkNullString(request.getParameter("user_content")));
			HttpSession session = request.getSession();
			map.put("ip", Utils.checkNullString(session.getAttribute("login_ip")));
			map.put("id", Utils.checkNullString(session.getAttribute("login_id")));
			
			String indexno =  Utils.checkNullString(cs_dao.getIndex());
			if("".equals(indexno)) { indexno = "1";}
			map.put("indexno",indexno);
			
			int cnt = cs_dao.insContact(map);
			if(cnt == 0)
			{
				mav.addObject("isSuc", "fail");
				mav.addObject("msg", "알 수 없는 오류 발생");
			}
			else
			{
				mav.addObject("isSuc", "success");
				mav.addObject("msg", "저장되었습니다.");
			}
		}
		catch(Exception e)
		{
			mav.addObject("isSuc", "fail");
			mav.addObject("msg", "알 수 없는 오류 발생");
			e.printStackTrace();
		}
		
		return mav;
	}
	
}