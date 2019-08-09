package com.clifton.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clifton.dto.Response;
import com.clifton.pojo.User;
import com.clifton.service.UserService;

/**  
* @author Clifton  
* @date 2019年8月5日 下午4:43:25 
* @project stusys
*/
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userservice;

	/**
	 * 登录
	 * @param user
	 * @param session
	 * @return
	 */
	@PostMapping("/login")
	@ResponseBody
	public Response login(User user, HttpSession session) {
		Response response = userservice.judgeUserNameAndUserPassword(user);
		if (response.getMeta().isSuccess()) {
			session.setAttribute("userName", user.getUserName());
		}
		return response;
	}

}
