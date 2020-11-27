package com.huaxia.plaze.modules.pboc.domain.ppq;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @author gaoh
 *
 */
@Alias("PF07")
public class PF07 implements Serializable {

	private static final long serialVersionUID = -7056235785462060272L;
	private PF07A PF07A;// 执业资格记录信息段 [1..1]
	private PF07Z PF07Z;// 标注及声明信息段 [0..1]

	public PF07A getPF07A() {
		return PF07A;
	}

	public void setPF07A(PF07A pF07A) {
		PF07A = pF07A;
	}

	public PF07Z getPF07Z() {
		return PF07Z;
	}

	public void setPF07Z(PF07Z pF07Z) {
		PF07Z = pF07Z;
	}

}
