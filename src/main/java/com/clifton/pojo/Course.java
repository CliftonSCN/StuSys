package com.clifton.pojo;

public class Course {
    private Integer id;

    private String couresNum;

    private String courseName;

    private Integer tcId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCouresNum() {
        return couresNum;
    }

    public void setCouresNum(String couresNum) {
        this.couresNum = couresNum == null ? null : couresNum.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getTcId() {
        return tcId;
    }

    public void setTcId(Integer tcId) {
        this.tcId = tcId;
    }
}