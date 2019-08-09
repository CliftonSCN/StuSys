package com.clifton.service;
/**  
* @author Clifton  
* @date 2019年8月6日 上午9:15:13 
* @project stusys
*/

import java.util.List;

import com.clifton.pojo.Student;

public interface StudentService {
	
	List<Student> getAllStudent();

	void uploadExcelStu(String realpath, String newName);
	
	String getUploadProcess();

	void delProcess();

	Student getStudentByNum(String attribute);

}
