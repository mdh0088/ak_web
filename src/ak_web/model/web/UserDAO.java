package ak_web.model.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import ak_web.classes.InitClass;
import ak_web.vo.AttendCustVo;
import ak_web.vo.LoginVo;
import ak_web.vo.ModifyVo;

public class UserDAO extends SqlSessionDaoSupport{
	
	private String NS = "/web/userMapper";
	
	public HashMap<String, Object> loginCheck(String login_id, String login_pw) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("login_id", login_id);
		map.put("login_pw", login_pw);
		HashMap<String, Object> data = getSqlSession().selectOne(NS + ".loginCheck", map);
		return data;
	}

	public String retrievePeriod(String store) {
		String data = getSqlSession().selectOne(NS + ".retrievePeriod", store);
		return data;
	}
	public String retrieveMemType(String loginID) {
		String data = getSqlSession().selectOne(NS + ".retrieveMemType", loginID);
		return data;
	}
	
	public HashMap<String, Object> retrieveCustNo(String store,String ci){
		HashMap<String, Object> map = new HashMap<>();
        map.put("store", store);
        map.put("ci", ci);
        HashMap<String, Object> data = getSqlSession().selectOne(NS + ".retrieveCustNo", map);
		return data;
	}
	
	public HashMap retrieveCustNo2(String cust_no,String store){
		HashMap<String, Object> map = new HashMap<>();
        map.put("cust_no", cust_no);
        map.put("store", store);
        HashMap<String, Object> data = getSqlSession().selectOne(NS + ".retrieveCustNo", map);
		return data;
	}
	
	public HashMap<String, Object> checkDefaultStore(String ci){
		HashMap<String, Object> map = new HashMap<>();
        map.put("ci", ci);
        HashMap<String, Object> data = getSqlSession().selectOne(NS + ".checkDefaultStore", map);
		return data;
	}
	
    public void addUserSession(HttpServletRequest request, LoginVo loginVo) {
        
        
//      HttpSession session = getRequest().getSession(true);
      /*
      HttpSession session = request.getSession(true);
      
      
      SessionManager sessionManager = new SessionManager(request);
      SessionForm sessionForm = sessionManager.getSessionForm();
      */
       HttpSession session = request.getSession();
    	
      if(loginVo.getAKmemCardNo()!=null && !loginVo.getAKmemCardNo().equals("")){ 
      	  session.setAttribute("AKmemCardNo", loginVo.getAKmemCardNo());
      	  System.out.println("getAKmemCardNo가 Null 이네~~"); 
      }
      
      if(loginVo.getCustNo()!=null){ 
    	  session.setAttribute("CusNo", loginVo.getCustNo());
      }
      
      //수강자_고객번호
      if(loginVo.getAttendCustNo()!=null){ 
      	  session.setAttribute("AttendCusNo", loginVo.getAttendCustNo());
      }
      
      //수강자_고객명
      if(loginVo.getAttendCustNm()!=null){ 
    	  session.setAttribute("AttendCusNm", loginVo.getAttendCustNm());
      }
      
      //수강자_성인/유아 구분
      if(loginVo.getAttendAgeGubun()!=null){
    	  session.setAttribute("AttendAgeGubun", loginVo.getAttendAgeGubun());
      }
      
      //수강자_점
      if(loginVo.getAttendStore() !=null){
    	  session.setAttribute("AttendStore", loginVo.getAttendStore());
      }
      
      // 로그인 사용자 DI 정보 (2013.04.04)
      if(loginVo.getDi() != null  && loginVo.getDi().equals("")) {
      	  session.setAttribute("Di", loginVo.getDi());
      }
      
      // 로그인 사용자 CI 정보 (2017.05.23)
      if(loginVo.getCi() != null  && loginVo.getCi().equals("")) {
      	  session.setAttribute("Ci", loginVo.getCi());
      }
      
      if(loginVo.getBirthymd() != null) {
      	  session.setAttribute("BirthYmd", loginVo.getBirthymd());
      } // 로그인 사용자  생년월일정보 (2013.06.13)
      
     // session.setAttribute(InitClass.SESSION_DOMAIN, sessionForm); 
  }
	
//	public HashMap<String, Object> getCustCount(String sCi) {
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("sCi", sCi);
//		HashMap<String, Object> data = getSqlSession().selectOne(NS + ".getCustCount", map);
//		return data;
//	}
//
//	public String checkDefaultStore(String ci) {
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("ci", ci);
//		String data = getSqlSession().selectOne(NS + ".checkDefaultStore", map);
//		return data;
//	}
//
//	public String retrievePeriod(String sAttendStore) {
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("sAttendStore", sAttendStore);
//		String data = getSqlSession().selectOne(NS + ".retrievePeriod", map);
//		return data;
//	}
//
//	public List<HashMap<String, Object>> retrieveCustNo(AttendCustVo actionobj) {
//		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".retrieveCustNo", actionobj);
//		return list;
//	}
//
//	public String retrieveCustSeq(AttendCustVo actionobj) {
//		String data = getSqlSession().selectOne(NS + ".retrieveCustSeq", actionobj);
//		return data;
//	}
//
//	public void createCUSTNO(AttendCustVo actionobj) {
//		getSqlSession().insert(NS + ".createCUSTNO", actionobj);
//		
//	}
//
//	public void updateCUSTNO(AttendCustVo actionobj) {
//		getSqlSession().update(NS + ".updateCUSTNO", actionobj);
//		
//	}
//
//	public void createBACUSTUser(AttendCustVo actionobj) {
//		getSqlSession().insert(NS + ".createBACUSTUser", actionobj);
//		
//	}
//
//	public List<HashMap<String, Object>> retrieveStoreInfo(String ci) {
//		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".retrieveStoreInfo", ci);
//		return list;
//	}
//
//	public String retrieveStoreSave(String ci) {
//		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".retrieveStoreSave", ci);
//		return list;
//	}
}
