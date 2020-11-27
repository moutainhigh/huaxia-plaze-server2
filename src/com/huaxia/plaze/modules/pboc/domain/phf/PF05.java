package com.huaxia.plaze.modules.pboc.domain.phf;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 住房公积金参缴记录信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PF05")
public class PF05 implements Serializable {

	private static final long serialVersionUID = -6041539762586465861L;
	private PF05A PF05A;// 住房公积金参缴记录信息段 [1..1]
	private PF05Z PF05Z;// 标注及声明信息段 [0..1]

	public PF05A getPF05A() {
		return PF05A;
	}

	public void setPF05A(PF05A pF05A) {
		PF05A = pF05A;
	}

	public PF05Z getPF05Z() {
		return PF05Z;
	}

	public void setPF05Z(PF05Z pF05Z) {
		PF05Z = pF05Z;
	}

}
