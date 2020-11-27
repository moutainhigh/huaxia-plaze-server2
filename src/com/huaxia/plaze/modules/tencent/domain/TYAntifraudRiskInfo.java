package com.huaxia.plaze.modules.tencent.domain;

import java.io.Serializable;
import java.util.Date;

public class TYAntifraudRiskInfo implements Serializable {
   
	private static final long serialVersionUID = 7767482137743311760L;

	// 记录编号
	private String uuid;

	private Date crtTime;//创建时间
	
	// 创建用户
	private String crtUser;
	
	// 身份证号码 关联用的
	private String 	trnId;
	
	// 与主表关联唯一的fkUuid值
	private String fkUuid;
	
	// 身份证号
	private String certNo;

    private String riskCode;//风险码

    private String riskCodeValue;//风险详情值

    public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getFkUuid() {
		return fkUuid;
	}

	public void setFkUuid(String fkUuid) {
		this.fkUuid = fkUuid;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		 this.riskCode = riskCode == null ? null : riskCode.trim();
	}

	public String getRiskCodeValue() {
		return riskCodeValue;
	}

	public void setRiskCodeValue(String riskCodeValue) {
		 this.riskCodeValue = riskCodeValue == null ? null : riskCodeValue.trim();
	}

	public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}