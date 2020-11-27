package com.huaxia.plaze.modules.bairong.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrBase;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrDay15;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrDay7;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrFst;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrLst;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMonth1;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMonth12;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMonth3;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMonth6;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMsgResponse;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrTrnRequest;

/**
 * 插入到百融多头借贷的相关表中的数据
 * 
 * @author liuwei
 */
public interface ApplyLoanStrMapper {

	int insertApplyLoanStrBase(ApplyLoanStrBase applyLoanStrBase);

	int insertApplyLoanStrD7(ApplyLoanStrDay7 applyLoanStrD7);

	int insertApplyLoanStrD15(ApplyLoanStrDay15 applyLoanStrD15);

	int insertApplyLoanStrM1(ApplyLoanStrMonth1 applyLoanStrM1);

	int insertApplyLoanStrM3(ApplyLoanStrMonth3 applyLoanStrM3);

	int insertApplyLoanStrM6(ApplyLoanStrMonth6 applyLoanStrM6);

	int insertApplyLoanStrM12(ApplyLoanStrMonth12 applyLoanStrM12);

	int insertApplyLoanStrFst(ApplyLoanStrFst applyLoanStrFst);

	int insertApplyLoanStrLst(ApplyLoanStrLst applyLoanStrLst);
	
	int insertRequest(ApplyLoanStrTrnRequest bdaiRongAlsTrnRequest);

	int insertResponse(ApplyLoanStrMsgResponse applyLoanStrMsgResponse);

	List<ApplyLoanStrMsgResponse> selectListByParams(Map<String, Object> args);

	List<ApplyLoanStrMsgResponse> selectHistoryListByParams(Map<String, Object> args);
	
	ApplyLoanStrTrnRequest selectRequest (String trnId);
}
