package com.huaxia.plaze.modules.pboc.domain.pca;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 授信协议信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PD02")
public class PD02 implements Serializable {

	private static final long serialVersionUID = 6771638579445457865L;
	private PD02A PD02A;// 基本信息段 [1..1]
	private PD02Z PD02Z;// 标注及声明信息段 [0..1]

	public PD02A getPD02A() {
		return PD02A;
	}

	public void setPD02A(PD02A pD02A) {
		PD02A = pD02A;
	}

	public PD02Z getPD02Z() {
		return PD02Z;
	}

	public void setPD02Z(PD02Z pD02Z) {
		PD02Z = pD02Z;
	}

}
