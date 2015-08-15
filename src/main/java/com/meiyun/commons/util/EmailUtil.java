package com.meiyun.commons.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtil {
	
	private static String HOST_NAME = "smtp.qq.com";
	/*private static String USER_NAME = "sion.qi@missionsky.com";
	private static String PASSWORD = "sionqi#77";*/
	private static String USER_NAME = "sion.qi@missionsky.com";
	private static String PASSWORD = "sionqi#77";
	
	public static void simpleEmail(String subject, String message, String userEmail) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName(HOST_NAME);
		email.setAuthenticator(new DefaultAuthenticator(USER_NAME, PASSWORD));
		email.setSSLOnConnect(true);
		email.setSmtpPort(465);
		email.setCharset("UTF-8");
		email.setFrom(USER_NAME);
		email.setSubject(subject);
		email.setMsg(message);
		email.addTo(userEmail);
		email.send();
	}
	
	public static void main(String[] args) {
		try {
			EmailUtil.simpleEmail("测试简单邮件发送服务", "成功发送邮件，请勿回复！", "616482412@qq.com");
			
			/*Email email = new SimpleEmail();
			email.setHostName("smtp.qq.com");
			//email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(USER_NAME, PASSWORD));
			email.setSSLOnConnect(true);
			email.setFrom(USER_NAME);
			email.setSubject("TestMail");
			email.setMsg("This is a test mail ... :-)");
			email.addTo("616482412@qq.com");
			email.send();*/
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
