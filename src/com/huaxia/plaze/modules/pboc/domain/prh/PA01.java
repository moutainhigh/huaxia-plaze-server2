package com.huaxia.plaze.modules.pboc.domain.prh;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 报告头信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PA01")
public class PA01 implements Serializable {

	private static final long serialVersionUID = 3783627315132702916L;
	private PA01A PA01A;// 报告标识信息段
	private PA01B PA01B;// 本次查询请求信息段
	private PA01C PA01C;// 其他身份标识信息段
	private PA01D PA01D;// 防欺诈警示信息段
	private PA01E PA01E;// 异议提示信息段

	public PA01A getPA01A() {
		return PA01A;
	}

	public void setPA01A(PA01A pA01A) {
		PA01A = pA01A;
	}

	public PA01B getPA01B() {
		return PA01B;
	}

	public void setPA01B(PA01B pA01B) {
		PA01B = pA01B;
	}

	public PA01C getPA01C() {
		return PA01C;
	}

	public void setPA01C(PA01C pA01C) {
		PA01C = pA01C;
	}

	public PA01D getPA01D() {
		return PA01D;
	}

	public void setPA01D(PA01D pA01D) {
		PA01D = pA01D;
	}

	public PA01E getPA01E() {
		return PA01E;
	}

	public void setPA01E(PA01E pA01E) {
		PA01E = pA01E;
	}

}