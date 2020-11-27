package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 特殊事件说明信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PD01Gdata")
public class PD01Gdata implements Serializable {

	private static final long serialVersionUID = -3354955689609285576L;
	private String PD01GS01;// 特殊事件说明个数 -- [1..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01GS01() {
		return PD01GS01;
	}

	public void setPD01GS01(String pD01GS01) {
		PD01GS01 = pD01GS01;
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