package com.ht.taobao.internal.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.p3.core.utils.common.StringUtils;

import com.alibaba.fastjson.JSON;
import com.ht.taobao.entity.TaoBaoOAuth;
import com.ht.taobao.internal.cluster.TaoBaoApiConfig;
import com.ht.taobao.internal.cluster.TaoBaoConstant;
import com.ht.taobao.service.TaobaoOauthServiceI;
import com.taobao.api.internal.util.WebUtils;
/**
 *  用户授权使用
 * @author ShiQiang
 *
 */
public class OauthUrlTools {
	
	//获取授权验证code的url   state和view选填
	public static String getCodeUrl(String state,String view){ 
		
		if(StringUtils.isBlank(state)){
			state = "wifuns";
		}
		if(StringUtils.isBlank(view)){
			view = "web";
		} 
		StringBuilder builder = new StringBuilder();
		builder.append(TaoBaoApiConfig.getOauthCodeUrl()).append("?");
		builder.append(TaoBaoConstant.RESPONSE_TYPE).append("=code&");
		builder.append(TaoBaoConstant.CLIENT_ID).append("=").append(TaoBaoApiConfig.getAppKey()).append("&");
		builder.append(TaoBaoConstant.REDIRECT_URI).append("=").append(TaoBaoApiConfig.getRedirectUrl()).append("&");
		builder.append(TaoBaoConstant.OAUTH_STATE).append("=").append(state).append("&");
		builder.append(TaoBaoConstant.OAUTH_VIEW).append("=").append(view); 
		return builder.toString();
	}
	
	//获取授权验证access_token的url  code必填，view选添
	public static TaoBaoOAuth getAccessToken(String code,String view){ 
		TaoBaoOAuth oauth = null;
		if(StringUtils.isNotBlank(code)){
			if(StringUtils.isBlank(view)){
				view = "web";
			} 
			Map<String, String> props = new HashMap<String, String>();
			props.put(TaoBaoConstant.GRANT_TYPE, "authorization_code"); 
			props.put(TaoBaoConstant.OAUTH_CODE,code);
			props.put(TaoBaoConstant.CLIENT_ID,TaoBaoApiConfig.getAppKey());
			props.put(TaoBaoConstant.CLIENT_SECRET,TaoBaoApiConfig.getAppSecret());
			props.put(TaoBaoConstant.REDIRECT_URI,TaoBaoApiConfig.getRedirectUrl());
			props.put(TaoBaoConstant.OAUTH_VIEW,view); 
			try {
				String getMsg = WebUtils.doPost(TaoBaoApiConfig.getOauthTokenUrl(), props, 30000, 30000);
				if(StringUtils.isNotBlank(getMsg)){
					oauth = JSON.parseObject(getMsg, TaoBaoOAuth.class);
				}else{
					oauth = new TaoBaoOAuth();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		return oauth;
	}
	
	//刷新access_token的授权时间  code必填，view选添
	public static TaoBaoOAuth refreshAccessToken(TaoBaoOAuth oauth){ 
		TaoBaoOAuth reOauth = null;
		if(oauth != null){
			 
			Map<String, String> props = new HashMap<String, String>();
			props.put(TaoBaoConstant.GRANT_TYPE, "refresh_token"); 
			props.put(TaoBaoConstant.REFRESH_TOKEN,oauth.getRefresh_token());
			props.put(TaoBaoConstant.CLIENT_ID,TaoBaoApiConfig.getAppKey());
			props.put(TaoBaoConstant.CLIENT_SECRET,TaoBaoApiConfig.getAppSecret()); 
			 
			try {
				String getMsg = WebUtils.doPost(TaoBaoApiConfig.getOauthTokenUrl(), props, 30000, 30000);
				if(StringUtils.isNotBlank(getMsg)){
					reOauth = JSON.parseObject(getMsg, TaoBaoOAuth.class);
				}else{
					reOauth = new TaoBaoOAuth();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		return reOauth;
	}
	
	
	//刷新access_token的授权时间  code必填，view选添
	public static TaoBaoOAuth refreshAccessToken(TaoBaoOAuth oauth,TaobaoOauthServiceI taobaoOauthService){  
		if(oauth != null && taobaoOauthService != null){
			 
			Map<String, String> props = new HashMap<String, String>();
			props.put(TaoBaoConstant.GRANT_TYPE, "refresh_token"); 
			props.put(TaoBaoConstant.REFRESH_TOKEN,oauth.getRefresh_token());
			props.put(TaoBaoConstant.CLIENT_ID,TaoBaoApiConfig.getAppKey());
			props.put(TaoBaoConstant.CLIENT_SECRET,TaoBaoApiConfig.getAppSecret()); 
			 
			try {
				String getMsg = WebUtils.doPost(TaoBaoApiConfig.getOauthTokenUrl(), props, 30000, 30000);
				if(StringUtils.isNotBlank(getMsg)){ 
					TaoBaoOAuth reOauth = JSON.parseObject(getMsg, TaoBaoOAuth.class);
					try {
						///MyBeanUtils.copyBeanNotNull2Bean(reOauth,oauth);
					} catch (Exception e) { 
						e.printStackTrace();
					}
					//taobaoOauthService.updateEntitie(oauth);
				}else{
					oauth = null;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		return oauth;
	}
	
	
}
