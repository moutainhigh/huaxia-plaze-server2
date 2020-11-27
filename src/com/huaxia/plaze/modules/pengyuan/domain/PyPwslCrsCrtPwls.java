package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人高信分报告个人高信分信息表
 * 
 * @author liu.jiwei
 *
 */
public class PyPwslCrsCrtPwls {

	private String uuid;
	private String crtTime;
	private String crtUser;
	private String trnId;
	private int subReportType;
	private int subReportCost;
	private int treatResult;
	private String treatErrorCode;
	private String errorMessage;

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

	public String getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(String crtTime) {
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

	public int getSubReportType() {
		return subReportType;
	}

	public void setSubReportType(int subReportType) {
		this.subReportType = subReportType;
	}

	public int getSubReportCost() {
		return subReportCost;
	}

	public void setSubReportCost(int subReportCost) {
		this.subReportCost = subReportCost;
	}

	public int getTreatResult() {
		return treatResult;
	}

	public void setTreatResult(int treatResult) {
		this.treatResult = treatResult;
	}

	public String getTreatErrorCode() {
		return treatErrorCode;
	}

	public void setTreatErrorCode(String treatErrorCode) {
		this.treatErrorCode = treatErrorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public PyPwslCrsCrtPwls(String uuid, String crtTime, String crtUser, String trnId, int subReportType,
			int subReportCost, int treatResult, String treatErrorCode, String errorMessage) {
		this.uuid = uuid;
		this.crtTime = crtTime;
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.subReportType = subReportType;
		this.subReportCost = subReportCost;
		this.treatResult = treatResult;
		this.treatErrorCode = treatErrorCode;
		this.errorMessage = errorMessage;
	}

	public PyPwslCrsCrtPwls() {
	}

	@Override
	public String toString() {
		return "PyPwslCrsCrtPwls [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", subReportType=" + subReportType + ", subReportCost=" + subReportCost + ", treatResult="
				+ treatResult + ", treatErrorCode=" + treatErrorCode + ", errorMessage=" + errorMessage + "]";
	}

}
