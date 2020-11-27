package com.huaxia.plaze.modules.fico.domain;

import java.util.Date;

public class Fico {
	
	//记录编号
	private String uuid;
	
	//创建时间
	private Date crtTime;
	
	//创建人
	private String crtUser;
	
	//申请件编号
	private String appid;

	//返回码
	private String retCoode;
	
	//评分结果
	private Long scoreId;
	
	//原因码
	private String reason;
	
	//返回码描述
	private String errMsg;
	
	//fico大数据分
	private Integer score;
	
	//是否有人行报告
	private String  pboc;
	
    //客户欺诈等级数字，从1到20共20个等级。
	private String fraud;

	//业务的主键，实现不同系统之间的同步
    private String trnId;
    
    /** 证件号 */
    private String certNo;
    
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getRetCoode() {
		return retCoode;
	}

	public void setRetCoode(String retCoode) {
		this.retCoode = retCoode;
	}

	public Long getScoreId() {
		return scoreId;
	}

	public void setScoreId(Long scoreId) {
		this.scoreId = scoreId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getPboc() {
		return pboc;
	}

	public void setPboc(String pboc) {
		this.pboc = pboc;
	}

	public String getFraud() {
		return fraud;
	}

	public void setFraud(String fraud) {
		this.fraud = fraud;
	}
	public String getTrnId() {
		return trnId;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}
	
	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	@Override
	public String toString() {
		return "Fico [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", appid=" + appid
				+ ", retCoode=" + retCoode + ", scoreId=" + scoreId + ", reason=" + reason + ", errMsg=" + errMsg
				+ ", score=" + score + ", pboc=" + pboc + ", fraud=" + fraud + ", trnId=" + trnId + "]";
	}

}