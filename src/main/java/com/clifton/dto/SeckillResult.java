package com.clifton.dto;

/**
 * 将所有的ajax请求返回类型，全部封装成json数据
 * 
 * @author Clifton
 * @date 2019年8月6日 下午4:34:26
 * @project stusys
 */
public class SeckillResult<T> {

	// 请求是否成功
	private boolean success;
	private T data;
	private String error;

	public SeckillResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public SeckillResult(boolean success, String error) {
		this.success = success;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
