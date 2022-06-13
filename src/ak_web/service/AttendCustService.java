package ak_web.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;

import ak_web.classes.SessionManager;
import ak_web.classes.Utils;
import ak_web.model.web.UserDAO;
import ak_web.vo.AttendCustVo;
import ak_web.vo.LoginVo;
import ak_web.vo.ModifyVo;

public class AttendCustService {
	
//	@Autowired
//	private UserDAO user_dao;
//	
//	public HashMap chkCustNo(HttpServletRequest request, HttpServletResponse response, HashMap param) throws Exception {
//		 
//        HashMap resultMap = new HashMap();
//        LoginVo retObj = new LoginVo();
//        resultMap.put("ajaxResultCd", "");
//        /* session mgr */
//    	String mode = Utils.checkNullString((String)param.get("mode"));
//    	/*
//    	 * ��� ������ mypage , attendcust ����
//    	 * request param:
//    	 * cust_no: ȸ����ȣ ������ �ڵ� ���� �Ǵ� ���� 
//    	 * store : ���� ������ �⺻������ �⺻���� ������ �д����� (03)
//    	 * hq : HQ ������ 00
//    	 * mode
//    	 * -nocheck , ȸ����ȣ ��ȿ���� üũ���� ����(������ ���� �ʴ´�.)
//    	 * -noset , session attend ���� ���� ���� ����(������ ����)
//    	 * 
//    	 *  
//    	 *  
//    	 * return value
//    	 * result : loginObj attend ������ �� �ִ� ��� ������ ����
//    	 * ajaxResultMsg : ���� �޼��� , ������ ����
//    	 * ajaxResultCd : ���μ��� Ÿ�� (�⺻��: attendCheckCustNo, �α��ο�û:reqlogin)
//    	 * resultCd : ���� �ڵ�
//    	 * 
//    	 * 
//    	 
//    	 */
//    	String resultMsg = "";
//        SessionManager sessionManager = new SessionManager(request);
//        SessionForm sessionForm = sessionManager.getSessionForm();
//        String sUsrId = Utils.checkNullString(sessionForm.getSessionUserid()); //session UserId
//        String sUsrRegno = sessionForm.getSessionRegno(); //session Regno
//        String sUnifyYn = sessionForm.getSessionUnifyYn(); //attend session custno
//        String sAKmemCardNo = sessionForm.getSessionAKmemCardNo(); //akmembers card no
//        String sDi  = sessionForm.getSessionDi();  // session DI (2013.04.04 �߰�)
//        String sCi  = sessionForm.getSessionCi();  // session CI (2017.05.26 �߰�)
//        String reqAttendCustNo = Utils.checkNullString((String)param.get("cust_no")); //attend session custno
//        String sAttendCustNo = reqAttendCustNo; //attend session custno
//        String sAttendStore = Utils.checkNullString((String)param.get("store")); //attend session store  
//        String sHq = Utils.checkNullString((String)param.get("hq")); //attend session store
//        if("".equals(sHq))
//        {
//        	sHq = "00";
//        }
//        
//        /*
//        System.out.println(">>>>>>>>>>>>>>1AttendCustService.java chkCustNo()>>>>>>>>>>>>>>>>>>>");
//        System.out.println(">>>>>>>>>>>>>>sessionForm.getSessionDi() <<<<<<<<"+sDi+">>>>>>>>>>>>>>>>>>>");
//        System.out.println(">>>>>>>>>>>>>>sessionForm.getSessionCi() <<<<<<<<"+sCi+">>>>>>>>>>>>>>>>>>>");
//        */
//        
//        try {
//        
//        //not-login throws LoginForm
//        if(sUsrId.equals("")){
//            System.out.println(">>>>>>>>>>>>>>�α����� �ʿ� �մϴ�<<<<<<<<<<<<<<");
//            resultMap.put("ajaxResultCd", "reqlogin");
//            resultMsg="�α����� �ʿ� �մϴ�.";
//        	throw new Exception(resultMsg);
//        }
//        
//        /*
//        System.out.println(">>>>>>>>>>>>>>reqAttendCustNo <<<<<<<<"+reqAttendCustNo+">>>>>>>>>>>>>>>>>>>");
//        System.out.println(">>>>>>>>>>>>>sAttendCustNo : "+sAttendCustNo );
//        System.out.println(">>>>>>>>>>>>>>sAttendStore <<<<<<<<"+sAttendStore+">>>>>>>>>>>>>>>>>>>");
//        System.out.println(">>>>>>>>>>>>>>sHq <<<<<<<<"+sHq+">>>>>>>>>>>>>>>>>>>");
//        System.out.println(">>>>>>>>>>>>>>mode <<<<<<<<"+mode+">>>>>>>>>>>>>>>>>>>");
//         */
//        
//        String rsBA_Custno = "";
//        String rsAKmem_Cardno = "";
//        String rsAKmem_Cusno = "";
//        String rsCi = "";
//        String rsBrith_ymd = "";
//        
//        rsBA_Custno = sAttendCustNo;
//    	rsCi = sCi;
//    	rsBrith_ymd = "";
//    	rsAKmem_Cardno=sessionForm.getSessionAKmemCardNo();
//    	
//    	
//        AttendCustVo actionobj = new AttendCustVo();
//        
//        //������ ���ýø� ó��
//        
//        HashMap custInfo = this.getCustCount(sCi);
//        String curDefStore=Utils.checkNullString((String)custInfo.get("STORE")); //�⺻ STORE
//        String curCustCount=Utils.checkNullString((String)custInfo.get("COUNT")); //���� ���� �� (��� ���� ���� ��)
//        if("".equals(curCustCount))
//        {
//        	curCustCount = "0";
//        }
//        
//        //System.out.println(">>>>>>>>>>>>>>curDefStore <<<<<<<<"+curDefStore+">>>>>>>>>>>>>>>>>>>");
//        //System.out.println(">>>>>>>>>>>>>>curCustCount <<<<<<<<"+curCustCount+">>>>>>>>>>>>>>>>>>>");
//        
//		if(sAttendStore.equals("")) //��û�� ������ ������
//        	sAttendStore=curDefStore; //�⺻ �������� ����
//        if(sAttendStore.equals("")) //�⺻������ ���� �Ǿ� ���� ������
//        {
//        	 System.out.println(">>>>>>>>>>>>>>NO DEFAULT STORE <<<<<<<<>>>>>>>>>>>>>>>>>>>");
//        	sAttendStore=this.checkDefaultStore(sCi);
//        	
//        	System.out.println(">>>>>>>>>>>>>>NO DEFAULT STORE RESULT>>>"+sAttendStore+" <<<<<<<<>>>>>>>>>>>>>>>>>>>");
//        	
//        }
//        if(sAttendStore.equals("")) //�⺻������ ���� �Ǿ� ���� ������
//        	sAttendStore="03"; //�д������� ����
//        
////        System.out.println(">>>>>>>>>>>>>>sAttendStore <<<<<<<<"+sAttendStore+">>>>>>>>>>>>>>>>>>>");
//        
//        
//        ///return �� �ʱ�ȭ//////////
//        retObj.setAttendCustNo(sAttendCustNo);
//        retObj.setAttendStore(sAttendStore); //���� ������ �⺻������ �⺻���� ������ �д����� (03)
//        retObj.setCi(sCi);
//        //return �� �ʱ�ȭ//////////
//        
//        String period = user_dao.retrievePeriod(sAttendStore);
//        
//        System.out.println(">>>>>>>>>>>>>>period <<<<<<<<"+period+">>>>>>>>>>>>>>>>>>>");
//        if(sAttendCustNo.equals("")){
//        
//            
//        	System.out.println(">>>>>>>>>>>>>>no cust no start");            
//            actionobj.setHq(sHq);
//            actionobj.setStore(sAttendStore);
//            actionobj.setUserid(sUsrId);
//            actionobj.setRegno(sUsrRegno);
//            actionobj.setCi(sCi);   // CI (2017.05.26 �߰�)
//            actionobj.setPeriod(period);
//            
//            
//            /* BA_CUSTNO,AKmemCusNo�� ������ */
//            List list = this.retrieveCustNo(actionobj);
//            /* actionobj �� ��� obj�� ��´� */
//            actionobj.setList(list); 
//            
//            if(list.size()!= 0){
//                for(int i = 0 ; i < list.size() ; i++){
//                    AttendCustVo vo = (AttendCustVo)list.get(i);
//                    rsBA_Custno = vo.getBA_Custno();
//                    rsAKmem_Cardno = vo.getAKmem_Cardno();
//                    rsAKmem_Cusno = vo.getAKmem_Cusno();
//                    rsCi    = vo.getCi();             // CI���� 20170526 - DI�߰� (2013.04.04)
//                    rsBrith_ymd = vo.getBirth_ymd();  // ������� �߰�(2013.06.19)
//                    
//                    retObj.setAKmemCardNo(rsAKmem_Cardno);
//                    retObj.setBirthymd(rsBrith_ymd);
//                    
//                }
//            }
//            
//            /*
//			System.out.println(">>>>>>>>>>>>>>AttendCustAction List <<<<<<<<<<<<<<");            
//			System.out.println("rsBA_Custno()="+rsBA_Custno);
//			System.out.println("rsAKmem_Cardno()="+rsAKmem_Cardno);
//			System.out.println("rsAKmem_Cusno()="+rsAKmem_Cusno);
//			System.out.println("rsCi ()="+rsCi);
//			System.out.println("rsBrith_ymd ()="+rsBrith_ymd);
//			*/
//            
//			 if( !Utils.checkNullString(rsAKmem_Cusno).equals(""))
//				 sAKmemCardNo = rsAKmem_Cardno;
//            //1.���ջ����(unify_yn) �̸� BA_CUSTNO �� �����ؾ� �Ѵ�. ���ٸ� ���� ������ �ű�ȸ�����ó��
//
//			if(mode.indexOf("|nocheck|")==-1)
//			{
//				
//				System.out.println(">>>>>>>>>>>>>>make db");
//				
//				
//				System.out.println("sUnifyYn="+sUnifyYn);
//	            if("Y".equals(sUnifyYn)){
//	                //step1-1. @AKRIS�� �������� ������ �� ������ ������ ������ Alert ó��
//	                  if( Utils.checkNullString(rsAKmem_Cusno).equals("") || rsAKmem_Cardno == null ){
//	                    System.out.println(">>>>>>>>>>>>>>�������� ã���� �����ϴ�11<<<<<<<<<<<<<<");
//	                    
//	                   resultMap.put("resultCd", "-2");
//	                    resultMsg="������ �������� ã���� �����ϴ�.^��Ż �ű� ���� �� ��ȭ���� ����� ���ؼ��� ���� 5�� ������ �ð��� �ҿ�˴ϴ�.^��� �� �ٽ� �̿��� �ּ���!";
//	                	throw new Exception(resultMsg);
//	                	
//	                  }  
//	                  
//	                  if( Utils.checkNullString(rsCi).equals("") ){
//	                      System.out.println(">>>>>>>>>>>>>>�������� ã���� �����ϴ�22<<<<<<<<<<<<<<");
//	                      resultMap.put("resultCd", "-2");
//	                      resultMsg="������ �������� ã���� �����ϴ�.^��Ż �ű� ���� �� ��ȭ���� ����� ���ؼ��� ���� 5�� ������ �ð��� �ҿ�˴ϴ�.^��� �� �ٽ� �̿��� �ּ���.";
//	                  	  throw new Exception(resultMsg);
//	                    } 
//	                  
//	                  //step1-2. BACUST�� �������� ������ ����� ȸ�������� @akris ȸ�����̺��� �о�� insert
//	                  if( Utils.checkNullString(rsBA_Custno).equals("") ){
//	                        
//	                        //BACUST�� create
//	                      rsBA_Custno = this.createBACUSTUser(actionobj);
//	                      
//	                      //exception
//	                      if(rsBA_Custno.equals("99")){
//	                          System.out.println(">>>>>>>>>>>>>>AttenCustAction Exception Found<<<<<<<<<<<<<<");
//	                          resultMap.put("resultCd", "-9");
//	                          resultMsg="������ ������ ������ ������ �߻��߽��ϴ�. ��ȭ��ī���̷� �����ٶ��ϴ�.";
//	                      	  throw new Exception(resultMsg);                          
//	                      }
//	                     
//	                      if(curCustCount.equals("0") && curDefStore.equals(""))
//	                      {
//	                    	  //���� ���� �����ε� �⺻�� ������ ������, �⺻���� ���� ���� �������� �������� �����Ѵ�.
//	                    	  
//	                    	  ModifyVo mvo = new ModifyVo(); //MyPage�� �Լ�����ϱ� ���ؼ� ��ü actionobj����, mypage_modify.jsp ȭ���� �� �ε� ����, ȭ��ε��� �⺻ �̿��� ������
//	                          
//	                    	  mvo.setStore(sAttendStore);
//	                    	  mvo.setCi(sCi);
//	                    	  mvo.setCustNo(sAttendCustNo);
//	                          // ������� �⺻ ���� �� ������ �������� ����
//	                          ModifyService msrv = new ModifyService();
//	                          
//	                          ModifyVo resutlobj = new ModifyVo(); // ����� �����ϱ� ���� vo
//	                          String result_msg=null;
//	                          result_msg = msrv.retrieveStoreSave(mvo);
//	                          sessionManager.setDefaultStoreSession(sAttendStore);
//	                          
//	                      }
//	                  }
//	            }else{
//	                //�̵��� ����� --> ��ȯ �ʼ� ó�� 
//	                //���� �ȳ��������� forward 
//	            }
//			}
//        }
//        else
//        {
//        	System.out.println(">>>>>>>>>>>>>>cust no start");
//        	rsBA_Custno = sAttendCustNo;
//        }
//       
//        if(!rsBA_Custno.equals(""))
//        {
//        	 
//        	System.out.println(">>>>>>>>>>>>>>get cust info");
//        	
//	        AttendCustDao dao = new AttendCustDao();
//	        LoginVo loginObj = dao.retrieveCustNo(sHq, rsBA_Custno, sAttendStore);
//	        if(loginObj==null)
//	        {
//	        	 System.out.println(">>>>>>>>>>>>>>AttenCustAction Exception Found<<<<<<<<<<<<<<");
//	             resultMap.put("resultCd", "-99");
//	             resultMsg="������ ������ ������ �߻��Ͽ����ϴ�. ��ȭ��ī���̷� �����ٶ��ϴ�.";
//	         	  throw new Exception(resultMsg);
//	        }
//	        //loginObj.setCustNo(loginObj.getAttendCustNo());
//	        loginObj.setDi(sDi);
//	        loginObj.setCi(sCi);
//	        loginObj.setAKmemCardNo(rsAKmem_Cardno);
//	        if(mode.indexOf("|noset|")==-1)
//	        {
//	        	System.out.println(">>>>>>>>>>>>>>session attend");
//	        	
//	        	sessionManager.addUserSession(request,loginObj);
//	        	ModifyVo mvo = new ModifyVo(); //MyPage�� �Լ�����ϱ� ���ؼ� ��ü actionobj����, mypage_modify.jsp ȭ���� �� �ε� ����, ȭ��ε��� �⺻ �̿��� ������
//                
//          	  	mvo.setStore(sAttendStore);
//          	  	mvo.setDi(sDi);
//          	  	mvo.setCi(sCi);
//          	    mvo.setCustNo(sAttendCustNo);
//          	    
//                // ������� �⺻ ���� �� ������ �������� ����
//                ModifyService msrv = new ModifyService();
//                
//                ModifyVo resutlobj = new ModifyVo(); // ����� �����ϱ� ���� vo
//                String result_msg=null;
//                result_msg = msrv.retrieveStoreSave(mvo);
//                sessionManager.setDefaultStoreSession(sAttendStore);
//	        }
//	        
//	        
//	        retObj=loginObj;
//	        /* actionForm �� ������Ʈ�� ������ */
//        }	
//        } catch(Exception e)
//        {
//        	System.out.println(e);
//        }
//        resultMap.put("result", retObj);
//        resultMap.put("ajaxResultMsg", resultMsg);
//        
//        System.out.println("-----------------> End of AttendCustService");
//        
//        return resultMap;
//    }
//	public HashMap<String, Object> getCustCount(String sCi)  throws SystemException {
//		// TODO Auto-generated method stub
//		return user_dao.getCustCount(sCi);
//	}
//	public String checkDefaultStore (String ci) throws SystemException	{
//		
//		return user_dao.checkDefaultStore(ci);
//	}
//	public List<HashMap<String, Object>> retrieveCustNo(AttendCustVo actionobj) throws SystemException{
//		return user_dao.retrieveCustNo(actionobj);
//	}
//	public String createBACUSTUser(AttendCustVo actionobj) throws SystemException {
//        String CustSeqNo = null;
//        try{
//            //�ű� ����ȣ ���� 
//            CustSeqNo = user_dao.retrieveCustSeq(actionobj);
//            actionobj.setCustno(CustSeqNo); //set����ȣ
//            
//            System.out.println("CustSeqNo = "+CustSeqNo.substring(5,9));
//            if("0001".equals(CustSeqNo.substring(5,9))){
//                //�ش� ���� ����� ���� ����ȸ�� (0001) �̸� seq table �� insert
//            	user_dao.createCUSTNO(actionobj);
//            }else{
//                // update seq no
//            	user_dao.updateCUSTNO(actionobj);
//            }
//            
//            //BACUST�� �ű�ȸ������ ���
//            user_dao.createBACUSTUser(actionobj);
//        } catch(Exception e) 
//        {  
//            return "99"; //ERROR CODE RETURN    
//        }        
//        return actionobj.getCustno();
//    }
}

