package com.huaxia.plaze.modules.pboc.domain.pim;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 手机号码信息
 * 
 * @author gaoh
 *
 */
@Alias("PB01BH")
public class PB01BH implements Serializable {
	private static final long serialVersionUID = 767922954920033165L;
	private String PB01BQ01;// 手机号码 -- [1..1]
	private String PB01BR01;// 信息更新日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPB01BQ01() {
		return PB01BQ01;
	}

	public void setPB01BQ01(String pB01BQ01) {
		PB01BQ01 = pB01BQ01;
	}

	public String getPB01BR01() {
		return PB01BR01;
	}

	public void setPB01BR01(String pB01BR01) {
		PB01BR01 = pB01BR01;
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