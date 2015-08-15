package com.meiyun.commons.validate;

import java.util.regex.Pattern;

public class Validator {
	
	private final static String NAME = "^[a-z0-9A-Z][a-z0-9A-Z\\.\\-\\_]+[a-z0-9A-Z]$";
	
	// 手机号码表达式
	private final static String MOBILE = "^1[3, 4, 5, 8][0-9]{9}$";
	
	// 邮箱表达式
	private final static String EMAIL = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	
	/**
	 * @验证名称
	 * @param value
	 * @return
	 */
	public static boolean isName(String name) {
		boolean flag = false;
		try {
			flag = Pattern.compile(NAME).matcher(name).matches();
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	
	/**
	 * @验证手机号
	 * @param value
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		boolean flag = false;
		try {
			flag = Pattern.compile(MOBILE).matcher(mobile).matches();
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	
	/**
	 * @验证邮箱号
	 * @param value
	 * @return
	 */
	public static boolean isEmail(String email) {
		boolean flag = false;
	    try{
		    flag = Pattern.compile(EMAIL).matcher(email).matches();
	    }catch(Exception e){
	    	flag = false;
	    }
	    
	    return flag;
	}


}
