package com.huaxia.plaze.modules.qyhy.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 企业行业信息ORGDETAIL 组织机构详情		
 * @author chenmeng
 */
public class QyhyInfoOrgDetail implements Serializable{
	private static final long serialVersionUID = 4877837891402460195L;

	private String uuid;

	private String trnId;//交易编号
    
    private String identityNo;//身份证号码

    private String bzjg;//办证机构

    private String bzrq;//代码证办证日期

    private String fddbr;//法人代表姓名

    private String jgdm;//组织机构代码

    private String jgdz;//机构地址

    private String jglx;//机构类型

    private String jgmc;//组织机构名称

    private String xzqh;//行政区划

    private String zcrq;//注册日期

    private String zfrq;//代码证作废日期

    private String bgrq;//发照日期

    private String creditcode;//统一社会信用代码

    private String dhhm;//电话号码

    private String email;//电子邮箱

    private String jhbz;//校核标志

    private String jjhydm;//经济行业名称

    private String jjlxdm;//经济类型名称

    private String jyfw;//经营范围

    private String jydz;//生产经营地址

    private String jyzt;//经营状态

    private String regno;//注册号

    private String url;//网址

    private String zczj;//注册资本

    private String zgmc;//上级主管部门

    private String zgrs;//职工人数

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

	public String getBzjg() {
        return bzjg;
    }

    public void setBzjg(String bzjg) {
        this.bzjg = bzjg == null ? null : bzjg.trim();
    }

    public String getBzrq() {
        return bzrq;
    }

    public void setBzrq(String bzrq) {
        this.bzrq = bzrq == null ? null : bzrq.trim();
    }

    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr == null ? null : fddbr.trim();
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

    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx == null ? null : jglx.trim();
    }

    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc == null ? null : jgmc.trim();
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh == null ? null : xzqh.trim();
    }

    public String getZcrq() {
        return zcrq;
    }

    public void setZcrq(String zcrq) {
        this.zcrq = zcrq == null ? null : zcrq.trim();
    }

    public String getZfrq() {
        return zfrq;
    }

    public void setZfrq(String zfrq) {
        this.zfrq = zfrq == null ? null : zfrq.trim();
    }

    public String getBgrq() {
        return bgrq;
    }

    public void setBgrq(String bgrq) {
        this.bgrq = bgrq == null ? null : bgrq.trim();
    }

    public String getCreditcode() {
        return creditcode;
    }

    public void setCreditcode(String creditcode) {
        this.creditcode = creditcode == null ? null : creditcode.trim();
    }

    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm == null ? null : dhhm.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getJhbz() {
        return jhbz;
    }

    public void setJhbz(String jhbz) {
        this.jhbz = jhbz == null ? null : jhbz.trim();
    }

    public String getJjhydm() {
        return jjhydm;
    }

    public void setJjhydm(String jjhydm) {
        this.jjhydm = jjhydm == null ? null : jjhydm.trim();
    }

    public String getJjlxdm() {
        return jjlxdm;
    }

    public void setJjlxdm(String jjlxdm) {
        this.jjlxdm = jjlxdm == null ? null : jjlxdm.trim();
    }

    public String getJyfw() {
        return jyfw;
    }

    public void setJyfw(String jyfw) {
        this.jyfw = jyfw == null ? null : jyfw.trim();
    }

    public String getJydz() {
        return jydz;
    }

    public void setJydz(String jydz) {
        this.jydz = jydz == null ? null : jydz.trim();
    }

    public String getJyzt() {
        return jyzt;
    }

    public void setJyzt(String jyzt) {
        this.jyzt = jyzt == null ? null : jyzt.trim();
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno == null ? null : regno.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getZczj() {
        return zczj;
    }

    public void setZczj(String zczj) {
        this.zczj = zczj == null ? null : zczj.trim();
    }

    public String getZgmc() {
        return zgmc;
    }

    public void setZgmc(String zgmc) {
        this.zgmc = zgmc == null ? null : zgmc.trim();
    }

    public String getZgrs() {
        return zgrs;
    }

    public void setZgrs(String zgrs) {
        this.zgrs = zgrs == null ? null : zgrs.trim();
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
}