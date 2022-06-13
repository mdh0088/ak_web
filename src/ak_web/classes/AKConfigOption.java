package ak_web.classes;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

public class AKConfigOption {
	
	public static AKConfigOption instance = null;

	private static Hashtable<String, String> systemConfig = null;

	private AKConfigOption() {
		systemConfig = new Hashtable<String, String>();
		init();
	}

	public static synchronized AKConfigOption getInstance() {
		if (instance == null) {
			instance = new AKConfigOption();
		}
		return instance;
	}

	private void init() {
		setSystemXmlPropertyValue();
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

	public String getOptionValue(String key) {
		return systemConfig.get(key);
		
	}
}
