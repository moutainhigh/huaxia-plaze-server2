package com.huaxia.plaze.modules.pboc.domain.pcj;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 民事判决记录信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PF02")
public class PF02 implements Serializable {

	private static final long serialVersionUID = -5157234363172734645L;
	private PF02A PF02A;// 民事判决记录信息段
	private PF02Z PF02Z;// 标注及声明信息段 [0..1]

	public PF02A getPF02A() {
		return PF02A;
	}

	public void setPF02A(PF02A pF02A) {
		PF02A = pF02A;
	}

	public PF02Z getPF02Z() {
		return PF02Z;
	}

	public void setPF02Z(PF02Z pF02Z) {
		PF02Z = pF02Z;
	}

}
