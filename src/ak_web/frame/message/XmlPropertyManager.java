package ak_web.frame.message;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;


import ak_web.classes.Utils;

/**
 * Created by IntelliJ IDEA. User: hmlee Date: 2008. 9. 29 Time: 오전 11:17:02 To
 * change this template use File | Settings | File Templates. 다큐멘텀 dfc
 * properties 서버정보를 가져오기 위한 클래스
 */

public class XmlPropertyManager {

	public static XmlPropertyManager instance = null;

	private static Hashtable<String, String> systemConfig = null;

	private static Hashtable<String, String> applicationMessage = null;

	private XmlPropertyManager() {
		systemConfig = new Hashtable<String, String>();
		applicationMessage = new Hashtable<String, String>();
		init();
	}

	private static synchronized XmlPropertyManager getInstance() {
		if (instance == null) {
			instance = new XmlPropertyManager();
		}
		return instance;
	}

	private void init() {
		setSystemXmlPropertyValue();
		setApplicatonXmlPropertyValue();
	}

	private void setSystemXmlPropertyValue() {
		Properties properties = new Properties();

		try {
			InputStream xmlStream = getClass().getResourceAsStream(
					"/com/ams/properties/SystemConfig.xml");
			if (xmlStream == null) {
				// throw some error
			}
			properties.loadFromXML(xmlStream);
			Enumeration keys = properties.propertyNames();

			properties.list(System.out);

			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				String value = properties.getProperty(key);
				systemConfig.put(key, value);
			}
		} catch (IOException exception) {
			exception.printStackTrace();
			// throw exception
		}
	}

	private void setApplicatonXmlPropertyValue() {
		Properties properties = new Properties();

		try {
			InputStream xmlStream = getClass().getResourceAsStream(
					"/com/ams/properties/ApplicationMessage.xml");
			if (xmlStream == null) {
				// throw some error
			}
			properties.loadFromXML(xmlStream);
			Enumeration keys = properties.propertyNames();

			properties.list(System.out);

			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				String value = properties.getProperty(key);
				applicationMessage.put(key, value);
			}
		} catch (IOException exception) {
			exception.printStackTrace();
			// throw exception
		}
	}

	private String getSystemValue(String key) {
		return systemConfig.get(key);
	}

	private String getApplicationValue(String key) {
		return applicationMessage.get(key);
	}

	public static String getSystemProperty(String strKey) {
		XmlPropertyManager systemProper = XmlPropertyManager.getInstance();
		
		String strValue = systemProper.getSystemValue(strKey);
		if (strValue == null) {
			strValue = "입력하신 키값이 존재하지 않습니다.";
		} 
		return strValue;
	}

	
	
	public static String getMessageProperty(String strKey) {
		XmlPropertyManager applicationProper = XmlPropertyManager.getInstance();
		
		String strValue = applicationProper.getApplicationValue(strKey);
		if (strValue == null) {
			strValue = "입력하신 키값이 존재하지 않습니다.";
		} 
		return strValue;
	}

	public static String getMessageProperty(String strKey, String arg1) {
		XmlPropertyManager applicationProper = XmlPropertyManager.getInstance();
		String strValue = applicationProper.getApplicationValue(strKey);
		if (strValue == null) {
			strValue = "입력하신 키값이 존재하지 않습니다.";
		} else {
			strValue = Utils.replace("{1}", arg1, strValue);
		}
		return strValue;
	}

	public static String getMessageProperty(String strKey, String arg1,
			String arg2) {
		XmlPropertyManager applicationProper = XmlPropertyManager.getInstance();
		String strValue = applicationProper.getApplicationValue(strKey);
		if (strValue == null) {
			strValue = "입력하신 키값이 존재하지 않습니다.";
		} else {
			strValue = Utils.replace("{1}", arg1, strValue);
			strValue = Utils.replace("{2}", arg2, strValue);
		}
		return strValue;
	}

	public static String getMessageProperty(String strKey, String arg1,
			String arg2, String arg3) {
		XmlPropertyManager applicationProper = XmlPropertyManager.getInstance();
		String strValue = applicationProper.getApplicationValue(strKey);
		if (strValue == null) {
			strValue = "입력하신 키값이 존재하지 않습니다.";
		} else {
			strValue = Utils.replace("{1}", arg1, strValue);
			strValue = Utils.replace("{2}", arg2, strValue);
			strValue = Utils.replace("{3}", arg3, strValue);
		}
		return strValue;
	}

}
