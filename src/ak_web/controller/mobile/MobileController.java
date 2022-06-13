package ak_web.controller.mobile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mobile/moacademy/*")
public class MobileController {
	
	@RequestMapping("attendance01")
	public ModelAndView attendance01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/attendance01");
		
		return mav;
	}
	
	@RequestMapping("attendance02")
	public ModelAndView attendance02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/attendance02");
		
		return mav;
	}
	
	
	@RequestMapping("catalog")
	public ModelAndView catalog(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/catalog");
		
		return mav;
	}
	
	@RequestMapping("certificate01")
	public ModelAndView certificate01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/certificate01");
		
		return mav;
	}
	
	@RequestMapping("certificate02")
	public ModelAndView certificate02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/certificate02");
		
		return mav;
	}
	
	@RequestMapping("certificate03")
	public ModelAndView certificate03(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/certificate03");
		
		return mav;
	}
	
	@RequestMapping("contract01")
	public ModelAndView contract01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/contract01");
		
		return mav;
	}
	
	@RequestMapping("contract02")
	public ModelAndView contract02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/contract02");
		
		return mav;
	}
	
	@RequestMapping("lector01")
	public ModelAndView lector01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/lector01");
		
		return mav;
	}
	
	@RequestMapping("lector02")
	public ModelAndView lector02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/lector02");
		
		return mav;
	}
	
	@RequestMapping("lector03")
	public ModelAndView lector03(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/lector03");
		
		return mav;
	}
	
	@RequestMapping("lector04")
	public ModelAndView lector04(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/lector04");
		
		return mav;
	}
	
	@RequestMapping("lector05")
	public ModelAndView lector05(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/lector05");
		
		return mav;
	}
	
	@RequestMapping("plan01")
	public ModelAndView plan01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/plan01");
		
		return mav;
	}
	
	@RequestMapping("plan02")
	public ModelAndView plan02(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/plan02");
		
		return mav;
	}
	
	@RequestMapping("result01")
	public ModelAndView result01(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/pages/mobile/academy/result01");
		
		return mav;
	}
	
	
	
	
	
}