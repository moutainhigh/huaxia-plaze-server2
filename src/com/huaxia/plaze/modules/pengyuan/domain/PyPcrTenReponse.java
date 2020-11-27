package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.List;

public class PyPcrTenReponse {

	// 鹏元个人信用报告表
	private PyPcrCrs pyPcrCrs;
	private List<PyCisReportCollection> pyCisReportCollectionList;
	private String ResultJson;

	public String getResultJson() {
		return ResultJson;
	}

	public void setResultJson(String resultJson) {
		ResultJson = resultJson;
	}

	public PyPcrCrs getPyPcrCrs() {
		return pyPcrCrs;
	}

	public void setPyPcrCrs(PyPcrCrs pyPcrCrs) {
		this.pyPcrCrs = pyPcrCrs;
	}

	public List<PyCisReportCollection> getPyCisReportCollectionList() {
		return pyCisReportCollectionList;
	}

	public void setPyCisReportCollectionList(List<PyCisReportCollection> pyCisReportCollectionList) {
		this.pyCisReportCollectionList = pyCisReportCollectionList;
	}

}
