package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 被追偿汇总信息段
 * 
 * @author gaoh
 *
 */
@Alias("PC02B")
public class PC02B implements Serializable {

	private static final long serialVersionUID = 1469864922200575126L;

	private PC02Bdata PC02Bdata;// 被追偿汇总信息段数据

	private List<PC02BH> PC02BHList;// 被追偿汇总信息

	public PC02Bdata getPC02Bdata() {
		return PC02Bdata;
	}

	public void setPC02Bdata(PC02Bdata pC02Bdata) {
		PC02Bdata = pC02Bdata;
	}

	public List<PC02BH> getPC02BHList() {
		return PC02BHList;
	}

	public void setPC02BHList(List<PC02BH> pC02BHList) {
		PC02BHList = pC02BHList;
	}

}