package com.huaxia.plaze.modules.hz.webservice;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.codehaus.xfire.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.hz.domain.Data;
import com.huaxia.plaze.modules.hz.domain.HzCollection;
import com.huaxia.plaze.modules.hz.domain.HzMsgResponse;
import com.huaxia.plaze.modules.hz.domain.HzTrnRequest;
import com.huaxia.plaze.modules.hz.domain.data.EnterpriseInfo;
import com.huaxia.plaze.modules.hz.domain.data.FyNaturalPerson;
import com.huaxia.plaze.modules.hz.domain.data.GjjLoanInfo;
import com.huaxia.plaze.modules.hz.domain.data.Gjjxx;
import com.huaxia.plaze.modules.hz.domain.data.Grxx;
import com.huaxia.plaze.modules.hz.domain.data.MarryInfo;
import com.huaxia.plaze.modules.hz.domain.data.RsjZxAc01;
import com.huaxia.plaze.modules.hz.domain.data.SbFeeinfogrid;
import com.huaxia.plaze.modules.hz.domain.data.VehicleInfo;
import com.huaxia.plaze.modules.hz.domain.data.VehiclePenaltyInfo;
import com.huaxia.plaze.modules.hz.domain.data.WaterAffairsInfo;
import com.huaxia.plaze.modules.hz.service.HzService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
public class HzDealDataAdapter {
	
	private final static Logger logger = LoggerFactory.getLogger(HzDealDataAdapter.class);
	
	@Resource
	private HzService hzService;
	
	public String dealHzData(String jsonRequest){
		
		/** 接收渠道(包括审批,PAD)传过来的请求参数,分解成各变量 */
		String requestChannel = "";
		String trnId          = "";
		String trnCode        = "";
		String queryMode      = "";
		String certType       = "";
		String certNo         = "";
		String name           = "";
		String mobile         = "";
		
		JSONObject jsonObject = JSONObject.fromObject(jsonRequest);
		if (jsonObject != null) {
			if (jsonObject.containsKey("REQUEST") && jsonObject.getString("REQUEST") != null
					&& !"".equals(jsonObject.getString("REQUEST"))) {
				JSONObject jsonRequet = JSONObject.fromObject(jsonObject.getString("REQUEST"));
				if (jsonRequet.containsKey("HEAD") && jsonRequet.getString("HEAD") != null
						&& !"".equals(jsonRequet.getString("HEAD"))) {
					JSONObject jsonHead = JSONObject.fromObject(jsonRequet.getString("HEAD"));
					if (jsonHead.containsKey("REQUEST_CHANNEL") && jsonHead.getString("REQUEST_CHANNEL") != null
							&& !"".equals(jsonHead.getString("REQUEST_CHANNEL"))) {
						requestChannel = jsonHead.getString("REQUEST_CHANNEL");
					}
					if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
							&& !"".equals(jsonHead.getString("TRN_ID"))) {
						trnId = jsonHead.getString("TRN_ID");
					}
					if (jsonHead.containsKey("TRN_CODE") && jsonHead.getString("TRN_CODE") != null
							&& !"".equals(jsonHead.getString("TRN_CODE"))) {
						trnCode = jsonHead.getString("TRN_CODE");
					}
				}
				
				if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
						&& !"".equals(jsonRequet.getString("BODY"))) {
					JSONObject jsonBody = JSONObject.fromObject(jsonRequet.getString("BODY"));
					if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
							&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
						queryMode = jsonBody.getString("QUERY_MODE");
					}
					if (jsonBody.containsKey("CERT_TYPE") && jsonBody.getString("CERT_TYPE") != null
							&& !"".equals(jsonBody.getString("CERT_TYPE"))) {
						certType = jsonBody.getString("CERT_TYPE");
					}
					if (jsonBody.containsKey("CERT_NO") && jsonBody.getString("CERT_NO") != null
							&& !"".equals(jsonBody.getString("CERT_NO"))) {
						certNo = jsonBody.getString("CERT_NO");
					}
					if (jsonBody.containsKey("NAME") && jsonBody.getString("NAME") != null
							&& !"".equals(jsonBody.getString("NAME"))) {
						name = jsonBody.getString("NAME");
					}
					if (jsonBody.containsKey("MOBILE") && jsonBody.getString("MOBILE") != null
							&& !"".equals(jsonBody.getString("MOBILE"))) {
						mobile = jsonBody.getString("MOBILE");
					}
				}
			}
		}
		
		/** 将请求参数入库 */
		HzTrnRequest hzTrnRequest = new HzTrnRequest();
		hzTrnRequest.setCrtUser("PLAZE");
		hzTrnRequest.setTrnId(trnId);
		hzTrnRequest.setRequestChannel(requestChannel);
		hzTrnRequest.setQueryMode(queryMode);
		hzTrnRequest.setCertType(certType);
		hzTrnRequest.setCertNo(certNo);
		hzTrnRequest.setName(name);
		hzTrnRequest.setMobile(mobile);
		hzTrnRequest.setTrnCode(trnCode);
		hzService.saveHzTrnRequest(hzTrnRequest);
		
		try {
			String messageBody = hzService.finBody(certNo);
			if(StringUtils.isNotBlank(messageBody)){
				Map<String, Object> head = new HashMap<String, Object>();
				head.put("RESPONSE_CHANNEL", "PLAZE");
				head.put("TRN_ID", trnId);

				Map<String, Object> body = new HashMap<String, Object>();
				body.put("RESPONSE_CODE", "000000");
				body.put("RESPONSE_DESC", "处理成功");
				body.put("RESPONSE_BODY", messageBody);

				Map<String, Object> response = new HashMap<String, Object>();
				response.put("HEAD", head);
				response.put("BODY", body);

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("RESPONSE", response);

				JSONObject json = JSONObject.fromObject(params);
				return json.toString();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error("杭州区域数据查库失败",e1);
		}
		
		/** 调用dmz的webservice,发起三方请求 */
		Client client = null;
		String message = "";
		String responseCode = "";
		//作为返回报文
		String response = null;
		try{
			client = new Client(new URL(AppConfig.getInstance().getValue("hz.dmz.webservice.url")));
			
			Object[] obj = new Object[] { jsonObject.toString() };
			Object[] result = client.invoke("invoke", obj);
			
			if(result != null){
				JSONObject jsonResponse = JSONObject.fromObject(String.valueOf(result[0]));
				if (jsonResponse.containsKey("RESPONSE") && jsonResponse.getString("RESPONSE") != null
						&& !"".equals(jsonResponse.getString("RESPONSE"))) {
					JSONObject jsonRes = JSONObject.fromObject(jsonResponse.getString("RESPONSE"));
					if (jsonRes.containsKey("BODY") && jsonRes.getString("BODY") != null
							&& !"".equals(jsonRes.getString("BODY"))) {

						JSONObject jsonBody = JSONObject.fromObject(jsonRes.getString("BODY"));
						if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
								&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
							message = jsonBody.getString("RESPONSE_BODY");
						}
						if (jsonBody.containsKey("RESPONSE_CODE") && jsonBody.getString("RESPONSE_CODE") != null
								&& !"".equals(jsonBody.getString("RESPONSE_CODE"))) {
							responseCode = jsonBody.getString("RESPONSE_CODE");
						}
						
						//为return的String赋值
						response = String.valueOf(jsonResponse.toString());
						
						if("999999".equals(responseCode)){
							return String.valueOf(jsonResponse.toString());
						}
					}
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("杭州区域数据请求查询异常"+trnId, e);
		}
		try {
			/** 原始报文入库 */
			HzMsgResponse hzMsgResponse = new HzMsgResponse();
			hzMsgResponse.setCrtUser(requestChannel);
			hzMsgResponse.setTrnId(trnId);
			hzMsgResponse.setMessageBody(message);
			hzService.saveHzMsgResponse(hzMsgResponse);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("杭州区域数据原始报文入库异常"+trnId, e);
		}
		try {
			HzCollection hzCollection = parseHz(message,trnId,requestChannel);
			if("0000".equals(hzCollection.getCode())){
				hzCollection.setCertNo(certNo);
				hzCollection.setCrtUser(requestChannel);
				hzService.saveHzCollection(hzCollection);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("杭州区域数据报文入库异常"+trnId, e);
		}
		
		return response;
		
	}
	
	private HzCollection parseHz(String message,String trnId,String requestChannel){
		
		HzCollection hzCollection = new HzCollection();
		hzCollection.setTrnId(trnId);
		if(message != null && message != ""){
			JSONObject jsonMessage = JSONObject.fromObject(message);
			if(jsonMessage.containsKey("code")){
				hzCollection.setCode(jsonMessage.getString("code"));
			}
			if(jsonMessage.containsKey("msg")){
				hzCollection.setMsg(jsonMessage.getString("msg"));
			}
			if(jsonMessage.containsKey("orderNo")){
				hzCollection.setOrderNo(jsonMessage.getString("orderNo"));
			}
			if(jsonMessage.containsKey("data") && jsonMessage.getString("data") != null
					&& !"".equals(jsonMessage.getString("data"))){
				Data data = new Data();
				data.setTrnId(trnId);
				data.setCrtUser(requestChannel);
				JSONObject jsonData = JSONObject.fromObject(jsonMessage.getString("data"));
				if(jsonData.containsKey("pid")){
					data.setPid(jsonData.getString("pid"));
				}
				if(jsonData.containsKey("datastatus")){
					data.setDataStatus(jsonData.getString("datastatus"));
				}
				if(jsonData.containsKey("name")){
					data.setName(jsonData.getString("name"));
				}
				if(jsonData.containsKey("api_channel_type") && jsonData.getString("api_channel_type") != null
						&& !"".equals(jsonData.getString("api_channel_type"))){
					JSONObject jsonApiChannelType = JSONObject.fromObject(jsonData.getString("api_channel_type"));
					if(jsonApiChannelType.containsKey("szf0001")){
						data.setApiChannelType(jsonApiChannelType.getString("szf0001"));
					}
				}
				
				/** data标签下的数组格式 */
				
				/** 个人信息 */
				if(jsonData.containsKey("grxx") && jsonData.getJSONArray("grxx") != null){
					JSONArray jsonArrayGrxx = jsonData.getJSONArray("grxx");
					if(jsonArrayGrxx.size() > 0){
						List<Grxx> grxxs = new ArrayList<Grxx>();
						for(int i = 0;i<jsonArrayGrxx.size();i++){
							JSONObject jsonGrxx = jsonArrayGrxx.getJSONObject(i);
							Grxx grxx = new Grxx();
							grxx.setTrnId(trnId);
							grxx.setCrtUser(requestChannel);
							if(jsonGrxx.containsKey("xm")){
								grxx.setXm(jsonGrxx.getString("xm"));
							}
							if(jsonGrxx.containsKey("sfzh")){
								grxx.setSfzh(jsonGrxx.getString("sfzh"));
							}
							if(jsonGrxx.containsKey("xb")){
								grxx.setXb(jsonGrxx.getString("xb"));
							}
							if(jsonGrxx.containsKey("csrq")){
								grxx.setCsrq(jsonGrxx.getString("csrq"));
							}
							if(jsonGrxx.containsKey("mz")){
								grxx.setMz(jsonGrxx.getString("mz"));
							}
							if(jsonGrxx.containsKey("addr")){
								grxx.setAddr(jsonGrxx.getString("addr"));
							}
							if(jsonGrxx.containsKey("hksx")){
								grxx.setHksx(jsonGrxx.getString("hksx"));
							}
							if(jsonGrxx.containsKey("jxdm")){
								grxx.setJxdm(jsonGrxx.getString("jxdm"));
							}
							if(jsonGrxx.containsKey("zzdz")){
								grxx.setZzdz(jsonGrxx.getString("zzdz"));
							}
							if(jsonGrxx.containsKey("djrq")){
								grxx.setDjrq(jsonGrxx.getString("djrq"));
							}
							if(jsonGrxx.containsKey("zxbz")){
								grxx.setZxbz(jsonGrxx.getString("zxbz"));
							}
							grxxs.add(grxx);
						}
						data.setGrxxs(grxxs);
					}
				}
				
				/** 婚姻信息 */
				if(jsonData.containsKey("marryinfo") && jsonData.getJSONArray("marryinfo") != null){
					JSONArray jsonArrayMarryInfo = jsonData.getJSONArray("marryinfo");
					if(jsonArrayMarryInfo.size()>0){
						List<MarryInfo> marryInfos = new ArrayList<MarryInfo>();
						for(int i = 0;i<jsonArrayMarryInfo.size();i++){
							JSONObject jsonMarryInfo = jsonArrayMarryInfo.getJSONObject(i);
							MarryInfo marryInfo = new MarryInfo();
							marryInfo.setTrnId(trnId);
							marryInfo.setCrtUser(requestChannel);
							if(jsonMarryInfo.containsKey("businesstype")){
								marryInfo.setBusinessType(jsonMarryInfo.getString("businesstype"));
							}
							marryInfos.add(marryInfo);
						}
						data.setMarryInfos(marryInfos);
					}
				}
				
				/** 公积金信息 */
				if(jsonData.containsKey("gjjxx") && jsonData.getJSONArray("gjjxx") != null){
					JSONArray jsonArrayGjjxx = jsonData.getJSONArray("gjjxx");
					if(jsonArrayGjjxx.size()>0){
						List<Gjjxx> gjjxxs = new ArrayList<Gjjxx>();
						for(int i = 0;i<jsonArrayGjjxx.size();i++){
							JSONObject jsonGjjxx = jsonArrayGjjxx.getJSONObject(i);
							Gjjxx gjjxx = new Gjjxx();
							gjjxx.setTrnId(trnId);
							gjjxx.setCrtUser(requestChannel);
							if(jsonGjjxx.containsKey("dept_name")){
								gjjxx.setDeptName(jsonGjjxx.getString("dept_name"));
							}
							if(jsonGjjxx.containsKey("status")){
								gjjxx.setStatus(jsonGjjxx.getString("status"));
							}
							if(jsonGjjxx.containsKey("set_date")){
								gjjxx.setSetDate(jsonGjjxx.getString("set_date"));
							}
							if(jsonGjjxx.containsKey("pay_ym")){
								gjjxx.setPayYm(jsonGjjxx.getString("pay_ym"));
							}
							if(jsonGjjxx.containsKey("lxys")){
								gjjxx.setLxys(jsonGjjxx.getString("lxys"));
							}
							if(jsonGjjxx.containsKey("ljys")){
								gjjxx.setLjys(jsonGjjxx.getString("ljys"));
							}
							if(jsonGjjxx.containsKey("pay_base")){
								gjjxx.setPayBase(jsonGjjxx.getString("pay_base"));
							}
							if(jsonGjjxx.containsKey("ppay_amt")){
								gjjxx.setpPayAmt(jsonGjjxx.getString("ppay_amt"));
							}
							if(jsonGjjxx.containsKey("cpay_amt")){
								gjjxx.setcPayAmt(jsonGjjxx.getString("cpay_amt"));
							}
							if(jsonGjjxx.containsKey("pay_amt")){
								gjjxx.setPayAmt(jsonGjjxx.getString("pay_amt"));
							}
							if(jsonGjjxx.containsKey("grjcjz")){
								gjjxx.setGrjcjz(jsonGjjxx.getString("grjcjz"));
							}
							gjjxxs.add(gjjxx);
						}
						data.setGjjxxs(gjjxxs);
					}
				}
				
				/** 社保基本信息 */
				if(jsonData.containsKey("rsj_zx_ac01") && jsonData.getJSONArray("rsj_zx_ac01") != null){
					JSONArray jsonArrayRsjZxAc01 = jsonData.getJSONArray("rsj_zx_ac01");
					if(jsonArrayRsjZxAc01.size()>0){
						List<RsjZxAc01> rsjZxAc01s = new ArrayList<RsjZxAc01>();
						for(int i = 0;i<jsonArrayRsjZxAc01.size();i++){
							JSONObject jsonRsjZxAc01 = jsonArrayRsjZxAc01.getJSONObject(i);
							RsjZxAc01 rsjZxAc01 = new RsjZxAc01();
							rsjZxAc01.setTrnId(trnId);
							rsjZxAc01.setCrtUser(requestChannel);
							if(jsonRsjZxAc01.containsKey("aac002")){
								rsjZxAc01.setAac002(jsonRsjZxAc01.getString("aac002"));
							}
							if(jsonRsjZxAc01.containsKey("aab004")){
								rsjZxAc01.setAab004(jsonRsjZxAc01.getString("aab004"));
							}
							if(jsonRsjZxAc01.containsKey("aae002")){
								rsjZxAc01.setAae002(jsonRsjZxAc01.getString("aae002"));
							}
							if(jsonRsjZxAc01.containsKey("lxys")){
								rsjZxAc01.setLxys(jsonRsjZxAc01.getString("lxys"));
							}
							if(jsonRsjZxAc01.containsKey("ljys")){
								rsjZxAc01.setLjys(jsonRsjZxAc01.getString("ljys"));
							}
							if(jsonRsjZxAc01.containsKey("bac601")){
								rsjZxAc01.setBac601(jsonRsjZxAc01.getString("bac601"));
							}
							if(jsonRsjZxAc01.containsKey("bac603")){
								rsjZxAc01.setBac603(jsonRsjZxAc01.getString("bac603"));
							}
							if(jsonRsjZxAc01.containsKey("bad006")){
								rsjZxAc01.setBad006(jsonRsjZxAc01.getString("bad006"));
							}
							if(jsonRsjZxAc01.containsKey("bad007")){
								rsjZxAc01.setBad007(jsonRsjZxAc01.getString("bad007"));
							}
							if(jsonRsjZxAc01.containsKey("bad008")){
								rsjZxAc01.setBad008(jsonRsjZxAc01.getString("bad008"));
							}
							if(jsonRsjZxAc01.containsKey("bad009")){
								rsjZxAc01.setBad009(jsonRsjZxAc01.getString("bad009"));
							}
							rsjZxAc01s.add(rsjZxAc01);
						}
						data.setRsjZxAc01s(rsjZxAc01s);
					}
				}
				
				/** 社保缴费信息 */
				if(jsonData.containsKey("sb_feeinfogrid") && jsonData.getJSONArray("sb_feeinfogrid") != null){
					JSONArray jsonArraySbFeeinfogrid = jsonData.getJSONArray("sb_feeinfogrid");
					if(jsonArraySbFeeinfogrid.size()>0){
						List<SbFeeinfogrid> sbFeeinfogrids = new ArrayList<SbFeeinfogrid>();
						for(int i = 0;i<jsonArraySbFeeinfogrid.size();i++){
							JSONObject jsonSbFeeinfogrid = jsonArraySbFeeinfogrid.getJSONObject(i);
							SbFeeinfogrid sbFeeinfogrid = new SbFeeinfogrid();
							sbFeeinfogrid.setTrnId(trnId);
							sbFeeinfogrid.setCrtUser(requestChannel);
							if(jsonSbFeeinfogrid.containsKey("aae003")){
								sbFeeinfogrid.setAae003(jsonSbFeeinfogrid.getString("aae003"));
							}
							if(jsonSbFeeinfogrid.containsKey("aae020_100")){
								sbFeeinfogrid.setAae020_100(jsonSbFeeinfogrid.getString("aae020_100"));
							}
							if(jsonSbFeeinfogrid.containsKey("aae180_100")){
								sbFeeinfogrid.setAae180_100(jsonSbFeeinfogrid.getString("aae180_100"));
							}
							if(jsonSbFeeinfogrid.containsKey("aab004")){
								sbFeeinfogrid.setAab004(jsonSbFeeinfogrid.getString("aab004"));
							}
							if(jsonSbFeeinfogrid.containsKey("aaa115")){
								sbFeeinfogrid.setAaa115(jsonSbFeeinfogrid.getString("aaa115"));
							}
							sbFeeinfogrids.add(sbFeeinfogrid);
						}
						data.setSbFeeinfogrids(sbFeeinfogrids);
					}
				}
				
				/** 车辆信息 */
				if(jsonData.containsKey("gaj_jj_grjdcdjxx") && jsonData.getJSONArray("gaj_jj_grjdcdjxx") != null){
					JSONArray jsonArrayVehicleInfo = jsonData.getJSONArray("gaj_jj_grjdcdjxx");
					if(jsonArrayVehicleInfo.size()>0){
						List<VehicleInfo> vehicleInfos = new ArrayList<VehicleInfo>();
						for(int i = 0;i<jsonArrayVehicleInfo.size();i++){
							JSONObject jsonVehicleInfo = jsonArrayVehicleInfo.getJSONObject(i);
							VehicleInfo vehicleInfo = new VehicleInfo();
							vehicleInfo.setTrnId(trnId);
							vehicleInfo.setCrtUser(requestChannel);
							if(jsonVehicleInfo.containsKey("dybj")){
								vehicleInfo.setDybj(jsonVehicleInfo.getString("dybj"));
							}
							if(jsonVehicleInfo.containsKey("hpzl")){
								vehicleInfo.setHpzl(jsonVehicleInfo.getString("hpzl"));
							}
							if(jsonVehicleInfo.containsKey("djrq")){
								vehicleInfo.setDjrq(jsonVehicleInfo.getString("djrq"));
							}
							vehicleInfos.add(vehicleInfo);
						}
						data.setVehicleInfos(vehicleInfos);
					}
				}
				
				/** 企业信息 */
				if(jsonData.containsKey("scjgj_hz_qyhznr") && jsonData.getJSONArray("scjgj_hz_qyhznr") != null){
					JSONArray jsonArrayEnterpriseInfo = jsonData.getJSONArray("scjgj_hz_qyhznr");
					if(jsonArrayEnterpriseInfo.size()>0){
						List<EnterpriseInfo> enterpriseInfos = new ArrayList<EnterpriseInfo>();
						for(int i = 0;i<jsonArrayEnterpriseInfo.size();i++){
							JSONObject jsonEnterpriseInfo = jsonArrayEnterpriseInfo.getJSONObject(i);
							EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
							enterpriseInfo.setTrnId(trnId);
							enterpriseInfo.setCrtUser(requestChannel);
							if(jsonEnterpriseInfo.containsKey("uniscid")){
								enterpriseInfo.setUniscid(jsonEnterpriseInfo.getString("uniscid"));
							}
							if(jsonEnterpriseInfo.containsKey("qymc")){
								enterpriseInfo.setQymc(jsonEnterpriseInfo.getString("qymc"));
							}
							if(jsonEnterpriseInfo.containsKey("qylx")){
								enterpriseInfo.setQylx(jsonEnterpriseInfo.getString("qylx"));
							}
							if(jsonEnterpriseInfo.containsKey("fddbr")){
								enterpriseInfo.setFddbr(jsonEnterpriseInfo.getString("fddbr"));
							}
							if(jsonEnterpriseInfo.containsKey("sfzjhm")){
								enterpriseInfo.setSfzjhm(jsonEnterpriseInfo.getString("sfzjhm"));
							}
							if(jsonEnterpriseInfo.containsKey("zczb")){
								enterpriseInfo.setZczb(jsonEnterpriseInfo.getString("zczb"));
							}
							if(jsonEnterpriseInfo.containsKey("jyfw")){
								enterpriseInfo.setJyfw(jsonEnterpriseInfo.getString("jyfw"));
							}
							if(jsonEnterpriseInfo.containsKey("hzrq")){
								enterpriseInfo.setHzrq(jsonEnterpriseInfo.getString("hzrq"));
							}
							if(jsonEnterpriseInfo.containsKey("clrq")){
								enterpriseInfo.setClrq(jsonEnterpriseInfo.getString("clrq"));
							}
							if(jsonEnterpriseInfo.containsKey("jyqsrq")){
								enterpriseInfo.setJyqsrq(jsonEnterpriseInfo.getString("jyqsrq"));
							}
							if(jsonEnterpriseInfo.containsKey("jyjzrq")){
								enterpriseInfo.setJyjzrq(jsonEnterpriseInfo.getString("jyjzrq"));
							}
							if(jsonEnterpriseInfo.containsKey("zzyxqxqsrq")){
								enterpriseInfo.setZzyxqxqsrq(jsonEnterpriseInfo.getString("zzyxqxqsrq"));
							}
							if(jsonEnterpriseInfo.containsKey("zzyxqxjzrq")){
								enterpriseInfo.setZzyxqxjzrq(jsonEnterpriseInfo.getString("zzyxqxjzrq"));
							}
							enterpriseInfos.add(enterpriseInfo);
						}
						data.setEnterpriseInfos(enterpriseInfos);
					}
				}
				
				/** 公积金贷款信息 */
				if(jsonData.containsKey("gjj_loan_info") && jsonData.getJSONArray("gjj_loan_info") != null){
					JSONArray jsonArrayGjjLoanInfo = jsonData.getJSONArray("gjj_loan_info");
					if(jsonArrayGjjLoanInfo.size()>0){
						List<GjjLoanInfo> gjjLoanInfos = new ArrayList<GjjLoanInfo>();
						for(int i = 0;i<jsonArrayGjjLoanInfo.size();i++){
							JSONObject jsonGjjLoanInfo = jsonArrayGjjLoanInfo.getJSONObject(i);
							GjjLoanInfo gjjLoanInfo = new GjjLoanInfo();
							gjjLoanInfo.setTrnId(trnId);
							gjjLoanInfo.setCrtUser(requestChannel);
							if(jsonGjjLoanInfo.containsKey("ln_amt")){
								gjjLoanInfo.setLnAmt(jsonGjjLoanInfo.getString("ln_amt"));
							}
							if(jsonGjjLoanInfo.containsKey("ln_bal")){
								gjjLoanInfo.setLnBal(jsonGjjLoanInfo.getString("ln_bal"));
							}
							if(jsonGjjLoanInfo.containsKey("ln_term")){
								gjjLoanInfo.setLnTerm(jsonGjjLoanInfo.getString("ln_term"));
							}
							if(jsonGjjLoanInfo.containsKey("rem_term")){
								gjjLoanInfo.setRemTerm(jsonGjjLoanInfo.getString("rem_term"));
							}
							if(jsonGjjLoanInfo.containsKey("sum_ovl_day")){
								gjjLoanInfo.setSumOvlDay(jsonGjjLoanInfo.getString("sum_ovl_day"));
							}
							gjjLoanInfos.add(gjjLoanInfo);
						}
						data.setGjjLoanInfos(gjjLoanInfos);
					}
				}
				
				/** 法院失信 */
				if(jsonData.containsKey("fy_natural_person") && jsonData.getJSONArray("fy_natural_person") != null){
					JSONArray jsonArrayFyNaturalPerson = jsonData.getJSONArray("fy_natural_person");
					if(jsonArrayFyNaturalPerson.size()>0){
						List<FyNaturalPerson> fyNaturalPersons = new ArrayList<FyNaturalPerson>();
						for(int i = 0;i<jsonArrayFyNaturalPerson.size();i++){
							JSONObject jsonFyNaturalPerson = jsonArrayFyNaturalPerson.getJSONObject(i);
							FyNaturalPerson fyNaturalPerson = new FyNaturalPerson();
							fyNaturalPerson.setTrnId(trnId);
							fyNaturalPerson.setCrtUser(requestChannel);
							if(jsonFyNaturalPerson.containsKey("sqzxbd")){
								fyNaturalPerson.setSqzxbd(jsonFyNaturalPerson.getString("sqzxbd"));
							}
							if(jsonFyNaturalPerson.containsKey("ah")){
								fyNaturalPerson.setAh(jsonFyNaturalPerson.getString("ah"));
							}
							if(jsonFyNaturalPerson.containsKey("ay")){
								fyNaturalPerson.setAy(jsonFyNaturalPerson.getString("ay"));
							}
							if(jsonFyNaturalPerson.containsKey("zxfymc")){
								fyNaturalPerson.setZxfymc(jsonFyNaturalPerson.getString("zxfymc"));
							}
							if(jsonFyNaturalPerson.containsKey("ajzt")){
								fyNaturalPerson.setAjzt(jsonFyNaturalPerson.getString("ajzt"));
							}
							fyNaturalPersons.add(fyNaturalPerson);
						}
						data.setFyNaturalPersons(fyNaturalPersons);
					}
				}
				
				/** 车辆处罚信息 */
				if(jsonData.containsKey("gaj_jj_jdcjsyjtwfxx") && jsonData.getJSONArray("gaj_jj_jdcjsyjtwfxx") != null){
					JSONArray jsonArrayVehiclePenaltyInfo = jsonData.getJSONArray("gaj_jj_jdcjsyjtwfxx");
					if(jsonArrayVehiclePenaltyInfo.size()>0){
						List<VehiclePenaltyInfo> vehiclePenaltyInfos = new ArrayList<VehiclePenaltyInfo>();
						for(int i = 0;i<jsonArrayVehiclePenaltyInfo.size();i++){
							JSONObject jsonVehiclePenaltyInfo = jsonArrayVehiclePenaltyInfo.getJSONObject(i);
							VehiclePenaltyInfo vehiclePenaltyInfo = new VehiclePenaltyInfo();
							vehiclePenaltyInfo.setTrnId(trnId);
							vehiclePenaltyInfo.setCrtUser(requestChannel);
							if(jsonVehiclePenaltyInfo.containsKey("wfsj")){
								vehiclePenaltyInfo.setWfsj(jsonVehiclePenaltyInfo.getString("wfsj"));
							}
							if(jsonVehiclePenaltyInfo.containsKey("wfjfs")){
								vehiclePenaltyInfo.setWfjfs(jsonVehiclePenaltyInfo.getString("wfjfs"));
							}
							if(jsonVehiclePenaltyInfo.containsKey("dsr")){
								vehiclePenaltyInfo.setDsr(jsonVehiclePenaltyInfo.getString("dsr"));
							}
							vehiclePenaltyInfos.add(vehiclePenaltyInfo);
						}
						data.setVehiclePenaltyInfos(vehiclePenaltyInfos);
					}
				}
				
				/** 水务缴费信息 */
				if(jsonData.containsKey("swj_t_serv_usage_mv") && jsonData.getJSONArray("swj_t_serv_usage_mv") != null){
					JSONArray jsonArrayWaterAffairsInfo = jsonData.getJSONArray("swj_t_serv_usage_mv");
					if(jsonArrayWaterAffairsInfo.size()>0){
						List<WaterAffairsInfo> waterAffairsInfos = new ArrayList<WaterAffairsInfo>();
						for(int i = 0;i<jsonArrayWaterAffairsInfo.size();i++){
							JSONObject jsonWaterAffairsInfo = jsonArrayWaterAffairsInfo.getJSONObject(i);
							WaterAffairsInfo waterAffairsInfo = new WaterAffairsInfo();
							waterAffairsInfo.setTrnId(trnId);
							waterAffairsInfo.setCrtUser(requestChannel);
							if(jsonWaterAffairsInfo.containsKey("serv_code")){
								waterAffairsInfo.setServCode(jsonWaterAffairsInfo.getString("serv_code"));
							}
							if(jsonWaterAffairsInfo.containsKey("collection_dt")){
								waterAffairsInfo.setCollectionDt(jsonWaterAffairsInfo.getString("collection_dt"));
							}
							if(jsonWaterAffairsInfo.containsKey("payment_status")){
								waterAffairsInfo.setPaymentStatus(jsonWaterAffairsInfo.getString("payment_status"));
							}
							waterAffairsInfos.add(waterAffairsInfo);
						}
						data.setWaterAffairsInfos(waterAffairsInfos);
					}
				}
				
				hzCollection.setData(data);
			}
		}
		return hzCollection;
	}

}
