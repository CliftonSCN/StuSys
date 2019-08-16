package com.clifton.service;
/**  
* @author Clifton  
* @date 2019年8月15日 下午2:47:33 
* @project stusys
*/

import java.util.List;
import java.util.Map;

import com.clifton.dto.TeacherFin;
import com.clifton.pojo.Appraise;

public interface TeacherService {
	
	List<TeacherFin> getTeacherList(String stuNum);

	void saveAppraise(Map map, int id);

	Appraise getGradeById(String id);

}
