package com.huaxia.plaze.modules.qyhy.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 企业行业信息SHAREHOLDER 股东及出资信息 		
 * @author chenmeng
 */
public class QyhyInfoShareHolder implements Serializable{
	private static final long serialVersionUID = 7252446676944338069L;

	private String uuid;

	private String trnId;//交易编号
    
    private String identityNo;//身份证号码

    private String condate;//出资日期

    private String conform;//出资方式

    private String country;//国别

    private String fundedratio;//出资比例

    private String invtype;//股东类型

    private String regcapcur;//认缴出资币种

    private String shaname;//股东名称

    private String subconam;//认缴出资额(万元)

    private Date crtTime;//创建时间
    
    private String crtUser;//创建用户

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

	public String getCondate() {
        return condate;
    }

    public void setCondate(String condate) {
        this.condate = condate == null ? null : condate.trim();
    }

    public String getConform() {
        return conform;
    }

    public void setConform(String conform) {
        this.conform = conform == null ? null : conform.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getFundedratio() {
        return fundedratio;
    }

    public void setFundedratio(String fundedratio) {
        this.fundedratio = fundedratio == null ? null : fundedratio.trim();
    }

    public String getInvtype() {
        return invtype;
    }

    public void setInvtype(String invtype) {
        this.invtype = invtype == null ? null : invtype.trim();
    }

    public String getRegcapcur() {
        return regcapcur;
    }

    public void setRegcapcur(String regcapcur) {
        this.regcapcur = regcapcur == null ? null : regcapcur.trim();
    }

    public String getShaname() {
        return shaname;
    }

    public void setShaname(String shaname) {
        this.shaname = shaname == null ? null : shaname.trim();
    }

    public String getSubconam() {
        return subconam;
    }

    public void setSubconam(String subconam) {
        this.subconam = subconam == null ? null : subconam.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}