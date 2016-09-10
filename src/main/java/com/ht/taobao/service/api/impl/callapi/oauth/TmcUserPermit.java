package com.ht.taobao.service.api.impl.callapi.oauth;

import com.ht.taobao.service.api.impl.TaobaoOauthInfoService;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.request.TmcUserPermitRequest;

public class TmcUserPermit extends TaobaoOauthInfoService{
	
	//商品
	//taobao_item_ItemRecommendDelete,taobao_item_ItemStockChanged ,taobao_item_ItemSkuZeroStock ,taobao_item_ItemPunishCc ,taobao_item_ItemPunishDownshelf,taobao_item_ItemPunishDelete ,taobao_item_ItemZeroStock,taobao_item_ItemRecommendAdd ,taobao_item_ItemUpdate ,taobao_item_ItemDelete ,taobao_item_ItemDownshelf,taobao_item_ItemUpshelf,taobao_item_ItemAdd,
	
	
	//交易
	//taobao_chengxian_Testest,taobao_trade_TradePartlySellerShip,taobao_trade_TradeAlipayCreate,taobao_trade_TradeChanged,taobao_trade_TradeLogisticsAddressChanged,taobao_trade_TradeMemoModified,taobao_trade_TradeRated,taobao_trade_TradeTimeoutRemind,taobao_trade_TradeSuccess,taobao_trade_TradePartlyConfirmPay,taobao_trade_TradePartlyRefund,taobao_trade_TradeDelayConfirmPay,taobao_trade_TradeSellerShip,taobao_trade_TradeBuyerPay,taobao_trade_TradeClose,taobao_trade_TradeCloseAndModifyDetailOrder,taobao_trade_TradeModifyFee,taobao_trade_TradeCreate,
	@Override
	public TaobaoRequest<?> getTaobaoAPIResult(String files) {
		TmcUserPermitRequest req = new TmcUserPermitRequest();
		req.setTopics(files);
		return req;
	}

}
