package com.ht.taobao.service.api.impl.callapi.nomal;

import com.ht.taobao.service.api.impl.TaobaoNormalInfoService;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.request.TmcUserGetRequest;

public class TmcUserGet extends TaobaoNormalInfoService{

	@Override
	public TaobaoRequest<?> getTaobaoAPIResult(String files) {
		//"user_nick,topics,user_id,is_valid,created,modified:testnick:tbUIC"
		TmcUserGetRequest req = new TmcUserGetRequest();
		String[] file = files.split(":"); 
		req.setFields(file[0]);
		req.setNick(file[1]);
		req.setUserPlatform(file[2]);
		return req;
	}

}
