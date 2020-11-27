package com.huaxia.plaze.modules.baoxin.domain;

import java.util.Date;

public class BaoXinRequest {

	private String uuid;
	private Date crtTime;
	private String crtUser;
	private String trnId;
	private String requestChannel;
	private String queryMode;
	private String certType;
	private String certNo;
	private String name;
	private String insurerUuid;
	private String trnCode;
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
	public String getInsurerUuid() {
		return insurerUuid;
	}
	public void setInsurerUuid(String insurerUuid) {
		this.insurerUuid = insurerUuid;
	}
	public BaoXinRequest(String uuid, Date crtTime, String crtUser, String trnId, String requestChannel,
			String queryMode, String certType, String certNo, String name, String insurerUuid) {
		super();
		this.uuid = uuid;
		this.crtTime = crtTime;
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.requestChannel = requestChannel;
		this.queryMode = queryMode;
		this.certType = certType;
		this.certNo = certNo;
		this.name = name;
		this.insurerUuid = insurerUuid;
	}
	public BaoXinRequest() {
	}
	public String getTrnCode() {
		return trnCode;
	}
	public void setTrnCode(String trnCode) {
		this.trnCode = trnCode;
	}
	
}
