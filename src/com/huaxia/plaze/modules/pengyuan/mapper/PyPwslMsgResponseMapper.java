package com.huaxia.plaze.modules.pengyuan.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.pengyuan.domain.PyPwslMsgResponse;

public interface PyPwslMsgResponseMapper {

	/**
	 * 保存数据源返回的原始报文
	 * @param pyPwslMsgResponse
	 * @return
	 */
	int save(PyPwslMsgResponse pyPwslMsgResponse);
	
	/**
	 * 通过请求条件查询已经保存的结果
	 * @param queryType
	 * @param name
	 * @param certNo
	 * @param subreportIds
	 * @param queryReaseonId
	 * @return
	 */
	List<String> findMsgByRequest(Map<String,Object> parameters);
}
