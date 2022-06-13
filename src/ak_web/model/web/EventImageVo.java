package ak_web.model.web;

/**
*
* <pre>
* 1. PROJ : 애경 맴버쉽 시스템 구축 - 어드민
* 2. NAME : EventImageVO
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
public class EventImageVo extends AKVo {

	private String indexno; //파일인덱스
	private String originalFileName; //원본파일이름
	private String tempFileName; //저장파일이름
	private String fileSavePath; //서버저장경로
	private String fileSize; //파일사이즈
	private int originalWidthSize; //원본넓이크기
	private int originalHeightSize; //원본높이크기
	private String uploadDate; //업로드날짜
	
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
	public String getIndexno() {
		return indexno;
	}
	public void setIndexno(String indexno) {
		this.indexno = indexno;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getTempFileName() {
		return tempFileName;
	}
	public void setTempFileName(String tempFileName) {
		this.tempFileName = tempFileName;
	}
	public String getFileSavePath() {
		return fileSavePath;
	}
	public void setFileSavePath(String fileSavePath) {
		this.fileSavePath = fileSavePath;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public int getOriginalWidthSize() {
		return originalWidthSize;
	}
	public void setOriginalWidthSize(int originalWidthSize) {
		this.originalWidthSize = originalWidthSize;
	}
	public int getOriginalHeightSize() {
		return originalHeightSize;
	}
	public void setOriginalHeightSize(int originalHeightSize) {
		this.originalHeightSize = originalHeightSize;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	
}
