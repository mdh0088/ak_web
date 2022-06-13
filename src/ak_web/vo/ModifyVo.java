package ak_web.vo;

import java.util.List;

public class ModifyVo extends AKVo {
    private String resi_no            ; //�ֹι�ȣ
    private String store              ; //���ڵ�
    private String storeNm            ; //�� ��
    private String custNm             ; //�� ����
    private String str_check    = "N" ;//�� �������� üũ�ϴ� ����
    private List list;
    private List sublist;
    private ModifyVo modify; //��������
    private String di                ;  // DI �߰�(2013.04.04)
    private String custNo                ;  // ȸ����ȣ �߰�(�⺻���������)
    private String ci                ;  // CI �߰�(2017.05.23)
    
    

	public void setResiNo            ( String resi_no              ) { this.resi_no            = resi_no           ; }
    public void setStore             ( String store                ) { this.store              = store             ; }
    public void setStoreNm           ( String storeNm              ) { this.storeNm            = storeNm             ; }
    public void setCustNm            ( String custNm               ) { this.custNm             = custNm            ; }
    public void setStr_check         ( String str_check            ) { this.str_check          = str_check          ; }
   
    public String getResiNo          () { return resi_no           ; }
    public String getStore           () { return store             ; }
    public String getStoreNm         () { return storeNm           ; }
    public String getCustNm          () { return custNm            ; }
    public String getStr_check       () { return str_check            ; }
     
    public List getList() {
        return list;
    }
    public void setList(List list) {
        this.list = list;
    }
    public List getSublist() {
        return sublist;
    }
    public void setSublist(List sublist) {
        this.sublist = sublist;
    }
    public ModifyVo getModify() {
        return modify;
    }
    public void setModify(ModifyVo modify) {
        this.modify = modify;
    }
    public String getDi() {
        return di;
    }
    public void setDi(String di) {
        this.di = di;
    }
    public String getCi() {
        return ci;
    }
    public void setCi(String ci) {
        this.ci = ci;
    }
    public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
}

