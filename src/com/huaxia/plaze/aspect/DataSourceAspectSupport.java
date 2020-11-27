package com.huaxia.plaze.aspect;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.datasource.interfaces.DataSourceInvoker;
import com.huaxia.plaze.datasource.service.DataSourceService;
import com.huaxia.util.SpringContextUtil;

/**
 * 数据源公共切面支持类
 * 
 * @author zhiguo.li
 * @version 1.0.0
 * @since 2019-09-03
 *
 */
public class DataSourceAspectSupport {

	private final static Logger logger = LoggerFactory.getLogger(DataSourceAspectSupport.class);

	private static DataSourceService dataSourceService;

	static {
		DataSourceAspectSupport.dataSourceService = SpringContextUtil.getBean(DataSourceService.class);
	}

	/**
	 * 数据源公共切面执行方法
	 * 
	 * @param point
	 *            数据源切面
	 * @param sourceCode
	 *            数据源编号
	 * @param invoker
	 *            数据源处理器
	 * @return
	 */
	public static Object execute(ProceedingJoinPoint point, String sourceCode, DataSourceInvoker invoker) {
		Object response = null;

		Object[] args = point.getArgs();
		if (args != null && args.length > 0) {
			Map<String, String> object = parseRequestMessage(args[0].toString());

			// 交易编号
			String trnId = object.get("TRN_ID");

			// 校验请求参数
			Map<String, String> validateResultMap = validate(object);
			if (!Boolean.parseBoolean(validateResultMap.get("result"))) {
				logger.warn("数据源参数校验失败");
				return buildResponseMessage(trnId, validateResultMap.get("code"), validateResultMap.get("message"));
			}

			// 请求渠道校验
			String channelName = object.get("REQUEST_CHANNEL");
			String channelCode = dataSourceService.getChannelCodeByName(channelName);
			if (StringUtils.isBlank(channelCode)) {
				return buildResponseMessage(trnId, "000003", "关键元素项（请求渠道）错误");
			}

			// 校验结果类型
			int type = -1;

			Map<String, Object> dataSourceConfigurateMap = dataSourceService.getConfigurationByParams(sourceCode, channelCode);
			if (dataSourceConfigurateMap == null) {
				// 未设置（查询请求放行）
				type = 1;
			} else {
				// 1、查询时间有效性校验
				String queryStartDateStr = String.valueOf(dataSourceConfigurateMap.get("QUERY_START_DATE"));
				String queryEndDateStr = String.valueOf(dataSourceConfigurateMap.get("QUERY_END_DATE"));
				boolean isAllowQuery = DataSourceAspectSupport.isAllowQuery(queryStartDateStr, queryEndDateStr);
				if (isAllowQuery) {
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("source_code_num", sourceCode);
					params.put("channel_code_num", channelCode);
					params.put("v_set", null);
					params.put("end_num", null);

					// 2、查询数量校验（验证请求是否放行? 如果返回结果大于1则放行, 其它情况禁止.）
					String result = String.valueOf(invoker.validate(params));
					if (StringUtils.isNotBlank(result)) {
						type = Integer.parseInt(result);
					}
				} else {
					return buildResponseMessage(trnId, "999993", "非有效请求查询时间");
				}
			}

			if (type > 0) {
				try {
					response = point.proceed();
				} catch (Throwable e) {
					e.printStackTrace();
					logger.error("流程执行异常[{}]", e.getMessage());
					response = buildResponseMessage(trnId, "000101", "业务流程执行异常");
				}
			} else {
				response = buildResponseMessage(trnId, "999994", "渠道查询数量已达上限");
			}
		}

		return response;
	}

	private static boolean isAllowQuery(String queryStartDateStr, String queryEndDateStr) {
		if (StringUtils.isBlank(queryStartDateStr) || StringUtils.isBlank(queryEndDateStr)) {
			return false;
		}

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date systemTime = Calendar.getInstance().getTime();
		try {
			if ((systemTime.getTime() < formatter.parse(queryStartDateStr).getTime())
					|| (systemTime.getTime() > formatter.parse(queryEndDateStr).getTime())) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	private static Map<String, String> validate(Map<String, String> object) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("result", "true");

		String trnId = object.get("TRN_ID");
		if (StringUtils.isBlank(trnId)) {
			result.put("result", "false");
			result.put("code", "000001");
			result.put("message", "交易编号参数缺失");
		}

		String channel = object.get("REQUEST_CHANNEL");
		if (StringUtils.isBlank(channel)) {
			result.put("result", "false");
			result.put("code", "000001");
			result.put("message", "请求渠道参数缺失");
		}
		return result;
	}

	/** 解析查询请求报文 */
	private static Map<String, String> parseRequestMessage(String message) {
		Map<String, String> args = new HashMap<String, String>();
		JSONObject jsonObject = JSON.parseObject(message);
		if (jsonObject != null) {
			if (jsonObject.containsKey("REQUEST") && jsonObject.getString("REQUEST") != null
					&& !"".equals(jsonObject.getString("REQUEST"))) {
				JSONObject jsonRequet = JSON.parseObject(jsonObject.getString("REQUEST"));
				if (jsonRequet.containsKey("HEAD") && jsonRequet.getString("HEAD") != null
						&& !"".equals(jsonRequet.getString("HEAD"))) {
					JSONObject jsonHead = JSON.parseObject(jsonRequet.getString("HEAD"));

					if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
							&& !"".equals(jsonHead.getString("TRN_ID"))) {
						args.put("TRN_ID", jsonHead.getString("TRN_ID"));
					}

					if (jsonHead.containsKey("REQUEST_CHANNEL") && jsonHead.getString("REQUEST_CHANNEL") != null
							&& !"".equals(jsonHead.getString("REQUEST_CHANNEL"))) {
						args.put("REQUEST_CHANNEL", jsonHead.getString("REQUEST_CHANNEL"));
					}

					JSONObject jsonBody = JSON.parseObject(jsonRequet.getString("BODY"));
					if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
							&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
						args.put("QUERY_MODE", jsonBody.getString("QUERY_MODE"));
					}
				}
			}
		}
		return args;
	}

	private static String buildResponseMessage(String trnId, String code, String message) {
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("RESPONSE_CHANNEL", "PLAZE");
		head.put("TRN_ID", trnId);

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("RESPONSE_CODE", code);
		body.put("RESPONSE_DESC", message);
		body.put("RESPONSE_BODY", "");

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("HEAD", head);
		response.put("BODY", body);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("RESPONSE", response);
		return JSON.toJSONString(new JSONObject(params));
	}

	/** 数据源校验结果 */
	public enum ValidateResult {

		/** 允许 */
		ALLOW("1"),

		/** 忽略 */
		IGNORE("0"),

		/** 拒绝 */
		REFUSE("-1");

		private String type;

		private ValidateResult(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

	}

}
