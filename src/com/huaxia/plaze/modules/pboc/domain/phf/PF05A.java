package com.huaxia.plaze.modules.pboc.domain.phf;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 住房公积金参缴记录信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF05A")
public class PF05A implements Serializable {

	private static final long serialVersionUID = 3635763611261227302L;
	private String PF05AQ01;// 参缴地 -- [1..1]
	private String PF05AR01;// 参缴日期 -- [1..1]
	private String PF05AD01;// 缴费状态 -- [1..1]
	private String PF05AR02;// 初缴月份 -- [1..1]
	private String PF05AR03;// 缴至月份 -- [1..1]
	private String PF05AQ02;// 单位缴存比例 -- [1..1]
	private String PF05AQ03;// 个人缴存比例 -- [1..1]
	private String PF05AJ01;// 月缴存额 -- [1..1]
	private String PF05AQ04;// 缴费单位 -- [1..1]
	private String PF05AR04;// 信息更新日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个住房公积金参缴记录的关联id

	public String getPF05AQ01() {
		return PF05AQ01;
	}

	public void setPF05AQ01(String pF05AQ01) {
		PF05AQ01 = pF05AQ01;
	}

	public String getPF05AR01() {
		return PF05AR01;
	}

	public void setPF05AR01(String pF05AR01) {
		PF05AR01 = pF05AR01;
	}

	public String getPF05AD01() {
		return PF05AD01;
	}

	public void setPF05AD01(String pF05AD01) {
		PF05AD01 = pF05AD01;
	}

	public String getPF05AR02() {
		return PF05AR02;
	}

	public void setPF05AR02(String pF05AR02) {
		PF05AR02 = pF05AR02;
	}

	public String getPF05AR03() {
		return PF05AR03;
	}

	public void setPF05AR03(String pF05AR03) {
		PF05AR03 = pF05AR03;
	}

	public String getPF05AQ02() {
		return PF05AQ02;
	}

	public void setPF05AQ02(String pF05AQ02) {
		PF05AQ02 = pF05AQ02;
	}

	public String getPF05AQ03() {
		return PF05AQ03;
	}

	public void setPF05AQ03(String pF05AQ03) {
		PF05AQ03 = pF05AQ03;
	}

	public String getPF05AJ01() {
		return PF05AJ01;
	}

	public void setPF05AJ01(String pF05AJ01) {
		PF05AJ01 = pF05AJ01;
	}

	public String getPF05AQ04() {
		return PF05AQ04;
	}

	public void setPF05AQ04(String pF05AQ04) {
		PF05AQ04 = pF05AQ04;
	}

	public String getPF05AR04() {
		return PF05AR04;
	}

	public void setPF05AR04(String pF05AR04) {
		PF05AR04 = pF05AR04;
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
