package com.clifton.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.clifton.dao.association;
import com.clifton.dao.c;
import com.clifton.dao.foreach;
import com.clifton.dao.from;
import com.clifton.dao.id;
import com.clifton.dao.insert;
import com.clifton.dao.resultMap;
import com.clifton.dao.t_class;
import com.clifton.dao.where;
import com.clifton.dto.Response;
import com.clifton.pojo.Student;
import com.clifton.service.StudentService;
import com.clifton.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author Clifton
 * @date 2019年8月6日 上午9:13:54
 * @project stusys
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	int insertBatch(List<Student> students);

	Student selectByNum(String num);
	
	List<Student> selectAllWithClass();
	
	<resultMap id="ResultMapWithClass" type="com.clifton.pojo.Student">
    <id column="id" jdbcType="INTEGER" property="id" />
    <result column="stu_num" jdbcType="VARCHAR" property="stuNum" />
    <result column="stu_name" jdbcType="VARCHAR" property="stuName" />
    <result column="stu_gender" jdbcType="INTEGER" property="stuGender" />
    <result column="stu_age" jdbcType="INTEGER" property="stuAge" />
    <result column="stu_phone" jdbcType="VARCHAR" property="stuPhone" />
    <result column="stu_email" jdbcType="VARCHAR" property="stuEmail" />
    <association property="stuClass" column="class_id" javaType="com.clifton.pojo.Class">
    	<id column="id" jdbcType="INTEGER" property="id" />
    	<result column="class_name" jdbcType="VARCHAR" property="className" />
    </association>
  </resultMap>
  <select id="selectByNum" parameterType="java.lang.String" resultMap="ResultMapWithClass">
	select * from t_student s, t_class c
	where s.class_id = c.id and s.stu_num = #{num}
</select>
<select id="selectAllWithClass" resultMap="ResultMapWithClass">
	select * from t_student s, t_class c
	where s.class_id = c.id
</select>
	 <insert id="insertBatch" parameterType="java.util.List">
		insert into t_student(stu_num, stu_name, stu_gender, stu_email, stu_phone) values
		<foreach collection="list" item="stu" separator=",">
			(
				#{stu.stuNum},
				#{stu.stuName},
				#{stu.stuGender},
				#{stu.stuEmail},
				#{stu.stuPhone}
			)
		</foreach>
	</insert>
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//分页显示每页数量
	private final static int PAGESIZE = 5;

	@Autowired
	StudentService studentService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/importStuBatch")
	@ResponseBody
	public Response importStuBatch() {
		//批量插入学生到用户表，密码默认为123456
		userService.insertAllStuIntoUser();
		logger.info("---------任务完成------------------");
		return new Response().success("任务完成");
	}
	
	@GetMapping("/getProcess")
	@ResponseBody
	public String getProcess() {
		//获取批量插入学生的进度
		return studentService.getUploadProcess();
	}
	
	@DeleteMapping("/delProcess")
	@ResponseBody
	public Response delProcess() {
		//删除缓存中插入进度
		studentService.delProcess();
		return new Response().success("录入成功");
	}
	
	@PostMapping("/uploadExcel")
	@ResponseBody
	public Response uploadExcel(MultipartFile file, HttpServletRequest request) {
		Response response = new Response();
		//获取文件存储绝对路径
		String realpath = request.getServletContext().getRealPath("uploadfiles/stu");
		//获取文件名
		String fileName = file.getOriginalFilename();
		//修改文件名
		String newName = UUID.randomUUID().toString().substring(2, 12)+fileName;
		File targetFile = new File(realpath, newName);
		//检查路径是否存在
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			//开始传输
			file.transferTo(targetFile);
			//开始解析excel文件并导入学生，异步执行
			studentService.uploadExcelStu(realpath, newName);
			//先返回结果
			response.success("录入中");
		} catch (IllegalStateException e) {
			response.failure("稍后再试");
			e.printStackTrace();
		} catch (IOException e) {
			response.failure("服务器异常");
			e.printStackTrace();
		}
		return response;
	}

	@GetMapping("/stuList")
	public ModelAndView stuList(@RequestParam(name="pn", defaultValue="0")int pn, ModelAndView mv) {
		//分页
		PageHelper.startPage(pn, PAGESIZE);
		List<Student> student = studentService.getAllStudent();
		PageInfo<Student> pageInfo = new PageInfo<>(student, 5);
		mv.setViewName("admin/stuList");
		mv.addObject("pageInfo", pageInfo);
		return mv;
	}

}
