package com.huaxia.plaze.modules.pboc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.pboc.mapper.BankTaskCallPlazeMapper;
import com.huaxia.plaze.modules.pboc.service.BankTaskCallPlazeService;

@Service("bankTaskCallPlazeService")
public class BankTaskCallPlazeServiceImpl implements BankTaskCallPlazeService {

	@Resource
	private BankTaskCallPlazeMapper bankTaskCallPlazeMapper;

	@Override
	public List<Map<String, String>> findBankTaskCallPlazeList(Map<String, Object> param) {
		return bankTaskCallPlazeMapper.selectBankTaskCallPlazeList(param);
	}

	@Override
	public List<Map<String, String>> findBankParamList(String identityNo, String identityType, String name,
			String taskStatus) {
		return bankTaskCallPlazeMapper.selectBankParamList(identityNo, identityType, name, taskStatus);
	}

	@Override
	public int updateTaskStatus(String identityNo, String identityType, String name, String updateStatus,
			String currStatus, String taskIp, String lstOptUser, String requestAddNum, String failureAddNum) {
		return bankTaskCallPlazeMapper.updateTaskStatus(identityNo, identityType, name, updateStatus, currStatus,
				taskIp, lstOptUser, requestAddNum, failureAddNum);
	}

	@Override
	public void saveBankTaskCallPlaze(Map<String, String> params) {
		bankTaskCallPlazeMapper.insertBankTaskCallPlaze(params);
	}

	@Override
	public List<Map<String, String>> findBankBackTaskPlazeList(Map<String, Object> param) {
		return bankTaskCallPlazeMapper.selectBankBackTaskPlazeList(param);
	}

	@Override
	public void deleteBankTaskPlaze(String uniqueRelid, String taskStatus) {
		bankTaskCallPlazeMapper.deleteBankTaskPlaze(uniqueRelid, taskStatus);
	}

	@Override
	public void updateBankTaskPlaze(String uniqueRelid, String updateStatus, String currStatus, String lstOptUser,
			String requestAddNum, String failureAddNum) {
		bankTaskCallPlazeMapper.updateBankTaskPlaze(uniqueRelid, updateStatus, currStatus, lstOptUser, requestAddNum,
				failureAddNum);
	}

	@Override
	public void saveBankTaskPlazeHis(String uniqueRelid) {
		bankTaskCallPlazeMapper.insertBankTaskPlazeHis(uniqueRelid);
	}

	@Override
	public void updatePbocTrnSingleReview(String sourceId, String status) {
		bankTaskCallPlazeMapper.updatePbocTrnSingleReview(sourceId, status);
	}

	@Override
	public Map<String, String> findUserAndPwd() {
		return bankTaskCallPlazeMapper.selectUserAndPwd();
	}

}
