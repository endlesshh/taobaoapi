package com.ht.taobao.service.api;

import javax.servlet.http.HttpServletResponse;

public interface TaobaoAPIService {
	//需要用户授权  可以是 当前系统的id或者 是 三方授权后的accessToken
	public boolean needOauth(String accessToken,HttpServletResponse response);
	//不需要用户授权
}
