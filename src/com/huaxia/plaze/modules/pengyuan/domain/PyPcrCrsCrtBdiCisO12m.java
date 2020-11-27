package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告银行信用信息信用卡最近12个月的月透支余额表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtBdiCisO12m {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 起始月份
	private String firstMonth;
	// 终止月份
	private String lastMonth;
	// 最近12个月的月透支余额
	private String limitValues;

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

	public String getFirstMonth() {
		return firstMonth;
	}

	public void setFirstMonth(String firstMonth) {
		this.firstMonth = firstMonth;
	}

	public String getLastMonth() {
		return lastMonth;
	}

	public void setLastMonth(String lastMonth) {
		this.lastMonth = lastMonth;
	}

	public String getLimitValues() {
		return limitValues;
	}

	public void setLimitValues(String limitValues) {
		this.limitValues = limitValues;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtBdiCisO12m [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId="
				+ trnId + ", firstMonth=" + firstMonth + ", lastMonth=" + lastMonth + ", limitValues=" + limitValues
				+ "]";
	}

}
