package com.huaxia.plaze.modules.qyhy.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 企业行业信息PUNISHBREAK 失信被执行人信息		
 * @author chenmeng
 */
public class QyhyInfoPunishBreak implements Serializable{
	private static final long serialVersionUID = -8262087867477823194L;

	private String uuid;//uuid

	private String trnId;//交易编号
    
    private String identityNo;//身份证号码

    private String casestate;//案件状态

    private String courtname;//执行法院

    private String disrupttypename;//失信被执行人行为具体情形

    private String performance;//被执行人的履行情况

    private String publishdateclean;//发布时间

    private Date crtTime;//创建时间
    
    private String crtUser;//创建用户

    private String duty;//生效法律文书确定的义务

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

	public String getTrnId() {
		return trnId;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

	public String getCrtUser() {
		return crtUser;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getCasestate() {
        return casestate;
    }

    public void setCasestate(String casestate) {
        this.casestate = casestate == null ? null : casestate.trim();
    }

    public String getCourtname() {
        return courtname;
    }

    public void setCourtname(String courtname) {
        this.courtname = courtname == null ? null : courtname.trim();
    }

    public String getDisrupttypename() {
        return disrupttypename;
    }

    public void setDisrupttypename(String disrupttypename) {
        this.disrupttypename = disrupttypename == null ? null : disrupttypename.trim();
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance == null ? null : performance.trim();
    }

    public String getPublishdateclean() {
        return publishdateclean;
    }

    public void setPublishdateclean(String publishdateclean) {
        this.publishdateclean = publishdateclean == null ? null : publishdateclean.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

	@Override
	public String toString() {
		return "QyhyInfoPunishBreak [uuid=" + uuid + ", trnId=" + trnId + ", identityNo=" + identityNo + ", casestate="
				+ casestate + ", courtname=" + courtname + ", disrupttypename=" + disrupttypename + ", performance="
				+ performance + ", publishdateclean=" + publishdateclean + ", crtTime=" + crtTime + ", crtUser="
				+ crtUser + ", duty=" + duty + "]";
	}

}