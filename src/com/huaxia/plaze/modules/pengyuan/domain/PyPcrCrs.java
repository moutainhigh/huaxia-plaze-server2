package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;

/**
 * 鹏元个人信用报告表
 * 
 * @author User
 *
 */
public class PyPcrCrs {

	// 记录编号
	private String uuid;
	// 创建时间
	private Date crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 查询批次号
	private String batchNo;
	// 查询单位名称
	private String unitName;
	// 分支结构名称
	private String subOrgan;
	// 查询操作员登录名
	private String queryUserId;
	// 查询请求数量
	private Integer queryCount;
	// 查询申请时间
	private String receiveTime;
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

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getSubOrgan() {
		return subOrgan;
	}

	public void setSubOrgan(String subOrgan) {
		this.subOrgan = subOrgan;
	}

	public String getQueryUserId() {
		return queryUserId;
	}

	public void setQueryUserId(String queryUserId) {
		this.queryUserId = queryUserId;
	}

	public Integer getQueryCount() {
		return queryCount;
	}

	public void setQueryCount(Integer queryCount) {
		this.queryCount = queryCount;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	@Override
	public String toString() {
		return "PyPcrCrs [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", batchNo=" + batchNo + ", unitName=" + unitName + ", subOrgan=" + subOrgan + ", queryUserId="
				+ queryUserId + ", queryCount=" + queryCount + ", receiveTime=" + receiveTime + "]";
	}

	public PyPcrCrs(String uuid, Date crtTime, String crtUser, String trnId, String batchNo, String unitName,
			String subOrgan, String queryUserId, int queryCount, String receiveTime) {
		this.uuid = uuid;
		this.crtTime = crtTime;
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.batchNo = batchNo;
		this.unitName = unitName;
		this.subOrgan = subOrgan;
		this.queryUserId = queryUserId;
		this.queryCount = queryCount;
		this.receiveTime = receiveTime;
	}

	public PyPcrCrs() {
	}

}
