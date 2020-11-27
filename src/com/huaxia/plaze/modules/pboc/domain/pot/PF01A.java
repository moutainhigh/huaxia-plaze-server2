package com.huaxia.plaze.modules.pboc.domain.pot;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 欠税记录信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF01A")
public class PF01A implements Serializable {

	private static final long serialVersionUID = -145304041284673225L;
	private String PF01AQ01;// 主管税务机关 -- [1..1]
	private String PF01AJ01;// 欠税总额 -- [1..1]
	private String PF01AR01;// 欠税统计日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个欠税记录信息单元的关联id

	public String getPF01AQ01() {
		return PF01AQ01;
	}

	public void setPF01AQ01(String pF01AQ01) {
		PF01AQ01 = pF01AQ01;
	}

	public String getPF01AJ01() {
		return PF01AJ01;
	}

	public void setPF01AJ01(String pF01AJ01) {
		PF01AJ01 = pF01AJ01;
	}

	public String getPF01AR01() {
		return PF01AR01;
	}

	public void setPF01AR01(String pF01AR01) {
		PF01AR01 = pF01AR01;
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
