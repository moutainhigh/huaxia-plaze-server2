package com.huaxia.plaze.modules.pengyuan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.pengyuan.domain.PyCisReportCollection;
import com.huaxia.plaze.modules.pengyuan.domain.PyCrsCrtBdiCisAbi;
import com.huaxia.plaze.modules.pengyuan.domain.PyCrsCrtBsi;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrt;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdi;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiCisAci;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiCisHs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiCisO12m;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiCisPp12m;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiCisPt12m;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiCisWa12m;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiCisWt12m;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiLisAbi;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiLisAci;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiLisBs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiLisHs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtBdiLisPl24m;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtHqi;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtHqiItm;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtIvi;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtIviItm;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtPbi;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtPbiAis;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtPbiDa;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtPbiDis;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtPbiHnis;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtPbiJis;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtPbiLbi;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtPbiSi;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtQcs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSi;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSiItm;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSisz2;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSisz2Bi;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSisz2Hi5y;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSisz2Pui;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSisz2Si5y;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSzbsi;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSzbsiBks;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSzbsiBss;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSzbsiIs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSzbsiSs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrCrsCrtSzbsiTs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrTenReponse;
import com.huaxia.plaze.modules.pengyuan.mapper.PyCrsCrtBdiCisAbiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyCrsCrtBsiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiCisAciMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiCisHsMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiCisO12mMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiCisPp12mMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiCisPt12mMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiCisWa12mMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiCisWt12mMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiLisAbiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiLisAciMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiLisBsMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiLisHsMappper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiLisPl24mMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtBdiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtHqiItmMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtHqiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtIviItmMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtIviMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtPbiAisMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtPbiDaMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtPbiDisMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtPbiHnisMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtPbiJisMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtPbiLbiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtPbiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtPbiSiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtQcsMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSiItmMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSisz2BiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSisz2Hi5yMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSisz2Mapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSisz2PuiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSisz2Si5yMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSzbsiBksMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSzbsiBssMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSzbsiIsMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSzbsiMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSzbsiSsMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsCrtSzbsiTsMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrCrsMapper;
import com.huaxia.plaze.modules.pengyuan.service.PyPcrTenReponseService;

@Service("pyPcrTenReponseService")
public class PyPcrTenReponseServiceImp implements PyPcrTenReponseService {

	private final static Logger logger = LoggerFactory.getLogger(PyPcrTenReponseServiceImp.class);

	@Resource
	private PyPcrCrsMapper pyPcrCrsMapper;
	@Resource
	private PyPcrCrsCrtMapper pyPcrCrsCrtMapper;
	@Resource
	private PyPcrCrsCrtQcsMapper pyPcrCrsCrtQcsMapper;
	@Resource
	private PyPcrCrsCrtPbiMapper pyPcrCrsCrtPbiMapper;
	@Resource
	private PyPcrCrsCrtPbiSiMapper pyPcrCrsCrtPbiSiMapper;
	@Resource
	private PyPcrCrsCrtPbiLbiMapper pyPcrCrsCrtPbiLbiMapper;
	@Resource
	private PyPcrCrsCrtPbiDisMapper pyPcrCrsCrtPbiDisMapper;
	@Resource
	private PyPcrCrsCrtPbiAisMapper pyPcrCrsCrtPbiAisMapper;
	@Resource
	private PyPcrCrsCrtPbiJisMapper pyPcrCrsCrtPbiJisMapper;
	@Resource
	private PyPcrCrsCrtPbiHnisMapper pyPcrCrsCrtPbiHnisMapper;
	@Resource
	private PyPcrCrsCrtPbiDaMapper pyPcrCrsCrtPbiDaMapper;
	@Resource
	private PyPcrCrsCrtBdiMapper pyPcrCrsCrtBdiMapper;
	@Resource
	private PyCrsCrtBdiCisAbiMapper pyCrsCrtBdiCisAbiMapper;
	@Resource
	private PyPcrCrsCrtBdiCisAciMapper pyPcrCrsCrtBdiCisAciMapper;
	@Resource
	private PyPcrCrsCrtBdiCisHsMapper pyPcrCrsCrtBdiCisHsMapper;
	@Resource
	private PyPcrCrsCrtBdiCisO12mMapper pyPcrCrsCrtBdiCisO12mMapper;
	@Resource
	private PyPcrCrsCrtBdiCisPp12mMapper pyPcrCrsCrtBdiCisPp12mMapper;
	@Resource
	private PyPcrCrsCrtBdiCisPt12mMapper PyPcrCrsCrtBdiCisPt12mMapper;
	@Resource
	private PyPcrCrsCrtBdiCisWa12mMapper pyPcrCrsCrtBdiCisWa12mMapper;
	@Resource
	private PyPcrCrsCrtBdiCisWt12mMapper pyPcrCrsCrtBdiCisWt12mMapper;
	@Resource
	private PyPcrCrsCrtBdiLisBsMapper pyPcrCrsCrtBdiLisBsMapper;
	@Resource
	private PyPcrCrsCrtBdiLisAbiMapper pyPcrCrsCrtBdiLisAbiMapper;
	@Resource
	private PyPcrCrsCrtBdiLisAciMapper pyPcrCrsCrtBdiLisAciMapper;
	@Resource
	private PyPcrCrsCrtBdiLisPl24mMapper pyPcrCrsCrtBdiLisPl24mMapper;
	@Resource
	private PyPcrCrsCrtBdiLisHsMappper pyPcrCrsCrtBdiLisHsMapper;
	@Resource
	private PyCrsCrtBsiMapper pyCrsCrtBsiMapper;
	@Resource
	private PyPcrCrsCrtSisz2Mapper pyPcrCrsCrtSisz2Mapper;
	@Resource
	private PyPcrCrsCrtSisz2BiMapper pyPcrCrsCrtSisz2BiMapper;
	@Resource
	private PyPcrCrsCrtSisz2PuiMapper pyPcrCrsCrtSisz2PuiMapper;
	@Resource
	private PyPcrCrsCrtSisz2Hi5yMapper pyPcrCrsCrtSisz2Hi5yMapper;
	@Resource
	private PyPcrCrsCrtSisz2Si5yMapper pyPcrCrsCrtSisz2Si5yMapper;
	@Resource
	private PyPcrCrsCrtSiMapper pyPcrCrsCrtSiMapper;
	@Resource
	private PyPcrCrsCrtSiItmMapper PyPcrCrsCrtSiItmMapper;
	@Resource
	private PyPcrCrsCrtIviMapper pyPcrCrsCrtIviMapper;
	@Resource
	private PyPcrCrsCrtIviItmMapper pyPcrCrsCrtIviItmMapper;
	@Resource
	private PyPcrCrsCrtSzbsiMapper pyPcrCrsCrtSzbsiMapper;
	@Resource
	private PyPcrCrsCrtSzbsiBssMapper pyPcrCrsCrtSzbsiBssMapper;
	@Resource
	private PyPcrCrsCrtSzbsiBksMapper pyPcrCrsCrtSzbsiBksMapper;
	@Resource
	private PyPcrCrsCrtSzbsiIsMapper pyPcrCrsCrtSzbsiIsMapper;
	@Resource
	private PyPcrCrsCrtSzbsiSsMapper pyPcrCrsCrtSzbsiSsMapper;
	@Resource
	private PyPcrCrsCrtSzbsiTsMapper pyPcrCrsCrtSzbsiTsMapper;
	@Resource
	private PyPcrCrsCrtHqiMapper pyPcrCrsCrtHqiMapper;
	@Resource
	private PyPcrCrsCrtHqiItmMapper pyPcrCrsCrtHqiItmMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int savePyPcrTenReponse(PyPcrTenReponse pyPcrTenReponse) {
		if (pyPcrTenReponse != null) {
			PyPcrCrs pyPcrCrs = pyPcrTenReponse.getPyPcrCrs();
			if (pyPcrCrs != null) {
				pyPcrCrsMapper.savePyPcrCrs(pyPcrCrs);
			}
			List<PyCisReportCollection> pyCisReportCollectionList = pyPcrTenReponse.getPyCisReportCollectionList();
			if (pyCisReportCollectionList != null && pyCisReportCollectionList.size() > 0) {
				for (PyCisReportCollection pyCisReport : pyCisReportCollectionList) {
					try {
						// 鹏元个人信用报告报告表
						PyPcrCrsCrt pyPcrCrsCrt = pyCisReport.getPyPcrCrsCrt();
						if (pyCisReport != null) {
							pyPcrCrsCrtMapper.savePyPcrCrsCrt(pyPcrCrsCrt);
						}
						// 鹏元个人信用报告查询条件表
						List<PyPcrCrsCrtQcs> pyPcrCrsCrtQcsList = pyCisReport.getPyPcrCrsCrtQcsList();
						if (pyPcrCrsCrtQcsList != null && pyPcrCrsCrtQcsList.size() > 0) {
							for (PyPcrCrsCrtQcs pyPcrCrsCrtQcs : pyPcrCrsCrtQcsList) {
								pyPcrCrsCrtQcsMapper.savePyPcrCrsCrtQcs(pyPcrCrsCrtQcs);
							}
						}
						// 鹏元个人信用报告个人基本信息表
						PyPcrCrsCrtPbi pyPcrCrsCrtPbi = pyCisReport.getPyPcrCrsCrtPbi();
						if (pyPcrCrsCrtPbi != null) {
							pyPcrCrsCrtPbiMapper.savePyPcrCrsCrtPbi(pyPcrCrsCrtPbi);
						}
						// 鹏元个人信用报告摘要信息表
						PyPcrCrsCrtPbiSi pyPcrCrsCrtPbiSi = pyCisReport.getPyPcrCrsCrtPbiSi();
						if (pyPcrCrsCrtPbiSi != null) {
							pyPcrCrsCrtPbiSiMapper.savePyPcrCrsCrtPbiSi(pyPcrCrsCrtPbiSi);
						}
						// 鹏元个人信用报告最新基本信息表
						PyPcrCrsCrtPbiLbi pyPcrCrsCrtPbiLbi = pyCisReport.getPyPcrCrsCrtPbiLbi();
						if (pyPcrCrsCrtPbiLbi != null) {
							pyPcrCrsCrtPbiLbiMapper.savePyPcrCrsCrtPbiLbi(pyPcrCrsCrtPbiLbi);
						}
						// 鹏元个人信用报告证件信息表
						List<PyPcrCrsCrtPbiDis> pyPcrCrsCrtPbiDisList = pyCisReport.getPyPcrCrsCrtPbiDisList();
						if (pyPcrCrsCrtPbiDisList != null && pyPcrCrsCrtPbiDisList.size() > 0) {
							for (PyPcrCrsCrtPbiDis pyPcrCrsCrtPbiDis : pyPcrCrsCrtPbiDisList) {
								pyPcrCrsCrtPbiDisMapper.savePyPcrCrsCrtPbiDis(pyPcrCrsCrtPbiDis);
							}
						}
						// 鹏元个人信用报告地址信息表
						List<PyPcrCrsCrtPbiAis> pyPcrCrsCrtPbiAisList = pyCisReport.getPyPcrCrsCrtPbiAisList();
						if (pyPcrCrsCrtPbiAisList != null && pyPcrCrsCrtPbiAisList.size() > 0) {
							for (PyPcrCrsCrtPbiAis pyPcrCrsCrtPbiAis : pyPcrCrsCrtPbiAisList) {
								pyPcrCrsCrtPbiAisMapper.savePyPcrCrsCrtPbiAis(pyPcrCrsCrtPbiAis);
							}
						}
						// 鹏元个人信用报告历次任职信息表
						List<PyPcrCrsCrtPbiJis> pyPcrCrsCrtPbiJisList = pyCisReport.getPyPcrCrsCrtPbiJisList();
						if (pyPcrCrsCrtPbiJisList != null && pyPcrCrsCrtPbiJisList.size() > 0) {
							for (PyPcrCrsCrtPbiJis pyPcrCrsCrtPbiJis : pyPcrCrsCrtPbiJisList) {
								pyPcrCrsCrtPbiJisMapper.savePyPcrCrsCrtPbiJis(pyPcrCrsCrtPbiJis);
							}
						}
						// 鹏元个人信用报告曾用名信息表
						List<PyPcrCrsCrtPbiHnis> pyPcrCrsCrtPbiHnisList = pyCisReport.getPyPcrCrsCrtPbiHnisList();
						if (pyPcrCrsCrtPbiHnisList != null && pyPcrCrsCrtPbiHnisList.size() > 0) {
							for (PyPcrCrsCrtPbiHnis pyPcrCrsCrtPbiHnis : pyPcrCrsCrtPbiHnisList) {
								pyPcrCrsCrtPbiHnisMapper.savePyPcrCrsCrtPbiHnis(pyPcrCrsCrtPbiHnis);
							}
						}
						// 鹏元个人信用报告身份警示信息表
						List<PyPcrCrsCrtPbiDa> pyPcrCrsCrtPbiDaList = pyCisReport.getPyPcrCrsCrtPbiDaList();
						if (pyPcrCrsCrtPbiDaList != null && pyPcrCrsCrtPbiDaList.size() > 0) {
							for (PyPcrCrsCrtPbiDa pyPcrCrsCrtPbiDa : pyPcrCrsCrtPbiDaList) {
								pyPcrCrsCrtPbiDaMapper.savePyPcrCrsCrtPbiDa(pyPcrCrsCrtPbiDa);
							}
						}
						// 鹏元个人信用报告银行信用信息表
						PyPcrCrsCrtBdi pyPcrCrsCrtBdi = pyCisReport.getPyPcrCrsCrtBdi();
						if (pyPcrCrsCrtBdi != null) {
							pyPcrCrsCrtBdiMapper.savePyPcrCrsCrtBdi(pyPcrCrsCrtBdi);
						}
						// 鹏元个人信用报告贷款信息账户基本信息表
						List<PyCrsCrtBdiCisAbi> pyCrsCrtBdiCisAbiList = pyCisReport.getPyCrsCrtBdiCisAbiList();
						if (pyCrsCrtBdiCisAbiList != null && pyCrsCrtBdiCisAbiList.size() > 0) {
							for (PyCrsCrtBdiCisAbi pyCrsCrtBdiCisAbi : pyCrsCrtBdiCisAbiList) {
								pyCrsCrtBdiCisAbiMapper.savePyCrsCrtBdiCisAbi(pyCrsCrtBdiCisAbi);
							}
						}
						// 鹏元个人信用报告银行信用信息信用卡账户动态信息表
						List<PyPcrCrsCrtBdiCisAci> pyPcrCrsCrtBdiCisAciList = pyCisReport.getPyPcrCrsCrtBdiCisAciList();
						if (pyPcrCrsCrtBdiCisAciList != null && pyPcrCrsCrtBdiCisAciList.size() > 0) {
							for (PyPcrCrsCrtBdiCisAci pyPcrCrsCrtBdiCisAci : pyPcrCrsCrtBdiCisAciList) {
								pyPcrCrsCrtBdiCisAciMapper.savePyPcrCrsCrtBdiCisAci(pyPcrCrsCrtBdiCisAci);
							}
						}
						// 鹏元个人信用报告银行信用信息信用卡状态变动记录表
						List<PyPcrCrsCrtBdiCisHs> pyPcrCrsCrtBdiCisHsList = pyCisReport.getPyPcrCrsCrtBdiCisHsList();
						if (pyPcrCrsCrtBdiCisHsList != null && pyPcrCrsCrtBdiCisHsList.size() > 0) {
							for (PyPcrCrsCrtBdiCisHs pyPcrCrsCrtBdiCisHs : pyPcrCrsCrtBdiCisHsList) {
								pyPcrCrsCrtBdiCisHsMapper.savePyPcrCrsCrtBdiCisHs(pyPcrCrsCrtBdiCisHs);
							}
						}
						// 鹏元个人信用报告银行信用信息信用卡最近12个月的月透支余额表
						List<PyPcrCrsCrtBdiCisO12m> pyPcrCrsCrtBdiCisO12mList = pyCisReport
								.getPyPcrCrsCrtBdiCisO12mList();
						if (pyPcrCrsCrtBdiCisO12mList != null && pyPcrCrsCrtBdiCisO12mList.size() > 0) {
							for (PyPcrCrsCrtBdiCisO12m pyPcrCrsCrtBdiCisO12m : pyPcrCrsCrtBdiCisO12mList) {
								pyPcrCrsCrtBdiCisO12mMapper.savePyPcrCrsCrtBdiCisO12m(pyPcrCrsCrtBdiCisO12m);
							}
						}
						// 鹏元个人信用报告银行信用信息信用卡最近12个月的月消费金额表
						List<PyPcrCrsCrtBdiCisPp12m> pyPcrCrsCrtBdiCisPp12mList = pyCisReport
								.getPyPcrCrsCrtBdiCisPp12mList();
						if (pyPcrCrsCrtBdiCisPp12mList != null && pyPcrCrsCrtBdiCisPp12mList.size() > 0) {
							for (PyPcrCrsCrtBdiCisPp12m pyPcrCrsCrtBdiCisPp12m : pyPcrCrsCrtBdiCisPp12mList) {
								pyPcrCrsCrtBdiCisPp12mMapper.savePyPcrCrsCrtBdiCisPp12m(pyPcrCrsCrtBdiCisPp12m);
							}
						}
						// 鹏元个人信用报告银行信用信息信用卡最近12个月的月消费次数表
						List<PyPcrCrsCrtBdiCisPt12m> pyPcrCrsCrtBdiCisPt12mList = pyCisReport
								.getPyPcrCrsCrtBdiCisPt12mList();
						if (pyPcrCrsCrtBdiCisPt12mList != null && pyPcrCrsCrtBdiCisPt12mList.size() > 0) {
							for (PyPcrCrsCrtBdiCisPt12m pyPcrCrsCrtBdiCisPt12m : pyPcrCrsCrtBdiCisPt12mList) {
								PyPcrCrsCrtBdiCisPt12mMapper.savePyPcrCrsCrtBdiCisPt12m(pyPcrCrsCrtBdiCisPt12m);
							}
						}
						// 鹏元个人信用报告银行信用信息信用卡最近12个月的月取现金额表
						List<PyPcrCrsCrtBdiCisWa12m> pyPcrCrsCrtBdiCisWa12mList = pyCisReport
								.getPyPcrCrsCrtBdiCisWa12mList();
						if (pyPcrCrsCrtBdiCisWa12mList != null && pyPcrCrsCrtBdiCisWa12mList.size() > 0) {
							for (PyPcrCrsCrtBdiCisWa12m pyPcrCrsCrtBdiCisWa12m : pyPcrCrsCrtBdiCisWa12mList) {
								pyPcrCrsCrtBdiCisWa12mMapper.savePyPcrCrsCrtBdiCisWa12m(pyPcrCrsCrtBdiCisWa12m);
							}
						}
						// 鹏元个人信用报告银行信用信息信用卡最近12个月的月取现次数表
						List<PyPcrCrsCrtBdiCisWt12m> pyPcrCrsCrtBdiCisWt12mList = pyCisReport
								.getPyPcrCrsCrtBdiCisWt12mList();
						if (pyPcrCrsCrtBdiCisWt12mList != null && pyPcrCrsCrtBdiCisWt12mList.size() > 0) {
							for (PyPcrCrsCrtBdiCisWt12m pyPcrCrsCrtBdiCisWt12m : pyPcrCrsCrtBdiCisWt12mList) {
								pyPcrCrsCrtBdiCisWt12mMapper.savePyPcrCrsCrtBdiCisWt12m(pyPcrCrsCrtBdiCisWt12m);
							}
						}
						// 鹏元个人信用报告贷款信息共同贷款人信息表
						List<PyPcrCrsCrtBdiLisBs> pyPcrCrsCrtBdiLisBsList = pyCisReport.getPyPcrCrsCrtBdiLisBsList();
						if (pyPcrCrsCrtBdiLisBsList != null && pyPcrCrsCrtBdiLisBsList.size() > 0) {
							for (PyPcrCrsCrtBdiLisBs pyPcrCrsCrtBdiLisBs : pyPcrCrsCrtBdiLisBsList) {
								pyPcrCrsCrtBdiLisBsMapper.savePyPcrCrsCrtBdiLisBs(pyPcrCrsCrtBdiLisBs);
							}
						}
						// 鹏元个人信用报告贷款信息账户基本信息表
						List<PyPcrCrsCrtBdiLisAbi> pyPcrCrsCrtBdiLisAbiList = pyCisReport.getPyPcrCrsCrtBdiLisAbiList();
						if (pyPcrCrsCrtBdiLisAbiList != null && pyPcrCrsCrtBdiLisAbiList.size() > 0) {
							for (PyPcrCrsCrtBdiLisAbi pyPcrCrsCrtBdiLisAbi : pyPcrCrsCrtBdiLisAbiList) {
								pyPcrCrsCrtBdiLisAbiMapper.savePyPcrCrsCrtBdiLisAbi(pyPcrCrsCrtBdiLisAbi);
							}
						}
						// 鹏元个人信用报告贷款信息账户动态信息表
						List<PyPcrCrsCrtBdiLisAci> pyPcrCrsCrtBdiLisAciList = pyCisReport.getPyPcrCrsCrtBdiLisAciList();
						if (pyPcrCrsCrtBdiLisAciList != null && pyPcrCrsCrtBdiLisAciList.size() > 0) {
							for (PyPcrCrsCrtBdiLisAci pyPcrCrsCrtBdiLisAci : pyPcrCrsCrtBdiLisAciList) {
								pyPcrCrsCrtBdiLisAciMapper.savePyPcrCrsCrtBdiLisAci(pyPcrCrsCrtBdiLisAci);
							}
						}
						// 鹏元个人信用报告贷款信息最近24月还款情况表
						List<PyPcrCrsCrtBdiLisPl24m> pyPcrCrsCrtBdiLisPl24mList = pyCisReport
								.getPyPcrCrsCrtBdiLisPl24mList();
						if (pyPcrCrsCrtBdiLisPl24mList != null && pyPcrCrsCrtBdiLisPl24mList.size() > 0) {
							for (PyPcrCrsCrtBdiLisPl24m pyPcrCrsCrtBdiLisPl24m : pyPcrCrsCrtBdiLisPl24mList) {
								pyPcrCrsCrtBdiLisPl24mMapper.savePyPcrCrsCrtBdiLisPl24m(pyPcrCrsCrtBdiLisPl24m);
							}
						}
						// 鹏元个人信用报告贷款信息贷款账户状态变动记录表
						List<PyPcrCrsCrtBdiLisHs> pyPcrCrsCrtBdiLisHsList = pyCisReport.getPyPcrCrsCrtBdiLisHsList();
						if (pyPcrCrsCrtBdiLisHsList != null && pyPcrCrsCrtBdiLisHsList.size() > 0) {
							for (PyPcrCrsCrtBdiLisHs pyPcrCrsCrtBdiLisHs : pyPcrCrsCrtBdiLisHsList) {
								pyPcrCrsCrtBdiLisHsMapper.savePyPcrCrsCrtBdiLisHs(pyPcrCrsCrtBdiLisHs);
							}
						}
						// 鹏元个人信用报告银行概要信息表
						PyCrsCrtBsi pyCrsCrtBsi = pyCisReport.getPyCrsCrtBsi();
						if (pyCrsCrtBsi != null) {
							pyCrsCrtBsiMapper.savePyCrsCrtBsi(pyCrsCrtBsi);
						}
						// 鹏元个人信用报告个人社会保险信息表
						PyPcrCrsCrtSisz2 pyPcrCrsCrtSisz2 = pyCisReport.getPyPcrCrsCrtSisz2();
						if (pyPcrCrsCrtSisz2 != null) {
							pyPcrCrsCrtSisz2Mapper.savePyPcrCrsCrtSisz2(pyPcrCrsCrtSisz2);
						}
						// 鹏元个人信用报告个人社会保险个人基本信息表
						PyPcrCrsCrtSisz2Bi pyPcrCrsCrtSisz2Bi = pyCisReport.getPyPcrCrsCrtSisz2Bi();
						if (pyPcrCrsCrtSisz2Bi != null) {
							pyPcrCrsCrtSisz2BiMapper.savePyPcrCrsCrtSisz2Bi(pyPcrCrsCrtSisz2Bi);
						}
						// 鹏元个人信用报告个人社会保险兼职单位信息
						List<PyPcrCrsCrtSisz2Pui> pyPcrCrsCrtSisz2PuiList = pyCisReport.getPyPcrCrsCrtSisz2PuiList();
						if (pyPcrCrsCrtSisz2PuiList != null && pyPcrCrsCrtSisz2PuiList.size() > 0) {
							for (PyPcrCrsCrtSisz2Pui pyPcrCrsCrtSisz2Pui : pyPcrCrsCrtSisz2PuiList) {
								pyPcrCrsCrtSisz2PuiMapper.savePyPcrCrsCrtSisz2Pui(pyPcrCrsCrtSisz2Pui);
							}
						}
						// 鹏元个人信用报告个人社会保险近5年内参保历史信息表
						List<PyPcrCrsCrtSisz2Hi5y> pyPcrCrsCrtSisz2Hi5yList = pyCisReport.getPyPcrCrsCrtSisz2Hi5yList();
						if (pyPcrCrsCrtSisz2Hi5yList != null && pyPcrCrsCrtSisz2Hi5yList.size() > 0) {
							for (PyPcrCrsCrtSisz2Hi5y pyPcrCrsCrtSisz2Hi5y : pyPcrCrsCrtSisz2Hi5yList) {
								pyPcrCrsCrtSisz2Hi5yMapper.savePyPcrCrsCrtSisz2Hi5y(pyPcrCrsCrtSisz2Hi5y);
							}
						}
						// 鹏元个人信用报告个人社会保险近5年内参保信息汇总表
						PyPcrCrsCrtSisz2Si5y pyPcrCrsCrtSisz2Si5y = pyCisReport.getPyPcrCrsCrtSisz2Si5y();
						if (pyPcrCrsCrtSisz2Si5y != null) {
							pyPcrCrsCrtSisz2Si5yMapper.savePyPcrCrsCrtSisz2Si5y(pyPcrCrsCrtSisz2Si5y);
						}
						// 鹏元个人信用报告特别信息表
						PyPcrCrsCrtSi pyPcrCrsCrtSi = pyCisReport.getPyPcrCrsCrtSi();
						if (pyPcrCrsCrtSi != null) {
							pyPcrCrsCrtSiMapper.savePyPcrCrsCrtSi(pyPcrCrsCrtSi);
						}
						// 鹏元个人信用报告特别信息内容表
						List<PyPcrCrsCrtSiItm> pyPcrCrsCrtSiItmList = pyCisReport.getPyPcrCrsCrtSiItmList();
						if (pyPcrCrsCrtSiItmList != null && pyPcrCrsCrtSiItmList.size() > 0) {
							for (PyPcrCrsCrtSiItm pyPcrCrsCrtSiItm : pyPcrCrsCrtSiItmList) {
								PyPcrCrsCrtSiItmMapper.savePyPcrCrsCrtSiItm(pyPcrCrsCrtSiItm);
							}
						}
						// 鹏元个人信用报告身份证号码校验信息表
						PyPcrCrsCrtIvi pyPcrCrsCrtIvi = pyCisReport.getPyPcrCrsCrtIvi();
						if (pyPcrCrsCrtIvi != null) {
							pyPcrCrsCrtIviMapper.savePyPcrCrsCrtIvi(pyPcrCrsCrtIvi);
						}
						// 鹏元个人信用报告身份证号码校验信息内容表
						PyPcrCrsCrtIviItm pyPcrCrsCrtIviItm = pyCisReport.getPyPcrCrsCrtIviItm();
						if (pyPcrCrsCrtIviItm != null) {
							pyPcrCrsCrtIviItmMapper.savePyPcrCrsCrtIviItm(pyPcrCrsCrtIviItm);
						}
						// 鹏元个人信用报告深圳基本摘要信息表
						PyPcrCrsCrtSzbsi pyPcrCrsCrtSzbsi = pyCisReport.getPyPcrCrsCrtSzbsi();
						if (pyPcrCrsCrtSzbsi != null) {
							pyPcrCrsCrtSzbsiMapper.savePyPcrCrsCrtSzbsi(pyPcrCrsCrtSzbsi);
						}
						// 鹏元个人信用报告深圳基本摘要信息表
						PyPcrCrsCrtSzbsiBss pyPcrCrsCrtSzbsiBss = pyCisReport.getPyPcrCrsCrtSzbsiBss();
						if (pyPcrCrsCrtSzbsiBss != null) {
							pyPcrCrsCrtSzbsiBssMapper.savePyPcrCrsCrtSzbsiBss(pyPcrCrsCrtSzbsiBss);
						}
						// 鹏元个人信用报告深圳基本摘要信息银行信息表
						PyPcrCrsCrtSzbsiBks pyPcrCrsCrtSzbsiBks = pyCisReport.getPyPcrCrsCrtSzbsiBks();
						if (pyPcrCrsCrtSzbsiBks != null) {
							pyPcrCrsCrtSzbsiBksMapper.savePyPcrCrsCrtSzbsiBks(pyPcrCrsCrtSzbsiBks);
						}
						// 鹏元个人信用报告深圳基本摘要信息社保信息表
						PyPcrCrsCrtSzbsiIs pyPcrCrsCrtSzbsiIs = pyCisReport.getPyPcrCrsCrtSzbsiIs();
						if (pyPcrCrsCrtSzbsiIs != null) {
							pyPcrCrsCrtSzbsiIsMapper.savePyPcrCrsCrtSzbsiIs(pyPcrCrsCrtSzbsiIs);
						}
						// 鹏元个人信用报告深圳基本摘要信息评分信息表
						PyPcrCrsCrtSzbsiSs pyPcrCrsCrtSzbsiSs = pyCisReport.getPyPcrCrsCrtSzbsiSs();
						if (pyPcrCrsCrtSzbsiSs != null) {
							pyPcrCrsCrtSzbsiSsMapper.savePyPcrCrsCrtSzbsiSs(pyPcrCrsCrtSzbsiSs);
						}
						// 鹏元个人信用报告深圳基本摘要信息电话欠费信息表
						PyPcrCrsCrtSzbsiTs pyPcrCrsCrtSzbsiTs = pyCisReport.getPyPcrCrsCrtSzbsiTs();
						if (pyPcrCrsCrtSzbsiTs != null) {
							pyPcrCrsCrtSzbsiTsMapper.savePyPcrCrsCrtSzbsiTs(pyPcrCrsCrtSzbsiTs);
						}
						// 鹏元个人信用报告近两年历史查询明细表
						PyPcrCrsCrtHqi pyPcrCrsCrtHqi = pyCisReport.getPyPcrCrsCrtHqi();
						if (pyPcrCrsCrtHqi != null) {
							pyPcrCrsCrtHqiMapper.savePyPcrCrsCrtHqi(pyPcrCrsCrtHqi);
						}
						// 鹏元个人信用报告近两年历史查询明细内容表
						List<PyPcrCrsCrtHqiItm> pyPcrCrsCrtHqiItmList = pyCisReport.getPyPcrCrsCrtHqiItmList();
						if (pyPcrCrsCrtHqiItmList != null && pyPcrCrsCrtHqiItmList.size() > 0) {
							for (PyPcrCrsCrtHqiItm pyPcrCrsCrtHqiItm : pyPcrCrsCrtHqiItmList) {
								pyPcrCrsCrtHqiItmMapper.savePyPcrCrsCrtHqiItm(pyPcrCrsCrtHqiItm);
							}
						}
						return 1;
					} catch (Exception e) {
						logger.error("[区域数据-深圳-鹏元个人信用] 持久化解析后报文异常{}",e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
		logger.error("[区域数据-深圳-鹏元个人信用] 保存返回报文失败！ 返回报文解析对象为空");
		return 0;
	}

}
