package ak_web.model.web;

import java.util.List;

import ak_web.classes.Utils;

public class LectureVo extends AKVo {
	
    private String hq                ; //�����ڵ�
    private String store             ; //���ڵ�
    private String period            ; //���
    private String main_cd           ; //���� ��з��ڵ�
    private String main_nm           ; //���� ��з���
    private String main_contents     ; //���� ��з� contents
    private String sect_cd           ; //���� �ߺз��ڵ�
    private String sect_nm           ; //���� �ߺз���
    private int    sect_nm_len       ; //���� �ߺз������
    private String sect_contents     ; //���� �ߺз� contents
    private String subject_cd        ; //�����ڵ�
    private String subject_nm        ; //���¸�
    private String day               ; //����
    private String lect_hour         ; //���ǽð�
    private int    lect_cnt          ; //����Ƚ��
    private String classroom         ; //���ǽ�
    private String lecturer_cd       ; //����
    private String start_ymd         ; //���ǽ�����
    private String end_ymd           ; //����������
    private int    capacity_no       ; //������
    private int    regis_no          ; //����μ�
    private int    web_capacity_no   ; //��������
    private int    web_regis_no      ; //������μ�
    private int    half_regis_no     ; //�ݾ��ο�
    private int    dc_cnt            ; //20%�����ο�
    private String subject_fg        ; //����/�ܱⱸ��
    private double regis_fee         ; //������
    private String close_yn          ; //���¸�������
    private String food_yn           ; //��������
    private double food_amt          ; //����
    private String web_lecturer_nm   ; //���ͳݰ����
    private String corp_fg           ; //���������ο���
    private String month_no          ; //���ư��°�����
    private String month_no1         ; //���ư��°�����
    private String creator           ; //�����
    private String create_ymd        ; //�����
    private int    mid_regis_no      ; //�ߵ�������û�� ��
    private double mid_regis_amt     ; //�ߵ�������û�ݾ�
    private int    manage_capacity_no; //��������
    private int    possible_no       ; //������������ο�
    private String lecturer_nm       ; //WEB �����
    private String lecturer_career   ; //WEB ������
    private String lecture_content   ; //WEB ���³���
    private String lecturer_comment  ; //WEB �߰�����
    private String etc               ; //WEB etc
    private String image_pic         ; //WEB �̹���
    private String cust_nm           ; //����
    private int    lect_part         ; //���½ð�(?����)
    private double enuri_per         ; //��������
    private String number            ; //���� �� �����ڵ�
    private String sessionAttendCusNo; //������ ����ȣ
    private String custNo;
    private String regNo;
    private String attendCustNo; //���� ����ȣ
    private String attendCustNm; //���� ����
    private String ipAddress;
    private String sessionId;
    private String lecttempfg;
    private String aKmemCardNo;
    private String cardfg; 			  		 //ī����ڵ� 
    private String backpack;                 //å���� ��� ����. (Y :��� N: �ο� ���̱�)
    private double f_regis_fee; 			 //������
    
    private boolean flag1; 			  		 //10ȸ�̸�
    private boolean flag2; 			  		 //10ȸ�̻�
    private boolean flag3; 			  		 //AK����ī�� ���� ����
    private boolean flag4; 			  		 //���Ӽ����� ���������  ����    
    private boolean flag5; 			  		 //���Ӽ����� ���������  ��뿩��    
    private boolean flag6; 			  		 //�ż� ���� ����
    private boolean flag7; 			  		 //�ż����� ������
    private boolean flag8; 			  		 //�Ⱓ,ȸ�� ���� ����
    private boolean flag9; 			  		 //�Ⱓ ���� ��� ����
    private boolean flag11; 			  		 //6������ ����
    
    private double free_fee; 				//���Ӽ����� ���������
    private double free_fee2; 				//���Ӽ����� ���������
    private double new_enuri_amt; 			//�ż����� ���αݾ�
    
    private List mainCdList;
    private List sectCdList;
    private List list;
    private List sublist;
    private LectureVo lecture; //��������
    
    
    private int file_no;
    private String file_nm;
    private String file_size;
    
    private String sale_ymd        ;   // �������� (�¶��� ��ҷ� �߰� 2012.06.20)
    private String pos_no          ;
    private String recpt_no        ;   // ������������ȣ  (�¶��� ��ҷ� �߰� 2012.06.20)
    
    private String org_sale_ymd    ;   // ���ŷ� �������� (2012.07.11) 
    private String org_ack_no      ;   // ���ŷ� ���ι�ȣ (2012.07.11)
    private String cardNo ;            // ī���ȣ (2012.07.11)
    
    private double card_amt         ;  // ī��ݾ� (2012.07.11)
    private String van_fg ;            // ī����κ���(2012.07.11) 
    
    private String sale_time       ;   // �����ð�(���ϸ� �߼����� �߰� 13.02.20)
    private String user_id         ;   // �α��� ���̵� (���Ϲ߼����� �߰� 13.02.20)
    
    private String sReceiptGb;         //���� �˻� ���� ����
    
    private String regi_date; 			//��� �����
    private String state_nm;			//��� ����(���/���/���)
    
    private String akcard_yn;          // AK���� ī�� ���� (����� �������� ���� 2014.07) 
    private double good_mny         ;  // KCP�� ���� ���� �ݾ� 2014.07
    private String enc_data         ;
    private String enc_info         ;
    private String tran_cd          ;

	private String site_cd          ;
    private String site_key         ;
    private String ordr_idxx        ;
    private String tid              ;
    
    private int gift_enuri_fg;  //������ ���� (0:�̻��,1:������,2:���αݾ�)
    private int gift_user_enuri;  //������� �� ������
    private int gift_date_enuri;  //���Ⱓ ������
    private int gift_date_enuri2;  //���Ⱓ2 ������
    private String gift_date_from;  //���Ⱓ ������
    private String gift_date_to;  //���Ⱓ ������
    private String gift_date_from2;  //���Ⱓ ������
    private String gift_date_to2;  //���Ⱓ ������2
    private double dayEnuri; 			//�ż����� ���αݾ�
    
    private String tot_subject_cd;  //�Ѱ��������ڵ�
    private String tot_enuri1_cd;  //�Ѱ��������ڵ�
    private String tot_enuri2_cd;  //�Ѱ��������ڵ�
    private String tot_enuri1_amt;  //�Ѱ��������ڵ�
    private String tot_enuri2_amt;  //�Ѱ��������ڵ�
    
    private String akmem_recpt_no; 	//����� ��������ȣ
    
    private String akKBcard_yn;       // AK���� ī�� ���� (�߰� 2017.09)
    
    private String akWBcard_yn;     // AK�츮 ī�� ����
    
    
	public String getAkWBcard_yn() {
        return akWBcard_yn;
    }
    public void setAkWBcard_yn(String akWBcard_yn) {
        this.akWBcard_yn = akWBcard_yn;
    }
    public String getAkmem_recpt_no() {
		return akmem_recpt_no;
	}
	public void setAkmem_recpt_no(String akmem_recpt_no) {
		this.akmem_recpt_no = akmem_recpt_no;
	}
	public String getTot_subject_cd() {
		return tot_subject_cd;
	}
	public void setTot_subject_cd(String tot_subject_cd) {
		this.tot_subject_cd = tot_subject_cd;
	}
	
	public String getTot_enuri1_cd() {
		return tot_enuri1_cd;
	}
	public void setTot_enuri1_cd(String tot_enuri1_cd) {
		this.tot_enuri1_cd = tot_enuri1_cd;
	}
	public String getTot_enuri2_cd() {
		return tot_enuri2_cd;
	}
	public void setTot_enuri2_cd(String tot_enuri2_cd) {
		this.tot_enuri2_cd = tot_enuri2_cd;
	}
	public String getTot_enuri1_amt() {
		return tot_enuri1_amt;
	}
	public void setTot_enuri1_amt(String tot_enuri1_amt) {
		this.tot_enuri1_amt = tot_enuri1_amt;
	}
	public String getTot_enuri2_amt() {
		return tot_enuri2_amt;
	}
	public void setTot_enuri2_amt(String tot_enuri2_amt) {
		this.tot_enuri2_amt = tot_enuri2_amt;
	}
	// set
    public void setHq                ( String hq                 ) { this.hq                 = hq                ; }
    public void setStore             ( String store              ) { this.store              = store             ; }
    public void setPeriod            ( String period             ) { this.period             = period            ; }
    public void setMain_cd           ( String main_cd            ) { this.main_cd            = main_cd           ; }
    public void setMain_nm           ( String main_nm            ) { this.main_nm            = main_nm           ; }
    public void setMain_contents     ( String main_contents      ) { this.main_contents      = main_contents     ; }
    public void setSect_cd           ( String sect_cd            ) { this.sect_cd            = sect_cd           ; }
    public void setSect_nm           ( String sect_nm            ) { this.sect_nm            = sect_nm           ; }
    public void setSect_nm_len       ( int    sect_nm_len        ) { this.sect_nm_len        = sect_nm_len       ; }
    public void setSect_contents     ( String sect_contents      ) { this.sect_contents      = sect_contents     ; }
    public void setSubject_cd        ( String subject_cd         ) { this.subject_cd         = subject_cd        ; }
    public void setSubject_nm        ( String subject_nm         ) { this.subject_nm         = subject_nm        ; }
    public void setDay               ( String day                ) { this.day                = day               ; }
    public void setLect_hour         ( String lect_hour          ) { this.lect_hour          = lect_hour         ; }
    public void setLect_cnt          ( int    lect_cnt           ) { this.lect_cnt           = lect_cnt          ; }
    public void setClassroom         ( String classroom          ) { this.classroom          = classroom         ; }
    public void setLecturer_cd       ( String lecturer_cd        ) { this.lecturer_cd        = lecturer_cd       ; }
    public void setStart_ymd         ( String start_ymd          ) { this.start_ymd          = start_ymd         ; }
    public void setEnd_ymd           ( String end_ymd            ) { this.end_ymd            = end_ymd           ; }
    public void setCapacity_no       ( int    capacity_no        ) { this.capacity_no        = capacity_no       ; }
    public void setRegis_no          ( int    regis_no           ) { this.regis_no           = regis_no          ; }
    public void setWeb_capacity_no   ( int    web_capacity_no    ) { this.web_capacity_no    = web_capacity_no   ; }
    public void setWeb_regis_no      ( int    web_regis_no       ) { this.web_regis_no       = web_regis_no      ; }
    public void setHalf_regis_no     ( int    half_regis_no      ) { this.half_regis_no      = half_regis_no     ; }
    public void setDc_cnt            ( int    dc_cnt             ) { this.dc_cnt             = dc_cnt            ; }
    public void setSubject_fg        ( String subject_fg         ) { this.subject_fg         = subject_fg        ; }
    public void setRegis_fee         ( double regis_fee          ) { this.regis_fee          = regis_fee         ; }
    public void setClose_yn          ( String close_yn           ) { this.close_yn           = close_yn          ; }
    public void setFood_yn           ( String food_yn            ) { this.food_yn            = food_yn           ; }
    public void setFood_amt          ( double food_amt           ) { this.food_amt           = food_amt          ; }
    public void setWeb_lecturer_nm   ( String web_lecturer_nm    ) { this.web_lecturer_nm    = web_lecturer_nm   ; }
    public void setCorp_fg           ( String corp_fg            ) { this.corp_fg            = corp_fg           ; }
    public void setMonth_no          ( String month_no           ) { this.month_no           = month_no          ; }
    public void setMonth_no1         ( String month_no1          ) { this.month_no1          = month_no1         ; }
    public void setCreator           ( String creator            ) { this.creator            = creator           ; }
    public void setCreate_ymd        ( String create_ymd         ) { this.create_ymd         = create_ymd        ; }
    public void setMid_regis_no      ( int    mid_regis_no       ) { this.mid_regis_no       = mid_regis_no      ; }
    public void setMid_regis_amt     ( double mid_regis_amt      ) { this.mid_regis_amt      = mid_regis_amt     ; }
    public void setManage_capacity_no( int    manage_capacity_no ) { this.manage_capacity_no = manage_capacity_no; }
    public void setPossible_no       ( int    possible_no        ) { this.possible_no        = possible_no       ; }
    public void setLecturer_nm       ( String lecturer_nm        ) { this.lecturer_nm        = lecturer_nm       ; }
    public void setLecturer_career   ( String lecturer_career    ) { this.lecturer_career    = lecturer_career   ; }
    public void setLecture_content   ( String lecture_content    ) { this.lecture_content    = lecture_content   ; }
    public void setLecturer_comment  ( String lecturer_comment   ) { this.lecturer_comment   = lecturer_comment  ; }
    public void setEtc               ( String etc                ) { this.etc                = etc               ; }
    public void setImage_pic         ( String image_pic          ) { this.image_pic          = image_pic         ; }
    public void setCust_nm           ( String cust_nm            ) { this.cust_nm            = cust_nm           ; }
    public void setLect_part         ( int    lect_part          ) { this.lect_part          = lect_part         ; }
    public void setEnuri_per         ( double enuri_per          ) { this.enuri_per          = enuri_per         ; }   
    public void setNumber            ( String number             ) { this.number             = number            ; }
    public void setSessionAttendCusNo( String sessionAttendCusNo ) { this.sessionAttendCusNo = sessionAttendCusNo; }
    public void setCustNo			 ( String custNo 			 ) { this.custNo 			 = custNo			 ; }
    public void setRegNo			 ( String regNo 			 ) { this.regNo 			 = regNo			 ; }
    public void setAttendCustNo		 ( String attendCustNo 		 ) { this.attendCustNo 		 = attendCustNo		 ; }
    public void setAttendCustNm		 ( String attendCustNm 		 ) { this.attendCustNm 		 = attendCustNm		 ; }
    public void setIpAddress		 ( String ipAddress 		 ) { this.ipAddress 		 = ipAddress		 ; }
    public void setSessionId		 ( String sessionId 		 ) { this.sessionId 		 = sessionId		 ; }
    public void setLecttempfg        ( String lecttempfg         ) { this.lecttempfg         = lecttempfg        ; }
    public void setAKmemCardNo       ( String aKmemCardNo        ) { this.aKmemCardNo        = aKmemCardNo       ; }
    public void setBackpack          ( String backpack           ) { this.backpack           = backpack          ; }
    public void setFile_nm           ( String file_nm            ) { this.file_nm            = file_nm           ; }
    public void setFile_size         ( String file_size          ) { this.file_size          = file_size         ; }
    public void setCardNo            ( String cardNo             ) { this.cardNo             = cardNo            ; }
    public void setFile_no           ( int    file_no        	 ) { this.file_no        	 = file_no       	 ; }
    public void setCard_amt          ( double card_amt           ) { this.card_amt           = card_amt          ; } 
    public void setLecture           ( LectureVo lecture         ) { this.lecture            = lecture           ; }
    public void setSublist           ( List sublist              ) { this.sublist            = sublist           ; }
    public void setList              ( List list                 ) { this.list               = list              ; }
    public void setMainCdList        ( List mainCdList           ) { this.mainCdList       = mainCdList          ; }
    public void setSectCdList        ( List sectCdList           ) { this.sectCdList       = sectCdList          ; }
    
    /*AK���� 5%�������� ���� ����(10.10.28) */
    public void setCardfg            ( String cardfg             ) { this.cardfg             = cardfg            ; }
    public void setF_regis_fee       ( double f_regis_fee        ) { this.f_regis_fee        = f_regis_fee       ; }
    public void setFlag1             ( boolean flag1             ) { this.flag1              = flag1             ; }
    public void setFlag2             ( boolean flag2             ) { this.flag2              = flag2             ; }    
    public void setFlag3             ( boolean flag3             ) { this.flag3              = flag3             ; }
    public void setFlag4             ( boolean flag4             ) { this.flag4              = flag4             ; }
    public void setFlag5             ( boolean flag5             ) { this.flag5              = flag5             ; }
    public void setFlag6             ( boolean flag6             ) { this.flag6              = flag6             ; }  
    public void setFlag7             ( boolean flag7             ) { this.flag7              = flag7             ; }
    public void setFlag8             ( boolean flag8             ) { this.flag8              = flag8             ; }
    public void setFlag9             ( boolean flag9             ) { this.flag9              = flag9             ; }
    public void setFlag11           ( boolean flag11            ) { this.flag11            = flag11            ; }
    public void setFree_fee          ( double free_fee           ) { this.free_fee           = free_fee          ; }
    public void setFree_fee2          ( double free_fee2           ) { this.free_fee2           = free_fee2          ; }
    public void setNew_enuri_amt     ( double new_enuri_amt      ) { this.new_enuri_amt      = new_enuri_amt     ; }
    public void setRecpt_no          ( String recpt_no           ) { this.recpt_no           = recpt_no          ; }
    public void setSale_ymd          ( String sale_ymd           ) { this.sale_ymd           = sale_ymd          ; }
    public void setOrg_ack_no        ( String org_ack_no         ) { this.org_ack_no         = org_ack_no        ; }
    public void setOrg_sale_ymd      ( String org_sale_ymd       ) { this.org_sale_ymd       = org_sale_ymd      ; }    
    public void setVan_fg            ( String van_fg             ) { this.van_fg             = van_fg            ; }
    
    public void setRegi_date         ( String regi_date          ) { this.regi_date          = regi_date         ; }
    public void setState_nm          ( String state_nm           ) { this.state_nm           = state_nm          ; }
    public void setSReceiptGb        ( String sReceiptGb         ) { this.sReceiptGb         = sReceiptGb        ; }
    public void setUser_id           ( String user_id            ) { this.user_id            = user_id           ; }
    public void setSale_time         ( String sale_time          ) { this.sale_time          = sale_time         ; }
    
    //�Ⱓ,�� �������
    public void setGift_enuri_fg(int gift_enuri_fg) {		this.gift_enuri_fg = gift_enuri_fg;	}
	public void setGift_user_enuri(int gift_user_enuri) {		this.gift_user_enuri = gift_user_enuri;	}
	public void setGift_date_enuri(int gift_date_enuri) {		this.gift_date_enuri = gift_date_enuri;	}
	public void setGift_date_enuri2(int gift_date_enuri2) {		this.gift_date_enuri2 = gift_date_enuri2;	}
	public void setGift_date_from(String gift_date_from) {		this.gift_date_from = gift_date_from;	}
	public void setGift_date_to(String gift_date_to) {		this.gift_date_to = gift_date_to;	}
	public void setGift_date_from2(String gift_date_from2) {		this.gift_date_from2 = gift_date_from2;	}
	public void setGift_date_to2(String gift_date_to2) {		this.gift_date_to2 = gift_date_to2;	}
	public void setDayEnuri(double dayEnuri) {		this.dayEnuri = dayEnuri;	}

    
    /* AK����ī�� ���� (2014.07.10) */
    public void setAkcard_yn         ( String akcard_yn          ) { this.akcard_yn          = akcard_yn         ; }    
    public void setGood_mny          ( double good_mny           ) { this.good_mny           = good_mny          ; }
    public void setEnc_data          ( String enc_data           ) { this.enc_data           = enc_data          ; }
    public void setEnc_info          ( String enc_info           ) { this.enc_info           = enc_info          ; }
    public void setTran_cd           ( String tran_cd            ) { this.tran_cd            = tran_cd           ; }
    public void setSite_cd           ( String site_cd            ) { this.site_cd            = site_cd           ; }
    public void setSite_key          ( String site_key           ) { this.site_key           = site_key           ; }
    public void setOrdr_idxx         ( String ordr_idxx          ) { this.ordr_idxx          = ordr_idxx         ; }
    public void setTid               ( String tid                ) { this.tid                = tid         ; }
    public void setAkKBcard_yn         ( String akKBcard_yn          ) { this.akKBcard_yn          = akKBcard_yn         ; }
    
    // get
    public String getHq                () { return hq                ; }
    public String getStore             () { return store             ; }
    public String getPeriod            () { return period            ; }
    public String getMain_cd           () { return main_cd           ; }
    public String getMain_nm           () { return main_nm           ; }
    public String getMain_contents     () { return main_contents     ; }
    public String getSect_cd           () { return sect_cd           ; }
    public String getSect_nm           () { return sect_nm           ; }
    public int    getSect_nm_len       () { return sect_nm_len       ; }
    public String getSect_contents     () { return sect_contents     ; }
    public String getSubject_cd        () { return subject_cd        ; }
    public String getSubject_nm        () { return subject_nm        ; }
    public String getDay               () { return day               ; }
    public String getLect_hour         () { return lect_hour         ; }
    public int    getLect_cnt          () { return lect_cnt          ; }
    public String getClassroom         () { return classroom         ; }
    public String getLecturer_cd       () { return lecturer_cd       ; }
    public String getStart_ymd         () { return start_ymd         ; }
    public String getEnd_ymd           () { return end_ymd           ; }
    public int    getCapacity_no       () { return capacity_no       ; }
    public int    getRegis_no          () { return regis_no          ; }
    public int    getWeb_capacity_no   () { return web_capacity_no   ; }
    public int    getWeb_regis_no      () { return web_regis_no      ; }
    public int    getHalf_regis_no     () { return half_regis_no     ; }
    public int    getDc_cnt            () { return dc_cnt            ; }
    public String getSubject_fg        () { return subject_fg        ; }
    public double getRegis_fee         () { return regis_fee         ; }
    public String getClose_yn          () { return close_yn          ; }
    public String getFood_yn           () { return food_yn           ; }
    public double getFood_amt          () { return food_amt          ; }
    public String getWeb_lecturer_nm   () { return web_lecturer_nm   ; }
    public String getCorp_fg           () { return corp_fg           ; }
    public String getMonth_no          () { return month_no          ; }
    public String getMonth_no1         () { return month_no1         ; }
    public String getCreator           () { return creator           ; }
    public String getCreate_ymd        () { return create_ymd        ; }
    public int    getMid_regis_no      () { return mid_regis_no      ; }
    public double getMid_regis_amt     () { return mid_regis_amt     ; }
    public int    getManage_capacity_no() { return manage_capacity_no; }
    public int    getPossible_no       () { return possible_no       ; }
    public String getLecturer_nm       () { return lecturer_nm       ; }
    public String getLecturer_career   () { return lecturer_career   ; }
    public String getLecture_content   () { return lecture_content   ; }
    public String getLecturer_comment  () { return lecturer_comment  ; }
    public String getEtc               () { return etc               ; }
    public String getImage_pic         () { return image_pic         ; }
    public String getCust_nm           () { return cust_nm           ; }
    public int    getLect_part         () { return lect_part         ; }
    public double getEnuri_per         () { return enuri_per         ; } 
    public String getNumber            () { return number            ; }
    public String getSessionAttendCusNo() { return sessionAttendCusNo; }
    public String getCustNo            () { return custNo            ; }
    public String getRegNo             () { return regNo             ; }
    public String getAttendCustNo      () { return attendCustNo      ; }
    public String getAttendCustNm      () { return attendCustNm      ; }
    public String getIpAddress         () { return ipAddress      	 ; }
    public String getSessionId         () { return sessionId      	 ; }
    public String getLecttempfg        () { return lecttempfg        ; }
    public String getAKmemCardNo       () { return aKmemCardNo       ; }
    public int    getFile_no           () { return file_no         	 ; }
    public String getFile_nm           () { return file_nm        	 ; }
    public String getFile_size         () { return file_size         ; }
    public String getBackpack          () { return backpack          ; }    
    public double getCard_amt          () { return card_amt          ; }
    public String getCardNo            () { return cardNo            ; }
    public List   getList              () {	return list              ; }
    public List   getSublist           () { return sublist           ; }
    public List   getMainCdList        () { return mainCdList        ; }
    public List   getSectCdList        () { return sectCdList        ; }
	public LectureVo getLecture        () { return lecture           ; }
    public boolean isFlag1             () { return flag1             ; }
    public boolean isFlag2             () { return flag2             ; }
    public boolean isFlag3             () { return flag3             ; }
    public boolean isFlag4             () { return flag4             ; }
    public boolean isFlag5             () { return flag5             ; }
    public boolean isFlag6             () { return flag6             ; }
    public boolean isFlag7             () { return flag7             ; }
    public boolean isFlag8             () { return flag8             ; }
    public boolean isFlag9             () { return flag9             ; }
    public boolean isFlag11             () { return flag11             ; }
    public double getFree_fee          () { return free_fee          ; }
    public double getFree_fee2          () { return free_fee2          ; }
    public double getNew_enuri_amt     () { return new_enuri_amt     ; }
    public String getRecpt_no          () { return recpt_no          ; }
    public String getOrg_sale_ymd      () { return org_sale_ymd      ; } 
    public String getOrg_ack_no        () { return org_ack_no        ; }
    public String getSale_ymd          () { return sale_ymd          ; }
    public String getVan_fg            () { return van_fg            ; }
    public double getF_regis_fee       () { return f_regis_fee       ; }
    /*AK���� 5%�������� ���� ����(10.10.28) */
    public String getCardfg            () { return cardfg            ; }
    public String getRegi_date         () {	return regi_date         ; }
    public String getState_nm          () { return state_nm          ; }
    
    public String getSReceiptGb        () { return sReceiptGb        ; }
    public String getUser_id           () { return user_id           ; }
    
    public String getSale_time         () { return sale_time         ; }
    
    /* ��ٱ��� ���� �ݾ� (2014.07.10) */
    public String getAkcard_yn         () { return akcard_yn         ; }
    public double getGood_mny          () { return good_mny          ; }
    public String getEnc_data          () { return enc_data          ; }
    public String getEnc_info          () { return enc_info          ; }
    public String getTran_cd           () { return tran_cd           ; }
    public String getSite_cd           () { return site_cd           ; }
    public String getSite_key          () { return site_key          ; }
    public String getOrdr_idxx         () { return ordr_idxx         ; }
    public String getTid               () { return tid               ; }
    public String getAkKBcard_yn         () { return akKBcard_yn         ; }
    
    
    /* ���� ���� ���� Start */
    private double dRegiAmt;
    private double dFoodAmt;
    private double dTotAmt;
    private double dTotalAmt;
    private String sAllot; //�Һ� ������
    private String sValidDt; //ī�� ��ȿ���
    private String akmem_card_status; //akmembers ī�����(����ī���̸� 00)
    private String sCardNo; //�����ſ�ī���ȣ
    private String sPwdNo; //ī���й�ȣ
    private String resi_fg; //����(1)/����(2)ī�屸��
    private String sResi_no; //�ֹι�ȣ ���ڸ�
    private String sBiz_no; //����� ��ȣ
    
    private double upointAmt;//20190420 ��� ���ϸ��� �赿�� 
    private String sSat_fg; //���� ���ϸ��� ��� �� ����
    
    public void setDRegiAmt          ( double dRegiAmt           ) { this.dRegiAmt           = dRegiAmt          ; }
    public void setDFoodAmt          ( double dFoodAmt           ) { this.dFoodAmt           = dFoodAmt          ; }
    public void setDTotAmt           ( double dTotAmt            ) { this.dTotAmt            = dTotAmt           ; }
    public void setDTotalAmt         ( double dTotalAmt          ) { this.dTotalAmt          = dTotalAmt         ; }
    public void setSAllot            ( String sAllot             ) { this.sAllot             = sAllot            ; }
    public void setSValidDt          ( String sValidDt           ) { this.sValidDt           = sValidDt          ; }
    public void setAkmem_card_status ( String akmem_card_status  ) { this.akmem_card_status  = akmem_card_status ; }
    public void setSCardNo           ( String sCardNo            ) { this.sCardNo            = sCardNo           ; }
    public void setSPwdNo            ( String sPwdNo             ) { this.sPwdNo             = sPwdNo            ; }
    public void setResi_fg           ( String resi_fg            ) { this.resi_fg            = resi_fg           ; }
    public void setSResi_no          ( String sResi_no           ) { this.sResi_no           = sResi_no          ; }
    public void setSBiz_no           ( String sBiz_no            ) { this.sBiz_no            = sBiz_no           ; }
    public void setPos_no            ( String pos_no             ) { this.pos_no             = pos_no            ; }
    
    public void setUPointAmt         ( double upointAmt          ) { this.upointAmt          = upointAmt         ; }
    public void setSat_fg            ( String sat_fg             ) { this.sSat_fg             = sat_fg            ; }
    
    public double getDRegiAmt          () { return dRegiAmt          ; }
    public double getDFoodAmt          () { return dFoodAmt          ; }
    public double getDTotAmt           () { return dTotAmt           ; }
    public double getDTotalAmt         () { return dTotalAmt         ; }
    public String getSAllot            () { return sAllot            ; }
    public String getSValidDt          () { return sValidDt          ; }
    public String getAkmem_card_status () { return akmem_card_status ; }
    public String getSCardNo           () { return sCardNo           ; }
    public String getSPwdNo            () { return sPwdNo            ; }
    public String getResi_fg           () { return resi_fg           ; }
    public String getSResi_no          () { return sResi_no          ; }
    public String getSBiz_no           () { return sBiz_no           ; }
    
    public double getUPointAmt         () { return upointAmt         ; }
    public String getSat_fg            () { return sSat_fg           ; }
    
    /* ���� ���� ���� End */
	public String getPos_no            () { return pos_no            ; }
	
    //�Ⱓ,�� �������
	public int getGift_enuri_fg() {		return gift_enuri_fg;	}
	public int getGift_user_enuri() {		return gift_user_enuri;	}
	public int getGift_date_enuri() {		return gift_date_enuri;	}
	public int getGift_date_enuri2() {		return gift_date_enuri2;	}
	public String getGift_date_from() {		return gift_date_from;	}
	public String getGift_date_to() {		return gift_date_to;	}
	public String getGift_date_from2() {		return gift_date_from2;	}
	public String getGift_date_to2() {		return gift_date_to2;	}
	public double getDayEnuri() {		return dayEnuri;	}
    
}
