package com.ht.taobao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户授权后返回的 授权信息
 * @author ShiQiang
 *	
 */
@Entity
@Table(name = "ht_taobao_oauth", schema = "")
public class TaoBaoOAuth {
	/**id*/
	private java.lang.Long id;
	
	private String access_token;
	//时间
	private Long expire_time;
	//Access token过期时间
	private Long expires_in;
	//r1级别API或字段的访问过期时间；
	private Long r1_expires_in;
	private String r1_valid;
	//r2级别API或字段的访问过期时间；
	private Long r2_expires_in;
	private String r2_valid;
	//Refresh token过期时间
	private Long re_expires_in;
	//Refresh token，可用来刷新access_token
	private String refresh_token;
	private Long refresh_token_valid_time;
	//淘宝帐号对应id
	private String taobao_user_id;
	//淘宝账号
	private String taobao_user_nick;
	//Access token的类型目前只支持bearer
	private String token_type;
	//w1级别API或字段的访问过期时间；
	private Long w1_expires_in;
	private String w1_valid;
	//w2级别API或字段的访问过期时间；
	private Long w2_expires_in;
	private String w2_valid;
	//淘宝子账号对应id
	private String sub_taobao_user_id;
	//淘宝子账号
	private String sub_taobao_user_nick;
	
	private String user_id;
	
	@Column(name ="user_id",nullable=true,length=200)
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID",nullable=false,length=19)
	public java.lang.Long getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setId(java.lang.Long id){
		this.id = id;
	}
	
	@Column(name ="ACCESS_TOKEN",nullable=true,length=200)
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
	@Column(name ="EXPIRE_TIME",nullable=true,length=19)
	public Long getExpire_time() {
		return expire_time;
	}
	public void setExpire_time(Long expire_time) {
		this.expire_time = expire_time;
	}
	@Column(name ="EXPIRES_IN",nullable=true,length=19)
	public Long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}
	@Column(name ="R1_EXPIRES_IN",nullable=true,length=19)
	public Long getR1_expires_in() {
		return r1_expires_in;
	}
	public void setR1_expires_in(Long r1_expires_in) {
		this.r1_expires_in = r1_expires_in;
	}
	@Column(name ="R1_VALID",nullable=true,length=100)
	public String getR1_valid() {
		return r1_valid;
	}
	public void setR1_valid(String r1_valid) {
		this.r1_valid = r1_valid;
	}
	@Column(name ="R2_EXPIRES_IN",nullable=true,length=19)
	public Long getR2_expires_in() {
		return r2_expires_in;
	}
	public void setR2_expires_in(Long r2_expires_in) {
		this.r2_expires_in = r2_expires_in;
	}
	@Column(name ="R2_VALID",nullable=true,length=100)
	public String getR2_valid() {
		return r2_valid;
	}
	public void setR2_valid(String r2_valid) {
		this.r2_valid = r2_valid;
	}
	@Column(name ="RE_EXPIRES_IN",nullable=true,length=19)
	public Long getRe_expires_in() {
		return re_expires_in;
	}
	public void setRe_expires_in(Long re_expires_in) {
		this.re_expires_in = re_expires_in;
	}
	@Column(name ="REFRESH_TOKEN",nullable=true,length=200)
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	@Column(name ="REFRESH_TOKEN_VALID_TIME",nullable=true,length=19)
	public Long getRefresh_token_valid_time() {
		return refresh_token_valid_time;
	}
	public void setRefresh_token_valid_time(Long refresh_token_valid_time) {
		this.refresh_token_valid_time = refresh_token_valid_time;
	}
	@Column(name ="TAOBAO_USER_ID",nullable=true,length=19)
	public String getTaobao_user_id() {
		return taobao_user_id;
	}
	public void setTaobao_user_id(String taobao_user_id) {
		this.taobao_user_id = taobao_user_id;
	}
	@Column(name ="TAOBAO_USER_NICK",nullable=true,length=100)
	public String getTaobao_user_nick() {
		return taobao_user_nick;
	}
	public void setTaobao_user_nick(String taobao_user_nick) {
		this.taobao_user_nick = taobao_user_nick;
	}
	@Column(name ="TOKEN_TYPE",nullable=true,length=100)
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	@Column(name ="W1_EXPIRES_IN",nullable=true,length=19)
	public Long getW1_expires_in() {
		return w1_expires_in;
	}
	public void setW1_expires_in(Long w1_expires_in) {
		this.w1_expires_in = w1_expires_in;
	}
	@Column(name ="W1_VALID",nullable=true,length=100)
	public String getW1_valid() {
		return w1_valid;
	}
	public void setW1_valid(String w1_valid) {
		this.w1_valid = w1_valid;
	}
	@Column(name ="W2_EXPIRES_IN",nullable=true,length=19)
	public Long getW2_expires_in() {
		return w2_expires_in;
	}
	public void setW2_expires_in(Long w2_expires_in) {
		this.w2_expires_in = w2_expires_in;
	}
	@Column(name ="W2_VALID",nullable=true,length=100)
	public String getW2_valid() {
		return w2_valid;
	}
	public void setW2_valid(String w2_valid) {
		this.w2_valid = w2_valid;
	}
	@Column(name ="SUB_TAOBAO_USER_ID",nullable=true,length=19)
	public String getSub_taobao_user_id() {
		return sub_taobao_user_id;
	}
	public void setSub_taobao_user_id(String sub_taobao_user_id) {
		this.sub_taobao_user_id = sub_taobao_user_id;
	}
	@Column(name ="SUB_TAOBAO_USER_NICK",nullable=true,length=100)
	public String getSub_taobao_user_nick() {
		return sub_taobao_user_nick;
	}
	public void setSub_taobao_user_nick(String sub_taobao_user_nick) {
		this.sub_taobao_user_nick = sub_taobao_user_nick;
	}
}
