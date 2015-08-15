package com.meiyun.model.core;

import java.io.Serializable;
import java.util.Map;

/**
 * @class 上下文设置组件
 * @author sion.qi
 * @date 2014-02-01
 */
public class Context implements Serializable {

	private static final long serialVersionUID = 1L;

	// 设置页面元信息
	private String title;
	private String description;
	private String labels;

	// 设置成功反回对象
	private Object result;

	// 设置响应信息
	private String message;

	// 是否成功
	private boolean success = true;

	// 支持自定义添加其他属性
	private Map<String, Object> map;

	public Context() {
		super();
	}

	/**
	 * @method 如果success标识为false，则不输出result对象
	 * @return
	 */
	public Object getResult() {
		return success ? result: null;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

}