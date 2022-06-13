package ak_web.model.web;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MainDAO extends SqlSessionDaoSupport{
	
	private String NS = "/web/mainMapper";
	
	public List<HashMap<String, Object>> getBranch() {
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getBranch");
		return list;
	}
	
	public List<HashMap<String, Object>> get1Depth() {
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".get1Depth");
		return list;
	}
	
	public List<HashMap<String, Object>> getSecCd(String store,String main_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("main_cd", main_cd);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getSecCd", map);
		return list;
	}

	public List<HashMap<String, Object>> getMBanner() {
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getMBanner");
		return list;
	}
	public List<HashMap<String, Object>> getSBanner() {
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getSBanner");
		return list;
	}

	public List<HashMap<String, Object>> getReco() {
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getReco");
		return list;
	}

	public List<HashMap<String, Object>> getPopup() {
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getPopup");
		return list;
	}
}
