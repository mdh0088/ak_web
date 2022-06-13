package ak_web.classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import ak_web.model.web.CommonDAO;
import ak_web.model.web.CourseDAO;
import ak_web.model.web.MainDAO;

public class Utils {	
	
	private static String toHex(byte hash[]) {
		StringBuffer buf = new StringBuffer(hash.length * 2);
		for(int i = 0; i < hash.length; i++) {
			int intVal = hash[i] & 0xff;
			if(intVal < 0x10) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(intVal));
		}
		return buf.toString();
	}
	public static String getHashString(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			return toHex(md.digest());
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			return str;
		}
	}
	
	public static synchronized String checkNullString(Object str) 
	{
		String strTmp;
		try 
		{
			if (str != null && str.toString().length() > 0 && !str.equals("") && !str.equals("null"))
			{
				strTmp = str.toString();
			}
			else
			{
				strTmp = "";
			}
		} 
		catch (Exception e) 
		{
			strTmp = "";
		}
		return strTmp;
	}
	static public String removeNULL(String str, String init)
 	{
        String result = init;
       
        if (str != null && !str.equals("null") && !str.equals("")){
          result = str.trim();
        }
       
        return result;
 	}
	static public String removeNULL(Object str, String init)
	{
		String result = init;
		
		if (str != null && !str.equals("null") && !str.equals("")){
			result = str.toString().trim();
		}
		
		return result;
	}
	
	public static synchronized int checkNullInt(Object num) 
	{
		int numTmp;
		try 
		{
			if (num != null && num.toString().length() > 0 && !num.equals(""))
			{
				numTmp = Integer.parseInt(num.toString().trim());
			}
			else
			{
				numTmp = 0;
			}
		} 
		catch (Exception e) 
		{
			numTmp = 0;
		}
		return numTmp;
	}
	
	public static String getDateNow(String type)
	{
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String year = (sdf.format(now)).substring(0,4);
		String month = (sdf.format(now)).substring(4,6);
		String day = (sdf.format(now)).substring(6,8);
		
		String ret = "";
		if("year".equals(type))
		{
			ret = year;
		}
		else if("month".equals(type))
		{
			ret = month;
		}
		else if("day".equals(type))
		{
			ret = day;
		}
		return ret;
	} 
	
	public static String getClientIP(HttpServletRequest request) {
		String ip = null;
		ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-RealIP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("REMOTE_ADDR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	public static String excelDown(String sheetname, String filename, ArrayList<String> db_column, ArrayList<String> print_column, ArrayList<Integer> size_column, List<HashMap<String, Object>> list) throws IOException
	{
		if(db_column.size() != print_column.size())
		{
			return "FAIL : 컬럼 갯수 상이";
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(sheetname);
		
		HSSFRow row = null;
		HSSFCell cell = null;
		
		//셀 스타일
		CellStyle headStyle = workbook.createCellStyle();
		headStyle.setFillForegroundColor(HSSFColorPredefined.AQUA.getIndex()); //배경색
		headStyle.setAlignment(HorizontalAlignment.CENTER); //가운데정렬
		headStyle.setVerticalAlignment(VerticalAlignment.CENTER); //세로정렬
		
		//사이즈지정
		for(int i = 0; i < size_column.size(); i++)
		{
			sheet.setColumnWidth(i+1, size_column.get(i)); 
		}
		//셀 스타일

		
		//제목 셋팅
		row = sheet.createRow(1); //한칸띄자 보기좋게
		for(int i = 0; i < print_column.size(); i++)
		{
			cell = row.createCell(i+1); //한칸띄자 보기좋게
			cell.setCellStyle(headStyle);
			cell.setCellValue(print_column.get(i));
		}
		//제목 셋팅
		
		for(int i = 0; i < list.size(); i++)
		{
			row = sheet.createRow(i+2);
			for(int z = 0; z < db_column.size(); z++)
			{
				cell = row.createCell(z+1);
				if(list.get(i).get(db_column.get(z)) != null)
				{
					cell.setCellValue(list.get(i).get(db_column.get(z)).toString());
				}
			}
		}
		
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\musign design lab\\Documents\\workspace-sts-3.9.6.RELEASE\\ak_culture\\WebContent\\excel\\"+filename);
		workbook.write(fos);
		fos.flush();
		fos.close();
		
		return "SUCCESS";
	}
	
	public static String excelDownforTable(String sheetname, String filename,int countMatches, ArrayList<String> print_column, ArrayList<Integer> size_column, ArrayList<Integer> list) throws IOException
	{
		if(countMatches != print_column.size())
		{
			return "FAIL : 컬럼 갯수 상이";
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(sheetname);
		
		HSSFRow row = null;
		HSSFCell cell = null;
		
		ArrayList<String> get_cell = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			Integer a = list.get(i);
		}
		
		//셀 스타일
		CellStyle headStyle = workbook.createCellStyle();
		headStyle.setFillForegroundColor(HSSFColorPredefined.AQUA.getIndex()); //배경색
		headStyle.setAlignment(HorizontalAlignment.CENTER); //가운데정렬
		headStyle.setVerticalAlignment(VerticalAlignment.CENTER); //세로정렬
		
		//사이즈지정
		for(int i = 0; i < size_column.size(); i++)
		{
			sheet.setColumnWidth(i+1, size_column.get(i)); 
		}
		//셀 스타일

		
		//제목 셋팅
		row = sheet.createRow(1); //한칸띄자 보기좋게
		for(int i = 0; i < print_column.size(); i++)
		{
			cell = row.createCell(i+1); //한칸띄자 보기좋게
			cell.setCellStyle(headStyle);
			cell.setCellValue(print_column.get(i));
		}
		//제목 셋팅
		/*
		for(int i = 0; i < list.size(); i++)
		{
			row = sheet.createRow(i+2);
			
			for(int z = 0; z < db_column.size(); z++)
			{
				cell = row.createCell(z+1);
				if(list.get(i).get(db_column.get(z)) != null)
				{
					cell.setCellValue(list.get(i).get(db_column.get(z)).toString());
				}
			}
		}
		*/
		
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\MUSIGN-301\\Documents\\workspace\\ak_culture\\WebContent\\excel\\"+filename);
		workbook.write(fos);
		fos.flush();
		fos.close();
		
		return "SUCCESS";
	}
	
	public static String repWord(String buffer) {
		buffer = buffer.replaceAll("&", "&amt;");
		buffer = buffer.replaceAll("<", "&lt;");
		buffer = buffer.replaceAll(">", "&gt;");
		buffer = buffer.replaceAll("\"", "&quot;");
		buffer = buffer.replaceAll("\'", "&#039;");
		buffer = buffer.replaceAll("\n", "<br>");
		return buffer;
	}
	
	public static void setSearchVal(ModelAndView mav, MainDAO main_dao)
	{
		mav.addObject("year", Utils.getDateNow("year"));
		List<HashMap<String, Object>> branchList = main_dao.getBranch();
		List<HashMap<String, Object>> maincdList = main_dao.get1Depth();
		
		mav.addObject("branchList", branchList);
		mav.addObject("maincdList", maincdList);
	}
	
	public static HashMap<String, Object> enterPeriod(CommonDAO common_dao,String store)
	{
		
		boolean isPreAttend = false;
		boolean okWebReceipt = false; 
		boolean okWebReceiptEnd = false;
		boolean okWebReceiptAdultS = false;
		boolean okWebReceiptChildS = false;
		boolean okWebReceiptAdultF = false;
		boolean okWebReceiptChildF = false;
		
		String sCurrentDate = Utils.getCurrentDate();
	    String sCurrentTime = Utils.getCurrentTime();
		
//	    String sCs_open         = "";
	    String sBgndate         = "";
	    String sAdult_s_bgndate = "일정미확정";
//	    String sChild_s_bgndate = "일정미확정";
	    String sAdult_f_bgndate = "일정미확정";
//	    String sChild_f_bgndate = "일정미확정";
	    String sEnddate         = "";
//	    String sTime            = "10:00";
//	    String sTime1           = "";
	    String sCreator         = "";
	    String sCreate_date     = "";
	    String sWeb_open        = "";
		
	    String period = common_dao.retrievePeriod(store).get("PERIOD").toString();
	    List<HashMap<String, Object>> LectReceiptDayList=null;
	    
		if (!store.equals("")) {
			LectReceiptDayList = common_dao.retrieveLectReceiptDay(store,period);
			
			if (LectReceiptDayList!=null) {
//				sCs_open         = LectReceiptDayList.get(0).get("CS_OPEN_YMD").toString();
				sBgndate         = LectReceiptDayList.get(0).get("START_YMD").toString();
				sAdult_s_bgndate = LectReceiptDayList.get(0).get("ADULT_S_BGN_YMD").toString();
//				sChild_s_bgndate = LectReceiptDayList.get(0).get("CHILD_S_BGN_YMD").toString();
				sAdult_f_bgndate = LectReceiptDayList.get(0).get("ADULT_F_BGN_YMD").toString();
//				sChild_f_bgndate = LectReceiptDayList.get(0).get("CHILD_F_BGN_YMD").toString();
				sEnddate         = LectReceiptDayList.get(0).get("END_YMD").toString();
//				sTime            = LectReceiptDayList.get(0).get("TIME").toString();
				sCreator         = LectReceiptDayList.get(0).get("CREATE_RESI_NO").toString();
				sCreate_date     = LectReceiptDayList.get(0).get("CREATE_DATE").toString();
				sWeb_open        = LectReceiptDayList.get(0).get("WEB_OPEN_YMD").toString();
				
				
				int iCurrentDate     = Integer.parseInt( sCurrentDate );
				int iCurrentTime     = Integer.parseInt( sCurrentTime );
				// 09.07.27 start_ymd DESK 먼저 접수로 web_open_ymd 로 수정
				int iBgndate         = Integer.parseInt( sWeb_open         );
				int iAdult_s_bgndate = Integer.parseInt( sAdult_s_bgndate );
//				int iChild_s_bgndate = Integer.parseInt( sChild_s_bgndate );
				int iAdult_f_bgndate = Integer.parseInt( sAdult_f_bgndate );
//				int iChild_f_bgndate = Integer.parseInt( sChild_f_bgndate );
				int iEnddate         = Integer.parseInt( sEnddate         );
//				int iTime            = Integer.parseInt( sTime            );
				
				sAdult_s_bgndate = Utils.dateMask(sAdult_s_bgndate)+"("+Utils.getDayOfWeekKOR (sAdult_s_bgndate)+")";
//				sChild_s_bgndate = Utils.dateMask(sChild_s_bgndate)+"("+Utils.getDayOfWeekKOR (sChild_s_bgndate)+")";
				sAdult_f_bgndate = Utils.dateMask(sAdult_f_bgndate)+"("+Utils.getDayOfWeekKOR (sAdult_f_bgndate)+")";
//				sChild_f_bgndate = Utils.dateMask(sChild_f_bgndate)+"("+Utils.getDayOfWeekKOR (sChild_f_bgndate)+")";
//				sTime            = Utils.timeMask(iTime+"").substring(0,5);
				
				if(iCurrentDate > iEnddate ){
					okWebReceiptEnd = true;
				}
				if (   ( iCurrentDate >  iBgndate && iCurrentDate <= iEnddate )
						||( iCurrentDate == iBgndate    )
						) {
					
					System.out.println("iCurrentDate : "+iCurrentDate );
					System.out.println("iBgndate : "+iBgndate );
					System.out.println("iEnddate : "+iEnddate );
					okWebReceipt = true; // 현재 접수 기간임
					
					//영유아 기존 재수강 분리요청으로 인해 분리함.
					//성인기존재수강
					if (  ( iCurrentDate >  iAdult_s_bgndate )
							||( iCurrentDate == iAdult_s_bgndate )
							) {
						okWebReceiptAdultS = true;
					}
					
					//유아기존재수강
//					if (  ( iCurrentDate >  iChild_s_bgndate )
//							||( iCurrentDate == iChild_s_bgndate && iCurrentTime >= iTime )
//							) {
//						okWebReceiptChildS = true;
//					}
					
					//성인신규재수강
					if (  ( iCurrentDate >  iAdult_f_bgndate )
							||( iCurrentDate == iAdult_f_bgndate)
							) {
						okWebReceiptAdultF = true;
					}
					
					//유아기존재수강
//					if (  ( iCurrentDate >  iChild_f_bgndate )
//							||( iCurrentDate == iChild_f_bgndate && iCurrentTime >= iTime )
//							) {
//						okWebReceiptChildF = true;
//					}
				}
				
			}
			
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("isPreAttend", isPreAttend);
		map.put("okWebReceipt", okWebReceipt);
		map.put("okWebReceiptEnd", okWebReceiptEnd);
		map.put("okWebReceiptAdultS", okWebReceiptAdultS);
		map.put("okWebReceiptChildS", okWebReceiptChildS);
		map.put("okWebReceiptAdultF", okWebReceiptAdultF);
		map.put("okWebReceiptChildF", okWebReceiptChildF);
		
		map.put("sCurrentDate", sCurrentDate);
		map.put("sCurrentTime", sCurrentTime);
//		map.put("sCs_open", sCs_open);
		map.put("sBgndate", sBgndate);
		map.put("sAdult_s_bgndate", sAdult_s_bgndate);
//		map.put("sChild_s_bgndate", sChild_s_bgndate);
		map.put("sAdult_f_bgndate", sAdult_f_bgndate);
//		map.put("sChild_f_bgndate", sChild_f_bgndate);
		map.put("sEnddate", sEnddate);
//		map.put("sTime", sTime);
//		map.put("sTime1", sTime1);
		map.put("sCreator", sCreator);
		map.put("sCreate_date", sCreate_date);
		map.put("sWeb_open", sWeb_open);
		

		
		return map;
	}
	
	
	
	
	
	public static String roundFixUp(double input, int fraction, boolean isGroupingUsed)
	{
		try
		{
			java.text.NumberFormat format = java.text.NumberFormat.getInstance();
			format.setMaximumFractionDigits(fraction);
			format.setMinimumFractionDigits(fraction);
			format.setGroupingUsed(isGroupingUsed);
			return format.format(input);
		}catch(Exception e){
			return new Double(input).toString();
		}
	} 

	
    /*************************************************
     * 4. 현재 날짜를 가져오는 함수 (서버모듈에서 실행)
     *    ex) getCurrentDate()
     * @param  void
     * @return String toDay  : 현재일자(년월일 8자리 String)
     *************************************************/
    static public String getCurrentDate() {        
        String toDay = null;
        
        java.util.Date date = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        toDay = dateFormat.format(date);
        
        return toDay;
    }
    
    /*************************************************
     * 5. 현재 시간을 가져오는 함수 (서버모듈에서 실행)
     *    ex) getCurrentTime()
     * @param  void
     * @return String nowTime  : 현재시간(시분초 6자리 String)
     *************************************************/
    static public String getCurrentTime() {
        String nowTime = null;
        
        java.util.Date date = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");
        nowTime = dateFormat.format(date);
        
        return nowTime;
    }
    
    /*************************************************
     * 10. 날짜를 년,월,일 단위로 나누는 함수
     *    ex) wonRetrans("20050903")
     * @param  String  src         : 8자리 년월일 String
     * @return String  resultValue : '/'로 분할된 10자리 년월일 String
     *************************************************/
    static public String dateMask(String src) {
        String resultValue = null;
        resultValue = src.substring(0,4) + "." + src.substring(4,6) + "." + src.substring(6);
        return resultValue;
    }
    
    /*************************************************
     * 11. 시간을 시,분,초 단위로 나누는 함수
     *    ex) timeMask("180216")
     * @param  String  src         : 6자리 시분초 String
     * @return String  resultValue : ':'로 분할된 8자리 시분초 String
     *************************************************/
    static public String timeMask(String src) {
        String resultValue = null;
        resultValue = src.substring(0,2) + ":" + src.substring(2,4) + ":" + src.substring(4);
        return resultValue;
    }
    
    /*************************************************
     * 13. 8자리 년월일 String을 Calendar Type의 날짜로 변환하는 함수
     *    ex) getDateCalendar("20050930")
     * @param  String   date     : 8자리 String Type의 년월일
     * @return Calendar calendar : Calendar Type의 날짜
     *************************************************/
    static public Calendar getDateCalendar(String date) {
        Calendar calendar = Calendar.getInstance(Locale.KOREA);
        calendar.set(Integer.parseInt(date.substring(0,4)),
        Integer.parseInt(date.substring(4,6)) - 1,
        Integer.parseInt(date.substring(6)));
    
        return calendar;
    }
    
    /*************************************************
     * 16. 입력받은 날짜가 한주의 몇번째 요일인지 int값을 돌려주는 함수
     *    ex) getDayOfWeek(date)
     * @param  Date  date   : 입력받은 날짜
     * @return int   result : 한주의 몇번째 요일
     *************************************************/
    static public int getDayOfWeek(java.util.Date date) {
        int result = -1;
        String weekdays[] = (new DateFormatSymbols()).getShortWeekdays();
        String weekday    = (new SimpleDateFormat("E")).format(date);
        
        for (int i = 1; i <= weekdays.length; ++i) {
            if (weekday.equals(weekdays[i])) {
                result = i;
                break;
            }
        }
        return result;
    }
    
    
    /*************************************************
     * 16-1. 입력받은 날짜의 한글요일 돌려주는 함수
     *    ex) getDayOfWeekKOR(date)
     * @param  String sDate   : 입력받은 날짜
     * @return String sResult : 해당요일
     *************************************************/
    static public String getDayOfWeekKOR( String sDate ) {
        String sResult = "";
        if ( sDate == null || sDate.length() != 8 ) {
            return sResult;
        }
        switch( getDayOfWeek( Utils.getDateCalendar(sDate).getTime() ) ) {
            case 1: sResult = "일"; break;
            case 2: sResult = "월"; break;
            case 3: sResult = "화"; break;
            case 4: sResult = "수"; break;
            case 5: sResult = "목"; break;
            case 6: sResult = "금"; break;
            case 7: sResult = "토"; break;
        }
        return sResult;
    }
    
    /*************************************************
     * 20.  입력받은 String 에서 space를 &nbsp; 로, enter 값을 <br>로 바꿈
     *    ex) toBRString(str)
     * @param  String  str   : 입력 받은 스트링값
     * @return String  value  : 변환값
     *************************************************/
    public static String toBRString(String str) {
        String value = null;
        int i, len = str.length();
        StringBuffer dest = new StringBuffer(len);
        
        for (i = 0 ; i <= (len - 1); i++) {
            if     ( str.charAt(i) == ' ' )  dest.append("&nbsp;");
            else if( str.charAt(i) == '\n')  dest.append("<br/>");
            else                             dest.append(str.charAt(i));
        }
        value = dest.toString();
        return value;
    }
    public static String createEncStringV3(String cpId, String urlCode, String certNum, String date, String certMet, String name, String phoneNo, String phoneCorp, String birthDay, String gender, String nation, String plusInfo, String extendVar)
	{
		//01. �ѱ����������(��) ��ȣȭ ��� ����
		com.icert.comm.secu.IcertSecuManager seed  = new com.icert.comm.secu.IcertSecuManager();

		//02. 1�� ��ȣȭ (tr_cert �����ͺ��� ���� �� ��ȣȭ)
		String tr_cert       = "";
		String enc_tr_cert = "";
		tr_cert            = cpId +"/"+ urlCode +"/"+ certNum +"/"+ date +"/"+ certMet +"/"+ birthDay +"/"+ gender +"/"+ name +"/"+ phoneNo +"/"+ phoneCorp +"/"+ nation +"/"+ plusInfo +"/"+ extendVar;
		enc_tr_cert        = seed.getEnc(tr_cert, "");

		//03. 1�� ��ȣȭ �����Ϳ� ���� ������ ������ ���� (HMAC)
		String hmacMsg = "";
		hmacMsg = seed.getMsg(enc_tr_cert);

		//04. 2�� ��ȣȭ (1�� ��ȣȭ ������, HMAC ������, extendVar ���� �� ��ȣȭ)
		tr_cert  = seed.getEnc(enc_tr_cert + "/" + hmacMsg + "/" + extendVar, "");
		
		return  tr_cert;  
	}
    public static String f_get_parm( String val ){
        if ( val == null ) val = "";
        return  val;
      }
    /*************************************************
     * 14. �Է¹��� String�� ���ϴ� ���̸�ŭ ���ϴ� ���ڷ� �������� ä���ִ� �Լ�
     *    ex) RPAD('111',10,'0')
     * @param  String   str    : 8�ڸ� String Type�� �����
     * @param  int      len    : ���ϴ±���
     * @param  char     pad    : ä�﹮��
     * @return String   result : ������ ���ڷ� ä���� String
     *************************************************/
    static public String RPAD(String str, int len, char pad) {
        String result = str;
        int templen = len - result.getBytes().length;
        
        for (int i = 0; i < templen; i++) {
            result = result + pad;
        }
        
        return result;
    }

    /*************************************************
     * 15. �Է¹��� String�� ���ϴ� ���̸�ŭ ���ϴ� ���ڷ� ������ ä���ִ� �Լ�
     *    ex) LPAD('111',10,'0')
     * @param  String   str    : 8�ڸ� String Type�� �����
     * @param  int      len    : ���ϴ±���
     * @param  char     pad    : ä�﹮��
     * @return String   result : ������ ���ڷ� ä���� String
     *************************************************/
    static public String LPAD(String str, int len, char pad) {
        String result = str;
        int templen = len - result.getBytes().length;
        
        for (int i = 0; i < templen; i++)
            result = pad + result;
        
        return result;
    }
    
	/**
	 * 인자로 받은 old문자열을 new문자열로 대체한다<br>
	 * 대소문자를 구분하여 정확하게 일치하는 문자열만 대체한다<br>
	 * 예) replace("hello", "welcome", "Hello hello my house")<br>
	 * returns "Hello welcome my house"
	 * 
	 * @param oldStr - 대체될 문자열
	 * @param newStr - 대체할 문자열
	 * @param src - 원본 문자열
	 * @return  해당 문자열로 대체한 후의 새로운 문자열
	 */
	public static String replace(String oldStr, String newStr, String src){
		if(isEmptyString(oldStr) || isNull(newStr) || isEmptyString(src) )
			return "";
		String des = new String();
		int oldLen = oldStr.length();
		int start = 0;
		int end = 0;
		while( (end = src.indexOf(oldStr,start)) > -1){
			des = des.concat(src.substring(start, end));
			des = des.concat(newStr);
			start = end+oldLen;
		}
		des = des.concat(src.substring(start));
		return des;
	}
	
	/**
	 * 해당 문자가 null이거나 공백이면 true 아니면 false반환
	 * 
	 * @param str - 검사할 문자열
	 * @return 검사 결과 여부
	 */
	public static boolean isEmptyString(String str){
		return (str == null || "".equals(str)) ? true : false;
	}
	
	/**
	 * 해당 문자가 null인지만 검사하여 맞으면 true 아니면 false반환
	 * 
	 * @param str - 검사할 문자열
	 * @return 검사 결과 여부
	 */
	public static boolean isNull(String str){
		return (str == null) ? true : false;
	}
	
	public static String convertFileName(String filename, String uploadPath) {
		if(!"".equals(filename))
		{
			String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());  //현재시간
			int i = -1;
			i = filename.lastIndexOf("."); // 파일 확장자 위치
			String realFileName = now + filename.substring(i, filename.length()); // 현재시간과 확장자 합치기
			
			File oldFile = new File(uploadPath + filename);
			File newFile = new File(uploadPath + realFileName);
			oldFile.renameTo(newFile); // 파일명 변경
			
			return realFileName.toString();
		}
		else
		{
			return "";
		}
	}
	public static String convertFileName(String filename, String uploadPath, int seq) {
		if(!"".equals(filename))
		{
			String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());  //현재시간
			int i = -1;
			i = filename.lastIndexOf("."); // 파일 확장자 위치
			String realFileName = now + seq + filename.substring(i, filename.length()); // 현재시간과 확장자 합치기
			
			File oldFile = new File(uploadPath + filename);
			File newFile = new File(uploadPath + realFileName);
			oldFile.renameTo(newFile); // 파일명 변경
			
			return realFileName.toString();
		}
		else
		{
			return "";
		}
	}
	public static String getPageUrl2(HttpServletRequest request, String url,boolean bSecure)
    {
        // true : � , false : ����
        if(bSecure)
            return "http://culture.akplaza.com" + url;
        else
            return "http://tculture.akplaza.com" + url;
    }
}
