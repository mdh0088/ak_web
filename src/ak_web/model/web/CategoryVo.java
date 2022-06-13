package ak_web.model.web;

/**
*
* <pre>
* 1. PROJ : 애경 맴버쉽 시스템 구축 - 어드민
* 2. NAME : CategoryVO
* 3. DESC : 카테고리를 관리하는 ValueOvject 클레스 이다
* </pre>
* 
* @author  블루웨이브, 김성복
* @version 1.0, 2008/11/04
* @see
* 
*/
/*------------------------------------------------------------------------------
*                            변         경         사         항                       
*-------------------------------------------------------------------------------
*    DATE       AUTHOR                       DESCRIPTION                        
*------------- -------- --------------------------------------------------------
* 2008/11/04    김성복       최초 작성                    
*-------------------------------------------------------------------------------
*/
public class CategoryVo extends AKVo {

	private String kind;
	private String category;
	private String description;
	
	private String ip;
	private String userid;
	
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
