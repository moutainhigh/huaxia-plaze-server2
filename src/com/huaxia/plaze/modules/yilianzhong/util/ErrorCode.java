package com.huaxia.plaze.modules.yilianzhong.util;

public enum ErrorCode {

	OK("000000", "处理成功"), MISS_EL("000001", "关键元素项缺失"), NO_PASS("000002", "关键元素项校验不通过"), DATA_SOURCE_RESP_EX("999995",
			"征信数据源响应报文异常"), DATA_SOURCE_DEAL_EX("999995", "征信数据源服务处理异常"), DATA_SOURCE_TIMEOUT("999997",
					"征信数据源服务请求超时"), DEAL_FAIL("999998", "处理失败"), DEAL_EX("999999", "处理异常");

	private String code;
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	ErrorCode(String code, String description) {
		this.code = code;
		this.description = description;
	}
}
