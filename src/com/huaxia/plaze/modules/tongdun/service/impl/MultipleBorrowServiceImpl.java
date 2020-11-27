package com.huaxia.plaze.modules.tongdun.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.tongdun.domain.MulBorInfo;
import com.huaxia.plaze.modules.tongdun.mapper.MulBorAntifraudIndexMapper;
import com.huaxia.plaze.modules.tongdun.mapper.MulBorBaseMapper;
import com.huaxia.plaze.modules.tongdun.mapper.MulBorBlackListMapper;
import com.huaxia.plaze.modules.tongdun.mapper.MulBorDataSourceMapper;
import com.huaxia.plaze.modules.tongdun.mapper.MulBorDescreditCountMapper;
import com.huaxia.plaze.modules.tongdun.mapper.MulBorGreyListMapper;
import com.huaxia.plaze.modules.tongdun.mapper.MulBorRiskItemMapper;
import com.huaxia.plaze.modules.tongdun.service.MultipleBorrowService;

/**
 * 多头借贷数据入库
 * 
 * @author liuwei
 *
 */
@Service("multipleBorrowService")
public class MultipleBorrowServiceImpl implements MultipleBorrowService {

	@Resource
	private MulBorBaseMapper mulBorBaseMapper;

	@Resource
	private MulBorBlackListMapper mulBorBlackListMapper;

	@Resource
	private MulBorDescreditCountMapper mulBorDescreditCountMapper;

	@Resource
	private MulBorGreyListMapper mulBorGreyListMapper;

	@Resource
	private MulBorRiskItemMapper mulBorRiskItemMapper;

	@Resource
	private MulBorAntifraudIndexMapper mulBorAntifraudIndexMapper;

	@Resource
	private MulBorDataSourceMapper mulBorDataSourceMapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(MulBorInfo mulBorInfo) {
		if (mulBorInfo.getMulBorBase() != null) {
			mulBorBaseMapper.insert(mulBorInfo.getMulBorBase());
		}
		if (mulBorInfo.getMulBorRiskItemList() != null) {
			for (int i = 0; i < mulBorInfo.getMulBorRiskItemList().size(); i++) {
				mulBorRiskItemMapper.insert(mulBorInfo.getMulBorRiskItemList().get(i));
			}
		}

		if (mulBorInfo.getMulBorBlackListList() != null) {
			for (int i = 0; i < mulBorInfo.getMulBorBlackListList().size(); i++) {
				mulBorBlackListMapper.insert(mulBorInfo.getMulBorBlackListList().get(i));
			}
		}
		if (mulBorInfo.getMulBorDescreditCountList() != null) {
			for (int i = 0; i < mulBorInfo.getMulBorDescreditCountList().size(); i++) {
				mulBorDescreditCountMapper.insert(mulBorInfo.getMulBorDescreditCountList().get(i));
			}
		}
		if (mulBorInfo.getMulBorGreyListList() != null) {
			for (int i = 0; i < mulBorInfo.getMulBorGreyListList().size(); i++) {
				mulBorGreyListMapper.insert(mulBorInfo.getMulBorGreyListList().get(i));
			}
		}
		if (mulBorInfo.getMulBorAntifraudIndex() != null) {
			mulBorAntifraudIndexMapper.insert(mulBorInfo.getMulBorAntifraudIndex());
		}
		return 0;
	}

	@Override
	public void callDataSource(Map<String, Object> args) {
		mulBorDataSourceMapper.callDataSourceCount(args);
	}
}
