package ak_web.vo;

public class AdminVo extends AKVo {

	private String adminid;
	private String password;
	private String name;
	private String juminid;

	private String phone;
	private String email;
	private String part;
	private String status;
	private String start_date;
	private String end_date;
	private String group_code;
	private String reg_date;
	private String group_name;
	private String old_id;
	
	private int page;
	
	boolean overID = false;
	
	private String searchGroup;
	private String searchType;
	private String searchText;

	private String ip;
	private String indexno;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIndexno() {
		return indexno;
	}

	public void setIndexno(String indexno) {
		this.indexno = indexno;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getJuminid() {
		return juminid;
	}

	public void setJuminid(String juminid) {
		this.juminid = juminid;
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

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getGroup_code() {
		return group_code;
	}

	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	
	public String getOld_id() {
		return old_id;
	}

	public void setOld_id(String old_id) {
		this.old_id = old_id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isOverID() {
		return overID;
	}

	public void setOverID(boolean overID) {
		this.overID = overID;
	}

	public String getSearchGroup() {
		return searchGroup;
	}

	public void setSearchGroup(String searchGroup) {
		this.searchGroup = searchGroup;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	
}
