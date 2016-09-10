package com.ht.taobao.service.api.impl.callapi.oauth;

import com.ht.taobao.service.api.impl.TaobaoOauthInfoService;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.request.UserSellerGetRequest;

public class UserSellerGet extends TaobaoOauthInfoService{ 
	 
	@Override
	public TaobaoRequest<?> getTaobaoAPIResult(String files) { 
		UserSellerGetRequest req = new UserSellerGetRequest();
		req.setFields(files); 
		return req;
	} 
}
