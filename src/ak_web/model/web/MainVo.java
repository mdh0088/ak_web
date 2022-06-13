package ak_web.model.web;


import java.util.List;

import ak_web.classes.FileUploadRequestWrapper;


/**
*
* <pre>
* 1. PROJ : 애경 맴버쉽 시스템 구축 - 어드민
* 2. NAME : MainVo
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
public class MainVo extends AKVo {

	private String indexno; //게시판인덱스번호
	private String boardid; //게시판아이디
	private String category; //게시판카테고리
	private String userid; //사용자아이디
	private String password; //게시글비밀번호
	private String name; //사용자이름
	private String nickname; //사용자닉네임
	private String email; //사용자이메일
	private String homepage; //사용자홈페이지
	private String title; //제목
	private String content; //본문
	private int visit; //조회수
	private int comment_count; //코멘트 수
	private String secret; //비밀글여부
	private String notice; //공지사항여부
	private String htmltag; //HTML태그사용여부
	private String tagcloud; //태그클라우드
	private int commend; //추천수
	private String event_url; //이벤트URL
	private String event_list_image; //이벤트리스트이미지
	
	private String event_start_date; //이벤트시작일
	private String event_end_date; //이벤트종료일
	private String event_lot_date; //이벤트추첨일
	private String write_start_date; // 등록일 검색조건 (시작일)
	private String write_end_date; // 등록일 검색조건 (종료일)
	private String writeday; //작성일
	private String subscription; //예약노출일
	
	private String ip; //사용자아이피
	private String ref; //원본글번호
	private int step; //X측넓이
	private int lev; //Y측높이
	private String categoryname; //카테고리이름
	private String categorykind; //카테고리종류
	
	private int startRow; //시작하는검색Row수
	private int endRow; //끝나는검색Row수
	
	private String searchType; //검색구분
	private String searchText; //검색단어
	
	private String newRecode; //새로등록된글
	
	private String small_path; //썸네일이미지경로
	private String small_name; //썸네일이미지파일이
	
	private int page; //현제페이지
	
	private int pageSize; //리스트페이지사이즈
	private String categoryType; //카테고리종류
	
	private String refuserid; //답글장성자아이디
	private String refname; //답글장성자이름
	
	private String pindexno; //답글 인덱스번호
	private String pref; //답글 원본글번호
	private String pstep; //답글 X측넓이
	
	private List indexnoList; //자식글번호 리스트
	
	private EventImageVo eventImageVo; //이벤트이미지파일 빈
	private FileUploadVo fileUploadVo; //업로드파일 빈
	private ImageFileVo imageFileVo; //이미지파일 빈
	private CommentVo commentVo; //코멘트 빈
	private List fileUploadList; //파일업로드 리스트
	private List commentList; //코멘트 리스트
	
	private String popupKey; //팝업종류
	private String popupFileName; //팝업으로보는 이미지파일이름
	private String popupViewURL; //팝업으로보는 이미지파일경로
	private int popupOriginalWidthSize; //팝업으로보는 원본 넓이 크기
	private int popupOriginalHeightSize; //팝업으로보는 원본 높이 크기
	
	private MasterVo masterVo; //게시판정보 빈
	
	private String errorMsg; //에러 메시지
	private boolean errorCheck; //에러여부
	
	private FileUploadRequestWrapper requestWrap; //파일업로드 리케스트 와퍼
	
	private SkinVo skinVo; //스킨 빈
	private String eventState; //이벤트 종류
	private CategoryVo categoryVo; //카테고리 빈
	private List categoryList; //카테고리리스트
	private List noticeList; //공지사항리스트
	private List list; //게시글 리스트
	private int totalCount; //게시글 카운트
	private String smallImageURL; //썸네일 이미지 보이는 경로
	private String eventImageURL; //이벤트게시판 보이는 경로
	private String forwardName; //리턴될 타일즈 이름
	private MainVo mainVo; //게시글 빈
	private String categoryView; //카테고리 검색시 필요한 키
	private String description; //게시글에 대한 설명
	private String[] selectValues; //게시글 복수 선택
	
	private String commentIndexno; //코멘트 인덱스번호
	private String imageViewURL; //이미지파일경로
	private String thumbnailViewURL; //썸네일이미지파일경로
	
	private String address1; //주소1
	private String address2; //주소2
	private String user_email; //사용자 이메일
	private String user_phone; //사용자 휴대폰
	
	private String boardfile; //보드파일 임시1
	private String imagefile; //이미지파일 임시2
	private String eventfile; //이벤트파일 임시3
	
	private int seqno; //시퀀스
	
	private int comment_pageSize; //코멘트페이지사이즈
	private int comment_page; //코멘트페이지
	
	private String choice; //이벤트 채택자 여부
	
	private String prevIndexNo; //이전글 인덱스번호
	private String prevTitle; //이전글 제목
	private String nextIndexNo; //다음글 인덱스 번호
	private String nextTitle; //다음글 제목
	
	private String fileViewURL; //파일이미지일때보기경로
	
	private String tag; //태그
	private int tagCount; //태그카운트
	
	private String subscription_use_check; //예약노출일 사용여부 체크
	
	private String sortkey;
	private String sorttype;
	private String eventDateUse; //노출기간 사용 여부
	
    private String event_code;
	public String getEvent_code() {
        return event_code;
    }

    public void setEvent_code(String event_code) {
        this.event_code = event_code;
    }

    public int getTagCount() {
		return tagCount;
	}

	public void setTagCount(int tagCount) {
		this.tagCount = tagCount;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getIndexno() {
		return indexno;
	}

	public void setIndexno(String indexno) {
		this.indexno = indexno;
	}

	public String getBoardid() {
		return boardid;
	}

	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getVisit() {
		return visit;
	}

	public void setVisit(int visit) {
		this.visit = visit;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getHtmltag() {
		return htmltag;
	}

	public void setHtmltag(String htmltag) {
		this.htmltag = htmltag;
	}

	public String getTagcloud() {
		return tagcloud;
	}

	public void setTagcloud(String tagcloud) {
		this.tagcloud = tagcloud;
	}

	public int getCommend() {
		return commend;
	}

	public void setCommend(int commend) {
		this.commend = commend;
	}

	public String getEvent_url() {
		return event_url;
	}

	public void setEvent_url(String event_url) {
		this.event_url = event_url;
	}

	public String getEvent_list_image() {
		return event_list_image;
	}

	public void setEvent_list_image(String event_list_image) {
		this.event_list_image = event_list_image;
	}

	public String getEvent_start_date() {
		return event_start_date;
	}

	public void setEvent_start_date(String event_start_date) {
		this.event_start_date = event_start_date;
	}

	public String getEvent_end_date() {
		return event_end_date;
	}

	public void setEvent_end_date(String event_end_date) {
		this.event_end_date = event_end_date;
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

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategorykind() {
		return categorykind;
	}

	public void setCategorykind(String categorykind) {
		this.categorykind = categorykind;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
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

	public String getNewRecode() {
		return newRecode;
	}

	public void setNewRecode(String newRecode) {
		this.newRecode = newRecode;
	}

	public String getSmall_path() {
		return small_path;
	}

	public void setSmall_path(String small_path) {
		this.small_path = small_path;
	}

	public String getSmall_name() {
		return small_name;
	}

	public void setSmall_name(String small_name) {
		this.small_name = small_name;
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

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getRefuserid() {
		return refuserid;
	}

	public void setRefuserid(String refuserid) {
		this.refuserid = refuserid;
	}

	public String getRefname() {
		return refname;
	}

	public void setRefname(String refname) {
		this.refname = refname;
	}
	
	public String getPindexno() {
		return pindexno;
	}

	public void setPindexno(String pindexno) {
		this.pindexno = pindexno;
	}
	
	public String getPref() {
		return pref;
	}

	public void setPref(String pref) {
		this.pref = pref;
	}

	public String getPstep() {
		return pstep;
	}

	public void setPstep(String pstep) {
		this.pstep = pstep;
	}

	public List getIndexnoList() {
		return indexnoList;
	}

	public void setIndexnoList(List indexnoList) {
		this.indexnoList = indexnoList;
	}

	public EventImageVo getEventImageVo() {
		return eventImageVo;
	}

	public void setEventImageVo(EventImageVo eventImageVo) {
		this.eventImageVo = eventImageVo;
	}

	public FileUploadVo getFileUploadVo() {
		return fileUploadVo;
	}

	public void setFileUploadVo(FileUploadVo fileUploadVo) {
		this.fileUploadVo = fileUploadVo;
	}

	public ImageFileVo getImageFileVo() {
		return imageFileVo;
	}

	public void setImageFileVo(ImageFileVo imageFileVo) {
		this.imageFileVo = imageFileVo;
	}

	public CommentVo getCommentVo() {
		return commentVo;
	}

	public void setCommentVo(CommentVo commentVo) {
		this.commentVo = commentVo;
	}

	public List getFileUploadList() {
		return fileUploadList;
	}

	public void setFileUploadList(List fileUploadList) {
		this.fileUploadList = fileUploadList;
	}

	public List getCommentList() {
		return commentList;
	}

	public void setCommentList(List commentList) {
		this.commentList = commentList;
	}

	public String getPopupKey() {
		return popupKey;
	}

	public void setPopupKey(String popupKey) {
		this.popupKey = popupKey;
	}

	public String getPopupFileName() {
		return popupFileName;
	}

	public void setPopupFileName(String popupFileName) {
		this.popupFileName = popupFileName;
	}

	public String getPopupViewURL() {
		return popupViewURL;
	}

	public void setPopupViewURL(String popupViewURL) {
		this.popupViewURL = popupViewURL;
	}

	public int getPopupOriginalWidthSize() {
		return popupOriginalWidthSize;
	}

	public void setPopupOriginalWidthSize(int popupOriginalWidthSize) {
		this.popupOriginalWidthSize = popupOriginalWidthSize;
	}

	public int getPopupOriginalHeightSize() {
		return popupOriginalHeightSize;
	}

	public void setPopupOriginalHeightSize(int popupOriginalHeightSize) {
		this.popupOriginalHeightSize = popupOriginalHeightSize;
	}

	public MasterVo getMasterVo() {
		return masterVo;
	}

	public void setMasterVo(MasterVo masterVo) {
		this.masterVo = masterVo;
	}

	public FileUploadRequestWrapper getRequestWrap() {
		return requestWrap;
	}

	public void setRequestWrap(FileUploadRequestWrapper requestWrap) {
		this.requestWrap = requestWrap;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public boolean isErrorCheck() {
		return errorCheck;
	}

	public void setErrorCheck(boolean errorCheck) {
		this.errorCheck = errorCheck;
	}

	public SkinVo getSkinVo() {
		return skinVo;
	}

	public void setSkinVo(SkinVo skinVo) {
		this.skinVo = skinVo;
	}

	public String getEventState() {
		return eventState;
	}

	public void setEventState(String eventState) {
		this.eventState = eventState;
	}

	public CategoryVo getCategoryVo() {
		return categoryVo;
	}

	public void setCategoryVo(CategoryVo categoryVo) {
		this.categoryVo = categoryVo;
	}

	public List getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List categoryList) {
		this.categoryList = categoryList;
	}

	public List getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List noticeList) {
		this.noticeList = noticeList;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getSmallImageURL() {
		return smallImageURL;
	}

	public void setSmallImageURL(String smallImageURL) {
		this.smallImageURL = smallImageURL;
	}

	public String getEventImageURL() {
		return eventImageURL;
	}

	public void setEventImageURL(String eventImageURL) {
		this.eventImageURL = eventImageURL;
	}

	public String getForwardName() {
		return forwardName;
	}

	public void setForwardName(String forwardName) {
		this.forwardName = forwardName;
	}

	public MainVo getMainVo() {
		return mainVo;
	}

	public void setMainVo(MainVo mainVo) {
		this.mainVo = mainVo;
	}

	public String getCategoryView() {
		return categoryView;
	}

	public void setCategoryView(String categoryView) {
		this.categoryView = categoryView;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getSelectValues() {
		return selectValues;
	}

	public void setSelectValues(String[] selectValues) {
		this.selectValues = selectValues;
	}

	public String getCommentIndexno() {
		return commentIndexno;
	}

	public void setCommentIndexno(String commentIndexno) {
		this.commentIndexno = commentIndexno;
	}

	public String getImageViewURL() {
		return imageViewURL;
	}

	public void setImageViewURL(String imageViewURL) {
		this.imageViewURL = imageViewURL;
	}

	public String getThumbnailViewURL() {
		return thumbnailViewURL;
	}

	public void setThumbnailViewURL(String thumbnailViewURL) {
		this.thumbnailViewURL = thumbnailViewURL;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getBoardfile() {
		return boardfile;
	}

	public void setBoardfile(String boardfile) {
		this.boardfile = boardfile;
	}

	public String getImagefile() {
		return imagefile;
	}

	public void setImagefile(String imagefile) {
		this.imagefile = imagefile;
	}

	public String getEventfile() {
		return eventfile;
	}

	public void setEventfile(String eventfile) {
		this.eventfile = eventfile;
	}

	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public int getComment_pageSize() {
		return comment_pageSize;
	}

	public void setComment_pageSize(int comment_pageSize) {
		this.comment_pageSize = comment_pageSize;
	}

	public int getComment_page() {
		return comment_page;
	}

	public void setComment_page(int comment_page) {
		this.comment_page = comment_page;
	}

	public String getEvent_lot_date() {
		return event_lot_date;
	}

	public void setEvent_lot_date(String event_lot_date) {
		this.event_lot_date = event_lot_date;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getPrevIndexNo() {
		return prevIndexNo;
	}

	public void setPrevIndexNo(String prevIndexNo) {
		this.prevIndexNo = prevIndexNo;
	}

	public String getPrevTitle() {
		return prevTitle;
	}

	public void setPrevTitle(String prevTitle) {
		this.prevTitle = prevTitle;
	}

	public String getNextIndexNo() {
		return nextIndexNo;
	}

	public void setNextIndexNo(String nextIndexNo) {
		this.nextIndexNo = nextIndexNo;
	}

	public String getNextTitle() {
		return nextTitle;
	}

	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}

	public String getFileViewURL() {
		return fileViewURL;
	}

	public void setFileViewURL(String fileViewURL) {
		this.fileViewURL = fileViewURL;
	}

	public String getWrite_start_date() {
		return write_start_date;
	}

	public void setWrite_start_date(String write_start_date) {
		this.write_start_date = write_start_date;
	}

	public String getWrite_end_date() {
		return write_end_date;
	}

	public void setWrite_end_date(String write_end_date) {
		this.write_end_date = write_end_date;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	public String getSubscription_use_check() {
		return subscription_use_check;
	}

	public void setSubscription_use_check(String subscription_use_check) {
		this.subscription_use_check = subscription_use_check;
	}

	public String getSortkey() {
		return sortkey;
	}

	public void setSortkey(String sortkey) {
		this.sortkey = sortkey;
	}

	public String getSorttype() {
		return sorttype;
	}

	public void setSorttype(String sorttype) {
		this.sorttype = sorttype;
	}
	
	public String getEventDateUse() {
		return eventDateUse;
	}

	public void setEventDateUse(String eventDateUse) {
		this.eventDateUse = eventDateUse;
	}
	
	
}
