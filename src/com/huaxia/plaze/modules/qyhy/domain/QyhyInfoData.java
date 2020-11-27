package com.huaxia.plaze.modules.qyhy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 企业行业信息 成功失败 参数存储表
 * @author chenmeng
 */
public class QyhyInfoData implements Serializable{
	private static final long serialVersionUID = 3543148947960938372L;

	private String uuid;

    private String trnId;//交易编号
    
    private String identityNo;//身份证号码

    private Integer code;//返回的结果吗 用来判断查询成功或是失败

    private String msg;//返回的信息

    private Date crtTime;//创建日期
    
    private String crtUer;//创建用户

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

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public String getCrtUer() {
		return crtUer;
	}

	public void setCrtUer(String crtUer) {
		this.crtUer = crtUer;
	}

}