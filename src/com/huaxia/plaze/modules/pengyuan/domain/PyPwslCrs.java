package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;

/**
 * 鹏元个人高信分表
 * 
 * @author liu.jiwei
 *
 */
public class PyPwslCrs {

	private String uuid;
	private Date crtTime;
	private String crtUser;
	private String trnId;
	private String batchNo;
	private String unitName;
	private String subOrgan;
	private String queryUserId;
	private int queryCount;
	private String receiveTime;
	private String appId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "PyPwslCrs [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", batchNo=" + batchNo + ", unitName=" + unitName + ", subOrgan=" + subOrgan + ", queryUserId="
				+ queryUserId + ", queryCount=" + queryCount + ", receiveTime=" + receiveTime + "]";
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

	public int getQueryCount() {
		return queryCount;
	}

	public void setQueryCount(int queryCount) {
		this.queryCount = queryCount;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public PyPwslCrs(String uuid, Date crtTime, String crtUser, String trnId, String batchNo, String unitName,
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

	public PyPwslCrs() {
	}
}