package com.huaxia.plaze.modules.unicom.mapper;

import com.huaxia.plaze.modules.unicom.domain.UnicomAddress;
import com.huaxia.plaze.modules.unicom.domain.UnicomAddressMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomAddressTrnRequest;

public interface UnicomAddressMapper {

	public void insterUnicomAddressTrnRequest(UnicomAddressTrnRequest uniaddinforRequest);

	public void insterUnicomAddressMsgResponse(UnicomAddressMsgResponse unicomAddressMsgResponse);

	public void insterUnicomAddress(UnicomAddress unicomAddress);

}
