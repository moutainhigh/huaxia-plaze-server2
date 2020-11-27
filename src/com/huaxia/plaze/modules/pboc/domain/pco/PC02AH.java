package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 信贷交易提示信息
 * 
 * @author gaoh
 *
 */
@Alias("PC02AH")
public class PC02AH implements Serializable {

	private static final long serialVersionUID = 1057123076224145372L;
	private String PC02AD01;// 业务类型 [1..1] --
	private String PC02AD02;// 业务大类 [1..1] --
	private String PC02AS03;// 账户数 [1..1] --
	private String PC02AR01;// 首笔业务发放月份 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02AD01() {
		return PC02AD01;
	}

	public void setPC02AD01(String pC02AD01) {
		PC02AD01 = pC02AD01;
	}

	public String getPC02AD02() {
		return PC02AD02;
	}

	public void setPC02AD02(String pC02AD02) {
		PC02AD02 = pC02AD02;
	}

	public String getPC02AS03() {
		return PC02AS03;
	}

	public void setPC02AS03(String pC02AS03) {
		PC02AS03 = pC02AS03;
	}

	public String getPC02AR01() {
		return PC02AR01;
	}

	public void setPC02AR01(String pC02AR01) {
		PC02AR01 = pC02AR01;
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
