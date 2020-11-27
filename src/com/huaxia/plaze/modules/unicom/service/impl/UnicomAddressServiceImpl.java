package com.huaxia.plaze.modules.unicom.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.unicom.domain.UnicomAddress;
import com.huaxia.plaze.modules.unicom.domain.UnicomAddressMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomAddressTrnRequest;
import com.huaxia.plaze.modules.unicom.mapper.UnicomAddressMapper;
import com.huaxia.plaze.modules.unicom.service.UnicomAddressService;

@Service("unicomAddressService")
public class UnicomAddressServiceImpl implements UnicomAddressService {

	@Resource
	private UnicomAddressMapper unicomAddressMapper;
	
	
	// 保存请求参数
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveUnicomAddressTrnRequest(UnicomAddressTrnRequest uniaddinforRequest) {
		unicomAddressMapper.insterUnicomAddressTrnRequest(uniaddinforRequest);
	}

	// 保存原始报文结果
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveUnicomAddressMsgResponse(UnicomAddressMsgResponse unicomAddressMsgResponse) {
		unicomAddressMapper.insterUnicomAddressMsgResponse(unicomAddressMsgResponse);
	}

	// 保存结果报文解析结果
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveUnicomAddress(UnicomAddress unicomAddress) {
		unicomAddressMapper.insterUnicomAddress(unicomAddress);
	}

}
