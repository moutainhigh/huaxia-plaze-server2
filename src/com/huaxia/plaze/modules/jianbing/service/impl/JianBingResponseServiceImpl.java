package com.huaxia.plaze.modules.jianbing.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.jianbing.domain.JianBingComAnalData;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjBrief;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjBriefAnal;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjDetail;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjDetailAnal;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjLoanBrief;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjLoanDetail;
import com.huaxia.plaze.modules.jianbing.domain.JianBingMsgResponse;
import com.huaxia.plaze.modules.jianbing.mapper.JianBingResponseMapper;
import com.huaxia.plaze.modules.jianbing.service.JianBingResponseService;
import com.huaxia.util.GuidUtil;

@Service("jianBingResponseService")
public class JianBingResponseServiceImpl implements JianBingResponseService {

	@Resource
	JianBingResponseMapper jianBingResponseMapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(Map<String, Object> info) throws Exception {
		// 返回报文
		String bodyStr = info.get("bodyStr").toString();
		info.get("trnId");
		// 交易编号
		String trnId = info.get("trnId").toString();
		// 创建者
		String crtUser = info.get("crtUser").toString();
		// 订单编号
		String applyId = info.get("applyId").toString();
		// pkUuid（用于trn_id相同时，分辨数据的不同时间版本）
		String trn_key = GuidUtil.getGuid();

		JianBingMsgResponse msg = new JianBingMsgResponse();
		msg.setMessageBody(bodyStr);
		msg.setCrtUser(crtUser);
		msg.setTrnId(trnId);
		msg.setApplyId(applyId);
		// 插入原报文
		jianBingResponseMapper.insertOriginMsg(msg);
		// 分别获取七张数据表的数据信息。
		JSONObject json = JSONObject.parseObject(bodyStr);
		JSONObject data = (JSONObject) json.get("gjj_data");
		JianBingGjjBrief brief = (JianBingGjjBrief) JSON.parseObject(data.get("gjj_brief").toString(),
				JianBingGjjBrief.class);

		JianBingGjjBriefAnal briefAnal = (JianBingGjjBriefAnal) JSON
				.parseObject(data.get("gjj_brief_analysis").toString(), JianBingGjjBriefAnal.class);

		List<JianBingGjjDetail> detailList = JSON.parseArray(data.getString("gjj_detail"), JianBingGjjDetail.class);

		JianBingGjjDetailAnal detailAnal = (JianBingGjjDetailAnal) JSON
				.parseObject(data.get("gjj_detail_analysis").toString(), JianBingGjjDetailAnal.class);
		List<JianBingComAnalData> comAnal = JSON.parseArray(detailAnal.getCompany_analyzed_data(),
				JianBingComAnalData.class);

		List<JianBingGjjLoanBrief> loanBrief = JSON.parseArray(data.getString("gjj_loan_brief"),
				JianBingGjjLoanBrief.class);

		JSONArray loanDetail = JSON.parseArray(data.getString("gjj_loan_detail"));

		brief.setCrt_user(crtUser);
		brief.setTrn_id(trnId);
		brief.setTrn_key(trn_key);
		// 插入公积金基本信息表
		int result = jianBingResponseMapper.insertBrief(brief);
		if (result > 0) {
			// 插入公积金基本信息明细表
			if (briefAnal != null) {
				briefAnal.setTrn_id(trnId);
				briefAnal.setCrt_user(crtUser);
				briefAnal.setTrn_key(trn_key);
				jianBingResponseMapper.insertBriefAnal(briefAnal);
			}
			// 插入公积金明细表
			if (detailList != null && detailList.size() > 0) {
				for (JianBingGjjDetail detail : detailList) {
					detail.setTrn_id(trnId);
					detail.setCrt_user(crtUser);
					detail.setTrn_key(trn_key);
					jianBingResponseMapper.insertGjjDetail(detail);
				}
			}
			// 插入公积金明细分析表
			if (detailAnal != null) {
				detailAnal.setTrn_id(trnId);
				detailAnal.setCrt_user(crtUser);
				detailAnal.setTrn_key(trn_key);
				jianBingResponseMapper.insertDetailAnal(detailAnal);
			}
			// 插入明细公司分析表
			if (comAnal != null && comAnal.size() > 0) {
				for (JianBingComAnalData company : comAnal) {
					company.setTrn_id(trnId);
					company.setCrt_user(crtUser);
					company.setTrn_key(trn_key);
					jianBingResponseMapper.insertComAnal(company);
				}
			}
			// 插入51公积金贷款表
			if (loanBrief != null && loanBrief.size() > 0) {
				for (JianBingGjjLoanBrief loan : loanBrief) {
					loan.setTrn_id(trnId);
					loan.setCrt_user(crtUser);
					loan.setTrn_key(trn_key);
					jianBingResponseMapper.insertGjjLoan(loan);
				}
			}
			// 插入公积金贷款明细表
			if (loanDetail != null && loanDetail.size() > 0) {
				for (int i = 0; i < loanDetail.size(); i++) {
					JSONArray detail = loanDetail.getJSONArray(i);
					for (int k = 0; k < detail.size(); k++) {
						JianBingGjjLoanDetail detailLoan = (JianBingGjjLoanDetail) JSON
								.parseObject(detail.getJSONObject(k).toString(), JianBingGjjLoanDetail.class);
						detailLoan.setTrn_id(trnId);
						detailLoan.setCrt_user(crtUser);
						detailLoan.setTrn_key(trn_key);
						jianBingResponseMapper.insertGjjLoanDetail(detailLoan);

					}
				}
			}

		}
		return result;

	}

	/*
	 * 查询模式为查找 去查找原报文
	 */
	@Override
	public String queryResponseByRequest(String apply_id) {
		return jianBingResponseMapper.selectResponseByRequest(apply_id);
	}

}
