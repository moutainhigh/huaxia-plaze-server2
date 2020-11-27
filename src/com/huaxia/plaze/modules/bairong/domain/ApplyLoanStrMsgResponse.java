package com.huaxia.plaze.modules.bairong.domain;

import java.util.Date;

public class ApplyLoanStrMsgResponse {

			//主键唯一
			private String uuid;
				
			//创建时间
			private Date crtTime;
				
			//创建用户
			private String crtUser;
			
		    //业务的主键，实现不同系统之间的同步
		    private String trnId;
		    
		    //响应报文体
		    private String messageBody;

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

			public String getMessageBody() {
				return messageBody;
			}

			public void setMessageBody(String messageBody) {
				this.messageBody = messageBody;
			}

			@Override
			public String toString() {
				return "ApplyLoanStrMsgResponse [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser
						+ ", trnId=" + trnId + ", messageBody=" + messageBody + "]";
			}
			
}
