package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告个人社会保险近5年内参保信息汇总表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtSisz2Si5y {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 最近12个月累计参保次数
	private Integer timesRecently12Months;
	// 最近24个月累计参保次数
	private Integer timesRecently24Months;
	// 最近36个月累计参保次数
	private Integer timesRecently36Months;
	// 最近48个月累计参保次数
	private Integer timesRecently48Months;
	// 最近60个月累计参保次数
	private Integer timesRecently60Months;
	// 60个月内最近连续参保次数
	private Integer stRecently60Months;
	// 最近60个月参保单位总数
	private Integer ucRecently60Months;
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
	public Integer getTimesRecently12Months() {
		return timesRecently12Months;
	}
	public void setTimesRecently12Months(Integer timesRecently12Months) {
		this.timesRecently12Months = timesRecently12Months;
	}
	public Integer getTimesRecently24Months() {
		return timesRecently24Months;
	}
	public void setTimesRecently24Months(Integer timesRecently24Months) {
		this.timesRecently24Months = timesRecently24Months;
	}
	public Integer getTimesRecently36Months() {
		return timesRecently36Months;
	}
	public void setTimesRecently36Months(Integer timesRecently36Months) {
		this.timesRecently36Months = timesRecently36Months;
	}
	public Integer getTimesRecently48Months() {
		return timesRecently48Months;
	}
	public void setTimesRecently48Months(Integer timesRecently48Months) {
		this.timesRecently48Months = timesRecently48Months;
	}
	public Integer getTimesRecently60Months() {
		return timesRecently60Months;
	}
	public void setTimesRecently60Months(Integer timesRecently60Months) {
		this.timesRecently60Months = timesRecently60Months;
	}
	public Integer getStRecently60Months() {
		return stRecently60Months;
	}
	public void setStRecently60Months(Integer stRecently60Months) {
		this.stRecently60Months = stRecently60Months;
	}
	public Integer getUcRecently60Months() {
		return ucRecently60Months;
	}
	public void setUcRecently60Months(Integer ucRecently60Months) {
		this.ucRecently60Months = ucRecently60Months;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	@Override
	public String toString() {
		return "PyPcrCrsCrtSisz2Si5y [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId="
				+ trnId + ", timesRecently12Months=" + timesRecently12Months + ", timesRecently24Months="
				+ timesRecently24Months + ", timesRecently36Months=" + timesRecently36Months
				+ ", timesRecently48Months=" + timesRecently48Months + ", timesRecently60Months="
				+ timesRecently60Months + ", stRecently60Months=" + stRecently60Months + ", ucRecently60Months="
				+ ucRecently60Months + ", appId=" + appId + "]";
	}


}
