package com.huaxia.plaze.modules.bairong.parse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.plaze.modules.MessageParser;
import com.huaxia.plaze.modules.bairong.domain.BRZX;
import com.huaxia.plaze.modules.bairong.domain.BRZXSpecialListForCell;
import com.huaxia.plaze.modules.bairong.domain.BRZXSpecialListForCid;
import com.huaxia.plaze.modules.bairong.domain.BRZXSpecialListForGid;
import com.huaxia.plaze.modules.bairong.domain.BRZXSpecialListForLmCell;
import com.huaxia.util.GuidUtil;

import net.sf.json.JSONObject;

/**
 * 百融征信报文解析器
 * @author wss
 *
 */
public class BrzxMessageParser implements MessageParser<BRZX> {
	
	private static final Logger logger = LoggerFactory.getLogger(BrzxMessageParser.class); 

	
	/**
	 *@Title:parse
	 *@Description: 百融报文解析器
	 *@param messages 报文组装
	 *@return
	 *@throws Exception
	 *@author: wss
	 *@Date:2019年3月25日上午9:29:44
	 */
	public  BRZX parse(String message) throws Exception {
		
		if (message == null || "".equals(message)) {
			return null;
			//throw new IllegalArgumentException("百融征信报文为空");
		}

		JSONObject json = JSONObject.fromObject(message);
		JSONObject flagObject = null;
		BRZX brzx = new BRZX();
		if (!json.containsKey("Flag") || json.get("Flag") == null || "".equals(json.get("Flag"))) {
			
			if (json.containsKey("success")&&!json.getBoolean("success") &&json.containsKey("error_code")
					&& "999999".equals(json.getString("error_code"))) {
				brzx.setCode("999999");
			}
			
			return brzx;
			//throw new IllegalArgumentException("百融征信报文Flag为空");
		} else {
			flagObject = JSONObject.fromObject(json.get("Flag"));
		}
		
		// 设置基表参数
		String pkUuid = GuidUtil.getGuid();
		brzx.setPkUuid(pkUuid);
		if (json.containsKey("swift_number")
				&& json.getString("swift_number") != null && !"".equals(json.getString("swift_number"))) {
			brzx.setSwiftNumber(json.getString("swift_number"));
		}
		if (json.containsKey("code") && json.getString("code") != null && !"".equals(json.getString("code"))) {
			brzx.setCode(json.getString("code"));
		}
		
		// 特殊名单核查
		if (flagObject.containsKey("specialList_c")) {
			String flag_specialList_c = "";
			if (flagObject.getString("specialList_c") != null && !"".equals(flagObject.getString("specialList_c"))) {
				flag_specialList_c = flagObject.getString("specialList_c");
			}

			if ("0".equals(flag_specialList_c) || "".equals(flag_specialList_c)) {
				// 如果响应报文对应标签匹配值为"0"，则构建空对象。
				brzx.setSpecialListForId(null);
				brzx.setSpecialListForCell(null);
				brzx.setSpecialListForLmCell(null);
				if (logger.isWarnEnabled()) {
					logger.warn("[百融数据解析   & 特殊名单核查] 特殊名单(SpecialList_c)匹配为空!");
				}
			} else {
				JSONObject specialListObject = null;

				if (json.containsKey("SpecialList_c") && json.get("SpecialList_c") != null && !"".equals(json.get("SpecialList_c"))) {
					specialListObject = JSONObject.fromObject(json.get("SpecialList_c"));
				}
				
				if (specialListObject != null) {
					// 通过身份证查询
					JSONObject specialListForIdObject = null;
					if (specialListObject.containsKey("id") && specialListObject.get("id") != null && !"".equals(specialListObject.get("id"))) {
						specialListForIdObject = JSONObject.fromObject(specialListObject.get("id"));
						if (specialListForIdObject != null && !specialListForIdObject.isEmpty()) {
							BRZXSpecialListForCid specialListForId = parseForId(specialListForIdObject);
							specialListForId.setPkUuid(pkUuid);
							brzx.setSpecialListForId(specialListForId);
						}
					}

					// 通过手机号查询
					JSONObject specialListForCellObject = null;
					if (specialListObject.containsKey("cell") && specialListObject.get("cell") != null && !"".equals(specialListObject.get("cell"))) {
						specialListForCellObject = JSONObject.fromObject(specialListObject.get("cell"));
						if (specialListForCellObject != null && !specialListForCellObject.isEmpty()) {
							BRZXSpecialListForCell specialListForCell = parseForCell(specialListForCellObject);
							specialListForCell.setPkUuid(pkUuid);
							brzx.setSpecialListForCell(specialListForCell);
						}
					}

					// 通过联系人手机号查询
					JSONObject specialListForLmCellObject = null;
					if (specialListObject.containsKey("lm_cell") && specialListObject.get("lm_cell") != null && !"".equals(specialListObject.get("lm_cell"))) {
						specialListForLmCellObject = JSONObject.fromObject(specialListObject.get("lm_cell"));
						if (specialListForLmCellObject != null && !specialListForLmCellObject.isEmpty()) {
							BRZXSpecialListForLmCell specialListForLmCell = parseForLmCell(specialListForLmCellObject);
							specialListForLmCell.setPkUuid(pkUuid);
							brzx.setSpecialListForLmCell(specialListForLmCell);
						}
					}

					// 通过GID查询
					if (specialListObject.containsKey("gid") && specialListObject.get("gid") != null && !"".equals(specialListObject.get("gid"))) {
						JSONObject specialListForGidObject = JSONObject.fromObject(specialListObject.get("gid"));
						if (specialListForGidObject != null && !specialListForGidObject.isEmpty()) {
							BRZXSpecialListForGid specialListForGid = parseForGid(specialListForGidObject);
							specialListForGid.setPkUuid(pkUuid);
								brzx.setSpecialListForGid(specialListForGid);
						}
					}
				}
			}
		}

		return brzx;
	}
	
	private BRZXSpecialListForGid parseForGid(JSONObject jsonObject) {
		BRZXSpecialListForGid entity = null;
		if (jsonObject != null && !jsonObject.isEmpty()) {
			entity = new BRZXSpecialListForGid();
			if (jsonObject.containsKey("bank_bad") && jsonObject.getString("bank_bad") != null) {
				entity.setSlGidBankBad(jsonObject.getString("bank_bad"));
			}
	
			if (jsonObject.containsKey("phone_overdue") && jsonObject.getString("phone_overdue") != null) {
				entity.setSlGidPhoneOverdue(jsonObject.getString("phone_overdue"));
			}
	
			if (jsonObject.containsKey("bank_fraud") && jsonObject.getString("bank_fraud") != null) {
				entity.setSlGidBankFraud(jsonObject.getString("bank_fraud"));
			}
	
			if (jsonObject.containsKey("bank_lost") && jsonObject.getString("bank_lost") != null) {
				entity.setSlGidBankLost(jsonObject.getString("bank_lost"));
			}
	
			if (jsonObject.containsKey("bank_refuse") && jsonObject.getString("bank_refuse") != null) {
				entity.setSlGidBankRefuse(jsonObject.getString("bank_refuse"));
			}
	
			if (jsonObject.containsKey("p2p_bad") && jsonObject.getString("p2p_bad") != null) {
				entity.setSlGidP2pBad(jsonObject.getString("p2p_bad"));
			}
	
			if (jsonObject.containsKey("p2p_overdue") && jsonObject.getString("p2p_overdue") != null) {
				entity.setSlGidP2pOverdue(jsonObject.getString("p2p_overdue"));
			}
	
			if (jsonObject.containsKey("p2p_fraud") && jsonObject.getString("p2p_fraud") != null) {
				entity.setSlGidP2pFraud(jsonObject.getString("p2p_fraud"));
			}
	
			if (jsonObject.containsKey("p2p_lost") && jsonObject.getString("p2p_lost") != null) {
				entity.setSlGidP2pLost(jsonObject.getString("p2p_lost"));
			}
	
			if (jsonObject.containsKey("p2p_refuse") && jsonObject.getString("p2p_refuse") != null) {
				entity.setSlGidP2pRefuse(jsonObject.getString("p2p_refuse"));
			}
	
			if (jsonObject.containsKey("nbank_p2p_bad") && jsonObject.getString("nbank_p2p_bad") != null) {
				entity.setSlGidNbankP2pBad(jsonObject.getString("nbank_p2p_bad"));
			}
	
			if (jsonObject.containsKey("nbank_p2p_overdue") && jsonObject.getString("nbank_p2p_overdue") != null) {
				entity.setSlGidNbankP2pOverdue(jsonObject.getString("nbank_p2p_overdue"));
			}
	
			if (jsonObject.containsKey("nbank_p2p_fraud") && jsonObject.getString("nbank_p2p_fraud") != null) {
				entity.setSlGidNbankP2pFraud(jsonObject.getString("nbank_p2p_fraud"));
			}
	
			if (jsonObject.containsKey("nbank_p2p_lost") && jsonObject.getString("nbank_p2p_lost") != null) {
				entity.setSlGidNbankP2pLost(jsonObject.getString("nbank_p2p_lost"));
			}
	
			if (jsonObject.containsKey("nbank_p2p_refuse") && jsonObject.getString("nbank_p2p_refuse") != null) {
				entity.setSlGidNbankP2pRefuse(jsonObject.getString("nbank_p2p_refuse"));
			}
	
			if (jsonObject.containsKey("nbank_mc_bad") && jsonObject.getString("nbank_mc_bad") != null) {
				entity.setSlGidNbankMcBad(jsonObject.getString("nbank_mc_bad"));
			}
	
			if (jsonObject.containsKey("nbank_mc_overdue") && jsonObject.getString("nbank_mc_overdue") != null) {
				entity.setSlGidNbankMcOverdue(jsonObject.getString("nbank_mc_overdue"));
			}
	
			if (jsonObject.containsKey("nbank_mc_fraud") && jsonObject.getString("nbank_mc_fraud") != null) {
				entity.setSlGidNbankMcFraud(jsonObject.getString("nbank_mc_fraud"));
			}
	
			if (jsonObject.containsKey("nbank_mc_lost") && jsonObject.getString("nbank_mc_lost") != null) {
				entity.setSlGidNbankMcLost(jsonObject.getString("nbank_mc_lost"));
			}
	
			if (jsonObject.containsKey("nbank_mc_refuse") && jsonObject.getString("nbank_mc_refuse") != null) {
				entity.setSlGidNbankMcRefuse(jsonObject.getString("nbank_mc_refuse"));
			}
	
			if (jsonObject.containsKey("nbank_ca_bad") && jsonObject.getString("nbank_ca_bad") != null) {
				entity.setSlGidNbankCaBad(jsonObject.getString("nbank_ca_bad"));
			}
	
			if (jsonObject.containsKey("nbank_ca_overdue") && jsonObject.getString("nbank_ca_overdue") != null) {
				entity.setSlGidNbankCaOverdue(jsonObject.getString("nbank_ca_overdue"));
			}
	
			if (jsonObject.containsKey("nbank_ca_fraud") && jsonObject.getString("nbank_ca_fraud") != null) {
				entity.setSlGidNbankCaFraud(jsonObject.getString("nbank_ca_fraud"));
			}
	
			if (jsonObject.containsKey("nbank_ca_lost") && jsonObject.getString("nbank_ca_lost") != null) {
				entity.setSlGidNbankCaLost(jsonObject.getString("nbank_ca_lost"));
			}
	
			if (jsonObject.containsKey("nbank_ca_refuse") && jsonObject.getString("nbank_ca_refuse") != null) {
				entity.setSlGidNbankCaRefuse(jsonObject.getString("nbank_ca_refuse"));
			}
	
			if (jsonObject.containsKey("nbank_com_bad") && jsonObject.getString("nbank_com_bad") != null) {
				entity.setSlGidNbankComBad(jsonObject.getString("nbank_com_bad"));
			}
			
			if (jsonObject.containsKey("nbank_com_overdue") && jsonObject.getString("nbank_com_overdue") != null) {
				entity.setSlGidNbankComOverdue(jsonObject.getString("nbank_com_overdue"));
			}
			
			if (jsonObject.containsKey("nbank_com_fraud") && jsonObject.getString("nbank_com_fraud") != null) {
				entity.setSlGidNbankComFraud(jsonObject.getString("nbank_com_fraud"));
			}
			
			if (jsonObject.containsKey("nbank_com_lost") && jsonObject.getString("nbank_com_lost") != null) {
				entity.setSlGidNbankComLost(jsonObject.getString("nbank_com_lost"));
			}
			
			if (jsonObject.containsKey("nbank_com_refuse") && jsonObject.getString("nbank_com_refuse") != null) {
				entity.setSlGidNbankComRefuse(jsonObject.getString("nbank_com_refuse"));
			}
			
			if (jsonObject.containsKey("nbank_cf_bad") && jsonObject.getString("nbank_cf_bad") != null) {
				entity.setSlGidNbankCfBad(jsonObject.getString("nbank_cf_bad"));
			}
			
			if (jsonObject.containsKey("nbank_cf_overdue") && jsonObject.getString("nbank_cf_overdue") != null) {
				entity.setSlGidNbankCfOverdue(jsonObject.getString("nbank_cf_overdue"));
			}
			
			if (jsonObject.containsKey("nbank_cf_fraud") && jsonObject.getString("nbank_cf_fraud") != null) {
				entity.setSlGidNbankCfFraud(jsonObject.getString("nbank_cf_fraud"));
			}
			
			if (jsonObject.containsKey("nbank_cf_lost") && jsonObject.getString("nbank_cf_lost") != null) {
				entity.setSlGidNbankCfLost(jsonObject.getString("nbank_cf_lost"));
			}
			
			if (jsonObject.containsKey("nbank_cf_refuse") && jsonObject.getString("nbank_cf_refuse") != null) {
				entity.setSlGidNbankCfRefuse(jsonObject.getString("nbank_cf_refuse"));
			}
			
			if (jsonObject.containsKey("nbank_other_bad") && jsonObject.getString("nbank_other_bad") != null) {
				entity.setSlGidNbankOtherBad(jsonObject.getString("nbank_other_bad"));
			}
			
			if (jsonObject.containsKey("nbank_other_overdue") && jsonObject.getString("nbank_other_overdue") != null) {
				entity.setSlGidNbankOtherOverdue(jsonObject.getString("nbank_other_overdue"));
			}
			
			if (jsonObject.containsKey("nbank_other_fraud") && jsonObject.getString("nbank_other_fraud") != null) {
				entity.setSlGidNbankOtherFraud(jsonObject.getString("nbank_other_fraud"));
			}
			
			if (jsonObject.containsKey("nbank_other_lost") && jsonObject.getString("nbank_other_lost") != null) {
				entity.setSlGidNbankOtherLost(jsonObject.getString("nbank_other_lost"));
			}
			
			if (jsonObject.containsKey("nbank_other_refuse") && jsonObject.getString("nbank_other_refuse") != null) {
				entity.setSlGidNbankOtherRefuse(jsonObject.getString("nbank_other_refuse"));
			}
		}
		return entity;
	}
	
	private BRZXSpecialListForLmCell parseForLmCell(JSONObject jsonObject) {
		BRZXSpecialListForLmCell entity = null;
		if (jsonObject != null && !jsonObject.isEmpty()) {
			entity = new BRZXSpecialListForLmCell();
			if (jsonObject.containsKey("abnormal") && jsonObject.getString("abnormal") != null) {
				entity.setSlLmCellAbnormal(jsonObject.getString("abnormal"));
			}
			if (jsonObject.containsKey("phone_overdue") && jsonObject.getString("phone_overdue") != null) {
				entity.setSlLmCellPhoneOverdue(jsonObject.getString("phone_overdue"));
			}
			if (jsonObject.containsKey("bank_bad") && jsonObject.getString("bank_bad") != null) {
				entity.setSlLmCellBankBad(jsonObject.getString("bank_bad"));
			}
			if (jsonObject.containsKey("bank_overdue") && jsonObject.getString("bank_overdue") != null) {
				entity.setSlLmCellBankOverdue(jsonObject.getString("bank_overdue"));
			}
			if (jsonObject.containsKey("bank_fraud") && jsonObject.getString("bank_fraud") != null) {
				entity.setSlLmCellBankFraud(jsonObject.getString("bank_fraud"));
			}
			if (jsonObject.containsKey("bank_lost") && jsonObject.getString("bank_lost") != null) {
				entity.setSlLmCellBankLost(jsonObject.getString("bank_lost"));
			}
			if (jsonObject.containsKey("bank_refuse") && jsonObject.getString("bank_refuse") != null) {
				entity.setSlLmCellBankRefuse(jsonObject.getString("bank_refuse"));
			}
			if (jsonObject.containsKey("nbank_p2p_bad") && jsonObject.getString("nbank_p2p_bad") != null) {
				entity.setSlLmCellNbankP2pBad(jsonObject.getString("nbank_p2p_bad"));
			}
			if (jsonObject.containsKey("nbank_p2p_overdue") && jsonObject.getString("nbank_p2p_overdue") != null) {
				entity.setSlLmCellNbankP2pOverdue(jsonObject.getString("nbank_p2p_overdue"));
			}
			if (jsonObject.containsKey("nbank_p2p_fraud") && jsonObject.getString("nbank_p2p_fraud") != null) {
				entity.setSlLmCellNbankP2pFraud(jsonObject.getString("nbank_p2p_fraud"));
			}
			if (jsonObject.containsKey("nbank_p2p_lost") && jsonObject.getString("nbank_p2p_lost") != null) {
				entity.setSlLmCellNbankP2pLost(jsonObject.getString("nbank_p2p_lost"));
			}
			if (jsonObject.containsKey("nbank_p2p_refuse") && jsonObject.getString("nbank_p2p_refuse") != null) {
				entity.setSlLmCellNbankP2pRefuse(jsonObject.getString("nbank_p2p_refuse"));
			}
			if (jsonObject.containsKey("nbank_mc_bad") && jsonObject.getString("nbank_mc_bad") != null) {
				entity.setSlLmCellNbankMcBad(jsonObject.getString("nbank_mc_bad"));
			}
			if (jsonObject.containsKey("nbank_mc_overdue") && jsonObject.getString("nbank_mc_overdue") != null) {
				entity.setSlLmCellNbankMcOverdue(jsonObject.getString("nbank_mc_overdue"));
			}
			if (jsonObject.containsKey("nbank_mc_fraud") && jsonObject.getString("nbank_mc_fraud") != null) {
				entity.setSlLmCellNbankMcFraud(jsonObject.getString("nbank_mc_fraud"));
			}
			if (jsonObject.containsKey("nbank_mc_lost") && jsonObject.getString("nbank_mc_lost") != null) {
				entity.setSlLmCellNbankMcLost(jsonObject.getString("nbank_mc_lost"));
			}
			if (jsonObject.containsKey("nbank_mc_refuse") && jsonObject.getString("nbank_mc_refuse") != null) {
				entity.setSlLmCellNbankMcRefuse(jsonObject.getString("nbank_mc_refuse"));
			}
			if (jsonObject.containsKey("nbank_ca_bad") && jsonObject.getString("nbank_ca_bad") != null) {
				entity.setSlLmCellNbankCaBad(jsonObject.getString("nbank_ca_bad"));
			}
			if (jsonObject.containsKey("nbank_ca_overdue") && jsonObject.getString("nbank_ca_overdue") != null) {
				entity.setSlLmCellNbankCaOverdue(jsonObject.getString("nbank_ca_overdue"));
			}
			if (jsonObject.containsKey("nbank_ca_fraud") && jsonObject.getString("nbank_ca_fraud") != null) {
				entity.setSlLmCellNbankCaFraud(jsonObject.getString("nbank_ca_fraud"));
			}
			if (jsonObject.containsKey("nbank_ca_lost") && jsonObject.getString("nbank_ca_lost") != null) {
				entity.setSlLmCellNbankCaLost(jsonObject.getString("nbank_ca_lost"));
			}
			if (jsonObject.containsKey("nbank_ca_refuse") && jsonObject.getString("nbank_ca_refuse") != null) {
				entity.setSlLmCellNbankCaRefuse(jsonObject.getString("nbank_ca_refuse"));
			}
			if (jsonObject.containsKey("nbank_com_bad") && jsonObject.getString("nbank_com_bad") != null) {
				entity.setSlLmCellNbankComBad(jsonObject.getString("nbank_com_bad"));
			}
			if (jsonObject.containsKey("nbank_com_overdue") && jsonObject.getString("nbank_com_overdue") != null) {
				entity.setSlLmCellNbankComOverdue(jsonObject.getString("nbank_com_overdue"));
			}
			if (jsonObject.containsKey("nbank_com_fraud") && jsonObject.getString("nbank_com_fraud") != null) {
				entity.setSlLmCellNbankComFraud(jsonObject.getString("nbank_com_fraud"));
			}
			if (jsonObject.containsKey("nbank_com_lost") && jsonObject.getString("nbank_com_lost") != null) {
				entity.setSlLmCellNbankComLost(jsonObject.getString("nbank_com_lost"));
			}
			if (jsonObject.containsKey("nbank_com_refuse") && jsonObject.getString("nbank_com_refuse") != null) {
				entity.setSlLmCellNbankComRefuse(jsonObject.getString("nbank_com_refuse"));
			}
			if (jsonObject.containsKey("nbank_cf_bad") && jsonObject.getString("nbank_cf_bad") != null) {
				entity.setSlLmCellNbankCfBad(jsonObject.getString("nbank_cf_bad"));
			}
			if (jsonObject.containsKey("nbank_cf_overdue") && jsonObject.getString("nbank_cf_overdue") != null) {
				entity.setSlLmCellNbankCfOverdue(jsonObject.getString("nbank_cf_overdue"));
			}
			if (jsonObject.containsKey("nbank_cf_fraud") && jsonObject.getString("nbank_cf_fraud") != null) {
				entity.setSlLmCellNbankCfFraud(jsonObject.getString("nbank_cf_fraud"));
			}
			if (jsonObject.containsKey("nbank_cf_lost") && jsonObject.getString("nbank_cf_lost") != null) {
				entity.setSlLmCellNbankCfLost(jsonObject.getString("nbank_cf_lost"));
			}
			if (jsonObject.containsKey("nbank_cf_refuse") && jsonObject.getString("nbank_cf_refuse") != null) {
				entity.setSlLmCellNbankCfRefuse(jsonObject.getString("nbank_cf_refuse"));
			}
			if (jsonObject.containsKey("nbank_other_bad") && jsonObject.getString("nbank_other_bad") != null) {
				entity.setSlLmCellNbankOtherBad(jsonObject.getString("nbank_other_bad"));
			}
			if (jsonObject.containsKey("nbank_other_overdue") && jsonObject.getString("nbank_other_overdue") != null) {
				entity.setSlLmCellNbankOtherOverdue(jsonObject.getString("nbank_other_overdue"));
			}
			if (jsonObject.containsKey("nbank_other_fraud") && jsonObject.getString("nbank_other_fraud") != null) {
				entity.setSlLmCellNbankOtherFraud(jsonObject.getString("nbank_other_fraud"));
			}
			if (jsonObject.containsKey("nbank_other_lost") && jsonObject.getString("nbank_other_lost") != null) {
				entity.setSlLmCellNbankOtherLost(jsonObject.getString("nbank_other_lost"));
			}
			if (jsonObject.containsKey("nbank_other_refuse") && jsonObject.getString("nbank_other_refuse") != null) {
				entity.setSlLmCellNbankOtherRefuse(jsonObject.getString("nbank_other_refuse"));
			}
		}
		return entity;
	}
	
	private BRZXSpecialListForCell parseForCell(JSONObject jsonObject) {
		BRZXSpecialListForCell entity = null;
		if (jsonObject != null && !jsonObject.isEmpty()) {
			entity = new BRZXSpecialListForCell();
	
			if (jsonObject.containsKey("abnormal") && jsonObject.getString("abnormal") != null) {
				entity.setSlCellAbnormal(jsonObject.getString("abnormal"));
			}
			if (jsonObject.containsKey("phone_overdue") && jsonObject.getString("phone_overdue") != null) {
				entity.setSlCellPhoneOverdue(jsonObject.getString("phone_overdue"));
			}
			if (jsonObject.containsKey("bank_bad") && jsonObject.getString("bank_bad") != null) {
				entity.setSlCellBankBad(jsonObject.getString("bank_bad"));
			}
			if (jsonObject.containsKey("bank_overdue") && jsonObject.getString("bank_overdue") != null) {
				entity.setSlCellBankOverdue(jsonObject.getString("bank_overdue"));
			}
			if (jsonObject.containsKey("bank_fraud") && jsonObject.getString("bank_fraud") != null) {
				entity.setSlCellBankFraud(jsonObject.getString("bank_fraud"));
			}
			if (jsonObject.containsKey("bank_lost") && jsonObject.getString("bank_lost") != null) {
				entity.setSlCellBankLost(jsonObject.getString("bank_lost"));
			}
			if (jsonObject.containsKey("bank_refuse") && jsonObject.getString("bank_refuse") != null) {
				entity.setSlCellBankRefuse(jsonObject.getString("bank_refuse"));
			}
			if (jsonObject.containsKey("p2p_bad") && jsonObject.getString("p2p_bad") != null) {
				entity.setSlCellP2pBad(jsonObject.getString("p2p_bad"));
			}
			if (jsonObject.containsKey("p2p_overdue") && jsonObject.getString("p2p_overdue") != null) {
				entity.setSlCellP2pOverdue(jsonObject.getString("p2p_overdue"));
			}
			if (jsonObject.containsKey("p2p_fraud") && jsonObject.getString("p2p_fraud") != null) {
				entity.setSlCellP2pFraud(jsonObject.getString("p2p_fraud"));
			}
			if (jsonObject.containsKey("p2p_lost") && jsonObject.getString("p2p_lost") != null) {
				entity.setSlCellP2pLost(jsonObject.getString("p2p_lost"));
			}
			if (jsonObject.containsKey("p2p_refuse") && jsonObject.getString("p2p_refuse") != null) {
				entity.setSlCellP2pRefuse(jsonObject.getString("p2p_refuse"));
			}
			if (jsonObject.containsKey("nbank_p2p_bad") && jsonObject.getString("nbank_p2p_bad") != null) {
				entity.setSlCellNbankP2pBad(jsonObject.getString("nbank_p2p_bad"));
			}
			if (jsonObject.containsKey("nbank_p2p_overdue") && jsonObject.getString("nbank_p2p_overdue") != null) {
				entity.setSlCellNbankP2pOverdue(jsonObject.getString("nbank_p2p_overdue"));
			}
			if (jsonObject.containsKey("nbank_p2p_fraud") && jsonObject.getString("nbank_p2p_fraud") != null) {
				entity.setSlCellNbankP2pFraud(jsonObject.getString("nbank_p2p_fraud"));
			}
			if (jsonObject.containsKey("nbank_p2p_lost") && jsonObject.getString("nbank_p2p_lost") != null) {
				entity.setSlCellNbankP2pLost(jsonObject.getString("nbank_p2p_lost"));
			}
			if (jsonObject.containsKey("nbank_p2p_refuse") && jsonObject.getString("nbank_p2p_refuse") != null) {
				entity.setSlCellNbankP2pRefuse(jsonObject.getString("nbank_p2p_refuse"));
			}
			if (jsonObject.containsKey("nbank_mc_bad") && jsonObject.getString("nbank_mc_bad") != null) {
				entity.setSlCellNbankMcBad(jsonObject.getString("nbank_mc_bad"));
			}
			if (jsonObject.containsKey("nbank_mc_overdue") && jsonObject.getString("nbank_mc_overdue") != null) {
				entity.setSlCellNbankMcOverdue(jsonObject.getString("nbank_mc_overdue"));
			}
			if (jsonObject.containsKey("nbank_mc_fraud") && jsonObject.getString("nbank_mc_fraud") != null) {
				entity.setSlCellNbankMcFraud(jsonObject.getString("nbank_mc_fraud"));
			}
			if (jsonObject.containsKey("nbank_mc_lost") && jsonObject.getString("nbank_mc_lost") != null) {
				entity.setSlCellNbankMcLost(jsonObject.getString("nbank_mc_lost"));
			}
			if (jsonObject.containsKey("nbank_mc_refuse") && jsonObject.getString("nbank_mc_refuse") != null) {
				entity.setSlCellNbankMcRefuse(jsonObject.getString("nbank_mc_refuse"));
			}
			if (jsonObject.containsKey("nbank_ca_bad") && jsonObject.getString("nbank_ca_bad") != null) {
				entity.setSlCellNbankCaBad(jsonObject.getString("nbank_ca_bad"));
			}
			if (jsonObject.containsKey("nbank_ca_overdue") && jsonObject.getString("nbank_ca_overdue") != null) {
				entity.setSlCellNbankCaOverdue(jsonObject.getString("nbank_ca_overdue"));
			}
			if (jsonObject.containsKey("nbank_ca_fraud") && jsonObject.getString("nbank_ca_fraud") != null) {
				entity.setSlCellNbankCaFraud(jsonObject.getString("nbank_ca_fraud"));
			}
			if (jsonObject.containsKey("nbank_ca_lost") && jsonObject.getString("nbank_ca_lost") != null) {
				entity.setSlCellNbankCaLost(jsonObject.getString("nbank_ca_lost"));
			}
			if (jsonObject.containsKey("nbank_ca_refuse") && jsonObject.getString("nbank_ca_refuse") != null) {
				entity.setSlCellNbankCaRefuse(jsonObject.getString("nbank_ca_refuse"));
			}
			if (jsonObject.containsKey("nbank_com_bad") && jsonObject.getString("nbank_com_bad") != null) {
				entity.setSlCellNbankComBad(jsonObject.getString("nbank_com_bad"));
			}
			if (jsonObject.containsKey("nbank_com_overdue") && jsonObject.getString("nbank_com_overdue") != null) {
				entity.setSlCellNbankComOverdue(jsonObject.getString("nbank_com_overdue"));
			}
			if (jsonObject.containsKey("nbank_com_fraud") && jsonObject.getString("nbank_com_fraud") != null) {
				entity.setSlCellNbankComFraud(jsonObject.getString("nbank_com_fraud"));
			}
			if (jsonObject.containsKey("nbank_com_lost") && jsonObject.getString("nbank_com_lost") != null) {
				entity.setSlCellNbankComLost(jsonObject.getString("nbank_com_lost"));
			}
			if (jsonObject.containsKey("nbank_com_refuse") && jsonObject.getString("nbank_com_refuse") != null) {
				entity.setSlCellNbankComRefuse(jsonObject.getString("nbank_com_refuse"));
			}
			if (jsonObject.containsKey("nbank_cf_bad") && jsonObject.getString("nbank_cf_bad") != null) {
				entity.setSlCellNbankCfBad(jsonObject.getString("nbank_cf_bad"));
			}
			if (jsonObject.containsKey("nbank_cf_overdue") && jsonObject.getString("nbank_cf_overdue") != null) {
				entity.setSlCellNbankCfOverdue(jsonObject.getString("nbank_cf_overdue"));
			}
			if (jsonObject.containsKey("nbank_cf_fraud") && jsonObject.getString("nbank_cf_fraud") != null) {
				entity.setSlCellNbankCfFraud(jsonObject.getString("nbank_cf_fraud"));
			}
			if (jsonObject.containsKey("nbank_cf_lost") && jsonObject.getString("nbank_cf_lost") != null) {
				entity.setSlCellNbankCfLost(jsonObject.getString("nbank_cf_lost"));
			}
			if (jsonObject.containsKey("nbank_cf_refuse") && jsonObject.getString("nbank_cf_refuse") != null) {
				entity.setSlCellNbankCfRefuse(jsonObject.getString("nbank_cf_refuse"));
			}
			if (jsonObject.containsKey("nbank_other_bad") && jsonObject.getString("nbank_other_bad") != null) {
				entity.setSlCellNbankOtherBad(jsonObject.getString("nbank_other_bad"));
			}
			if (jsonObject.containsKey("nbank_other_overdue") && jsonObject.getString("nbank_other_overdue") != null) {
				entity.setSlCellNbankOtherOverdue(jsonObject.getString("nbank_other_overdue"));
			}
			if (jsonObject.containsKey("nbank_other_fraud") && jsonObject.getString("nbank_other_fraud") != null) {
				entity.setSlCellNbankOtherFraud(jsonObject.getString("nbank_other_fraud"));
			}
			if (jsonObject.containsKey("nbank_other_lost") && jsonObject.getString("nbank_other_lost") != null) {
				entity.setSlCellNbankOtherLost(jsonObject.getString("nbank_other_lost"));
			}
			if (jsonObject.containsKey("nbank_other_refuse") && jsonObject.getString("nbank_other_refuse") != null) {
				entity.setSlCellNbankOtherRefuse(jsonObject.getString("nbank_other_refuse"));
			}
		}
		return entity;
	}
	
	private BRZXSpecialListForCid parseForId(JSONObject jsonObject) {
		BRZXSpecialListForCid entity = null;
		if (jsonObject != null && !jsonObject.isEmpty()) {
			entity = new BRZXSpecialListForCid();
			if (jsonObject.containsKey("abnormal") && jsonObject.getString("abnormal") != null) {
				entity.setSlIdAbnormal(jsonObject.getString("abnormal"));
			}
			if (jsonObject.containsKey("phone_overdue") && jsonObject.getString("phone_overdue") != null) {
				entity.setSlIdPhoneOverdue(jsonObject.getString("phone_overdue"));
			}
			if (jsonObject.containsKey("court_bad") && jsonObject.getString("court_bad") != null) {
				entity.setSlIdCourtBad(jsonObject.getString("court_bad"));
			}
			if (jsonObject.containsKey("court_executed") && jsonObject.getString("court_executed") != null) {
				entity.setSlIdCourtExecuted(jsonObject.getString("court_executed"));
			}
			if (jsonObject.containsKey("bank_bad") && jsonObject.getString("bank_bad") != null) {
				entity.setSlIdBankBad(jsonObject.getString("bank_bad"));
			}
			if (jsonObject.containsKey("bank_overdue") && jsonObject.getString("bank_overdue") != null) {
				entity.setSlIdBankOverdue(jsonObject.getString("bank_overdue"));
			}
			if (jsonObject.containsKey("bank_fraud") && jsonObject.getString("bank_fraud") != null) {
				entity.setSlIdBankFraud(jsonObject.getString("bank_fraud"));
			}
			if (jsonObject.containsKey("bank_lost") && jsonObject.getString("bank_lost") != null) {
				entity.setSlIdBankLost(jsonObject.getString("bank_lost"));
			}
			if (jsonObject.containsKey("bank_refuse") && jsonObject.getString("bank_refuse") != null) {
				entity.setSlIdBankRefuse(jsonObject.getString("bank_refuse"));
			}
			if (jsonObject.containsKey("p2p_bad") && jsonObject.getString("p2p_bad") != null) {
				entity.setSlIdP2pBad(jsonObject.getString("p2p_bad"));
			}
			if (jsonObject.containsKey("p2p_overdue") && jsonObject.getString("p2p_overdue") != null) {
				entity.setSlIdP2pOverdue(jsonObject.getString("p2p_overdue"));
			}
			if (jsonObject.containsKey("p2p_fraud") && jsonObject.getString("p2p_fraud") != null) {
				entity.setSlIdP2pFraud(jsonObject.getString("p2p_fraud"));
			}
			if (jsonObject.containsKey("p2p_lost") && jsonObject.getString("p2p_lost") != null) {
				entity.setSlIdP2pLost(jsonObject.getString("p2p_lost"));
			}
			if (jsonObject.containsKey("p2p_refuse") && jsonObject.getString("p2p_refuse") != null) {
				entity.setSlIdP2pRefuse(jsonObject.getString("p2p_refuse"));
			}
			if (jsonObject.containsKey("nbank_p2p_bad") && jsonObject.getString("nbank_p2p_bad") != null) {
				entity.setSlIdNbankP2pBad(jsonObject.getString("nbank_p2p_bad"));
			}
			if (jsonObject.containsKey("nbank_p2p_overdue") && jsonObject.getString("nbank_p2p_overdue") != null) {
				entity.setSlIdNbankP2pOverdue(jsonObject.getString("nbank_p2p_overdue"));
			}
			if (jsonObject.containsKey("nbank_p2p_fraud") && jsonObject.getString("nbank_p2p_fraud") != null) {
				entity.setSlIdNbankP2pFraud(jsonObject.getString("nbank_p2p_fraud"));
			}
			if (jsonObject.containsKey("nbank_p2p_lost") && jsonObject.getString("nbank_p2p_lost") != null) {
				entity.setSlIdNbankP2pLost(jsonObject.getString("nbank_p2p_lost"));
			}
			if (jsonObject.containsKey("nbank_p2p_refuse") && jsonObject.getString("nbank_p2p_refuse") != null) {
				entity.setSlIdNbankP2pRefuse(jsonObject.getString("nbank_p2p_refuse"));
			}
			if (jsonObject.containsKey("nbank_mc_bad") && jsonObject.getString("nbank_mc_bad") != null) {
				entity.setSlIdNbankMcBad(jsonObject.getString("nbank_mc_bad"));
			}
			if (jsonObject.containsKey("nbank_mc_overdue") && jsonObject.getString("nbank_mc_overdue") != null) {
				entity.setSlIdNbankMcOverdue(jsonObject.getString("nbank_mc_overdue"));
			}
			if (jsonObject.containsKey("nbank_mc_fraud") && jsonObject.getString("nbank_mc_fraud") != null) {
				entity.setSlIdNbankMcFraud(jsonObject.getString("nbank_mc_fraud"));
			}
			if (jsonObject.containsKey("nbank_mc_lost") && jsonObject.getString("nbank_mc_lost") != null) {
				entity.setSlIdNbankMcLost(jsonObject.getString("nbank_mc_lost"));
			}
			if (jsonObject.containsKey("nbank_mc_refuse") && jsonObject.getString("nbank_mc_refuse") != null) {
				entity.setSlIdNbankMcRefuse(jsonObject.getString("nbank_mc_refuse"));
			}
			if (jsonObject.containsKey("nbank_ca_bad") && jsonObject.getString("nbank_ca_bad") != null) {
				entity.setSlIdNbankCaBad(jsonObject.getString("nbank_ca_bad"));
			}
			if (jsonObject.containsKey("nbank_ca_overdue") && jsonObject.getString("nbank_ca_overdue") != null) {
				entity.setSlIdNbankCaOverdue(jsonObject.getString("nbank_ca_overdue"));
			}
			if (jsonObject.containsKey("nbank_ca_fraud") && jsonObject.getString("nbank_ca_fraud") != null) {
				entity.setSlIdNbankCaFraud(jsonObject.getString("nbank_ca_fraud"));
			}
			if (jsonObject.containsKey("nbank_ca_lost") && jsonObject.getString("nbank_ca_lost") != null) {
				entity.setSlIdNbankCaLost(jsonObject.getString("nbank_ca_lost"));
			}
			if (jsonObject.containsKey("nbank_ca_refuse") && jsonObject.getString("nbank_ca_refuse") != null) {
				entity.setSlIdNbankCaRefuse(jsonObject.getString("nbank_ca_refuse"));
			}
			if (jsonObject.containsKey("nbank_com_bad") && jsonObject.getString("nbank_com_bad") != null) {
				entity.setSlIdNbankComBad(jsonObject.getString("nbank_com_bad"));
			}
			if (jsonObject.containsKey("nbank_com_overdue") && jsonObject.getString("nbank_com_overdue") != null) {
				entity.setSlIdNbankComOverdue(jsonObject.getString("nbank_com_overdue"));
			}
			if (jsonObject.containsKey("nbank_com_fraud") && jsonObject.getString("nbank_com_fraud") != null) {
				entity.setSlIdNbankComFraud(jsonObject.getString("nbank_com_fraud"));
			}
			if (jsonObject.containsKey("nbank_com_lost") && jsonObject.getString("nbank_com_lost") != null) {
				entity.setSlIdNbankComLost(jsonObject.getString("nbank_com_lost"));
			}
			if (jsonObject.containsKey("nbank_com_refuse") && jsonObject.getString("nbank_com_refuse") != null) {
				entity.setSlIdNbankComRefuse(jsonObject.getString("nbank_com_refuse"));
			}
			if (jsonObject.containsKey("nbank_cf_bad") && jsonObject.getString("nbank_cf_bad") != null) {
				entity.setSlIdNbankCfBad(jsonObject.getString("nbank_cf_bad"));
			}
			if (jsonObject.containsKey("nbank_cf_overdue") && jsonObject.getString("nbank_cf_overdue") != null) {
				entity.setSlIdNbankCfOverdue(jsonObject.getString("nbank_cf_overdue"));
			}
			if (jsonObject.containsKey("nbank_cf_fraud") && jsonObject.getString("nbank_cf_fraud") != null) {
				entity.setSlIdNbankCfFraud(jsonObject.getString("nbank_cf_fraud"));
			}
			if (jsonObject.containsKey("nbank_cf_lost") && jsonObject.getString("nbank_cf_lost") != null) {
				entity.setSlIdNbankCfLost(jsonObject.getString("nbank_cf_lost"));
			}
			if (jsonObject.containsKey("nbank_cf_refuse") && jsonObject.getString("nbank_cf_refuse") != null) {
				entity.setSlIdNbankCfRefuse(jsonObject.getString("nbank_cf_refuse"));
			}
			if (jsonObject.containsKey("nbank_other_bad") && jsonObject.getString("nbank_other_bad") != null) {
				entity.setSlIdNbankOtherBad(jsonObject.getString("nbank_other_bad"));
			}
			if (jsonObject.containsKey("nbank_other_overdue") && jsonObject.getString("nbank_other_overdue") != null) {
				entity.setSlIdNbankOtherOverdue(jsonObject.getString("nbank_other_overdue"));
			}
			if (jsonObject.containsKey("nbank_other_fraud") && jsonObject.getString("nbank_other_fraud") != null) {
				entity.setSlIdNbankOtherFraud(jsonObject.getString("nbank_other_fraud"));
			}
			if (jsonObject.containsKey("nbank_other_lost") && jsonObject.getString("nbank_other_lost") != null) {
				entity.setSlIdNbankOtherLost(jsonObject.getString("nbank_other_lost"));
			}
			if (jsonObject.containsKey("nbank_other_refuse") && jsonObject.getString("nbank_other_refuse") != null) {
				entity.setSlIdNbankOtherRefuse(jsonObject.getString("nbank_other_refuse"));
			}
		}
		return entity;
	}
	
}
