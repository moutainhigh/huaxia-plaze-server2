package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;

import com.huaxia.plaze.modules.pboc.domain.pim.PB01;
/**
 * 身份信息
 * @author gaoh
 *
 */
public class PIM implements Serializable {
	private static final long serialVersionUID = -5489415863785434355L;
	private PB01  PB01  ;//身份信息单元

	public PB01 getPB01() {
		return PB01;
	}

	public void setPB01(PB01 pB01) {
		PB01 = pB01;
	}
	
}