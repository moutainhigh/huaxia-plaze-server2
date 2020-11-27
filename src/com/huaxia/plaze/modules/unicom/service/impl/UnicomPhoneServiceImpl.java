package com.huaxia.plaze.modules.unicom.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.unicom.domain.UnicomPhone;
import com.huaxia.plaze.modules.unicom.domain.UnicomPhoneMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomPhoneTrnRequest;
import com.huaxia.plaze.modules.unicom.mapper.UnicomPhoneMapper;
import com.huaxia.plaze.modules.unicom.service.UnicomPhoneService;

@Service("unicomPhoneService")
public class UnicomPhoneServiceImpl implements UnicomPhoneService {
	
	@Resource
	private UnicomPhoneMapper unicomPhoneMapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveUnicomPhoneTrnRequest(UnicomPhoneTrnRequest unicomPhoneTrnRequest) {
		unicomPhoneMapper.insertUnicomPhoneTrnRequest(unicomPhoneTrnRequest);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveUnicomPhoneMsgResponse(UnicomPhoneMsgResponse unicomPhoneMsgResponse) {
		unicomPhoneMapper.insertUnicomPhoneMsgResponse(unicomPhoneMsgResponse);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveUnicomPhone(UnicomPhone unicomPhone) {
		unicomPhoneMapper.insertUnicomPhone(unicomPhone);
	}

}
