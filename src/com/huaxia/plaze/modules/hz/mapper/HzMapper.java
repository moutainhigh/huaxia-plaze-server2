package com.huaxia.plaze.modules.hz.mapper;

import java.util.List;

import com.huaxia.plaze.modules.hz.domain.Data;
import com.huaxia.plaze.modules.hz.domain.HzCollection;
import com.huaxia.plaze.modules.hz.domain.HzMsgResponse;
import com.huaxia.plaze.modules.hz.domain.HzTrnRequest;
import com.huaxia.plaze.modules.hz.domain.data.EnterpriseInfo;
import com.huaxia.plaze.modules.hz.domain.data.FyNaturalPerson;
import com.huaxia.plaze.modules.hz.domain.data.GjjLoanInfo;
import com.huaxia.plaze.modules.hz.domain.data.Gjjxx;
import com.huaxia.plaze.modules.hz.domain.data.Grxx;
import com.huaxia.plaze.modules.hz.domain.data.MarryInfo;
import com.huaxia.plaze.modules.hz.domain.data.RsjZxAc01;
import com.huaxia.plaze.modules.hz.domain.data.SbFeeinfogrid;
import com.huaxia.plaze.modules.hz.domain.data.VehicleInfo;
import com.huaxia.plaze.modules.hz.domain.data.VehiclePenaltyInfo;
import com.huaxia.plaze.modules.hz.domain.data.WaterAffairsInfo;

public interface HzMapper {
	
	void insertHzTrnRequest(HzTrnRequest hzTrnRequest);
	void insertHzMsgResponse(HzMsgResponse hzMsgResponse);
	
	void insertHzInfo(HzCollection hzCollection);
	void insertHzMatchStatus(Data data);
	void insertHzApiChannelType(Data data);
	void insertHzGrxx(List<Grxx> grxxs);
	void insertHzMarryInfo(List<MarryInfo> marryInfos);
	void insertHzgjjxx(List<Gjjxx> gjjxxs);
	void insertHzRsjZxAc01(List<RsjZxAc01> rsjZxAc01s);
	void insertHzSbFeeinfogrid(List<SbFeeinfogrid> sbFeeinfogrids);
	void insertHzVehicleInfo(List<VehicleInfo> vehicleInfos);
	void insertHzEnterpriseInfo(List<EnterpriseInfo> enterpriseInfos);
	void insertHzGjjLoanInfo(List<GjjLoanInfo> gjjLoanInfos);
	void insertHzFyNaturalPerson(List<FyNaturalPerson> fyNaturalPersons);
	void insertHzVehiclePenaltyInfo(List<VehiclePenaltyInfo> vehiclePenaltyInfos);
	void insertHzWaterAffairsInfo(List<WaterAffairsInfo> waterAffairsInfos);
	
	String selectBody(String certNo);

}
