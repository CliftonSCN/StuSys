package com.clifton.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clifton.dto.Response;
import com.clifton.pojo.Student;
import com.clifton.service.StudentService;
import com.clifton.service.UserService;

/**  
* @author Clifton  
* @date 2019年8月7日 下午8:58:03 
* @project stusys
*/
@Controller
@RequestMapping("/stu")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserService userService;
	
	/**
	 * 个人信息页面跳转
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/home")
	public String toHome(Model model, HttpSession session) {
		Student student = studentService.getStudentByNum((String)session.getAttribute("userName"));
		model.addAttribute("student", student);
		return "stu/home";
	}
	
	/**
	 * 修改密码
	 * @param stuNum
	 * @param password
	 * @return
	 */
	@GetMapping("/changePassword")
	@ResponseBody
	public Response changePassword(@RequestParam("stuNum")String stuNum, @RequestParam("password")String password) {
		try {
			userService.changePasswordByStuNum(stuNum, password);
		} catch (Exception e) {
			return new Response().failure(e.getMessage());
		}
		return new Response().success("修改成功");
	}
	

}
