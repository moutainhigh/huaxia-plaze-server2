package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;

public class PyCrsResponse {

	private String uuid;
	private Date CrtTime;
	private String crtUser;
	private String trnId;
	private String messageBody;
	private String appId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCrtTime() {
		return CrtTime;
	}

	public void setCrtTime(Date crtTime) {
		CrtTime = crtTime;
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

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public PyCrsResponse(String crtUser, String trnId, String messageBody) {
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.messageBody = messageBody;
	}

	@Override
	public String toString() {
		return "PyCrsResponse [uuid=" + uuid + ", CrtTime=" + CrtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", messageBody=" + messageBody + "]";
	}

}
