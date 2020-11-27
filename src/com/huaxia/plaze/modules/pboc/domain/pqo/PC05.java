package com.huaxia.plaze.modules.pboc.domain.pqo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 查询记录概要信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PC05")
public class PC05 implements Serializable {

	private static final long serialVersionUID = 4325692066278524327L;
	private PC05A PC05A;// 上一次查询记录信息段
	private PC05B PC05B;// 查询记录汇总信息段 [1..1]

	public PC05A getPC05A() {
		return PC05A;
	}

	public void setPC05A(PC05A pC05A) {
		PC05A = pC05A;
	}

	public PC05B getPC05B() {
		return PC05B;
	}

	public void setPC05B(PC05B pC05B) {
		PC05B = pC05B;
	}

}