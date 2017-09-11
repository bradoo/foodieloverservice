package com.ibm.foodielover.common;

import java.io.Serializable;

public class JSONWrapper implements Serializable {
	
	private String code;
	
	private String error;
	
	private boolean success;
	
	private Object content;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

}
