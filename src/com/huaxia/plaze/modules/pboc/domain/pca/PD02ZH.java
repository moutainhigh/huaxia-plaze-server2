package com.huaxia.plaze.modules.pboc.domain.pca;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息
 * 
 * @author gaoh
 *
 */
@Alias("PD02ZH")
public class PD02ZH implements Serializable {

	private static final long serialVersionUID = -8873422749618035382L;
	private String PD02ZD01;// 标注及声明类型 -- [1..1]
	private String PD02ZQ01;// 标注或声明内容 -- [1..1]
	private String PD02ZR01;// 添加日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个 授信协议信息单元 的关联id

	public String getPD02ZD01() {
		return PD02ZD01;
	}

	public void setPD02ZD01(String pD02ZD01) {
		PD02ZD01 = pD02ZD01;
	}

	public String getPD02ZQ01() {
		return PD02ZQ01;
	}

	public void setPD02ZQ01(String pD02ZQ01) {
		PD02ZQ01 = pD02ZQ01;
	}

	public String getPD02ZR01() {
		return PD02ZR01;
	}

	public void setPD02ZR01(String pD02ZR01) {
		PD02ZR01 = pD02ZR01;
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
