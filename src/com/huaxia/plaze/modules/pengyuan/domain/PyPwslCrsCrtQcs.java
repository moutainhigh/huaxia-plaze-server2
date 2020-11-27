package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;

/**
 * 鹏元个人高信分报告查询条件表
 * 
 * @author liu.jiwei
 *
 */
public class PyPwslCrsCrtQcs {

	private String uuid;
	private Date crtTime;
	private String crtUser;
	private String TrnId;
	private String name;
	private String caption;
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
		return TrnId;
	}

	public void setTrnId(String trnId) {
		TrnId = trnId;
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
		return "PyPwslCrsCrtQcs [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", TrnId=" + TrnId
				+ ", name=" + name + ", caption=" + caption + ", conditionValue=" + conditionValue + "]";
	}

	public PyPwslCrsCrtQcs(String uuid, Date crtTime, String crtUser, String trnId, String name, String caption,
			String conditionValue) {
		this.uuid = uuid;
		this.crtTime = crtTime;
		this.crtUser = crtUser;
		TrnId = trnId;
		this.name = name;
		this.caption = caption;
		this.conditionValue = conditionValue;
	}

	public PyPwslCrsCrtQcs() {
	}

}
