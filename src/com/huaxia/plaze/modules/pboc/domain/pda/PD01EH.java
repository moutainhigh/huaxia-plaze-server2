package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 历史表现信息
 * 
 * @author gaoh
 *
 */
@Alias("PD01EH")
public class PD01EH implements Serializable {

	private static final long serialVersionUID = -4373450966511305967L;
	private String PD01ER03;// 月份 -- [1..1]
	private String PD01ED01;// 还款状态 -- [1..1]
	private String PD01EJ01;// 逾期（透支）总额 --
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01ER03() {
		return PD01ER03;
	}

	public void setPD01ER03(String pD01ER03) {
		PD01ER03 = pD01ER03;
	}

	public String getPD01ED01() {
		return PD01ED01;
	}

	public void setPD01ED01(String pD01ED01) {
		PD01ED01 = pD01ED01;
	}

	public String getPD01EJ01() {
		return PD01EJ01;
	}

	public void setPD01EJ01(String pD01EJ01) {
		PD01EJ01 = pD01EJ01;
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