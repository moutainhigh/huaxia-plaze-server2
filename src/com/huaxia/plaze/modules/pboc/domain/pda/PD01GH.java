package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;
/**
 * 特殊事件说明信息
 * @author gaoh
 *
 */

import org.apache.ibatis.type.Alias;

@Alias("PD01GH")
public class PD01GH implements Serializable {

	private static final long serialVersionUID = 6481591178411085404L;
	private String PD01GR01;// 特殊事件发生月份 -- [1..1]
	private String PD01GD01;// 特殊事件类型 -- [1..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01GR01() {
		return PD01GR01;
	}

	public void setPD01GR01(String pD01GR01) {
		PD01GR01 = pD01GR01;
	}

	public String getPD01GD01() {
		return PD01GD01;
	}

	public void setPD01GD01(String pD01GD01) {
		PD01GD01 = pD01GD01;
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