package ak_web.model.web;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import oracle.sql.BLOB;


public class CourseDAO extends SqlSessionDaoSupport{
	
	private String NS = "/web/courseMapper";

	public List<HashMap<String, Object>> test() {
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".test");
		return list;
	}
	
	
	public List<HashMap<String, Object>> getPeltCount(String store,String period,String month_val,String yoil,String search_name,String main_cd,String sect_cd, String subject_fg) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("month_val", month_val);
		map.put("yoil", yoil);
		map.put("search_name", search_name);
		map.put("main_cd", main_cd);
		map.put("sect_cd", sect_cd);
		map.put("subject_fg", subject_fg);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getPeltCount", map);
		return list;
	}
	
	
	public List<HashMap<String, Object>> getPelt(int s_rownum, int e_rownum, String sort_type,
			String store,String period,String month_val,String yoil,String search_name,String main_cd,String sect_cd, String subject_fg) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("sort_type", sort_type);
		
		map.put("store", store);
		map.put("period", period);
		map.put("month_val", month_val);
		map.put("yoil", yoil);
		map.put("search_name", search_name);
		map.put("main_cd", main_cd);
		map.put("sect_cd", sect_cd);
		map.put("subject_fg", subject_fg);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getPelt", map);
		return list;
	}
	
	public List<HashMap<String, Object>> getReviewCount(String store,String period,String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);		
		map.put("subject_cd", subject_cd);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getReviewCount", map);
		return list;
	}
	public void upReviewViews(String store,String period,String subject_cd,String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);		
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		getSqlSession().update(NS + ".upReviewViews", map);
	}
	
	
	public List<HashMap<String, Object>> getReview(int s_rownum, int e_rownum, String store,String period,String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("store", store);
		map.put("period", period);		
		map.put("subject_cd", subject_cd);
		
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getReview", map);
		return list;
	}
	
	public int courseChk(String store, String period, String subject_cd, String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		int data = getSqlSession().selectOne(NS + ".courseChk", map);
		return data;
	}
	
	public List<HashMap<String, Object>> getPlanDetail(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getPlanDetail", map);
		return list;
	}
	
	public HashMap<String, Object> getPeltOne(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		
		HashMap<String, Object> data = getSqlSession().selectOne(NS + ".getPeltOne", map);
		return data;
	}
	
	public HashMap<String, Object> chk_bookshelf(String store, String period, String subject_cd, String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		HashMap<String, Object> data = getSqlSession().selectOne(NS + ".chk_bookshelf", map);
		return data;
	}

	public void ins_bookshelf(String store, String period, String subject_cd, String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		getSqlSession().insert(NS + ".ins_bookshelf", map);
	}
	
	public List<HashMap<String, Object>> getSecCd(String sub_code) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("sub_code", sub_code);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getSecCd", map);
		return list;
	}
	
	
	public List<HashMap<String, Object>> chk_cancel(String store, String period, String subject_cd, String cust_no ) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".chk_cancel", map);
		return list;
	}
	
	public List<HashMap<String, Object>> chk_session_id(String store,String cust_no,String user_id ) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("cust_no", cust_no);
		map.put("user_id", user_id);		
		
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".chk_session_id", map);
		return list;
	}
	
	public List<HashMap<String, Object>> temp_chklist_1(String store,String period,String cust_no, String subject_cd ) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("cust_no", cust_no);
		map.put("subject_cd", subject_cd);
		
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".temp_chklist_1", map);
		return list;
	}
	
	public List<HashMap<String, Object>> temp_chklist_2(String store,String cust_no, String cust_id ) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("cust_no", cust_no);
		map.put("cust_id", cust_id);
		
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".temp_chklist_2", map);
		return list;
	}
	
	public List<HashMap<String, Object>> temp_chklist_3(String store,String cust_no, String subject_cd,String ipAddress,String cust_id ) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("cust_no", cust_no);
		map.put("subject_cd", subject_cd);
		map.put("ipAddress", ipAddress);
		map.put("cust_id", cust_id);
		
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".temp_chklist_3", map);
		return list;
	}
	
	public List<HashMap<String, Object>> temp_chklist_4(String store,String period, String subject_cd, boolean isCommit) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		
		
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".temp_chklist_4", map);
		
		return list;
	}
	
	public void addToTemp(String ipAddress, String cust_no, String subject_cd, String cust_id,String store,String p_cust,String c_cust1,String c_cust2) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("ipAddress", ipAddress);
		map.put("cust_no", cust_no);
		map.put("subject_cd", subject_cd);
		map.put("cust_id", cust_id);
		map.put("store", store);
		map.put("p_cust", p_cust);
		map.put("c_cust1", c_cust1);
		map.put("c_cust2", c_cust2);

		getSqlSession().insert(NS + ".addToTemp", map);
	}
	public int upToTemp(String ipAddress, String cust_no, String subject_cd, String cust_id,String store,String p_cust,String c_cust1,String c_cust2) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("ipAddress", ipAddress);
		map.put("cust_no", cust_no);
		map.put("subject_cd", subject_cd);
		map.put("cust_id", cust_id);
		map.put("store", store);
		map.put("p_cust", p_cust);
		map.put("c_cust1", c_cust1);
		map.put("c_cust2", c_cust2);
		
		return getSqlSession().update(NS + ".upToTemp", map);
	}
	
	public void tempDateUpdate(String store, String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("cust_no", cust_no);

		getSqlSession().update(NS + ".tempDateUpdate", map);
	}
	
	public List<HashMap<String, Object>> retrieveListLecture(String store,String period, String main_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("main_cd", main_cd);

		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".retrieveListLecture", map);
		return list;
	}
	
	public HashMap<String, Object> retrieveLecture(String store, String period,String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		
		HashMap<String, Object> data = getSqlSession().selectOne(NS + ".retrieveLecture", map);
		return data;
	}
	
	public void tempAlter() {
		HashMap<String, Object> map = new HashMap<>();
		getSqlSession().update(NS + ".tempAlter", map);
	}
	
	
	
	public BLOB lecturePhoto(String store, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("subject_cd", subject_cd);
		
		BLOB data = getSqlSession().selectOne(NS + ".lecturePhoto", map);
		return data;
	}
	
	public List<HashMap<String, Object>> checkWaitList_1(String store,String period,String cust_no, String subject_cd ) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("cust_no", cust_no);
		map.put("subject_cd", subject_cd);
		
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".checkWaitList_1", map);
		return list;
	}
	
	public int selectWaitLectureCnt(String cust_no, String period) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("period", period);
		int data = getSqlSession().selectOne(NS + ".selectWaitLectureCnt", map);
		return data;
	}
	
	public String selectWaitState(String store, String period, String subject_cd, String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		
		String data = getSqlSession().selectOne(NS + ".selectWaitState", map);
		return data;
	}
	
	public void updateWaitState(String store, String period, String subject_cd, String cust_no, String main_cd, String sect_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		map.put("main_cd", main_cd);
		map.put("sect_cd", sect_cd);

		getSqlSession().update(NS + ".updateWaitState", map);
	}
	
	public void addWaitLecture(String store, String period, String subject_cd, String cust_no,String main_cd, String sect_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		map.put("main_cd", main_cd);
		map.put("sect_cd", sect_cd);

		getSqlSession().insert(NS + ".addWaitLecture", map);
	}


	public HashMap<String, Object> getWlect(String store, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("subject_cd", subject_cd);
		return getSqlSession().selectOne(NS + ".getWlect", map);
	}


	public String getCanc() {
		return getSqlSession().selectOne(NS + ".getCanc");
	}


	public List<HashMap<String, Object>> findChildByCust(String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		return getSqlSession().selectList(NS + ".findChildByCust", map);
	}


	public String getIsTwo(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		return getSqlSession().selectOne(NS + ".getIsTwo", map);
	}
}
