package com.clifton.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.clifton.pojo.User;
import com.clifton.pojo.UserExample;

public interface UserMapper {
	
	User findUserByUserName(String userName);
	
	Set<String> findRoles(String userName);
	
	Set<String> findPermissions(String userName);
	
	int insertStuUserBatch(String password);
	
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	int updatePassword(@Param("stuNum")String stuNum, @Param("userPassword")String userPassword);
}