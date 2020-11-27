package com.huaxia.plaze.modules.pboc.domain.pcj;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 民事判决记录信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF02A")
public class PF02A implements Serializable {
	private static final long serialVersionUID = 7343148099619062960L;
	private String PF02AQ01;// 立案法院 -- [1..1]
	private String PF02AQ02;// 案由 -- [1..1]
	private String PF02AR01;// 立案日期 -- [1..1]
	private String PF02AD01;// 结案方式 -- [1..1]
	private String PF02AQ03;// 判决/调解结果 -- [1..1]
	private String PF02AR02;// 判决/调解生效日期 -- [1..1]
	private String PF02AQ04;// 诉讼标的 -- [1..1]
	private String PF02AJ01;// 诉讼标的金额 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个民事判决记录信息单元的关联id

	public String getPF02AQ01() {
		return PF02AQ01;
	}

	public void setPF02AQ01(String pF02AQ01) {
		PF02AQ01 = pF02AQ01;
	}

	public String getPF02AQ02() {
		return PF02AQ02;
	}

	public void setPF02AQ02(String pF02AQ02) {
		PF02AQ02 = pF02AQ02;
	}

	public String getPF02AR01() {
		return PF02AR01;
	}

	public void setPF02AR01(String pF02AR01) {
		PF02AR01 = pF02AR01;
	}

	public String getPF02AD01() {
		return PF02AD01;
	}

	public void setPF02AD01(String pF02AD01) {
		PF02AD01 = pF02AD01;
	}

	public String getPF02AQ03() {
		return PF02AQ03;
	}

	public void setPF02AQ03(String pF02AQ03) {
		PF02AQ03 = pF02AQ03;
	}

	public String getPF02AR02() {
		return PF02AR02;
	}

	public void setPF02AR02(String pF02AR02) {
		PF02AR02 = pF02AR02;
	}

	public String getPF02AQ04() {
		return PF02AQ04;
	}

	public void setPF02AQ04(String pF02AQ04) {
		PF02AQ04 = pF02AQ04;
	}

	public String getPF02AJ01() {
		return PF02AJ01;
	}

	public void setPF02AJ01(String pF02AJ01) {
		PF02AJ01 = pF02AJ01;
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
