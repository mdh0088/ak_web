package ak_web.model.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import ak_web.classes.Utils;
import ak_web.vo.LoginVo;

public class CommonDAO extends SqlSessionDaoSupport{
	
	private String NS = "/web/commonMapper";
	
	public HashMap<String, Object> retrievePeriod(String store) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		HashMap<String, Object> data = getSqlSession().selectOne(NS + ".retrievePeriod", map);
		return data;
	}
	
	public List<HashMap<String, Object>> retrieveLectReceiptDay(String store, String period) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".retrieveLectReceiptDay", map);
		return list;
	}
	
	public List<HashMap<String, Object>> getBranch() {
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getBranch");
		return list;
	}
	

	public HashMap<String, Object> chkCustNo(HttpServletRequest request, HttpServletResponse response, HashMap<String, Object> param, UserDAO user_dao, CommonDAO common_dao) throws Exception {
		 
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        LoginVo retObj = new LoginVo();
        resultMap.put("ajaxResultCd", "");
        /* session mgr */
    	String mode = Utils.checkNullString(param.get("mode"));
    	/*
    	 * 사용 예제는 mypage , attendcust 참조
    	 * request param:
    	 * cust_no: 회원번호 없으면 자동 축출 또는 생성
    	 * store : 지점 없으면 기본점으로 기본점도 없으면 분당으로 (03)
    	 * hq : HQ 없으면 00
    	 * mode
    	 * -nocheck , 회원번호 유효성을 체크하지 않음(생성도 하지 않는다.)
    	 * -noset , session attend 정보 생성 하지 않음(수강자 변경)
    	 * 
    	 *  
    	 *  
    	 * return value
    	 * result : loginObj attend 설정할 수 있는 모든 정보가 있음
    	 * ajaxResultMsg : 에러 메세지 , 없으면 성공
    	 * ajaxResultCd : 프로세스 타입 (기본값: attendCheckCustNo, 로그인요청:reqlogin)
    	 * resultCd : 에러 코드
    	 * 
    	 * 
    	 
    	 */
    	String resultMsg = "";

        
        HttpSession session = request.getSession();
               
        String sUsrId = Utils.checkNullString(session.getAttribute("login_id")); //session UserId
        //String sUsrRegno = sessionForm.getSessionRegno(); //session Regno
        String sUnifyYn = Utils.checkNullString(session.getAttribute("UnifyYn")); //attend session custno
        String sAKmemCardNo = Utils.checkNullString(session.getAttribute("AKmem_Cardno")); //akmembers card no
        String sDi  = Utils.checkNullString(session.getAttribute("Di"));  // session DI (2013.04.04 추가)
        String sCi  = Utils.checkNullString(session.getAttribute("Ci"));  // session CI (2017.05.26 추가)
        String reqAttendCustNo = Utils.checkNullString(param.get("cust_no")); //attend session custno
        String sAttendCustNo = reqAttendCustNo; //attend session custno
        String sAttendStore = Utils.checkNullString(param.get("store")); //attend session store  
        String sHq ="00"; //attend session store
        
        /*
        System.out.println(">>>>>>>>>>>>>>1AttendCustService.java chkCustNo()>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>sessionForm.getSessionDi() <<<<<<<<"+sDi+">>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>sessionForm.getSessionCi() <<<<<<<<"+sCi+">>>>>>>>>>>>>>>>>>>");
        */
        
        try {
        
        //not-login throws LoginForm
        if(sUsrId.equals("")){
            System.out.println(">>>>>>>>>>>>>>로그인이 필요 합니다<<<<<<<<<<<<<<");
            resultMap.put("ajaxResultCd", "reqlogin");
            resultMsg="로그인이 필요 합니다.";
        	throw new Exception(resultMsg);
        }
        
        /*
        System.out.println(">>>>>>>>>>>>>>reqAttendCustNo <<<<<<<<"+reqAttendCustNo+">>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>sAttendCustNo : "+sAttendCustNo );
        System.out.println(">>>>>>>>>>>>>>sAttendStore <<<<<<<<"+sAttendStore+">>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>sHq <<<<<<<<"+sHq+">>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>mode <<<<<<<<"+mode+">>>>>>>>>>>>>>>>>>>");
         */
        
        String rsBA_Custno = "";
        String rsAKmem_Cardno = "";
        String rsAKmem_Cusno = "";
        String rsCi = "";
        String rsBrith_ymd = "";
        
        rsBA_Custno = sAttendCustNo;
    	rsCi = sCi;
    	rsBrith_ymd = "";
    	rsAKmem_Cardno=Utils.checkNullString(session.getAttribute("AKmem_Cardno"));
    	
    	
        //AttendCustVo actionobj = new AttendCustVo();
        
        //수강자 비선택시만 처리
        
        
        HashMap<String, Object> custInfo = user_dao.retrieveCustNo(sAttendStore,sCi); 
        String curDefStore=Utils.checkNullString(custInfo.get("STORE")); //기본 STORE
        String curCustCount=Utils.checkNullString(custInfo.get("COUNT")); //현재 본인 수 (모든 지점 본인 수)
        if (curCustCount.equals("")) {
        	curCustCount="0";
		}
        
        
        //System.out.println(">>>>>>>>>>>>>>curDefStore <<<<<<<<"+curDefStore+">>>>>>>>>>>>>>>>>>>");
        //System.out.println(">>>>>>>>>>>>>>curCustCount <<<<<<<<"+curCustCount+">>>>>>>>>>>>>>>>>>>");
        
		if(sAttendStore.equals("")) //요청이 지점이 없으면
        	sAttendStore=curDefStore; //기본 지점으로 셋팅
        if(sAttendStore.equals("")) //기본지점도 지정 되어 있지 않으면
        {
        	 System.out.println(">>>>>>>>>>>>>>NO DEFAULT STORE <<<<<<<<>>>>>>>>>>>>>>>>>>>");
        	sAttendStore= Utils.checkNullString(user_dao.checkDefaultStore(sCi).get("STORE"));
        	System.out.println(">>>>>>>>>>>>>>NO DEFAULT STORE RESULT>>>"+sAttendStore+" <<<<<<<<>>>>>>>>>>>>>>>>>>>");
        	
        }
        if(sAttendStore.equals("")) //기본지점도 지정 되어 있지 않으면
        	sAttendStore="03"; //분당점으로 셋팅
        
//        System.out.println(">>>>>>>>>>>>>>sAttendStore <<<<<<<<"+sAttendStore+">>>>>>>>>>>>>>>>>>>");
        
        
        ///return 값 초기화//////////
        /*
        retObj.setAttendCustNo(sAttendCustNo);
        retObj.setAttendStore(sAttendStore); //지점 없으면 기본점으로 기본점도 없으면 분당으로 (03)
        retObj.setCi(sCi);
        */
        
        retObj.setAttendCustNo(sAttendCustNo);
        retObj.setAttendStore(sAttendStore); //지점 없으면 기본점으로 기본점도 없으면 분당으로 (03)
        retObj.setCi(sCi);
        //return 값 초기화//////////
        
        //CommonService cmservice = new CommonService();
        //String period = cmservice.retrievePeriod(sAttendStore);
        String period = Utils.checkNullString(common_dao.retrievePeriod(sAttendStore).get("PERIOD")); //현재 화성화된 기수 
        
        System.out.println(">>>>>>>>>>>>>>period <<<<<<<<"+period+">>>>>>>>>>>>>>>>>>>");
        if(sAttendCustNo.equals("")){
        
            
//        	System.out.println(">>>>>>>>>>>>>>no cust no start");            
//            actionobj.setHq(sHq);
//            actionobj.setStore(sAttendStore);
//            actionobj.setUserid(sUsrId);
//            actionobj.setRegno(sUsrRegno);
//            actionobj.setCi(sCi);   // CI (2017.05.26 추가)
//            actionobj.setPeriod(period);
//            
//            
//            /* BA_CUSTNO,AKmemCusNo를 가져옴 */
//            List list = this.retrieveCustNo(actionobj);
//            /* actionobj 에 결과 obj를 담는다 */
//            actionobj.setList(list); 
//            
//            if(list.size()!= 0){
//                for(int i = 0 ; i < list.size() ; i++){
//                    AttendCustVo vo = (AttendCustVo)list.get(i);
//                    rsBA_Custno = vo.getBA_Custno();
//                    rsAKmem_Cardno = vo.getAKmem_Cardno();
//                    rsAKmem_Cusno = vo.getAKmem_Cusno();
//                    rsCi    = vo.getCi();             // CI변경 20170526 - DI추가 (2013.04.04)
//                    rsBrith_ymd = vo.getBirth_ymd();  // 생년월일 추가(2013.06.19)
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
//			 if( !Common.removeNULL(rsAKmem_Cusno,"").equals(""))
//				 sAKmemCardNo = rsAKmem_Cardno;
//            //1.통합사용자(unify_yn) 이면 BA_CUSTNO 가 존재해야 한다. 없다면 선택 점으로 신규회원등록처리
//
//			if(mode.indexOf("|nocheck|")==-1)
//			{
//				
//				System.out.println(">>>>>>>>>>>>>>make db");
//				
//				
//				System.out.println("sUnifyYn="+sUnifyYn);
//	            if("Y".equals(sUnifyYn)){
//	                //step1-1. @AKRIS에 존재하지 않으면 고객 정보가 미전송 임으로 Alert 처리
//	                  if( Common.removeNULL(rsAKmem_Cusno,"").equals("") || rsAKmem_Cardno == null ){
//	                    System.out.println(">>>>>>>>>>>>>>고객정보를 찾을수 없습니다11<<<<<<<<<<<<<<");
//	                    
//	                   resultMap.put("resultCd", "-2");
//	                    resultMsg="고객님의 고객정보를 찾을수 없습니다.^포탈 신규 가입 후 문화센터 사용을 위해서는 최장 5분 정도의 시간이 소요됩니다.^잠시 후 다시 이용해 주세요!";
//	                	throw new Exception(resultMsg);
//	                	
//	                  }  
//	                  
//	                  if( Common.removeNULL(rsCi,"").equals("") ){
//	                      System.out.println(">>>>>>>>>>>>>>고객정보를 찾을수 없습니다22<<<<<<<<<<<<<<");
//	                      resultMap.put("resultCd", "-2");
//	                      resultMsg="고객님의 고객정보를 찾을수 없습니다.^포탈 신규 가입 후 문화센터 사용을 위해서는 최장 5분 정도의 시간이 소요됩니다.^잠시 후 다시 이용해 주세요.";
//	                  	  throw new Exception(resultMsg);
//	                    } 
//	                  
//	                  //step1-2. BACUST에 존재하지 않으면 멤버스 회원임으로 @akris 회원테이블에서 읽어와 insert
//	                  if( Common.removeNULL(rsBA_Custno,"").equals("") ){
//	                        
//	                        //BACUST에 create
//	                      rsBA_Custno = this.createBACUSTUser(actionobj);
//	                      
//	                      //exception
//	                      if(rsBA_Custno.equals("99")){
//	                          System.out.println(">>>>>>>>>>>>>>AttenCustAction Exception Found<<<<<<<<<<<<<<");
//	                          resultMap.put("resultCd", "-9");
//	                          resultMsg="고객님의 고객정보 생성시 오류가 발생했습니다. 문화아카데미로 연락바랍니다.";
//	                      	  throw new Exception(resultMsg);                          
//	                      }
//	                     
//	                      if(curCustCount.equals("0") && curDefStore.equals(""))
//	                      {
//	                    	  //최초 생성 유저인데 기본점 정보가 없으면, 기본점은 최초 생성 수강자의 지점으로 지정한다.
//	                    	  
//	                    	  ModifyVo mvo = new ModifyVo(); //MyPage의 함수사용하기 위해서 객체 actionobj생성, mypage_modify.jsp 화면을 재 로딩 위함, 화면로딩시 기본 이용점 가져옴
//	                          
//	                    	  mvo.setStore(sAttendStore);
//	                    	  mvo.setCi(sCi);
//	                    	  mvo.setCustNo(sAttendCustNo);
//	                          // 사용자의 기본 설정 점 정보를 가져오기 위함
//	                          ModifyService msrv = new ModifyService();
//	                          
//	                          ModifyVo resutlobj = new ModifyVo(); // 결과를 저장하기 위한 vo
//	                          String result_msg=null;
//	                          result_msg = msrv.retrieveStoreSave(mvo);
//	                          sessionManager.setDefaultStoreSession(sAttendStore);
//	                          
//	                      }
//	                  }
//	            }else{
//	                //미동의 사용자 --> 전환 필수 처리 
//	                //동의 안내페이지로 forward 
//	            }
//			}
			
        }
        else
        {
        	System.out.println(">>>>>>>>>>>>>>cust no start");
        	rsBA_Custno = sAttendCustNo;
        }
       
        if(!rsBA_Custno.equals(""))
        {
        	 
        	System.out.println(">>>>>>>>>>>>>>get cust info");
        	
	       // AttendCustDao dao = new AttendCustDao();
        	HashMap<String, Object> loginObjData= user_dao.retrieveCustNo2(rsBA_Custno, sAttendStore);
        	LoginVo loginObj = new LoginVo();
        	
        	if (loginObjData.size()!=0) {
            	loginObj.setAttendCustNo(Utils.checkNullString(loginObjData.get("BA_CUST_NO")));
            	loginObj.setDi(Utils.checkNullString(loginObjData.get("DI")));
            	loginObj.setCi(Utils.checkNullString(loginObjData.get("CI")));
            	loginObj.setAttendCustNm(Utils.checkNullString(loginObjData.get("KOR_NM")));
            	loginObj.setAttendStore(Utils.checkNullString(loginObjData.get("STORE")));
            	loginObj.setBirthymd(Utils.checkNullString(loginObjData.get("BIRTH_YMD")));
            	String birthymd = Utils.checkNullString(loginObjData.get("BIRTH_YMD"));
            	if(birthymd.length()>=4)
            	{
            	 int iAge =  Integer.parseInt(Utils.getCurrentDate().substring(0,4)) - Integer.parseInt(birthymd.substring(0,4));
                 
                 System.out.println("LectureAction.java -- selectlist() >>>>>> iAge: "+iAge);            

                 String sAgeYYYY   = null ;
                 String sSex       = null ;
                 String sSAgeGubun = null ;
                 
                 // 나이 기준 변경 만 20세 → 19세 (2014.02.06 김인숙 요청)
                 if ( iAge >= 19  ) { // 성인 강좌 가능 
                     sSAgeGubun = "A" ;
                 }else {  // 영유아 강좌 가능 
                     sSAgeGubun = "C" ;
                 }
                 loginObj.setBirthymd(birthymd);
                 
                 loginObj.setAttendAgeGubun(sSAgeGubun);
            	}
			}
        	
        	
	        
	        if(loginObj==null)
	        {
	        	 System.out.println(">>>>>>>>>>>>>>AttenCustAction Exception Found<<<<<<<<<<<<<<");
	             resultMap.put("resultCd", "-99");
	             resultMsg="수강자 지정중 문제가 발생하였습니다. 문화아카데미로 연락바랍니다.";
	         	  throw new Exception(resultMsg);
	        }
	        //loginObj.setCustNo(loginObj.getAttendCustNo());
	        loginObj.setDi(sDi);
	        loginObj.setCi(sCi);
	        loginObj.setAKmemCardNo(rsAKmem_Cardno);
	        
	        if(mode.indexOf("|noset|")==-1)
	        {
	        	System.out.println(">>>>>>>>>>>>>>session attend");
	        	
	        	/*
	        	sessionManager.addUserSession(request,loginObj);
	        	
	        	ModifyVo mvo = new ModifyVo(); //MyPage의 함수사용하기 위해서 객체 actionobj생성, mypage_modify.jsp 화면을 재 로딩 위함, 화면로딩시 기본 이용점 가져옴
                
          	  	mvo.setStore(sAttendStore);
          	  	mvo.setDi(sDi);
          	  	mvo.setCi(sCi);
          	    mvo.setCustNo(sAttendCustNo);
          	    
                // 사용자의 기본 설정 점 정보를 가져오기 위함
                ModifyService msrv = new ModifyService();
                
                ModifyVo resutlobj = new ModifyVo(); // 결과를 저장하기 위한 vo
                String result_msg=null;
                result_msg = msrv.retrieveStoreSave(mvo);
                sessionManager.setDefaultStoreSession(sAttendStore);
                */
                
	        }
	        
	        
	        retObj=loginObj;
	        /* actionForm 을 리퀘스트로 보낸다 */
        }	
        } catch(Exception e)
        {
        	System.out.println(e);
        }
        resultMap.put("result", retObj);
        resultMap.put("ajaxResultMsg", resultMsg);
        
        System.out.println("-----------------> End of AttendCustService");
        
        return resultMap;
    }

	public int getPereCnt(String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		return getSqlSession().selectOne(NS + ".getPereCnt", map);
	}
	public List<HashMap<String, Object>> getEncdList(String store, String period, String cust_no, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("cust_no", cust_no);
		map.put("subject_cd", subject_cd);
		return getSqlSession().selectList(NS + ".getEncdList", map);
	}

	public int change_main_store(String store, String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("cust_no", cust_no);
		return getSqlSession().update(NS + ".change_main_store", map);
	}
	public int change_main_store2(String store, String cust_no, String ci) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("cust_no", cust_no);
		map.put("ci", ci);
		return getSqlSession().update(NS + ".change_main_store2", map);
	}

	public String getStoreNm(String store) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		return getSqlSession().selectOne(NS + ".getStoreNm", map);
	}

	public String getisEncdYN(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		return getSqlSession().selectOne(NS + ".getisEncdYN", map);
	}
	
}
