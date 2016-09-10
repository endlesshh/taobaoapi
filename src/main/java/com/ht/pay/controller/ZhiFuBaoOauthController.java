package com.ht.pay.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Scope("prototype")
@Controller
@RequestMapping("/zhiFuBaoOauthController")
public class ZhiFuBaoOauthController {
	/**
	 * 淘宝API列表 页面跳转 
	 */
	@RequestMapping({ "/oauth.do" })
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/ht/taobao/taobaoOauthList");
	}
}
