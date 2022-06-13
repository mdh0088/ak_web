package ak_web.model.web;

public class AKVo implements java.io.Serializable {
	/**
     * AKVo�� ��ӹ޴� Vo Ŭ������ �ν��ϼ� ������/�̸��� String ���·� �����Ѵ�.
     *
     * @return    �ν��ϼ� ������/�̸��� Stringȭ�� ��ü
     */
 
	public String toString() {
		/*
		StringBuffer sb = new StringBuffer();
		try {
			BeanInfo info = Introspector.getBeanInfo(this.getClass(), AKVo.class);			
			
			PropertyDescriptor[] pd = info.getPropertyDescriptors();
			sb.append("\n******************** " + this.getClass().getName() + " ********************\n");
			for ( int i = 0; i < pd.length; i++ ) {
				sb.append("* " + pd[i].getName() + "\t = " + pd[i].getValue(pd[i].getName()) + "\n");
			}
			sb.append("*********************************************************************\n");
			//return sb.toString();
		} catch ( IntrospectionException ine ) {
			ine.printStackTrace();
		}
		*/
		//return sb.toString();
		return "";
	}
}