package com.ht.taobao.service.api.impl.callapi.nomal;

import com.ht.taobao.service.api.impl.TaobaoNormalInfoService;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.request.TmcQueueGetRequest;

public class TmcQueueGet extends TaobaoNormalInfoService{

	@Override
	public TaobaoRequest<?> getTaobaoAPIResult(String files) {
		TmcQueueGetRequest req = new TmcQueueGetRequest();
		req.setGroupName("default");
		return req;
	}

}
