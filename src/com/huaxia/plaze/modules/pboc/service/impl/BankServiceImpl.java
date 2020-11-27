package com.huaxia.plaze.modules.pboc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.pboc.domain.Bank;
import com.huaxia.plaze.modules.pboc.domain.BankControlTimeNum;
import com.huaxia.plaze.modules.pboc.domain.PAH;
import com.huaxia.plaze.modules.pboc.domain.PAP;
import com.huaxia.plaze.modules.pboc.domain.PBS;
import com.huaxia.plaze.modules.pboc.domain.PCA;
import com.huaxia.plaze.modules.pboc.domain.PCE;
import com.huaxia.plaze.modules.pboc.domain.PCJ;
import com.huaxia.plaze.modules.pboc.domain.PCO;
import com.huaxia.plaze.modules.pboc.domain.PCR;
import com.huaxia.plaze.modules.pboc.domain.PDA;
import com.huaxia.plaze.modules.pboc.domain.PHF;
import com.huaxia.plaze.modules.pboc.domain.PIM;
import com.huaxia.plaze.modules.pboc.domain.PMM;
import com.huaxia.plaze.modules.pboc.domain.PND;
import com.huaxia.plaze.modules.pboc.domain.PNO;
import com.huaxia.plaze.modules.pboc.domain.POM;
import com.huaxia.plaze.modules.pboc.domain.POQ;
import com.huaxia.plaze.modules.pboc.domain.POS;
import com.huaxia.plaze.modules.pboc.domain.POT;
import com.huaxia.plaze.modules.pboc.domain.PPO;
import com.huaxia.plaze.modules.pboc.domain.PPQ;
import com.huaxia.plaze.modules.pboc.domain.PQO;
import com.huaxia.plaze.modules.pboc.domain.PRH;
import com.huaxia.plaze.modules.pboc.domain.PRM;
import com.huaxia.plaze.modules.pboc.domain.PSM;
import com.huaxia.plaze.modules.pboc.domain.pah.PF08;
import com.huaxia.plaze.modules.pboc.domain.pah.PF08A;
import com.huaxia.plaze.modules.pboc.domain.pah.PF08Z;
import com.huaxia.plaze.modules.pboc.domain.pah.PF08ZH;
import com.huaxia.plaze.modules.pboc.domain.pah.PF08Zdata;
import com.huaxia.plaze.modules.pboc.domain.pap.PF04;
import com.huaxia.plaze.modules.pboc.domain.pap.PF04A;
import com.huaxia.plaze.modules.pboc.domain.pap.PF04Z;
import com.huaxia.plaze.modules.pboc.domain.pap.PF04ZH;
import com.huaxia.plaze.modules.pboc.domain.pap.PF04Zdata;
import com.huaxia.plaze.modules.pboc.domain.pbs.PF06;
import com.huaxia.plaze.modules.pboc.domain.pbs.PF06A;
import com.huaxia.plaze.modules.pboc.domain.pbs.PF06Z;
import com.huaxia.plaze.modules.pboc.domain.pbs.PF06ZH;
import com.huaxia.plaze.modules.pboc.domain.pbs.PF06Zdata;
import com.huaxia.plaze.modules.pboc.domain.pca.PD02;
import com.huaxia.plaze.modules.pboc.domain.pca.PD02A;
import com.huaxia.plaze.modules.pboc.domain.pca.PD02Z;
import com.huaxia.plaze.modules.pboc.domain.pca.PD02ZH;
import com.huaxia.plaze.modules.pboc.domain.pca.PD02Zdata;
import com.huaxia.plaze.modules.pboc.domain.pce.PF03;
import com.huaxia.plaze.modules.pboc.domain.pce.PF03A;
import com.huaxia.plaze.modules.pboc.domain.pce.PF03Z;
import com.huaxia.plaze.modules.pboc.domain.pce.PF03ZH;
import com.huaxia.plaze.modules.pboc.domain.pce.PF03Zdata;
import com.huaxia.plaze.modules.pboc.domain.pcj.PF02;
import com.huaxia.plaze.modules.pboc.domain.pcj.PF02A;
import com.huaxia.plaze.modules.pboc.domain.pcj.PF02Z;
import com.huaxia.plaze.modules.pboc.domain.pcj.PF02ZH;
import com.huaxia.plaze.modules.pboc.domain.pcj.PF02Zdata;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02A;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02AH;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02Adata;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02B;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02BH;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02Bdata;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02C;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02D;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02DH;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02Ddata;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02E;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02F;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02G;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02H;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02I;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02K;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02KH;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02Kdata;
import com.huaxia.plaze.modules.pboc.domain.pcr.PD03;
import com.huaxia.plaze.modules.pboc.domain.pcr.PD03A;
import com.huaxia.plaze.modules.pboc.domain.pcr.PD03Z;
import com.huaxia.plaze.modules.pboc.domain.pcr.PD03ZH;
import com.huaxia.plaze.modules.pboc.domain.pcr.PD03Zdata;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01A;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01B;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01C;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01D;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01DH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Ddata;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01E;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01EH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Edata;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01F;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01FH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Fdata;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01G;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01GH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Gdata;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01H;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01HH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Hdata;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Z;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01ZH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Zdata;
import com.huaxia.plaze.modules.pboc.domain.phf.PF05;
import com.huaxia.plaze.modules.pboc.domain.phf.PF05A;
import com.huaxia.plaze.modules.pboc.domain.phf.PF05Z;
import com.huaxia.plaze.modules.pboc.domain.phf.PF05ZH;
import com.huaxia.plaze.modules.pboc.domain.phf.PF05Zdata;
import com.huaxia.plaze.modules.pboc.domain.pim.PB01;
import com.huaxia.plaze.modules.pboc.domain.pim.PB01A;
import com.huaxia.plaze.modules.pboc.domain.pim.PB01B;
import com.huaxia.plaze.modules.pboc.domain.pim.PB01BH;
import com.huaxia.plaze.modules.pboc.domain.pim.PB01Bdata;
import com.huaxia.plaze.modules.pboc.domain.pmm.PB02;
import com.huaxia.plaze.modules.pboc.domain.pnd.PE01;
import com.huaxia.plaze.modules.pboc.domain.pnd.PE01A;
import com.huaxia.plaze.modules.pboc.domain.pnd.PE01Z;
import com.huaxia.plaze.modules.pboc.domain.pnd.PE01ZH;
import com.huaxia.plaze.modules.pboc.domain.pnd.PE01Zdata;
import com.huaxia.plaze.modules.pboc.domain.pno.PC03;
import com.huaxia.plaze.modules.pboc.domain.pno.PC030H;
import com.huaxia.plaze.modules.pboc.domain.pno.PC03data;
import com.huaxia.plaze.modules.pboc.domain.pom.PB04;
import com.huaxia.plaze.modules.pboc.domain.poq.PH01;
import com.huaxia.plaze.modules.pboc.domain.pos.PG01;
import com.huaxia.plaze.modules.pboc.domain.pos.PG010H;
import com.huaxia.plaze.modules.pboc.domain.pos.PG01data;
import com.huaxia.plaze.modules.pboc.domain.pot.PF01;
import com.huaxia.plaze.modules.pboc.domain.pot.PF01A;
import com.huaxia.plaze.modules.pboc.domain.pot.PF01Z;
import com.huaxia.plaze.modules.pboc.domain.pot.PF01ZH;
import com.huaxia.plaze.modules.pboc.domain.pot.PF01Zdata;
import com.huaxia.plaze.modules.pboc.domain.ppo.PC04;
import com.huaxia.plaze.modules.pboc.domain.ppo.PC040H;
import com.huaxia.plaze.modules.pboc.domain.ppo.PC04data;
import com.huaxia.plaze.modules.pboc.domain.ppq.PF07;
import com.huaxia.plaze.modules.pboc.domain.ppq.PF07A;
import com.huaxia.plaze.modules.pboc.domain.ppq.PF07Z;
import com.huaxia.plaze.modules.pboc.domain.ppq.PF07ZH;
import com.huaxia.plaze.modules.pboc.domain.ppq.PF07Zdata;
import com.huaxia.plaze.modules.pboc.domain.pqo.PC05;
import com.huaxia.plaze.modules.pboc.domain.pqo.PC05A;
import com.huaxia.plaze.modules.pboc.domain.pqo.PC05B;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01A;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01B;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01C;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01CH;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01Cdata;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01D;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01E;
import com.huaxia.plaze.modules.pboc.domain.prm.PB03;
import com.huaxia.plaze.modules.pboc.domain.psm.PC01;
import com.huaxia.plaze.modules.pboc.domain.psm.PC01data;
import com.huaxia.plaze.modules.pboc.domain.psm.PC01scoreEle;
import com.huaxia.plaze.modules.pboc.mapper.BankAdministraAwardRecordMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankAdministraPunishRecordMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankCivilJudgeRecordMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankControlLogicMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankCreditLoanTransactionMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankCreditProtocolMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankDebitCreditInfoMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankForceExecuteRecordMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankHousingFundPayRecordMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankIdentityInfoMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankLowIncomeSalveRecordMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankMaritalInfoMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankNoCreditTransactionMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankOtherLabelStateMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankPostPaidServeMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankPracticeQualifyRecordMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankProfessionInfoMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankPublicInfoMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankQueryRecordMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankQueryRecordSummaryMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankRelateRepayDutyMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankReportHeaderMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankResidenceInfoMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankScoreInfoMapper;
import com.huaxia.plaze.modules.pboc.mapper.BankTaxArrearsRecordMapper;
import com.huaxia.plaze.modules.pboc.service.BankService;
import com.huaxia.plaze.util.TaskParamUtil;
import com.huaxia.plaze.util.TaskStatusUtil;

/**
 * 人行二期服务
 * 
 * @author gaoh
 *
 */
@Service("bankService")
public class BankServiceImpl implements BankService {
	@Resource
	private BankReportHeaderMapper bankReportHeaderMapper;
	@Resource
	private BankIdentityInfoMapper bankIdentityInfoMapper;
	@Resource
	private BankMaritalInfoMapper bankMaritalInfoMapper;
	@Resource
	private BankResidenceInfoMapper bankResidenceInfoMapper;
	@Resource
	private BankProfessionInfoMapper bankProfessionInfoMapper;
	@Resource
	private BankScoreInfoMapper bankScoreInfoMapper;
	@Resource
	private BankCreditLoanTransactionMapper bankCreditLoanTransactionMapper;
	@Resource
	private BankNoCreditTransactionMapper bankNoCreditTransactionMapper;
	@Resource
	private BankPublicInfoMapper bankPublicInfoMapper;
	@Resource
	private BankQueryRecordSummaryMapper bankQueryRecordSummaryMapper;
	@Resource
	private BankDebitCreditInfoMapper bankDebitCreditInfoMapper;
	@Resource
	private BankCreditProtocolMapper bankCreditProtocolMapper;
	@Resource
	private BankRelateRepayDutyMapper bankRelateRepayDutyMapper;
	@Resource
	private BankPostPaidServeMapper bankPostPaidServeMapper;
	@Resource
	private BankTaxArrearsRecordMapper bankTaxArrearsRecordMapper;
	@Resource
	private BankCivilJudgeRecordMapper bankCivilJudgeRecordMapper;
	@Resource
	private BankForceExecuteRecordMapper bankForceExecuteRecordMapper;
	@Resource
	private BankAdministraPunishRecordMapper bankAdministraPunishRecordMapper;
	@Resource
	private BankHousingFundPayRecordMapper bankHousingFundPayRecordMapper;
	@Resource
	private BankLowIncomeSalveRecordMapper bankLowIncomeSalveRecordMapper;
	@Resource
	private BankPracticeQualifyRecordMapper bankPracticeQualifyRecordMapper;
	@Resource
	private BankAdministraAwardRecordMapper bankAdministraAwardRecordMapper;
	@Resource
	private BankOtherLabelStateMapper bankOtherLabelStateMapper;
	@Resource
	private BankQueryRecordMapper bankQueryRecordMapper;
	@Resource
	private BankControlLogicMapper bankControlLogicMapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveBankReportMessage(Bank bank) {
		// 1.1 报告头 PRH [1..1]
		PRH prh = bank.getPRH();
		if (prh != null) {
			// 1.1.1 报告头信息单元 PA01 [1..1]
			PA01 pa01 = prh.getPA01();
			if (pa01 != null) {
				// 1.1.1.1 报告标识信息段 PA01A [1..1]
				PA01A pa01a = pa01.getPA01A();
				if (pa01a != null) {
					bankReportHeaderMapper.insertReportMarkInfo(pa01a);
				}
				// 1.1.1.2本次查询请求信息段 PA01B [1..1]
				PA01B pa01b = pa01.getPA01B();
				if (pa01b != null) {
					bankReportHeaderMapper.insertCurQueryRequest(pa01b);
				}
				// 1.1.1.3 其他身份标识信息段 PA01C [0..1]
				PA01C pa01c = pa01.getPA01C();
				if (pa01c != null) {
					// 其他身份标识信息段数据
					PA01Cdata pa01cData = pa01c.getPA01Cdata();
					if (pa01cData != null) {
						bankReportHeaderMapper.insertOtherIdentityMark(pa01cData);
					}
					// 1.1.1.3.2 身份信息 PA01CH [0..99]
					List<PA01CH> pa01chList = pa01c.getPA01CHList();
					if (pa01chList != null && pa01chList.size() > 0) {
						bankReportHeaderMapper.insertIdentityDataList(pa01chList);
					}
				}
				// 1.1.1.4 防欺诈警示信息段 PA01D [1..1]
				PA01D pa01d = pa01.getPA01D();
				if (pa01d != null) {
					bankReportHeaderMapper.insertCheatProofCaution(pa01d);
				}
				// 1.1.1.5 异议提示信息段 PA01E [1..1]
				PA01E pa01e = pa01.getPA01E();
				if (pa01e != null) {
					bankReportHeaderMapper.insertDissentHint(pa01e);
				}

			}

		}
		// 1.2 身份信息 PIM [1..1]
		PIM pim = bank.getPIM();
		if (pim != null) {
			// 1.2.1 身份信息单元 PB01 [0..1]
			PB01 pb01 = pim.getPB01();
			if (pb01 != null) {
				// 1.2.1.1 基本概况信息段 PB01A [0..1]
				PB01A pb01a = pb01.getPB01A();
				if (pb01a != null) {
					bankIdentityInfoMapper.insertIdentityProfile(pb01a);
				}
				// 1.2.2 手机号码信息段 PB01B [0..1]
				PB01B pb01b = pb01.getPB01B();
				if (pb01b != null) {
					// 手机号码信息段数据
					PB01Bdata pb01bData = pb01b.getPB01Bdata();
					if (pb01bData != null) {
						bankIdentityInfoMapper.insertPhoneNumberData(pb01bData);
					}
					// 1.2.2.2手机号码信息 PB01BH [1..5]
					List<PB01BH> pb01bhList = pb01b.getPB01BHList();
					if (pb01bhList != null && pb01bhList.size() > 0) {
						bankIdentityInfoMapper.insertPhoneNumberDetailList(pb01bhList);
					}
				}
			}
		}
		// 1.3 婚姻信息 PMM [1..1]
		PMM pmm = bank.getPMM();
		if (pmm != null) {
			// 1.3.1 婚姻信息单元 PB02 [0..1]
			PB02 pb02 = pmm.getPB02();
			if (pb02 != null) {
				bankMaritalInfoMapper.insertMaritalInfo(pb02);
			}
		}
		// 1.4 居住信息 PRM [1..1]
		PRM prm = bank.getPRM();
		if (prm != null) {
			// 1.4.1 居住信息单元 PB03 [0..5]
			List<PB03> pb03List = prm.getPB03List();
			if (pb03List != null && pb03List.size() > 0) {
				bankResidenceInfoMapper.insertResidenceInfoList(pb03List);
			}
		}
		// 1.5 职业信息 POM [1..1]
		POM pom = bank.getPOM();
		if (pom != null) {
			// 1.5.1 职业信息单元 PB04 [0..5]
			List<PB04> pb04List = pom.getPB04List();
			if (pb04List != null && pb04List.size() > 0) {
				bankProfessionInfoMapper.insertProfessionInfoList(pb04List);
			}
		}
		// 1.6 评分信息 PSM [1..1]
		PSM psm = bank.getPSM();
		if (psm != null) {
			// 1.6.1 评分信息单元 PC01 [1..1]
			PC01 pc01 = psm.getPC01();
			if (pc01 != null) {
				// 评分信息单元数据
				PC01data pc01Data = pc01.getPC01data();
				if (pc01Data != null) {
					bankScoreInfoMapper.insertScoreInfo(pc01Data);
				}
				// 1.6.1.4 分数说明 PC010D01 -- [1..2]
				List<PC01scoreEle> scoreEleList = pc01.getPC01scoreEleList();
				if (scoreEleList != null && scoreEleList.size() > 0) {
					bankScoreInfoMapper.insertScoreEleList(scoreEleList);
				}
			}
		}
		// 1.7 信贷交易信息概要 PCO [1..1]
		PCO pco = bank.getPCO();
		if (pco != null) {
			// 1.7.1 信贷交易信息概要信息单元 PC02 [0..1]
			PC02 pc02 = pco.getPC02();
			if (pc02 != null) {
				// 1.7.1.1 信贷交易提示信息段 PC02A [0..1]
				PC02A pc02a = pc02.getPC02A();
				if (pc02a != null) {
					// 信贷交易提示信息段数据
					PC02Adata pc02aData = pc02a.getPC02Adata();
					if (pc02aData != null) {
						bankCreditLoanTransactionMapper.insertCreditTransactionData(pc02aData);
					}
					// 1.7.1.1.3 信贷交易提示信息 PC02AH [1..6]
					List<PC02AH> pc02ahList = pc02a.getPC02AHList();
					if (pc02ahList != null && pc02ahList.size() > 0) {
						bankCreditLoanTransactionMapper.insertCreditTransactionDetailList(pc02ahList);
					}
				}
				// 1.7.1.2 被追偿汇总信息段 PC02B [0..1]
				PC02B pc02b = pc02.getPC02B();
				if (pc02b != null) {
					// 被追偿汇总信息段数据
					PC02Bdata pc02bData = pc02b.getPC02Bdata();
					if (pc02bData != null) {
						bankCreditLoanTransactionMapper.insertBeRecoveriedSumData(pc02bData);
					}
					// 1.7.1.2.4 被追偿汇总信息 PC02BH [1..2]
					List<PC02BH> pc02bhList = pc02b.getPC02BHList();
					if (pc02bhList != null && pc02bhList.size() > 0) {
						bankCreditLoanTransactionMapper.insertBeRecoveriedSumDelList(pc02bhList);
					}
				}
				// 1.7.1.3 呆账汇总信息段 PC02C [0..1]
				PC02C pc02c = pc02.getPC02C();
				if (pc02c != null) {
					bankCreditLoanTransactionMapper.insertBadDebtsSum(pc02c);
				}
				// 1.7.1.4 逾期（透支）汇总信息段 PC02D [0..1]
				PC02D pc02d = pc02.getPC02D();
				if (pc02d != null) {
					// 逾期（透支）汇总信息段数据
					PC02Ddata pc02dData = pc02d.getPC02Ddata();
					if (pc02dData != null) {
						bankCreditLoanTransactionMapper.insertOverdueDraftSum(pc02dData);
					}
					// 1.7.1.4.2 逾期（透支）汇总信息 PC02DH [1..6]
					List<PC02DH> pc02dList = pc02d.getPC02DHList();
					if (pc02dList != null && pc02dList.size() > 0) {
						bankCreditLoanTransactionMapper.insertOverdueDraftSumDelList(pc02dList);
					}
				}
				// 1.7.1.5 非循环贷账户汇总信息段 PC02E [0..1]
				PC02E pc02e = pc02.getPC02E();
				if (pc02e != null) {
					bankCreditLoanTransactionMapper.insertNoRevolveLoanAccoSum(pc02e);
				}
				// 1.7.1.6 循环额度下分账户汇总信息段 PC02F [0..1]
				PC02F pc02f = pc02.getPC02F();
				if (pc02f != null) {
					bankCreditLoanTransactionMapper.insertRevolveLimSubAccoSum(pc02f);
				}
				// 1.7.1.7 循环贷账户汇总信息段 PC02G [0..1]
				PC02G pc02g = pc02.getPC02G();
				if (pc02g != null) {
					bankCreditLoanTransactionMapper.insertRevolveLoanAccoSum(pc02g);
				}
				// 1.7.1.8 贷记卡账户汇总信息段 PC02H [0..1]
				PC02H pc02h = pc02.getPC02H();
				if (pc02h != null) {
					bankCreditLoanTransactionMapper.insertCreditCardAccoSum(pc02h);
				}
				// 1.7.1.9 准贷记卡账户汇总信息段 PC02I [0..1]
				PC02I pc02i = pc02.getPC02I();
				if (pc02i != null) {
					bankCreditLoanTransactionMapper.insertSemiCreditCardAccoSum(pc02i);
				}
				// 1.7.1.10 相关还款责任汇总信息段 PC02K
				PC02K pc02k = pc02.getPC02K();
				if (pc02k != null) {
					// 相关还款责任汇总信息段数据
					PC02Kdata pc02kData = pc02k.getPC02Kdata();
					if (pc02kData != null) {
						bankCreditLoanTransactionMapper.insertRelatedRepayDutySum(pc02kData);
					}
					// 1.7.1.10.2 相关还款责任汇总信息 PC02KH [1..4]
					List<PC02KH> pc02khList = pc02k.getPC02KHList();
					if (pc02khList != null && pc02khList.size() > 0) {
						bankCreditLoanTransactionMapper.insertRelatedRepayDutySumDelList(pc02khList);
					}
				}
			}
		}
		// 1.8 非信贷交易信息概要 PNO [1..1]
		PNO pno = bank.getPNO();
		if (pno != null) {
			// 1.8.1 后付费业务欠费信息汇总信息单元 PC03 [0..1]
			PC03 pc03 = pno.getPC03();
			if (pc03 != null) {
				// 后付费业务欠费信息汇总信息单元数据
				PC03data pc03Data = pc03.getPC03data();
				if (pc03Data != null) {
					bankNoCreditTransactionMapper.insertPostPayArreagageAum(pc03Data);
				}
				// 后付费业务欠信息汇总信息 PC030H
				PC030H pc03h = pc03.getPC030H();
				if (pc03h != null) {
					bankNoCreditTransactionMapper.insertPostPayArreagageAumDel(pc03h);
				}
			}
		}
		// 1.9 公共信息概要 PPO [1..1]
		PPO ppo = bank.getPPO();
		if (ppo != null) {
			// 1.9.1 公共信息概要信息单元 PC04 [0..1]
			PC04 pc04 = ppo.getPC04();
			if (pc04 != null) {
				// 公共信息概要信息数据
				PC04data pc04Data = pc04.getPC04data();
				if (pc04Data != null) {
					bankPublicInfoMapper.insertPublicInfoData(pc04Data);
				}
				// 1.9.1.2 公共信息概要信息 PC040H [1..4]
				List<PC040H> pc040hList = pc04.getPC040HList();
				if (pc040hList != null && pc040hList.size() > 0) {
					bankPublicInfoMapper.insertPublicInfoDelList(pc040hList);
				}
			}
		}
		// 1.10 查询记录概要 PQO [1..1]
		PQO pqo = bank.getPQO();
		if (pqo != null) {
			// 1.10.1 查询记录概要信息单元 PC05 [1..1]
			PC05 pc05 = pqo.getPC05();
			if (pc05 != null) {
				// 1.10.1.1 上一次查询记录信息段 PC05A [0..1]
				PC05A pc05a = pc05.getPC05A();
				if (pc05a != null) {
					bankQueryRecordSummaryMapper.insertLastQueryRecord(pc05a);
				}
				// 1.10.1.2 查询记录汇总信息段 PC05B [1..1]
				PC05B pc05b = pc05.getPC05B();
				if (pc05b != null) {
					bankQueryRecordSummaryMapper.insertQueryRecordSum(pc05b);
				}
			}
		}
		// 1.11 借贷账户信息 PDA [1..1]
		PDA pda = bank.getPDA();
		if (pda != null) {
			// 1.11.1 借贷账户信息单元 PD01 [0..*]
			List<PD01> pd01List = pda.getPD01List();
			if (pd01List != null && pd01List.size() > 0) {
				for (int i = 0; i < pd01List.size(); i++) {
					PD01 pd01 = pd01List.get(i);
					if (pd01 != null) {
						// 1.11.1.1 基本信息段 PD01A [1..1]
						PD01A pd01a = pd01.getPD01A();
						if (pd01a != null) {
							bankDebitCreditInfoMapper.insertDebitCreditBasicInfo(pd01a);
						}
						// 1.11.1.2 最新表现信息段 PD01B [1..1]
						PD01B pd01b = pd01.getPD01B();
						if (pd01b != null) {
							bankDebitCreditInfoMapper.insertDebitCreditNewstShow(pd01b);
						}
						// 1.11.1.3 最近一次月度表现信息段 PD01C [0..1]
						PD01C pd01c = pd01.getPD01C();
						if (pd01c != null) {
							bankDebitCreditInfoMapper.insertDebitCreditNearestMonth(pd01c);
						}
						// 1.11.1.4 最近24个月还款记录信息段 PD01D [0..1]
						PD01D pd01d = pd01.getPD01D();
						if (pd01d != null) {
							PD01Ddata pd01dData = pd01d.getPD01Ddata();
							if (pd01dData != null) {
								bankDebitCreditInfoMapper.insertDebitCreditNearest24MonthRepayRecord(pd01dData);
							}
							// 1.11.1.4.3 还款状态信息 PD01DH
							List<PD01DH> pd01dhList = pd01d.getPD01DHList();
							if (pd01dhList != null && pd01dhList.size() > 0) {
								bankDebitCreditInfoMapper.insertDebitCreditRepayStatusInfoList(pd01dhList);
							}
						}
						// 1.11.1.5 最近5年内历史表现信息段 PD01E [0..1]
						PD01E pd01e = pd01.getPD01E();
						if (pd01e != null) {
							PD01Edata pd01eData = pd01e.getPD01Edata();
							if (pd01eData != null) {
								bankDebitCreditInfoMapper.insertDebitCreditNearest5YearHistory(pd01eData);
							}
							// 1.11.1.5.4 历史表现信息 PD01EH [1..60]
							List<PD01EH> pd01ehList = pd01e.getPD01EHList();
							if (pd01ehList != null && pd01ehList.size() > 0) {
								bankDebitCreditInfoMapper.insertDebitCreditNearest5YearHisExpressList(pd01ehList);
							}
						}
						// 1.11.1.6 特殊交易信息段 PD01F [0..1]
						PD01F pd01f = pd01.getPD01F();
						if (pd01f != null) {
							PD01Fdata pd01fData = pd01f.getPD01Fdata();
							if (pd01fData != null) {
								bankDebitCreditInfoMapper.insertDebitCreditSpecialTransaction(pd01fData);
							}
							// 1.11.1.6.2 特殊交易信息 PD01FH [1..99]
							List<PD01FH> pd01fhList = pd01f.getPD01FHList();
							if (pd01fhList != null && pd01fhList.size() > 0) {
								bankDebitCreditInfoMapper.insertDebitCreditSpecialTradeList(pd01fhList);
							}
						}
						// 1.11.1.7 特殊事件说明信息段 PD01G [0..1]
						PD01G pd01g = pd01.getPD01G();
						if (pd01g != null) {
							PD01Gdata pd01gData = pd01g.getPD01Gdata();
							if (pd01gData != null) {
								bankDebitCreditInfoMapper.insertDebitCreditSpecialEventExpress(pd01gData);
							}
							// 1.11.1.7.2 特殊事件说明信息 PD01GH [1..99]
							List<PD01GH> pd01ghList = pd01g.getPD01GHList();
							if (pd01ghList != null && pd01ghList.size() > 0) {
								bankDebitCreditInfoMapper.insertDebitCreditSpecialEventExpressInfoList(pd01ghList);
							}
						}
						// 1.11.1.8 大额专项分期信息段 PD01H [0..1]
						PD01H pd01h = pd01.getPD01H();
						if (pd01h != null) {
							PD01Hdata pd01hData = pd01h.getPD01Hdata();
							if (pd01hData != null) {
								bankDebitCreditInfoMapper.insertDebitCreditDezxFq(pd01hData);
							}
							// 1.11.1.8.2 大额专项分期信息 PD01HH [1..99]
							List<PD01HH> pd01hhList = pd01h.getPD01HHList();
							if (pd01hhList != null && pd01hhList.size() > 0) {
								bankDebitCreditInfoMapper.insertDebitCreditDezxFqInfoList(pd01hhList);
							}
						}
						// 1.11.1.9 标注及声明信息段 PD01Z [0..1]
						PD01Z pd01z = pd01.getPD01Z();
						if (pd01z != null) {
							PD01Zdata pd01zData = pd01z.getPD01Zdata();
							if (pd01zData != null) {
								bankDebitCreditInfoMapper.insertDebitCreditPdaLabelState(pd01zData);
							}
							// 1.11.1.9.2 标注及声明信息 PD01ZH [1..5]
							List<PD01ZH> pd01zhList = pd01z.getPD01ZHList();
							if (pd01zhList != null && pd01zhList.size() > 0) {
								bankDebitCreditInfoMapper.insertDebitCreditPdaLabelStateInfoList(pd01zhList);
							}
						}
					}
				}
			}
		}
		// 1.12 授信协议信息 PCA [1..1]
		PCA pca = bank.getPCA();
		if (pca != null) {
			// 1.12.1 授信协议信息单元 PD02 [0..*]
			List<PD02> pd02List = pca.getPD02List();
			if (pd02List != null && pd02List.size() > 0) {
				for (int i = 0; i < pd02List.size(); i++) {
					PD02 pd02 = pd02List.get(i);
					if (pd02 != null) {
						// 1.12.1.1 基本信息段 PD02A [1..1]
						PD02A pd02a = pd02.getPD02A();
						if (pd02a != null) {
							bankCreditProtocolMapper.insertCreditProtocolBasicInfo(pd02a);
						}
						// 1.12.1.2 标注及声明信息段 PD02Z [0..1]
						PD02Z pd02z = pd02.getPD02Z();
						if (pd02z != null) {
							PD02Zdata pd02zData = pd02z.getPD02Zdata();
							if (pd02zData != null) {
								bankCreditProtocolMapper.insertCreditProtocolPcaLabelState(pd02zData);
							}
							// 1.12.1.2.2 标注及声明信息 PD02ZH [1..5]
							List<PD02ZH> pd02zhList = pd02z.getPD02ZHList();
							if (pd02zhList != null && pd02zhList.size() > 0) {
								bankCreditProtocolMapper.insertCreditProtocolPcaLabelStateInfoList(pd02zhList);
							}
						}
					}
				}
			}
		}
		// 1.13 相关还款责任信息 PCR [1..1]
		PCR pcr = bank.getPCR();
		if (pcr != null) {
			// 1.13.1 相关还款责任信息单元 PD03 [0..*]
			List<PD03> pd03List = pcr.getPD03List();
			if (pd03List != null && pd03List.size() > 0) {
				for (int i = 0; i < pd03List.size(); i++) {
					PD03 pd03 = pd03List.get(i);
					if (pd03 != null) {
						// 1.13.1.1 相关还款责任信息段 PD03A [1..1]
						PD03A pd03a = pd03.getPD03A();
						if (pd03a != null) {
							bankRelateRepayDutyMapper.insertRelateRepayDutyInfo(pd03a);
						}
						PD03Z pd03z = pd03.getPD03Z();
						if (pd03z != null) {
							PD03Zdata pd03zData = pd03z.getPD03Zdata();
							if (pd03zData != null) {
								bankRelateRepayDutyMapper.insertRelateRepayDutyPcrLabelState(pd03zData);
							}
							// 1.13.1.2.2 标注及声明信息 PD03ZH [1.. 5]
							List<PD03ZH> pd03zhList = pd03z.getPD03ZHList();
							if (pd03zhList != null && pd03zhList.size() > 0) {
								bankRelateRepayDutyMapper.insertRelateRepayDutyPcrLabelStateInfoList(pd03zhList);
							}
						}
					}
				}
			}
		}
		// 1.14 后付费业务信息 PND [1..1]
		PND pnd = bank.getPND();
		if (pnd != null) {
			// 1.14.1 后付费业务信息单元 PE01 [0..*]
			List<PE01> pe01List = pnd.getPE01List();
			if (pe01List != null && pe01List.size() > 0) {
				for (int i = 0; i < pe01List.size(); i++) {
					PE01 pe01 = pe01List.get(i);
					if (pe01 != null) {
						// 1.14.1.1 后付费业务信息段 PE01A [1..1]
						PE01A pe01a = pe01.getPE01A();
						if (pe01a != null) {
							bankPostPaidServeMapper.insertPostPaidServeInfo(pe01a);
						}
						// 1.14.1.2 标注及声明信息段 PE01Z [0..1]
						PE01Z pe01z = pe01.getPE01Z();
						if (pe01z != null) {
							PE01Zdata pe01zData = pe01z.getPE01Zdata();
							if (pe01zData != null) {
								bankPostPaidServeMapper.insertPostPaidServePndLabelState(pe01zData);
							}
							// 1.14.1.2.2 标注及声明信息 PE01ZH [1..5]
							List<PE01ZH> pe01zhList = pe01z.getPE01ZHList();
							if (pe01zhList != null && pe01zhList.size() > 0) {
								bankPostPaidServeMapper.insertPostPaidServePndLabelStateInfoList(pe01zhList);
							}
						}
					}
				}
			}
		}
		// 1.15 欠税记录 POT [1..1]
		POT pot = bank.getPOT();
		if (pot != null) {
			// 1.15.1 欠税记录信息单元 PF01 [0..*]
			List<PF01> pf01List = pot.getPF01List();
			if (pf01List != null && pf01List.size() > 0) {
				for (int i = 0; i < pf01List.size(); i++) {
					PF01 pf01 = pf01List.get(i);
					if (pf01 != null) {
						// 1.15.1.1 欠税 记录信息段 PF01A [1..1]
						PF01A pf01a = pf01.getPF01A();
						if (pf01a != null) {
							bankTaxArrearsRecordMapper.insertTaxArrearsRecordInfo(pf01a);
						}
						// 1.15.1.2 标注及声明信息段 PF01Z [0..1]
						PF01Z pf01z = pf01.getPF01Z();
						if (pf01z != null) {
							PF01Zdata pf01zData = pf01z.getPF01Zdata();
							if (pf01zData != null) {
								bankTaxArrearsRecordMapper.insertTaxArrearsRecordPotLabelState(pf01zData);
							}
							// 1.15.1.2.2 标注及声明信息 PF01ZH [1..5]
							List<PF01ZH> pf01zhList = pf01z.getPF01ZHList();
							if (pf01zhList != null && pf01zhList.size() > 0) {
								bankTaxArrearsRecordMapper.insertTaxArrearsRecordPotLabelStateInfoList(pf01zhList);
							}
						}
					}
				}
			}
		}
		// 1.16 民事判决记录 PCJ [1..1]
		PCJ pcj = bank.getPCJ();
		if (pcj != null) {
			// 1.16.1 民事判决记录信息单元 PF02 [0..*]
			List<PF02> pf02List = pcj.getPF02List();
			if (pf02List != null && pf02List.size() > 0) {
				for (int i = 0; i < pf02List.size(); i++) {
					PF02 pf02 = pf02List.get(i);
					if (pf02 != null) {
						// 1.16.1.1 民事判决记录信息段 PF02A [1..1]
						PF02A pf02a = pf02.getPF02A();
						if (pf02a != null) {
							bankCivilJudgeRecordMapper.insertCivilJudgeRecordInfo(pf02a);
						}
						// 1.16.1.2 标注及声明信息段 PF02Z [0..1]
						PF02Z pf02z = pf02.getPF02Z();
						if (pf02z != null) {
							PF02Zdata pf02zData = pf02z.getPF02Zdata();
							if (pf02zData != null) {
								bankCivilJudgeRecordMapper.insertCivilJudgeRecordPcjLabelState(pf02zData);
							}
							// 1.16.1.2.2 标注及声明信息 PF02ZH [1..5]
							List<PF02ZH> pf02zhList = pf02z.getPF02ZHList();
							if (pf02zhList != null && pf02zhList.size() > 0) {
								bankCivilJudgeRecordMapper.insertCivilJudgeRecordPcjLabelStateInfoList(pf02zhList);
							}
						}
					}
				}
			}
		}
		// 1.17 强制执行记录 PCE [1..1]
		PCE pce = bank.getPCE();
		if (pce != null) {
			// 1.17.1 强制执行记录信息单元 PF03 [0..*]
			List<PF03> pf03List = pce.getPF03List();
			if (pf03List != null && pf03List.size() > 0) {
				for (int i = 0; i < pf03List.size(); i++) {
					PF03 pf03 = pf03List.get(i);
					if (pf03 != null) {
						// 1.17.1.1 强制执行记录信息段 PF03A [1..1]
						PF03A pf03a = pf03.getPF03A();
						if (pf03a != null) {
							bankForceExecuteRecordMapper.insertForceExecuteRecordInfo(pf03a);
						}
						// 1.17.1.2 标注及声明信息段 PF03Z [0..1]
						PF03Z pf03z = pf03.getPF03Z();
						if (pf03z != null) {
							PF03Zdata pf03zData = pf03z.getPF03Zdata();
							if (pf03zData != null) {
								bankForceExecuteRecordMapper.insertForceExecuteRecordPceLabelState(pf03zData);
							}
							// 1.17.1.2.2 标注及声明信息 PF03ZH [1..5]
							List<PF03ZH> pf03zhList = pf03z.getPF03ZHList();
							if (pf03zhList != null && pf03zhList.size() > 0) {
								bankForceExecuteRecordMapper.insertForceExecuteRecordPceLabelStateInfoList(pf03zhList);
							}
						}
					}
				}
			}
		}
		// 1.18 行政处罚记录 PAP [1..1]
		PAP pap = bank.getPAP();
		if (pap != null) {
			// 1.18.1 行政处罚记录信息单元 PF04 [0..*]
			List<PF04> pf04List = pap.getPF04List();
			if (pf04List != null && pf04List.size() > 0) {
				for (int i = 0; i < pf04List.size(); i++) {
					PF04 pf04 = pf04List.get(i);
					if (pf04 != null) {
						// 1.18.1.1 行政处罚记录信息段 PF04A [1..1]
						PF04A pf04a = pf04.getPF04A();
						if (pf04a != null) {
							bankAdministraPunishRecordMapper.insertAdministraPunishRecordInfo(pf04a);
						}
						// 1.18.1.2 标注及声明信息段 PF04Z [0..1]
						PF04Z pf04z = pf04.getPF04Z();
						if (pf04z != null) {
							PF04Zdata pf04zData = pf04z.getPF04Zdata();
							if (pf04zData != null) {
								bankAdministraPunishRecordMapper.insertAdministraPunishRecordPapLabelState(pf04zData);
							}
							// 1.18.1.2.2 标注及声明信息 PF04ZH [1..5]
							List<PF04ZH> pf04zhList = pf04z.getPF04ZHList();
							if (pf04zhList != null && pf04zhList.size() > 0) {
								bankAdministraPunishRecordMapper
										.insertAdministraPunishRecordPapLabelStateInfoList(pf04zhList);
							}
						}
					}
				}
			}
		}
		// 1.19 住房公积金参缴记录 PHF [1..1]
		PHF phf = bank.getPHF();
		if (phf != null) {
			// 1.19.1 住房公积金参缴记录信息单元 PF05 [0..*]
			List<PF05> pf05List = phf.getPF05List();
			if (pf05List != null && pf05List.size() > 0) {
				for (int i = 0; i < pf05List.size(); i++) {
					PF05 pf05 = pf05List.get(i);
					if (pf05 != null) {
						// 1.19.1.1 住房公积金参缴记录信息段 PF05A [1..1]
						PF05A pf05a = pf05.getPF05A();
						if (pf05a != null) {
							bankHousingFundPayRecordMapper.insertHousingFundPayRecordInfo(pf05a);
						}
						// 1.19.1.2 标注及声明信息段 PF05Z [0..1]
						PF05Z pf05z = pf05.getPF05Z();
						if (pf05z != null) {
							PF05Zdata pf05zData = pf05z.getPF05Zdata();
							if (pf05zData != null) {
								bankHousingFundPayRecordMapper.insertHousingFundPayRecordPfhLabelState(pf05zData);
							}
							// 1.19.1.2.1 标注及声明信息 PF05ZH [1..5]
							List<PF05ZH> pf05zhList = pf05z.getPF05ZHList();
							if (pf05zhList != null && pf05zhList.size() > 0) {
								bankHousingFundPayRecordMapper
										.insertHousingFundPayRecordPfhLabelStateInfoList(pf05zhList);
							}
						}
					}
				}
			}
		}
		// 1.20 低保救助记录 PBS [1..1]
		PBS pbs = bank.getPBS();
		if (pbs != null) {
			// 1.20.1 低保救助记录信息单元 PF06 [0..*]
			List<PF06> pf06List = pbs.getPF06List();
			if (pf06List != null && pf06List.size() > 0) {
				for (int i = 0; i < pf06List.size(); i++) {
					PF06 pf06 = pf06List.get(i);
					if (pf06 != null) {
						// 1.20.1.1 低保救助记录信息段 PF06A [1..1]
						PF06A pf06a = pf06.getPF06A();
						if (pf06a != null) {
							bankLowIncomeSalveRecordMapper.insertLowIncomeSalveRecordInfo(pf06a);
						}
						// 1.20.1.2 标注及声明信息段 PF06Z [0..1]
						PF06Z pf06z = pf06.getPF06Z();
						if (pf06z != null) {
							PF06Zdata PF06Zdata = pf06z.getPF06Zdata();
							if (PF06Zdata != null) {
								bankLowIncomeSalveRecordMapper.insertLowIncomeSalveRecordPbsLabelState(PF06Zdata);
							}
							// 1.20.1.2.2 标注及声明信息 PF06ZH [1..5]
							List<PF06ZH> pf06zhList = pf06z.getPF06ZHList();
							if (pf06zhList != null && pf06zhList.size() > 0) {
								bankLowIncomeSalveRecordMapper
										.insertLowIncomeSalveRecordPbsLabelStateInfoList(pf06zhList);
							}
						}
					}
				}
			}
		}
		// 1.21 执业资格记录 PPQ [1..1]
		PPQ ppq = bank.getPPQ();
		if (ppq != null) {
			// 1.21.1 执业资格记录信息单元 PF07 [0..*]
			List<PF07> pf07List = ppq.getPF07List();
			if (pf07List != null && pf07List.size() > 0) {
				for (int i = 0; i < pf07List.size(); i++) {
					PF07 pf07 = pf07List.get(i);
					if (pf07 != null) {
						// 1.21.1.1 执业资格记录信息段 PF07A [1..1]
						PF07A pf07a = pf07.getPF07A();
						if (pf07a != null) {
							bankPracticeQualifyRecordMapper.insertPracticeQualifyRecordInfo(pf07a);
						}
						// 1.21.1.2 标注及声明信息段 PF07Z [0..1]
						PF07Z pf07z = pf07.getPF07Z();
						if (pf07z != null) {
							PF07Zdata pf07zData = pf07z.getPF07Zdata();
							if (pf07zData != null) {
								bankPracticeQualifyRecordMapper.insertPracticeQualifyRecordPpqLabelState(pf07zData);
							}
							// 1.21.1.2.2 标注及声明信息 PF07ZH [1..5]
							List<PF07ZH> pf07zhList = pf07z.getPF07ZHList();
							if (pf07zhList != null && pf07zhList.size() > 0) {
								bankPracticeQualifyRecordMapper
										.insertPracticeQualifyRecordPpqLabelStateInfoList(pf07zhList);
							}
						}
					}
				}
			}
		}
		// 1.22 行政奖励记录 PAH [1..1]
		PAH pah = bank.getPAH();
		if (pah != null) {
			// 1.22.1 行政奖励记录信息单元 PF08 [0..*]
			List<PF08> pf08List = pah.getPF08List();
			if (pf08List != null && pf08List.size() > 0) {
				for (int i = 0; i < pf08List.size(); i++) {
					PF08 pf08 = pf08List.get(i);
					if (pf08 != null) {
						// 1.22.1.1 行政奖励记录信息段 PF08A [1..1]
						PF08A pf08a = pf08.getPF08A();
						if (pf08a != null) {
							bankAdministraAwardRecordMapper.insertAdministraAwardRecordInfo(pf08a);
						}
						// 1.22.1.2 标注及声明信息段 PF08Z [0..1]
						PF08Z pf08z = pf08.getPF08Z();
						if (pf08z != null) {
							PF08Zdata pf08zData = pf08z.getPF08Zdata();
							if (pf08zData != null) {
								bankAdministraAwardRecordMapper.insertAdministraAwardRecordPahLabelState(pf08zData);
							}
							// 1.22.1.2.2 标注及声明信息 PF08ZH [1..5]
							List<PF08ZH> pf08zhList = pf08z.getPF08ZHList();
							if (pf08zhList != null && pf08zhList.size() > 0) {
								bankAdministraAwardRecordMapper
										.insertAdministraAwardRecordPahLabelStateInfoList(pf08zhList);
							}
						}
					}
				}
			}
		}
		// 1.23 其他标注及声明信息 POS [1..1]
		POS pos = bank.getPOS();
		if (pos != null) {
			// 1.23.1 标注及声明信息单元 PG01 [0..*]
			List<PG01> pg01List = pos.getPG01List();
			if (pg01List != null && pg01List.size() > 0) {
				for (int i = 0; i < pg01List.size(); i++) {
					PG01 pg01 = pg01List.get(i);
					if (pg01 != null) {
						PG01data pg01Data = pg01.getPG01data();
						if (pg01Data != null) {
							bankOtherLabelStateMapper.insertOtherLabelState(pg01Data);
						}
						// 1.23.1.4 标注及声明信息 PG010H [1..5]
						List<PG010H> pg010hList = pg01.getPG010HList();
						if (pg010hList != null && pg010hList.size() > 0) {
							bankOtherLabelStateMapper.insertOtherLabelStateInfoList(pg010hList);
						}
					}
				}
			}
		}
		// 1.24 查询记录 POQ [1..1]
		POQ poq = bank.getPOQ();
		if (poq != null) {
			// 1.24.1 查询记录信息单元 PH01 [0..*]
			List<PH01> ph01List = poq.getPH01List();
			if (ph01List != null && ph01List.size() > 0) {
				bankQueryRecordMapper.insertQueryRecordList(ph01List);
			}
		}

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveBankControlLogic(String uniqueRelid, String sourceId, String identityType, String identityCardNo,
			String name, String queryFlag, String source, String body) {

		bankControlLogicMapper.insertBankBodyOriginal(identityCardNo, identityType, name, uniqueRelid, body,
				TaskParamUtil.TASK_IP);

		bankControlLogicMapper.insertBankTaskCall(uniqueRelid, sourceId, TaskParamUtil.TASK_IP, TaskStatusUtil.INITIAL,
				identityType, identityCardNo, name, queryFlag, source);

	}

	@Override
	public String queryLateIdNoUniqueRelid(Map<String, String> param) {
		return bankControlLogicMapper.selectLateIdNoUniqueRelid(param);
	}

	@Override
	public String findBankMessage(Map<String, String> param) {
		return bankControlLogicMapper.selectBankMessage(param);
	}

	@Override
	public List<Map<String, String>> findBankParserTaskList(Map<String, Object> param) {
		return bankControlLogicMapper.selectBankParserTaskList(param);
	}

	@Override
	public String findBankMessageByUniqueRelid(String uniqueRelid) {
		return bankControlLogicMapper.selectBankMessageByUniqueRelid(uniqueRelid);
	}

	@Override
	public void updateBankTaskCall(String uniqueRelid, String taskStatus) {
		bankControlLogicMapper.updateBankTaskCall(uniqueRelid, taskStatus);
	}

	@Override
	public void deleteBankTask(String uniqueRelid, String taskStatus) {
		bankControlLogicMapper.deleteBankTask(uniqueRelid, taskStatus);
	}

	@Override
	public String findBankBodyOriginalUniqueRelid(String uniqueRelid) {
		return bankControlLogicMapper.selectBankBodyOriginalUniqueRelid(uniqueRelid);
	}

	@Override
	public void saveBankTaskHis(String uniqueRelid) {
		bankControlLogicMapper.insertBankTaskHis(uniqueRelid);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveDeleteBankBody(Integer dayControl, Integer queryNum) {
		// 查出需要插入历史表的数据
		List<String> uniqueRelidList = bankControlLogicMapper.selectBankBodyUniqueRelidList(dayControl, queryNum,
				TaskParamUtil.TASK_IP);
		if (uniqueRelidList != null && uniqueRelidList.size() > 0) {
			// 将这些数据保存到历史表 根据唯一关联id集合
			// 因报文 站空间较大 暂时不存入历史库 190308
			// bankControlLogicMapper.saveBankBodyHis(uniqueRelidList);
			// 删除原始报文 根据唯一关联id集合
			bankControlLogicMapper.deleteBankBody(uniqueRelidList);
		}
	}

	@Override
	public BankControlTimeNum findBankControlNumTime(String taskType) {
		return bankControlLogicMapper.selectBankControlNumTime(taskType);
	}

	@Override
	public Integer findBankNumByTime(Date startTime, Date endTime) {
		return bankControlLogicMapper.selectBankNumByTime(startTime, endTime);
	}

}
