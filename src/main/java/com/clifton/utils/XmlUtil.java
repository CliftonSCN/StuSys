package com.clifton.utils;
/**  
* @author Clifton  
* @date 2019年8月8日 下午5:23:51 
* @project stusys
*/
public class XmlUtil {
	
	public static boolean isNotEmpty(String string) {
		if (string == null || string.length() == 0) {
			return false;
		}
		return true;
	}

}
