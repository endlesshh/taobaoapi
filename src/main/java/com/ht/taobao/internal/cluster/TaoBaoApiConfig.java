package com.ht.taobao.internal.cluster;

import java.util.ResourceBundle;

public class TaoBaoApiConfig {

	private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("sysConfig");

	/**
	 * @param key String
	 * @return String
	 */
	public static String get(String key) {
		return resourceBundle.getString(key);
	}
	 
	public static String getTaobaoDebug() {
		return TaoBaoApiConfig.get("taobaoDebug");
	}
	
	
	public static String getServerUrl() {
		if(Boolean.valueOf(getTaobaoDebug())){
			return TaoBaoApiConfig.get("dServerUrl");
		}else{
			return TaoBaoApiConfig.get("serverUrl");
		} 
	}
	
	public static String getOauthCodeUrl() {
		if(Boolean.valueOf(getTaobaoDebug())){
			return TaoBaoApiConfig.get("dOauthCodeUrl");
		}else{
			return TaoBaoApiConfig.get("oauthCodeUrl");
		}  
	}
	
	public static String getOauthTokenUrl() {
		if(Boolean.valueOf(getTaobaoDebug())){
			return TaoBaoApiConfig.get("dOauthTokenUrl");
		}else{
			return TaoBaoApiConfig.get("oauthTokenUrl");
		}  
	}
	
	public static String getAppKey() {
		if(Boolean.valueOf(getTaobaoDebug())){
			return TaoBaoApiConfig.get("dAppKey");
		}else{
			return TaoBaoApiConfig.get("appKey");
		}  
	}
	
	public static String getAppSecret() {
		if(Boolean.valueOf(getTaobaoDebug())){
			return TaoBaoApiConfig.get("dAppSecret");
		}else{
			return TaoBaoApiConfig.get("appSecret");
		} 
	} 
	
	public static String getRedirectUrl() {
		if(Boolean.valueOf(getTaobaoDebug())){
			return TaoBaoApiConfig.get("dRedirectUrl");
		}else{
			return TaoBaoApiConfig.get("redirectUrl");
		} 
	} 
	public static String getMsgUrl() {
		if(Boolean.valueOf(getTaobaoDebug())){
			return TaoBaoApiConfig.get("dMsgUrl");
		}else{
			return TaoBaoApiConfig.get("msgUrl");
		} 
	} 
	
}
