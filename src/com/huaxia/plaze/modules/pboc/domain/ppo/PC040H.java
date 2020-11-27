package com.huaxia.plaze.modules.pboc.domain.ppo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 公共信息概要信息
 * 
 * @author gaoh
 *
 */
@Alias("PC040H")
public class PC040H implements Serializable {

	private static final long serialVersionUID = 2389710189512119240L;
	private String PC040D01;// 公共信息类型 -- [1..1]
	private String PC040S02;// 记录数 -- [1..1]
	private String PC040J01;// 涉及金额 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC040D01() {
		return PC040D01;
	}

	public void setPC040D01(String pC040D01) {
		PC040D01 = pC040D01;
	}

	public String getPC040S02() {
		return PC040S02;
	}

	public void setPC040S02(String pC040S02) {
		PC040S02 = pC040S02;
	}

	public String getPC040J01() {
		return PC040J01;
	}

	public void setPC040J01(String pC040J01) {
		PC040J01 = pC040J01;
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