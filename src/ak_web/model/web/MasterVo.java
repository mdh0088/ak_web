package ak_web.model.web;

/**
*
* <pre>
* 1. PROJ : 애경 맴버쉽 시스템 구축 - 어드민
* 2. NAME : MasterVo
* 3. DESC : 게시판마스터를 관리하는 ValueOvject 클레스 이다
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
public class MasterVo extends AKVo {

	private String id; //게시판아이디
	private String name; //게시판이름
	private int type; //게시판타입
	private String skin; //스킨타입
	private String description; //게시판설명
	private int page;
	private int pageSize;
	private int totalcount;
	
	private int permission_list; //리스트보기권한
	private int permission_view; //본문보기권한
	private int permission_write; //글작성권한
	private int permission_reply; //답글달기권한
	private int permission_comment; //코멘트달기권한
	private int permission_download; //파일다운로드권한
	private int permission_delete; //글삭제권한
	
	private String option_reply = "N"; //답글사용여부
	private String option_reply_limit = "N"; //본문글에만답글허용여부
	private String option_comment = "N"; //코멘트사용여부
	private String option_comment_limit = "N"; //본문글에만코멘트허용여부
	private String option_secret = "N"; //비밀글사용여부
	private String option_tagcloud = "N"; //태그클라우드사용여부
	private String option_password = "N"; //게시판비밀번호사용여부
	private String option_htmltag = "N"; //HTML태그사용여부
	private String option_recommend = "N"; //추천사용여부
	private String option_visit = "Y"; //조회수사용여부
	private String option_subscription = "N";
	
	private String option_fileupload = "N"; //파일업로드허용여부
	private int file_limit; //업로드파일갯수제한
	private String file_extension_limit; //파일확장자업로드제한
	private int file_size_limit; //파일사이즈제한
	
	private String category_type; //카테고리타입
	
	private int paging_block_limit; //페이징블럭겟수
	private int list_recode_limit; //리스트레코드수
	private int imageboard_width_limit; //이미지게시판일경우가로겟수
	private int imageboard_height_limit; //이미지게시판일경우세로겟수
	private int small_image_width = 0; //썸네일이미지 가로사이즈
	private int small_image_height = 0; //썸네일이미지 세로사이즈
	private int image_max_width = 0; //이미지게시판최대가로사이즈
	private int image_max_height = 0; //이미지게시판최대세로사이즈
	
	private String event_not_content = "N"; //이벤트게시판본문없음여부
	
	private String create_date; //게시판생성일
	
	private String list_point_code; //리스트 시 발생 포인트
	private String view_point_code; //조회시 발생 포인트
	private String write_point_code; //등록시 발생 포인트
	private String reply_point_code; //리플작성시 발생포인트
	private String comment_point_code; //코멘트 작성시 발생포인트
	private String download_point_code; //다운로드시 발생 포인트
	private String delete_point_code; //글삭제시 발생 포인트
	
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

	public String getDelete_point_code() {
		return delete_point_code;
	}

	public void setDelete_point_code(String delete_point_code) {
		this.delete_point_code = delete_point_code;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPermission_list() {
		return permission_list;
	}

	public void setPermission_list(int permission_list) {
		this.permission_list = permission_list;
	}

	public int getPermission_view() {
		return permission_view;
	}

	public void setPermission_view(int permission_view) {
		this.permission_view = permission_view;
	}

	public int getPermission_write() {
		return permission_write;
	}

	public void setPermission_write(int permission_write) {
		this.permission_write = permission_write;
	}

	public int getPermission_reply() {
		return permission_reply;
	}

	public void setPermission_reply(int permission_reply) {
		this.permission_reply = permission_reply;
	}

	public int getPermission_comment() {
		return permission_comment;
	}

	public void setPermission_comment(int permission_comment) {
		this.permission_comment = permission_comment;
	}

	public int getPermission_download() {
		return permission_download;
	}

	public void setPermission_download(int permission_download) {
		this.permission_download = permission_download;
	}

	public String getOption_reply() {
		return option_reply;
	}

	public void setOption_reply(String option_reply) {
		this.option_reply = option_reply;
	}

	public String getOption_reply_limit() {
		return option_reply_limit;
	}

	public void setOption_reply_limit(String option_reply_limit) {
		this.option_reply_limit = option_reply_limit;
	}

	public String getOption_comment() {
		return option_comment;
	}

	public void setOption_comment(String option_comment) {
		this.option_comment = option_comment;
	}

	public String getOption_comment_limit() {
		return option_comment_limit;
	}

	public void setOption_comment_limit(String option_comment_limit) {
		this.option_comment_limit = option_comment_limit;
	}

	public String getOption_secret() {
		return option_secret;
	}

	public void setOption_secret(String option_secret) {
		this.option_secret = option_secret;
	}

	public String getOption_tagcloud() {
		return option_tagcloud;
	}

	public void setOption_tagcloud(String option_tagcloud) {
		this.option_tagcloud = option_tagcloud;
	}

	public String getOption_password() {
		return option_password;
	}

	public void setOption_password(String option_password) {
		this.option_password = option_password;
	}

	public String getOption_htmltag() {
		return option_htmltag;
	}

	public void setOption_htmltag(String option_htmltag) {
		this.option_htmltag = option_htmltag;
	}

	public String getOption_recommend() {
		return option_recommend;
	}

	public void setOption_recommend(String option_recommend) {
		this.option_recommend = option_recommend;
	}

	public String getOption_visit() {
		return option_visit;
	}

	public void setOption_visit(String option_visit) {
		this.option_visit = option_visit;
	}

	public String getOption_fileupload() {
		return option_fileupload;
	}

	public void setOption_fileupload(String option_fileupload) {
		this.option_fileupload = option_fileupload;
	}

	public int getFile_limit() {
		return file_limit;
	}

	public void setFile_limit(int file_limit) {
		this.file_limit = file_limit;
	}

	public String getFile_extension_limit() {
		return file_extension_limit;
	}

	public void setFile_extension_limit(String file_extension_limit) {
		this.file_extension_limit = file_extension_limit;
	}

	public int getFile_size_limit() {
		return file_size_limit;
	}

	public void setFile_size_limit(int file_size_limit) {
		this.file_size_limit = file_size_limit;
	}

	public String getCategory_type() {
		return category_type;
	}

	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}

	public int getPaging_block_limit() {
		return paging_block_limit;
	}

	public void setPaging_block_limit(int paging_block_limit) {
		this.paging_block_limit = paging_block_limit;
	}

	public int getList_recode_limit() {
		return list_recode_limit;
	}

	public void setList_recode_limit(int list_recode_limit) {
		this.list_recode_limit = list_recode_limit;
	}

	public int getImageboard_width_limit() {
		return imageboard_width_limit;
	}

	public void setImageboard_width_limit(int imageboard_width_limit) {
		this.imageboard_width_limit = imageboard_width_limit;
	}

	public int getImageboard_height_limit() {
		return imageboard_height_limit;
	}

	public void setImageboard_height_limit(int imageboard_height_limit) {
		this.imageboard_height_limit = imageboard_height_limit;
	}

	public int getSmall_image_width() {
		return small_image_width;
	}

	public void setSmall_image_width(int small_image_width) {
		this.small_image_width = small_image_width;
	}

	public int getSmall_image_height() {
		return small_image_height;
	}

	public void setSmall_image_height(int small_image_height) {
		this.small_image_height = small_image_height;
	}

	public int getImage_max_width() {
		return image_max_width;
	}

	public void setImage_max_width(int image_max_width) {
		this.image_max_width = image_max_width;
	}

	public int getImage_max_height() {
		return image_max_height;
	}

	public void setImage_max_height(int image_max_height) {
		this.image_max_height = image_max_height;
	}

	public String getEvent_not_content() {
		return event_not_content;
	}

	public void setEvent_not_content(String event_not_content) {
		this.event_not_content = event_not_content;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getList_point_code() {
		return list_point_code;
	}

	public void setList_point_code(String list_point_code) {
		this.list_point_code = list_point_code;
	}

	public String getView_point_code() {
		return view_point_code;
	}

	public void setView_point_code(String view_point_code) {
		this.view_point_code = view_point_code;
	}

	public String getWrite_point_code() {
		return write_point_code;
	}

	public void setWrite_point_code(String write_point_code) {
		this.write_point_code = write_point_code;
	}

	public String getReply_point_code() {
		return reply_point_code;
	}

	public void setReply_point_code(String reply_point_code) {
		this.reply_point_code = reply_point_code;
	}

	public String getComment_point_code() {
		return comment_point_code;
	}

	public void setComment_point_code(String comment_point_code) {
		this.comment_point_code = comment_point_code;
	}

	public String getDownload_point_code() {
		return download_point_code;
	}

	public void setDownload_point_code(String download_point_code) {
		this.download_point_code = download_point_code;
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

	public int getPermission_delete() {
		return permission_delete;
	}

	public void setPermission_delete(int permission_delete) {
		this.permission_delete = permission_delete;
	}

	public String getOption_subscription() {
		return option_subscription;
	}

	public void setOption_subscription(String option_subscription) {
		this.option_subscription = option_subscription;
	}
	
	
}

