package com.clifton.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clifton.dto.Response;
import com.clifton.dto.TeacherFin;
import com.clifton.pojo.Student;
import com.clifton.service.StudentService;
import com.clifton.service.TeacherService;
import com.clifton.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**  
* @author Clifton  
* @date 2019年8月7日 下午8:58:03 
* @project stusys
*/
@Controller
@RequestMapping("/stu")
public class StudentController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getGrade")
	@ResponseBody
	public Response getGrade(String id) {
		Appraise appraise = teacherService.getGradeById(id);
		return null;
	}
	
	/**
	 * 原本已经在这里从数据库查出查询fin(学生是否评分)的值，但上一个页面已经查出，便重复利用
	 * @param id
	 * @param fin
	 * @param model
	 * @return
	 */
	@GetMapping("/toGrade")
	public String toGrade(@RequestParam("id")int id, @RequestParam("fin")int fin, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("fin", fin);
		return "stu/grade";
	}
	
	@GetMapping("/toAppraise")
	public String toAppraise() {
		return "stu/appraise";
	}
	
	@GetMapping("getTeachers")
	@ResponseBody
	public List<TeacherFin> getTeacher() {
		return teacherService.getTeacherList((String) SecurityUtils.getSubject().getPrincipal());
	}
	
	@PostMapping("/appraise")
	@ResponseBody
	public Response Appraise(@RequestParam("data") String data, @RequestParam("id") int id) {
		ObjectMapper om=new ObjectMapper();
		Map map = null;
		try {
			map = om.readValue(data, Map.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teacherService.saveAppraise(map,id);
		return new Response().success();
	}
	
	/**
	 * 个人信息页面跳转
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/home")
	public String toHome(Model model, HttpSession session) {
		String principal = (String) SecurityUtils.getSubject().getPrincipal();
		Student student = studentService.getStudentByNum(principal);
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
