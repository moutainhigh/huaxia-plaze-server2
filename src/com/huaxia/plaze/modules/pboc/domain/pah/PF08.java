package com.huaxia.plaze.modules.pboc.domain.pah;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 行政奖励记录信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PF08")
public class PF08 implements Serializable {

	private static final long serialVersionUID = -7800496428005914592L;
	private PF08A PF08A;// 行政奖励记录信息段
	private PF08Z PF08Z;// 标注及声明信息段

	public PF08A getPF08A() {
		return PF08A;
	}

	public void setPF08A(PF08A pF08A) {
		PF08A = pF08A;
	}

	public PF08Z getPF08Z() {
		return PF08Z;
	}

	public void setPF08Z(PF08Z pF08Z) {
		PF08Z = pF08Z;
	}

}
