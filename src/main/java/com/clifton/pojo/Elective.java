package com.clifton.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Elective {
    private Integer id;

    private String electiveName;

    private Integer stock;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date endTime;

    @Override
	public String toString() {
		return "Elective [id=" + id + ", electiveName=" + electiveName + ", stock=" + stock + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElectiveName() {
        return electiveName;
    }

    public void setElectiveName(String electiveName) {
        this.electiveName = electiveName == null ? null : electiveName.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}