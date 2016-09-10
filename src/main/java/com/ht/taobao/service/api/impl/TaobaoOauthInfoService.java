package com.ht.taobao.service.api.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.p3.core.utils.common.StringUtils;

import com.ht.taobao.entity.TaoBaoOAuth;
import com.ht.taobao.internal.util.OauthUrlTools;
//import com.ht.taobao.service.TaobaoOauthServiceI;
import com.ht.taobao.service.api.TaobaoAPIService;
import com.ht.taobao.service.api.impl.result.ReturnResult;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;

public abstract class TaobaoOauthInfoService implements TaobaoAPIService{
	private static final Logger logger = Logger.getLogger(TaobaoOauthInfoService.class);
	//后期手动更换默认链接类
	protected TaobaoClient client = ClientSingleton.INSTANCE.apiClient;
	//授权
	//private TaobaoOauthServiceI taobaoOauthService;
	private TaoBaoOAuth oauth;
	
	 
	//主方法
	public ReturnResltSerivce getAPIInfo(String fields,String accessToken,HttpServletResponse response)throws ApiException{  
		//检验权限
		TaobaoResponse resp = null;
		if(needOauth(accessToken,response)){ 
			//构造请求
			TaobaoRequest<?> request = getTaobaoAPIResult(fields);
			resp= client.execute(request,this.oauth.getAccess_token());
			//进行需要重复请求的检测
			resp = checkState(request,resp,response);
			//处理返回结果  
		}
		ReturnResltSerivce resultRe = new ReturnResult(resp);
		return resultRe;
	            
	} 
	public abstract TaobaoRequest<?> getTaobaoAPIResult(String files);  
	
	@Override
	public boolean needOauth(String accessToken,HttpServletResponse response) {
		try {
			if(StringUtils.isNotBlank(accessToken)){
				//taobaoOauthService = (TaobaoOauthServiceI) ApplicationContextUtil.getContext().getBean("taobaoOauthService");
				TaoBaoOAuth oauth = null;// taobaoOauthService.findUniqueByProperty(TaoBaoOAuth.class,"user_id",accessToken);
				if(oauth == null){
					oauth = null;//taobaoOauthService.findUniqueByProperty(TaoBaoOAuth.class,"access_token",accessToken);
				}
				if(oauth != null){
					this.oauth = oauth;
					return true;
				}else{
					response.sendRedirect(OauthUrlTools.getCodeUrl("", ""));
					return false;
				}
			}
		} catch (Exception e) {
			logger.debug("accessToken查询错误");
			return false;
		} 
		return false;
	}  
	/**
	 * 检查返回状态，进行重复请求操作处理
	 * @param request
	 * @param resp
	 * @return
	 * @throws ApiException
	 */
	private TaobaoResponse checkState(TaobaoRequest<?> request,TaobaoResponse resp,HttpServletResponse response)throws ApiException{
		//重新请求
		if(resp.getSubCode() != null && resp.getSubCode().startsWith("isp")){
			return tryAgin(request,resp);
		}else if(resp.getErrorCode() != null){
			//权限过期
			if(resp.getErrorCode().equalsIgnoreCase("54")||resp.getErrorCode().equalsIgnoreCase("53")){
				 //token过期 刷新权限 
				return 	refreshOauthAgin(request,resp,response);
			}
			if(resp.getSubCode()!=null && resp.getSubCode().equals("invalid-sessionkey")){
				 //token过期 刷新权限 
				return 	refreshOauthAgin(request,resp,response);
			}
		} 
		return resp;
	}
	/**
	 * 淘宝服务器问题，进行重新请求
	 * @param request
	 * @param resp
	 * @return
	 * @throws ApiException
	 */
	private  TaobaoResponse  tryAgin(TaobaoRequest<?> request,TaobaoResponse resp)throws ApiException{ 
		resp = client.execute(request,this.oauth.getAccess_token()); 
		return resp; 
	}
	/**
	 * 授权过期进行重新请求
	 * @param request
	 * @param resp
	 * @return
	 * @throws ApiException
	 */
	private  TaobaoResponse  refreshOauthAgin(TaobaoRequest<?> request,TaobaoResponse resp,HttpServletResponse response)throws ApiException{ 
		 this.oauth = null;//OauthUrlTools.refreshAccessToken(this.oauth,taobaoOauthService);
		 if(resp.getSubCode() != null && resp.getSubCode().startsWith("isp")){
        	 resp = client.execute(request,this.oauth.getAccess_token());
         }
		 //如果依旧没有权限则跳转重新授权
		 if(resp.getErrorCode() != null){ 
			if(resp.getErrorCode().equalsIgnoreCase("54")||resp.getErrorCode().equalsIgnoreCase("53")){
				 //想办法跳转重新授权
				//调用淘宝授权 
				try {
					response.sendRedirect(OauthUrlTools.getCodeUrl("", ""));
				} catch (IOException e) {
					logger.info("重新授权");
					e.printStackTrace();
				}
				return null; 
			}
			if(resp.getSubCode()!=null && resp.getSubCode().equals("invalid-sessionkey")){
				 //想办法跳转重新授权
				//调用淘宝授权 
				try {
					response.sendRedirect(OauthUrlTools.getCodeUrl("", ""));
				} catch (IOException e) {
					logger.info("重新授权");
					e.printStackTrace();
				}
				return null; 
			}
		}
		return resp; 
	}
	
	
}
