package com.clifton.dto;

/**
 * @author Clifton
 * @date 2019年8月15日 下午7:56:09
 * @project stusys
 */
public class TeacherFin {

	private String tcNum;
	private String tcName;
	private int fin;

	@Override
	public String toString() {
		return "TeacherFin [tcNum=" + tcNum + ", tcName=" + tcName + ", fin=" + fin + "]";
	}

	public String getTcNum() {
		return tcNum;
	}

	public void setTcNum(String tcNum) {
		this.tcNum = tcNum;
	}

	public String getTcName() {
		return tcName;
	}

	public void setTcName(String tcName) {
		this.tcName = tcName;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

}
