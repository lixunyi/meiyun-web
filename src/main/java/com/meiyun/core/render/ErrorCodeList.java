package com.meiyun.core.render;

/**
 * 错误代码清单
 * 
 * @url http://docs.apicloud.com/%E4%BA%91API/data-cloud-api#7
 * @author Administrator
 *
 */
public enum ErrorCodeList {

	ERROR_100(100, "操作失败"), 
	ERROR_101(101, "删除数据失败"), 
	ERROR_102(102, "参数错误"), 
	ERROR_103(103, "邮箱格式错误"),
	ERROR_104(104, "没有访问权限"), 
	ERROR_105(105, "验证签名失败"), 
	ERROR_106(106, "用户名或密码错误"), 
	ERROR_107(107, "数据查询失败"), 
	ERROR_108(108, "文件不存在"),
	ERROR_109(109, "用户名或密码错误");

	private int code;

	private String message;

	private ErrorCodeList(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
