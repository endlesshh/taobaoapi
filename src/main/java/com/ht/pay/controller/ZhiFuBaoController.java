package com.ht.pay.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Scope("prototype")
@Controller
@RequestMapping("/zhiFuBaoController")
public class ZhiFuBaoController {
	
	
	//-------------当面付
	@RequestMapping(params = "index")
	public ModelAndView index(HttpServletRequest request) {
		return new ModelAndView("com/ht/pay/alipay/trade/index");
	}
	@RequestMapping(params = "tradePay")
	public ModelAndView tradePay(HttpServletRequest request) {
		return new ModelAndView("com/ht/pay/alipay/trade/trade_pay");
	}
	@RequestMapping(params = "tradePrecreate")
	public ModelAndView tradePrecreate(HttpServletRequest request) {
		return new ModelAndView("com/ht/pay/alipay/trade/trade_precreate");
	}
	@RequestMapping(params = "tradeQuery")
	public ModelAndView tradeQuery(HttpServletRequest request) {
		return new ModelAndView("com/ht/pay/alipay/trade/trade_query");
	}
	@RequestMapping(params = "tradeRefund")
	public ModelAndView tradeRefund(HttpServletRequest request) {
		return new ModelAndView("com/ht/pay/alipay/trade/trade_refund");
	}
	
	//-------------及时到账
	@RequestMapping(params = "alipayApi")
	public ModelAndView alipayApi(HttpServletRequest request) {
		return new ModelAndView("com/ht/pay/alipay/direct/md5/alipayapi");
	}
	@RequestMapping(params = "alipayIndex")
	public ModelAndView alipayIndex(HttpServletRequest request) {
		return new ModelAndView("com/ht/pay/alipay/direct/md5/index");
	}
	@RequestMapping(params = "alipayNotify")
	public ModelAndView alipayNotify(HttpServletRequest request) {
		return new ModelAndView("com/ht/pay/alipay/direct/md5/notify_url");
	}
	@RequestMapping(params = "alipayReturn")
	public ModelAndView alipayReturn(HttpServletRequest request) {
		return new ModelAndView("com/ht/pay/alipay/direct/md5/return_url");
	}
	 
	
}
