package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;


/**
 * 鹏元个人信用报告摘要信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtPbiSi {

	// 记录编号
	private String uuid;
	// 创建时间
	private Date crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 证件号码个数
	private Integer documentCount;
	// 该客户地址信息个数
	private Integer adressCount;
	// 该客户工作单位个数
	private Integer jobCount;
	// 曾用名次数
	private Integer histroyNameCount;
	// 身份警告次数
	private Integer documentAlertCount;
	// 历史报告查询次数
	private Integer queryReportCount;
	// 最近个人基本信息更新日期
	private String lastInfoDate;

	private String appId;

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

	public Integer getDocumentCount() {
		return documentCount;
	}

	public void setDocumentCount(Integer documentCount) {
		this.documentCount = documentCount;
	}

	public Integer getAdressCount() {
		return adressCount;
	}

	public void setAdressCount(Integer adressCount) {
		this.adressCount = adressCount;
	}

	public Integer getJobCount() {
		return jobCount;
	}

	public void setJobCount(Integer jobCount) {
		this.jobCount = jobCount;
	}

	public Integer getHistroyNameCount() {
		return histroyNameCount;
	}

	public void setHistroyNameCount(Integer histroyNameCount) {
		this.histroyNameCount = histroyNameCount;
	}

	public Integer getDocumentAlertCount() {
		return documentAlertCount;
	}

	public void setDocumentAlertCount(Integer documentAlertCount) {
		this.documentAlertCount = documentAlertCount;
	}

	public Integer getQueryReportCount() {
		return queryReportCount;
	}

	public void setQueryReportCount(Integer queryReportCount) {
		this.queryReportCount = queryReportCount;
	}

	public String getLastInfoDate() {
		return lastInfoDate;
	}

	public void setLastInfoDate(String lastInfoDate) {
		this.lastInfoDate = lastInfoDate;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtPbiSi [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", documentCount=" + documentCount + ", adressCount=" + adressCount + ", jobCount=" + jobCount
				+ ", histroyNameCount=" + histroyNameCount + ", documentAlertCount=" + documentAlertCount
				+ ", queryReportCount=" + queryReportCount + ", lastInfoDate=" + lastInfoDate + ", appId=" + appId
				+ "]";
	}


}
