package com.clifton.dto;
/**  
* @author Clifton  
* @date 2019年8月6日 下午2:43:39 
* @project stusys
*/
public class Exposer {
	
	 // 是否开启秒杀
    private boolean exposed;

    // 加密措施
    private String md5;

    //id为seckillId的商品的秒杀地址
    private int electiveId;

    // 系统当前时间(毫秒)
    private long now;

    // 秒杀的开启时间
    private long start;

    // 秒杀的结束时间
    private long end;
    
    //当前学号
    private String stuNum;

    public Exposer(boolean exposed, String md5, int electiveId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.electiveId = electiveId;
    }
    
    public Exposer(boolean exposed, String md5, int electiveId, String stuNum) {
        this.exposed = exposed;
        this.md5 = md5;
        this.electiveId = electiveId;
        this.stuNum = stuNum;
    }

    public Exposer(boolean exposed, int electiveId, long now, long start, long end) {
        this.exposed = exposed;
        this.electiveId = electiveId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, int electiveId) {
        this.exposed = exposed;
        this.electiveId = electiveId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getElectiveId() {
        return electiveId;
    }

    public void setElectiveId(int electiveId) {
        this.electiveId = electiveId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	@Override
	public String toString() {
		return "Exposer [exposed=" + exposed + ", md5=" + md5 + ", electiveId=" + electiveId + ", now=" + now
				+ ", start=" + start + ", end=" + end + ", stuNum=" + stuNum + "]";
	}

}
