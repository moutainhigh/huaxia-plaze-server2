package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;

/**
 * 鹏元个人高信分返回原始报文表
 * 
 * @author liu.jiwei
 *
 */
public class PyPwslMsgResponse {

	private String uuid;
	private Date crtTime;
	private String crtUser;
	private String trnId;
	private String msaagesBody;

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

	public String getMsaagesBody() {
		return msaagesBody;
	}

	public void setMsaagesBody(String msaagesBody) {
		this.msaagesBody = msaagesBody;
	}

	public PyPwslMsgResponse(String uuid, Date crtTime, String crtUser, String trnId, String msaagesBody) {
		this.uuid = uuid;
		this.crtTime = crtTime;
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.msaagesBody = msaagesBody;
	}

	public PyPwslMsgResponse() {
	}

	@Override
	public String toString() {
		return "PyPwslMsgResponse [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", msaagesBody=" + msaagesBody + "]";
	}

}
