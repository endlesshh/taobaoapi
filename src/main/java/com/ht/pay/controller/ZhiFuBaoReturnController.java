package com.ht.pay.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 *  回调地址
 * @author Administrator
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/zhiFuBaoReturnController")
public class ZhiFuBaoReturnController {
	/**
	 * 淘宝API列表 页面跳转 
	 */ 
	@RequestMapping({ "/return.do" })
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/ht/taobao/taobaoOauthList");
	}
}
