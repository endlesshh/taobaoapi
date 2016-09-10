package com.ht.taobao.service.api.impl.result;

import com.ht.taobao.internal.cluster.TaoBaoConstant;
import com.ht.taobao.service.api.impl.ReturnResltSerivce;
import com.ht.taobao.service.api.impl.TaobaoResult;
import com.taobao.api.TaobaoResponse;
/**
 * 统一管理返回结果
 * @author ShiQiang
 *
 */
public class ReturnResult implements ReturnResltSerivce { 
	
	private boolean isSuccess = false;
	
	private TaobaoResponse resp;
	
	private TaobaoResult<?> result;
	
	public ReturnResult(TaobaoResponse resp){
		this.resp = resp;
		if(resp != null){
			this.isSuccess = resp.isSuccess();
		}
	} 
	public boolean isSuccess() { 
		return this.isSuccess;
	} 
	public TaobaoResult<?> getResutl(String resultType){ 
		//返回结果级别
		if(this.resp != null){
			if(isSuccess){ 
				if(TaoBaoConstant.RESULT_TYPE_TWO_MAP.equals(resultType)){
					result = new Taobao2LevelMapResult(this.resp.getBody());
				}else if(TaoBaoConstant.RESULT_TYPE_ONE_MAP.equals(resultType)){
					result = new Taobao1LevelMapResult(this.resp.getBody());
				}else{
					result = new TaobaoJsonResult("");
				}
			}else{  
				if(TaoBaoConstant.RESULT_TYPE_EROOR_STATE_MAP.equals(resultType)){
					result = new TaobaoCodeStateResult(this.resp.getBody());
				}else if(TaoBaoConstant.RESULT_TYPE_ONE_MAP.equals(resultType)){
					result = new Taobao1LevelMapResult(this.resp.getBody());
				}else{
					result = new TaobaoJsonResult("");
				}
			}  
		}else{  
			//默认 原结果返回
			result = new TaobaoJsonResult("");
			  
		} 
		return result;
	} 
}
