package com.huaxia.plaze.modules.pboc.domain.pmm;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 婚姻信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PB02")
public class PB02 implements Serializable {

	private static final long serialVersionUID = 388241026257434990L;
	private String PB020D01;// 婚姻状况 -- [1..1]
	private String PB020Q01;// 配偶姓名 -- [1..1]
	private String PB020D02;// 配偶证件类型 -- [1..1]
	private String PB020I01;// 配偶证件号码 -- [1..1]
	private String PB020Q02;// 配偶工作单位 -- [1..1]
	private String PB020Q03;// 配偶联系电话 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPB020D01() {
		return PB020D01;
	}

	public void setPB020D01(String pB020D01) {
		PB020D01 = pB020D01;
	}

	public String getPB020Q01() {
		return PB020Q01;
	}

	public void setPB020Q01(String pB020Q01) {
		PB020Q01 = pB020Q01;
	}

	public String getPB020D02() {
		return PB020D02;
	}

	public void setPB020D02(String pB020D02) {
		PB020D02 = pB020D02;
	}

	public String getPB020I01() {
		return PB020I01;
	}

	public void setPB020I01(String pB020I01) {
		PB020I01 = pB020I01;
	}

	public String getPB020Q02() {
		return PB020Q02;
	}

	public void setPB020Q02(String pB020Q02) {
		PB020Q02 = pB020Q02;
	}

	public String getPB020Q03() {
		return PB020Q03;
	}

	public void setPB020Q03(String pB020Q03) {
		PB020Q03 = pB020Q03;
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