package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 相关还款责任汇总信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PC02Kdata")
public class PC02Kdata implements Serializable {
	private static final long serialVersionUID = -2888104288609211865L;
	private String PC02KS01;// 相关还款责任个数 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02KS01() {
		return PC02KS01;
	}

	public void setPC02KS01(String pC02KS01) {
		PC02KS01 = pC02KS01;
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