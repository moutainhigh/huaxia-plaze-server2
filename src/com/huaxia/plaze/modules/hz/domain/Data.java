package com.huaxia.plaze.modules.hz.domain;

import java.util.List;

import com.huaxia.plaze.modules.hz.domain.data.VehicleInfo;
import com.huaxia.plaze.modules.hz.domain.data.VehiclePenaltyInfo;
import com.huaxia.plaze.modules.hz.domain.data.WaterAffairsInfo;
import com.huaxia.plaze.modules.hz.domain.data.EnterpriseInfo;
import com.huaxia.plaze.modules.hz.domain.data.FyNaturalPerson;
import com.huaxia.plaze.modules.hz.domain.data.GjjLoanInfo;
import com.huaxia.plaze.modules.hz.domain.data.Gjjxx;
import com.huaxia.plaze.modules.hz.domain.data.Grxx;
import com.huaxia.plaze.modules.hz.domain.data.MarryInfo;
import com.huaxia.plaze.modules.hz.domain.data.RsjZxAc01;
import com.huaxia.plaze.modules.hz.domain.data.SbFeeinfogrid;

public class Data {
	
	private String trnId;
	private String name;
	private String pid;
	private String dataStatus;
	private String apiChannelType; //json格式的字符串
	
	private List<Grxx> grxxs;
	private List<MarryInfo> marryInfos;
	private List<Gjjxx> gjjxxs;
	private List<RsjZxAc01> rsjZxAc01s;
	private List<SbFeeinfogrid> sbFeeinfogrids;
	private List<VehicleInfo> vehicleInfos;
	private List<EnterpriseInfo> enterpriseInfos;
	private List<GjjLoanInfo> gjjLoanInfos;
	private List<FyNaturalPerson> fyNaturalPersons;
	private List<VehiclePenaltyInfo> vehiclePenaltyInfos;
	private List<WaterAffairsInfo> waterAffairsInfos;
	private String crtUser;
	
	public String getCrtUser() {
		return crtUser;
	}
	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}
	
	public String getTrnId() {
		return trnId;
	}
	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getDataStatus() {
		return dataStatus;
	}
	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}
	public String getApiChannelType() {
		return apiChannelType;
	}
	public void setApiChannelType(String apiChannelType) {
		this.apiChannelType = apiChannelType;
	}
	public List<Grxx> getGrxxs() {
		return grxxs;
	}
	public void setGrxxs(List<Grxx> grxxs) {
		this.grxxs = grxxs;
	}
	public List<MarryInfo> getMarryInfos() {
		return marryInfos;
	}
	public void setMarryInfos(List<MarryInfo> marryInfos) {
		this.marryInfos = marryInfos;
	}
	public List<Gjjxx> getGjjxxs() {
		return gjjxxs;
	}
	public void setGjjxxs(List<Gjjxx> gjjxxs) {
		this.gjjxxs = gjjxxs;
	}
	public List<RsjZxAc01> getRsjZxAc01s() {
		return rsjZxAc01s;
	}
	public void setRsjZxAc01s(List<RsjZxAc01> rsjZxAc01s) {
		this.rsjZxAc01s = rsjZxAc01s;
	}
	public List<SbFeeinfogrid> getSbFeeinfogrids() {
		return sbFeeinfogrids;
	}
	public void setSbFeeinfogrids(List<SbFeeinfogrid> sbFeeinfogrids) {
		this.sbFeeinfogrids = sbFeeinfogrids;
	}
	public List<VehicleInfo> getVehicleInfos() {
		return vehicleInfos;
	}
	public void setVehicleInfos(List<VehicleInfo> vehicleInfos) {
		this.vehicleInfos = vehicleInfos;
	}
	public List<EnterpriseInfo> getEnterpriseInfos() {
		return enterpriseInfos;
	}
	public void setEnterpriseInfos(List<EnterpriseInfo> enterpriseInfos) {
		this.enterpriseInfos = enterpriseInfos;
	}
	public List<GjjLoanInfo> getGjjLoanInfos() {
		return gjjLoanInfos;
	}
	public void setGjjLoanInfos(List<GjjLoanInfo> gjjLoanInfos) {
		this.gjjLoanInfos = gjjLoanInfos;
	}
	public List<FyNaturalPerson> getFyNaturalPersons() {
		return fyNaturalPersons;
	}
	public void setFyNaturalPersons(List<FyNaturalPerson> fyNaturalPersons) {
		this.fyNaturalPersons = fyNaturalPersons;
	}
	public List<VehiclePenaltyInfo> getVehiclePenaltyInfos() {
		return vehiclePenaltyInfos;
	}
	public void setVehiclePenaltyInfos(List<VehiclePenaltyInfo> vehiclePenaltyInfos) {
		this.vehiclePenaltyInfos = vehiclePenaltyInfos;
	}
	public List<WaterAffairsInfo> getWaterAffairsInfos() {
		return waterAffairsInfos;
	}
	public void setWaterAffairsInfos(List<WaterAffairsInfo> waterAffairsInfos) {
		this.waterAffairsInfos = waterAffairsInfos;
	}
	
}
