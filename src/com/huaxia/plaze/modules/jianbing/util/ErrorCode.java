package com.huaxia.plaze.modules.jianbing.util;

public enum ErrorCode {

	OK("000000", "处理成功"), MISS_EL("000001", "关键元素项缺失"), NO_PASS("000002", "关键元素项校验不通过"), 
	DATA_SOURCE_RESP_EX("999995","征信数据源响应报文异常"), DATA_SOURCE_DEAL_EX("999996", "征信数据源服务处理异常"), 
	DATA_SOURCE_TIMEOUT("999997","征信数据源服务请求超时"), 
	DATA_NOTFOUND("999991","查询需要的响应报文不存在"),DATA_SOURCE_YDJDMZ("999992","获取dmz连接异常"),
	DATA_PARSE_YDJDMZ("999993","调用dmz以及解析响应时异常"),
	DEAL_FAIL("999998", "处理失败"), DEAL_EX("999999", "处理异常");

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
