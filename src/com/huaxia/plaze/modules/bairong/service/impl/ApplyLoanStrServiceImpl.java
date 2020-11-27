package com.huaxia.plaze.modules.bairong.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStr;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMsgResponse;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrTrnRequest;
import com.huaxia.plaze.modules.bairong.mapper.ApplyLoanStrDataSourceMapper;
import com.huaxia.plaze.modules.bairong.mapper.ApplyLoanStrMapper;
import com.huaxia.plaze.modules.bairong.service.ApplyLoanStrService;

@Service("applyLoanStrService")
public class ApplyLoanStrServiceImpl implements ApplyLoanStrService {

	@Resource
	private ApplyLoanStrMapper applyLoanStrMapper;
	
	@Resource
	private ApplyLoanStrDataSourceMapper applyLoanStrDataSourceMapper;

	@Override
	public int saveApplyLoanStr(ApplyLoanStr applyLoanStr) {
		int result = 0;
		if (applyLoanStr != null) {
			if (applyLoanStr.getApplyLoanStrBase() != null) {
				result += applyLoanStrMapper.insertApplyLoanStrBase(applyLoanStr.getApplyLoanStrBase());
			}
			if (applyLoanStr.getApplyLoanStrD7() != null) {
				result += applyLoanStrMapper.insertApplyLoanStrD7(applyLoanStr.getApplyLoanStrD7());
			}
			if (applyLoanStr.getApplyLoanStrD15() != null) {
				result += applyLoanStrMapper.insertApplyLoanStrD15(applyLoanStr.getApplyLoanStrD15());
			}
			if (applyLoanStr.getApplyLoanStrM1() != null) {
				result += applyLoanStrMapper.insertApplyLoanStrM1(applyLoanStr.getApplyLoanStrM1());
			}
			if (applyLoanStr.getApplyLoanStrM3() != null) {
				result += applyLoanStrMapper.insertApplyLoanStrM3(applyLoanStr.getApplyLoanStrM3());
			}
			if (applyLoanStr.getApplyLoanStrM6() != null) {
				result += applyLoanStrMapper.insertApplyLoanStrM6(applyLoanStr.getApplyLoanStrM6());
			}
			if (applyLoanStr.getApplyLoanStrM12() != null) {
				result += applyLoanStrMapper.insertApplyLoanStrM12(applyLoanStr.getApplyLoanStrM12());
			}
			if (applyLoanStr.getApplyLoanStrFst() != null) {
				result += applyLoanStrMapper.insertApplyLoanStrFst(applyLoanStr.getApplyLoanStrFst());
			}
			if (applyLoanStr.getApplyLoanStrLst() != null) {
				result += applyLoanStrMapper.insertApplyLoanStrLst(applyLoanStr.getApplyLoanStrLst());
			}
		}
		return result;
	}

	@Override
	public int saveRequest(ApplyLoanStrTrnRequest applyLoanStrTrnRequest) {
		return applyLoanStrMapper.insertRequest(applyLoanStrTrnRequest);
	}

	@Override
	public int saveResponse(ApplyLoanStrMsgResponse applyLoanStrMsgResponse) {
		return applyLoanStrMapper.insertResponse(applyLoanStrMsgResponse);
	}

	@Override
	public List<ApplyLoanStrMsgResponse> queryListByParams(String certNo, String mobile, String name, Date startDate,
			Date endDate) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("certNo", certNo);
		args.put("mobile", mobile);
		args.put("name", name);
		args.put("startDate", startDate);
		args.put("endDate", endDate);
		return applyLoanStrMapper.selectListByParams(args);
	}

	@Override
	public List<ApplyLoanStrMsgResponse> queryListByParams(String certNo, String mobile, String name) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("certNo", certNo);
		args.put("mobile", mobile);
		args.put("name", name);
		return applyLoanStrMapper.selectHistoryListByParams(args);
	}

	@Override
	public void callDataSource(Map<String, Object> args) {
		applyLoanStrDataSourceMapper.callDataSourceCount(args);
	}

	@Override
	public ApplyLoanStrTrnRequest queryRequest(String trnId) {
		// TODO Auto-generated method stub
		return applyLoanStrMapper.selectRequest(trnId);
	}

}
