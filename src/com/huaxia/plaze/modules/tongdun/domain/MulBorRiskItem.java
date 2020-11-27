package com.huaxia.plaze.modules.tongdun.domain;

import java.util.Date;

/**
 * 多头借贷风险项目表
 * 
 * @author liwuei
 *
 */
public class MulBorRiskItem {
	
	// 主键唯一
	private String uuid;

	// 创建时间
	private Date crtTime;

	// 创建用户
	private String crtUser;

	// 逻辑外键
	private String pkUuid;

	// 关联外键
	private String refUuid;

	// 风险分数
	private Integer score;

	// 决策结果
	private String decision;

	// 规则名称
	private String riskName;

	// 策略决策结果
	private String policyDecision;

	// 车略决策模式
	private String policyMode;

	// 策略分数
	private String policyScore;

	// 策略名称
	private String policyName;

	// 规则编号
	private Integer ruleId;

	// 业务的主键，实现不同系统之间的同步
	private String trnId;

	// 申请件编号
	private String appId;

	public String getTrnId() {
		return trnId;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

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

	public String getRefUuid() {
		return refUuid;
	}

	public void setRefUuid(String refUuid) {
		this.refUuid = refUuid;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getPolicyDecision() {
		return policyDecision;
	}

	public void setPolicyDecision(String policyDecision) {
		this.policyDecision = policyDecision;
	}

	public String getPolicyMode() {
		return policyMode;
	}

	public void setPolicyMode(String policyMode) {
		this.policyMode = policyMode;
	}

	public String getPolicyScore() {
		return policyScore;
	}

	public void setPolicyScore(String policyScore) {
		this.policyScore = policyScore;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public String getPkUuid() {
		return pkUuid;
	}

	public void setPkUuid(String pkUuid) {
		this.pkUuid = pkUuid;
	}

	@Override
	public String toString() {
		return "MulBorRiskItem [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", pkUuid=" + pkUuid
				+ ", refUuid=" + refUuid + ", score=" + score + ", decision=" + decision + ", riskName=" + riskName
				+ ", policyDecision=" + policyDecision + ", policyMode=" + policyMode + ", policyScore=" + policyScore
				+ ", policyName=" + policyName + ", ruleId=" + ruleId + ", trnId=" + trnId + ", appId=" + appId + "]";
	}

}
