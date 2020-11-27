package com.huaxia.plaze.modules.pboc.domain.pca;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 基本信息段
 * 
 * @author gaoh
 *
 */
@Alias("PD02A")
public class PD02A implements Serializable {

	private static final long serialVersionUID = -6268538230849238819L;
	private String PD02AI01;// 授信协议编号 -- [1..1]
	private String PD02AD01;// 业务管理机构类型 -- [1..1]
	private String PD02AI02;// 业务管理机构 -- [1..1]
	private String PD02AI03;// 授信协议标识 -- [1..1]
	private String PD02AD02;// 授信额度用途 -- [1..1]
	private String PD02AJ01;// 授信额度 -- [1..1]
	private String PD02AD03;// 币种 -- [1..1]
	private String PD02AR01;// 生效日期 -- [1..1]
	private String PD02AR02;// 到期日期 -- [1..1]
	private String PD02AD04;// 授信协议状态 -- [1..1]
	private String PD02AJ04;// 已用额度 -- [1..1]
	private String PD02AJ03;// 授信限额 -- [1..1]
	private String PD02AI04;// 授信限额编号 -- [0..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个 授信协议信息单元 的关联id

	public String getPD02AI01() {
		return PD02AI01;
	}

	public void setPD02AI01(String pD02AI01) {
		PD02AI01 = pD02AI01;
	}

	public String getPD02AD01() {
		return PD02AD01;
	}

	public void setPD02AD01(String pD02AD01) {
		PD02AD01 = pD02AD01;
	}

	public String getPD02AI02() {
		return PD02AI02;
	}

	public void setPD02AI02(String pD02AI02) {
		PD02AI02 = pD02AI02;
	}

	public String getPD02AI03() {
		return PD02AI03;
	}

	public void setPD02AI03(String pD02AI03) {
		PD02AI03 = pD02AI03;
	}

	public String getPD02AD02() {
		return PD02AD02;
	}

	public void setPD02AD02(String pD02AD02) {
		PD02AD02 = pD02AD02;
	}

	public String getPD02AJ01() {
		return PD02AJ01;
	}

	public void setPD02AJ01(String pD02AJ01) {
		PD02AJ01 = pD02AJ01;
	}

	public String getPD02AD03() {
		return PD02AD03;
	}

	public void setPD02AD03(String pD02AD03) {
		PD02AD03 = pD02AD03;
	}

	public String getPD02AR01() {
		return PD02AR01;
	}

	public void setPD02AR01(String pD02AR01) {
		PD02AR01 = pD02AR01;
	}

	public String getPD02AR02() {
		return PD02AR02;
	}

	public void setPD02AR02(String pD02AR02) {
		PD02AR02 = pD02AR02;
	}

	public String getPD02AD04() {
		return PD02AD04;
	}

	public void setPD02AD04(String pD02AD04) {
		PD02AD04 = pD02AD04;
	}

	public String getPD02AJ04() {
		return PD02AJ04;
	}

	public void setPD02AJ04(String pD02AJ04) {
		PD02AJ04 = pD02AJ04;
	}

	public String getPD02AJ03() {
		return PD02AJ03;
	}

	public void setPD02AJ03(String pD02AJ03) {
		PD02AJ03 = pD02AJ03;
	}

	public String getPD02AI04() {
		return PD02AI04;
	}

	public void setPD02AI04(String pD02AI04) {
		PD02AI04 = pD02AI04;
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
