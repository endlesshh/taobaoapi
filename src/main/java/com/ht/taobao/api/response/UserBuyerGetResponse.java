package com.ht.taobao.api.response;

import com.taobao.api.TaobaoResponse;
import com.taobao.api.domain.User;
import com.taobao.api.internal.mapping.ApiField;

public class UserBuyerGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 7834252592144657384L;

	/** 
	 * 用户信息
	 */
	@ApiField("user")
	private User user;


	public void setUser(User user) {
		this.user = user;
	}
	public User getUser( ) {
		return this.user;
	}
	


}
