package com.clifton.pojo;

public class Appraise {
    private String stuId;

    private String tcId;

    private Double option1;

    private Double option2;

    private Double avg;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getTcId() {
        return tcId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId == null ? null : tcId.trim();
    }

    public Double getOption1() {
        return option1;
    }

    public void setOption1(Double option1) {
        this.option1 = option1;
    }

    public Double getOption2() {
        return option2;
    }

    public void setOption2(Double option2) {
        this.option2 = option2;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }
}