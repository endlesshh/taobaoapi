package com.ht.taobao.service.api.impl.result;

import java.util.Map;

import com.ht.taobao.service.api.impl.TaobaoResult;
import com.ht.taobao.service.api.impl.result.algorithm.Map1LevelAlgorithm;

public class TaobaoOauthResult implements TaobaoResult<Boolean>{
	 
	private String json;
	//可以自行替换成其他的map算法
	private AlgorithmParse<Map<String,Object>> mapPares = new Map1LevelAlgorithm();
	public TaobaoOauthResult(String json){
		this.json = json;
	}
	
	//查看是否需要进行刷新授权
	@Override
	public Boolean getResult(){
		if(mapPares.parse(this.json) != null && mapPares.parse(this.json).get("code") != null){
			Integer code = (Integer) mapPares.parse(this.json).get("code");
			if(code.intValue() == 54 || code.intValue() == 53){
				return true;
			}else{
				return false;
			} 
		}else{
			return false;
		} 
	} 
}
