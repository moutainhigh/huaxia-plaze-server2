package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;

/**
 * 鹏元个人高信分报告个人高信分信息内容表
 * 
 * @author liu.jiwei
 *
 */
public class PyPwslCrsCrtPwlsItm {

	private String uuid;
	private Date crtTime;
	private String crtUser;
	private String trnId;
	private String score;
	private String grade;
	private String advice;
	private String label;
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

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "PyPwslCrsCrtPwlsItm [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId="
				+ trnId + ", score=" + score + ", grade=" + grade + ", advice=" + advice + ", label=" + label + "]";
	}

	public PyPwslCrsCrtPwlsItm(String uuid, Date crtTime, String crtUser, String trnId, String score, String grade,
			String advice, String label) {
		this.uuid = uuid;
		this.crtTime = crtTime;
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.score = score;
		this.grade = grade;
		this.advice = advice;
		this.label = label;
	}

	public PyPwslCrsCrtPwlsItm() {
	}

}
