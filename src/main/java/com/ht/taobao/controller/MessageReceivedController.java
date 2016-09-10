package com.ht.taobao.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ht.taobao.internal.cluster.TaoBaoApiConfig;
import com.ht.taobao.service.api.TaobaoAPIFacade;
import com.ht.taobao.service.api.impl.ClientSingleton;
import com.taobao.api.internal.tmc.Message;
import com.taobao.api.internal.tmc.MessageHandler;
import com.taobao.api.internal.tmc.MessageStatus;
import com.taobao.api.internal.tmc.TmcClient;
import com.taobao.api.internal.toplink.LinkException;

@Scope("prototype")
@Controller
@RequestMapping("/messageReceivedController")
public class MessageReceivedController {
	@RequestMapping({"/recived.do"})
	public ModelAndView list(HttpServletRequest request) {
		TaobaoAPIFacade acde = new TaobaoAPIFacade();
		
		 
		return new ModelAndView("com/ht/taobao/taobaoOauthList");
	} 
	
	
	//测试消息订阅使用
	@RequestMapping({"/test.do"})
	public ModelAndView test(HttpServletRequest request,HttpServletResponse response) {
		TaobaoAPIFacade acde = new TaobaoAPIFacade();
		//淘宝消息授权实例
	//	taobao_item_ItemRecommendDelete,taobao_item_ItemStockChanged ,taobao_item_ItemSkuZeroStock ,taobao_item_ItemPunishCc ,taobao_item_ItemPunishDownshelf,taobao_item_ItemPunishDelete ,taobao_item_ItemZeroStock,taobao_item_ItemRecommendAdd ,taobao_item_ItemUpdate ,taobao_item_ItemDelete ,taobao_item_ItemDownshelf,taobao_item_ItemUpshelf,taobao_item_ItemAdd,
//		String topics = "taobao_chengxian_Testest,taobao_trade_TradePartlySellerShip,taobao_trade_TradeAlipayCreate,taobao_trade_TradeChanged,taobao_trade_TradeLogisticsAddressChanged,taobao_trade_TradeMemoModified,taobao_trade_TradeRated,taobao_trade_TradeTimeoutRemind,taobao_trade_TradeSuccess,taobao_trade_TradePartlyConfirmPay,taobao_trade_TradePartlyRefund,taobao_trade_TradeDelayConfirmPay,taobao_trade_TradeSellerShip,taobao_trade_TradeBuyerPay,taobao_trade_TradeClose,taobao_trade_TradeCloseAndModifyDetailOrder,taobao_trade_TradeModifyFee,taobao_trade_TradeCreate";
//		Map<String,Object>  map = acde.permitTopics(topics, "1",response);
//		if(map!=null && map.get("is_success") != null){
//			Boolean.valueOf(map.get("is_success").toString());
//		}
//		System.out.println(map);
//		//Map<String,Object>  map2  = acde.cancleUserTopics("sandbox_cilai_c,'',", "1",response);
//		Map<String,Object>  map2  = acde.getUserTopics("user_nick,topics,user_id,is_valid,created,modified:sandbox_cilai_c:tbUIC");
//		System.out.println(map2);
		
		
		// 获取卖家商品库存
		Map<String,Object>  map = acde.getGoodsItems("2",response);
		if(map!=null && map.get("is_success") != null){
			Boolean.valueOf(map.get("is_success").toString());
		} 
		//获取出售中的商品
//		Map<String,Object>  map = acde.getOnsaleItems("2",response);
//		if(map!=null && map.get("is_success") != null){
//			Boolean.valueOf(map.get("is_success").toString());
//		} 
//		//获取用户信息
//		Map<String,Object>  map = acde.getUserBuyerInfo("","2",response);
//		if(map!=null && map.get("is_success") != null){
//			Boolean.valueOf(map.get("is_success").toString());
//		} 
		//获取用户订阅消息队列信息
//		Map<String,Object>  map = acde.getTmcQueue("");
//		if(map!=null && map.get("is_success") != null){
//			Boolean.valueOf(map.get("is_success").toString());
//		}
		
		
		TmcClient client = ClientSingleton.INSTANCE.defaultClient;
		 System.out.println("======================="+client);
		client.setMessageHandler(new MessageHandler() {
		    public void onMessage(Message message, MessageStatus status) {
		        try {
		            System.out.println(message.getContent());
		            System.out.println("=======================");
		            System.out.println(message.getTopic());
		        } catch (Exception e) {
		            e.printStackTrace();
		            status.fail(); // 消息处理失败回滚，服务端需要重发
		          // 重试注意：不是所有的异常都需要系统重试。 
		          // 对于字段不全、主键冲突问题，导致写DB异常，不可重试，否则消息会一直重发
		          // 对于，由于网络问题，权限问题导致的失败，可重试。
		          // 重试时间 5分钟不等，不要滥用，否则会引起雪崩
		        }
		    }
		});
		try {
			client.connect(TaoBaoApiConfig.getMsgUrl());
		} catch (LinkException e) {
			 
			e.printStackTrace();
		}  
		
		
		return new ModelAndView("com/ht/taobao/taobaoOauthList");
	} 
}
