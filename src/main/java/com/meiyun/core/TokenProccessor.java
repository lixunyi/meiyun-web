package com.meiyun.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

/**
 * 会话随机数生成器<br>
 * 保证随机数的唯一性，所有随机数都由这一对象产生
 * @author Administrator
 *
 */
public class TokenProccessor {

	//1.把构造函数私有  
    //2.自己创建一个类的对象  
    //3.提供方法获取类的对象 
	private TokenProccessor() {}
	
	private static TokenProccessor instance = new TokenProccessor();
	
	public static TokenProccessor getInstance() {
		return instance;
	}
	
	/**
	 * 生成TOKEN
	 * @return
	 */
	public String getToken() {
		String token = System.currentTimeMillis() + new Random().nextInt(1000000) + "";
		
		try {
			// 得到数据指纹：md5 消息摘要
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] result = digest.digest(token.getBytes()); 
			BASE64Encoder encoder = new BASE64Encoder(); //Base64将三字节变成四字节(由原来的8位截前6位然后在前面补00,所以取值范围0-63)
			token = encoder.encode(result);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return token;
	}

}
