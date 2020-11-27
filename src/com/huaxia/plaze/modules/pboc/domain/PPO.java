package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;

import com.huaxia.plaze.modules.pboc.domain.ppo.PC04;
/**
 * 公共信息概要
 * @author gaoh
 *
 */
public class PPO implements Serializable {

	private static final long serialVersionUID = 9168226234907272140L;
	private PC04 PC04;//公共信息概要信息单元

	public PC04 getPC04() {
		return PC04;
	}

	public void setPC04(PC04 pC04) {
		PC04 = pC04;
	}
	
}