package com.huaxia.plaze.modules.unicom.service;

import com.huaxia.plaze.modules.unicom.domain.UnicomAddress;
import com.huaxia.plaze.modules.unicom.domain.UnicomAddressMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomAddressTrnRequest;

public interface UnicomAddressService {

	/** 保存请求参数*/
	void saveUnicomAddressTrnRequest(UnicomAddressTrnRequest uniaddinforRequest);

	/** 保存原始的结果报文*/
	void saveUnicomAddressMsgResponse(UnicomAddressMsgResponse unicomAddressMsgResponse);

	/** 结果报文解析入库*/
	void saveUnicomAddress(UnicomAddress unicomAddress);
	
	
}
