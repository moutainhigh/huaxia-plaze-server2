package com.huaxia.plaze.modules.bairong.service;

import java.util.Date;
import java.util.List;

import com.huaxia.plaze.datasource.service.DataSourceCountService;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStr;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMsgResponse;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrTrnRequest;

/**
 * save十条表中的数据
 * 
 * @author liuwei
 */
public interface ApplyLoanStrService extends DataSourceCountService {

	int saveApplyLoanStr(ApplyLoanStr applyLoanStr);

	int saveRequest(ApplyLoanStrTrnRequest applyLoanStrTrnRequest);
	
	/**
	 * @Title: saveResponse
	 * @Description: 交易响应表数据入库
	 * @param applyLoanStrMsgResponse
	 * @return
	 * @author: LiuWei
	 * @Date: 2019年5月31日下午10:48:58
	 */
	int saveResponse(ApplyLoanStrMsgResponse applyLoanStrMsgResponse);

	/**
	 * @Title: selectListByParams
	 * @Description: 根据输入数据查询数据中是否有24小时之内的数据
	 * @param certNo
	 * @param mobile
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @return
	 * @author: LiuWei
	 * @Date: 2019年6月1日下午4:41:36
	 */
	List<ApplyLoanStrMsgResponse> queryListByParams(String certNo,String mobile,String name,Date startDate,Date endDate);
	/**
	 * @Title: queryListByParams
	 *@Description: 数据表中查询历史数据
	 *@param certNo
	 *@param mobile
	 *@param name
	 *@return
	 *@author: LiuWei
	 *@Date: 2019年9月3日下午3:37:35
	 */
	List<ApplyLoanStrMsgResponse> queryListByParams(String certNo,String mobile,String name);
	/**
	 * @param trnId
	 * @return
	 */
	ApplyLoanStrTrnRequest queryRequest (String trnId);
}
