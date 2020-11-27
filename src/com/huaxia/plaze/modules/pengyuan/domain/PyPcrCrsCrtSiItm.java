package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告特别信息内容表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtSiItm {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 信息类型
	private Integer infoType;
	// 信息来源单位中文名称
	private String infoUnit;
	// 信息提供单位来源部门
	private String infoDepartment;
	// 信息描述时间的发生时间
	private String occurDate;
	// 特别信息内容描述
	private String content;
	// 信息获取日期
	private String infoDate;

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

	public Integer getInfoType() {
		return infoType;
	}

	public void setInfoType(Integer infoType) {
		this.infoType = infoType;
	}

	public String getInfoUnit() {
		return infoUnit;
	}

	public void setInfoUnit(String infoUnit) {
		this.infoUnit = infoUnit;
	}

	public String getInfoDepartment() {
		return infoDepartment;
	}

	public void setInfoDepartment(String infoDepartment) {
		this.infoDepartment = infoDepartment;
	}

	public String getOccurDate() {
		return occurDate;
	}

	public void setOccurDate(String occurDate) {
		this.occurDate = occurDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtSiItm [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", infoType=" + infoType + ", infoUnit=" + infoUnit + ", infoDepartment=" + infoDepartment
				+ ", occurDate=" + occurDate + ", content=" + content + ", infoDate=" + infoDate + ", appId=" + appId
				+ "]";
	}

	

}
