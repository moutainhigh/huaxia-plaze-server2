package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 最新表现信息段
 * 
 * @author gaoh
 *
 */
@Alias("PD01B")
public class PD01B implements Serializable {

	private static final long serialVersionUID = 9201004773115186976L;
	private String PD01BD01;// 账户状态 -- [1..1]
	private String PD01BR01;// 关闭日期 -- [1..1]
	private String PD01BR04;// 转出月份 -- [0..1]
	private String PD01BJ01;// 余额 -- [1..1]
	private String PD01BR02;// 最近一次还款日期 -- [1..1]
	private String PD01BJ02;// 最近一次还款金额 -- [0..1]
	private String PD01BD03;// 五级分类 -- [0..1]
	private String PD01BD04;// 还款状态 -- [0..1]
	private String PD01BR03;// 信息报告日期 -- [1..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01BD01() {
		return PD01BD01;
	}

	public void setPD01BD01(String pD01BD01) {
		PD01BD01 = pD01BD01;
	}

	public String getPD01BR01() {
		return PD01BR01;
	}

	public void setPD01BR01(String pD01BR01) {
		PD01BR01 = pD01BR01;
	}

	public String getPD01BR04() {
		return PD01BR04;
	}

	public void setPD01BR04(String pD01BR04) {
		PD01BR04 = pD01BR04;
	}

	public String getPD01BJ01() {
		return PD01BJ01;
	}

	public void setPD01BJ01(String pD01BJ01) {
		PD01BJ01 = pD01BJ01;
	}

	public String getPD01BR02() {
		return PD01BR02;
	}

	public void setPD01BR02(String pD01BR02) {
		PD01BR02 = pD01BR02;
	}

	public String getPD01BJ02() {
		return PD01BJ02;
	}

	public void setPD01BJ02(String pD01BJ02) {
		PD01BJ02 = pD01BJ02;
	}

	public String getPD01BD03() {
		return PD01BD03;
	}

	public void setPD01BD03(String pD01BD03) {
		PD01BD03 = pD01BD03;
	}

	public String getPD01BD04() {
		return PD01BD04;
	}

	public void setPD01BD04(String pD01BD04) {
		PD01BD04 = pD01BD04;
	}

	public String getPD01BR03() {
		return PD01BR03;
	}

	public void setPD01BR03(String pD01BR03) {
		PD01BR03 = pD01BR03;
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