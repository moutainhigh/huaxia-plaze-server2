package com.huaxia.plaze.modules.tencent.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TYAntifraud implements Serializable {
   
	private static final long serialVersionUID = -3157514020542124523L;
	private TYAntifraudData tyAntifraudData;//天御分主表
    private List<TYAntifraudRiskInfo> listTYAntifraudRiskInfo;//风险类型的说明
	public TYAntifraudData getTyAntifraudData() {
		return tyAntifraudData;
	}
	public void setTyAntifraudData(TYAntifraudData tyAntifraudData) {
		this.tyAntifraudData = tyAntifraudData;
	}
	public List<TYAntifraudRiskInfo> getListTYAntifraudRiskInfo() {
		return listTYAntifraudRiskInfo;
	}
	public void setListTYAntifraudRiskInfo(List<TYAntifraudRiskInfo> listTYAntifraudRiskInfo) {
		this.listTYAntifraudRiskInfo = listTYAntifraudRiskInfo;
	}
    
}