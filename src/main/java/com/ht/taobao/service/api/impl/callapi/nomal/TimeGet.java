package com.ht.taobao.service.api.impl.callapi.nomal;

import com.ht.taobao.service.api.impl.TaobaoNormalInfoService;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.request.TimeGetRequest;

public class TimeGet extends TaobaoNormalInfoService{

	@Override
	public TaobaoRequest<?> getTaobaoAPIResult(String files) {
		TimeGetRequest req = new TimeGetRequest(); 
		return req;
	} 
}
