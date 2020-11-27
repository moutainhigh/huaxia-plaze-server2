package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 被追偿汇总信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PC02Bdata")
public class PC02Bdata implements Serializable {
	private static final long serialVersionUID = 4275868539451539743L;
	private String PC02BS01;// 账户数合计 [1..1] --
	private String PC02BJ01;// 余额合计 [1..1] --
	private String PC02BS02;// 业务类型数量 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02BS01() {
		return PC02BS01;
	}

	public void setPC02BS01(String pC02BS01) {
		PC02BS01 = pC02BS01;
	}

	public String getPC02BJ01() {
		return PC02BJ01;
	}

	public void setPC02BJ01(String pC02BJ01) {
		PC02BJ01 = pC02BJ01;
	}

	public String getPC02BS02() {
		return PC02BS02;
	}

	public void setPC02BS02(String pC02BS02) {
		PC02BS02 = pC02BS02;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public String getUniqueRelid() {
		return uniqueRelid;
	}

	public void setUniqueRelid(String uniqueRelid) {
		this.uniqueRelid = uniqueRelid;
	}

}