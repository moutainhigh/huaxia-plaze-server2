package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;

import com.huaxia.plaze.modules.pboc.domain.pno.PC03;
/**
 * 非信贷交易信息概要
 * @author gaoh
 *
 */
public class PNO  implements Serializable{
	private static final long serialVersionUID = 6067321323617168376L;
	private PC03 PC03;// 后付费业务欠费信息汇总信息单元

	public PC03 getPC03() {
		return PC03;
	}

	public void setPC03(PC03 pC03) {
		PC03 = pC03;
	}
	
}