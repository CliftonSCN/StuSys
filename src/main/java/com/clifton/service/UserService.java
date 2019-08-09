package com.clifton.service;

import com.clifton.dto.Response;
import com.clifton.pojo.User;

/**  
* @author Clifton  
* @date 2019年8月5日 下午7:57:46 
* @project stusys
*/
public interface UserService {

	Response judgeUserNameAndUserPassword(User user);
	
	Response insertAllStuIntoUser();

	void changePasswordByStuNum(String stuNum, String password) throws Exception;

}
