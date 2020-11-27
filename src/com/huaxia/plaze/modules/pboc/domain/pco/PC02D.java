package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;
/**
 * 逾期（透支）汇总信息段
 * @author gaoh
 *
 */
@Alias("PC02D")
public class PC02D implements Serializable {

	private static final long serialVersionUID = 4455707504231588192L;

	private PC02Ddata PC02Ddata;//逾期（透支）汇总信息段数据
	
	private List<PC02DH> PC02DHList;//逾期（透支）汇总信息

	public PC02Ddata getPC02Ddata() {
		return PC02Ddata;
	}

	public void setPC02Ddata(PC02Ddata pC02Ddata) {
		PC02Ddata = pC02Ddata;
	}

	public List<PC02DH> getPC02DHList() {
		return PC02DHList;
	}

	public void setPC02DHList(List<PC02DH> pC02DHList) {
		PC02DHList = pC02DHList;
	}
	
}