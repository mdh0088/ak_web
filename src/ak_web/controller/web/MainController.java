package ak_web.controller.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ak_web.classes.Utils;
import ak_web.model.web.AcademyDAO;
import ak_web.model.web.MainDAO;

@Controller
@RequestMapping("/*")
public class MainController {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Value("${image_dir}")
	private String image_dir;
	@Autowired
	private MainDAO main_dao;
	
	@Autowired
	private AcademyDAO ac_dao;
	
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/main");
		Utils.setSearchVal(mav, main_dao);
		
		List<HashMap<String, Object>> mbList = main_dao.getMBanner();
		List<HashMap<String, Object>> sbList = main_dao.getSBanner();
//		List<HashMap<String, Object>> recoList = main_dao.getReco();
		List<HashMap<String, Object>> popList = main_dao.getPopup();
		List<HashMap<String, Object>> newsList = ac_dao.getNewsList(0, 3, "","",""); 
		
		mav.addObject("mbList", mbList);
		mav.addObject("sbList", sbList);
//		mav.addObject("recoList", recoList);
		mav.addObject("popList", popList);
		mav.addObject("newsList", newsList);
		mav.addObject("image_dir", image_dir);
		
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
		
		return mav;
	}
	@RequestMapping("/mbanner")
	public ModelAndView mbanner(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/mbanner");
		
		String file_nm = Utils.checkNullString(request.getParameter("file_nm"));
		
		mav.addObject("image_dir", image_dir);
		mav.addObject("file_nm", file_nm);
		
		return mav;
	}

	
	@RequestMapping("/getMain")
	@ResponseBody
	public HashMap<String, Object> getMain(HttpServletRequest request) {
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("/WEB-INF/pages/basic/gift/listed");
		//Utils.setPeriController(mav, common_dao);
		
		
//		String store = Utils.checkNullString(request.getParameter("store"));

		
		List<HashMap<String, Object>> mainlist = main_dao.get1Depth();
//		List<HashMap<String, Object>> sectlist = main_dao.getSecCd(store);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("mainlist", mainlist);
//		map.put("sectlist", sectlist);

		return map;
	}
	
	@RequestMapping("/getSect")
	@ResponseBody
	public HashMap<String, Object> getSect(HttpServletRequest request) {
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("/WEB-INF/pages/basic/gift/listed");
		//Utils.setPeriController(mav, common_dao);
		
		HttpSession session = request.getSession();
		String store = Utils.removeNULL(session.getAttribute("login_store"),"03");
		String main_cd = Utils.checkNullString(request.getParameter("main_cd"));

		
//		List<HashMap<String, Object>> mainlist = main_dao.get1Depth();
		List<HashMap<String, Object>> sectlist = main_dao.getSecCd(store,main_cd);
		
		HashMap<String, Object> map = new HashMap<>();
//		map.put("mainlist", mainlist);
		map.put("sectlist", sectlist);

		return map;
	}
	@RequestMapping("/preview_main")
	public ModelAndView preview_main(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/web/preview_main");
		
		return mav;
	}
}