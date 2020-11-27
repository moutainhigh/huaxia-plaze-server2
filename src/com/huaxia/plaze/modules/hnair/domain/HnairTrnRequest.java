package com.huaxia.plaze.modules.hnair.domain;

import java.util.Date;

public class HnairTrnRequest {
			//主键唯一
			private String uuid;
				
			//创建时间
			private Date crtTime;
				
			//创建用户
			private String crtUser;
			
			//业务的主键，实现不同系统之间的同步
		    private String trnId;
			
		    //请求渠道
		    private String requestChannel;
		    
		    //查询模式
		    private String queryMode;
		    
		    //被查询者证件类型
		    private String certType;
		    
			//身份证号码
			private String certNo;
					
			//姓名
			private String name;
			
			//手机号码
			private String mobile;

			//调用类型
			private String trnCode;
			
			//传入的参数
			private String requestBody;

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

			public String getRequestChannel() {
				return requestChannel;
			}

			public void setRequestChannel(String requestChannel) {
				this.requestChannel = requestChannel;
			}

			public String getQueryMode() {
				return queryMode;
			}

			public void setQueryMode(String queryMode) {
				this.queryMode = queryMode;
			}

			public String getCertType() {
				return certType;
			}

			public void setCertType(String certType) {
				this.certType = certType;
			}

			public String getCertNo() {
				return certNo;
			}

			public void setCertNo(String certNo) {
				this.certNo = certNo;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getMobile() {
				return mobile;
			}

			public void setMobile(String mobile) {
				this.mobile = mobile;
			}

			public String getTrnCode() {
				return trnCode;
			}

			public void setTrnCode(String trnCode) {
				this.trnCode = trnCode;
			}

			public String getRequestBody() {
				return requestBody;
			}

			public void setRequestBody(String requestBody) {
				this.requestBody = requestBody;
			}

			@Override
			public String toString() {
				return "HnairTrnRequest [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId="
						+ trnId + ", requestChannel=" + requestChannel + ", queryMode=" + queryMode + ", certType="
						+ certType + ", certNo=" + certNo + ", name=" + name + ", mobile=" + mobile + ", trnCode="
						+ trnCode + ", requestBody=" + requestBody + "]";
			}
			
}
