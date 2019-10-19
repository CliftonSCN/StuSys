package com.clifton.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**  
* @author Clifton  
* @date 2019年8月18日 下午7:47:57 
* @project stusys
*/
public class MD5Util {
	
	public static String transfer(String str, String salt) {
		String hashAlgorithmName = "MD5";
        String credentials = str;
        int hashIterations = 1024;
        ByteSource credentialsSalt = null;
        if (salt != null) {
        	credentialsSalt = ByteSource.Util.bytes(salt);
		}
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        String result = obj.toString();
        return result;
	}

}
