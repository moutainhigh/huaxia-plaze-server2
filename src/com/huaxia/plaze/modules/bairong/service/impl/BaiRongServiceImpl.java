package com.huaxia.plaze.modules.bairong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.bairong.domain.BRZX;
import com.huaxia.plaze.modules.bairong.domain.BRZXSpecialListForCell;
import com.huaxia.plaze.modules.bairong.domain.BRZXSpecialListForGid;
import com.huaxia.plaze.modules.bairong.domain.BRZXSpecialListForCid;
import com.huaxia.plaze.modules.bairong.domain.BRZXSpecialListForLmCell;
import com.huaxia.plaze.modules.bairong.mapper.BaiRongBaseMapper;
import com.huaxia.plaze.modules.bairong.mapper.BaiRongSpecialListForCellMapper;
import com.huaxia.plaze.modules.bairong.mapper.BaiRongSpecialListForGidMapper;
import com.huaxia.plaze.modules.bairong.mapper.BaiRongSpecialListForCidMapper;
import com.huaxia.plaze.modules.bairong.mapper.BaiRongSpecialListForLmCellMapper;
import com.huaxia.plaze.modules.bairong.service.BaiRongService;

@Service("baiRongService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class BaiRongServiceImpl implements BaiRongService {
	
	@Autowired
	private BaiRongBaseMapper bairongbaseMapper;
	
	@Autowired
	private BaiRongSpecialListForCidMapper baiRongSpecialListForIdMapper;
	
	@Autowired
	private BaiRongSpecialListForCellMapper baiRongSpecialListForCellMapper;
	
	@Autowired
	private BaiRongSpecialListForLmCellMapper baiRongSpecialListForLmCellMapper;
	
	@Autowired
	private BaiRongSpecialListForGidMapper baiRongSpecialListForGidMapper;
	
	@Override
	public int save(BRZX brzx) {
		int result = 0;
		
		// 插入基表
		saveSpecialListBase(brzx);

		// 通过身份证查询
		if (brzx.getSpecialListForId() != null) {
			BRZXSpecialListForCid specialListForId = brzx.getSpecialListForId();
			specialListForId.setSwiftNumber(brzx.getSwiftNumber());
			specialListForId.setCertNo(brzx.getCertNo());
			specialListForId.setPkUuid(brzx.getPkUuid());
			specialListForId.setCrtUser(brzx.getCrtUser());
			result += saveSpecialListForId(specialListForId);
		}

		// 通过手机号查询
		if (brzx.getSpecialListForCell() != null) {
			BRZXSpecialListForCell specialListForCell = brzx.getSpecialListForCell();
			specialListForCell.setSwiftNumber(brzx.getSwiftNumber());
			specialListForCell.setCertNo(brzx.getCertNo());
			specialListForCell.setPkUuid(brzx.getPkUuid());
			specialListForCell.setCrtUser(brzx.getCrtUser());
			result += saveSpecialListForCell(specialListForCell);
		}

		// 通过联系人手机号查询
		if (brzx.getSpecialListForLmCell() != null) {
			BRZXSpecialListForLmCell specialListForLmCell = brzx.getSpecialListForLmCell();
			specialListForLmCell.setSwiftNumber(brzx.getSwiftNumber());
			specialListForLmCell.setCertNo(brzx.getCertNo());;
			specialListForLmCell.setPkUuid(brzx.getPkUuid());
			specialListForLmCell.setCrtUser(brzx.getCrtUser());
			result += saveSpecialListForLmCell(specialListForLmCell);
		}

		// 通过GID查询
		if (brzx.getSpecialListForGid() != null) {
			BRZXSpecialListForGid specialListForGid = brzx.getSpecialListForGid();
			specialListForGid.setSwiftNumber(brzx.getSwiftNumber());
			specialListForGid.setCertNo(brzx.getCertNo());
			specialListForGid.setPkUuid(brzx.getPkUuid());
			specialListForGid.setCrtUser(brzx.getCrtUser());
			result += saveSpecialListForGid(specialListForGid);
		}
		
		return result;
	}

	@Override
	public int saveSpecialListForId(BRZX specialList) {
		return getBaiRongSpecialListForIdMapper().insert(specialList);
	}

	@Override
	public int saveSpecialListForCell(BRZX specialList) {
		return getBaiRongSpecialListForCellMapper().insert(specialList);
	}

	@Override
	public int saveSpecialListForLmCell(BRZX specialList) {
		return getBaiRongSpecialListForLmCellMapper().insert(specialList);
	}

	@Override
	public int saveSpecialListForGid(BRZX specialList) {
		return getBaiRongSpecialListForGidMapper().insert(specialList);
	}
	
	@Override
	public int saveSpecialListBase(BRZX brzx){
		return getBairongbaseMapper().insert(brzx);
	}

	public BaiRongBaseMapper getBairongbaseMapper() {
		return bairongbaseMapper;
	}

	public void setBairongbaseMapper(BaiRongBaseMapper bairongbaseMapper) {
		this.bairongbaseMapper = bairongbaseMapper;
	}

	public BaiRongSpecialListForCidMapper getBaiRongSpecialListForIdMapper() {
		return baiRongSpecialListForIdMapper;
	}

	public void setBaiRongSpecialListForIdMapper(BaiRongSpecialListForCidMapper baiRongSpecialListForIdMapper) {
		this.baiRongSpecialListForIdMapper = baiRongSpecialListForIdMapper;
	}

	public BaiRongSpecialListForCellMapper getBaiRongSpecialListForCellMapper() {
		return baiRongSpecialListForCellMapper;
	}

	public void setBaiRongSpecialListForCellMapper(BaiRongSpecialListForCellMapper baiRongSpecialListForCellMapper) {
		this.baiRongSpecialListForCellMapper = baiRongSpecialListForCellMapper;
	}

	public BaiRongSpecialListForLmCellMapper getBaiRongSpecialListForLmCellMapper() {
		return baiRongSpecialListForLmCellMapper;
	}

	public void setBaiRongSpecialListForLmCellMapper(BaiRongSpecialListForLmCellMapper baiRongSpecialListForLmCellMapper) {
		this.baiRongSpecialListForLmCellMapper = baiRongSpecialListForLmCellMapper;
	}

	public BaiRongSpecialListForGidMapper getBaiRongSpecialListForGidMapper() {
		return baiRongSpecialListForGidMapper;
	}

	public void setBaiRongSpecialListForGidMapper(BaiRongSpecialListForGidMapper baiRongSpecialListForGidMapper) {
		this.baiRongSpecialListForGidMapper = baiRongSpecialListForGidMapper;
	}

	@Override
	public BRZXSpecialListForCell findSpecialListForCellByFkUuid(String fkUuid) {
		return baiRongSpecialListForCellMapper.selectSpecialListForCellByFkUuid(fkUuid);
	}

}
