package com.ht.taobao.service.api.impl.result.algorithm;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.ht.taobao.service.api.impl.result.AlgorithmParse;

public class Map2LevelAlgorithm implements AlgorithmParse<Map<String,Object>>{

	/**
	 * 使用map对象进行数据保存
	 * 例如：
	 * {
		    "user_buyer_get_response":{
		        "user":{
		            "nick":"hz0799",
		            "sex":"m",
		            "avatar":"http:png"
		        }
		    }
		}
		只保留    "nick":"hz0799",
	           "sex":"m",
	           "avatar":"http:png"
	         返回值使用key-value的形式获取       
	    
	 * @param jsonString
	 * @return
	 */
	@Override
	public Map<String,Object> parse(String json){
		Map<String,Object> result = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(json)){
			Map<String,Object> map = JSON.parseObject(json, Map.class);
			for(Object key : map.values()){
				Map<String,Object> results = (Map<String, Object>) key;
				for(Object res : results.values()){
					if(res instanceof Map){
						return (Map<String, Object>) res; 
					} 
				} 
			}
		} 
		return result;
	}
}
