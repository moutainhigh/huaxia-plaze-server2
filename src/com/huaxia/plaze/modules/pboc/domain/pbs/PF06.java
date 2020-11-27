package com.huaxia.plaze.modules.pboc.domain.pbs;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 低保救助记录信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PF06")
public class PF06 implements Serializable {

	private static final long serialVersionUID = -7134069962601285017L;
	private PF06A PF06A;// 低保救助记录信息段 [1..1]
	private PF06Z PF06Z;// 标注及声明信息段 [0..1]

	public PF06A getPF06A() {
		return PF06A;
	}

	public void setPF06A(PF06A pF06A) {
		PF06A = pF06A;
	}

	public PF06Z getPF06Z() {
		return PF06Z;
	}

	public void setPF06Z(PF06Z pF06Z) {
		PF06Z = pF06Z;
	}

}
