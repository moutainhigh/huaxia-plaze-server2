package com.huaxia.plaze.modules.qyhy.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * METADATA 元数据来源
 * @author chenmeng
 */
public class QyhyInfoMetaData implements Serializable{
	
	private static final long serialVersionUID = -2558821342504791421L;

	private String uuid;

	private String trnId;//交易编号
    
    private String identityNo;//身份证号码

    private String source;//匹配标志-工商(1：精确匹配2：模糊匹配3：无法匹配)

    private Date crtTime;//创建日期
    
    private String crtUser;//创建用户

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
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
    
}