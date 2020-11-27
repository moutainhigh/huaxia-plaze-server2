package com.huaxia.plaze.modules.jianbing.domain;

import java.util.Date;

public class JianBingResponse {
	private String uuid;
	private Date crtTime;
	private String crtUser;
	private String trnId;
	private String resultCode;
	private String resultDesc;
	private String responseCode;
	private String responseDesc;
	private String success;
	private String resultJson;

	public JianBingResponse(String crtUser, String trnId, String resultCode, String resultDesc, String responseCode,
			String responseDesc, String success, String resultJson) {
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.resultCode = resultCode;
		this.resultDesc = resultDesc;
		this.responseCode = responseCode;
		this.responseDesc = responseDesc;
		this.success = success;
		this.resultJson = resultJson;
	}

	public JianBingResponse() {
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

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
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

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getResultJson() {
		return resultJson;
	}

	public void setResultJson(String resultJson) {
		this.resultJson = resultJson;
	}

	@Override
	public String toString() {
		return "HarMoblResponse [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", responseCode=" + responseCode
				+ ", responseDesc=" + responseDesc + ", success=" + success + ", resultJson=" + resultJson + "]";
	}

}
