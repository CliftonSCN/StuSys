package stusys;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**  
* @author Clifton  
* @date 2019年8月16日 上午10:32:39 
* @project stusys
*/
public class MD5 {
	
	public static void main(String[] args) {
		String hashAlgorithmName = "MD5";
        String credentials = "123456";
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes("1610701120");
//        Object obj = new SimpleHash(hashAlgorithmName, credentials, "1610701120", hashIterations);
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, null, hashIterations);
//        System.out.println(obj);
        System.out.println(simpleHash.toString());
	}

}
