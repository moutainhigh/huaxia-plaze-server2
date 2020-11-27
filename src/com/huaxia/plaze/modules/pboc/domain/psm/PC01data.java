package com.huaxia.plaze.modules.pboc.domain.psm;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 评分信息数据
 * 
 * @author gaoh
 *
 */
@Alias("PC01data")
public class PC01data implements Serializable {

	private static final long serialVersionUID = -6514057766253200334L;
	private String PC010Q01;// 数字解读 -- [1..1]
	private String PC010Q02;// 相对位置 -- [1..1]
	private String PC010S01;// 分数说明条 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC010Q01() {
		return PC010Q01;
	}

	public void setPC010Q01(String pC010Q01) {
		PC010Q01 = pC010Q01;
	}

	public String getPC010Q02() {
		return PC010Q02;
	}

	public void setPC010Q02(String pC010Q02) {
		PC010Q02 = pC010Q02;
	}

	public String getPC010S01() {
		return PC010S01;
	}

	public void setPC010S01(String pC010S01) {
		PC010S01 = pC010S01;
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
