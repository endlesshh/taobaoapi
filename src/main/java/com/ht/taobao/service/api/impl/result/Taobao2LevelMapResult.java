package com.ht.taobao.service.api.impl.result;

import java.util.Map;

import com.ht.taobao.service.api.impl.TaobaoResult;
import com.ht.taobao.service.api.impl.result.algorithm.Map2LevelAlgorithm;

public class Taobao2LevelMapResult implements TaobaoResult<Map<String,Object>>{
	
	 
	//可以自行替换成其他的map算法
	private AlgorithmParse<Map<String,Object>> mapPares = new Map2LevelAlgorithm();
	
	//API的返回json结果级
	private String json;
	
	public Taobao2LevelMapResult(String json){
		this.json = json;
	} 
	
	public Map<String,Object> getResult(){  
		return mapPares.parse(this.json);
	} 
}
