package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 借贷账户信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PD01")
public class PD01 implements Serializable {
	private static final long serialVersionUID = 9102235508198218886L;
	private PD01A PD01A;// 基本信息段 [1..1]
	private PD01B PD01B;// 最新表现信息段
	private PD01C PD01C;// 最近一次月度表现信息段
	private PD01D PD01D;// 最近24个月还款记录信息段
	private PD01E PD01E;// 最近5年内历史表现信息段 [0..1]
	private PD01F PD01F;// 特殊交易信息段
	private PD01G PD01G;// 特殊事件说明信息段 [0..1]
	private PD01H PD01H;// 大额专项分期信息段 [0..1]
	private PD01Z PD01Z;// 标注及声明信息段

	public PD01A getPD01A() {
		return PD01A;
	}

	public void setPD01A(PD01A pD01A) {
		PD01A = pD01A;
	}

	public PD01B getPD01B() {
		return PD01B;
	}

	public void setPD01B(PD01B pD01B) {
		PD01B = pD01B;
	}

	public PD01C getPD01C() {
		return PD01C;
	}

	public void setPD01C(PD01C pD01C) {
		PD01C = pD01C;
	}

	public PD01D getPD01D() {
		return PD01D;
	}

	public void setPD01D(PD01D pD01D) {
		PD01D = pD01D;
	}

	public PD01E getPD01E() {
		return PD01E;
	}

	public void setPD01E(PD01E pD01E) {
		PD01E = pD01E;
	}

	public PD01F getPD01F() {
		return PD01F;
	}

	public void setPD01F(PD01F pD01F) {
		PD01F = pD01F;
	}

	public PD01G getPD01G() {
		return PD01G;
	}

	public void setPD01G(PD01G pD01G) {
		PD01G = pD01G;
	}

	public PD01H getPD01H() {
		return PD01H;
	}

	public void setPD01H(PD01H pD01H) {
		PD01H = pD01H;
	}

	public PD01Z getPD01Z() {
		return PD01Z;
	}

	public void setPD01Z(PD01Z pD01Z) {
		PD01Z = pD01Z;
	}

}
