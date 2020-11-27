package com.huaxia.plaze.modules.pboc.domain.pah;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 行政奖励记录信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF08A")
public class PF08A implements Serializable {

	private static final long serialVersionUID = 3816954819572887352L;
	private String PF08AQ01;// 奖励机构 -- [1..1]
	private String PF08AQ02;// 奖励内容 -- [1..1]
	private String PF08AR01;// 生效年月 -- [1..1]
	private String PF08AR02;// 截止年月 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个行政奖励记录的关联id

	public String getPF08AQ01() {
		return PF08AQ01;
	}

	public void setPF08AQ01(String pF08AQ01) {
		PF08AQ01 = pF08AQ01;
	}

	public String getPF08AQ02() {
		return PF08AQ02;
	}

	public void setPF08AQ02(String pF08AQ02) {
		PF08AQ02 = pF08AQ02;
	}

	public String getPF08AR01() {
		return PF08AR01;
	}

	public void setPF08AR01(String pF08AR01) {
		PF08AR01 = pF08AR01;
	}

	public String getPF08AR02() {
		return PF08AR02;
	}

	public void setPF08AR02(String pF08AR02) {
		PF08AR02 = pF08AR02;
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
