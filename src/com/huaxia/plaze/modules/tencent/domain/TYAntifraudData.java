package com.huaxia.plaze.modules.tencent.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 天御分主表信息
 * @author gaohui
 *
 */
public class TYAntifraudData implements Serializable {
   
	private static final long serialVersionUID = -9079443077091056402L;

	// 记录编号
	private String uuid;

	//创建时间
	private Date crtTime;
	
	// 创建用户
	private String crtUser;
	
	// 身份证号码 关联用的
	private String 	trnId;
	
	// 每个身份证号码关联唯一的pkUuid值
	private String pkUuid;
	
	// 身份证号
	private String certNo;
   
    private String code;//响应代码 0成功 非0是具体错误代码

    private String codeDesc;//响应结果说明

    private Integer found;//表示该条记录能否查到,1为能查到，-1为查不到

    private Integer idFound;//表示该条记录中的身份证能否查到,1为能查到，-1为查不到

    private String message;//查询信息描述

    private Integer riskScore;//0~100：欺诈分值。值越高欺诈可能性越大

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

	public String getPkUuid() {
		return pkUuid;
	}

	public void setPkUuid(String pkUuid) {
		this.pkUuid = pkUuid;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getFound() {
        return found;
    }

    public void setFound(Integer found) {
        this.found = found;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public Integer getIdFound() {
		return idFound;
	}

	public void setIdFound(Integer idFound) {
		this.idFound = idFound;
	}

	public Integer getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(Integer riskScore) {
		this.riskScore = riskScore;
	}
    
}