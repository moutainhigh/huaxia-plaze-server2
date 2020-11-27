package com.huaxia.plaze.modules.pboc.caller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.apache.commons.httpclient.HttpClient;
import org.codehaus.xfire.client.Client;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.pboc.service.BankService;
import com.huaxia.plaze.modules.pboc.service.BankTaskCallPlazeService;
import com.huaxia.plaze.util.CommonUtil;
import com.huaxia.plaze.util.TaskParamUtil;
import com.huaxia.plaze.util.TaskStatusUtil;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import cn.com.infosec.netsign.agent.PBCAgent2G;

/**
 * 人行二期任务请求
 * 
 * @author gaoh
 *
 */
public class BankTaskCaller implements Runnable {
	
	private final static Logger logger = LoggerFactory.getLogger(BankTaskCaller.class);
	
	private BankTaskCallPlazeService bankTaskCallPlazeService;

	private BankService bankService;
	
	public BankTaskCaller(ThreadLocal<Map<String, Object>> wrapper) {
		Map<String, Object> services = wrapper.get();
		this.bankService = (BankService) services.get("bankService");
		this.bankTaskCallPlazeService = (BankTaskCallPlazeService) services.get("bankTaskCallPlazeService");
	}

	@Override
	public void run() {
		while (true) {
			// 创建http客户端
			HttpClient httpClient = new HttpClient();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("taskIp", TaskParamUtil.TASK_IP);
			paramMap.put("taskStatus", TaskStatusUtil.INITIAL);
			paramMap.put("querySize", TaskParamUtil.BANK_QUERY_SIZE);
			int startHour = Integer.parseInt(TaskParamUtil.BANK_NOTSEARCH_TIME_START.substring(0, 2));
			int startMinute = Integer.parseInt(TaskParamUtil.BANK_NOTSEARCH_TIME_START.substring(2, 4));
			int startSecond = Integer.parseInt(TaskParamUtil.BANK_NOTSEARCH_TIME_START.substring(4, 6));
			int startTimeSecondSum = (startHour * 3600) + (startMinute * 60) + startSecond;
			int endHour = Integer.parseInt(TaskParamUtil.BANK_NOTSEARCH_TIME_END.substring(0, 2));
			int endMinute = Integer.parseInt(TaskParamUtil.BANK_NOTSEARCH_TIME_END.substring(2, 4));
			int endSecond = Integer.parseInt(TaskParamUtil.BANK_NOTSEARCH_TIME_END.substring(4, 6));
			int endTimeSecondSum = (endHour * 3600) + (endMinute * 60) + endSecond;

			try {
				while (true) {
					try {
						Thread.sleep(TaskParamUtil.BANK_THREAD_SLEEPTIME_MM);
					} catch (InterruptedException e) {

					}
					Calendar calendar = Calendar.getInstance();
					int currHour = calendar.get(Calendar.HOUR_OF_DAY);
					int currMinute = calendar.get(Calendar.MINUTE);
					int currSecond = calendar.get(Calendar.SECOND);
					int currTimeSecondSum = (currHour * 3600) + (currMinute * 60) + currSecond;

					// 当前时间大于BANK_NOTSEARCH_TIME_START
					if (currTimeSecondSum >= startTimeSecondSum) {
						if (logger.isInfoEnabled()) {
							logger.info("PBOC start时间比较,message:{}",
									"当前时间大于" + TaskParamUtil.BANK_NOTSEARCH_TIME_START);
						}
						continue;
					}
					// 当前时间小于BANK_NOTSEARCH_TIME_END
					if (currTimeSecondSum <= endTimeSecondSum) {
						if (logger.isInfoEnabled()) {
							logger.info("PBOC end时间比较,message:{}", "当前时间小于" + TaskParamUtil.BANK_NOTSEARCH_TIME_END);
						}
						continue;
					}

					List<Map<String, String>> taskStatusList = bankTaskCallPlazeService
							.findBankTaskCallPlazeList(paramMap);

					if (taskStatusList != null && taskStatusList.size() > 0) {
						int size = taskStatusList.size();
						if (logger.isDebugEnabled()) {
							logger.debug("[客户端 & 人行] 查询人行任务条数：{}", size);
						}
						for (Map<String, String> task : taskStatusList) {
							String uniqueRelid = task.get("uniqueRelid");// 唯一关联标识
							boolean paramErrorFlag = false;
							String idNo = task.get("identityNo");// 当前请求被查询人证件号
							if (idNo == null || "".equals(idNo) || idNo.length() != 18) {
								paramErrorFlag = true;
							}
							String identityType = task.get("identityType");// 当前请求被查询人证件号类型
							if (identityType == null || "".equals(identityType)) {
								paramErrorFlag = true;
							}
							String name = task.get("name");// 当前请求被查询人姓名
							if (name == null || "".equals(name)) {
								paramErrorFlag = true;
							}
							String queryReason = task.get("queryReason");//查询原因
							if(queryReason == null || "".equals(queryReason)){
								paramErrorFlag = true;
							}
							// 插入历史表
							bankTaskCallPlazeService.saveBankTaskPlazeHis(uniqueRelid);
							if (paramErrorFlag) {// 参数错误
								bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid, TaskStatusUtil.PARAM_ERROE,
										TaskStatusUtil.INITIAL, TaskParamUtil.CURR_USER, null, null);
								bankTaskCallPlazeService.updatePbocTrnSingleReview(uniqueRelid, "4");
								continue;
							}
							String queryFlag = task.get("queryFlag");// 查询标识
							// 人行查询30天逻辑
							boolean is30Days = true;
							Map<String, String> params = new HashMap<String, String>();
							params.put("identityCardNo", idNo);
							params.put("identityType", identityType);
							params.put("name", name);
							params.put("dayControl", TaskParamUtil.BANK_SEARCH_DAYS_CONTROL);
							if ("2".equals(queryFlag)) {
								// 30内 最近返回的人行
								String lateIdentityCardNo = bankService.queryLateIdNoUniqueRelid(params);
								if (lateIdentityCardNo != null && !"".equals(lateIdentityCardNo)) {
									// 存在的话 修改任务表状态为2
									is30Days = false;
									bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid, TaskStatusUtil.SUCCESS,
											TaskStatusUtil.INITIAL, TaskParamUtil.USER_COPY, null, null);
									bankTaskCallPlazeService.updatePbocTrnSingleReview(uniqueRelid, "3");
								}
							}
							if (is30Days) { // 人行正常查询逻辑 非人行30天内复制逻辑
								// 请求开始
								bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid, TaskStatusUtil.START,
										TaskStatusUtil.INITIAL, TaskParamUtil.CURR_USER, "1", null);
								bankTaskCallPlazeService.updatePbocTrnSingleReview(uniqueRelid, "2");
								
								/** 获取发起二代人行需要的用户名和密码 */
								String user = "";
								String pwd  = "";
								Map<String , String> userAndPwd = bankTaskCallPlazeService.findUserAndPwd();
								if(userAndPwd == null || userAndPwd.isEmpty()){
									bankTaskCallPlazeService.saveBankTaskPlazeHis(uniqueRelid);
									bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid,
											TaskStatusUtil.USERANDPWD_ERROR, TaskStatusUtil.START,
											TaskParamUtil.CURR_USER, null, null);
									bankTaskCallPlazeService.updatePbocTrnSingleReview(uniqueRelid, "4");
									continue;
								}else{
									user = userAndPwd.get("QUERY_USER");
									pwd  = userAndPwd.get("QUERY_PASS");
								}
								
								/**====================请求方式改成webservice======开始=============*/
								Client client = new Client(new URL(AppConfig.getInstance().getValue("bank.webservice.url")));
								String request = rh2(name, identityType, idNo, queryReason, user, pwd);
								
								String signedTextB64 = "";
								try {
									PBCAgent2G pbc = new PBCAgent2G(false);
									pbc.openSignServer(AppConfig.getInstance().getValue("sign.ip"), AppConfig.getInstance().getValue("sign.port"), AppConfig.getInstance().getValue("sign.password"));
									
									signedTextB64 = pbc.dettachedSign(request.getBytes(), AppConfig.getInstance().getValue("sign.certdn"));
									pbc.closeSignServer();
								} catch (Exception e) {
									e.printStackTrace();
									logger.error("获取数字签名失败", e);
									bankTaskCallPlazeService.saveBankTaskPlazeHis(uniqueRelid);
									bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid,
											TaskStatusUtil.GET_SIGN_ERROR, TaskStatusUtil.START,
											TaskParamUtil.CURR_USER, null, null);
									bankTaskCallPlazeService.updatePbocTrnSingleReview(uniqueRelid, "4");
									continue;
								}
								
								/** 追加数字签名 */
								String report = request + "{S:"+signedTextB64+":S}";
								Object[] result = null;
								try {
									result = client.invoke("psCreditReportQueryReq", new Object[] { report });
								} catch (Exception e) {
									e.printStackTrace();
									logger.error("请求人行webservice接口异常", e);
									bankTaskCallPlazeService.saveBankTaskPlazeHis(uniqueRelid);
									bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid,
											TaskStatusUtil.SERVE_RESPOSE_ERROE, TaskStatusUtil.START,
											TaskParamUtil.CURR_USER, null, null);
									bankTaskCallPlazeService.updatePbocTrnSingleReview(uniqueRelid, "4");
									continue;
								}
								/**====================请求方式改成webservice======结束=============*/
								
								if(result != null){
									String detail = dealResult(String.valueOf(result[0]),idNo,identityType,name);
									if("AAA001".equals(detail)){
										logger.info(uniqueRelid+"返回码是AAA001");
										bankTaskCallPlazeService.saveBankTaskPlazeHis(uniqueRelid);
										bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid, TaskStatusUtil.SUCCESS, TaskStatusUtil.START,
												TaskParamUtil.CURR_USER, null, null);
										continue;
									}
									if("failure".equals(detail)){
										bankTaskCallPlazeService.saveBankTaskPlazeHis(uniqueRelid);
										bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid, TaskStatusUtil.PARSE_ERROE, TaskStatusUtil.START,
												TaskParamUtil.CURR_USER, null, null);
										continue;
									}
									if("code_error".equals(detail)){
										logger.info("uniqueRelid返回码异常:"+uniqueRelid);
										bankTaskCallPlazeService.saveBankTaskPlazeHis(uniqueRelid);
										bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid, TaskStatusUtil.RESPOSE_CODE_ERROR, TaskStatusUtil.START,
												TaskParamUtil.CURR_USER, null, null);
									}
								}
								
							}

							try {
								Thread.sleep(TaskParamUtil.BANK_SINGLE_SLEEPTIME_MM);
							} catch (InterruptedException e) {

							}
						} // list循环结束
					} else {
						if (logger.isDebugEnabled()) {
							logger.debug("[客户端 & 人行] 未查询到人行任务条数!");
						}
					}
				}
			} catch (Exception e) {
				if (logger.isErrorEnabled()) {
					logger.error("bankTaskCallerError线程异常中断! Exception:{}", e);
				}
			} finally {
				// 8秒后线程重启
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {

				}
			}

			if (logger.isInfoEnabled()) {
				logger.info("[客户端 & 人行] 线程已经异常中断重启!");
			}
		}

	}
	
	
/** =============================二代人行请求报文拼接======start==========APS提供======================= */	
	
	public static String rh2(String name, String idType, String idNo, String queryReason,String userCode,String pwd) { 
		String sendMsg=""; 
		String fristHead=AppConfig.getInstance().getValue("query.version")+AppConfig.getInstance().getValue("query.org.code")+AppConfig.getInstance().getValue("receive.org.code")+getMqSendTime()+AppConfig.getInstance().getValue("request.type")+getMqSendTimeAndSjNum()+"000000000000";
		String head=getSedHeadStr(userCode, pwd);//userCode 账号 pwd 密码
		String msg=getSedSingleQueryStr(userCode, name, idType, idNo, queryReason);//name 姓名 idType 证件类别 idNo证件号码  queryReason 03
		sendMsg=fristHead+"<?xml version=\"1.0\" encoding=\"UTF-8\"?><Document>"+head+msg+"</Document>";
		return sendMsg;
	}
	public static String getSedHeadStr(String userCode,String pwd){
	 	String xmlStr ="<Head>"+
	 	"<QueryOrgCode>" + AppConfig.getInstance().getValue("query.org.code") + "</QueryOrgCode>"+
	 	"<UserCode>" + userCode + "</UserCode>"+
	 	"<Password>" + pwd + "</Password>"+
      "</Head>";
	 	return xmlStr;
	 }
	public static String getSedSingleQueryStr(String userCode,String name,
			String idType,String idNo,String queryReason){

		String xmlStr="<Msg>"+
		"<OriginateOrgCode>" + AppConfig.getInstance().getValue("query.org.code") + "</OriginateOrgCode>"+
		"<OriginateUserCode>" + userCode + "</OriginateUserCode>"+
		"<Name>"+name+"</Name>"+
		"<IDType>"+idType+"</IDType>"+
		"<IDNum>"+idNo+"</IDNum>"+
		"<QueryReason>"+queryReason+"</QueryReason>"+
		"<ServiceCode>"+AppConfig.getInstance().getValue("service.code")+"</ServiceCode>"+//服务代码
		"</Msg>";
		return xmlStr;
	}
	private static String getMqSendTime(){
		String time="";	 		
	 	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
	 	time= formatter.format(new Date());	
	 	return time;
	}
	private static String getMqSendTimeAndSjNum(){
		String time="";
		int num=12345678;	 		
	 	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	 	time= formatter.format(new Date());
	 	num = (int)((Math.random()*9+1)*10000000);
	 	return time+num;
	}
	
/** =============================二代人行请求报文拼接======end======================================== */
	
/** =============================解压流操作======start======================================== */
	
	public static byte[] unZipString(String compressStr) throws Exception{
		
		if(compressStr == null){
			return null;
		}
		
		ByteArrayOutputStream out = null;
		ByteArrayInputStream in = null;
		GZIPInputStream gin = null;
		
		byte[] compressed = Base64.decode(compressStr);
		out = new ByteArrayOutputStream();
		in = new ByteArrayInputStream(compressed);
		gin = new GZIPInputStream(in);
		
		byte[] buf = new byte[1024];
		int num = -1;
		
		while((num = gin.read(buf, 0, buf.length)) != -1){
			out.write(buf,0,num);
		}
		
		gin.close();
		in.close();
		byte[] byteArray = out.toByteArray();
		
		out.flush();
		out.close();
		
		return byteArray;
		
	}
	
/** =============================解压流操作======end======================================== */
	
	public String dealResult(String report,String identityNo,String identityType,String name) {
		
		String message = report.split("\r\n")[1];
		// --ceshi start
//		Calendar calendar = Calendar.getInstance();
//		int currHour = calendar.get(Calendar.HOUR_OF_DAY);
//		int currMinute = calendar.get(Calendar.MINUTE);
//		int currSecond = calendar.get(Calendar.SECOND);
//		int currTimeSecondSum = (currHour * 3600) + (currMinute * 60) + currSecond;
//		CommonUtil.downLoadMessageContent(message, TaskParamUtil.BANK_XML_PATH, currTimeSecondSum + "", null, ".xml",
//				"人行信息");
		// -- ceshi end
		Document document = null;
		Node msgNode = null;
		Node resultCodeNode = null;
		try {
			document = DocumentHelper.parseText(message);
			msgNode = document.selectSingleNode("/Document/Msg");
			// 查询结果代码
			resultCodeNode = msgNode.selectSingleNode("ResultCode");
		} catch (Exception e) {
			logger.error("人行报文格式异常", e);
			return "failure";
		}
		if (resultCodeNode != null) {
			String resultCode = resultCodeNode.getText();
			if (!"AAA000".equals(resultCode) && !"AAA001".equals(resultCode)) { // 处理失败
				if (logger.isInfoEnabled()) {
					logger.info("bankresultCodeError:{}", resultCode);
				}
				return "code_error";
			}
			if("AAA001".equals(resultCode)){
				return "AAA001";
			}
		} else {
			return "failure";
		}
		// 信用报告内容 ReportMessage
		Node reportMessageNode = msgNode.selectSingleNode("ReportMessage");
		String reportMessage = "";
		if (reportMessageNode != null) {
			reportMessage = reportMessageNode.getText();
		} else {
			return "failure";
		}
		if ("".equals(reportMessage)) {
			return "failure";
		}
		String body = "";
		byte[] mess;
		try {
			mess = unZipString(reportMessage);
			body = new String(mess, "UTF-8");
		} catch (Exception e2) {
			if (logger.isInfoEnabled()) {
				logger.info("bankBase64BodyException:{}", e2);
			}
		}
		if (body == null || "".equals(body)) {
			return "failure";
		}
		Document documentBody = null;
		try {
			documentBody = DocumentHelper.parseText(body);
		} catch (DocumentException e) {
			if (logger.isInfoEnabled()) {
				logger.info("bankDocumentBodyException:{}", e);
			}
		}
//		Map<String, String> reqParam = getParamBank(documentBody);
		String uniqueRelid = "";// 每个身份证号码关联的唯一uuid值
//		String identityNo = reqParam.get("idNo");// 身份证号
//		String identityType = reqParam.get("idType");// 身份证类型
//		String name = reqParam.get("name");// 姓名
		if("310225197610210033".equals(identityNo)){
			logger.info("测试报文++"+body);
		}
		String source = "";
		String queryFlag = "0";
		String sourceId = "";
		List<Map<String, String>> taskMapList = bankTaskCallPlazeService.findBankParamList(identityNo, identityType,
				name, TaskStatusUtil.START);
		if (taskMapList != null && taskMapList.size() > 0) {
			for (Map<String, String> taskMap : taskMapList) {
				uniqueRelid = taskMap.get("UNIQUE_RELID");
				source = taskMap.get("SOURCE");
				queryFlag = taskMap.get("QUERY_FLAG");
				sourceId = taskMap.get("SOURCE_ID");
				boolean errorFlag = false;// 异常标志
				String oriUniqueRelid = bankService.findBankBodyOriginalUniqueRelid(uniqueRelid);// 报文表关联id是否存在
				if (oriUniqueRelid != null) { // 存在的话 不做入库操作
					if (logger.isInfoEnabled()) {
						logger.info(" oriUniqueRelidExist!! continue current circulation!! :{}", oriUniqueRelid);
					}
					continue;
				}
				try {
					bankService.saveBankControlLogic(uniqueRelid, sourceId, identityType, identityNo, name, queryFlag,
							source, body);
				} catch (Exception e) {
					if (logger.isInfoEnabled()) {
						logger.info("bankMessageError:" + identityNo + " uniqueRelid=" + uniqueRelid + " Exception:{}",
								e);
					}
					errorFlag = true;
				}
				String taskStatus = TaskStatusUtil.SUCCESS;
				if (errorFlag) { // 异常
					taskStatus = TaskStatusUtil.SAVE_ERROE;
				}
				try {
					bankTaskCallPlazeService.saveBankTaskPlazeHis(uniqueRelid);
					bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid, taskStatus, TaskStatusUtil.START,
							TaskParamUtil.CURR_USER, null, null);
				} catch (Exception e) {
					if (logger.isInfoEnabled()) {
						logger.info("bankMessageUpdateError:" + identityNo + " uniqueRelid=" + uniqueRelid
								+ " Exception:{}", e);
					}
				}
			} // 循环结束
		}

		return "success";
	}

	/**
	 * @Title:getParamBank
	 * @Description:获取人行请求参数
	 * @param documentBody
	 * @return
	 * @author: gaohui
	 * @Date:2018年12月18日下午3:00:28
	 */
	private Map<String, String> getParamBank(Document documentBody) {
		Map<String, String> reqParam = new HashMap<String, String>();
		//// 1.1.1.2本次查询请求信息段 PA01B [1..1]
		Node pa01bNode = documentBody.selectSingleNode("/Document/PRH/PA01/PA01B");
		if (pa01bNode != null) {
			// 1.1.1.2.1 被查询者姓名 PA01BQ01 [1..1]
			Node PA01BQ01 = pa01bNode.selectSingleNode("PA01BQ01");
			if (PA01BQ01 != null) {
				reqParam.put("name", PA01BQ01.getText());
			}
			// 1.1.1.2.2 被查询者证件类型 PA01BD01 [1..1]
			Node PA01BD01 = pa01bNode.selectSingleNode("PA01BD01");
			if (PA01BD01 != null) {
				reqParam.put("idType", PA01BD01.getText());
			}
			// 1.1.1.2.3被查询者证件号码 PA01BI01 [1..1]
			Node PA01BI01 = pa01bNode.selectSingleNode("PA01BI01");
			if (PA01BI01 != null) {
				reqParam.put("idNo", PA01BI01.getText());
			}
			return reqParam;
		} else {
			return null;
		}
	}

}
