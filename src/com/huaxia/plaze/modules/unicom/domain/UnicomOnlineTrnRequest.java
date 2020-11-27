package com.huaxia.plaze.modules.unicom.domain;

/**
 * 
 * @author dingguofeng
 * 联通在网时长  渠道请求参数实体类
 *
 */
public class UnicomOnlineTrnRequest {
	
	/** 创建用户 */
	private String crtUser;
	
	/** 业务主键 */
	private String trnId;
	
	/** 交易渠道 */
	private String requestChannel;
	
	/** 查询方式 */
	private String queryMode;
	
	/** 证件类型 */
	private String certType;
	
	/** 证件号码 */
	private String certNo;
	
	/** 姓名 */
	private String name;
	
	/** 手机号码 */
	private String mobile;

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

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
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
	
}
