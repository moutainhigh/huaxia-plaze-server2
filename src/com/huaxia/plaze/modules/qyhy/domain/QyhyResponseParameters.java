package com.huaxia.plaze.modules.qyhy.domain;

import java.util.Date;

public class QyhyResponseParameters {
	private String uuid;
	private Date crtTime;
	private String crtUser;
	private String trnId;
	private String responseCode;
	private String responseDesc;
	private String responseBody;//原始报文
	
	
	public QyhyResponseParameters(String uuid, Date crtTime, String crtUser, String trnId, String responseCode,
			String responseDesc, String responseBody) {
		super();
		this.uuid = uuid;
		this.crtTime = crtTime;
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.responseCode = responseCode;
		this.responseDesc = responseDesc;
		this.responseBody = responseBody;
	}


	public QyhyResponseParameters() {
		
	}


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
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseDesc() {
		return responseDesc;
	}
	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}
	
	public String getResponseBody() {
		return responseBody;
	}


	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}


	@Override
	public String toString() {
		return "QyhyResponseParameters [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId="
				+ trnId + ", responseCode=" + responseCode + ", responseDesc=" + responseDesc + ", responseBody="
				+ responseBody + "]";
	}
	
}
