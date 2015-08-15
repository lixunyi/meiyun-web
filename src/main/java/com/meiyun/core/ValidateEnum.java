package com.meiyun.core;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 验证对象枚举类
 * 
 * @author Administrator
 *
 */
public enum ValidateEnum {

	INSTANCE;

	private Logger logger = LoggerFactory.getLogger(ValidateEnum.class);

	private ValidateEnum() {

	}

	/**
	 * 验证对象
	 * 
	 * @param validatorObject
	 * @return
	 */
	public boolean validate(Object validatorObject) {
		Validator validator = new Validator();
		List<ConstraintViolation> list = validator.validate(validatorObject);
		for (ConstraintViolation cv : list) {
			logger.error(cv.getMessage());
		}

		return list.size() == 0;
	}

	/**
	 * 验证对象，并指定验证的字段
	 * 
	 * @param validatorObject
	 * @param profiles
	 * @return
	 */
	public boolean validate(Object validatorObject, String... profiles) {
		Validator validator = new Validator();
		List<ConstraintViolation> list = validator.validate(validatorObject,
				profiles);
		for (ConstraintViolation cv : list) {
			logger.error(cv.getMessage());
		}

		return list.size() == 0;
	}

}
