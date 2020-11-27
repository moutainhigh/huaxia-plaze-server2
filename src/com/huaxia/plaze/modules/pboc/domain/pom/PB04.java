package com.huaxia.plaze.modules.pboc.domain.pom;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 职业信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PB04")
public class PB04 implements Serializable {

	private static final long serialVersionUID = 2369225580070441363L;
	private String PB040D01;// 就业状况 -- [1..1]
	private String PB040Q01;// 工作单位 -- [1..1]
	private String PB040D02;// 单位性质 -- [1..1]
	private String PB040D03;// 行业 -- [1..1]
	private String PB040Q02;// 单位地址 -- [1..1]
	private String PB040Q03;// 单位电话 -- [1..1]
	private String PB040D04;// 职业 -- [1..1]
	private String PB040D05;// 职务 -- [1..1]
	private String PB040D06;// 职称 -- [1..1]
	private String PB040R01;// 进入本单位年份 -- [1..1]
	private String PB040R02;// 信息更新日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPB040D01() {
		return PB040D01;
	}

	public void setPB040D01(String pB040D01) {
		PB040D01 = pB040D01;
	}

	public String getPB040Q01() {
		return PB040Q01;
	}

	public void setPB040Q01(String pB040Q01) {
		PB040Q01 = pB040Q01;
	}

	public String getPB040D02() {
		return PB040D02;
	}

	public void setPB040D02(String pB040D02) {
		PB040D02 = pB040D02;
	}

	public String getPB040D03() {
		return PB040D03;
	}

	public void setPB040D03(String pB040D03) {
		PB040D03 = pB040D03;
	}

	public String getPB040Q02() {
		return PB040Q02;
	}

	public void setPB040Q02(String pB040Q02) {
		PB040Q02 = pB040Q02;
	}

	public String getPB040Q03() {
		return PB040Q03;
	}

	public void setPB040Q03(String pB040Q03) {
		PB040Q03 = pB040Q03;
	}

	public String getPB040D04() {
		return PB040D04;
	}

	public void setPB040D04(String pB040D04) {
		PB040D04 = pB040D04;
	}

	public String getPB040D05() {
		return PB040D05;
	}

	public void setPB040D05(String pB040D05) {
		PB040D05 = pB040D05;
	}

	public String getPB040D06() {
		return PB040D06;
	}

	public void setPB040D06(String pB040D06) {
		PB040D06 = pB040D06;
	}

	public String getPB040R01() {
		return PB040R01;
	}

	public void setPB040R01(String pB040R01) {
		PB040R01 = pB040R01;
	}

	public String getPB040R02() {
		return PB040R02;
	}

	public void setPB040R02(String pB040R02) {
		PB040R02 = pB040R02;
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