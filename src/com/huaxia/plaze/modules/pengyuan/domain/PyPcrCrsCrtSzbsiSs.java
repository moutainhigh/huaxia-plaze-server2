package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告深圳基本摘要信息评分信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtSzbsiSs {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 综合评分
	private Integer score;
	// 评分日期
	private String scoringDate;

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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getScoringDate() {
		return scoringDate;
	}

	public void setScoringDate(String scoringDate) {
		this.scoringDate = scoringDate;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtSzbsiSs [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", score=" + score + ", scoringDate=" + scoringDate + ", appId=" + appId + "]";
	}


}
