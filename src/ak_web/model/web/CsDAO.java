package ak_web.model.web;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CsDAO extends SqlSessionDaoSupport{
	
	private String NS = "/web/csMapper";
	
	public String getIndex() {
		return  getSqlSession().selectOne(NS + ".getIndex");
	}
	public HashMap<String, Object> getLecrInfo(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		
		HashMap<String, Object> list = getSqlSession().selectOne(NS + ".getLecrInfo", map);
		return list;
	}
	public int insContact(HashMap<String, Object> map) {
		return getSqlSession().insert(NS + ".insContact", map);
	}
	
}
