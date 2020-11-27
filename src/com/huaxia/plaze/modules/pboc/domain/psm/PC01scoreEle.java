package com.huaxia.plaze.modules.pboc.domain.psm;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 评分信息分数说明
 * 
 * @author gaoh
 *
 */
@Alias("PC01scoreEle")
public class PC01scoreEle implements Serializable {

	private static final long serialVersionUID = -6168040491089925454L;
	private String PC010D01;// 分数说明 -- [1..2]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC010D01() {
		return PC010D01;
	}

	public void setPC010D01(String pC010D01) {
		PC010D01 = pC010D01;
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