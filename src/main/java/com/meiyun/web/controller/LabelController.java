package com.meiyun.web.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.meiyun.core.Route;
import com.meiyun.core.annotation.Logined;
import com.meiyun.core.render.Context;
import com.meiyun.dao.core.Pagable;
import com.meiyun.model.Label;
import com.meiyun.model.User;
import com.meiyun.service.LabelService;
import com.meiyun.web.component.WebContent;
import com.meiyun.web.core.BaseController;

@Controller
@Scope("prototype")
public class LabelController extends BaseController<Label, Integer, LabelService> {

	@Override
	@Resource
	public void setBaseService(LabelService baseService) {
		super.baseService = baseService;
	}
	
	@Logined
	@RequestMapping(value=Route.LABEL_NEW, method=RequestMethod.GET)
	public String add() {

		return WebContent.forword("label.new");
	}
	
	@ResponseBody
	@RequestMapping(value=Route.LABEL_NEW, method=RequestMethod.POST)
	public Context add(String title, String comment, HttpServletRequest request) {
		Context context = new Context();
		context.setMessage("添加标签成功");
		
		System.out.println("进入");
		
		User loginUser = super.getLoginUser(request);
		
		Label label = new Label();
		// 添加标签信息
		label.setTitle(title);
		label.setComment(comment);
		
		// 系统自动处理数据
		label.setAbbr(super.getPinYinHeadChar(label.getTitle()));
		label.setName(UUID.randomUUID().toString());
		label.setSpell(super.getPingYin(label.getTitle()));
		label.setState(1);
		label.setUser(loginUser);
		
		System.out.println(JSON.toJSONString(label, true));
		
		try {
			boolean flag = getBaseService().add(label);
			if (!flag) {
				context.setMessage("添加标签失败");
				context.setSuccess(false);
			}
		} catch (Exception e) {
			context.setMessage("添加标签失败");
			context.setSuccess(false);
			e.printStackTrace();
		}
		
		return context;
	}
	
	@ResponseBody
	@RequestMapping(value=Route.LABEL_UPDATE)
	public Context update(Label label) {
		Context context = new Context();
		
		try {
			getBaseService().update(label);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return context;
	}
	
	@ResponseBody
	@RequestMapping(value=Route.LABEL_DELETE)
	public Context delete(Label label) {
		Context context = new Context();
		
		try {
			getBaseService().delete(label);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return context;
	}
	
	@RequestMapping(value=Route.LABEL_INDEX)
	public String index(Model model, Label label) {
		Context context = new Context();
		
		try {
			PageInfo<Label> page = getBaseService().query(null, new Pagable(1, 50));
			context.setResult(page.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(JSON.toJSONString(context, true));
		model.addAttribute("c", context);
		return WebContent.forword("label.index");
	}
	
}
