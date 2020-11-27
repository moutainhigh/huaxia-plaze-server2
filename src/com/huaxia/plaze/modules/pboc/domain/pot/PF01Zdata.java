package com.huaxia.plaze.modules.pboc.domain.pot;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PF01Zdata")
public class PF01Zdata implements Serializable {

	private static final long serialVersionUID = 2745951125641415984L;
	private String PF01ZS01;// 标注及声明个数 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个欠税记录信息单元的关联id

	public String getPF01ZS01() {
		return PF01ZS01;
	}

	public void setPF01ZS01(String pF01ZS01) {
		PF01ZS01 = pF01ZS01;
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
