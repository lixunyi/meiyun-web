package com.meiyun.web.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meiyun.core.Route;
import com.meiyun.web.component.WebContent;

@Controller
@Scope("prototype")
public class HomeController {

	/**
	 * 关于我们
	 * 
	 * @return
	 */
	@RequestMapping(value = Route.HOME_INDEX)
	public String index() {
		return WebContent.forword("home.index");
	}

	/**
	 * 移动APP
	 * 
	 * @return
	 */
	@RequestMapping(value = Route.HOME_APP)
	public String app() {
		return WebContent.forword("home.app");
	}

	/**
	 * 版本声明
	 * 
	 * @return
	 */
	@RequestMapping(value = Route.HOME_COPYRIGHT)
	public String copyright() {
		return WebContent.forword("home.copyright");
	}

	/**
	 * 反馈建议
	 * 
	 * @return
	 */
	@RequestMapping(value = Route.HOME_FAQ)
	public String faq() {
		return WebContent.forword("home.faq");
	}

	/**
	 * 帮助中心
	 * 
	 * @return
	 */
	@RequestMapping(value = Route.HOME_HELP)
	public String help() {
		return WebContent.forword("home.help");
	}

}
