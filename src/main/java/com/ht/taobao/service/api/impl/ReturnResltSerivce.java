package com.ht.taobao.service.api.impl;

public interface ReturnResltSerivce {
	public boolean isSuccess();
	public TaobaoResult<?> getResutl(String resultType);
}
