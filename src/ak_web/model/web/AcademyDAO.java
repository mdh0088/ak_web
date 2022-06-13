package ak_web.model.web;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.kcp.*;

import ak_web.classes.CmAKmembers;
import ak_web.classes.CmCardApp;
import ak_web.classes.Utils;
import ak_web.classes.XmlPropertyManager;
import oracle.sql.BLOB;


public class AcademyDAO extends SqlSessionDaoSupport{
	
	private String NS = "/web/academyMapper";
	
	public List<HashMap<String, Object>> getBookCount(String cust_no,String store,String period,String cust_id) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("store", store);
		map.put("period", period);
		map.put("cust_id", cust_id);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getBookCount", map);
		return list;
	}
	
	
	public List<HashMap<String, Object>> getBookList(int s_rownum, int e_rownum, String order_by, String sort_type,String cust_no,String store, String period,String cust_id) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("order_by", order_by);
		map.put("sort_type", sort_type);
		map.put("cust_no", cust_no);
		map.put("store", store);
		map.put("period", period);
		map.put("cust_id", cust_id);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getBookList", map);
		return list;
	}
	
	public int del_bookshelf(String store, String period, String subject_cd, String cust_no,String ischk) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		map.put("ischk", ischk);
		int result = getSqlSession().delete(NS + ".del_bookshelf", map);
		return result;
		
	}
	
	public void upt_regi_no(int cnt,String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cnt", cnt);
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);

		getSqlSession().delete(NS + ".upt_regi_no", map);
		
		
	}
	
	public List<HashMap<String, Object>> getchildCount(String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getchildCount", map);
		return list;
	}
	
	public List<HashMap<String, Object>> getchild(int s_rownum, int e_rownum, String order_by, String sort_type,String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("order_by", order_by);
		map.put("sort_type", sort_type);
		map.put("cust_no", cust_no);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getchild", map);
		return list;
	}
	
	public List<HashMap<String, Object>> getmyinfo(String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getmyinfo", map);
		return list;
	}
	
	public int saveChild(String child_nm,String child_gender ,String child_birth, String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("child_nm", child_nm);
		map.put("child_gender", child_gender);
		map.put("child_birth", child_birth.replaceAll("-", ""));
		map.put("cust_no", cust_no);
		return getSqlSession().insert(NS + ".saveChild", map);
	}
	
	public List<HashMap<String, Object>> getencdCount(String cust_no,String store) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("store", store);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getencdCount", map);
		return list;
	}
	
	public List<HashMap<String, Object>> getencd(int s_rownum, int e_rownum, String order_by, String sort_type,String cust_no,String store) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("order_by", order_by);
		map.put("sort_type", sort_type);
		map.put("cust_no", cust_no);
		map.put("store", store);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getencd", map);
		return list;
	}
	
	
	public List<HashMap<String, Object>> getwaitCount(String cust_no,String store) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("store", store);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getwaitCount", map);
		return list;
	}
	
	public List<HashMap<String, Object>> getwait(int s_rownum, int e_rownum, String order_by, String sort_type,String cust_no, String store) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("order_by", order_by);
		map.put("sort_type", sort_type);
		map.put("cust_no", cust_no);
		map.put("store", store);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getwait", map);
		return list;
	}

	public void del_wait(String cust_no, String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		getSqlSession().delete(NS + ".del_wait", map);
		
	}
	
//	public List<HashMap<String, Object>> getMylectureListCount(String cust_no,String store,String start_ymd,String end_ymd) {
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("cust_no", cust_no);
//		map.put("store", store);
//		map.put("start_ymd", start_ymd);
//		map.put("end_ymd", end_ymd);
//		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getMylectureListCount", map);
//		return list;
//	}
	
	public List<HashMap<String, Object>> getMylectureList(String cust_no,String store,String start_ymd,String end_ymd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("store", store);
		map.put("start_ymd", start_ymd);
		map.put("end_ymd", end_ymd);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getMylectureList", map);
		return list;
	}


	public List<HashMap<String, Object>> selectPayIngView(LectureVo actionobj) {
		List<HashMap<String, Object>> rs = getSqlSession().selectList(NS + ".selectPayIngView", actionobj);
		List list = new ArrayList();
		for(int i = 0; i < rs.size(); i++)
		{
			LectureVo lectureVo = new LectureVo();
			
			 lectureVo.setSubject_cd(Utils.checkNullString(rs.get(i).get("SUBJECT_CD")));
			 lectureVo.setSubject_nm(Utils.checkNullString(rs.get(i).get("SUBJECT_NM")));
			 lectureVo.setEnuri_per(Double.parseDouble(Utils.checkNullString(rs.get(i).get("ENURI_PERCENT"))));
			 lectureVo.setLect_cnt(Utils.checkNullInt(rs.get(i).get("LECT_CNT")));
			 lectureVo.setCapacity_no(Utils.checkNullInt(rs.get(i).get("CAPACITY_NO")));
			 lectureVo.setMain_cd(Utils.checkNullString(rs.get(i).get("MAIN_CD")));
			 
			 if("2".equals(Utils.checkNullString(rs.get(i).get("MAIN_CD"))) && !"".equals(Utils.removeNULL(rs.get(i).get("C_CUST2"), ""))) //베이비 강좌일땐 가격 업데이트
			 {
				 lectureVo.setRegis_fee(Double.parseDouble(Utils.checkNullString(rs.get(i).get("REGIS_FEE"))) + Double.parseDouble(Utils.checkNullString(rs.get(i).get("REGIS_FEE"))) / 2);
				 lectureVo.setFood_amt(Double.parseDouble(Utils.checkNullString(rs.get(i).get("FOOD_AMT"))) + Double.parseDouble(Utils.checkNullString(rs.get(i).get("FOOD_AMT"))) / 2);
			 }
			 else if("3".equals(Utils.checkNullString(rs.get(i).get("MAIN_CD"))) && !"".equals(Utils.removeNULL(rs.get(i).get("C_CUST2"), ""))) //베이비 강좌일땐 가격 업데이트
			 {
				 lectureVo.setRegis_fee(Double.parseDouble(Utils.checkNullString(rs.get(i).get("REGIS_FEE"))) + Double.parseDouble(Utils.checkNullString(rs.get(i).get("REGIS_FEE"))));
				 lectureVo.setFood_amt(Double.parseDouble(Utils.checkNullString(rs.get(i).get("FOOD_AMT"))) + Double.parseDouble(Utils.checkNullString(rs.get(i).get("FOOD_AMT"))));
			 }
			 else
			 {
				 lectureVo.setRegis_fee(Double.parseDouble(Utils.checkNullString(rs.get(i).get("REGIS_FEE"))));
				 lectureVo.setFood_amt(Double.parseDouble(Utils.checkNullString(rs.get(i).get("FOOD_AMT"))));
			 }
			 
			 list.add(lectureVo);
		}
		return list;
	}


	public int selectLectGift(LectureVo actionobj) {
		int ret = getSqlSession().selectOne(NS + ".selectLectGift", actionobj);
		return ret;
	}
	public int selectFreeUse(LectureVo actionobj) {
		int ret = getSqlSession().selectOne(NS + ".selectFreeUse", actionobj);
		return ret;
	}


	public int selectLectCntUse(LectureVo actionobj) {
		int ret = getSqlSession().selectOne(NS + ".selectLectCntUse", actionobj);
		return ret;
	}
	public int selectSubjectEnuriUse(LectureVo actionobj) {
		int ret = getSqlSession().selectOne(NS + ".selectSubjectEnuriUse", actionobj);
		return ret;
	}
	public int selectPeriodSale(LectureVo actionobj) {
		int ret = getSqlSession().selectOne(NS + ".selectPeriodSale", actionobj);
		return ret;
	}


	public List selectGiftEnuri(LectureVo actionobj) {
		List<HashMap<String, Object>> rs = getSqlSession().selectList(NS + ".selectGiftEnuri", actionobj);
		List list = new ArrayList();
		for(int i = 0; i < rs.size(); i++)
		{
			LectureVo lectureVo = new LectureVo();
			
			 lectureVo.setGift_enuri_fg(Utils.checkNullInt(rs.get(i).get("GIFT_ENURI_FG")));
			 lectureVo.setGift_user_enuri(Utils.checkNullInt(rs.get(i).get("GIFT_USER_ENURI")));
			 lectureVo.setGift_date_enuri(Utils.checkNullInt(rs.get(i).get("GIFT_DATE_ENURI")));
			 lectureVo.setGift_date_enuri2(Utils.checkNullInt(rs.get(i).get("GIFT_DATE_ENURI2")));
			 lectureVo.setGift_date_from(Utils.checkNullString(rs.get(i).get("GIFT_DATE_FROM")));
			 lectureVo.setGift_date_to(Utils.checkNullString(rs.get(i).get("GIFT_DATE_TO")));
			 lectureVo.setGift_date_from2(Utils.checkNullString(rs.get(i).get("GIFT_DATE_FROM2")));
			 lectureVo.setGift_date_to2(Utils.checkNullString(rs.get(i).get("GIFT_DATE_TO2")));
			 list.add(lectureVo);
		}
		return list;
	}


	public void tempPayDateSet(LectureVo actionobj) {
		
		
		String resultCode="";
		
		HashMap<String, Object> rs = getSqlSession().selectOne(NS + ".getTempPayDateSet", actionobj);
		
		if (Utils.checkNullInt(rs.get("CAPACITY_NO")) <= Utils.checkNullInt(rs.get("REGIS_NO"))) {
        	//정원 초과인 경우
        	resultCode="::EXNO::";
        }
		else
		{
			int cnt = getSqlSession().update(NS + ".tempPayDateSet1", actionobj);
			HashMap<String, Object> map = new HashMap<>();
			map.put("cnt", cnt);
			map.put("store", actionobj.getStore());
			map.put("attendCustNo", actionobj.getAttendCustNo());
			map.put("sessionId", actionobj.getSessionId());
			map.put("period", actionobj.getPeriod());
			map.put("subject_cd", actionobj.getSubject_cd());
			getSqlSession().update(NS + ".tempPayDateSet2", map);
		}
		
	}


	public int selectLectSin(LectureVo actionobj) {
		int ret = getSqlSession().selectOne(NS + ".selectLectSin", actionobj);
		return ret;
	}




	public int retrieveTempCheck(LectureVo actionobj) {
		int tempCheckCnt = getSqlSession().selectOne(NS + ".retrieveTempCheck", actionobj);
		return tempCheckCnt;
	}


	public String retrieveSettleCheck(LectureVo actionobj) {
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".retrieveSettleCheck", actionobj);
		String rslt = "";
        if (list.size() > 0) {
            rslt = "fail"; // 이미 결제된 강좌 존재
            return rslt;
        } else {
            rslt = "success"; // 이미 결제된 강좌 미존재
            return rslt;
        }
	}


	public String GetAkmemGrade(String aKmem_CustLevel) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("aKmem_CustLevel", aKmem_CustLevel);
		return getSqlSession().selectOne(NS + ".GetAkmemGrade", map);
	}
	public int saveAKmembersPointLog(HashMap<String, Object> map) {
		getSqlSession().insert(NS + ".saveAKmembersPointLog", map);
		return 0;
	}
	public void useAKmembersPointLog(String hq, String store, String pos_no, String recpt_no, String total_pay,
			String total_enuri_amt, String total_regis_fee, String akmem_card_no, String aKmem_CustNo,
			String aKmem_Family_CustNo, String aKmem_Use_Point, String aKmem_vat_use_pt, String aKmem_vat_ext_use_pt,
			String aKmem_SaveApprove_Point, String aKmem_SaveApproveNo_POS, String akmem_point_amt, String login_seq) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("hq", hq);
		map.put("store", store);
		map.put("pos_no", pos_no);
		map.put("pos_no", pos_no);
		
		map.put("recpt_no", recpt_no);
        map.put("total_show_amt", total_pay);
        map.put("total_enuri_amt", total_enuri_amt);
        map.put("total_regis_fee", total_regis_fee);    //net_sale_amt
        map.put("AKmem_cardno", akmem_card_no);
        map.put("AKmem_CustNo", aKmem_CustNo);
        map.put("AKmem_Family_CustNo", aKmem_Family_CustNo);
        map.put("AKmem_Use_Point", aKmem_Use_Point);         // 사용마일리지
        map.put("AKmem_vat_use_pt", aKmem_vat_use_pt);        // 부가세포함 사용포인트
        map.put("AKmem_vat_ext_use_pt", aKmem_vat_ext_use_pt);    // 부가세제외 사용포인트
        map.put("AKmem_SaveApprove_Point", aKmem_SaveApprove_Point); // 누적 마일리지 금액 추가 (2013.09.05)
        map.put("AKmem_SaveApproveNo_POS", aKmem_SaveApproveNo_POS);
        map.put("akmem_point_amt", akmem_point_amt);   //사용 마일리지 금액 추가
        map.put("login_seq", login_seq);   //사용 마일리지 금액 추가
		getSqlSession().insert(NS + ".useAKmembersPointLog", map);
		
	}
	
	public String Check(String ci) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("ci", ci);
		String Check = Utils.checkNullString(getSqlSession().selectOne(NS + ".Check", map));
		if (!Check.equals("")) {
			Check="Y";
		}else {
			Check="N";
		}
		return Check;
	}
	
	public String last_chk(String cust_no,String reg_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("reg_no", reg_no);
		String Check = Utils.checkNullString(getSqlSession().selectOne(NS + ".last_chk", map));
	
		return Check;
	}
	
	public List<HashMap<String, Object>> Result(String usrid, String ci) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("usrid", usrid);
		map.put("ci", ci);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".Result", map);
		return list;
		
	}
	
	public String getRegNo(String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		
		String reg_no = Utils.checkNullString(getSqlSession().selectOne(NS + ".getRegNo",map));
		if (reg_no.equals("0")) {
			reg_no="1";
		}
		return reg_no;
	}
	
	public HashMap<String, Object> usr_info(String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);

		HashMap<String, Object> data = getSqlSession().selectOne(NS + ".usr_info", map);
		return data;
	}

	public String retrievePeriod(String store) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		String ret = getSqlSession().selectOne(NS + ".retrievePeriod", map);
		return ret;
	}


	public String searchUserCi(LectureVo actionobj) {
		String ret = getSqlSession().selectOne(NS + ".searchUserCi", actionobj);
		return ret;
	}


	public String selectTempCompare(String login_id, String login_cust, String login_store,String login_period,Double DTotAmt,String tot_subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("login_id", login_id);
		map.put("login_cust", login_cust);
		map.put("login_store", login_store);
		map.put("login_period", login_period);
		map.put("tot_subject_cd", tot_subject_cd);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".selectTempCompare", map);
		String rslt = "";
        
        int iRegiTot = 0;
        int iFoodTot = 0;
        for(int i = 0; i < list.size(); i++)
        {
            iRegiTot = Utils.checkNullInt(list.get(i).get("REGIS_FEE"));
            iFoodTot = Utils.checkNullInt(list.get(i).get("FOOD_AMT"));
            
            //기간할인 추가(20151017)
            if (DTotAmt != (double)(iRegiTot + iFoodTot )) {
                rslt = "fail"; // 결제 금액 상이
                return rslt;
            } else if (DTotAmt == (double)(iRegiTot + iFoodTot )) {
                rslt = "success"; // 결제 금액 동일
                return rslt;
            }
        }
        return rslt;
	}


	public String tempAsCheck(LectureVo actionobj) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", actionobj.getStore());
		map.put("attendCustNo", actionobj.getAttendCustNo());
		String tot_subject_cd = actionobj.getTot_subject_cd();
        
        if(tot_subject_cd != ""){
        	tot_subject_cd = tot_subject_cd.substring(1);
        	map.put("Tot_subject_cd", tot_subject_cd);
        }
		int sub_cnt = getSqlSession().selectOne(NS + ".tempAsCheck", map);
		
		String rslt = "";
		if(sub_cnt > 0){
        	rslt = "fail"; // 결제중 책가방 담김
        	return rslt;
        }else{
        	rslt = "success"; // 정상
            return rslt;
        }
	}


	public String retrieveTotAmtCheck(LectureVo actionobj) {
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".retrieveTotAmtCheck", actionobj);
		String rslt = "";
        
        int iRegiTot = 0;
        int iFoodTot = 0;
        if(list.size() > 0)
        {
            iRegiTot = Utils.checkNullInt(list.get(0).get("REGIS_FEE"));
            iFoodTot = Utils.checkNullInt(list.get(0).get("FOOD_AMT"));
            
            //기간할인 추가(20151017)
            if (actionobj.getDTotAmt() != (double)(iRegiTot + iFoodTot )) {
                rslt = "fail"; // 결제 금액 상이
                return rslt;
            } else if (actionobj.getDTotAmt() == (double)(iRegiTot + iFoodTot )) {
                rslt = "success"; // 결제 금액 동일
                return rslt;
            }
        }
        return rslt;
	}


	public String settleProcess(LectureVo actionobj) throws Exception {
		
		 String rslt = "";
        String sApprovNo = "";
        String scBank_cd = "";
        String scRate = "";            
        String sCurrentTime = Utils.getCurrentTime();
        String sDate = Utils.getCurrentDate();
        String akmem_recpt_no = "";
        String sInstFg = "";        	
        String strECode = null;
        String sValidDt = "";
        
        InetAddress inet = InetAddress.getLocalHost();
        String inet_ip = inet.getHostAddress();         
        
        
        String g_conf_home_dir = "";
    	String g_conf_gw_url = "";
    	String g_conf_gw_port = "";
    	int g_conf_tx_mode = 0;
    	
    	String tran_cd = actionobj.getTran_cd();
    	String g_conf_site_cd = actionobj.getSite_cd();   
    	String g_conf_site_key = actionobj.getSite_key();
    	String g_conf_log_level = "";
    	String g_conf_log_dir = "";
    	
    	String g_sat_fg = actionobj.getSat_fg();
    	int slip_cnt = 0;
    	
    	J_PP_CLI_N c_PayPlus = new J_PP_CLI_N();
    	
    	System.out.println("1111 : "+inet_ip);
    	System.out.println("22222222222" + XmlPropertyManager.getSystemProperty("dev_was"));
    	if (inet_ip.equals(XmlPropertyManager.getSystemProperty("dev_was"))) { // 개발서버인 경우..
       	g_conf_home_dir = XmlPropertyManager.getSystemProperty("g_conf_home_dir_test");
       	g_conf_gw_url = XmlPropertyManager.getSystemProperty("g_conf_gw_url_test");
       	g_conf_gw_port = XmlPropertyManager.getSystemProperty("g_conf_gw_port_test");
       	g_conf_tx_mode = Integer.parseInt(XmlPropertyManager.getSystemProperty("g_conf_tx_mode_test"));
       	g_conf_site_cd = XmlPropertyManager.getSystemProperty("g_conf_site_cd_test");
       	g_conf_site_key = XmlPropertyManager.getSystemProperty("g_conf_site_key_test");
       	g_conf_log_level = XmlPropertyManager.getSystemProperty("g_conf_log_level_test");
       	g_conf_log_dir = XmlPropertyManager.getSystemProperty("g_conf_log_dir_test");
       	
       } else if (inet_ip.equals(XmlPropertyManager.getSystemProperty("front_was1"))|| inet_ip.equals(XmlPropertyManager.getSystemProperty("front_was2"))) {
       	g_conf_home_dir = XmlPropertyManager.getSystemProperty("g_conf_home_dir");
       	g_conf_gw_url = XmlPropertyManager.getSystemProperty("g_conf_gw_url");
       	g_conf_gw_port = XmlPropertyManager.getSystemProperty("g_conf_gw_port");
       	g_conf_tx_mode = Integer.parseInt(XmlPropertyManager.getSystemProperty("g_conf_tx_mode"));
       	g_conf_log_level = XmlPropertyManager.getSystemProperty("g_conf_log_level");
       	g_conf_log_dir = XmlPropertyManager.getSystemProperty("g_conf_log_dir");
       	
       }
    	c_PayPlus.mf_init( "", g_conf_gw_url, g_conf_gw_port, g_conf_tx_mode, g_conf_log_dir );
       c_PayPlus.mf_init_set();   
    	String res_cd = "";
   	String res_msg = "";    
    	
   	if(!g_sat_fg.equals("P")){
   		
   		c_PayPlus.mf_set_enc_data( Utils.f_get_parm( actionobj.getEnc_data() ), Utils.f_get_parm( actionobj.getEnc_info() ) );
   		
   		int ordr_data_set_no;
           ordr_data_set_no = c_PayPlus.mf_add_set( "ordr_data" );
           c_PayPlus.mf_set_us( ordr_data_set_no, "ordr_mony", Double.toString(actionobj.getDTotalAmt()).split("\\.")[0] );
           
           System.out.println("Double.toString(actionobj.getDTotalAmt())" + Double.toString(actionobj.getDTotalAmt()).split("\\.")[0]); //소숫점제거
   		
   		
   		
//           c_PayPlus.mf_init_set();
//           
//           
//           c_PayPlus.mf_set_enc_data( Utils.f_get_parm( actionobj.getEnc_data() ), Utils.f_get_parm( actionobj.getEnc_info() ) );
           
           if ( tran_cd.length() > 0 ){
           	c_PayPlus.mf_do_tx( g_conf_site_cd, g_conf_site_key, tran_cd, "", actionobj.getOrdr_idxx(), g_conf_log_level, "0" );
           	System.out.println("actionobj.getOrdr_idxx() : "+actionobj.getOrdr_idxx());
       		
       	    res_cd  = c_PayPlus.m_res_cd;  // 결과 코드
       		res_msg = c_PayPlus.m_res_msg; // 결과 메시지
       		
       	}else{
               c_PayPlus.m_res_cd  = "9562";
               c_PayPlus.m_res_msg = "연동 오류|Payplus Plugin이 설치되지 않았거나 tran_cd값이 설정되지 않았습니다.";
               return "fail";
           }
           
           System.out.println("res_cd : " + res_cd + " 시스템 시각 : " + Utils.getCurrentTime() + " res_msg : "+res_msg);
           
           //정상적으로 값을 가져왔을 경우 변수 설정 
           if(res_cd.equals("0000")){
           	actionobj.setTid(c_PayPlus.mf_get_res("tno")); // KCP 거래 고유 번호
           	
           	// 822 신한 제휴 일 경우 사이트 코드 분리로 822 코드 강제 설정 BY KSM 2014.07
           	if(!actionobj.getAkcard_yn().equals("Y") && !actionobj.getAkKBcard_yn().equals("Y")){
           		
           		HashMap<String, Object> map = new HashMap<>();
           		map.put("card_cd", c_PayPlus.mf_get_res( "card_cd"));
           		String ret = getSqlSession().selectOne(NS + ".getCardFg", map);
           		System.out.println(" c_PayPlus.mf_get_res(card_cd) : " + c_PayPlus.mf_get_res( "card_cd"));
       			actionobj.setCardfg(ret);
           	}

           	actionobj.setSCardNo(c_PayPlus.mf_get_res( "card_no")); // 3번째 자리 0000마스킹된 카드번호
           	sApprovNo = c_PayPlus.mf_get_res("app_no");
           	actionobj.setSAllot(c_PayPlus.mf_get_res("quota"));
           	scRate = "07"; // 승인벤사구분(1)
           	// 메일발송 내역시 필요항목 추가(2013.02.20)
               actionobj.setSale_time(sCurrentTime);
               actionobj.setSale_ymd(sDate);
               sInstFg = c_PayPlus.mf_get_res("quota");

               if(Integer.parseInt(sInstFg) > 1){
               	sInstFg = "1";
               }else{
               	sInstFg = "0";
               }
               
               // 유효기간 강제 설정 
               sValidDt = "200000";
               // AK신한카드 (822) 결제자 , 결제금액 존재자, 정규강좌 존재자(isFlag1=ture), 단기강좌
               // 미존재자(isFlag2=flag), AK신한카드 5%할인일정 해당하면 (isFlag3=true)
               if ((actionobj.getCardfg().equals("822"))
                       && (actionobj.getDTotalAmt() > 0) && actionobj.isFlag1()
                       && !actionobj.isFlag2() && actionobj.isFlag3()) {

                   // DESK System 공통마스터관리>> 마스터 코드관리 각점별 에누리코드 세팅 추후 개발 (12.10.15)
                   if ("01".equals(actionobj.getStore())) {
                       strECode = "120";
                   } else if ("02".equals(actionobj.getStore())) {
                       strECode = "222";
                   } else if ("03".equals(actionobj.getStore())) {
                       strECode = "324";
                   } else if ("04".equals(actionobj.getStore())) {
                       strECode = "411";
                   } else if ("05".equals(actionobj.getStore())) {
                       strECode = "511";
                   }
               }

               String enuriC = "";
               String enuriPeriod = "";
               
               if(actionobj.isFlag4() && actionobj.isFlag5()){
               	enuriC = "Y";
               }
               
               if(actionobj.getDayEnuri() > 0){
               	enuriPeriod = "Y";
               }

               if(enuriC.equals("Y") && !enuriPeriod.equals("Y")){
	                strECode = "901";
               }else if(!enuriC.equals("Y") && enuriPeriod.equals("Y")){
   	            strECode = "902";
               }else if(enuriC.equals("Y") && enuriPeriod.equals("Y")){
	                strECode = "903";
               }
               
           }else if(res_cd.equals("CC36")){
           	rslt = "결제하신 카드 정보가 맞는지 확인 후 다시 시도해 주세요\nAK신한카드일 경우 [AK신한카드],AKKB국민카드일 경우 [AKKB국민카드], 일반 신한카드,국민카드일 경우 [일반카드]를 선택하셔야 합니다.";
           	return "Wrong Card";
           }else{
               rslt = "카드승인 중 알수없는 오류가 발생하였습니다.";
               return rslt;
           }
   	} else {
   		//마일리지 전액 사용시 강제 셋팅 함
   		actionobj.setTid("00000000000000"); // KCP 거래 고유 번호
   		actionobj.setCardfg("000");
   		actionobj.setSCardNo("0000000000000000"); // 3번째 자리 0000마스킹된 카드번호
   		actionobj.setSale_time(sCurrentTime);
   		actionobj.setSale_ymd(sDate);
   		actionobj.setAkmem_card_status("00");
   		actionobj.setSAllot("99");
   		
   		sInstFg   = "0";
   		sValidDt  = "200000";
   		sApprovNo = "00000000";
   		scBank_cd = "";
   		scRate    = "";
   		strECode  = "";
   	}
   	/*------------------------------------------------------------------------------------
        *     유료강좌 recpt_no 영수증번호 생성 -- AKmembers 로 unique 한 key를 적립하기위해선 영수증번호가 필요함 by CH 090102
        *-----------------------------------------------------------------------------------*/
       if ("00".equals(actionobj.getAkmem_card_status())) {

           if ("01".equals(actionobj.getStore())) {
           	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_01");
           } else if ("02".equals(actionobj.getStore())) {
           	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_02");
           } else if ("03".equals(actionobj.getStore())) {
           	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_03");
           } else if ("04".equals(actionobj.getStore())) {
           	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_04");
           } else if ("05".equals(actionobj.getStore())) {
           	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_05");
           }
           actionobj.setAkmem_recpt_no(akmem_recpt_no);
       }
       // 이미 등록한 강좌인지 체크
       // pay_method 카드결제 경우 결제 카드사 정보 추가 (10.10.28)
       // sms_yn 메일전송 여부 정보 추가(11.01.26)
       HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("hq", actionobj.getHq());
		paramMap.put("store", actionobj.getStore());
		paramMap.put("sDate", sDate);
		paramMap.put("sCurrentTime", sCurrentTime);
		paramMap.put("akmem_recpt_no", akmem_recpt_no);
		paramMap.put("period", actionobj.getPeriod());
		paramMap.put("dTotAmt", actionobj.getDTotAmt());
		paramMap.put("dTotalAmt", actionobj.getDTotalAmt());
		paramMap.put("sCardNo", actionobj.getSCardNo());
		paramMap.put("sInstFg", sInstFg);
		paramMap.put("sAllot", actionobj.getSAllot());
		paramMap.put("sValidDt", sValidDt);
		paramMap.put("sApprovNo", sApprovNo);
		paramMap.put("scBank_cd", scBank_cd);
		paramMap.put("scRate", scRate);
		paramMap.put("cardfg", actionobj.getCardfg()); // pay_method 카드결제 경우 결제 카드사 정보 추가 (10.10.28)
		paramMap.put("strECode", strECode); // 신한카드 결제경우 할인구분 AK신한 5%코드 추가 (12.10.15)
		paramMap.put("tid", actionobj.getTid());
		paramMap.put("uPointAmt", Double.toString(actionobj.getUPointAmt()).split("\\.")[0]);
		paramMap.put("attendCustNo", actionobj.getAttendCustNo());
		paramMap.put("sessionId", actionobj.getSessionId());
		
		String subject_arr[] = actionobj.getTot_subject_cd().split(",");
		String encd1_no_arr[] = actionobj.getTot_enuri1_cd().split(",");
		String encd2_no_arr[] = actionobj.getTot_enuri2_cd().split(",");
		String encd1_amt_arr[] = actionobj.getTot_enuri1_amt().split(",");
		String encd2_amt_arr[] = actionobj.getTot_enuri2_amt().split(",");
		
		int upcnt = 0;
		for(int i = 0; i < subject_arr.length; i++)
		{
			paramMap.put("subject_cd", subject_arr[i]);
			paramMap.put("enuri1_code", encd1_no_arr[i].replaceAll("undefined", ""));
			paramMap.put("enuri2_code", encd2_no_arr[i].replaceAll("undefined", ""));
			paramMap.put("enuri1_amt", encd1_amt_arr[i]);
			paramMap.put("enuri2_amt", encd2_amt_arr[i]);
			
			
			if(Integer.parseInt(encd1_amt_arr[i]) > 0)
			{
				paramMap.put("enuri1_yn", "Y");
			}
			else
			{
				paramMap.put("enuri1_yn", "N");
			}
			if(Integer.parseInt(encd2_amt_arr[i]) > 0)
			{
				paramMap.put("enuri2_yn", "Y");
			}
			else
			{
				paramMap.put("enuri2_yn", "N");
			}
			int tmp_cnt = getSqlSession().insert(NS + ".insWbtrTb", paramMap);
			if(tmp_cnt > 0)
			{
				upcnt++;
			}
			//출석부 시작
			System.out.println("출석부 시작");
			HashMap<String, Object> data = getAttendInfo(actionobj.getStore(),actionobj.getPeriod(),subject_arr[i]);
			if (data!=null) 
			{
				String dayChk[] = Utils.checkNullString(data.get("DAY_CHK")).split("\\|");
				String dayVal ="";
				for (int j = 0; j < dayChk.length; j++) 
				{
					dayVal+="X|";
				}
				insAttend(actionobj.getStore(),actionobj.getPeriod(),subject_arr[i], "","N",actionobj.getAttendCustNo(),dayVal, "", "", "");
			}
			//출석부 종료
			
		}
		
		
       System.out.println("upcnt : "+upcnt);
       
       if (upcnt == 0) {
       	c_PayPlus.mf_init_set();

           tran_cd = "00200000";
           
           int mod_data_set_no;                
           mod_data_set_no = c_PayPlus.mf_add_set( "mod_data" );

           c_PayPlus.mf_set_us( mod_data_set_no, "tno",      actionobj.getTid()); // KCP 원거래 거래번호
           c_PayPlus.mf_set_us( mod_data_set_no, "mod_type", "STSC"   ); // 원거래 변경 요청 종류
           c_PayPlus.mf_set_us( mod_data_set_no, "mod_ip",   actionobj.getSessionId()  ); // 변경 요청자 IP
           c_PayPlus.mf_set_us( mod_data_set_no, "mod_desc", "가맹점 결과 처리 오류 - 가맹점에서 취소 요청"  ); // 변경 사유

			c_PayPlus.mf_do_tx( g_conf_site_cd, g_conf_site_key, tran_cd, "", actionobj.getOrdr_idxx(), g_conf_log_level, "0" );
			
           rslt = "매출테이블 저장 시 에러가 발생하였습니다.";
           return rslt;
       } else if (upcnt > 0) {
           if ("00".equals(actionobj.getAkmem_card_status())) {

               // 삼성카드 인지 체크(마일리지 0%)
               // 삼성카드 인지 체크(마일리지 0.1%)(10.01.04 변경됨)
               // 제휴 삼성카드도 마일리지 적립되어야함 - 09.12.01~11.06.08까지 애경삼성카드 적립
               // 불가오류로 로직 변경함 (11.06.08)
               // 차후 연계제휴삼성카드 마일리지적립율 변경시 CmAKmembers.java -
               // getCalcAkmemPoint()메소드 참고하여 수정필요 ★
           	/* 삼성 카드 체크 불가 2014.07 PG사 도입 일반 카드로 분류
           	 * 삼성 카드는 마일리지 적립이 있다.(10.01.04 변경됨)
               int SAMSUNGCount = 0;*/
           	
               // 신한제휴카드 인지 체크 (마일리지 적립시 20%추가 인정)
               int SHINHANCount = 0;
               
           	//국민제휴 확인(2017.09)
           	int KBCount = 0;
               
               if(actionobj.getAkcard_yn().equals("Y")){
               	SHINHANCount = 1;
               }else if(actionobj.getAkKBcard_yn().equals("Y")){
               	KBCount = 1;
               }

               System.out.println("SHINHANCount >>>>" +SHINHANCount + "+KBCount >>>>" +KBCount);

               System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> actionobj.getAkmem_card_status() :" + actionobj.getAkmem_card_status()+ "<<<<<<");
               System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> actionobj.getAKmemCardNo()       :" + actionobj.getAKmemCardNo() + "<<<<<<<<<<");
               System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> actionobj.getSCardNo()           :" + actionobj.getSCardNo() + "<<<<<<<<<<<<<<");
               System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> akmem_recpt_no                   :" + akmem_recpt_no + "<<<<<<<<<<<<<<");
               System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> actionobj.getDTotalAmt()         :" + Integer.toString((int) (actionobj.getDTotalAmt())) + "<<<<<<<<<<<<<<");
               System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> actionobj.getUPointAmt()         :" + actionobj.getUPointAmt());
               
               System.out.println("actionobj.getUPointAmt() : "+actionobj.getUPointAmt());
               if(actionobj.getUPointAmt() > 0){
               	//AKmembers 사용요청
               	CmAKmembers exeAKmem2 = new CmAKmembers();
                   HashMap map2 = exeAKmem2.AKmemPoint(actionobj.getStore()
                   		, actionobj.getAKmemCardNo()
                   		, actionobj.getSCardNo() // card_no
                           , Utils.getCurrentDate() // recpt_sale_ymd
                           , "070013" // 인터넷 포스 번호
                           , akmem_recpt_no // recpt_no 영수증번호가 없으므로 멤버스용 akmem_recpt_no
                           , Integer.toString((int) (actionobj.getDTotalAmt())) // total_amt
                           , Integer.toString(exeAKmem2.getCalcAkmemPoint(SHINHANCount, KBCount, actionobj.getDTotalAmt(), this)) // akmem_recpt_point
                           , Integer.toString((int) (actionobj.getUPointAmt())) // akmem_recpt_point
                           , ""
                           , ""
                           , "USE");

                   String AKmem_sApprovNo2 = (String) map2.get("RSP_CD");
                   String AKmem_sMessage2 = (String) map2.get("MSG_TRMNL");
                   
                   if ("00".equals(AKmem_sApprovNo2)) {
                   	String AKmem_SaveApproveNo = (String) map2.get("PTCP_PERM_NO");
                       String AKmem_SaveApproveNo_POS = (String) map2.get("PERM_NO");
                       String AKmem_SaveApprove_Point = (String) map2.get("EUSE_PT");
                       String AKmem_CustNo = (String) map2.get("CUS_NO");
                       String AKmem_Create_Point = "0";
                       String AKmem_send_buff = (String) map2.get("SEND_STR");
                       String AKmem_recv_buff = (String) map2.get("RECV_BUFF");
                       String AKmem_CardNo = (String) map2.get("CARD_NO");
                       String USE_PT = Utils.removeNULL((String) map2.get("USE_PT"),"0");
                       String VAT_CAL_USE_PT = Utils.removeNULL((String) map2.get("VAT_USE_PT"),"0");
                       String VAT_CAL_EXT_USE_PT = Utils.removeNULL((String) map2.get("VAT_EXT_USE_PT"),"0");
                   	
                       slip_cnt ++;
                       
//                     db insert
                       HashMap<String, Object> paramMap2 = new HashMap<>();
               		paramMap2.put("hq", actionobj.getHq());
               		paramMap2.put("store", actionobj.getStore());
               		paramMap2.put("sDate", Utils.getCurrentDate());
               		paramMap2.put("pos_no", "070013");
               		paramMap2.put("akmem_recpt_no", akmem_recpt_no);
               		paramMap2.put("period", actionobj.getPeriod());
               		paramMap2.put("dTotalAmt", actionobj.getDTotalAmt());
               		paramMap2.put("AKmem_CardNo", AKmem_CardNo);// 멤버스카드번호-암호화 제거(2018.06.20)
               		paramMap2.put("AKmem_CustNo", AKmem_CustNo);
               		paramMap2.put("AKmem_SaveApproveNo_POS", AKmem_SaveApproveNo_POS);
               		paramMap2.put("AKmem_SaveApprove_Point", Integer.parseInt(AKmem_SaveApprove_Point));
               		
               		paramMap2.put("USE_PT", Integer.parseInt(USE_PT));
               		paramMap2.put("VAT_CAL_USE_PT", Integer.parseInt(VAT_CAL_USE_PT));
               		paramMap2.put("VAT_CAL_EXT_USE_PT", Integer.parseInt(VAT_CAL_EXT_USE_PT));
               		paramMap2.put("AKmem_send_buff", AKmem_send_buff);
               		paramMap2.put("AKmem_recv_buff", AKmem_recv_buff);
               		paramMap2.put("slip_cnt", slip_cnt);
               		
               		int count1 = getSqlSession().insert(NS + ".insWbptTb", paramMap2);

                       if (count1 == 0) {
                           rslt = "AK멤버스 사용  테이블 저장중 ERROR가 발생하였습니다.";
                           return rslt;
                       }
                       
                       System.out.println("사용 ok -> db-insert");
                       System.out.println("AKmem_SaveApproveNo     = " + AKmem_SaveApproveNo);
                       System.out.println("AKmem_SaveApproveNo_POS = " + AKmem_SaveApproveNo_POS);
                       System.out.println("AKmem_SaveApprove_Point = " + AKmem_SaveApprove_Point);
                       System.out.println("VAT_CAL_USE_PT          = " + VAT_CAL_USE_PT);
                       System.out.println("VAT_CAL_EXT_USE_PT      = " + VAT_CAL_EXT_USE_PT);
                   } else {
                   	rslt = "AK멤버스 사용요청오류";
                       return rslt;
                   }
               }

               if(!g_sat_fg.equals("P")){ //마일리지 전액 사용이 아니라면 적립 전문 보냄
               	//AKmembers 적립요청
                   CmAKmembers exeAKmem = new CmAKmembers();
                   HashMap map = exeAKmem.AKmemPoint(actionobj.getStore()
                   		, actionobj.getAKmemCardNo()
                   		, actionobj.getSCardNo() // card_no
                           , Utils.getCurrentDate() // recpt_sale_ymd
                           , "070013" // 인터넷 포스 번호
                           , akmem_recpt_no // recpt_no 영수증번호가 없으므로 멤버스용 akmem_recpt_no
                           , Integer.toString((int) (actionobj.getDTotalAmt())) // total_amt
                           , Integer.toString(exeAKmem.getCalcAkmemPoint(SHINHANCount, KBCount, actionobj.getDTotalAmt(), this)) // akmem_recpt_point
                           , Integer.toString((int) (actionobj.getUPointAmt())) // akmem_recpt_point
                           , ""
                           , ""
                           , "SAVE"); 

                   String AKmem_sApprovNo = (String) map.get("RSP_CD");
                   String AKmem_sMessage = (String) map.get("MSG_TRMNL");

                   if ("00".equals(AKmem_sApprovNo)) {
                       String AKmem_SaveApproveNo = (String) map.get("PTCP_PERM_NO");
                       String AKmem_SaveApproveNo_POS = (String) map.get("PERM_NO");
                       String AKmem_SaveApprove_Point = (String) map.get("EUSE_PT");
                       String AKmem_CustNo = (String) map.get("CUS_NO");
                       String AKmem_Create_Point = (String) map.get("TOT_CREA_PT");
                       String AKmem_CardNo = (String) map.get("CARD_NO");
                       String AKmem_send_buff = (String) map.get("SEND_STR");
                       String AKmem_recv_buff = (String) map.get("RECV_BUFF");
                       
                       slip_cnt++;
                       System.out.println("AKmem_SaveApprove_Point >>>>> 적립 >>>>> +"+AKmem_SaveApprove_Point);

                       // db insert
                       HashMap<String, Object> paramMap3 = new HashMap<>();
               		paramMap3.put("hq", actionobj.getHq());
               		paramMap3.put("store", actionobj.getStore());
               		paramMap3.put("sDate", Utils.getCurrentDate());
               		paramMap3.put("pos_no", "070013");
               		paramMap3.put("akmem_recpt_no", akmem_recpt_no);
               		paramMap3.put("dTotalAmt", actionobj.getDTotalAmt());
               		paramMap3.put("AKmem_CardNo", AKmem_CardNo);// 멤버스카드번호-암호화 제거(2018.06.20)
               		paramMap3.put("AKmem_CustNo", AKmem_CustNo);
               		paramMap3.put("AKmem_Create_Point", AKmem_Create_Point);
               		paramMap3.put("AKmem_SaveApproveNo_POS", AKmem_SaveApproveNo_POS);
               		paramMap3.put("AKmem_SaveApprove_Point", AKmem_SaveApprove_Point);
               		paramMap3.put("AKmem_send_buff", AKmem_send_buff);
               		paramMap3.put("AKmem_recv_buff", AKmem_recv_buff);
               		paramMap3.put("slip_cnt", slip_cnt);
               		
                       int count1 = getSqlSession().insert(NS + ".insWbptTb2", paramMap3);
                       
                       if (count1 == 0) {
                           rslt = "AK멤버스 적립 테이블 저장중 ERROR가 발생하였습니다.";
                           return rslt;
                       }

                       System.out.println("적립 ok -> db-insert");
                       System.out.println("AKmem_SaveApproveNo = " + AKmem_SaveApproveNo);
                       System.out.println("AKmem_SaveApproveNo_POS = " + AKmem_SaveApproveNo_POS);
                       System.out.println("AKmem_SaveApprove_Point = " + AKmem_SaveApprove_Point);
                       // return value에 적립후 포인트 추가 ( ^금회적립포인트 ^적립후 포인트)

                   } else { 
                       rslt = "AK멤버스 적립요청오류";
                       return rslt;
                   }
               }
           }

           rslt = "success";
           return rslt;
       }
       return rslt;
	}
	
	public HashMap<String, Object> getAttendInfo(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		HashMap<String, Object> data = getSqlSession().selectOne(NS + ".getAttendInfo", map);
		return data;
	}
	
	public void insAttend(String store, String period, String subject_cd, String login_seq,String isLec,String cust_no,String dayVal,String p_cust, String c_cust1, String c_cust2) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("login_seq", login_seq);
		map.put("isLec", isLec);
		map.put("cust_no", cust_no);
		map.put("dayVal", dayVal);
		map.put("p_cust", p_cust);
		map.put("c_cust1", c_cust1);
		map.put("c_cust2", c_cust2);
		
		getSqlSession().insert(NS + ".insAttend", map);
	}
	
	
	public String settleProcess_half(LectureVo actionobj) throws Exception {
		
		 String rslt = "";
        String sApprovNo = "";
        String scBank_cd = "";
        String scRate = "";            
        String sCurrentTime = Utils.getCurrentTime();
        String sDate = Utils.getCurrentDate();
        String akmem_recpt_no = "";
        String sInstFg = "";        	
        String strECode = null;
        String sValidDt = "";
        
        InetAddress inet = InetAddress.getLocalHost();
        String inet_ip = inet.getHostAddress();         
        
        
        String g_conf_home_dir = "";
    	String g_conf_gw_url = "";
    	String g_conf_gw_port = "";
    	int g_conf_tx_mode = 0;
    	
    	String tran_cd = actionobj.getTran_cd();
    	String g_conf_site_cd = actionobj.getSite_cd();   
    	String g_conf_site_key = actionobj.getSite_key();
    	String g_conf_log_level = "";
    	String g_conf_log_dir = "";
    	
    	String g_sat_fg = actionobj.getSat_fg();
    	int slip_cnt = 0;
    	
    	J_PP_CLI_N c_PayPlus = new J_PP_CLI_N();
    	
    	if (inet_ip.equals(XmlPropertyManager.getSystemProperty("dev_was"))) { // 개발서버인 경우..
       	g_conf_home_dir = XmlPropertyManager.getSystemProperty("g_conf_home_dir_test");
       	g_conf_gw_url = XmlPropertyManager.getSystemProperty("g_conf_gw_url_test");
       	g_conf_gw_port = XmlPropertyManager.getSystemProperty("g_conf_gw_port_test");
       	g_conf_tx_mode = Integer.parseInt(XmlPropertyManager.getSystemProperty("g_conf_tx_mode_test"));
       	g_conf_site_cd = XmlPropertyManager.getSystemProperty("g_conf_site_cd_test");
       	g_conf_site_key = XmlPropertyManager.getSystemProperty("g_conf_site_key_test");
       	g_conf_log_level = XmlPropertyManager.getSystemProperty("g_conf_log_level_test");
       	g_conf_log_dir = XmlPropertyManager.getSystemProperty("g_conf_log_dir_test");
       	
       } else if (inet_ip.equals(XmlPropertyManager.getSystemProperty("front_was1"))|| inet_ip.equals(XmlPropertyManager.getSystemProperty("front_was2"))) {
       	g_conf_home_dir = XmlPropertyManager.getSystemProperty("g_conf_home_dir");
       	g_conf_gw_url = XmlPropertyManager.getSystemProperty("g_conf_gw_url");
       	g_conf_gw_port = XmlPropertyManager.getSystemProperty("g_conf_gw_port");
       	g_conf_tx_mode = Integer.parseInt(XmlPropertyManager.getSystemProperty("g_conf_tx_mode"));
       	g_conf_log_level = XmlPropertyManager.getSystemProperty("g_conf_log_level");
       	g_conf_log_dir = XmlPropertyManager.getSystemProperty("g_conf_log_dir");
       	
       }
    	c_PayPlus.mf_init( "", g_conf_gw_url, g_conf_gw_port, g_conf_tx_mode, g_conf_log_dir );
       c_PayPlus.mf_init_set();   
    	String res_cd = "";
   	String res_msg = "";    
    	
   	if(!g_sat_fg.equals("P")){
   		
   		c_PayPlus.mf_set_enc_data( Utils.f_get_parm( actionobj.getEnc_data() ), Utils.f_get_parm( actionobj.getEnc_info() ) );
   		
   		int ordr_data_set_no;
           ordr_data_set_no = c_PayPlus.mf_add_set( "ordr_data" );
           c_PayPlus.mf_set_us( ordr_data_set_no, "ordr_mony", Double.toString(actionobj.getDTotalAmt()).split("\\.")[0] );
           System.out.println("Double.toString(actionobj.getDTotalAmt())" + Double.toString(actionobj.getDTotAmt()).split("\\.")[0]); //소숫점제거
           System.out.println("Double.toString(actionobj.getDTotalAmt())" + Double.toString(actionobj.getDTotalAmt()).split("\\.")[0]); //소숫점제거
   		
   		
   		
//           c_PayPlus.mf_init_set();
//           
//           
//           c_PayPlus.mf_set_enc_data( Utils.f_get_parm( actionobj.getEnc_data() ), Utils.f_get_parm( actionobj.getEnc_info() ) );
           
           if ( tran_cd.length() > 0 ){
           	c_PayPlus.mf_do_tx( g_conf_site_cd, g_conf_site_key, tran_cd, "", actionobj.getOrdr_idxx(), g_conf_log_level, "0" );
           	System.out.println("actionobj.getOrdr_idxx() : "+actionobj.getOrdr_idxx());
       		
       	    res_cd  = c_PayPlus.m_res_cd;  // 결과 코드
       		res_msg = c_PayPlus.m_res_msg; // 결과 메시지
       		
       	}else{
               c_PayPlus.m_res_cd  = "9562";
               c_PayPlus.m_res_msg = "연동 오류|Payplus Plugin이 설치되지 않았거나 tran_cd값이 설정되지 않았습니다.";
               return "fail";
           }
           
           System.out.println("res_cd : " + res_cd + " 시스템 시각 : " + Utils.getCurrentTime() + " res_msg : "+res_msg);
           
           //정상적으로 값을 가져왔을 경우 변수 설정 
           if(res_cd.equals("0000")){
           	actionobj.setTid(c_PayPlus.mf_get_res("tno")); // KCP 거래 고유 번호
           	
           	if(!actionobj.getAkcard_yn().equals("Y") && !actionobj.getAkKBcard_yn().equals("Y")){
           		
           		HashMap<String, Object> map = new HashMap<>();
           		map.put("card_cd", c_PayPlus.mf_get_res( "card_cd"));
           		String ret = getSqlSession().selectOne(NS + ".getCardFg", map);
           		System.out.println(" c_PayPlus.mf_get_res(card_cd) : " + c_PayPlus.mf_get_res( "card_cd"));
       			actionobj.setCardfg(ret);
           	}
           	

           	actionobj.setSCardNo(c_PayPlus.mf_get_res( "card_no")); // 3번째 자리 0000마스킹된 카드번호
           	sApprovNo = c_PayPlus.mf_get_res("app_no");
           	actionobj.setSAllot(c_PayPlus.mf_get_res("quota"));
           	scRate = "07"; // 승인벤사구분(1)
           	// 메일발송 내역시 필요항목 추가(2013.02.20)
               actionobj.setSale_time(sCurrentTime);
               actionobj.setSale_ymd(sDate);
               sInstFg = c_PayPlus.mf_get_res("quota");

               if(Integer.parseInt(sInstFg) > 1){
               	sInstFg = "1";
               }else{
               	sInstFg = "0";
               }
               
               // 유효기간 강제 설정 
               
           }else if(res_cd.equals("CC36")){
           	rslt = "결제하신 카드 정보가 맞는지 확인 후 다시 시도해 주세요\nAK신한카드일 경우 [AK신한카드],AKKB국민카드일 경우 [AKKB국민카드], 일반 신한카드,국민카드일 경우 [일반카드]를 선택하셔야 합니다.";
           	return "Wrong Card";
           }else{
               rslt = "카드승인 중 알수없는 오류가 발생하였습니다.";
               return rslt;
           }
           sValidDt = "200000";
           if ("00".equals(actionobj.getAkmem_card_status())) {

               if ("01".equals(actionobj.getStore())) {
               	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_01");
               } else if ("02".equals(actionobj.getStore())) {
               	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_02");
               } else if ("03".equals(actionobj.getStore())) {
               	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_03");
               } else if ("04".equals(actionobj.getStore())) {
               	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_04");
               } else if ("05".equals(actionobj.getStore())) {
               	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_05");
               }
               actionobj.setAkmem_recpt_no(akmem_recpt_no);
           }
           
           HashMap<String, Object> paramMap = new HashMap<>();
	   		paramMap.put("hq", actionobj.getHq());
	   		paramMap.put("store", actionobj.getStore());
	   		paramMap.put("sDate", sDate);
	   		paramMap.put("sCurrentTime", sCurrentTime);
	   		paramMap.put("akmem_recpt_no", akmem_recpt_no);
	   		paramMap.put("period", actionobj.getPeriod());
	   		paramMap.put("dTotAmt", actionobj.getDTotAmt());
	   		paramMap.put("dTotalAmt", actionobj.getDTotalAmt());
	   		paramMap.put("sCardNo", actionobj.getSCardNo());
	   		paramMap.put("sInstFg", sInstFg);
	   		paramMap.put("sAllot", actionobj.getSAllot());
	   		paramMap.put("sValidDt", sValidDt);
	   		paramMap.put("sApprovNo", sApprovNo);
	   		paramMap.put("scBank_cd", scBank_cd);
	   		paramMap.put("scRate", scRate);
	   		paramMap.put("cardfg", actionobj.getCardfg()); // pay_method 카드결제 경우 결제 카드사 정보 추가 (10.10.28)
	   		paramMap.put("strECode", strECode); // 신한카드 결제경우 할인구분 AK신한 5%코드 추가 (12.10.15)
	   		paramMap.put("tid", actionobj.getTid());
	   		paramMap.put("uPointAmt", Double.toString(actionobj.getUPointAmt()).split("\\.")[0]);
	   		paramMap.put("attendCustNo", actionobj.getAttendCustNo());
	   		paramMap.put("sessionId", actionobj.getSessionId());
	   		paramMap.put("tot_subject_cd", actionobj.getTot_subject_cd());
   		
          int upcnt = getSqlSession().insert(NS + ".insWbtrTb_half", paramMap);
          System.out.println("upcnt : "+upcnt);
          
          if (upcnt == 0) {
          	c_PayPlus.mf_init_set();

              tran_cd = "00200000";
              
              int mod_data_set_no;                
              mod_data_set_no = c_PayPlus.mf_add_set( "mod_data" );

              c_PayPlus.mf_set_us( mod_data_set_no, "tno",      actionobj.getTid()); // KCP 원거래 거래번호
              c_PayPlus.mf_set_us( mod_data_set_no, "mod_type", "STSC"   ); // 원거래 변경 요청 종류
              c_PayPlus.mf_set_us( mod_data_set_no, "mod_ip",   actionobj.getSessionId()  ); // 변경 요청자 IP
              c_PayPlus.mf_set_us( mod_data_set_no, "mod_desc", "가맹점 결과 처리 오류 - 가맹점에서 취소 요청"  ); // 변경 사유

   			c_PayPlus.mf_do_tx( g_conf_site_cd, g_conf_site_key, tran_cd, "", actionobj.getOrdr_idxx(), g_conf_log_level, "0" );
   			
              rslt = "매출테이블 저장 시 에러가 발생하였습니다.";
              return rslt;
          } else if (upcnt > 0) {
              if ("00".equals(actionobj.getAkmem_card_status())) {

                  // 삼성카드 인지 체크(마일리지 0%)
                  // 삼성카드 인지 체크(마일리지 0.1%)(10.01.04 변경됨)
                  // 제휴 삼성카드도 마일리지 적립되어야함 - 09.12.01~11.06.08까지 애경삼성카드 적립
                  // 불가오류로 로직 변경함 (11.06.08)
                  // 차후 연계제휴삼성카드 마일리지적립율 변경시 CmAKmembers.java -
                  // getCalcAkmemPoint()메소드 참고하여 수정필요 ★
              	/* 삼성 카드 체크 불가 2014.07 PG사 도입 일반 카드로 분류
              	 * 삼성 카드는 마일리지 적립이 있다.(10.01.04 변경됨)
                  int SAMSUNGCount = 0;*/
              	
                  // 신한제휴카드 인지 체크 (마일리지 적립시 20%추가 인정)
                  int SHINHANCount = 0;
                  
              	//국민제휴 확인(2017.09)
              	int KBCount = 0;
                  
                  if(actionobj.getAkcard_yn().equals("Y")){
                  	SHINHANCount = 1;
                  }else if(actionobj.getAkKBcard_yn().equals("Y")){
                  	KBCount = 1;
                  }

                  System.out.println("SHINHANCount >>>>" +SHINHANCount + "+KBCount >>>>" +KBCount);

                  System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> actionobj.getAkmem_card_status() :" + actionobj.getAkmem_card_status()+ "<<<<<<");
                  System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> actionobj.getAKmemCardNo()       :" + actionobj.getAKmemCardNo() + "<<<<<<<<<<");
                  System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> actionobj.getSCardNo()           :" + actionobj.getSCardNo() + "<<<<<<<<<<<<<<");
                  System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> akmem_recpt_no                   :" + akmem_recpt_no + "<<<<<<<<<<<<<<");
                  System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> actionobj.getDTotalAmt()         :" + Integer.toString((int) (actionobj.getDTotalAmt())) + "<<<<<<<<<<<<<<");
                  System.out.println("멤버스적립 saveAKmemPoint >>>>>>>>>> actionobj.getUPointAmt()         :" + actionobj.getUPointAmt());
                  
                  System.out.println("actionobj.getUPointAmt() : "+actionobj.getUPointAmt());

                  if(!g_sat_fg.equals("P")){ //마일리지 전액 사용이 아니라면 적립 전문 보냄
                  	//AKmembers 적립요청
                      CmAKmembers exeAKmem = new CmAKmembers();
                      HashMap map = exeAKmem.AKmemPoint(actionobj.getStore()
                      		, actionobj.getAKmemCardNo()
                      		, actionobj.getSCardNo() // card_no
                              , Utils.getCurrentDate() // recpt_sale_ymd
                              , "070013" // 인터넷 포스 번호
                              , akmem_recpt_no // recpt_no 영수증번호가 없으므로 멤버스용 akmem_recpt_no
                              , Integer.toString((int) (actionobj.getDTotalAmt())) // total_amt
                              , Integer.toString(exeAKmem.getCalcAkmemPoint(SHINHANCount, KBCount, actionobj.getDTotalAmt(), this)) // akmem_recpt_point
                              , Integer.toString((int) (actionobj.getUPointAmt())) // akmem_recpt_point
                              , ""
                              , ""
                              , "SAVE"); 

                      String AKmem_sApprovNo = (String) map.get("RSP_CD");
                      String AKmem_sMessage = (String) map.get("MSG_TRMNL");

                      if ("00".equals(AKmem_sApprovNo)) {
                          String AKmem_SaveApproveNo = (String) map.get("PTCP_PERM_NO");
                          String AKmem_SaveApproveNo_POS = (String) map.get("PERM_NO");
                          String AKmem_SaveApprove_Point = (String) map.get("EUSE_PT");
                          String AKmem_CustNo = (String) map.get("CUS_NO");
                          String AKmem_Create_Point = (String) map.get("TOT_CREA_PT");
                          String AKmem_CardNo = (String) map.get("CARD_NO");
                          String AKmem_send_buff = (String) map.get("SEND_STR");
                          String AKmem_recv_buff = (String) map.get("RECV_BUFF");
                          
                          slip_cnt++;
                          System.out.println("AKmem_SaveApprove_Point >>>>> 적립 >>>>> +"+AKmem_SaveApprove_Point);

                          // db insert
                          HashMap<String, Object> paramMap3 = new HashMap<>();
                  		paramMap3.put("hq", actionobj.getHq());
                  		paramMap3.put("store", actionobj.getStore());
                  		paramMap3.put("sDate", Utils.getCurrentDate());
                  		paramMap3.put("pos_no", "070013");
                  		paramMap3.put("akmem_recpt_no", akmem_recpt_no);
                  		paramMap3.put("dTotalAmt", actionobj.getDTotalAmt());
                  		paramMap3.put("AKmem_CardNo", AKmem_CardNo);// 멤버스카드번호-암호화 제거(2018.06.20)
                  		paramMap3.put("AKmem_CustNo", AKmem_CustNo);
                  		paramMap3.put("AKmem_Create_Point", AKmem_Create_Point);
                  		paramMap3.put("AKmem_SaveApproveNo_POS", AKmem_SaveApproveNo_POS);
                  		paramMap3.put("AKmem_SaveApprove_Point", AKmem_SaveApprove_Point);
                  		paramMap3.put("AKmem_send_buff", AKmem_send_buff);
                  		paramMap3.put("AKmem_recv_buff", AKmem_recv_buff);
                  		paramMap3.put("slip_cnt", slip_cnt);
                  		
                          int count1 = getSqlSession().insert(NS + ".insWbptTb2", paramMap3);
                          
                          if (count1 == 0) {
                              rslt = "AK멤버스 적립 테이블 저장중 ERROR가 발생하였습니다.";
                              return rslt;
                          }

                          System.out.println("적립 ok -> db-insert");
                          System.out.println("AKmem_SaveApproveNo = " + AKmem_SaveApproveNo);
                          System.out.println("AKmem_SaveApproveNo_POS = " + AKmem_SaveApproveNo_POS);
                          System.out.println("AKmem_SaveApprove_Point = " + AKmem_SaveApprove_Point);
                          // return value에 적립후 포인트 추가 ( ^금회적립포인트 ^적립후 포인트)

                      } else { 
                          rslt = "AK멤버스 적립요청오류";
                          return rslt;
                      }
                      rslt = "success";
                  }
              }

             
              return rslt;
          }
   	} 
   	
   	
   	/*------------------------------------------------------------------------------------
        *     유료강좌 recpt_no 영수증번호 생성 -- AKmembers 로 unique 한 key를 적립하기위해선 영수증번호가 필요함 by CH 090102
        *-----------------------------------------------------------------------------------*/
       	c_PayPlus.mf_init_set();

       tran_cd = "00200000";
       
       int mod_data_set_no;                
       mod_data_set_no = c_PayPlus.mf_add_set( "mod_data" );

       c_PayPlus.mf_set_us( mod_data_set_no, "tno",      actionobj.getTid()); // KCP 원거래 거래번호
       c_PayPlus.mf_set_us( mod_data_set_no, "mod_type", "STSC"   ); // 원거래 변경 요청 종류
       c_PayPlus.mf_set_us( mod_data_set_no, "mod_ip",   actionobj.getSessionId()  ); // 변경 요청자 IP
       c_PayPlus.mf_set_us( mod_data_set_no, "mod_desc", "가맹점 결과 처리 오류 - 가맹점에서 취소 요청"  ); // 변경 사유

		c_PayPlus.mf_do_tx( g_conf_site_cd, g_conf_site_key, tran_cd, "", actionobj.getOrdr_idxx(), g_conf_log_level, "0" );
		
       return rslt;
	}


	public String giftProcess(LectureVo actionobj) throws Exception {
        try {

            int allCreateCnt = 0; // 선착순 등록 총인원
            int webcount = 0;
            int lect_cnt_count = 0;
            
            String cust_fg = "";
            String gift_fg = "";
            int giftCnt1 = 0; //기존회원 선착순
            int giftCnt2 = 0; // 신규회원 선착순
            int giftCnt3 = 0; //B에서 사용
            int giftCnt4 = 0; //C에서 사용
            int giftClass3Cnt = 0; // 사은품관리(등록) X강좌이상 선착순 인원등록수
            int lect_cnt_count2 = 0; // 수강내역 X강좌 이상 총 인원 조회
            int giftA_AllCnt = 0; // 사은품관리(등록) 기존+신규 선착순 인원등록수
            int existCntw = 0; //기존회원
            int newCntw = 0; //신규회원
            String sReturn = ""; //사은품리턴값
            int cnt = 0; //ABC씀 바꾸려면 다바꿔야됨
            boolean createYn = false; //선착순대상자 확인
            String rslt = "";
            String gift_massage = "";
            
            // 구로점 10회이상이거나 620 시작강좌
            if ("01".equals(actionobj.getStore())) {
            	
            	lect_cnt_count = getSqlSession().selectOne(NS + ".getLectCntCount_01", actionobj);
                // ★ 12.01.11 수원점 8회이상으로 변경(윤정희)
                // 11.10.27 수원점 내부 리뉴얼 공사로 6회이상으로 변경(이소진)
                // 11.01.25 8회이상 강좌 가능(이소진)
                // 수원점 10회이상이거나 620 시작강좌
            } else if ("02".equals(actionobj.getStore())) {
            	lect_cnt_count = getSqlSession().selectOne(NS + ".getLectCntCount_02", actionobj);
                // 11.10.27 query.append(" AND (B.LECT_CNT > 5 ) \n"); // 6회이상
                // 10.01.26 (old)이거나 118004 강좌(8회강좌) (윤정희 비활성화 요청)
                // query.append(" AND (B.LECT_CNT > 9 ) \n");
                // 10.10.25 10회이상만 가능(이소진) query.append(" AND (B.LECT_CNT > 7 )
                // \n");
                // 10.04.29 8회이상만 가능(이소진) query.append(" AND (B.LECT_CNT > 9 OR
                // (SUBSTR(B.SUBJECT_CD,1,3) = '620')) \n");

            } else if ("03".equals(actionobj.getStore())) {
            	lect_cnt_count = getSqlSession().selectOne(NS + ".getLectCntCount_03", actionobj);
                // 영재음악원 사은품체크 제외(10.01.26 백혜정)
                // 분당 44기 620001 코드만 사은품 지급 요청 (08.07.30 박지선)
                // 현재 분당 10회이상이거나 620001, 620002 강좌 포함(09.07.21)
                // 평택점 10회이상이거나 620 시작강좌
                // (old) 이거나 101001 강좌 (6회강좌) - (10.01.26 이효진주임 비활성화 요청)
            } else if ("04".equals(actionobj.getStore())) {
            	lect_cnt_count = getSqlSession().selectOne(NS + ".getLectCntCount_04", actionobj);
            } else if ("05".equals(actionobj.getStore())) {
            	lect_cnt_count = getSqlSession().selectOne(NS + ".getLectCntCount_05", actionobj);
            }


            /*System.out.println(" 사은품 지급 체크  lect_cnt_count  : >>>>>>>>>>>>>>>>>> "+ lect_cnt_count);
            System.out.println(" 사은품 지급 체크 지점 >>>>>>>>>>>>>>>>>> "+ actionobj.getStore());*/

            // 08.05.10 수원점 사은품 지급수량여분으로 온라인 체크 차단요청 (윤정희대리)
            // 한 강좌라도 lect_cnt 가 10회 이상인 강좌만 사은품 로직을 탑니다.
            if (lect_cnt_count > 0) {

                /*------------------------------------------------------------------------------------
                 *    ** 사은품 Class A
                 *-----------------------------------------------------------------------------------*/

                // 고객과거 매출 조회 for cust_fg 무료강좌회원도 매출로 확인
            	System.out.println("1");
            	HashMap<String, Object> custCnt = getSqlSession().selectOne(NS + ".getCustFg", actionobj);
            	System.out.println("2");
            	if(custCnt != null && custCnt.get("COUNT") != null)
            	{
            		// 과거 매출이 존재 - 기존
            		System.out.println("기존회원입니다.기수->>"+custCnt.get("COUNT"));
            		cust_fg = "0";
            	}
            	else
            	{
            		// 신규회원
            		System.out.println("신규회원입니다.");
            		cust_fg = "1";
            	}
            	System.out.println("3");
                // 사은품 인원수를 받아오자. (GIFT_CLASS3_CNT X강좌이상 x선착순인원 추가)
                // 2014.03.10 BY KSM WEB 선착순 시간보다 미만일시는 0 아니면 설정된 웹 선착순 인원을 가져옴. CASE문 추가. 
            	HashMap<String, Object> giftcnt = getSqlSession().selectOne(NS + ".getGiftCnt", actionobj);
            	System.out.println("4");
            	if(giftcnt != null)
            	{
                    giftCnt1 = Utils.checkNullInt(giftcnt.get("GIFT_CNT1"));
                    giftCnt2 = Utils.checkNullInt(giftcnt.get("GIFT_CNT2"));
                    giftCnt3 = Utils.checkNullInt(giftcnt.get("GIFT_CNT3"));
                    giftCnt4 = Utils.checkNullInt(giftcnt.get("GIFT_CNT4"));
                    giftClass3Cnt = Utils.checkNullInt(giftcnt.get("GIFT_CLASS3_CNT")); // 사은품관리(등록)
                                                                    // X강좌 선착순
                                                                    // 인원 조회
                 // WEB/DESK 분리 WEB 조회(2011.04.25)
                    giftA_AllCnt = Utils.checkNullInt(giftcnt.get("GIFTA_ALLCNT")); // 총 회원 선착순
                    existCntw = Utils.checkNullInt(giftcnt.get("EXIST_CNT_W")); // 기존 회원 선착순 마감 인원
                    newCntw = Utils.checkNullInt(giftcnt.get("NEW_CNT_W")); // 신규 회원 선착순  마감 인원
                    System.out.println("5");
            	}
                //여기부터가 A 시작 위에 공통
                /*System.out.println("기존+신규 선착순 인원 조회 giftCnt0 ->giftA_AllCnt  >>>>>>>>>> :"+ giftA_AllCnt);
                System.out.println("기존+신규 선착순 WEB 마감 인원 조회 giftCnt0_w->existCntw >>> :"+ existCntw);*/

                // BAGIFTTB 에서 해당기수에 사은품A 지급내역 정보를 조회해 온다.
                    
            	HashMap<String, Object> getGiftFg = getSqlSession().selectOne(NS + ".getGiftFg", actionobj);
            	if(getGiftFg != null)
            	{
            		gift_fg = Utils.checkNullString(getGiftFg.get("GIFT_FG"));
            	}
                System.out.println("6");
                if(gift_fg.equals("1") || gift_fg.equals("2")) {
                    // 사은품 테이블에 고객정보가 있으면(반납인원제외)
                	//지금 미지급만 수령
                    sReturn = "Y";
                    System.out.println("이미 사은품 A를 수령한 회원입니다.");
                } else {
                    // 선착순 등록 총인원  조회
                	allCreateCnt = getSqlSession().selectOne(NS + ".getAllCreateCnt", actionobj);
                	System.out.println("7");
                    //웹에서는 웹만 신경쓰면 될듯
                    //allCreateCnt 사용안할수도 있음 등록총인원
                    //선착순 등록인원 < 설정된_선착순_총인원 - 총인원 0이면 제외됨 (선착순 사용안함)
                    if (allCreateCnt < giftA_AllCnt) {
                    	System.out.println("8");
                    	//선착순 사용함 들어오면 일단 몇명 등록된지 확인
                    	//기존,신규 선착순 시작할시 - 기존선착순0 이거나 날짜미포함 0 -제외
                   // 	//if(existCntw > 0 ){
                    		//1.기존선착순 등록자확인
                    		webcount = getSqlSession().selectOne(NS + ".getWebCount", actionobj);
                            //기존 선착순대상자  가능확인 현재등록인원 < 기존선착순 설정인원
                            if(webcount < existCntw){
                            	createYn = true;
                            
                            //현재까지 선착순웹등록 전체 < 기존+신규웹설정인원 (기존에 소진안된것포함20160707윤정희과장요청) //미포함하려면 쿼리변경필요    
                            }else if(webcount < newCntw){ 
	                           	createYn = true;
                            }
                            System.out.println("9");
                            // 1. 대상자가능
                            if (createYn) {
                            	System.out.println("10");
                                if(gift_fg.equals("0") || gift_fg.equals("9")) {
                                	//미지급 취소 대상자 전환
                                    System.out.println("회원의 반납이력이 있습니다. GIFT_FG를 '2'(미지급)로 변환합니다.");

                                    cnt = getSqlSession().update(NS + ".upGiftRet", actionobj);

                                    if (cnt == 0) {
                                        System.out.println("-----사은품A 테이블 수정중 ERROR가 발생하였습니다.--->>>"+cnt);
                                        rslt = "fail";
                                        return rslt;
                                    }
                                    sReturn = "A";
                                    
                                } else {
                                	System.out.println("11");
                                	//추후 현재 1명 1개 선착순등록,->2개이상 받는것으로 변경되면 pk수정5->6 사람당 받은갯수 로 변경
                                    // 이력이 없으면 INSERT
                                    
                                  
                                	HashMap<String, Object> map = new HashMap<>();
                            		map.put("hq", actionobj.getHq());
                            		map.put("store", actionobj.getStore());
                            		map.put("period", actionobj.getPeriod());
                            		map.put("attendCustNo", actionobj.getAttendCustNo());
                            		map.put("cust_fg", cust_fg);
                            		System.out.println("12");
                                    cnt = getSqlSession().insert(NS + ".insGiftRet", actionobj);

	                                    if (cnt == 0) {
	                                        System.out.println("-----사은품A 테이블 저장중 ERROR가 발생하였습니다.-----");
	                                        rslt = "fail";
	                                        return rslt;
	                                    }
                                    sReturn = "A";
                                }
                                System.out.println("13");
                        //신규 선착순 시작    신규+기존 선착순 전체 / 현재등록인원 < 선착순 총설정 인원
                        }else{
                        	System.out.println("14");
                        	System.out.println("사은품A WEB 지급 인원을 초과하였습니다.");
                            sReturn = "Y";
                        }
                    }else {
                    	System.out.println("15");
                        System.out.println("사은품A 지급 인원을 초과하였습니다.");
                        sReturn = "Y";
                    }
                }

                /*------------------------------------------------------------------------------------
                 *    ** 사은품 Class B
                 *-----------------------------------------------------------------------------------*/

                // 1. 현재 BAPERETB 에 몇건의 강좌가 있는지 COUNT
                int classBCount = 0;
                int bawbtrtbCount = 0;

                int classBCountAK = 0;
                int bawbtrtbCountAK = 0;

                // 09.07.21 점별 사은품 지급 대상 강좌 별도요청으로 분리함

                // ★ 11.01.26 구로점 10회 이상이거나 620 시작강좌 사은품 B(X강좌이상 수강) AK신한카드 결제자만
                // 해당됨(백혜정)
                // 구로점 10회이상이거나 620 시작강좌
                if ("01".equals(actionobj.getStore())) {
                	
                	classBCount = getSqlSession().selectOne(NS + ".getClassBCount_01", actionobj);
                    /*
                     * 기존소스 백업 query8.append(" SELECT COUNT(*) AS COUNT \n");
                     * query8.append(" FROM BAPERETB A, BAPELTTB B \n");
                     * query8.append(" WHERE A.HQ = ? \n"); query8.append(" AND
                     * A.STORE = ? \n"); query8.append(" AND A.PERIOD = ? \n");
                     * query8.append(" AND A.CUST_NO = ? \n"); query8.append("
                     * AND A.PAY_YN = 'Y' \n"); query8.append(" AND
                     * A.REGIS_CANCEL_FG = '1' \n"); query8.append(" AND
                     * (B.LECT_CNT > 9 OR (SUBSTR(B.SUBJECT_CD,1,3) = '620'))
                     * \n"); query8.append(" AND A.HQ = B.HQ \n");
                     * query8.append(" AND A.STORE = B.STORE \n");
                     * query8.append(" AND A.SUBJECT_CD = B.SUBJECT_CD \n");
                     * query8.append(" AND A.PERIOD = B.PERIOD \n");
                     * query8.append(" GROUP BY A.PERIOD \n");
                     */

                    // ★ 12.01.11 수원점 8회이상으로 변경 / AK신한카드만 결제가능 (윤정희)
                    // 11.10.27 수원점 내부리뉴얼 공사로 6회이상으로 변경(이소진) / AK신한카드 결제 비활성화,
                    // AK신한카드 체크제외 , 강좌횟수만 해당하면 됨 (홍소현)
                    // 11.01.25 수원점 8회이상 강좌(이소진) 사은품 B(X강좌이상 수강) AK신한카드 결제자만 해당됨
                } else if ("02".equals(actionobj.getStore())) {
                    /*
                     * (old)이거나 118004 강좌(8회강좌) (10.01.26 윤정희 비활성화 요청)
                     * query8.append(" AND (B.LECT_CNT > 9 ) \n"); 기존소스 백업
                     * (10.10.27) query8.append(" SELECT COUNT(*) AS COUNT \n");
                     * query8.append(" FROM BAPERETB A, BAPELTTB B \n");
                     * query8.append(" WHERE A.HQ = ? \n"); query8.append(" AND
                     * A.STORE = ? \n"); query8.append(" AND A.PERIOD = ? \n");
                     * query8.append(" AND A.CUST_NO = ? \n"); query8.append("
                     * AND A.PAY_YN = 'Y' \n"); query8.append(" AND
                     * A.REGIS_CANCEL_FG = '1' \n"); query8.append(" AND
                     * (B.LECT_CNT > 9 ) \n");
                     * 
                     * 10.10.25 10회이상만 가능(이소진) query8.append(" AND (B.LECT_CNT >
                     * 7 ) \n"); 10.04.29 8회이상만 가능(이소진) query8.append(" AND
                     * (B.LECT_CNT > 9 OR (SUBSTR(B.SUBJECT_CD,1,3) = '620' ))
                     * \n"); query8.append(" AND A.HQ = B.HQ \n");
                     * query8.append(" AND A.STORE = B.STORE \n");
                     * query8.append(" AND A.SUBJECT_CD = B.SUBJECT_CD \n");
                     * query8.append(" AND A.PERIOD = B.PERIOD \n");
                     * query8.append(" GROUP BY A.PERIOD \n");
                     */
                    // 사은품 B(X강좌이상 수강) AK신한카드 결제자만 해당됨 - 수원점 (10.10.27 백혜정)
                	classBCount = getSqlSession().selectOne(NS + ".getClassBCount_02", actionobj);
                    // ★ 분당점 영재음악원 사은품체크 제외 분당 620001, 620002 강좌 포함
                    // 영재음악원 사은품체크 제외(10.01.26 백혜정)
                    // 분당 44기 6200001 코드만 사은품 지급 요청 (08.07.30 박지선)
                    // 현재 분당 620001, 620002 강좌 포함(09.07.21)
                } else if ("03".equals(actionobj.getStore())) {
                    /*
                     * 기존소스 백업 (10.10.27 ) query8.append(" SELECT COUNT(*) AS
                     * COUNT \n"); query8.append(" FROM BAPERETB A, BAPELTTB B
                     * \n"); query8.append(" WHERE A.HQ = ? \n");
                     * query8.append(" AND A.STORE = ? \n"); query8.append(" AND
                     * A.PERIOD = ? \n"); query8.append(" AND A.CUST_NO = ?
                     * \n"); query8.append(" AND A.PAY_YN = 'Y' \n");
                     * query8.append(" AND A.REGIS_CANCEL_FG = '1' \n");
                     * query8.append(" AND (substr(B.SUBJECT_CD,1,3) <> '414')
                     * AND (B.LECT_CNT > 9 OR ( B.SUBJECT_CD in
                     * ('620001','620002')) ) \n"); query8.append(" AND A.HQ =
                     * B.HQ \n"); query8.append(" AND A.STORE = B.STORE \n");
                     * query8.append(" AND A.SUBJECT_CD = B.SUBJECT_CD \n");
                     * query8.append(" AND A.PERIOD = B.PERIOD \n");
                     * query8.append(" GROUP BY A.PERIOD \n");
                     */
                    // 사은품 B(X강좌이상 수강) AK신한카드 결제자만 해당됨 - 분당점 (10.10.27 백혜정)
                	classBCount = getSqlSession().selectOne(NS + ".getClassBCount_03", actionobj);

                    // ★ 11.01.26 평택점 10회 이상이거나 620 시작강좌 사은품 B(X강좌이상 수강) AK신한카드
                    // 결제자만 해당됨(백혜정)
                    // 평택점 10회이상이거나 620 시작강좌
                    // (old) 이거나 101001 강좌 (6회강좌) - (10.01.26 이효진주임 비활성화 요청)
                } else if ("04".equals(actionobj.getStore())) {
                	classBCount = getSqlSession().selectOne(NS + ".getClassBCount_04", actionobj);

                    /*
                     * 기존소스 백업 query8.append(" SELECT COUNT(*) AS COUNT \n");
                     * query8.append(" FROM BAPERETB A, BAPELTTB B \n");
                     * query8.append(" WHERE A.HQ = ? \n"); query8.append(" AND
                     * A.STORE = ? \n"); query8.append(" AND A.PERIOD = ? \n");
                     * query8.append(" AND A.CUST_NO = ? \n"); query8.append("
                     * AND A.PAY_YN = 'Y' \n"); query8.append(" AND
                     * A.REGIS_CANCEL_FG = '1' \n"); query8.append(" AND
                     * (B.LECT_CNT > 9 OR (SUBSTR(B.SUBJECT_CD,1,3) = '620' ))
                     * \n"); query8.append(" AND A.HQ = B.HQ \n");
                     * query8.append(" AND A.STORE = B.STORE \n");
                     * query8.append(" AND A.SUBJECT_CD = B.SUBJECT_CD \n");
                     * query8.append(" AND A.PERIOD = B.PERIOD \n");
                     * query8.append(" GROUP BY A.PERIOD \n");
                     */
                } else if ("05".equals(actionobj.getStore())) {
                	classBCount = getSqlSession().selectOne(NS + ".getClassBCount_05", actionobj);

                }


                /*System.out.println("  giftProcess.java   --  query8  :"+ query8);
                System.out.println("  giftProcess.java   --  getHq  :" + actionobj.getHq());
                System.out.println("  giftProcess.java   --  getStore  :"+ actionobj.getStore());
                System.out.println("  giftProcess.java   --  getPeriod  :" + actionobj.getPeriod());
                System.out.println("  giftProcess.java   --  getAttendCustNo  :" + actionobj.getAttendCustNo());*/


                /*
                 * // 평택점 사은품 B(X강좌이상 수강) AK신한카드 결제자만 2만원 / AK신한카드 미결제자 1만원 해당됨 -
                 * 분당점 (10.10.28 백혜정요청 ) START ---------------
                 * if("04".equals(actionobj.getStore())) { query8AK.append("
                 * SELECT COUNT(*) AS COUNT \n"); query8AK.append(" FROM
                 * BAPERETB A, BAPELTTB B , BATRCATB C \n"); query8AK.append("
                 * WHERE A.HQ = ? \n"); query8AK.append(" AND A.STORE = ? \n");
                 * query8AK.append(" AND A.PERIOD = ? \n"); query8AK.append("
                 * AND A.CUST_NO = ? \n"); query8AK.append(" AND A.PAY_YN = 'Y'
                 * \n"); query8AK.append(" AND A.REGIS_CANCEL_FG = '1' \n");
                 * query8AK.append(" AND C.CARD_CORP_NO ='822' \n");
                 * query8AK.append(" AND (B.LECT_CNT > 9 OR
                 * (SUBSTR(B.SUBJECT_CD,1,3) = '620' )) \n"); query8AK.append("
                 * AND A.HQ = B.HQ \n"); query8AK.append(" AND A.HQ = C.HQ \n");
                 * query8AK.append(" AND A.STORE = B.STORE \n");
                 * query8AK.append(" AND A.STORE = C.STORE \n");
                 * query8AK.append(" AND A.SALE_YMD = C.SALE_YMD \n");
                 * query8AK.append(" AND A.POS_NO = C.POS_NO \n");
                 * query8AK.append(" AND A.RECPT_NO = C.RECPT_NO \n");
                 * query8AK.append(" AND A.SUBJECT_CD = B.SUBJECT_CD \n");
                 * query8AK.append(" AND A.PERIOD = B.PERIOD \n");
                 * query8AK.append(" GROUP BY A.PERIOD \n");
                 * 
                 * qm8AK.setString( 1, actionobj.getHq() ); qm8AK.setString( 2,
                 * actionobj.getStore() ); qm8AK.setString( 3,
                 * actionobj.getPeriod() ); qm8AK.setString( 4,
                 * actionobj.getAttendCustNo() );
                 * 
                 * System.out.println(" giftProcess.java -- query8 :"+query8);
                 * 
                 * AkResultSet rs8AK = qm8AK.executeQuery(query8AK);
                 * 
                 * if(rs8AK.next()) { classBCountAK = rs8.getInt("count"); }
                 * System.out.println(">>>>>>>>>>>>>>>>>>>>>> classBCountAK
                 * :"+classBCountAK + " <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
                 * 
                 *  }
                 */
                // 평택점 사은품 B(X강좌이상 수강) AK신한카드 결제자만 2만원 / AK신한카드 미결제자 1만원 해당됨 -
                // 분당점 (10.10.28 백혜정요청 ) END ---------------

                // -----------------------------------------------------------
                // 2. BAWBTRTB 에 몇건의 강좌가 있는지 COUNT
                // ----------------------------------------------------------
                // 09.07.21 점별 사은품 지급 대상 강좌 별도요청으로 분리함
                // ★ 11.01.26 구로점 10회 이상이거나 620 시작강좌 사은품 B(X강좌이상 수강) AK신한카드 결제자만
                // 해당됨(백혜정)
                // 구로점 10회이상이거나 620 시작강좌
                if ("01".equals(actionobj.getStore())) {
                	bawbtrtbCount = getSqlSession().selectOne(NS + ".getWbtrtbCount_01", actionobj);
                   

                    /*
                     * 기존소스 백업 query9.append(" SELECT COUNT(*) AS COUNT \n");
                     * query9.append(" FROM BAWBTRTB A, BAPELTTB B \n");
                     * query9.append(" WHERE A.HQ = ? \n"); query9.append(" AND
                     * A.STORE = ? \n"); query9.append(" AND A.PERIOD = ? \n");
                     * query9.append(" AND A.CUST_NO = ? \n"); query9.append("
                     * AND A.SEND_YN = 'N' \n"); query9.append(" AND (B.LECT_CNT >
                     * 9 OR (SUBSTR(B.SUBJECT_CD,1,3) = '620' )) \n");
                     * query9.append(" AND A.HQ = B.HQ \n"); query9.append(" AND
                     * A.STORE = B.STORE \n"); query9.append(" AND A.SUBJECT_CD =
                     * B.SUBJECT_CD \n"); query9.append(" AND A.PERIOD =
                     * B.PERIOD \n"); query9.append(" GROUP BY A.PERIOD \n");
                     */

                    // ★ 12.01.11 수원점 8회이상으로 변경 / AK신한카드만 결제가능 (윤정희)
                    // 11.10.27 수원점 내부리뉴얼 공사로 6회이상으로 변경(이소진) / AK신한카드 결제 비활성화,
                    // AK신한카드 체크제외 , 강좌횟수만 해당하면 됨 (홍소현)
                    // 11.01.25 수원점 8회이상 강좌(이소진)
                    // 수원점 10회이상이거나 620 시작강좌
                    // (old)이거나 118004 강좌(8회강좌) (10.01.26 윤정희 비활성화 요청)
                } else if ("02".equals(actionobj.getStore())) {
                    /*
                     * 기존소스 백업 (10.10.28 ) query9.append(" SELECT COUNT(*) AS
                     * COUNT \n"); query9.append(" FROM BAWBTRTB A, BAPELTTB B
                     * \n"); query9.append(" WHERE A.HQ = ? \n");
                     * query9.append(" AND A.STORE = ? \n"); query9.append(" AND
                     * A.PERIOD = ? \n"); query9.append(" AND A.CUST_NO = ?
                     * \n"); query9.append(" AND A.SEND_YN = 'N' \n");
                     * query9.append(" AND (B.LECT_CNT > 9 ) \n"); //10.10.25
                     * 10회이상만 가능(이소진)query9.append(" AND (B.LECT_CNT > 7 ) \n");
                     * //10.04.29 8회이상만 가능(이소진) query9.append(" AND (B.LECT_CNT >
                     * 9 OR (SUBSTR(B.SUBJECT_CD,1,3) = '620' )) \n");
                     * query9.append(" AND A.HQ = B.HQ \n"); query9.append(" AND
                     * A.STORE = B.STORE \n"); query9.append(" AND A.SUBJECT_CD =
                     * B.SUBJECT_CD \n"); query9.append(" AND A.PERIOD =
                     * B.PERIOD \n"); query9.append(" GROUP BY A.PERIOD \n");
                     */

                    // 사은품 B(X강좌이상 수강) AK신한카드 결제자만 해당됨 - 수원점 (10.10.27 백혜정)
                	bawbtrtbCount = getSqlSession().selectOne(NS + ".getWbtrtbCount_02", actionobj);
                   

                    // ★ 분당점 영재음악원 사은품체크 제외 분당 620001, 620002 강좌 포함
                    // 영재음악원 사은품체크 제외(10.01.26 백혜정)
                    // 분당 44기 6200001 코드만 사은품 지급 요청 (08.07.30 박지선)
                    // 현재 분당 10회이상강좌이거나 620001, 620002 강좌 포함(09.07.21)
                } else if ("03".equals(actionobj.getStore())) {
                    /*
                     * 기존소스 백업 (10.10.28 ) query9.append(" SELECT COUNT(*) AS
                     * COUNT \n"); query9.append(" FROM BAWBTRTB A, BAPELTTB B
                     * \n"); query9.append(" WHERE A.HQ = ? \n");
                     * query9.append(" AND A.STORE = ? \n"); query9.append(" AND
                     * A.PERIOD = ? \n"); query9.append(" AND A.CUST_NO = ?
                     * \n"); query9.append(" AND A.SEND_YN = 'N' \n");
                     * query9.append(" AND (substr(B.SUBJECT_CD,1,3) <> '414')
                     * AND (B.LECT_CNT > 9 OR ( B.SUBJECT_CD in
                     * ('620001','620002')) ) \n"); query9.append(" AND A.HQ =
                     * B.HQ \n"); query9.append(" AND A.STORE = B.STORE \n");
                     * query9.append(" AND A.SUBJECT_CD = B.SUBJECT_CD \n");
                     * query9.append(" AND A.PERIOD = B.PERIOD \n");
                     * query9.append(" GROUP BY A.PERIOD \n");
                     */

                    // 사은품 B(X강좌이상 수강) AK신한카드 결제자만 해당됨 - 분당점 (10.10.27 백혜정)
                	bawbtrtbCount = getSqlSession().selectOne(NS + ".getWbtrtbCount_03", actionobj);
                    

                    // ★ 11.01.26 평택점 10회 이상이거나 620 시작강좌 사은품 B(X강좌이상 수강) AK신한카드
                    // 결제자만 해당됨(백혜정)
                    // 평택점 10회이상이거나 620 시작강좌
                    // (old) 이거나 101001 강좌 (6회강좌) - (10.01.26 이효진주임 비활성화 요청)
                } else if ("04".equals(actionobj.getStore())) {
                	bawbtrtbCount = getSqlSession().selectOne(NS + ".getWbtrtbCount_04", actionobj);
                   

                    /*
                     * 기존소스 백업 query9.append(" SELECT COUNT(*) AS COUNT \n");
                     * query9.append(" FROM BAWBTRTB A, BAPELTTB B \n");
                     * query9.append(" WHERE A.HQ = ? \n"); query9.append(" AND
                     * A.STORE = ? \n"); query9.append(" AND A.PERIOD = ? \n");
                     * query9.append(" AND A.CUST_NO = ? \n"); query9.append("
                     * AND A.SEND_YN = 'N' \n"); query9.append(" AND (B.LECT_CNT >
                     * 9 OR (SUBSTR(B.SUBJECT_CD,1,3) = '620' )) \n");
                     * query9.append(" AND A.HQ = B.HQ \n"); query9.append(" AND
                     * A.STORE = B.STORE \n"); query9.append(" AND A.SUBJECT_CD =
                     * B.SUBJECT_CD \n"); query9.append(" AND A.PERIOD =
                     * B.PERIOD \n"); query9.append(" GROUP BY A.PERIOD \n");
                     */
                } else if ("05".equals(actionobj.getStore())) {
                	bawbtrtbCount = getSqlSession().selectOne(NS + ".getWbtrtbCount_05", actionobj);
                   
                }


                /*System.out.println("  giftProcess.java   --  query9  :"+ query9);
                System.out.println("  giftProcess.java   --  getHq  :"+ actionobj.getHq());
                System.out.println("  giftProcess.java   --  getStore  :"+ actionobj.getStore());
                System.out.println("  giftProcess.java   --  getPeriod  :"+ actionobj.getPeriod());
                System.out.println("  giftProcess.java   --  getAttendCustNo  :" + actionobj.getAttendCustNo());*/

                // 평택점 사은품 B(X강좌이상 수강) AK신한카드 결제자만 2만원 / AK신한카드 미결제자 1만원 해당됨 -
                // 분당점 (10.10.28 백혜정요청 ) START ---------------
                /*
                 * if("04".equals(actionobj.getStore())) { query9AK.append("
                 * SELECT COUNT(*) AS COUNT \n"); query9AK.append(" FROM
                 * BAWBTRTB A, BAPELTTB B \n"); query9AK.append(" WHERE A.HQ = ?
                 * \n"); query9AK.append(" AND A.STORE = ? \n");
                 * query9AK.append(" AND A.PERIOD = ? \n"); query9AK.append("
                 * AND A.CUST_NO = ? \n"); query9AK.append(" AND A.SEND_YN = 'N'
                 * \n"); query9AK.append(" AND A.PAY_METHOD = '822' \n");
                 * query9AK.append(" AND (B.LECT_CNT > 9 OR
                 * (SUBSTR(B.SUBJECT_CD,1,3) = '620' )) \n"); query9AK.append("
                 * AND A.HQ = B.HQ \n"); query9AK.append(" AND A.STORE = B.STORE
                 * \n"); query9AK.append(" AND A.SUBJECT_CD = B.SUBJECT_CD \n");
                 * query9AK.append(" AND A.PERIOD = B.PERIOD \n");
                 * query9AK.append(" GROUP BY A.PERIOD \n");
                 * 
                 * qm9AK.setString( 1, actionobj.getHq() ); qm9AK.setString( 2,
                 * actionobj.getStore() ); qm9AK.setString( 3,
                 * actionobj.getPeriod() ); qm9AK.setString( 4,
                 * actionobj.getAttendCustNo() );
                 * 
                 * System.out.println(" giftProcess.java -- query8AK
                 * :"+query8AK);
                 * 
                 * AkResultSet rs9AK = qm9AK.executeQuery(query9AK);
                 * 
                 * if(rs9AK.next()) { bawbtrtbCountAK = rs9AK.getInt("count"); }
                 * 
                 * System.out.println(">>>>>>>>>>>>>>>>>>>>>> bawbtrtbCountAK
                 * :"+bawbtrtbCountAK + " <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" ); }
                 */
                // 평택점 사은품 B(X강좌이상 수강) AK신한카드 결제자만 2만원 / AK신한카드 미결제자 1만원 해당됨 -
                // 분당점 (10.10.28 백혜정요청 ) END ---------------
                // 사은품 조회 Class B (X강좌이상 수강인원수 조회 BAGIFTTB 09.07.24)
                lect_cnt_count2 = getSqlSession().selectOne(NS + ".getLectCntCount2", actionobj);

                System.out.println(" lect_cnt_count2  :" + lect_cnt_count2 + "  <  giftClass3Cnt :  " + giftClass3Cnt);

                // 총 X강좌이상 수강회원이 사은품관리(등록) 선착순(BAGIFTTB) 총 인원보다 적을경우
                // 비교추가(09.07.24)
                if (lect_cnt_count2 < giftClass3Cnt) {

                    // 3. COUNT의 합이 3이상일때 사은품 테이블에 저장된 기록이 있는지 CHECK
                    // 08.10.31 구로점 사은품B 지급수량여분으로 온라인 체크 차단요청 (함승은)

                    System.out.println("classBCount    :" + classBCount + " + bawbtrtbCount :" + bawbtrtbCount + "  >=  giftCnt3  :" + giftCnt3);

                    // System.out.println(">>>>>>>>>>>>>>>>>>>>>> classBCountAK :"+classBCountAK + " + bawbtrtbCountAK :"+ bawbtrtbCountAK+" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );

                    if (classBCount + bawbtrtbCount >= giftCnt3) {
                        // BAGIFTTB 에서 해당기수에 사은품B 지급내역 정보를 조회해 온다.
                    	List<HashMap<String, Object>> getGiftRetList = getSqlSession().selectOne(NS + ".getGiftRetList", actionobj);
                        

                        System.out.println("사은품B   sqlQuery  -- hq  :"  + actionobj.getHq());
                        System.out.println("사은품B   sqlQuery  -- store  :" + actionobj.getStore());
                        System.out.println("사은품B   sqlQuery  -- sPeriod  :" + actionobj.getPeriod());
                        System.out.println("사은품B   sqlQuery  -- sAttendCustNo   :" + actionobj.getAttendCustNo());
                        System.out.println("사은품B   sqlQuery  -- B  : B ");


                        if (getGiftRetList.size() > 0) {
                            // 4. 테이블에 이미 저장되 있으면(반납인원제외) 추가 지급 하지 않음. return
                            // "Y"
                            sReturn = sReturn + "Y";
                            System.out.println("이미 사은품 B를 수령한 회원입니다.");
                        } else {
                            // 5. 반납이력조회 후 이력이 있으면 미지급으로 update, 없으면 미지급으로
                            // insert
                        	List<HashMap<String, Object>> getGiftRetList2 = getSqlSession().selectOne(NS + ".getGiftRetList2", actionobj);
                            

                            if (getGiftRetList2.size() > 0) {
                                System.out.println("회원의 반납이력이 있습니다. GIFT_FG를 '2'(미지급)로 변환합니다.");
                                cnt = getSqlSession().update(NS + ".upGiftList", actionobj);

                                if (cnt == 0) {
                                    System.out.println("-----사은품B 테이블 수정중 ERROR가 발생하였습니다.-----");
                                    rslt = "fail";
                                    return rslt;
                                }

                                sReturn = sReturn + "B";
                            } else {
                                // 이력이 없으면 INSERT

                                // 평택점 AK신한만 평택점 1만원 지급 변경(11.01.26) 백혜정
                                // 강좌횟수 점별 사은품 지급 문구 추가 (10.10.28)
                                /*
                                 * if("04".equals(actionobj.getStore()) &&
                                 * (classBCountAK + bawbtrtbCountAK >= giftCnt3) ) {
                                 * gift_massage = "2만원 상품권"; } else {
                                 * gift_massage = "1만원 상품권"; }
                                 * 
                                 * System.out.println("gift_massage :
                                 * >>>>>>>>>>>>>>>>>>>>> "+gift_massage);
                                 */

                                // ★ 12.01.11 기존로직 동일
                                gift_massage = "1만원 상품권";

                                // 11.10.27 수원점 내부리뉴얼 공사로 사은품 B 강좌횟수 (이소진) /
                                // AK신한카드 결제 비활성화, AK신한카드 체크제외 , 강좌횟수만 해당하면 됨
                                // (홍소현)
                                /*
                                 * if("02".equals(actionobj.getStore())) {
                                 * gift_massage = "애경 청은차 치약세트 "; }else{
                                 * gift_massage = "1만원 상품권"; }
                                 */

                                
                                cnt = getSqlSession().insert(NS + ".insGiftList", actionobj);

                                if (cnt == 0) {
                                    System.out.println("-----사은품B 테이블 저장중 ERROR가 발생하였습니다.-----");
                                    rslt = "fail";
                                    return rslt;
                                }

                                sReturn = sReturn + "B";
                            }
                        }
                    } else {
                        // 3강좌 이하라면 사은품 B 대상자 아님
                        sReturn = sReturn + "Y";
                    }
                } else {
                    // 3강좌 이하라면 사은품 B 대상자 아님
                    sReturn = sReturn + "Y";
                }
                System.out.println(" sReturn ****************  :" + sReturn);

                /*------------------------------------------------------------------------------------
                 *    ** 사은품 Class C
                 *-----------------------------------------------------------------------------------*/

                // 1. 1년 연속수강자인지 CHECK
                int classCCount = 0;
                int AKCount = 0;

                // 구로점 10회이상이거나 620 시작강좌

                // 분당 44기 6200001 코드만 사은품 지급 요청 (08.07.30 박지선)
                // 분당점, 평택점 연속수강자 체크 (분당, 평택 사은품 지급 대상강좌 분리함 09.07.21)
                // 수원점 명단세팅하여 기존동일하게 체크. 수원점 외 나머지점  연속수강자 체크 로직 변경 (2013.10.8) ★
                /* 기존소스 백업(2013.10.08)
                if ("03".equals(actionobj.getStore())
                        || "04".equals(actionobj.getStore())) {

                    if ("03".equals(actionobj.getStore())) {
                        query14.append(" SELECT NVL(SUM(COUNT(*)), 0) AS COUNT                                                          \n");
                        query14.append("   FROM                                                                                         \n");
                        query14.append("       (                                                                                        \n");
                        query14.append("         SELECT A.PERIOD, COUNT(*)                                                              \n");
                        query14.append("          FROM BAPERETB A, BAPELTTB B                                                           \n");
                        query14.append("         WHERE A.HQ          = ?                                                                \n");
                        query14.append("          AND A.STORE       = ?                                                                 \n");
                        query14.append("          AND A.PERIOD BETWEEN trim(TO_CHAR((? - ?), '000')) AND trim(TO_CHAR((? - 1), '000'))  \n");
                        query14.append("          AND A.CUST_NO     = ?                                                                 \n");
                        query14.append("          AND A.PAY_YN      = 'Y'                                                               \n");
                        query14.append("          AND A.REGIS_CANCEL_FG = '1'                                                           \n");
                        query14.append("          AND (substr(B.SUBJECT_CD,1,3) <> '414') AND (B.LECT_CNT  > 9 OR ( B.SUBJECT_CD in ('620001','620002')) ) \n");
                        query14.append("          AND A.HQ          = B.HQ                                                              \n");
                        query14.append("          AND A.STORE       = B.STORE                                                           \n");
                        query14.append("          AND A.SUBJECT_CD  = B.SUBJECT_CD                                                      \n");
                        query14.append("          AND A.PERIOD      = B.PERIOD                                                          \n");
                        query14.append("        GROUP BY A.PERIOD                                                                       \n");
                        query14.append("       )                                                                                        \n");
                        query14.append("  GROUP BY PERIOD                                                                               \n");
                    } else {
                        query14.append(" SELECT NVL(SUM(COUNT(*)), 0) AS COUNT                                                          \n");
                        query14.append("   FROM                                                                                         \n");
                        query14.append("       (                                                                                        \n");
                        query14.append("         SELECT A.PERIOD, COUNT(*)                                                              \n");
                        query14.append("          FROM BAPERETB A, BAPELTTB B                                                           \n");
                        query14.append("         WHERE A.HQ          = ?                                                                \n");
                        query14.append("          AND A.STORE       = ?                                                                 \n");
                        query14.append("          AND A.PERIOD BETWEEN trim(TO_CHAR((? - ?), '000')) AND trim(TO_CHAR((? - 1), '000'))  \n");
                        query14.append("          AND A.CUST_NO     = ?                                                                 \n");
                        query14.append("          AND A.PAY_YN      = 'Y'                                                               \n");
                        query14.append("          AND A.REGIS_CANCEL_FG = '1'                                                           \n");
                        query14.append("          AND (B.LECT_CNT   > 9 OR (substr(B.SUBJECT_CD,1,3) = '620' )) \n");
                        query14.append("          AND A.HQ          = B.HQ                                                              \n");
                        query14.append("          AND A.STORE       = B.STORE                                                           \n");
                        query14.append("          AND A.SUBJECT_CD  = B.SUBJECT_CD                                                      \n");
                        query14.append("          AND A.PERIOD      = B.PERIOD                                                          \n");
                        query14.append("        GROUP BY A.PERIOD                                                                       \n");
                        query14.append("       )                                                                                        \n");
                        query14.append("  GROUP BY PERIOD                                                                               \n");
                    }

                    System.out.println("sqlQuery  연속수강 분당, 평택 *****************************************  :" + query14);

                    qm14.setString(1, actionobj.getHq());
                    qm14.setString(2, actionobj.getStore());
                    qm14.setString(3, actionobj.getPeriod());
                    qm14.setInt(4, giftCnt4);
                    qm14.setString(5, actionobj.getPeriod());
                    qm14.setString(6, actionobj.getAttendCustNo());

                    AkResultSet rs14 = qm14.executeQuery(query14);

                    if (rs14.next()) {
                        classCCount = rs14.getInt("count");
                    }
                } else {
                    query15.append(" SELECT COUNT(*) AS COUNT FROM BAGIFTTB_AK                                                       \n");
                    query15.append("  WHERE HQ          = ?                                                                          \n");
                    query15.append("    AND STORE       = ?                                                                          \n");
                    query15.append("    AND PERIOD      = ?                                                                          \n");
                    query15.append("    AND CUST_NO     = ?                                                                          \n");
                    query15.append("    AND STAT IS NULL                                                                             \n");

                    System.out.println("sqlQuery  연속수강 구로, 수원  **********************************   :"+ query15);

                    qm15.setString(1, actionobj.getHq());
                    qm15.setString(2, actionobj.getStore());
                    qm15.setString(3, actionobj.getPeriod());
                    qm15.setString(4, actionobj.getAttendCustNo());

                    AkResultSet rs15 = qm15.executeQuery(query15);

                    if (rs15.next()) {
                        AKCount = rs15.getInt("count");
                    }
                }*/
                

                //연속수강자 체크(20150111)
                HashMap<String, Object> map = new HashMap<>();
                map.put("hq", actionobj.getHq());
        		map.put("store", actionobj.getStore());
        		map.put("period", actionobj.getPeriod());
        		map.put("attendCustNo", actionobj.getAttendCustNo());
        		map.put("gift_cnt", giftCnt4);
                
                    // 구로점 
                    if ("01".equals(actionobj.getStore())) {
                    	classCCount = getSqlSession().selectOne(NS + ".getContinueCount_01", actionobj);
                        //수원점    
                    }else if ("02".equals(actionobj.getStore())) {
                    	classCCount = getSqlSession().selectOne(NS + ".getContinueCount_02", actionobj);
                    // 분당점
                    } else if ("03".equals(actionobj.getStore())) {
                    	classCCount = getSqlSession().selectOne(NS + ".getContinueCount_03", actionobj);
                   // 평택점 
                    } else if ("04".equals(actionobj.getStore())) {
                    	classCCount = getSqlSession().selectOne(NS + ".getContinueCount_04", actionobj);
                    //원주점
                    } else if ("05".equals(actionobj.getStore())) {
                    	classCCount = getSqlSession().selectOne(NS + ".getContinueCount_05", actionobj);
                    }
                    
                    
                if (classCCount >= giftCnt4 || AKCount > 0) {
                    // BAGIFTTB 에서 해당기수에 사은품C 지급내역 정보를 조회해 온다.
                	List<HashMap<String, Object>> getGiftRetList3 = getSqlSession().selectOne(NS + ".getGiftRetList3", actionobj);
                    // 연속 수강자 테스트 2014.11.24


                    if (getGiftRetList3.size() > 0) {
                        // 2. 테이블에 이미 저장되 있으면(반납인원제외) 추가 지급 하지 않음. return "Y"
                        sReturn = sReturn + "Y";
                        System.out.println("이미 사은품 C를 수령한 회원입니다.");
                    } else {
                        // 3. 반납이력조회 후 이력이 있으면 미지급으로 update, 없으면 미지급으로 insert
                    	List<HashMap<String, Object>> getGiftRetList4 = getSqlSession().selectOne(NS + ".getGiftRetList4", actionobj);
                        


                        if (getGiftRetList4.size() > 0) {

                            System.out.println("회원의 반납이력이 있습니다. GIFT_FG를 '2'(미지급)로 변환합니다.");
                            cnt = getSqlSession().update(NS + ".upGiftRet2", actionobj);

                            if (cnt == 0) {
                                System.out.println("-----사은품C 테이블 수정중 ERROR가 발생하였습니다.-----");
                                rslt = "fail";
                                return rslt;
                            }
                            sReturn = sReturn + "C";

                        } else {
                            // 이력이 없으면 INSERT

                        	cnt = getSqlSession().insert(NS + ".insGiftRet2", actionobj);
                            System.out.println("  giftProcess.java   --  getHq  :"+ actionobj.getHq());
                            System.out.println("  giftProcess.java   --  getStore  :"+ actionobj.getStore());
                            System.out.println("  giftProcess.java   --  getPeriod  :"+ actionobj.getPeriod());
                            System.out.println("  giftProcess.java   --  getAttendCustNo  :"+ actionobj.getAttendCustNo());

                            if (cnt == 0) {
                                System.out.println("-----사은품C 테이블 저장중 ERROR가 발생하였습니다.-----");
                                rslt = "fail";
                                return rslt;
                            }
                            sReturn = sReturn + "C";
                        }
                    }
                } else {
                    // 1년 연속 수강자가 아니라면
                    sReturn = sReturn + "Y";
                }

            } else {
                // 강좌 lect_cnt가 10회 이상이 되지 않아 사은품 해당사항이 아닐경우 로직 자체를 타지 않는다.
                System.out.println("사은품 해당 강좌가 아닙니다.");
                sReturn = "YYY";
            }

            System.out.println("gift sReturn  :" + sReturn);

            // 사은품 3종
            String class_a = null;
            String class_b = null;
            String class_c = null;
            String okMessage = "";

            class_a = sReturn.substring(0, 1);
            class_b = sReturn.substring(1, 2);
            class_c = sReturn.substring(2, 3);

            // 08.10.31 사은품 지급 메시지 점별 문구 추가 (인선옥주임)

            if ("A".equals(class_a)) {
                if ("01".equals(actionobj.getStore())) { // 구로점
                    class_a = "[선착순-상품권 5천원]";
                } else if ("02".equals(actionobj.getStore())) { // 수원점
                    class_a = "[선착순-상품권 5천원]";
                } else if ("03".equals(actionobj.getStore())) { // 분당점
                    class_a = "[선착순-상품권 5천원]";
                } else if ("04".equals(actionobj.getStore())) { // 평택점
                    class_a = "[선착순-상품권 5천원]";
                } else if ("05".equals(actionobj.getStore())) { // 원주점
                    class_a = "[선착순-상품권 5천원]";                    
                } else {
                    class_a = "[선착순-오류 문화센터 전화요망]";
                }

            } else {
                class_a = "";
            }

            if ("B".equals(class_b)) {
                if ("01".equals(actionobj.getStore())) { // 구로점
                    class_b = "[AK신한카드 결제자  3강좌이상 -상품권 1만원]";
                } else if ("02".equals(actionobj.getStore())) { // 수원점
                    class_b = "[AK신한카드 결제자  3강좌이상-상품권 1만원]";
                } else if ("03".equals(actionobj.getStore())) { // 분당점
                    class_b = "[AK신한카드 결제자  3강좌이상-상품권 1만원]";
                } else if ("04".equals(actionobj.getStore())) { // 평택점
                    // class_b = "[3강좌이상-상품권 1만원]";
                    class_b = "[AK신한카드 결제자  3강좌이상-상품권 1만원]";
                    // "[3강좌이상-"+gift_massage+"]" ; // AK신한결제 여부에 따라 [3강좌이상-2만원
                    // 상품권] /제외 [3강좌이상-1만원 상품권] 표시됨 (10.10.28)
                } else if ("05".equals(actionobj.getStore())) { // 원주점
                    class_b = "[AK신한카드 결제자  3강좌이상-상품권 1만원]";
                } else {
                    class_b = "[강좌횟수-오류 문화센터 전화요망]";
                }
            } else {
                class_b = "";
            }

            /*
             * 무료수강권 → 수강할인권 문구 수정(10.07.21) 백혜정과장 [기존소스백업 ]
             * if("C".equals(class_c)) { if("01".equals(actionobj.getStore())){ //
             * 구로점 class_c = "[연속수강자-무료수강권 5천원]"; }else
             * if("02".equals(actionobj.getStore())){ // 수원점 class_c =
             * "[연속수강자-무료수강권 1만원]"; }else if("03".equals(actionobj.getStore())){ //
             * 분당점 class_c = "[연속수강자-무료수강권 1만원]"; }else
             * if("04".equals(actionobj.getStore())){ // 평택점 class_c =
             * "[연속수강자-무료수강권 1만원]"; }else{ class_c = "[연속수강자-오류 문화센터 전화요망]"; } }
             */

            if ("C".equals(class_c)) {
                if ("01".equals(actionobj.getStore())) {        // 구로점 (★1만원권-> 5천원권
                    class_c = "[다음학기 수강할인권 1만원]"; // ※ 2014.10 구로점 연속 수강자 삭제
                } else if ("02".equals(actionobj.getStore())) { // 수원점
                    class_c = "[다음학기 수강할인권 1만원]";
                } else if ("03".equals(actionobj.getStore())) { // 분당점
                    class_c = "[다음학기 수강할인권 1만원]"; // "[연속수강자-수강할인권 1만원]"; 2014.10 문구 변경 [다음학기 수강할인권 1만원]
                } else if ("04".equals(actionobj.getStore())) { // 평택점
                    class_c = "[다음학기 수강할인권 1만원]";
                } else if ("05".equals(actionobj.getStore())) { // 원주점
                    class_c = "[다음학기 수강할인권 1만원]";                    
                } else {
                    class_c = "[다음학기 수강할인권-오류 문화센터 전화요망]";
                }
            } else {
                class_c = "";
            }

            if ("YYY".equals(sReturn)) {
                sReturn = "Y";
            } else {
            	MainVo vobj = new MainVo();
            	vobj.setBoardid("cardtext");
            	vobj.setPage(1);
            	vobj.setPageSize(10);
            	vobj.setWrite_start_date("");
            	vobj.setWrite_end_date("");
            	vobj.setCategoryView("ALL");
            	vobj.setEventState("");
            	vobj.setEventDateUse("Y"); //현날짜에 노출이 허락된 것만..
            	
            	String infoText01 = "";
            	String infoTextEtc = "";
            	
                //2013.11.22
            	//okMessage = "사은품 대상자 입니다.\\n문화아카데미 안내데스크에서  11월 17(일)일까지 수령바랍니다!";
            	okMessage = "사은품 대상자 입니다.\\n";
                
               	okMessage = okMessage + infoText01;

                /*
                 * 12.01.11 기존소스 백업 if("02".equals(actionobj.getStore())){
                 * okMessage = "사은품 대상자 입니다.\\n문화아카데미 안내데스크에서 [청은차치약세트]-12월
                 * 27일(화), [상품권외]-01월 27일(금)일까지 수령바랍니다! "; }else{ okMessage =
                 * "사은품 대상자 입니다.\\n문화아카데미 안내데스크에서 12월 20(화)일까지 수령바랍니다!"; }
                 */
                sReturn = "X" + class_a + class_b + class_c + okMessage; // 2014.04.29 by ksm "X" + class_a + class_b + class_c + okMessage;
                														 // 2014.10.20 by ksm "X" + class_a + class_b + okMessage; 요청자 : 최재연 대리
            }

            return sReturn;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }


	public int tempDeleteProcess(LectureVo actionobj) {
		
		return getSqlSession().delete(NS + ".tempDeleteProcess", actionobj);
	}


	public String EmailInsert(LectureVo actionobj) {
		int pay_cnt = 0;
		int ret = getSqlSession().selectOne(NS + ".nextSeqMail");
		int seq = ret + 1;
        String automail_id = String.valueOf(seq);
        String sendEmail ="";
        
        String result = "FAIL";
        String emailUrl = "http://culture.akplaza.com/cult/email/email_platform.jsp?";
        String emailResult = "hq=" + actionobj.getHq() + "&store=" + actionobj.getStore() + "&period=" + actionobj.getPeriod() + "&sale_ymd=" + actionobj.getSale_ymd() + "&sale_time="
                            + actionobj.getSale_time() + "&cust_no=" + actionobj.getAttendCustNo();

        emailUrl = emailUrl + emailResult;
        
        pay_cnt = getSqlSession().selectOne(NS + ".getPayCnt", actionobj);
        
        if (pay_cnt == 0) {
            result = "FAIL";
        } else if (pay_cnt > 0) {
            // 1) 우선순위  부모 메일주소 조회 
        	sendEmail = getSqlSession().selectOne(NS + ".getPEmail_addr", actionobj);
            
            if ((sendEmail == "" )||(sendEmail == null) ) {
                // 2) 우선순위  부모 메일주소 미존재시 자녀본인  조회 
            	sendEmail = getSqlSession().selectOne(NS + ".getCEmail_addr", actionobj);
            }  
                
            //
            if ((sendEmail != "" ) && (sendEmail != null) ) {
                // insert
            	HashMap<String, Object> map = new HashMap<>();
        		map.put("automail_id", automail_id);
        		map.put("sendEmail", sendEmail);
        		map.put("emailUrl", emailUrl);
        		
        		map.put("user_id", actionobj.getUser_id());      
        		map.put("hq", actionobj.getHq());           
        		map.put("store", actionobj.getStore());        
        		map.put("period", actionobj.getPeriod());       
        		map.put("attendCustNo", actionobj.getAttendCustNo()); 
        		map.put("sale_ymd", actionobj.getSale_ymd());     
        		map.put("sale_time", actionobj.getSale_time());   
        		
                
            	getSqlSession().insert(NS + ".insMail", map);

            } else {
                System.out.println("LectureDao.java - EmailInsert  >>>>> Email not found <<<<<<<<<<<<<< ");
            }

            result = "SUCCESS";
        }

        return result;
        
	}


	public String freeUseInsert(LectureVo actionobj) {
		String result = "FAIL";
		int cnt = getSqlSession().selectOne(NS + ".getFreeUseCnt", actionobj);
		if(cnt > 0)
		{
			result = "FAIL";
		}
		else
		{
			int intFreeUse = 0;

            if (actionobj.isFlag4() && actionobj.isFlag5()) {
            	//전점 1만원 사용(20160111)
                intFreeUse = 10000;
            }
            HashMap<String, Object> map = new HashMap<>();
    		map.put("hq", actionobj.getHq());             
    		map.put("store", actionobj.getStore());          
    		map.put("akmem_recpt_no", actionobj.getAkmem_recpt_no()); 
    		map.put("period", actionobj.getPeriod());         
    		map.put("attendCustNo", actionobj.getAttendCustNo());   
    		map.put("intFreeUse", intFreeUse);   
    		map.put("subject_cd", actionobj.getSubject_cd());   
    		
    		getSqlSession().insert(NS + ".freeUseInsert", actionobj);
    		result = "SUCCESS";
		}
		
		return result;
	}
	
	
	public void insWBREC(HashMap<String, Object> map) {
		getSqlSession().insert(NS + ".insWBREC", map);
	}

	public void insWBPLA(HashMap<String, Object> map) {
		getSqlSession().insert(NS + ".insWBPLA", map);
	}
	
	/*
	public void insWBHIS(HashMap<String, Object> map) {
		getSqlSession().insert(NS + ".insWBHIS", map);
	}

	public void insWBCUR(HashMap<String, Object> map) {
		getSqlSession().insert(NS + ".insWBCUR", map);
	}
	
	public void insApply(String reg_no) {
		getSqlSession().insert(NS + ".insApply", reg_no);
	}
	*/
	
	public HashMap<String, Object> ApplyListInfo(String reg_no,String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("reg_no", reg_no);
		map.put("cust_no", cust_no);
		HashMap<String, Object> list = getSqlSession().selectOne(NS + ".ApplyListInfo", map);
		return list;
	}
	
	public HashMap<String, Object> ApplyListInfo2(String reg_no,String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("reg_no", reg_no);
		map.put("cust_no", cust_no);
		HashMap<String, Object> list = getSqlSession().selectOne(NS + ".ApplyListInfo2", map);
		return list;
	}
	
	/*
	public BLOB recruitPhoto(String reg_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("reg_no", reg_no);

        BLOB data = getSqlSession().selectOne(NS + ".recruitPhoto", map);
		return data;

	}
	
	public List<HashMap<String, Object>> recruitFileInfo(String reg_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("reg_no", reg_no);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".recruitFileInfo", map);
		return list;
	}
	 */

	public String akMemberPercent(String subcode) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("subcode", subcode);
		return getSqlSession().selectOne(NS + ".akMemberPercent", map);
	}


	public String setLectCalcPredict(LectureVo actionobj) throws Exception {
		try {

            String result = "";
            String rlt = "E"; // 결제실패시 return값

            // 1.장바구니 체크
            int tempCheckCnt = retrieveTempCheck(actionobj);

            if (tempCheckCnt == 0) {
                result = "등록할 정보가 없습니다.";
                return rlt+result;
            }

            // 2.결제 중복 체크
            String settleCheckRslt = retrieveSettleCheck(actionobj);

            if (settleCheckRslt.equals("fail")) { // 결제된 강좌 존재
                result = "이미 결제된 강좌가 있습니다.";
                return rlt+result;
            }
            
            // 진행기수 -1 (이전기수) 연속수강 사은품 대상자 무료수강권 여부체크(2011.01.03) 존재하면 true
            int free_fee = 0;

            if (actionobj.isFlag4()) {
            	//전점 1만원 
                free_fee = 10000;  // 구로점 외 무료수강권 10,000원권

                actionobj.setFree_fee(free_fee);
//                System.out.println("LectureDao.java - setLectCalc 연속수강권  : free_fee >>>>>>>>>>>>>>>>>>>:"+ free_fee);
            }
            rlt = "S";
            return rlt;

        } catch (Exception e) {
            throw new Exception(e);
        }
	}


	public String setLectCanCelCalc(LectureVo actionobj) throws Exception {
        try {

            String result = "";
            String rlt = "N"; // 결제실패시 return값

            // 1.결제내역 체크
            int RealCheckCnt = getSqlSession().selectOne(NS + ".retrieveRealCheck", actionobj);
            System.out.println("RealCheckCnt 0이면 out--------------------> " + RealCheckCnt);
            if (RealCheckCnt == 0) {
                result = "정상적으로 결제한 내역이 없습니다.";
                rlt = "N1";
                return rlt;
            }

            // 2.수강취소 중복방지 체크
            String CancelCheck = getSqlSession().selectOne(NS + ".retrieveCancelCheck", actionobj);
            System.out.println("CancelCheck 0이면 out--------------------> " + CancelCheck);
            if ("Y".equals(CancelCheck)) {
                result = "이미 취소된 수강내역입니다.";
                rlt = "N2";
                return rlt;
            }

            // 3.결제취소마감일 체크
            int CloseCheckCnt = getSqlSession().selectOne(NS + ".retrieveCloseCheck", actionobj);
            System.out.println("CloseCheckCnt 0이면 out--------------------> "+ CloseCheckCnt);
            if (CloseCheckCnt > 0) {
                result = "고객님께서는 결제하신 강좌중 개강일 또는 취소 기준일이 지난B강좌(일일특강,요리,여행강좌)가 포함되어 있습니다.B해당점에 방문하여 취소 부탁드립니다.B고맙습니다.";
                rlt = "N3";
                return rlt;
            }

            // 4.이미 시작된 강좌여부 체크
            int StartCheckCnt = getSqlSession().selectOne(NS + ".retrieveStartCheck", actionobj);
            System.out.println("StartCheckCnt 0이면 out--------------------> "+ StartCheckCnt);
            if (StartCheckCnt > 0) {
                result = "고객님께서는 결제하신 강좌중 개강일 또는 취소 기준일이 지난B강좌(일일특강,요리,여행강좌)가 포함되어 있습니다.해당점에 방문하여 취소 부탁드립니다.B고맙습니다.";
                rlt = "N4";
                return rlt;
            }
            
            //4-1.기수의 웹 결제 취소일과 비교 (BAPERITB 의 해당 기수의 END_YMD와 비교 
            int PeriodCheck = getSqlSession().selectOne(NS + ".retrievePeriodCheck", actionobj);
            System.out.println("PeriodCheck 0이면 out--------------------> "+ PeriodCheck);
            if (PeriodCheck > 0) {
                result = "해당 기수의 취소 기한이 마감되었습니다. 고맙습니다.";
                rlt = "N8";
                return rlt;
            }
            
            //4-2. 가용 포인트가 1000점 이상인지 체크 
            //카드 결제 취소 시 최소 가용 마일리지 금액 체크 20190528 김동현
           
            CmAKmembers cmAKmembers = new CmAKmembers();
            
            HashMap AKmemRead ;
            String AKmemCardStatus = null;
            String AKmemTotalPoint = "";
            if(!"".equals(actionobj.getAKmemCardNo())){
            	AKmemRead = cmAKmembers.getAKmemRead( actionobj.getStore(), actionobj.getAKmemCardNo());
            	//정상적인 카드번호인지 확인
                AKmemCardStatus = cmAKmembers.getAKmemStatus(AKmemRead);
                if ( "00".equals(AKmemCardStatus) ){
                	AKmemTotalPoint = (String) AKmemRead.get("AKmem_total_point");
                	
                	//가용 + 사용 - 적립 이 -999점 이 되면 통과 
                	List<HashMap<String, Object>> rs = getSqlSession().selectList(NS + ".getPointAKmem", actionobj);

	                int AKMEM_RECPT_POINT = 0;
	                int AKMEM_USE_POINT = 0;
	                int tempSum = 0;
	                if (rs.size() > 0) {
	                	AKMEM_RECPT_POINT += Utils.checkNullInt(rs.get(0).get("AKMEM_RECPT_POINT"));
	                	AKMEM_USE_POINT += Utils.checkNullInt(rs.get(0).get("AKMEM_USE_POINT"));
	                } else {
	                	result = "마일리지 조회 시 오류가 발생했습니다. 해당 지점에 문의 바랍니다.";
	                    rlt = "N10";
	                    return rlt;
	                }
	                
	                tempSum = Integer.parseInt(AKmemTotalPoint) + AKMEM_USE_POINT - AKMEM_RECPT_POINT;
	                if(tempSum < -999){
	                	result = "마일리지 부족으로 수강취소 불가하니, 해당 지점에 문의 바랍니다.";
	                    rlt = "N11";
	                    return rlt;
	                }
	                
	            	
                } else {
                	result = "회원 인증 오류가 발생했습니다. 해당 지점에  문의 바랍니다.";
                    rlt = "N9";
                    return rlt;
                }
            }

            // 5.무료강좌 존재여부 체크(수강료 0원)
            int FreePayCheckCnt = getSqlSession().selectOne(NS + ".retrieveFreePayCheck", actionobj);
            System.out.println("FreePayCheckCnt 0이면 out--------------------> " + FreePayCheckCnt);
            if (FreePayCheckCnt > 0) {
                result = "무료강좌는 온라인 취소가 불가 합니다.";
                rlt = "N5";
                return rlt;
            }

            // 6.사은품 반납여부 체크(지급 경우 취소불가-내방필요! 미지급상태만 가능- 취소로 변경)
            int GiftCheckCnt = getSqlSession().selectOne(NS + ".retrieveGiftCheck", actionobj);
            System.out.println("GiftCheckCnt 0이면 out--------------------> " + GiftCheckCnt);
            if (GiftCheckCnt > 0) {
                result = "고객님께서는 사은품을 지급 받은 내역이 있습니다. 해당점을 방문하셔야 취소가 가능합니다.";
                rlt = "N6";
                return rlt;
            }

            // 7.승인취소 처리 및 매출임시테이블 저장
            String settleCancleProcessRslt = settleCancleProcess(actionobj);
            System.out.println("settleCancleProcessRslt fall이면 out--------------------> "+ settleCancleProcessRslt);
            if (!settleCancleProcessRslt.equals("success")) { // 승인취소처리 및  매출임시테이블 저장 실패
                result = settleCancleProcessRslt;
                return rlt;
            } else if (settleCancleProcessRslt.equals("success")) { // 정상승인취소 완료면 결제인원 차감 처리

                // 7-1. 결제취소 해당강좌 책가방 바로 담기.
                if (actionobj.getBackpack() != null && actionobj.getBackpack().equals("Y"))
                    webregisnoBackpackProcess(actionobj);
                // 7-2 결제취소 해당강좌 책가방 담지 X -> 강좌인원 줄이기.
                else
                    webregisnoMinusProcess(actionobj);

            }

            // 8.수강할인권 사용여부체크
            int FreeCheckCnt = getSqlSession().selectOne(NS + ".retrieveFreeCheck", actionobj);
            System.out.println("FreeCheckCnt 0이면 out--------------------> " + FreeCheckCnt);

/*            // 9.정규강좌 존재여부체크
            int LectCntCheck = selectLectCntUseCancel(actionobj);
            System.out.println("LectCntCheck 0이면 out--------------------> " + LectCntCheck);*/

            // 안씀 -10. 무료수강권 사용내역이 있으나 정규강좌 수강내역 존재가 없다면
            
            // 무료수강권 사용 취소
            if (FreeCheckCnt > 0 ) {
                // 10-1.수강할인권 미사용으로 변경 (BAFREETB)
            	int upcnt = getSqlSession().selectOne(NS + ".freeCancelProcess", actionobj);
            	String freeCancelProcessRslt = "FAIL";
            	if(upcnt > 0)
            	{
            		freeCancelProcessRslt = "SUCCESS";
            	}
                System.out.println("freeCancelProcessRslt fall이면 out--------------------> "+ freeCancelProcessRslt);
                if (freeCancelProcessRslt.equals("fail")) { // 무료수강권 사용내역 미사용 처리실패
                    result = "연속수강자 정규강좌 수강해당자 무료수강권 미사용 원복중 에러가 발생했습니다.";
                    rlt = "N7";
                    return rlt;
                }
            }

            // 11.사은품 체크 및 반납처리 (2:미지급-> 9:취소 처리)
            String giftCancelProcessRslt = giftCancelProcess(actionobj);
            System.out.println("giftCancelProcessRslt fall이면 out--------------------> "+ giftCancelProcessRslt);
            if (giftCancelProcessRslt.equals("fail")) { // 사은품 처리 실패
                result = giftCancelProcessRslt;
                return rlt;
            }

            // 12. 취소 내역 메일발송 저장
            String EmailCancelInsert = EmailCancelInsert(actionobj);
            System.out.println("EmailCancelInsert <<<<<<<<<< 취소>>>>>>>>>>>>>>> 결과 fall이면 out--------------------> "  + EmailCancelInsert);
            if (EmailCancelInsert != "SUCCESS") { // 연속수강자 수강 할인권 사용 저장 에러
                result = "취소 메일발송 내역  저장시 에러가 발생하였습니다.";
                return rlt;
            }

//            System.out.println("sResult ------------------------> "+ giftCancelProcessRslt);
            return giftCancelProcessRslt;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	public String setLectCanCelCalc_half(LectureVo actionobj) throws Exception {
        try {
        	System.out.println("22222222");
            String result = "";
            String rlt = "N"; // 결제실패시 return값

            // 1.결제내역 체크
            int RealCheckCnt = getSqlSession().selectOne(NS + ".retrieveRealCheck", actionobj);
            System.out.println("RealCheckCnt 0이면 out--------------------> " + RealCheckCnt);
            if (RealCheckCnt == 0) {
                result = "정상적으로 결제한 내역이 없습니다.";
                rlt = "N1";
                return rlt;
            }

            // 2.수강취소 중복방지 체크
            String CancelCheck = getSqlSession().selectOne(NS + ".retrieveCancelCheck", actionobj);
            System.out.println("CancelCheck 0이면 out--------------------> " + CancelCheck);
            if ("Y".equals(CancelCheck)) {
                result = "이미 취소된 수강내역입니다.";
                rlt = "N2";
                return rlt;
            }

            // 3.결제취소마감일 체크
//            int CloseCheckCnt = getSqlSession().selectOne(NS + ".retrieveCloseCheck", actionobj);
//            System.out.println("CloseCheckCnt 0이면 out--------------------> "+ CloseCheckCnt);
//            if (CloseCheckCnt > 0) {
//                result = "고객님께서는 결제하신 강좌중 개강일 또는 취소 기준일이 지난B강좌(일일특강,요리,여행강좌)가 포함되어 있습니다.B해당점에 방문하여 취소 부탁드립니다.B고맙습니다.";
//                rlt = "N3";
//                return rlt;
//            }

            // 4.이미 시작된 강좌여부 체크
//            int StartCheckCnt = getSqlSession().selectOne(NS + ".retrieveStartCheck", actionobj);
//            System.out.println("StartCheckCnt 0이면 out--------------------> "+ StartCheckCnt);
//            if (StartCheckCnt > 0) {
//                result = "고객님께서는 결제하신 강좌중 개강일 또는 취소 기준일이 지난B강좌(일일특강,요리,여행강좌)가 포함되어 있습니다.해당점에 방문하여 취소 부탁드립니다.B고맙습니다.";
//                rlt = "N4";
//                return rlt;
//            }
            
            //4-1.기수의 웹 결제 취소일과 비교 (BAPERITB 의 해당 기수의 END_YMD와 비교 
//            int PeriodCheck = getSqlSession().selectOne(NS + ".retrievePeriodCheck", actionobj);
//            System.out.println("PeriodCheck 0이면 out--------------------> "+ PeriodCheck);
//            if (PeriodCheck > 0) {
//                result = "해당 기수의 취소 기한이 마감되었습니다. 고맙습니다.";
//                rlt = "N8";
//                return rlt;
//            }
            
            //4-2. 가용 포인트가 1000점 이상인지 체크 
            //카드 결제 취소 시 최소 가용 마일리지 금액 체크 20190528 김동현
           
            CmAKmembers cmAKmembers = new CmAKmembers();
            
            HashMap AKmemRead ;
            String AKmemCardStatus = null;
            String AKmemTotalPoint = "";
            if(!"".equals(actionobj.getAKmemCardNo())){
            	AKmemRead = cmAKmembers.getAKmemRead( actionobj.getStore(), actionobj.getAKmemCardNo());
            	//정상적인 카드번호인지 확인
                AKmemCardStatus = cmAKmembers.getAKmemStatus(AKmemRead);
                if ( "00".equals(AKmemCardStatus) ){
                	AKmemTotalPoint = (String) AKmemRead.get("AKmem_total_point");
                	
                	//가용 + 사용 - 적립 이 -999점 이 되면 통과 
                	List<HashMap<String, Object>> rs = getSqlSession().selectList(NS + ".getPointAKmem", actionobj);

	                int AKMEM_RECPT_POINT = 0;
	                int AKMEM_USE_POINT = 0;
	                int tempSum = 0;
	                if (rs.size() > 0) {
	                	AKMEM_RECPT_POINT += Utils.checkNullInt(rs.get(0).get("AKMEM_RECPT_POINT"));
	                	AKMEM_USE_POINT += Utils.checkNullInt(rs.get(0).get("AKMEM_USE_POINT"));
	                } else {
	                	result = "마일리지 조회 시 오류가 발생했습니다. 해당 지점에 문의 바랍니다.";
	                    rlt = "N10";
	                    return rlt;
	                }
	                
	                tempSum = Integer.parseInt(AKmemTotalPoint) + AKMEM_USE_POINT - AKMEM_RECPT_POINT;
	                if(tempSum < -999){
	                	result = "마일리지 부족으로 수강취소 불가하니, 해당 지점에 문의 바랍니다.";
	                    rlt = "N11";
	                    return rlt;
	                }
	                
	            	
                } else {
                	result = "회원 인증 오류가 발생했습니다. 해당 지점에  문의 바랍니다.";
                    rlt = "N9";
                    return rlt;
                }
            }

            // 5.무료강좌 존재여부 체크(수강료 0원)
            int FreePayCheckCnt = getSqlSession().selectOne(NS + ".retrieveFreePayCheck", actionobj);
            System.out.println("FreePayCheckCnt 0이면 out--------------------> " + FreePayCheckCnt);
            if (FreePayCheckCnt > 0) {
                result = "무료강좌는 온라인 취소가 불가 합니다.";
                rlt = "N5";
                return rlt;
            }

            // 6.사은품 반납여부 체크(지급 경우 취소불가-내방필요! 미지급상태만 가능- 취소로 변경)
            int GiftCheckCnt = getSqlSession().selectOne(NS + ".retrieveGiftCheck", actionobj);
            System.out.println("GiftCheckCnt 0이면 out--------------------> " + GiftCheckCnt);
            if (GiftCheckCnt > 0) {
                result = "고객님께서는 사은품을 지급 받은 내역이 있습니다. 해당점을 방문하셔야 취소가 가능합니다.";
                rlt = "N6";
                return rlt;
            }

            // 7.승인취소 처리 및 매출임시테이블 저장
            String settleCancleProcessRslt = settleCancleProcess(actionobj);
            System.out.println("settleCancleProcessRslt fall이면 out--------------------> "+ settleCancleProcessRslt);
            if (!settleCancleProcessRslt.equals("success")) { // 승인취소처리 및  매출임시테이블 저장 실패
                result = settleCancleProcessRslt;
                return rlt;
            } else if (settleCancleProcessRslt.equals("success")) { // 정상승인취소 완료면 결제인원 차감 처리

                // 7-1. 결제취소 해당강좌 책가방 바로 담기.
                if (actionobj.getBackpack() != null && actionobj.getBackpack().equals("Y"))
                    webregisnoBackpackProcess(actionobj);
                // 7-2 결제취소 해당강좌 책가방 담지 X -> 강좌인원 줄이기.
                else
                    webregisnoMinusProcess(actionobj);

            }

            // 8.수강할인권 사용여부체크
            int FreeCheckCnt = getSqlSession().selectOne(NS + ".retrieveFreeCheck", actionobj);
            System.out.println("FreeCheckCnt 0이면 out--------------------> " + FreeCheckCnt);

/*            // 9.정규강좌 존재여부체크
            int LectCntCheck = selectLectCntUseCancel(actionobj);
            System.out.println("LectCntCheck 0이면 out--------------------> " + LectCntCheck);*/

            // 안씀 -10. 무료수강권 사용내역이 있으나 정규강좌 수강내역 존재가 없다면
            
            // 무료수강권 사용 취소
            if (FreeCheckCnt > 0 ) {
                // 10-1.수강할인권 미사용으로 변경 (BAFREETB)
            	int upcnt = getSqlSession().selectOne(NS + ".freeCancelProcess", actionobj);
            	String freeCancelProcessRslt = "FAIL";
            	if(upcnt > 0)
            	{
            		freeCancelProcessRslt = "SUCCESS";
            	}
                System.out.println("freeCancelProcessRslt fall이면 out--------------------> "+ freeCancelProcessRslt);
                if (freeCancelProcessRslt.equals("fail")) { // 무료수강권 사용내역 미사용 처리실패
                    result = "연속수강자 정규강좌 수강해당자 무료수강권 미사용 원복중 에러가 발생했습니다.";
                    rlt = "N7";
                    return rlt;
                }
            }

            // 11.사은품 체크 및 반납처리 (2:미지급-> 9:취소 처리)
            String giftCancelProcessRslt = giftCancelProcess(actionobj);
            System.out.println("giftCancelProcessRslt fall이면 out--------------------> "+ giftCancelProcessRslt);
            if (giftCancelProcessRslt.equals("fail")) { // 사은품 처리 실패
                result = giftCancelProcessRslt;
                return rlt;
            }

            // 12. 취소 내역 메일발송 저장
            String EmailCancelInsert = EmailCancelInsert(actionobj);
            System.out.println("EmailCancelInsert <<<<<<<<<< 취소>>>>>>>>>>>>>>> 결과 fall이면 out--------------------> "  + EmailCancelInsert);
            if (EmailCancelInsert != "SUCCESS") { // 연속수강자 수강 할인권 사용 저장 에러
                result = "취소 메일발송 내역  저장시 에러가 발생하였습니다.";
                return rlt;
            }

//            System.out.println("sResult ------------------------> "+ giftCancelProcessRslt);
            return giftCancelProcessRslt;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	
	public String EmailCancelInsert(LectureVo actionobj) throws Exception {
        try {
            
            int pay_cnt = 0;            
            int ret = getSqlSession().selectOne(NS + ".nextSeqMail");
    		int seq = ret + 1;
            String automail_id = String.valueOf(seq);
            String sendEmail ="";
            String sDate = Utils.getCurrentDate();

            String result = "FAIL";
            
            String emailUrl = "http://culture.akplaza.com/cult/email/email_platform.jsp?";
            String emailResult = "hq=" + actionobj.getHq() + "&store=" + actionobj.getStore() + "&period=" + actionobj.getPeriod() + "&sale_ymd=" + sDate + "&sale_time="
                                + actionobj.getSale_time() + "&cust_no=" + actionobj.getCustNo(); 

            emailUrl = emailUrl + emailResult;
            
            System.out.println("EmailCancelInsert >>>>>>>>>>>>>>>> emailUrl >>>>>>>>"+emailUrl);
          
            pay_cnt = getSqlSession().selectOne(NS + ".selectCancelMailCnt", actionobj);
            // 취소

            if (pay_cnt == 0) {
                result = "FAIL";
            } else if (pay_cnt > 0) {
                
                // 1) 우선순위  부모 메일주소 조회 
            	actionobj.setAttendCustNo(actionobj.getCustNo());
            	sendEmail = getSqlSession().selectOne(NS + ".getPEmail_addr", actionobj);
                
                if ((sendEmail == "" )||(sendEmail == null) ) {
                    // 2) 우선순위  부모 메일주소 미존재시 자녀본인  조회 
                	sendEmail = getSqlSession().selectOne(NS + ".getCEmail_addr", actionobj);
                   
                }  
                    
                //
                if ((sendEmail != "" ) && (sendEmail != null) ) {    
            
                // insert
                	HashMap<String, Object> map = new HashMap<>();
            		map.put("automail_id", automail_id);
            		map.put("sendEmail", sendEmail);
            		map.put("emailUrl", emailUrl);
            		
            		map.put("user_id", actionobj.getUser_id());      
            		map.put("hq", actionobj.getHq());           
            		map.put("store", actionobj.getStore());        
            		map.put("period", actionobj.getPeriod());       
            		map.put("attendCustNo", actionobj.getAttendCustNo()); 
            		map.put("sale_ymd", Utils.getCurrentDate());     
            		map.put("sale_time", actionobj.getSale_time());   
            		
                    
                	getSqlSession().insert(NS + ".insMail", map);
                	
                } else {
                    System.out.println("LectureDao.java - EmailCancelInsert  >>>>> Email not found <<<<<<<<<<<<<< ");
                }

                result = "SUCCESS";
            }

            return result;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	public String giftCancelProcess(LectureVo actionobj) throws Exception {
        try {

            int lect_cnt_count = 0;
            int acnt = 0;
            int bcnt = 0;
            int ccnt = 0;
            int dcnt = 0;

            String rslt = "";
            String sReturn = "";

            // ***********************************************************
            // 인터넷결제 미전송 내역 확인 lect_cnt_wcount
            // ***********************************************************

            // 구로점 10회이상이거나 620 시작강좌
            if ("01".equals(actionobj.getStore())) {
            	
            	lect_cnt_count = getSqlSession().selectOne(NS + ".getCancelLectCntCount_01", actionobj);
                // ★ 12.01.11 수원점 8회이상으로 변경(윤정희)
            } else if ("02".equals(actionobj.getStore())) {

            	lect_cnt_count = getSqlSession().selectOne(NS + ".getCancelLectCntCount_02", actionobj);

                // 분당점 영재음악원 사은품체크 제외 분당 620001, 620002 강좌 포함
            } else if ("03".equals(actionobj.getStore())) {

            	lect_cnt_count = getSqlSession().selectOne(NS + ".getCancelLectCntCount_03", actionobj);

                // 평택점 10회이상이거나 620 시작강좌
            } else if ("04".equals(actionobj.getStore())) {

            	lect_cnt_count = getSqlSession().selectOne(NS + ".getCancelLectCntCount_04", actionobj);

            } else if ("05".equals(actionobj.getStore())) {

            	lect_cnt_count = getSqlSession().selectOne(NS + ".getCancelLectCntCount_05", actionobj);

            }


/*            System.out.println("  giftCancelProcess.java   --  query  :"+ query);
            System.out.println("  giftCancelProcess.java   --  getHq  :"+ actionobj.getHq());
            System.out.println("  giftCancelProcess.java   --  getStore  :"+ actionobj.getStore());
            System.out.println("  giftCancelProcess.java   --  getPeriod  :"+ actionobj.getPeriod());
            System.out.println("  giftCancelProcess.java   --  getCustNo  :"+ actionobj.getCustNo());*/


            // 모두 취소 되었다면....
            if (lect_cnt_count <= 0) { 

                /*------------------------------------------------------------------------------------
                 *    ** 사은품 Class A 
                 *-----------------------------------------------------------------------------------*/

                // BAGIFTTB 에서 해당기수에 사은품A 지급내역 정보를 조회해 온다.
            	List<HashMap<String, Object>> rs2 = getSqlSession().selectList(NS + ".getGiftCountA", actionobj);

                if (rs2.size() > 0) {
                    // 사은품 테이블에 고객정보가 있으면(반납인원제외)

                    System.out.println("회원은 선착순 사은품 A - 2(미지급)상태이므로   GIFT_FG를 '9'(취소)로 변환합니다.");
                    acnt = getSqlSession().update(NS + ".upCancelGiftA", actionobj);


                    if (acnt == 0) {
                        System.out.println("-----결제취소 사은품A 테이블 수정중 ERROR가 발생하였습니다.-----");
                        rslt = "fail";
                        return rslt;
                    }
                }
                
                /*------------------------------------------------------------------------------------
                 *    ** 사은품 Class B
                 *-----------------------------------------------------------------------------------*/

                // BAGIFTTB 에서 해당기수에 사은품B 지급내역 정보를 조회해 온다.
                List<HashMap<String, Object>> rs6 = getSqlSession().selectList(NS + ".getGiftCountB", actionobj);

                if (rs6.size() > 0) {
                    // 사은품 테이블에 고객정보가 있으면(반납인원제외)

                    System.out.println("회원은 강좌 횟수 X 이상 B - 2(미지급)상태이므로   GIFT_FG를 '9'(취소)로 변환합니다.");


                    bcnt = getSqlSession().update(NS + ".upCancelGiftB", actionobj);
 
                    if (bcnt == 0) {
                        System.out.println("-----결제취소 사은품B 테이블 수정중 ERROR가 발생하였습니다.-----");
                        rslt = "fail";
                        return rslt;
                    }
                }
                
                /*------------------------------------------------------------------------------------
                 *    ** 사은품 Class C 
                 *-----------------------------------------------------------------------------------*/

                // BAGIFTTB 에서 해당기수에 사은품C 지급내역 정보를 조회해 온다.

                List<HashMap<String, Object>> rs4 = getSqlSession().selectList(NS + ".getGiftCountC", actionobj);

                if (rs4.size() > 0) {
                    // 사은품 테이블에 고객정보가 있으면(반납인원제외)

                    System.out.println("결제취소 회원은  연속수강자 사은품 C - 2(미지급)상태이므로   GIFT_FG를 '9'(취소)로 변환합니다.");

                    ccnt = getSqlSession().update(NS + ".upCancelGiftC", actionobj);

                    if (ccnt == 0) {
                        System.out
                                .println("-----결제취소 사은품C 테이블 수정중 ERROR가 발생하였습니다.-----");
                        rslt = "fail";
                        return rslt;
                    }

                }
                
                /*------------------------------------------------------------------------------------
                 *    ** 사은품 Class D 
                 *-----------------------------------------------------------------------------------*/

                // BAGIFTTB 에서 해당기수에 사은품D 지급내역 정보를 조회해 온다.
                List<HashMap<String, Object>> rs8 = getSqlSession().selectList(NS + ".getGiftCountD", actionobj);


                if (rs8.size() > 0) {
                    // 사은품 테이블에 고객정보가 있으면(반납인원제외)

                    System.out.println("결제취소 회원은  사은대상자  사은품 D - 2(미지급)상태이므로   GIFT_FG를 '9'(취소)로 변환합니다.");

                    dcnt = getSqlSession().update(NS + ".upCancelGiftD", actionobj);
                    if (dcnt == 0) {
                        System.out.println("-----결제취소 사은품D 테이블 수정중 ERROR가 발생하였습니다.-----");
                        rslt = "fail";
                        return rslt;
                    }

                }
                
                /*-----------------------------------------------------------------------------------*/

            }

            sReturn = "Y";

            System.out.println("gift cancel >>>>> sReturn ------ :" + sReturn);

            return sReturn;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	public void webregisnoMinusProcess(LectureVo actionobj) throws Exception {
        try {

            // 취소 내역조회
            List<HashMap<String, Object>> rs = getSqlSession().selectList(NS + ".selWebregisnoMinusProcess", actionobj);
            if(rs.size() > 0)
            {
            	getSqlSession().update(NS + ".upWebregisnoMinusProcess", actionobj);
            }
            
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	public void webregisnoBackpackProcess(LectureVo actionobj) throws Exception {
        try {

            // 취소 내역중 책가방  담기 되있는 강좌 확인.

            int cnt = getSqlSession().selectOne(NS + ".getCancelBookCount", actionobj);

            if (cnt == 0) {
            	// 등록 된 강좌는 인원을 1명 줄여준다.
            	getSqlSession().update(NS + ".upCancelPeltRegis", actionobj);
                
                // 취소 내역 책가방 담기.
            	getSqlSession().insert(NS + ".insCancelTempLog", actionobj);
            } else {
                // 등록 된 강좌는 인원을 1명 줄여준다.
            	getSqlSession().update(NS + ".upCancelPeltRegis", actionobj);

                // 취소 내역 책가방 담기.(장바구니 담아져 있지 않은 내역만 담아줌)
            	getSqlSession().insert(NS + ".insCancelTempLog2", actionobj);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	public String settleCancleProcess(LectureVo actionobj)
            throws Exception {
        try {

            InetAddress inet = InetAddress.getLocalHost();
            String inet_ip = inet.getHostAddress();

            String rslt = "";
            String sChck_value = "";
            String approve = "";
            String sApprovNo = "";
            String scBank_cd = "";
            String scRate = "";
            String sMessage = ""; // 신청오류 메세지
            String sCurrentTime = Utils.getCurrentTime();
            String sDate = Utils.getCurrentDate();

            String akmem_cardno = "";
            String akmem_scardno = "";
            String akmem_custno = "";
            String akmem_family_custno = "";
            int akmem_recpt_point = 0;
            String akmem_approve_no = "";
            String akmem_approve_no_save = "";
            String akmem_approve_no_use = "";
            int akmem_total_show_amt = 0;
            int akmem_total_enuri_amt = 0;
            int akmem_total_regis_fee = 0;
            String akmem_sysdate = "";
            String akmem_ori_recpt_no = "";
            String akmem_recpt_no = "";
            String req_tx = "mod";
            int akmem_use_point = 0;
            J_PP_CLI_N c_PayPlus = new J_PP_CLI_N();
        	
        	String g_conf_home_dir = "";
        	String g_conf_gw_url = "";
        	String g_conf_gw_port = "";
        	int g_conf_tx_mode = 0;
        	String tran_cd = actionobj.getTran_cd();
        	String g_conf_site_cd = actionobj.getSite_cd();
        	String g_conf_site_key = "";
        	String g_conf_log_level = "";
        	
        	String res_cd = "";
        	String res_msg = "";
        	
        	int pay_cnt = 0;
        	
        	
        	/* 실이었다면 테스트 반영시 삭제 ※※
        	g_conf_site_cd = XmlPropertyManager.getSystemProperty("g_conf_site_cd_" + actionobj.getStore() + "_AK");
    		System.out.println("취소시 사이트 코드 (822) : " + g_conf_site_cd);
    		
    		g_conf_site_cd = XmlPropertyManager.getSystemProperty("g_conf_site_cd_" + actionobj.getStore());
    		System.out.println("취소시 사이트 코드 (822 X) : " + g_conf_site_cd);
    		
    		*/
    		
            if (inet_ip.equals(XmlPropertyManager.getSystemProperty("dev_was"))) { // 개발서버인 경우..
            	g_conf_home_dir = XmlPropertyManager.getSystemProperty("g_conf_home_dir_test");
            	g_conf_gw_url = XmlPropertyManager.getSystemProperty("g_conf_gw_url_test");
            	g_conf_gw_port = XmlPropertyManager.getSystemProperty("g_conf_gw_port_test");
            	g_conf_tx_mode = Integer.parseInt(XmlPropertyManager.getSystemProperty("g_conf_tx_mode_test"));
            	g_conf_site_cd = XmlPropertyManager.getSystemProperty("g_conf_site_cd_test");
            	g_conf_site_key = XmlPropertyManager.getSystemProperty("g_conf_site_key_test");
            	g_conf_log_level = XmlPropertyManager.getSystemProperty("g_conf_log_level_test");
            	
            } else if (inet_ip.equals(XmlPropertyManager.getSystemProperty("front_was1"))|| inet_ip.equals(XmlPropertyManager.getSystemProperty("front_was2"))) {
            	
            	g_conf_home_dir = XmlPropertyManager.getSystemProperty("g_conf_home_dir");
            	g_conf_gw_url = XmlPropertyManager.getSystemProperty("g_conf_gw_url");
            	g_conf_gw_port = XmlPropertyManager.getSystemProperty("g_conf_gw_port");
            	
            	// 세션의 점 코드가 아닌 사용자 선택한 값의 점 코드 2014.07 PG 도입으로 인한 변경 
            	if(actionobj.getAkcard_yn().equals("Y")){
            	
            		g_conf_site_cd = XmlPropertyManager.getSystemProperty("g_conf_site_cd_" + actionobj.getStore() + "_AK");
            		g_conf_site_key = XmlPropertyManager.getSystemProperty("g_conf_site_key_" + actionobj.getStore() + "_AK");
            		System.out.println("취소시 사이트 코드 (822) : " + g_conf_site_cd);
            		System.out.println("취소시 사이트 키 (822) : " + g_conf_site_key);
            	}else if(actionobj.getAkKBcard_yn().equals("Y")){
            	
            		g_conf_site_cd = XmlPropertyManager.getSystemProperty("g_conf_site_cd_" + actionobj.getStore() + "_AKKB");
            		g_conf_site_key = XmlPropertyManager.getSystemProperty("g_conf_site_key_" + actionobj.getStore() + "_AKKB");
            		System.out.println("취소시 사이트 코드 (042) : " + g_conf_site_cd);
            		System.out.println("취소시 사이트 키 (042) : " + g_conf_site_key);
            	}else{
            	
            		g_conf_site_cd = XmlPropertyManager.getSystemProperty("g_conf_site_cd_" + actionobj.getStore());
            		g_conf_site_key = XmlPropertyManager.getSystemProperty("g_conf_site_key_" + actionobj.getStore());
            		System.out.println("취소시 사이트 코드 (일반 X) : " + g_conf_site_cd);
            		System.out.println("취소시 사이트 키 (일반 X) : " + g_conf_site_key);
            	}
            	
            	g_conf_tx_mode = Integer.parseInt(XmlPropertyManager.getSystemProperty("g_conf_tx_mode"));            	
            	g_conf_log_level = XmlPropertyManager.getSystemProperty("g_conf_log_level");            	
            }
            // 메일발송 취소 내역시 필요항목 추가(2013.02.20)
            actionobj.setSale_time(sCurrentTime);
            
            //마일리지 전액 사용 쿼리 2019.05.22 김동현
            pay_cnt = getSqlSession().selectOne(NS + ".selectCancelPointCnt", actionobj);
            if (pay_cnt == 0) { //전액 마일리지 취소 가 아닌 경우
            	if (actionobj.getSale_ymd().equals(sDate) && (actionobj.getTid() == null || actionobj.getTid().equals(""))) {
                    // 1) 당일매출 당일취소경우는 카드취소 승인취소 전문 전송 START 기존 로직
                	   /*
                     * 현재 WEB은 나이스(02), 코벤(03)으로만 승인요청함 차후 멤버스 서버 이관시 멤버스 서버단에 승인처리
                     * 고려해야함!! cf) CFDB (cfmall1/tyvld_44[쇼핑_44] 로그인후
                     * source/cardis/cys.7210 ---나이스, cys.7410--코벤 , include폴더및 define.h
                     * 점별 벤사 설정파일) (WEB경우 통신서버 정검시 접수 불가로 DB단에서 나이스, 코벤 벤사 승인요청 필요-
                     * WEB승인요청시 벤사단에 주민번호 뒷자리 넘겨줌. 일반벤사 승인요청과 틀림)
                     * 더이상 van결제 안함 백업개념
                     */
                	CmCardApp acard = new CmCardApp();

                    System.out.println(">>>>>>>>>>>>>>>당일매출 당일취소 카드 승인취소 처리 >>>>>>>>>>>>>>>  START -------------------> ");

                    // 1-1)원거래 매출 정보 조회 부분 추가
                    LectureVo actionobj2 = selectCardList(actionobj);
                    
                    // 1-2) 취소 카드정보설정
                    acard.setCancelCardStmt(actionobj2.getHq(), actionobj2.getStore(), actionobj2.getCardNo(), actionobj2.getSValidDt(),
                                            actionobj2.getSAllot(), Utils.roundFixUp(actionobj2.getCard_amt(), 0, false),sChck_value, 
                                            actionobj2.getOrg_ack_no(), actionobj2.getOrg_sale_ymd(), actionobj2.getVan_fg());

                    if (acard.start().equals("OK")) { // 소켓접속시도
                        approve = acard.run(); // 승인정보얻기

                        System.out.println("approve       : >>>>>>>>>>>>>>>>>>>>"+ approve + "<<<<<<<<<<<<<<");

                        sApprovNo = approve.substring(0, 8);
                        scBank_cd = approve.substring(8, 9); // 업무 구분(1) 5: 백화점가맹점 , 3:식품관가맹점
                                                             // (수원점 제외하고는 다 식품관 가맹점으로 승인남 현재 무의미 값 11.05.27 )
                        scRate = approve.substring(9, 10); // 승인벤사구분(1)
                        sMessage = approve.substring(10, 50);

                    } else {
                        sApprovNo = "Fail0000";
                    }
                    acard.stop(); // 접속종료
                    
                    System.out.println("settleCancleProcess_acard  : >>>>>>>>>>>>>>>>>>>>"+ sApprovNo + "<<<<<<<<<<<<<<");
                    System.out.println("settleCancleProcess_acard scRate : >>>>>>>>>>>>>>>>>>>>"+ scRate + "<<<<<<<<<<<<<<");

                    if ("1".equals(scRate)) {
                        scRate = "01";
                    } else if ("2".equals(scRate)) {
                        scRate = "02";
                    } else if ("4".equals(scRate)) {
                        scRate = "03";
                    } else if ("5".equals(scRate)) {
                        scRate = "04";
                    } else if ("6".equals(scRate)) {
                        scRate = "05";
                    } else if ("7".equals(scRate)) {
                        scRate = "06";
                    }

                    System.out.println("approve number   = [" + sApprovNo + "]\n");
                    System.out.println("scRate           = [" + scRate + "]");
                    System.out.println("message          = [" + sMessage + "]\n");
                    System.out.println("approve time     = [" + sCurrentTime + "]\n");

                        // 1-3) 카드취소 승인 결과 처리
                    if (sMessage == null || "".equals(sMessage)) {
                        rslt = "카드취소승인 중 알수없는 오류가 발생하였습니다. AK PLAZA 전산실 문의 바랍니다. ";
                        return rslt;
                    } else if ("        ".equals(sApprovNo)|| "Fail0000".equals(sApprovNo)) {
                        return sMessage;
                    }

                    System.out.println(">>>>>>>>>>>>>>> 당일매출 당일취소 카드 승인취소 처리 >>>>>>>>>>>>>>>  END -------------------> ");

                }else if(!actionobj.getTid().equals("")){
                	// PG사 승인 요청 
                	c_PayPlus.mf_init( "", g_conf_gw_url, g_conf_gw_port, g_conf_tx_mode, g_conf_home_dir );
                    c_PayPlus.mf_init_set();
                    
                    int    mod_data_set_no;

                    tran_cd = "00200000";
                    mod_data_set_no = c_PayPlus.mf_add_set( "mod_data" );
                    
                    System.out.println("actionobj.getTid() : "+actionobj.getTid());
                    
                    c_PayPlus.mf_set_us( mod_data_set_no, "tno",        actionobj.getTid()  ); // KCP 원거래 거래번호
                    c_PayPlus.mf_set_us( mod_data_set_no, "mod_type",   "STSC"                            ); // 원거래 변경 요청 종류
                    c_PayPlus.mf_set_us( mod_data_set_no, "mod_ip",     inet_ip                           ); // 변경 요청자 IP
                    c_PayPlus.mf_set_us( mod_data_set_no, "mod_desc",   "AK PLAZA 문화 아카데미 웹 취소 요청     " ); // 변경 사유
                    
                    if ( tran_cd.length() > 0 ){
                    	c_PayPlus.mf_do_tx( g_conf_site_cd, g_conf_site_key, tran_cd, "", "", g_conf_log_level, "0" );            		
                	    res_cd  = c_PayPlus.m_res_cd;  // 결과 코드
                		res_msg = c_PayPlus.m_res_msg; // 결과 메시지
                	}else{
                        c_PayPlus.m_res_cd  = "9562";
                        c_PayPlus.m_res_msg = "연동 오류|Payplus Plugin이 설치되지 않았거나 tran_cd값이 설정되지 않았습니다.";
                        rslt = "연동 모듈의 이상이 있습니다. KCP로 문의 바랍니다. ";
                        return rslt;
                    }
                    
                    if(!res_cd.equals("0000")) // 정상적으로 취소가 되지 않았을 경우 
                    {
                        System.out.println("res_cd====="+res_cd);
                        System.out.println("res_msg====="+res_msg);
                        

                    	rslt = "KCP 매출 취소시 문제가 발생 하였습니다. KCP로 문의 바랍니다.  ";
                        return rslt;
                    }
                    
                }
            } 
            // 당일매출 당일취소경우는 카드취소 승인취소 전문 전송 END
            // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            /*------------------------------------------------------------------------------------
             *     유료강좌 recpt_no 영수증번호 생성 -- AKmembers 로 unique 한 key를 적립하기위해선 영수증번호가 필요함 by CH 090102
             *-----------------------------------------------------------------------------------*/
            if (pay_cnt == 0) { //전액 마일리지 취소 가 아닌 경우
            	List<HashMap<String, Object>> rs = getSqlSession().selectList(NS + ".getAkmemNotCancel", actionobj);
            	
	            if (rs.size() > 0) {
	                akmem_cardno = Utils.checkNullString(rs.get(0).get("AKMEM_CARD_NO")); // 멤버스카드번호-암호화 제거(2018.06.20)              
	                akmem_scardno = Utils.checkNullString(rs.get(0).get("AKMEM_SCARD_NO")); // 결제카드번호-암호화 제거(2018.06.20)
	                akmem_custno = Utils.checkNullString(rs.get(0).get("AKMEM_CUSTNO")); // 멤버스회원번호
	                akmem_family_custno = Utils.checkNullString(rs.get(0).get("AKMEM_FAMILY_CUSTNO")); // 멤버스패밀리회원번호
	                
	                //akmem_approve_no = rs.get(0).get("AKMEM_APPROVE_NO"); // 적립당시
	                                                                        // 승인번호
	                akmem_total_show_amt = Integer.parseInt(Utils.checkNullString(rs.get(0).get("TOTAL_SHOW_AMT"))); // 총매출금액
	                akmem_total_regis_fee = Integer.parseInt(Utils.checkNullString(rs.get(0).get("TOTAL_REGIS_FEE"))); // 결제금액
	                akmem_sysdate = Utils.checkNullString(rs.get(0).get("SYSTEM_DATE")); // 시스템 일자
	                akmem_ori_recpt_no = Utils.checkNullString(rs.get(0).get("RECPT_NO")); // 원거래 (+) 적립
	                //if(rs.getInt("AKMEM_RECPT_POINT") > 0){
	                	akmem_approve_no_save = Utils.checkNullString(rs.get(0).get("AKMEM_APPROVE_NO_SAVE")); // 적립당시
	                //}
	                //if(rs.getInt("USE_POINT") > 0){
	                	akmem_approve_no_use = Utils.checkNullString(rs.get(0).get("AKMEM_APPROVE_NO_USE")); // 사용당시
	                //}
	                akmem_recpt_point = Integer.parseInt(Utils.checkNullString(rs.get(0).get("AKMEM_RECPT_POINT"))); // 적립된 포인트점수
	                akmem_use_point = Integer.parseInt(Utils.checkNullString(rs.get(0).get("USE_POINT")));// 멤버스 사용 된 마일리지 포인트 점수
	            }
            } else {
            	//마일리지 전액 취소인 경우
            	List<HashMap<String, Object>> rs = getSqlSession().selectList(NS + ".getAkmemCancel", actionobj);
	            System.out.println("akmem_cardno =1=> ");
	            if (rs.size() > 0) {
	            	//akmem_cardno = Des3.decode3DES(rs.getString("AKMEM_CARD_NO")); // 멤버스카드번호
	                //akmem_scardno = Des3.decode3DES(rs.getString("AKMEM_SCARD_NO")); // 결제카드번호
	                akmem_cardno = Utils.checkNullString(rs.get(0).get("AKMEM_CARD_NO")); // 멤버스카드번호-암호화 제거(2018.06.20)              
	                akmem_scardno = Utils.checkNullString(rs.get(0).get("AKMEM_SCARD_NO")); // 결제카드번호-암호화 제거(2018.06.20)
	                akmem_custno = Utils.checkNullString(rs.get(0).get("AKMEM_CUSTNO")); // 멤버스회원번호
	                akmem_family_custno = Utils.checkNullString(rs.get(0).get("AKMEM_FAMILY_CUSTNO")); // 멤버스패밀리회원번호
	                
	                akmem_approve_no = Utils.checkNullString(rs.get(0).get("AKMEM_APPROVE_NO")); // 적립당시
	                                                                        // 승인번호
	                akmem_total_show_amt = Integer.parseInt(Utils.checkNullString(rs.get(0).get("TOTAL_SHOW_AMT"))); // 총매출금액
	                akmem_total_regis_fee = Integer.parseInt(Utils.checkNullString(rs.get(0).get("TOTAL_REGIS_FEE"))); // 결제금액
	                akmem_sysdate = Utils.checkNullString(rs.get(0).get("SYSTEM_DATE")); // 시스템 일자
	                akmem_ori_recpt_no = Utils.checkNullString(rs.get(0).get("RECPT_NO")); // 원거래 (+) 적립
	                //if(rs.getInt("AKMEM_RECPT_POINT") > 0){
	                	//akmem_approve_no_save = rs.getString("AKMEM_APPROVE_NO"); // 적립당시
	                //}
	                //if(rs.getInt("USE_POINT") > 0){
	                	akmem_approve_no_use = Utils.checkNullString(rs.get(0).get("AKMEM_APPROVE_NO")); // 적립당시
	                //}
	                akmem_recpt_point = Integer.parseInt(Utils.checkNullString(rs.get(0).get("AKMEM_RECPT_POINT"))); // 적립된 포인트점수
	                akmem_use_point = Integer.parseInt(Utils.checkNullString(rs.get(0).get("USE_POINT")));// 멤버스 사용 된 마일리지 포인트 점수
	            }
            }

            // 멤버스 적립내역 존재경우 취소의 차감 영수증번호 조회 START
            // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            if (!akmem_cardno.equals("")) {
                if ("01".equals(actionobj.getStore())) {
                	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_01");
                } else if ("02".equals(actionobj.getStore())) {
                	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_02");
                } else if ("03".equals(actionobj.getStore())) {
                	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_03");
                } else if ("04".equals(actionobj.getStore())) {
                	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_04");
                } else if ("05".equals(actionobj.getStore())) {
                	akmem_recpt_no = getSqlSession().selectOne(NS + ".getAKmemRecptNo_05");
                }
            }
            // 멤버스 적립내역 존재경우 취소의 차감 영수증번호 조회 START
            // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

            // 2) 원거래 매출 정보 취소구분자 수정
            // 2-1) BATRMSTB UPDATE
            int upbatrmstbcnt = getSqlSession().update(NS + ".upTrmstbCancel", actionobj);
            

            if (upbatrmstbcnt == 0) {
                rslt = "매출취소중 BATRMSTB 원거래 정상건 취소 구분자 수정시 에러가 발생하였습니다.";
                return rslt;
            }

            // 2-2) BAPERETB UPDATE

            int upbaperetbcnt = getSqlSession().update(NS + ".upPeretbCancel", actionobj);
            /*System.out.println("  settleCancleProcess.java   --  query4 :" + query4);
            System.out.println("  settleCancleProcess.java   --  upbaperetbcnt :" + upbaperetbcnt);*/

            if (upbaperetbcnt == 0) {
                rslt = "매출취소중 BAPERETB 원거래 정상건 취소 구분자 수정시 에러가 발생하였습니다.";
                return rslt;
            }

            // 2-3) BAWBTRTB UPDATE
            int upbawbtrtbcnt = getSqlSession().update(NS + ".upWbtrtbCancel", actionobj);

            /*System.out.println("  settleCancleProcess.java   --  query5 :"+ query5);
            System.out.println("  settleCancleProcess.java   --  upbawbtrtbcnt :"+ upbawbtrtbcnt);*/

            if (upbawbtrtbcnt == 0) {
                rslt = "BAWBTRTB# 매출테이블 원거래 정상건 취소 구분자 수정시 에러가 발생하였습니다.";
                return rslt;
            } else if (upbawbtrtbcnt > 0) {
            	
            	System.out.println("== 매출 취소 ==>");
            	
                // 2-4) 취소 매출 BAWBTRTB INSERT
            	HashMap<String, Object> param = new HashMap<>();
            	param.put("hq", actionobj.getHq());
            	param.put("store", actionobj.getStore());
            	param.put("sDate", sDate);
            	param.put("sCurrentTime", sCurrentTime);
            	param.put("ipAddress", actionobj.getIpAddress());
            	param.put("akmem_recpt_no", akmem_recpt_no);
            	param.put("sale_ymd", actionobj.getSale_ymd());
            	param.put("recpt_no", actionobj.getRecpt_no());
            	param.put("pos_no", actionobj.getPos_no());
            	param.put("tid", actionobj.getTid());
            	param.put("period", actionobj.getPeriod());
            	param.put("custNo", actionobj.getCustNo());
            	
                
                int incnt = getSqlSession().insert(NS + ".insWbtrtbCancel", param);

                /*System.out.println("  settleCancleProcess.java   --  query6 :"+ query6);
                System.out.println("  settleCancleProcess.java   --  incnt :"  + incnt);*/

                if (incnt == 0) {
                    rslt = "BAWBTRTB 매출테이블 취소매출 저장시 에러가 발생하였습니다.";
                    return rslt;
                } else if ((upbatrmstbcnt > 0) && (upbaperetbcnt > 0) && (incnt > 0)) {

                    // 3) 멤버스 적립내역 조회 및 존재시 멤버스 차감 START
                    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                    // 3-1) 멤버스 적립내역 존재경우 멤버스 차감 세팅
                	System.out.println("멤버스 적립 취소 작업 시 : 카드번호 : " + akmem_cardno + ": 사용자 정보 :" + actionobj.getCustNo());
                    if (!akmem_cardno.equals("")) {
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_cardno          :"+ akmem_cardno);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_scardno         :"+ akmem_scardno);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_custno          :"+ akmem_custno);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_family_custno   :"+ akmem_family_custno);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_recpt_point     :"+ akmem_recpt_point);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_approve_no      :"+ akmem_approve_no);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_approve_no_save :"+ akmem_approve_no_save);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_approve_no_use  :"+ akmem_approve_no_use);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_total_show_amt  :"+ akmem_total_show_amt);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_total_regis_fee :"+ akmem_total_regis_fee);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_sysdate         :"+ akmem_sysdate);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_ori_recpt_no    :"+ akmem_ori_recpt_no);
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  getSale_ymd           :"+ actionobj.getSale_ymd());
                        System.out.println("  settleCancleProcess.java   멤버스발급내역 카드번호 조회 --  akmem_use_point       :"+ akmem_use_point);
                        
                        if(akmem_use_point > 0){
//                          AKmembers 사용 마일리지 차감요청
                            CmAKmembers exeAKmem = new CmAKmembers();
                            HashMap map2 = exeAKmem.AKmemPoint(actionobj.getStore()
                            		, akmem_cardno // 멤버스적립 카드번호
                                    , akmem_scardno // 결제카드번호
                                    , Utils.getCurrentDate() // recpt_sale_ymd (Sysdate)
                                    , actionobj.getPos_no() // 인터넷 포스 번호
                                    , akmem_recpt_no // recpt_no 영수증번호가 없으므로 멤버스용 akmem_recpt_no
                                    , Integer.toString((int) akmem_total_regis_fee) // total_amt
                                    , Integer.toString((int) akmem_recpt_point) // akmem_recpt_point
                                    , Integer.toString((int) akmem_use_point) // akmem_recpt_point
                                    , actionobj.getSale_ymd() // 원거래 매출일자 ★ 추가 2012.07.16)
                                    , akmem_ori_recpt_no // 원거래 멤버스 적립 영수증번호 ★ 추가 (2012.07.16)
                                    , "USECANCLE");
                            String AKmem_sApprovNo2 = (String) map2.get("RSP_CD");
                            String AKmem_sMessage2 = (String) map2.get("MSG_TRMNL");

                            if ("00".equals(AKmem_sApprovNo2)) {
                                
                                String AKmem_SaveApproveNo = (String) map2.get("PTCP_PERM_NO");
                                String AKmem_SaveApproveNo_POS = (String) map2.get("PERM_NO");
                                String AKmem_SaveApprove_Point = (String) map2.get("EUSE_PT");
                                String AKmem_CustNo = (String) map2.get("CUS_NO");
                                String AKmem_Create_Point = (String) map2.get("TOT_CREA_PT");
                                String AKmem_send_buff = (String) map2.get("SEND_STR");
                                String AKmem_recv_buff = (String) map2.get("RECV_BUFF");
                                
                                System.out.println("AKmem_SaveApprove_Point >>>>> 사용 차감 >>>>> "+AKmem_SaveApprove_Point);
                                
                                // db insert
                                param.put("AKmem_SaveApproveNo_POS", AKmem_SaveApproveNo_POS);
                                param.put("AKmem_send_buff", AKmem_send_buff);
                                param.put("AKmem_recv_buff", AKmem_recv_buff);
                                param.put("AKmem_SaveApprove_Point", AKmem_SaveApprove_Point);

                                int inpointcnt = getSqlSession().insert(NS + ".insWbptTbCancel", param);

                                System.out.println("  useSettleCancleProcess.java   --  inpointcnt :" + inpointcnt);

                                if (inpointcnt == 0) {
                                    rslt = "AK멤버스 사용 차감 테이블 저장중 ERROR가 발생하였습니다.";
                                    return rslt;
                                }

                                System.out.println("사용 차감ok ->db-insert");
                                System.out.println("AKmem_SaveApproveNo = "+ AKmem_SaveApproveNo);
                                System.out.println("AKmem_SaveApproveNo_POS = " + AKmem_SaveApproveNo_POS);
                                System.out.println("AKmem_SaveApprove_Point = " + AKmem_SaveApprove_Point);

                                // return value에 적립후 포인트 추가 ( ^금회적립포인트 ^적립후 포인트)

                            } else {
                                rslt = "AK멤버스 사용 마일리지 차감 요청오류";
                                return rslt;
                            }
                        }
                        
                        System.out.println("pay_cnt : "+pay_cnt);

                        if (pay_cnt == 0) { //전액 마일리지 취소 가 아닌 경우
//                        	 AKmembers 차감요청
                            CmAKmembers exeAKmem = new CmAKmembers();
                            HashMap map = exeAKmem.AKmemPoint(actionobj.getStore()
                            		, akmem_cardno // 멤버스적립 카드번호
                                    , akmem_scardno // 결제카드번호
                                    , Utils.getCurrentDate() // recpt_sale_ymd (Sysdate)
                                    , actionobj.getPos_no() // 인터넷 포스 번호
                                    , akmem_recpt_no // recpt_no 영수증번호가 없으므로 멤버스용 akmem_recpt_no
                                    , Integer.toString((int) akmem_total_regis_fee) // total_amt
                                    , Integer.toString((int) akmem_recpt_point) // akmem_recpt_point
                                    , Integer.toString((int) akmem_use_point) // akmem_use_point
                                    , actionobj.getSale_ymd() // 원거래 매출일자 ★ 추가 2012.07.16)
                                    , akmem_ori_recpt_no // 원거래 멤버스 적립 영수증번호 ★ 추가 (2012.07.16)
                                    , "SAVECANCLE");

                            String AKmem_sApprovNo = (String) map.get("RSP_CD");
                            String AKmem_sMessage = (String) map.get("MSG_TRMNL");
     
                            if ("00".equals(AKmem_sApprovNo)) {
                                
                                String AKmem_SaveApproveNo = (String) map.get("PTCP_PERM_NO");
                                String AKmem_SaveApproveNo_POS = (String) map.get("PERM_NO");
                                String AKmem_SaveApprove_Point = (String) map.get("EUSE_PT");
                                String AKmem_CustNo = (String) map.get("CUS_NO");
                                String AKmem_Create_Point = (String) map.get("TOT_CREA_PT");
                                String AKmem_send_buff = (String) map.get("SEND_STR");
                                String AKmem_recv_buff = (String) map.get("RECV_BUFF");

                                System.out.println("AKmem_SaveApprove_Point >>>>> 적립 차감 >>>>> "+AKmem_SaveApprove_Point);
                                System.out.println("AKmem_SaveApproveNo = "+ AKmem_SaveApproveNo);
                                System.out.println("AKmem_SaveApproveNo_POS = " + AKmem_SaveApproveNo_POS);
                                
                                // db insert
                                
                                param.put("AKmem_SaveApproveNo_POS", AKmem_SaveApproveNo_POS);
                                param.put("AKmem_send_buff", AKmem_send_buff);
                                param.put("AKmem_recv_buff", AKmem_recv_buff);
                                param.put("AKmem_SaveApprove_Point", AKmem_SaveApprove_Point);

                                int inpointcnt = getSqlSession().insert(NS + ".insWbptTbCancel2", param);

                                System.out.println("  settleCancleProcess.java   --  inpointcnt :" + inpointcnt);

                                if (inpointcnt == 0) {
                                    rslt = "AK멤버스 차감 테이블 저장중 ERROR가 발생하였습니다.";
                                    return rslt;
                                }

                                System.out.println("적립 차감ok ->db-insert");
                                System.out.println("AKmem_SaveApproveNo = "+ AKmem_SaveApproveNo);
                                System.out.println("AKmem_SaveApproveNo_POS = " + AKmem_SaveApproveNo_POS);
                                System.out.println("AKmem_SaveApprove_Point = " + AKmem_SaveApprove_Point);

                                // return value에 적립후 포인트 추가 ( ^금회적립포인트 ^적립후 포인트)

                            } else {
                                rslt = "AK멤버스차감 요청오류";
                                return rslt;
                            }
                        }
                    }

                    // 3) 멤버스 적립내역 조회 및 존재시 멤버스 차감 END
                    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

                    rslt = "success";
                    return rslt;
                }
            }
            return rslt;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	public LectureVo selectCardList(LectureVo actionobj) throws Exception {
        try {
        	List<HashMap<String, Object>> rs = getSqlSession().selectList(NS + ".selectCardList", actionobj);

//            System.out.println("selectCardList - query >>>>>> " + query);

            LectureVo lectureVo = new LectureVo();
            if (rs.size() > 0) {
                lectureVo.setHq(Utils.checkNullString(rs.get(0).get("HQ")));
                lectureVo.setStore(Utils.checkNullString(rs.get(0).get("STORE")));
//              lectureVo.setCardNo(Des3.decode3DES(rs.getString("card_no")));
                lectureVo.setCardNo(Utils.checkNullString(rs.get(0).get("CARD_NO"))); // 멤버스카드번호-암호화 제거(2018.06.20)
                lectureVo.setSValidDt(Utils.checkNullString(rs.get(0).get("VALID_DATE")));
                lectureVo.setSAllot(Utils.checkNullString(rs.get(0).get("INST_MM")));
                lectureVo.setCard_amt(Double.parseDouble(Utils.checkNullString(rs.get(0).get("CARD_AMT"))));
                lectureVo.setOrg_ack_no(Utils.checkNullString(rs.get(0).get("APPROVE_NO")));
                lectureVo.setOrg_sale_ymd(Utils.checkNullString(rs.get(0).get("SALE_YMD")));
                lectureVo.setVan_fg(Utils.checkNullString(rs.get(0).get("VAN_FG")));

/*                System.out.println("selectCardList - hq         >>>>>> "                        + rs.getString("hq"));
                System.out.println("selectCardList - store      >>>>>> "                        + rs.getString("store"));
                System.out.println("selectCardList - card_no    >>>>>> "                        + Des3.decode3DES(rs.getString("card_no")));
                System.out.println("selectCardList - valid_date >>>>>> "                        + rs.getString("valid_date"));
                System.out.println("selectCardList - card_amt   >>>>>> "                        + rs.getString("card_amt"));
                System.out.println("selectCardList - approve_no >>>>>> "                        + rs.getString("approve_no"));
                System.out.println("selectCardList - sale_ymd >>>>>> "                        + rs.getString("sale_ymd"));
                System.out.println("selectCardList - van_fg >>>>>> "                        + rs.getString("van_fg"));*/

            }
            return lectureVo;
            } catch (Exception e) {
            throw new Exception(e);
        }
    }
	
	public HashMap<String, Object> getNewsFileName(String cust_no,int reg_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("reg_no", reg_no);
		return getSqlSession().selectOne(NS + ".getNewsFileName", map);
	}
	
	public HashMap<String, Object> getNewsFileName2(String cust_no,int reg_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("reg_no", reg_no);
		return getSqlSession().selectOne(NS + ".getNewsFileName2", map);
	}
	
	public void Save(HashMap<String, Object> param){
		String path = XmlPropertyManager.getSystemProperty("RECRUIT_FILE_PATH");
		File file = new File(path + param.get("file_nm"));
		param.put("file", file);
		getSqlSession().update(NS + ".Save_wbrec", param);
	}
	
	public void Save02(HashMap<String, Object> param){
		String path = XmlPropertyManager.getSystemProperty("RECRUIT_FILE_PATH");
		File file = new File(path + param.get("file_nm"));
		param.put("file", file);
		getSqlSession().update(NS + ".Save_wbpla", param);
	}


	public List<HashMap<String, Object>> getSubjectTax(String branch, String web_text, String cus_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("branch", branch);
		map.put("web_text", web_text);
		map.put("cus_no", cus_no);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getSubjectTax", map);
		return list;
	}




	public List<HashMap<String, Object>> getJr(String store, String period, String subject_cd, String lecturer_cd, String tb) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("lecturer_cd", lecturer_cd);
		map.put("subject_cd", subject_cd);
		map.put("tb", tb);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getJr", map);
		return list;
	}


	public String getLecturerCd(String cus_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cus_no", cus_no);
		return getSqlSession().selectOne(NS + ".getLecturerCd", map);
	}


	public HashMap<String, Object> getLecrByCus(String cus_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cus_no", cus_no);
		HashMap<String, Object> data = getSqlSession().selectOne(NS + ".getLecrByCus", map);
		return data;
	}


	public List<HashMap<String, Object>> getSubjectCert(String branch, String start_ymd, String end_ymd, String cus_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("branch", branch);
		map.put("start_ymd", start_ymd);
		map.put("end_ymd", end_ymd);
		map.put("cus_no", cus_no);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getSubjectCert", map);
		return list;
	}


	public String getSubjectNm(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		return  getSqlSession().selectOne(NS + ".getSubjectNm", map);
	}


	public List<HashMap<String, Object>> getNewsCount(String search_store, String search_type, String search_name) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("search_store", search_store);
		map.put("search_type", search_type);
		map.put("search_name", search_name);
		return  getSqlSession().selectList(NS + ".getNewsCount", map);
	}


	public List<HashMap<String, Object>> getNewsList(int s_rownum, int e_rownum, String search_store, String search_type, String search_name) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("search_store", search_store);
		map.put("search_type", search_type);
		map.put("search_name", search_name);
		return  getSqlSession().selectList(NS + ".getNewsList", map);
	}


	public HashMap<String, Object> getNewsOne(String seq) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("seq", seq);
		return getSqlSession().selectOne(NS + ".getNewsOne", map);
	}


	public void upNewsViews(String seq) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("seq", seq);
		getSqlSession().update(NS + ".upNewsViews", map);
	}
	
	public void lastSubmit(String cust_no,String reg_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("reg_no", reg_no);
		getSqlSession().update(NS + ".lastSubmitWBREC", map);
		getSqlSession().update(NS + ".lastSubmitWBPLA", map);
		//getSqlSession().insert(NS + ".insApply", reg_no);
		//getSqlSession().insert(NS + ".insContract", reg_no);
	}
	
	
	public List<HashMap<String, Object>> getApplyResultCount(String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		return  getSqlSession().selectList(NS + ".getApplyResultCount", map);
	}
	
	
	public List<HashMap<String, Object>> getApplyResult(int s_rownum, int e_rownum, String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("cust_no", cust_no);
		
		return  getSqlSession().selectList(NS + ".getApplyResult", map);
	}
	
	public List<HashMap<String, Object>> getContractInfoCount(String cus_no,String store,String start_ymd,String end_ymd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cus_no", cus_no);
		map.put("store", store);
		map.put("start_ymd", start_ymd);
		map.put("end_ymd", end_ymd);
		return  getSqlSession().selectList(NS + ".getContractInfoCount", map);
	}
	
	
	public List<HashMap<String, Object>> getContractInfo(int s_rownum, int e_rownum, String cus_no,String store,String start_ymd,String end_ymd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("cus_no", cus_no);
		map.put("store", store);
		map.put("start_ymd", start_ymd);
		map.put("end_ymd", end_ymd);
		
		return  getSqlSession().selectList(NS + ".getContractInfo", map);
	}
	
	public HashMap<String, Object> getContractInfo02(String store,String period,String cus_no, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("cus_no", cus_no);
		map.put("subject_cd", subject_cd);
		
		HashMap<String, Object> list = getSqlSession().selectOne(NS + ".getContractInfo02", map);
		return list;
	}
	
	public int confirm(String store, String period, String cus_no, String subject_cd,String naver_yn,String info_yn) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("cus_no", cus_no);
		map.put("subject_cd", subject_cd);
		map.put("naver_yn", naver_yn);
		map.put("info_yn", info_yn);
		int result = getSqlSession().update(NS + ".confirm", map);
		return result;
	}

	
	public int delAply(String cust_no,String reg_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("reg_no", reg_no);
		map.put("cust_no", cust_no);
		
		int rs1 = getSqlSession().delete(NS + ".delWBREC", map);
		int rs2 = getSqlSession().delete(NS + ".delWBPLA", map);
		//int rs3 = getSqlSession().delete(NS + ".delCONTRACT", map);
		//int rs4 = getSqlSession().delete(NS + ".delAPPLY", map);
		
		int result=rs1+rs2;
		return result;
	}
	
	public List<HashMap<String, Object>> getSeason(String store) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getSeason",map);
		return list;
	}


	public String selPeriBySeason(String search_store, String web_text) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("search_store", search_store);
		map.put("web_text", web_text);
		return getSqlSession().selectOne(NS + ".selPeriBySeason", map);
	}


	public List<HashMap<String, Object>> getPlanListCount(String search_store, String start_peri, String end_peri, String login_cus) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("search_store", search_store);
		map.put("start_peri", start_peri);
		map.put("end_peri", end_peri);
		map.put("login_cus", login_cus);
		return  getSqlSession().selectList(NS + ".getPlanListCount", map);
	}


	public List<HashMap<String, Object>> getPlanList(int s_rownum, int e_rownum, String search_store, String start_peri, String end_peri, String login_cus) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("search_store", search_store);
		map.put("start_peri", start_peri);
		map.put("end_peri", end_peri);
		map.put("login_cus", login_cus);
		return  getSqlSession().selectList(NS + ".getPlanList", map);
	}


	public HashMap<String, Object> getPeltDetail(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		return  getSqlSession().selectOne(NS + ".getPeltDetail", map);
	}
	
	
	public List<HashMap<String, Object>> getLectListCount(String cus_no,String store) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cus_no", cus_no);
		map.put("store", store);
		return  getSqlSession().selectList(NS + ".getLectListCount", map);
	}
	
	
	public List<HashMap<String, Object>> getLectList(int s_rownum, int e_rownum, String cus_no,String store) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("cus_no", cus_no);
		map.put("store", store);
		
		return  getSqlSession().selectList(NS + ".getLectList", map);
	}
	
	public List<HashMap<String, Object>> getAttendListCount(String store,String period,String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		return  getSqlSession().selectList(NS + ".getAttendListCount", map);
	}
	
	
	public List<HashMap<String, Object>> getAttendList(int s_rownum, int e_rownum, String store,String period,String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		
		return  getSqlSession().selectList(NS + ".getAttendList", map);
	}
	

	public void uptAttendList(String store, String period, String subject_cd,String cust_no,String chklist,String content) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		map.put("chklist", chklist);
		map.put("content", content);
		
		getSqlSession().update(NS + ".uptAttendList", map);
		
	}
	
	public HashMap<String, Object> getLecrInfo(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		
		HashMap<String, Object> list = getSqlSession().selectOne(NS + ".getLecrInfo", map);
		return list;
	}
	
	public HashMap<String, Object> getReview(String store, String period, String subject_cd, String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		
		HashMap<String, Object> list = getSqlSession().selectOne(NS + ".getReview", map);
		return list;
	}
	
	public int uptReview(String store, String period, String subject_cd, String cust_no,String reco_yn,String content) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		map.put("reco_yn", reco_yn);
		map.put("content", content);
		int result = getSqlSession().update(NS + ".uptReview", map);
		return result;
	}
	
	public int delReview(String store, String period, String subject_cd, String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		int result = getSqlSession().update(NS + ".delReview", map);
		return result;
	}
	public List<HashMap<String, Object>> getPlanDetail(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getPlanDetail", map);
		return list;
	}
	public HashMap<String, Object> getPeltOne(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		
		HashMap<String, Object> data = getSqlSession().selectOne(NS + ".getPeltOne", map);
		return data;
	}
	public void upPlan(String store, String period, String subject_cd, String subject_nm, String lecturer_nm, String lecturer_career, String lecture_content, String etc, String login_seq, String filename) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("subject_nm", subject_nm);
		map.put("lecturer_nm", lecturer_nm);
		map.put("lecturer_career", lecturer_career);
		map.put("lecture_content", lecture_content);
		map.put("etc", etc);
		map.put("login_seq", login_seq);
		map.put("filename", filename);
		getSqlSession().update(NS + ".upPlan", map);
	}
	public void insPlan(String store, String period, String subject_cd, String subject_nm, String lecturer_nm, String lecturer_career, String lecture_content, String etc, String login_seq, String filename) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("subject_nm", subject_nm);
		map.put("lecturer_nm", lecturer_nm);
		map.put("lecturer_career", lecturer_career);
		map.put("lecture_content", lecture_content);
		map.put("etc", etc);
		map.put("login_seq", login_seq);
		map.put("filename", filename);
		getSqlSession().insert(NS + ".insPlan", map);
	}

	public List<HashMap<String, Object>> getRecoCount(String tag) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("tag", tag);
		return  getSqlSession().selectList(NS + ".getRecoCount", map);
	}
	public List<HashMap<String, Object>> getRecoList(int s_rownum, int e_rownum, String tag) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_rownum", s_rownum);
		map.put("e_rownum", e_rownum);
		map.put("tag", tag);
		return  getSqlSession().selectList(NS + ".getRecoList", map);
	}


	public int insReview(String store, String period, String subject_cd, String cust_no, String reco_yn, String content) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		map.put("cust_no", cust_no);
		map.put("reco_yn", reco_yn);
		map.put("content", content);
		int result = getSqlSession().insert(NS + ".insReview", map);
		return result;
	}


	public List<HashMap<String, Object>> getPaymentListByTid(String tid, String store, String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("tid", tid);
		map.put("store", store);
		map.put("cust_no", cust_no);
		return  getSqlSession().selectList(NS + ".getPaymentListByTid", map);
	}


	public List<HashMap<String, Object>> getPeltMid(String store, String period, String subject_cd) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		map.put("subject_cd", subject_cd);
		
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getPeltMid", map);
		return list;
	}


	public List<HashMap<String, Object>> getHoliday(String store, String period) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("store", store);
		map.put("period", period);
		List<HashMap<String, Object>> list = getSqlSession().selectList(NS + ".getHoliday", map);
		return list;
	}
	
	public void uptMarrySNS(String cust_no, String marry_fg, String sns_url) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("marry_fg", marry_fg);
		map.put("sns_url", sns_url);
		getSqlSession().update(NS + ".uptMarrySNS", map);
	}
	
	public HashMap<String, Object> getMarrySNS(String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		HashMap<String, Object> data = getSqlSession().selectOne(NS + ".getMarrySNS", map);
		return data;
	}
	
	public int delChild(String cust_no,String child_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		map.put("child_no", child_no);

		return getSqlSession().update(NS + ".delChild", map);
	}
	
	public int getlast_childNo(String cust_no) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("cust_no", cust_no);
		return getSqlSession().selectOne(NS + ".getlast_childNo", map);
	}
}
