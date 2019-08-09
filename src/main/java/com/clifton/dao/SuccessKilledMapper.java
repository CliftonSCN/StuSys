package com.clifton.dao;

import com.clifton.pojo.SuccessKilled;
import com.clifton.pojo.SuccessKilledExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuccessKilledMapper {
	
	
	int insertSuccessKilled(@Param("electiveId") int electiveId, @Param("stuNum") int stuNum, @Param("successTime")Date successTime);
	
	SuccessKilled queryByIdWithElective(@Param("stuNum") int stuNum);
	
	
    long countByExample(SuccessKilledExample example);

    int deleteByExample(SuccessKilledExample example);

    int deleteByPrimaryKey(String stuNum);

    int insert(SuccessKilled record);

    int insertSelective(SuccessKilled record);

    List<SuccessKilled> selectByExample(SuccessKilledExample example);

    SuccessKilled selectByPrimaryKey(String stuNum);

    int updateByExampleSelective(@Param("record") SuccessKilled record, @Param("example") SuccessKilledExample example);

    int updateByExample(@Param("record") SuccessKilled record, @Param("example") SuccessKilledExample example);

    int updateByPrimaryKeySelective(SuccessKilled record);

    int updateByPrimaryKey(SuccessKilled record);
}