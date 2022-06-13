package ak_web.service;

public class SessionForm implements java.io.Serializable {
    
    String sessionRole = "";
    String sessionName = "";
    String sessionUserid = "";
    String sessionUserlevel = "0";
    String sessionAdminGroup = "0";
    String sessionLoginTime = "";
    String sessionOnlineCardNo = "";
    String sessionRegno = "";
    String sessionEngName = "";
    String sessionUnifyYn = ""; // SSO 인증 통합회원여부 Y:통합회원, N:미통합회원

    String sessionCusNo = "";       //로그인 고객번호
    String sessionAttendCusNo = ""; //수강자 고객번호
    String sessionAttendCusNm = ""; //수강자 고객명
    String sessionAKmemCusNo = "";  //AKmem 고객번호
    String sessionAKmemCardNo = ""; //AKmem 카드번호
    String sessionAttendAgeGubun = ""; //수강자 성인/유아구분(A성인,C유아)
    String sessionAttendStore = "";    //수강_점
    
    String sessionIp = "";
    String sessionId = "";
    
    String sessionDi = "";        // DI 값 추가 (2013.04.03)
    String sessionCi = "";        // CI 값 추가 (2017.05.25)
    String sessionBirthYmd = "";  // BirthYmd 값 추가 (2013.06.13)
    
    String sessionMemType = "";  // MemType 값 추가 (2016.02.02)
    
    public String getSessionDi() {
        return sessionDi;
    } 
    public void setSessionDi(String sessionDi) {
        this.sessionDi = sessionDi;
    }
    public String getSessionCi() {
        return sessionCi;
    } 
    public void setSessionCi(String sessionCi) {
        this.sessionCi = sessionCi;
    }
    public void setSessionAttendCusNo       ( String sessionAttendCusNo         ) { this.sessionAttendCusNo             = sessionAttendCusNo           ; }
    public void setSessionAttendCusNm       ( String sessionAttendCusNm         ) { this.sessionAttendCusNm             = sessionAttendCusNm           ; }
    public void setSessionAKmemCusNo       ( String sessionAKmemCusNo           ) { this.sessionAKmemCusNo              = sessionAKmemCusNo           ; }
    public void setSessionAKmemCardNo      ( String sessionAKmemCardNo          ) { this.sessionAKmemCardNo             = sessionAKmemCardNo           ; }    
    public void setSessionUnifyYn          ( String sessionUnifyYn              ) { this.sessionUnifyYn                 = sessionUnifyYn           ; }
    public void setSessionAttendStore       ( String sessionAttendStore         ) { this.sessionAttendStore             = sessionAttendStore           ; }
        
    public String getSessionAttendCusNo            () { return sessionAttendCusNo           ; }
    public String getSessionAttendCusNm            () { return sessionAttendCusNm           ; }
    public String getSessionAKmemCusNo             () { return sessionAKmemCusNo           ; }
    public String getSessionAKmemCardNo            () { return sessionAKmemCardNo           ; }
    public String getSessionUnifyYn                () { return sessionUnifyYn           ; }
    public String getSessionAttendStore            () { return sessionAttendStore           ; }
    
    boolean sessionAuthChecked = false;

    public String getSessionRole() {
        return sessionRole;
    }

    public void setSessionRole(String sessionRole) {
        this.sessionRole = sessionRole;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionUserid() {
        return sessionUserid;
    }

    public void setSessionUserid(String sessionUserid) {
        this.sessionUserid = sessionUserid;
    }

    public String getSessionUserlevel() {
        return sessionUserlevel;
    }

    public void setSessionUserlevel(String sessionUserlevel) {
        this.sessionUserlevel = sessionUserlevel;
    }

    public boolean isSessionAuthChecked() {
        return sessionAuthChecked;
    }

    public String getSessionAdminGroup() {
        return sessionAdminGroup;
    }

    public void setSessionAdminGroup(String sessionAdminGroup) {
        this.sessionAdminGroup = sessionAdminGroup;
    }
    
    public void setSessionAuthChecked(boolean sessionAuthChecked) {
        this.sessionAuthChecked = sessionAuthChecked;
    }

    public String getSessionCusNo() {
        return sessionCusNo;
    }

    public void setSessionCusNo(String sessionCusNo) {
        this.sessionCusNo = sessionCusNo;
    }

    public String getSessionOnlineCardNo() {
        return sessionOnlineCardNo;
    }

    public void setSessionOnlineCardNo(String sessionOnlineCardNo) {
        this.sessionOnlineCardNo = sessionOnlineCardNo;
    }

    public String getSessionLoginTime() {
        return sessionLoginTime;
    }

    public void setSessionLoginTime(String sessionLoginTime) {
        this.sessionLoginTime = sessionLoginTime;
    }
    
    

    public String getSessionRegno() {
        return sessionRegno;
    }

    public void setSessionRegno(String sessionRegno) {
        this.sessionRegno = sessionRegno;
    }
    

    public String getSessionEngName() {
        return sessionEngName;
    }

    public void setSessionEngName(String sessionEngName) {
        this.sessionEngName = sessionEngName;
    }

    public void setAuthChecked(boolean checked) {
        this.setSessionAuthChecked(checked);
    }

    public String getSessionIp() {
        return sessionIp;
    }

    public void setSessionIp(String sessionIp) {
        this.sessionIp = sessionIp;
    }
    
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    public String getSessionAttendAgeGubun() {
        return sessionAttendAgeGubun;
    }

    public void setSessionAttendAgeGubun(String sessionAttendAgeGubun) {
        this.sessionAttendAgeGubun = sessionAttendAgeGubun;
    }
    public String getSessionBirthYmd() {
        return sessionBirthYmd;
    }
    public void setSessionBirthYmd(String sessionBirthYmd) {
        this.sessionBirthYmd = sessionBirthYmd;
    }
    
    public String getSessionMemType() {
        return sessionMemType;
    }
    public void setSessionMemType(String sessionMemType) {
        this.sessionMemType = sessionMemType;
    }
	
}
