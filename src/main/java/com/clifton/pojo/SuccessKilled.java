package com.clifton.pojo;

import java.util.Date;

public class SuccessKilled {
    private String stuNum;

    private Integer electiveId;

    private Date successTime;

    private Byte state;
    
    private Elective elective;

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public Integer getElectiveId() {
        return electiveId;
    }

    public void setElectiveId(Integer electiveId) {
        this.electiveId = electiveId;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

	public Elective getElective() {
		return elective;
	}

	public void setElective(Elective elective) {
		this.elective = elective;
	}
}