package com.clifton.pojo;

import java.util.List;

public class Student {
    private Integer id;

    private String stuNum;

    private String stuName;

    private Integer stuGender;

    private Integer stuAge;

    private String stuPhone;

    private String stuEmail;

    private Class stuClass;
    
    private List<Score> scores;

	public Class getStuClass() {
		return stuClass;
	}

	public void setStuClass(Class stuClass) {
		this.stuClass = stuClass;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Integer getStuGender() {
        return stuGender;
    }

    public void setStuGender(Integer stuGender) {
        this.stuGender = stuGender;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail == null ? null : stuEmail.trim();
    }

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuNum=" + stuNum + ", stuName=" + stuName + ", stuGender=" + stuGender
				+ ", stuAge=" + stuAge + ", stuPhone=" + stuPhone + ", stuEmail=" + stuEmail + ", stuClass=" + stuClass
				+ ", scores=" + scores + "]";
	}

}