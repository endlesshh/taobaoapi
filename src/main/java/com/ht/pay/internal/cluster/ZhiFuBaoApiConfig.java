package com.ht.pay.internal.cluster;

import java.util.ResourceBundle;

public class ZhiFuBaoApiConfig {

	private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("sysConfig");

	/**
	 * @param key String
	 * @return String
	 */
	public static String get(String key) {
		return resourceBundle.getString(key);
	}
	 
	public static String getZhiFuBaoDebug() {
		return ZhiFuBaoApiConfig.get("zhiFuBaoDebug");
	}
	
	
	public static String getServerUrl() {
		if(Boolean.valueOf(getZhiFuBaoDebug())){
			return ZhiFuBaoApiConfig.get("dServerUrl");
		}else{
			return ZhiFuBaoApiConfig.get("serverUrl");
		} 
	}
	
	public static String getOauthCodeUrl() {
		if(Boolean.valueOf(getZhiFuBaoDebug())){
			return ZhiFuBaoApiConfig.get("dOauthCodeUrl");
		}else{
			return ZhiFuBaoApiConfig.get("oauthCodeUrl");
		}  
	}
	
	public static String getOauthTokenUrl() {
		if(Boolean.valueOf(getZhiFuBaoDebug())){
			return ZhiFuBaoApiConfig.get("dOauthTokenUrl");
		}else{
			return ZhiFuBaoApiConfig.get("oauthTokenUrl");
		}  
	}
	
	public static String getAppKey() {
		if(Boolean.valueOf(getZhiFuBaoDebug())){
			return ZhiFuBaoApiConfig.get("dAppKey");
		}else{
			return ZhiFuBaoApiConfig.get("appKey");
		}  
	}
	
	public static String getAppSecret() {
		if(Boolean.valueOf(getZhiFuBaoDebug())){
			return ZhiFuBaoApiConfig.get("dAppSecret");
		}else{
			return ZhiFuBaoApiConfig.get("appSecret");
		} 
	} 
	
	public static String getRedirectUrl() {
		if(Boolean.valueOf(getZhiFuBaoDebug())){
			return ZhiFuBaoApiConfig.get("dRedirectUrl");
		}else{
			return ZhiFuBaoApiConfig.get("redirectUrl");
		} 
	} 
}
