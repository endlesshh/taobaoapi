package com.ht.taobao.service.api.impl;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ht.taobao.internal.cluster.TaoBaoApiConfig;
import com.ht.taobao.internal.cluster.TaoBaoConstant;
import com.ht.taobao.service.api.TaobaoAPIService;
import com.ht.taobao.service.api.impl.result.ReturnResult;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;

public abstract class TaobaoNormalInfoService implements TaobaoAPIService{
	private static final Logger logger = Logger.getLogger(TaobaoNormalInfoService.class);
	private String appKey = TaoBaoApiConfig.getAppKey();
	private String appSecret = TaoBaoApiConfig.getAppSecret();
	private String serverUrl = TaoBaoApiConfig.getServerUrl();
	//后期手动更换默认链接类
	protected TaobaoClient client = new DefaultTaobaoClient(this.serverUrl,this.appKey,this.appSecret,TaoBaoConstant.FORMAT_JSON);
	 
	public ReturnResltSerivce getAPIInfo(String fields)throws ApiException{  
		 
		TaobaoRequest<?> request = getTaobaoAPIResult(fields);
		TaobaoResponse resp= client.execute(request); 
		resp = tryAgin(request,resp);
		
		//处理返回结果
		ReturnResltSerivce resultRe = new ReturnResult(resp); 
		return resultRe;
		  
	} 
	
	/**
	 * 淘宝服务器问题，进行重新请求
	 * @param request
	 * @param resp
	 * @return
	 * @throws ApiException
	 */
	private  TaobaoResponse  tryAgin(TaobaoRequest<?> request,TaobaoResponse resp)throws ApiException{ 
		resp = client.execute(request); 
		return resp; 
	}
	
	
	public abstract TaobaoRequest<?> getTaobaoAPIResult(String files); 
	@Override
	public boolean needOauth(String userId,HttpServletResponse response) { 
		return false;
	} 
}
