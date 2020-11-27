package com.huaxia.plaze.modules.hnair.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.util.TaskStatusUtil;
import com.huaxia.plaze.modules.hnair.domain.Hnair;
import net.sf.json.JSONObject;

public class HnairAdapter {
	private final static Logger logger = LoggerFactory.getLogger(HnairAdapter.class);
	private final static AppConfig appConfig = AppConfig.getInstance();

	/**
	 * @Title: parsehnair
	 * @Description: TODO
	 * @param message
	 * @return
	 * @author: LiuWei
	 * @Date: 2019年4月3日下午6:03:03
	 */
	public static Hnair parsehnair(String message) {
		try {
			if (message == null || "".equals(message)) {
				if (logger.isErrorEnabled()) {
					logger.error("[客户端 & 海航] 数据解析异常! {}", "海航报文为空");
				}
				return null;
			}
			JSONObject json = JSONObject.fromObject(message);
			if (json.containsKey("success") && !json.getBoolean("success") && json.containsKey("error_code")
					&& "999999".equals(json.getString("error_code"))) {
				if (logger.isErrorEnabled()) {
					logger.error("[客户端 & 海航] 数据解析异常! {}", " 有异常" + 999999);
				}
				return null;
			}
			Hnair hnair = new Hnair();
			// 响应代码
			if (json.containsKey("errorCode") && json.getString("errorCode") != null
					&& !"".equals(json.getString("errorCode"))) {
				hnair.setErrorcode(json.getString("errorCode"));
			}
			// 响应结果说明
			if (json.containsKey("errorMessage") && json.getString("errorMessage") != null
					&& !"".equals(json.getString("errorMessage"))) {
				hnair.setErrormessage(json.getString("errorMessage"));
			}
			// 服务器端事务或交易编号
			if (json.containsKey("sTId") && json.getString("sTId") != null && !"".equals(json.getString("sTId"))) {
				hnair.setStid(json.getString("sTId"));
			}
			// 客户器端事务或交易编号
			if (json.containsKey("cTId") && json.getString("cTId") != null && !"".equals(json.getString("cTId"))) {
				hnair.setCtid(json.getString("cTId"));
			}
			// 扩展信息
			if (json.containsKey("extendsInfo") && json.getString("extendsInfo") != null
					&& !"".equals(json.getString("extendsInfo"))) {
				hnair.setExtendsinfo(json.getString("extendsInfo"));
			}
			// 是否有过飞行记录
			if (json.containsKey("vipFlg") && json.getString("vipFlg") != null
					&& !"".equals(json.getString("vipFlg"))) {
				hnair.setVipflg(json.getString("vipFlg"));
			}
			// 会员卡号
			if (json.containsKey("cid") && json.getString("cid") != null && !"".equals(json.getString("cid"))) {
				hnair.setCid(json.getString("cid"));
			}
			// 最近一年飞行次数
			if (json.containsKey("flyCnt") && json.getString("flyCnt") != null
					&& !"".equals(json.getString("flyCnt"))) {
				hnair.setFlycnt(Integer.parseInt(json.getString("flyCnt").split("[.]")[0]));// 避免飞行次数为类似
																							// 0.0的数据报错
			}
			// 会员级别
			if (json.containsKey("grade") && json.getString("grade") != null && !"".equals(json.getString("grade"))) {
				hnair.setGrade(json.getString("grade"));
			}
			// 手机号是否与入参一致
			if (json.containsKey("resrv1") && json.getString("resrv1") != null
					&& !"".equals(json.getString("resrv1"))) {
				hnair.setResrv1(json.getString("resrv1"));
			}
			// 是否有兑奖资格
			if (json.containsKey("resrv2") && json.getString("resrv2") != null
					&& !"".equals(json.getString("resrv2"))) {
				hnair.setResrv2(json.getString("resrv2"));
			}
			// 预留字段3
			if (json.containsKey("resrv3") && json.getString("resrv3") != null
					&& !"".equals(json.getString("resrv3"))) {
				hnair.setResrv3(json.getString("resrv3"));
			}
			return hnair;
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("[客户端 & 海航] 数据解析异常   " + " Exception:{}", e);
			}

			return null;
		}
	}

}
