package com.huaxia.plaze.modules.tencent.parse;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.opas.util.UUIDGen;
import com.huaxia.plaze.modules.MessageParser;
import com.huaxia.plaze.modules.tencent.domain.TYAntifraud;
import com.huaxia.plaze.modules.tencent.domain.TYAntifraudData;
import com.huaxia.plaze.modules.tencent.domain.TYAntifraudRiskInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 天御分报文解析器
 * @author User
 *
 */
public class TianYuMessageParser implements MessageParser<TYAntifraud> {

	public static final Logger logger = LoggerFactory.getLogger(TianYuMessageParser.class);
	/**
	 *@Title:parse
	 *@Description: 天御报文解析器
	 *@param message 报文组装
	 *@return
	 *@throws Exception
	 *@author: wss
	 *@Date:2019年3月28日11:10:01
	 */
	public TYAntifraud parse(String message) throws Exception {
		
		if (message == null || "".equals(message)) {
			if (logger.isErrorEnabled()) {
				logger.error("[客户端 & 腾讯天御分] 数据解析异常! {}","腾讯天御分报文为空");
			}
			return null;
		}
		JSONObject jsonObject = JSONObject.fromObject(message);
		if (jsonObject.containsKey("success")&&!jsonObject.getBoolean("success") &&jsonObject.containsKey("error_code")
				&& "999999".equals(jsonObject.getString("error_code"))) {
			//对方服务响应异常
			throw new Exception("对方服务响应异常");
		} 
		TYAntifraud tyAntifraud = new TYAntifraud();
		TYAntifraudData tyAntifraudData=new TYAntifraudData();
		tyAntifraudData.setPkUuid(UUIDGen.getUUID());
		//响应代码 0成功 非0是具体错误代码
		if (jsonObject.containsKey("code") && jsonObject.getString("code") != null && !"".equals(jsonObject.getString("code"))) {
			tyAntifraudData.setCode(jsonObject.getString("code"));
		}else{
			//响应码异常
			throw new Exception("响应码异常");
		}
		//响应结果说明
		if (jsonObject.containsKey("codeDesc") && jsonObject.getString("codeDesc") != null && !"".equals(jsonObject.getString("codeDesc"))) {
			tyAntifraudData.setCodeDesc(jsonObject.getString("codeDesc"));
		}
		//表示该条记录能否查到,1为能查到，-1为查不到
		if (jsonObject.containsKey("found") && jsonObject.getString("found") != null && !"".equals(jsonObject.getString("found"))) {
			tyAntifraudData.setFound(Integer.parseInt(jsonObject.getString("found")));
		}
		//表示该条记录中的身份证能否查到,1为能查到，-1为查不到
		if (jsonObject.containsKey("idFound") && jsonObject.getString("idFound") != null && !"".equals(jsonObject.getString("idFound"))) {
			tyAntifraudData.setIdFound(Integer.parseInt(jsonObject.getString("idFound")));
		}
		//查询信息描述
		if (jsonObject.containsKey("message") && jsonObject.getString("message") != null && !"".equals(jsonObject.getString("message"))) {
			tyAntifraudData.setMessage(jsonObject.getString("message"));
		}
		//0~100：欺诈分值。值越高欺诈可能性越大
		if (jsonObject.containsKey("riskScore") && jsonObject.getString("riskScore") != null && !"".equals(jsonObject.getString("riskScore"))) {
			tyAntifraudData.setRiskScore(Integer.parseInt(jsonObject.getString("riskScore")));
		}
		tyAntifraud.setTyAntifraudData(tyAntifraudData);
		//主表 关联风险码信息
		if (jsonObject.containsKey("riskInfo") && jsonObject.getString("riskInfo") != null && !"".equals(jsonObject.getString("riskInfo"))) {
			JSONArray riskInfoArray = JSONArray.fromObject(jsonObject.get("riskInfo"));
			List<TYAntifraudRiskInfo> tyRiskInfoList=new ArrayList<TYAntifraudRiskInfo>();
			for (int i = 0; i < riskInfoArray.size(); i++) {
				TYAntifraudRiskInfo tyRiskInfo=new TYAntifraudRiskInfo();
				JSONObject riskObject = (JSONObject) riskInfoArray.get(i);
				int addControl=0;
				if (riskObject.containsKey("riskCode") && riskObject.getString("riskCode") != null && !"".equals(riskObject.getString("riskCode"))) {
					tyRiskInfo.setRiskCode(riskObject.getString("riskCode"));
					addControl++;
				}
				if (riskObject.containsKey("riskCodeValue") && riskObject.getString("riskCodeValue") != null && !"".equals(riskObject.getString("riskCodeValue"))) {
					tyRiskInfo.setRiskCodeValue(riskObject.getString("riskCodeValue"));
					addControl++;
				}
				if(addControl>0){
					tyRiskInfo.setFkUuid(tyAntifraudData.getPkUuid());
					tyRiskInfoList.add(tyRiskInfo);
				}
			}
			if(tyRiskInfoList!=null&&tyRiskInfoList.size()>0){
				tyAntifraud.setListTYAntifraudRiskInfo(tyRiskInfoList);
			}
			
		}
		return tyAntifraud;
	}
	
}
