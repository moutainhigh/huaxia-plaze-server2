package com.huaxia.plaze.modules.hz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.hz.domain.Data;
import com.huaxia.plaze.modules.hz.domain.HzCollection;
import com.huaxia.plaze.modules.hz.domain.HzMsgResponse;
import com.huaxia.plaze.modules.hz.domain.HzTrnRequest;
import com.huaxia.plaze.modules.hz.mapper.HzMapper;
import com.huaxia.plaze.modules.hz.service.HzService;

@Service("hzService")
public class HzServiceImpl implements HzService {
	
	@Resource
	private HzMapper hzMapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveHzTrnRequest(HzTrnRequest hzTrnRequest) {
		hzMapper.insertHzTrnRequest(hzTrnRequest);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveHzMsgResponse(HzMsgResponse hzMsgResponse) {
		hzMapper.insertHzMsgResponse(hzMsgResponse);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveHzCollection(HzCollection hzCollection) {
		if(hzCollection != null){
			hzMapper.insertHzInfo(hzCollection);
			Data data = hzCollection.getData();
			if(hzCollection.getData() != null){
				hzMapper.insertHzMatchStatus(data);
				hzMapper.insertHzApiChannelType(data);
				if(data.getGrxxs() != null){
					hzMapper.insertHzGrxx(data.getGrxxs());
				}
				if(data.getMarryInfos() != null){
					hzMapper.insertHzMarryInfo(data.getMarryInfos());
				}
				if(data.getGjjxxs() != null){
					hzMapper.insertHzgjjxx(data.getGjjxxs());
				}
				if(data.getRsjZxAc01s() != null){
					hzMapper.insertHzRsjZxAc01(data.getRsjZxAc01s());
				}
				if(data.getSbFeeinfogrids() != null){
					hzMapper.insertHzSbFeeinfogrid(data.getSbFeeinfogrids());
				}
				if(data.getVehicleInfos() != null){
					hzMapper.insertHzVehicleInfo(data.getVehicleInfos());
				}
				if(data.getEnterpriseInfos() != null){
					hzMapper.insertHzEnterpriseInfo(data.getEnterpriseInfos());
				}
				if(data.getGjjLoanInfos() != null){
					hzMapper.insertHzGjjLoanInfo(data.getGjjLoanInfos());
				}
				if(data.getFyNaturalPersons() != null){
					hzMapper.insertHzFyNaturalPerson(data.getFyNaturalPersons());
				}
				if(data.getVehiclePenaltyInfos() != null){
					hzMapper.insertHzVehiclePenaltyInfo(data.getVehiclePenaltyInfos());
				}
				if(data.getWaterAffairsInfos() != null){
					hzMapper.insertHzWaterAffairsInfo(data.getWaterAffairsInfos());
				}
			}
		}

	}

	@Override
	public String finBody(String certNo) {
		return hzMapper.selectBody(certNo);
	}

}
