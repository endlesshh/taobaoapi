package com.ht.taobao.service.api.impl.callapi.oauth;

import org.jeecgframework.p3.core.utils.common.StringUtils;

import com.ht.taobao.service.api.impl.TaobaoOauthInfoService;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.request.TmcUserCancelRequest;

public class TmcUserCancel extends TaobaoOauthInfoService{

	@Override
	public TaobaoRequest<?> getTaobaoAPIResult(String files) {
		TmcUserCancelRequest req = new TmcUserCancelRequest();
		String[] reqString = files.split(",");
		req.setNick(reqString[0]);
		if(StringUtils.isNotBlank(reqString[1])){
			req.setUserPlatform(reqString[1]);
		} 
		return req;
	}

}
