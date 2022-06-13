package ak_web.initclass;

public class initClass {
	
	
	public static String getSESSION_DOMAIN() {
		return SESSION_DOMAIN;
	}
	
	
	
	public static String SESSION_DOMAIN = "SESSION_DOMAIN";  // 세션객체에 세션정보 저장시 사용하는 키
	public static String LEFT_MENU_LIST = "LEFT_MENU_LIST"; // 메뉴 리스트 저장
	public static String TOP_MENU_LIST = "TOP_MENU_LIST"; // 메뉴 리스트 저장
	public static String FILE_REQUEST = "FILE_REQUEST"; // FILE_REQUEST 
	public static String SESSION_MENU_GROUP = "SESSION_MENU_GROUP"; // menugroup 코드값 기억
	public static String SESSION_FORM = "SESSION_FORM"; // Request객체서 세션정보 저장시 사용하는  
	public static String REQUEST_URI = "REQUEST_URI"; // 서블릿 주소
	public static String RANDOM_SMS = "RANDOM_SMS"; // 서블릿 주소
}
