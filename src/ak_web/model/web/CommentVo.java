package ak_web.model.web;

/**
*
* <pre>
* 1. PROJ : 애경 맴버쉽 시스템 구축 - 어드민
* 2. NAME : CommentVO
* 3. DESC : 게시판을 관리하는 ValueOvject 클레스 이다
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
public class CommentVo extends AKVo {

	private String indexno; //코멘트인덱스번호
	private String boardno; //게시판번호
	private String id; //글쓴이아이디
	private String name; //글쓴이이름
	private String nickname; //글쓴이닉네임
	private String content; //내용
	private String writeday; //작성일
	private String ip; //글쓴이이아피
	
	private int pageSize; //코멘트페이지사이즈
	private int page; //코멘트페이지
	
	public String getIndexno() {
		return indexno;
	}
	public void setIndexno(String indexno) {
		this.indexno = indexno;
	}
	public String getBoardno() {
		return boardno;
	}
	public void setBoardno(String boardno) {
		this.boardno = boardno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
	
}
