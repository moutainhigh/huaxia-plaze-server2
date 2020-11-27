package com.huaxia.plaze.modules.pboc.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.plaze.modules.pboc.domain.Bank;
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
import com.huaxia.plaze.modules.pboc.service.BankService;
import com.huaxia.plaze.modules.pboc.service.BankTaskCallPlazeService;
import com.huaxia.plaze.util.TaskParamUtil;
import com.huaxia.plaze.util.TaskStatusUtil;
import com.huaxia.util.GuidUtil;

/**
 * 保存人行报文到三方平台
 * 
 * @author gaoh
 *
 */
public class BankSaveThread implements Runnable {

	private final static Logger logger = LoggerFactory.getLogger(BankSaveThread.class);

	private BankService bankService;
	
	private BankTaskCallPlazeService bankTaskCallPlazeService;

	public BankSaveThread(ThreadLocal<Map<String, Object>> wrapper) {
		Map<String, Object> services = wrapper.get();
		this.bankService = (BankService) services.get("bankService");
		this.bankTaskCallPlazeService = (BankTaskCallPlazeService) services.get("bankTaskCallPlazeService");
	}

	@Override
	public void run() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("taskIp", TaskParamUtil.TASK_IP);
		paramMap.put("taskStatus", TaskStatusUtil.INITIAL);
		paramMap.put("querySize", TaskParamUtil.BANK_PARSER_QUERY_SIZE);
		while (true) {
			boolean reStartBankFlag = false;// 线程重启标志(报错时线程不会中断)
			sleepThread(TaskParamUtil.BANK_PARSER_MULTIPLE_SLEEPTIME_MM);
			List<Map<String, String>> taskList = null;
			try {
				taskList = bankService.findBankParserTaskList(paramMap);
			} catch (Exception e) {
				if (logger.isErrorEnabled()) {
					logger.error("bankError: Exception:{}", e);
				}
				reStartBankFlag = true;
			}
			if (taskList != null && taskList.size() > 0) {
				for (Map<String, String> task : taskList) {
					String source = task.get("SOURCE");
					String uniqueRelid = task.get("UNIQUE_RELID");
					String idNo = task.get("IDENTITY_NO");// 当前请求被查询人证件号
					String body = "";
					boolean errorFlag = false;// 异常标志
					try {
						// 保存任务表更改前状态
						bankService.saveBankTaskHis(uniqueRelid);
						// 更改任务表状态 为开始
						bankService.updateBankTaskCall(uniqueRelid, TaskStatusUtil.START);
						// 查询出解密后报文
						body = bankService.findBankMessageByUniqueRelid(uniqueRelid);
					} catch (Exception e) {
						if (logger.isErrorEnabled()) {
							logger.error("bankPraseError:" + uniqueRelid + " Exception:{}", e);
						}
						reStartBankFlag = true;
					}
					if (reStartBankFlag) {// 查询报错跳出本次循环
						continue;
					}
					// 要更改成的任务状态
					String taskStatus = TaskStatusUtil.SUCCESS;
					Bank bank = null;
					try {
						bank = parse(body, idNo, uniqueRelid, source);
					} catch (Exception e) {
						if (logger.isErrorEnabled()) {
							logger.error("bankPraseError:" + uniqueRelid + " Exception:{}", e);
						}
						errorFlag = true;
						taskStatus = TaskStatusUtil.PARSE_ERROE;
					}
					if (!errorFlag) {
						try {
							bankService.saveBankReportMessage(bank);
						} catch (Exception e) {
							if (logger.isErrorEnabled()) {
								logger.error("bankSaveError:" + uniqueRelid + " Exception:{}", e);
							}
							errorFlag = true;
							taskStatus = TaskStatusUtil.SAVE_ERROE;
						}
					}
					try {
						// 保存任务表更改前状态
						bankService.saveBankTaskHis(uniqueRelid);
						// 更改任务表状态 为当前taskStatus值
						bankService.updateBankTaskCall(uniqueRelid, taskStatus);
						// 成功标的话 就删除
						if (TaskStatusUtil.SUCCESS.equals(taskStatus)) {
							// 保存任务表更改前状态
							bankService.saveBankTaskHis(uniqueRelid);
							// 删除任务表任务
							bankService.deleteBankTask(uniqueRelid, taskStatus);
							
							/**更改页面单笔请求表状态,反显用  */
							bankTaskCallPlazeService.updatePbocTrnSingleReview(uniqueRelid, "3");
						} else {
							bankTaskCallPlazeService.updatePbocTrnSingleReview(uniqueRelid, "4");
						}
					} catch (Exception e) {
						if (logger.isErrorEnabled()) {
							logger.error("bankSaveError:" + uniqueRelid + " Exception:{}", e);
						}
						reStartBankFlag = true;
					}

				} // 遍历结束

			} else {// 没数据时加大延迟时间

				sleepThread(TaskParamUtil.BANK_PARSER_THREAD_SLEEPTIME_MM);

			}
			// 报错时加大延迟时间
			if (reStartBankFlag) {
				if (logger.isErrorEnabled()) {
					logger.error("bankSaveError: Exception:{}", "bankSaveThread Restart!! 请查看报错原因!!");
				}
				sleepThread(8000);
			}
		}

	}

	/**
	 * @Title:sleepThread
	 * @Description:使线程停顿一段时间
	 * @param time
	 *            停顿时间（毫秒）
	 * @author: gaohui
	 * @Date:2019年1月8日下午2:03:57
	 */
	private void sleepThread(Integer time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			if (logger.isInfoEnabled()) {
				logger.info("threadSleepBank:Exception：{}", e);
			}
		}
	}

	/**
	 * @Title:parse
	 * @Description:人行报文解析
	 * @param message
	 *            人行报文
	 * @param identityCardNo
	 *            身份证号
	 * @param uniqueRelid
	 *            唯一关联ID
	 * @param source
	 *            数据来源
	 * @return
	 * @author: gaohui
	 * @Date:2019年1月9日下午3:52:32
	 */
	@SuppressWarnings("unchecked")
	private Bank parse(String message, String identityCardNo, String uniqueRelid, String source) {
		Document document = null;
		try {
			document = DocumentHelper.parseText(message);
		} catch (DocumentException e) {

		}
		Bank bank = new Bank();
		bank.setIdentityCardNo(identityCardNo);
		bank.setUniqueRelid(uniqueRelid);
		Node rootNode = document.selectSingleNode("/Document");
		if (rootNode != null) {
			// 1.1 报告头 PRH [1..1]
			Node prhNode = rootNode.selectSingleNode("PRH");
			if (prhNode != null) {
				PRH prh = new PRH();
				// 1.1.1 报告头信息单元 PA01 [1..1]
				Node pa01Node = prhNode.selectSingleNode("PA01");
				if (pa01Node != null) {
					PA01 pa01 = new PA01();
					// 1.1.1.1 报告标识信息段 PA01A [1..1]
					Node pa01aNode = pa01Node.selectSingleNode("PA01A");
					if (pa01aNode != null) {
						PA01A pa01a = new PA01A();
						pa01a.setIdentityCardNo(identityCardNo);
						pa01a.setUniqueRelid(uniqueRelid);
						pa01a.setSource(source);
						// 1.1.1.1.1 报告编号 PA01AI01 -- [1..1]
						Node PA01AI01 = pa01aNode.selectSingleNode("PA01AI01");
						if (PA01AI01 != null) {
							pa01a.setPA01AI01(PA01AI01.getText());
						}
						// 1.1.1.1.2 报告时间 PA01AR01 -- [1..1]
						Node PA01AR01 = pa01aNode.selectSingleNode("PA01AR01");
						if (PA01AR01 != null) {
							pa01a.setPA01AR01(PA01AR01.getText());
						}
						pa01.setPA01A(pa01a);
					}
					// 1.1.1.2本次查询请求信息段 PA01B [1..1]
					Node pa01bNode = pa01Node.selectSingleNode("PA01B");
					if (pa01bNode != null) {
						PA01B pa01b = new PA01B();
						pa01b.setIdentityCardNo(identityCardNo);
						pa01b.setUniqueRelid(uniqueRelid);
						// 1.1.1.2.1 被查询者姓名 PA01BQ01 [1..1]
						Node PA01BQ01 = pa01bNode.selectSingleNode("PA01BQ01");
						if (PA01BQ01 != null) {
							pa01b.setPA01BQ01(PA01BQ01.getText());
						}
						// 1.1.1.2.2 被查询者证件类型 PA01BD01 [1..1]
						Node PA01BD01 = pa01bNode.selectSingleNode("PA01BD01");
						if (PA01BD01 != null) {
							pa01b.setPA01BD01(PA01BD01.getText());
						}
						// 1.1.1.2.3被查询者证件号码 PA01BI01 [1..1]
						Node PA01BI01 = pa01bNode.selectSingleNode("PA01BI01");
						if (PA01BI01 != null) {
							pa01b.setPA01BI01(PA01BI01.getText());
						}
						// 1.1.1.2.4查询机构代码 PA01BI02 [1..1]
						Node PA01BI02 = pa01bNode.selectSingleNode("PA01BI02");
						if (PA01BI02 != null) {
							pa01b.setPA01BI02(PA01BI02.getText());
						}
						// 1.1.1.2.5查询原因代码 PA01BD02 [1..1]
						Node PA01BD02 = pa01bNode.selectSingleNode("PA01BD02");
						if (PA01BD02 != null) {
							pa01b.setPA01BD02(PA01BD02.getText());
						}
						pa01.setPA01B(pa01b);
					}
					// 1.1.1.3 其他身份标识信息段 PA01C [0..1]
					Node pa01cNode = pa01Node.selectSingleNode("PA01C");
					if (pa01cNode != null) {
						PA01C pa01c = new PA01C();
						// 1.1.1.3.1 身份标识个数 PA01CS01 [1..1]
						Node PA01CS01 = pa01cNode.selectSingleNode("PA01CS01");
						if (PA01CS01 != null) {
							PA01Cdata pa01cData = new PA01Cdata();
							pa01cData.setIdentityCardNo(identityCardNo);
							pa01cData.setUniqueRelid(uniqueRelid);
							pa01cData.setPA01CS01(PA01CS01.getText());
							pa01c.setPA01Cdata(pa01cData);
						}
						// 1.1.1.3.2 身份信息 PA01CH [0..99]
						List<Element> pa01chListNode = pa01cNode.selectNodes("PA01CH");
						if (pa01chListNode != null && pa01chListNode.size() > 0) {
							List<PA01CH> pa01chList = new ArrayList<PA01CH>();
							for (int i = 0; i < pa01chListNode.size(); i++) {
								Element pa01chNode = pa01chListNode.get(i);
								if (pa01chNode == null) {
									continue;
								}
								PA01CH pa01ch = new PA01CH();
								pa01ch.setIdentityCardNo(identityCardNo);
								pa01ch.setUniqueRelid(uniqueRelid);
								// 1.1.1.3.2.1 证件类型 PA01CD01 [1..1]
								Node PA01CD01 = pa01chNode.selectSingleNode("PA01CD01");
								if (PA01CD01 != null) {
									pa01ch.setPA01CD01(PA01CD01.getText());
								}
								// 1.1.1.3.2.2证件号码 PA01CI01 [1..1]
								Node PA01CI01 = pa01chNode.selectSingleNode("PA01CI01");
								if (PA01CI01 != null) {
									pa01ch.setPA01CI01(PA01CI01.getText());
								}
								pa01chList.add(pa01ch);
							}
							pa01c.setPA01CHList(pa01chList);
						}
						pa01.setPA01C(pa01c);
					}
					// 1.1.1.4 防欺诈警示信息段 PA01D [1..1]
					Node pa01dNode = pa01Node.selectSingleNode("PA01D");
					if (pa01dNode != null) {
						PA01D pa01d = new PA01D();
						pa01d.setIdentityCardNo(identityCardNo);
						pa01d.setUniqueRelid(uniqueRelid);
						// 1.1.1.4.1 防欺诈警示标志 PA01DQ01 [1..1]
						Node PA01DQ01 = pa01dNode.selectSingleNode("PA01DQ01");
						if (PA01DQ01 != null) {
							pa01d.setPA01DQ01(PA01DQ01.getText());
						}
						// 1.1.1.4.2防欺诈警示联系电话 PA01DQ02 [1..1]
						Node PA01DQ02 = pa01dNode.selectSingleNode("PA01DQ02");
						if (PA01DQ02 != null) {
							pa01d.setPA01DQ02(PA01DQ02.getText());
						}
						// 1.1.1.4.3防欺诈警示生效日期 PA01DR01 [1..1]
						Node PA01DR01 = pa01dNode.selectSingleNode("PA01DR01");
						if (PA01DR01 != null) {
							pa01d.setPA01DR01(PA01DR01.getText());
						}
						// 1.1.1.4.4防欺诈警示截止日期 PA01DR02 [1..1]
						Node PA01DR02 = pa01dNode.selectSingleNode("PA01DR02");
						if (PA01DR02 != null) {
							pa01d.setPA01DR02(PA01DR02.getText());
						}
						pa01.setPA01D(pa01d);
					}
					// 1.1.1.5 异议提示信息段 PA01E [1..1]
					Node pa01eNode = pa01Node.selectSingleNode("PA01E");
					if (pa01eNode != null) {
						// 1.1.1.5.1 异议标注数目 PA01ES01 [1..1]
						Node PA01ES01 = pa01eNode.selectSingleNode("PA01ES01");
						if (PA01ES01 != null) {
							PA01E pa01e = new PA01E();
							pa01e.setIdentityCardNo(identityCardNo);
							pa01e.setUniqueRelid(uniqueRelid);
							pa01e.setPA01ES01(PA01ES01.getText());
							pa01.setPA01E(pa01e);
						}
					}
					prh.setPA01(pa01);
				}
				bank.setPRH(prh);
			}
			// 1.2 身份信息 PIM [1..1]
			Node pimNode = rootNode.selectSingleNode("PIM");
			if (pimNode != null) {
				PIM pim = new PIM();
				// 1.2.1 身份信息单元 PB01 [0..1]
				Node pb01Node = pimNode.selectSingleNode("PB01");
				if (pb01Node != null) {
					PB01 pb01 = new PB01();
					// 1.2.1.1 基本概况信息段 PB01A [0..1]
					Node pb01aNode = pb01Node.selectSingleNode("PB01A");
					if (pb01aNode != null) {
						PB01A pb01a = new PB01A();
						pb01a.setIdentityCardNo(identityCardNo);
						pb01a.setUniqueRelid(uniqueRelid);
						// 1.2.1.1.1 性别 PB01AD01 -- [1..1]
						Node PB01AD01 = pb01aNode.selectSingleNode("PB01AD01");
						if (PB01AD01 != null) {
							pb01a.setPB01AD01(PB01AD01.getText());
						}
						// 1.2.1.1.2 出生日期 PB01AR01 -- [1..1]
						Node PB01AR01 = pb01aNode.selectSingleNode("PB01AR01");
						if (PB01AR01 != null) {
							pb01a.setPB01AR01(PB01AR01.getText());
						}
						// 1.2.1.1.3 学历 PB01AD02 -- [1..1]
						Node PB01AD02 = pb01aNode.selectSingleNode("PB01AD02");
						if (PB01AD02 != null) {
							pb01a.setPB01AD02(PB01AD02.getText());
						}
						// 1.2.1.1.4 学位 PB01AD03 -- [1..1]
						Node PB01AD03 = pb01aNode.selectSingleNode("PB01AD03");
						if (PB01AD03 != null) {
							pb01a.setPB01AD03(PB01AD03.getText());
						}
						// 1.2.1.1.5 就业状况 PB01AD04 -- [1..1]
						Node PB01AD04 = pb01aNode.selectSingleNode("PB01AD04");
						if (PB01AD04 != null) {
							pb01a.setPB01AD04(PB01AD04.getText());
						}
						// 1.2.1.1.6 电子邮箱 PB01AQ01 -- [1..1]
						Node PB01AQ01 = pb01aNode.selectSingleNode("PB01AQ01");
						if (PB01AQ01 != null) {
							pb01a.setPB01AQ01(PB01AQ01.getText());
						}
						// 1.2.1.1.7 通讯地址 PB01AQ02 -- [1..1]
						Node PB01AQ02 = pb01aNode.selectSingleNode("PB01AQ02");
						if (PB01AQ02 != null) {
							pb01a.setPB01AQ02(PB01AQ02.getText());
						}
						// 1.2.1.1.8 国籍 PB01AD05 -- [1..1]
						Node PB01AD05 = pb01aNode.selectSingleNode("PB01AD05");
						if (PB01AD05 != null) {
							pb01a.setPB01AD05(PB01AD05.getText());
						}
						// 1.2.1.1.9 户籍地址 PB01AQ03 -- [1..1]
						Node PB01AQ03 = pb01aNode.selectSingleNode("PB01AQ03");
						if (PB01AQ03 != null) {
							pb01a.setPB01AQ03(PB01AQ03.getText());
						}
						pb01.setPB01A(pb01a);
					}
					// 1.2.2 手机号码信息段 PB01B [0..1]
					Node pb01bNode = pb01Node.selectSingleNode("PB01B");
					if (pb01bNode != null) {
						PB01B pb01b = new PB01B();
						// 1.2.2.1手机号码个数 PB01BS01 -- [1..1]
						Node PB01BS01 = pb01bNode.selectSingleNode("PB01BS01");
						if (PB01BS01 != null) {
							PB01Bdata pb01bData = new PB01Bdata();
							pb01bData.setIdentityCardNo(identityCardNo);
							pb01bData.setUniqueRelid(uniqueRelid);
							pb01bData.setPB01BS01(PB01BS01.getText());
							pb01b.setPB01Bdata(pb01bData);
						}
						// 1.2.2.2手机号码信息 PB01BH [1..5]
						List<Element> pb01bhListNode = pb01bNode.selectNodes("PB01BH");
						if (pb01bhListNode != null && pb01bhListNode.size() > 0) {
							List<PB01BH> pb01bhList = new ArrayList<PB01BH>();
							for (int i = 0; i < pb01bhListNode.size(); i++) {
								Element pb01bhNode = pb01bhListNode.get(i);
								if (pb01bhNode == null) {
									continue;
								}
								PB01BH pb01bh = new PB01BH();
								pb01bh.setIdentityCardNo(identityCardNo);
								pb01bh.setUniqueRelid(uniqueRelid);
								// 1.2.2.2.1手机号码 PB01BQ01 -- [1..1]
								Node PB01BQ01 = pb01bhNode.selectSingleNode("PB01BQ01");
								if (PB01BQ01 != null) {
									pb01bh.setPB01BQ01(PB01BQ01.getText());
								}
								// 1.2.2.2.2信息更新日期 PB01BR01 -- [1..1]
								Node PB01BR01 = pb01bhNode.selectSingleNode("PB01BR01");
								if (PB01BR01 != null) {
									pb01bh.setPB01BR01(PB01BR01.getText());
								}
								pb01bhList.add(pb01bh);
							}
							pb01b.setPB01BHList(pb01bhList);
						}
						pb01.setPB01B(pb01b);
					}
					pim.setPB01(pb01);
				}
				bank.setPIM(pim);
			}
			// 1.3 婚姻信息 PMM [1..1]
			Node pmmNode = rootNode.selectSingleNode("PMM");
			if (pmmNode != null) {
				PMM pmm = new PMM();
				// 1.3.1 婚姻信息单元 PB02 [0..1]
				Node pb02Node = pmmNode.selectSingleNode("PB02");
				if (pb02Node != null) {
					PB02 pb02 = new PB02();
					pb02.setIdentityCardNo(identityCardNo);
					pb02.setUniqueRelid(uniqueRelid);
					// 1.3.1.1 婚姻状况 PB020D01 -- [1..1]
					Node PB020D01 = pb02Node.selectSingleNode("PB020D01");
					if (PB020D01 != null) {
						pb02.setPB020D01(PB020D01.getText());
					}
					// 1.3.1.2 配偶姓名 PB020Q01 -- [1..1]
					Node PB020Q01 = pb02Node.selectSingleNode("PB020Q01");
					if (PB020Q01 != null) {
						pb02.setPB020Q01(PB020Q01.getText());
					}
					// 1.3.1.3 配偶证件类型 PB020D02 -- [1..1]
					Node PB020D02 = pb02Node.selectSingleNode("PB020D02");
					if (PB020D02 != null) {
						pb02.setPB020D02(PB020D02.getText());
					}
					// 1.3.1.4 配偶证件号码 PB020I01 -- [1..1]
					Node PB020I01 = pb02Node.selectSingleNode("PB020I01");
					if (PB020I01 != null) {
						pb02.setPB020I01(PB020I01.getText());
					}
					// 1.3.1.5 配偶工作单位 PB020Q02 -- [1..1]
					Node PB020Q02 = pb02Node.selectSingleNode("PB020Q02");
					if (PB020Q02 != null) {
						pb02.setPB020Q02(PB020Q02.getText());
					}
					// 1.3.1.6 配偶联系电话 PB020Q03 -- [1..1]
					Node PB020Q03 = pb02Node.selectSingleNode("PB020Q03");
					if (PB020Q03 != null) {
						pb02.setPB020Q03(PB020Q03.getText());
					}
					pmm.setPB02(pb02);
				}
				bank.setPMM(pmm);
			}
			// 1.4 居住信息 PRM [1..1]
			Node prmNode = rootNode.selectSingleNode("PRM");
			if (prmNode != null) {
				PRM prm = new PRM();
				// 1.4.1 居住信息单元 PB03 [0..5]
				List<Element> pb03ListNode = prmNode.selectNodes("PB03");
				if (pb03ListNode != null && pb03ListNode.size() > 0) {
					List<PB03> pb03List = new ArrayList<PB03>();
					for (int i = 0; i < pb03ListNode.size(); i++) {
						Element pb03Node = pb03ListNode.get(i);
						if (pb03Node == null) {
							continue;
						}
						PB03 pb03 = new PB03();
						pb03.setIdentityCardNo(identityCardNo);
						pb03.setUniqueRelid(uniqueRelid);
						// 1.4.1.1 居住状况 PB030D01 -- [1..1]
						Node PB030D01 = pb03Node.selectSingleNode("PB030D01");
						if (PB030D01 != null) {
							pb03.setPB030D01(PB030D01.getText());
						}
						// 1.4.1.2 居住地址 PB030Q01 -- [1..1]
						Node PB030Q01 = pb03Node.selectSingleNode("PB030Q01");
						if (PB030Q01 != null) {
							pb03.setPB030Q01(PB030Q01.getText());
						}
						// 1.4.1.3 住宅电话 PB030Q02 -- [1..1]
						Node PB030Q02 = pb03Node.selectSingleNode("PB030Q02");
						if (PB030Q02 != null) {
							pb03.setPB030Q02(PB030Q02.getText());
						}
						// 1.4.1.4 信息更新日期 PB030R01 -- [1..1]
						Node PB030R01 = pb03Node.selectSingleNode("PB030R01");
						if (PB030R01 != null) {
							pb03.setPB030R01(PB030R01.getText());
						}
						pb03List.add(pb03);
					}
					prm.setPB03List(pb03List);
				}
				bank.setPRM(prm);
			}
			// 1.5 职业信息 POM [1..1]
			Node pomNode = rootNode.selectSingleNode("POM");
			if (pomNode != null) {
				POM pom = new POM();
				// 1.5.1 职业信息单元 PB04 [0..5]
				List<Element> pb04ListNode = pomNode.selectNodes("PB04");
				if (pb04ListNode != null && pb04ListNode.size() > 0) {
					List<PB04> pb04List = new ArrayList<PB04>();
					for (int i = 0; i < pb04ListNode.size(); i++) {
						Element pb04Node = pb04ListNode.get(i);
						if (pb04Node == null) {
							continue;
						}
						PB04 pb04 = new PB04();
						pb04.setIdentityCardNo(identityCardNo);
						pb04.setUniqueRelid(uniqueRelid);
						// 1.5.1.1 就业状况 PB040D01 -- [1..1]
						Node PB040D01 = pb04Node.selectSingleNode("PB040D01");
						if (PB040D01 != null) {
							pb04.setPB040D01(PB040D01.getText());
						}
						// 1.5.1.2 工作单位 PB040Q01 -- [1..1]
						Node PB040Q01 = pb04Node.selectSingleNode("PB040Q01");
						if (PB040Q01 != null) {
							pb04.setPB040Q01(PB040Q01.getText());
						}
						// 1.5.1.3 单位性质 PB040D02 -- [1..1]
						Node PB040D02 = pb04Node.selectSingleNode("PB040D02");
						if (PB040D02 != null) {
							pb04.setPB040D02(PB040D02.getText());
						}
						// 1.5.1.4 行业 PB040D03 -- [1..1]
						Node PB040D03 = pb04Node.selectSingleNode("PB040D03");
						if (PB040D03 != null) {
							pb04.setPB040D03(PB040D03.getText());
						}
						// 1.5.1.5 单位地址 PB040Q02 -- [1..1]
						Node PB040Q02 = pb04Node.selectSingleNode("PB040Q02");
						if (PB040Q02 != null) {
							pb04.setPB040Q02(PB040Q02.getText());
						}
						// 1.5.1.6 单位电话 PB040Q03 -- [1..1]
						Node PB040Q03 = pb04Node.selectSingleNode("PB040Q03");
						if (PB040Q03 != null) {
							pb04.setPB040Q03(PB040Q03.getText());
						}
						// 1.5.1.7 职业 PB040D04 -- [1..1]
						Node PB040D04 = pb04Node.selectSingleNode("PB040D04");
						if (PB040D04 != null) {
							pb04.setPB040D04(PB040D04.getText());
						}
						// 1.5.1.8 职务 PB040D05 -- [1..1]
						Node PB040D05 = pb04Node.selectSingleNode("PB040D05");
						if (PB040D05 != null) {
							pb04.setPB040D05(PB040D05.getText());
						}
						// 1.5.1.9 职称 PB040D06 -- [1..1]
						Node PB040D06 = pb04Node.selectSingleNode("PB040D06");
						if (PB040D06 != null) {
							pb04.setPB040D06(PB040D06.getText());
						}
						// 1.5.1.10 进入本单位年份 PB040R01 -- [1..1]
						Node PB040R01 = pb04Node.selectSingleNode("PB040R01");
						if (PB040R01 != null) {
							pb04.setPB040R01(PB040R01.getText());
						}
						// 1.5.1.11 信息更新日期 PB040R02 -- [1..1]
						Node PB040R02 = pb04Node.selectSingleNode("PB040R02");
						if (PB040R02 != null) {
							pb04.setPB040R02(PB040R02.getText());
						}
						pb04List.add(pb04);
					}
					pom.setPB04List(pb04List);
				}
				bank.setPOM(pom);
			}
			// 1.6 评分信息 PSM [1..1]
			Node psmNode = rootNode.selectSingleNode("PSM");
			if (psmNode != null) {
				PSM psm = new PSM();
				// 1.6.1 评分信息单元 PC01 [1..1]
				Node pc01Node = psmNode.selectSingleNode("PC01");
				if (pc01Node != null) {
					PC01 pc01 = new PC01();
					PC01data pc01Data = new PC01data();
					pc01Data.setIdentityCardNo(identityCardNo);
					pc01Data.setUniqueRelid(uniqueRelid);
					// 1.6.1.1 数字解读 PC010Q01 -- [1..1] 5 Score
					Node PC010Q01 = pc01Node.selectSingleNode("PC010Q01");
					if (PC010Q01 != null) {
						pc01Data.setPC010Q01(PC010Q01.getText());
					}
					// 1.6.1.2 相对位置 PC010Q02 -- [1..1]
					Node PC010Q02 = pc01Node.selectSingleNode("PC010Q02");
					if (PC010Q02 != null) {
						pc01Data.setPC010Q02(PC010Q02.getText());
					}
					// 1.6.1.3 分数说明条 PC010S01 -- [1..1]
					Node PC010S01 = pc01Node.selectSingleNode("PC010S01");
					if (PC010S01 != null) {
						pc01Data.setPC010S01(PC010S01.getText());
					}
					pc01.setPC01data(pc01Data);
					// 1.6.1.4 分数说明 PC010D01 -- [1..2]
					List<Element> pb010d01ListNode = pc01Node.selectNodes("PC010D01");
					if (pb010d01ListNode != null && pb010d01ListNode.size() > 0) {
						List<PC01scoreEle> pc01ScoreEleList = new ArrayList<PC01scoreEle>();
						for (int i = 0; i < pb010d01ListNode.size(); i++) {
							Element pb010d01Node = pb010d01ListNode.get(i);
							if (pb010d01Node == null) {
								continue;
							}
							PC01scoreEle pc01ScoreEle = new PC01scoreEle();
							pc01ScoreEle.setIdentityCardNo(identityCardNo);
							pc01ScoreEle.setUniqueRelid(uniqueRelid);
							pc01ScoreEle.setPC010D01(pb010d01Node.getText());
							pc01ScoreEleList.add(pc01ScoreEle);
						}
						pc01.setPC01scoreEleList(pc01ScoreEleList);
					}
					psm.setPC01(pc01);
				}
				bank.setPSM(psm);
			}
			// 1.7 信贷交易信息概要 PCO [1..1]
			Node pcoNode = rootNode.selectSingleNode("PCO");
			if (pcoNode != null) {
				PCO pco = new PCO();
				// 1.7.1 信贷交易信息概要信息单元 PC02 [0..1]
				Node pc02Node = pcoNode.selectSingleNode("PC02");
				if (pc02Node != null) {
					PC02 pc02 = new PC02();
					// 1.7.1.1 信贷交易提示信息段 PC02A [0..1]
					Node pc02aNode = pc02Node.selectSingleNode("PC02A");
					if (pc02aNode != null) {
						PC02A pc02a = new PC02A();
						PC02Adata pc02aData = new PC02Adata();
						pc02aData.setIdentityCardNo(identityCardNo);
						pc02aData.setUniqueRelid(uniqueRelid);
						// 1.7.1.1.1 账户数合计 PC02AS01 [1..1] --
						Node PC02AS01 = pc02aNode.selectSingleNode("PC02AS01");
						if (PC02AS01 != null) {
							pc02aData.setPC02AS01(PC02AS01.getText());
						}
						// 1.7.1.1.2 业务类型数量 PC02AS02 [1..1] --
						Node PC02AS02 = pc02aNode.selectSingleNode("PC02AS02");
						if (PC02AS02 != null) {
							pc02aData.setPC02AS02(PC02AS02.getText());
						}
						pc02a.setPC02Adata(pc02aData);
						// 1.7.1.1.3 信贷交易提示信息 PC02AH [1..6]
						List<Element> pc02ahListNode = pc02aNode.selectNodes("PC02AH");
						if (pc02ahListNode != null && pc02ahListNode.size() > 0) {
							List<PC02AH> pc0ahList = new ArrayList<PC02AH>();
							for (int i = 0; i < pc02ahListNode.size(); i++) {
								Element pc0ahNode = pc02ahListNode.get(i);
								if (pc0ahNode == null) {
									continue;
								}
								PC02AH pc0ah = new PC02AH();
								pc0ah.setIdentityCardNo(identityCardNo);
								pc0ah.setUniqueRelid(uniqueRelid);
								// 1.7.1.1.3.1 业务类型 PC02AD01 [1..1] --
								Node PC02AD01 = pc0ahNode.selectSingleNode("PC02AD01");
								if (PC02AD01 != null) {
									pc0ah.setPC02AD01(PC02AD01.getText());
								}
								// 1.7.1.1.3.2 业务大类 PC02AD02 [1..1] --
								Node PC02AD02 = pc0ahNode.selectSingleNode("PC02AD02");
								if (PC02AD02 != null) {
									pc0ah.setPC02AD02(PC02AD02.getText());
								}
								// 1.7.1.1.3.3 账户数 PC02AS03 [1..1] --
								Node PC02AS03 = pc0ahNode.selectSingleNode("PC02AS03");
								if (PC02AS03 != null) {
									pc0ah.setPC02AS03(PC02AS03.getText());
								}
								// 1.7.1.1.3.4 首笔业务发放月份 PC02AR01 [1..1] --
								Node PC02AR01 = pc0ahNode.selectSingleNode("PC02AR01");
								if (PC02AR01 != null) {
									pc0ah.setPC02AR01(PC02AR01.getText());
								}
								pc0ahList.add(pc0ah);
							}
							pc02a.setPC02AHList(pc0ahList);
						}
						pc02.setPC02A(pc02a);
					}
					// 1.7.1.2 被追偿汇总信息段 PC02B [0..1]
					Node pc02bNode = pc02Node.selectSingleNode("PC02B");
					if (pc02bNode != null) {
						PC02B pc02b = new PC02B();
						PC02Bdata pc02bData = new PC02Bdata();
						pc02bData.setIdentityCardNo(identityCardNo);
						pc02bData.setUniqueRelid(uniqueRelid);
						// 1.7.1.2.1 账户数合计 PC02BS01 [1..1] --
						Node PC02BS01 = pc02bNode.selectSingleNode("PC02BS01");
						if (PC02BS01 != null) {
							pc02bData.setPC02BS01(PC02BS01.getText());
						}
						// 1.7.1.2.2 余额合计 PC02BJ01 [1..1] --
						Node PC02BJ01 = pc02bNode.selectSingleNode("PC02BJ01");
						if (PC02BJ01 != null) {
							pc02bData.setPC02BJ01(PC02BJ01.getText());
						}
						// 1.7.1.2.3 业务类型数量 PC02BS02 [1..1] --
						Node PC02BS02 = pc02bNode.selectSingleNode("PC02BS02");
						if (PC02BS02 != null) {
							pc02bData.setPC02BS02(PC02BS02.getText());
						}
						pc02b.setPC02Bdata(pc02bData);
						// 1.7.1.2.4 被追偿汇总信息 PC02BH [1..2]
						List<Element> pc02bhListNode = pc02bNode.selectNodes("PC02BH");
						if (pc02bhListNode != null && pc02bhListNode.size() > 0) {
							List<PC02BH> pc02bhList = new ArrayList<PC02BH>();
							for (int i = 0; i < pc02bhListNode.size(); i++) {
								Element pc02bhNode = pc02bhListNode.get(i);
								if (pc02bhNode == null) {
									continue;
								}
								PC02BH pc02bh = new PC02BH();
								pc02bh.setIdentityCardNo(identityCardNo);
								pc02bh.setUniqueRelid(uniqueRelid);
								// 1.7.1.2.4.1 业务类型 PC02BD01 [1..1] --
								Node PC02BD01 = pc02bhNode.selectSingleNode("PC02BD01");
								if (PC02BD01 != null) {
									pc02bh.setPC02BD01(PC02BD01.getText());
								}
								// 1.7.1.2.4.2 账户数 PC02BS03 [1..1] --
								Node PC02BS03 = pc02bhNode.selectSingleNode("PC02BS03");
								if (PC02BS03 != null) {
									pc02bh.setPC02BS03(PC02BS03.getText());
								}
								// 1.7.1.2.4.3 余额 PC02BJ02 [1..1] --
								Node PC02BJ02 = pc02bhNode.selectSingleNode("PC02BJ02");
								if (PC02BJ02 != null) {
									pc02bh.setPC02BJ02(PC02BJ02.getText());
								}
								pc02bhList.add(pc02bh);
							}
							pc02b.setPC02BHList(pc02bhList);
						}
						pc02.setPC02B(pc02b);
					}
					// 1.7.1.3 呆账汇总信息段 PC02C [0..1]
					Node pc02cNode = pc02Node.selectSingleNode("PC02C");
					if (pc02cNode != null) {
						PC02C pc02c = new PC02C();
						pc02c.setIdentityCardNo(identityCardNo);
						pc02c.setUniqueRelid(uniqueRelid);
						// 1.7.1.3.1 账户数 PC02CS01 [1..1] --
						Node PC02CS01 = pc02cNode.selectSingleNode("PC02CS01");
						if (PC02CS01 != null) {
							pc02c.setPC02CS01(PC02CS01.getText());
						}
						// 1.7.1.3.2 余额 PC02CJ01 [1..1] --
						Node PC02CJ01 = pc02cNode.selectSingleNode("PC02CJ01");
						if (PC02CJ01 != null) {
							pc02c.setPC02CJ01(PC02CJ01.getText());
						}
						pc02.setPC02C(pc02c);
					}
					// 1.7.1.4 逾期（透支）汇总信息段 PC02D [0..1]
					Node pc02dNode = pc02Node.selectSingleNode("PC02D");
					if (pc02dNode != null) {
						PC02D pc02d = new PC02D();
						PC02Ddata pc02dData = new PC02Ddata();
						pc02dData.setIdentityCardNo(identityCardNo);
						pc02dData.setUniqueRelid(uniqueRelid);
						// 1.7.1.4.1 账户类型数量 PC02DS01 [1..1] --
						Node PC02DS01 = pc02dNode.selectSingleNode("PC02DS01");
						if (PC02DS01 != null) {
							pc02dData.setPC02DS01(PC02DS01.getText());
						}
						pc02d.setPC02Ddata(pc02dData);
						// 1.7.1.4.2 逾期（透支）汇总信息 PC02DH [1..6]
						List<Element> pc02dhListNode = pc02dNode.selectNodes("PC02DH");
						if (pc02dhListNode != null && pc02dhListNode.size() > 0) {
							List<PC02DH> pc02dhList = new ArrayList<PC02DH>();
							for (int i = 0; i < pc02dhListNode.size(); i++) {
								Element pc02dhNode = pc02dhListNode.get(i);
								if (pc02dhNode == null) {
									continue;
								}
								PC02DH pc02dh = new PC02DH();
								pc02dh.setIdentityCardNo(identityCardNo);
								pc02dh.setUniqueRelid(uniqueRelid);
								// 1.7.1.4.2.1 账户类型 PC02DD01 [1..1] --
								Node PC02DD01 = pc02dhNode.selectSingleNode("PC02DD01");
								if (PC02DD01 != null) {
									pc02dh.setPC02DD01(PC02DD01.getText());
								}
								// 1.7.1.4.2.2 账户数 PC02DS02 [1..1] --
								Node PC02DS02 = pc02dhNode.selectSingleNode("PC02DS02");
								if (PC02DS02 != null) {
									pc02dh.setPC02DS02(PC02DS02.getText());
								}
								// 1.7.1.4.2.3 月份数 PC02DS03 [1..1] --
								Node PC02DS03 = pc02dhNode.selectSingleNode("PC02DS03");
								if (PC02DS03 != null) {
									pc02dh.setPC02DS03(PC02DS03.getText());
								}
								// 1.7.1.4.2.4 单月最高逾期（透支）总额 PC02DJ01 [1..1] --
								Node PC02DJ01 = pc02dhNode.selectSingleNode("PC02DJ01");
								if (PC02DJ01 != null) {
									pc02dh.setPC02DJ01(PC02DJ01.getText());
								}
								// 1.7.1.4.2.5 最长逾期（透支）月数 PC02DS04 [1..1] --
								Node PC02DS04 = pc02dhNode.selectSingleNode("PC02DS04");
								if (PC02DS04 != null) {
									pc02dh.setPC02DS04(PC02DS04.getText());
								}

								pc02dhList.add(pc02dh);
							}
							pc02d.setPC02DHList(pc02dhList);
						}
						pc02.setPC02D(pc02d);
					}
					// 1.7.1.5 非循环贷账户汇总信息段 PC02E [0..1]
					Node pc02eNode = pc02Node.selectSingleNode("PC02E");
					if (pc02eNode != null) {
						PC02E pc02e = new PC02E();
						pc02e.setIdentityCardNo(identityCardNo);
						pc02e.setUniqueRelid(uniqueRelid);
						// 1.7.1.5.1 管理机构数 PC02ES01 [1..1] --
						Node PC02ES01 = pc02eNode.selectSingleNode("PC02ES01");
						if (PC02ES01 != null) {
							pc02e.setPC02ES01(PC02ES01.getText());
						}
						// 1.7.1.5.2 账户数 PC02ES02 [1..1] --
						Node PC02ES02 = pc02eNode.selectSingleNode("PC02ES02");
						if (PC02ES02 != null) {
							pc02e.setPC02ES02(PC02ES02.getText());
						}
						// 1.7.1.5.3 授信总额 PC02EJ01 [1..1] --
						Node PC02EJ01 = pc02eNode.selectSingleNode("PC02EJ01");
						if (PC02EJ01 != null) {
							pc02e.setPC02EJ01(PC02EJ01.getText());
						}
						// 1.7.1.5.4 余额 PC02EJ02 [1..1] --
						Node PC02EJ02 = pc02eNode.selectSingleNode("PC02EJ02");
						if (PC02EJ02 != null) {
							pc02e.setPC02EJ02(PC02EJ02.getText());
						}
						// 1.7.1.5.5 最近6个月平均应还款 PC02EJ03 [1..1] --
						Node PC02EJ03 = pc02eNode.selectSingleNode("PC02EJ03");
						if (PC02EJ03 != null) {
							pc02e.setPC02EJ03(PC02EJ03.getText());
						}
						pc02.setPC02E(pc02e);
					}
					// 1.7.1.6 循环额度下分账户汇总信息段 PC02F [0..1]
					Node pc02fNode = pc02Node.selectSingleNode("PC02F");
					if (pc02fNode != null) {
						PC02F pc02f = new PC02F();
						pc02f.setIdentityCardNo(identityCardNo);
						pc02f.setUniqueRelid(uniqueRelid);
						// 1.7.1.6.1 管理机构数 PC02FS01 [1..1] --
						Node PC02FS01 = pc02fNode.selectSingleNode("PC02FS01");
						if (PC02FS01 != null) {
							pc02f.setPC02FS01(PC02FS01.getText());
						}
						// 1.7.1.6.2 账户数 PC02FS02 [1..1] --
						Node PC02FS02 = pc02fNode.selectSingleNode("PC02FS02");
						if (PC02FS02 != null) {
							pc02f.setPC02FS02(PC02FS02.getText());
						}
						// 1.7.1.6.3 授信总额 PC02FJ01 [1..1] --
						Node PC02FJ01 = pc02fNode.selectSingleNode("PC02FJ01");
						if (PC02FJ01 != null) {
							pc02f.setPC02FJ01(PC02FJ01.getText());
						}
						// 1.7.1.6.4 余额 PC02FJ02 [1..1] --
						Node PC02FJ02 = pc02fNode.selectSingleNode("PC02FJ02");
						if (PC02FJ02 != null) {
							pc02f.setPC02FJ02(PC02FJ02.getText());
						}
						// 1.7.1.6.5 最近6个月平均应还款 PC02FJ03 [1..1] --
						Node PC02FJ03 = pc02fNode.selectSingleNode("PC02FJ03");
						if (PC02FJ03 != null) {
							pc02f.setPC02FJ03(PC02FJ03.getText());
						}
						pc02.setPC02F(pc02f);
					}
					// 1.7.1.7 循环贷账户汇总信息段 PC02G [0..1]
					Node pc02gNode = pc02Node.selectSingleNode("PC02G");
					if (pc02gNode != null) {
						PC02G pc02g = new PC02G();
						pc02g.setIdentityCardNo(identityCardNo);
						pc02g.setUniqueRelid(uniqueRelid);
						// 1.7.1.7.1 管理机构数 PC02GS01 [1..1] --
						Node PC02GS01 = pc02gNode.selectSingleNode("PC02GS01");
						if (PC02GS01 != null) {
							pc02g.setPC02GS01(PC02GS01.getText());
						}
						// 1.7.1.7.2 账户数 PC02GS02 [1..1] --
						Node PC02GS02 = pc02gNode.selectSingleNode("PC02GS02");
						if (PC02GS02 != null) {
							pc02g.setPC02GS02(PC02GS02.getText());
						}
						// 1.7.1.7.3 授信总额 PC02GJ01 [1..1] --
						Node PC02GJ01 = pc02gNode.selectSingleNode("PC02GJ01");
						if (PC02GJ01 != null) {
							pc02g.setPC02GJ01(PC02GJ01.getText());
						}
						// 1.7.1.7.4 余额 PC02GJ02 [1..1] --
						Node PC02GJ02 = pc02gNode.selectSingleNode("PC02GJ02");
						if (PC02GJ02 != null) {
							pc02g.setPC02GJ02(PC02GJ02.getText());
						}
						// 1.7.1.7.5 最近6个月平均应还款 PC02GJ03 [1..1] --
						Node PC02GJ03 = pc02gNode.selectSingleNode("PC02GJ03");
						if (PC02GJ03 != null) {
							pc02g.setPC02GJ03(PC02GJ03.getText());
						}
						pc02.setPC02G(pc02g);
					}
					// 1.7.1.8 贷记卡账户汇总信息段 PC02H [0..1]
					Node pc02hNode = pc02Node.selectSingleNode("PC02H");
					if (pc02hNode != null) {
						PC02H pc02h = new PC02H();
						pc02h.setIdentityCardNo(identityCardNo);
						pc02h.setUniqueRelid(uniqueRelid);
						// 1.7.1.8.1 发卡机构数 PC02HS01 [1..1] --
						Node PC02HS01 = pc02hNode.selectSingleNode("PC02HS01");
						if (PC02HS01 != null) {
							pc02h.setPC02HS01(PC02HS01.getText());
						}
						// 1.7.1.8.2 账户数 PC02HS02 [1..1] --
						Node PC02HS02 = pc02hNode.selectSingleNode("PC02HS02");
						if (PC02HS02 != null) {
							pc02h.setPC02HS02(PC02HS02.getText());
						}
						// 1.7.1.8.3 授信总额 PC02HJ01 [1..1] --
						Node PC02HJ01 = pc02hNode.selectSingleNode("PC02HJ01");
						if (PC02HJ01 != null) {
							pc02h.setPC02HJ01(PC02HJ01.getText());
						}
						// 1.7.1.8.4 单家行最高授信额 PC02HJ02 [1..1] --
						Node PC02HJ02 = pc02hNode.selectSingleNode("PC02HJ02");
						if (PC02HJ02 != null) {
							pc02h.setPC02HJ02(PC02HJ02.getText());
						}
						// 1.7.1.8.5 单家行最低授信额 PC02HJ03 [1..1] --
						Node PC02HJ03 = pc02hNode.selectSingleNode("PC02HJ03");
						if (PC02HJ03 != null) {
							pc02h.setPC02HJ03(PC02HJ03.getText());
						}
						// 1.7.1.8.6 已用额度 PC02HJ04 [1..1] --
						Node PC02HJ04 = pc02hNode.selectSingleNode("PC02HJ04");
						if (PC02HJ04 != null) {
							pc02h.setPC02HJ04(PC02HJ04.getText());
						}
						// 1.7.1.8.7 最近6个月平均使用额度 PC02HJ05 [1..1] --
						Node PC02HJ05 = pc02hNode.selectSingleNode("PC02HJ05");
						if (PC02HJ05 != null) {
							pc02h.setPC02HJ05(PC02HJ05.getText());
						}
						pc02.setPC02H(pc02h);
					}
					// 1.7.1.9 准贷记卡账户汇总信息段 PC02I [0..1]
					Node pc02iNode = pc02Node.selectSingleNode("PC02I");
					if (pc02iNode != null) {
						PC02I pc02i = new PC02I();
						pc02i.setIdentityCardNo(identityCardNo);
						pc02i.setUniqueRelid(uniqueRelid);
						// 1.7.1.9.1 发卡机构数 PC02IS01 [1..1] --
						Node PC02IS01 = pc02iNode.selectSingleNode("PC02IS01");
						if (PC02IS01 != null) {
							pc02i.setPC02IS01(PC02IS01.getText());
						}
						// 1.7.1.9.2 账户数 PC02IS02 [1..1] --
						Node PC02IS02 = pc02iNode.selectSingleNode("PC02IS02");
						if (PC02IS02 != null) {
							pc02i.setPC02IS02(PC02IS02.getText());
						}
						// 1.7.1.9.3 授信总额 PC02IJ01 [1..1] --
						Node PC02IJ01 = pc02iNode.selectSingleNode("PC02IJ01");
						if (PC02IJ01 != null) {
							pc02i.setPC02IJ01(PC02IJ01.getText());
						}
						// 1.7.1.9.4 单家行最高授信额 PC02IJ02 [1..1] --
						Node PC02IJ02 = pc02iNode.selectSingleNode("PC02IJ02");
						if (PC02IJ02 != null) {
							pc02i.setPC02IJ02(PC02IJ02.getText());
						}
						// 1.7.1.9.5 单家行最低授信额 PC02IJ03 [1..1] --
						Node PC02IJ03 = pc02iNode.selectSingleNode("PC02IJ03");
						if (PC02IJ03 != null) {
							pc02i.setPC02IJ03(PC02IJ03.getText());
						}
						// 1.7.1.9.6 透支余额 PC02IJ04 [1..1] --
						Node PC02IJ04 = pc02iNode.selectSingleNode("PC02IJ04");
						if (PC02IJ04 != null) {
							pc02i.setPC02IJ04(PC02IJ04.getText());
						}
						// 1.7.1.9.7 最近6个月平均透支余额 PC02IJ05 [1..1] --
						Node PC02IJ05 = pc02iNode.selectSingleNode("PC02IJ05");
						if (PC02IJ05 != null) {
							pc02i.setPC02IJ05(PC02IJ05.getText());
						}
						pc02.setPC02I(pc02i);
					}
					// 1.7.1.10 相关还款责任汇总信息段 PC02K [0..1]
					Node pc02kNode = pc02Node.selectSingleNode("PC02K");
					if (pc02kNode != null) {
						PC02K pc02k = new PC02K();
						PC02Kdata pc02kData = new PC02Kdata();
						pc02kData.setIdentityCardNo(identityCardNo);
						pc02kData.setUniqueRelid(uniqueRelid);
						// 1.7.1.10.1 相关还款责任个数 PC02KS01 [1..1] --
						Node PC02KS01 = pc02kNode.selectSingleNode("PC02KS01");
						if (PC02KS01 != null) {
							pc02kData.setPC02KS01(PC02KS01.getText());
						}
						pc02k.setPC02Kdata(pc02kData);
						// 1.7.1.10.2 相关还款责任汇总信息 PC02KH [1..4]
						List<Element> pc02khListNode = pc02kNode.selectNodes("PC02KH");
						if (pc02khListNode != null && pc02khListNode.size() > 0) {
							List<PC02KH> pc02khList = new ArrayList<PC02KH>();
							for (int i = 0; i < pc02khListNode.size(); i++) {
								Element pc02khNode = pc02khListNode.get(i);
								if (pc02khNode == null) {
									continue;
								}
								PC02KH pc02kh = new PC02KH();
								pc02kh.setIdentityCardNo(identityCardNo);
								pc02kh.setUniqueRelid(uniqueRelid);
								// 1.7.1.10.2.1 借款人身份类别 PC02KD01 [1..1] --
								Node PC02KD01 = pc02khNode.selectSingleNode("PC02KD01");
								if (PC02KD01 != null) {
									pc02kh.setPC02KD01(PC02KD01.getText());
								}
								// 1.7.1.10.2.2 还款责任类型 PC02KD02 [1..1] --
								Node PC02KD02 = pc02khNode.selectSingleNode("PC02KD02");
								if (PC02KD02 != null) {
									pc02kh.setPC02KD02(PC02KD02.getText());
								}
								// 1.7.1.10.2.3 账户数 PC02KS02 [1..1] --
								Node PC02KS02 = pc02khNode.selectSingleNode("PC02KS02");
								if (PC02KS02 != null) {
									pc02kh.setPC02KS02(PC02KS02.getText());
								}
								// 1.7.1.10.2.4 还款责任金额 PC02KJ01 [1..1] --
								Node PC02KJ01 = pc02khNode.selectSingleNode("PC02KJ01");
								if (PC02KJ01 != null) {
									pc02kh.setPC02KJ01(PC02KJ01.getText());
								}
								// 1.7.1.10.2.5 余额 PC02KJ02 [1..1] --
								Node PC02KJ02 = pc02khNode.selectSingleNode("PC02KJ02");
								if (PC02KJ02 != null) {
									pc02kh.setPC02KJ02(PC02KJ02.getText());
								}
								pc02khList.add(pc02kh);
							}
							pc02k.setPC02KHList(pc02khList);
						}
						pc02.setPC02K(pc02k);
					}
					pco.setPC02(pc02);
				}
				bank.setPCO(pco);
			}
			// 1.8 非信贷交易信息概要 PNO [1..1]
			Node pnoNode = rootNode.selectSingleNode("PNO");
			if (pnoNode != null) {
				PNO pno = new PNO();
				// 1.8.1 后付费业务欠费信息汇总信息单元 PC03 [0..1]
				Node pc03Node = pnoNode.selectSingleNode("PC03");
				if (pc03Node != null) {
					PC03 pc03 = new PC03();
					PC03data pc03Data = new PC03data();
					pc03Data.setIdentityCardNo(identityCardNo);
					pc03Data.setUniqueRelid(uniqueRelid);
					// 1.8.1.1 后付费业务类型数量 PC030S01 -- [1..1]
					Node PC030S01 = pc03Node.selectSingleNode("PC030S01");
					if (PC030S01 != null) {
						pc03Data.setPC030S01(PC030S01.getText());
					}
					pc03.setPC03data(pc03Data);
					// 1.8.1.2 后付费业务欠信息汇总信息 PC030H [1..1]
					Node pc030hNode = pc03Node.selectSingleNode("PC030H");
					if (pc030hNode != null) {
						PC030H pc030h = new PC030H();
						pc030h.setIdentityCardNo(identityCardNo);
						pc030h.setUniqueRelid(uniqueRelid);
						// 1.8.1.2.1 后付费业务类型 PC030D01 -- [1..1]
						Node PC030D01 = pc030hNode.selectSingleNode("PC030D01");
						if (PC030D01 != null) {
							pc030h.setPC030D01(PC030D01.getText());
						}
						// 1.8.1.2.2 欠费账户数 PC030S02 -- [1..1]
						Node PC030S02 = pc030hNode.selectSingleNode("PC030S02");
						if (PC030S02 != null) {
							pc030h.setPC030S02(PC030S02.getText());
						}
						// 1.8.1.2.3 欠费金额 PC030J01 -- [1..1]
						Node PC030J01 = pc030hNode.selectSingleNode("PC030J01");
						if (PC030J01 != null) {
							pc030h.setPC030J01(PC030J01.getText());
						}
						pc03.setPC030H(pc030h);
					}
					pno.setPC03(pc03);
				}
				bank.setPNO(pno);
			}
			// 1.9 公共信息概要 PPO [1..1]
			Node ppoNode = rootNode.selectSingleNode("PPO");
			if (ppoNode != null) {
				PPO ppo = new PPO();
				// 1.9.1 公共信息概要信息单元 PC04 [0..1]
				Node pc04Node = ppoNode.selectSingleNode("PC04");
				if (pc04Node != null) {
					PC04 pc04 = new PC04();
					PC04data pc04Data = new PC04data();
					pc04Data.setIdentityCardNo(identityCardNo);
					pc04Data.setUniqueRelid(uniqueRelid);
					// 1.9.1.1 公共信息类型数量 PC040S01 -- [1..1]
					Node PC040S01 = pc04Node.selectSingleNode("PC040S01");
					if (PC040S01 != null) {
						pc04Data.setPC040S01(PC040S01.getText());
					}
					pc04.setPC04data(pc04Data);
					// 1.9.1.2 公共信息概要信息 PC040H [1..4]
					List<Element> pc040hNodeList = pc04Node.selectNodes("PC040H");
					if (pc040hNodeList != null && pc040hNodeList.size() > 0) {
						List<PC040H> pc040hList = new ArrayList<PC040H>();
						for (int i = 0; i < pc040hNodeList.size(); i++) {
							Element pc040hNode = pc040hNodeList.get(i);
							if (pc040hNode == null) {
								continue;
							}
							PC040H pc040h = new PC040H();
							pc040h.setIdentityCardNo(identityCardNo);
							pc040h.setUniqueRelid(uniqueRelid);
							// 1.9.1.2.1 公共信息类型 PC040D01 -- [1..1]
							Node PC040D01 = pc040hNode.selectSingleNode("PC040D01");
							if (PC040D01 != null) {
								pc040h.setPC040D01(PC040D01.getText());
							}
							// 1.9.1.2.2 记录数 PC040S02 -- [1..1]
							Node PC040S02 = pc040hNode.selectSingleNode("PC040S02");
							if (PC040S02 != null) {
								pc040h.setPC040S02(PC040S02.getText());
							}
							// 1.9.1.2.3 涉及金额 PC040J01 -- [1..1]
							Node PC040J01 = pc040hNode.selectSingleNode("PC040J01");
							if (PC040J01 != null) {
								pc040h.setPC040J01(PC040J01.getText());
							}
							pc040hList.add(pc040h);
						}
						pc04.setPC040HList(pc040hList);
					}
					ppo.setPC04(pc04);
				}
				bank.setPPO(ppo);
			}
			// 1.10 查询记录概要 PQO [1..1]
			Node pqoNode = rootNode.selectSingleNode("PQO");
			if (pqoNode != null) {
				PQO pqo = new PQO();
				// 1.10.1 查询记录概要信息单元 PC05 [1..1]
				Node pc05Node = pqoNode.selectSingleNode("PC05");
				if (pc05Node != null) {
					PC05 pc05 = new PC05();
					// 1.10.1.1 上一次查询记录信息段 PC05A [0..1]
					Node pc05aNode = pc05Node.selectSingleNode("PC05A");
					if (pc05aNode != null) {
						PC05A pc05a = new PC05A();
						pc05a.setIdentityCardNo(identityCardNo);
						pc05a.setUniqueRelid(uniqueRelid);
						// 1.10.1.1.1上一次查询日期 PC05AR01 -- [1..1]
						Node PC05AR01 = pc05aNode.selectSingleNode("PC05AR01");
						if (PC05AR01 != null) {
							pc05a.setPC05AR01(PC05AR01.getText());
						}
						// 1.10.1.1.2上一次查询机构类型 PC05AD01 -- [1..1]
						Node PC05AD01 = pc05aNode.selectSingleNode("PC05AD01");
						if (PC05AD01 != null) {
							pc05a.setPC05AD01(PC05AD01.getText());
						}
						// 1.10.1.1.3上一次查询机构代码 PC05AI01 -- [1..1]
						Node PC05AI01 = pc05aNode.selectSingleNode("PC05AI01");
						if (PC05AI01 != null) {
							pc05a.setPC05AI01(PC05AI01.getText());
						}
						// 1.10.1.1.4上一次查询原因 PC05AQ01 -- [1..1]
						Node PC05AQ01 = pc05aNode.selectSingleNode("PC05AQ01");
						if (PC05AQ01 != null) {
							pc05a.setPC05AQ01(PC05AQ01.getText());
						}
						pc05.setPC05A(pc05a);
					}
					// 1.10.1.2 查询记录汇总信息段 PC05B [1..1]
					Node pc05bNode = pc05Node.selectSingleNode("PC05B");
					if (pc05bNode != null) {
						PC05B pc05b = new PC05B();
						pc05b.setIdentityCardNo(identityCardNo);
						pc05b.setUniqueRelid(uniqueRelid);
						// 1.10.1.2.1 最近1个月内的查询机构数（贷款审批） PC05BS01 -- [1..1]
						Node PC05BS01 = pc05bNode.selectSingleNode("PC05BS01");
						if (PC05BS01 != null) {
							pc05b.setPC05BS01(PC05BS01.getText());
						}
						// 1.10.1.2.2 最近1个月内的查询机构数（信用卡审批） PC05BS02 -- [1..1]
						Node PC05BS02 = pc05bNode.selectSingleNode("PC05BS02");
						if (PC05BS02 != null) {
							pc05b.setPC05BS02(PC05BS02.getText());
						}
						// 1.10.1.2.3 最近1个月内的查询次数（贷款审批）PC05BS03 -- [1..1]
						Node PC05BS03 = pc05bNode.selectSingleNode("PC05BS03");
						if (PC05BS03 != null) {
							pc05b.setPC05BS03(PC05BS03.getText());
						}
						// 1.10.1.2.4 最近1个月内的查询次数（信用卡审批） PC05BS04 -- [1..1]
						Node PC05BS04 = pc05bNode.selectSingleNode("PC05BS04");
						if (PC05BS04 != null) {
							pc05b.setPC05BS04(PC05BS04.getText());
						}
						// 1.10.1.2.5 最近1个月内的查询次数（本人查询） PC05BS05 -- [1..1]
						Node PC05BS05 = pc05bNode.selectSingleNode("PC05BS05");
						if (PC05BS05 != null) {
							pc05b.setPC05BS05(PC05BS05.getText());
						}
						// 1.10.1.2.6 最近2年内的查询次数（贷后管理） PC05BS06 -- [1..1]
						Node PC05BS06 = pc05bNode.selectSingleNode("PC05BS06");
						if (PC05BS06 != null) {
							pc05b.setPC05BS06(PC05BS06.getText());
						}
						// 1.10.1.2.7 最近2年内的查询次数（担保资格审查） PC05BS07 -- [1..1]
						Node PC05BS07 = pc05bNode.selectSingleNode("PC05BS07");
						if (PC05BS07 != null) {
							pc05b.setPC05BS07(PC05BS07.getText());
						}
						// 1.10.1.2.8 最近2年内的查询次数（特约商户实名审查）PC05BS08 -- [1..1]
						Node PC05BS08 = pc05bNode.selectSingleNode("PC05BS08");
						if (PC05BS08 != null) {
							pc05b.setPC05BS08(PC05BS08.getText());
						}
						pc05.setPC05B(pc05b);
					}
					pqo.setPC05(pc05);
				}
				bank.setPQO(pqo);
			}
			// 1.11 借贷账户信息 PDA [1..1]
			Node pdaNode = rootNode.selectSingleNode("PDA");
			if (pdaNode != null) {
				PDA pda = new PDA();
				// 1.11.1 借贷账户信息单元 PD01 [0..*]
				List<Element> pd01NodeList = pdaNode.selectNodes("PD01");
				if (pd01NodeList != null && pd01NodeList.size() > 0) {
					List<PD01> pd01List = new ArrayList<PD01>();
					for (int i = 0; i < pd01NodeList.size(); i++) {
						Element pd01Node = pd01NodeList.get(i);
						if (pd01Node == null) {
							continue;
						}
						PD01 pd01 = new PD01();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.11.1.1 基本信息段 PD01A [1..1]
						Node pd01aNode = pd01Node.selectSingleNode("PD01A");
						if (pd01aNode != null) {
							PD01A pd01a = new PD01A();
							pd01a.setIdentityCardNo(identityCardNo);
							pd01a.setUniqueRelid(uniqueRelid);
							pd01a.setRelateId(relateId);
							// 1.11.1.1.1 账户编号 PD01AI01 -- [1..1]
							Node PD01AI01 = pd01aNode.selectSingleNode("PD01AI01");
							if (PD01AI01 != null) {
								pd01a.setPD01AI01(PD01AI01.getText());
							}
							// 1.11.1.1.2 账户类型 PD01AD01 -- [1..1]
							Node PD01AD01 = pd01aNode.selectSingleNode("PD01AD01");
							if (PD01AD01 != null) {
								pd01a.setPD01AD01(PD01AD01.getText());
							}
							// 1.11.1.1.3 业务管理机构类型 PD01AD02 -- [1..1]
							Node PD01AD02 = pd01aNode.selectSingleNode("PD01AD02");
							if (PD01AD02 != null) {
								pd01a.setPD01AD02(PD01AD02.getText());
							}
							// 1.11.1.1.4 业务管理机构代码 PD01AI02 -- [1..1]
							Node PD01AI02 = pd01aNode.selectSingleNode("PD01AI02");
							if (PD01AI02 != null) {
								pd01a.setPD01AI02(PD01AI02.getText());
							}
							// 1.11.1.1.5 账户标识 PD01AI03 -- [0..1 ]
							Node PD01AI03 = pd01aNode.selectSingleNode("PD01AI03");
							if (PD01AI03 != null) {
								pd01a.setPD01AI03(PD01AI03.getText());
							}
							// 1.11.1.1.6 授信协议编号 PD01AI04 -- [0..1]
							Node PD01AI04 = pd01aNode.selectSingleNode("PD01AI04");
							if (PD01AI04 != null) {
								pd01a.setPD01AI04(PD01AI04.getText());
							}
							// 1.11.1.1.7 业务种类 PD01AD03 -- [0..1]
							Node PD01AD03 = pd01aNode.selectSingleNode("PD01AD03");
							if (PD01AD03 != null) {
								pd01a.setPD01AD03(PD01AD03.getText());
							}
							// 1.11.1.1.8 开立日期 PD01AR01 -- [1..1]
							Node PD01AR01 = pd01aNode.selectSingleNode("PD01AR01");
							if (PD01AR01 != null) {
								pd01a.setPD01AR01(PD01AR01.getText());
							}
							// 1.11.1.1.9 币种 PD01AD04 -- [0..1]
							Node PD01AD04 = pd01aNode.selectSingleNode("PD01AD04");
							if (PD01AD04 != null) {
								pd01a.setPD01AD04(PD01AD04.getText());
							}
							// 1.11.1.1.10 借款金额 PD01AJ01 -- [0..1]
							Node PD01AJ01 = pd01aNode.selectSingleNode("PD01AJ01");
							if (PD01AJ01 != null) {
								pd01a.setPD01AJ01(PD01AJ01.getText());
							}
							// 1.11.1.1.11 账户授信额度 PD01AJ02 -- [0..1]
							Node PD01AJ02 = pd01aNode.selectSingleNode("PD01AJ02");
							if (PD01AJ02 != null) {
								pd01a.setPD01AJ02(PD01AJ02.getText());
							}
							// 1.11.1.1.12 共享授信额度 PD01AJ03 -- [0..1]
							Node PD01AJ03 = pd01aNode.selectSingleNode("PD01AJ03");
							if (PD01AJ03 != null) {
								pd01a.setPD01AJ03(PD01AJ03.getText());
							}
							// 1.11.1.1.13 到期日期 PD01AR02 -- [0..1]
							Node PD01AR02 = pd01aNode.selectSingleNode("PD01AR02");
							if (PD01AR02 != null) {
								pd01a.setPD01AR02(PD01AR02.getText());
							}
							// 1.11.1.1.14 还款方式 PD01AD05 -- [0..1]
							Node PD01AD05 = pd01aNode.selectSingleNode("PD01AD05");
							if (PD01AD05 != null) {
								pd01a.setPD01AD05(PD01AD05.getText());
							}
							// 1.11.1.1.15 还款频率 PD01AD06 -- [0..1]
							Node PD01AD06 = pd01aNode.selectSingleNode("PD01AD06");
							if (PD01AD06 != null) {
								pd01a.setPD01AD06(PD01AD06.getText());
							}
							// 1.11.1.1.16 还款期数 PD01AS01 -- [0..1]
							Node PD01AS01 = pd01aNode.selectSingleNode("PD01AS01");
							if (PD01AS01 != null) {
								pd01a.setPD01AS01(PD01AS01.getText());
							}
							// 1.11.1.1.17 担保方式 PD01AD07 -- [0..1]
							Node PD01AD07 = pd01aNode.selectSingleNode("PD01AD07");
							if (PD01AD07 != null) {
								pd01a.setPD01AD07(PD01AD07.getText());
							}
							// 1.11.1.1.18 贷款发放形式 PD01AD08 -- [0..1]
							Node PD01AD08 = pd01aNode.selectSingleNode("PD01AD08");
							if (PD01AD08 != null) {
								pd01a.setPD01AD08(PD01AD08.getText());
							}
							// 1.11.1.1.19 共同借款标志 PD01AD09 -- [0..1]
							Node PD01AD09 = pd01aNode.selectSingleNode("PD01AD09");
							if (PD01AD09 != null) {
								pd01a.setPD01AD09(PD01AD09.getText());
							}
							// 1.11.1.1.20 债权转移时的还款状态 PD01AD10 -- [0..1]
							Node PD01AD10 = pd01aNode.selectSingleNode("PD01AD10");
							if (PD01AD10 != null) {
								pd01a.setPD01AD10(PD01AD10.getText());
							}
							pd01.setPD01A(pd01a);
						}
						// 1.11.1.2 最新表现信息段 PD01B [1..1]
						Node pd01bNode = pd01Node.selectSingleNode("PD01B");
						if (pd01bNode != null) {
							PD01B pd01b = new PD01B();
							pd01b.setIdentityCardNo(identityCardNo);
							pd01b.setUniqueRelid(uniqueRelid);
							pd01b.setRelateId(relateId);
							// 1.11.1.2.1 账户状态 PD01BD01 -- [1..1]
							Node PD01BD01 = pd01bNode.selectSingleNode("PD01BD01");
							if (PD01BD01 != null) {
								pd01b.setPD01BD01(PD01BD01.getText());
							}
							// 1.11.1.2.2 关闭日期 PD01BR01 -- [1..1]
							Node PD01BR01 = pd01bNode.selectSingleNode("PD01BR01");
							if (PD01BR01 != null) {
								pd01b.setPD01BR01(PD01BR01.getText());
							}
							// 1.11.1.2.3 转出月份 PD01BR04 -- [0..1]
							Node PD01BR04 = pd01bNode.selectSingleNode("PD01BR04");
							if (PD01BR04 != null) {
								pd01b.setPD01BR04(PD01BR04.getText());
							}
							// 1.11.1.2.4 余额 PD01BJ01 -- [1..1]
							Node PD01BJ01 = pd01bNode.selectSingleNode("PD01BJ01");
							if (PD01BJ01 != null) {
								pd01b.setPD01BJ01(PD01BJ01.getText());
							}
							// 1.11.1.2.5 最近一次还款日期 PD01BR02 -- [1..1]
							Node PD01BR02 = pd01bNode.selectSingleNode("PD01BR02");
							if (PD01BR02 != null) {
								pd01b.setPD01BR02(PD01BR02.getText());
							}
							// 1.11.1.2.6 最近一次还款金额 PD01BJ02 -- [0..1]
							Node PD01BJ02 = pd01bNode.selectSingleNode("PD01BJ02");
							if (PD01BJ02 != null) {
								pd01b.setPD01BJ02(PD01BJ02.getText());
							}
							// 1.11.1.2.7 五级分类 PD01BD03 -- [0..1]
							Node PD01BD03 = pd01bNode.selectSingleNode("PD01BD03");
							if (PD01BD03 != null) {
								pd01b.setPD01BD03(PD01BD03.getText());
							}
							// 1.11.1.2.8 还款状态 PD01BD04 -- [0..1]
							Node PD01BD04 = pd01bNode.selectSingleNode("PD01BD04");
							if (PD01BD04 != null) {
								pd01b.setPD01BD04(PD01BD04.getText());
							}
							// 1.11.1.2.9 信息报告日期 PD01BR03 -- [1..1]
							Node PD01BR03 = pd01bNode.selectSingleNode("PD01BR03");
							if (PD01BR03 != null) {
								pd01b.setPD01BR03(PD01BR03.getText());
							}
							pd01.setPD01B(pd01b);
						}
						// 1.11.1.3 最近一次月度表现信息段 PD01C [0..1]
						Node pd01cNode = pd01Node.selectSingleNode("PD01C");
						if (pd01cNode != null) {
							PD01C pd01c = new PD01C();
							pd01c.setIdentityCardNo(identityCardNo);
							pd01c.setUniqueRelid(uniqueRelid);
							pd01c.setRelateId(relateId);
							// 1.11.1.3.1 月份 PD01CR01 -- [1..1]
							Node PD01CR01 = pd01cNode.selectSingleNode("PD01CR01");
							if (PD01CR01 != null) {
								pd01c.setPD01CR01(PD01CR01.getText());
							}
							// 1.11.1.3.2 账户状态 PD01CD01 -- [1..1]
							Node PD01CD01 = pd01cNode.selectSingleNode("PD01CD01");
							if (PD01CD01 != null) {
								pd01c.setPD01CD01(PD01CD01.getText());
							}
							// 1.11.1.3.3 余额 PD01CJ01 -- [1..1]
							Node PD01CJ01 = pd01cNode.selectSingleNode("PD01CJ01");
							if (PD01CJ01 != null) {
								pd01c.setPD01CJ01(PD01CJ01.getText());
							}
							// 1.11.1.3.4 已用额度 PD01CJ02 -- [0..1]
							Node PD01CJ02 = pd01cNode.selectSingleNode("PD01CJ02");
							if (PD01CJ02 != null) {
								pd01c.setPD01CJ02(PD01CJ02.getText());
							}
							// 1.11.1.3.5 未出单的大额专项分期余额 PD01CJ03 -- [0..1]
							Node PD01CJ03 = pd01cNode.selectSingleNode("PD01CJ03");
							if (PD01CJ03 != null) {
								pd01c.setPD01CJ03(PD01CJ03.getText());
							}
							// 1.11.1.3.6 五级分类 PD01CD02 -- [0..1]
							Node PD01CD02 = pd01cNode.selectSingleNode("PD01CD02");
							if (PD01CD02 != null) {
								pd01c.setPD01CD02(PD01CD02.getText());
							}
							// 1.11.1.3.7 剩余还款期数 PD01CS01 -- [0..1]
							Node PD01CS01 = pd01cNode.selectSingleNode("PD01CS01");
							if (PD01CS01 != null) {
								pd01c.setPD01CS01(PD01CS01.getText());
							}
							// 1.11.1.3.8 结算/应还款日 PD01CR02 -- [1..1]
							Node PD01CR02 = pd01cNode.selectSingleNode("PD01CR02");
							if (PD01CR02 != null) {
								pd01c.setPD01CR02(PD01CR02.getText());
							}
							// 1.11.1.3.9 本月应还款 PD01CJ04 -- [0..1]
							Node PD01CJ04 = pd01cNode.selectSingleNode("PD01CJ04");
							if (PD01CJ04 != null) {
								pd01c.setPD01CJ04(PD01CJ04.getText());
							}
							// 1.11.1.3.10 本月实还款 PD01CJ05 -- [1..1]
							Node PD01CJ05 = pd01cNode.selectSingleNode("PD01CJ05");
							if (PD01CJ05 != null) {
								pd01c.setPD01CJ05(PD01CJ05.getText());
							}
							// 1.11.1.3.11 最近一次还款日期 PD01CR03 -- [1..1]
							Node PD01CR03 = pd01cNode.selectSingleNode("PD01CR03");
							if (PD01CR03 != null) {
								pd01c.setPD01CR03(PD01CR03.getText());
							}
							// 1.11.1.3.12 当前逾期期数 PD01CS02 -- [0..1]
							Node PD01CS02 = pd01cNode.selectSingleNode("PD01CS02");
							if (PD01CS02 != null) {
								pd01c.setPD01CS02(PD01CS02.getText());
							}
							// 1.11.1.3.13 当前逾期总额 PD01CJ06 -- [0..1]
							Node PD01CJ06 = pd01cNode.selectSingleNode("PD01CJ06");
							if (PD01CJ06 != null) {
								pd01c.setPD01CJ06(PD01CJ06.getText());
							}
							// 1.11.1.3.14 逾期31—60天未还本金 PD01CJ07 -- [0..1]
							Node PD01CJ07 = pd01cNode.selectSingleNode("PD01CJ07");
							if (PD01CJ07 != null) {
								pd01c.setPD01CJ07(PD01CJ07.getText());
							}
							// 1.11.1.3.15 逾期61－90天未还本金 PD01CJ08 -- [0..1]
							Node PD01CJ08 = pd01cNode.selectSingleNode("PD01CJ08");
							if (PD01CJ08 != null) {
								pd01c.setPD01CJ08(PD01CJ08.getText());
							}
							// 1.11.1.3.16 逾期91－180天未还本金 PD01CJ09 -- [0..1]
							Node PD01CJ09 = pd01cNode.selectSingleNode("PD01CJ09");
							if (PD01CJ09 != null) {
								pd01c.setPD01CJ09(PD01CJ09.getText());
							}
							// 1.11.1.3.17 逾期180天以上未还本金 PD01CJ10 -- [0..1]
							Node PD01CJ10 = pd01cNode.selectSingleNode("PD01CJ10");
							if (PD01CJ10 != null) {
								pd01c.setPD01CJ10(PD01CJ10.getText());
							}
							// 1.11.1.3.18 透支180天以上未付余额 PD01CJ11 -- [0..1]
							Node PD01CJ11 = pd01cNode.selectSingleNode("PD01CJ11");
							if (PD01CJ11 != null) {
								pd01c.setPD01CJ11(PD01CJ11.getText());
							}
							// 1.11.1.3.19 最近6个月平均使用额度 PD01CJ12 -- [0..1]
							Node PD01CJ12 = pd01cNode.selectSingleNode("PD01CJ12");
							if (PD01CJ12 != null) {
								pd01c.setPD01CJ12(PD01CJ12.getText());
							}
							// 1.11.1.3.20 最近6个月平均透支余额 PD01CJ13 -- [0..1]
							Node PD01CJ13 = pd01cNode.selectSingleNode("PD01CJ13");
							if (PD01CJ13 != null) {
								pd01c.setPD01CJ13(PD01CJ13.getText());
							}
							// 1.11.1.3.21 最大使用额度 PD01CJ14 -- [0..1]
							Node PD01CJ14 = pd01cNode.selectSingleNode("PD01CJ14");
							if (PD01CJ14 != null) {
								pd01c.setPD01CJ14(PD01CJ14.getText());
							}
							// 1.11.1.3.22 最大透支余额 PD01CJ15 -- [0..1]
							Node PD01CJ15 = pd01cNode.selectSingleNode("PD01CJ15");
							if (PD01CJ15 != null) {
								pd01c.setPD01CJ15(PD01CJ15.getText());
							}
							// 1.11.1.3.23 信息报告日期 PD01CR04 -- [1..1]
							Node PD01CR04 = pd01cNode.selectSingleNode("PD01CR04");
							if (PD01CR04 != null) {
								pd01c.setPD01CR04(PD01CR04.getText());
							}
							pd01.setPD01C(pd01c);
						}
						// 1.11.1.4 最近24个月还款记录信息段 PD01D [0..1]
						Node pd01dNode = pd01Node.selectSingleNode("PD01D");
						if (pd01dNode != null) {
							PD01D pd01d = new PD01D();
							PD01Ddata pd01dData = new PD01Ddata();
							pd01dData.setIdentityCardNo(identityCardNo);
							pd01dData.setUniqueRelid(uniqueRelid);
							pd01dData.setRelateId(relateId);
							// 1.11.1.4.1 起始年月 PD01DR01 -- [1..1]
							Node PD01DR01 = pd01dNode.selectSingleNode("PD01DR01");
							if (PD01DR01 != null) {
								pd01dData.setPD01DR01(PD01DR01.getText());
							}
							// 1.11.1.4.2 截止年月 PD01DR02 -- [1..1]
							Node PD01DR02 = pd01dNode.selectSingleNode("PD01DR02");
							if (PD01DR02 != null) {
								pd01dData.setPD01DR02(PD01DR02.getText());
							}
							pd01d.setPD01Ddata(pd01dData);

							// 1.11.1.4.3 还款状态信息 PD01DH [1..24]
							List<Element> pd01dhNodeList = pd01dNode.selectNodes("PD01DH");
							if (pd01dhNodeList != null && pd01dhNodeList.size() > 0) {
								List<PD01DH> pd01dhList = new ArrayList<PD01DH>();
								for (int j = 0; j < pd01dhNodeList.size(); j++) {
									Element pd01dhNode = pd01dhNodeList.get(j);
									if (pd01dhNode == null) {
										continue;
									}
									PD01DH pd01dh = new PD01DH();
									pd01dh.setIdentityCardNo(identityCardNo);
									pd01dh.setUniqueRelid(uniqueRelid);
									pd01dh.setRelateId(relateId);
									// 1.11.1.4.3.1 月份 PD01DR03 -- [1..1]
									Node PD01DR03 = pd01dhNode.selectSingleNode("PD01DR03");
									if (PD01DR03 != null) {
										pd01dh.setPD01DR03(PD01DR03.getText());
									}
									// 1.11.1.4.3.2 还款状态 PD01DD01 -- [1..1]
									Node PD01DD01 = pd01dhNode.selectSingleNode("PD01DD01");
									if (PD01DD01 != null) {
										pd01dh.setPD01DD01(PD01DD01.getText());
									}
									pd01dhList.add(pd01dh);
								}
								pd01d.setPD01DHList(pd01dhList);
							}
							pd01.setPD01D(pd01d);
						}
						// 1.11.1.5 最近5年内历史表现信息段 PD01E [0..1]
						Node pd01eNode = pd01Node.selectSingleNode("PD01E");
						if (pd01eNode != null) {
							PD01E pd01e = new PD01E();
							PD01Edata pd01eData = new PD01Edata();
							pd01eData.setIdentityCardNo(identityCardNo);
							pd01eData.setUniqueRelid(uniqueRelid);
							pd01eData.setRelateId(relateId);
							// 1.11.1.5.1 起始年月 PD01ER01 -- [1..1]
							Node PD01ER01 = pd01eNode.selectSingleNode("PD01ER01");
							if (PD01ER01 != null) {
								pd01eData.setPD01ER01(PD01ER01.getText());
							}
							// 1.11.1.5.2 截止年月 PD01ER02 -- [1..1]
							Node PD01ER02 = pd01eNode.selectSingleNode("PD01ER02");
							if (PD01ER02 != null) {
								pd01eData.setPD01ER02(PD01ER02.getText());
							}
							// 1.11.1.5.3 月数 PD01ES01 -- [1..1]
							Node PD01ES01 = pd01eNode.selectSingleNode("PD01ES01");
							if (PD01ES01 != null) {
								pd01eData.setPD01ES01(PD01ES01.getText());
							}
							pd01e.setPD01Edata(pd01eData);
							// 1.11.1.5.4 历史表现信息 PD01EH [1..60]
							List<Element> pd01ehNodeList = pd01eNode.selectNodes("PD01EH");
							if (pd01ehNodeList != null && pd01ehNodeList.size() > 0) {
								List<PD01EH> pd01ehList = new ArrayList<PD01EH>();
								for (int j = 0; j < pd01ehNodeList.size(); j++) {
									Element pd01ehNode = pd01ehNodeList.get(j);
									if (pd01ehNode == null) {
										continue;
									}
									PD01EH pd01eh = new PD01EH();
									pd01eh.setIdentityCardNo(identityCardNo);
									pd01eh.setUniqueRelid(uniqueRelid);
									pd01eh.setRelateId(relateId);
									// 1.11.1.5.4.1 月份 PD01ER03 -- [1..1]
									Node PD01ER03 = pd01ehNode.selectSingleNode("PD01ER03");
									if (PD01ER03 != null) {
										pd01eh.setPD01ER03(PD01ER03.getText());
									}
									// 1.11.1.5.4.2 还款状态 PD01ED01 -- [1..1]
									Node PD01ED01 = pd01ehNode.selectSingleNode("PD01ED01");
									if (PD01ED01 != null) {
										pd01eh.setPD01ED01(PD01ED01.getText());
									}
									// 1.11.1.5.4.3 逾期（透支）总额 PD01EJ01 -- [1..1]
									Node PD01EJ01 = pd01ehNode.selectSingleNode("PD01EJ01");
									if (PD01EJ01 != null) {
										pd01eh.setPD01EJ01(PD01EJ01.getText());
									}
									pd01ehList.add(pd01eh);
								}
								pd01e.setPD01EHList(pd01ehList);
							}
							pd01.setPD01E(pd01e);
						}
						// 1.11.1.6 特殊交易信息段 PD01F [0..1]
						Node pd01fNode = pd01Node.selectSingleNode("PD01F");
						if (pd01fNode != null) {
							PD01F pd01f = new PD01F();
							PD01Fdata pd01fData = new PD01Fdata();
							pd01fData.setIdentityCardNo(identityCardNo);
							pd01fData.setUniqueRelid(uniqueRelid);
							pd01fData.setRelateId(relateId);
							// 1.11.1.6.1 特殊交易个数 PD01FS01 -- [1..1]
							Node PD01FS01 = pd01fNode.selectSingleNode("PD01FS01");
							if (PD01FS01 != null) {
								pd01fData.setPD01FS01(PD01FS01.getText());
							}
							pd01f.setPD01Fdata(pd01fData);
							// 1.11.1.6.2 特殊交易信息 PD01FH [1..99]
							List<Element> pd01fhNodeList = pd01fNode.selectNodes("PD01FH");
							if (pd01fhNodeList != null && pd01fhNodeList.size() > 0) {
								List<PD01FH> pd01fhList = new ArrayList<PD01FH>();
								for (int j = 0; j < pd01fhNodeList.size(); j++) {
									Element pd01fhNode = pd01fhNodeList.get(j);
									if (pd01fhNode == null) {
										continue;
									}
									PD01FH pd01fh = new PD01FH();
									pd01fh.setIdentityCardNo(identityCardNo);
									pd01fh.setUniqueRelid(uniqueRelid);
									pd01fh.setRelateId(relateId);
									// 1.11.1.6.2.1 特殊交易类型 PD01FD01 -- [1..1]
									Node PD01FD01 = pd01fhNode.selectSingleNode("PD01FD01");
									if (PD01FD01 != null) {
										pd01fh.setPD01FD01(PD01FD01.getText());
									}
									// 1.11.1.6.2.2 特殊交易发生日期 PD01FR01 -- [1..1]
									Node PD01FR01 = pd01fhNode.selectSingleNode("PD01FR01");
									if (PD01FR01 != null) {
										pd01fh.setPD01FR01(PD01FR01.getText());
									}
									// 1.11.1.6.2.3 到期日期变更月数 PD01FS02 -- [1..1]
									Node PD01FS02 = pd01fhNode.selectSingleNode("PD01FS02");
									if (PD01FS02 != null) {
										pd01fh.setPD01FS02(PD01FS02.getText());
									}
									// 1.11.1.6.2.4 特殊交易发生金额 PD01FJ01 -- [1..1]
									Node PD01FJ01 = pd01fhNode.selectSingleNode("PD01FJ01");
									if (PD01FJ01 != null) {
										pd01fh.setPD01FJ01(PD01FJ01.getText());
									}
									// 1.11.1.6.2.5 特殊交易明细记录 PD01FQ01 -- [1..1]
									Node PD01FQ01 = pd01fhNode.selectSingleNode("PD01FQ01");
									if (PD01FQ01 != null) {
										pd01fh.setPD01FQ01(PD01FQ01.getText());
									}
									pd01fhList.add(pd01fh);
								}
								pd01f.setPD01FHList(pd01fhList);
							}
							pd01.setPD01F(pd01f);
						}
						// 1.11.1.7 特殊事件说明信息段 PD01G [0..1]
						Node pd01gNode = pd01Node.selectSingleNode("PD01G");
						if (pd01gNode != null) {
							PD01G pd01g = new PD01G();
							PD01Gdata pd01gData = new PD01Gdata();
							pd01gData.setIdentityCardNo(identityCardNo);
							pd01gData.setUniqueRelid(uniqueRelid);
							pd01gData.setRelateId(relateId);
							// 1.11.1.7.1 特殊事件说明个数 PD01GS01 -- [1..1]
							Node PD01GS01 = pd01gNode.selectSingleNode("PD01GS01");
							if (PD01GS01 != null) {
								pd01gData.setPD01GS01(PD01GS01.getText());
							}
							pd01g.setPD01Gdata(pd01gData);
							// 1.11.1.7.2 特殊事件说明信息 PD01GH [1..99]
							List<Element> pd01ghNodeList = pd01gNode.selectNodes("PD01GH");
							if (pd01ghNodeList != null && pd01ghNodeList.size() > 0) {
								List<PD01GH> pd01ghList = new ArrayList<PD01GH>();
								for (int j = 0; j < pd01ghNodeList.size(); j++) {
									Element pd01ghNode = pd01ghNodeList.get(j);
									if (pd01ghNode == null) {
										continue;
									}
									PD01GH pd01gh = new PD01GH();
									pd01gh.setIdentityCardNo(identityCardNo);
									pd01gh.setUniqueRelid(uniqueRelid);
									pd01gh.setRelateId(relateId);
									// 1.11.1.7.2.1 特殊事件发生月份 PD01GR01 -- [1..1]
									Node PD01GR01 = pd01ghNode.selectSingleNode("PD01GR01");
									if (PD01GR01 != null) {
										pd01gh.setPD01GR01(PD01GR01.getText());
									}
									// 1.11.1.7.2.2 特殊事件类型 PD01GD01 -- [1..1]
									Node PD01GD01 = pd01ghNode.selectSingleNode("PD01GD01");
									if (PD01GD01 != null) {
										pd01gh.setPD01GD01(PD01GD01.getText());
									}
									pd01ghList.add(pd01gh);
								}
								pd01g.setPD01GHList(pd01ghList);
							}
							pd01.setPD01G(pd01g);
						}
						// 1.11.1.8 大额专项分期信息段 PD01H [0..1]
						Node pd01hNode = pd01Node.selectSingleNode("PD01H");
						if (pd01hNode != null) {
							PD01H pd01h = new PD01H();
							PD01Hdata pd01hData = new PD01Hdata();
							pd01hData.setIdentityCardNo(identityCardNo);
							pd01hData.setUniqueRelid(uniqueRelid);
							pd01hData.setRelateId(relateId);
							// 1.11.1.8.1 大额专项分期笔数 PD01HS01 -- [1..1]
							Node PD01HS01 = pd01hNode.selectSingleNode("PD01HS01");
							if (PD01HS01 != null) {
								pd01hData.setPD01HS01(PD01HS01.getText());
							}
							pd01h.setPD01Hdata(pd01hData);
							// 1.11.1.8.2 大额专项分期信息 PD01HH [1..99]
							List<Element> pd01hhNodeList = pd01hNode.selectNodes("PD01HH");
							if (pd01hhNodeList != null && pd01hhNodeList.size() > 0) {
								List<PD01HH> pd01hhList = new ArrayList<PD01HH>();
								for (int j = 0; j < pd01hhNodeList.size(); j++) {
									Element pd01hhNode = pd01hhNodeList.get(j);
									if (pd01hhNode == null) {
										continue;
									}
									PD01HH pd01hh = new PD01HH();
									pd01hh.setIdentityCardNo(identityCardNo);
									pd01hh.setUniqueRelid(uniqueRelid);
									pd01hh.setRelateId(relateId);
									// 1.11.1.8.2.1 大额专项分期额度 PD01HJ01 -- [1..1]
									Node PD01HJ01 = pd01hhNode.selectSingleNode("PD01HJ01");
									if (PD01HJ01 != null) {
										pd01hh.setPD01HJ01(PD01HJ01.getText());
									}
									// 1.11.1.8.2.2 分期额度生效日期 PD01HR01 -- [1..1]
									Node PD01HR01 = pd01hhNode.selectSingleNode("PD01HR01");
									if (PD01HR01 != null) {
										pd01hh.setPD01HR01(PD01HR01.getText());
									}
									// 1.11.1.8.2.3 分期额度到期日期 PD01HR02 -- [1..1]
									Node PD01HR02 = pd01hhNode.selectSingleNode("PD01HR02");
									if (PD01HR02 != null) {
										pd01hh.setPD01HR02(PD01HR02.getText());
									}
									// 1.11.1.8.2.4 已用分期金额 PD01HJ02 -- [1..1]
									Node PD01HJ02 = pd01hhNode.selectSingleNode("PD01HJ02");
									if (PD01HJ02 != null) {
										pd01hh.setPD01HJ02(PD01HJ02.getText());
									}
									pd01hhList.add(pd01hh);
								}
								pd01h.setPD01HHList(pd01hhList);
							}
							pd01.setPD01H(pd01h);
						}
						// 1.11.1.9 标注及声明信息段 PD01Z [0..1]
						Node pd01zNode = pd01Node.selectSingleNode("PD01Z");
						if (pd01zNode != null) {
							PD01Z pd01z = new PD01Z();
							PD01Zdata pd01zData = new PD01Zdata();
							pd01zData.setIdentityCardNo(identityCardNo);
							pd01zData.setUniqueRelid(uniqueRelid);
							pd01zData.setRelateId(relateId);
							// 1.11.1.9.1 标注及声明个数 PD01ZS01 -- [1..1]
							Node PD01ZS01 = pd01zNode.selectSingleNode("PD01ZS01");
							if (PD01ZS01 != null) {
								pd01zData.setPD01ZS01(PD01ZS01.getText());
							}
							pd01z.setPD01Zdata(pd01zData);
							// 1.11.1.9.2 标注及声明信息 PD01ZH [1..5]
							List<Element> pd01zhNodeList = pd01zNode.selectNodes("PD01ZH");
							if (pd01zhNodeList != null && pd01zhNodeList.size() > 0) {
								List<PD01ZH> pd01zhList = new ArrayList<PD01ZH>();
								for (int j = 0; j < pd01zhNodeList.size(); j++) {
									Element pd01zhNode = pd01zhNodeList.get(j);
									if (pd01zhNode == null) {
										continue;
									}
									PD01ZH pd01zh = new PD01ZH();
									pd01zh.setIdentityCardNo(identityCardNo);
									pd01zh.setUniqueRelid(uniqueRelid);
									pd01zh.setRelateId(relateId);
									// 1.11.1.9.2.1 标注及声明类型 PD01ZD01 -- [1..1]
									Node PD01ZD01 = pd01zhNode.selectSingleNode("PD01ZD01");
									if (PD01ZD01 != null) {
										pd01zh.setPD01ZD01(PD01ZD01.getText());
									}
									// 1.11.1.9.2.2 标注或声明内容 PD01ZQ01 -- [1..1]
									Node PD01ZQ01 = pd01zhNode.selectSingleNode("PD01ZQ01");
									if (PD01ZQ01 != null) {
										pd01zh.setPD01ZQ01(PD01ZQ01.getText());
									}
									// 1.11.1.9.2.3 添加日期 PD01ZR01 -- [1..1]
									Node PD01ZR01 = pd01zhNode.selectSingleNode("PD01ZR01");
									if (PD01ZR01 != null) {
										pd01zh.setPD01ZR01(PD01ZR01.getText());
									}
									pd01zhList.add(pd01zh);
								}
								pd01z.setPD01ZHList(pd01zhList);
							}
							pd01.setPD01Z(pd01z);
						}
						pd01List.add(pd01);
					}
					pda.setPD01List(pd01List);
				}
				bank.setPDA(pda);
			}
			// 1.12 授信协议信息 PCA [1..1]
			Node pcaNode = rootNode.selectSingleNode("PCA");
			if (pcaNode != null) {
				PCA pca = new PCA();
				// 1.12.1 授信协议信息单元 PD02 [0..*]
				List<Element> pd02NodeList = pcaNode.selectNodes("PD02");
				if (pd02NodeList != null && pd02NodeList.size() > 0) {
					List<PD02> pd02List = new ArrayList<PD02>();
					for (int i = 0; i < pd02NodeList.size(); i++) {
						Element pd02Node = pd02NodeList.get(i);
						if (pd02Node == null) {
							continue;
						}
						PD02 pd02 = new PD02();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.12.1.1 基本信息段 PD02A [1..1]
						Node pd02aNode = pd02Node.selectSingleNode("PD02A");
						if (pd02aNode != null) {
							PD02A pd02a = new PD02A();
							pd02a.setIdentityCardNo(identityCardNo);
							pd02a.setUniqueRelid(uniqueRelid);
							pd02a.setRelateId(relateId);
							// 1.12.1.1.1 授信协议编号 PD02AI01 -- [1..1]
							Node PD02AI01 = pd02aNode.selectSingleNode("PD02AI01");
							if (PD02AI01 != null) {
								pd02a.setPD02AI01(PD02AI01.getText());
							}
							// 1.12.1.1.2 业务管理机构类型 PD02AD01 -- [1..1]
							Node PD02AD01 = pd02aNode.selectSingleNode("PD02AD01");
							if (PD02AD01 != null) {
								pd02a.setPD02AD01(PD02AD01.getText());
							}
							// 1.12.1.1.3 业务管理机构 PD02AI02 -- [1..1]
							Node PD02AI02 = pd02aNode.selectSingleNode("PD02AI02");
							if (PD02AI02 != null) {
								pd02a.setPD02AI02(PD02AI02.getText());
							}
							// 1.12.1.1.4 授信协议标识 PD02AI03 -- [1..1]
							Node PD02AI03 = pd02aNode.selectSingleNode("PD02AI03");
							if (PD02AI03 != null) {
								pd02a.setPD02AI03(PD02AI03.getText());
							}
							// 1.12.1.1.5 授信额度用途 PD02AD02 -- [1..1]
							Node PD02AD02 = pd02aNode.selectSingleNode("PD02AD02");
							if (PD02AD02 != null) {
								pd02a.setPD02AD02(PD02AD02.getText());
							}
							// 1.12.1.1.6 授信额度 PD02AJ01 -- [1..1]
							Node PD02AJ01 = pd02aNode.selectSingleNode("PD02AJ01");
							if (PD02AJ01 != null) {
								pd02a.setPD02AJ01(PD02AJ01.getText());
							}
							// 1.12.1.1.7 币种 PD02AD03 -- [1..1]
							Node PD02AD03 = pd02aNode.selectSingleNode("PD02AD03");
							if (PD02AD03 != null) {
								pd02a.setPD02AD03(PD02AD03.getText());
							}
							// 1.12.1.1.8 生效日期 PD02AR01 -- [1..1]
							Node PD02AR01 = pd02aNode.selectSingleNode("PD02AR01");
							if (PD02AR01 != null) {
								pd02a.setPD02AR01(PD02AR01.getText());
							}
							// 1.12.1.1.9 到期日期 PD02AR02 -- [1..1]
							Node PD02AR02 = pd02aNode.selectSingleNode("PD02AR02");
							if (PD02AR02 != null) {
								pd02a.setPD02AR02(PD02AR02.getText());
							}
							// 1.12.1.1.10 授信协议状态 PD02AD04 -- [1..1]
							Node PD02AD04 = pd02aNode.selectSingleNode("PD02AD04");
							if (PD02AD04 != null) {
								pd02a.setPD02AD04(PD02AD04.getText());
							}
							// 1.12.1.1.11 已用额度 PD02AJ04 -- [1..1]
							Node PD02AJ04 = pd02aNode.selectSingleNode("PD02AJ04");
							if (PD02AJ04 != null) {
								pd02a.setPD02AJ04(PD02AJ04.getText());
							}
							// 1.12.1.1.12 授信限额 PD02AJ03 -- [1..1]
							Node PD02AJ03 = pd02aNode.selectSingleNode("PD02AJ03");
							if (PD02AJ03 != null) {
								pd02a.setPD02AJ03(PD02AJ03.getText());
							}
							// 1.12.1.1.13 授信限额编号 PD02AI04 -- [0..1]
							Node PD02AI04 = pd02aNode.selectSingleNode("PD02AI04");
							if (PD02AI04 != null) {
								pd02a.setPD02AI04(PD02AI04.getText());
							}
							pd02.setPD02A(pd02a);
						}
						// 1.12.1.2 标注及声明信息段 PD02Z [0..1]
						Node pd02zNode = pd02Node.selectSingleNode("PD02Z");
						if (pd02zNode != null) {
							PD02Z pd02z = new PD02Z();
							PD02Zdata pd02zData = new PD02Zdata();
							pd02zData.setIdentityCardNo(identityCardNo);
							pd02zData.setUniqueRelid(uniqueRelid);
							pd02zData.setRelateId(relateId);
							// 1.12.1.2.1 标注及声明个数 PD02ZS01 -- [1..1]
							Node PD02ZS01 = pd02zNode.selectSingleNode("PD02ZS01");
							if (PD02ZS01 != null) {
								pd02zData.setPD02ZS01(PD02ZS01.getText());
							}
							pd02z.setPD02Zdata(pd02zData);
							// 1.12.1.2.2 标注及声明信息 PD02ZH [1..5]
							List<Element> pd02zhNodeList = pd02zNode.selectNodes("PD02ZH");
							if (pd02zhNodeList != null && pd02zhNodeList.size() > 0) {
								List<PD02ZH> pd02zhList = new ArrayList<PD02ZH>();
								for (int j = 0; j < pd02zhNodeList.size(); j++) {
									Element pd02zhNode = pd02zhNodeList.get(j);
									if (pd02zhNode == null) {
										continue;
									}
									PD02ZH pd02zh = new PD02ZH();
									pd02zh.setIdentityCardNo(identityCardNo);
									pd02zh.setUniqueRelid(uniqueRelid);
									pd02zh.setRelateId(relateId);
									// 1.12.1.2.2.1 标注及声明类型 PD02ZD01 -- [1..1]
									Node PD02ZD01 = pd02zhNode.selectSingleNode("PD02ZD01");
									if (PD02ZD01 != null) {
										pd02zh.setPD02ZD01(PD02ZD01.getText());
									}
									// 1.12.1.2.2.2 标注或声明内容 PD02ZQ01 -- [1..1]
									Node PD02ZQ01 = pd02zhNode.selectSingleNode("PD02ZQ01");
									if (PD02ZQ01 != null) {
										pd02zh.setPD02ZQ01(PD02ZQ01.getText());
									}
									// 1.12.1.2.2.3 添加日期 PD02ZR01 -- [1..1]
									Node PD02ZR01 = pd02zhNode.selectSingleNode("PD02ZR01");
									if (PD02ZR01 != null) {
										pd02zh.setPD02ZR01(PD02ZR01.getText());
									}
									pd02zhList.add(pd02zh);
								}
								pd02z.setPD02ZHList(pd02zhList);
							}
							pd02.setPD02Z(pd02z);
						}
						pd02List.add(pd02);
					}
					pca.setPD02List(pd02List);
				}
				bank.setPCA(pca);
			}
			// 1.13 相关还款责任信息 PCR [1..1]
			Node pcrNode = rootNode.selectSingleNode("PCR");
			if (pcrNode != null) {
				PCR pcr = new PCR();
				// 1.13.1 相关还款责任信息单元 PD03 [0..*]
				List<Element> pcrNodeList = pcrNode.selectNodes("PD03");
				if (pcrNodeList != null && pcrNodeList.size() > 0) {
					List<PD03> pd03NodeList = new ArrayList<PD03>();
					for (int i = 0; i < pcrNodeList.size(); i++) {
						Element pd03Node = pcrNodeList.get(i);
						if (pd03Node == null) {
							continue;
						}
						PD03 pd03 = new PD03();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.13.1.1 相关还款责任信息段 PD03A [1..1]
						Node pd03aNode = pd03Node.selectSingleNode("PD03A");
						if (pd03aNode != null) {
							PD03A pd03a = new PD03A();
							pd03a.setIdentityCardNo(identityCardNo);
							pd03a.setUniqueRelid(uniqueRelid);
							pd03a.setRelateId(relateId);
							// 1.13.1.1.1 主借款人身份类别 PD03AD08 -- [1..1]
							Node PD03AD08 = pd03aNode.selectSingleNode("PD03AD08");
							if (PD03AD08 != null) {
								pd03a.setPD03AD08(PD03AD08.getText());
							}
							// 1.13.1.1.2 业务管理机构类型 PD03AD01 -- [1..1]
							Node PD03AD01 = pd03aNode.selectSingleNode("PD03AD01");
							if (PD03AD01 != null) {
								pd03a.setPD03AD01(PD03AD01.getText());
							}
							// 1.13.1.1.3 业务管理机构 PD03AQ01 -- [1..1]
							Node PD03AQ01 = pd03aNode.selectSingleNode("PD03AQ01");
							if (PD03AQ01 != null) {
								pd03a.setPD03AQ01(PD03AQ01.getText());
							}
							// 1.13.1.1.4 业务种类 PD03AD02 -- [1..1]
							Node PD03AD02 = pd03aNode.selectSingleNode("PD03AD02");
							if (PD03AD02 != null) {
								pd03a.setPD03AD02(PD03AD02.getText());
							}
							// 1.13.1.1.5 开立日期 PD03AR01 -- [1..1]
							Node PD03AR01 = pd03aNode.selectSingleNode("PD03AR01");
							if (PD03AR01 != null) {
								pd03a.setPD03AR01(PD03AR01.getText());
							}
							// 1.13.1.1.6 到期日 PD03AR02 -- [1..1]
							Node PD03AR02 = pd03aNode.selectSingleNode("PD03AR02");
							if (PD03AR02 != null) {
								pd03a.setPD03AR02(PD03AR02.getText());
							}
							// 1.13.1.1.7 相关还款责任人类型 PD03AD03 -- [1..1]
							Node PD03AD03 = pd03aNode.selectSingleNode("PD03AD03");
							if (PD03AD03 != null) {
								pd03a.setPD03AD03(PD03AD03.getText());
							}
							// 1.13.1.1.8 保证合同编号 PD03AQ02 -- [1..1]
							Node PD03AQ02 = pd03aNode.selectSingleNode("PD03AQ02");
							if (PD03AQ02 != null) {
								pd03a.setPD03AQ02(PD03AQ02.getText());
							}
							// 1.13.1.1.9 相关还款责任金额 PD03AJ01 -- [1..1]
							Node PD03AJ01 = pd03aNode.selectSingleNode("PD03AJ01");
							if (PD03AJ01 != null) {
								pd03a.setPD03AJ01(PD03AJ01.getText());
							}
							// 1.13.1.1.10 币种 PD03AD04 -- [1..1]
							Node PD03AD04 = pd03aNode.selectSingleNode("PD03AD04");
							if (PD03AD04 != null) {
								pd03a.setPD03AD04(PD03AD04.getText());
							}
							// 1.13.1.1.11 余额 PD03AJ02 -- [1..1]
							Node PD03AJ02 = pd03aNode.selectSingleNode("PD03AJ02");
							if (PD03AJ02 != null) {
								pd03a.setPD03AJ02(PD03AJ02.getText());
							}
							// 1.13.1.1.12 五级分类 PD03AD05 -- [1..1]
							Node PD03AD05 = pd03aNode.selectSingleNode("PD03AD05");
							if (PD03AD05 != null) {
								pd03a.setPD03AD05(PD03AD05.getText());
							}
							// 1.13.1.1.13 账户类型 PD03AD06 -- [1..1]
							Node PD03AD06 = pd03aNode.selectSingleNode("PD03AD06");
							if (PD03AD06 != null) {
								pd03a.setPD03AD06(PD03AD06.getText());
							}
							// 1.13.1.1.14 还款状态 PD03AD07 -- [1..1]
							Node PD03AD07 = pd03aNode.selectSingleNode("PD03AD07");
							if (PD03AD07 != null) {
								pd03a.setPD03AD07(PD03AD07.getText());
							}
							// 1.13.1.1.15 逾期月数 PD03AS01 -- [1..1]
							Node PD03AS01 = pd03aNode.selectSingleNode("PD03AS01");
							if (PD03AS01 != null) {
								pd03a.setPD03AS01(PD03AS01.getText());
							}
							// 1.13.1.1.16 信息报告日期 PD03AR03 -- [1..1]
							Node PD03AR03 = pd03aNode.selectSingleNode("PD03AR03");
							if (PD03AR03 != null) {
								pd03a.setPD03AR03(PD03AR03.getText());
							}
							pd03.setPD03A(pd03a);
						}
						// 1.13.1.2 标注及声明信息段 PD03Z [0..1]
						Node pd03zNode = pd03Node.selectSingleNode("PD03Z");
						if (pd03zNode != null) {
							PD03Z pd03z = new PD03Z();
							PD03Zdata pd03zData = new PD03Zdata();
							pd03zData.setIdentityCardNo(identityCardNo);
							pd03zData.setUniqueRelid(uniqueRelid);
							pd03zData.setRelateId(relateId);
							// 1.13.1.2.1 标注及声明个数 PD03ZS01 [1..1] --
							Node PD03ZS01 = pd03zNode.selectSingleNode("PD03ZS01");
							if (PD03ZS01 != null) {
								pd03zData.setPD03ZS01(PD03ZS01.getText());
							}
							pd03z.setPD03Zdata(pd03zData);
							// 1.13.1.2.2 标注及声明信息 PD03ZH [1.. 5]
							List<Element> pd03zhNodeList = pd03zNode.selectNodes("PD03ZH");
							if (pd03zhNodeList != null && pd03zhNodeList.size() > 0) {
								List<PD03ZH> pd03zhList = new ArrayList<PD03ZH>();
								for (int j = 0; j < pd03zhNodeList.size(); j++) {
									Element pd03zhNode = pd03zhNodeList.get(j);
									if (pd03zhNode == null) {
										continue;
									}
									PD03ZH pd03zh = new PD03ZH();
									pd03zh.setIdentityCardNo(identityCardNo);
									pd03zh.setUniqueRelid(uniqueRelid);
									pd03zh.setRelateId(relateId);
									// 1.13.1.2.2.1 标注及声明类型 PD03ZD01 [1..1] --
									Node PD03ZD01 = pd03zhNode.selectSingleNode("PD03ZD01");
									if (PD03ZD01 != null) {
										pd03zh.setPD03ZD01(PD03ZD01.getText());
									}
									// 1.13.1.2.2.2 标注或声明内容 PD03ZQ01 [1..1] --
									Node PD03ZQ01 = pd03zhNode.selectSingleNode("PD03ZQ01");
									if (PD03ZQ01 != null) {
										pd03zh.setPD03ZQ01(PD03ZQ01.getText());
									}
									// 1.13.1.2.2.3 添加日期 PD03ZR01 [1..1] --
									Node PD03ZR01 = pd03zhNode.selectSingleNode("PD03ZR01");
									if (PD03ZR01 != null) {
										pd03zh.setPD03ZR01(PD03ZR01.getText());
									}
									pd03zhList.add(pd03zh);
								}
								pd03z.setPD03ZHList(pd03zhList);
							}
							pd03.setPD03Z(pd03z);
						}
						pd03NodeList.add(pd03);
					}
					pcr.setPD03List(pd03NodeList);
				}
				bank.setPCR(pcr);
			}
			// 1.14 后付费业务信息 PND [1..1]
			Node pndNode = rootNode.selectSingleNode("PND");
			if (pndNode != null) {
				PND pnd = new PND();
				// 1.14.1 后付费业务信息单元 PE01 [0..*]
				List<Element> pe01NodeList = pndNode.selectNodes("PE01");
				if (pe01NodeList != null && pe01NodeList.size() > 0) {
					List<PE01> pe01List = new ArrayList<PE01>();
					for (int i = 0; i < pe01NodeList.size(); i++) {
						Element pe01Node = pe01NodeList.get(i);
						if (pe01Node == null) {
							continue;
						}
						PE01 pe01 = new PE01();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.14.1.1 后付费业务信息段 PE01A [1..1]
						Node pe01aNode = pe01Node.selectSingleNode("PE01A");
						if (pe01aNode != null) {
							PE01A pe01a = new PE01A();
							pe01a.setIdentityCardNo(identityCardNo);
							pe01a.setUniqueRelid(uniqueRelid);
							pe01a.setRelateId(relateId);
							// 1.14.1.1.1 后付费账户类型 PE01AD01 -- [1..1]
							Node PE01AD01 = pe01aNode.selectSingleNode("PE01AD01");
							if (PE01AD01 != null) {
								pe01a.setPE01AD01(PE01AD01.getText());
							}
							// 1.14.1.1.2 机构名称 PE01AQ01 -- [1..1]
							Node PE01AQ01 = pe01aNode.selectSingleNode("PE01AQ01");
							if (PE01AQ01 != null) {
								pe01a.setPE01AQ01(PE01AQ01.getText());
							}
							// 1.14.1.1.3 业务类型 PE01AD02 -- [1..1]
							Node PE01AD02 = pe01aNode.selectSingleNode("PE01AD02");
							if (PE01AD02 != null) {
								pe01a.setPE01AD02(PE01AD02.getText());
							}
							// 1.14.1.1.4 业务开通日期 PE01AR01 -- [1..1]
							Node PE01AR01 = pe01aNode.selectSingleNode("PE01AR01");
							if (PE01AR01 != null) {
								pe01a.setPE01AR01(PE01AR01.getText());
							}
							// 1.14.1.1.5 当前缴费状态 PE01AD03 -- [1..1]
							Node PE01AD03 = pe01aNode.selectSingleNode("PE01AD03");
							if (PE01AD03 != null) {
								pe01a.setPE01AD03(PE01AD03.getText());
							}
							// 1.14.1.1.6 当前欠费金额 PE01AJ01 -- [1..1]
							Node PE01AJ01 = pe01aNode.selectSingleNode("PE01AJ01");
							if (PE01AJ01 != null) {
								pe01a.setPE01AJ01(PE01AJ01.getText());
							}
							// 1.14.1.1.7 记账年月 PE01AR02 -- [1..1]
							Node PE01AR02 = pe01aNode.selectSingleNode("PE01AR02");
							if (PE01AR02 != null) {
								pe01a.setPE01AR02(PE01AR02.getText());
							}
							// 1.14.1.1.8 最近24个月缴费记录 PE01AQ02 -- [1..1]
							Node PE01AQ02 = pe01aNode.selectSingleNode("PE01AQ02");
							if (PE01AQ02 != null) {
								pe01a.setPE01AQ02(PE01AQ02.getText());
							}
							pe01.setPE01A(pe01a);
						}
						// 1.14.1.2 标注及声明信息段 PE01Z [0..1]
						Node pe01zNode = pe01Node.selectSingleNode("PE01Z");
						if (pe01zNode != null) {
							PE01Z pe01z = new PE01Z();
							PE01Zdata pe01zData = new PE01Zdata();
							pe01zData.setIdentityCardNo(identityCardNo);
							pe01zData.setUniqueRelid(uniqueRelid);
							pe01zData.setRelateId(relateId);
							// 1.14.1.2.1 标注及声明个数 PE01ZS01 -- [1..1]
							Node PE01ZS01 = pe01zNode.selectSingleNode("PE01ZS01");
							if (PE01ZS01 != null) {
								pe01zData.setPE01ZS01(PE01ZS01.getText());
							}
							pe01z.setPE01Zdata(pe01zData);
							// 1.14.1.2.2 标注及声明信息 PE01ZH [1..5]
							List<Element> pe01zhNodeList = pe01zNode.selectNodes("PE01ZH");
							if (pe01zhNodeList != null && pe01zhNodeList.size() > 0) {
								List<PE01ZH> pe01zhList = new ArrayList<PE01ZH>();
								for (int j = 0; j < pe01zhNodeList.size(); j++) {
									Node pe01zhNode = pe01zhNodeList.get(j);
									if (pe01zhNode == null) {
										continue;
									}
									PE01ZH pe01zh = new PE01ZH();
									pe01zh.setIdentityCardNo(identityCardNo);
									pe01zh.setUniqueRelid(uniqueRelid);
									pe01zh.setRelateId(relateId);
									// 1.14.1.2.2.1 标注及声明类型 PE01ZD01 -- [1..1]
									Node PE01ZD01 = pe01zhNode.selectSingleNode("PE01ZD01");
									if (PE01ZD01 != null) {
										pe01zh.setPE01ZD01(PE01ZD01.getText());
									}
									// 1.14.1.2.2.2 标注或声明内容 PE01ZQ01 -- [1..1]
									Node PE01ZQ01 = pe01zhNode.selectSingleNode("PE01ZQ01");
									if (PE01ZQ01 != null) {
										pe01zh.setPE01ZQ01(PE01ZQ01.getText());
									}
									// 1.14.1.2.2.3 添加日期 PE01ZR01 -- [1..1]
									Node PE01ZR01 = pe01zhNode.selectSingleNode("PE01ZR01");
									if (PE01ZR01 != null) {
										pe01zh.setPE01ZR01(PE01ZR01.getText());
									}
									pe01zhList.add(pe01zh);
								}
								pe01z.setPE01ZHList(pe01zhList);
							}
							pe01.setPE01Z(pe01z);
						}
						pe01List.add(pe01);
					}
					pnd.setPE01List(pe01List);
				}
				bank.setPND(pnd);
			}
			// 1.15 欠税记录 POT
			Node potNode = rootNode.selectSingleNode("POT");
			if (potNode != null) {
				POT pot = new POT();
				// 1.15.1 欠税记录信息单元 PF01 [0..*]
				List<Element> pf01NodeList = potNode.selectNodes("PF01");
				if (pf01NodeList != null && pf01NodeList.size() > 0) {
					List<PF01> pf01List = new ArrayList<PF01>();
					for (int i = 0; i < pf01NodeList.size(); i++) {
						Element pf01Node = pf01NodeList.get(i);
						if (pf01Node == null) {
							continue;
						}
						PF01 pf01 = new PF01();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.15.1.1 欠税 记录信息段 PF01A [1..1]
						Node pf01aNode = pf01Node.selectSingleNode("PF01A");
						if (pf01aNode != null) {
							PF01A pf01a = new PF01A();
							pf01a.setIdentityCardNo(identityCardNo);
							pf01a.setUniqueRelid(uniqueRelid);
							pf01a.setRelateId(relateId);
							// 1.15.1.1.1 主管税务机关 PF01AQ01 -- [1..1]
							Node PF01AQ01 = pf01aNode.selectSingleNode("PF01AQ01");
							if (PF01AQ01 != null) {
								pf01a.setPF01AQ01(PF01AQ01.getText());
							}
							// 1.15.1.1.2 欠税总额 PF01AJ01 -- [1..1]
							Node PF01AJ01 = pf01aNode.selectSingleNode("PF01AJ01");
							if (PF01AJ01 != null) {
								pf01a.setPF01AJ01(PF01AJ01.getText());
							}
							// 1.15.1.1.3 欠税统计日期 PF01AR01 -- [1..1]
							Node PF01AR01 = pf01aNode.selectSingleNode("PF01AR01");
							if (PF01AR01 != null) {
								pf01a.setPF01AR01(PF01AR01.getText());
							}
							pf01.setPF01A(pf01a);
						}
						// 1.15.1.2 标注及声明信息段 PF01Z [0..1]
						Node pf01zNode = pf01Node.selectSingleNode("PF01Z");
						if (pf01zNode != null) {
							PF01Z pf01z = new PF01Z();
							PF01Zdata pf01zData = new PF01Zdata();
							pf01zData.setIdentityCardNo(identityCardNo);
							pf01zData.setUniqueRelid(uniqueRelid);
							pf01zData.setRelateId(relateId);
							// 1.15.1.2.1 标注及声明个数 PF01ZS01 -- [1..1]
							Node PF01ZS01 = pf01zNode.selectSingleNode("PF01ZS01");
							if (PF01ZS01 != null) {
								pf01zData.setPF01ZS01(PF01ZS01.getText());
							}
							pf01z.setPF01Zdata(pf01zData);
							// 1.15.1.2.2 标注及声明信息 PF01ZH [1..5]
							List<Element> pf01zhNodeList = pf01zNode.selectNodes("PF01ZH");
							if (pf01zhNodeList != null && pf01zhNodeList.size() > 0) {
								List<PF01ZH> pf01zhList = new ArrayList<PF01ZH>();
								for (int j = 0; j < pf01zhNodeList.size(); j++) {
									Element pf01zhNode = pf01zhNodeList.get(j);
									if (pf01zhNode == null) {
										continue;
									}
									PF01ZH pf01zh = new PF01ZH();
									pf01zh.setIdentityCardNo(identityCardNo);
									pf01zh.setUniqueRelid(uniqueRelid);
									pf01zh.setRelateId(relateId);
									// 1.15.1.2.2.1 标注及声明类型 PF01ZD01 -- [1..1]
									Node PF01ZD01 = pf01zhNode.selectSingleNode("PF01ZD01");
									if (PF01ZD01 != null) {
										pf01zh.setPF01ZD01(PF01ZD01.getText());
									}
									// 1.15.1.2.2.2 标注或声明内容 PF01ZQ01 -- [1..1]
									Node PF01ZQ01 = pf01zhNode.selectSingleNode("PF01ZQ01");
									if (PF01ZQ01 != null) {
										pf01zh.setPF01ZQ01(PF01ZQ01.getText());
									}
									// 1.15.1.2.2.3 添加日期 PF01ZR01 -- [1..1]
									Node PF01ZR01 = pf01zhNode.selectSingleNode("PF01ZR01");
									if (PF01ZR01 != null) {
										pf01zh.setPF01ZR01(PF01ZR01.getText());
									}
									pf01zhList.add(pf01zh);
								}
								pf01z.setPF01ZHList(pf01zhList);
							}
							pf01.setPF01Z(pf01z);
						}
						pf01List.add(pf01);
					}
					pot.setPF01List(pf01List);
				}
				bank.setPOT(pot);
			}
			// 1.16 民事判决记录 PCJ [1..1]
			Node pcjNode = rootNode.selectSingleNode("PCJ");
			if (pcjNode != null) {
				PCJ pcj = new PCJ();
				// 1.16.1 民事判决记录信息单元 PF02 [0..*]
				List<Element> pf02NodeList = pcjNode.selectNodes("PF02");
				if (pf02NodeList != null && pf02NodeList.size() > 0) {
					List<PF02> pf02List = new ArrayList<PF02>();
					for (int i = 0; i < pf02NodeList.size(); i++) {
						Element pf02Node = pf02NodeList.get(i);
						if (pf02Node == null) {
							continue;
						}
						PF02 pf02 = new PF02();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.16.1.1 民事判决记录信息段 PF02A [1..1]
						Node pf02aNode = pf02Node.selectSingleNode("PF02A");
						if (pf02aNode != null) {
							PF02A pf02a = new PF02A();
							pf02a.setIdentityCardNo(identityCardNo);
							pf02a.setUniqueRelid(uniqueRelid);
							pf02a.setRelateId(relateId);
							// 1.16.1.1.1 立案法院 PF02AQ01 -- [1..1]
							Node PF02AQ01 = pf02aNode.selectSingleNode("PF02AQ01");
							if (PF02AQ01 != null) {
								pf02a.setPF02AQ01(PF02AQ01.getText());
							}
							// 1.16.1.1.2 案由 PF02AQ02 -- [1..1]
							Node PF02AQ02 = pf02aNode.selectSingleNode("PF02AQ02");
							if (PF02AQ02 != null) {
								pf02a.setPF02AQ02(PF02AQ02.getText());
							}
							// 1.16.1.1.3 立案日期 PF02AR01 -- [1..1]
							Node PF02AR01 = pf02aNode.selectSingleNode("PF02AR01");
							if (PF02AR01 != null) {
								pf02a.setPF02AR01(PF02AR01.getText());
							}
							// 1.16.1.1.4 结案方式 PF02AD01 -- [1..1]
							Node PF02AD01 = pf02aNode.selectSingleNode("PF02AD01");
							if (PF02AD01 != null) {
								pf02a.setPF02AD01(PF02AD01.getText());
							}
							// 1.16.1.1.5 判决/调解结果 PF02AQ03 -- [1..1]
							Node PF02AQ03 = pf02aNode.selectSingleNode("PF02AQ03");
							if (PF02AQ03 != null) {
								pf02a.setPF02AQ03(PF02AQ03.getText());
							}
							// 1.16.1.1.6 判决/调解生效日期 PF02AR02 -- [1..1]
							Node PF02AR02 = pf02aNode.selectSingleNode("PF02AR02");
							if (PF02AR02 != null) {
								pf02a.setPF02AR02(PF02AR02.getText());
							}
							// 1.16.1.1.7 诉讼标的 PF02AQ04 -- [1..1]
							Node PF02AQ04 = pf02aNode.selectSingleNode("PF02AQ04");
							if (PF02AQ04 != null) {
								pf02a.setPF02AQ04(PF02AQ04.getText());
							}
							// 1.16.1.1.8 诉讼标的金额 PF02AJ01 -- [1..1]
							Node PF02AJ01 = pf02aNode.selectSingleNode("PF02AJ01");
							if (PF02AJ01 != null) {
								pf02a.setPF02AJ01(PF02AJ01.getText());
							}
							pf02.setPF02A(pf02a);
						}
						// 1.16.1.2 标注及声明信息段 PF02Z [0..1]
						Node pf02zNode = pf02Node.selectSingleNode("PF02Z");
						if (pf02zNode != null) {
							PF02Z pf02z = new PF02Z();
							PF02Zdata pf02zData = new PF02Zdata();
							pf02zData.setIdentityCardNo(identityCardNo);
							pf02zData.setUniqueRelid(uniqueRelid);
							pf02zData.setRelateId(relateId);
							// 1.16.1.2.1 标注及声明个数 PF02ZS01 -- [1..1]
							Node PF02ZS01 = pf02zNode.selectSingleNode("PF02ZS01");
							if (PF02ZS01 != null) {
								pf02zData.setPF02ZS01(PF02ZS01.getText());
							}
							pf02z.setPF02Zdata(pf02zData);
							// 1.16.1.2.2 标注及声明信息 PF02ZH [1..5]
							List<Element> pf02zhNodeList = pf02zNode.selectNodes("PF02ZH");
							if (pf02zhNodeList != null && pf02zhNodeList.size() > 0) {
								List<PF02ZH> pf02zhList = new ArrayList<PF02ZH>();
								for (int j = 0; j < pf02zhNodeList.size(); j++) {
									Element pf02zhNode = pf02zhNodeList.get(j);
									if (pf02zhNode == null) {
										continue;
									}
									PF02ZH pf02zh = new PF02ZH();
									pf02zh.setIdentityCardNo(identityCardNo);
									pf02zh.setUniqueRelid(uniqueRelid);
									pf02zh.setRelateId(relateId);
									// 1.16.1.2.2.1 标注及声明类型 PF02ZD01 -- [1..1]
									Node PF02ZD01 = pf02zhNode.selectSingleNode("PF02ZD01");
									if (PF02ZD01 != null) {
										pf02zh.setPF02ZD01(PF02ZD01.getText());
									}
									// 1.16.1.2.2.2 标注或声明内容 PF02ZQ01 -- [1..1]
									Node PF02ZQ01 = pf02zhNode.selectSingleNode("PF02ZQ01");
									if (PF02ZQ01 != null) {
										pf02zh.setPF02ZQ01(PF02ZQ01.getText());
									}
									// 1.16.1.2.2.3 添加日期 PF02ZR01 -- [1..1]
									Node PF02ZR01 = pf02zhNode.selectSingleNode("PF02ZR01");
									if (PF02ZR01 != null) {
										pf02zh.setPF02ZR01(PF02ZR01.getText());
									}
									pf02zhList.add(pf02zh);
								}
								pf02z.setPF02ZHList(pf02zhList);
							}
							pf02.setPF02Z(pf02z);
						}
						pf02List.add(pf02);
					}
					pcj.setPF02List(pf02List);
				}
				bank.setPCJ(pcj);
			}
			// 1.17 强制执行记录 PCE [1..1]
			Node pceNode = rootNode.selectSingleNode("PCE");
			if (pceNode != null) {
				PCE pce = new PCE();
				// 1.17.1 强制执行记录信息单元 PF03 [0..*]
				List<Element> pf03NodeList = pceNode.selectNodes("PF03");
				if (pf03NodeList != null && pf03NodeList.size() > 0) {
					List<PF03> pf03List = new ArrayList<PF03>();
					for (int i = 0; i < pf03NodeList.size(); i++) {
						Element pf03Node = pf03NodeList.get(i);
						if (pf03Node == null) {
							continue;
						}
						PF03 pf03 = new PF03();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.17.1.1 强制执行记录信息段 PF03A [1..1]
						Node pf03aNode = pf03Node.selectSingleNode("PF03A");
						if (pf03aNode != null) {
							PF03A pf03a = new PF03A();
							pf03a.setIdentityCardNo(identityCardNo);
							pf03a.setUniqueRelid(uniqueRelid);
							pf03a.setRelateId(relateId);
							// 1.17.1.1.1 执行法院 PF03AQ01 -- [1..1]
							Node PF03AQ01 = pf03aNode.selectSingleNode("PF03AQ01");
							if (PF03AQ01 != null) {
								pf03a.setPF03AQ01(PF03AQ01.getText());
							}
							// 1.17.1.1.2 执行案由 PF03AQ02 -- [1..1]
							Node PF03AQ02 = pf03aNode.selectSingleNode("PF03AQ02");
							if (PF03AQ02 != null) {
								pf03a.setPF03AQ02(PF03AQ02.getText());
							}
							// 1.17.1.1.3 立案日期 PF03AR01 -- [1..1]
							Node PF03AR01 = pf03aNode.selectSingleNode("PF03AR01");
							if (PF03AR01 != null) {
								pf03a.setPF03AR01(PF03AR01.getText());
							}
							// 1.17.1.1.4 结案方式 PF03AD01 -- [1..1]
							Node PF03AD01 = pf03aNode.selectSingleNode("PF03AD01");
							if (PF03AD01 != null) {
								pf03a.setPF03AD01(PF03AD01.getText());
							}
							// 1.17.1.1.5 案件状态 PF03AQ03 -- [1..1]
							Node PF03AQ03 = pf03aNode.selectSingleNode("PF03AQ03");
							if (PF03AQ03 != null) {
								pf03a.setPF03AQ03(PF03AQ03.getText());
							}
							// 1.17.1.1.6 结案日期 PF03AR02 -- [1..1]
							Node PF03AR02 = pf03aNode.selectSingleNode("PF03AR02");
							if (PF03AR02 != null) {
								pf03a.setPF03AR02(PF03AR02.getText());
							}
							// 1.17.1.1.7 申请执行标的 PF03AQ04 -- [1..1]
							Node PF03AQ04 = pf03aNode.selectSingleNode("PF03AQ04");
							if (PF03AQ04 != null) {
								pf03a.setPF03AQ04(PF03AQ04.getText());
							}
							// 1.17.1.1.8 申请执行标的金额 PF03AJ01 -- [1..1]
							Node PF03AJ01 = pf03aNode.selectSingleNode("PF03AJ01");
							if (PF03AJ01 != null) {
								pf03a.setPF03AJ01(PF03AJ01.getText());
							}
							// 1.17.1.1.9 已执行标的 PF03AQ05 -- [1..1]
							Node PF03AQ05 = pf03aNode.selectSingleNode("PF03AQ05");
							if (PF03AQ05 != null) {
								pf03a.setPF03AQ05(PF03AQ05.getText());
							}
							// 1.17.1.1.10 已执行标的金额 PF03AJ02 -- [1..1]
							Node PF03AJ02 = pf03aNode.selectSingleNode("PF03AJ02");
							if (PF03AJ02 != null) {
								pf03a.setPF03AJ02(PF03AJ02.getText());
							}
							pf03.setPF03A(pf03a);
						}
						// 1.17.1.2 标注及声明信息段 PF03Z [0..1]
						Node pf03zNode = pf03Node.selectSingleNode("PF03Z");
						if (pf03zNode != null) {
							PF03Z pf03z = new PF03Z();
							PF03Zdata pf03zData = new PF03Zdata();
							pf03zData.setIdentityCardNo(identityCardNo);
							pf03zData.setUniqueRelid(uniqueRelid);
							pf03zData.setRelateId(relateId);
							// 1.17.1.2.1 标注及声明个数 PF03ZS01 -- [1..1]
							Node PF03ZS01 = pf03zNode.selectSingleNode("PF03ZS01");
							if (PF03ZS01 != null) {
								pf03zData.setPF03ZS01(PF03ZS01.getText());
							}
							pf03z.setPF03Zdata(pf03zData);
							// 1.17.1.2.2 标注及声明信息 PF03ZH [1..5]
							List<Element> pf03zhNodeList = pf03zNode.selectNodes("PF03ZH");
							if (pf03zhNodeList != null && pf03zhNodeList.size() > 0) {
								List<PF03ZH> pf03zhList = new ArrayList<PF03ZH>();
								for (int j = 0; j < pf03zhNodeList.size(); j++) {
									Element pf03zhNode = pf03zhNodeList.get(j);
									if (pf03zhNode == null) {
										continue;
									}
									PF03ZH pf03zh = new PF03ZH();
									pf03zh.setIdentityCardNo(identityCardNo);
									pf03zh.setUniqueRelid(uniqueRelid);
									pf03zh.setRelateId(relateId);
									// 1.17.1.2.2.1 标注及声明类型 PF03ZD01 -- [1..1]
									Node PF03ZD01 = pf03zhNode.selectSingleNode("PF03ZD01");
									if (PF03ZD01 != null) {
										pf03zh.setPF03ZD01(PF03ZD01.getText());
									}
									// 1.17.1.2.2.2 标注或声明内容 PF03ZQ01 -- [1..1]
									Node PF03ZQ01 = pf03zhNode.selectSingleNode("PF03ZQ01");
									if (PF03ZQ01 != null) {
										pf03zh.setPF03ZQ01(PF03ZQ01.getText());
									}
									// 1.17.1.2.2.3 添加日期 PF03ZR01 -- [1..1]
									Node PF03ZR01 = pf03zhNode.selectSingleNode("PF03ZR01");
									if (PF03ZR01 != null) {
										pf03zh.setPF03ZR01(PF03ZR01.getText());
									}
									pf03zhList.add(pf03zh);
								}
								pf03z.setPF03ZHList(pf03zhList);
							}
							pf03.setPF03Z(pf03z);
						}
						pf03List.add(pf03);
					}
					pce.setPF03List(pf03List);
				}
				bank.setPCE(pce);
			}
			// 1.18 行政处罚记录 PAP [1..1]
			Node papNode = rootNode.selectSingleNode("PAP");
			if (papNode != null) {
				PAP pap = new PAP();
				// 1.18.1 行政处罚记录信息单元 PF04 [0..*]
				List<Element> pf04NodeList = papNode.selectNodes("PF04");
				if (pf04NodeList != null && pf04NodeList.size() > 0) {
					List<PF04> pf04List = new ArrayList<PF04>();
					for (int i = 0; i < pf04NodeList.size(); i++) {
						Element pf04Node = pf04NodeList.get(i);
						if (pf04Node == null) {
							continue;
						}
						PF04 pf04 = new PF04();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.18.1.1 行政处罚记录信息段 PF04A [1..1]
						Node pf04aNode = pf04Node.selectSingleNode("PF04A");
						if (pf04aNode != null) {
							PF04A pf04a = new PF04A();
							pf04a.setIdentityCardNo(identityCardNo);
							pf04a.setUniqueRelid(uniqueRelid);
							pf04a.setRelateId(relateId);
							// 1.18.1.1.1 处罚机构 PF04AQ01 -- [1..1]
							Node PF04AQ01 = pf04aNode.selectSingleNode("PF04AQ01");
							if (PF04AQ01 != null) {
								pf04a.setPF04AQ01(PF04AQ01.getText());
							}
							// 1.18.1.1.2 处罚内容 PF04AQ02 -- [1..1]
							Node PF04AQ02 = pf04aNode.selectSingleNode("PF04AQ02");
							if (PF04AQ02 != null) {
								pf04a.setPF04AQ02(PF04AQ02.getText());
							}
							// 1.18.1.1.3 处罚金额 PF04AJ01 -- [1..1]
							Node PF04AJ01 = pf04aNode.selectSingleNode("PF04AJ01");
							if (PF04AJ01 != null) {
								pf04a.setPF04AJ01(PF04AJ01.getText());
							}
							// 1.18.1.1.4 处罚生效日期 PF04AR01 -- [1..1]
							Node PF04AR01 = pf04aNode.selectSingleNode("PF04AR01");
							if (PF04AR01 != null) {
								pf04a.setPF04AR01(PF04AR01.getText());
							}
							// 1.18.1.1.5 处罚截止日期 PF04AR02 -- [1..1]
							Node PF04AR02 = pf04aNode.selectSingleNode("PF04AR02");
							if (PF04AR02 != null) {
								pf04a.setPF04AR02(PF04AR02.getText());
							}
							// 1.18.1.1.6 行政复议结果 PF04AQ03 -- [1..1]
							Node PF04AQ03 = pf04aNode.selectSingleNode("PF04AQ03");
							if (PF04AQ03 != null) {
								pf04a.setPF04AQ03(PF04AQ03.getText());
							}
							pf04.setPF04A(pf04a);
						}
						// 1.18.1.2 标注及声明信息段 PF04Z [0..1]
						Node pf04zNode = pf04Node.selectSingleNode("PF04Z");
						if (pf04zNode != null) {
							PF04Z pf04z = new PF04Z();
							PF04Zdata pf04zData = new PF04Zdata();
							pf04zData.setIdentityCardNo(identityCardNo);
							pf04zData.setUniqueRelid(uniqueRelid);
							pf04zData.setRelateId(relateId);
							// 1.18.1.2.1 标注及声明个数 PF04ZS01 -- [1..1]
							Node PF04ZS01 = pf04zNode.selectSingleNode("PF04ZS01");
							if (PF04ZS01 != null) {
								pf04zData.setPF04ZS01(PF04ZS01.getText());
							}
							pf04z.setPF04Zdata(pf04zData);
							// 1.18.1.2.2 标注及声明信息 PF04ZH [1..5]
							List<Element> pf04zhNodeList = pf04zNode.selectNodes("PF04ZH");
							if (pf04zhNodeList != null && pf04zhNodeList.size() > 0) {
								List<PF04ZH> pf04zhList = new ArrayList<PF04ZH>();
								for (int j = 0; j < pf04zhNodeList.size(); j++) {
									Element pf04zhNode = pf04zhNodeList.get(j);
									if (pf04zhNode == null) {
										continue;
									}
									PF04ZH pf04zh = new PF04ZH();
									pf04zh.setIdentityCardNo(identityCardNo);
									pf04zh.setUniqueRelid(uniqueRelid);
									pf04zh.setRelateId(relateId);
									// 1.18.1.2.2.1 标注及声明类型 PF04ZD01 -- [1..1]
									Node PF04ZD01 = pf04zhNode.selectSingleNode("PF04ZD01");
									if (PF04ZD01 != null) {
										pf04zh.setPF04ZD01(PF04ZD01.getText());
									}
									// 1.18.1.2.2.2 标注或声明内容 PF04ZQ01 -- [1..1]
									Node PF04ZQ01 = pf04zhNode.selectSingleNode("PF04ZQ01");
									if (PF04ZQ01 != null) {
										pf04zh.setPF04ZQ01(PF04ZQ01.getText());
									}
									// 1.18.1.2.2.3 添加日期 PF04ZR01 -- [1..1]
									Node PF04ZR01 = pf04zhNode.selectSingleNode("PF04ZR01");
									if (PF04ZR01 != null) {
										pf04zh.setPF04ZR01(PF04ZR01.getText());
									}
									pf04zhList.add(pf04zh);
								}
								pf04z.setPF04ZHList(pf04zhList);
							}
							pf04.setPF04Z(pf04z);
						}
						pf04List.add(pf04);
					}
					pap.setPF04List(pf04List);
				}
				bank.setPAP(pap);
			}
			// 1.19 住房公积金参缴记录 PHF [1..1]
			Node phfNode = rootNode.selectSingleNode("PHF");
			if (phfNode != null) {
				PHF phf = new PHF();
				// 1.19.1 住房公积金参缴记录信息单元 PF05 [0..*]
				List<Element> pf05NodeList = phfNode.selectNodes("PF05");
				if (pf05NodeList != null && pf05NodeList.size() > 0) {
					List<PF05> pf05List = new ArrayList<PF05>();
					for (int i = 0; i < pf05NodeList.size(); i++) {
						Element pf05Node = pf05NodeList.get(i);
						if (pf05Node == null) {
							continue;
						}
						PF05 pf05 = new PF05();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.19.1.1 住房公积金参缴记录信息段 PF05A [1..1]
						Node pf05aNode = pf05Node.selectSingleNode("PF05A");
						if (pf05aNode != null) {
							PF05A pf05a = new PF05A();
							pf05a.setIdentityCardNo(identityCardNo);
							pf05a.setUniqueRelid(uniqueRelid);
							pf05a.setRelateId(relateId);
							// 1.19.1.1.1 参缴地 PF05AQ01 -- [1..1]
							Node PF05AQ01 = pf05aNode.selectSingleNode("PF05AQ01");
							if (PF05AQ01 != null) {
								pf05a.setPF05AQ01(PF05AQ01.getText());
							}
							// 1.19.1.1.2 参缴日期 PF05AR01 -- [1..1]
							Node PF05AR01 = pf05aNode.selectSingleNode("PF05AR01");
							if (PF05AR01 != null) {
								pf05a.setPF05AR01(PF05AR01.getText());
							}
							// 1.19.1.1.3 缴费状态 PF05AD01 -- [1..1]
							Node PF05AD01 = pf05aNode.selectSingleNode("PF05AD01");
							if (PF05AD01 != null) {
								pf05a.setPF05AD01(PF05AD01.getText());
							}
							// 1.19.1.1.4 初缴月份 PF05AR02 -- [1..1]
							Node PF05AR02 = pf05aNode.selectSingleNode("PF05AR02");
							if (PF05AR02 != null) {
								pf05a.setPF05AR02(PF05AR02.getText());
							}
							// 1.19.1.1.5 缴至月份 PF05AR03 -- [1..1]
							Node PF05AR03 = pf05aNode.selectSingleNode("PF05AR03");
							if (PF05AR03 != null) {
								pf05a.setPF05AR03(PF05AR03.getText());
							}
							// 1.19.1.1.6 单位缴存比例 PF05AQ02 -- [1..1]
							Node PF05AQ02 = pf05aNode.selectSingleNode("PF05AQ02");
							if (PF05AQ02 != null) {
								pf05a.setPF05AQ02(PF05AQ02.getText());
							}
							// 1.19.1.1.7 个人缴存比例 PF05AQ03 -- [1..1]
							Node PF05AQ03 = pf05aNode.selectSingleNode("PF05AQ03");
							if (PF05AQ03 != null) {
								pf05a.setPF05AQ03(PF05AQ03.getText());
							}
							// 1.19.1.1.8 月缴存额 PF05AJ01 -- [1..1]
							Node PF05AJ01 = pf05aNode.selectSingleNode("PF05AJ01");
							if (PF05AJ01 != null) {
								pf05a.setPF05AJ01(PF05AJ01.getText());
							}
							// 1.19.1.1.9 缴费单位 PF05AQ04 -- [1..1]
							Node PF05AQ04 = pf05aNode.selectSingleNode("PF05AQ04");
							if (PF05AQ04 != null) {
								pf05a.setPF05AQ04(PF05AQ04.getText());
							}
							// 1.19.1.1.10 信息更新日期 PF05AR04 -- [1..1]
							Node PF05AR04 = pf05aNode.selectSingleNode("PF05AR04");
							if (PF05AR04 != null) {
								pf05a.setPF05AR04(PF05AR04.getText());
							}
							pf05.setPF05A(pf05a);
						}
						// 1.19.1.2 标注及声明信息段 PF05Z [0..1]
						Node pf05zNode = pf05Node.selectSingleNode("PF05Z");
						if (pf05zNode != null) {
							PF05Z pf05z = new PF05Z();
							PF05Zdata pf05zData = new PF05Zdata();
							pf05zData.setIdentityCardNo(identityCardNo);
							pf05zData.setUniqueRelid(uniqueRelid);
							pf05zData.setRelateId(relateId);
							// 1.19.1.2.1 标注及声明个数 PF05ZS01 -- [1..1]
							Node PF05ZS01 = pf05zNode.selectSingleNode("PF05ZS01");
							if (PF05ZS01 != null) {
								pf05zData.setPF05ZS01(PF05ZS01.getText());
							}
							pf05z.setPF05Zdata(pf05zData);
							// 1.19.1.2.1 标注及声明信息 PF05ZH [1..5]
							List<Element> pf05zhNodeList = pf05zNode.selectNodes("PF05ZH");
							if (pf05zhNodeList != null && pf05zhNodeList.size() > 0) {
								List<PF05ZH> pf05zhList = new ArrayList<PF05ZH>();
								for (int j = 0; j < pf05zhNodeList.size(); j++) {
									Element pf05zhNode = pf05zhNodeList.get(j);
									if (pf05zhNode == null) {
										continue;
									}
									PF05ZH pf05zh = new PF05ZH();
									pf05zh.setIdentityCardNo(identityCardNo);
									pf05zh.setUniqueRelid(uniqueRelid);
									pf05zh.setRelateId(relateId);
									// 1.19.1.2.1.1 标注及声明类型 PF05ZD01 -- [1..1]
									Node PF05ZD01 = pf05zhNode.selectSingleNode("PF05ZD01");
									if (PF05ZD01 != null) {
										pf05zh.setPF05ZD01(PF05ZD01.getText());
									}
									// 1.19.1.2.1.2 标注或声明内容 PF05ZQ01 -- [1..1]
									Node PF05ZQ01 = pf05zhNode.selectSingleNode("PF05ZQ01");
									if (PF05ZQ01 != null) {
										pf05zh.setPF05ZQ01(PF05ZQ01.getText());
									}
									// 1.19.1.2.1.3 添加日期 PF05ZR01 -- [1..1]
									Node PF05ZR01 = pf05zhNode.selectSingleNode("PF05ZR01");
									if (PF05ZR01 != null) {
										pf05zh.setPF05ZR01(PF05ZR01.getText());
									}
									pf05zhList.add(pf05zh);
								}
								pf05z.setPF05ZHList(pf05zhList);
							}
							pf05.setPF05Z(pf05z);
						}
						pf05List.add(pf05);
					}
					phf.setPF05List(pf05List);
				}
				bank.setPHF(phf);
			}
			// 1.20 低保救助记录 PBS [1..1]
			Node pbsNode = rootNode.selectSingleNode("PBS");
			if (pbsNode != null) {
				PBS pbs = new PBS();
				// 1.20.1 低保救助记录信息单元 PF06 [0..*]
				List<Element> pf06NodeList = pbsNode.selectNodes("PF06");
				if (pf06NodeList != null && pf06NodeList.size() > 0) {
					List<PF06> pf06List = new ArrayList<PF06>();
					for (int i = 0; i < pf06NodeList.size(); i++) {
						Element pf06Node = pf06NodeList.get(i);
						if (pf06Node == null) {
							continue;
						}
						PF06 pf06 = new PF06();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.20.1.1 低保救助记录信息段 PF06A [1..1]
						Node pf06aNode = pf06Node.selectSingleNode("PF06A");
						if (pf06aNode != null) {
							PF06A pf06a = new PF06A();
							pf06a.setIdentityCardNo(identityCardNo);
							pf06a.setUniqueRelid(uniqueRelid);
							pf06a.setRelateId(relateId);
							// 1.20.1.1.1 人员类别 PF06AD01 -- [1..1]
							Node PF06AD01 = pf06aNode.selectSingleNode("PF06AD01");
							if (PF06AD01 != null) {
								pf06a.setPF06AD01(PF06AD01.getText());
							}
							// 1.20.1.1.2 所在地 PF06AQ01 -- [1..1]
							Node PF06AQ01 = pf06aNode.selectSingleNode("PF06AQ01");
							if (PF06AQ01 != null) {
								pf06a.setPF06AQ01(PF06AQ01.getText());
							}
							// 1.20.1.1.3 工作单位 PF06AQ02 -- [1..1]
							Node PF06AQ02 = pf06aNode.selectSingleNode("PF06AQ02");
							if (PF06AQ02 != null) {
								pf06a.setPF06AQ02(PF06AQ02.getText());
							}
							// 1.20.1.1.4 家庭月收入 PF06AQ03 -- [1..1]
							Node PF06AQ03 = pf06aNode.selectSingleNode("PF06AQ03");
							if (PF06AQ03 != null) {
								pf06a.setPF06AQ03(PF06AQ03.getText());
							}
							// 1.20.1.1.5 申请日期 PF06AR01 -- [1..1]
							Node PF06AR01 = pf06aNode.selectSingleNode("PF06AR01");
							if (PF06AR01 != null) {
								pf06a.setPF06AR01(PF06AR01.getText());
							}
							// 1.20.1.1.6 批准日期 PF06AR02 -- [1..1]
							Node PF06AR02 = pf06aNode.selectSingleNode("PF06AR02");
							if (PF06AR02 != null) {
								pf06a.setPF06AR02(PF06AR02.getText());
							}
							// 1.20.1.1.7 信息更新日期 PF06AR03 -- [1..1]
							Node PF06AR03 = pf06aNode.selectSingleNode("PF06AR03");
							if (PF06AR03 != null) {
								pf06a.setPF06AR03(PF06AR03.getText());
							}
							pf06.setPF06A(pf06a);
						}
						// 1.20.1.2 标注及声明信息段 PF06Z [0..1]
						Node pf06zNode = pf06Node.selectSingleNode("PF06Z");
						if (pf06zNode != null) {
							PF06Z pf06z = new PF06Z();
							PF06Zdata pf06zData = new PF06Zdata();
							pf06zData.setIdentityCardNo(identityCardNo);
							pf06zData.setUniqueRelid(uniqueRelid);
							pf06zData.setRelateId(relateId);
							// 1.20.1.2.1 标注及声明个数 PF06ZS01 -- [1..1]
							Node PF06ZS01 = pf06zNode.selectSingleNode("PF06ZS01");
							if (PF06ZS01 != null) {
								pf06zData.setPF06ZS01(PF06ZS01.getText());
							}
							pf06z.setPF06Zdata(pf06zData);
							// 1.20.1.2.2 标注及声明信息 PF06ZH [1..5]
							List<Element> pf06zhNodeList = pf06zNode.selectNodes("PF06ZH");
							if (pf06zhNodeList != null && pf06zhNodeList.size() > 0) {
								List<PF06ZH> pf06zhList = new ArrayList<PF06ZH>();
								for (int j = 0; j < pf06zhNodeList.size(); j++) {
									Node pf06zhNode = pf06zhNodeList.get(j);
									if (pf06zhNode == null) {
										continue;
									}
									PF06ZH pf06zh = new PF06ZH();
									pf06zh.setIdentityCardNo(identityCardNo);
									pf06zh.setUniqueRelid(uniqueRelid);
									pf06zh.setRelateId(relateId);
									// 1.20.1.2.2.1 标注及声明类型 PF06ZD01 -- [1..1]
									Node PF06ZD01 = pf06zhNode.selectSingleNode("PF06ZD01");
									if (PF06ZD01 != null) {
										pf06zh.setPF06ZD01(PF06ZD01.getText());
									}
									// 1.20.1.2.2.2 标注或声明内容 PF06ZQ01 -- [1..1]
									Node PF06ZQ01 = pf06zhNode.selectSingleNode("PF06ZQ01");
									if (PF06ZQ01 != null) {
										pf06zh.setPF06ZQ01(PF06ZQ01.getText());
									}
									// 1.20.1.2.2.3 添加日期 PF06ZR01 -- [1..1]
									Node PF06ZR01 = pf06zhNode.selectSingleNode("PF06ZR01");
									if (PF06ZR01 != null) {
										pf06zh.setPF06ZR01(PF06ZR01.getText());
									}
									pf06zhList.add(pf06zh);
								}
								pf06z.setPF06ZHList(pf06zhList);
							}
							pf06.setPF06Z(pf06z);
						}
						pf06List.add(pf06);
					}
					pbs.setPF06List(pf06List);
				}
				bank.setPBS(pbs);
			}
			// 1.21 执业资格记录 PPQ [1..1]
			Node ppqNode = rootNode.selectSingleNode("PPQ");
			if (ppqNode != null) {
				PPQ ppq = new PPQ();
				// 1.21.1 执业资格记录信息单元 PF07 [0..*]
				List<Element> pf07NodeList = ppqNode.selectNodes("PF07");
				if (pf07NodeList != null && pf07NodeList.size() > 0) {
					List<PF07> pf07List = new ArrayList<PF07>();
					for (int i = 0; i < pf07NodeList.size(); i++) {
						Element pf07Node = pf07NodeList.get(i);
						if (pf07Node == null) {
							continue;
						}
						PF07 pf07 = new PF07();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.21.1.1 执业资格记录信息段 PF07A [1..1]
						Node pf07aNode = pf07Node.selectSingleNode("PF07A");
						if (pf07aNode != null) {
							PF07A pf07a = new PF07A();
							pf07a.setIdentityCardNo(identityCardNo);
							pf07a.setUniqueRelid(uniqueRelid);
							pf07a.setRelateId(relateId);
							// 1.21.1.1.1 执业资格名称 PF07AQ01 -- [1..1]
							Node PF07AQ01 = pf07aNode.selectSingleNode("PF07AQ01");
							if (PF07AQ01 != null) {
								pf07a.setPF07AQ01(PF07AQ01.getText());
							}
							// 1.21.1.1.2 颁发机构 PF07AQ02 -- [1..1]
							Node PF07AQ02 = pf07aNode.selectSingleNode("PF07AQ02");
							if (PF07AQ02 != null) {
								pf07a.setPF07AQ02(PF07AQ02.getText());
							}
							// 1.21.1.1.3 等级 PF07AD01 -- [1..1]
							Node PF07AD01 = pf07aNode.selectSingleNode("PF07AD01");
							if (PF07AD01 != null) {
								pf07a.setPF07AD01(PF07AD01.getText());
							}
							// 1.21.1.1.4 机构所在地 PF07AD02 -- [1..1]
							Node PF07AD02 = pf07aNode.selectSingleNode("PF07AD02");
							if (PF07AD02 != null) {
								pf07a.setPF07AD02(PF07AD02.getText());
							}
							// 1.21.1.1.5 获得年月 PF07AR01 -- [1..1]
							Node PF07AR01 = pf07aNode.selectSingleNode("PF07AR01");
							if (PF07AR01 != null) {
								pf07a.setPF07AR01(PF07AR01.getText());
							}
							// 1.21.1.1.6 到期年月 PF07AR02 -- [1..1]
							Node PF07AR02 = pf07aNode.selectSingleNode("PF07AR02");
							if (PF07AR02 != null) {
								pf07a.setPF07AR02(PF07AR02.getText());
							}
							// 1.21.1.1.7 吊销年月 PF07AR03 -- [1..1]
							Node PF07AR03 = pf07aNode.selectSingleNode("PF07AR03");
							if (PF07AR03 != null) {
								pf07a.setPF07AR03(PF07AR03.getText());
							}
							pf07.setPF07A(pf07a);
						}
						// 1.21.1.2 标注及声明信息段 PF07Z [0..1]
						Node pf07zNode = pf07Node.selectSingleNode("PF07Z");
						if (pf07zNode != null) {
							PF07Z pf07z = new PF07Z();
							PF07Zdata pf07zData = new PF07Zdata();
							pf07zData.setIdentityCardNo(identityCardNo);
							pf07zData.setUniqueRelid(uniqueRelid);
							pf07zData.setRelateId(relateId);
							// 1.21.1.2.1 标注及声明个数 PF07ZS01 -- [1..1]
							Node PF07ZS01 = pf07zNode.selectSingleNode("PF07ZS01");
							if (PF07ZS01 != null) {
								pf07zData.setPF07ZS01(PF07ZS01.getText());
							}
							pf07z.setPF07Zdata(pf07zData);
							// 1.21.1.2.2 标注及声明信息 PF07ZH [1..5]
							List<Element> pf07zhNodeList = pf07zNode.selectNodes("PF07ZH");
							if (pf07zhNodeList != null && pf07zhNodeList.size() > 0) {
								List<PF07ZH> pf07zhList = new ArrayList<PF07ZH>();
								for (int j = 0; j < pf07zhNodeList.size(); j++) {
									Element pf07zhNode = pf07zhNodeList.get(j);
									if (pf07zhNode == null) {
										continue;
									}
									PF07ZH pf07zh = new PF07ZH();
									pf07zh.setIdentityCardNo(identityCardNo);
									pf07zh.setUniqueRelid(uniqueRelid);
									pf07zh.setRelateId(relateId);
									// 1.21.1.2.2.1 标注及声明类型 PF07ZD01 -- [1..1]
									Node PF07ZD01 = pf07zhNode.selectSingleNode("PF07ZD01");
									if (PF07ZD01 != null) {
										pf07zh.setPF07ZD01(PF07ZD01.getText());
									}
									// 1.21.1.2.2.2 标注或声明内容 PF07ZQ01 -- [1..1]
									Node PF07ZQ01 = pf07zhNode.selectSingleNode("PF07ZQ01");
									if (PF07ZQ01 != null) {
										pf07zh.setPF07ZQ01(PF07ZQ01.getText());
									}
									// 1.21.1.2.2.3 添加日期 PF07ZR01 -- [1..1]
									Node PF07ZR01 = pf07zhNode.selectSingleNode("PF07ZR01");
									if (PF07ZR01 != null) {
										pf07zh.setPF07ZR01(PF07ZR01.getText());
									}
									pf07zhList.add(pf07zh);
								}
								pf07z.setPF07ZHList(pf07zhList);
							}
							pf07.setPF07Z(pf07z);
						}
						pf07List.add(pf07);
					}
					ppq.setPF07List(pf07List);
				}
				bank.setPPQ(ppq);
			}
			// 1.22 行政奖励记录 PAH [1..1]
			Node pahNode = rootNode.selectSingleNode("PAH");
			if (pahNode != null) {
				PAH pah = new PAH();
				// 1.22.1 行政奖励记录信息单元 PF08 [0..*]
				List<Element> pf08NodeList = pahNode.selectNodes("PF08");
				if (pf08NodeList != null && pf08NodeList.size() > 0) {
					List<PF08> pf08List = new ArrayList<PF08>();
					for (int i = 0; i < pf08NodeList.size(); i++) {
						Element pf08Node = pf08NodeList.get(i);
						if (pf08Node == null) {
							continue;
						}
						PF08 pf08 = new PF08();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						// 1.22.1.1 行政奖励记录信息段 PF08A [1..1]
						Node pf08aNode = pf08Node.selectSingleNode("PF08A");
						if (pf08aNode != null) {
							PF08A pf08a = new PF08A();
							pf08a.setIdentityCardNo(identityCardNo);
							pf08a.setUniqueRelid(uniqueRelid);
							pf08a.setRelateId(relateId);
							// 1.22.1.1.1 奖励机构 PF08AQ01 -- [1..1]
							Node PF08AQ01 = pf08aNode.selectSingleNode("PF08AQ01");
							if (PF08AQ01 != null) {
								pf08a.setPF08AQ01(PF08AQ01.getText());
							}
							// 1.22.1.1.2 奖励内容 PF08AQ02 -- [1..1]
							Node PF08AQ02 = pf08aNode.selectSingleNode("PF08AQ02");
							if (PF08AQ02 != null) {
								pf08a.setPF08AQ02(PF08AQ02.getText());
							}
							// 1.22.1.1.3 生效年月 PF08AR01 -- [1..1]
							Node PF08AR01 = pf08aNode.selectSingleNode("PF08AR01");
							if (PF08AR01 != null) {
								pf08a.setPF08AR01(PF08AR01.getText());
							}
							// 1.22.1.1.4 截止年月 PF08AR02 -- [1..1]
							Node PF08AR02 = pf08aNode.selectSingleNode("PF08AR02");
							if (PF08AR02 != null) {
								pf08a.setPF08AR02(PF08AR02.getText());
							}
							pf08.setPF08A(pf08a);
						}
						// 1.22.1.2 标注及声明信息段 PF08Z [0..1]
						Node pf08zNode = pf08Node.selectSingleNode("PF08Z");
						if (pf08zNode != null) {
							PF08Z pf08z = new PF08Z();
							PF08Zdata pf08zData = new PF08Zdata();
							pf08zData.setIdentityCardNo(identityCardNo);
							pf08zData.setUniqueRelid(uniqueRelid);
							pf08zData.setRelateId(relateId);
							// 1.22.1.2.1 标注及声明个数 PF08ZS01 -- [1..1]
							Node PF08ZS01 = pf08zNode.selectSingleNode("PF08ZS01");
							if (PF08ZS01 != null) {
								pf08zData.setPF08ZS01(PF08ZS01.getText());
							}
							pf08z.setPF08Zdata(pf08zData);
							// 1.22.1.2.2 标注及声明信息 PF08ZH [1..5]
							List<Element> pf08zhNodeList = pf08zNode.selectNodes("PF08ZH");
							if (pf08zhNodeList != null && pf08zhNodeList.size() > 0) {
								List<PF08ZH> pf08zhList = new ArrayList<PF08ZH>();
								for (int j = 0; j < pf08zhNodeList.size(); j++) {
									Node pf08zhNode = pf08zhNodeList.get(j);
									if (pf08zhNode == null) {
										continue;
									}
									PF08ZH pf08zh = new PF08ZH();
									pf08zh.setIdentityCardNo(identityCardNo);
									pf08zh.setUniqueRelid(uniqueRelid);
									pf08zh.setRelateId(relateId);
									// 1.22.1.2.2.1 标注及声明类型 PF08ZD01 -- [1..1]
									Node PF08ZD01 = pf08zhNode.selectSingleNode("PF08ZD01");
									if (PF08ZD01 != null) {
										pf08zh.setPF08ZD01(PF08ZD01.getText());
									}
									// 1.22.1.2.2.2 标注或声明内容 PF08ZQ01 -- [1..1]
									Node PF08ZQ01 = pf08zhNode.selectSingleNode("PF08ZQ01");
									if (PF08ZQ01 != null) {
										pf08zh.setPF08ZQ01(PF08ZQ01.getText());
									}
									// 1.22.1.2.2.3 添加日期 PF08ZR01 -- [1..1]
									Node PF08ZR01 = pf08zhNode.selectSingleNode("PF08ZR01");
									if (PF08ZR01 != null) {
										pf08zh.setPF08ZR01(PF08ZR01.getText());
									}
									pf08zhList.add(pf08zh);
								}
								pf08z.setPF08ZHList(pf08zhList);
							}
							pf08.setPF08Z(pf08z);
						}
						pf08List.add(pf08);
					}
					pah.setPF08List(pf08List);
				}
				bank.setPAH(pah);
			}
			// 1.23 其他标注及声明信息 POS [1..1]
			Node posNode = rootNode.selectSingleNode("POS");
			if (posNode != null) {
				POS pos = new POS();
				// 1.23.1 标注及声明信息单元 PG01 [0..*]
				List<Element> pg01NodeList = posNode.selectNodes("PG01");
				if (pg01NodeList != null && pg01NodeList.size() > 0) {
					List<PG01> pg01List = new ArrayList<PG01>();
					for (int i = 0; i < pg01NodeList.size(); i++) {
						Node pg01Node = pg01NodeList.get(i);
						if (pg01Node == null) {
							continue;
						}
						PG01 pg01 = new PG01();
						String relateId = GuidUtil.getGuid();// 关联的uuid
						PG01data pg01Data = new PG01data();
						pg01Data.setIdentityCardNo(identityCardNo);
						pg01Data.setUniqueRelid(uniqueRelid);
						pg01Data.setRelateId(relateId);
						// 1.23.1.1 对象类型 PG010D01 -- [1..1]
						Node PG010D01 = pg01Node.selectSingleNode("PG010D01");
						if (PG010D01 != null) {
							pg01Data.setPG010D01(PG010D01.getText());
						}
						// 1.23.1.2 对象标识 PG010D02 -- [1..1]
						Node PG010D02 = pg01Node.selectSingleNode("PG010D02");
						if (PG010D02 != null) {
							pg01Data.setPG010D02(PG010D02.getText());
						}
						// 1.23.1.3 标注及声明类型个数 PG010S01 -- [1..1]
						Node PG010S01 = pg01Node.selectSingleNode("PG010S01");
						if (PG010S01 != null) {
							pg01Data.setPG010S01(PG010S01.getText());
						}
						pg01.setPG01data(pg01Data);
						// 1.23.1.4 标注及声明信息 PG010H [1..5]
						List<Element> pg010hNodeList = pg01Node.selectNodes("PG010H");
						if (pg010hNodeList != null && pg010hNodeList.size() > 0) {
							List<PG010H> pg010hList = new ArrayList<PG010H>();
							for (int j = 0; j < pg010hNodeList.size(); j++) {
								Element pg010hNode = pg010hNodeList.get(j);
								if (pg010hNode == null) {
									continue;
								}
								PG010H pg010h = new PG010H();
								pg010h.setIdentityCardNo(identityCardNo);
								pg010h.setUniqueRelid(uniqueRelid);
								pg010h.setRelateId(relateId);
								// 1.23.1.4.1 标注及声明类型 PG010D03 -- [1..1]
								Node PG010D03 = pg010hNode.selectSingleNode("PG010D03");
								if (PG010D03 != null) {
									pg010h.setPG010D03(PG010D03.getText());
								}
								// 1.23.1.4.2 标注或声明内容 PG010Q01 -- [1..1]
								Node PG010Q01 = pg010hNode.selectSingleNode("PG010Q01");
								if (PG010Q01 != null) {
									pg010h.setPG010Q01(PG010Q01.getText());
								}
								// 1.23.1.4.3 添加日期 PG010R01 -- [1..1]
								Node PG010R01 = pg010hNode.selectSingleNode("PG010R01");
								if (PG010R01 != null) {
									pg010h.setPG010R01(PG010R01.getText());
								}
								pg010hList.add(pg010h);
							}
							pg01.setPG010HList(pg010hList);
						}
						pg01List.add(pg01);
					}
					pos.setPG01List(pg01List);
				}
				bank.setPOS(pos);
			}
			// 1.24 查询记录 POQ [1..1]
			Node poqNode = rootNode.selectSingleNode("POQ");
			if (poqNode != null) {
				POQ poq = new POQ();
				// 1.24.1 查询记录信息单元 PH01 [0..*]
				List<Element> ph01NodeList = poqNode.selectNodes("PH01");
				if (ph01NodeList != null && ph01NodeList.size() > 0) {
					List<PH01> ph01List = new ArrayList<PH01>();
					for (int i = 0; i < ph01NodeList.size(); i++) {
						Element ph01Node = ph01NodeList.get(i);
						if (ph01Node == null) {
							continue;
						}
						PH01 ph01 = new PH01();
						ph01.setIdentityCardNo(identityCardNo);
						ph01.setUniqueRelid(uniqueRelid);
						// 1.24.1.1 查询日期 PH010R01 -- [1..1]
						Node PH010R01 = ph01Node.selectSingleNode("PH010R01");
						if (PH010R01 != null) {
							ph01.setPH010R01(PH010R01.getText());
						}
						// 1.24.1.2 查询机构类型 PH010D01 -- [1..1]
						Node PH010D01 = ph01Node.selectSingleNode("PH010D01");
						if (PH010D01 != null) {
							ph01.setPH010D01(PH010D01.getText());
						}
						// 1.24.1.3 查询机构 PH010Q02 -- [1..1]
						Node PH010Q02 = ph01Node.selectSingleNode("PH010Q02");
						if (PH010Q02 != null) {
							ph01.setPH010Q02(PH010Q02.getText());
						}
						// 1.24.1.4 查询原因 PH010Q03 -- [1..1]
						Node PH010Q03 = ph01Node.selectSingleNode("PH010Q03");
						if (PH010Q03 != null) {
							ph01.setPH010Q03(PH010Q03.getText());
						}
						ph01List.add(ph01);
					}
					poq.setPH01List(ph01List);
				}
				bank.setPOQ(poq);
			}
		}
		return bank;
	}

}
