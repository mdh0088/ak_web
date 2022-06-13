package ak_web.model.web;

import java.util.List;

public class MylectureVo extends AKVo {
	private String p_cust_no         ; //�θ�ȸ����ȣ
	private String c_cust_no         ; //�ڳ�ȸ����ȣ
	private String relation          ; //��������
    private String hq                ; //�����ڵ�
    private String store             ; //���ڵ�
    private String cust_nm           ; //����
    private String kor_nm            ; //����
    private String cust_no           ; //����ȣ 
  	private String resi_no           ; //�ֹι�ȣ
 	private String period            ;
 	private String new_cust_no       ;
	private String start_ymd         ;
	private String day               ;
	private String lect_hour 	     ;
	private String regis_fee         ;
	private String food_amt          ;//����
	private String subject_nm        ;
	private String lecturer_nm       ;
	private String image_pic         ;
	private String lecturer_career   ;
	private String lecture_content   ;
	private String lecturer_comment  ;
	private String enuri_percent     ;
	private String main_cd           ;
	private String check             ;//�������� ����Ʈ �����Ͱ� �ִ��� üũ
	private String etc				 ;
    private String pay_ymd           ; 
    private String pos_recpt         ; // NO.070013-0004�� ������
    private String hhmiss            ; // �ú�
    private String card_no           ;
    private String card_nm           ;
    private String approve_no        ;
    private String valid_date        ;
    private String inst_fg           ;
    private String inst_mm           ; // �Һΰ��� (���Ϲ߼۱��а� �ʿ�� �߰��� 13.02.18)
    private String coupon_fg         ;
    private String coupon_count      ;  
    private String coupon_no         ;
    private String coupon_amt        ;
    private String coupon_repay_amt  ;
    private String card_amt          ;
    private String trade_all_amt     ;
    private String net_sale_amt      ;
    private String enuri_amt         ;
    private String change            ;
    private String sub_tot_fee       ;
    private String regis_cancel_fg   ;
    private String cancel_ymd        ;
    private String webtextchk = "N"  ;
	private String end_ymd           ;
	private String subject_cd        ; 
	private String menu_num          ;//pop_upâ ����
    private String web_text          ;
 	private String str_check         ;
    private String period_start      ;
    private String period_end        ;
    private String pos_no            ;
    private String recpt_no          ;
    private String sale_ymd          ;
    private String sale_time         ; // �����ð� (���Ϲ߼۱��а� �ʿ�� �߰��� 13.02.14)
    private String sale_fg           ; // �������� [ ����:01,  ���:02 ] (���Ϲ߼۱��а� �ʿ�� �߰��� 13.02.18)
    
	private List   list              ;
    private List   web_text_list     ;
       
    private int    possible_no       ;
    private int    page              ;
    private int    totalCount        ; //�Խñ� ī��Ʈ
    
    private String di                ; // DI�߰� (2013.04.05)
    private String ci                ; // CI�߰� (2017.05.25)
    private String tid               ; // TID �߰�(2014.07.17)
    
    private String akmem_card_no    ;  //����� �������� �߰� - ī���ȣ (2013.09.26)
    private String akmem_custno     ;  //����� �������� �߰� - �����ȸ����ȣ  (2013.09.26)
    private String akmem_approve_no ;  //����� �������� �߰� - ���ι�ȣ (2013.09.26)
    private String akmem_recpt_point;  //����� �������� �߰� - ��ȸ���ϸ���  (2013.09.26)
    private String akmem_tot_point  ;  //����� �������� �߰� - ���� ���ϸ���  (2013.09.26)
    private String akmem_use_point  ;  //����� �������� �߰� - ��� ���ϸ���  (2019.05.15)
    
    private String pos_type;
    
    private String akcard_yn;          // AK���� ī�� ���� (����� �������� ���� 2014.07)
    private String akKBcard_yn;       // AK���� ī�� ���� (�߰� 2017.09)

    // set
	
	
    
   
    public void setCancel_ymd        ( String cancel_ymd         ) { this.cancel_ymd         = cancel_ymd        ; }
    public void setRegis_cancel_fg   ( String regis_cancel_fg    ) { this.regis_cancel_fg    = regis_cancel_fg   ; }
    public void setSub_tot_fee       ( String sub_tot_fee        ) { this.sub_tot_fee = sub_tot_fee              ; }
    public void setHhmiss            ( String hhmiss             ) { this.hhmiss = hhmiss                        ; }
    public void setDay				 ( String day                ) { this.day                = day               ; }            
	public void setLect_hour 		 ( String lect_hour          ) { this.lect_hour          = lect_hour         ; }      
	public void setRegis_fee 		 ( String regis_fee          ) { this.regis_fee          = regis_fee         ; }      
	public void setFood_amt 	     ( String food_amt           ) { this.food_amt           = food_amt          ; }      
	public void setSubject_nm 		 ( String subject_nm         ) { this.subject_nm         = subject_nm        ; }   
	public void setLecturer_nm 		 ( String lecturer_nm        ) { this.lecturer_nm        = lecturer_nm       ; }     
	public void setImage_pic  		 ( String image_pic          ) { this.image_pic          = image_pic         ; }     
	public void setLecturer_career 	 ( String lecturer_career    ) { this.lecturer_career    = lecturer_career   ; }
	public void setLecture_content 	 ( String lecture_content    ) { this.lecture_content    = lecture_content   ; }
	public void setLecturer_comment	 ( String lecturer_comment   ) { this.lecturer_comment   = lecturer_comment  ; }
	public void setEtc  			 ( String etc                ) { this.etc                = etc               ; }
	public void setEnd_ymd			 ( String end_ymd            ) { this.end_ymd            = end_ymd           ; }
	public void setStart_ymd         ( String start_ymd          ) { this.start_ymd          = start_ymd         ; }
	public void setSubject_cd        ( String subject_cd         ) { this.subject_cd         = subject_cd        ; }
	public void setHq                ( String hq                 ) { this.hq                 = hq                ; }
    public void setStore             ( String store              ) { this.store              = store             ; }
    public void setKor_nm            ( String kor_nm             ) { this.kor_nm             = kor_nm            ; }
    public void setCust_nm           ( String cust_nm            ) { this.cust_nm            = cust_nm           ; }
    public void setCust_no           ( String cust_no            ) { this.cust_no            = cust_no           ; }
    public void setC_cust_no         ( String c_cust_no          ) { this.c_cust_no          = c_cust_no         ; }
    public void setP_cust_no         ( String p_cust_no          ) { this.p_cust_no          = p_cust_no         ; }
    public void setRelation          ( String relation           ) { this.relation           = relation          ; } // get
    public void setResi_no           ( String resi_no            ) { this.resi_no            = resi_no           ; } 
    public void setPeriod            ( String period             ) { this.period             = period            ; }
    public void setNew_Cust_no       ( String new_cust_no        ) { this.new_cust_no        = new_cust_no       ; }
    public void setEnuri_percent     ( String enuri_percent      ) { this.enuri_percent      = enuri_percent     ; }
    public void setMain_cd           ( String main_cd            ) { this.main_cd            = main_cd           ; }
    public void setCheck             ( String check              ) { this.check              = check             ; }
    public void setMenu_num          ( String menu_num           ) { this.menu_num           = menu_num          ; }
    public void setStr_check         ( String str_check          ) { this.str_check          = str_check         ; }
    public void setWeb_text          ( String web_text           ) { this.web_text           = web_text          ; }
    public void setPeriod_start      ( String period_start       ) { this.period_start       = period_start      ; }
    public void setPeriod_end        ( String period_end         ) { this.period_end         = period_end        ; }
    public void setPos_no            ( String pos_no             ) { this.pos_no             = pos_no            ; }
    public void setRecpt_no          ( String recpt_no           ) { this.recpt_no           = recpt_no          ; }
    public void setSale_ymd          ( String sale_ymd           ) { this.sale_ymd           = sale_ymd          ; }    
    public void setPay_ymd           ( String pay_ymd            ) { this.pay_ymd            = pay_ymd           ; }
    public void setPos_recpt         ( String pos_recpt          ) { this.pos_recpt          = pos_recpt         ; }
    public void setWebtextchk        ( String webtextchk         ) { this.webtextchk         = webtextchk        ; }
    public void setApprove_no        ( String approve_no         ) { this.approve_no         = approve_no        ; }
    public void setCard_amt          ( String card_amt           ) { this.card_amt           = card_amt          ; }
    public void setCard_no           ( String card_no            ) { this.card_no            = card_no           ; }
    public void setChange            ( String change             ) { this.change             = change            ; }
    public void setCoupon_amt        ( String coupon_amt         ) { this.coupon_amt         = coupon_amt        ; }
    public void setCoupon_count      ( String coupon_count       ) { this.coupon_count       = coupon_count      ; }
    public void setCoupon_no         ( String coupon_no          ) { this.coupon_no          = coupon_no         ; }
    public void setCoupon_repay_amt  ( String coupon_repay_amt   ) { this.coupon_repay_amt   = coupon_repay_amt  ; }
    public void setEnuri_amt         ( String enuri_amt          ) { this.enuri_amt          = enuri_amt         ; }
    public void setInst_fg           ( String inst_fg            ) { this.inst_fg            = inst_fg           ; }
    public void setNet_sale_amt      ( String net_sale_amt       ) { this.net_sale_amt       = net_sale_amt      ; }
    public void setTrade_all_amt     ( String trade_all_amt      ) { this.trade_all_amt      = trade_all_amt     ; }
    public void setValid_date        ( String valid_date         ) { this.valid_date         = valid_date        ; }
    public void setCoupon_fg         ( String coupon_fg          ) { this.coupon_fg          = coupon_fg         ; }
    public void setCard_nm           ( String card_nm            ) { this.card_nm            = card_nm           ; }
    
    public void setPage              ( int page                  ) { this.page               = page              ; }
    public void setTotalCount        ( int totalCount            ) { this.totalCount         = totalCount        ; }
    public void setPossible_no       ( int possible_no           ) { this.possible_no        = possible_no       ; }
    
    public void setList              ( List list                 ) { this.list               = list              ; }
    public void setWeb_text_list     ( List web_text_list        ) { this.web_text_list      = web_text_list     ; }
    public void setPos_type          ( String pos_type           ) { this.pos_type           = pos_type          ; }
    public void setSale_time         ( String sale_time          ) { this.sale_time          = sale_time         ; }    
    public void setSale_fg           ( String sale_fg            ) { this.sale_fg            = sale_fg           ; }
    public void setInst_mm           ( String inst_mm            ) { this.inst_mm            = inst_mm           ; }
    public void setDi                ( String di                 ) { this.di                 = di                ; }
    public void setCi                ( String ci                 ) { this.ci                 = ci                ; }
    public void setAkmem_approve_no  ( String akmem_approve_no   ) { this.akmem_approve_no   = akmem_approve_no  ; }
    public void setAkmem_card_no     ( String akmem_card_no      ) { this.akmem_card_no      = akmem_card_no     ; }
    
    public void setAkmem_custno      ( String akmem_custno       ) { this.akmem_custno       = akmem_custno      ; }
    public void setAkmem_recpt_point ( String akmem_recpt_point  ) { this.akmem_recpt_point  = akmem_recpt_point ; }
    
    public void setAkmem_tot_point   ( String akmem_tot_point    ) { this.akmem_tot_point    = akmem_tot_point   ; }
    public void setAkmem_use_point   ( String akmem_use_point    ) { this.akmem_use_point    = akmem_use_point   ; }
    public void setTid               ( String tid                ) { this.tid                = tid               ; }
    /* AK����ī�� ���� (2014.07.10) */
    public void setAkcard_yn         ( String akcard_yn          ) { this.akcard_yn          = akcard_yn         ; }
    public void setAkKBcard_yn         ( String akKBcard_yn          ) { this.akKBcard_yn          = akKBcard_yn         ; }
    
    // get
    
    public String getEnuri_percent     () { return enuri_percent     ; }
    public String getDay			   () { return day               ; }			            
	public String getLect_hour 		   () { return lect_hour         ; }		 
	public String getRegis_fee 		   () { return regis_fee         ; }	    
	public String getFood_amt 	 	   () { return food_amt          ; }    
	public String getSubject_nm 	   () { return subject_nm        ; }	 
	public String getLecturer_nm 	   () { return lecturer_nm       ; }    
	public String getImage_pic  	   () { return image_pic         ; }     
	public String getLecturer_career   () { return lecturer_career   ; }
	public String getLecture_content   () { return lecture_content   ; }
	public String getLecturer_comment  () { return lecturer_comment  ; }
	public String getEtc  			   () { return etc         		 ; }
	public String getEnd_ymd		   () { return end_ymd         	 ; }
	public String getStart_ymd         () { return start_ymd         ; }
    public String getSubject_cd        () { return subject_cd        ; }
    public String getRelation          () { return relation          ; }
    public String getP_cust_no         () { return p_cust_no         ; }
	public String getC_cust_no         () { return c_cust_no         ; } 
	public String getCust_no           () { return cust_no           ; } 
	public String getCust_nm           () { return cust_nm           ; }
	public String getKor_nm            () { return kor_nm            ; }
	public String getHq                () { return hq                ; }
    public String getStore             () { return store             ; }
    public String getResi_no           () { return resi_no           ; }
    public String getPeriod            () { return period            ; }
    public String getNew_Cust_no       () { return new_cust_no       ; }
    public String getMain_cd           () { return main_cd           ; }
    public String getCheck             () { return check             ; }
    public String getMenu_num          () { return menu_num          ; } 
    public String getStr_check         () { return str_check         ; }
    public String getWeb_text          () { return web_text          ; }
    public String getPeriod_start      () { return period_start      ; }
    public String getPeriod_end        () { return period_end        ; }
    public String getPos_no            () { return pos_no            ; }
    public String getRecpt_no          () { return recpt_no          ; }
    public String getSale_ymd          () { return sale_ymd          ; }    
    public String getPay_ymd           () { return pay_ymd           ; }
    public String getPos_recpt         () { return pos_recpt         ; }
    public String getWebtextchk        () { return webtextchk        ; }
    public String getRegis_cancel_fg   () { return regis_cancel_fg   ; }
    public String getSub_tot_fee       () { return sub_tot_fee       ; }
    public String getHhmiss            () { return hhmiss            ; }
    public String getCancel_ymd        () { return cancel_ymd        ; }
    public String getApprove_no        () { return approve_no        ; }
    public String getCard_amt          () { return card_amt          ; }
    public String getCard_no           () { return card_no           ; }
    public String getChange            () { return change            ; }
    public String getCoupon_amt        () { return coupon_amt        ; }
    public String getCoupon_count      () { return coupon_count      ; }
    public String getCoupon_no         () { return coupon_no         ; }
    public String getCoupon_repay_amt  () { return coupon_repay_amt  ; }
    public String getEnuri_amt         () { return enuri_amt         ; }
    public String getNet_sale_amt      () { return net_sale_amt      ; }
    public String getTrade_all_amt     () { return trade_all_amt     ; }
    public String getValid_date        () { return valid_date        ; }
    public String getCoupon_fg         () { return coupon_fg         ; }
    public String getCard_nm           () { return card_nm           ; }
    public String getInst_fg           () { return inst_fg           ; }
    
    public int    getPage              () { return page              ; }
    public int    getTotalCount        () { return totalCount        ; }
    public int    getPossible_no       () { return possible_no       ; } 
    
    public List   getList              () { return list              ; }
	public List   getWeb_text_list     () { return web_text_list     ; }
	public String getPos_type          () { return pos_type          ; }
    public String getSale_time         () { return sale_time         ; }
    public String getSale_fg           () { return sale_fg           ; }
    
    public String getInst_mm           () { return inst_mm           ; }
    public String getDi                () { return di                ; }
    public String getCi                () { return ci                ; }
    
    public String getAkmem_approve_no  () { return akmem_approve_no  ; }
    
    public String getAkmem_card_no     () { return akmem_card_no     ; }
    public String getAkmem_custno      () { return akmem_custno      ; }
    
    public String getAkmem_recpt_point () { return akmem_recpt_point ; }
    public String getAkmem_tot_point   () { return akmem_tot_point   ; }
    public String getAkmem_use_point   () { return akmem_use_point   ; }
    public String getTid               () { return tid               ; }
    public String getAkcard_yn         () { return akcard_yn         ; }
    public String getAkKBcard_yn         () { return akKBcard_yn         ; }
        
}
