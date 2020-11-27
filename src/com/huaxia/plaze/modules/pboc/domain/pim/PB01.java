package com.huaxia.plaze.modules.pboc.domain.pim;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 身份信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PB01")
public class PB01 implements Serializable {

	private static final long serialVersionUID = 4745978883935040371L;
	private PB01A PB01A;// 基本概况信息段
	private PB01B PB01B;// 手机号码信息段

	public PB01A getPB01A() {
		return PB01A;
	}

	public void setPB01A(PB01A pB01A) {
		PB01A = pB01A;
	}

	public PB01B getPB01B() {
		return PB01B;
	}

	public void setPB01B(PB01B pB01B) {
		PB01B = pB01B;
	}

}