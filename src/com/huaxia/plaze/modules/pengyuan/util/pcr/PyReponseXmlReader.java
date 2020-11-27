package com.huaxia.plaze.modules.pengyuan.util.pcr;

import java.io.FileInputStream;
import java.util.List;
import java.util.Vector;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * 区域数据-深圳-鹏元个人信用xml报文解析工具类
 * 
 * @author User
 *
 */
public class PyReponseXmlReader {

	private final static Logger logger = LoggerFactory.getLogger(PyReponseXmlReader.class);

	private static Document doc;

	// 鹏元个人信用报告表
	private static PyPcrCrs pyPcrCrs;
	// 鹏元个人信用报告报告表
	private static PyPcrCrsCrt pyPcrCrsCrt;
	// 鹏元个人信用报告查询条件表
	private static List<PyPcrCrsCrtQcs> pyPcrCrsCrtQcsList;
	// 鹏元个人信用报告个人基本信息表
	private static PyPcrCrsCrtPbi pyPcrCrsCrtPbi;
	// 鹏元个人信用报告摘要信息表
	private static PyPcrCrsCrtPbiSi pyPcrCrsCrtPbiSi;
	// 鹏元个人信用报告最新基本信息表
	private static PyPcrCrsCrtPbiLbi pyPcrCrsCrtPbiLbi;
	// 鹏元个人信用报告证件信息表
	private static List<PyPcrCrsCrtPbiDis> pyPcrCrsCrtPbiDisList;
	// 鹏元个人信用报告地址信息表
	private static List<PyPcrCrsCrtPbiAis> pyPcrCrsCrtPbiAisList;
	// 鹏元个人信用报告历次任职信息表
	private static List<PyPcrCrsCrtPbiJis> pyPcrCrsCrtPbiJisList;
	// 鹏元个人信用报告曾用名信息表
	private static List<PyPcrCrsCrtPbiHnis> pyPcrCrsCrtPbiHnisList;
	// 鹏元个人信用报告身份警示信息表
	private static List<PyPcrCrsCrtPbiDa> pyPcrCrsCrtPbiDaList;
	// 鹏元个人信用报告银行信用信息表
	private static PyPcrCrsCrtBdi pyPcrCrsCrtBdi;
	// 鹏元个人信用报告贷款信息账户基本信息表
	private static List<PyCrsCrtBdiCisAbi> pyCrsCrtBdiCisAbiList;
	// 鹏元个人信用报告银行信用信息信用卡账户动态信息表
	private static List<PyPcrCrsCrtBdiCisAci> pyPcrCrsCrtBdiCisAciList;
	// 鹏元个人信用报告银行信用信息信用卡状态变动记录表
	private static List<PyPcrCrsCrtBdiCisHs> pyPcrCrsCrtBdiCisHsList;
	// 鹏元个人信用报告银行信用信息信用卡最近12个月的月透支余额表
	private static List<PyPcrCrsCrtBdiCisO12m> pyPcrCrsCrtBdiCisO12mList;
	// 鹏元个人信用报告银行信用信息信用卡最近12个月的月消费金额表
	private static List<PyPcrCrsCrtBdiCisPp12m> pyPcrCrsCrtBdiCisPp12mList;
	// 鹏元个人信用报告银行信用信息信用卡最近12个月的月消费次数表
	private static List<PyPcrCrsCrtBdiCisPt12m> PyPcrCrsCrtBdiCisPt12mList;
	// 鹏元个人信用报告银行信用信息信用卡最近12个月的月取现金额表
	private static List<PyPcrCrsCrtBdiCisWa12m> pyPcrCrsCrtBdiCisWa12mList;
	// 鹏元个人信用报告银行信用信息信用卡最近12个月的月取现次数表
	private static List<PyPcrCrsCrtBdiCisWt12m> pyPcrCrsCrtBdiCisWt12mList;
	// 鹏元个人信用报告贷款信息共同贷款人信息表
	private static List<PyPcrCrsCrtBdiLisBs> pyPcrCrsCrtBdiLisBsList;
	// 鹏元个人信用报告贷款信息账户基本信息表
	private static List<PyPcrCrsCrtBdiLisAbi> pyPcrCrsCrtBdiLisAbiList;
	// 鹏元个人信用报告贷款信息账户动态信息表
	private static List<PyPcrCrsCrtBdiLisAci> pyPcrCrsCrtBdiLisAciList;
	// 鹏元个人信用报告贷款信息最近24月还款情况表
	private static List<PyPcrCrsCrtBdiLisPl24m> pyPcrCrsCrtBdiLisPl24mList;
	// 鹏元个人信用报告贷款信息贷款账户状态变动记录表
	private static List<PyPcrCrsCrtBdiLisHs> pyPcrCrsCrtBdiLisHsList;
	// 鹏元个人信用报告银行概要信息表
	private static PyCrsCrtBsi pyCrsCrtBsi;
	// 鹏元个人信用报告个人社会保险信息表
	private static PyPcrCrsCrtSisz2 pyPcrCrsCrtSisz2;
	// 鹏元个人信用报告个人社会保险个人基本信息表
	private static PyPcrCrsCrtSisz2Bi pyPcrCrsCrtSisz2Bi;
	// 鹏元个人信用报告个人社会保险兼职单位信息
	private static List<PyPcrCrsCrtSisz2Pui> pyPcrCrsCrtSisz2PuiList;
	// 鹏元个人信用报告个人社会保险近5年内参保历史信息表
	private static List<PyPcrCrsCrtSisz2Hi5y> pyPcrCrsCrtSisz2Hi5yList;
	// 鹏元个人信用报告个人社会保险近5年内参保信息汇总表
	private static PyPcrCrsCrtSisz2Si5y pyPcrCrsCrtSisz2Si5y;
	// 鹏元个人信用报告特别信息表
	private static PyPcrCrsCrtSi pyPcrCrsCrtSi;
	// 鹏元个人信用报告特别信息内容表
	private static List<PyPcrCrsCrtSiItm> PyPcrCrsCrtSiItmList;
	// 鹏元个人信用报告身份证号码校验信息表
	private static PyPcrCrsCrtIvi pyPcrCrsCrtIvi;
	// 鹏元个人信用报告身份证号码校验信息内容表
	private static PyPcrCrsCrtIviItm pyPcrCrsCrtIviItm;
	// 鹏元个人信用报告深圳基本摘要信息表
	private static PyPcrCrsCrtSzbsi pyPcrCrsCrtSzbsi;
	// 鹏元个人信用报告深圳基本摘要信息基本信息表
	private static PyPcrCrsCrtSzbsiBss pyPcrCrsCrtSzbsiBss;
	// 鹏元个人信用报告深圳基本摘要信息银行信息表
	private static PyPcrCrsCrtSzbsiBks pyPcrCrsCrtSzbsiBks;
	// 鹏元个人信用报告深圳基本摘要信息社保信息表
	private static PyPcrCrsCrtSzbsiIs pyPcrCrsCrtSzbsiIs;
	// 鹏元个人信用报告深圳基本摘要信息评分信息表
	private static PyPcrCrsCrtSzbsiSs pyPcrCrsCrtSzbsiSs;
	// 鹏元个人信用报告深圳基本摘要信息电话欠费信息表
	private static PyPcrCrsCrtSzbsiTs pyPcrCrsCrtSzbsiTs;
	// 鹏元个人信用报告近两年历史查询明细表
	private static PyPcrCrsCrtHqi pyPcrCrsCrtHqi;
	// 鹏元个人信用报告近两年历史查询明细内容表
	private static List<PyPcrCrsCrtHqiItm> pyPcrCrsCrtHqiItmList;

	// 鹏元个人信用返回报文总类
	private static PyPcrTenReponse pyPcrTenReponse;

	private static List<PyCisReportCollection> pyCisReportCollectionList;

	/**
	 * 解析xml字符串文档
	 * 
	 * @param xmlStr
	 *            字符串XML文档
	 * @param trnId
	 *            交易编号
	 * @return
	 */
	public static PyPcrTenReponse readStringXml(String xmlStr, String trnId, String appId,String CRT_USER) {
		if (StringUtils.isNotBlank(xmlStr)) {
			try {
				// 将字符串转换为XML
				doc = DocumentHelper.parseText(xmlStr);
			} catch (DocumentException e) {
				logger.error("[区域数据-深圳-鹏元-个人信用],返回报文解析异常,字符串转XML失败. xml={}", xmlStr);
				e.printStackTrace();
			}
			if (doc == null) {
				logger.error("[区域数据-深圳-鹏元-个人信用],String转XML文档异常.	{}", xmlStr);
				return null;
			}
			// 获取根节点
			Element cisReports = doc.getRootElement();
			if (cisReports == null) {
				logger.error("[区域数据-深圳-鹏元-个人信用],XML文档获取根节点异常.	{}", xmlStr);
				return null;
			}
			if ("cisReports".equals(cisReports.getName())) {
				pyPcrTenReponse = new PyPcrTenReponse();
				if (cisReports != null) {
					// 获取根节点标签属性
					pyPcrCrs = new PyPcrCrs();
					pyPcrCrs.setTrnId(trnId);
					pyPcrCrs.setCrtUser(CRT_USER);
					if (cisReports.attribute("batNo") != null) {
						pyPcrCrs.setBatchNo(cisReports.attribute("batNo").getValue());
					}
					if (cisReports.attribute("unitName") != null) {
						pyPcrCrs.setUnitName(cisReports.attribute("unitName").getValue());
					}
					if (cisReports.attribute("subOrgan") != null) {
						pyPcrCrs.setSubOrgan(cisReports.attribute("subOrgan").getValue());
					}
					if (cisReports.attribute("queryUserID") != null) {
						pyPcrCrs.setQueryUserId(cisReports.attribute("queryUserID").getValue());
					}
					if (cisReports.attribute("queryCount") != null) {
						pyPcrCrs.setQueryCount(conversionInt(cisReports.attribute("queryCount").getValue()));
					}
					if (cisReports.attribute("receiveTime") != null) {
						pyPcrCrs.setReceiveTime(cisReports.attribute("receiveTime").getValue());
					}
					pyPcrCrs.setAppId(appId);
					// 将内容放入总类
					pyPcrTenReponse.setPyPcrCrs(pyPcrCrs);
					// 获取根节点下子节点 cisReports>cisReport,该节点可能有1-n个
					Element cisReport = cisReports.element("cisReport");
					if (cisReport != null) {
						List<Element> ListCisReport = cisReports.elements("cisReport");
						if (ListCisReport != null && ListCisReport.size() > 0) {
							pyCisReportCollectionList = new Vector<>();
							PyCisReportCollection pyCisReportCollection = new PyCisReportCollection();
							for (Element e : ListCisReport) {
								// 获取节点 cisReports>cisReport 的属性
								pyPcrCrsCrt = new PyPcrCrsCrt();
								pyPcrCrsCrt.setTrnId(trnId);
								pyPcrCrsCrt.setCrtUser(CRT_USER);
								if (e.attribute("reportID") != null) {
									pyPcrCrsCrt.setReportId(e.attributeValue("reportID"));
								}

								if (e.attribute("buildEndTime") != null) {
									pyPcrCrsCrt.setBuildEnTime(e.attributeValue("buildEndTime"));
								}

								if (e.attribute("queryReasonID") != null) {
									pyPcrCrsCrt.setQueryReasonId(conversionInt(e.attributeValue("queryReasonID")));
								}

								if (e.attribute("subReportTypes") != null) {
									pyPcrCrsCrt.setSubReportTypes(e.attributeValue("subReportTypes"));
								}

								if (e.attribute("treatResult") != null) {
									pyPcrCrsCrt.setTreatResult(e.attributeValue("treatResult"));
								}

								if (e.attribute("subReportTypesShortCaption") != null) {
									pyPcrCrsCrt.setSubReportTypesShortCaption(e.attributeValue("subReportTypesShortCaption"));
								}

								if (e.attribute("refID") != null) {
									pyPcrCrsCrt.setRefId(e.attributeValue("refID"));
								}

								if (e.attribute("hasSystemError") != null) {
									pyPcrCrsCrt.setHasSystemError(e.attributeValue("hasSystemError"));
								}

								if (e.attribute("isFrozen") != null) {
									pyPcrCrsCrt.setIsFrozen(e.attributeValue("isFrozen"));
								}
								pyPcrCrsCrt.setAppId(appId);
								// 将内容放入总类
								pyCisReportCollection.setPyPcrCrsCrt(pyPcrCrsCrt);
								
								pyPcrCrsCrtQcsList = new Vector<>();
								pyPcrCrsCrtBdiLisBsList = new Vector<>();
								pyPcrCrsCrtBdiLisAbiList = new Vector<>();
								pyPcrCrsCrtBdiLisAciList = new Vector<>();
								pyPcrCrsCrtBdiLisPl24mList = new Vector<>();
								pyPcrCrsCrtBdiLisHsList = new Vector<>();
								pyPcrCrsCrtSisz2PuiList = new Vector<>();
								pyPcrCrsCrtSisz2Hi5yList = new Vector<>();
								pyCrsCrtBdiCisAbiList = new Vector<>();
								pyPcrCrsCrtBdiCisAciList = new Vector<>();
								pyPcrCrsCrtBdiCisHsList = new Vector<>();
								pyPcrCrsCrtBdiCisO12mList = new Vector<>();
								pyPcrCrsCrtBdiCisPp12mList = new Vector<>();
								PyPcrCrsCrtBdiCisPt12mList = new Vector<>();
								pyPcrCrsCrtBdiCisWa12mList = new Vector<>();
								pyPcrCrsCrtBdiCisWt12mList = new Vector<>();
								pyPcrCrsCrtPbiDisList = new Vector<>();
								pyPcrCrsCrtPbiHnisList = new Vector<>();
								pyPcrCrsCrtPbiAisList = new Vector<>();
								pyPcrCrsCrtPbiJisList = new Vector<>();
								PyPcrCrsCrtSiItmList = new Vector<>();
								pyPcrCrsCrtPbiDaList = new Vector<>();
								pyPcrCrsCrtHqiItmList = new Vector<>();
								// 查询条件信息 节点-
								// cisReports>cisReport>queryConditions
								// 该节点可能有1-n个
								Element queryConditions = e.element("queryConditions");
								if (queryConditions != null) {
									
									List<Element> itemList = queryConditions.elements("item");
									if (itemList != null && itemList.size() > 0) {
										for (Element item : itemList) {
											PyPcrCrsCrtQcs pyPcrCrsCrtQcs = new PyPcrCrsCrtQcs();
											pyPcrCrsCrtQcs.setTrnId(trnId);
											pyPcrCrsCrtQcs.setCrtUser(CRT_USER);
											pyPcrCrsCrtQcs.setName(item.elementText("name"));
											pyPcrCrsCrtQcs.setCaption(item.elementText("caption"));
											pyPcrCrsCrtQcs.setConditionValue(item.elementText("value"));
											pyPcrCrsCrtQcs.setAppId(appId);
											pyPcrCrsCrtQcsList.add(pyPcrCrsCrtQcs);
										}
									}
									// 将结果放入总类
									pyCisReportCollection.setPyPcrCrsCrtQcsList(pyPcrCrsCrtQcsList);

								}
								// 个人基本信息 获取节点
								// cisReports>cisReport>personBaseInfo
								Element personBaseInfo = e.element("personBaseInfo");
								if (personBaseInfo != null) {
									// 节点属性
									pyPcrCrsCrtPbi = new PyPcrCrsCrtPbi();
									pyPcrCrsCrtPbi.setTrnId(trnId);
									pyPcrCrsCrtPbi.setCrtUser(CRT_USER);
									if(personBaseInfo.attribute("subReportType")!=null){
										pyPcrCrsCrtPbi.setSubReportType(conversionInt(personBaseInfo.attribute("subReportType").getValue()));
									}
									if(personBaseInfo.attribute("subReportTypeCost")!=null){
										pyPcrCrsCrtPbi.setSubReportTypeCost(conversionInt(personBaseInfo.attribute("subReportTypeCost").getValue()));
									}
									if(personBaseInfo.attribute("treatResult")!=null){
										pyPcrCrsCrtPbi.setTreatResult(conversionInt(personBaseInfo.attribute("treatResult").getValue()));
									}
									if (personBaseInfo.attribute("treatErrorCode") != null) {
										pyPcrCrsCrtPbi.setTreatErrorCode(personBaseInfo.attribute("treatErrorCode").getValue());
									}
									if(personBaseInfo.attribute("errorMessage")!=null){
										pyPcrCrsCrtPbi.setErrorMessage(personBaseInfo.attribute("errorMessage").getValue());
									}
									pyPcrCrsCrtPbi.setAppId(appId);
									// 将结果放入总类
									pyCisReportCollection.setPyPcrCrsCrtPbi(pyPcrCrsCrtPbi);
									// 节点内容 节点
									// cisReports>cisReport>personBaseInfo>item
									Element item = personBaseInfo.element("item");
									if (item != null) {
										// 摘要信息
										Element summaryInfo = item.element("summaryInfo");
										if (summaryInfo != null) {
											pyPcrCrsCrtPbiSi = new PyPcrCrsCrtPbiSi();
											pyPcrCrsCrtPbiSi.setTrnId(trnId);
											pyPcrCrsCrtPbiSi.setCrtUser(CRT_USER);
											pyPcrCrsCrtPbiSi.setDocumentCount(
													conversionInt(summaryInfo.elementText("documentCount")));
											pyPcrCrsCrtPbiSi.setAdressCount(
													conversionInt(summaryInfo.elementText("addressCount")));
											pyPcrCrsCrtPbiSi
													.setJobCount(conversionInt(summaryInfo.elementText("jobCount")));
											pyPcrCrsCrtPbiSi.setHistroyNameCount(
													conversionInt(summaryInfo.elementText("historyNameCount")));
											pyPcrCrsCrtPbiSi.setDocumentAlertCount(
													conversionInt(summaryInfo.elementText("documentAlertCount")));
											pyPcrCrsCrtPbiSi.setQueryReportCount(
													conversionInt(summaryInfo.elementText("queryReportCount")));
											pyPcrCrsCrtPbiSi.setLastInfoDate(summaryInfo.elementText("lastInfoDate"));
											pyPcrCrsCrtPbiSi.setAppId(appId);
											// 将结果放入总类
											pyCisReportCollection.setPyPcrCrsCrtPbiSi(pyPcrCrsCrtPbiSi);
										}
										// 最新基本信息
										Element lastBaseInfo = item.element("lastBaseInfo");
										if (lastBaseInfo != null) {
											pyPcrCrsCrtPbiLbi = new PyPcrCrsCrtPbiLbi();
											pyPcrCrsCrtPbiLbi.setTrnId(trnId);
											pyPcrCrsCrtPbiLbi.setCrtUser(CRT_USER);
											pyPcrCrsCrtPbiLbi.setName(lastBaseInfo.elementText("name"));
											pyPcrCrsCrtPbiLbi.setGender(lastBaseInfo.elementText("gender"));
											pyPcrCrsCrtPbiLbi.setBirthday(lastBaseInfo.elementText("birthday"));
											pyPcrCrsCrtPbiLbi
													.setMarriageStatus(lastBaseInfo.elementText("marriageStatus"));
											pyPcrCrsCrtPbiLbi
													.setRegisterAddress(lastBaseInfo.elementText("registerAddress"));
											pyPcrCrsCrtPbiLbi
													.setCurrentAddress(lastBaseInfo.elementText("currentAddress"));
											pyPcrCrsCrtPbiLbi.setTel(lastBaseInfo.elementText("tel"));
											pyPcrCrsCrtPbiLbi.setMobile(lastBaseInfo.elementText("mobile"));
											pyPcrCrsCrtPbiLbi
													.setOccupationType(lastBaseInfo.elementText("occupationType"));
											pyPcrCrsCrtPbiLbi.setPositionType(lastBaseInfo.elementText("positionType"));
											pyPcrCrsCrtPbiLbi.setTitleType(lastBaseInfo.elementText("titleType"));
											pyPcrCrsCrtPbiLbi.setEducation(lastBaseInfo.elementText("education"));
											pyPcrCrsCrtPbiLbi.setInfoDate(lastBaseInfo.elementText("infoDate"));
											pyPcrCrsCrtPbiLbi.setAppId(appId);
											// 将结果放入总类
											pyCisReportCollection.setPyPcrCrsCrtPbiLbi(pyPcrCrsCrtPbiLbi);
										}
										// 证件信息
										Element documentInfos = item.element("documentInfos");
										if (documentInfos != null) {
											
											List<Element> documentInfosList = documentInfos.elements("item");
											if (documentInfosList != null && documentInfosList.size() > 0) {
												for (Element documentInfosItem : documentInfosList) {
													PyPcrCrsCrtPbiDis pyPcrCrsCrtPbiDis = new PyPcrCrsCrtPbiDis();
													pyPcrCrsCrtPbiDis.setTrnId(trnId);
													pyPcrCrsCrtPbiDis.setCrtUser(CRT_USER);
													pyPcrCrsCrtPbiDis.setName(documentInfosItem.elementText("name"));
													pyPcrCrsCrtPbiDis
															.setDocumentNo(documentInfosItem.elementText("documentNo"));
													pyPcrCrsCrtPbiDis.setDocumentType(
															documentInfosItem.elementText("documentType"));
													pyPcrCrsCrtPbiDis
															.setCountry(documentInfosItem.elementText("country"));
													pyPcrCrsCrtPbiDis
															.setInfoDate(documentInfosItem.elementText("infoDate"));
													pyPcrCrsCrtPbiDis.setAppId(appId);
													pyPcrCrsCrtPbiDisList.add(pyPcrCrsCrtPbiDis);
												}
												// 将结果放入总类
												pyCisReportCollection.setPyPcrCrsCrtPbiDisList(pyPcrCrsCrtPbiDisList);
											}

										}
										// 地址信息(最多取最近5个)
										Element addressInfos = item.element("addressInfos");
										if (addressInfos != null) {
											
											List<Element> addressInfosList = addressInfos.elements("item");
											if (addressInfosList != null && addressInfosList.size() > 0) {
												for (Element addressInfosItem : addressInfosList) {
													PyPcrCrsCrtPbiAis pyPcrCrsCrtPbiAis = new PyPcrCrsCrtPbiAis();
													pyPcrCrsCrtPbiAis.setTrnId(trnId);
													pyPcrCrsCrtPbiAis.setCrtUser(CRT_USER);
													pyPcrCrsCrtPbiAis
															.setAddress(addressInfosItem.elementText("address"));
													pyPcrCrsCrtPbiAis.setTel(addressInfosItem.elementText("tel"));
													pyPcrCrsCrtPbiAis.setMobile(addressInfosItem.elementText("mobile"));
													pyPcrCrsCrtPbiAis.setInfoUnit(
															conversionInt(addressInfosItem.elementText("infoUnit")));
													pyPcrCrsCrtPbiAis
															.setInfoDate(addressInfosItem.elementText("infoDate"));
													pyPcrCrsCrtPbiAis.setAppId(appId);
													pyPcrCrsCrtPbiAisList.add(pyPcrCrsCrtPbiAis);
												}
												// 将结果放入总类
												pyCisReportCollection.setPyPcrCrsCrtPbiAisList(pyPcrCrsCrtPbiAisList);

											}
										}
										// 历次任职信息(最多取最近5个)
										Element jobInfos = item.element("jobInfos");
										if (jobInfos != null) {
											List<Element> jobInfosList = jobInfos.elements("item");
											
											if (jobInfosList != null && jobInfosList.size() > 0) {
												for (Element jobInfosItem : jobInfosList) {
													PyPcrCrsCrtPbiJis pyPcrCrsCrtPbiJis = new PyPcrCrsCrtPbiJis();
													pyPcrCrsCrtPbiJis.setTrnId(trnId);
													pyPcrCrsCrtPbiJis.setCrtUser(CRT_USER);
													pyPcrCrsCrtPbiJis.setEmployer(jobInfosItem.elementText("employer"));
													pyPcrCrsCrtPbiJis
															.setEmployerType(jobInfosItem.elementText("employerType"));
													pyPcrCrsCrtPbiJis.setOccupationType(
															jobInfosItem.elementText("occupationType"));
													pyPcrCrsCrtPbiJis
															.setPositionType(jobInfosItem.elementText("positionType"));
													pyPcrCrsCrtPbiJis
															.setTitleType(jobInfosItem.elementText("titleType"));
													pyPcrCrsCrtPbiJis.setInfoDate(jobInfosItem.elementText("infoDate"));
													pyPcrCrsCrtPbiJis
															.setInforUnit(jobInfosItem.elementText("infoUnit"));
													pyPcrCrsCrtPbiJis.setAppId(appId);
													pyPcrCrsCrtPbiJisList.add(pyPcrCrsCrtPbiJis);
												}
												// 将结果放入总类
												pyCisReportCollection.setPyPcrCrsCrtPbiJisList(pyPcrCrsCrtPbiJisList);
											}
										}
										// 曾用名信息
										Element historyNameInfos = item.element("historyNameInfos");
										if (historyNameInfos != null) {
											
											List<Element> historyNameInfosList = historyNameInfos.elements("item");
											if (historyNameInfosList != null && historyNameInfosList.size() > 0) {
												for (Element historyNameInfosItem : historyNameInfosList) {
													PyPcrCrsCrtPbiHnis pyPcrCrsCrtPbiHnis = new PyPcrCrsCrtPbiHnis();
													pyPcrCrsCrtPbiHnis.setTrnId(trnId);
													pyPcrCrsCrtPbiHnis.setCrtUser(CRT_USER);
													pyPcrCrsCrtPbiHnis
															.setName(historyNameInfosItem.elementText("name"));
													pyPcrCrsCrtPbiHnis
															.setInfoUnit(historyNameInfosItem.elementText("infoUnit"));
													pyPcrCrsCrtPbiHnis
															.setInfoDate(historyNameInfosItem.elementText("infoDate"));
													pyPcrCrsCrtPbiHnis.setAppId(appId);
													pyPcrCrsCrtPbiHnisList.add(pyPcrCrsCrtPbiHnis);
												}
												// 将结果放入总类
												pyCisReportCollection.setPyPcrCrsCrtPbiHnisList(pyPcrCrsCrtPbiHnisList);
											}
										}
										// 身份警示信息
										Element documentAlert = item.element("documentAlert");
										if (documentAlert != null) {
											
											List<Element> documentAlertList = documentAlert.elements("item");
											if (documentAlertList != null && documentAlertList.size() > 0) {
												for (Element documentAlertItem : documentAlertList) {
													PyPcrCrsCrtPbiDa pyPcrCrsCrtPbiDa = new PyPcrCrsCrtPbiDa();
													pyPcrCrsCrtPbiDa.setTrnId(trnId);
													pyPcrCrsCrtPbiDa.setCrtUser(CRT_USER);
													pyPcrCrsCrtPbiDa.setName(documentAlertItem.elementText("name"));
													pyPcrCrsCrtPbiDa
															.setDocumentNo(documentAlertItem.elementText("documentNo"));
													pyPcrCrsCrtPbiDa.setDocumentType(
															documentAlertItem.elementText("documentType"));
													pyPcrCrsCrtPbiDa
															.setCountry(documentAlertItem.elementText("country"));
													pyPcrCrsCrtPbiDa.setGender(documentAlertItem.elementText("gender"));
													pyPcrCrsCrtPbiDa
															.setBirthday(documentAlertItem.elementText("birthday"));
													pyPcrCrsCrtPbiDa
															.setInfoDate(documentAlertItem.elementText("infoDate"));
													pyPcrCrsCrtPbiDa.setAppId(appId);
													pyPcrCrsCrtPbiDaList.add(pyPcrCrsCrtPbiDa);
												}
												// 将结果放入总类
												pyCisReportCollection.setPyPcrCrsCrtPbiDaList(pyPcrCrsCrtPbiDaList);
											}
										}
									}
								}
								// 深圳银行信用信用信息
								Element bankDetailsInfo = e.element("bankDetailsInfo");
								if (bankDetailsInfo != null) {
									pyPcrCrsCrtBdi = new PyPcrCrsCrtBdi();
									pyPcrCrsCrtBdi.setTrnId(trnId);
									pyPcrCrsCrtBdi.setCrtUser(CRT_USER);
									if(bankDetailsInfo.attribute("subReportType")!=null){
										pyPcrCrsCrtBdi.setSubReportType(bankDetailsInfo.attributeValue("subReportType"));
									}
									
									if(bankDetailsInfo.attribute("subReportTypeCost")!=null){
										pyPcrCrsCrtBdi
										.setSubReportTypeCost(bankDetailsInfo.attributeValue("subReportTypeCost"));
									}
									
									if(bankDetailsInfo.attribute("treatResult")!=null){
										pyPcrCrsCrtBdi.setTreatResult(bankDetailsInfo.attributeValue("treatResult"));
									}
									if (bankDetailsInfo.attribute("treatErrorCode") != null) {
										pyPcrCrsCrtBdi
												.setTreatErrorCode(bankDetailsInfo.attributeValue("treatErrorCode"));
									}
									if(bankDetailsInfo.attribute("errorMessage")!=null){
										pyPcrCrsCrtBdi.setErrorMessage(bankDetailsInfo.attributeValue("errorMessage"));
									}
									pyPcrCrsCrtBdi.setAppId(appId);
									// 将结果放入总类
									pyCisReportCollection.setPyPcrCrsCrtBdi(pyPcrCrsCrtBdi);
									// 所有信用卡信息 -节点creditcardInfos
									Element creditcardInfos = bankDetailsInfo.element("creditcardInfos");
									if (creditcardInfos != null) {
										List<Element> creditcardInfosList = creditcardInfos.elements("item");
										
										if (creditcardInfosList != null && creditcardInfosList.size() > 0) {
											for (Element creditcardInfosItem : creditcardInfosList) {
												// 账户基本信息-节点：accountBaseInfo
												Element accountBaseInfo = creditcardInfosItem
														.element("accountBaseInfo");
												if (accountBaseInfo != null) {
													PyCrsCrtBdiCisAbi pyCrsCrtBdiCisAbi = new PyCrsCrtBdiCisAbi();
													pyCrsCrtBdiCisAbi = new PyCrsCrtBdiCisAbi();
													pyCrsCrtBdiCisAbi.setTrnId(trnId);
													pyCrsCrtBdiCisAbi.setCrtUser(CRT_USER);
													pyCrsCrtBdiCisAbi.setCreditcardNO(
															accountBaseInfo.elementText("creditcardNo"));
													pyCrsCrtBdiCisAbi.setCreditcardName(
															accountBaseInfo.elementText("creditcardName"));
													pyCrsCrtBdiCisAbi.setUnit(accountBaseInfo.elementText("unit"));
													pyCrsCrtBdiCisAbi.setCreditcardType(
															accountBaseInfo.elementText("creditcardType"));
													pyCrsCrtBdiCisAbi.setCreditcardGrade(
															accountBaseInfo.elementText("creditcardGrade"));
													pyCrsCrtBdiCisAbi
															.setCurrency(accountBaseInfo.elementText("currency"));
													pyCrsCrtBdiCisAbi
															.setOpenDate(accountBaseInfo.elementText("openDate"));
													pyCrsCrtBdiCisAbi.setPermittedOverdraft(conversionDouble(
															accountBaseInfo.elementText("permittedOverdraft")));
													pyCrsCrtBdiCisAbi.setStatus(accountBaseInfo.elementText("status"));
													pyCrsCrtBdiCisAbi
															.setInfoDate(accountBaseInfo.elementText("infoDate"));
													pyCrsCrtBdiCisAbi.setAppId(appId);
													pyCrsCrtBdiCisAbiList.add(pyCrsCrtBdiCisAbi);
												}
												// 信用卡账户动态信息-节点：accountChangeInfo
												Element accountChangeInfo = creditcardInfosItem
														.element("accountChangeInfo");
												if (accountChangeInfo != null) {
													PyPcrCrsCrtBdiCisAci pyPcrCrsCrtBdiCisAci = new PyPcrCrsCrtBdiCisAci();
													pyPcrCrsCrtBdiCisAci.setTrnId(trnId);
													pyPcrCrsCrtBdiCisAci.setCrtUser(CRT_USER);
													pyPcrCrsCrtBdiCisAci.setOverdraftBalanceForLastMonth(
															conversionDouble(accountChangeInfo
																	.elementText("overdraftBalanceForLastMonth")));
													pyPcrCrsCrtBdiCisAci.setOverdraftOccurForLastMonth(
															conversionDouble(accountChangeInfo
																	.elementText("overdraftOccurForLastMonth")));
													pyPcrCrsCrtBdiCisAci.setWithdrawForLastMonth(conversionDouble(
															accountChangeInfo.elementText("withdrawForLastMonth")));
													pyPcrCrsCrtBdiCisAci.setWithdrawTimesForLastMonth(
															conversionInt(accountChangeInfo
																	.elementText("withdrawTimesForLastMonth")));
													pyPcrCrsCrtBdiCisAci.setPurchaseForLastMonth(conversionDouble(
															accountChangeInfo.elementText("purchaseForLastMonth")));
													pyPcrCrsCrtBdiCisAci.setPurchaseTimesForLastMonth(
															conversionInt(accountChangeInfo
																	.elementText("purchaseTimesForLastMonth")));
													pyPcrCrsCrtBdiCisAci.setOverdraftForLast6Month(conversionDouble(
															accountChangeInfo.elementText("overdraftForLast6Month")));
													pyPcrCrsCrtBdiCisAci.setPurchaseForLast6Month(conversionDouble(
															accountChangeInfo.elementText("purchaseForLast6Month")));
													pyPcrCrsCrtBdiCisAci.setPurchaseTimesForLast6Month(
															conversionInt(accountChangeInfo
																	.elementText("purchaseTimesForLast6Month")));
													pyPcrCrsCrtBdiCisAci.setWithdrawForLast6Month(conversionDouble(
															accountChangeInfo.elementText("withdrawForLast6Month")));
													pyPcrCrsCrtBdiCisAci.setOverdraftForLast12Month(conversionDouble(
															accountChangeInfo.elementText("overdraftForLast12Month")));
													pyPcrCrsCrtBdiCisAci.setPurchaseForLast12Month(conversionDouble(
															accountChangeInfo.elementText("purchaseForLast12Month")));
													pyPcrCrsCrtBdiCisAci.setWithdrawForLast12Month(conversionDouble(
															accountChangeInfo.elementText("withdrawForLast12Month")));
													pyPcrCrsCrtBdiCisAci.setWithdrawTimesForLast6Month(
															conversionInt(accountChangeInfo
																	.elementText("withdrawTimesForLast6Month")));
													pyPcrCrsCrtBdiCisAci
															.setInfoDate(accountChangeInfo.elementText("infoDate"));
													pyPcrCrsCrtBdiCisAci.setAppId(appId);
													pyPcrCrsCrtBdiCisAciList.add(pyPcrCrsCrtBdiCisAci);
												}
												// 账户状态变动记录-节点：historyStatus
												Element historyStatus = creditcardInfosItem.element("historyStatus");
												if (historyStatus != null) {
													List<Element> historyStatusList = historyStatus.elements("item");
													if (historyStatusList != null && historyStatusList.size() > 0) {
														for (Element historyStatusItem : historyStatusList) {
															PyPcrCrsCrtBdiCisHs pyPcrCrsCrtBdiCisHs = new PyPcrCrsCrtBdiCisHs();
															pyPcrCrsCrtBdiCisHs.setTrnId(trnId);
															pyPcrCrsCrtBdiCisHs.setCrtUser(CRT_USER);
															pyPcrCrsCrtBdiCisHs
																	.setStatus(historyStatusItem.elementText("status"));
															pyPcrCrsCrtBdiCisHs.setInfoDate(
																	historyStatusItem.elementText("infoDate"));
															pyPcrCrsCrtBdiCisHs.setAppId(appId);
															pyPcrCrsCrtBdiCisHsList.add(pyPcrCrsCrtBdiCisHs);
														}
													}
													PyPcrCrsCrtBdiCisHs pyPcrCrsCrtBdiCisHs = new PyPcrCrsCrtBdiCisHs();
												}
												// 节点-overdraftFor12Months
												Element overdraftFor12Months = creditcardInfosItem
														.element("overdraftFor12Months");
												if (overdraftFor12Months != null) {
													PyPcrCrsCrtBdiCisO12m pyPcrCrsCrtBdiCisO12m = new PyPcrCrsCrtBdiCisO12m();
													pyPcrCrsCrtBdiCisO12m.setTrnId(trnId);
													pyPcrCrsCrtBdiCisO12m.setCrtUser(CRT_USER);
													pyPcrCrsCrtBdiCisO12m.setFirstMonth(
															overdraftFor12Months.attributeValue("firstMonth"));
													pyPcrCrsCrtBdiCisO12m.setLastMonth(
															overdraftFor12Months.attributeValue("lastMonth"));
													pyPcrCrsCrtBdiCisO12m.setLimitValues(
															overdraftFor12Months.attributeValue("values"));
													pyPcrCrsCrtBdiCisO12m.setAppId(appId);
													pyPcrCrsCrtBdiCisO12mList.add(pyPcrCrsCrtBdiCisO12m);
												}
												// 节点-purchasePaymentFor12Months
												Element purchasePaymentFor12Months = creditcardInfosItem
														.element("purchasePaymentFor12Months");
												if (purchasePaymentFor12Months != null) {
													PyPcrCrsCrtBdiCisPp12m pyPcrCrsCrtBdiCisPp12m = new PyPcrCrsCrtBdiCisPp12m();
													pyPcrCrsCrtBdiCisPp12m.setTrnId(trnId);
													pyPcrCrsCrtBdiCisPp12m.setCrtUser(CRT_USER);
													pyPcrCrsCrtBdiCisPp12m.setFirstMonth(
															overdraftFor12Months.attributeValue("firstMonth"));
													pyPcrCrsCrtBdiCisPp12m.setLastMonth(
															overdraftFor12Months.attributeValue("lastMonth"));
													pyPcrCrsCrtBdiCisPp12m.setLimitValues(
															overdraftFor12Months.attributeValue("values"));
													pyPcrCrsCrtBdiCisPp12m.setAppId(appId);
													pyPcrCrsCrtBdiCisPp12mList.add(pyPcrCrsCrtBdiCisPp12m);
												}
												// 节点-purchaseTimesFor12Months
												Element purchaseTimesFor12Months = creditcardInfosItem
														.element("purchaseTimesFor12Months");
												if (purchaseTimesFor12Months != null) {
													PyPcrCrsCrtBdiCisPt12m pyPcrCrsCrtBdiCisPt12m = new PyPcrCrsCrtBdiCisPt12m();
													pyPcrCrsCrtBdiCisPt12m.setTrnId(trnId);
													pyPcrCrsCrtBdiCisPt12m.setCrtUser(CRT_USER);
													pyPcrCrsCrtBdiCisPt12m.setFirstMonth(
															overdraftFor12Months.attributeValue("firstMonth"));
													pyPcrCrsCrtBdiCisPt12m.setLastMonth(
															overdraftFor12Months.attributeValue("lastMonth"));
													pyPcrCrsCrtBdiCisPt12m.setLimitValues(
															overdraftFor12Months.attributeValue("values"));
													pyPcrCrsCrtBdiCisPt12m.setAppId(appId);
													PyPcrCrsCrtBdiCisPt12mList.add(pyPcrCrsCrtBdiCisPt12m);
												}
												// 节点-withdrawAmountFor12Months
												Element withdrawAmountFor12Months = creditcardInfosItem
														.element("withdrawAmountFor12Months");
												if (withdrawAmountFor12Months != null) {
													PyPcrCrsCrtBdiCisWa12m pyPcrCrsCrtBdiCisWa12m = new PyPcrCrsCrtBdiCisWa12m();
													pyPcrCrsCrtBdiCisWa12m.setTrnId(trnId);
													pyPcrCrsCrtBdiCisWa12m.setCrtUser(CRT_USER);
													pyPcrCrsCrtBdiCisWa12m.setFirstMonth(
															overdraftFor12Months.attributeValue("firstMonth"));
													pyPcrCrsCrtBdiCisWa12m.setLastMonth(
															overdraftFor12Months.attributeValue("lastMonth"));
													pyPcrCrsCrtBdiCisWa12m.setLimitValues(
															overdraftFor12Months.attributeValue("values"));
													pyPcrCrsCrtBdiCisWa12m.setAppId(appId);
													pyPcrCrsCrtBdiCisWa12mList.add(pyPcrCrsCrtBdiCisWa12m);
												}
												// 节点-withdrawTimesFor12Months
												Element withdrawTimesFor12Months = creditcardInfosItem
														.element("withdrawTimesFor12Months");
												if (withdrawTimesFor12Months != null) {
													PyPcrCrsCrtBdiCisWt12m pyPcrCrsCrtBdiCisWt12m = new PyPcrCrsCrtBdiCisWt12m();
													pyPcrCrsCrtBdiCisWt12m.setTrnId(trnId);
													pyPcrCrsCrtBdiCisWt12m.setCrtUser(CRT_USER);
													pyPcrCrsCrtBdiCisWt12m.setFirstMonth(
															overdraftFor12Months.attributeValue("firstMonth"));
													pyPcrCrsCrtBdiCisWt12m.setLastMonth(
															overdraftFor12Months.attributeValue("lastMonth"));
													pyPcrCrsCrtBdiCisWt12m.setLimitValues(
															overdraftFor12Months.attributeValue("values"));
													pyPcrCrsCrtBdiCisWt12m.setAppId(appId);
													pyPcrCrsCrtBdiCisWt12mList.add(pyPcrCrsCrtBdiCisWt12m);
												}
											}
											// 将结果放入总类
											pyCisReportCollection.setPyCrsCrtBdiCisAbiList(pyCrsCrtBdiCisAbiList);
											pyCisReportCollection.setPyPcrCrsCrtBdiCisAciList(pyPcrCrsCrtBdiCisAciList);
											pyCisReportCollection.setPyPcrCrsCrtBdiCisHsList(pyPcrCrsCrtBdiCisHsList);
											pyCisReportCollection
													.setPyPcrCrsCrtBdiCisO12mList(pyPcrCrsCrtBdiCisO12mList);
											pyCisReportCollection
													.setPyPcrCrsCrtBdiCisPp12mList(pyPcrCrsCrtBdiCisPp12mList);
											pyCisReportCollection
													.setPyPcrCrsCrtBdiCisPt12mList(PyPcrCrsCrtBdiCisPt12mList);
											pyCisReportCollection
													.setPyPcrCrsCrtBdiCisWa12mList(pyPcrCrsCrtBdiCisWa12mList);
											pyCisReportCollection
													.setPyPcrCrsCrtBdiCisWt12mList(pyPcrCrsCrtBdiCisWt12mList);

										}
									}
									// 所有贷款信息-节点loanInfos
									Element loanInfos = bankDetailsInfo.element("loanInfos");
									if (loanInfos != null) {
										List<Element> loanInfosList = loanInfos.elements("item");
										if (loanInfosList != null && loanInfosList.size() > 0) {
											
											for (Element loanInfosItem : loanInfosList) {

												// 共同贷款人信息-节点：borrowers
												Element borrowers = loanInfosItem.element("borrowers");
												if (borrowers != null) {
													List<Element> borrowersList = borrowers.elements("item");
													for (Element borrowersItem : borrowersList) {
														PyPcrCrsCrtBdiLisBs pyPcrCrsCrtBdiLisBs = new PyPcrCrsCrtBdiLisBs();
														pyPcrCrsCrtBdiLisBs.setTrnId(trnId);
														pyPcrCrsCrtBdiLisBs.setCrtUser(CRT_USER);
														pyPcrCrsCrtBdiLisBs.setName(borrowersItem.elementText("name"));
														pyPcrCrsCrtBdiLisBs
																.setDocumentNo(borrowersItem.elementText("documentNo"));
														pyPcrCrsCrtBdiLisBs.setAppId(appId);
														pyPcrCrsCrtBdiLisBsList.add(pyPcrCrsCrtBdiLisBs);
													}
												}
												// 账户基本信息-节点：accountBaseInfo
												Element accountBaseInfo = loanInfosItem.element("accountBaseInfo");
												if (accountBaseInfo != null) {
													PyPcrCrsCrtBdiLisAbi pyPcrCrsCrtBdiLisAbi = new PyPcrCrsCrtBdiLisAbi();
													pyPcrCrsCrtBdiLisAbi.setTrnId(trnId);
													pyPcrCrsCrtBdiLisAbi.setCrtUser(CRT_USER);
													pyPcrCrsCrtBdiLisAbi
															.setAccountNo(accountBaseInfo.elementText("accountNo"));
													pyPcrCrsCrtBdiLisAbi.setUnit(
															conversionInt(accountBaseInfo.elementText("unit")));
													pyPcrCrsCrtBdiLisAbi
															.setCurrency(accountBaseInfo.elementText("currency"));
													pyPcrCrsCrtBdiLisAbi
															.setLoanItem(accountBaseInfo.elementText("loanItem"));
													pyPcrCrsCrtBdiLisAbi.setGuaranteeMode(
															accountBaseInfo.elementText("guaranteeMode"));
													pyPcrCrsCrtBdiLisAbi.setAuthorizedAmount(conversionDouble(
															accountBaseInfo.elementText("authorizedAmount")));
													pyPcrCrsCrtBdiLisAbi.setAmount(
															conversionDouble(accountBaseInfo.elementText("amount")));
													pyPcrCrsCrtBdiLisAbi
															.setStatus(accountBaseInfo.elementText("status"));
													pyPcrCrsCrtBdiLisAbi
															.setOpenDate(accountBaseInfo.elementText("openDate"));
													pyPcrCrsCrtBdiLisAbi.setMaturityDate(
															accountBaseInfo.elementText("maturityDate"));
													pyPcrCrsCrtBdiLisAbi.setPaymentBeginDate(
															accountBaseInfo.elementText("paymentBeginDate"));
													pyPcrCrsCrtBdiLisAbi
															.setPaymentPlan(accountBaseInfo.elementText("paymentPlan"));
													pyPcrCrsCrtBdiLisAbi
															.setPaymentMode(accountBaseInfo.elementText("paymentMode"));
													pyPcrCrsCrtBdiLisAbi.setInstallmentPlan(conversionDouble(
															accountBaseInfo.elementText("installmentPlan")));
													pyPcrCrsCrtBdiLisAbi
															.setInfoDate(accountBaseInfo.elementText("infoDate"));
													pyPcrCrsCrtBdiLisAbi.setAppId(appId);
													pyPcrCrsCrtBdiLisAbiList.add(pyPcrCrsCrtBdiLisAbi);
												}
												// 账户动态信息-节点：accountChangeInfo
												Element accountChangeInfo = loanInfosItem.element("accountChangeInfo");
												if (accountChangeInfo != null) {
													PyPcrCrsCrtBdiLisAci pyPcrCrsCrtBdiLisAci = new PyPcrCrsCrtBdiLisAci();
													pyPcrCrsCrtBdiLisAci.setTrnId(trnId);
													pyPcrCrsCrtBdiLisAci.setCrtUser(CRT_USER);
													pyPcrCrsCrtBdiLisAci.setLastPaymentMonth(
															accountChangeInfo.elementText("lastPaymentMonth"));
													pyPcrCrsCrtBdiLisAci.setRemainTerms(conversionInt(
															accountChangeInfo.elementText("remainTerms")));
													pyPcrCrsCrtBdiLisAci.setBalanceLastTerm(conversionDouble(
															accountChangeInfo.elementText("balanceLastTerm")));
													pyPcrCrsCrtBdiLisAci
															.setRpaLastTerm(conversionDouble(accountChangeInfo
																	.elementText("realPaymentAmountLastTerm")));
													pyPcrCrsCrtBdiLisAci.setAaLastTerm(conversionDouble(
															accountChangeInfo.elementText("arrearAmountLastTerm")));
													pyPcrCrsCrtBdiLisAci.setArrearTimesCount(conversionInt(
															accountChangeInfo.elementText("arrearTimesCount")));
													pyPcrCrsCrtBdiLisAci
															.setAtcoCountinuous(conversionInt(accountChangeInfo
																	.elementText("arrearTimesCountOfContinuous")));
													pyPcrCrsCrtBdiLisAci.setAtcoTotal(conversionInt(
															accountChangeInfo.elementText("arrearTimesCountOfTotal")));
													pyPcrCrsCrtBdiLisAci.setArrearTimes1(conversionInt(
															accountChangeInfo.elementText("arrearTimes1")));
													pyPcrCrsCrtBdiLisAci.setArrearTimes2(conversionInt(
															accountChangeInfo.elementText("arrearTimes2")));
													pyPcrCrsCrtBdiLisAci.setArrearTimes3(conversionInt(
															accountChangeInfo.elementText("arrearTimes3")));
													pyPcrCrsCrtBdiLisAci.setArrearTimes4(conversionInt(
															accountChangeInfo.elementText("arrearTimes4")));
													pyPcrCrsCrtBdiLisAci.setArrearTimes5(conversionInt(
															accountChangeInfo.elementText("arrearTimes5")));
													pyPcrCrsCrtBdiLisAci.setArrearTimes6(conversionInt(
															accountChangeInfo.elementText("arrearTimes6")));
													pyPcrCrsCrtBdiLisAci.setArrearTimes7_12(conversionInt(
															accountChangeInfo.elementText("arrearTimes7-12")));
													pyPcrCrsCrtBdiLisAci.setArrearTimesOver12(conversionInt(
															accountChangeInfo.elementText("arrearTimesOver12")));
													pyPcrCrsCrtBdiLisAci
															.setInfoDate(accountChangeInfo.elementText("infoDate"));
													pyPcrCrsCrtBdiLisAci.setAppId(appId);
													pyPcrCrsCrtBdiLisAciList.add(pyPcrCrsCrtBdiLisAci);
												}
												// 节点：paymentForLast24Month
												Element paymentForLast24Month = loanInfosItem
														.element("paymentForLast24Month");
												if (paymentForLast24Month != null) {
													PyPcrCrsCrtBdiLisPl24m pyPcrCrsCrtBdiLisPl24m = new PyPcrCrsCrtBdiLisPl24m();
													pyPcrCrsCrtBdiLisPl24m.setTrnId(trnId);
													pyPcrCrsCrtBdiLisPl24m.setCrtUser(CRT_USER);
													pyPcrCrsCrtBdiLisPl24m.setFirstMonth(
															paymentForLast24Month.attributeValue("firstMonth"));
													pyPcrCrsCrtBdiLisPl24m.setLastMonth(
															paymentForLast24Month.attributeValue("lastMonth"));
													pyPcrCrsCrtBdiLisPl24m.setLimitValues(
															paymentForLast24Month.attributeValue("values"));
													pyPcrCrsCrtBdiLisPl24m.setAppId(appId);
													pyPcrCrsCrtBdiLisPl24mList.add(pyPcrCrsCrtBdiLisPl24m);
												}
												// 账户状态变动记录-节点：historyStatus
												Element historyStatus = loanInfosItem.element("historyStatus");
												if (historyStatus != null) {
													List<Element> historyStatusList = historyStatus.elements("item");
													if (historyStatusList != null && historyStatusList.size() > 0) {
														for (Element historyStatusItem : historyStatusList) {
															PyPcrCrsCrtBdiLisHs pyPcrCrsCrtBdiLisHs = new PyPcrCrsCrtBdiLisHs();
															pyPcrCrsCrtBdiLisHs.setTrnId(trnId);
															pyPcrCrsCrtBdiLisHs.setCrtUser(CRT_USER);
															pyPcrCrsCrtBdiLisHs
																	.setStatus(historyStatusItem.elementText("status"));
															pyPcrCrsCrtBdiLisHs.setInfoDate(
																	historyStatusItem.elementText("infoDate"));
															pyPcrCrsCrtBdiLisHs.setAppId(appId);
															pyPcrCrsCrtBdiLisHsList.add(pyPcrCrsCrtBdiLisHs);
														}

													}
												}
											}
											// 将结果放入总类
											pyCisReportCollection.setPyPcrCrsCrtBdiLisBsList(pyPcrCrsCrtBdiLisBsList);
											pyCisReportCollection.setPyPcrCrsCrtBdiLisAbiList(pyPcrCrsCrtBdiLisAbiList);
											pyCisReportCollection.setPyPcrCrsCrtBdiLisAciList(pyPcrCrsCrtBdiLisAciList);
											pyCisReportCollection
													.setPyPcrCrsCrtBdiLisPl24mList(pyPcrCrsCrtBdiLisPl24mList);
											pyCisReportCollection.setPyPcrCrsCrtBdiLisHsList(pyPcrCrsCrtBdiLisHsList);
											pyCisReportCollection.setPyPcrCrsCrtSisz2PuiList(pyPcrCrsCrtSisz2PuiList);
											pyCisReportCollection.setPyPcrCrsCrtSisz2Hi5yList(pyPcrCrsCrtSisz2Hi5yList);
										}
									}

								}
								// 银行概要信息
								Element bankSummaryInfo = e.element("bankSummaryInfo");
								if (bankSummaryInfo != null) {

									Element bankSummaryInfoItem = bankSummaryInfo.element("item");
									if (bankSummaryInfoItem != null) {
										pyCrsCrtBsi = new PyCrsCrtBsi();
										pyCrsCrtBsi.setTrnId(trnId);
										pyCrsCrtBsi.setCrtUser(CRT_USER);

										pyCrsCrtBsi.setSubReportType(
												conversionInt(bankSummaryInfo.attributeValue("subReportType")));
										pyCrsCrtBsi.setSubReportTypeCost(
												conversionInt(bankSummaryInfo.attributeValue("subReportTypeCost")));
										pyCrsCrtBsi.setTreatResult(
												conversionInt(bankSummaryInfo.attributeValue("treatResult")));
										pyCrsCrtBsi.setTreatErrorCode(bankSummaryInfo.attributeValue("treatErrorCode"));
										pyCrsCrtBsi.setErrorMessage(bankSummaryInfo.attributeValue("errorMessage"));

										pyCrsCrtBsi.setCreditcardCount(
												conversionInt(bankSummaryInfoItem.elementText("creditcardCount")));
										pyCrsCrtBsi.setCreditcardUsingCount(
												conversionInt(bankSummaryInfoItem.elementText("creditcardUsingCount")));
										pyCrsCrtBsi.setCreditcardFirstOpen(
												bankSummaryInfoItem.elementText("creditcardFirstOpen"));
										pyCrsCrtBsi.setCaCount(conversionInt(
												bankSummaryInfoItem.elementText("creditcardAbnormalCount")));
										pyCrsCrtBsi.setCpOverdraftAmount(conversionDouble(
												bankSummaryInfoItem.elementText("creditcardPermittedOverdraftAmount")));
										pyCrsCrtBsi.setcOverdraftAmount(conversionDouble(
												bankSummaryInfoItem.elementText("creditcardOverdraftAmount")));
										pyCrsCrtBsi.setCreditcardCancelCount(conversionInt(
												bankSummaryInfoItem.elementText("creditcardCancelCount")));
										pyCrsCrtBsi.setCoLastOccurAmount(conversionDouble(
												bankSummaryInfoItem.elementText("creditcardOverdraftLastOccurAmount")));
										pyCrsCrtBsi.setHighestOverdraftAmount(conversionDouble(
												bankSummaryInfoItem.elementText("highestOverdraftAmount")));
										pyCrsCrtBsi.setWorstCardStatus(
												conversionInt(bankSummaryInfoItem.elementText("worstCardStatus")));
										pyCrsCrtBsi.setLoanCount(
												conversionInt(bankSummaryInfoItem.elementText("loanCount")));
										pyCrsCrtBsi.setLoanBankCount(
												conversionInt(bankSummaryInfoItem.elementText("loanBankCount")));
										pyCrsCrtBsi.setLoanNotSquareCount(
												conversionInt(bankSummaryInfoItem.elementText("loanNotSquareCount")));
										pyCrsCrtBsi.setLoanFirstOpen(bankSummaryInfoItem.elementText("loanFirstOpen"));
										pyCrsCrtBsi.setLoanAbnormalCount(
												conversionInt(bankSummaryInfoItem.elementText("loanAbnormalCount")));
										pyCrsCrtBsi.setLoanAmount(
												conversionDouble(bankSummaryInfoItem.elementText("loanAmount")));
										pyCrsCrtBsi.setLoanBalanceAmount(
												conversionDouble(bankSummaryInfoItem.elementText("loanBalanceAmount")));
										pyCrsCrtBsi.setLoanArrearAmount(
												conversionDouble(bankSummaryInfoItem.elementText("loanArrearAmount")));
										pyCrsCrtBsi.setLoanHistoryArrearTimes(conversionInt(
												bankSummaryInfoItem.elementText("loanHistoryArrearTimes")));
										pyCrsCrtBsi.setWorstLoanStatus(
												conversionInt(bankSummaryInfoItem.elementText("worstLoanStatus")));
										pyCrsCrtBsi.setLoanHistory12ArrearTimes(conversionInt(
												bankSummaryInfoItem.elementText("loanHistory12ArrearTimes")));
										pyCrsCrtBsi.setSettleAccountCount(
												conversionInt(bankSummaryInfoItem.elementText("settleAccountCount")));
										pyCrsCrtBsi.setYear5overDueAccountCount(conversionInt(
												bankSummaryInfoItem.elementText("year5overDueAccountCount")));
										pyCrsCrtBsi.setAppId(appId);
										// 将结果放入总类
										pyCisReportCollection.setPyCrsCrtBsi(pyCrsCrtBsi);
									}

								}
								// 深圳社会保险信息
								Element socialInsuranceOfShenzhen2 = e.element("socialInsuranceOfShenzhen2");
								if (socialInsuranceOfShenzhen2 != null) {
									pyPcrCrsCrtSisz2 = new PyPcrCrsCrtSisz2();
									pyPcrCrsCrtSisz2.setTrnId(trnId);
									pyPcrCrsCrtSisz2.setCrtUser(CRT_USER);
									if(socialInsuranceOfShenzhen2.attribute("subReportType")!=null){
										pyPcrCrsCrtSisz2.setSubReportType(
												conversionInt(socialInsuranceOfShenzhen2.attributeValue("subReportType")));
									}
									
									if(socialInsuranceOfShenzhen2.attribute("subReportTypeCost")!=null){
										pyPcrCrsCrtSisz2.setSubReprotTypeCount(conversionInt(
												socialInsuranceOfShenzhen2.attributeValue("subReportTypeCost")));
									}
									
									if(socialInsuranceOfShenzhen2.attribute("treatResult")!=null){
										pyPcrCrsCrtSisz2.setTreatResult(
												conversionInt(socialInsuranceOfShenzhen2.attributeValue("treatResult")));
									}
									if (socialInsuranceOfShenzhen2.attribute("treatErrorCode") != null) {
										pyPcrCrsCrtSisz2.setTreatErrorCode(
												socialInsuranceOfShenzhen2.attributeValue("treatErrorCode"));
									}
									if(socialInsuranceOfShenzhen2.attribute("errorMessage")!=null){
										pyPcrCrsCrtSisz2
										.setErrorMessage(socialInsuranceOfShenzhen2.attributeValue("errorMessage"));
									}
									
									pyPcrCrsCrtSisz2.setAppId(appId);
									// 将结果放入总类
									pyCisReportCollection.setPyPcrCrsCrtSisz2(pyPcrCrsCrtSisz2);
									Element socialInsuranceOfShenzhen2Item = socialInsuranceOfShenzhen2.element("item");
									if (socialInsuranceOfShenzhen2Item != null) {
										// 节点-baseInfo
										Element baseInfo = socialInsuranceOfShenzhen2Item.element("baseInfo");
										if (baseInfo != null) {
											pyPcrCrsCrtSisz2Bi = new PyPcrCrsCrtSisz2Bi();
											pyPcrCrsCrtSisz2Bi.setTrnId(trnId);
											pyPcrCrsCrtSisz2Bi.setCrtUser(CRT_USER);
											pyPcrCrsCrtSisz2Bi.setName(baseInfo.elementText("name"));
											pyPcrCrsCrtSisz2Bi.setDocumentNo(baseInfo.elementText("documentNo"));
											pyPcrCrsCrtSisz2Bi.setGender(baseInfo.elementText("gender"));
											pyPcrCrsCrtSisz2Bi
													.setRegisteredStatus(baseInfo.elementText("registeredStatus"));
											pyPcrCrsCrtSisz2Bi.setInsuranceNo(baseInfo.elementText("insuranceNo"));
											pyPcrCrsCrtSisz2Bi.setCurrentStatus(baseInfo.elementText("currentStatus"));
											pyPcrCrsCrtSisz2Bi.setStartDate(baseInfo.elementText("startDate"));
											pyPcrCrsCrtSisz2Bi
													.setInsurePay(conversionDouble(baseInfo.elementText("insurePay")));
											pyPcrCrsCrtSisz2Bi.setFactInsurePay(
													conversionDouble(baseInfo.elementText("factInsurePay")));
											pyPcrCrsCrtSisz2Bi.setLastUnitName(baseInfo.elementText("lastUnitName"));
											pyPcrCrsCrtSisz2Bi.setUnitType(baseInfo.elementText("unitType"));
											pyPcrCrsCrtSisz2Bi.setUnitPersonCount(
													conversionInt(baseInfo.elementText("unitPersonCount")));
											pyPcrCrsCrtSisz2Bi.setPluralityCount(
													conversionInt(baseInfo.elementText("pluralityCount")));
											pyPcrCrsCrtSisz2Bi
													.setEndowmentState(baseInfo.elementText("endowmentState"));
											pyPcrCrsCrtSisz2Bi.setHospitalState(baseInfo.elementText("hospitalState"));
											pyPcrCrsCrtSisz2Bi
													.setHospitalCategory(baseInfo.elementText("hospitalCategory"));
											pyPcrCrsCrtSisz2Bi.setBearingState(baseInfo.elementText("bearingState"));
											pyPcrCrsCrtSisz2Bi.setInjureState(baseInfo.elementText("injureState"));
											pyPcrCrsCrtSisz2Bi.setIdlenessState(baseInfo.elementText("idlenessState"));
											pyPcrCrsCrtSisz2Bi.setEndowmentAmount(
													conversionDouble(baseInfo.elementText("endowmentAmount")));
											pyPcrCrsCrtSisz2Bi.setHospitalAmount(
													conversionDouble(baseInfo.elementText("hospitalAmount")));
											pyPcrCrsCrtSisz2Bi.setInfoDate(baseInfo.elementText("infoDate"));
											pyPcrCrsCrtSisz2Bi.setAppId(appId);
											// 将结果放入总类
											pyCisReportCollection.setPyPcrCrsCrtSisz2Bi(pyPcrCrsCrtSisz2Bi);
										}
										// 节点-pluralityUnitInfo
										Element pluralityUnitInfo = socialInsuranceOfShenzhen2Item
												.element("pluralityUnitInfo");
										if (pluralityUnitInfo != null) {
											List<Element> pluralityUnitInfoList = pluralityUnitInfo.elements("item");
											if (pluralityUnitInfoList != null && pluralityUnitInfoList.size() > 0) {
												for (Element pluralityUnitInfoItem : pluralityUnitInfoList) {
													PyPcrCrsCrtSisz2Pui pyPcrCrsCrtSisz2Pui = new PyPcrCrsCrtSisz2Pui();
													pyPcrCrsCrtSisz2Pui.setTrnId(trnId);
													pyPcrCrsCrtSisz2Pui.setCrtUser(CRT_USER);
													pyPcrCrsCrtSisz2Pui
															.setUnitName(pluralityUnitInfoItem.elementText("unitName"));
													pyPcrCrsCrtSisz2Pui
															.setUnitType(pluralityUnitInfoItem.elementText("unitType"));
													pyPcrCrsCrtSisz2Pui
															.setInfoDate(pluralityUnitInfoItem.elementText("infoDate"));
													pyPcrCrsCrtSisz2Pui.setAppId(appId);
													pyPcrCrsCrtSisz2PuiList.add(pyPcrCrsCrtSisz2Pui);
												}
												// 将结果放入总类
												pyCisReportCollection
														.setPyPcrCrsCrtSisz2PuiList(pyPcrCrsCrtSisz2PuiList);
											}

										}
										// 节点-historyInfo5Year
										Element historyInfo5Year = socialInsuranceOfShenzhen2Item
												.element("historyInfo5Year");
										if (historyInfo5Year != null) {
											List<Element> historyInfo5YearList = historyInfo5Year.elements("item");
											String infoDate = historyInfo5Year.attributeValue("infoDate");
											if (historyInfo5YearList != null && historyInfo5YearList.size() > 0) {
												for (Element historyInfo5YearItem : historyInfo5YearList) {
													PyPcrCrsCrtSisz2Hi5y pyPcrCrsCrtSisz2Hi5y = new PyPcrCrsCrtSisz2Hi5y();
													pyPcrCrsCrtSisz2Hi5y.setTrnId(trnId);
													pyPcrCrsCrtSisz2Hi5y.setCrtUser(CRT_USER);
													pyPcrCrsCrtSisz2Hi5y.setInfoDate(infoDate);
													pyPcrCrsCrtSisz2Hi5y
															.setUnitName(historyInfo5YearItem.elementText("unitName"));
													pyPcrCrsCrtSisz2Hi5y
															.setUnitType(historyInfo5YearItem.elementText("unitType"));
													pyPcrCrsCrtSisz2Hi5y.setInsuranceType(
															historyInfo5YearItem.elementText("insuranceType"));
													pyPcrCrsCrtSisz2Hi5y.setStartDate(
															historyInfo5YearItem.elementText("startDate"));
													pyPcrCrsCrtSisz2Hi5y
															.setEndDate(historyInfo5YearItem.elementText("endDate"));
													pyPcrCrsCrtSisz2Hi5y.setInsuranceState(
															historyInfo5YearItem.elementText("insuranceState"));
													pyPcrCrsCrtSisz2Hi5y.setAppId(appId);
													pyPcrCrsCrtSisz2Hi5yList.add(pyPcrCrsCrtSisz2Hi5y);
												}
												// 将结果放入总类
												pyCisReportCollection
														.setPyPcrCrsCrtSisz2Hi5yList(pyPcrCrsCrtSisz2Hi5yList);
											}
										}

										// 节点-summaryInfo5Year
										Element summaryInfo5Year = socialInsuranceOfShenzhen2Item
												.element("summaryInfo5Year");
										if (summaryInfo5Year != null) {
											pyPcrCrsCrtSisz2Si5y = new PyPcrCrsCrtSisz2Si5y();
											pyPcrCrsCrtSisz2Si5y.setTrnId(trnId);
											pyPcrCrsCrtSisz2Si5y.setCrtUser(CRT_USER);
											pyPcrCrsCrtSisz2Si5y.setTimesRecently12Months(conversionInt(
													summaryInfo5Year.elementText("timesRecently12Months")));
											pyPcrCrsCrtSisz2Si5y.setTimesRecently24Months(conversionInt(
													summaryInfo5Year.elementText("timesRecently24Months")));
											pyPcrCrsCrtSisz2Si5y.setTimesRecently36Months(conversionInt(
													summaryInfo5Year.elementText("timesRecently36Months")));
											pyPcrCrsCrtSisz2Si5y.setTimesRecently48Months(conversionInt(
													summaryInfo5Year.elementText("timesRecently48Months")));
											pyPcrCrsCrtSisz2Si5y.setTimesRecently60Months(conversionInt(
													summaryInfo5Year.elementText("timesRecently60Months")));
											pyPcrCrsCrtSisz2Si5y.setStRecently60Months(conversionInt(
													summaryInfo5Year.elementText("seriesTimesRecently60Months")));
											pyPcrCrsCrtSisz2Si5y.setUcRecently60Months(conversionInt(
													summaryInfo5Year.elementText("unitCountRecently60Months")));
											pyPcrCrsCrtSisz2Si5y.setAppId(appId);
											// 将结果放入总类
											pyCisReportCollection.setPyPcrCrsCrtSisz2Si5y(pyPcrCrsCrtSisz2Si5y);
										}

									}

								}
								// 特别信息
								Element specialInfo = e.element("specialInfo");
								if (specialInfo != null) {
									

									pyPcrCrsCrtSi = new PyPcrCrsCrtSi();
									pyPcrCrsCrtSi.setTrnId(trnId);
									pyPcrCrsCrtSi.setCrtUser(CRT_USER);
									if(specialInfo.attribute("subReportType")!=null){
										pyPcrCrsCrtSi.setSubReportType(
												conversionInt(specialInfo.attributeValue("subReportType")));
									}
									
									if(specialInfo.attribute("subReportTypeCost")!=null){
										pyPcrCrsCrtSi.setSubReportTypeCost(
												conversionInt(specialInfo.attributeValue("subReportTypeCost")));
									}
									
									if(specialInfo.attribute("treatResult")!=null){
										pyPcrCrsCrtSi
										.setTreatResult(conversionInt(specialInfo.attributeValue("treatResult")));
									}
									
									if (specialInfo.attribute("treatErrorCode") != null) {
										pyPcrCrsCrtSi.setTreatErrorCode(specialInfo.attributeValue("treatErrorCode"));
									}
									if(specialInfo.attribute("errorMessage")!=null){
										pyPcrCrsCrtSi.setErrorMessage(specialInfo.attributeValue("errorMessage"));
									}
									
									pyPcrCrsCrtSi.setAppId(appId);
									// 将结果放入总类
									pyCisReportCollection.setPyPcrCrsCrtSi(pyPcrCrsCrtSi);
									// 内容节点
									List<Element> specialInfoList = specialInfo.elements("item");
									if (specialInfoList != null && specialInfoList.size() > 0) {
										for (Element specialInfoItem : specialInfoList) {
											PyPcrCrsCrtSiItm pyPcrCrsCrtSiItm = new PyPcrCrsCrtSiItm();
											pyPcrCrsCrtSiItm.setTrnId(trnId);
											pyPcrCrsCrtSiItm.setCrtUser(CRT_USER);
											pyPcrCrsCrtSiItm.setInfoType(
													conversionInt(specialInfoItem.attributeValue("infoType")));
											pyPcrCrsCrtSiItm.setInfoUnit(specialInfoItem.elementText("infoUnit"));
											pyPcrCrsCrtSiItm
													.setInfoDepartment(specialInfoItem.elementText("infoDepartment"));
											pyPcrCrsCrtSiItm.setOccurDate(specialInfoItem.elementText("occurDate"));
											pyPcrCrsCrtSiItm.setContent(specialInfoItem.elementText("content"));
											pyPcrCrsCrtSiItm.setInfoDate(specialInfoItem.elementText("infoDate"));
											pyPcrCrsCrtSiItm.setAppId(appId);
											PyPcrCrsCrtSiItmList.add(pyPcrCrsCrtSiItm);

										}
										// 将结果放入总类
										pyCisReportCollection.setPyPcrCrsCrtSiItmList(PyPcrCrsCrtSiItmList);
									}

								}
								// 身份证号码校验信息
								Element identityVerifyInfo = e.element("identityVerifyInfo");
								if (identityVerifyInfo != null) {
									pyPcrCrsCrtIvi = new PyPcrCrsCrtIvi();
									pyPcrCrsCrtIvi.setTrnId(trnId);
									pyPcrCrsCrtIvi.setCrtUser(CRT_USER);
									if(identityVerifyInfo.attribute("subReportType")!=null){
										pyPcrCrsCrtIvi.setSubReportType(
												conversionInt(identityVerifyInfo.attributeValue("subReportType")));
									}
									
									if(identityVerifyInfo.attribute("subReportTypeCost")!=null){
										pyPcrCrsCrtIvi.setSubReportTypeCost(
												conversionInt(identityVerifyInfo.attributeValue("subReportTypeCost")));
									}
									
									if(identityVerifyInfo.attribute("treatResult")!=null){
										pyPcrCrsCrtIvi.setTreatResult(
												conversionInt(identityVerifyInfo.attributeValue("treatResult")));
									}
									
									if (identityVerifyInfo.attribute("treatErrorCode") != null) {
										pyPcrCrsCrtIvi
												.setTreatErrorCode(identityVerifyInfo.attributeValue("treatErrorCode"));
									}
									if(identityVerifyInfo.attribute("errorMessage")!=null){
										pyPcrCrsCrtIvi.setErrorMessage(identityVerifyInfo.attributeValue("errorMessage"));
									}
									
									pyPcrCrsCrtIvi.setAppId(appId);
									// 将结果放入总类
									pyCisReportCollection.setPyPcrCrsCrtIvi(pyPcrCrsCrtIvi);
									// 内容节点
									Element identityVerifyInfoItem = identityVerifyInfo.element("item");
									if (identityVerifyInfoItem != null) {
										pyPcrCrsCrtIviItm = new PyPcrCrsCrtIviItm();
										pyPcrCrsCrtIviItm.setTrnId(trnId);
										pyPcrCrsCrtIviItm.setCrtUser(CRT_USER);
										pyPcrCrsCrtIviItm
												.setDocumentNo(identityVerifyInfoItem.elementText("documentNo"));
										pyPcrCrsCrtIviItm.setBirthday(identityVerifyInfoItem.elementText("birthday"));
										pyPcrCrsCrtIviItm.setGender(identityVerifyInfoItem.elementText("gender"));
										pyPcrCrsCrtIviItm.setOriginalAddress(
												identityVerifyInfoItem.elementText("originalAddress"));
										pyPcrCrsCrtIviItm.setVerifyOfParity(
												identityVerifyInfoItem.elementText("verifyOfParity"));
										pyPcrCrsCrtIviItm
												.setVerifyOfArea(identityVerifyInfoItem.elementText("verifyOfArea"));
										pyPcrCrsCrtIviItm.setVerifyOfBirthday(
												identityVerifyInfoItem.elementText("verifyOfBirthday"));
										pyPcrCrsCrtIviItm
												.setIs18Indentify(identityVerifyInfoItem.elementText("is18Identify"));
										pyPcrCrsCrtIviItm
												.setVerifyResult(identityVerifyInfoItem.elementText("verifyResult"));
										pyPcrCrsCrtIviItm.setAppId(appId); // 将结果放入总类
										pyCisReportCollection.setPyPcrCrsCrtIviItm(pyPcrCrsCrtIviItm);
									}
								}
								// 深圳基本摘要信息
								Element szBaseSummaryInfo = e.element("szBaseSummaryInfo");
								if (szBaseSummaryInfo != null) {
									pyPcrCrsCrtSzbsi = new PyPcrCrsCrtSzbsi();
									pyPcrCrsCrtSzbsi.setTrnId(trnId);
									pyPcrCrsCrtSzbsi.setCrtUser(CRT_USER);
									if(szBaseSummaryInfo.attribute("subReportType")!=null){
										pyPcrCrsCrtSzbsi.setSubReportType(
												conversionInt(szBaseSummaryInfo.attributeValue("subReportType")));
									}
									
									if(szBaseSummaryInfo.attribute("subReportTypeCost")!=null){
										pyPcrCrsCrtSzbsi.setSubReportTypeCost(
												conversionInt(szBaseSummaryInfo.attributeValue("subReportTypeCost")));
									}
									
									if(szBaseSummaryInfo.attribute("treatResult")!=null){
										pyPcrCrsCrtSzbsi.setTreatResult(
												conversionInt(szBaseSummaryInfo.attributeValue("treatResult")));
									}
									
									if (szBaseSummaryInfo.attribute("treatErrorCode") != null) {
										pyPcrCrsCrtSzbsi
												.setTreatErrorCode(szBaseSummaryInfo.attributeValue("treatErrorCode"));
									}
									if(szBaseSummaryInfo.attribute("errorMessage")!=null){
										pyPcrCrsCrtSzbsi.setErrorMessage(szBaseSummaryInfo.attributeValue("errorMessage"));
									}
									
									pyPcrCrsCrtSzbsi.setAppId(appId);
									// 将结果放入总类
									pyCisReportCollection.setPyPcrCrsCrtSzbsi(pyPcrCrsCrtSzbsi);
									// 节点-baseSummary
									Element baseSummary = szBaseSummaryInfo.element("baseSummary");
									if (baseSummary != null) {
										pyPcrCrsCrtSzbsiBss = new PyPcrCrsCrtSzbsiBss();
										pyPcrCrsCrtSzbsiBss.setTrnId(trnId);
										pyPcrCrsCrtSzbsiBss.setCrtUser(CRT_USER);
										pyPcrCrsCrtSzbsiBss.setHistoryNameCount(
												conversionInt(baseSummary.elementText("historyNameCount")));
										pyPcrCrsCrtSzbsiBss.setDocumentAlertCount(
												conversionInt(baseSummary.elementText("documentAlertCount")));
										pyPcrCrsCrtSzbsiBss.setQueryReportCount(
												conversionInt(baseSummary.elementText("queryReportCount")));
										pyPcrCrsCrtSzbsiBss.setAppId(appId);
										if (pyPcrCrsCrtSzbsiBss.getHistoryNameCount() != null
												|| pyPcrCrsCrtSzbsiBss.getDocumentAlertCount() != null
												|| pyPcrCrsCrtSzbsiBss.getQueryReportCount() != null) {
											// 将结果放入总类
											pyCisReportCollection.setPyPcrCrsCrtSzbsiBss(pyPcrCrsCrtSzbsiBss);
										}

									}
									// 节点-bankSummary
									Element bankSummary = szBaseSummaryInfo.element("bankSummary");
									if (bankSummary != null) {
										pyPcrCrsCrtSzbsiBks = new PyPcrCrsCrtSzbsiBks();
										pyPcrCrsCrtSzbsiBks.setTrnId(trnId);
										pyPcrCrsCrtSzbsiBks.setCrtUser(CRT_USER);
										pyPcrCrsCrtSzbsiBks
												.setLoanCount(conversionInt(bankSummary.elementText("loanCount")));
										pyPcrCrsCrtSzbsiBks.setLoanNotSquareCount(
												conversionInt(bankSummary.elementText("loanNotSquareCount")));
										pyPcrCrsCrtSzbsiBks
												.setLoanAmount(conversionDouble(bankSummary.elementText("loanAmount")));
										pyPcrCrsCrtSzbsiBks.setLoanBalanceAmount(
												conversionDouble(bankSummary.elementText("loanBalanceAmount")));
										pyPcrCrsCrtSzbsiBks.setLoanArrearAmount(
												conversionDouble(bankSummary.elementText("loanArrearAmount")));
										pyPcrCrsCrtSzbsiBks.setLoanHistoryArrearTimes(
												conversionInt(bankSummary.elementText("loanHistoryArrearTimes")));
										pyPcrCrsCrtSzbsiBks.setCreditcardCount(
												conversionInt(bankSummary.elementText("creditcardCount")));
										pyPcrCrsCrtSzbsiBks.setCreditcardUsingCount(
												conversionInt(bankSummary.elementText("creditcardUsingCount")));
										pyPcrCrsCrtSzbsiBks.setCpOverdraftAmount(conversionDouble(
												bankSummary.elementText("creditcardPermittedOverdraftAmount")));
										pyPcrCrsCrtSzbsiBks.setCreditcardOverdraftAmount(
												conversionDouble(bankSummary.elementText("creditcardOverdraftAmount")));
										pyPcrCrsCrtSzbsiBks
												.setCreditcardFirstOpen(bankSummary.elementText("creditcardFirstOpen"));
										pyPcrCrsCrtSzbsiBks.setAppId(appId);
										// 将结果放入总类
										pyCisReportCollection.setPyPcrCrsCrtSzbsiBks(pyPcrCrsCrtSzbsiBks);

									}
									// 节点-insureSummary
									Element insureSummary = szBaseSummaryInfo.element("insureSummary");
									if (insureSummary != null) {
										pyPcrCrsCrtSzbsiIs = new PyPcrCrsCrtSzbsiIs();
										pyPcrCrsCrtSzbsiIs.setTrnId(trnId);
										pyPcrCrsCrtSzbsiIs.setCrtUser(CRT_USER);
										pyPcrCrsCrtSzbsiIs
												.setInsurePay(conversionDouble(insureSummary.elementText("insurePay")));
										pyPcrCrsCrtSzbsiIs.setFactInsurePay(
												conversionDouble(insureSummary.elementText("factInsurePay")));
										pyPcrCrsCrtSzbsiIs.setCurrentStatus(insureSummary.elementText("currentStatus"));
										pyPcrCrsCrtSzbsiIs.setInfoDate(insureSummary.elementText("infoDate"));
										pyPcrCrsCrtSzbsiIs.setLastUnitName(insureSummary.elementText("lastUnitName"));
										pyPcrCrsCrtSzbsiIs.setAppId(appId);
										if (pyPcrCrsCrtSzbsiIs.getInsurePay() != null
												|| pyPcrCrsCrtSzbsiIs.getFactInsurePay() != null
												|| pyPcrCrsCrtSzbsiIs.getCurrentStatus() != null
												|| pyPcrCrsCrtSzbsiIs.getInfoDate() != null
												|| pyPcrCrsCrtSzbsiIs.getLastUnitName() != null) {
											// 将结果放入总类
											pyCisReportCollection.setPyPcrCrsCrtSzbsiIs(pyPcrCrsCrtSzbsiIs);
										}

									}
									// 节点-scoreSummary
									Element scoreSummary = szBaseSummaryInfo.element("scoreSummary");
									if (scoreSummary != null) {
										pyPcrCrsCrtSzbsiSs = new PyPcrCrsCrtSzbsiSs();
										pyPcrCrsCrtSzbsiSs.setTrnId(trnId);
										pyPcrCrsCrtSzbsiSs.setCrtUser(CRT_USER);
										pyPcrCrsCrtSzbsiSs.setScore(conversionInt(scoreSummary.elementText("score")));
										pyPcrCrsCrtSzbsiSs.setScoringDate(scoreSummary.elementText("scoringDate"));
										pyPcrCrsCrtSzbsiSs.setAppId(appId);
										// 将结果放入总类
										pyCisReportCollection.setPyPcrCrsCrtSzbsiSs(pyPcrCrsCrtSzbsiSs);
									}
									// 节点-telSummary
									Element telSummary = szBaseSummaryInfo.element("telSummary");
									if (telSummary != null) {
										pyPcrCrsCrtSzbsiTs = new PyPcrCrsCrtSzbsiTs();
										pyPcrCrsCrtSzbsiTs.setTrnId(trnId);
										pyPcrCrsCrtSzbsiTs.setCrtUser(CRT_USER);
										pyPcrCrsCrtSzbsiTs.setIsOweFee(telSummary.elementText("isOweFee"));
										pyPcrCrsCrtSzbsiTs.setInfoDate(telSummary.elementText("infoDate"));
										pyPcrCrsCrtSzbsiTs.setAppId(appId);
										// 将结果放入总类
										pyCisReportCollection.setPyPcrCrsCrtSzbsiTs(pyPcrCrsCrtSzbsiTs);
									}
								}
								// 近两年历史查询记录
								Element historyQueryInfo = e.element("historyQueryInfo");
								if (historyQueryInfo != null) {
									pyPcrCrsCrtHqi = new PyPcrCrsCrtHqi();
									pyPcrCrsCrtHqi.setTrnId(trnId);
									pyPcrCrsCrtHqi.setCrtUser(CRT_USER);
									if(historyQueryInfo.attribute("subReportType")!=null){
										pyPcrCrsCrtHqi.setSubReportType(
												conversionInt(historyQueryInfo.attributeValue("subReportType")));
									}
									
									if(historyQueryInfo.attribute("subReportTypeCost")!=null){
										pyPcrCrsCrtHqi.setSubReportTypeCost(
												conversionInt(historyQueryInfo.attributeValue("subReportTypeCost")));
									}
									
									if(historyQueryInfo.attribute("treatResult")!=null){
										pyPcrCrsCrtHqi.setTreatResult(
												conversionInt(historyQueryInfo.attributeValue("treatResult")));
									}
									
									if (historyQueryInfo.attribute("treatErrorCode") != null) {
										pyPcrCrsCrtHqi
												.setTreatErrorCode(historyQueryInfo.attributeValue("treatErrorCode"));
									}
									if(historyQueryInfo.attribute("errorMessage")!=null){
										pyPcrCrsCrtHqi.setErrorMessage(historyQueryInfo.attributeValue("errorMessage"));
									}
									pyPcrCrsCrtHqi.setAppId(appId);
									// 将结果放入总类
									pyCisReportCollection.setPyPcrCrsCrtHqi(pyPcrCrsCrtHqi);
									// 内容节点
									List<Element> historyQueryInfoList = historyQueryInfo.elements("item");
									if (historyQueryInfoList != null && historyQueryInfoList.size() > 0) {
										
										for (Element historyQueryInfoItem : historyQueryInfoList) {
											PyPcrCrsCrtHqiItm pyPcrCrsCrtHqiItm = new PyPcrCrsCrtHqiItm();
											pyPcrCrsCrtHqiItm.setTrnId(trnId);
											pyPcrCrsCrtHqiItm.setCrtUser(CRT_USER);
											pyPcrCrsCrtHqiItm
													.setUnit(conversionInt(historyQueryInfoItem.elementText("unit")));
											pyPcrCrsCrtHqiItm.setQueryReason(
													conversionInt(historyQueryInfoItem.elementText("queryReason")));
											pyPcrCrsCrtHqiItm.setUnitMemberId(
													conversionInt(historyQueryInfoItem.elementText("unitMemberID")));
											pyPcrCrsCrtHqiItm
													.setUnitMember(historyQueryInfoItem.elementText("unitMember"));
											pyPcrCrsCrtHqiItm
													.setQueryDate(historyQueryInfoItem.elementText("queryDate"));
											pyPcrCrsCrtHqiItm.setAppId(appId);
											pyPcrCrsCrtHqiItmList.add(pyPcrCrsCrtHqiItm);
										}
										// 将结果放入总类
										pyCisReportCollection.setPyPcrCrsCrtHqiItmList(pyPcrCrsCrtHqiItmList);
									}
								}
								pyCisReportCollectionList.add(pyCisReportCollection);
							}

							pyPcrTenReponse.setPyCisReportCollectionList(pyCisReportCollectionList);
						}

					}
				}
			}
			return pyPcrTenReponse;
		}
		return null;
	}

	public static Integer conversionInt(String intStr) {
		if (StringUtils.isNotBlank(intStr)) {
			try {
				return Integer.parseInt(intStr);
			} catch (Exception e) {
				logger.warn("[区域数据-深圳-个人信用] XML报文解析,字符串转Integer异常！  intStr={}", intStr);
				return null;
			}
		}
		logger.warn("[区域数据-深圳-个人信用] XML报文解析,字符串转Integer异常！  intStr={}", intStr);
		return null;
	}

	public static Double conversionDouble(String doubleStr) {
		if (StringUtils.isNotBlank(doubleStr)) {
			try {
				return Double.parseDouble(doubleStr);
			} catch (Exception e) {
				logger.warn("[区域数据-深圳-个人信用] XML报文解析,字符串转Double异常！  doubleStr={}", doubleStr);
				return null;
			}
		}
		logger.warn("[区域数据-深圳-个人信用] XML报文解析,字符串转Double异常！  doubleStr={}", doubleStr);
		return null;

	}

	/**
	 * 测试
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {/*
		String repString = IOUtils.toString(new FileInputStream("d:/pwsl.xml"), "GBK");
		PyPcrTenReponse testReponse = readStringXml(repString, "122222", "appId");
		System.out.println("鹏元个人信用报告表");
		System.out.println(testReponse.getPyPcrCrs().toString());
		for (PyCisReportCollection crc : testReponse.getPyCisReportCollectionList()) {
			System.out.println("**********************************************************************************");
			System.out.println("鹏元个人信用报告报告表");
			System.out.println(crc.getPyPcrCrsCrt().toString());
			System.out.println("鹏元个人信用报告查询条件表");
			for (PyPcrCrsCrtQcs p : crc.getPyPcrCrsCrtQcsList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告个人基本信息表");
			System.out.println(crc.getPyPcrCrsCrtPbi().toString());
			System.out.println("鹏元个人信用报告摘要信息表");
			System.out.println(crc.getPyPcrCrsCrtPbiSi().toString());
			System.out.println("鹏元个人信用报告最新基本信息表");
			System.out.println(crc.getPyPcrCrsCrtPbiLbi().toString());
			System.out.println("鹏元个人信用报告证件信息表");
			for (PyPcrCrsCrtPbiDis p : crc.getPyPcrCrsCrtPbiDisList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告地址信息表");
			for (PyPcrCrsCrtPbiAis p : crc.getPyPcrCrsCrtPbiAisList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告历次任职信息表");
			for (PyPcrCrsCrtPbiJis p : crc.getPyPcrCrsCrtPbiJisList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告曾用名信息表");
			for (PyPcrCrsCrtPbiHnis p : crc.getPyPcrCrsCrtPbiHnisList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告身份警示信息表");
			for (PyPcrCrsCrtPbiDa p : crc.getPyPcrCrsCrtPbiDaList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告银行信用信息表");
			System.out.println(crc.getPyPcrCrsCrtBdi().toString());
			System.out.println("鹏元个人信用报告贷款信息账户基本信息表");
			for (PyCrsCrtBdiCisAbi p : crc.getPyCrsCrtBdiCisAbiList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告银行信用信息信用卡账户动态信息表");
			for (PyPcrCrsCrtBdiCisAci p : crc.getPyPcrCrsCrtBdiCisAciList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告银行信用信息信用卡状态变动记录表");
			for (PyPcrCrsCrtBdiCisHs p : crc.getPyPcrCrsCrtBdiCisHsList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告银行信用信息信用卡最近12个月的月透支余额表");
			for (PyPcrCrsCrtBdiCisO12m p : crc.getPyPcrCrsCrtBdiCisO12mList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告银行信用信息信用卡最近12个月的月消费金额表");
			for (PyPcrCrsCrtBdiCisPp12m p : crc.getPyPcrCrsCrtBdiCisPp12mList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告银行信用信息信用卡最近12个月的月消费次数表");
			for (PyPcrCrsCrtBdiCisPt12m p : crc.getPyPcrCrsCrtBdiCisPt12mList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告银行信用信息信用卡最近12个月的月取现金额表");
			for (PyPcrCrsCrtBdiCisWa12m p : crc.getPyPcrCrsCrtBdiCisWa12mList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告银行信用信息信用卡最近12个月的月取现次数表");
			for (PyPcrCrsCrtBdiCisWt12m p : crc.getPyPcrCrsCrtBdiCisWt12mList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告贷款信息共同贷款人信息表");
			for (PyPcrCrsCrtBdiLisBs p : crc.getPyPcrCrsCrtBdiLisBsList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告贷款信息账户基本信息表");
			for (PyPcrCrsCrtBdiLisAbi p : crc.getPyPcrCrsCrtBdiLisAbiList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告贷款信息账户动态信息表");
			for (PyPcrCrsCrtBdiLisAci p : crc.getPyPcrCrsCrtBdiLisAciList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告贷款信息最近24月还款情况表");
			for (PyPcrCrsCrtBdiLisPl24m p : crc.getPyPcrCrsCrtBdiLisPl24mList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告贷款信息贷款账户状态变动记录表");
			for (PyPcrCrsCrtBdiLisHs p : crc.getPyPcrCrsCrtBdiLisHsList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告银行概要信息表");
			System.out.println(crc.getPyCrsCrtBsi().toString());
			System.out.println("鹏元个人信用报告个人社会保险信息表");
			System.out.println(crc.getPyPcrCrsCrtSisz2().toString());
			System.out.println("鹏元个人信用报告个人社会保险个人基本信息表");
			System.out.println(crc.getPyPcrCrsCrtSisz2Bi().toString());
			System.out.println("鹏元个人信用报告个人社会保险兼职单位信息");
			for (PyPcrCrsCrtSisz2Pui p : crc.getPyPcrCrsCrtSisz2PuiList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告个人社会保险近5年内参保历史信息表");
			for (PyPcrCrsCrtSisz2Hi5y p : crc.getPyPcrCrsCrtSisz2Hi5yList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告个人社会保险近5年内参保信息汇总表");
			System.out.println(crc.getPyPcrCrsCrtSisz2Si5y().toString());
			System.out.println("鹏元个人信用报告特别信息表");
			System.out.println(crc.getPyPcrCrsCrtSi().toString());
			System.out.println("鹏元个人信用报告特别信息内容表");
			for (PyPcrCrsCrtSiItm p : crc.getPyPcrCrsCrtSiItmList()) {
				System.out.println(p.toString());
			}
			System.out.println("鹏元个人信用报告身份证号码校验信息表");
			System.out.println(crc.getPyPcrCrsCrtIvi().toString());
			System.out.println("鹏元个人信用报告身份证号码校验信息内容表");
			System.out.println(crc.getPyPcrCrsCrtIviItm().toString());
			System.out.println("鹏元个人信用报告深圳基本摘要信息表");
			System.out.println(crc.getPyPcrCrsCrtSzbsi().toString());
			System.out.println("鹏元个人信用报告深圳基本摘要信息基本信息表");
			System.out.println(crc.getPyPcrCrsCrtSzbsiBss().toString());
			System.out.println("鹏元个人信用报告深圳基本摘要信息银行信息表");
			System.out.println(crc.getPyPcrCrsCrtSzbsiBks().toString());
			System.out.println("鹏元个人信用报告深圳基本摘要信息社保信息表");
			System.out.println(crc.getPyPcrCrsCrtSzbsiIs().toString());
			System.out.println("鹏元个人信用报告深圳基本摘要信息评分信息表");
			System.out.println(crc.getPyPcrCrsCrtSzbsiSs().toString());
			System.out.println("鹏元个人信用报告深圳基本摘要信息电话欠费信息表");
			System.out.println(crc.getPyPcrCrsCrtSzbsiTs().toString());
			System.out.println("鹏元个人信用报告近两年历史查询明细表");
			System.out.println(crc.getPyPcrCrsCrtHqi().toString());
			System.out.println("鹏元个人信用报告近两年历史查询明细内容表");
			for (PyPcrCrsCrtHqiItm p : crc.getPyPcrCrsCrtHqiItmList()) {
				System.out.println(p.toString());
			}
		}
	*/}

}
