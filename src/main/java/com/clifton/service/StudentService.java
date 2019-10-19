package com.clifton.service;
/**  
* @author Clifton  
* @date 2019年8月6日 上午9:15:13 
* @project stusys
*/

import java.util.ArrayList;
import java.util.List;

import com.clifton.pojo.Student;

public interface StudentService {
	
	/**
	 * 获取全部学生信息
	 * @return
	 */
	List<Student> getAllStudent();

	/**
	 * 上传Excel文件，导入学生信息
	 * @param realpath
	 * @param newName
	 */
	void uploadExcelStu(String realpath, String newName);
	
	/**
	 * 从缓存中获取上传进度
	 * @return
	 */
	String getUploadProcess();

	/**
	 * 删除缓存中的上传进度
	 */
	void delProcess();

	/**
	 * 根据学号查询学生信息
	 * @param attribute
	 * @return
	 */
	Student getStudentByNum(String attribute);

	void delAll(ArrayList<String> stuNumList);

}
