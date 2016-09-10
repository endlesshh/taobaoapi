package com.ht.taobao.service.api.impl;

import com.ht.taobao.internal.cluster.TaoBaoApiConfig;
import com.ht.taobao.internal.cluster.TaoBaoConstant;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.tmc.TmcClient;

public enum ClientSingleton {  
    INSTANCE;  
	private ClientSingleton(){};
	public TmcClient defaultClient = new TmcClient(TaoBaoApiConfig.getAppKey(),TaoBaoApiConfig.getAppSecret(), "default");
	public TaobaoClient apiClient = new DefaultTaobaoClient(TaoBaoApiConfig.getServerUrl(),TaoBaoApiConfig.getAppKey(),TaoBaoApiConfig.getAppSecret(),TaoBaoConstant.FORMAT_JSON);
	   
} 