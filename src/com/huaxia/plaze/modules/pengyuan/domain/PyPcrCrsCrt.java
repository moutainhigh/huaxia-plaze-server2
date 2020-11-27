package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;

/**
 * 鹏元个人信用报告报告表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrt {

	// 记录编号
	private String uuid;
	// 创建时间
	private Date crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 报告编号
	private String reportId;
	// 报告生成结束时间
	private String buildEnTime;
	// 查询原因ID
	private int queryReasonId;
	// 查询的收费子报告ID
	private String subReportTypes;
	// 对应的收费子报告收费次数
	private String treatResult;
	// 报告类型简称
	private String subReportTypesShortCaption;
	// 引用ID
	private String refId;
	// 有否系统错误
	private String hasSystemError;
	// 该客户是否被冻结
	private String isFrozen;

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

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getBuildEnTime() {
		return buildEnTime;
	}

	public void setBuildEnTime(String buildEnTime) {
		this.buildEnTime = buildEnTime;
	}

	public int getQueryReasonId() {
		return queryReasonId;
	}

	public void setQueryReasonId(int queryReasonId) {
		this.queryReasonId = queryReasonId;
	}

	public String getSubReportTypes() {
		return subReportTypes;
	}

	public void setSubReportTypes(String subReportTypes) {
		this.subReportTypes = subReportTypes;
	}

	public String getTreatResult() {
		return treatResult;
	}

	public void setTreatResult(String treatResult) {
		this.treatResult = treatResult;
	}

	public String getSubReportTypesShortCaption() {
		return subReportTypesShortCaption;
	}

	public void setSubReportTypesShortCaption(String subReportTypesShortCaption) {
		this.subReportTypesShortCaption = subReportTypesShortCaption;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getHasSystemError() {
		return hasSystemError;
	}

	public void setHasSystemError(String hasSystemError) {
		this.hasSystemError = hasSystemError;
	}

	public String getIsFrozen() {
		return isFrozen;
	}

	public void setIsFrozen(String isFrozen) {
		this.isFrozen = isFrozen;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrt [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", reportId=" + reportId + ", buildEnTime=" + buildEnTime + ", queryReasonId=" + queryReasonId
				+ ", subReportTypes=" + subReportTypes + ", treatResult=" + treatResult
				+ ", subReportTypesShortCaption=" + subReportTypesShortCaption + ", refId=" + refId
				+ ", hasSystemError=" + hasSystemError + ", isFrozen=" + isFrozen + "]";
	}

	public PyPcrCrsCrt(String uuid, Date crtTime, String crtUser, String trnId, String reportId, String buildEnTime,
			int queryReasonId, String subReportTypes, String treatResult, String subReportTypesShortCaption,
			String refId, String hasSystemError, String isFrozen) {
		this.uuid = uuid;
		this.crtTime = crtTime;
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.reportId = reportId;
		this.buildEnTime = buildEnTime;
		this.queryReasonId = queryReasonId;
		this.subReportTypes = subReportTypes;
		this.treatResult = treatResult;
		this.subReportTypesShortCaption = subReportTypesShortCaption;
		this.refId = refId;
		this.hasSystemError = hasSystemError;
		this.isFrozen = isFrozen;
	}

	public PyPcrCrsCrt() {
	}

}
