package com.clifton.service;

import java.util.List;

import com.clifton.dto.Exposer;
import com.clifton.dto.SeckillExecution;
import com.clifton.exception.RepeatKillException;
import com.clifton.exception.SeckillCloseException;
import com.clifton.exception.SeckillException;
import com.clifton.pojo.Elective;

/**  
* @author Clifton  
* @date 2019年8月6日 下午2:40:04 
* @project stusys
*/
public interface ElectiveService {
	
	/**
     * 查询全部的选课记录
     * 
     * @return
     */
    List<Elective> getElectiveList(String order);

    /**
     * 查询单个选课记录
     * 
     * @param seckillId
     * @return
     */
    Elective getById(int id);

    /**
     * 在选课开启时输出选课接口的地址，否则输出系统时间和选课时间
     * 
     * @param id 选课Id
     * @return 根据对应的状态返回对应的状态实体
     */
    Exposer exportSeckillUrl(int id);

    /**
     * 执行选课操作，有可能失败，有可能成功，所以要抛出我们允许的异常
     * 
     * @param seckillId 选课ID
     * @param md5 md5加密值
     * @return 根据不同的结果返回不同的实体信息
     */
    SeckillExecution executeSeckill(int id, int stuNum, String md5) throws SeckillException,
            RepeatKillException, SeckillCloseException;

}
