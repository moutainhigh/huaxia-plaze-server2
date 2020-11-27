package com.huaxia.plaze.modules.pboc.domain.pot;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 欠税记录信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PF01")
public class PF01 implements Serializable {

	private static final long serialVersionUID = -7072931135897532751L;
	private PF01A PF01A;// 欠税记录信息段 [1..1]
	private PF01Z PF01Z;// 标注及声明信息段

	public PF01A getPF01A() {
		return PF01A;
	}

	public void setPF01A(PF01A pF01A) {
		PF01A = pF01A;
	}

	public PF01Z getPF01Z() {
		return PF01Z;
	}

	public void setPF01Z(PF01Z pF01Z) {
		PF01Z = pF01Z;
	}

}
