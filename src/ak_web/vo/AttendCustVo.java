package ak_web.vo;

import java.util.List;

public class AttendCustVo extends AKVo {
	
    private String hq               ; //�����ڵ�
    private String store            ; //���ڵ�
    private String userid           ; //login UserID 
    private String regno            ; //login �ֹι�ȣ
    private String custno           ; //����ȣ
    private String period           ; //��ȭ���� �����
    private String ba_custno        ; //��ȭ���� ����ȣ
    private String akmem_cusno      ; //AK����� ����ȣ
    private String akmem_cardno     ; //AK����� ī���ȣ
    private String di               ; //�� DI���� (2013.04.04)
    private String ci               ; //�� CI���� (2017.05.23)
    private String birth_ymd        ; //�� ������� (2013.06.19)
        
    private List list               ;

    
    
    // set
    public void setHq                ( String hq                 ) { this.hq                 = hq                ; }
    public void setStore             ( String store              ) { this.store              = store             ; }
    public void setUserid            ( String userid             ) { this.userid             = userid            ; }
    public void setRegno             ( String regno              ) { this.regno              = regno             ; }
    public void setCustno            ( String custno             ) { this.custno             = custno            ; }
    public void setPeriod            ( String period             ) { this.period             = period            ; }
    public void setBA_Custno         ( String ba_custno          ) { this.ba_custno          = ba_custno         ; }
    public void setAKmem_Cusno       ( String akmem_cusno        ) { this.akmem_cusno        = akmem_cusno       ; }
    public void setAKmem_Cardno      ( String akmem_cardno       ) { this.akmem_cardno       = akmem_cardno      ; }
    public void setDi                ( String di                 ) { this.di                 = di                ; }
    public void setCi                ( String ci                 ) { this.ci                 = ci                ; }
    public void setList              ( List list                 ) { this.list               = list              ; }
	public void setBirth_ymd         ( String birth_ymd          ) { this.birth_ymd          = birth_ymd         ; } 
    // get
    public String getHq                () { return hq                ; }
    public String getStore             () { return store             ; }
    public String getUserid            () { return userid            ; }
    public String getRegno             () { return regno             ; }
    public String getCustno            () { return custno            ; }
    public String getPeriod            () { return period            ; }
    public String getBA_Custno         () { return ba_custno         ; }
    public String getAKmem_Cusno       () { return akmem_cusno       ; }
    public String getAKmem_Cardno      () { return akmem_cardno      ; }
    
	public List getList                () { return list              ; }
	public String getBirth_ymd         () { return birth_ymd         ; }
      
    public String getDi                () { return di                ; }
    public String getCi                () { return ci                ; }
    
}
