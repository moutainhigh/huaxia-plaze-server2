package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 
 * @author User 鹏元个人信用报告近两年历史查询明细内容表
 */
public class PyPcrCrsCrtHqiItm {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 查询单位ID
	private Integer unit;
	// 查询原因ID
	private Integer queryReason;
	// 查询单位所属单位类型ID
	private Integer unitMemberId;
	// 查询单位名称
	private String unitMember;
	// 查询日期
	private String queryDate;

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

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Integer getQueryReason() {
		return queryReason;
	}

	public void setQueryReason(Integer queryReason) {
		this.queryReason = queryReason;
	}

	public Integer getUnitMemberId() {
		return unitMemberId;
	}

	public void setUnitMemberId(Integer unitMemberId) {
		this.unitMemberId = unitMemberId;
	}

	public String getUnitMember() {
		return unitMember;
	}

	public void setUnitMember(String unitMember) {
		this.unitMember = unitMember;
	}

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtHqiItm [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", unit=" + unit + ", queryReason=" + queryReason + ", unitMemberId=" + unitMemberId + ", unitMember="
				+ unitMember + ", queryDate=" + queryDate + ", appId=" + appId + "]";
	}


}
