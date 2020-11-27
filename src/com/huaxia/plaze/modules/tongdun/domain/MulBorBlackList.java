package com.huaxia.plaze.modules.tongdun.domain;

import java.util.Date;

/**
 * 多头借风险名单风险详情表
 * @author liuwei
 *
 */
public class MulBorBlackList {
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
		
		//匹配类型显示名称
		private String hitTypeDisplayName;
		
		//风险类型显示名称
		private String fraudTypeDisplayName;
		
		//案号
		private String caseCode;
		
		//执行法院
		private String executeCourt;
		
		//立案时间
		private String caseDate;
		
		//性别
		private String gender;
		
		//被执行人履行情况
		private String carryOut;
		
		//被执行人姓名
		private String executedName;
		
		//风险类型
		private String fraudType;
		
		//被执行人具体情况
		private String specificCircumstances;
		
		//执行标的
		private String executeSubjec;
		
		//执行状态
		private String executeStatus;
		
		//做出依据执行法院
		private String evidenceCoutt;
		
		//生效法律文书确定的义务
		private String termDuty;
		
		//省份
		private String province;;
		
		//执行依据文号
		private String executeCode;
		
		//命中的属性值
		private String value;
		
		//年龄
		private String age;
		
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

		public String getCaseCode() {
			return caseCode;
		}

		public void setCaseCode(String caseCode) {
			this.caseCode = caseCode;
		}

		public String getExecuteCourt() {
			return executeCourt;
		}

		public void setExecuteCourt(String executeCourt) {
			this.executeCourt = executeCourt;
		}

		public String getCaseDate() {
			return caseDate;
		}

		public void setCaseDate(String caseDate) {
			this.caseDate = caseDate;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getCarryOut() {
			return carryOut;
		}

		public void setCarryOut(String carryOut) {
			this.carryOut = carryOut;
		}

		public String getExecutedName() {
			return executedName;
		}

		public void setExecutedName(String executedName) {
			this.executedName = executedName;
		}

		public String getFraudType() {
			return fraudType;
		}

		public void setFraudType(String fraudType) {
			this.fraudType = fraudType;
		}

		public String getSpecificCircumstances() {
			return specificCircumstances;
		}

		public void setSpecificCircumstances(String specificCircumstances) {
			this.specificCircumstances = specificCircumstances;
		}

		public String getExecuteSubjec() {
			return executeSubjec;
		}

		public void setExecuteSubjec(String executeSubjec) {
			this.executeSubjec = executeSubjec;
		}

		public String getExecuteStatus() {
			return executeStatus;
		}

		public void setExecuteStatus(String executeStatus) {
			this.executeStatus = executeStatus;
		}

		public String getEvidenceCoutt() {
			return evidenceCoutt;
		}

		public void setEvidenceCoutt(String evidenceCoutt) {
			this.evidenceCoutt = evidenceCoutt;
		}

		public String getTermDuty() {
			return termDuty;
		}

		public void setTermDuty(String termDuty) {
			this.termDuty = termDuty;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getExecuteCode() {
			return executeCode;
		}

		public void setExecuteCode(String executeCode) {
			this.executeCode = executeCode;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getEvidenceTime() {
			return evidenceTime;
		}

		public void setEvidenceTime(String evidenceTime) {
			this.evidenceTime = evidenceTime;
		}
		@Override
		public String toString() {
			return "MulBorBlackList [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", refUuid="
					+ refUuid + ", type=" + type + ", description=" + description + ", hitTypeDisplayName="
					+ hitTypeDisplayName + ", fraudTypeDisplayName=" + fraudTypeDisplayName + ", caseCode=" + caseCode
					+ ", executeCourt=" + executeCourt + ", caseDate=" + caseDate + ", gender=" + gender + ", carryOut="
					+ carryOut + ", executedName=" + executedName + ", fraudType=" + fraudType
					+ ", specificCircumstances=" + specificCircumstances + ", executeSubjec=" + executeSubjec
					+ ", executeStatus=" + executeStatus + ", evidenceCoutt=" + evidenceCoutt + ", termDuty=" + termDuty
					+ ", province=" + province + ", executeCode=" + executeCode + ", value=" + value + ", age=" + age
					+ ", evidenceTime=" + evidenceTime + ", trnId=" + trnId + ", appId=" + appId + "]";
		}

}
