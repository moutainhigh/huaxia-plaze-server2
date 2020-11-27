package com.huaxia.plaze.modules.pboc.domain.pce;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息
 * 
 * @author gaoh
 *
 */
@Alias("PF03ZH")
public class PF03ZH implements Serializable {

	private static final long serialVersionUID = -3572653258045810047L;
	private String PF03ZD01;// 标注及声明类型 -- [1..1]
	private String PF03ZQ01;// 标注或声明内容 -- [1..1]
	private String PF03ZR01;// 添加日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个强制执行记录信息单元的关联id

	public String getPF03ZD01() {
		return PF03ZD01;
	}

	public void setPF03ZD01(String pF03ZD01) {
		PF03ZD01 = pF03ZD01;
	}

	public String getPF03ZQ01() {
		return PF03ZQ01;
	}

	public void setPF03ZQ01(String pF03ZQ01) {
		PF03ZQ01 = pF03ZQ01;
	}

	public String getPF03ZR01() {
		return PF03ZR01;
	}

	public void setPF03ZR01(String pF03ZR01) {
		PF03ZR01 = pF03ZR01;
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
