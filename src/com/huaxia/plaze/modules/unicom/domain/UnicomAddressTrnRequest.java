package com.huaxia.plaze.modules.unicom.domain;
/**
 * 联通地址类信息,请求参数实体类
 * @author lipengfei
 *
 */
public class UnicomAddressTrnRequest {

	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 交易渠道
	private String requestChannel;
	// 查询方式
	private String queryMode;
	// 姓名
	private String name;
	// 手机号码
	private String mobile;
	// 运营商类别
	private String carrier;
	// 产品Id
	private String apiKey;
	// 详细地址
	private String address;
	
	
	public UnicomAddressTrnRequest() {
		super();
	}


	public UnicomAddressTrnRequest(String crtUser, String trnId, String requestChannel, String queryMode, String name,
			String mobile, String carrier, String apiKey, String address) {
		super();
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.requestChannel = requestChannel;
		this.queryMode = queryMode;
		this.name = name;
		this.mobile = mobile;
		this.carrier = carrier;
		this.apiKey = apiKey;
		this.address = address;
	}


	public String getCrtUser() {
		return crtUser;
	}


	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}


	public String getTrnId() {
		return trnId;
	}


	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}


	public String getRequestChannel() {
		return requestChannel;
	}


	public void setRequestChannel(String requestChannel) {
		this.requestChannel = requestChannel;
	}


	public String getQueryMode() {
		return queryMode;
	}


	public void setQueryMode(String queryMode) {
		this.queryMode = queryMode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getCarrier() {
		return carrier;
	}


	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}


	public String getApiKey() {
		return apiKey;
	}


	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
}
