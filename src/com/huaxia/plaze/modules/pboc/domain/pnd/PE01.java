package com.huaxia.plaze.modules.pboc.domain.pnd;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 后付费业务信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PE01")
public class PE01 implements Serializable {

	private static final long serialVersionUID = -2639270079032745351L;

	private PE01A PE01A;// 后付费业务信息段

	private PE01Z PE01Z;// 标注及声明信息段 [0..1]

	public PE01A getPE01A() {
		return PE01A;
	}

	public void setPE01A(PE01A pE01A) {
		PE01A = pE01A;
	}

	public PE01Z getPE01Z() {
		return PE01Z;
	}

	public void setPE01Z(PE01Z pE01Z) {
		PE01Z = pE01Z;
	}

}
