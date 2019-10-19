package com.clifton.dto;

import com.clifton.enums.SeckillStatEnum;
import com.clifton.pojo.SuccessKilled;

/** 
* 封装执行选课后的结果:是否选课成功 
* @author Clifton  
* @date 2019年8月6日 下午2:55:56 
* @project stusys
*/
public class SeckillExecution {

    private int electiveId;

    //选课执行结果的状态
    private int state;

    //状态的明文标识
    private String stateInfo;

    //当选课成功时，需要传递选课成功的对象回去
    private SuccessKilled successKilled;

    //选课成功返回所有信息
    public SeckillExecution(int electiveId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.electiveId = electiveId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
        this.successKilled = successKilled;
    }

    //选课失败
    public SeckillExecution(int electiveId, SeckillStatEnum statEnum) {
        this.electiveId = electiveId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
    }

    public int getElectiveId() {
        return electiveId;
    }

    public void setElectiveId(int electiveId) {
        this.electiveId = electiveId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}