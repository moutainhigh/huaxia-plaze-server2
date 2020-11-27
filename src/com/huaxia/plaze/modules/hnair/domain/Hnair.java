package com.huaxia.plaze.modules.hnair.domain;

import java.io.Serializable;
import java.util.Date;

public class Hnair implements Serializable {
	private static final long serialVersionUID = -2014162693305947006L;
  
    //响应代码 0成功 非0是具体错误代码
    private String errorcode;
    //响应结果说明
    private String errormessage;
    //服务器端事务或交易编号
    private String stid;
    //客户器端事务或交易编号
    private String ctid;
    //扩展信息
    private String extendsinfo;
    //是否有过飞行记录
    private String vipflg;
    //会员卡号
    private String cid;
    // 最近一年飞行次数
    private Integer flycnt;
    //会员级别
    private String grade;
    //手机号是否与入参一致
    private String resrv1;
    //是否有兑奖资格
    private String resrv2;
    //预留字段3
    private String resrv3;
    //创建时间
    private Date crtTime;
    //业务的主键，实现不同系统之间的同步
    private String trnId;
    //创建用户
    private String crtUser;
    
    /** 证件号 */
    private String certNo;
  
    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode == null ? null : errorcode.trim();
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage == null ? null : errormessage.trim();
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid == null ? null : stid.trim();
    }

    public String getCtid() {
        return ctid;
    }

    public void setCtid(String ctid) {
        this.ctid = ctid == null ? null : ctid.trim();
    }

    public String getExtendsinfo() {
        return extendsinfo;
    }

    public void setExtendsinfo(String extendsinfo) {
        this.extendsinfo = extendsinfo == null ? null : extendsinfo.trim();
    }

    public String getVipflg() {
        return vipflg;
    }

    public void setVipflg(String vipflg) {
        this.vipflg = vipflg == null ? null : vipflg.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public Integer getFlycnt() {
        return flycnt;
    }

    public void setFlycnt(Integer flycnt) {
        this.flycnt = flycnt;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getResrv1() {
        return resrv1;
    }

    public void setResrv1(String resrv1) {
        this.resrv1 = resrv1 == null ? null : resrv1.trim();
    }

    public String getResrv2() {
        return resrv2;
    }

    public void setResrv2(String resrv2) {
        this.resrv2 = resrv2 == null ? null : resrv2.trim();
    }

    public String getResrv3() {
        return resrv3;
    }

    public void setResrv3(String resrv3) {
        this.resrv3 = resrv3 == null ? null : resrv3.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
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
	
	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	@Override
	public String toString() {
		return "Hnair [errorcode=" + errorcode + ", errormessage=" + errormessage + ", stid=" + stid + ", ctid=" + ctid
				+ ", extendsinfo=" + extendsinfo + ", vipflg=" + vipflg + ", cid=" + cid + ", flycnt=" + flycnt
				+ ", grade=" + grade + ", resrv1=" + resrv1 + ", resrv2=" + resrv2 + ", resrv3=" + resrv3 + ", crtTime="
				+ crtTime + ", trnId=" + trnId + ", crtUser=" + crtUser + "]";
	}

	
}
