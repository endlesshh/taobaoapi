package com.ht.taobao.service.api.impl.callapi.oauth;


import com.ht.taobao.service.api.impl.TaobaoOauthInfoService;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.request.ItemsInventoryGetRequest;

public class ItemsInventoryGet extends TaobaoOauthInfoService{

	@Override
	public TaobaoRequest<?> getTaobaoAPIResult(String files) {
		ItemsInventoryGetRequest req = new ItemsInventoryGetRequest();
		req.setFields("nick,type,cid,pic_url");
//		req.setQ("nike");
//		req.setBanner("for_shelved");
//		req.setCid(1232L);
//		req.setSellerCids("12,123");
		req.setPageNo(1L);
		req.setPageSize(40L);
//		req.setHasDiscount(true);
//		req.setOrderBy("list_time:desc");
//		req.setIsTaobao(true);
//		req.setIsEx(true);
//		req.setStartModified(StringUtils.parseDateTime("2000-01-01 00:00:00"));
//		req.setEndModified(StringUtils.parseDateTime("2000-01-01 00:00:00"));
//		req.setIsCspu(true);
		return req;
	} 
}
