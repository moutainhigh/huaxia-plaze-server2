package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;

import com.huaxia.plaze.modules.pboc.domain.prh.PA01;

/**
 * 报告头
 * @author gaoh
 *
 */
public class PRH implements Serializable {
	
	private static final long serialVersionUID = -8525628955109874182L;
	private PA01 PA01;//报告头信息单元

	public PA01 getPA01() {
		return PA01;
	}

	public void setPA01(PA01 pA01) {
		PA01 = pA01;
	}
	

}