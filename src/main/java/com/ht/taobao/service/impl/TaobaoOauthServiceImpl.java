//package com.ht.taobao.service.impl;
//import java.io.Serializable;
//
//import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ht.taobao.entity.TaoBaoOAuth;
//import com.ht.taobao.service.TaobaoOauthServiceI;
//
//@Service("taobaoOauthService")
//@Transactional
//public class TaobaoOauthServiceImpl extends CommonServiceImpl implements TaobaoOauthServiceI {
//
//	
// 	public <T> void delete(T entity) {
// 		super.delete(entity);
// 		//执行删除操作配置的sql增强
//		this.doDelSql((TaoBaoOAuth)entity);
// 	}
// 	
// 	public <T> Serializable save(T entity) {
// 		Serializable t = super.save(entity);
// 		//执行新增操作配置的sql增强
// 		this.doAddSql((TaoBaoOAuth)entity);
// 		return t;
// 	}
// 	
// 	public <T> void saveOrUpdate(T entity) {
// 		super.saveOrUpdate(entity);
// 		//执行更新操作配置的sql增强
// 		this.doUpdateSql((TaoBaoOAuth)entity);
// 	}
// 	
// 	/**
//	 * 默认按钮-sql增强-新增操作
//	 * @param id
//	 * @return
//	 */
// 	public boolean doAddSql(TaoBaoOAuth t){
//	 	return true;
// 	}
// 	/**
//	 * 默认按钮-sql增强-更新操作
//	 * @param id
//	 * @return
//	 */
// 	public boolean doUpdateSql(TaoBaoOAuth t){
//	 	return true;
// 	}
// 	/**
//	 * 默认按钮-sql增强-删除操作
//	 * @param id
//	 * @return
//	 */
// 	public boolean doDelSql(TaoBaoOAuth t){
//	 	return true;
// 	}
// 	
//// 	/**
////	 * 替换sql中的变量
////	 * @param sql
////	 * @return
////	 */
//// 	public String replaceVal(String sql,TaobaoOauthEntity t){
//// 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
//// 		sql  = sql.replace("#{access_token}",String.valueOf(t.getAccessToken()));
//// 		sql  = sql.replace("#{expire_time}",String.valueOf(t.getExpireTime()));
//// 		sql  = sql.replace("#{expires_in}",String.valueOf(t.getExpiresIn()));
//// 		sql  = sql.replace("#{r1_expires_in}",String.valueOf(t.getR1ExpiresIn()));
//// 		sql  = sql.replace("#{r1_valid}",String.valueOf(t.getR1Valid()));
//// 		sql  = sql.replace("#{r2_expires_in}",String.valueOf(t.getR2ExpiresIn()));
//// 		sql  = sql.replace("#{r2_valid}",String.valueOf(t.getR2Valid()));
//// 		sql  = sql.replace("#{re_expires_in}",String.valueOf(t.getReExpiresIn()));
//// 		sql  = sql.replace("#{refresh_token}",String.valueOf(t.getRefreshToken()));
//// 		sql  = sql.replace("#{refresh_token_valid_time}",String.valueOf(t.getRefreshTokenValidTime()));
//// 		sql  = sql.replace("#{taobao_user_id}",String.valueOf(t.getTaobaoUserId()));
//// 		sql  = sql.replace("#{taobao_user_nick}",String.valueOf(t.getTaobaoUserNick()));
//// 		sql  = sql.replace("#{token_type}",String.valueOf(t.getTokenType()));
//// 		sql  = sql.replace("#{w1_expires_in}",String.valueOf(t.getW1ExpiresIn()));
//// 		sql  = sql.replace("#{w1_valid}",String.valueOf(t.getW1Valid()));
//// 		sql  = sql.replace("#{w2_expires_in}",String.valueOf(t.getW2ExpiresIn()));
//// 		sql  = sql.replace("#{w2_valid}",String.valueOf(t.getW2Valid()));
//// 		sql  = sql.replace("#{sub_taobao_user_id}",String.valueOf(t.getSubTaobaoUserId()));
//// 		sql  = sql.replace("#{sub_taobao_user_nick}",String.valueOf(t.getSubTaobaoUserNick()));
//// 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
//// 		return sql;
//// 	}
//}