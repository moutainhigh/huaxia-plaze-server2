package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 基本信息段
 * 
 * @author gaoh
 *
 */
@Alias("PD01A")
public class PD01A implements Serializable {
	private static final long serialVersionUID = -2351236738865557659L;
	private String PD01AI01;// 账户编号 -- [1..1]
	private String PD01AD01;// 账户类型 -- [1..1]
	private String PD01AD02;// 业务管理机构类型 -- [1..1]
	private String PD01AI02;// 业务管理机构代码 -- [1..1]
	private String PD01AI03;// 账户标识 -- [0..1 ]
	private String PD01AI04;// 授信协议编号 -- [0..1]
	private String PD01AD03;// 业务种类 -- [0..1]
	private String PD01AR01;// 开立日期 -- [1..1]
	private String PD01AD04;// 币种 -- [0..1]
	private String PD01AJ01;// 借款金额 -- [0..1]
	private String PD01AJ02;// 账户授信额度 -- [0..1]
	private String PD01AJ03;// 共享授信额度 -- [0..1]
	private String PD01AR02;// 到期日期 -- [0..1]
	private String PD01AD05;// 还款方式 -- [0..1]
	private String PD01AD06;// 还款频率 -- [0..1]
	private String PD01AS01;// 还款期数 -- [0..1]
	private String PD01AD07;// 担保方式 -- [0..1]
	private String PD01AD08;// 贷款发放形式 -- [0..1]
	private String PD01AD09;// 共同借款标志 -- [0..1]
	private String PD01AD10;// 债权转移时的还款状态 -- [0..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01AI01() {
		return PD01AI01;
	}

	public void setPD01AI01(String pD01AI01) {
		PD01AI01 = pD01AI01;
	}

	public String getPD01AD01() {
		return PD01AD01;
	}

	public void setPD01AD01(String pD01AD01) {
		PD01AD01 = pD01AD01;
	}

	public String getPD01AD02() {
		return PD01AD02;
	}

	public void setPD01AD02(String pD01AD02) {
		PD01AD02 = pD01AD02;
	}

	public String getPD01AI02() {
		return PD01AI02;
	}

	public void setPD01AI02(String pD01AI02) {
		PD01AI02 = pD01AI02;
	}

	public String getPD01AI03() {
		return PD01AI03;
	}

	public void setPD01AI03(String pD01AI03) {
		PD01AI03 = pD01AI03;
	}

	public String getPD01AI04() {
		return PD01AI04;
	}

	public void setPD01AI04(String pD01AI04) {
		PD01AI04 = pD01AI04;
	}

	public String getPD01AD03() {
		return PD01AD03;
	}

	public void setPD01AD03(String pD01AD03) {
		PD01AD03 = pD01AD03;
	}

	public String getPD01AR01() {
		return PD01AR01;
	}

	public void setPD01AR01(String pD01AR01) {
		PD01AR01 = pD01AR01;
	}

	public String getPD01AD04() {
		return PD01AD04;
	}

	public void setPD01AD04(String pD01AD04) {
		PD01AD04 = pD01AD04;
	}

	public String getPD01AJ01() {
		return PD01AJ01;
	}

	public void setPD01AJ01(String pD01AJ01) {
		PD01AJ01 = pD01AJ01;
	}

	public String getPD01AJ02() {
		return PD01AJ02;
	}

	public void setPD01AJ02(String pD01AJ02) {
		PD01AJ02 = pD01AJ02;
	}

	public String getPD01AJ03() {
		return PD01AJ03;
	}

	public void setPD01AJ03(String pD01AJ03) {
		PD01AJ03 = pD01AJ03;
	}

	public String getPD01AR02() {
		return PD01AR02;
	}

	public void setPD01AR02(String pD01AR02) {
		PD01AR02 = pD01AR02;
	}

	public String getPD01AD05() {
		return PD01AD05;
	}

	public void setPD01AD05(String pD01AD05) {
		PD01AD05 = pD01AD05;
	}

	public String getPD01AD06() {
		return PD01AD06;
	}

	public void setPD01AD06(String pD01AD06) {
		PD01AD06 = pD01AD06;
	}

	public String getPD01AS01() {
		return PD01AS01;
	}

	public void setPD01AS01(String pD01AS01) {
		PD01AS01 = pD01AS01;
	}

	public String getPD01AD07() {
		return PD01AD07;
	}

	public void setPD01AD07(String pD01AD07) {
		PD01AD07 = pD01AD07;
	}

	public String getPD01AD08() {
		return PD01AD08;
	}

	public void setPD01AD08(String pD01AD08) {
		PD01AD08 = pD01AD08;
	}

	public String getPD01AD09() {
		return PD01AD09;
	}

	public void setPD01AD09(String pD01AD09) {
		PD01AD09 = pD01AD09;
	}

	public String getPD01AD10() {
		return PD01AD10;
	}

	public void setPD01AD10(String pD01AD10) {
		PD01AD10 = pD01AD10;
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