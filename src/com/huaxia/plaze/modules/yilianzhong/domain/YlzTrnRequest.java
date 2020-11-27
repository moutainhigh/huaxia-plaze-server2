package com.huaxia.plaze.modules.yilianzhong.domain;

import java.util.Date;

public class YlzTrnRequest {

	//记录编号
	private String uuid;
	//创建时间
	private Date crtTime;
	//创建用户
	private String crtUser;
	//交易编号
	private String trnId;
	//查询模式
	private String queryMode;
	//被查询者姓名
	private String name;
	//被查询者证件号码
	private String certNo;
	//请求渠道
	private String requestChannel;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
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

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getRequestChannel() {
		return requestChannel;
	}

	public void setRequestChannel(String requestChannel) {
		this.requestChannel = requestChannel;
	}

	public YlzTrnRequest(String uuid, Date crtTime, String crtUser, String trnId, String queryMode, String name,
			String certNo, String requestChannel) {
		this.uuid = uuid;
		this.crtTime = crtTime;
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.queryMode = queryMode;
		this.name = name;
		this.certNo = certNo;
		this.requestChannel = requestChannel;
	}

	public YlzTrnRequest() {
	}

	@Override
	public String toString() {
		return "YlzTrnRequest [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", queryMode=" + queryMode + ", name=" + name + ", certNo=" + certNo + ", requestChannel="
				+ requestChannel + "]";
	}

}
