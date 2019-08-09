package com.clifton.dao;

import com.clifton.pojo.Elective;
import com.clifton.pojo.ElectiveExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElectiveMapper {
	
	
	int reduceNumber(@Param("electiceId")int electiceId, @Param("killTime") Date killTime);
	
	Elective queryById(int electiceId);
	
	List<Elective> queryAll(@Param("order")String order);
	
	
    long countByExample(ElectiveExample example);

    int deleteByExample(ElectiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Elective record);

    int insertSelective(Elective record);

    List<Elective> selectByExample(ElectiveExample example);

    Elective selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Elective record, @Param("example") ElectiveExample example);

    int updateByExample(@Param("record") Elective record, @Param("example") ElectiveExample example);

    int updateByPrimaryKeySelective(Elective record);

    int updateByPrimaryKey(Elective record);
}