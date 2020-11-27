package com.huaxia.plaze.modules.qyhy.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 企业行业信息BASIC 照面信息		
 * @author chenmeng
 */
public class QyhyInfoBasic implements Serializable{
	private static final long serialVersionUID = -8059043760027534979L;

	private String uuid;//主键ID

	private String trnId;//交易编号
    
    private String identityNo;//身份证号码

    private String abuitem;//许可经营项目

    private String ancheyear;//最后年检年度

    private String apprdate;//核准日期

    private String candate;//注销日期

    private String creditcode;//统一社会信用代码

    private String dom;//住所

    private String domdistrict;//住所所在行政区划

    private String email;//邮箱

    private String entname;//企业名称

    private String entnameeng;//企业英文名称

    private String entnameOld;//曾用名

    private String entstatus;//经营状态

    private String enttype;//企业(机构)类型

    private String enttypecode;//企业(机构)类型编码

    private String esdate;//成立日期

    private String frname;//法定代表人/负责人/执行事务合伙人

    private String id;//企业ID

    private String industrycocode;//国民经济行业代码

    private String industryconame;//国民经济代码名称

    private String opfrom;//经营期限自

    private String opto;//经营期限至

    private String orgcodes;//组织机构代码

    private String oriregno;//原注册号

    private String reccap;//实收资本(万元)

    private String regcap;//注册资本(万元)

    private String regcapcur;//注册资本币种

    private String regno;//注册号

    private String regorg;//登记机关

    private String regorgcity;//所在城市

    private String regorgcode;//注册地址行政编号

    private String regorgdistrict;//所在区/县

    private String regorgprovince;//所在省份

    private String revdate;//吊销日期

    private String zsopscope;//中数处理过后的经营业务范围

    private String tel;//联系人电话

    private String empnum;//员工人数

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

	public String getAbuitem() {
        return abuitem;
    }

    public void setAbuitem(String abuitem) {
        this.abuitem = abuitem == null ? null : abuitem.trim();
    }

    public String getAncheyear() {
        return ancheyear;
    }

    public void setAncheyear(String ancheyear) {
        this.ancheyear = ancheyear == null ? null : ancheyear.trim();
    }

    public String getApprdate() {
        return apprdate;
    }

    public void setApprdate(String apprdate) {
        this.apprdate = apprdate == null ? null : apprdate.trim();
    }

    public String getCandate() {
        return candate;
    }

    public void setCandate(String candate) {
        this.candate = candate == null ? null : candate.trim();
    }

    public String getCreditcode() {
        return creditcode;
    }

    public void setCreditcode(String creditcode) {
        this.creditcode = creditcode == null ? null : creditcode.trim();
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom == null ? null : dom.trim();
    }

    public String getDomdistrict() {
        return domdistrict;
    }

    public void setDomdistrict(String domdistrict) {
        this.domdistrict = domdistrict == null ? null : domdistrict.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEntname() {
        return entname;
    }

    public void setEntname(String entname) {
        this.entname = entname == null ? null : entname.trim();
    }

    public String getEntnameeng() {
        return entnameeng;
    }

    public void setEntnameeng(String entnameeng) {
        this.entnameeng = entnameeng == null ? null : entnameeng.trim();
    }

    public String getEntnameOld() {
        return entnameOld;
    }

    public void setEntnameOld(String entnameOld) {
        this.entnameOld = entnameOld == null ? null : entnameOld.trim();
    }

    public String getEntstatus() {
        return entstatus;
    }

    public void setEntstatus(String entstatus) {
        this.entstatus = entstatus == null ? null : entstatus.trim();
    }

    public String getEnttype() {
        return enttype;
    }

    public void setEnttype(String enttype) {
        this.enttype = enttype == null ? null : enttype.trim();
    }

    public String getEnttypecode() {
        return enttypecode;
    }

    public void setEnttypecode(String enttypecode) {
        this.enttypecode = enttypecode == null ? null : enttypecode.trim();
    }

    public String getEsdate() {
        return esdate;
    }

    public void setEsdate(String esdate) {
        this.esdate = esdate == null ? null : esdate.trim();
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname == null ? null : frname.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIndustrycocode() {
        return industrycocode;
    }

    public void setIndustrycocode(String industrycocode) {
        this.industrycocode = industrycocode == null ? null : industrycocode.trim();
    }

    public String getIndustryconame() {
        return industryconame;
    }

    public void setIndustryconame(String industryconame) {
        this.industryconame = industryconame == null ? null : industryconame.trim();
    }

    public String getOpfrom() {
        return opfrom;
    }

    public void setOpfrom(String opfrom) {
        this.opfrom = opfrom == null ? null : opfrom.trim();
    }

    public String getOpto() {
        return opto;
    }

    public void setOpto(String opto) {
        this.opto = opto == null ? null : opto.trim();
    }

    public String getOrgcodes() {
        return orgcodes;
    }

    public void setOrgcodes(String orgcodes) {
        this.orgcodes = orgcodes == null ? null : orgcodes.trim();
    }

    public String getOriregno() {
        return oriregno;
    }

    public void setOriregno(String oriregno) {
        this.oriregno = oriregno == null ? null : oriregno.trim();
    }

    public String getReccap() {
        return reccap;
    }

    public void setReccap(String reccap) {
        this.reccap = reccap == null ? null : reccap.trim();
    }

    public String getRegcap() {
        return regcap;
    }

    public void setRegcap(String regcap) {
        this.regcap = regcap == null ? null : regcap.trim();
    }

    public String getRegcapcur() {
        return regcapcur;
    }

    public void setRegcapcur(String regcapcur) {
        this.regcapcur = regcapcur == null ? null : regcapcur.trim();
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno == null ? null : regno.trim();
    }

    public String getRegorg() {
        return regorg;
    }

    public void setRegorg(String regorg) {
        this.regorg = regorg == null ? null : regorg.trim();
    }

    public String getRegorgcity() {
        return regorgcity;
    }

    public void setRegorgcity(String regorgcity) {
        this.regorgcity = regorgcity == null ? null : regorgcity.trim();
    }

    public String getRegorgcode() {
        return regorgcode;
    }

    public void setRegorgcode(String regorgcode) {
        this.regorgcode = regorgcode == null ? null : regorgcode.trim();
    }

    public String getRegorgdistrict() {
        return regorgdistrict;
    }

    public void setRegorgdistrict(String regorgdistrict) {
        this.regorgdistrict = regorgdistrict == null ? null : regorgdistrict.trim();
    }

    public String getRegorgprovince() {
        return regorgprovince;
    }

    public void setRegorgprovince(String regorgprovince) {
        this.regorgprovince = regorgprovince == null ? null : regorgprovince.trim();
    }

    public String getRevdate() {
        return revdate;
    }

    public void setRevdate(String revdate) {
        this.revdate = revdate == null ? null : revdate.trim();
    }

    public String getZsopscope() {
        return zsopscope;
    }

    public void setZsopscope(String zsopscope) {
        this.zsopscope = zsopscope == null ? null : zsopscope.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmpnum() {
        return empnum;
    }

    public void setEmpnum(String empnum) {
        this.empnum = empnum == null ? null : empnum.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}