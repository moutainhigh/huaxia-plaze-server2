package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 信贷交易提示信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PC02Adata")
public class PC02Adata implements Serializable {

	private static final long serialVersionUID = 2310057971962004078L;
	private String PC02AS01;// 账户数合计 [1..1] --
	private String PC02AS02;// 业务类型数量 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02AS01() {
		return PC02AS01;
	}

	public void setPC02AS01(String pC02AS01) {
		PC02AS01 = pC02AS01;
	}

	public String getPC02AS02() {
		return PC02AS02;
	}

	public void setPC02AS02(String pC02AS02) {
		PC02AS02 = pC02AS02;
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