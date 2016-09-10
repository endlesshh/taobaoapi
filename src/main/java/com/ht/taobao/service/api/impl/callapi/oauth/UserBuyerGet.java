package com.ht.taobao.service.api.impl.callapi.oauth;

import com.ht.taobao.api.request.UserBuyerGetRequest;
import com.ht.taobao.service.api.impl.TaobaoOauthInfoService;
import com.taobao.api.TaobaoRequest;

public class UserBuyerGet extends TaobaoOauthInfoService{

	@Override
	public TaobaoRequest<?> getTaobaoAPIResult(String files) {
		UserBuyerGetRequest req = new UserBuyerGetRequest();
		req.setFields("nick,sex"); 
		return req;
	} 

}
