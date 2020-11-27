package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;

/**
 * 鹏元个人高信分报告表
 * 
 * @author liu.jiwei
 *
 */
public class PyPwslCrsCrt {

	private String uuid;
	private Date crtTime;
	private String crtUser;
	private String trnId;
	private String reportId;
	private String buildEnTime;
	private int queryReasonId;
	private String subReportTypes;
	private String treatResult;
	private String subReportTypesShortCaption;
	private String refId;
	private String hasSystemError;
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

	public String getBuildEnTIme() {
		return buildEnTime;
	}

	public void setBuildEnTIme(String buildEnTIme) {
		this.buildEnTime = buildEnTIme;
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

	public PyPwslCrsCrt(String uuid, Date crtTime, String crtUser, String trnId, String reportId, String buildEnTime,
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

	public PyPwslCrsCrt() {
	}

	@Override
	public String toString() {
		return "PyPwslCrsCrt [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", reportId=" + reportId + ", buildEnTime=" + buildEnTime + ", queryReasonId=" + queryReasonId
				+ ", subReportTypes=" + subReportTypes + ", treatResult=" + treatResult
				+ ", subReportTypesShortCaption=" + subReportTypesShortCaption + ", refId=" + refId
				+ ", hasSystemError=" + hasSystemError + ", isFrozen=" + isFrozen + "]";
	}

}
