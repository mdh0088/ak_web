package ak_web.classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
import nets.websso.ssoclient.authcheck.AuthStatus;

public class AKAccessRestrictUtil {	
	
    protected Logger log = Logger.getLogger(this.getClass());
	public static AKAccessRestrictUtil instance = null;

	private static List<Map<String, Object>> xmlURLTypeLi = null; //접근제한 데이터 URL타입 저장용
	private static List<Map<String, Object>> xmlSATypeLi = null; //접근제한 데이터 스크립트 A타입 저장용
	private static List<Map<String, Object>> xmlSBTypeLi = null; //접근제한 데이터 스크립트 B타입 저장용

	private AKAccessRestrictUtil() {	    
		init();
	}

	public static synchronized AKAccessRestrictUtil getInstance() {
		if (instance == null) {
			instance = new AKAccessRestrictUtil();
		}
		return instance;
	}
	
	private void init() {
	    xmlURLTypeLi = new Vector<Map<String, Object>>();
        xmlSATypeLi = new Vector<Map<String, Object>>();
        xmlSBTypeLi = new Vector<Map<String, Object>>();
        
		setXmlPropertyValue();
	}

	/**
	 * xml 파일을 파싱하여 key, value 형태로 데이터 저장처리
	 */
	private void setXmlPropertyValue() {
		Properties properties = new Properties();

		try {
			InputStream xmlStream = getClass().getResourceAsStream(
					"/ak_web/properties/AccessRestrictConfig.xml");
			if (xmlStream == null) {
				// throw some error
			    log.error(">>>>>>>>>>> [Error] setXmlPropertyValue xmlStream=" + xmlStream);
			}
			properties.loadFromXML(xmlStream);
			Enumeration keys = properties.propertyNames();

			properties.list(System.out);

			String key = "";
			String value = "";
			while (keys.hasMoreElements()) {
				key = (String) keys.nextElement();
				value = properties.getProperty(key);
								
				if(key.indexOf("URL_TYPE") != -1) {
                    xmlURLTypeLi.add(splitUrlParam(value));
                }
				//스크립트 A방식 데이터 저장
				else if(key.indexOf("SA_TYPE") != -1) {
				    xmlSATypeLi.add(splitUrlParam(value));
				}
				//스크립트 B방식 데이터 저장
				else if(key.indexOf("SB_TYPE") != -1) {
				    xmlSBTypeLi.add(splitUrlParam(value));
				}
			}
//			log.info(">>>>>>>>>>> setXmlPropertyValue xmlURLTypeLi=" + xmlURLTypeLi);
//			log.info(">>>>>>>>>>> setXmlPropertyValue xmlSATypeLi=" + xmlSATypeLi);
//			log.info(">>>>>>>>>>> setXmlPropertyValue xmlSBTypeLi=" + xmlSBTypeLi);
		} catch (IOException exception) {
			exception.printStackTrace();
			// throw exception
		}
	}

	private Map<String, Object> splitUrlParam(String sFullUrl) {
	    Map<String, Object> returnMp = new HashMap<String, Object>();
	    String sUrl = ""; //url 부분
	    Map<String, String> paramMp = null; //파라미터 부분
	    
	    //입력된 url정보가 존재하는 경우 파싱
        if(sFullUrl != null && sFullUrl.length() > 0) {
            
            //url 부분과 파라미터 부분 분리
            String[] arrUrlElement = sFullUrl.split("\\?");
            sUrl = arrUrlElement[0]; //url 부분
            if(arrUrlElement.length > 1) {
                //파라미터를 &기준으로 분리
                String[] arrParamElement = arrUrlElement[1].split("\\&");
                
                paramMp = new HashMap<String, String>();
                for(int i=0; i<arrParamElement.length; i++) {
                    //개별 파라미터를 변수를 key로 값을 value에 Map 자료형으로 저장
                    String[] arrParamData = arrParamElement[i].split("\\=");
                    
                    //개별 파라미터의 값이 있는지 확인 
                    if(arrParamData != null && arrParamData.length == 2) {
                        
                        //개별 파라미터의 변수명이 있는지 확인
                        if(arrParamData[0] != null && arrParamData[0].length() > 0) {
                            paramMp.put(arrParamData[0],arrParamData[1]);
                        }
                    }
                }               
            }

            returnMp.put("url", sUrl);
            returnMp.put("param", paramMp);            
//            log.info(">>>>>>>>>>> splitUrlParam returnMp=" + returnMp);
        }
        else {
            log.error(">>>>>>>>>>> [비교대상 url 정보 미존재] sFullUrl=[" + sFullUrl + "]");
        }
        return returnMp;
	}
	
    public String getProcessResult(String sInputFullUrl, String memType, String procMethod) {
        String returnFlag = "Pass"; //기존처리방식 유지
        log.info(">>>>>>>>>>>[START] AKAccessRestrictUtil getProcessResult() <<<<<<<<<<<<<<<<<");
        
        //입력url과 접근제한url정보를 비교하여 결과를 리턴
        String accessRestrictResult = getAccessRestrictResult(sInputFullUrl, procMethod);
        log.info(">>>>>>>>>>> getProcessResult accessRestrictResult=" + accessRestrictResult);
        
        //접근제한 url인 경우
        if("A".equals(accessRestrictResult)) {
            //회원구분이 간편회원인 경우
            if("S".equals(memType)) {
                returnFlag = "S-LyPop"; //간편회원-레이어 팝업을 실행
            }
            else if("T".equals(memType)) {
                returnFlag = "T-Pass"; //통합회원-기존처리방식 유지
            }
        }
        
        log.info(">>>>>>>>>>>[END] getProcessResult memType=" + memType + ", procMethod=" + procMethod + ", returnFlag=" + returnFlag);
        return returnFlag;
    } 
	
	/**
     * 입력url과 접근제한url정보를 비교하여 결과를 리턴하는 메소드
     * 
     * @param sInputFullUrl
     * @return
     */
    private String getAccessRestrictResult(String sInputFullUrl, String procMethod) {
        String sResult = "";
        
        //파싱된 데이터 저장유무 확인
        chkXmlPropertyValue();
        
        //입력url과 파라미터 정보를 Map의 {url=xxxxx, param={method=xxx, hq=00}} 형태로 저장
        Map<String, Object> inputFullUrlInfoMp = splitUrlParam(sInputFullUrl);
        log.info(">>>>>>>>>>> getAccessRestrictResult inputFullUrlInfoMp=" + inputFullUrlInfoMp);
        log.info(">>>>>>>>>>> getAccessRestrictResult procMethod=" + procMethod);
                
        //입력 url, 입력 파라미터 저장
        String sInputUrl = (String)inputFullUrlInfoMp.get("url");
        Map<String, String> inputParamMp = (Map<String, String>)inputFullUrlInfoMp.get("param");
        
        //처리방식별 xml 데이터 선택
        List<Map<String, Object>> xmlDataLi = null;
        if("SA".equals(procMethod)) {
            xmlDataLi = xmlSATypeLi;
        }
        else if("SB".equals(procMethod)) {
            xmlDataLi = xmlSBTypeLi;
        }
        else {
            xmlDataLi = xmlURLTypeLi;
        }
                
        //접근제한 url정보와 입력된 url정보를 비교하여 결과를 리턴(A:접근제한, P:Pass)
        Set xmlKey = null;
        String sXmlKeyName = "";
        String sXmlValueName = "";        
        Map<String, Object> xmlTypeMp = null;
        log.info(">>>>>>>>>>> getAccessRestrictResult 접근제한 url정보 xmlDataLi=" + xmlDataLi);
        for(int i=0; i<xmlDataLi.size(); i++) {
            xmlTypeMp = xmlDataLi.get(i);
            
            String sXmlUrl = (String)xmlTypeMp.get("url");
            Map<String, String> xmlParamMp = (Map<String, String>)xmlTypeMp.get("param");
            log.info(">>>>>>>>>>> getAccessRestrictResult 접근제한 url정보 sXmlUrl=" + sXmlUrl + ", xmlParamMp=" + xmlParamMp);
            
            //기준 url과 입력 url이 동일한 경우
            if(sXmlUrl.equals(sInputUrl)) {
                log.info(">>>>>>>>>>> getAccessRestrictResult 기준 url과 입력 url이 동일한 경우");
                
                //기준 파라미터가 존재할 경우 처리
                if(xmlParamMp != null && !xmlParamMp.isEmpty()) {
                    log.info(">>>>>>>>>>> getAccessRestrictResult 기준 파라미터가 존재");
                    
                    xmlKey = xmlParamMp.keySet();
                    for(Iterator iterator = xmlKey.iterator(); iterator.hasNext();) {
                        sXmlKeyName = (String) iterator.next();
                        sXmlValueName = (String) xmlParamMp.get(sXmlKeyName);
                        log.info(">>>>>>>>>>> getAccessRestrictResult sXmlKeyName=" + sXmlKeyName + ", sXmlValueName=" + sXmlValueName);
                        
                        //입력 파라미터가 존재하고, 기준 변수명과 값이 입력 변수명과 값이 동일한지 체크 
                        if(inputParamMp != null && !inputParamMp.isEmpty() && sXmlValueName.equals(inputParamMp.get(sXmlKeyName))) {
                            log.info(">>>>>>>>>>> getAccessRestrictResult 입력 파라미터가 존재하고, 기준 변수명과 값이 입력 변수명과 값이 동일");
                            sResult = "A"; //접근제한 URL(기준 url과 입력 url이 동일하고 기준 파라미터와 입력 파라미터가 동일)
                        }
                        else {
                            log.info(">>>>>>>>>>> getAccessRestrictResult 입력 파라미터가 존재하고, 기준 변수명과 값이 입력 변수명과 값이 동일하지 않음");
                            sResult = "P";
                            break;
                        }
                    }
                    
                    //기준 변수명과 값이 입력 변수명과 값이 동일하면 리턴
                    if("A".equals(sResult)) {
                        log.info(">>>>>>>>>>> getAccessRestrictResult 기준 변수명과 값이 입력 변수명과 값이 동일하면 리턴");
                        return sResult;
                    }
                }
                //기준 파라미터가 존재하지 않을 경우 처리
                else {
                    log.info(">>>>>>>>>>> getAccessRestrictResult 기준 파라미터가 존재하지 않음");
                    return sResult = "A"; //접근제한 URL(기준 url과 입력 url이 동일하고 기준 파라미터가 없는 경우)
                }
            }
            //기준 url과 입력 url이 동일하지 않은 경우
            else {
                log.info(">>>>>>>>>>> getAccessRestrictResult 기준 url과 입력 url이 동일하지 않은 경우");
                sResult = "P";
            }
        }
        
        log.info(">>>>>>>>>>> getAccessRestrictResult 최종 결과 리턴 sResult=" + sResult);
        return sResult;        
    }
    
	/**
	 * xml 파일을 파싱하여 key, value 형태로 데이터 저장되어 있는지 확인하여
	 * 1개라도 안되어 있으면 전체 초기화 후 init() 호출
	 */
	private void chkXmlPropertyValue() {	    
	    if (xmlURLTypeLi == null || xmlURLTypeLi.isEmpty() 
	            || xmlSATypeLi == null || xmlSATypeLi.isEmpty() 
	            || xmlSBTypeLi == null || xmlSBTypeLi.isEmpty()) {
	        log.error("xmlURLTypeLi 또는 xmlSATypeLi 또는 xmlSBTypeLi 에 데이터 미존재! xmlURLTypeLi=["+xmlURLTypeLi+"], xmlSATypeLi=["+xmlSATypeLi+"], xmlSBTypeLi=["+xmlSBTypeLi+"]");
	        xmlURLTypeLi = null;
	        xmlSATypeLi = null;
	        xmlSBTypeLi = null;
	        init();
        }
    }
    
}
