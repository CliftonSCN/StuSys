package com.clifton.dao;

import com.clifton.pojo.Appraise;
import com.clifton.pojo.AppraiseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppraiseMapper {
    long countByExample(AppraiseExample example);

    int deleteByExample(AppraiseExample example);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    List<Appraise> selectByExample(AppraiseExample example);

    int updateByExampleSelective(@Param("record") Appraise record, @Param("example") AppraiseExample example);

    int updateByExample(@Param("record") Appraise record, @Param("example") AppraiseExample example);
}