package com.huaxia.plaze.modules.qyhy.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 企业行业信息ORGBASIC 组织机构列表		
 * @author chenmeng
 */
public class QyhyInfoOrgBasic implements Serializable{
	private static final long serialVersionUID = 503426942949565454L;

	private String uuid;//uuid

	private String trnId;//交易编号
    
    private String identityNo;//身份证号码

    private String jgdm;//组织机构代码

    private String jgdz;//机构地址

    private String jgmc;//组织机构名称

    private String zybz;//质疑标志

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

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm == null ? null : jgdm.trim();
    }

    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz == null ? null : jgdz.trim();
    }

    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc == null ? null : jgmc.trim();
    }

    public String getZybz() {
        return zybz;
    }

    public void setZybz(String zybz) {
        this.zybz = zybz == null ? null : zybz.trim();
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
    
}