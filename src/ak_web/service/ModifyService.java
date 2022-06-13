package ak_web.service;

import java.util.HashMap;
import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;

import ak_web.model.web.UserDAO;
import ak_web.vo.ModifyVo;

public class ModifyService {
	
//	@Autowired
//	private UserDAO user_dao;
//	
//	public ModifyVo retrieveStoreInfo(ModifyVo actionobj) throws SystemException{
//		List<HashMap<String, Object>> list = user_dao.retrieveStoreInfo(actionobj.getCi());
//		
//		if(list.size() > 0) {
//		    System.out.println("setStore"+list.get(0).get("store"));
//        	ModifyVo modifyvo = new ModifyVo();
//    
//            modifyvo.setStoreNm(list.get(0).get("store_nm").toString());
//            modifyvo.setStore(list.get(0).get("store").toString());
//            System.out.println("setStore"+modifyvo.getStore());
//            
//            return modifyvo;
//        } else {
//            ModifyVo modifyvo = new ModifyVo();
//            
//            modifyvo.setStoreNm("�̼��� ����"); // ��ȸ�� �� ������ ���� ��쿡 00 ���� ������ �ش�.
//            modifyvo.setStore("00");
//            System.out.println("setStore : �̼��� ���� : 00");
//            
//            return modifyvo;
//        }
//	}
//
//    public String retrieveStoreSave(ModifyVo actionobj) throws SystemException{
//    	List<HashMap<String, Object>> list = user_dao.retrieveStoreSave(actionobj.getCi());
//        return user_dao.retrieveStoreSave(actionobj);
//    }
//    
}
