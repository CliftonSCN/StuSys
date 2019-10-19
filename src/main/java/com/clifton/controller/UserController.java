package com.clifton.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/login.jsp";
	}

	/**
	 * 登录
	 * @param user
	 * @param session
	 * @return
	 */
	@PostMapping("/login")
	@ResponseBody
	public Response login(User user, HttpSession session) {
		Subject subject = SecurityUtils.getSubject() ;
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getUserPassword()) ;
		try {
		subject.login(token);
		return new Response().success();
		}catch (UnknownAccountException e){
		//这里将异常打印关闭是因为如果登录失败的话会自动抛异常
			return new Response().failure("用户名不存在");
		}catch (IncorrectCredentialsException e) {
			return new Response().failure("密码错误");
		}catch (Exception e) {
			e.printStackTrace();
			return new Response().failure("登录失败");
		}
		
	}
	
	@RequestMapping("/welcome")
	public String toWelcome() {
//		org.apache.shiro.web.session.HttpServletSession.HOST_SESSION_KEY:1610701120
		return "welcome";
	}

}
