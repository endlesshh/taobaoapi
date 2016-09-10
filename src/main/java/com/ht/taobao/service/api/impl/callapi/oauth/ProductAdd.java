package com.ht.taobao.service.api.impl.callapi.oauth;

import java.util.Date;

import com.ht.taobao.service.api.impl.TaobaoOauthInfoService;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.request.ProductAddRequest;

public class ProductAdd  extends TaobaoOauthInfoService{

	@Override
	public TaobaoRequest<?> getTaobaoAPIResult(String files) {
		ProductAddRequest req = new ProductAddRequest();
		req.setCid(5300012L);
		req.setOuterId("96330012");
		req.setProps("pid:vid;pid:vid");
		req.setBinds("pid:vid;pid:vid");
		req.setSaleProps("pid:vid;pid:vid");
		req.setCustomerProps("20000:优衣库:型号:001:632501:1234");
		req.setPrice("200.07");
		//req.setImage(new FileItem("/tmp/file.txt"));
		req.setName("笔记本");
		req.setDesc("这是产品描述");
		req.setMajor(true);
		req.setVerticalMarket(4L);
		req.setMarketTime(StringUtils.parseDateTime(StringUtils.formatDateTime(new Date())));
		req.setPropertyAlias("1627207:3232483:深深绿色");
		req.setPackingList("说明书:1;耳机:1;充电器:1");
		req.setExtraInfo("[{\"field_key\":\"description\",\"field_name\":\"内容简介\",\"field_value\":\"我是内容简介\"},{\"field_name\":\"目录\",\"field_value\":\"我是目录\"}]");
		req.setMarketId("2");
		req.setSellPt("明星同款");
		req.setTemplateId(1L);
		req.setSuiteItemsStr("1000000062318020:1;1000000062318020:2;");
		req.setIsPubSuite(false);
		return req;
	} 
}
