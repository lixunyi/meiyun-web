package com.meiyun.web.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.meiyun.core.Route;
import com.meiyun.core.annotation.Logined;
import com.meiyun.core.render.Context;
import com.meiyun.core.session.LoginUser;
import com.meiyun.dao.core.Pagable;
import com.meiyun.model.Product;
import com.meiyun.model.Topic;
import com.meiyun.service.ProductService;
import com.meiyun.service.TopicService;
import com.meiyun.web.component.WebContent;
import com.meiyun.web.core.BaseController;

@Controller
@Scope("prototype")
public class TopicController extends BaseController<Topic, Integer, TopicService> {
	
	@Resource
	private ProductService productService;

	@Override
	@Resource
	public void setBaseService(TopicService baseService) {
		super.baseService = baseService;
	}
	
	@Logined
	@RequestMapping(value=Route.TOPIC_NEW, method=RequestMethod.GET)
	public String add() {
		return WebContent.forword("topic.new");
	}
	
	@ResponseBody
	@RequestMapping(value=Route.TOPIC_NEW, method=RequestMethod.POST)
	public Context add(String title, String comment, HttpServletRequest request) {
		Context context = new Context();
		context.setMessage("主题创建成功");
		
		try {
			Topic topic = new Topic();
			topic.setTitle(title);
			topic.setComment(comment);
			
			// 默认参数
			topic.setColor("#ccc");
			topic.setCounter(0);
			topic.setLiked(0);
			topic.setName(UUID.randomUUID().toString());
			topic.setState(1);
			topic.setUser(new LoginUser(request).getUser());
			
			boolean flag = getBaseService().add(topic);
			if (!flag) {
				context.setSuccess(false);
				context.setMessage("主题创建失败");
			}
		} catch (Exception e) {
			context.setSuccess(false);
			context.setMessage("系统发生故障");
			e.printStackTrace();
		}
		
		return context;
	}
	
	@RequestMapping(value=Route.TOPIC_INDEX)
	public String index(Model model, Topic topic) {
		
		Context context = new Context();
		
		try {
			PageInfo<Topic> page = getBaseService().query(null, new Pagable(1, 5));
			context.setResult(page.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("c", context);
		
		return WebContent.forword("topic.index");
	}
	
	@RequestMapping(value=Route.TOPIC_DETAIL)
	public String detail(Model model, @PathVariable Integer id) {
		Context context = new Context();
		Product product = new Product();
		product.setTopic(new Topic(id));
		
		try {
			PageInfo<Product> page = productService.query(null, new Pagable(1, 5));
			context.setResult(page.getList());
			
			Topic topic = getBaseService().queryById(id);
			model.addAttribute("topic", topic);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("c", context);
		return WebContent.forword("topic.detail");
	}

}
