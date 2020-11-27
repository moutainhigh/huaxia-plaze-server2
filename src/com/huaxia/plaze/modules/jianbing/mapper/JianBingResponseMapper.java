package com.huaxia.plaze.modules.jianbing.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.jianbing.domain.JianBingComAnalData;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjBrief;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjBriefAnal;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjDetail;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjDetailAnal;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjLoanBrief;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjLoanDetail;
import com.huaxia.plaze.modules.jianbing.domain.JianBingMsgResponse;
import com.huaxia.plaze.modules.nciic.domain.NciicInfo;
import com.huaxia.plaze.modules.nciic.domain.NciicMsgResponse;
import com.huaxia.plaze.modules.nciic.domain.NciicResponse;

public interface JianBingResponseMapper {

	int insert(NciicInfo info);

	void insertMsg(NciicMsgResponse msg);

	String selectResponseByRequest(String apply_id);

	int insertBrief(JianBingGjjBrief brief);

	int insertBriefDetail(JianBingGjjDetail detail);

	int insertBriefAnal(JianBingGjjBriefAnal briefAnal);

	void insertGjjDetail(JianBingGjjDetail detail);

	void insertDetailAnal(JianBingGjjDetailAnal detailAnal);

	void insertGjjLoan(JianBingGjjLoanBrief loan);

	void insertGjjLoanDetail(JianBingGjjLoanDetail detailLoan);

	void insertOriginMsg(JianBingMsgResponse msg);

	void insertComAnal(JianBingComAnalData company);
}
