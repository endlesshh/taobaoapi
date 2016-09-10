package com.ht.taobao.service.api.impl.result;

import java.util.Map;

import com.ht.taobao.service.api.impl.TaobaoResult;
import com.ht.taobao.service.api.impl.result.algorithm.Map1LevelAlgorithm;

public class Taobao1LevelMapResult implements TaobaoResult<Map<String,Object>>{
	
	 
	//可以自行替换成其他的map算法
	private AlgorithmParse<Map<String,Object>> mapPares = new Map1LevelAlgorithm();
	
	//API的返回json结果级
	private String json;
	
	public Taobao1LevelMapResult(String json ){ 
		this.json = json;
	} 
	
	public Map<String,Object> getResult(){  
		return mapPares.parse(this.json);
	} 
}
