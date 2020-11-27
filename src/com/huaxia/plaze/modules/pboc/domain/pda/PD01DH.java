package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 还款状态信息
 * 
 * @author gaoh
 *
 */
@Alias("PD01DH")
public class PD01DH implements Serializable {

	private static final long serialVersionUID = 6449659664613736787L;
	private String PD01DR03;// 月份 -- [1..1]
	private String PD01DD01;// 还款状态 -- [1..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01DR03() {
		return PD01DR03;
	}

	public void setPD01DR03(String pD01DR03) {
		PD01DR03 = pD01DR03;
	}

	public String getPD01DD01() {
		return PD01DD01;
	}

	public void setPD01DD01(String pD01DD01) {
		PD01DD01 = pD01DD01;
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