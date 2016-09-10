package com.ht.taobao.service.api.impl.callapi.oauth;

import com.ht.taobao.service.api.impl.TaobaoOauthInfoService;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.request.PromotionActivityGetRequest;

public class PromotionActivityGet extends TaobaoOauthInfoService{

	@Override
	public TaobaoRequest<?> getTaobaoAPIResult(String files) {
		PromotionActivityGetRequest req = new PromotionActivityGetRequest();
		req.setActivityId(Long.parseLong(files));
		return req;
	}

}
