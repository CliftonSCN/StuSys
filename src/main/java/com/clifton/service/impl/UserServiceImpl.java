package com.clifton.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clifton.dao.UserMapper;
import com.clifton.dto.Response;
import com.clifton.pojo.User;
import com.clifton.pojo.UserExample;
import com.clifton.pojo.UserExample.Criteria;
import com.clifton.service.UserService;

/**  
* @author Clifton  
* @date 2019年8月5日 下午7:59:56 
* @project stusys
*/
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public Response judgeUserNameAndUserPassword(User user) {
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserNameEqualTo(user.getUserName());
		List<User> list = userMapper.selectByExample(example);
		if (list.size() == 0) {
			return new Response().failure("用户不存在");
		}
		if (list.get(0).getUserPassword().equals(user.getUserPassword())) {
			return new Response().success();
		}else {
			return new Response().failure("密码错误");
		}
	}

	@Override
	public Response insertAllStuIntoUser() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		userMapper.insertStuUserBatch();
		return new Response().success();
	}

	@Override
	public void changePasswordByStuNum(String stuNum, String password) throws Exception {
		int updateRow = userMapper.updatePassword(stuNum, password);
		if (updateRow < 1) {
			throw new Exception("更新失败");
		}
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findUserByUserName(username);
	}

	@Override
	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return userMapper.findPermissions(username);
	}

	@Override
	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return userMapper.findRoles(username);
	}

}
