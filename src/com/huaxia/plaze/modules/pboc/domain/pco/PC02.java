package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 信贷交易信息概要
 * 
 * @author gaoh
 *
 */
@Alias("PC02")
public class PC02 implements Serializable {

	private static final long serialVersionUID = -7714198335516997842L;
	private PC02A PC02A;// 信贷交易提示信息段
	private PC02B PC02B;// 被追偿汇总信息段
	private PC02C PC02C;// 呆账汇总信息段
	private PC02D PC02D;// 逾期（透支）汇总信息段
	private PC02E PC02E;// 非循环贷账户汇总信息段
	private PC02F PC02F;// 循环额度下分账户汇总信息段
	private PC02G PC02G;// 循环贷账户汇总信息段
	private PC02H PC02H;// 贷记卡账户汇总信息段
	private PC02I PC02I;// 准贷记卡账户汇总信息段
	private PC02K PC02K;// 相关还款责任汇总信息段

	public PC02A getPC02A() {
		return PC02A;
	}

	public void setPC02A(PC02A pC02A) {
		PC02A = pC02A;
	}

	public PC02B getPC02B() {
		return PC02B;
	}

	public void setPC02B(PC02B pC02B) {
		PC02B = pC02B;
	}

	public PC02C getPC02C() {
		return PC02C;
	}

	public void setPC02C(PC02C pC02C) {
		PC02C = pC02C;
	}

	public PC02D getPC02D() {
		return PC02D;
	}

	public void setPC02D(PC02D pC02D) {
		PC02D = pC02D;
	}

	public PC02E getPC02E() {
		return PC02E;
	}

	public void setPC02E(PC02E pC02E) {
		PC02E = pC02E;
	}

	public PC02F getPC02F() {
		return PC02F;
	}

	public void setPC02F(PC02F pC02F) {
		PC02F = pC02F;
	}

	public PC02G getPC02G() {
		return PC02G;
	}

	public void setPC02G(PC02G pC02G) {
		PC02G = pC02G;
	}

	public PC02H getPC02H() {
		return PC02H;
	}

	public void setPC02H(PC02H pC02H) {
		PC02H = pC02H;
	}

	public PC02I getPC02I() {
		return PC02I;
	}

	public void setPC02I(PC02I pC02I) {
		PC02I = pC02I;
	}

	public PC02K getPC02K() {
		return PC02K;
	}

	public void setPC02K(PC02K pC02K) {
		PC02K = pC02K;
	}

}