package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 最近24个月还款记录信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PD01Ddata")
public class PD01Ddata implements Serializable {

	private static final long serialVersionUID = -682206285450327605L;
	private String PD01DR01;// 起始年月-- [1..1]
	private String PD01DR02;// 截止年月-- [1..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01DR01() {
		return PD01DR01;
	}

	public void setPD01DR01(String pD01DR01) {
		PD01DR01 = pD01DR01;
	}

	public String getPD01DR02() {
		return PD01DR02;
	}

	public void setPD01DR02(String pD01DR02) {
		PD01DR02 = pD01DR02;
	}

	public String getRelateId() {
		return relateId;
	}

	public void setRelateId(String relateId) {
		this.relateId = relateId;
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