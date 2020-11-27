package com.huaxia.plaze.modules.trdrequest.domain;

public class TrdRequest {
	
	private String trnCode;
	private String requestUrl;
	private String method;
	public String getTrnCode() {
		return trnCode;
	}
	public void setTrnCode(String trnCode) {
		this.trnCode = trnCode;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
}
