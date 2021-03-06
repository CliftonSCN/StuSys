package com.clifton.dao;

import com.clifton.pojo.Student;
import com.clifton.pojo.StudentExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
	
	int insertBatch(List<Student> students);

	Student selectByNum(String num);
	
	List<Student> selectAllWithClass();
	
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String stuNum);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(String stuNum);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

	void delAll(@Param("stuNumList")ArrayList<String> stuNumList);
}