package com.huaxia.plaze.modules.bairong.domain;

import java.util.Date;

/**
 * 距最近相关机构申请的相关天数
 * 
 * @author Liuwei
 */
public class ApplyLoanStrLst {
	
	private String trnKey;

	// 主键唯一
	private String uuid;

	// 创建时间
	private Date crtTime;

	// 创建用户
	private String crtUser;

	// 业务的主键，实现不同系统之间的同步
	private String trnId;

	// 申请件编号
	private String appId;

	// 按身份证号查询，距最近在银行机构申请的间隔天数
	private String lstIdBankInteday;

	// 按身份证号查询，最近开始在银行机构连续申请的次数
	private String lstIdBankConsnum;

	// 按身份证号查询，最近开始在银行机构连续申请的持续天数
	private String lstIdBankCsinteday;

	// 按身份证号查询，距最近在非银行机构申请的间隔天数
	private String lstIdNbankInteday;

	// 按身份证号查询，最近开始在非银行机构连续申请的次数
	private String lstIdNbankConsnum;

	// 按身份证号查询，最近开始在非银机构连续申请的持续天数
	private String lstIdNbankCsinteday;

	// 按手机号查询，距最近在银行机构申请的间隔天数
	private String lstCellBankInteday;

	// 按手机号查询，最近开始在银行机构连续申请的次数
	private String lstCellBankConsnum;

	// 按手机号查询，最近开始在银行机构连续申请的持续天数
	private String lstCellBankCsinteday;

	// 按手机号查询，距最近在非银机构申请的间隔天数
	private String lstCellNbankInteday;

	// 按手机号查询，最近开始在非银机构连续申请的次数
	private String lstCellNbankConsnum;

	// 按手机号查询，最近开始在非银机构连续申请的持续天数
	private String lstCellNbankCsinteday;

	public String getUuid() {
		return uuid;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public String getCrtUser() {
		return crtUser;
	}

	public String getTrnId() {
		return trnId;
	}

	public String getAppId() {
		return appId;
	}

	public String getLstIdBankInteday() {
		return lstIdBankInteday;
	}

	public String getLstIdBankConsnum() {
		return lstIdBankConsnum;
	}

	public String getLstIdBankCsinteday() {
		return lstIdBankCsinteday;
	}

	public String getLstIdNbankInteday() {
		return lstIdNbankInteday;
	}

	public String getLstIdNbankConsnum() {
		return lstIdNbankConsnum;
	}

	public String getLstIdNbankCsinteday() {
		return lstIdNbankCsinteday;
	}

	public String getLstCellBankInteday() {
		return lstCellBankInteday;
	}

	public String getLstCellBankConsnum() {
		return lstCellBankConsnum;
	}

	public String getLstCellBankCsinteday() {
		return lstCellBankCsinteday;
	}

	public String getLstCellNbankInteday() {
		return lstCellNbankInteday;
	}

	public String getLstCellNbankConsnum() {
		return lstCellNbankConsnum;
	}

	public String getLstCellNbankCsinteday() {
		return lstCellNbankCsinteday;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setLstIdBankInteday(String lstIdBankInteday) {
		this.lstIdBankInteday = lstIdBankInteday;
	}

	public void setLstIdBankConsnum(String lstIdBankConsnum) {
		this.lstIdBankConsnum = lstIdBankConsnum;
	}

	public void setLstIdBankCsinteday(String lstIdBankCsinteday) {
		this.lstIdBankCsinteday = lstIdBankCsinteday;
	}

	public void setLstIdNbankInteday(String lstIdNbankInteday) {
		this.lstIdNbankInteday = lstIdNbankInteday;
	}

	public void setLstIdNbankConsnum(String lstIdNbankConsnum) {
		this.lstIdNbankConsnum = lstIdNbankConsnum;
	}

	public void setLstIdNbankCsinteday(String lstIdNbankCsinteday) {
		this.lstIdNbankCsinteday = lstIdNbankCsinteday;
	}

	public void setLstCellBankInteday(String lstCellBankInteday) {
		this.lstCellBankInteday = lstCellBankInteday;
	}

	public void setLstCellBankConsnum(String lstCellBankConsnum) {
		this.lstCellBankConsnum = lstCellBankConsnum;
	}

	public void setLstCellBankCsinteday(String lstCellBankCsinteday) {
		this.lstCellBankCsinteday = lstCellBankCsinteday;
	}

	public void setLstCellNbankInteday(String lstCellNbankInteday) {
		this.lstCellNbankInteday = lstCellNbankInteday;
	}

	public void setLstCellNbankConsnum(String lstCellNbankConsnum) {
		this.lstCellNbankConsnum = lstCellNbankConsnum;
	}

	public void setLstCellNbankCsinteday(String lstCellNbankCsinteday) {
		this.lstCellNbankCsinteday = lstCellNbankCsinteday;
	}

	public String getTrnKey() {
		return trnKey;
	}

	public void setTrnKey(String trnKey) {
		this.trnKey = trnKey;
	}

}
