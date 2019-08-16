package com.clifton.service;

import java.util.Set;

import com.clifton.dto.Response;
import com.clifton.pojo.User;

/**  
* @author Clifton  
* @date 2019年8月5日 下午7:57:46 
* @project stusys
*/
public interface UserService {

	/**
	 * 判断登录信息，返回验证结果
	 * @param user
	 * @return
	 */
	Response judgeUserNameAndUserPassword(User user);
	
	/**
	 * 将所有学生的学号设为用户名，密码为123456，角色为学生
	 * @return
	 */
	Response insertAllStuIntoUser();

	void changePasswordByStuNum(String stuNum, String password) throws Exception;

	User findUserByUsername(String username);

	Set<String> findPermissions(String username);

	Set<String> findRoles(String username);

}
