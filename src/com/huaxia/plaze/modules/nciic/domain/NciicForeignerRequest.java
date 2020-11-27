package com.huaxia.plaze.modules.nciic.domain;

import java.util.Date;

public class NciicForeignerRequest {

	private String uuid;
	private Date crtTime;
	private String crtUser;
	private String trnId;
	private String requestChannel;
	private String queryMode;
	private String certType;
	private String certNo;
	private String name;
	private String birth;
	private String expiryDate;

	public NciicForeignerRequest() {
	}

	public NciicForeignerRequest(String crtUser, String trnId, String requestChannel, String queryMode, String certType,
			String certNo, String name, String birth,String expiryDate) {
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.requestChannel = requestChannel;
		this.queryMode = queryMode;
		this.certType = certType;
		this.certNo = certNo;
		this.name = name;
		this.birth = birth;
		this.expiryDate = expiryDate;
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

	public String getBirth() {
		return birth;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
}
