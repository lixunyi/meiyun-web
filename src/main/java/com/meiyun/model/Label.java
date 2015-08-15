package com.meiyun.model;

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotNull;

import com.meiyun.model.core.CommonEntity;

/**
 * 标签
 * 
 * @author Administrator
 *
 */
public class Label extends CommonEntity {

	private static final long serialVersionUID = -3212014541351838054L;

	@NotNull(profiles = "spell")
	@MaxLength(value = 64, profiles = "spell")
	private String spell; // 拼写

	@NotNull(profiles = "abbr")
	@MaxLength(value = 32, profiles = "abbr")
	private String abbr; // 缩写

	private Integer parent; // 父ID

	private Integer reorder; // 排序ID

	private Integer type; // 类型

	@NotNull(profiles = "user")
	private User user; // 用户

	public Label() {
		super();
	}

	public Label(Integer id) {
		super(id);
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Integer getReorder() {
		return reorder;
	}

	public void setReorder(Integer reorder) {
		this.reorder = reorder;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
