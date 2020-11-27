package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 信贷交易提示信息段
 * 
 * @author gaoh
 *
 */
@Alias("PC02A")
public class PC02A implements Serializable {
	private static final long serialVersionUID = -4348950790565624793L;
	private PC02Adata PC02Adata;// 信贷交易提示信息段数据
	private List<PC02AH> PC02AHList;// 信贷交易提示信息

	public PC02Adata getPC02Adata() {
		return PC02Adata;
	}

	public void setPC02Adata(PC02Adata pC02Adata) {
		PC02Adata = pC02Adata;
	}

	public List<PC02AH> getPC02AHList() {
		return PC02AHList;
	}

	public void setPC02AHList(List<PC02AH> pC02AHList) {
		PC02AHList = pC02AHList;
	}

}
