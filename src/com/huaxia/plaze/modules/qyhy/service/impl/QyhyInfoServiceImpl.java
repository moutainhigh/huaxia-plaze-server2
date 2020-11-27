package com.huaxia.plaze.modules.qyhy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.qyhy.domain.QyhyInfo;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoBasic;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoData;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoMetaData;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoOrgBasic;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoOrgDetail;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoPerson;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoPunishBreak;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoShareHolder;
import com.huaxia.plaze.modules.qyhy.mapper.QyhyInfoMapper;
import com.huaxia.plaze.modules.qyhy.service.QyhyInfoService;

@Service("qyhyInfoService")
public class QyhyInfoServiceImpl implements QyhyInfoService {
	@Resource
	private QyhyInfoMapper qyhyInfoMapper;

	@Override
	public void saveQyhyInfoUpdateDataAdapterAction(QyhyInfo qyhyInfo, String uniqueRelid,String crtUser)
			throws Exception {

		// TODO Auto-generated method stub
		// String crtUser= "PLAZE";//系统默认用户名
		//===========1.企业行业信息 成功失败 参数存储表
		QyhyInfoData qyhyInfoData=qyhyInfo.getQyhyInfoData();
		if(qyhyInfoData != null){
			qyhyInfoData.setCrtUer(crtUser);
		}
		Integer code= qyhyInfoData.getCode();
		if(code==200||code==404||code==444||code==445||code==901){
		qyhyInfoMapper.insertQyhyInfoData(qyhyInfoData);
		//===========2.SHAREHOLDER 股东及出资信息 	
		List<QyhyInfoShareHolder> qyhyInfoShareHolderList=qyhyInfo.getQyhyInfoShareHolderList();
		if(qyhyInfoShareHolderList!=null&&qyhyInfoShareHolderList.size()>0){
			for(QyhyInfoShareHolder q : qyhyInfoShareHolderList){
				if(q != null){
					q.setCrtUser(crtUser);
				}
			}
			qyhyInfoMapper.insertQyhyInfoShareHolderList(qyhyInfoShareHolderList);
		}
		//===========3.BASIC 照面信息
		QyhyInfoBasic qyhyInfoBasic=qyhyInfo.getQyhyInfoBasic();
		if(qyhyInfoBasic!=null){
			qyhyInfoBasic.setCrtUser(crtUser);
			qyhyInfoMapper.insertQyhyInfoBasic(qyhyInfoBasic);
		}
		//===========4.PERSON 主要管理人员
		List<QyhyInfoPerson> qyhyInfoPersonList=qyhyInfo.getQyhyInfoPersonList();
		if(qyhyInfoPersonList!=null&&qyhyInfoPersonList.size()>0){
			for(QyhyInfoPerson q : qyhyInfoPersonList){
				if(q != null){
					q.setCrtUser(crtUser);
				}
			}
			qyhyInfoMapper.insertQyhyInfoPersonList(qyhyInfoPersonList);
		}
		//===========5.PUNISHBREAK 失信被执行人信息	
		List<QyhyInfoPunishBreak> qyhyInfoPunishBreakList=qyhyInfo.getQyhyInfoPunishBreakList();
		if(qyhyInfoPunishBreakList!=null&&qyhyInfoPunishBreakList.size()>0){
			for(QyhyInfoPunishBreak q : qyhyInfoPunishBreakList){
				if(q != null){
					q.setCrtUser(crtUser);
				}
			}
			qyhyInfoMapper.insertQyhyInfoPunishBreakList(qyhyInfoPunishBreakList);
		}
		//===========6.ORGBASIC 组织机构列表	
		List<QyhyInfoOrgBasic> qyhyInfoOrgBasicList=qyhyInfo.getQyhyInfoOrgBasicList();
		if(qyhyInfoOrgBasicList!=null&&qyhyInfoOrgBasicList.size()>0){
			for(QyhyInfoOrgBasic q : qyhyInfoOrgBasicList){
				if(q != null){
					q.setCrtUser(crtUser);
				}
			}
			qyhyInfoMapper.insertQyhyInfoOrgBasicList(qyhyInfoOrgBasicList);
		}
		//===========7.ORGDETAIL 组织机构详情
		 QyhyInfoOrgDetail qyhyInfoOrgDetail=qyhyInfo.getQyhyInfoOrgDetail();
		 if(qyhyInfoOrgDetail!=null){
			 qyhyInfoOrgDetail.setCrtUser(crtUser);
			 qyhyInfoMapper.insertQyhyInfoOrgDetail(qyhyInfoOrgDetail);
		 }
		//===========8.METADATA 元数据来源	
		 QyhyInfoMetaData qyhyInfoMetaData =qyhyInfo.getQyhyInfoMetaData();
		 if(qyhyInfoMetaData!=null){
			 qyhyInfoMetaData.setCrtUser(crtUser);
			 qyhyInfoMapper.insertQyhyInfoMetaData(qyhyInfoMetaData);
		    }
	     
		}
	

	}

}
