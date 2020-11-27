package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告个人社会保险信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtSisz2 {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 子报告ID
	private Integer subReportType;
	// 收费子报告ID
	private Integer subReprotTypeCount;
	// 子报告查询状态
	private Integer treatResult;
	// 错误代码
	private String treatErrorCode;
	// 错误信息
	private String errorMessage;

	private String appId;

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

	public Integer getSubReportType() {
		return subReportType;
	}

	public void setSubReportType(Integer subReportType) {
		this.subReportType = subReportType;
	}

	public Integer getSubReprotTypeCount() {
		return subReprotTypeCount;
	}

	public void setSubReprotTypeCount(Integer subReprotTypeCount) {
		this.subReprotTypeCount = subReprotTypeCount;
	}

	public Integer getTreatResult() {
		return treatResult;
	}

	public void setTreatResult(Integer treatResult) {
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

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtSisz2 [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", subReportType=" + subReportType + ", subReprotTypeCount=" + subReprotTypeCount + ", treatResult="
				+ treatResult + ", treatErrorCode=" + treatErrorCode + ", errorMessage=" + errorMessage + ", appId="
				+ appId + "]";
	}

	
}
