package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;

/**
 * 鹏元个人信用报告查询条件表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtQcs {

	// 记录编号
	private String uuid;
	// 创建时间
	private Date crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 查询条件英文名称
	private String name;
	// 查询条件中文名称
	private String caption;
	// 查询条件值
	private String conditionValue;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getConditionValue() {
		return conditionValue;
	}

	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtQcs [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", name=" + name + ", caption=" + caption + ", conditionValue=" + conditionValue + "]";
	}

}
