package com.meiyun.model;

import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotNull;

import com.meiyun.model.core.CommonEntity;

/**
 * 用户
 * 
 * @author Administrator
 *
 */
public class User extends CommonEntity {

	private static final long serialVersionUID = 1389304540251152780L;

	@Email(profiles = "email")
	@MaxLength(value = 32, profiles = "email")
	private String email; // 邮箱

	private Integer isEmailSet; // 邮箱是否验证

	@MaxLength(value = 32, profiles = "mobile")
	private String mobile; // 手机

	private Integer isMobileSet; // 手机是否验证

	@NotNull(profiles = "password")
	@MaxLength(value = 32, profiles = "password")
	private String password; // 密码

	@NotNull(profiles = "secret")
	@MaxLength(value = 36, profiles = "secret")
	private String secret; // 安全码

	@NotNull(profiles = "salt")
	@MaxLength(value = 8, profiles = "salt")
	private String salt; // 盐，加密字符串

	@MaxLength(value = 128, profiles = "image")
	private String image; // 图像

	@MaxLength(value = 128, profiles = "cover")
	private String cover; // 封面

	@MaxLength(value = 32, profiles = "color")
	private String color; // 主题色

	private Integer type; // 用户类型

	public User() {
		super();
	}

	public User(Integer id) {
		super(id);
	}

	public User(String name) {
		super(name);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsEmailSet() {
		return isEmailSet;
	}

	public void setIsEmailSet(Integer isEmailSet) {
		this.isEmailSet = isEmailSet;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getIsMobileSet() {
		return isMobileSet;
	}

	public void setIsMobileSet(Integer isMobileSet) {
		this.isMobileSet = isMobileSet;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
