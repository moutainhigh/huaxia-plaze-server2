package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 最近一次月度表现信息段
 * 
 * @author gaoh
 *
 */
@Alias("PD01C")
public class PD01C implements Serializable {

	private static final long serialVersionUID = -3112117299179807906L;
	private String PD01CR01;// 月份 -- [1..1]
	private String PD01CD01;// 账户状态 -- [1..1]
	private String PD01CJ01;// 余额 -- [1..1]
	private String PD01CJ02;// 已用额度 -- [0..1]
	private String PD01CJ03;// 未出单的大额专项分期余 -- [0..1]
	private String PD01CD02;// 五级分类 -- [0..1]
	private String PD01CS01;// 剩余还款期数 -- [0..1]
	private String PD01CR02;// 结算/应还款日 -- [1..1]
	private String PD01CJ04;// 本月应还款 -- [0..1]
	private String PD01CJ05;// 本月实还款 -- [1..1]
	private String PD01CR03;// 最近一次还款日期 -- [1..1]
	private String PD01CS02;// 当前逾期期数 -- [0..1]
	private String PD01CJ06;// 当前逾期总额 -- [0..1]
	private String PD01CJ07;// 逾期31—60天未还本金 -- [0..1]
	private String PD01CJ08;// 逾期61－90天未还本金 -- [0..1]
	private String PD01CJ09;// 逾期91－180天未还本金 -- [0..1]
	private String PD01CJ10;// 逾期180天以上未还本金 -- [0..1]
	private String PD01CJ11;// 透支180天以上未付余额 -- [0..1]
	private String PD01CJ12;// 最近6个月平均使用额度 -- [0..1]
	private String PD01CJ13;// 最近6个月平均透支余额 -- [0..1]
	private String PD01CJ14;// 最大使用额度 -- [0..1]
	private String PD01CJ15;// 最大透支余额 -- [0..1]
	private String PD01CR04;// 信息报告日期 -- [1..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01CR01() {
		return PD01CR01;
	}

	public void setPD01CR01(String pD01CR01) {
		PD01CR01 = pD01CR01;
	}

	public String getPD01CD01() {
		return PD01CD01;
	}

	public void setPD01CD01(String pD01CD01) {
		PD01CD01 = pD01CD01;
	}

	public String getPD01CJ01() {
		return PD01CJ01;
	}

	public void setPD01CJ01(String pD01CJ01) {
		PD01CJ01 = pD01CJ01;
	}

	public String getPD01CJ02() {
		return PD01CJ02;
	}

	public void setPD01CJ02(String pD01CJ02) {
		PD01CJ02 = pD01CJ02;
	}

	public String getPD01CJ03() {
		return PD01CJ03;
	}

	public void setPD01CJ03(String pD01CJ03) {
		PD01CJ03 = pD01CJ03;
	}

	public String getPD01CD02() {
		return PD01CD02;
	}

	public void setPD01CD02(String pD01CD02) {
		PD01CD02 = pD01CD02;
	}

	public String getPD01CS01() {
		return PD01CS01;
	}

	public void setPD01CS01(String pD01CS01) {
		PD01CS01 = pD01CS01;
	}

	public String getPD01CR02() {
		return PD01CR02;
	}

	public void setPD01CR02(String pD01CR02) {
		PD01CR02 = pD01CR02;
	}

	public String getPD01CJ04() {
		return PD01CJ04;
	}

	public void setPD01CJ04(String pD01CJ04) {
		PD01CJ04 = pD01CJ04;
	}

	public String getPD01CJ05() {
		return PD01CJ05;
	}

	public void setPD01CJ05(String pD01CJ05) {
		PD01CJ05 = pD01CJ05;
	}

	public String getPD01CR03() {
		return PD01CR03;
	}

	public void setPD01CR03(String pD01CR03) {
		PD01CR03 = pD01CR03;
	}

	public String getPD01CS02() {
		return PD01CS02;
	}

	public void setPD01CS02(String pD01CS02) {
		PD01CS02 = pD01CS02;
	}

	public String getPD01CJ06() {
		return PD01CJ06;
	}

	public void setPD01CJ06(String pD01CJ06) {
		PD01CJ06 = pD01CJ06;
	}

	public String getPD01CJ07() {
		return PD01CJ07;
	}

	public void setPD01CJ07(String pD01CJ07) {
		PD01CJ07 = pD01CJ07;
	}

	public String getPD01CJ08() {
		return PD01CJ08;
	}

	public void setPD01CJ08(String pD01CJ08) {
		PD01CJ08 = pD01CJ08;
	}

	public String getPD01CJ09() {
		return PD01CJ09;
	}

	public void setPD01CJ09(String pD01CJ09) {
		PD01CJ09 = pD01CJ09;
	}

	public String getPD01CJ10() {
		return PD01CJ10;
	}

	public void setPD01CJ10(String pD01CJ10) {
		PD01CJ10 = pD01CJ10;
	}

	public String getPD01CJ11() {
		return PD01CJ11;
	}

	public void setPD01CJ11(String pD01CJ11) {
		PD01CJ11 = pD01CJ11;
	}

	public String getPD01CJ12() {
		return PD01CJ12;
	}

	public void setPD01CJ12(String pD01CJ12) {
		PD01CJ12 = pD01CJ12;
	}

	public String getPD01CJ13() {
		return PD01CJ13;
	}

	public void setPD01CJ13(String pD01CJ13) {
		PD01CJ13 = pD01CJ13;
	}

	public String getPD01CJ14() {
		return PD01CJ14;
	}

	public void setPD01CJ14(String pD01CJ14) {
		PD01CJ14 = pD01CJ14;
	}

	public String getPD01CJ15() {
		return PD01CJ15;
	}

	public void setPD01CJ15(String pD01CJ15) {
		PD01CJ15 = pD01CJ15;
	}

	public String getPD01CR04() {
		return PD01CR04;
	}

	public void setPD01CR04(String pD01CR04) {
		PD01CR04 = pD01CR04;
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