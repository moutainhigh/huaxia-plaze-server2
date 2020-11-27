package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告深圳基本摘要信息基本信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtSzbsiBss {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 曾用名次数
	private Integer historyNameCount;
	// 身份预警次数
	private Integer documentAlertCount;
	// 历史信用报告查询次数
	private Integer queryReportCount;

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

	public Integer getHistoryNameCount() {
		return historyNameCount;
	}

	public void setHistoryNameCount(Integer historyNameCount) {
		this.historyNameCount = historyNameCount;
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

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtSzbsiBss [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId="
				+ trnId + ", historyNameCount=" + historyNameCount + ", documentAlertCount=" + documentAlertCount
				+ ", queryReportCount=" + queryReportCount + ", appId=" + appId + "]";
	}

	
}
