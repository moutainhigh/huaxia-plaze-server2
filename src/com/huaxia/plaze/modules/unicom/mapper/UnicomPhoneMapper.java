package com.huaxia.plaze.modules.unicom.mapper;

import com.huaxia.plaze.modules.unicom.domain.UnicomPhone;
import com.huaxia.plaze.modules.unicom.domain.UnicomPhoneMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomPhoneTrnRequest;

public interface UnicomPhoneMapper {
	
	void insertUnicomPhoneTrnRequest(UnicomPhoneTrnRequest unicomPhoneTrnRequest);
	
	void insertUnicomPhoneMsgResponse(UnicomPhoneMsgResponse unicomPhoneMsgResponse);
	
	void insertUnicomPhone(UnicomPhone unicomPhone);

}
