package com.huaxia.plaze.modules.pengyuan.domain;

public class PyPwslTrnRequest {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 请求渠道
	private String requestChannel;
	// 查询模式
	private String queryMode;
	// 查询类型ID
//	private String queryType;
	// 被查询者姓名
	private String name;
	// 被查询者证件号码
	private String certNo;
	// 查询的收费子报告类型ID
//	private String subreportIds;
	// 查询原因ID
//	private int queryReaseonId;
	// 引用ID
//	private String refId;

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

//	public String getQueryType() {
//		return queryType;
//	}
//
//	public void setQueryType(String queryType) {
//		this.queryType = queryType;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

//	public String getSubreportIds() {
//		return subreportIds;
//	}
//
//	public void setSubreportIds(String subreportIds) {
//		this.subreportIds = subreportIds;
//	}
//
//	public int getQueryReaseonId() {
//		return queryReaseonId;
//	}
//
//	public void setQueryReaseonId(int queryReaseonId) {
//		this.queryReaseonId = queryReaseonId;
//	}
//
//	public String getRefId() {
//		return refId;
//	}
//
//	public void setRefId(String refId) {
//		this.refId = refId;
//	}

	public PyPwslTrnRequest() {
	}

	@Override
	public String toString() {
		return "PyPwslTrnRequest [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", requestChannel=" + requestChannel + ", queryMode=" + queryMode + ", name=" + name + ", certNo="
				+ certNo + ", appId=" + appId + "]";
	}

	public PyPwslTrnRequest(String uuid, String crtTime, String crtUser, String trnId, String requestChannel,
			String queryMode, String name, String certNo, String appId) {
		super();
		this.uuid = uuid;
		this.crtTime = crtTime;
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.requestChannel = requestChannel;
		this.queryMode = queryMode;
		this.name = name;
		this.certNo = certNo;
		this.appId = appId;
	}

	

}
