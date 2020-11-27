package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.List;

public class PyPwslResponse {

	private PyPwslCrs pyPwslCrs;
	private List<PyPwslCrsCrtCollection> pyPwslCrsCrtCollectionList;
	private String ResultJson;

	public PyPwslCrs getPyPwslCrs() {
		return pyPwslCrs;
	}

	public void setPyPwslCrs(PyPwslCrs pyPwslCrs) {
		this.pyPwslCrs = pyPwslCrs;
	}

	public List<PyPwslCrsCrtCollection> getPyPwslCrsCrtCollectionList() {
		return pyPwslCrsCrtCollectionList;
	}

	public void setPyPwslCrsCrtCollectionList(List<PyPwslCrsCrtCollection> pyPwslCrsCrtCollectionList) {
		this.pyPwslCrsCrtCollectionList = pyPwslCrsCrtCollectionList;
	}

	public String getResultJson() {
		return ResultJson;
	}

	public void setResultJson(String resultJson) {
		ResultJson = resultJson;
	}

}
