package com.ht.taobao.service.api.impl.result.algorithm;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.ht.taobao.service.api.impl.result.AlgorithmParse;

public class Map1LevelAlgorithm implements AlgorithmParse<Map<String,Object>>{
	
	@Override
	public Map<String,Object> parse(String json){
		Map<String,Object> result = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(json)){
			Map<String,Object> map = JSON.parseObject(json, Map.class); 
			for(Object res : map.values()){ 
				return (Map<String, Object>) res;  
			}  
		} 
		return result;
	}
}
