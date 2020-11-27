package com.huaxia.plaze.modules.pboc.domain.pah;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PF08Zdata")
public class PF08Zdata implements Serializable {

	private static final long serialVersionUID = 3721376392679809668L;
	private String PF08ZS01;// 标注及声明个数 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个行政奖励记录的关联id

	public String getPF08ZS01() {
		return PF08ZS01;
	}

	public void setPF08ZS01(String pF08ZS01) {
		PF08ZS01 = pF08ZS01;
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

	public String getRelateId() {
		return relateId;
	}

	public void setRelateId(String relateId) {
		this.relateId = relateId;
	}

}
