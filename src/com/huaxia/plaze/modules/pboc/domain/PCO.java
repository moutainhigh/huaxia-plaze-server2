package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;

import com.huaxia.plaze.modules.pboc.domain.pco.PC02;
/**
 * 信贷交易信息概要
 * @author gaoh
 *
 */
public class PCO implements Serializable {

	private static final long serialVersionUID = 1913233068451630473L;
	private PC02 PC02;//信贷交易信息概要信息单元

	public PC02 getPC02() {
		return PC02;
	}

	public void setPC02(PC02 pC02) {
		PC02 = pC02;
	}
	
}