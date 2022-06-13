package ak_web.vo;

public class LoginVo extends AKVo {

	private String userid = "";
	private String passwd = "";
	private String juminid = "";
	private String user_name = "";
	private String regdate = "";
	private String login_ip;
	private String indexno;
	
	private String phone = "";
	private String email = "";
	
	private String onlineCardNo;
	private String cus_no;
	private String regno;
	private String eng_name;
	
    private String Unify_yn = ""; //SSO ���տ��� 
    private String CustNo = ""; //����ȣ
    private String AttendCustNo = ""; //������_����ȣ
    private String AttendCustNm = ""; //������_����
    private String AttendAgeGubun = ""; //������_�������� ����(A����,C����)
    private String AKmemCardNo = ""; //�α��ΰ����� AKmembers card no
    private String sessionId = ""; //����id
    private String AttendStore = ""; //����_��	
    
    private String di = "";         //DI �߰� (2013.04.03)
    private String ci = "";         //CI �߰� (2017.05.23)
    private String birthymd = "";   //�������(2013.06.13)
    
    private String memType = ""; //ȸ������(T:����ȸ��,S:����ȸ��)(2016.02.02)
        
	public String getBirthymd() {
        return birthymd;
    }
    public void setBirthymd(String birthymd) {
        this.birthymd = birthymd;
    }
    public String getOnlineCardNo() {
		return onlineCardNo;
	}
	public void setOnlineCardNo(String onlineCardNo) {
		this.onlineCardNo = onlineCardNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getJuminid() {
		return juminid;
	}
	public void setJuminid(String juminid) {
		this.juminid = juminid;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public String getIndexno() {
		return indexno;
	}
	public void setIndexno(String indexno) {
		this.indexno = indexno;
	}
	public String getCus_no() {
		return cus_no;
	}
	public void setCus_no(String cus_no) {
		this.cus_no = cus_no;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getEng_name() {
		return eng_name;
	}
	public void setEng_name(String eng_name) {
		this.eng_name = eng_name;
	}
	
    public String getUnifyYN(){
        return Unify_yn;
    }        
    public void setUnifyYN(String Unify_yn){
        this.Unify_yn = Unify_yn;
    }    
    
    public String getCustNo(){
        return CustNo;
    }        
    public void setCustNo(String CustNo){
        this.CustNo = CustNo;
    }    
    public String getAttendCustNo(){
        return AttendCustNo;
    }    
    public void setAttendCustNo(String AttendCustNo){
        this.AttendCustNo = AttendCustNo;
    }    
    public String getAttendAgeGubun(){
        return AttendAgeGubun;
    }    
    public void setAttendAgeGubun(String AttendAgeGubun){
        this.AttendAgeGubun = AttendAgeGubun;
    }    
    public String getAttendCustNm(){
        return AttendCustNm;
    }    
    public void setAttendCustNm(String AttendCustNm){
        this.AttendCustNm = AttendCustNm;
    }    
    public String getAKmemCardNo(){
        return AKmemCardNo;
    }    
    public void setAKmemCardNo(String AKmemCardNo){
        this.AKmemCardNo = AKmemCardNo;
    }
    
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

    public String getAttendStore() {
        return AttendStore;
    }
    public void setAttendStore(String AttendStore) {
        this.AttendStore = AttendStore;
    }
    public String getDi() {
        return di;
    }
    public void setDi(String di) {
        this.di = di;
    }
    public String getCi() {
        return ci;
    }
    public void setCi(String ci) {
        this.ci = ci;
    }
    
    public String getMemType() {
        return memType;
    }
    public void setMemType(String memType) {
        this.memType = memType;
    }
}
