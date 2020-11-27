package com.huaxia.plaze.modules.pboc.domain.prh;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 报告标识信息段
 * 
 * @author gaoh
 *
 */
@Alias("PA01A")
public class PA01A implements Serializable {

	private static final long serialVersionUID = -224343989811746535L;
	private String PA01AI01;// 报告编号
	private String PA01AR01;// 报告时间
	private String identityCardNo;// 身份证号
	private String source;// 数据来源
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPA01AI01() {
		return PA01AI01;
	}

	public void setPA01AI01(String pA01AI01) {
		PA01AI01 = pA01AI01;
	}

	public String getPA01AR01() {
		return PA01AR01;
	}

	public void setPA01AR01(String pA01AR01) {
		PA01AR01 = pA01AR01;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUniqueRelid() {
		return uniqueRelid;
	}

	public void setUniqueRelid(String uniqueRelid) {
		this.uniqueRelid = uniqueRelid;
	}

}
