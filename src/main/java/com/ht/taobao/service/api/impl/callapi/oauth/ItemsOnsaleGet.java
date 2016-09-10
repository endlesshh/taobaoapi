package com.ht.taobao.service.api.impl.callapi.oauth;

import com.ht.taobao.service.api.impl.TaobaoOauthInfoService;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.request.ItemsOnsaleGetRequest;

public class ItemsOnsaleGet extends TaobaoOauthInfoService{

	@Override
	public TaobaoRequest<?> getTaobaoAPIResult(String files) {
		ItemsOnsaleGetRequest req = new ItemsOnsaleGetRequest();
		req.setFields("title,nick,type,cid,pic_url,num,props");
//		req.setQ("N97");
//		req.setCid(1512L);
//		req.setSellerCids("11");
		req.setPageNo(1L);
//		req.setHasDiscount(true);
//		req.setHasShowcase(true);
//		req.setOrderBy("list_time:desc");
//		req.setIsTaobao(true);
//		req.setIsEx(true);
		req.setPageSize(100L);
//		req.setStartModified(StringUtils.parseDateTime("2000-01-01 00:00:00"));
//		req.setEndModified(StringUtils.parseDateTime("2000-01-01 00:00:00"));
//		req.setIsCspu(true);
		return req;
	}

}
