package com.huaxia.plaze.modules.bairong.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 第三方   & 百融
 * 
 * @author wss
 *
 */
public class BRZX implements Serializable {

	private static final long serialVersionUID = 2460870788892083779L;

	// 记录编号
	private String uuid;

	// 创建时间
	private Date crtTime;
	
	// 创建用户
	private String crtUser;
	
	// 身份证号码 关联用的
	private String 	trnId;
	
	// 每个身份证号码关联唯一的pkUuid值
	private String pkUuid;
	
	// 身份证号
	private String certNo;

	// 响应参数 & 流水号（设备请求唯一标识）
	private String swiftNumber;

	// 响应参数 & 响应代码
	private String code;

	// 特殊名单核查 & 通过身份证查询
	private BRZXSpecialListForCid specialListForId;

	// 特殊名单核查 & 通过手机号查询
	private BRZXSpecialListForCell specialListForCell;

	// 特殊名单核查 & 通过联系人手机号查询
	private BRZXSpecialListForLmCell specialListForLmCell;

	// 特殊名单核查 & 通过GID查询
	private BRZXSpecialListForGid specialListForGid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public String getCrtUser() {
		return crtUser;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public String getTrnId() {
		return trnId;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

	public String getPkUuid() {
		return pkUuid;
	}

	public void setPkUuid(String pkUuid) {
		this.pkUuid = pkUuid;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BRZXSpecialListForCid getSpecialListForId() {
		return specialListForId;
	}

	public void setSpecialListForId(BRZXSpecialListForCid specialListForId) {
		this.specialListForId = specialListForId;
	}

	public BRZXSpecialListForCell getSpecialListForCell() {
		return specialListForCell;
	}

	public void setSpecialListForCell(BRZXSpecialListForCell specialListForCell) {
		this.specialListForCell = specialListForCell;
	}

	public BRZXSpecialListForLmCell getSpecialListForLmCell() {
		return specialListForLmCell;
	}

	public void setSpecialListForLmCell(BRZXSpecialListForLmCell specialListForLmCell) {
		this.specialListForLmCell = specialListForLmCell;
	}

	public BRZXSpecialListForGid getSpecialListForGid() {
		return specialListForGid;
	}

	public void setSpecialListForGid(BRZXSpecialListForGid specialListForGid) {
		this.specialListForGid = specialListForGid;
	}
	
}
