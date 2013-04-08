package com.banshan.lifebarServer.action;

import com.banshan.lifebarServer.common.SystemStatic;

public class BaseJsonAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7984695489585545361L;
	private String message;
	private String result;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setFailMessage(String message) {
		this.message = message;
		this.result = "ERROR";
	}
	public void setSuccessMessage(String message) {
		this.message = message;
		this.result = "OK";
	}
	
	public String setFailCode(String code)
	{
		this.message = code;
		this.result = "ERROR";
		return SystemStatic.FAIL;
	}
	
}
