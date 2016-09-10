package com.ht.taobao.service.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.ht.taobao.internal.cluster.TaoBaoConstant;
import com.ht.taobao.service.api.impl.ReturnResltSerivce;
import com.ht.taobao.service.api.impl.TaobaoNormalInfoService;
import com.ht.taobao.service.api.impl.TaobaoOauthInfoService;
import com.ht.taobao.service.api.impl.callapi.nomal.TimeGet;
import com.ht.taobao.service.api.impl.callapi.nomal.TmcQueueGet;
import com.ht.taobao.service.api.impl.callapi.nomal.TmcUserGet;
import com.ht.taobao.service.api.impl.callapi.oauth.ItemsInventoryGet;
import com.ht.taobao.service.api.impl.callapi.oauth.ItemsOnsaleGet;
import com.ht.taobao.service.api.impl.callapi.oauth.TmcUserPermit;
import com.ht.taobao.service.api.impl.callapi.oauth.UserBuyerGet;
import com.ht.taobao.service.api.impl.callapi.oauth.UserSellerGet;
import com.ht.taobao.service.api.impl.result.Taobao1LevelMapResult;
import com.ht.taobao.service.api.impl.result.Taobao2LevelMapResult;
import com.ht.taobao.service.api.impl.result.TaobaoCodeStateResult;
import com.ht.taobao.service.api.impl.result.TaobaoJsonResult;
import com.taobao.api.ApiException;

public class TaobaoAPIFacade {
	
	private TaobaoOauthInfoService aouthInfo;
	private TaobaoNormalInfoService normalInfo;
	
	//---------------------授权区
	public Map<String,Object> getOnsaleItems(String userId,HttpServletResponse response){
		aouthInfo = new ItemsOnsaleGet(); 
		try {
			ReturnResltSerivce result = aouthInfo.getAPIInfo("",userId,response);
			if(result.isSuccess()){
				Taobao2LevelMapResult mapResult = (Taobao2LevelMapResult) result.getResutl(TaoBaoConstant.RESULT_TYPE_TWO_MAP);
				return mapResult.getResult(); 
			} 
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return new HashMap<String,Object>();
	} 
	
	
	
	//给授权用户订阅消息
	//获取卖家商品库存信息
	public Map<String,Object> getGoodsItems(String userId,HttpServletResponse response){
		aouthInfo = new ItemsInventoryGet(); 
		try {
			ReturnResltSerivce result = aouthInfo.getAPIInfo("",userId,response);
			if(result.isSuccess()){
				Taobao2LevelMapResult mapResult = (Taobao2LevelMapResult) result.getResutl(TaoBaoConstant.RESULT_TYPE_TWO_MAP);
				return mapResult.getResult(); 
			} 
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return new HashMap<String,Object>();
	} 
	//获取卖家信息
	public Map<String,Object> permitTopics(String fields,String userId,HttpServletResponse response){
		aouthInfo = new TmcUserPermit(); 
		try {
			ReturnResltSerivce result = aouthInfo.getAPIInfo(fields,userId,response);
			if(result.isSuccess()){
				Taobao1LevelMapResult mapResult = (Taobao1LevelMapResult) result.getResutl(TaoBaoConstant.RESULT_TYPE_ONE_MAP);
				return mapResult.getResult();
			} 
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return new HashMap<String,Object>();
	} 
	//获取买家信息
	public Map<String,Object> getUserBuyerInfo(String fields,String userId,HttpServletResponse response){
		aouthInfo = new UserBuyerGet(); 
		try {
			ReturnResltSerivce result = aouthInfo.getAPIInfo(fields,userId,response);
			if(result.isSuccess()){
				Taobao1LevelMapResult mapResult = (Taobao1LevelMapResult) result.getResutl(TaoBaoConstant.RESULT_TYPE_ONE_MAP);
				return mapResult.getResult();
			} 
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return new HashMap<String,Object>();
	} 
	
	//获取卖家信息  
	/**
	 * fields 必须用户,隔开
	 * @param fields
	 * @param userId
	 * @return
	 */
	public Map<String,Object> cancleUserTopics(String fields,String userId,HttpServletResponse response){
		aouthInfo = new TmcUserPermit(); 
		try {
			ReturnResltSerivce result = aouthInfo.getAPIInfo(fields,userId,response);
			if(result.isSuccess()){
				Taobao1LevelMapResult mapResult = (Taobao1LevelMapResult) result.getResutl(TaoBaoConstant.RESULT_TYPE_ONE_MAP);
				return mapResult.getResult();
			} 
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return new HashMap<String,Object>();
	} 
	
	
	//获取卖家信息
	public Map<String,Object> getUserSellerMap(String fields,String userId,HttpServletResponse response){
		aouthInfo = new UserSellerGet(); 
		try {
			ReturnResltSerivce result = aouthInfo.getAPIInfo(fields,userId,response);
			if(result.isSuccess()){
				Taobao2LevelMapResult mapResult = (Taobao2LevelMapResult) result.getResutl(TaoBaoConstant.RESULT_TYPE_TWO_MAP);
				return mapResult.getResult();
			}  
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return new HashMap<String,Object>();
	} 
	//判断是否为卖家
	public String CheckUserIsSeller(String accessToken,HttpServletResponse response){
		aouthInfo = new UserSellerGet(); 
		try {
			ReturnResltSerivce result = aouthInfo.getAPIInfo("nick",accessToken,response);
			if(result.isSuccess()){
				TaobaoCodeStateResult mapResult = (TaobaoCodeStateResult) result.getResutl(TaoBaoConstant.RESULT_TYPE_EROOR_STATE_MAP);
				return mapResult.getResult();
			}   
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return "";
	} 
	
	public String getUserSellerJson(String fields,String userId,HttpServletResponse response){
		aouthInfo = new UserSellerGet(); 
		try {
			ReturnResltSerivce result = aouthInfo.getAPIInfo(fields,userId,response);
			if(result.isSuccess()){
				TaobaoJsonResult mapResult = (TaobaoJsonResult) result.getResutl("");
				return mapResult.getResult();
			}   
			 
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return "";
	}
	//非授权区
	//获取消息队列
	public Map<String,Object> getTmcQueue(String fields){
		normalInfo = new TmcQueueGet(); 
		try {
			ReturnResltSerivce result = normalInfo.getAPIInfo(fields);
			if(result.isSuccess()){
				Taobao1LevelMapResult mapResult = (Taobao1LevelMapResult) result.getResutl(TaoBaoConstant.RESULT_TYPE_ONE_MAP);
				return mapResult.getResult();
			}  
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return new HashMap<String,Object>();
	} 
	
	
	//获取系统时间
	public Map<String,Object> getUserTopics(String fields){
		normalInfo = new TmcUserGet(); 
		try {
			ReturnResltSerivce result = normalInfo.getAPIInfo(fields);
			if(result.isSuccess()){
				Taobao1LevelMapResult mapResult = (Taobao1LevelMapResult) result.getResutl(TaoBaoConstant.RESULT_TYPE_ONE_MAP);
				return mapResult.getResult();
			}  
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return new HashMap<String,Object>();
	} 
	
	
	
	public Map<String,Object> getTimeMap(){
		normalInfo = new TimeGet(); 
		try {
			ReturnResltSerivce result = normalInfo.getAPIInfo("");
			if(result.isSuccess()){
				Taobao1LevelMapResult mapResult = (Taobao1LevelMapResult) result.getResutl(TaoBaoConstant.RESULT_TYPE_ONE_MAP);
				return mapResult.getResult();
			}  
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return new HashMap<String,Object>();
	} 
	public String getTimeJson(){
		normalInfo = new TimeGet(); 
		try {
			ReturnResltSerivce result = normalInfo.getAPIInfo("");
			if(result.isSuccess()){
				TaobaoJsonResult mapResult = (TaobaoJsonResult) result.getResutl("");
				return mapResult.getResult();
			}  
		} catch (ApiException e) { 
			e.printStackTrace();
		}
		return "";
	}
	
	
}
