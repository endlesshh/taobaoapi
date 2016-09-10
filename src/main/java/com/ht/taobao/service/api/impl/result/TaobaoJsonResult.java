package com.ht.taobao.service.api.impl.result;

import com.ht.taobao.service.api.impl.TaobaoResult;

public class TaobaoJsonResult implements TaobaoResult<String>{
	 
	private String json;
	
	public TaobaoJsonResult(String json){
		this.json = json;
	}
	
	@Override
	public String getResult() {
		 return this.json;
	} 
}
