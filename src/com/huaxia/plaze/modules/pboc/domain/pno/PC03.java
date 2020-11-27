package com.huaxia.plaze.modules.pboc.domain.pno;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 后付费业务欠费信息汇总信息单元 PC03
 * 
 * @author gaoh
 *
 */
@Alias("PC03")
public class PC03 implements Serializable {

	private static final long serialVersionUID = -7763627450416860415L;
	private PC03data PC03data;// 后付费业务欠费信息汇总信息单元数据
	private PC030H PC030H;// 后付费业务欠信息汇总信息 [1..1]

	public PC03data getPC03data() {
		return PC03data;
	}

	public void setPC03data(PC03data pC03data) {
		PC03data = pC03data;
	}

	public PC030H getPC030H() {
		return PC030H;
	}

	public void setPC030H(PC030H pC030H) {
		PC030H = pC030H;
	}

}