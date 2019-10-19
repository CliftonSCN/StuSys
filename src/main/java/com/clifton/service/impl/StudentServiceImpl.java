package com.clifton.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clifton.dao.StudentMapper;
import com.clifton.pojo.Student;
import com.clifton.redis.RedisHandle;
import com.clifton.service.StudentService;
import com.clifton.utils.ReadExcelUtils;

/**  
* @author Clifton  
* @date 2019年8月6日 上午9:16:07 
* @project stusys
*/
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	RedisHandle redisHandle;

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentMapper.selectAllWithClass();
	}

	@Override
	@Transactional
	@Async
	public void uploadExcelStu(String realpath, String newName) {
		Map<String, List<String>> map = ReadExcelUtils.readXlse(realpath+"\\"+newName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		redisHandle.set("uploadExcel", "50%", (long) 240);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Student> students = new ArrayList<Student>();
		try {
			List<String> nums = map.get("学号");
			List<String> names = map.get("姓名");
			List<String> phones = map.get("电话");
			List<String> emails = map.get("邮箱");
			List<String> genders = map.get("性别");
			redisHandle.set("uploadExcel", "70%", (long) 240);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < nums.size(); i++) {
				Student student = new Student();
				student.setStuNum(nums.get(i));
				student.setStuName(names.get(i));
				student.setStuPhone(phones.get(i));
				student.setStuEmail(emails.get(i));
				student.setStuGender(Integer.valueOf((String) genders.get(i).subSequence(0, 1)));
				students.add(student);
			}
			studentMapper.insertBatch(students);
		} catch (Exception e) {
			redisHandle.set("uploadExcel", "error", (long) 240);
			File file = new File(realpath+"\\"+newName);
			file.delete();
			throw e;
		}
		File file = new File(realpath+"\\"+newName);
		file.delete();
		redisHandle.set("uploadExcel", "100%", (long) 240);
	}
	
	@Override
	public String getUploadProcess() {
		String process = (String) redisHandle.get("uploadExcel");
		return process;
	}
	
	@Override
	public void delProcess() {
		redisHandle.remove("uploadExcel");
	}

	@Override
	public Student getStudentByNum(String num) {
		return studentMapper.selectByNum(num);
	}

	@Override
	public void delAll(ArrayList<String> stuNumList) {
		studentMapper.delAll(stuNumList);
		
	}

}
