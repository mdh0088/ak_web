package ak_web.model.web;

public class FileUploadVo extends AKVo {

	private String indexno; //파일인덱스
	private String boardno; //게시글번호
	private String originalFileName; //원본파일이름
	private String tempFileName; //저장파일이름
	private String fileSavePath; //서버저장경로
	private String fileSize; //파일사이즈
	private String uploadDate; //업로드날짜
	private int fileDownCount; //다운로드카운트
	
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
	public String getBoardno() {
		return boardno;
	}
	public void setBoardno(String boardno) {
		this.boardno = boardno;
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
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public int getFileDownCount() {
		return fileDownCount;
	}
	public void setFileDownCount(int fileDownCount) {
		this.fileDownCount = fileDownCount;
	}
	
	
}
