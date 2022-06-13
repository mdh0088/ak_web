package ak_web.model.web;

/**
*
* <pre>
* 1. PROJ : 애경 맴버쉽 시스템 구축 - 어드민
* 2. NAME : SkinVo
* 3. DESC : 스킨을 관리하는 ValueOvject 클레스 이다
* </pre>
* 
* @author  블루웨이브, 김성복
* @version 1.0, 2008/11/03
* @see
* 
*/
/*------------------------------------------------------------------------------
*                            변         경         사         항                       
*-------------------------------------------------------------------------------
*    DATE       AUTHOR                       DESCRIPTION                        
*------------- -------- --------------------------------------------------------
* 2008/11/03    김성복       최초 작성                    
*-------------------------------------------------------------------------------
*/
public class SkinVo extends AKVo {

	private int page;
	private int pageSize;
	private int totalcount;
	private String skinname;
	private String list_name;
	private String content_name;
	private String updateform_name;
	private String writeform_name;
	
	private String skinname_old;
	
	private String userid;
	private String ip;
	
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSkinname() {
		return skinname;
	}

	public void setSkinname(String skinname) {
		this.skinname = skinname;
	}

	public String getList_name() {
		return list_name;
	}

	public void setList_name(String list_name) {
		this.list_name = list_name;
	}

	public String getContent_name() {
		return content_name;
	}

	public void setContent_name(String content_name) {
		this.content_name = content_name;
	}

	public String getUpdateform_name() {
		return updateform_name;
	}

	public void setUpdateform_name(String updateform_name) {
		this.updateform_name = updateform_name;
	}

	public String getWriteform_name() {
		return writeform_name;
	}

	public void setWriteform_name(String writeform_name) {
		this.writeform_name = writeform_name;
	}

	public String getSkinname_old() {
		return skinname_old;
	}

	public void setSkinname_old(String skinname_old) {
		this.skinname_old = skinname_old;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	
	
}
