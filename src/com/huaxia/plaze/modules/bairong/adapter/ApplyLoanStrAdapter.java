package com.huaxia.plaze.modules.bairong.adapter;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStr;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrBase;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrDay15;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrDay7;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrFst;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrLst;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMonth1;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMonth12;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMonth3;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMonth6;
import com.huaxia.util.GuidUtil;

import net.sf.json.JSONObject;

/**
 * 解析百融三方返回的数据，实现数据解析到Java类中，然后把Java类数据入库 code 16000行
 * 
 * @author liuwei
 */
public class ApplyLoanStrAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ApplyLoanStrAdapter.class);

	/**
	 * @Title: parseApplyLoanStr
	 * @Description:解析百融返回的多头借贷的报文，实现数据正确的解析然后入库
	 * @param params
	 * @return
	 * @author: LiuWei
	 * @Date: 2019年5月31日下午6:09:12
	 * @author zhiguo.li, 2019-09-11, 增加关联属性"uukey"解析赋值
	 */
	public static ApplyLoanStr parseApplyLoanStr(Map<String, Object> params) {
		String name = (String) params.get("name");
		String crtNo = (String) params.get("crtNo");
		String mobile = (String) params.get("mobile");
		String crtUser = (String) params.get("crtUser");
		String trnId = (String) params.get("trnId");
		String appId = (String) params.get("appId");
		String message = (String) params.get("message");
		String cardAccount = (String) params.get("cardAccount");
		String sequence =  (String)params.get("sequence");
		// 初始化Java类
		ApplyLoanStr applyLoanStr = new ApplyLoanStr();

		if (StringUtils.isBlank(message)) {
			if (logger.isErrorEnabled()) {
				logger.error("[客户端 & 百融多头借贷] 数据解析异常! {}", "百融多头借贷返回信息报文为空");
			}
			return null;
		}

		String trnKey = GuidUtil.getGuid();

		try {
			// 开始解析JSON格式的返回数据
			JSONObject json = JSONObject.fromObject(message);
			if (json != null && (!json.isEmpty())) {
				ApplyLoanStrBase applyLoanStrBase = new ApplyLoanStrBase();
				applyLoanStrBase.setUuid(GuidUtil.getGuid());
				applyLoanStrBase.setCrtTime(new Date());
				applyLoanStrBase.setCrtUser(crtUser);
				applyLoanStrBase.setTrnId(trnId);
				applyLoanStrBase.setAppId(appId);
				applyLoanStrBase.setName(name);
				applyLoanStrBase.setCertNo(crtNo);
				applyLoanStrBase.setMobile(mobile);
				applyLoanStrBase.setTrnKey(trnKey);
				applyLoanStrBase.setCradAccount(cardAccount);
				if (StringUtils.isNotBlank(sequence)) {
					applyLoanStrBase.setSequence((Long)Long.parseLong(sequence));
				}
			
				applyLoanStr.setApplyLoanStrBase(applyLoanStrBase);
				if (json.containsKey("swift_number") && json.getString("swift_number") != null
						&& !"".equals(json.getString("swift_number"))) {
					applyLoanStrBase.setSwiftNumber(json.getString("swift_number"));
				}
				if (json.containsKey("code") && json.getString("code") != null && !"".equals(json.getString("code"))) {
					applyLoanStrBase.setCode(json.getString("code"));
				}
				if (json.containsKey("Flag") && json.getString("Flag") != null && !"".equals(json.getString("Flag"))) {
					JSONObject flagJSON = JSONObject.fromObject(json.getString("Flag"));
					if (flagJSON != null) {
						if (flagJSON.containsKey("applyloanstr") && flagJSON.getString("applyloanstr") != null
								&& !"".equals(flagJSON.getString("applyloanstr"))) {
							applyLoanStrBase.setFlagApplyloanstr(flagJSON.getString("applyloanstr"));
						}
					}
				}
				if (json.containsKey("ApplyLoanStr") && json.getString("ApplyLoanStr") != null
						&& !"".equals(json.getString("ApplyLoanStr"))) {
					JSONObject applyLoanStrJSON = JSONObject.fromObject(json.getString("ApplyLoanStr"));
					if (applyLoanStrJSON != null && (!applyLoanStrJSON.isEmpty())) {
						if (applyLoanStrJSON.containsKey("d7") && applyLoanStrJSON.getString("d7") != null
								&& !"".equals(applyLoanStrJSON.getString("d7"))) {
							JSONObject d7JSON = JSONObject.fromObject(applyLoanStrJSON.getString("d7"));
							if (d7JSON != null && (!d7JSON.isEmpty())) {
								ApplyLoanStrDay7 applyLoanStrD7 = new ApplyLoanStrDay7();
								applyLoanStrD7.setUuid(GuidUtil.getGuid());
								applyLoanStrD7.setCrtTime(new Date());
								applyLoanStrD7.setCrtUser(crtUser);
								applyLoanStrD7.setTrnId(trnId);
								applyLoanStrD7.setAppId(appId);
								applyLoanStrD7.setTrnKey(trnKey);
								applyLoanStr.setApplyLoanStrD7(applyLoanStrD7);
								if (d7JSON.containsKey("id") && d7JSON.getString("id") != null
										&& !"".equals(d7JSON.getString("id"))) {
									JSONObject idJSON = JSONObject.fromObject(d7JSON.getString("id"));
									if (idJSON != null) {
										if (idJSON.containsKey("pdl") && idJSON.getString("pdl") != null
												&& !"".equals(idJSON.getString("pdl"))) {
											JSONObject pdlJSON = JSONObject.fromObject(idJSON.getString("pdl"));
											if (pdlJSON != null) {
												if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
														&& !"".equals(pdlJSON.getString("allnum"))) {
													applyLoanStrD7.setD7IdPdlAllnum(pdlJSON.getString("allnum"));
												}
												if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
														&& !"".equals(pdlJSON.getString("orgnum"))) {
													applyLoanStrD7.setD7IdPdlOrgnum(pdlJSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("caon") && idJSON.getString("caon") != null
												&& !"".equals(idJSON.getString("caon"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("caon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7IdCaonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7IdCaonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("rel") && idJSON.getString("rel") != null
												&& !"".equals(idJSON.getString("rel"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("rel"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7IdRelAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7IdRelOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("caoff") && idJSON.getString("caoff") != null
												&& !"".equals(idJSON.getString("caoff"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("caoff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7IdCaoffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7IdCaoffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("cooff") && idJSON.getString("cooff") != null
												&& !"".equals(idJSON.getString("cooff"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("cooff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7IdCooffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7IdCooffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("af") && idJSON.getString("af") != null
												&& !"".equals(idJSON.getString("af"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("af"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7IdAfAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7IdAfOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("coon") && idJSON.getString("coon") != null
												&& !"".equals(idJSON.getString("coon"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("coon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7IdCoonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7IdCoonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("oth") && idJSON.getString("oth") != null
												&& !"".equals(idJSON.getString("oth"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("oth"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7IdOthAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7IdOthOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("bank") && idJSON.getString("bank") != null
												&& !"".equals(idJSON.getString("bank"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("bank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrD7.setD7IdBankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7IdBankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("tra_allnum")
														&& JSON.getString("tra_allnum") != null
														&& !"".equals(JSON.getString("tra_allnum"))) {
													applyLoanStrD7.setD7IdBankTraAllnum(JSON.getString("tra_allnum"));
												}
												if (JSON.containsKey("ret_allnum")
														&& JSON.getString("ret_allnum") != null
														&& !"".equals(JSON.getString("ret_allnum"))) {
													applyLoanStrD7.setD7IdBankRetAllnum(JSON.getString("ret_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7IdBankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("tra_orgnum")
														&& JSON.getString("tra_orgnum") != null
														&& !"".equals(JSON.getString("tra_orgnum"))) {
													applyLoanStrD7.setD7IdBankTraOrgnum(JSON.getString("tra_orgnum"));
												}
												if (JSON.containsKey("ret_orgnum")
														&& JSON.getString("ret_orgnum") != null
														&& !"".equals(JSON.getString("ret_orgnum"))) {
													applyLoanStrD7.setD7IdBankRetOrgnum(JSON.getString("ret_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrD7.setD7IdBankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrD7.setD7IdBankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrD7
															.setD7IdBankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrD7
															.setD7IdBankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
										if (idJSON.containsKey("nbank") && idJSON.getString("nbank") != null
												&& !"".equals(idJSON.getString("nbank"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("nbank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrD7.setD7IdNbankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7IdNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrD7.setD7IdNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrD7.setD7IdNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrD7.setD7IdNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrD7.setD7IdNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrD7.setD7IdNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrD7.setD7IdNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankNsloanAllnum(JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrD7.setD7IdNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankFinleaAllnum(JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7IdNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrD7.setD7IdNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrD7.setD7IdNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrD7.setD7IdNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrD7.setD7IdNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrD7.setD7IdNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrD7.setD7IdNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankNsloanAllnum(JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrD7.setD7IdNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankFinleaAllnum(JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7IdNbankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("p2p_orgnum")
														&& JSON.getString("p2p_orgnum") != null
														&& !"".equals(JSON.getString("p2p_orgnum"))) {
													applyLoanStrD7.setD7IdNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
												}
												if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
														&& !"".equals(JSON.getString("mc_orgnum"))) {
													applyLoanStrD7.setD7IdNbankMcOrgnum(JSON.getString("mc_orgnum"));
												}
												if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
														&& !"".equals(JSON.getString("ca_orgnum"))) {
													applyLoanStrD7.setD7IdNbankCaOrgnum(JSON.getString("ca_orgnum"));
												}
												if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
														&& !"".equals(JSON.getString("cf_orgnum"))) {
													applyLoanStrD7.setD7IdNbankCfOrgnum(JSON.getString("cf_orgnum"));
												}
												if (JSON.containsKey("com_orgnum")
														&& JSON.getString("com_orgnum") != null
														&& !"".equals(JSON.getString("com_orgnum"))) {
													applyLoanStrD7.setD7IdNbankComOrgnum(JSON.getString("com_orgnum"));
												}
												if (JSON.containsKey("oth_orgnum")
														&& JSON.getString("oth_orgnum") != null
														&& !"".equals(JSON.getString("oth_orgnum"))) {
													applyLoanStrD7.setD7IdNbankOthOrgnum(JSON.getString("oth_orgnum"));
												}
												if (JSON.containsKey("nsloan_orgnum")
														&& JSON.getString("nsloan_orgnum") != null
														&& !"".equals(JSON.getString("nsloan_orgnum"))) {
													applyLoanStrD7
															.setD7IdNbankNsloanOrgnum(JSON.getString("nsloan_orgnum"));
												}
												if (JSON.containsKey("autofin_orgnum")
														&& JSON.getString("autofin_orgnum") != null
														&& !"".equals(JSON.getString("autofin_orgnum"))) {
													applyLoanStrD7.setD7IdNbankAutofinOrgnum(
															JSON.getString("autofin_orgnum"));
												}
												if (JSON.containsKey("sloan_orgnum")
														&& JSON.getString("sloan_orgnum") != null
														&& !"".equals(JSON.getString("sloan_orgnum"))) {
													applyLoanStrD7
															.setD7IdNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
												}
												if (JSON.containsKey("cons_orgnum")
														&& JSON.getString("cons_orgnum") != null
														&& !"".equals(JSON.getString("cons_orgnum"))) {
													applyLoanStrD7
															.setD7IdNbankConsOrgnum(JSON.getString("cons_orgnum"));
												}
												if (JSON.containsKey("finlea_orgnum")
														&& JSON.getString("finlea_orgnum") != null
														&& !"".equals(JSON.getString("finlea_orgnum"))) {
													applyLoanStrD7
															.setD7IdNbankFinleaOrgnum(JSON.getString("finlea_orgnum"));
												}
												if (JSON.containsKey("else_orgnum")
														&& JSON.getString("else_orgnum") != null
														&& !"".equals(JSON.getString("else_orgnum"))) {
													applyLoanStrD7
															.setD7IdNbankElseOrgnum(JSON.getString("else_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrD7
															.setD7IdNbankWeekOrgnum(JSON.getString("week_orgnum"));
												}

												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrD7
															.setD7IdNbankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrD7
															.setD7IdNbankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
									}
								}

								if (d7JSON.containsKey("cell") && d7JSON.getString("cell") != null
										&& !"".equals(d7JSON.getString("cell"))) {
									JSONObject cellJSON = JSONObject.fromObject(d7JSON.getString("cell"));
									if (cellJSON != null) {
										if (cellJSON.containsKey("pdl") && cellJSON.getString("pdl") != null
												&& !"".equals(cellJSON.getString("pdl"))) {
											JSONObject pdlJSON = JSONObject.fromObject(cellJSON.getString("pdl"));
											if (pdlJSON != null) {
												if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
														&& !"".equals(pdlJSON.getString("allnum"))) {
													applyLoanStrD7.setD7CellPdlAllnum(pdlJSON.getString("allnum"));
												}
												if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
														&& !"".equals(pdlJSON.getString("orgnum"))) {
													applyLoanStrD7.setD7CellPdlOrgnum(pdlJSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("caon") && cellJSON.getString("caon") != null
												&& !"".equals(cellJSON.getString("caon"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7CellCaonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7CellCaonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("rel") && cellJSON.getString("rel") != null
												&& !"".equals(cellJSON.getString("rel"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("rel"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7CellRelAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7CellRelOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("caoff") && cellJSON.getString("caoff") != null
												&& !"".equals(cellJSON.getString("caoff"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caoff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7CellCaoffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7CellCaoffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("cooff") && cellJSON.getString("cooff") != null
												&& !"".equals(cellJSON.getString("cooff"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("cooff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7CellCooffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7CellCooffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("af") && cellJSON.getString("af") != null
												&& !"".equals(cellJSON.getString("af"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("af"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7CellAfAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7CellAfOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("coon") && cellJSON.getString("coon") != null
												&& !"".equals(cellJSON.getString("coon"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("coon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7CellCoonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7CellCoonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("oth") && cellJSON.getString("oth") != null
												&& !"".equals(cellJSON.getString("oth"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("oth"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7CellOthAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7CellOthOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("bank") && cellJSON.getString("bank") != null
												&& !"".equals(cellJSON.getString("bank"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("bank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrD7.setD7CellBankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7CellBankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("tra_allnum")
														&& JSON.getString("tra_allnum") != null
														&& !"".equals(JSON.getString("tra_allnum"))) {
													applyLoanStrD7.setD7CellBankTraAllnum(JSON.getString("tra_allnum"));
												}
												if (JSON.containsKey("ret_allnum")
														&& JSON.getString("ret_allnum") != null
														&& !"".equals(JSON.getString("ret_allnum"))) {
													applyLoanStrD7.setD7CellBankRetAllnum(JSON.getString("ret_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7CellBankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("tra_orgnum")
														&& JSON.getString("tra_orgnum") != null
														&& !"".equals(JSON.getString("tra_orgnum"))) {
													applyLoanStrD7.setD7CellBankTraOrgnum(JSON.getString("tra_orgnum"));
												}
												if (JSON.containsKey("ret_orgnum")
														&& JSON.getString("ret_orgnum") != null
														&& !"".equals(JSON.getString("ret_orgnum"))) {
													applyLoanStrD7.setD7CellBankRetOrgnum(JSON.getString("ret_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrD7
															.setD7CellBankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrD7
															.setD7CellBankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrD7
															.setD7CellBankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrD7
															.setD7CellBankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("nbank") && cellJSON.getString("nbank") != null
												&& !"".equals(cellJSON.getString("nbank"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("nbank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrD7.setD7CellNbankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7CellNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrD7.setD7CellNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrD7.setD7CellNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrD7.setD7CellNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrD7.setD7CellNbankNsloanAllnum(
															JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrD7.setD7CellNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrD7.setD7CellNbankFinleaAllnum(
															JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD7.setD7CellNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrD7.setD7CellNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrD7.setD7CellNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrD7.setD7CellNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrD7.setD7CellNbankNsloanAllnum(
															JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrD7.setD7CellNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrD7.setD7CellNbankFinleaAllnum(
															JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD7.setD7CellNbankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("p2p_orgnum")
														&& JSON.getString("p2p_orgnum") != null
														&& !"".equals(JSON.getString("p2p_orgnum"))) {
													applyLoanStrD7
															.setD7CellNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
												}
												if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
														&& !"".equals(JSON.getString("mc_orgnum"))) {
													applyLoanStrD7.setD7CellNbankMcOrgnum(JSON.getString("mc_orgnum"));
												}
												if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
														&& !"".equals(JSON.getString("ca_orgnum"))) {
													applyLoanStrD7.setD7CellNbankCaOrgnum(JSON.getString("ca_orgnum"));
												}
												if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
														&& !"".equals(JSON.getString("cf_orgnum"))) {
													applyLoanStrD7.setD7CellNbankCfOrgnum(JSON.getString("cf_orgnum"));
												}
												if (JSON.containsKey("com_orgnum")
														&& JSON.getString("com_orgnum") != null
														&& !"".equals(JSON.getString("com_orgnum"))) {
													applyLoanStrD7
															.setD7CellNbankComOrgnum(JSON.getString("com_orgnum"));
												}
												if (JSON.containsKey("oth_orgnum")
														&& JSON.getString("oth_orgnum") != null
														&& !"".equals(JSON.getString("oth_orgnum"))) {
													applyLoanStrD7
															.setD7CellNbankOthOrgnum(JSON.getString("oth_orgnum"));
												}
												if (JSON.containsKey("nsloan_orgnum")
														&& JSON.getString("nsloan_orgnum") != null
														&& !"".equals(JSON.getString("nsloan_orgnum"))) {
													applyLoanStrD7.setD7CellNbankNsloanOrgnum(
															JSON.getString("nsloan_orgnum"));
												}
												if (JSON.containsKey("autofin_orgnum")
														&& JSON.getString("autofin_orgnum") != null
														&& !"".equals(JSON.getString("autofin_orgnum"))) {
													applyLoanStrD7.setD7CellNbankAutofinOrgnum(
															JSON.getString("autofin_orgnum"));
												}
												if (JSON.containsKey("sloan_orgnum")
														&& JSON.getString("sloan_orgnum") != null
														&& !"".equals(JSON.getString("sloan_orgnum"))) {
													applyLoanStrD7
															.setD7CellNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
												}
												if (JSON.containsKey("cons_orgnum")
														&& JSON.getString("cons_orgnum") != null
														&& !"".equals(JSON.getString("cons_orgnum"))) {
													applyLoanStrD7
															.setD7CellNbankConsOrgnum(JSON.getString("cons_orgnum"));
												}
												if (JSON.containsKey("finlea_orgnum")
														&& JSON.getString("finlea_orgnum") != null
														&& !"".equals(JSON.getString("finlea_orgnum"))) {
													applyLoanStrD7.setD7CellNbankFinleaOrgnum(
															JSON.getString("finlea_orgnum"));
												}
												if (JSON.containsKey("else_orgnum")
														&& JSON.getString("else_orgnum") != null
														&& !"".equals(JSON.getString("else_orgnum"))) {
													applyLoanStrD7
															.setD7CellNbankElseOrgnum(JSON.getString("else_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrD7
															.setD7CellNbankWeekOrgnum(JSON.getString("week_orgnum"));
												}

												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrD7
															.setD7CellNbankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrD7
															.setD7CellNbankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
									}
								}
							}
						}
						if (applyLoanStrJSON.containsKey("d15") && applyLoanStrJSON.getString("d15") != null
								&& !"".equals(applyLoanStrJSON.getString("d15"))) {
							JSONObject d15JSON = JSONObject.fromObject(applyLoanStrJSON.getString("d15"));
							if (d15JSON != null && (!d15JSON.isEmpty())) {
								ApplyLoanStrDay15 applyLoanStrD15 = new ApplyLoanStrDay15();
								applyLoanStrD15.setUuid(GuidUtil.getGuid());
								applyLoanStrD15.setCrtTime(new Date());
								applyLoanStrD15.setCrtUser(crtUser);
								applyLoanStrD15.setTrnId(trnId);
								applyLoanStrD15.setAppId(appId);
								applyLoanStrD15.setTrnKey(trnKey);
								applyLoanStr.setApplyLoanStrD15(applyLoanStrD15);
								if (d15JSON.containsKey("id") && d15JSON.getString("id") != null
										&& !"".equals(d15JSON.getString("id"))) {
									JSONObject idJSON = JSONObject.fromObject(d15JSON.getString("id"));
									if (idJSON != null) {
										if (idJSON.containsKey("pdl") && idJSON.getString("pdl") != null
												&& !"".equals(idJSON.getString("pdl"))) {
											JSONObject pdlJSON = JSONObject.fromObject(idJSON.getString("pdl"));
											if (pdlJSON != null) {
												if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
														&& !"".equals(pdlJSON.getString("allnum"))) {
													applyLoanStrD15.setD15IdPdlAllnum(pdlJSON.getString("allnum"));
												}
												if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
														&& !"".equals(pdlJSON.getString("orgnum"))) {
													applyLoanStrD15.setD15IdPdlOrgnum(pdlJSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("caon") && idJSON.getString("caon") != null
												&& !"".equals(idJSON.getString("caon"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("caon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15IdCaonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15IdCaonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("rel") && idJSON.getString("rel") != null
												&& !"".equals(idJSON.getString("rel"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("rel"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15IdRelAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15IdRelOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("caoff") && idJSON.getString("caoff") != null
												&& !"".equals(idJSON.getString("caoff"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("caoff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15IdCaoffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15IdCaoffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("cooff") && idJSON.getString("cooff") != null
												&& !"".equals(idJSON.getString("cooff"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("cooff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15IdCooffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15IdCooffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("af") && idJSON.getString("af") != null
												&& !"".equals(idJSON.getString("af"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("af"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15IdAfAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15IdAfOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("coon") && idJSON.getString("coon") != null
												&& !"".equals(idJSON.getString("coon"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("coon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15IdCoonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15IdCoonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("oth") && idJSON.getString("oth") != null
												&& !"".equals(idJSON.getString("oth"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("oth"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15IdOthAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15IdOthOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("bank") && idJSON.getString("bank") != null
												&& !"".equals(idJSON.getString("bank"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("bank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrD15.setD15IdBankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15IdBankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("tra_allnum")
														&& JSON.getString("tra_allnum") != null
														&& !"".equals(JSON.getString("tra_allnum"))) {
													applyLoanStrD15.setD15IdBankTraAllnum(JSON.getString("tra_allnum"));
												}
												if (JSON.containsKey("ret_allnum")
														&& JSON.getString("ret_allnum") != null
														&& !"".equals(JSON.getString("ret_allnum"))) {
													applyLoanStrD15.setD15IdBankRetAllnum(JSON.getString("ret_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15IdBankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("tra_orgnum")
														&& JSON.getString("tra_orgnum") != null
														&& !"".equals(JSON.getString("tra_orgnum"))) {
													applyLoanStrD15.setD15IdBankTraOrgnum(JSON.getString("tra_orgnum"));
												}
												if (JSON.containsKey("ret_orgnum")
														&& JSON.getString("ret_orgnum") != null
														&& !"".equals(JSON.getString("ret_orgnum"))) {
													applyLoanStrD15.setD15IdBankRetOrgnum(JSON.getString("ret_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrD15
															.setD15IdBankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrD15
															.setD15IdBankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrD15
															.setD15IdBankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrD15
															.setD15IdBankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
										if (idJSON.containsKey("nbank") && idJSON.getString("nbank") != null
												&& !"".equals(idJSON.getString("nbank"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("nbank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrD15.setD15IdNbankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15IdNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrD15.setD15IdNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrD15.setD15IdNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrD15.setD15IdNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankNsloanAllnum(JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrD15.setD15IdNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankFinleaAllnum(JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15IdNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrD15.setD15IdNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrD15.setD15IdNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrD15.setD15IdNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankNsloanAllnum(JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrD15.setD15IdNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankFinleaAllnum(JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15IdNbankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("p2p_orgnum")
														&& JSON.getString("p2p_orgnum") != null
														&& !"".equals(JSON.getString("p2p_orgnum"))) {
													applyLoanStrD15
															.setD15IdNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
												}
												if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
														&& !"".equals(JSON.getString("mc_orgnum"))) {
													applyLoanStrD15.setD15IdNbankMcOrgnum(JSON.getString("mc_orgnum"));
												}
												if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
														&& !"".equals(JSON.getString("ca_orgnum"))) {
													applyLoanStrD15.setD15IdNbankCaOrgnum(JSON.getString("ca_orgnum"));
												}
												if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
														&& !"".equals(JSON.getString("cf_orgnum"))) {
													applyLoanStrD15.setD15IdNbankCfOrgnum(JSON.getString("cf_orgnum"));
												}
												if (JSON.containsKey("com_orgnum")
														&& JSON.getString("com_orgnum") != null
														&& !"".equals(JSON.getString("com_orgnum"))) {
													applyLoanStrD15
															.setD15IdNbankComOrgnum(JSON.getString("com_orgnum"));
												}
												if (JSON.containsKey("oth_orgnum")
														&& JSON.getString("oth_orgnum") != null
														&& !"".equals(JSON.getString("oth_orgnum"))) {
													applyLoanStrD15
															.setD15IdNbankOthOrgnum(JSON.getString("oth_orgnum"));
												}
												if (JSON.containsKey("nsloan_orgnum")
														&& JSON.getString("nsloan_orgnum") != null
														&& !"".equals(JSON.getString("nsloan_orgnum"))) {
													applyLoanStrD15
															.setD15IdNbankNsloanOrgnum(JSON.getString("nsloan_orgnum"));
												}
												if (JSON.containsKey("autofin_orgnum")
														&& JSON.getString("autofin_orgnum") != null
														&& !"".equals(JSON.getString("autofin_orgnum"))) {
													applyLoanStrD15.setD15IdNbankAutofinOrgnum(
															JSON.getString("autofin_orgnum"));
												}
												if (JSON.containsKey("sloan_orgnum")
														&& JSON.getString("sloan_orgnum") != null
														&& !"".equals(JSON.getString("sloan_orgnum"))) {
													applyLoanStrD15
															.setD15IdNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
												}
												if (JSON.containsKey("cons_orgnum")
														&& JSON.getString("cons_orgnum") != null
														&& !"".equals(JSON.getString("cons_orgnum"))) {
													applyLoanStrD15
															.setD15IdNbankConsOrgnum(JSON.getString("cons_orgnum"));
												}
												if (JSON.containsKey("finlea_orgnum")
														&& JSON.getString("finlea_orgnum") != null
														&& !"".equals(JSON.getString("finlea_orgnum"))) {
													applyLoanStrD15
															.setD15IdNbankFinleaOrgnum(JSON.getString("finlea_orgnum"));
												}
												if (JSON.containsKey("else_orgnum")
														&& JSON.getString("else_orgnum") != null
														&& !"".equals(JSON.getString("else_orgnum"))) {
													applyLoanStrD15
															.setD15IdNbankElseOrgnum(JSON.getString("else_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrD15
															.setD15IdNbankWeekOrgnum(JSON.getString("week_orgnum"));
												}

												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrD15
															.setD15IdNbankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrD15
															.setD15IdNbankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
									}
								}

								if (d15JSON.containsKey("cell") && d15JSON.getString("cell") != null
										&& !"".equals(d15JSON.getString("cell"))) {
									JSONObject cellJSON = JSONObject.fromObject(d15JSON.getString("cell"));
									if (cellJSON != null) {
										if (cellJSON.containsKey("pdl") && cellJSON.getString("pdl") != null
												&& !"".equals(cellJSON.getString("pdl"))) {
											JSONObject pdlJSON = JSONObject.fromObject(cellJSON.getString("pdl"));
											if (pdlJSON != null) {
												if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
														&& !"".equals(pdlJSON.getString("allnum"))) {
													applyLoanStrD15.setD15CellPdlAllnum(pdlJSON.getString("allnum"));
												}
												if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
														&& !"".equals(pdlJSON.getString("orgnum"))) {
													applyLoanStrD15.setD15CellPdlOrgnum(pdlJSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("caon") && cellJSON.getString("caon") != null
												&& !"".equals(cellJSON.getString("caon"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15CellCaonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15CellCaonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("rel") && cellJSON.getString("rel") != null
												&& !"".equals(cellJSON.getString("rel"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("rel"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15CellRelAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15CellRelOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("caoff") && cellJSON.getString("caoff") != null
												&& !"".equals(cellJSON.getString("caoff"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caoff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15CellCaoffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15CellCaoffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("cooff") && cellJSON.getString("cooff") != null
												&& !"".equals(cellJSON.getString("cooff"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("cooff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15CellCooffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15CellCooffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("af") && cellJSON.getString("af") != null
												&& !"".equals(cellJSON.getString("af"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("af"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15CellAfAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15CellAfOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("coon") && cellJSON.getString("coon") != null
												&& !"".equals(cellJSON.getString("coon"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("coon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15CellCoonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15CellCoonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("oth") && cellJSON.getString("oth") != null
												&& !"".equals(cellJSON.getString("oth"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("oth"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15CellOthAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15CellOthOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("bank") && cellJSON.getString("bank") != null
												&& !"".equals(cellJSON.getString("bank"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("bank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrD15.setD15CellBankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15CellBankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("tra_allnum")
														&& JSON.getString("tra_allnum") != null
														&& !"".equals(JSON.getString("tra_allnum"))) {
													applyLoanStrD15
															.setD15CellBankTraAllnum(JSON.getString("tra_allnum"));
												}
												if (JSON.containsKey("ret_allnum")
														&& JSON.getString("ret_allnum") != null
														&& !"".equals(JSON.getString("ret_allnum"))) {
													applyLoanStrD15
															.setD15CellBankRetAllnum(JSON.getString("ret_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15CellBankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("tra_orgnum")
														&& JSON.getString("tra_orgnum") != null
														&& !"".equals(JSON.getString("tra_orgnum"))) {
													applyLoanStrD15
															.setD15CellBankTraOrgnum(JSON.getString("tra_orgnum"));
												}
												if (JSON.containsKey("ret_orgnum")
														&& JSON.getString("ret_orgnum") != null
														&& !"".equals(JSON.getString("ret_orgnum"))) {
													applyLoanStrD15
															.setD15CellBankRetOrgnum(JSON.getString("ret_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrD15
															.setD15CellBankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrD15
															.setD15CellBankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrD15
															.setD15CellBankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrD15
															.setD15CellBankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("nbank") && cellJSON.getString("nbank") != null
												&& !"".equals(cellJSON.getString("nbank"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("nbank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrD15.setD15CellNbankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15CellNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrD15.setD15CellNbankNsloanAllnum(
															JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrD15.setD15CellNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrD15.setD15CellNbankFinleaAllnum(
															JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrD15.setD15CellNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrD15.setD15CellNbankNsloanAllnum(
															JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrD15.setD15CellNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrD15.setD15CellNbankFinleaAllnum(
															JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrD15.setD15CellNbankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("p2p_orgnum")
														&& JSON.getString("p2p_orgnum") != null
														&& !"".equals(JSON.getString("p2p_orgnum"))) {
													applyLoanStrD15
															.setD15CellNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
												}
												if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
														&& !"".equals(JSON.getString("mc_orgnum"))) {
													applyLoanStrD15
															.setD15CellNbankMcOrgnum(JSON.getString("mc_orgnum"));
												}
												if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
														&& !"".equals(JSON.getString("ca_orgnum"))) {
													applyLoanStrD15
															.setD15CellNbankCaOrgnum(JSON.getString("ca_orgnum"));
												}
												if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
														&& !"".equals(JSON.getString("cf_orgnum"))) {
													applyLoanStrD15
															.setD15CellNbankCfOrgnum(JSON.getString("cf_orgnum"));
												}
												if (JSON.containsKey("com_orgnum")
														&& JSON.getString("com_orgnum") != null
														&& !"".equals(JSON.getString("com_orgnum"))) {
													applyLoanStrD15
															.setD15CellNbankComOrgnum(JSON.getString("com_orgnum"));
												}
												if (JSON.containsKey("oth_orgnum")
														&& JSON.getString("oth_orgnum") != null
														&& !"".equals(JSON.getString("oth_orgnum"))) {
													applyLoanStrD15
															.setD15CellNbankOthOrgnum(JSON.getString("oth_orgnum"));
												}
												if (JSON.containsKey("nsloan_orgnum")
														&& JSON.getString("nsloan_orgnum") != null
														&& !"".equals(JSON.getString("nsloan_orgnum"))) {
													applyLoanStrD15.setD15CellNbankNsloanOrgnum(
															JSON.getString("nsloan_orgnum"));
												}
												if (JSON.containsKey("autofin_orgnum")
														&& JSON.getString("autofin_orgnum") != null
														&& !"".equals(JSON.getString("autofin_orgnum"))) {
													applyLoanStrD15.setD15CellNbankAutofinOrgnum(
															JSON.getString("autofin_orgnum"));
												}
												if (JSON.containsKey("sloan_orgnum")
														&& JSON.getString("sloan_orgnum") != null
														&& !"".equals(JSON.getString("sloan_orgnum"))) {
													applyLoanStrD15
															.setD15CellNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
												}
												if (JSON.containsKey("cons_orgnum")
														&& JSON.getString("cons_orgnum") != null
														&& !"".equals(JSON.getString("cons_orgnum"))) {
													applyLoanStrD15
															.setD15CellNbankConsOrgnum(JSON.getString("cons_orgnum"));
												}
												if (JSON.containsKey("finlea_orgnum")
														&& JSON.getString("finlea_orgnum") != null
														&& !"".equals(JSON.getString("finlea_orgnum"))) {
													applyLoanStrD15.setD15CellNbankFinleaOrgnum(
															JSON.getString("finlea_orgnum"));
												}
												if (JSON.containsKey("else_orgnum")
														&& JSON.getString("else_orgnum") != null
														&& !"".equals(JSON.getString("else_orgnum"))) {
													applyLoanStrD15
															.setD15CellNbankElseOrgnum(JSON.getString("else_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrD15
															.setD15CellNbankWeekOrgnum(JSON.getString("week_orgnum"));
												}

												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrD15
															.setD15CellNbankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrD15
															.setD15CellNbankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
									}
								}
							}
						}

						if (applyLoanStrJSON.containsKey("m1") && applyLoanStrJSON.getString("m1") != null
								&& !"".equals(applyLoanStrJSON.getString("m1"))) {
							JSONObject m1JSON = JSONObject.fromObject(applyLoanStrJSON.getString("m1"));
							if (m1JSON != null && (!m1JSON.isEmpty())) {
								ApplyLoanStrMonth1 applyLoanStrM1 = new ApplyLoanStrMonth1();
								applyLoanStrM1.setUuid(GuidUtil.getGuid());
								applyLoanStrM1.setCrtTime(new Date());
								applyLoanStrM1.setCrtUser(crtUser);
								applyLoanStrM1.setTrnId(trnId);
								applyLoanStrM1.setAppId(appId);
								applyLoanStrM1.setTrnKey(trnKey);
								applyLoanStr.setApplyLoanStrM1(applyLoanStrM1);
								if (m1JSON.containsKey("id") && m1JSON.getString("id") != null
										&& !"".equals(m1JSON.getString("id"))) {
									JSONObject idJSON = JSONObject.fromObject(m1JSON.getString("id"));
									if (idJSON != null) {
										if (idJSON.containsKey("pdl") && idJSON.getString("pdl") != null
												&& !"".equals(idJSON.getString("pdl"))) {
											JSONObject pdlJSON = JSONObject.fromObject(idJSON.getString("pdl"));
											if (pdlJSON != null) {
												if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
														&& !"".equals(pdlJSON.getString("allnum"))) {
													applyLoanStrM1.setM1IdPdlAllnum(pdlJSON.getString("allnum"));
												}
												if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
														&& !"".equals(pdlJSON.getString("orgnum"))) {
													applyLoanStrM1.setM1IdPdlOrgnum(pdlJSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("caon") && idJSON.getString("caon") != null
												&& !"".equals(idJSON.getString("caon"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("caon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1IdCaonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1IdCaonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("rel") && idJSON.getString("rel") != null
												&& !"".equals(idJSON.getString("rel"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("rel"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1IdRelAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1IdRelOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("caoff") && idJSON.getString("caoff") != null
												&& !"".equals(idJSON.getString("caoff"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("caoff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1IdCaoffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1IdCaoffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("cooff") && idJSON.getString("cooff") != null
												&& !"".equals(idJSON.getString("cooff"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("cooff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1IdCooffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1IdCooffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("af") && idJSON.getString("af") != null
												&& !"".equals(idJSON.getString("af"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("af"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1IdAfAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1IdAfOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("coon") && idJSON.getString("coon") != null
												&& !"".equals(idJSON.getString("coon"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("coon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1IdCoonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1IdCoonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("oth") && idJSON.getString("oth") != null
												&& !"".equals(idJSON.getString("oth"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("oth"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1IdOthAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1IdOthOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("bank") && idJSON.getString("bank") != null
												&& !"".equals(idJSON.getString("bank"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("bank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM1.setM1IdBankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1IdBankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("tra_allnum")
														&& JSON.getString("tra_allnum") != null
														&& !"".equals(JSON.getString("tra_allnum"))) {
													applyLoanStrM1.setM1IdBankTraAllnum(JSON.getString("tra_allnum"));
												}
												if (JSON.containsKey("ret_allnum")
														&& JSON.getString("ret_allnum") != null
														&& !"".equals(JSON.getString("ret_allnum"))) {
													applyLoanStrM1.setM1IdBankRetAllnum(JSON.getString("ret_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1IdBankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("tra_orgnum")
														&& JSON.getString("tra_orgnum") != null
														&& !"".equals(JSON.getString("tra_orgnum"))) {
													applyLoanStrM1.setM1IdBankTraOrgnum(JSON.getString("tra_orgnum"));
												}
												if (JSON.containsKey("ret_orgnum")
														&& JSON.getString("ret_orgnum") != null
														&& !"".equals(JSON.getString("ret_orgnum"))) {
													applyLoanStrM1.setM1IdBankRetOrgnum(JSON.getString("ret_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM1.setM1IdBankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM1.setM1IdBankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM1
															.setM1IdBankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM1
															.setM1IdBankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
										if (idJSON.containsKey("nbank") && idJSON.getString("nbank") != null
												&& !"".equals(idJSON.getString("nbank"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("nbank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM1.setM1IdNbankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1IdNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrM1.setM1IdNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrM1.setM1IdNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrM1.setM1IdNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrM1.setM1IdNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrM1.setM1IdNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrM1.setM1IdNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankNsloanAllnum(JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrM1.setM1IdNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankFinleaAllnum(JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1IdNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrM1.setM1IdNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrM1.setM1IdNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrM1.setM1IdNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrM1.setM1IdNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrM1.setM1IdNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrM1.setM1IdNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankNsloanAllnum(JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrM1.setM1IdNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankFinleaAllnum(JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1IdNbankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("p2p_orgnum")
														&& JSON.getString("p2p_orgnum") != null
														&& !"".equals(JSON.getString("p2p_orgnum"))) {
													applyLoanStrM1.setM1IdNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
												}
												if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
														&& !"".equals(JSON.getString("mc_orgnum"))) {
													applyLoanStrM1.setM1IdNbankMcOrgnum(JSON.getString("mc_orgnum"));
												}
												if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
														&& !"".equals(JSON.getString("ca_orgnum"))) {
													applyLoanStrM1.setM1IdNbankCaOrgnum(JSON.getString("ca_orgnum"));
												}
												if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
														&& !"".equals(JSON.getString("cf_orgnum"))) {
													applyLoanStrM1.setM1IdNbankCfOrgnum(JSON.getString("cf_orgnum"));
												}
												if (JSON.containsKey("com_orgnum")
														&& JSON.getString("com_orgnum") != null
														&& !"".equals(JSON.getString("com_orgnum"))) {
													applyLoanStrM1.setM1IdNbankComOrgnum(JSON.getString("com_orgnum"));
												}
												if (JSON.containsKey("oth_orgnum")
														&& JSON.getString("oth_orgnum") != null
														&& !"".equals(JSON.getString("oth_orgnum"))) {
													applyLoanStrM1.setM1IdNbankOthOrgnum(JSON.getString("oth_orgnum"));
												}
												if (JSON.containsKey("nsloan_orgnum")
														&& JSON.getString("nsloan_orgnum") != null
														&& !"".equals(JSON.getString("nsloan_orgnum"))) {
													applyLoanStrM1
															.setM1IdNbankNsloanOrgnum(JSON.getString("nsloan_orgnum"));
												}
												if (JSON.containsKey("autofin_orgnum")
														&& JSON.getString("autofin_orgnum") != null
														&& !"".equals(JSON.getString("autofin_orgnum"))) {
													applyLoanStrM1.setM1IdNbankAutofinOrgnum(
															JSON.getString("autofin_orgnum"));
												}
												if (JSON.containsKey("sloan_orgnum")
														&& JSON.getString("sloan_orgnum") != null
														&& !"".equals(JSON.getString("sloan_orgnum"))) {
													applyLoanStrM1
															.setM1IdNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
												}
												if (JSON.containsKey("cons_orgnum")
														&& JSON.getString("cons_orgnum") != null
														&& !"".equals(JSON.getString("cons_orgnum"))) {
													applyLoanStrM1
															.setM1IdNbankConsOrgnum(JSON.getString("cons_orgnum"));
												}
												if (JSON.containsKey("finlea_orgnum")
														&& JSON.getString("finlea_orgnum") != null
														&& !"".equals(JSON.getString("finlea_orgnum"))) {
													applyLoanStrM1
															.setM1IdNbankFinleaOrgnum(JSON.getString("finlea_orgnum"));
												}
												if (JSON.containsKey("else_orgnum")
														&& JSON.getString("else_orgnum") != null
														&& !"".equals(JSON.getString("else_orgnum"))) {
													applyLoanStrM1
															.setM1IdNbankElseOrgnum(JSON.getString("else_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM1
															.setM1IdNbankWeekOrgnum(JSON.getString("week_orgnum"));
												}

												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM1
															.setM1IdNbankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM1
															.setM1IdNbankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
									}
								}

								if (m1JSON.containsKey("cell") && m1JSON.getString("cell") != null
										&& !"".equals(m1JSON.getString("cell"))) {
									JSONObject cellJSON = JSONObject.fromObject(m1JSON.getString("cell"));
									if (cellJSON != null) {
										if (cellJSON.containsKey("pdl") && cellJSON.getString("pdl") != null
												&& !"".equals(cellJSON.getString("pdl"))) {
											JSONObject pdlJSON = JSONObject.fromObject(cellJSON.getString("pdl"));
											if (pdlJSON != null) {
												if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
														&& !"".equals(pdlJSON.getString("allnum"))) {
													applyLoanStrM1.setM1CellPdlAllnum(pdlJSON.getString("allnum"));
												}
												if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
														&& !"".equals(pdlJSON.getString("orgnum"))) {
													applyLoanStrM1.setM1CellPdlOrgnum(pdlJSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("caon") && cellJSON.getString("caon") != null
												&& !"".equals(cellJSON.getString("caon"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1CellCaonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1CellCaonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("rel") && cellJSON.getString("rel") != null
												&& !"".equals(cellJSON.getString("rel"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("rel"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1CellRelAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1CellRelOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("caoff") && cellJSON.getString("caoff") != null
												&& !"".equals(cellJSON.getString("caoff"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caoff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1CellCaoffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1CellCaoffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("cooff") && cellJSON.getString("cooff") != null
												&& !"".equals(cellJSON.getString("cooff"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("cooff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1CellCooffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1CellCooffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("af") && cellJSON.getString("af") != null
												&& !"".equals(cellJSON.getString("af"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("af"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1CellAfAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1CellAfOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("coon") && cellJSON.getString("coon") != null
												&& !"".equals(cellJSON.getString("coon"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("coon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1CellCoonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1CellCoonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("oth") && cellJSON.getString("oth") != null
												&& !"".equals(cellJSON.getString("oth"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("oth"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1CellOthAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1CellOthOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("bank") && cellJSON.getString("bank") != null
												&& !"".equals(cellJSON.getString("bank"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("bank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM1.setM1CellBankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1CellBankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("tra_allnum")
														&& JSON.getString("tra_allnum") != null
														&& !"".equals(JSON.getString("tra_allnum"))) {
													applyLoanStrM1.setM1CellBankTraAllnum(JSON.getString("tra_allnum"));
												}
												if (JSON.containsKey("ret_allnum")
														&& JSON.getString("ret_allnum") != null
														&& !"".equals(JSON.getString("ret_allnum"))) {
													applyLoanStrM1.setM1CellBankRetAllnum(JSON.getString("ret_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1CellBankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("tra_orgnum")
														&& JSON.getString("tra_orgnum") != null
														&& !"".equals(JSON.getString("tra_orgnum"))) {
													applyLoanStrM1.setM1CellBankTraOrgnum(JSON.getString("tra_orgnum"));
												}
												if (JSON.containsKey("ret_orgnum")
														&& JSON.getString("ret_orgnum") != null
														&& !"".equals(JSON.getString("ret_orgnum"))) {
													applyLoanStrM1.setM1CellBankRetOrgnum(JSON.getString("ret_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM1
															.setM1CellBankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM1
															.setM1CellBankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM1
															.setM1CellBankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM1
															.setM1CellBankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("nbank") && cellJSON.getString("nbank") != null
												&& !"".equals(cellJSON.getString("nbank"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("nbank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM1.setM1CellNbankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1CellNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrM1.setM1CellNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrM1.setM1CellNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrM1.setM1CellNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrM1.setM1CellNbankNsloanAllnum(
															JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrM1.setM1CellNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrM1.setM1CellNbankFinleaAllnum(
															JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM1.setM1CellNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrM1.setM1CellNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrM1.setM1CellNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrM1.setM1CellNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrM1.setM1CellNbankNsloanAllnum(
															JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrM1.setM1CellNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrM1.setM1CellNbankFinleaAllnum(
															JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankElseAllnum(JSON.getString("else_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM1.setM1CellNbankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("p2p_orgnum")
														&& JSON.getString("p2p_orgnum") != null
														&& !"".equals(JSON.getString("p2p_orgnum"))) {
													applyLoanStrM1
															.setM1CellNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
												}
												if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
														&& !"".equals(JSON.getString("mc_orgnum"))) {
													applyLoanStrM1.setM1CellNbankMcOrgnum(JSON.getString("mc_orgnum"));
												}
												if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
														&& !"".equals(JSON.getString("ca_orgnum"))) {
													applyLoanStrM1.setM1CellNbankCaOrgnum(JSON.getString("ca_orgnum"));
												}
												if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
														&& !"".equals(JSON.getString("cf_orgnum"))) {
													applyLoanStrM1.setM1CellNbankCfOrgnum(JSON.getString("cf_orgnum"));
												}
												if (JSON.containsKey("com_orgnum")
														&& JSON.getString("com_orgnum") != null
														&& !"".equals(JSON.getString("com_orgnum"))) {
													applyLoanStrM1
															.setM1CellNbankComOrgnum(JSON.getString("com_orgnum"));
												}
												if (JSON.containsKey("oth_orgnum")
														&& JSON.getString("oth_orgnum") != null
														&& !"".equals(JSON.getString("oth_orgnum"))) {
													applyLoanStrM1
															.setM1CellNbankOthOrgnum(JSON.getString("oth_orgnum"));
												}
												if (JSON.containsKey("nsloan_orgnum")
														&& JSON.getString("nsloan_orgnum") != null
														&& !"".equals(JSON.getString("nsloan_orgnum"))) {
													applyLoanStrM1.setM1CellNbankNsloanOrgnum(
															JSON.getString("nsloan_orgnum"));
												}
												if (JSON.containsKey("autofin_orgnum")
														&& JSON.getString("autofin_orgnum") != null
														&& !"".equals(JSON.getString("autofin_orgnum"))) {
													applyLoanStrM1.setM1CellNbankAutofinOrgnum(
															JSON.getString("autofin_orgnum"));
												}
												if (JSON.containsKey("sloan_orgnum")
														&& JSON.getString("sloan_orgnum") != null
														&& !"".equals(JSON.getString("sloan_orgnum"))) {
													applyLoanStrM1
															.setM1CellNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
												}
												if (JSON.containsKey("cons_orgnum")
														&& JSON.getString("cons_orgnum") != null
														&& !"".equals(JSON.getString("cons_orgnum"))) {
													applyLoanStrM1
															.setM1CellNbankConsOrgnum(JSON.getString("cons_orgnum"));
												}
												if (JSON.containsKey("finlea_orgnum")
														&& JSON.getString("finlea_orgnum") != null
														&& !"".equals(JSON.getString("finlea_orgnum"))) {
													applyLoanStrM1.setM1CellNbankFinleaOrgnum(
															JSON.getString("finlea_orgnum"));
												}
												if (JSON.containsKey("else_orgnum")
														&& JSON.getString("else_orgnum") != null
														&& !"".equals(JSON.getString("else_orgnum"))) {
													applyLoanStrM1
															.setM1CellNbankElseOrgnum(JSON.getString("else_orgnum"));
												}
												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM1
															.setM1CellNbankWeekOrgnum(JSON.getString("week_orgnum"));
												}

												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM1
															.setM1CellNbankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM1
															.setM1CellNbankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
									}
								}
							}
						}

						if (applyLoanStrJSON.containsKey("m3") && applyLoanStrJSON.getString("m3") != null
								&& !"".equals(applyLoanStrJSON.getString("m3"))) {
							JSONObject m3JSON = JSONObject.fromObject(applyLoanStrJSON.getString("m3"));
							if (m3JSON != null && (!m3JSON.isEmpty())) {
								ApplyLoanStrMonth3 applyLoanStrM3 = new ApplyLoanStrMonth3();
								applyLoanStrM3.setUuid(GuidUtil.getGuid());
								applyLoanStrM3.setCrtTime(new Date());
								applyLoanStrM3.setCrtUser(crtUser);
								applyLoanStrM3.setTrnId(trnId);
								applyLoanStrM3.setAppId(appId);
								applyLoanStrM3.setTrnKey(trnKey);
								applyLoanStr.setApplyLoanStrM3(applyLoanStrM3);
								if (m3JSON.containsKey("id") && m3JSON.getString("id") != null
										&& !"".equals(m3JSON.getString("id"))) {
									JSONObject idJSON = JSONObject.fromObject(m3JSON.getString("id"));
									if (idJSON != null) {
										if (idJSON.containsKey("max_inteday") && idJSON.getString("max_inteday") != null
												&& !"".equals(idJSON.getString("max_inteday"))) {
											applyLoanStrM3.setM3IdMaxInteday(idJSON.getString("max_inteday"));
										}
										if (idJSON.containsKey("min_inteday") && idJSON.getString("min_inteday") != null
												&& !"".equals(idJSON.getString("min_inteday"))) {
											applyLoanStrM3.setM3IdMinInteday(idJSON.getString("min_inteday"));
										}
										if (idJSON.containsKey("tot_mons") && idJSON.getString("tot_mons") != null
												&& !"".equals(idJSON.getString("tot_mons"))) {
											applyLoanStrM3.setM3IdTotMons(idJSON.getString("tot_mons"));
										}
										if (idJSON.containsKey("avg_monnum") && idJSON.getString("avg_monnum") != null
												&& !"".equals(idJSON.getString("avg_monnum"))) {
											applyLoanStrM3.setM3IdAvgMonnum(idJSON.getString("avg_monnum"));
										}
										if (idJSON.containsKey("max_monnum") && idJSON.getString("max_monnum") != null
												&& !"".equals(idJSON.getString("max_monnum"))) {
											applyLoanStrM3.setM3IdMaxMonnum(idJSON.getString("max_monnum"));
										}
										if (idJSON.containsKey("min_monnum") && idJSON.getString("min_monnum") != null
												&& !"".equals(idJSON.getString("min_monnum"))) {
											applyLoanStrM3.setM3IdMinMonnum(idJSON.getString("min_monnum"));
										}
										if (idJSON.containsKey("pdl") && idJSON.getString("pdl") != null
												&& !"".equals(idJSON.getString("pdl"))) {
											JSONObject pdlJSON = JSONObject.fromObject(idJSON.getString("pdl"));
											if (pdlJSON != null) {
												if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
														&& !"".equals(pdlJSON.getString("allnum"))) {
													applyLoanStrM3.setM3IdPdlAllnum(pdlJSON.getString("allnum"));
												}
												if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
														&& !"".equals(pdlJSON.getString("orgnum"))) {
													applyLoanStrM3.setM3IdPdlOrgnum(pdlJSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("caon") && idJSON.getString("caon") != null
												&& !"".equals(idJSON.getString("caon"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("caon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3IdCaonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3IdCaonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("rel") && idJSON.getString("rel") != null
												&& !"".equals(idJSON.getString("rel"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("rel"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3IdRelAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3IdRelOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("caoff") && idJSON.getString("caoff") != null
												&& !"".equals(idJSON.getString("caoff"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("caoff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3IdCaoffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3IdCaoffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("cooff") && idJSON.getString("cooff") != null
												&& !"".equals(idJSON.getString("cooff"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("cooff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3IdCooffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3IdCooffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("af") && idJSON.getString("af") != null
												&& !"".equals(idJSON.getString("af"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("af"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3IdAfAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3IdAfOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("coon") && idJSON.getString("coon") != null
												&& !"".equals(idJSON.getString("coon"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("coon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3IdCoonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3IdCoonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("oth") && idJSON.getString("oth") != null
												&& !"".equals(idJSON.getString("oth"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("oth"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3IdOthAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3IdOthOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("bank") && idJSON.getString("bank") != null
												&& !"".equals(idJSON.getString("bank"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("bank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM3.setM3IdBankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3IdBankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("tra_allnum")
														&& JSON.getString("tra_allnum") != null
														&& !"".equals(JSON.getString("tra_allnum"))) {
													applyLoanStrM3.setM3IdBankTraAllnum(JSON.getString("tra_allnum"));
												}
												if (JSON.containsKey("ret_allnum")
														&& JSON.getString("ret_allnum") != null
														&& !"".equals(JSON.getString("ret_allnum"))) {
													applyLoanStrM3.setM3IdBankRetAllnum(JSON.getString("ret_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3IdBankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("tra_orgnum")
														&& JSON.getString("tra_orgnum") != null
														&& !"".equals(JSON.getString("tra_orgnum"))) {
													applyLoanStrM3.setM3IdBankTraOrgnum(JSON.getString("tra_orgnum"));
												}
												if (JSON.containsKey("ret_orgnum")
														&& JSON.getString("ret_orgnum") != null
														&& !"".equals(JSON.getString("ret_orgnum"))) {
													applyLoanStrM3.setM3IdBankRetOrgnum(JSON.getString("ret_orgnum"));
												}

												if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
														&& !"".equals(JSON.getString("tot_mons"))) {
													applyLoanStrM3.setM3IdBankTotMons(JSON.getString("tot_mons"));
												}
												if (JSON.containsKey("avg_monnum")
														&& JSON.getString("avg_monnum") != null
														&& !"".equals(JSON.getString("avg_monnum"))) {
													applyLoanStrM3.setM3IdBankAvgMonnum(JSON.getString("avg_monnum"));
												}
												if (JSON.containsKey("max_monnum")
														&& JSON.getString("max_monnum") != null
														&& !"".equals(JSON.getString("max_monnum"))) {
													applyLoanStrM3.setM3IdBankMaxMonnum(JSON.getString("max_monnum"));
												}
												if (JSON.containsKey("min_monnum")
														&& JSON.getString("min_monnum") != null
														&& !"".equals(JSON.getString("min_monnum"))) {
													applyLoanStrM3.setM3IdBankMinMonnum(JSON.getString("min_monnum"));
												}
												if (JSON.containsKey("max_inteday")
														&& JSON.getString("max_inteday") != null
														&& !"".equals(JSON.getString("max_inteday"))) {
													applyLoanStrM3.setM3IdBankMaxInteday(JSON.getString("max_inteday"));
												}
												if (JSON.containsKey("min_inteday")
														&& JSON.getString("min_inteday") != null
														&& !"".equals(JSON.getString("min_inteday"))) {
													applyLoanStrM3.setM3IdBankMinInteday(JSON.getString("min_inteday"));
												}

												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM3.setM3IdBankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM3.setM3IdBankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM3
															.setM3IdBankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM3
															.setM3IdBankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
										if (idJSON.containsKey("nbank") && idJSON.getString("nbank") != null
												&& !"".equals(idJSON.getString("nbank"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("nbank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM3.setM3IdNbankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3IdNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrM3.setM3IdNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrM3.setM3IdNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrM3.setM3IdNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrM3.setM3IdNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrM3.setM3IdNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrM3.setM3IdNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrM3
															.setM3IdNbankNsloanAllnum(JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrM3.setM3IdNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrM3
															.setM3IdNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrM3
															.setM3IdNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrM3
															.setM3IdNbankFinleaAllnum(JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrM3
															.setM3IdNbankElseAllnum(JSON.getString("else_allnum"));
												}

												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3IdNbankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("p2p_orgnum")
														&& JSON.getString("p2p_orgnum") != null
														&& !"".equals(JSON.getString("p2p_orgnum"))) {
													applyLoanStrM3.setM3IdNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
												}
												if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
														&& !"".equals(JSON.getString("mc_orgnum"))) {
													applyLoanStrM3.setM3IdNbankMcOrgnum(JSON.getString("mc_orgnum"));
												}
												if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
														&& !"".equals(JSON.getString("ca_orgnum"))) {
													applyLoanStrM3.setM3IdNbankCaOrgnum(JSON.getString("ca_orgnum"));
												}
												if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
														&& !"".equals(JSON.getString("cf_orgnum"))) {
													applyLoanStrM3.setM3IdNbankCfOrgnum(JSON.getString("cf_orgnum"));
												}
												if (JSON.containsKey("com_orgnum")
														&& JSON.getString("com_orgnum") != null
														&& !"".equals(JSON.getString("com_orgnum"))) {
													applyLoanStrM3.setM3IdNbankComOrgnum(JSON.getString("com_orgnum"));
												}
												if (JSON.containsKey("oth_orgnum")
														&& JSON.getString("oth_orgnum") != null
														&& !"".equals(JSON.getString("oth_orgnum"))) {
													applyLoanStrM3.setM3IdNbankOthOrgnum(JSON.getString("oth_orgnum"));
												}
												if (JSON.containsKey("nsloan_orgnum")
														&& JSON.getString("nsloan_orgnum") != null
														&& !"".equals(JSON.getString("nsloan_orgnum"))) {
													applyLoanStrM3
															.setM3IdNbankNsloanOrgnum(JSON.getString("nsloan_orgnum"));
												}
												if (JSON.containsKey("autofin_orgnum")
														&& JSON.getString("autofin_orgnum") != null
														&& !"".equals(JSON.getString("autofin_orgnum"))) {
													applyLoanStrM3.setM3IdNbankAutofinOrgnum(
															JSON.getString("autofin_orgnum"));
												}
												if (JSON.containsKey("sloan_orgnum")
														&& JSON.getString("sloan_orgnum") != null
														&& !"".equals(JSON.getString("sloan_orgnum"))) {
													applyLoanStrM3
															.setM3IdNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
												}
												if (JSON.containsKey("cons_orgnum")
														&& JSON.getString("cons_orgnum") != null
														&& !"".equals(JSON.getString("cons_orgnum"))) {
													applyLoanStrM3
															.setM3IdNbankConsOrgnum(JSON.getString("cons_orgnum"));
												}
												if (JSON.containsKey("finlea_orgnum")
														&& JSON.getString("finlea_orgnum") != null
														&& !"".equals(JSON.getString("finlea_orgnum"))) {
													applyLoanStrM3
															.setM3IdNbankFinleaOrgnum(JSON.getString("finlea_orgnum"));
												}
												if (JSON.containsKey("else_orgnum")
														&& JSON.getString("else_orgnum") != null
														&& !"".equals(JSON.getString("else_orgnum"))) {
													applyLoanStrM3
															.setM3IdNbankElseOrgnum(JSON.getString("else_orgnum"));
												}

												if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
														&& !"".equals(JSON.getString("tot_mons"))) {
													applyLoanStrM3.setM3IdNbankTotMons(JSON.getString("tot_mons"));
												}
												if (JSON.containsKey("avg_monnum")
														&& JSON.getString("avg_monnum") != null
														&& !"".equals(JSON.getString("avg_monnum"))) {
													applyLoanStrM3.setM3IdNbankAvgMonnum(JSON.getString("avg_monnum"));
												}
												if (JSON.containsKey("max_monnum")
														&& JSON.getString("max_monnum") != null
														&& !"".equals(JSON.getString("max_monnum"))) {
													applyLoanStrM3.setM3IdNbankMaxMonnum(JSON.getString("max_monnum"));
												}
												if (JSON.containsKey("min_monnum")
														&& JSON.getString("min_monnum") != null
														&& !"".equals(JSON.getString("min_monnum"))) {
													applyLoanStrM3.setM3IdNbankMinMonnum(JSON.getString("min_monnum"));
												}
												if (JSON.containsKey("max_inteday")
														&& JSON.getString("max_inteday") != null
														&& !"".equals(JSON.getString("max_inteday"))) {
													applyLoanStrM3
															.setM3IdNbankMaxInteday(JSON.getString("max_inteday"));
												}
												if (JSON.containsKey("min_inteday")
														&& JSON.getString("min_inteday") != null
														&& !"".equals(JSON.getString("min_inteday"))) {
													applyLoanStrM3
															.setM3IdNbankMinInteday(JSON.getString("min_inteday"));
												}

												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM3
															.setM3IdNbankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM3
															.setM3IdNbankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM3
															.setM3IdNbankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM3
															.setM3IdNbankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
									}
								}

								if (m3JSON.containsKey("cell") && m3JSON.getString("cell") != null
										&& !"".equals(m3JSON.getString("cell"))) {

									JSONObject cellJSON = JSONObject.fromObject(m3JSON.getString("cell"));
									if (cellJSON != null) {
										if (cellJSON.containsKey("max_inteday")
												&& cellJSON.getString("max_inteday") != null
												&& !"".equals(cellJSON.getString("max_inteday"))) {
											applyLoanStrM3.setM3CellMaxInteday(cellJSON.getString("max_inteday"));
										}
										if (cellJSON.containsKey("min_inteday")
												&& cellJSON.getString("min_inteday") != null
												&& !"".equals(cellJSON.getString("min_inteday"))) {
											applyLoanStrM3.setM3CellMinInteday(cellJSON.getString("min_inteday"));
										}
										if (cellJSON.containsKey("tot_mons") && cellJSON.getString("tot_mons") != null
												&& !"".equals(cellJSON.getString("tot_mons"))) {
											applyLoanStrM3.setM3CellTotMons(cellJSON.getString("tot_mons"));
										}
										if (cellJSON.containsKey("avg_monnum")
												&& cellJSON.getString("avg_monnum") != null
												&& !"".equals(cellJSON.getString("avg_monnum"))) {
											applyLoanStrM3.setM3CellAvgMonnum(cellJSON.getString("avg_monnum"));
										}
										if (cellJSON.containsKey("max_monnum")
												&& cellJSON.getString("max_monnum") != null
												&& !"".equals(cellJSON.getString("max_monnum"))) {
											applyLoanStrM3.setM3CellMaxMonnum(cellJSON.getString("max_monnum"));
										}
										if (cellJSON.containsKey("min_monnum")
												&& cellJSON.getString("min_monnum") != null
												&& !"".equals(cellJSON.getString("min_monnum"))) {
											applyLoanStrM3.setM3CellMinMonnum(cellJSON.getString("min_monnum"));
										}
										if (cellJSON.containsKey("pdl") && cellJSON.getString("pdl") != null
												&& !"".equals(cellJSON.getString("pdl"))) {
											JSONObject pdlJSON = JSONObject.fromObject(cellJSON.getString("pdl"));
											if (pdlJSON != null) {
												if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
														&& !"".equals(pdlJSON.getString("allnum"))) {
													applyLoanStrM3.setM3CellPdlAllnum(pdlJSON.getString("allnum"));
												}
												if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
														&& !"".equals(pdlJSON.getString("orgnum"))) {
													applyLoanStrM3.setM3CellPdlOrgnum(pdlJSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("caon") && cellJSON.getString("caon") != null
												&& !"".equals(cellJSON.getString("caon"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3CellCaonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3CellCaonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("rel") && cellJSON.getString("rel") != null
												&& !"".equals(cellJSON.getString("rel"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("rel"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3CellRelAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3CellRelOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("caoff") && cellJSON.getString("caoff") != null
												&& !"".equals(cellJSON.getString("caoff"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caoff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3CellCaoffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3CellCaoffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("cooff") && cellJSON.getString("cooff") != null
												&& !"".equals(cellJSON.getString("cooff"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("cooff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3CellCooffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3CellCooffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("af") && cellJSON.getString("af") != null
												&& !"".equals(cellJSON.getString("af"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("af"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3CellAfAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3CellAfOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("coon") && cellJSON.getString("coon") != null
												&& !"".equals(cellJSON.getString("coon"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("coon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3CellCoonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3CellCoonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("oth") && cellJSON.getString("oth") != null
												&& !"".equals(cellJSON.getString("oth"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("oth"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3CellOthAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3CellOthOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("bank") && cellJSON.getString("bank") != null
												&& !"".equals(cellJSON.getString("bank"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("bank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM3.setM3CellBankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3CellBankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("tra_allnum")
														&& JSON.getString("tra_allnum") != null
														&& !"".equals(JSON.getString("tra_allnum"))) {
													applyLoanStrM3.setM3CellBankTraAllnum(JSON.getString("tra_allnum"));
												}
												if (JSON.containsKey("ret_allnum")
														&& JSON.getString("ret_allnum") != null
														&& !"".equals(JSON.getString("ret_allnum"))) {
													applyLoanStrM3.setM3CellBankRetAllnum(JSON.getString("ret_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3CellBankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("tra_orgnum")
														&& JSON.getString("tra_orgnum") != null
														&& !"".equals(JSON.getString("tra_orgnum"))) {
													applyLoanStrM3.setM3CellBankTraOrgnum(JSON.getString("tra_orgnum"));
												}
												if (JSON.containsKey("ret_orgnum")
														&& JSON.getString("ret_orgnum") != null
														&& !"".equals(JSON.getString("ret_orgnum"))) {
													applyLoanStrM3.setM3CellBankRetOrgnum(JSON.getString("ret_orgnum"));
												}

												if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
														&& !"".equals(JSON.getString("tot_mons"))) {
													applyLoanStrM3.setM3CellBankTotMons(JSON.getString("tot_mons"));
												}
												if (JSON.containsKey("avg_monnum")
														&& JSON.getString("avg_monnum") != null
														&& !"".equals(JSON.getString("avg_monnum"))) {
													applyLoanStrM3.setM3CellBankAvgMonnum(JSON.getString("avg_monnum"));
												}
												if (JSON.containsKey("max_monnum")
														&& JSON.getString("max_monnum") != null
														&& !"".equals(JSON.getString("max_monnum"))) {
													applyLoanStrM3.setM3CellBankMaxMonnum(JSON.getString("max_monnum"));
												}
												if (JSON.containsKey("min_monnum")
														&& JSON.getString("min_monnum") != null
														&& !"".equals(JSON.getString("min_monnum"))) {
													applyLoanStrM3.setM3CellBankMinMonnum(JSON.getString("min_monnum"));
												}
												if (JSON.containsKey("max_inteday")
														&& JSON.getString("max_inteday") != null
														&& !"".equals(JSON.getString("max_inteday"))) {
													applyLoanStrM3
															.setM3CellBankMaxInteday(JSON.getString("max_inteday"));
												}
												if (JSON.containsKey("min_inteday")
														&& JSON.getString("min_inteday") != null
														&& !"".equals(JSON.getString("min_inteday"))) {
													applyLoanStrM3
															.setM3CellBankMinInteday(JSON.getString("min_inteday"));
												}

												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM3
															.setM3CellBankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM3
															.setM3CellBankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM3
															.setM3CellBankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM3
															.setM3CellBankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("nbank") && cellJSON.getString("nbank") != null
												&& !"".equals(cellJSON.getString("nbank"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("nbank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM3.setM3CellNbankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM3.setM3CellNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrM3
															.setM3CellNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrM3.setM3CellNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrM3.setM3CellNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrM3.setM3CellNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrM3
															.setM3CellNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrM3
															.setM3CellNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrM3.setM3CellNbankNsloanAllnum(
															JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrM3.setM3CellNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrM3
															.setM3CellNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrM3
															.setM3CellNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrM3.setM3CellNbankFinleaAllnum(
															JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrM3
															.setM3CellNbankElseAllnum(JSON.getString("else_allnum"));
												}

												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM3.setM3CellNbankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("p2p_orgnum")
														&& JSON.getString("p2p_orgnum") != null
														&& !"".equals(JSON.getString("p2p_orgnum"))) {
													applyLoanStrM3
															.setM3CellNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
												}
												if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
														&& !"".equals(JSON.getString("mc_orgnum"))) {
													applyLoanStrM3.setM3CellNbankMcOrgnum(JSON.getString("mc_orgnum"));
												}
												if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
														&& !"".equals(JSON.getString("ca_orgnum"))) {
													applyLoanStrM3.setM3CellNbankCaOrgnum(JSON.getString("ca_orgnum"));
												}
												if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
														&& !"".equals(JSON.getString("cf_orgnum"))) {
													applyLoanStrM3.setM3CellNbankCfOrgnum(JSON.getString("cf_orgnum"));
												}
												if (JSON.containsKey("com_orgnum")
														&& JSON.getString("com_orgnum") != null
														&& !"".equals(JSON.getString("com_orgnum"))) {
													applyLoanStrM3
															.setM3CellNbankComOrgnum(JSON.getString("com_orgnum"));
												}
												if (JSON.containsKey("oth_orgnum")
														&& JSON.getString("oth_orgnum") != null
														&& !"".equals(JSON.getString("oth_orgnum"))) {
													applyLoanStrM3
															.setM3CellNbankOthOrgnum(JSON.getString("oth_orgnum"));
												}
												if (JSON.containsKey("nsloan_orgnum")
														&& JSON.getString("nsloan_orgnum") != null
														&& !"".equals(JSON.getString("nsloan_orgnum"))) {
													applyLoanStrM3.setM3CellNbankNsloanOrgnum(
															JSON.getString("nsloan_orgnum"));
												}
												if (JSON.containsKey("autofin_orgnum")
														&& JSON.getString("autofin_orgnum") != null
														&& !"".equals(JSON.getString("autofin_orgnum"))) {
													applyLoanStrM3.setM3CellNbankAutofinOrgnum(
															JSON.getString("autofin_orgnum"));
												}
												if (JSON.containsKey("sloan_orgnum")
														&& JSON.getString("sloan_orgnum") != null
														&& !"".equals(JSON.getString("sloan_orgnum"))) {
													applyLoanStrM3
															.setM3CellNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
												}
												if (JSON.containsKey("cons_orgnum")
														&& JSON.getString("cons_orgnum") != null
														&& !"".equals(JSON.getString("cons_orgnum"))) {
													applyLoanStrM3
															.setM3CellNbankConsOrgnum(JSON.getString("cons_orgnum"));
												}
												if (JSON.containsKey("finlea_orgnum")
														&& JSON.getString("finlea_orgnum") != null
														&& !"".equals(JSON.getString("finlea_orgnum"))) {
													applyLoanStrM3.setM3CellNbankFinleaOrgnum(
															JSON.getString("finlea_orgnum"));
												}
												if (JSON.containsKey("else_orgnum")
														&& JSON.getString("else_orgnum") != null
														&& !"".equals(JSON.getString("else_orgnum"))) {
													applyLoanStrM3
															.setM3CellNbankElseOrgnum(JSON.getString("else_orgnum"));
												}

												if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
														&& !"".equals(JSON.getString("tot_mons"))) {
													applyLoanStrM3.setM3CellNbankTotMons(JSON.getString("tot_mons"));
												}
												if (JSON.containsKey("avg_monnum")
														&& JSON.getString("avg_monnum") != null
														&& !"".equals(JSON.getString("avg_monnum"))) {
													applyLoanStrM3
															.setM3CellNbankAvgMonnum(JSON.getString("avg_monnum"));
												}
												if (JSON.containsKey("max_monnum")
														&& JSON.getString("max_monnum") != null
														&& !"".equals(JSON.getString("max_monnum"))) {
													applyLoanStrM3
															.setM3CellNbankMaxMonnum(JSON.getString("max_monnum"));
												}
												if (JSON.containsKey("min_monnum")
														&& JSON.getString("min_monnum") != null
														&& !"".equals(JSON.getString("min_monnum"))) {
													applyLoanStrM3
															.setM3CellNbankMinMonnum(JSON.getString("min_monnum"));
												}
												if (JSON.containsKey("max_inteday")
														&& JSON.getString("max_inteday") != null
														&& !"".equals(JSON.getString("max_inteday"))) {
													applyLoanStrM3
															.setM3CellNbankMaxInteday(JSON.getString("max_inteday"));
												}
												if (JSON.containsKey("min_inteday")
														&& JSON.getString("min_inteday") != null
														&& !"".equals(JSON.getString("min_inteday"))) {
													applyLoanStrM3
															.setM3CellNbankMinInteday(JSON.getString("min_inteday"));
												}

												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM3
															.setM3CellNbankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM3
															.setM3CellNbankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM3
															.setM3CellNbankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM3
															.setM3CellNbankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
									}

								}
							}
						}

						if (applyLoanStrJSON.containsKey("m6") && applyLoanStrJSON.getString("m6") != null
								&& !"".equals(applyLoanStrJSON.getString("m6"))) {
							JSONObject m6JSON = JSONObject.fromObject(applyLoanStrJSON.getString("m6"));
							if (m6JSON != null && (!m6JSON.isEmpty())) {
								ApplyLoanStrMonth6 applyLoanStrM6 = new ApplyLoanStrMonth6();
								applyLoanStrM6.setUuid(GuidUtil.getGuid());
								applyLoanStrM6.setCrtTime(new Date());
								applyLoanStrM6.setCrtUser(crtUser);
								applyLoanStrM6.setTrnId(trnId);
								applyLoanStrM6.setAppId(appId);
								applyLoanStrM6.setTrnKey(trnKey);
								applyLoanStr.setApplyLoanStrM6(applyLoanStrM6);
								if (m6JSON.containsKey("id") && m6JSON.getString("id") != null
										&& !"".equals(m6JSON.getString("id"))) {
									JSONObject idJSON = JSONObject.fromObject(m6JSON.getString("id"));
									if (idJSON != null) {
										if (idJSON.containsKey("max_inteday") && idJSON.getString("max_inteday") != null
												&& !"".equals(idJSON.getString("max_inteday"))) {
											applyLoanStrM6.setM6IdMaxInteday(idJSON.getString("max_inteday"));
										}
										if (idJSON.containsKey("min_inteday") && idJSON.getString("min_inteday") != null
												&& !"".equals(idJSON.getString("min_inteday"))) {
											applyLoanStrM6.setM6IdMinInteday(idJSON.getString("min_inteday"));
										}
										if (idJSON.containsKey("tot_mons") && idJSON.getString("tot_mons") != null
												&& !"".equals(idJSON.getString("tot_mons"))) {
											applyLoanStrM6.setM6IdTotMons(idJSON.getString("tot_mons"));
										}
										if (idJSON.containsKey("avg_monnum") && idJSON.getString("avg_monnum") != null
												&& !"".equals(idJSON.getString("avg_monnum"))) {
											applyLoanStrM6.setM6IdAvgMonnum(idJSON.getString("avg_monnum"));
										}
										if (idJSON.containsKey("max_monnum") && idJSON.getString("max_monnum") != null
												&& !"".equals(idJSON.getString("max_monnum"))) {
											applyLoanStrM6.setM6IdMaxMonnum(idJSON.getString("max_monnum"));
										}
										if (idJSON.containsKey("min_monnum") && idJSON.getString("min_monnum") != null
												&& !"".equals(idJSON.getString("min_monnum"))) {
											applyLoanStrM6.setM6IdMinMonnum(idJSON.getString("min_monnum"));
										}
										if (idJSON.containsKey("pdl") && idJSON.getString("pdl") != null
												&& !"".equals(idJSON.getString("pdl"))) {
											JSONObject pdlJSON = JSONObject.fromObject(idJSON.getString("pdl"));
											if (pdlJSON != null) {
												if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
														&& !"".equals(pdlJSON.getString("allnum"))) {
													applyLoanStrM6.setM6IdPdlAllnum(pdlJSON.getString("allnum"));
												}
												if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
														&& !"".equals(pdlJSON.getString("orgnum"))) {
													applyLoanStrM6.setM6IdPdlOrgnum(pdlJSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("caon") && idJSON.getString("caon") != null
												&& !"".equals(idJSON.getString("caon"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("caon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6IdCaonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6IdCaonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("rel") && idJSON.getString("rel") != null
												&& !"".equals(idJSON.getString("rel"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("rel"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6IdRelAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6IdRelOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("caoff") && idJSON.getString("caoff") != null
												&& !"".equals(idJSON.getString("caoff"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("caoff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6IdCaoffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6IdCaoffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("cooff") && idJSON.getString("cooff") != null
												&& !"".equals(idJSON.getString("cooff"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("cooff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6IdCooffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6IdCooffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("af") && idJSON.getString("af") != null
												&& !"".equals(idJSON.getString("af"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("af"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6IdAfAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6IdAfOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("coon") && idJSON.getString("coon") != null
												&& !"".equals(idJSON.getString("coon"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("coon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6IdCoonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6IdCoonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("oth") && idJSON.getString("oth") != null
												&& !"".equals(idJSON.getString("oth"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("oth"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6IdOthAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6IdOthOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (idJSON.containsKey("bank") && idJSON.getString("bank") != null
												&& !"".equals(idJSON.getString("bank"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("bank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM6.setM6IdBankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6IdBankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("tra_allnum")
														&& JSON.getString("tra_allnum") != null
														&& !"".equals(JSON.getString("tra_allnum"))) {
													applyLoanStrM6.setM6IdBankTraAllnum(JSON.getString("tra_allnum"));
												}
												if (JSON.containsKey("ret_allnum")
														&& JSON.getString("ret_allnum") != null
														&& !"".equals(JSON.getString("ret_allnum"))) {
													applyLoanStrM6.setM6IdBankRetAllnum(JSON.getString("ret_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6IdBankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("tra_orgnum")
														&& JSON.getString("tra_orgnum") != null
														&& !"".equals(JSON.getString("tra_orgnum"))) {
													applyLoanStrM6.setM6IdBankTraOrgnum(JSON.getString("tra_orgnum"));
												}
												if (JSON.containsKey("ret_orgnum")
														&& JSON.getString("ret_orgnum") != null
														&& !"".equals(JSON.getString("ret_orgnum"))) {
													applyLoanStrM6.setM6IdBankRetOrgnum(JSON.getString("ret_orgnum"));
												}

												if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
														&& !"".equals(JSON.getString("tot_mons"))) {
													applyLoanStrM6.setM6IdBankTotMons(JSON.getString("tot_mons"));
												}
												if (JSON.containsKey("avg_monnum")
														&& JSON.getString("avg_monnum") != null
														&& !"".equals(JSON.getString("avg_monnum"))) {
													applyLoanStrM6.setM6IdBankAvgMonnum(JSON.getString("avg_monnum"));
												}
												if (JSON.containsKey("max_monnum")
														&& JSON.getString("max_monnum") != null
														&& !"".equals(JSON.getString("max_monnum"))) {
													applyLoanStrM6.setM6IdBankMaxMonnum(JSON.getString("max_monnum"));
												}
												if (JSON.containsKey("min_monnum")
														&& JSON.getString("min_monnum") != null
														&& !"".equals(JSON.getString("min_monnum"))) {
													applyLoanStrM6.setM6IdBankMinMonnum(JSON.getString("min_monnum"));
												}
												if (JSON.containsKey("max_inteday")
														&& JSON.getString("max_inteday") != null
														&& !"".equals(JSON.getString("max_inteday"))) {
													applyLoanStrM6.setM6IdBankMaxInteday(JSON.getString("max_inteday"));
												}
												if (JSON.containsKey("min_inteday")
														&& JSON.getString("min_inteday") != null
														&& !"".equals(JSON.getString("min_inteday"))) {
													applyLoanStrM6.setM6IdBankMinInteday(JSON.getString("min_inteday"));
												}

												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM6.setM6IdBankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM6.setM6IdBankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM6
															.setM6IdBankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM6
															.setM6IdBankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
										if (idJSON.containsKey("nbank") && idJSON.getString("nbank") != null
												&& !"".equals(idJSON.getString("nbank"))) {
											JSONObject JSON = JSONObject.fromObject(idJSON.getString("nbank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM6.setM6IdNbankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6IdNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrM6.setM6IdNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrM6.setM6IdNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrM6.setM6IdNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrM6.setM6IdNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrM6.setM6IdNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrM6.setM6IdNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrM6
															.setM6IdNbankNsloanAllnum(JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrM6.setM6IdNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrM6
															.setM6IdNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrM6
															.setM6IdNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrM6
															.setM6IdNbankFinleaAllnum(JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrM6
															.setM6IdNbankElseAllnum(JSON.getString("else_allnum"));
												}

												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6IdNbankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("p2p_orgnum")
														&& JSON.getString("p2p_orgnum") != null
														&& !"".equals(JSON.getString("p2p_orgnum"))) {
													applyLoanStrM6.setM6IdNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
												}
												if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
														&& !"".equals(JSON.getString("mc_orgnum"))) {
													applyLoanStrM6.setM6IdNbankMcOrgnum(JSON.getString("mc_orgnum"));
												}
												if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
														&& !"".equals(JSON.getString("ca_orgnum"))) {
													applyLoanStrM6.setM6IdNbankCaOrgnum(JSON.getString("ca_orgnum"));
												}
												if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
														&& !"".equals(JSON.getString("cf_orgnum"))) {
													applyLoanStrM6.setM6IdNbankCfOrgnum(JSON.getString("cf_orgnum"));
												}
												if (JSON.containsKey("com_orgnum")
														&& JSON.getString("com_orgnum") != null
														&& !"".equals(JSON.getString("com_orgnum"))) {
													applyLoanStrM6.setM6IdNbankComOrgnum(JSON.getString("com_orgnum"));
												}
												if (JSON.containsKey("oth_orgnum")
														&& JSON.getString("oth_orgnum") != null
														&& !"".equals(JSON.getString("oth_orgnum"))) {
													applyLoanStrM6.setM6IdNbankOthOrgnum(JSON.getString("oth_orgnum"));
												}
												if (JSON.containsKey("nsloan_orgnum")
														&& JSON.getString("nsloan_orgnum") != null
														&& !"".equals(JSON.getString("nsloan_orgnum"))) {
													applyLoanStrM6
															.setM6IdNbankNsloanOrgnum(JSON.getString("nsloan_orgnum"));
												}
												if (JSON.containsKey("autofin_orgnum")
														&& JSON.getString("autofin_orgnum") != null
														&& !"".equals(JSON.getString("autofin_orgnum"))) {
													applyLoanStrM6.setM6IdNbankAutofinOrgnum(
															JSON.getString("autofin_orgnum"));
												}
												if (JSON.containsKey("sloan_orgnum")
														&& JSON.getString("sloan_orgnum") != null
														&& !"".equals(JSON.getString("sloan_orgnum"))) {
													applyLoanStrM6
															.setM6IdNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
												}
												if (JSON.containsKey("cons_orgnum")
														&& JSON.getString("cons_orgnum") != null
														&& !"".equals(JSON.getString("cons_orgnum"))) {
													applyLoanStrM6
															.setM6IdNbankConsOrgnum(JSON.getString("cons_orgnum"));
												}
												if (JSON.containsKey("finlea_orgnum")
														&& JSON.getString("finlea_orgnum") != null
														&& !"".equals(JSON.getString("finlea_orgnum"))) {
													applyLoanStrM6
															.setM6IdNbankFinleaOrgnum(JSON.getString("finlea_orgnum"));
												}
												if (JSON.containsKey("else_orgnum")
														&& JSON.getString("else_orgnum") != null
														&& !"".equals(JSON.getString("else_orgnum"))) {
													applyLoanStrM6
															.setM6IdNbankElseOrgnum(JSON.getString("else_orgnum"));
												}

												if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
														&& !"".equals(JSON.getString("tot_mons"))) {
													applyLoanStrM6.setM6IdNbankTotMons(JSON.getString("tot_mons"));
												}
												if (JSON.containsKey("avg_monnum")
														&& JSON.getString("avg_monnum") != null
														&& !"".equals(JSON.getString("avg_monnum"))) {
													applyLoanStrM6.setM6IdNbankAvgMonnum(JSON.getString("avg_monnum"));
												}
												if (JSON.containsKey("max_monnum")
														&& JSON.getString("max_monnum") != null
														&& !"".equals(JSON.getString("max_monnum"))) {
													applyLoanStrM6.setM6IdNbankMaxMonnum(JSON.getString("max_monnum"));
												}
												if (JSON.containsKey("min_monnum")
														&& JSON.getString("min_monnum") != null
														&& !"".equals(JSON.getString("min_monnum"))) {
													applyLoanStrM6.setM6IdNbankMinMonnum(JSON.getString("min_monnum"));
												}
												if (JSON.containsKey("max_inteday")
														&& JSON.getString("max_inteday") != null
														&& !"".equals(JSON.getString("max_inteday"))) {
													applyLoanStrM6
															.setM6IdNbankMaxInteday(JSON.getString("max_inteday"));
												}
												if (JSON.containsKey("min_inteday")
														&& JSON.getString("min_inteday") != null
														&& !"".equals(JSON.getString("min_inteday"))) {
													applyLoanStrM6
															.setM6IdNbankMinInteday(JSON.getString("min_inteday"));
												}

												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM6
															.setM6IdNbankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM6
															.setM6IdNbankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM6
															.setM6IdNbankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM6
															.setM6IdNbankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
									}
								}

								if (m6JSON.containsKey("cell") && m6JSON.getString("cell") != null
										&& !"".equals(m6JSON.getString("cell"))) {

									JSONObject cellJSON = JSONObject.fromObject(m6JSON.getString("cell"));
									if (cellJSON != null) {
										if (cellJSON.containsKey("max_inteday")
												&& cellJSON.getString("max_inteday") != null
												&& !"".equals(cellJSON.getString("max_inteday"))) {
											applyLoanStrM6.setM6CellMaxInteday(cellJSON.getString("max_inteday"));
										}
										if (cellJSON.containsKey("min_inteday")
												&& cellJSON.getString("min_inteday") != null
												&& !"".equals(cellJSON.getString("min_inteday"))) {
											applyLoanStrM6.setM6CellMinInteday(cellJSON.getString("min_inteday"));
										}
										if (cellJSON.containsKey("tot_mons") && cellJSON.getString("tot_mons") != null
												&& !"".equals(cellJSON.getString("tot_mons"))) {
											applyLoanStrM6.setM6CellTotMons(cellJSON.getString("tot_mons"));
										}
										if (cellJSON.containsKey("avg_monnum")
												&& cellJSON.getString("avg_monnum") != null
												&& !"".equals(cellJSON.getString("avg_monnum"))) {
											applyLoanStrM6.setM6CellAvgMonnum(cellJSON.getString("avg_monnum"));
										}
										if (cellJSON.containsKey("max_monnum")
												&& cellJSON.getString("max_monnum") != null
												&& !"".equals(cellJSON.getString("max_monnum"))) {
											applyLoanStrM6.setM6CellMaxMonnum(cellJSON.getString("max_monnum"));
										}
										if (cellJSON.containsKey("min_monnum")
												&& cellJSON.getString("min_monnum") != null
												&& !"".equals(cellJSON.getString("min_monnum"))) {
											applyLoanStrM6.setM6CellMinMonnum(cellJSON.getString("min_monnum"));
										}
										if (cellJSON.containsKey("pdl") && cellJSON.getString("pdl") != null
												&& !"".equals(cellJSON.getString("pdl"))) {
											JSONObject pdlJSON = JSONObject.fromObject(cellJSON.getString("pdl"));
											if (pdlJSON != null) {
												if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
														&& !"".equals(pdlJSON.getString("allnum"))) {
													applyLoanStrM6.setM6CellPdlAllnum(pdlJSON.getString("allnum"));
												}
												if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
														&& !"".equals(pdlJSON.getString("orgnum"))) {
													applyLoanStrM6.setM6CellPdlOrgnum(pdlJSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("caon") && cellJSON.getString("caon") != null
												&& !"".equals(cellJSON.getString("caon"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6CellCaonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6CellCaonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("rel") && cellJSON.getString("rel") != null
												&& !"".equals(cellJSON.getString("rel"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("rel"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6CellRelAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6CellRelOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("caoff") && cellJSON.getString("caoff") != null
												&& !"".equals(cellJSON.getString("caoff"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caoff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6CellCaoffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6CellCaoffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("cooff") && cellJSON.getString("cooff") != null
												&& !"".equals(cellJSON.getString("cooff"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("cooff"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6CellCooffAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6CellCooffOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("af") && cellJSON.getString("af") != null
												&& !"".equals(cellJSON.getString("af"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("af"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6CellAfAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6CellAfOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("coon") && cellJSON.getString("coon") != null
												&& !"".equals(cellJSON.getString("coon"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("coon"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6CellCoonAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6CellCoonOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("oth") && cellJSON.getString("oth") != null
												&& !"".equals(cellJSON.getString("oth"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("oth"));
											if (JSON != null) {
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6CellOthAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6CellOthOrgnum(JSON.getString("orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("bank") && cellJSON.getString("bank") != null
												&& !"".equals(cellJSON.getString("bank"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("bank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM6.setM6CellBankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6CellBankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("tra_allnum")
														&& JSON.getString("tra_allnum") != null
														&& !"".equals(JSON.getString("tra_allnum"))) {
													applyLoanStrM6.setM6CellBankTraAllnum(JSON.getString("tra_allnum"));
												}
												if (JSON.containsKey("ret_allnum")
														&& JSON.getString("ret_allnum") != null
														&& !"".equals(JSON.getString("ret_allnum"))) {
													applyLoanStrM6.setM6CellBankRetAllnum(JSON.getString("ret_allnum"));
												}
												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6CellBankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("tra_orgnum")
														&& JSON.getString("tra_orgnum") != null
														&& !"".equals(JSON.getString("tra_orgnum"))) {
													applyLoanStrM6.setM6CellBankTraOrgnum(JSON.getString("tra_orgnum"));
												}
												if (JSON.containsKey("ret_orgnum")
														&& JSON.getString("ret_orgnum") != null
														&& !"".equals(JSON.getString("ret_orgnum"))) {
													applyLoanStrM6.setM6CellBankRetOrgnum(JSON.getString("ret_orgnum"));
												}

												if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
														&& !"".equals(JSON.getString("tot_mons"))) {
													applyLoanStrM6.setM6CellBankTotMons(JSON.getString("tot_mons"));
												}
												if (JSON.containsKey("avg_monnum")
														&& JSON.getString("avg_monnum") != null
														&& !"".equals(JSON.getString("avg_monnum"))) {
													applyLoanStrM6.setM6CellBankAvgMonnum(JSON.getString("avg_monnum"));
												}
												if (JSON.containsKey("max_monnum")
														&& JSON.getString("max_monnum") != null
														&& !"".equals(JSON.getString("max_monnum"))) {
													applyLoanStrM6.setM6CellBankMaxMonnum(JSON.getString("max_monnum"));
												}
												if (JSON.containsKey("min_monnum")
														&& JSON.getString("min_monnum") != null
														&& !"".equals(JSON.getString("min_monnum"))) {
													applyLoanStrM6.setM6CellBankMinMonnum(JSON.getString("min_monnum"));
												}
												if (JSON.containsKey("max_inteday")
														&& JSON.getString("max_inteday") != null
														&& !"".equals(JSON.getString("max_inteday"))) {
													applyLoanStrM6
															.setM6CellBankMaxInteday(JSON.getString("max_inteday"));
												}
												if (JSON.containsKey("min_inteday")
														&& JSON.getString("min_inteday") != null
														&& !"".equals(JSON.getString("min_inteday"))) {
													applyLoanStrM6
															.setM6CellBankMinInteday(JSON.getString("min_inteday"));
												}

												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM6
															.setM6CellBankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM6
															.setM6CellBankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM6
															.setM6CellBankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM6
															.setM6CellBankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
										if (cellJSON.containsKey("nbank") && cellJSON.getString("nbank") != null
												&& !"".equals(cellJSON.getString("nbank"))) {
											JSONObject JSON = JSONObject.fromObject(cellJSON.getString("nbank"));
											if (JSON != null) {
												if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
														&& !"".equals(JSON.getString("selfnum"))) {
													applyLoanStrM6.setM6CellNbankSelfnum(JSON.getString("selfnum"));
												}
												if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
														&& !"".equals(JSON.getString("allnum"))) {
													applyLoanStrM6.setM6CellNbankAllnum(JSON.getString("allnum"));
												}
												if (JSON.containsKey("p2p_allnum")
														&& JSON.getString("p2p_allnum") != null
														&& !"".equals(JSON.getString("p2p_allnum"))) {
													applyLoanStrM6
															.setM6CellNbankP2pAllnum(JSON.getString("p2p_allnum"));
												}
												if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
														&& !"".equals(JSON.getString("mc_allnum"))) {
													applyLoanStrM6.setM6CellNbankMcAllnum(JSON.getString("mc_allnum"));
												}
												if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
														&& !"".equals(JSON.getString("ca_allnum"))) {
													applyLoanStrM6.setM6CellNbankCaAllnum(JSON.getString("ca_allnum"));
												}
												if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
														&& !"".equals(JSON.getString("cf_allnum"))) {
													applyLoanStrM6.setM6CellNbankCfAllnum(JSON.getString("cf_allnum"));
												}
												if (JSON.containsKey("com_allnum")
														&& JSON.getString("com_allnum") != null
														&& !"".equals(JSON.getString("com_allnum"))) {
													applyLoanStrM6
															.setM6CellNbankComAllnum(JSON.getString("com_allnum"));
												}
												if (JSON.containsKey("oth_allnum")
														&& JSON.getString("oth_allnum") != null
														&& !"".equals(JSON.getString("oth_allnum"))) {
													applyLoanStrM6
															.setM6CellNbankOthAllnum(JSON.getString("oth_allnum"));
												}
												if (JSON.containsKey("nsloan_allnum")
														&& JSON.getString("nsloan_allnum") != null
														&& !"".equals(JSON.getString("nsloan_allnum"))) {
													applyLoanStrM6.setM6CellNbankNsloanAllnum(
															JSON.getString("nsloan_allnum"));
												}
												if (JSON.containsKey("autofin_allnum")
														&& JSON.getString("autofin_allnum") != null
														&& !"".equals(JSON.getString("autofin_allnum"))) {
													applyLoanStrM6.setM6CellNbankAutofinAllnum(
															JSON.getString("autofin_allnum"));
												}
												if (JSON.containsKey("sloan_allnum")
														&& JSON.getString("sloan_allnum") != null
														&& !"".equals(JSON.getString("sloan_allnum"))) {
													applyLoanStrM6
															.setM6CellNbankSloanAllnum(JSON.getString("sloan_allnum"));
												}
												if (JSON.containsKey("cons_allnum")
														&& JSON.getString("cons_allnum") != null
														&& !"".equals(JSON.getString("cons_allnum"))) {
													applyLoanStrM6
															.setM6CellNbankConsAllnum(JSON.getString("cons_allnum"));
												}
												if (JSON.containsKey("finlea_allnum")
														&& JSON.getString("finlea_allnum") != null
														&& !"".equals(JSON.getString("finlea_allnum"))) {
													applyLoanStrM6.setM6CellNbankFinleaAllnum(
															JSON.getString("finlea_allnum"));
												}
												if (JSON.containsKey("else_allnum")
														&& JSON.getString("else_allnum") != null
														&& !"".equals(JSON.getString("else_allnum"))) {
													applyLoanStrM6
															.setM6CellNbankElseAllnum(JSON.getString("else_allnum"));
												}

												if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
														&& !"".equals(JSON.getString("orgnum"))) {
													applyLoanStrM6.setM6CellNbankOrgnum(JSON.getString("orgnum"));
												}
												if (JSON.containsKey("p2p_orgnum")
														&& JSON.getString("p2p_orgnum") != null
														&& !"".equals(JSON.getString("p2p_orgnum"))) {
													applyLoanStrM6
															.setM6CellNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
												}
												if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
														&& !"".equals(JSON.getString("mc_orgnum"))) {
													applyLoanStrM6.setM6CellNbankMcOrgnum(JSON.getString("mc_orgnum"));
												}
												if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
														&& !"".equals(JSON.getString("ca_orgnum"))) {
													applyLoanStrM6.setM6CellNbankCaOrgnum(JSON.getString("ca_orgnum"));
												}
												if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
														&& !"".equals(JSON.getString("cf_orgnum"))) {
													applyLoanStrM6.setM6CellNbankCfOrgnum(JSON.getString("cf_orgnum"));
												}
												if (JSON.containsKey("com_orgnum")
														&& JSON.getString("com_orgnum") != null
														&& !"".equals(JSON.getString("com_orgnum"))) {
													applyLoanStrM6
															.setM6CellNbankComOrgnum(JSON.getString("com_orgnum"));
												}
												if (JSON.containsKey("oth_orgnum")
														&& JSON.getString("oth_orgnum") != null
														&& !"".equals(JSON.getString("oth_orgnum"))) {
													applyLoanStrM6
															.setM6CellNbankOthOrgnum(JSON.getString("oth_orgnum"));
												}
												if (JSON.containsKey("nsloan_orgnum")
														&& JSON.getString("nsloan_orgnum") != null
														&& !"".equals(JSON.getString("nsloan_orgnum"))) {
													applyLoanStrM6.setM6CellNbankNsloanOrgnum(
															JSON.getString("nsloan_orgnum"));
												}
												if (JSON.containsKey("autofin_orgnum")
														&& JSON.getString("autofin_orgnum") != null
														&& !"".equals(JSON.getString("autofin_orgnum"))) {
													applyLoanStrM6.setM6CellNbankAutofinOrgnum(
															JSON.getString("autofin_orgnum"));
												}
												if (JSON.containsKey("sloan_orgnum")
														&& JSON.getString("sloan_orgnum") != null
														&& !"".equals(JSON.getString("sloan_orgnum"))) {
													applyLoanStrM6
															.setM6CellNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
												}
												if (JSON.containsKey("cons_orgnum")
														&& JSON.getString("cons_orgnum") != null
														&& !"".equals(JSON.getString("cons_orgnum"))) {
													applyLoanStrM6
															.setM6CellNbankConsOrgnum(JSON.getString("cons_orgnum"));
												}
												if (JSON.containsKey("finlea_orgnum")
														&& JSON.getString("finlea_orgnum") != null
														&& !"".equals(JSON.getString("finlea_orgnum"))) {
													applyLoanStrM6.setM6CellNbankFinleaOrgnum(
															JSON.getString("finlea_orgnum"));
												}
												if (JSON.containsKey("else_orgnum")
														&& JSON.getString("else_orgnum") != null
														&& !"".equals(JSON.getString("else_orgnum"))) {
													applyLoanStrM6
															.setM6CellNbankElseOrgnum(JSON.getString("else_orgnum"));
												}

												if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
														&& !"".equals(JSON.getString("tot_mons"))) {
													applyLoanStrM6.setM6CellNbankTotMons(JSON.getString("tot_mons"));
												}
												if (JSON.containsKey("avg_monnum")
														&& JSON.getString("avg_monnum") != null
														&& !"".equals(JSON.getString("avg_monnum"))) {
													applyLoanStrM6
															.setM6CellNbankAvgMonnum(JSON.getString("avg_monnum"));
												}
												if (JSON.containsKey("max_monnum")
														&& JSON.getString("max_monnum") != null
														&& !"".equals(JSON.getString("max_monnum"))) {
													applyLoanStrM6
															.setM6CellNbankMaxMonnum(JSON.getString("max_monnum"));
												}
												if (JSON.containsKey("min_monnum")
														&& JSON.getString("min_monnum") != null
														&& !"".equals(JSON.getString("min_monnum"))) {
													applyLoanStrM6
															.setM6CellNbankMinMonnum(JSON.getString("min_monnum"));
												}
												if (JSON.containsKey("max_inteday")
														&& JSON.getString("max_inteday") != null
														&& !"".equals(JSON.getString("max_inteday"))) {
													applyLoanStrM6
															.setM6CellNbankMaxInteday(JSON.getString("max_inteday"));
												}
												if (JSON.containsKey("min_inteday")
														&& JSON.getString("min_inteday") != null
														&& !"".equals(JSON.getString("min_inteday"))) {
													applyLoanStrM6
															.setM6CellNbankMinInteday(JSON.getString("min_inteday"));
												}

												if (JSON.containsKey("week_allnum")
														&& JSON.getString("week_allnum") != null
														&& !"".equals(JSON.getString("week_allnum"))) {
													applyLoanStrM6
															.setM6CellNbankWeekAllnum(JSON.getString("week_allnum"));
												}
												if (JSON.containsKey("week_orgnum")
														&& JSON.getString("week_orgnum") != null
														&& !"".equals(JSON.getString("week_orgnum"))) {
													applyLoanStrM6
															.setM6CellNbankWeekOrgnum(JSON.getString("week_orgnum"));
												}
												if (JSON.containsKey("night_allnum")
														&& JSON.getString("night_allnum") != null
														&& !"".equals(JSON.getString("night_allnum"))) {
													applyLoanStrM6
															.setM6CellNbankNightAllnum(JSON.getString("night_allnum"));
												}
												if (JSON.containsKey("night_orgnum")
														&& JSON.getString("night_orgnum") != null
														&& !"".equals(JSON.getString("night_orgnum"))) {
													applyLoanStrM6
															.setM6CellNbankNightOrgnum(JSON.getString("night_orgnum"));
												}
											}
										}
									}

								}
							}
						}
						if (applyLoanStrJSON.containsKey("m12") && applyLoanStrJSON.getString("m12") != null
								&& !"".equals(applyLoanStrJSON.getString("m12"))) {
							JSONObject m12JSON = JSONObject.fromObject(applyLoanStrJSON.getString("m12"));
							if (m12JSON != null && (!m12JSON.isEmpty())) {
								ApplyLoanStrMonth12 applyLoanStrM12 = new ApplyLoanStrMonth12();
								applyLoanStrM12.setUuid(GuidUtil.getGuid());
								applyLoanStrM12.setCrtTime(new Date());
								applyLoanStrM12.setCrtUser(crtUser);
								applyLoanStrM12.setTrnId(trnId);
								applyLoanStrM12.setAppId(appId);
								applyLoanStrM12.setTrnKey(trnKey);
								applyLoanStr.setApplyLoanStrM12(applyLoanStrM12);
								parseM12(m12JSON, applyLoanStrM12);
							}
						}
						if (applyLoanStrJSON.containsKey("fst") && applyLoanStrJSON.getString("fst") != null
								&& !"".equals(applyLoanStrJSON.getString("fst"))) {
							JSONObject fstJSON = JSONObject.fromObject(applyLoanStrJSON.getString("fst"));
							if (fstJSON != null && (!fstJSON.isEmpty())) {
								ApplyLoanStrFst applyLoanStrFst = new ApplyLoanStrFst();
								applyLoanStrFst.setUuid(GuidUtil.getGuid());
								applyLoanStrFst.setCrtTime(new Date());
								applyLoanStrFst.setCrtUser(crtUser);
								applyLoanStrFst.setTrnId(trnId);
								applyLoanStrFst.setAppId(appId);
								applyLoanStrFst.setTrnKey(trnKey);
								applyLoanStr.setApplyLoanStrFst(applyLoanStrFst);
								parseFST(fstJSON, applyLoanStrFst);
							}
						}
						if (applyLoanStrJSON.containsKey("lst") && applyLoanStrJSON.getString("lst") != null
								&& !"".equals(applyLoanStrJSON.getString("lst"))) {
							JSONObject lstJSON = JSONObject.fromObject(applyLoanStrJSON.getString("lst"));
							if (lstJSON != null && (!lstJSON.isEmpty())) {
								ApplyLoanStrLst applyLoanStrLst = new ApplyLoanStrLst();
								applyLoanStrLst.setUuid(GuidUtil.getGuid());
								applyLoanStrLst.setCrtTime(new Date());
								applyLoanStrLst.setCrtUser(crtUser);
								applyLoanStrLst.setTrnId(trnId);
								applyLoanStrLst.setAppId(appId);
								applyLoanStrLst.setTrnKey(trnKey);
								applyLoanStr.setApplyLoanStrLst(applyLoanStrLst);
								parseLST(lstJSON, applyLoanStrLst);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[百融多头借贷] 数据解析异常:{}", e.getMessage());
		}
		return applyLoanStr;
	}

	// 因为解析方法不能太大，故分解方法parseFST
	public static void parseFST(JSONObject fstJSON, ApplyLoanStrFst applyLoanStrFst) {
		if (fstJSON.containsKey("id") && fstJSON.getString("id") != null && !"".equals(fstJSON.getString("id"))) {
			JSONObject idJSON = JSONObject.fromObject(fstJSON.getString("id"));
			if (idJSON != null) {
				if (idJSON.containsKey("bank") && idJSON.getString("bank") != null
						&& !"".equals(idJSON.getString("bank"))) {
					JSONObject bankJSON = JSONObject.fromObject(idJSON.getString("bank"));
					if (bankJSON != null) {
						if (bankJSON.containsKey("inteday") && bankJSON.getString("inteday") != null
								&& !"".equals(bankJSON.getString("inteday"))) {
							applyLoanStrFst.setFstIdBankInteday(bankJSON.getString("inteday"));
						}
					}
				}
				if (idJSON.containsKey("nbank") && idJSON.getString("nbank") != null
						&& !"".equals(idJSON.getString("nbank"))) {
					JSONObject nbankJSON = JSONObject.fromObject(idJSON.getString("nbank"));
					if (nbankJSON != null) {
						if (nbankJSON.containsKey("inteday") && nbankJSON.getString("inteday") != null
								&& !"".equals(nbankJSON.getString("inteday"))) {
							applyLoanStrFst.setFstIdNbankInteday(nbankJSON.getString("inteday"));
						}
					}
				}
			}
		}
		if (fstJSON.containsKey("cell") && fstJSON.getString("cell") != null && !"".equals(fstJSON.getString("cell"))) {
			JSONObject cellJSON = JSONObject.fromObject(fstJSON.getString("cell"));
			if (cellJSON != null) {
				if (cellJSON.containsKey("bank") && cellJSON.getString("bank") != null
						&& !"".equals(cellJSON.getString("bank"))) {
					JSONObject bankJSON = JSONObject.fromObject(cellJSON.getString("bank"));
					if (bankJSON != null) {
						if (bankJSON.containsKey("inteday") && bankJSON.getString("inteday") != null
								&& !"".equals(bankJSON.getString("inteday"))) {
							applyLoanStrFst.setFstCellBankInteday(bankJSON.getString("inteday"));
						}
					}
				}
				if (cellJSON.containsKey("nbank") && cellJSON.getString("nbank") != null
						&& !"".equals(cellJSON.getString("nbank"))) {
					JSONObject nbankJSON = JSONObject.fromObject(cellJSON.getString("nbank"));
					if (nbankJSON != null) {
						if (nbankJSON.containsKey("inteday") && nbankJSON.getString("inteday") != null
								&& !"".equals(nbankJSON.getString("inteday"))) {
							applyLoanStrFst.setFstCellNbankInteday(nbankJSON.getString("inteday"));
						}
					}
				}
			}
		}
	}

	// 因为解析方法不能太大，故分解方法parseLST
	public static void parseLST(JSONObject lstJSON, ApplyLoanStrLst applyLoanStrLst) {
		if (lstJSON.containsKey("id") && lstJSON.getString("id") != null && !"".equals(lstJSON.getString("id"))) {
			JSONObject idJSON = JSONObject.fromObject(lstJSON.getString("id"));
			if (idJSON != null) {
				if (idJSON.containsKey("bank") && idJSON.getString("bank") != null
						&& !"".equals(idJSON.getString("bank"))) {
					JSONObject bankJSON = JSONObject.fromObject(idJSON.getString("bank"));
					if (bankJSON != null) {
						if (bankJSON.containsKey("inteday") && bankJSON.getString("inteday") != null
								&& !"".equals(bankJSON.getString("inteday"))) {
							applyLoanStrLst.setLstIdBankInteday(bankJSON.getString("inteday"));
						}
						if (bankJSON.containsKey("consnum") && bankJSON.getString("consnum") != null
								&& !"".equals(bankJSON.getString("consnum"))) {
							applyLoanStrLst.setLstIdBankConsnum(bankJSON.getString("consnum"));
						}
						if (bankJSON.containsKey("csinteday") && bankJSON.getString("csinteday") != null
								&& !"".equals(bankJSON.getString("csinteday"))) {
							applyLoanStrLst.setLstIdBankCsinteday(bankJSON.getString("csinteday"));
						}
					}
				}
				if (idJSON.containsKey("nbank") && idJSON.getString("nbank") != null
						&& !"".equals(idJSON.getString("nbank"))) {
					JSONObject nbankJSON = JSONObject.fromObject(idJSON.getString("nbank"));
					if (nbankJSON != null) {
						if (nbankJSON.containsKey("inteday") && nbankJSON.getString("inteday") != null
								&& !"".equals(nbankJSON.getString("inteday"))) {
							applyLoanStrLst.setLstIdNbankInteday(nbankJSON.getString("inteday"));
						}
						if (nbankJSON.containsKey("consnum") && nbankJSON.getString("consnum") != null
								&& !"".equals(nbankJSON.getString("consnum"))) {
							applyLoanStrLst.setLstIdNbankConsnum(nbankJSON.getString("consnum"));
						}
						if (nbankJSON.containsKey("csinteday") && nbankJSON.getString("csinteday") != null
								&& !"".equals(nbankJSON.getString("csinteday"))) {
							applyLoanStrLst.setLstIdNbankCsinteday(nbankJSON.getString("csinteday"));
						}
					}
				}
			}
		}
		if (lstJSON.containsKey("cell") && lstJSON.getString("cell") != null && !"".equals(lstJSON.getString("cell"))) {
			JSONObject cellJSON = JSONObject.fromObject(lstJSON.getString("cell"));
			if (cellJSON != null) {
				if (cellJSON.containsKey("bank") && cellJSON.getString("bank") != null
						&& !"".equals(cellJSON.getString("bank"))) {
					JSONObject bankJSON = JSONObject.fromObject(cellJSON.getString("bank"));
					if (bankJSON != null) {
						if (bankJSON.containsKey("inteday") && bankJSON.getString("inteday") != null
								&& !"".equals(bankJSON.getString("inteday"))) {
							applyLoanStrLst.setLstCellBankInteday(bankJSON.getString("inteday"));
						}
						if (bankJSON.containsKey("consnum") && bankJSON.getString("consnum") != null
								&& !"".equals(bankJSON.getString("consnum"))) {
							applyLoanStrLst.setLstCellBankConsnum(bankJSON.getString("consnum"));
						}
						if (bankJSON.containsKey("csinteday") && bankJSON.getString("csinteday") != null
								&& !"".equals(bankJSON.getString("csinteday"))) {
							applyLoanStrLst.setLstCellBankCsinteday(bankJSON.getString("csinteday"));
						}

					}
				}
				if (cellJSON.containsKey("nbank") && cellJSON.getString("nbank") != null
						&& !"".equals(cellJSON.getString("nbank"))) {
					JSONObject nbankJSON = JSONObject.fromObject(cellJSON.getString("nbank"));
					if (nbankJSON != null) {
						if (nbankJSON.containsKey("inteday") && nbankJSON.getString("inteday") != null
								&& !"".equals(nbankJSON.getString("inteday"))) {
							applyLoanStrLst.setLstCellNbankInteday(nbankJSON.getString("inteday"));
						}
						if (nbankJSON.containsKey("consnum") && nbankJSON.getString("consnum") != null
								&& !"".equals(nbankJSON.getString("consnum"))) {
							applyLoanStrLst.setLstCellNbankConsnum(nbankJSON.getString("consnum"));
						}
						if (nbankJSON.containsKey("csinteday") && nbankJSON.getString("csinteday") != null
								&& !"".equals(nbankJSON.getString("csinteday"))) {
							applyLoanStrLst.setLstCellNbankCsinteday(nbankJSON.getString("csinteday"));
						}
					}
				}
			}
		}

	}

	// 因为解析方法不能太大，故分解方法最近12个月的
	public static void parseM12(JSONObject m12JSON, ApplyLoanStrMonth12 applyLoanStrM12) {

		if (m12JSON != null) {
			if (m12JSON.containsKey("id") && m12JSON.getString("id") != null && !"".equals(m12JSON.getString("id"))) {
				JSONObject idJSON = JSONObject.fromObject(m12JSON.getString("id"));
				if (idJSON != null) {
					if (idJSON.containsKey("max_inteday") && idJSON.getString("max_inteday") != null
							&& !"".equals(idJSON.getString("max_inteday"))) {
						applyLoanStrM12.setM12IdMaxInteday(idJSON.getString("max_inteday"));
					}
					if (idJSON.containsKey("min_inteday") && idJSON.getString("min_inteday") != null
							&& !"".equals(idJSON.getString("min_inteday"))) {
						applyLoanStrM12.setM12IdMinInteday(idJSON.getString("min_inteday"));
					}
					if (idJSON.containsKey("tot_mons") && idJSON.getString("tot_mons") != null
							&& !"".equals(idJSON.getString("tot_mons"))) {
						applyLoanStrM12.setM12IdTotMons(idJSON.getString("tot_mons"));
					}
					if (idJSON.containsKey("avg_monnum") && idJSON.getString("avg_monnum") != null
							&& !"".equals(idJSON.getString("avg_monnum"))) {
						applyLoanStrM12.setM12IdAvgMonnum(idJSON.getString("avg_monnum"));
					}
					if (idJSON.containsKey("max_monnum") && idJSON.getString("max_monnum") != null
							&& !"".equals(idJSON.getString("max_monnum"))) {
						applyLoanStrM12.setM12IdMaxMonnum(idJSON.getString("max_monnum"));
					}
					if (idJSON.containsKey("min_monnum") && idJSON.getString("min_monnum") != null
							&& !"".equals(idJSON.getString("min_monnum"))) {
						applyLoanStrM12.setM12IdMinMonnum(idJSON.getString("min_monnum"));
					}
					if (idJSON.containsKey("pdl") && idJSON.getString("pdl") != null
							&& !"".equals(idJSON.getString("pdl"))) {
						JSONObject pdlJSON = JSONObject.fromObject(idJSON.getString("pdl"));
						if (pdlJSON != null) {
							if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
									&& !"".equals(pdlJSON.getString("allnum"))) {
								applyLoanStrM12.setM12IdPdlAllnum(pdlJSON.getString("allnum"));
							}
							if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
									&& !"".equals(pdlJSON.getString("orgnum"))) {
								applyLoanStrM12.setM12IdPdlOrgnum(pdlJSON.getString("orgnum"));
							}
						}
					}
					if (idJSON.containsKey("caon") && idJSON.getString("caon") != null
							&& !"".equals(idJSON.getString("caon"))) {
						JSONObject JSON = JSONObject.fromObject(idJSON.getString("caon"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12IdCaonAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12IdCaonOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (idJSON.containsKey("rel") && idJSON.getString("rel") != null
							&& !"".equals(idJSON.getString("rel"))) {
						JSONObject JSON = JSONObject.fromObject(idJSON.getString("rel"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12IdRelAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12IdRelOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (idJSON.containsKey("caoff") && idJSON.getString("caoff") != null
							&& !"".equals(idJSON.getString("caoff"))) {
						JSONObject JSON = JSONObject.fromObject(idJSON.getString("caoff"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12IdCaoffAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12IdCaoffOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (idJSON.containsKey("cooff") && idJSON.getString("cooff") != null
							&& !"".equals(idJSON.getString("cooff"))) {
						JSONObject JSON = JSONObject.fromObject(idJSON.getString("cooff"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12IdCooffAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12IdCooffOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (idJSON.containsKey("af") && idJSON.getString("af") != null
							&& !"".equals(idJSON.getString("af"))) {
						JSONObject JSON = JSONObject.fromObject(idJSON.getString("af"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12IdAfAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12IdAfOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (idJSON.containsKey("coon") && idJSON.getString("coon") != null
							&& !"".equals(idJSON.getString("coon"))) {
						JSONObject JSON = JSONObject.fromObject(idJSON.getString("coon"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12IdCoonAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12IdCoonOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (idJSON.containsKey("oth") && idJSON.getString("oth") != null
							&& !"".equals(idJSON.getString("oth"))) {
						JSONObject JSON = JSONObject.fromObject(idJSON.getString("oth"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12IdOthAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12IdOthOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (idJSON.containsKey("bank") && idJSON.getString("bank") != null
							&& !"".equals(idJSON.getString("bank"))) {
						JSONObject JSON = JSONObject.fromObject(idJSON.getString("bank"));
						if (JSON != null) {
							if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
									&& !"".equals(JSON.getString("selfnum"))) {
								applyLoanStrM12.setM12IdBankSelfnum(JSON.getString("selfnum"));
							}
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12IdBankAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("tra_allnum") && JSON.getString("tra_allnum") != null
									&& !"".equals(JSON.getString("tra_allnum"))) {
								applyLoanStrM12.setM12IdBankTraAllnum(JSON.getString("tra_allnum"));
							}
							if (JSON.containsKey("ret_allnum") && JSON.getString("ret_allnum") != null
									&& !"".equals(JSON.getString("ret_allnum"))) {
								applyLoanStrM12.setM12IdBankRetAllnum(JSON.getString("ret_allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12IdBankOrgnum(JSON.getString("orgnum"));
							}
							if (JSON.containsKey("tra_orgnum") && JSON.getString("tra_orgnum") != null
									&& !"".equals(JSON.getString("tra_orgnum"))) {
								applyLoanStrM12.setM12IdBankTraOrgnum(JSON.getString("tra_orgnum"));
							}
							if (JSON.containsKey("ret_orgnum") && JSON.getString("ret_orgnum") != null
									&& !"".equals(JSON.getString("ret_orgnum"))) {
								applyLoanStrM12.setM12IdBankRetOrgnum(JSON.getString("ret_orgnum"));
							}

							if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
									&& !"".equals(JSON.getString("tot_mons"))) {
								applyLoanStrM12.setM12IdBankTotMons(JSON.getString("tot_mons"));
							}
							if (JSON.containsKey("avg_monnum") && JSON.getString("avg_monnum") != null
									&& !"".equals(JSON.getString("avg_monnum"))) {
								applyLoanStrM12.setM12IdBankAvgMonnum(JSON.getString("avg_monnum"));
							}
							if (JSON.containsKey("max_monnum") && JSON.getString("max_monnum") != null
									&& !"".equals(JSON.getString("max_monnum"))) {
								applyLoanStrM12.setM12IdBankMaxMonnum(JSON.getString("max_monnum"));
							}
							if (JSON.containsKey("min_monnum") && JSON.getString("min_monnum") != null
									&& !"".equals(JSON.getString("min_monnum"))) {
								applyLoanStrM12.setM12IdBankMinMonnum(JSON.getString("min_monnum"));
							}
							if (JSON.containsKey("max_inteday") && JSON.getString("max_inteday") != null
									&& !"".equals(JSON.getString("max_inteday"))) {
								applyLoanStrM12.setM12IdBankMaxInteday(JSON.getString("max_inteday"));
							}
							if (JSON.containsKey("min_inteday") && JSON.getString("min_inteday") != null
									&& !"".equals(JSON.getString("min_inteday"))) {
								applyLoanStrM12.setM12IdBankMinInteday(JSON.getString("min_inteday"));
							}

							if (JSON.containsKey("week_allnum") && JSON.getString("week_allnum") != null
									&& !"".equals(JSON.getString("week_allnum"))) {
								applyLoanStrM12.setM12IdBankWeekAllnum(JSON.getString("week_allnum"));
							}
							if (JSON.containsKey("week_orgnum") && JSON.getString("week_orgnum") != null
									&& !"".equals(JSON.getString("week_orgnum"))) {
								applyLoanStrM12.setM12IdBankWeekOrgnum(JSON.getString("week_orgnum"));
							}
							if (JSON.containsKey("night_allnum") && JSON.getString("night_allnum") != null
									&& !"".equals(JSON.getString("night_allnum"))) {
								applyLoanStrM12.setM12IdBankNightAllnum(JSON.getString("night_allnum"));
							}
							if (JSON.containsKey("night_orgnum") && JSON.getString("night_orgnum") != null
									&& !"".equals(JSON.getString("night_orgnum"))) {
								applyLoanStrM12.setM12IdBankNightOrgnum(JSON.getString("night_orgnum"));
							}
						}
					}
					if (idJSON.containsKey("nbank") && idJSON.getString("nbank") != null
							&& !"".equals(idJSON.getString("nbank"))) {
						JSONObject JSON = JSONObject.fromObject(idJSON.getString("nbank"));
						if (JSON != null) {
							if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
									&& !"".equals(JSON.getString("selfnum"))) {
								applyLoanStrM12.setM12IdNbankSelfnum(JSON.getString("selfnum"));
							}
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12IdNbankAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("p2p_allnum") && JSON.getString("p2p_allnum") != null
									&& !"".equals(JSON.getString("p2p_allnum"))) {
								applyLoanStrM12.setM12IdNbankP2pAllnum(JSON.getString("p2p_allnum"));
							}
							if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
									&& !"".equals(JSON.getString("mc_allnum"))) {
								applyLoanStrM12.setM12IdNbankMcAllnum(JSON.getString("mc_allnum"));
							}
							if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
									&& !"".equals(JSON.getString("ca_allnum"))) {
								applyLoanStrM12.setM12IdNbankCaAllnum(JSON.getString("ca_allnum"));
							}
							if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
									&& !"".equals(JSON.getString("cf_allnum"))) {
								applyLoanStrM12.setM12IdNbankCfAllnum(JSON.getString("cf_allnum"));
							}
							if (JSON.containsKey("com_allnum") && JSON.getString("com_allnum") != null
									&& !"".equals(JSON.getString("com_allnum"))) {
								applyLoanStrM12.setM12IdNbankComAllnum(JSON.getString("com_allnum"));
							}
							if (JSON.containsKey("oth_allnum") && JSON.getString("oth_allnum") != null
									&& !"".equals(JSON.getString("oth_allnum"))) {
								applyLoanStrM12.setM12IdNbankOthAllnum(JSON.getString("oth_allnum"));
							}
							if (JSON.containsKey("nsloan_allnum") && JSON.getString("nsloan_allnum") != null
									&& !"".equals(JSON.getString("nsloan_allnum"))) {
								applyLoanStrM12.setM12IdNbankNsloanAllnum(JSON.getString("nsloan_allnum"));
							}
							if (JSON.containsKey("autofin_allnum") && JSON.getString("autofin_allnum") != null
									&& !"".equals(JSON.getString("autofin_allnum"))) {
								applyLoanStrM12.setM12IdNbankAutofinAllnum(JSON.getString("autofin_allnum"));
							}
							if (JSON.containsKey("sloan_allnum") && JSON.getString("sloan_allnum") != null
									&& !"".equals(JSON.getString("sloan_allnum"))) {
								applyLoanStrM12.setM12IdNbankSloanAllnum(JSON.getString("sloan_allnum"));
							}
							if (JSON.containsKey("cons_allnum") && JSON.getString("cons_allnum") != null
									&& !"".equals(JSON.getString("cons_allnum"))) {
								applyLoanStrM12.setM12IdNbankConsAllnum(JSON.getString("cons_allnum"));
							}
							if (JSON.containsKey("finlea_allnum") && JSON.getString("finlea_allnum") != null
									&& !"".equals(JSON.getString("finlea_allnum"))) {
								applyLoanStrM12.setM12IdNbankFinleaAllnum(JSON.getString("finlea_allnum"));
							}
							if (JSON.containsKey("else_allnum") && JSON.getString("else_allnum") != null
									&& !"".equals(JSON.getString("else_allnum"))) {
								applyLoanStrM12.setM12IdNbankElseAllnum(JSON.getString("else_allnum"));
							}

							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12IdNbankOrgnum(JSON.getString("orgnum"));
							}
							if (JSON.containsKey("p2p_orgnum") && JSON.getString("p2p_orgnum") != null
									&& !"".equals(JSON.getString("p2p_orgnum"))) {
								applyLoanStrM12.setM12IdNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
							}
							if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
									&& !"".equals(JSON.getString("mc_orgnum"))) {
								applyLoanStrM12.setM12IdNbankMcOrgnum(JSON.getString("mc_orgnum"));
							}
							if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
									&& !"".equals(JSON.getString("ca_orgnum"))) {
								applyLoanStrM12.setM12IdNbankCaOrgnum(JSON.getString("ca_orgnum"));
							}
							if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
									&& !"".equals(JSON.getString("cf_orgnum"))) {
								applyLoanStrM12.setM12IdNbankCfOrgnum(JSON.getString("cf_orgnum"));
							}
							if (JSON.containsKey("com_orgnum") && JSON.getString("com_orgnum") != null
									&& !"".equals(JSON.getString("com_orgnum"))) {
								applyLoanStrM12.setM12IdNbankComOrgnum(JSON.getString("com_orgnum"));
							}
							if (JSON.containsKey("oth_orgnum") && JSON.getString("oth_orgnum") != null
									&& !"".equals(JSON.getString("oth_orgnum"))) {
								applyLoanStrM12.setM12IdNbankOthOrgnum(JSON.getString("oth_orgnum"));
							}
							if (JSON.containsKey("nsloan_orgnum") && JSON.getString("nsloan_orgnum") != null
									&& !"".equals(JSON.getString("nsloan_orgnum"))) {
								applyLoanStrM12.setM12IdNbankNsloanOrgnum(JSON.getString("nsloan_orgnum"));
							}
							if (JSON.containsKey("autofin_orgnum") && JSON.getString("autofin_orgnum") != null
									&& !"".equals(JSON.getString("autofin_orgnum"))) {
								applyLoanStrM12.setM12IdNbankAutofinOrgnum(JSON.getString("autofin_orgnum"));
							}
							if (JSON.containsKey("sloan_orgnum") && JSON.getString("sloan_orgnum") != null
									&& !"".equals(JSON.getString("sloan_orgnum"))) {
								applyLoanStrM12.setM12IdNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
							}
							if (JSON.containsKey("cons_orgnum") && JSON.getString("cons_orgnum") != null
									&& !"".equals(JSON.getString("cons_orgnum"))) {
								applyLoanStrM12.setM12IdNbankConsOrgnum(JSON.getString("cons_orgnum"));
							}
							if (JSON.containsKey("finlea_orgnum") && JSON.getString("finlea_orgnum") != null
									&& !"".equals(JSON.getString("finlea_orgnum"))) {
								applyLoanStrM12.setM12IdNbankFinleaOrgnum(JSON.getString("finlea_orgnum"));
							}
							if (JSON.containsKey("else_orgnum") && JSON.getString("else_orgnum") != null
									&& !"".equals(JSON.getString("else_orgnum"))) {
								applyLoanStrM12.setM12IdNbankElseOrgnum(JSON.getString("else_orgnum"));
							}

							if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
									&& !"".equals(JSON.getString("tot_mons"))) {
								applyLoanStrM12.setM12IdNbankTotMons(JSON.getString("tot_mons"));
							}
							if (JSON.containsKey("avg_monnum") && JSON.getString("avg_monnum") != null
									&& !"".equals(JSON.getString("avg_monnum"))) {
								applyLoanStrM12.setM12IdNbankAvgMonnum(JSON.getString("avg_monnum"));
							}
							if (JSON.containsKey("max_monnum") && JSON.getString("max_monnum") != null
									&& !"".equals(JSON.getString("max_monnum"))) {
								applyLoanStrM12.setM12IdNbankMaxMonnum(JSON.getString("max_monnum"));
							}
							if (JSON.containsKey("min_monnum") && JSON.getString("min_monnum") != null
									&& !"".equals(JSON.getString("min_monnum"))) {
								applyLoanStrM12.setM12IdNbankMinMonnum(JSON.getString("min_monnum"));
							}
							if (JSON.containsKey("max_inteday") && JSON.getString("max_inteday") != null
									&& !"".equals(JSON.getString("max_inteday"))) {
								applyLoanStrM12.setM12IdNbankMaxInteday(JSON.getString("max_inteday"));
							}
							if (JSON.containsKey("min_inteday") && JSON.getString("min_inteday") != null
									&& !"".equals(JSON.getString("min_inteday"))) {
								applyLoanStrM12.setM12IdNbankMinInteday(JSON.getString("min_inteday"));
							}

							if (JSON.containsKey("week_allnum") && JSON.getString("week_allnum") != null
									&& !"".equals(JSON.getString("week_allnum"))) {
								applyLoanStrM12.setM12IdNbankWeekAllnum(JSON.getString("week_allnum"));
							}
							if (JSON.containsKey("week_orgnum") && JSON.getString("week_orgnum") != null
									&& !"".equals(JSON.getString("week_orgnum"))) {
								applyLoanStrM12.setM12IdNbankWeekOrgnum(JSON.getString("week_orgnum"));
							}
							if (JSON.containsKey("night_allnum") && JSON.getString("night_allnum") != null
									&& !"".equals(JSON.getString("night_allnum"))) {
								applyLoanStrM12.setM12IdNbankNightAllnum(JSON.getString("night_allnum"));
							}
							if (JSON.containsKey("night_orgnum") && JSON.getString("night_orgnum") != null
									&& !"".equals(JSON.getString("night_orgnum"))) {
								applyLoanStrM12.setM12IdNbankNightOrgnum(JSON.getString("night_orgnum"));
							}
						}
					}
				}
			}

			if (m12JSON.containsKey("cell") && m12JSON.getString("cell") != null
					&& !"".equals(m12JSON.getString("cell"))) {

				JSONObject cellJSON = JSONObject.fromObject(m12JSON.getString("cell"));
				if (cellJSON != null) {
					if (cellJSON.containsKey("max_inteday") && cellJSON.getString("max_inteday") != null
							&& !"".equals(cellJSON.getString("max_inteday"))) {
						applyLoanStrM12.setM12CellMaxInteday(cellJSON.getString("max_inteday"));
					}
					if (cellJSON.containsKey("min_inteday") && cellJSON.getString("min_inteday") != null
							&& !"".equals(cellJSON.getString("min_inteday"))) {
						applyLoanStrM12.setM12CellMinInteday(cellJSON.getString("min_inteday"));
					}
					if (cellJSON.containsKey("tot_mons") && cellJSON.getString("tot_mons") != null
							&& !"".equals(cellJSON.getString("tot_mons"))) {
						applyLoanStrM12.setM12CellTotMons(cellJSON.getString("tot_mons"));
					}
					if (cellJSON.containsKey("avg_monnum") && cellJSON.getString("avg_monnum") != null
							&& !"".equals(cellJSON.getString("avg_monnum"))) {
						applyLoanStrM12.setM12CellAvgMonnum(cellJSON.getString("avg_monnum"));
					}
					if (cellJSON.containsKey("max_monnum") && cellJSON.getString("max_monnum") != null
							&& !"".equals(cellJSON.getString("max_monnum"))) {
						applyLoanStrM12.setM12CellMaxMonnum(cellJSON.getString("max_monnum"));
					}
					if (cellJSON.containsKey("min_monnum") && cellJSON.getString("min_monnum") != null
							&& !"".equals(cellJSON.getString("min_monnum"))) {
						applyLoanStrM12.setM12CellMinMonnum(cellJSON.getString("min_monnum"));
					}
					if (cellJSON.containsKey("pdl") && cellJSON.getString("pdl") != null
							&& !"".equals(cellJSON.getString("pdl"))) {
						JSONObject pdlJSON = JSONObject.fromObject(cellJSON.getString("pdl"));
						if (pdlJSON != null) {
							if (pdlJSON.containsKey("allnum") && pdlJSON.getString("allnum") != null
									&& !"".equals(pdlJSON.getString("allnum"))) {
								applyLoanStrM12.setM12CellPdlAllnum(pdlJSON.getString("allnum"));
							}
							if (pdlJSON.containsKey("orgnum") && pdlJSON.getString("orgnum") != null
									&& !"".equals(pdlJSON.getString("orgnum"))) {
								applyLoanStrM12.setM12CellPdlOrgnum(pdlJSON.getString("orgnum"));
							}
						}
					}
					if (cellJSON.containsKey("caon") && cellJSON.getString("caon") != null
							&& !"".equals(cellJSON.getString("caon"))) {
						JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caon"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12CellCaonAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12CellCaonOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (cellJSON.containsKey("rel") && cellJSON.getString("rel") != null
							&& !"".equals(cellJSON.getString("rel"))) {
						JSONObject JSON = JSONObject.fromObject(cellJSON.getString("rel"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12CellRelAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12CellRelOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (cellJSON.containsKey("caoff") && cellJSON.getString("caoff") != null
							&& !"".equals(cellJSON.getString("caoff"))) {
						JSONObject JSON = JSONObject.fromObject(cellJSON.getString("caoff"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12CellCaoffAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12CellCaoffOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (cellJSON.containsKey("cooff") && cellJSON.getString("cooff") != null
							&& !"".equals(cellJSON.getString("cooff"))) {
						JSONObject JSON = JSONObject.fromObject(cellJSON.getString("cooff"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12CellCooffAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12CellCooffOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (cellJSON.containsKey("af") && cellJSON.getString("af") != null
							&& !"".equals(cellJSON.getString("af"))) {
						JSONObject JSON = JSONObject.fromObject(cellJSON.getString("af"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12CellAfAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12CellAfOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (cellJSON.containsKey("coon") && cellJSON.getString("coon") != null
							&& !"".equals(cellJSON.getString("coon"))) {
						JSONObject JSON = JSONObject.fromObject(cellJSON.getString("coon"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12CellCoonAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12CellCoonOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (cellJSON.containsKey("oth") && cellJSON.getString("oth") != null
							&& !"".equals(cellJSON.getString("oth"))) {
						JSONObject JSON = JSONObject.fromObject(cellJSON.getString("oth"));
						if (JSON != null) {
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12CellOthAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12CellOthOrgnum(JSON.getString("orgnum"));
							}
						}
					}
					if (cellJSON.containsKey("bank") && cellJSON.getString("bank") != null
							&& !"".equals(cellJSON.getString("bank"))) {
						JSONObject JSON = JSONObject.fromObject(cellJSON.getString("bank"));
						if (JSON != null) {
							if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
									&& !"".equals(JSON.getString("selfnum"))) {
								applyLoanStrM12.setM12CellBankSelfnum(JSON.getString("selfnum"));
							}
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12CellBankAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("tra_allnum") && JSON.getString("tra_allnum") != null
									&& !"".equals(JSON.getString("tra_allnum"))) {
								applyLoanStrM12.setM12CellBankTraAllnum(JSON.getString("tra_allnum"));
							}
							if (JSON.containsKey("ret_allnum") && JSON.getString("ret_allnum") != null
									&& !"".equals(JSON.getString("ret_allnum"))) {
								applyLoanStrM12.setM12CellBankRetAllnum(JSON.getString("ret_allnum"));
							}
							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12CellBankOrgnum(JSON.getString("orgnum"));
							}
							if (JSON.containsKey("tra_orgnum") && JSON.getString("tra_orgnum") != null
									&& !"".equals(JSON.getString("tra_orgnum"))) {
								applyLoanStrM12.setM12CellBankTraOrgnum(JSON.getString("tra_orgnum"));
							}
							if (JSON.containsKey("ret_orgnum") && JSON.getString("ret_orgnum") != null
									&& !"".equals(JSON.getString("ret_orgnum"))) {
								applyLoanStrM12.setM12CellBankRetOrgnum(JSON.getString("ret_orgnum"));
							}

							if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
									&& !"".equals(JSON.getString("tot_mons"))) {
								applyLoanStrM12.setM12CellBankTotMons(JSON.getString("tot_mons"));
							}
							if (JSON.containsKey("avg_monnum") && JSON.getString("avg_monnum") != null
									&& !"".equals(JSON.getString("avg_monnum"))) {
								applyLoanStrM12.setM12CellBankAvgMonnum(JSON.getString("avg_monnum"));
							}
							if (JSON.containsKey("max_monnum") && JSON.getString("max_monnum") != null
									&& !"".equals(JSON.getString("max_monnum"))) {
								applyLoanStrM12.setM12CellBankMaxMonnum(JSON.getString("max_monnum"));
							}
							if (JSON.containsKey("min_monnum") && JSON.getString("min_monnum") != null
									&& !"".equals(JSON.getString("min_monnum"))) {
								applyLoanStrM12.setM12CellBankMinMonnum(JSON.getString("min_monnum"));
							}
							if (JSON.containsKey("max_inteday") && JSON.getString("max_inteday") != null
									&& !"".equals(JSON.getString("max_inteday"))) {
								applyLoanStrM12.setM12CellBankMaxInteday(JSON.getString("max_inteday"));
							}
							if (JSON.containsKey("min_inteday") && JSON.getString("min_inteday") != null
									&& !"".equals(JSON.getString("min_inteday"))) {
								applyLoanStrM12.setM12CellBankMinInteday(JSON.getString("min_inteday"));
							}

							if (JSON.containsKey("week_allnum") && JSON.getString("week_allnum") != null
									&& !"".equals(JSON.getString("week_allnum"))) {
								applyLoanStrM12.setM12CellBankWeekAllnum(JSON.getString("week_allnum"));
							}
							if (JSON.containsKey("week_orgnum") && JSON.getString("week_orgnum") != null
									&& !"".equals(JSON.getString("week_orgnum"))) {
								applyLoanStrM12.setM12CellBankWeekOrgnum(JSON.getString("week_orgnum"));
							}
							if (JSON.containsKey("night_allnum") && JSON.getString("night_allnum") != null
									&& !"".equals(JSON.getString("night_allnum"))) {
								applyLoanStrM12.setM12CellBankNightAllnum(JSON.getString("night_allnum"));
							}
							if (JSON.containsKey("night_orgnum") && JSON.getString("night_orgnum") != null
									&& !"".equals(JSON.getString("night_orgnum"))) {
								applyLoanStrM12.setM12CellBankNightOrgnum(JSON.getString("night_orgnum"));
							}
						}
					}
					if (cellJSON.containsKey("nbank") && cellJSON.getString("nbank") != null
							&& !"".equals(cellJSON.getString("nbank"))) {
						JSONObject JSON = JSONObject.fromObject(cellJSON.getString("nbank"));
						if (JSON != null) {
							if (JSON.containsKey("selfnum") && JSON.getString("selfnum") != null
									&& !"".equals(JSON.getString("selfnum"))) {
								applyLoanStrM12.setM12CellNbankSelfnum(JSON.getString("selfnum"));
							}
							if (JSON.containsKey("allnum") && JSON.getString("allnum") != null
									&& !"".equals(JSON.getString("allnum"))) {
								applyLoanStrM12.setM12CellNbankAllnum(JSON.getString("allnum"));
							}
							if (JSON.containsKey("p2p_allnum") && JSON.getString("p2p_allnum") != null
									&& !"".equals(JSON.getString("p2p_allnum"))) {
								applyLoanStrM12.setM12CellNbankP2pAllnum(JSON.getString("p2p_allnum"));
							}
							if (JSON.containsKey("mc_allnum") && JSON.getString("mc_allnum") != null
									&& !"".equals(JSON.getString("mc_allnum"))) {
								applyLoanStrM12.setM12CellNbankMcAllnum(JSON.getString("mc_allnum"));
							}
							if (JSON.containsKey("ca_allnum") && JSON.getString("ca_allnum") != null
									&& !"".equals(JSON.getString("ca_allnum"))) {
								applyLoanStrM12.setM12CellNbankCaAllnum(JSON.getString("ca_allnum"));
							}
							if (JSON.containsKey("cf_allnum") && JSON.getString("cf_allnum") != null
									&& !"".equals(JSON.getString("cf_allnum"))) {
								applyLoanStrM12.setM12CellNbankCfAllnum(JSON.getString("cf_allnum"));
							}
							if (JSON.containsKey("com_allnum") && JSON.getString("com_allnum") != null
									&& !"".equals(JSON.getString("com_allnum"))) {
								applyLoanStrM12.setM12CellNbankComAllnum(JSON.getString("com_allnum"));
							}
							if (JSON.containsKey("oth_allnum") && JSON.getString("oth_allnum") != null
									&& !"".equals(JSON.getString("oth_allnum"))) {
								applyLoanStrM12.setM12CellNbankOthAllnum(JSON.getString("oth_allnum"));
							}
							if (JSON.containsKey("nsloan_allnum") && JSON.getString("nsloan_allnum") != null
									&& !"".equals(JSON.getString("nsloan_allnum"))) {
								applyLoanStrM12.setM12CellNbankNsloanAllnum(JSON.getString("nsloan_allnum"));
							}
							if (JSON.containsKey("autofin_allnum") && JSON.getString("autofin_allnum") != null
									&& !"".equals(JSON.getString("autofin_allnum"))) {
								applyLoanStrM12.setM12CellNbankAutofinAllnum(JSON.getString("autofin_allnum"));
							}
							if (JSON.containsKey("sloan_allnum") && JSON.getString("sloan_allnum") != null
									&& !"".equals(JSON.getString("sloan_allnum"))) {
								applyLoanStrM12.setM12CellNbankSloanAllnum(JSON.getString("sloan_allnum"));
							}
							if (JSON.containsKey("cons_allnum") && JSON.getString("cons_allnum") != null
									&& !"".equals(JSON.getString("cons_allnum"))) {
								applyLoanStrM12.setM12CellNbankConsAllnum(JSON.getString("cons_allnum"));
							}
							if (JSON.containsKey("finlea_allnum") && JSON.getString("finlea_allnum") != null
									&& !"".equals(JSON.getString("finlea_allnum"))) {
								applyLoanStrM12.setM12CellNbankFinleaAllnum(JSON.getString("finlea_allnum"));
							}
							if (JSON.containsKey("else_allnum") && JSON.getString("else_allnum") != null
									&& !"".equals(JSON.getString("else_allnum"))) {
								applyLoanStrM12.setM12CellNbankElseAllnum(JSON.getString("else_allnum"));
							}

							if (JSON.containsKey("orgnum") && JSON.getString("orgnum") != null
									&& !"".equals(JSON.getString("orgnum"))) {
								applyLoanStrM12.setM12CellNbankOrgnum(JSON.getString("orgnum"));
							}
							if (JSON.containsKey("p2p_orgnum") && JSON.getString("p2p_orgnum") != null
									&& !"".equals(JSON.getString("p2p_orgnum"))) {
								applyLoanStrM12.setM12CellNbankP2pOrgnum(JSON.getString("p2p_orgnum"));
							}
							if (JSON.containsKey("mc_orgnum") && JSON.getString("mc_orgnum") != null
									&& !"".equals(JSON.getString("mc_orgnum"))) {
								applyLoanStrM12.setM12CellNbankMcOrgnum(JSON.getString("mc_orgnum"));
							}
							if (JSON.containsKey("ca_orgnum") && JSON.getString("ca_orgnum") != null
									&& !"".equals(JSON.getString("ca_orgnum"))) {
								applyLoanStrM12.setM12CellNbankCaOrgnum(JSON.getString("ca_orgnum"));
							}
							if (JSON.containsKey("cf_orgnum") && JSON.getString("cf_orgnum") != null
									&& !"".equals(JSON.getString("cf_orgnum"))) {
								applyLoanStrM12.setM12CellNbankCfOrgnum(JSON.getString("cf_orgnum"));
							}
							if (JSON.containsKey("com_orgnum") && JSON.getString("com_orgnum") != null
									&& !"".equals(JSON.getString("com_orgnum"))) {
								applyLoanStrM12.setM12CellNbankComOrgnum(JSON.getString("com_orgnum"));
							}
							if (JSON.containsKey("oth_orgnum") && JSON.getString("oth_orgnum") != null
									&& !"".equals(JSON.getString("oth_orgnum"))) {
								applyLoanStrM12.setM12CellNbankOthOrgnum(JSON.getString("oth_orgnum"));
							}
							if (JSON.containsKey("nsloan_orgnum") && JSON.getString("nsloan_orgnum") != null
									&& !"".equals(JSON.getString("nsloan_orgnum"))) {
								applyLoanStrM12.setM12CellNbankNsloanOrgnum(JSON.getString("nsloan_orgnum"));
							}
							if (JSON.containsKey("autofin_orgnum") && JSON.getString("autofin_orgnum") != null
									&& !"".equals(JSON.getString("autofin_orgnum"))) {
								applyLoanStrM12.setM12CellNbankAutofinOrgnum(JSON.getString("autofin_orgnum"));
							}
							if (JSON.containsKey("sloan_orgnum") && JSON.getString("sloan_orgnum") != null
									&& !"".equals(JSON.getString("sloan_orgnum"))) {
								applyLoanStrM12.setM12CellNbankSloanOrgnum(JSON.getString("sloan_orgnum"));
							}
							if (JSON.containsKey("cons_orgnum") && JSON.getString("cons_orgnum") != null
									&& !"".equals(JSON.getString("cons_orgnum"))) {
								applyLoanStrM12.setM12CellNbankConsOrgnum(JSON.getString("cons_orgnum"));
							}
							if (JSON.containsKey("finlea_orgnum") && JSON.getString("finlea_orgnum") != null
									&& !"".equals(JSON.getString("finlea_orgnum"))) {
								applyLoanStrM12.setM12CellNbankFinleaOrgnum(JSON.getString("finlea_orgnum"));
							}
							if (JSON.containsKey("else_orgnum") && JSON.getString("else_orgnum") != null
									&& !"".equals(JSON.getString("else_orgnum"))) {
								applyLoanStrM12.setM12CellNbankElseOrgnum(JSON.getString("else_orgnum"));
							}

							if (JSON.containsKey("tot_mons") && JSON.getString("tot_mons") != null
									&& !"".equals(JSON.getString("tot_mons"))) {
								applyLoanStrM12.setM12CellNbankTotMons(JSON.getString("tot_mons"));
							}
							if (JSON.containsKey("avg_monnum") && JSON.getString("avg_monnum") != null
									&& !"".equals(JSON.getString("avg_monnum"))) {
								applyLoanStrM12.setM12CellNbankAvgMonnum(JSON.getString("avg_monnum"));
							}
							if (JSON.containsKey("max_monnum") && JSON.getString("max_monnum") != null
									&& !"".equals(JSON.getString("max_monnum"))) {
								applyLoanStrM12.setM12CellNbankMaxMonnum(JSON.getString("max_monnum"));
							}
							if (JSON.containsKey("min_monnum") && JSON.getString("min_monnum") != null
									&& !"".equals(JSON.getString("min_monnum"))) {
								applyLoanStrM12.setM12CellNbankMinMonnum(JSON.getString("min_monnum"));
							}
							if (JSON.containsKey("max_inteday") && JSON.getString("max_inteday") != null
									&& !"".equals(JSON.getString("max_inteday"))) {
								applyLoanStrM12.setM12CellNbankMaxInteday(JSON.getString("max_inteday"));
							}
							if (JSON.containsKey("min_inteday") && JSON.getString("min_inteday") != null
									&& !"".equals(JSON.getString("min_inteday"))) {
								applyLoanStrM12.setM12CellNbankMinInteday(JSON.getString("min_inteday"));
							}

							if (JSON.containsKey("week_allnum") && JSON.getString("week_allnum") != null
									&& !"".equals(JSON.getString("week_allnum"))) {
								applyLoanStrM12.setM12CellNbankWeekAllnum(JSON.getString("week_allnum"));
							}
							if (JSON.containsKey("week_orgnum") && JSON.getString("week_orgnum") != null
									&& !"".equals(JSON.getString("week_orgnum"))) {
								applyLoanStrM12.setM12CellNbankWeekOrgnum(JSON.getString("week_orgnum"));
							}
							if (JSON.containsKey("night_allnum") && JSON.getString("night_allnum") != null
									&& !"".equals(JSON.getString("night_allnum"))) {
								applyLoanStrM12.setM12CellNbankNightAllnum(JSON.getString("night_allnum"));
							}
							if (JSON.containsKey("night_orgnum") && JSON.getString("night_orgnum") != null
									&& !"".equals(JSON.getString("night_orgnum"))) {
								applyLoanStrM12.setM12CellNbankNightOrgnum(JSON.getString("night_orgnum"));
							}
						}
					}
				}
			}
		}
	}
}
