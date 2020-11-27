package com.huaxia.plaze.modules.pboc.domain.pcr;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息
 * 
 * @author gaoh
 *
 */
@Alias("PD03ZH")
public class PD03ZH implements Serializable {

	private static final long serialVersionUID = 4914191166740780343L;
	private String PD03ZD01;// 标注及声明类型 [1..1] --
	private String PD03ZQ01;// 标注或声明内容 [1..1] --
	private String PD03ZR01;// 添加日期 [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个相关还款责任信息单元的关联id

	public String getPD03ZD01() {
		return PD03ZD01;
	}

	public void setPD03ZD01(String pD03ZD01) {
		PD03ZD01 = pD03ZD01;
	}

	public String getPD03ZQ01() {
		return PD03ZQ01;
	}

	public void setPD03ZQ01(String pD03ZQ01) {
		PD03ZQ01 = pD03ZQ01;
	}

	public String getPD03ZR01() {
		return PD03ZR01;
	}

	public void setPD03ZR01(String pD03ZR01) {
		PD03ZR01 = pD03ZR01;
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
