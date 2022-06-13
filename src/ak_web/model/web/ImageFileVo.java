package ak_web.model.web;

public class ImageFileVo extends AKVo {

	private String indexno; //파일인덱스
	private String originalFileName; //원본파일이름
	private String tempFileName; //저장파일이름
	private String fileSavePath; //서버저장경로
	private String fileSize; //파일사이즈
	private int originalWidthSize; //원본넓이크기
	private int originalHeightSize; //원본높이크기
	private String thumbnailFilePath; //썸네일서버저장경로
	private String thumbnailFileName; //썸네일파일이름
	private String uploadDate; //업로드날짜
	
	private int viewWidthSize; //화면에 보이는 크기
	private int viewHeightSize; //화면에 보이는 크기
	
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
	public String getThumbnailFilePath() {
		return thumbnailFilePath;
	}
	public void setThumbnailFilePath(String thumbnailFilePath) {
		this.thumbnailFilePath = thumbnailFilePath;
	}
	public String getThumbnailFileName() {
		return thumbnailFileName;
	}
	public void setThumbnailFileName(String thumbnailFileName) {
		this.thumbnailFileName = thumbnailFileName;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public int getViewWidthSize() {
		return viewWidthSize;
	}
	public void setViewWidthSize(int viewWidthSize) {
		this.viewWidthSize = viewWidthSize;
	}
	public int getViewHeightSize() {
		return viewHeightSize;
	}
	public void setViewHeightSize(int viewHeightSize) {
		this.viewHeightSize = viewHeightSize;
	}
	
	
}
