package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 大额专项分期信息
 * 
 * @author gaoh
 *
 */
@Alias("PD01HH")
public class PD01HH implements Serializable {

	private static final long serialVersionUID = -1926451827032954329L;
	private String PD01HJ01;// 大额专项分期额度 -- [1..1]
	private String PD01HR01;// 分期额度生效日期 -- [1..1]
	private String PD01HR02;// 分期额度到期日期 -- [1..1]
	private String PD01HJ02;// 已用分期金额 -- [1..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01HJ01() {
		return PD01HJ01;
	}

	public void setPD01HJ01(String pD01HJ01) {
		PD01HJ01 = pD01HJ01;
	}

	public String getPD01HR01() {
		return PD01HR01;
	}

	public void setPD01HR01(String pD01HR01) {
		PD01HR01 = pD01HR01;
	}

	public String getPD01HR02() {
		return PD01HR02;
	}

	public void setPD01HR02(String pD01HR02) {
		PD01HR02 = pD01HR02;
	}

	public String getPD01HJ02() {
		return PD01HJ02;
	}

	public void setPD01HJ02(String pD01HJ02) {
		PD01HJ02 = pD01HJ02;
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
