package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告银行信用信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtBdi {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 子报告ID
	private String subReportType;
	// 收费子报告ID
	private String subReportTypeCost;
	// 子报告状态ID
	private String treatResult;
	// 错误代码
	private String TreatErrorCode;
	// 错误信息
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

	public String getSubReportType() {
		return subReportType;
	}

	public void setSubReportType(String subReportType) {
		this.subReportType = subReportType;
	}

	public String getSubReportTypeCost() {
		return subReportTypeCost;
	}

	public void setSubReportTypeCost(String subReportTypeCost) {
		this.subReportTypeCost = subReportTypeCost;
	}

	public String getTreatResult() {
		return treatResult;
	}

	public void setTreatResult(String treatResult) {
		this.treatResult = treatResult;
	}

	public String getTreatErrorCode() {
		return TreatErrorCode;
	}

	public void setTreatErrorCode(String treatErrorCode) {
		TreatErrorCode = treatErrorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtBdi [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", subReportType=" + subReportType + ", subReportTypeCost=" + subReportTypeCost + ", treatResult="
				+ treatResult + ", TreatErrorCode=" + TreatErrorCode + ", errorMessage=" + errorMessage + "]";
	}

}
