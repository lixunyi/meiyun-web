package com.meiyun.commons.util;

import java.util.Random;
/**
 * @生成验证码字符串
 * @author Administrator
 * @date 2014-04-29
 */
public class SaltUtil {

	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String numberChar = "0123456789";

	/**
	 * 返回一个定长的随机字符串(只包含大小写字母、数字)
	 * 
	 * @param length 随机字符串长度
	 * @return 随机字符串
	 */
	public static String getRandomString(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(new Random().nextInt(allChar.length())));
		}
		return sb.toString();
	}

	/**
	 * 返回一个定长的随机纯字母字符串(只包含大小写字母)
	 * 
	 * @param length 随机字符串长度
	 * @return 随机字符串
	 */
	public static String getRandomMixString(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(new Random().nextInt(letterChar.length())));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		/*System.out.println(getRandomString(15));
		System.out.println(getRandomMixString(15));*/
	}
}