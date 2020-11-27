package com.huaxia.plaze.modules.tongdun.domain;

import java.util.Date;

/**
 * 多头借贷关注名单详情表
 * @author liwei
 *
 */
public class MulBorGreyList {


	//主键唯一
	private String uuid;

	//创建时间
	private Date crtTime;

	//创建用户
	private String crtUser;

	//关联外键
	private String refUuid;
	
	
	//规则类型
	private String type;
			
	//描述
	private String description;
			
	//匹配类型
	private String hitTypeDisplayName;
			
	//风险类型显示名
	private String fraudTypeDisplayName;

	//命中关注名单细则的属性值
	private String value;
			
	//风险等级
	private String riskLevel;
			
	//风险类型
	private String fraudType;
			
	//证据时间戳形式
	private String evidenceTime;
	
	//业务的主键，实现不同系统之间的同步
    private String trnId;
    
	//申请件编号
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
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHitTypeDisplayName() {
		return hitTypeDisplayName;
	}

	public void setHitTypeDisplayName(String hitTypeDisplayName) {
		this.hitTypeDisplayName = hitTypeDisplayName;
	}

	public String getFraudTypeDisplayName() {
		return fraudTypeDisplayName;
	}

	public void setFraudTypeDisplayName(String fraudTypeDisplayName) {
		this.fraudTypeDisplayName = fraudTypeDisplayName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getFraudType() {
		return fraudType;
	}

	public void setFraudType(String fraudType) {
		this.fraudType = fraudType;
	}

	public String getEvidenceTime() {
		return evidenceTime;
	}

	public void setEvidenceTime(String evidenceTime) {
		this.evidenceTime = evidenceTime;
	}
	@Override
	public String toString() {
		return "MulBorGreyList [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", refUuid=" + refUuid
				+ ", type=" + type + ", description=" + description + ", hitTypeDisplayName=" + hitTypeDisplayName
				+ ", fraudTypeDisplayName=" + fraudTypeDisplayName + ", value=" + value + ", riskLevel=" + riskLevel
				+ ", fraudType=" + fraudType + ", evidenceTime=" + evidenceTime + ", trnId=" + trnId + ", appId="
				+ appId + "]";
	}

}
