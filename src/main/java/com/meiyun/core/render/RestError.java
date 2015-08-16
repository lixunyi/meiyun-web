package com.meiyun.core.render;

import java.io.Serializable;

/**
 * 系统错误码构件
 * 
 * @author Administrator
 *
 */
public class RestError implements Serializable {

	private static final long serialVersionUID = 8654305864803096100L;

	private int errorCode; // 错误码

	private String message; // 错误消息描述
	
	public RestError() {
		super();
	}

	/**
	 * 设置错误码
	 * 
	 * @param errorCodeList
	 */
	public RestError(ErrorCodeList errorCodeList) {
		this.setErrorCode(errorCodeList);
	}
	
	/**
	 * 设置错误码
	 * 
	 * @param errorCodeList
	 */
	public void setErrorCode(ErrorCodeList errorCodeList) {
		this.setErrorCode(errorCodeList.getCode());
		this.setMessage(errorCodeList.getMessage());
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
