package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 最近5年内历史表现信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PD01Edata")
public class PD01Edata implements Serializable {

	private static final long serialVersionUID = -5303792355968643839L;
	private String PD01ER01;// 起始年月 -- [1..1]
	private String PD01ER02;// 截止年月 -- [1..1]
	private String PD01ES01;// 月数 -- [1..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01ER01() {
		return PD01ER01;
	}

	public void setPD01ER01(String pD01ER01) {
		PD01ER01 = pD01ER01;
	}

	public String getPD01ER02() {
		return PD01ER02;
	}

	public void setPD01ER02(String pD01ER02) {
		PD01ER02 = pD01ER02;
	}

	public String getPD01ES01() {
		return PD01ES01;
	}

	public void setPD01ES01(String pD01ES01) {
		PD01ES01 = pD01ES01;
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