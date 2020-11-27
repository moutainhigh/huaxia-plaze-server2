package com.huaxia.plaze.modules.pboc.domain.pce;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 强制执行记录信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF03A")
public class PF03A implements Serializable {

	private static final long serialVersionUID = -7262688369822435034L;
	private String PF03AQ01;// 执行法院 -- [1..1]
	private String PF03AQ02;// 执行案由 -- [1..1]
	private String PF03AR01;// 立案日期 -- [1..1]
	private String PF03AD01;// 结案方式 -- [1..1]
	private String PF03AQ03;// 案件状态 -- [1..1]
	private String PF03AR02;// 结案日期 -- [1..1]
	private String PF03AQ04;// 申请执行标的 -- [1..1]
	private String PF03AJ01;// 申请执行标的金额 -- [1..1]
	private String PF03AQ05;// 已执行标的 -- [1..1]
	private String PF03AJ02;// 已执行标的金额 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个强制执行记录信息单元的关联id

	public String getPF03AQ01() {
		return PF03AQ01;
	}

	public void setPF03AQ01(String pF03AQ01) {
		PF03AQ01 = pF03AQ01;
	}

	public String getPF03AQ02() {
		return PF03AQ02;
	}

	public void setPF03AQ02(String pF03AQ02) {
		PF03AQ02 = pF03AQ02;
	}

	public String getPF03AR01() {
		return PF03AR01;
	}

	public void setPF03AR01(String pF03AR01) {
		PF03AR01 = pF03AR01;
	}

	public String getPF03AD01() {
		return PF03AD01;
	}

	public void setPF03AD01(String pF03AD01) {
		PF03AD01 = pF03AD01;
	}

	public String getPF03AQ03() {
		return PF03AQ03;
	}

	public void setPF03AQ03(String pF03AQ03) {
		PF03AQ03 = pF03AQ03;
	}

	public String getPF03AR02() {
		return PF03AR02;
	}

	public void setPF03AR02(String pF03AR02) {
		PF03AR02 = pF03AR02;
	}

	public String getPF03AQ04() {
		return PF03AQ04;
	}

	public void setPF03AQ04(String pF03AQ04) {
		PF03AQ04 = pF03AQ04;
	}

	public String getPF03AJ01() {
		return PF03AJ01;
	}

	public void setPF03AJ01(String pF03AJ01) {
		PF03AJ01 = pF03AJ01;
	}

	public String getPF03AQ05() {
		return PF03AQ05;
	}

	public void setPF03AQ05(String pF03AQ05) {
		PF03AQ05 = pF03AQ05;
	}

	public String getPF03AJ02() {
		return PF03AJ02;
	}

	public void setPF03AJ02(String pF03AJ02) {
		PF03AJ02 = pF03AJ02;
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

	public String getRelateId() {
		return relateId;
	}

	public void setRelateId(String relateId) {
		this.relateId = relateId;
	}

}
