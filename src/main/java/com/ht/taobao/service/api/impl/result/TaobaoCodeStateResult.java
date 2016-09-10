package com.ht.taobao.service.api.impl.result;

import java.util.Map;

import com.ht.taobao.service.api.impl.TaobaoResult;
import com.ht.taobao.service.api.impl.result.algorithm.Map1LevelAlgorithm;

public class TaobaoCodeStateResult implements TaobaoResult<String>{
	 
	private String json;
	//可以自行替换成其他的map算法
	private AlgorithmParse<Map<String,Object>> mapPares = new Map1LevelAlgorithm();
	public TaobaoCodeStateResult(String json){
		this.json = json;
	}
	
	//查看是否需要进行刷新授权
	@Override
	public String getResult(){
		if(mapPares.parse(this.json).get("sub_code") != null){
			String code = (String) mapPares.parse(this.json).get("sub_code");
			if("isv.shop-not-exist:invalid-shop".equals(code)){
				return "1";
			}else{
				return "2";
			}
		}else{
			return "3";
		}
	}

	 
	
}
