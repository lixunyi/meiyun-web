package com.meiyun.core.render;

import java.io.Serializable;

/**
 * 系统响应结果构件
 * 
 * @author Administrator
 *
 */
public class RestContext implements Serializable {

	private static final long serialVersionUID = -2359614821187369756L;

	private boolean success = Boolean.TRUE; // 请求是否成功

	private RestError error; // 错误消息

	private Object result; // 结果集

	public boolean isSuccess() {
		return success;
	}

	/**
	 * 当设置是否成功时，会自动清除相应的数据信息
	 * @param success
	 */
	public void setSuccess(boolean success) {
		this.clear();
		this.success = success;
	}

	public RestError getError() {
		return error;
	}
	
	/**
	 * 当设置错误代码时，必须为错误的响应
	 * @param errorCodeList
	 */
	public void setError(ErrorCodeList errorCodeList) {
		this.setSuccess(Boolean.FALSE);
		this.error = new RestError(errorCodeList);
	}

	public Object getResult() {
		return result;
	}

	/**
	 * 当设置结果集时，必须为成功的响应
	 * @param result
	 */
	public void setResult(Object result) {
		this.setSuccess(Boolean.TRUE);
		this.result = result;
	}
	
	/**
	 * 清除数据: 成功=则清除错误消息,反之清除结果集
	 */
	private void clear() {
		if (success) {
			this.error = null;
		} else {
			this.result = null;
		}
	}

}
