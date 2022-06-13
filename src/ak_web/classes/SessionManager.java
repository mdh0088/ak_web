package ak_web.classes;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.SystemException;

import ak_web.service.AttendCustService;
import ak_web.service.SessionForm;
import ak_web.vo.AdminVo;
import ak_web.vo.LoginVo;

public class SessionManager {

//    private HttpServletRequest req = null;
//    //private HttpServletResponse res = null;
//    private String poolName = AKConfigOption.getInstance().getOptionValue("DB_CONNECTOR_HOME");
//    
//    SessionForm currentSession = null;
//    
//    public SessionManager(HttpServletRequest request) {
//        req = request;
//        
//        currentSession = getAuthObject();
//        //res = response;
//    }
//    
//    public HttpServletRequest getRequest() {
//        return this.req;
//    }
//    
//    /*
//    public HttpServletResponse getResponse() {
//        return this.res;
//    }
//    */
//    
//    public SessionForm getAuthObject() {
//        
//        HttpSession session = getRequest().getSession();
//        SessionForm objAuth = (SessionForm)session.getAttribute(InitClass.getSESSION_DOMAIN()   );      
//        
//        if ( objAuth == null ) {
//            return getNewAuth();
//        } else {
//            return objAuth;
//
//        }
//    }
//
//    protected SessionForm getNewAuth() {
//        SessionForm ssf = new SessionForm();
//        
//        return ssf;
//    }
//    
//    public SessionForm getSessionForm() {
//        HttpSession session = getRequest().getSession();
//        Object objAuth = session.getAttribute(InitClass.getSESSION_DOMAIN() );
//        
//        if ( objAuth == null ) {
//            System.out.println("%%%%%%%%%%%%%%%%%%%%%% �� � ����");
//            return (SessionForm)getNewAuth();
//        } else {
//            System.out.println("%%%%%%%%%%%%%%%%%%%%%% � ����");
//            return (SessionForm)objAuth;
//        }
//    }
//    
//    public void setSessionForm(SessionForm sessionForm) {
//        
//        HttpSession session = getRequest().getSession();
//        
//        String sessionName = sessionForm.getSessionName();
//        String sessionRole = sessionForm.getSessionRole();
//        String sessionUserid = sessionForm.getSessionUserid();
//        String sessionUserlevel = sessionForm.getSessionUserlevel();
//        String sessionDi        = sessionForm.getSessionDi();              // DI �߰�(2013.04.03)
//        String sessionCi        = sessionForm.getSessionCi();              // CI �߰�(2017.05.25)
//        String sessionBirthYmd   = sessionForm.getSessionBirthYmd();       // ������� �߰�(2013.06.13)
//        String sessionMemType = sessionForm.getSessionMemType();   // ȸ������ �߰� (2016.02.02)
//        
//        SessionForm newSessionForm = new SessionForm();
//        newSessionForm.setAuthChecked(true);
//        newSessionForm.setSessionAuthChecked(true);
//        newSessionForm.setSessionName(sessionName);
//        newSessionForm.setSessionRole(sessionRole);
//        newSessionForm.setSessionUserid(sessionUserid);
//        newSessionForm.setSessionUserlevel(sessionUserlevel);
//        newSessionForm.setSessionDi(sessionDi);                         // DI �߰�(2013.04.03)
//        newSessionForm.setSessionCi(sessionCi);                         // CI �߰�(2013.04.03)
//        newSessionForm.setSessionBirthYmd(sessionBirthYmd);             // ������� �߰�(2013.06.13)
//        newSessionForm.setSessionMemType(sessionMemType);   // ȸ������ �߰� (2016.02.02)
//        
//        session.setAttribute(InitClass.SESSION_DOMAIN, sessionForm);
//    }
//    
//    public void removeSessionForm() {
//        HttpSession session = getRequest().getSession();
//        
//        if(session!=null) {
//            //SessionForm sf = (SessionForm)session.getAttribute(InitClass.getSESSION_DOMAIN());
//            
//            session.invalidate();
//            session = null;
//            //SessionForm sf = new SessionForm();
//            
//            //session.setAttribute(InitClass.SESSION_DOMAIN, sf);
//        }
//        
//        
//    }
//    
//
//    public void makeSuperAdminSession(AdminVo adminVo) {
//        HttpSession session = getRequest().getSession(true);
//        
//        SessionForm newSessionForm = new SessionForm();
//        newSessionForm.setAuthChecked(true);
//        newSessionForm.setSessionAuthChecked(true);
//        newSessionForm.setSessionName("SuperAdmin");
//        newSessionForm.setSessionRole("super");
//        newSessionForm.setSessionUserid(adminVo.getAdminid());
//        newSessionForm.setSessionUserlevel("100");
//        newSessionForm.setSessionAdminGroup("0");
//        newSessionForm.setSessionLoginTime(StringUtil.TimestampToString(new Timestamp(System.currentTimeMillis())));
//        
//        session.setAttribute(InitClass.SESSION_DOMAIN, newSessionForm);
//        
//        //���� ������ �޴� ����Ʈ ����..
//        //List menuList = getLeftMenuList(adminVo.getGroup_code());
//        //session.setAttribute(InitClass.SESMENU_LIST, menuList);
//        
//        
//    }
//    
//    public void makeAdminSession(AdminVo adminVo) {
//        HttpSession session = getRequest().getSession(true);
//        
//        SessionForm newSessionForm = new SessionForm();
//        newSessionForm.setAuthChecked(true);
//        newSessionForm.setSessionAuthChecked(true);
//        newSessionForm.setSessionName(adminVo.getName());
//        newSessionForm.setSessionRole("admin");
//        newSessionForm.setSessionUserid(adminVo.getAdminid());
//        newSessionForm.setSessionUserlevel("70");
//        newSessionForm.setSessionAdminGroup(adminVo.getGroup_code());
//        newSessionForm.setSessionLoginTime(StringUtil.TimestampToString(new Timestamp(System.currentTimeMillis())));
//        
//        newSessionForm.setSessionIp(adminVo.getIp());
//        
//        session.setAttribute(InitClass.SESSION_DOMAIN, newSessionForm);
//        
//        //���� ������ �޴� ����Ʈ ����..
//        //List menuList = getLeftMenuList(adminVo.getGroup_code());
//        //session.setAttribute(InitClass.SESMENU_LIST, menuList);
//        
//        
//    }
//    
//    public void makeUserSession(LoginVo loginVo) {
//        
//        
//        HttpSession session = getRequest().getSession(true);
//        
//        SessionForm sessionForm = new SessionForm();
//        
//        sessionForm.setAuthChecked(true);
//        sessionForm.setSessionAuthChecked(true);
//        sessionForm.setSessionRole("user");
//        sessionForm.setSessionUserlevel("20");
//        
//        sessionForm.setSessionName(loginVo.getUser_name());
//        sessionForm.setSessionUserid(loginVo.getUserid().toLowerCase());
//        sessionForm.setSessionLoginTime(StringUtil.TimestampToString(new Timestamp(System.currentTimeMillis())));
//        
//        sessionForm.setSessionRegno(loginVo.getRegno());
//        sessionForm.setSessionUnifyYn(loginVo.getUnifyYN());
//        //==> sessionid��  ptl_id�� ��ü
//        //sessionForm.setSessionIp(loginVo.getLogin_ip());
//        sessionForm.setSessionIp(loginVo.getUserid());
//      
//        sessionForm.setSessionAKmemCardNo(loginVo.getAKmemCardNo());
//        
//        sessionForm.setSessionAttendCusNo(loginVo.getAttendCustNo());  //������_����ȣ
//        sessionForm.setSessionAttendCusNm(loginVo.getAttendCustNm());  //������_����
//        sessionForm.setSessionAttendAgeGubun(loginVo.getAttendAgeGubun()); //������ ���� ����
//        sessionForm.setSessionAttendStore(loginVo.getAttendStore()); //������
//        
//        //String sSessionId = session.getId();
//        //sessionForm.setSessionId(sSessionId.substring(sSessionId.lastIndexOf("|") + 1, sSessionId.lastIndexOf("|") + 14));
//        //==> sessionid��  ptl_id�� ��ü
//        sessionForm.setSessionId(loginVo.getUserid());
//        
//        //     sessionForm.setSessionCusNo(loginVo.getCus_no());
//        sessionForm.setSessionDi(loginVo.getDi());   // DI �߰� (2013.04.03) 
//        sessionForm.setSessionCi(loginVo.getCi());   // CI �߰� (2017.05.25)
//        sessionForm.setSessionBirthYmd(loginVo.getBirthymd());   // ������� �߰� (2013.04.13)
//        
//        System.out.println(">>>>>>>>>>>loginVo.getMemType()="+loginVo.getMemType());
//        sessionForm.setSessionMemType(loginVo.getMemType());   // ȸ������ �߰� (2016.02.02)
//        
//        
//        //////�߰� �⺻ ������ ����////////////////////////////////
//        
//       
//        ////////////////////////////////////////////////////////
//        
//    System.out.println(">>>>>>>>>>>>>>>>>>> ���ǻ��� ���� makeUserSession  <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//        
//        session.setAttribute(InitClass.SESSION_DOMAIN, sessionForm);
//        
//    System.out.println(">>>>>>>>>>>>>>>>>>> ���ǻ��� ���� makeUserSession  <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//    
//    	   
//    	if(Utils.checkNullString(sessionForm.getSessionAttendCusNo()).equals(""))
//    	{
//    		System.out.println(">>>>>>>>>>>loginVo DEFAULT ATTEND CUST SETTING START <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//		    AttendCustService attcustService = new AttendCustService();
//		    HashMap param = new HashMap();
//		    param.put("hq", "00");
//		    param.put("store", "");
//		    param.put("mode", "|nocheck|");
//		    try {
//				HashMap resultObj = attcustService.chkCustNo(getRequest(), null, param);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println(">>>>>>>>>>>loginVo DEFAULT ATTEND CUST SETTING ERROR"+e.toString()+" <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//			}
//		    System.out.println(">>>>>>>>>>>loginVo DEFAULT ATTEND CUST SETTING END <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//    	}
//	    
//    }
//        
//
//    public void addUserSession(HttpServletRequest request, LoginVo loginVo) {
//        
//        
////        HttpSession session = getRequest().getSession(true);
//        
//        HttpSession session = request.getSession(true);
//        
//        
//        SessionManager sessionManager = new SessionManager(request);
//        SessionForm sessionForm = sessionManager.getSessionForm();
//        
//        if(loginVo.getAKmemCardNo()!=null && !loginVo.getAKmemCardNo().equals("")){ 
//        	sessionForm.setSessionAKmemCardNo(loginVo.getAKmemCardNo());
//        	System.out.println("getAKmemCardNo�� Null �̳�~~"); 
//        }
//        
//        if(loginVo.getCustNo()!=null){ 
//        	sessionForm.setSessionCusNo(loginVo.getCustNo());
//        }
//        
//        //������_����ȣ
//        if(loginVo.getAttendCustNo()!=null){ 
//        	sessionForm.setSessionAttendCusNo(loginVo.getAttendCustNo()); 
//        }
//        
//        //������_����
//        if(loginVo.getAttendCustNm()!=null){ 
//        	sessionForm.setSessionAttendCusNm(loginVo.getAttendCustNm());
//        }
//        
//        //������_����/���� ����
//        if(loginVo.getAttendAgeGubun()!=null){
//        	sessionForm.setSessionAttendAgeGubun(loginVo.getAttendAgeGubun());
//        }
//        
//        //������_��
//        if(loginVo.getAttendStore() !=null){
//        	sessionForm.setSessionAttendStore(loginVo.getAttendStore());
//        }
//        
//        // �α��� ����� DI ���� (2013.04.04)
//        if(loginVo.getDi() != null  && loginVo.getDi().equals("")) {
//        	sessionForm.setSessionDi(loginVo.getDi());
//        }
//        
//        // �α��� ����� CI ���� (2017.05.23)
//        if(loginVo.getCi() != null  && loginVo.getCi().equals("")) {
//        	sessionForm.setSessionCi(loginVo.getCi());
//        }
//        
//        if(loginVo.getBirthymd() != null) {
//        	sessionForm.setSessionBirthYmd(loginVo.getBirthymd());
//        } // �α��� �����  ����������� (2013.06.13)
//        
//        session.setAttribute(InitClass.SESSION_DOMAIN, sessionForm); 
//    }
//        
//    public void setDefaultStoreSession( String Dstore ) {
//      
//      HttpSession session = getRequest().getSession(true);
//      //20131115
//      if(Dstore == null || "".equals(Dstore) || "00".equals(Dstore)){
//    	  Dstore = "03"; //�д���
//      }
//
//      session.setAttribute("SESSION_STORE", Dstore);
//      
//      System.out.println(">>>>Set SESSION_STORE:"+Dstore);
//  }    
//
//    public String getDefaultStoreSession() {
//        
//        HttpSession session = getRequest().getSession(true);
//        String DefaultStore = (String)session.getAttribute("SESSION_STORE");
//        System.out.println(">>>>Get SESSION_STORE:"+DefaultStore);
//        return DefaultStore ;
//    }  
//    
//    public void deleteAdminSession() {
//        HttpSession session = getRequest().getSession();
//        
//        if(session!=null) {
//            //SessionForm sf = (SessionForm)session.getAttribute(InitClass.getSESSION_DOMAIN());
//            
//            session.invalidate();
//            
//            //SessionForm sf = new SessionForm();
//            
//            //session.setAttribute(InitClass.SESSION_DOMAIN, sf);
//        }
//    }
//    
//    public boolean isSessionForm() {
//        HttpSession session = getRequest().getSession();
//        Object sessionObject = session.getAttribute(InitClass.getSESSION_DOMAIN());
//        
//        if(sessionObject==null) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//    
//    public void makeSessionMenuList(String groupcode) {
//        HttpSession session = getRequest().getSession(true);
//        
//    }
//    
//    
//    public List getLeftMenuList() {
//        HttpSession session = getRequest().getSession();
//        
//        if ( session == null ) {
//        
//            return null;
//            
//        }else {
//            
//            SessionForm sessionForm = (SessionForm)session.getAttribute(InitClass.SESSION_DOMAIN);
//            
//            if ( sessionForm != null) {
//                
//                if ( sessionForm.getSessionRole().equals("super")) {
//                    return getLeftMenuList(sessionForm.getSessionAdminGroup(), true);   
//                } else {
//                    return getLeftMenuList(sessionForm.getSessionAdminGroup(), false);
//                }
//                
//            }
//                
//        }
//        
//        return null;
//        
//    }
//    
//    /**
//     * ���� ������ �޴� ����Ʈ�� �о�´�.
//     * Ű - �����ڱ׷� group_code
//     * @param group_code
//     * @return
//     * @throws SystemException
//     */
//    public List getLeftMenuList(String groupcode, boolean isSuper) {
//        
//        boolean isauth = false;
//        
//        List menuList = new LinkedList();
//        
//        try {
//            QueryManager qm = new QueryManager(poolName);
//            StringBuffer sql = new StringBuffer();
//            
//            if ( isSuper) {
//                sql.append("SELECT A.menu_group_name, A.menu_group_code, B.menu_code, B.menu_name, B.menu_uri \n");
//                sql.append(" FROM CDW_ADMIN_MENU_GROUP A join CDW_ADMIN_MENU B on A.menu_group_code = B.menu_group_code \n");
//                sql.append(" WHERE A.status = 'Y' \n");
//                
//            } else {
//                sql.append("SELECT c.menu_group_name,c.menu_group_code, b.menu_name, \n");
//                sql.append(" b.menu_code, a.group_code,  b.menu_uri                  \n");
//                sql.append(" From CDW_ADMIN_AUTH a join CDW_ADMIN_MENU b on a.menu_code = b.menu_code \n");
//                sql.append(" join CDW_ADMIN_MENU_GROUP c on b.menu_group_code = c.menu_group_code \n");
//                sql.append(" where a.group_code = ? AND c.status = 'Y' \n");                
//
//                qm.setInt(1, Integer.parseInt(groupcode));  
//            }
//            
//                        
//            AkResultSet rs = qm.executeQuery(sql);
//            
//            if(rs.next()) {
//
//                do {
//                    AccessMenu menu = new AccessMenu();
//                    
//                    menu.setMenuGroupName(rs.getString("menu_group_name"));
//                    menu.setMenuGroupCode(rs.getString("menu_group_code"));
//                    menu.setMenuCode(rs.getString("menu_code"));
//                    menu.setMenuName(rs.getString("menu_name"));
//                    menu.setMenuUri(rs.getString("menu_uri"));
//                            
//                    menuList.add(menu);
//                    
//                } while(rs.next());
//
//                
//            } 
//
//        } catch(Exception e) {
//            e.printStackTrace();
//            
//        }
//        
//        return menuList;
//    }
//    
//    public List getTopMenuList() {
//        HttpSession session = getRequest().getSession();
//        
//        if ( session == null ) {
//        
//            return null;
//            
//        }else {
//            
//            SessionForm sessionForm = (SessionForm)session.getAttribute(InitClass.SESSION_DOMAIN);
//            
//            if ( sessionForm != null) {
//                
//                if ( sessionForm.getSessionRole().equals("super")) {
//                    return getTopMenuList(sessionForm.getSessionAdminGroup(), true);    
//                } else {
//                    return getTopMenuList(sessionForm.getSessionAdminGroup(), false);
//                }
//                
//            }
//                
//        }
//        
//        return null;
//        
//    }
//    
//    /**
//     * ��� �޴� ����Ʈ�� �о�´�.
//     * Ű - 
//     * @param 
//     * @return
//     * @throws SystemException
//     */
//    public List getTopMenuList(String groupcode, boolean isSuper) {
//        
//        boolean isauth = false;
//        
//        try {
//            QueryManager qm = new QueryManager(poolName);
//            StringBuffer sql = new StringBuffer();
//            
//            if ( isSuper) {
//                sql.append("SELECT menu_group_code, menu_group_name \n");
//                sql.append(" From CDW_ADMIN_MENU_GROUP              \n");
//                sql.append(" WHERE status='Y'               \n");
//                sql.append(" ORDER BY menu_group_name ASC \n");
//                
//            } else {
//                sql.append(" SELECT z.menu_group_code, z.menu_group_name \n");
//                sql.append(" FROM CDW_ADMIN_MENU_GROUP z  \n");
//                sql.append(" INNER JOIN ( \n");
//                sql.append(" SELECT c.menu_group_code FROM CDW_ADMIN_AUTH a  \n");
//                sql.append(" LEFT JOIN CDW_ADMIN_MENU b \n");
//                sql.append(" ON a.menu_code = b.menu_code \n");
//                sql.append(" LEFT JOIN CDW_ADMIN_MENU_GROUP c \n");
//                sql.append(" ON b.menu_group_code = c.menu_group_code \n");
//                sql.append(" WHERE a.group_code = ? AND c.status='Y'  \n");
//                sql.append(" GROUP BY c.menu_group_code \n");
//                sql.append(" ) x \n");
//                sql.append(" ON z.menu_group_code = x.menu_group_code \n");
//                sql.append(" ORDER BY z.menu_group_name ASC \n");
//                
//                qm.setInt(1, Integer.parseInt(groupcode));  
//            }
//            
//            
//            
//            AkResultSet rs = qm.executeQuery(sql);
//            
//            List menuList = new LinkedList();
//            
//            if(rs.next()) {
//
//                do {
//                    AccessMenu menu = new AccessMenu();
//                    
//                    menu.setMenuGroupName(rs.getString("menu_group_name"));
//                    menu.setMenuGroupCode(rs.getString("menu_group_code"));
//                            
//                    menuList.add(menu);
//                    
//                } while(rs.next());
//
//                return menuList;
//            } 
//
//        } catch(Exception e) {
//            e.printStackTrace();
//            
//        }
//        
//        return java.util.Collections.EMPTY_LIST;
//    }
//    
//    
//    // ���� ���� üũ
//    public boolean sessionAuth (AccessorInfo accessInfo) {
//        
//        if ( checkAuth(accessInfo))
//            return true;
//        else
//            return false;
//    }
//    
//    protected boolean checkAuth(AccessorInfo accessInfo)  {
//        HttpSession session = getRequest().getSession();
//        SessionForm sessionForm = (SessionForm)session.getAttribute(InitClass.SESSION_DOMAIN);
//        
//        if(sessionForm==null) {
//            sessionForm = new SessionForm();
//        }
//        
//        boolean bRollCheck = false;
//        String[] roles = accessInfo.getAccessor_Roles();
//        //int iSession_role = getAuthLevel(currentSession.getSessionRole());
//        int iSession_role = getAuthLevel(sessionForm.getSessionRole());
//        
//        //System.out.println("checking role....");
//        
//        //���� ������ ������  OK..
//        //if ( currentSession.getSessionRole().equals("super"))
//        if ( sessionForm.getSessionRole().equals("super"))
//            return true;
//        
//        /* ��Ʈ���� Roll üũ */
//        if (roles == null)
//            bRollCheck = false;
//        
//        for ( int i = 0; i < roles.length ; i++ ) { 
//            
//            //System.out.println("page role :" + getAuthLevel(roles[i]) + " , user role: " + iSession_role);
//            if ( getAuthLevel(roles[i]) <= iSession_role) {
//                bRollCheck = true;
//                break;
//            }
//        }
//        
//        if(bRollCheck)  {
//            //��Ʈ���� Roll�� admin�� ���� �Ǿ� ���� �ܿ�  ������ �޴� ���� Ȯ��
//            if ( containAdminRoll(roles)) {
//                
//                if ( accessInfo.getAccessor_Uri().startsWith("/winchester") || checkMenuAuth(sessionForm.getSessionAdminGroup(),accessInfo)) {
//                    
//                    bRollCheck =  true;
//                } else {
//                    bRollCheck =  false;
//                }
//                
//            }
//        }
//        
//        return bRollCheck;
//    }
//    
//    // �޴�����üũ
//    public boolean sessionMenu (AccessorInfo accessInfo) {
//        
//        if ( checkMenu(accessInfo))
//            return true;
//        else
//            return false;
//    }
//    
//    protected boolean checkMenu(AccessorInfo accessInfo)  {
//        HttpSession session = getRequest().getSession();
//        SessionForm sessionForm = (SessionForm)session.getAttribute(InitClass.SESSION_DOMAIN);
//        
//        if(sessionForm==null) {
//            sessionForm = new SessionForm();
//        }
//        
//        if(sessionForm==null) {
//            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ���� �� ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//        } else {
//            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ getSessionAdminGroup : "+sessionForm.getSessionAdminGroup()+" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ getSessionEmail : "+sessionForm.getSessionEmail()+" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ getSessionLoginTime : "+sessionForm.getSessionLoginTime()+" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ getSessionName : "+sessionForm.getSessionName()+" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ getSessionPhone : "+sessionForm.getSessionPhone()+" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ getSessionRole : "+sessionForm.getSessionRole()+" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ getSessionUserid : "+sessionForm.getSessionUserid()+" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ getSessionUserlevel : "+sessionForm.getSessionUserlevel()+" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//        }
//        
//        return checkMenu(sessionForm.getSessionAdminGroup(), accessInfo);
//    }
//    
//    public boolean containAdminRoll(String[] roles){
//        
//        if ( roles == null) 
//            return false;
//    
//        for ( int i =0 ; i < roles.length ; i++) {
//            if (StringUtil.nvl(roles[i]).equals("admin") )
//                return true;
//        }
//        
//        return false;
//    }
//    
//    /**
//     * ��Ʈ���� role�� ����Ǿ��ִ� ���ڸ�
//     * �������·� �ٲپ��ش�
//     * @param authStr
//     * @return
//     */
//    public int getAuthLevel(String authStr) {
//        
//        int auth = 0;
//        
//        if(authStr == null || authStr.equals("")) {
//            auth = 0;
//        } else if(authStr.equals("guest")) {
//            auth = 0;
//        } else if(authStr.equals("user")) {
//            auth = 10;
//        } else if(authStr.equals("admin")) {
//            auth = 70;
//        }
//        
//        return auth;
//    }
//    
//    
//    /**
//     * �����ڱ׷� ���� ����Ʈ ��������
//     * Ű - �����ڱ׷� group_code
//     * @param actionobj
//     * @return
//     * @throws SystemException
//     */
//    public boolean checkMenuAuth(String groupcode, AccessorInfo accessorInfo) {
//        
//        String uri = accessorInfo.getAccessor_Uri();
//        boolean isauth = false;
//        
//        //System.out.println("checking menuAuth form db...");
//        
//        try {
//            QueryManager qm = new QueryManager(poolName);
//            StringBuffer sql = new StringBuffer();
//            sql.append("SELECT                                                                      \n");
//            sql.append(" b.menu_code, a.group_code, b.menu_name, b.menu_uri                         \n");
//            sql.append(" from CDW_admin_auth a join CDW_admin_menu b on a.menu_code = b.menu_code \n");
//            sql.append(" where a.group_code = ? and b.menu_uri like ?                           \n");
//
//            qm.setInt(1, Integer.parseInt(groupcode));
//            qm.setString(2,uri+"%");
//            
//            AkResultSet rs = qm.executeQuery(sql);
//            
//            if(rs.next()) {
//                //System.out.println("Return menu_uri : " + rs.getString("menu_uri"));
//                if ( uri.endsWith("board.do")) {
//                    do {
//                        HashMap params = getParameters(rs.getString("menu_uri"));
//                        
//                        String boardid = (String)accessorInfo.getParameter("boardid");
//                        String boardid2 = (String)params.get("boardid");
//                        
//                        if ( boardid != null && boardid2 != null && boardid.equals(boardid2)){
//                            isauth = true;
//                            break;
//                        }
//                        
//                    } while(rs.next());
//                
//                }else {
//                    isauth = true;
//                }
//                
//                
//                
//            } else {
//                
//                //System.out.println("No Records.");
//                isauth = false;
//            }
//
//        } catch(Exception e) {
//            isauth = false;
//            e.printStackTrace();
//            
//        }
//        
//        return isauth;
//    }
//    
//    /**
//     * �����ڱ׷� ���� �޴����� üũ
//     * Ű - �����ڱ׷� group_code
//     * @param actionobj
//     * @return
//     * @throws SystemException
//     */
//    public boolean checkMenu(String groupcode, AccessorInfo accessorInfo) {
//        
//        String uri = accessorInfo.getAccessor_Uri();
//        boolean isauth = false;
//        
//        //System.out.println("checking menu form db...");
//        
//        try {
//            QueryManager qm = new QueryManager(poolName);
//            StringBuffer sql = new StringBuffer();
//            sql.append("SELECT                                                                      \n");
//            sql.append(" b.menu_code, a.group_code, b.menu_name, b.menu_uri                         \n");
//            sql.append(" from CDW_admin_auth a join CDW_admin_menu b on a.menu_code = b.menu_code \n");
//            sql.append(" where a.group_code = ?                             \n");
//
//            qm.setInt(1, Integer.parseInt(groupcode));
//            
//            //System.out.println("GroupCode : " + groupcode);
//
//            AkResultSet rs = qm.executeQuery(sql);
//            
//            if(rs.next()) {
//                
//                isauth = true;
//                
//                //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!! �޴� ���� !!!!!!!!!!!!!!!!!!!!");
//                
//            } else {
//                
//                //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!! �޴� ���� !!!!!!!!!!!!!!!!!!!!");
//                isauth = false;
//            }
//
//        } catch(Exception e) {
//            isauth = false;
//            e.printStackTrace();
//            
//        }
//        
//        return isauth;
//    }
//    
//    protected HashMap getParameters(String url) {
//        HashMap hashMap = new HashMap();
//        
//        if ( url != null) {
//        
//            if ( url.indexOf('?') > -1 ) {
//                
//                String paramString = url.substring(url.indexOf('?')+1);
//                
//                try {
//                    StringTokenizer tokens = new StringTokenizer(paramString,"&");
//                    
//                    if(tokens.hasMoreTokens()) {
//                        String token = tokens.nextToken();
//                        
//                        //System.out.println("ù��° ��ū ==========> " + token);
//                    
//                        StringTokenizer paramToken = new StringTokenizer(token,"=");
//                    
//                        hashMap.put(paramToken.nextToken(), paramToken.nextToken());
//                    } else {
//                        StringTokenizer tokens_ = new StringTokenizer(paramString,"=");
//                        
//                        if(tokens_.hasMoreTokens()) {
//                            hashMap.put(tokens_.nextToken(), tokens_.nextToken());
//                        }
//                    }
//                }catch (Exception e) {
//                    e.printStackTrace();
//                }
//            
//            }           
//        }
//        
//        return hashMap;
//    }
//    
//    public void setSessionSMS(String randomSms) {
//        
//        HttpSession session = getRequest().getSession();
//        
//        session.setAttribute(InitClass.RANDOM_SMS, randomSms);
//    }
//    
//    public String getSessionSMS() {
//        HttpSession session = getRequest().getSession();
//        String randomSms = (String)session.getAttribute(InitClass.RANDOM_SMS);
//        
//        if ( randomSms == null ) {
//            return "";
//        } else {
//            return randomSms;
//        }
//    }
//
//    //�����PC���� ���
//    public void setMoblieSession() {
//        
//        HttpSession session = getRequest().getSession(true);
//
//        session.setAttribute("SESSION_MOBLIE_YN", "Y");
//        
//        System.out.println(">>>>Set SESSION_MOBLIE: Y");
//    }    
//
//      public String getMoblieSession() {
//          
//          HttpSession session = getRequest().getSession(true);
//          String Moblie_PC = (String)session.getAttribute("SESSION_MOBLIE_YN");
//          System.out.println(">>>>Get SESSION_MOBLIE:"+Moblie_PC);
//          return Moblie_PC ;
//      }  
    
}
