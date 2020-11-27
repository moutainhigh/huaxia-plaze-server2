package com.huaxia.plaze.modules.tongdun.domain;

import java.util.Date;

/**
 * 多头借贷信贷逾期统计详情表
 * 
 * @author liuwei
 *
 */
public class MulBorDescreditCount {

	// 主键唯一
	private String uuid;

	// 创建时间
	private Date crtTime;

	// 创建用户
	private String crtUser;

	// 关联外键
	private String refUuid;

	
	// 规则类型
	private String type;

	// 规则描述
	private String description;

	// 信贷逾期次数
	private Integer discreditTimes;

	// 平台个数
	private Integer platformCount;

	// 逾期时间
	private String overdueTime;

	// 逾期金额区间
	private String overdueAmountRange;

	// 逾期笔数
	private Integer overdueCount;

	// 逾期时间区间
	private String overdueDayRange;

	//业务的主键，实现不同系统之间的同步
    private String trnId;
    
	//申请件编号
	private String appId;
	
	public String getTrnId() {
		return trnId;
	}
	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}
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

	public String getRefUuid() {
		return refUuid;
	}

	public void setRefUuid(String refUuid) {
		this.refUuid = refUuid;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDiscreditTimes() {
		return discreditTimes;
	}

	public void setDiscreditTimes(Integer discreditTimes) {
		this.discreditTimes = discreditTimes;
	}

	public Integer getPlatformCount() {
		return platformCount;
	}

	public void setPlatformCount(Integer platformCount) {
		this.platformCount = platformCount;
	}

	public String getOverdueTime() {
		return overdueTime;
	}

	public void setOverdueTime(String overdueTime) {
		this.overdueTime = overdueTime;
	}

	public String getOverdueAmountRange() {
		return overdueAmountRange;
	}

	public void setOverdueAmountRange(String overdueAmountRange) {
		this.overdueAmountRange = overdueAmountRange;
	}

	public Integer getOverdueCount() {
		return overdueCount;
	}

	public void setOverdueCount(Integer overdueCount) {
		this.overdueCount = overdueCount;
	}

	public String getOverdueDayRange() {
		return overdueDayRange;
	}

	public void setOverdueDayRange(String overdueDayRange) {
		this.overdueDayRange = overdueDayRange;
	}
	@Override
	public String toString() {
		return "MulBorDescreditCount [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", refUuid="
				+ refUuid + ", type=" + type + ", description=" + description + ", discreditTimes=" + discreditTimes
				+ ", platformCount=" + platformCount + ", overdueTime=" + overdueTime + ", overdueAmountRange="
				+ overdueAmountRange + ", overdueCount=" + overdueCount + ", overdueDayRange=" + overdueDayRange
				+ ", trnId=" + trnId + ", appId=" + appId + "]";
	}

}
