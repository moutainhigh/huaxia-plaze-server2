package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;

import com.huaxia.plaze.modules.pboc.domain.psm.PC01;
public class PSM implements Serializable {
	private static final long serialVersionUID = -8617956521354460451L;
	private PC01 PC01;//评分信息单元

	public PC01 getPC01() {
		return PC01;
	}

	public void setPC01(PC01 pC01) {
		PC01 = pC01;
	}
	
}