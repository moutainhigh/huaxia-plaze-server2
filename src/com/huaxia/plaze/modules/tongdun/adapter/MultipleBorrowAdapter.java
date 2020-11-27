package com.huaxia.plaze.modules.tongdun.adapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.opas.util.UUIDGen;
import com.huaxia.plaze.modules.tongdun.domain.MulBorAntifraudIndex;
import com.huaxia.plaze.modules.tongdun.domain.MulBorBase;
import com.huaxia.plaze.modules.tongdun.domain.MulBorBlackList;
import com.huaxia.plaze.modules.tongdun.domain.MulBorDescreditCount;
import com.huaxia.plaze.modules.tongdun.domain.MulBorGreyList;
import com.huaxia.plaze.modules.tongdun.domain.MulBorInfo;
import com.huaxia.plaze.modules.tongdun.domain.MulBorRiskItem;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 多头借代的适配器
 * 
 * @author Liuwei
 *
 */
public class MultipleBorrowAdapter {

	private static final Logger logger = LoggerFactory.getLogger(MultipleBorrowAdapter.class);

	/**
	 * @Title:parseQyhyInfo
	 * @Description:多头借贷的请求信息解析报文
	 * @param message
	 * @param appId
	 * @param crtUser
	 * @param crtNo
	 * @param mobile
	 * @param trnId
	 * @return MulBorInfo
	 * @author: Liuwei
	 * @Date:2019年02月01日 17:35
	 * @Data:lastUpdate 2019年02月12日
	 * @Data:lastUpdate 2019年02月15日实现完整报文的入库
	 * @Data:lastUpdate 2019年02月23日更新了数据库，重新进行数据库入库
	 * @Data:lastUpdate 2019年03月01日 完成了定时的任务。实现了线程入库
	 */
	public MulBorInfo parseMulBorInfo(String message, String appId, String crtUser, String crtNo, String mobile,
			String trnId) {
		MulBorInfo mulborInfo = new MulBorInfo();
		try {
			JSONObject json = JSONObject.fromObject(message);
			
			List<MulBorRiskItem> mulBorRiskItemrList = new ArrayList<MulBorRiskItem>();
			List<MulBorBlackList> mulBorBlackList = new ArrayList<MulBorBlackList>();
			List<MulBorDescreditCount> mulBorDescreditCountList = new ArrayList<MulBorDescreditCount>();
			List<MulBorGreyList> mulBorGreyList = new ArrayList<MulBorGreyList>();
			
			if (message == null || "".equals(message)) {
				if (logger.isErrorEnabled()) {
					logger.error("[客户端 & 多头借贷信息] 数据解析异常! {}", "多头借贷返回信息报文为空");
				}
				return null;
			}
			// 创建基础表
			MulBorBase basetable = new MulBorBase();// 基础表的设置
			String uuid = UUIDGen.getUUID();// 自动生成基础表的ID，不重复
			Date crtTime = new Date();
			basetable.setUuid(uuid);
			basetable.setCrtTime(crtTime);
			basetable.setCrtUser(crtUser);
			String pkUuidOfBaseTable = UUIDGen.getUUID();// 自动生成基础表的ID，
			basetable.setPkUuid(pkUuidOfBaseTable);
			basetable.setAppId(appId);
			basetable.setTrnId(trnId);
			basetable.setCertNo(crtNo);
			basetable.setMobile(mobile);
			
			if (json.containsKey("success") && json.getString("success") != null
					&& !"".equals(json.getString("success"))) {
				basetable.setSuccess(json.getString("success"));
			}
			if (json.containsKey("id") && json.getString("id") != null && !"".equals(json.getString("id"))) {
				basetable.setID(json.getString("id"));
			}
			if (json.containsKey("reason_code") && json.getString("reason_code") != null
					&& !"".equals(json.getString("reason_code"))) {
				basetable.setReasonCode(json.getString("reason_code"));
			}
			if (json.containsKey("nextService") && json.getString("nextService") != null
					&& !"".equals(json.getString("nextService"))) {
				basetable.setNextService(json.getString("nextService"));
			}
			if (json.containsKey("reason_desc") && json.getString("reason_desc") != null
					&& !"".equals(json.getString("reason_desc"))) {
				basetable.setReasonDesc(json.getString("reason_desc"));
			}
			JSONObject resultDescJSON = new JSONObject();
			if (json.containsKey("result_desc") && json.getString("result_desc") != null
					&& !"".equals(json.getString("result_desc"))) {
				JSONObject resultJSON = JSONObject.fromObject(json.getString("result_desc"));
				
				if (resultJSON.containsKey("ANTIFRAUD") && resultJSON.getString("ANTIFRAUD") != null
						&& !"".equals(resultJSON.getString("ANTIFRAUD"))) {
					resultDescJSON = JSONObject.fromObject(resultJSON.getString("ANTIFRAUD"));
				}
				JSONObject antiFraudIndexJSON = new JSONObject();
				if (resultJSON.containsKey("ANTIFRAUD_INDEX") && resultJSON.getString("ANTIFRAUD_INDEX") != null
						&& !"".equals(resultJSON.getString("ANTIFRAUD_INDEX"))) {
					antiFraudIndexJSON = JSONObject.fromObject(resultJSON.getString("ANTIFRAUD_INDEX"));// 反欺詐指标服务

					// 创建指标服务格
					MulBorAntifraudIndex mulBorAntifraudIndex = new MulBorAntifraudIndex();
					String uuidOfIndex = UUIDGen.getUUID();// 自动生成基础表的ID，不重复
					mulBorAntifraudIndex.setUuid(uuidOfIndex);
					mulBorAntifraudIndex.setCrtTime(crtTime);
					mulBorAntifraudIndex.setCrtUser(crtUser);
					mulBorAntifraudIndex.setRefUuid(pkUuidOfBaseTable);
					mulBorAntifraudIndex.setAppId(appId);
					mulBorAntifraudIndex.setTrnId(trnId);
					
					if(antiFraudIndexJSON.containsKey("ed8d0a4c82dd50b1")&& antiFraudIndexJSON.getString("ed8d0a4c82dd50b1")!=null && !"".equals(antiFraudIndexJSON.getString("ed8d0a4c82dd50b1")) && !"null".equals(antiFraudIndexJSON.getString("ed8d0a4c82dd50b1"))){ mulBorAntifraudIndex.setANTIFRAUD_0a4c82dd50b1(antiFraudIndexJSON.getString("ed8d0a4c82dd50b1"));}
					if(antiFraudIndexJSON.containsKey("h9c68c5c6b85ba31")&& antiFraudIndexJSON.getString("h9c68c5c6b85ba31")!=null && !"".equals(antiFraudIndexJSON.getString("h9c68c5c6b85ba31")) && !"null".equals(antiFraudIndexJSON.getString("h9c68c5c6b85ba31"))){ mulBorAntifraudIndex.setANTIFRAUD_8c5c6b85ba31(antiFraudIndexJSON.getString("h9c68c5c6b85ba31"));}
					if(antiFraudIndexJSON.containsKey("ad93a5cfd2cc0821")&& antiFraudIndexJSON.getString("ad93a5cfd2cc0821")!=null && !"".equals(antiFraudIndexJSON.getString("ad93a5cfd2cc0821")) && !"null".equals(antiFraudIndexJSON.getString("ad93a5cfd2cc0821"))){ mulBorAntifraudIndex.setANTIFRAUD_a5cfd2cc0821(antiFraudIndexJSON.getString("ad93a5cfd2cc0821"));}
					if(antiFraudIndexJSON.containsKey("f40f7dc74be258f1")&& antiFraudIndexJSON.getString("f40f7dc74be258f1")!=null && !"".equals(antiFraudIndexJSON.getString("f40f7dc74be258f1")) && !"null".equals(antiFraudIndexJSON.getString("f40f7dc74be258f1"))){ mulBorAntifraudIndex.setANTIFRAUD_7dc74be258f1(antiFraudIndexJSON.getString("f40f7dc74be258f1"));}
					if(antiFraudIndexJSON.containsKey("bc2ae4bef80ab191")&& antiFraudIndexJSON.getString("bc2ae4bef80ab191")!=null && !"".equals(antiFraudIndexJSON.getString("bc2ae4bef80ab191")) && !"null".equals(antiFraudIndexJSON.getString("bc2ae4bef80ab191"))){ mulBorAntifraudIndex.setANTIFRAUD_e4bef80ab191(antiFraudIndexJSON.getString("bc2ae4bef80ab191"));}
					if(antiFraudIndexJSON.containsKey("he005f1cff4a6081")&& antiFraudIndexJSON.getString("he005f1cff4a6081")!=null && !"".equals(antiFraudIndexJSON.getString("he005f1cff4a6081")) && !"null".equals(antiFraudIndexJSON.getString("he005f1cff4a6081"))){ mulBorAntifraudIndex.setANTIFRAUD_5f1cff4a6081(antiFraudIndexJSON.getString("he005f1cff4a6081"));}
					if(antiFraudIndexJSON.containsKey("i3b4d3c5b644d261")&& antiFraudIndexJSON.getString("i3b4d3c5b644d261")!=null && !"".equals(antiFraudIndexJSON.getString("i3b4d3c5b644d261")) && !"null".equals(antiFraudIndexJSON.getString("i3b4d3c5b644d261"))){ mulBorAntifraudIndex.setANTIFRAUD_d3c5b644d261(antiFraudIndexJSON.getString("i3b4d3c5b644d261"));}
					if(antiFraudIndexJSON.containsKey("dc5fac586c138441")&& antiFraudIndexJSON.getString("dc5fac586c138441")!=null && !"".equals(antiFraudIndexJSON.getString("dc5fac586c138441")) && !"null".equals(antiFraudIndexJSON.getString("dc5fac586c138441"))){ mulBorAntifraudIndex.setANTIFRAUD_ac586c138441(antiFraudIndexJSON.getString("dc5fac586c138441"));}
					if(antiFraudIndexJSON.containsKey("hf1ed964cad56851")&& antiFraudIndexJSON.getString("hf1ed964cad56851")!=null && !"".equals(antiFraudIndexJSON.getString("hf1ed964cad56851")) && !"null".equals(antiFraudIndexJSON.getString("hf1ed964cad56851"))){ mulBorAntifraudIndex.setANTIFRAUD_d964cad56851(antiFraudIndexJSON.getString("hf1ed964cad56851"));}
					if(antiFraudIndexJSON.containsKey("df80d0d879f929b1")&& antiFraudIndexJSON.getString("df80d0d879f929b1")!=null && !"".equals(antiFraudIndexJSON.getString("df80d0d879f929b1")) && !"null".equals(antiFraudIndexJSON.getString("df80d0d879f929b1"))){ mulBorAntifraudIndex.setANTIFRAUD_d0d879f929b1(antiFraudIndexJSON.getString("df80d0d879f929b1"));}
					if(antiFraudIndexJSON.containsKey("ff36d7b369958461")&& antiFraudIndexJSON.getString("ff36d7b369958461")!=null && !"".equals(antiFraudIndexJSON.getString("ff36d7b369958461")) && !"null".equals(antiFraudIndexJSON.getString("ff36d7b369958461"))){ mulBorAntifraudIndex.setANTIFRAUD_d7b369958461(antiFraudIndexJSON.getString("ff36d7b369958461"));}
					if(antiFraudIndexJSON.containsKey("af9f7decf0c10f91")&& antiFraudIndexJSON.getString("af9f7decf0c10f91")!=null && !"".equals(antiFraudIndexJSON.getString("af9f7decf0c10f91")) && !"null".equals(antiFraudIndexJSON.getString("af9f7decf0c10f91"))){ mulBorAntifraudIndex.setANTIFRAUD_7decf0c10f91(antiFraudIndexJSON.getString("af9f7decf0c10f91"));}
					if(antiFraudIndexJSON.containsKey("abd8cd6ddb5b0231")&& antiFraudIndexJSON.getString("abd8cd6ddb5b0231")!=null && !"".equals(antiFraudIndexJSON.getString("abd8cd6ddb5b0231")) && !"null".equals(antiFraudIndexJSON.getString("abd8cd6ddb5b0231"))){ mulBorAntifraudIndex.setANTIFRAUD_cd6ddb5b0231(antiFraudIndexJSON.getString("abd8cd6ddb5b0231"));}
					if(antiFraudIndexJSON.containsKey("ff46e400cb476291")&& antiFraudIndexJSON.getString("ff46e400cb476291")!=null && !"".equals(antiFraudIndexJSON.getString("ff46e400cb476291")) && !"null".equals(antiFraudIndexJSON.getString("ff46e400cb476291"))){ mulBorAntifraudIndex.setANTIFRAUD_e400cb476291(antiFraudIndexJSON.getString("ff46e400cb476291"));}
					if(antiFraudIndexJSON.containsKey("f24a5edebc93e271")&& antiFraudIndexJSON.getString("f24a5edebc93e271")!=null && !"".equals(antiFraudIndexJSON.getString("f24a5edebc93e271")) && !"null".equals(antiFraudIndexJSON.getString("f24a5edebc93e271"))){ mulBorAntifraudIndex.setANTIFRAUD_5edebc93e271(antiFraudIndexJSON.getString("f24a5edebc93e271"));}
					if(antiFraudIndexJSON.containsKey("fd7248e8c2d36f21")&& antiFraudIndexJSON.getString("fd7248e8c2d36f21")!=null && !"".equals(antiFraudIndexJSON.getString("fd7248e8c2d36f21")) && !"null".equals(antiFraudIndexJSON.getString("fd7248e8c2d36f21"))){ mulBorAntifraudIndex.setANTIFRAUD_48e8c2d36f21(antiFraudIndexJSON.getString("fd7248e8c2d36f21"));}
					if(antiFraudIndexJSON.containsKey("gb8d06b34db165e1")&& antiFraudIndexJSON.getString("gb8d06b34db165e1")!=null && !"".equals(antiFraudIndexJSON.getString("gb8d06b34db165e1")) && !"null".equals(antiFraudIndexJSON.getString("gb8d06b34db165e1"))){ mulBorAntifraudIndex.setANTIFRAUD_06b34db165e1(antiFraudIndexJSON.getString("gb8d06b34db165e1"));}
					if(antiFraudIndexJSON.containsKey("fc8369a5fc3dbc11")&& antiFraudIndexJSON.getString("fc8369a5fc3dbc11")!=null && !"".equals(antiFraudIndexJSON.getString("fc8369a5fc3dbc11")) && !"null".equals(antiFraudIndexJSON.getString("fc8369a5fc3dbc11"))){ mulBorAntifraudIndex.setANTIFRAUD_69a5fc3dbc11(antiFraudIndexJSON.getString("fc8369a5fc3dbc11"));}
					if(antiFraudIndexJSON.containsKey("bc418fb406000650")&& antiFraudIndexJSON.getString("bc418fb406000650")!=null && !"".equals(antiFraudIndexJSON.getString("bc418fb406000650")) && !"null".equals(antiFraudIndexJSON.getString("bc418fb406000650"))){ mulBorAntifraudIndex.setANTIFRAUD_8fb406000650(antiFraudIndexJSON.getString("bc418fb406000650"));}
					if(antiFraudIndexJSON.containsKey("bff3531b058e93f0")&& antiFraudIndexJSON.getString("bff3531b058e93f0")!=null && !"".equals(antiFraudIndexJSON.getString("bff3531b058e93f0")) && !"null".equals(antiFraudIndexJSON.getString("bff3531b058e93f0"))){ mulBorAntifraudIndex.setANTIFRAUD_531b058e93f0(antiFraudIndexJSON.getString("bff3531b058e93f0"));}
					if(antiFraudIndexJSON.containsKey("b8294c244935aef0")&& antiFraudIndexJSON.getString("b8294c244935aef0")!=null && !"".equals(antiFraudIndexJSON.getString("b8294c244935aef0")) && !"null".equals(antiFraudIndexJSON.getString("b8294c244935aef0"))){ mulBorAntifraudIndex.setANTIFRAUD_4c244935aef0(antiFraudIndexJSON.getString("b8294c244935aef0"));}
					if(antiFraudIndexJSON.containsKey("a7e74faf84e71160")&& antiFraudIndexJSON.getString("a7e74faf84e71160")!=null && !"".equals(antiFraudIndexJSON.getString("a7e74faf84e71160")) && !"null".equals(antiFraudIndexJSON.getString("a7e74faf84e71160"))){ mulBorAntifraudIndex.setANTIFRAUD_4faf84e71160(antiFraudIndexJSON.getString("a7e74faf84e71160"));}
					if(antiFraudIndexJSON.containsKey("f776cd01aa772bd0")&& antiFraudIndexJSON.getString("f776cd01aa772bd0")!=null && !"".equals(antiFraudIndexJSON.getString("f776cd01aa772bd0")) && !"null".equals(antiFraudIndexJSON.getString("f776cd01aa772bd0"))){ mulBorAntifraudIndex.setANTIFRAUD_cd01aa772bd0(antiFraudIndexJSON.getString("f776cd01aa772bd0"));}
					if(antiFraudIndexJSON.containsKey("c9e54b549901aea0")&& antiFraudIndexJSON.getString("c9e54b549901aea0")!=null && !"".equals(antiFraudIndexJSON.getString("c9e54b549901aea0")) && !"null".equals(antiFraudIndexJSON.getString("c9e54b549901aea0"))){ mulBorAntifraudIndex.setANTIFRAUD_4b549901aea0(antiFraudIndexJSON.getString("c9e54b549901aea0"));}
					if(antiFraudIndexJSON.containsKey("g577bc72c9ccec40")&& antiFraudIndexJSON.getString("g577bc72c9ccec40")!=null && !"".equals(antiFraudIndexJSON.getString("g577bc72c9ccec40")) && !"null".equals(antiFraudIndexJSON.getString("g577bc72c9ccec40"))){ mulBorAntifraudIndex.setANTIFRAUD_bc72c9ccec40(antiFraudIndexJSON.getString("g577bc72c9ccec40"));}
					if(antiFraudIndexJSON.containsKey("ec2a39497d9839d0")&& antiFraudIndexJSON.getString("ec2a39497d9839d0")!=null && !"".equals(antiFraudIndexJSON.getString("ec2a39497d9839d0")) && !"null".equals(antiFraudIndexJSON.getString("ec2a39497d9839d0"))){ mulBorAntifraudIndex.setANTIFRAUD_39497d9839d0(antiFraudIndexJSON.getString("ec2a39497d9839d0"));}
					if(antiFraudIndexJSON.containsKey("da00ff7f8fc1f120")&& antiFraudIndexJSON.getString("da00ff7f8fc1f120")!=null && !"".equals(antiFraudIndexJSON.getString("da00ff7f8fc1f120")) && !"null".equals(antiFraudIndexJSON.getString("da00ff7f8fc1f120"))){ mulBorAntifraudIndex.setANTIFRAUD_ff7f8fc1f120(antiFraudIndexJSON.getString("da00ff7f8fc1f120"));}
					if(antiFraudIndexJSON.containsKey("b45cefcaeb13df30")&& antiFraudIndexJSON.getString("b45cefcaeb13df30")!=null && !"".equals(antiFraudIndexJSON.getString("b45cefcaeb13df30")) && !"null".equals(antiFraudIndexJSON.getString("b45cefcaeb13df30"))){ mulBorAntifraudIndex.setANTIFRAUD_efcaeb13df30(antiFraudIndexJSON.getString("b45cefcaeb13df30"));}
					if(antiFraudIndexJSON.containsKey("jc54a549cd137ad0")&& antiFraudIndexJSON.getString("jc54a549cd137ad0")!=null && !"".equals(antiFraudIndexJSON.getString("jc54a549cd137ad0")) && !"null".equals(antiFraudIndexJSON.getString("jc54a549cd137ad0"))){ mulBorAntifraudIndex.setANTIFRAUD_a549cd137ad0(antiFraudIndexJSON.getString("jc54a549cd137ad0"));}
					if(antiFraudIndexJSON.containsKey("cf09c3437b89c780")&& antiFraudIndexJSON.getString("cf09c3437b89c780")!=null && !"".equals(antiFraudIndexJSON.getString("cf09c3437b89c780")) && !"null".equals(antiFraudIndexJSON.getString("cf09c3437b89c780"))){ mulBorAntifraudIndex.setANTIFRAUD_c3437b89c780(antiFraudIndexJSON.getString("cf09c3437b89c780"));}
					if(antiFraudIndexJSON.containsKey("id4d4f66e1f858e0")&& antiFraudIndexJSON.getString("id4d4f66e1f858e0")!=null && !"".equals(antiFraudIndexJSON.getString("id4d4f66e1f858e0")) && !"null".equals(antiFraudIndexJSON.getString("id4d4f66e1f858e0"))){ mulBorAntifraudIndex.setANTIFRAUD_4f66e1f858e0(antiFraudIndexJSON.getString("id4d4f66e1f858e0"));}
					if(antiFraudIndexJSON.containsKey("f4d285f885cc4f40")&& antiFraudIndexJSON.getString("f4d285f885cc4f40")!=null && !"".equals(antiFraudIndexJSON.getString("f4d285f885cc4f40")) && !"null".equals(antiFraudIndexJSON.getString("f4d285f885cc4f40"))){ mulBorAntifraudIndex.setANTIFRAUD_85f885cc4f40(antiFraudIndexJSON.getString("f4d285f885cc4f40"));}
					if(antiFraudIndexJSON.containsKey("a0e87de9144eca20")&& antiFraudIndexJSON.getString("a0e87de9144eca20")!=null && !"".equals(antiFraudIndexJSON.getString("a0e87de9144eca20")) && !"null".equals(antiFraudIndexJSON.getString("a0e87de9144eca20"))){ mulBorAntifraudIndex.setANTIFRAUD_7de9144eca20(antiFraudIndexJSON.getString("a0e87de9144eca20"));}
					if(antiFraudIndexJSON.containsKey("f0d8e3509aaf13d0")&& antiFraudIndexJSON.getString("f0d8e3509aaf13d0")!=null && !"".equals(antiFraudIndexJSON.getString("f0d8e3509aaf13d0")) && !"null".equals(antiFraudIndexJSON.getString("f0d8e3509aaf13d0"))){ mulBorAntifraudIndex.setANTIFRAUD_e3509aaf13d0(antiFraudIndexJSON.getString("f0d8e3509aaf13d0"));}
					if(antiFraudIndexJSON.containsKey("d3ff161760eea3f1")&& antiFraudIndexJSON.getString("d3ff161760eea3f1")!=null && !"".equals(antiFraudIndexJSON.getString("d3ff161760eea3f1")) && !"null".equals(antiFraudIndexJSON.getString("d3ff161760eea3f1"))){ mulBorAntifraudIndex.setANTIFRAUD_161760eea3f1(antiFraudIndexJSON.getString("d3ff161760eea3f1"));}
					if(antiFraudIndexJSON.containsKey("fe81871b4791b741")&& antiFraudIndexJSON.getString("fe81871b4791b741")!=null && !"".equals(antiFraudIndexJSON.getString("fe81871b4791b741")) && !"null".equals(antiFraudIndexJSON.getString("fe81871b4791b741"))){ mulBorAntifraudIndex.setANTIFRAUD_871b4791b741(antiFraudIndexJSON.getString("fe81871b4791b741"));}
					if(antiFraudIndexJSON.containsKey("aafd64343ca2cfa1")&& antiFraudIndexJSON.getString("aafd64343ca2cfa1")!=null && !"".equals(antiFraudIndexJSON.getString("aafd64343ca2cfa1")) && !"null".equals(antiFraudIndexJSON.getString("aafd64343ca2cfa1"))){ mulBorAntifraudIndex.setANTIFRAUD_64343ca2cfa1(antiFraudIndexJSON.getString("aafd64343ca2cfa1"));}
					if(antiFraudIndexJSON.containsKey("j94ecd166e53c9b1")&& antiFraudIndexJSON.getString("j94ecd166e53c9b1")!=null && !"".equals(antiFraudIndexJSON.getString("j94ecd166e53c9b1")) && !"null".equals(antiFraudIndexJSON.getString("j94ecd166e53c9b1"))){ mulBorAntifraudIndex.setANTIFRAUD_cd166e53c9b1(antiFraudIndexJSON.getString("j94ecd166e53c9b1"));}
					if(antiFraudIndexJSON.containsKey("a14e2ebb86a755d1")&& antiFraudIndexJSON.getString("a14e2ebb86a755d1")!=null && !"".equals(antiFraudIndexJSON.getString("a14e2ebb86a755d1")) && !"null".equals(antiFraudIndexJSON.getString("a14e2ebb86a755d1"))){ mulBorAntifraudIndex.setANTIFRAUD_2ebb86a755d1(antiFraudIndexJSON.getString("a14e2ebb86a755d1"));}
					if(antiFraudIndexJSON.containsKey("ca8f0fd434e40bb1")&& antiFraudIndexJSON.getString("ca8f0fd434e40bb1")!=null && !"".equals(antiFraudIndexJSON.getString("ca8f0fd434e40bb1")) && !"null".equals(antiFraudIndexJSON.getString("ca8f0fd434e40bb1"))){ mulBorAntifraudIndex.setANTIFRAUD_0fd434e40bb1(antiFraudIndexJSON.getString("ca8f0fd434e40bb1"));}
					if(antiFraudIndexJSON.containsKey("e7e361aee6654c01")&& antiFraudIndexJSON.getString("e7e361aee6654c01")!=null && !"".equals(antiFraudIndexJSON.getString("e7e361aee6654c01")) && !"null".equals(antiFraudIndexJSON.getString("e7e361aee6654c01"))){ mulBorAntifraudIndex.setANTIFRAUD_61aee6654c01(antiFraudIndexJSON.getString("e7e361aee6654c01"));}
					if(antiFraudIndexJSON.containsKey("ce62d5d1955ff171")&& antiFraudIndexJSON.getString("ce62d5d1955ff171")!=null && !"".equals(antiFraudIndexJSON.getString("ce62d5d1955ff171")) && !"null".equals(antiFraudIndexJSON.getString("ce62d5d1955ff171"))){ mulBorAntifraudIndex.setANTIFRAUD_d5d1955ff171(antiFraudIndexJSON.getString("ce62d5d1955ff171"));}
					if(antiFraudIndexJSON.containsKey("jfead3445eae2341")&& antiFraudIndexJSON.getString("jfead3445eae2341")!=null && !"".equals(antiFraudIndexJSON.getString("jfead3445eae2341")) && !"null".equals(antiFraudIndexJSON.getString("jfead3445eae2341"))){ mulBorAntifraudIndex.setANTIFRAUD_d3445eae2341(antiFraudIndexJSON.getString("jfead3445eae2341"));}
					if(antiFraudIndexJSON.containsKey("a5541904f9b71b31")&& antiFraudIndexJSON.getString("a5541904f9b71b31")!=null && !"".equals(antiFraudIndexJSON.getString("a5541904f9b71b31")) && !"null".equals(antiFraudIndexJSON.getString("a5541904f9b71b31"))){ mulBorAntifraudIndex.setANTIFRAUD_1904f9b71b31(antiFraudIndexJSON.getString("a5541904f9b71b31"));}
					if(antiFraudIndexJSON.containsKey("cd6cffcfc2b798a1")&& antiFraudIndexJSON.getString("cd6cffcfc2b798a1")!=null && !"".equals(antiFraudIndexJSON.getString("cd6cffcfc2b798a1")) && !"null".equals(antiFraudIndexJSON.getString("cd6cffcfc2b798a1"))){ mulBorAntifraudIndex.setANTIFRAUD_ffcfc2b798a1(antiFraudIndexJSON.getString("cd6cffcfc2b798a1"));}
					if(antiFraudIndexJSON.containsKey("h8a18401d0095da1")&& antiFraudIndexJSON.getString("h8a18401d0095da1")!=null && !"".equals(antiFraudIndexJSON.getString("h8a18401d0095da1")) && !"null".equals(antiFraudIndexJSON.getString("h8a18401d0095da1"))){ mulBorAntifraudIndex.setANTIFRAUD_8401d0095da1(antiFraudIndexJSON.getString("h8a18401d0095da1"));}
					if(antiFraudIndexJSON.containsKey("h02a82b0f20981a1")&& antiFraudIndexJSON.getString("h02a82b0f20981a1")!=null && !"".equals(antiFraudIndexJSON.getString("h02a82b0f20981a1")) && !"null".equals(antiFraudIndexJSON.getString("h02a82b0f20981a1"))){ mulBorAntifraudIndex.setANTIFRAUD_82b0f20981a1(antiFraudIndexJSON.getString("h02a82b0f20981a1"));}
					if(antiFraudIndexJSON.containsKey("f1082ec00f08de71")&& antiFraudIndexJSON.getString("f1082ec00f08de71")!=null && !"".equals(antiFraudIndexJSON.getString("f1082ec00f08de71")) && !"null".equals(antiFraudIndexJSON.getString("f1082ec00f08de71"))){ mulBorAntifraudIndex.setANTIFRAUD_2ec00f08de71(antiFraudIndexJSON.getString("f1082ec00f08de71"));}
					if(antiFraudIndexJSON.containsKey("h32eac9e681b02a1")&& antiFraudIndexJSON.getString("h32eac9e681b02a1")!=null && !"".equals(antiFraudIndexJSON.getString("h32eac9e681b02a1")) && !"null".equals(antiFraudIndexJSON.getString("h32eac9e681b02a1"))){ mulBorAntifraudIndex.setANTIFRAUD_ac9e681b02a1(antiFraudIndexJSON.getString("h32eac9e681b02a1"));}
					if(antiFraudIndexJSON.containsKey("d4d4acf713df3fd1")&& antiFraudIndexJSON.getString("d4d4acf713df3fd1")!=null && !"".equals(antiFraudIndexJSON.getString("d4d4acf713df3fd1")) && !"null".equals(antiFraudIndexJSON.getString("d4d4acf713df3fd1"))){ mulBorAntifraudIndex.setANTIFRAUD_acf713df3fd1(antiFraudIndexJSON.getString("d4d4acf713df3fd1"));}
					if(antiFraudIndexJSON.containsKey("cdd0ac4f01b59331")&& antiFraudIndexJSON.getString("cdd0ac4f01b59331")!=null && !"".equals(antiFraudIndexJSON.getString("cdd0ac4f01b59331")) && !"null".equals(antiFraudIndexJSON.getString("cdd0ac4f01b59331"))){ mulBorAntifraudIndex.setANTIFRAUD_ac4f01b59331(antiFraudIndexJSON.getString("cdd0ac4f01b59331"));}
					if(antiFraudIndexJSON.containsKey("g0eaf7215fe4b561")&& antiFraudIndexJSON.getString("g0eaf7215fe4b561")!=null && !"".equals(antiFraudIndexJSON.getString("g0eaf7215fe4b561")) && !"null".equals(antiFraudIndexJSON.getString("g0eaf7215fe4b561"))){ mulBorAntifraudIndex.setANTIFRAUD_f7215fe4b561(antiFraudIndexJSON.getString("g0eaf7215fe4b561"));}
					if(antiFraudIndexJSON.containsKey("j115dda895875860")&& antiFraudIndexJSON.getString("j115dda895875860")!=null && !"".equals(antiFraudIndexJSON.getString("j115dda895875860")) && !"null".equals(antiFraudIndexJSON.getString("j115dda895875860"))){ mulBorAntifraudIndex.setANTIFRAUD_dda895875860(antiFraudIndexJSON.getString("j115dda895875860"));}
					if(antiFraudIndexJSON.containsKey("c8f0c66690712910")&& antiFraudIndexJSON.getString("c8f0c66690712910")!=null && !"".equals(antiFraudIndexJSON.getString("c8f0c66690712910")) && !"null".equals(antiFraudIndexJSON.getString("c8f0c66690712910"))){ mulBorAntifraudIndex.setANTIFRAUD_c66690712910(antiFraudIndexJSON.getString("c8f0c66690712910"));}
					if(antiFraudIndexJSON.containsKey("f074345211438ff0")&& antiFraudIndexJSON.getString("f074345211438ff0")!=null && !"".equals(antiFraudIndexJSON.getString("f074345211438ff0")) && !"null".equals(antiFraudIndexJSON.getString("f074345211438ff0"))){ mulBorAntifraudIndex.setANTIFRAUD_345211438ff0(antiFraudIndexJSON.getString("f074345211438ff0"));}
					if(antiFraudIndexJSON.containsKey("g33e17e6407b61a0")&& antiFraudIndexJSON.getString("g33e17e6407b61a0")!=null && !"".equals(antiFraudIndexJSON.getString("g33e17e6407b61a0")) && !"null".equals(antiFraudIndexJSON.getString("g33e17e6407b61a0"))){ mulBorAntifraudIndex.setANTIFRAUD_17e6407b61a0(antiFraudIndexJSON.getString("g33e17e6407b61a0"));}
					if(antiFraudIndexJSON.containsKey("ac1f65d9389b8af0")&& antiFraudIndexJSON.getString("ac1f65d9389b8af0")!=null && !"".equals(antiFraudIndexJSON.getString("ac1f65d9389b8af0")) && !"null".equals(antiFraudIndexJSON.getString("ac1f65d9389b8af0"))){ mulBorAntifraudIndex.setANTIFRAUD_65d9389b8af0(antiFraudIndexJSON.getString("ac1f65d9389b8af0"));}
					if(antiFraudIndexJSON.containsKey("a2bbaab6d8fb91b0")&& antiFraudIndexJSON.getString("a2bbaab6d8fb91b0")!=null && !"".equals(antiFraudIndexJSON.getString("a2bbaab6d8fb91b0")) && !"null".equals(antiFraudIndexJSON.getString("a2bbaab6d8fb91b0"))){ mulBorAntifraudIndex.setANTIFRAUD_aab6d8fb91b0(antiFraudIndexJSON.getString("a2bbaab6d8fb91b0"));}
					if(antiFraudIndexJSON.containsKey("a4be985b5ba42e40")&& antiFraudIndexJSON.getString("a4be985b5ba42e40")!=null && !"".equals(antiFraudIndexJSON.getString("a4be985b5ba42e40")) && !"null".equals(antiFraudIndexJSON.getString("a4be985b5ba42e40"))){ mulBorAntifraudIndex.setANTIFRAUD_985b5ba42e40(antiFraudIndexJSON.getString("a4be985b5ba42e40"));}
					if(antiFraudIndexJSON.containsKey("cd7ecf44bdae4ba0")&& antiFraudIndexJSON.getString("cd7ecf44bdae4ba0")!=null && !"".equals(antiFraudIndexJSON.getString("cd7ecf44bdae4ba0")) && !"null".equals(antiFraudIndexJSON.getString("cd7ecf44bdae4ba0"))){ mulBorAntifraudIndex.setANTIFRAUD_cf44bdae4ba0(antiFraudIndexJSON.getString("cd7ecf44bdae4ba0"));}
					if(antiFraudIndexJSON.containsKey("f559aa7668222f80")&& antiFraudIndexJSON.getString("f559aa7668222f80")!=null && !"".equals(antiFraudIndexJSON.getString("f559aa7668222f80")) && !"null".equals(antiFraudIndexJSON.getString("f559aa7668222f80"))){ mulBorAntifraudIndex.setANTIFRAUD_aa7668222f80(antiFraudIndexJSON.getString("f559aa7668222f80"));}
					if(antiFraudIndexJSON.containsKey("f2c3c50ff997ac10")&& antiFraudIndexJSON.getString("f2c3c50ff997ac10")!=null && !"".equals(antiFraudIndexJSON.getString("f2c3c50ff997ac10")) && !"null".equals(antiFraudIndexJSON.getString("f2c3c50ff997ac10"))){ mulBorAntifraudIndex.setANTIFRAUD_c50ff997ac10(antiFraudIndexJSON.getString("f2c3c50ff997ac10"));}
					if(antiFraudIndexJSON.containsKey("b7c4423d47136df0")&& antiFraudIndexJSON.getString("b7c4423d47136df0")!=null && !"".equals(antiFraudIndexJSON.getString("b7c4423d47136df0")) && !"null".equals(antiFraudIndexJSON.getString("b7c4423d47136df0"))){ mulBorAntifraudIndex.setANTIFRAUD_423d47136df0(antiFraudIndexJSON.getString("b7c4423d47136df0"));}
					if(antiFraudIndexJSON.containsKey("jbddc961bdc158c0")&& antiFraudIndexJSON.getString("jbddc961bdc158c0")!=null && !"".equals(antiFraudIndexJSON.getString("jbddc961bdc158c0")) && !"null".equals(antiFraudIndexJSON.getString("jbddc961bdc158c0"))){ mulBorAntifraudIndex.setANTIFRAUD_c961bdc158c0(antiFraudIndexJSON.getString("jbddc961bdc158c0"));}
					if(antiFraudIndexJSON.containsKey("h3bec7a2789758c0")&& antiFraudIndexJSON.getString("h3bec7a2789758c0")!=null && !"".equals(antiFraudIndexJSON.getString("h3bec7a2789758c0")) && !"null".equals(antiFraudIndexJSON.getString("h3bec7a2789758c0"))){ mulBorAntifraudIndex.setANTIFRAUD_c7a2789758c0(antiFraudIndexJSON.getString("h3bec7a2789758c0"));}
					if(antiFraudIndexJSON.containsKey("d44c12b48e2ad0d0")&& antiFraudIndexJSON.getString("d44c12b48e2ad0d0")!=null && !"".equals(antiFraudIndexJSON.getString("d44c12b48e2ad0d0")) && !"null".equals(antiFraudIndexJSON.getString("d44c12b48e2ad0d0"))){ mulBorAntifraudIndex.setANTIFRAUD_12b48e2ad0d0(antiFraudIndexJSON.getString("d44c12b48e2ad0d0"));}
					if(antiFraudIndexJSON.containsKey("c00a3e3266dff9a0")&& antiFraudIndexJSON.getString("c00a3e3266dff9a0")!=null && !"".equals(antiFraudIndexJSON.getString("c00a3e3266dff9a0")) && !"null".equals(antiFraudIndexJSON.getString("c00a3e3266dff9a0"))){ mulBorAntifraudIndex.setANTIFRAUD_3e3266dff9a0(antiFraudIndexJSON.getString("c00a3e3266dff9a0"));}
					if(antiFraudIndexJSON.containsKey("gc650dddf6531740")&& antiFraudIndexJSON.getString("gc650dddf6531740")!=null && !"".equals(antiFraudIndexJSON.getString("gc650dddf6531740")) && !"null".equals(antiFraudIndexJSON.getString("gc650dddf6531740"))){ mulBorAntifraudIndex.setANTIFRAUD_0dddf6531740(antiFraudIndexJSON.getString("gc650dddf6531740"));}
					if(antiFraudIndexJSON.containsKey("if965e8b36093271")&& antiFraudIndexJSON.getString("if965e8b36093271")!=null && !"".equals(antiFraudIndexJSON.getString("if965e8b36093271")) && !"null".equals(antiFraudIndexJSON.getString("if965e8b36093271"))){ mulBorAntifraudIndex.setANTIFRAUD_5e8b36093271(antiFraudIndexJSON.getString("if965e8b36093271"));}
					if(antiFraudIndexJSON.containsKey("efa20f17340bb3d1")&& antiFraudIndexJSON.getString("efa20f17340bb3d1")!=null && !"".equals(antiFraudIndexJSON.getString("efa20f17340bb3d1")) && !"null".equals(antiFraudIndexJSON.getString("efa20f17340bb3d1"))){ mulBorAntifraudIndex.setANTIFRAUD_0f17340bb3d1(antiFraudIndexJSON.getString("efa20f17340bb3d1"));}
					if(antiFraudIndexJSON.containsKey("e773f50d9a1534f1")&& antiFraudIndexJSON.getString("e773f50d9a1534f1")!=null && !"".equals(antiFraudIndexJSON.getString("e773f50d9a1534f1")) && !"null".equals(antiFraudIndexJSON.getString("e773f50d9a1534f1"))){ mulBorAntifraudIndex.setANTIFRAUD_f50d9a1534f1(antiFraudIndexJSON.getString("e773f50d9a1534f1"));}
					if(antiFraudIndexJSON.containsKey("dadd8b47333b60f1")&& antiFraudIndexJSON.getString("dadd8b47333b60f1")!=null && !"".equals(antiFraudIndexJSON.getString("dadd8b47333b60f1")) && !"null".equals(antiFraudIndexJSON.getString("dadd8b47333b60f1"))){ mulBorAntifraudIndex.setANTIFRAUD_8b47333b60f1(antiFraudIndexJSON.getString("dadd8b47333b60f1"));}
					if(antiFraudIndexJSON.containsKey("gb5d1063a6592601")&& antiFraudIndexJSON.getString("gb5d1063a6592601")!=null && !"".equals(antiFraudIndexJSON.getString("gb5d1063a6592601")) && !"null".equals(antiFraudIndexJSON.getString("gb5d1063a6592601"))){ mulBorAntifraudIndex.setANTIFRAUD_1063a6592601(antiFraudIndexJSON.getString("gb5d1063a6592601"));}
					if(antiFraudIndexJSON.containsKey("cf2291931fc33a61")&& antiFraudIndexJSON.getString("cf2291931fc33a61")!=null && !"".equals(antiFraudIndexJSON.getString("cf2291931fc33a61")) && !"null".equals(antiFraudIndexJSON.getString("cf2291931fc33a61"))){ mulBorAntifraudIndex.setANTIFRAUD_91931fc33a61(antiFraudIndexJSON.getString("cf2291931fc33a61"));}
					if(antiFraudIndexJSON.containsKey("d9c3de24c02f8481")&& antiFraudIndexJSON.getString("d9c3de24c02f8481")!=null && !"".equals(antiFraudIndexJSON.getString("d9c3de24c02f8481")) && !"null".equals(antiFraudIndexJSON.getString("d9c3de24c02f8481"))){ mulBorAntifraudIndex.setANTIFRAUD_de24c02f8481(antiFraudIndexJSON.getString("d9c3de24c02f8481"));}
					if(antiFraudIndexJSON.containsKey("b6a9ca08351cc511")&& antiFraudIndexJSON.getString("b6a9ca08351cc511")!=null && !"".equals(antiFraudIndexJSON.getString("b6a9ca08351cc511")) && !"null".equals(antiFraudIndexJSON.getString("b6a9ca08351cc511"))){ mulBorAntifraudIndex.setANTIFRAUD_ca08351cc511(antiFraudIndexJSON.getString("b6a9ca08351cc511"));}
					if(antiFraudIndexJSON.containsKey("a6e5e221f4f1e761")&& antiFraudIndexJSON.getString("a6e5e221f4f1e761")!=null && !"".equals(antiFraudIndexJSON.getString("a6e5e221f4f1e761")) && !"null".equals(antiFraudIndexJSON.getString("a6e5e221f4f1e761"))){ mulBorAntifraudIndex.setANTIFRAUD_e221f4f1e761(antiFraudIndexJSON.getString("a6e5e221f4f1e761"));}
					if(antiFraudIndexJSON.containsKey("g56fae4b0d59bdf1")&& antiFraudIndexJSON.getString("g56fae4b0d59bdf1")!=null && !"".equals(antiFraudIndexJSON.getString("g56fae4b0d59bdf1")) && !"null".equals(antiFraudIndexJSON.getString("g56fae4b0d59bdf1"))){ mulBorAntifraudIndex.setANTIFRAUD_ae4b0d59bdf1(antiFraudIndexJSON.getString("g56fae4b0d59bdf1"));}
					if(antiFraudIndexJSON.containsKey("cc8edd029e7c9b51")&& antiFraudIndexJSON.getString("cc8edd029e7c9b51")!=null && !"".equals(antiFraudIndexJSON.getString("cc8edd029e7c9b51")) && !"null".equals(antiFraudIndexJSON.getString("cc8edd029e7c9b51"))){ mulBorAntifraudIndex.setANTIFRAUD_dd029e7c9b51(antiFraudIndexJSON.getString("cc8edd029e7c9b51"));}
					if(antiFraudIndexJSON.containsKey("d346c8914cf84a01")&& antiFraudIndexJSON.getString("d346c8914cf84a01")!=null && !"".equals(antiFraudIndexJSON.getString("d346c8914cf84a01")) && !"null".equals(antiFraudIndexJSON.getString("d346c8914cf84a01"))){ mulBorAntifraudIndex.setANTIFRAUD_c8914cf84a01(antiFraudIndexJSON.getString("d346c8914cf84a01"));}
					if(antiFraudIndexJSON.containsKey("b5e2b9094b7f6931")&& antiFraudIndexJSON.getString("b5e2b9094b7f6931")!=null && !"".equals(antiFraudIndexJSON.getString("b5e2b9094b7f6931")) && !"null".equals(antiFraudIndexJSON.getString("b5e2b9094b7f6931"))){ mulBorAntifraudIndex.setANTIFRAUD_b9094b7f6931(antiFraudIndexJSON.getString("b5e2b9094b7f6931"));}
					if(antiFraudIndexJSON.containsKey("ifa9516bb59c3741")&& antiFraudIndexJSON.getString("ifa9516bb59c3741")!=null && !"".equals(antiFraudIndexJSON.getString("ifa9516bb59c3741")) && !"null".equals(antiFraudIndexJSON.getString("ifa9516bb59c3741"))){ mulBorAntifraudIndex.setANTIFRAUD_516bb59c3741(antiFraudIndexJSON.getString("ifa9516bb59c3741"));}
					if(antiFraudIndexJSON.containsKey("ce3e52a92783d1a1")&& antiFraudIndexJSON.getString("ce3e52a92783d1a1")!=null && !"".equals(antiFraudIndexJSON.getString("ce3e52a92783d1a1")) && !"null".equals(antiFraudIndexJSON.getString("ce3e52a92783d1a1"))){ mulBorAntifraudIndex.setANTIFRAUD_52a92783d1a1(antiFraudIndexJSON.getString("ce3e52a92783d1a1"));}
					if(antiFraudIndexJSON.containsKey("a46481a4cb14dcc0")&& antiFraudIndexJSON.getString("a46481a4cb14dcc0")!=null && !"".equals(antiFraudIndexJSON.getString("a46481a4cb14dcc0")) && !"null".equals(antiFraudIndexJSON.getString("a46481a4cb14dcc0"))){ mulBorAntifraudIndex.setANTIFRAUD_81a4cb14dcc0(antiFraudIndexJSON.getString("a46481a4cb14dcc0"));}
					if(antiFraudIndexJSON.containsKey("cb020b4c56afc4d0")&& antiFraudIndexJSON.getString("cb020b4c56afc4d0")!=null && !"".equals(antiFraudIndexJSON.getString("cb020b4c56afc4d0")) && !"null".equals(antiFraudIndexJSON.getString("cb020b4c56afc4d0"))){ mulBorAntifraudIndex.setANTIFRAUD_0b4c56afc4d0(antiFraudIndexJSON.getString("cb020b4c56afc4d0"));}
					if(antiFraudIndexJSON.containsKey("c7f15ef845f75c30")&& antiFraudIndexJSON.getString("c7f15ef845f75c30")!=null && !"".equals(antiFraudIndexJSON.getString("c7f15ef845f75c30")) && !"null".equals(antiFraudIndexJSON.getString("c7f15ef845f75c30"))){ mulBorAntifraudIndex.setANTIFRAUD_5ef845f75c30(antiFraudIndexJSON.getString("c7f15ef845f75c30"));}
					if(antiFraudIndexJSON.containsKey("ec6ed86123679f20")&& antiFraudIndexJSON.getString("ec6ed86123679f20")!=null && !"".equals(antiFraudIndexJSON.getString("ec6ed86123679f20")) && !"null".equals(antiFraudIndexJSON.getString("ec6ed86123679f20"))){ mulBorAntifraudIndex.setANTIFRAUD_d86123679f20(antiFraudIndexJSON.getString("ec6ed86123679f20"));}
					if(antiFraudIndexJSON.containsKey("b11e62085131a0e0")&& antiFraudIndexJSON.getString("b11e62085131a0e0")!=null && !"".equals(antiFraudIndexJSON.getString("b11e62085131a0e0")) && !"null".equals(antiFraudIndexJSON.getString("b11e62085131a0e0"))){ mulBorAntifraudIndex.setANTIFRAUD_62085131a0e0(antiFraudIndexJSON.getString("b11e62085131a0e0"));}
					if(antiFraudIndexJSON.containsKey("ed1002f0ce3c49b0")&& antiFraudIndexJSON.getString("ed1002f0ce3c49b0")!=null && !"".equals(antiFraudIndexJSON.getString("ed1002f0ce3c49b0")) && !"null".equals(antiFraudIndexJSON.getString("ed1002f0ce3c49b0"))){ mulBorAntifraudIndex.setANTIFRAUD_02f0ce3c49b0(antiFraudIndexJSON.getString("ed1002f0ce3c49b0"));}
					if(antiFraudIndexJSON.containsKey("e087b2adaba137f0")&& antiFraudIndexJSON.getString("e087b2adaba137f0")!=null && !"".equals(antiFraudIndexJSON.getString("e087b2adaba137f0")) && !"null".equals(antiFraudIndexJSON.getString("e087b2adaba137f0"))){ mulBorAntifraudIndex.setANTIFRAUD_b2adaba137f0(antiFraudIndexJSON.getString("e087b2adaba137f0"));}
					if(antiFraudIndexJSON.containsKey("c2123f24d3d821f0")&& antiFraudIndexJSON.getString("c2123f24d3d821f0")!=null && !"".equals(antiFraudIndexJSON.getString("c2123f24d3d821f0")) && !"null".equals(antiFraudIndexJSON.getString("c2123f24d3d821f0"))){ mulBorAntifraudIndex.setANTIFRAUD_3f24d3d821f0(antiFraudIndexJSON.getString("c2123f24d3d821f0"));}
					if(antiFraudIndexJSON.containsKey("i0b22184d215c1d0")&& antiFraudIndexJSON.getString("i0b22184d215c1d0")!=null && !"".equals(antiFraudIndexJSON.getString("i0b22184d215c1d0")) && !"null".equals(antiFraudIndexJSON.getString("i0b22184d215c1d0"))){ mulBorAntifraudIndex.setANTIFRAUD_2184d215c1d0(antiFraudIndexJSON.getString("i0b22184d215c1d0"));}
					if(antiFraudIndexJSON.containsKey("c653174f3daa7090")&& antiFraudIndexJSON.getString("c653174f3daa7090")!=null && !"".equals(antiFraudIndexJSON.getString("c653174f3daa7090")) && !"null".equals(antiFraudIndexJSON.getString("c653174f3daa7090"))){ mulBorAntifraudIndex.setANTIFRAUD_174f3daa7090(antiFraudIndexJSON.getString("c653174f3daa7090"));}
					if(antiFraudIndexJSON.containsKey("ec46840bea513490")&& antiFraudIndexJSON.getString("ec46840bea513490")!=null && !"".equals(antiFraudIndexJSON.getString("ec46840bea513490")) && !"null".equals(antiFraudIndexJSON.getString("ec46840bea513490"))){ mulBorAntifraudIndex.setANTIFRAUD_840bea513490(antiFraudIndexJSON.getString("ec46840bea513490"));}
					if(antiFraudIndexJSON.containsKey("fd9e250d6de8f150")&& antiFraudIndexJSON.getString("fd9e250d6de8f150")!=null && !"".equals(antiFraudIndexJSON.getString("fd9e250d6de8f150")) && !"null".equals(antiFraudIndexJSON.getString("fd9e250d6de8f150"))){ mulBorAntifraudIndex.setANTIFRAUD_250d6de8f150(antiFraudIndexJSON.getString("fd9e250d6de8f150"));}
					if(antiFraudIndexJSON.containsKey("ja43726655fe0e41")&& antiFraudIndexJSON.getString("ja43726655fe0e41")!=null && !"".equals(antiFraudIndexJSON.getString("ja43726655fe0e41")) && !"null".equals(antiFraudIndexJSON.getString("ja43726655fe0e41"))){ mulBorAntifraudIndex.setANTIFRAUD_726655fe0e41(antiFraudIndexJSON.getString("ja43726655fe0e41"));}
					if(antiFraudIndexJSON.containsKey("f421e8699ab64f11")&& antiFraudIndexJSON.getString("f421e8699ab64f11")!=null && !"".equals(antiFraudIndexJSON.getString("f421e8699ab64f11")) && !"null".equals(antiFraudIndexJSON.getString("f421e8699ab64f11"))){ mulBorAntifraudIndex.setANTIFRAUD_e8699ab64f11(antiFraudIndexJSON.getString("f421e8699ab64f11"));}
					if(antiFraudIndexJSON.containsKey("aa8b1a3acd9d8321")&& antiFraudIndexJSON.getString("aa8b1a3acd9d8321")!=null && !"".equals(antiFraudIndexJSON.getString("aa8b1a3acd9d8321")) && !"null".equals(antiFraudIndexJSON.getString("aa8b1a3acd9d8321"))){ mulBorAntifraudIndex.setANTIFRAUD_1a3acd9d8321(antiFraudIndexJSON.getString("aa8b1a3acd9d8321"));}
					if(antiFraudIndexJSON.containsKey("e368ae6341359221")&& antiFraudIndexJSON.getString("e368ae6341359221")!=null && !"".equals(antiFraudIndexJSON.getString("e368ae6341359221")) && !"null".equals(antiFraudIndexJSON.getString("e368ae6341359221"))){ mulBorAntifraudIndex.setANTIFRAUD_ae6341359221(antiFraudIndexJSON.getString("e368ae6341359221"));}
					if(antiFraudIndexJSON.containsKey("b41afcef6d5316c1")&& antiFraudIndexJSON.getString("b41afcef6d5316c1")!=null && !"".equals(antiFraudIndexJSON.getString("b41afcef6d5316c1")) && !"null".equals(antiFraudIndexJSON.getString("b41afcef6d5316c1"))){ mulBorAntifraudIndex.setANTIFRAUD_fcef6d5316c1(antiFraudIndexJSON.getString("b41afcef6d5316c1"));}
					if(antiFraudIndexJSON.containsKey("b4f431ebeae71ac1")&& antiFraudIndexJSON.getString("b4f431ebeae71ac1")!=null && !"".equals(antiFraudIndexJSON.getString("b4f431ebeae71ac1")) && !"null".equals(antiFraudIndexJSON.getString("b4f431ebeae71ac1"))){ mulBorAntifraudIndex.setANTIFRAUD_31ebeae71ac1(antiFraudIndexJSON.getString("b4f431ebeae71ac1"));}
					if(antiFraudIndexJSON.containsKey("j6c459ec64955f81")&& antiFraudIndexJSON.getString("j6c459ec64955f81")!=null && !"".equals(antiFraudIndexJSON.getString("j6c459ec64955f81")) && !"null".equals(antiFraudIndexJSON.getString("j6c459ec64955f81"))){ mulBorAntifraudIndex.setANTIFRAUD_59ec64955f81(antiFraudIndexJSON.getString("j6c459ec64955f81"));}
					if(antiFraudIndexJSON.containsKey("c49136e823180421")&& antiFraudIndexJSON.getString("c49136e823180421")!=null && !"".equals(antiFraudIndexJSON.getString("c49136e823180421")) && !"null".equals(antiFraudIndexJSON.getString("c49136e823180421"))){ mulBorAntifraudIndex.setANTIFRAUD_36e823180421(antiFraudIndexJSON.getString("c49136e823180421"));}
					if(antiFraudIndexJSON.containsKey("aea9565c88cef451")&& antiFraudIndexJSON.getString("aea9565c88cef451")!=null && !"".equals(antiFraudIndexJSON.getString("aea9565c88cef451")) && !"null".equals(antiFraudIndexJSON.getString("aea9565c88cef451"))){ mulBorAntifraudIndex.setANTIFRAUD_565c88cef451(antiFraudIndexJSON.getString("aea9565c88cef451"));}
					if(antiFraudIndexJSON.containsKey("f778a2ca08d0ad11")&& antiFraudIndexJSON.getString("f778a2ca08d0ad11")!=null && !"".equals(antiFraudIndexJSON.getString("f778a2ca08d0ad11")) && !"null".equals(antiFraudIndexJSON.getString("f778a2ca08d0ad11"))){ mulBorAntifraudIndex.setANTIFRAUD_a2ca08d0ad11(antiFraudIndexJSON.getString("f778a2ca08d0ad11"));}
					if(antiFraudIndexJSON.containsKey("f861aae68f6ed511")&& antiFraudIndexJSON.getString("f861aae68f6ed511")!=null && !"".equals(antiFraudIndexJSON.getString("f861aae68f6ed511")) && !"null".equals(antiFraudIndexJSON.getString("f861aae68f6ed511"))){ mulBorAntifraudIndex.setANTIFRAUD_aae68f6ed511(antiFraudIndexJSON.getString("f861aae68f6ed511"));}
					if(antiFraudIndexJSON.containsKey("da67206dcd7f7031")&& antiFraudIndexJSON.getString("da67206dcd7f7031")!=null && !"".equals(antiFraudIndexJSON.getString("da67206dcd7f7031")) && !"null".equals(antiFraudIndexJSON.getString("da67206dcd7f7031"))){ mulBorAntifraudIndex.setANTIFRAUD_206dcd7f7031(antiFraudIndexJSON.getString("da67206dcd7f7031"));}
					if(antiFraudIndexJSON.containsKey("bb9be12e97972ec1")&& antiFraudIndexJSON.getString("bb9be12e97972ec1")!=null && !"".equals(antiFraudIndexJSON.getString("bb9be12e97972ec1")) && !"null".equals(antiFraudIndexJSON.getString("bb9be12e97972ec1"))){ mulBorAntifraudIndex.setANTIFRAUD_e12e97972ec1(antiFraudIndexJSON.getString("bb9be12e97972ec1"));}
					if(antiFraudIndexJSON.containsKey("a49a920763cb9dd1")&& antiFraudIndexJSON.getString("a49a920763cb9dd1")!=null && !"".equals(antiFraudIndexJSON.getString("a49a920763cb9dd1")) && !"null".equals(antiFraudIndexJSON.getString("a49a920763cb9dd1"))){ mulBorAntifraudIndex.setANTIFRAUD_920763cb9dd1(antiFraudIndexJSON.getString("a49a920763cb9dd1"));}
					if(antiFraudIndexJSON.containsKey("fe6df7d48e7a7fd1")&& antiFraudIndexJSON.getString("fe6df7d48e7a7fd1")!=null && !"".equals(antiFraudIndexJSON.getString("fe6df7d48e7a7fd1")) && !"null".equals(antiFraudIndexJSON.getString("fe6df7d48e7a7fd1"))){ mulBorAntifraudIndex.setANTIFRAUD_f7d48e7a7fd1(antiFraudIndexJSON.getString("fe6df7d48e7a7fd1"));}
					if(antiFraudIndexJSON.containsKey("cbddeaeeb101a711")&& antiFraudIndexJSON.getString("cbddeaeeb101a711")!=null && !"".equals(antiFraudIndexJSON.getString("cbddeaeeb101a711")) && !"null".equals(antiFraudIndexJSON.getString("cbddeaeeb101a711"))){ mulBorAntifraudIndex.setANTIFRAUD_eaeeb101a711(antiFraudIndexJSON.getString("cbddeaeeb101a711"));}
					if(antiFraudIndexJSON.containsKey("i3bd2cc6fa284591")&& antiFraudIndexJSON.getString("i3bd2cc6fa284591")!=null && !"".equals(antiFraudIndexJSON.getString("i3bd2cc6fa284591")) && !"null".equals(antiFraudIndexJSON.getString("i3bd2cc6fa284591"))){ mulBorAntifraudIndex.setANTIFRAUD_2cc6fa284591(antiFraudIndexJSON.getString("i3bd2cc6fa284591"));}
					if(antiFraudIndexJSON.containsKey("ecf5d6c111317e71")&& antiFraudIndexJSON.getString("ecf5d6c111317e71")!=null && !"".equals(antiFraudIndexJSON.getString("ecf5d6c111317e71")) && !"null".equals(antiFraudIndexJSON.getString("ecf5d6c111317e71"))){ mulBorAntifraudIndex.setANTIFRAUD_d6c111317e71(antiFraudIndexJSON.getString("ecf5d6c111317e71"));}
					if(antiFraudIndexJSON.containsKey("c1e234310d985721")&& antiFraudIndexJSON.getString("c1e234310d985721")!=null && !"".equals(antiFraudIndexJSON.getString("c1e234310d985721")) && !"null".equals(antiFraudIndexJSON.getString("c1e234310d985721"))){ mulBorAntifraudIndex.setANTIFRAUD_34310d985721(antiFraudIndexJSON.getString("c1e234310d985721"));}
					if(antiFraudIndexJSON.containsKey("d04ce5c06632e511")&& antiFraudIndexJSON.getString("d04ce5c06632e511")!=null && !"".equals(antiFraudIndexJSON.getString("d04ce5c06632e511")) && !"null".equals(antiFraudIndexJSON.getString("d04ce5c06632e511"))){ mulBorAntifraudIndex.setANTIFRAUD_e5c06632e511(antiFraudIndexJSON.getString("d04ce5c06632e511"));}
					if(antiFraudIndexJSON.containsKey("b6618518b24e6d01")&& antiFraudIndexJSON.getString("b6618518b24e6d01")!=null && !"".equals(antiFraudIndexJSON.getString("b6618518b24e6d01")) && !"null".equals(antiFraudIndexJSON.getString("b6618518b24e6d01"))){ mulBorAntifraudIndex.setANTIFRAUD_8518b24e6d01(antiFraudIndexJSON.getString("b6618518b24e6d01"));}
					if(antiFraudIndexJSON.containsKey("e69470f6c6b1b550")&& antiFraudIndexJSON.getString("e69470f6c6b1b550")!=null && !"".equals(antiFraudIndexJSON.getString("e69470f6c6b1b550")) && !"null".equals(antiFraudIndexJSON.getString("e69470f6c6b1b550"))){ mulBorAntifraudIndex.setANTIFRAUD_70f6c6b1b550(antiFraudIndexJSON.getString("e69470f6c6b1b550"));}
					if(antiFraudIndexJSON.containsKey("c85cafb711bb1e80")&& antiFraudIndexJSON.getString("c85cafb711bb1e80")!=null && !"".equals(antiFraudIndexJSON.getString("c85cafb711bb1e80")) && !"null".equals(antiFraudIndexJSON.getString("c85cafb711bb1e80"))){ mulBorAntifraudIndex.setANTIFRAUD_afb711bb1e80(antiFraudIndexJSON.getString("c85cafb711bb1e80"));}
					if(antiFraudIndexJSON.containsKey("c7e7b9a7f3b1ba00")&& antiFraudIndexJSON.getString("c7e7b9a7f3b1ba00")!=null && !"".equals(antiFraudIndexJSON.getString("c7e7b9a7f3b1ba00")) && !"null".equals(antiFraudIndexJSON.getString("c7e7b9a7f3b1ba00"))){ mulBorAntifraudIndex.setANTIFRAUD_b9a7f3b1ba00(antiFraudIndexJSON.getString("c7e7b9a7f3b1ba00"));}
					if(antiFraudIndexJSON.containsKey("f9970577468331b0")&& antiFraudIndexJSON.getString("f9970577468331b0")!=null && !"".equals(antiFraudIndexJSON.getString("f9970577468331b0")) && !"null".equals(antiFraudIndexJSON.getString("f9970577468331b0"))){ mulBorAntifraudIndex.setANTIFRAUD_0577468331b0(antiFraudIndexJSON.getString("f9970577468331b0"));}
					if(antiFraudIndexJSON.containsKey("bb8a815d5462bb70")&& antiFraudIndexJSON.getString("bb8a815d5462bb70")!=null && !"".equals(antiFraudIndexJSON.getString("bb8a815d5462bb70")) && !"null".equals(antiFraudIndexJSON.getString("bb8a815d5462bb70"))){ mulBorAntifraudIndex.setANTIFRAUD_815d5462bb70(antiFraudIndexJSON.getString("bb8a815d5462bb70"));}
					if(antiFraudIndexJSON.containsKey("h458e3033d42ae10")&& antiFraudIndexJSON.getString("h458e3033d42ae10")!=null && !"".equals(antiFraudIndexJSON.getString("h458e3033d42ae10")) && !"null".equals(antiFraudIndexJSON.getString("h458e3033d42ae10"))){ mulBorAntifraudIndex.setANTIFRAUD_e3033d42ae10(antiFraudIndexJSON.getString("h458e3033d42ae10"));}
					if(antiFraudIndexJSON.containsKey("d57907fe4e9b86c0")&& antiFraudIndexJSON.getString("d57907fe4e9b86c0")!=null && !"".equals(antiFraudIndexJSON.getString("d57907fe4e9b86c0")) && !"null".equals(antiFraudIndexJSON.getString("d57907fe4e9b86c0"))){ mulBorAntifraudIndex.setANTIFRAUD_07fe4e9b86c0(antiFraudIndexJSON.getString("d57907fe4e9b86c0"));}
					if(antiFraudIndexJSON.containsKey("d1195439378f49e0")&& antiFraudIndexJSON.getString("d1195439378f49e0")!=null && !"".equals(antiFraudIndexJSON.getString("d1195439378f49e0")) && !"null".equals(antiFraudIndexJSON.getString("d1195439378f49e0"))){ mulBorAntifraudIndex.setANTIFRAUD_5439378f49e0(antiFraudIndexJSON.getString("d1195439378f49e0"));}
					if(antiFraudIndexJSON.containsKey("b6e896df341d7ac0")&& antiFraudIndexJSON.getString("b6e896df341d7ac0")!=null && !"".equals(antiFraudIndexJSON.getString("b6e896df341d7ac0")) && !"null".equals(antiFraudIndexJSON.getString("b6e896df341d7ac0"))){ mulBorAntifraudIndex.setANTIFRAUD_96df341d7ac0(antiFraudIndexJSON.getString("b6e896df341d7ac0"));}
					if(antiFraudIndexJSON.containsKey("j76369efe2ed0480")&& antiFraudIndexJSON.getString("j76369efe2ed0480")!=null && !"".equals(antiFraudIndexJSON.getString("j76369efe2ed0480")) && !"null".equals(antiFraudIndexJSON.getString("j76369efe2ed0480"))){ mulBorAntifraudIndex.setANTIFRAUD_69efe2ed0480(antiFraudIndexJSON.getString("j76369efe2ed0480"));}
					if(antiFraudIndexJSON.containsKey("c546dad774186b10")&& antiFraudIndexJSON.getString("c546dad774186b10")!=null && !"".equals(antiFraudIndexJSON.getString("c546dad774186b10")) && !"null".equals(antiFraudIndexJSON.getString("c546dad774186b10"))){ mulBorAntifraudIndex.setANTIFRAUD_dad774186b10(antiFraudIndexJSON.getString("c546dad774186b10"));}
					if(antiFraudIndexJSON.containsKey("bf3bc7c3de9ad0a0")&& antiFraudIndexJSON.getString("bf3bc7c3de9ad0a0")!=null && !"".equals(antiFraudIndexJSON.getString("bf3bc7c3de9ad0a0")) && !"null".equals(antiFraudIndexJSON.getString("bf3bc7c3de9ad0a0"))){ mulBorAntifraudIndex.setANTIFRAUD_c7c3de9ad0a0(antiFraudIndexJSON.getString("bf3bc7c3de9ad0a0"));}
					if(antiFraudIndexJSON.containsKey("d97fa55921ccfc30")&& antiFraudIndexJSON.getString("d97fa55921ccfc30")!=null && !"".equals(antiFraudIndexJSON.getString("d97fa55921ccfc30")) && !"null".equals(antiFraudIndexJSON.getString("d97fa55921ccfc30"))){ mulBorAntifraudIndex.setANTIFRAUD_a55921ccfc30(antiFraudIndexJSON.getString("d97fa55921ccfc30"));}
					if(antiFraudIndexJSON.containsKey("e7a29d43aeb5d4c0")&& antiFraudIndexJSON.getString("e7a29d43aeb5d4c0")!=null && !"".equals(antiFraudIndexJSON.getString("e7a29d43aeb5d4c0")) && !"null".equals(antiFraudIndexJSON.getString("e7a29d43aeb5d4c0"))){ mulBorAntifraudIndex.setANTIFRAUD_9d43aeb5d4c0(antiFraudIndexJSON.getString("e7a29d43aeb5d4c0"));}
					if(antiFraudIndexJSON.containsKey("e0cc633d1f0f3960")&& antiFraudIndexJSON.getString("e0cc633d1f0f3960")!=null && !"".equals(antiFraudIndexJSON.getString("e0cc633d1f0f3960")) && !"null".equals(antiFraudIndexJSON.getString("e0cc633d1f0f3960"))){ mulBorAntifraudIndex.setANTIFRAUD_633d1f0f3960(antiFraudIndexJSON.getString("e0cc633d1f0f3960"));}
					if(antiFraudIndexJSON.containsKey("jd57cc06e3fc9d80")&& antiFraudIndexJSON.getString("jd57cc06e3fc9d80")!=null && !"".equals(antiFraudIndexJSON.getString("jd57cc06e3fc9d80")) && !"null".equals(antiFraudIndexJSON.getString("jd57cc06e3fc9d80"))){ mulBorAntifraudIndex.setANTIFRAUD_cc06e3fc9d80(antiFraudIndexJSON.getString("jd57cc06e3fc9d80"));}
					if(antiFraudIndexJSON.containsKey("d4e11d0a2bdbc700")&& antiFraudIndexJSON.getString("d4e11d0a2bdbc700")!=null && !"".equals(antiFraudIndexJSON.getString("d4e11d0a2bdbc700")) && !"null".equals(antiFraudIndexJSON.getString("d4e11d0a2bdbc700"))){ mulBorAntifraudIndex.setANTIFRAUD_1d0a2bdbc700(antiFraudIndexJSON.getString("d4e11d0a2bdbc700"));}
					if(antiFraudIndexJSON.containsKey("ba8b37d86624c840")&& antiFraudIndexJSON.getString("ba8b37d86624c840")!=null && !"".equals(antiFraudIndexJSON.getString("ba8b37d86624c840")) && !"null".equals(antiFraudIndexJSON.getString("ba8b37d86624c840"))){ mulBorAntifraudIndex.setANTIFRAUD_37d86624c840(antiFraudIndexJSON.getString("ba8b37d86624c840"));}
					if(antiFraudIndexJSON.containsKey("c59458463101eec0")&& antiFraudIndexJSON.getString("c59458463101eec0")!=null && !"".equals(antiFraudIndexJSON.getString("c59458463101eec0")) && !"null".equals(antiFraudIndexJSON.getString("c59458463101eec0"))){ mulBorAntifraudIndex.setANTIFRAUD_58463101eec0(antiFraudIndexJSON.getString("c59458463101eec0"));}
					if(antiFraudIndexJSON.containsKey("ga0c2f22f31df6c0")&& antiFraudIndexJSON.getString("ga0c2f22f31df6c0")!=null && !"".equals(antiFraudIndexJSON.getString("ga0c2f22f31df6c0")) && !"null".equals(antiFraudIndexJSON.getString("ga0c2f22f31df6c0"))){ mulBorAntifraudIndex.setANTIFRAUD_2f22f31df6c0(antiFraudIndexJSON.getString("ga0c2f22f31df6c0"));}
					if(antiFraudIndexJSON.containsKey("d6690efc481c3e11")&& antiFraudIndexJSON.getString("d6690efc481c3e11")!=null && !"".equals(antiFraudIndexJSON.getString("d6690efc481c3e11")) && !"null".equals(antiFraudIndexJSON.getString("d6690efc481c3e11"))){ mulBorAntifraudIndex.setANTIFRAUD_0efc481c3e11(antiFraudIndexJSON.getString("d6690efc481c3e11"));}
					if(antiFraudIndexJSON.containsKey("dfb4b7cd97a99b91")&& antiFraudIndexJSON.getString("dfb4b7cd97a99b91")!=null && !"".equals(antiFraudIndexJSON.getString("dfb4b7cd97a99b91")) && !"null".equals(antiFraudIndexJSON.getString("dfb4b7cd97a99b91"))){ mulBorAntifraudIndex.setANTIFRAUD_b7cd97a99b91(antiFraudIndexJSON.getString("dfb4b7cd97a99b91"));}
					if(antiFraudIndexJSON.containsKey("d95ce55e23c04261")&& antiFraudIndexJSON.getString("d95ce55e23c04261")!=null && !"".equals(antiFraudIndexJSON.getString("d95ce55e23c04261")) && !"null".equals(antiFraudIndexJSON.getString("d95ce55e23c04261"))){ mulBorAntifraudIndex.setANTIFRAUD_e55e23c04261(antiFraudIndexJSON.getString("d95ce55e23c04261"));}
					if(antiFraudIndexJSON.containsKey("afa0381be99bdf81")&& antiFraudIndexJSON.getString("afa0381be99bdf81")!=null && !"".equals(antiFraudIndexJSON.getString("afa0381be99bdf81")) && !"null".equals(antiFraudIndexJSON.getString("afa0381be99bdf81"))){ mulBorAntifraudIndex.setANTIFRAUD_381be99bdf81(antiFraudIndexJSON.getString("afa0381be99bdf81"));}
					if(antiFraudIndexJSON.containsKey("ecdf4e28898eb2f1")&& antiFraudIndexJSON.getString("ecdf4e28898eb2f1")!=null && !"".equals(antiFraudIndexJSON.getString("ecdf4e28898eb2f1")) && !"null".equals(antiFraudIndexJSON.getString("ecdf4e28898eb2f1"))){ mulBorAntifraudIndex.setANTIFRAUD_4e28898eb2f1(antiFraudIndexJSON.getString("ecdf4e28898eb2f1"));}
					if(antiFraudIndexJSON.containsKey("bb79e9c90d961b81")&& antiFraudIndexJSON.getString("bb79e9c90d961b81")!=null && !"".equals(antiFraudIndexJSON.getString("bb79e9c90d961b81")) && !"null".equals(antiFraudIndexJSON.getString("bb79e9c90d961b81"))){ mulBorAntifraudIndex.setANTIFRAUD_e9c90d961b81(antiFraudIndexJSON.getString("bb79e9c90d961b81"));}
					if(antiFraudIndexJSON.containsKey("f3ab394a66802d50")&& antiFraudIndexJSON.getString("f3ab394a66802d50")!=null && !"".equals(antiFraudIndexJSON.getString("f3ab394a66802d50")) && !"null".equals(antiFraudIndexJSON.getString("f3ab394a66802d50"))){ mulBorAntifraudIndex.setANTIFRAUD_394a66802d50(antiFraudIndexJSON.getString("f3ab394a66802d50"));}
					if(antiFraudIndexJSON.containsKey("ef6dee676d6542c0")&& antiFraudIndexJSON.getString("ef6dee676d6542c0")!=null && !"".equals(antiFraudIndexJSON.getString("ef6dee676d6542c0")) && !"null".equals(antiFraudIndexJSON.getString("ef6dee676d6542c0"))){ mulBorAntifraudIndex.setANTIFRAUD_ee676d6542c0(antiFraudIndexJSON.getString("ef6dee676d6542c0"));}
					if(antiFraudIndexJSON.containsKey("d4ae4b95f0143420")&& antiFraudIndexJSON.getString("d4ae4b95f0143420")!=null && !"".equals(antiFraudIndexJSON.getString("d4ae4b95f0143420")) && !"null".equals(antiFraudIndexJSON.getString("d4ae4b95f0143420"))){ mulBorAntifraudIndex.setANTIFRAUD_4b95f0143420(antiFraudIndexJSON.getString("d4ae4b95f0143420"));}
					if(antiFraudIndexJSON.containsKey("cfccfa43ee1ea310")&& antiFraudIndexJSON.getString("cfccfa43ee1ea310")!=null && !"".equals(antiFraudIndexJSON.getString("cfccfa43ee1ea310")) && !"null".equals(antiFraudIndexJSON.getString("cfccfa43ee1ea310"))){ mulBorAntifraudIndex.setANTIFRAUD_fa43ee1ea310(antiFraudIndexJSON.getString("cfccfa43ee1ea310"));}
					if(antiFraudIndexJSON.containsKey("b559fd983032da40")&& antiFraudIndexJSON.getString("b559fd983032da40")!=null && !"".equals(antiFraudIndexJSON.getString("b559fd983032da40")) && !"null".equals(antiFraudIndexJSON.getString("b559fd983032da40"))){ mulBorAntifraudIndex.setANTIFRAUD_fd983032da40(antiFraudIndexJSON.getString("b559fd983032da40"));}
					if(antiFraudIndexJSON.containsKey("d87a326d3de30a90")&& antiFraudIndexJSON.getString("d87a326d3de30a90")!=null && !"".equals(antiFraudIndexJSON.getString("d87a326d3de30a90")) && !"null".equals(antiFraudIndexJSON.getString("d87a326d3de30a90"))){ mulBorAntifraudIndex.setANTIFRAUD_326d3de30a90(antiFraudIndexJSON.getString("d87a326d3de30a90"));}
					if(antiFraudIndexJSON.containsKey("hf4ca2cd59853fa0")&& antiFraudIndexJSON.getString("hf4ca2cd59853fa0")!=null && !"".equals(antiFraudIndexJSON.getString("hf4ca2cd59853fa0")) && !"null".equals(antiFraudIndexJSON.getString("hf4ca2cd59853fa0"))){ mulBorAntifraudIndex.setANTIFRAUD_a2cd59853fa0(antiFraudIndexJSON.getString("hf4ca2cd59853fa0"));}
					if(antiFraudIndexJSON.containsKey("hea58ed58d092710")&& antiFraudIndexJSON.getString("hea58ed58d092710")!=null && !"".equals(antiFraudIndexJSON.getString("hea58ed58d092710")) && !"null".equals(antiFraudIndexJSON.getString("hea58ed58d092710"))){ mulBorAntifraudIndex.setANTIFRAUD_8ed58d092710(antiFraudIndexJSON.getString("hea58ed58d092710"));}
					if(antiFraudIndexJSON.containsKey("d257afcbc297fc41")&& antiFraudIndexJSON.getString("d257afcbc297fc41")!=null && !"".equals(antiFraudIndexJSON.getString("d257afcbc297fc41")) && !"null".equals(antiFraudIndexJSON.getString("d257afcbc297fc41"))){ mulBorAntifraudIndex.setANTIFRAUD_afcbc297fc41(antiFraudIndexJSON.getString("d257afcbc297fc41"));}
					if(antiFraudIndexJSON.containsKey("g7f125091a670151")&& antiFraudIndexJSON.getString("g7f125091a670151")!=null && !"".equals(antiFraudIndexJSON.getString("g7f125091a670151")) && !"null".equals(antiFraudIndexJSON.getString("g7f125091a670151"))){ mulBorAntifraudIndex.setANTIFRAUD_25091a670151(antiFraudIndexJSON.getString("g7f125091a670151"));}
					if(antiFraudIndexJSON.containsKey("dcec7816c976d701")&& antiFraudIndexJSON.getString("dcec7816c976d701")!=null && !"".equals(antiFraudIndexJSON.getString("dcec7816c976d701")) && !"null".equals(antiFraudIndexJSON.getString("dcec7816c976d701"))){ mulBorAntifraudIndex.setANTIFRAUD_7816c976d701(antiFraudIndexJSON.getString("dcec7816c976d701"));}
					if(antiFraudIndexJSON.containsKey("b7591f3c7162fe71")&& antiFraudIndexJSON.getString("b7591f3c7162fe71")!=null && !"".equals(antiFraudIndexJSON.getString("b7591f3c7162fe71")) && !"null".equals(antiFraudIndexJSON.getString("b7591f3c7162fe71"))){ mulBorAntifraudIndex.setANTIFRAUD_1f3c7162fe71(antiFraudIndexJSON.getString("b7591f3c7162fe71"));}
					if(antiFraudIndexJSON.containsKey("ia50743e0c2cad61")&& antiFraudIndexJSON.getString("ia50743e0c2cad61")!=null && !"".equals(antiFraudIndexJSON.getString("ia50743e0c2cad61")) && !"null".equals(antiFraudIndexJSON.getString("ia50743e0c2cad61"))){ mulBorAntifraudIndex.setANTIFRAUD_743e0c2cad61(antiFraudIndexJSON.getString("ia50743e0c2cad61"));}
					if(antiFraudIndexJSON.containsKey("ebc9c7af4177d721")&& antiFraudIndexJSON.getString("ebc9c7af4177d721")!=null && !"".equals(antiFraudIndexJSON.getString("ebc9c7af4177d721")) && !"null".equals(antiFraudIndexJSON.getString("ebc9c7af4177d721"))){ mulBorAntifraudIndex.setANTIFRAUD_c7af4177d721(antiFraudIndexJSON.getString("ebc9c7af4177d721"));}
					if(antiFraudIndexJSON.containsKey("idb72ee5a02ffe70")&& antiFraudIndexJSON.getString("idb72ee5a02ffe70")!=null && !"".equals(antiFraudIndexJSON.getString("idb72ee5a02ffe70")) && !"null".equals(antiFraudIndexJSON.getString("idb72ee5a02ffe70"))){ mulBorAntifraudIndex.setANTIFRAUD_2ee5a02ffe70(antiFraudIndexJSON.getString("idb72ee5a02ffe70"));}
					if(antiFraudIndexJSON.containsKey("ia5dfa8229c60960")&& antiFraudIndexJSON.getString("ia5dfa8229c60960")!=null && !"".equals(antiFraudIndexJSON.getString("ia5dfa8229c60960")) && !"null".equals(antiFraudIndexJSON.getString("ia5dfa8229c60960"))){ mulBorAntifraudIndex.setANTIFRAUD_fa8229c60960(antiFraudIndexJSON.getString("ia5dfa8229c60960"));}
					if(antiFraudIndexJSON.containsKey("j539dcc8ee56fd90")&& antiFraudIndexJSON.getString("j539dcc8ee56fd90")!=null && !"".equals(antiFraudIndexJSON.getString("j539dcc8ee56fd90")) && !"null".equals(antiFraudIndexJSON.getString("j539dcc8ee56fd90"))){ mulBorAntifraudIndex.setANTIFRAUD_dcc8ee56fd90(antiFraudIndexJSON.getString("j539dcc8ee56fd90"));}
					if(antiFraudIndexJSON.containsKey("de6b66c0c946b530")&& antiFraudIndexJSON.getString("de6b66c0c946b530")!=null && !"".equals(antiFraudIndexJSON.getString("de6b66c0c946b530")) && !"null".equals(antiFraudIndexJSON.getString("de6b66c0c946b530"))){ mulBorAntifraudIndex.setANTIFRAUD_66c0c946b530(antiFraudIndexJSON.getString("de6b66c0c946b530"));}
					if(antiFraudIndexJSON.containsKey("d309c09e2cdbb0b0")&& antiFraudIndexJSON.getString("d309c09e2cdbb0b0")!=null && !"".equals(antiFraudIndexJSON.getString("d309c09e2cdbb0b0")) && !"null".equals(antiFraudIndexJSON.getString("d309c09e2cdbb0b0"))){ mulBorAntifraudIndex.setANTIFRAUD_c09e2cdbb0b0(antiFraudIndexJSON.getString("d309c09e2cdbb0b0"));}
					if(antiFraudIndexJSON.containsKey("f6fa769da8285e50")&& antiFraudIndexJSON.getString("f6fa769da8285e50")!=null && !"".equals(antiFraudIndexJSON.getString("f6fa769da8285e50")) && !"null".equals(antiFraudIndexJSON.getString("f6fa769da8285e50"))){ mulBorAntifraudIndex.setANTIFRAUD_769da8285e50(antiFraudIndexJSON.getString("f6fa769da8285e50"));}
					if(antiFraudIndexJSON.containsKey("g7d05404bf1f19f0")&& antiFraudIndexJSON.getString("g7d05404bf1f19f0")!=null && !"".equals(antiFraudIndexJSON.getString("g7d05404bf1f19f0")) && !"null".equals(antiFraudIndexJSON.getString("g7d05404bf1f19f0"))){ mulBorAntifraudIndex.setANTIFRAUD_5404bf1f19f0(antiFraudIndexJSON.getString("g7d05404bf1f19f0"));}
					if(antiFraudIndexJSON.containsKey("f4c427da67cb7130")&& antiFraudIndexJSON.getString("f4c427da67cb7130")!=null && !"".equals(antiFraudIndexJSON.getString("f4c427da67cb7130")) && !"null".equals(antiFraudIndexJSON.getString("f4c427da67cb7130"))){ mulBorAntifraudIndex.setANTIFRAUD_27da67cb7130(antiFraudIndexJSON.getString("f4c427da67cb7130"));}
					if(antiFraudIndexJSON.containsKey("j57f7330c7055f51")&& antiFraudIndexJSON.getString("j57f7330c7055f51")!=null && !"".equals(antiFraudIndexJSON.getString("j57f7330c7055f51")) && !"null".equals(antiFraudIndexJSON.getString("j57f7330c7055f51"))){ mulBorAntifraudIndex.setANTIFRAUD_7330c7055f51(antiFraudIndexJSON.getString("j57f7330c7055f51"));}
					if(antiFraudIndexJSON.containsKey("fd834b3e0de98881")&& antiFraudIndexJSON.getString("fd834b3e0de98881")!=null && !"".equals(antiFraudIndexJSON.getString("fd834b3e0de98881")) && !"null".equals(antiFraudIndexJSON.getString("fd834b3e0de98881"))){ mulBorAntifraudIndex.setANTIFRAUD_4b3e0de98881(antiFraudIndexJSON.getString("fd834b3e0de98881"));}
					if(antiFraudIndexJSON.containsKey("ebd7af70e5cc27f1")&& antiFraudIndexJSON.getString("ebd7af70e5cc27f1")!=null && !"".equals(antiFraudIndexJSON.getString("ebd7af70e5cc27f1")) && !"null".equals(antiFraudIndexJSON.getString("ebd7af70e5cc27f1"))){ mulBorAntifraudIndex.setANTIFRAUD_af70e5cc27f1(antiFraudIndexJSON.getString("ebd7af70e5cc27f1"));}
					if(antiFraudIndexJSON.containsKey("g69ef4be4b1bb551")&& antiFraudIndexJSON.getString("g69ef4be4b1bb551")!=null && !"".equals(antiFraudIndexJSON.getString("g69ef4be4b1bb551")) && !"null".equals(antiFraudIndexJSON.getString("g69ef4be4b1bb551"))){ mulBorAntifraudIndex.setANTIFRAUD_f4be4b1bb551(antiFraudIndexJSON.getString("g69ef4be4b1bb551"));}
					if(antiFraudIndexJSON.containsKey("h0f1d932dae554d1")&& antiFraudIndexJSON.getString("h0f1d932dae554d1")!=null && !"".equals(antiFraudIndexJSON.getString("h0f1d932dae554d1")) && !"null".equals(antiFraudIndexJSON.getString("h0f1d932dae554d1"))){ mulBorAntifraudIndex.setANTIFRAUD_d932dae554d1(antiFraudIndexJSON.getString("h0f1d932dae554d1"));}
					if(antiFraudIndexJSON.containsKey("a9dbff55f67ed591")&& antiFraudIndexJSON.getString("a9dbff55f67ed591")!=null && !"".equals(antiFraudIndexJSON.getString("a9dbff55f67ed591")) && !"null".equals(antiFraudIndexJSON.getString("a9dbff55f67ed591"))){ mulBorAntifraudIndex.setANTIFRAUD_ff55f67ed591(antiFraudIndexJSON.getString("a9dbff55f67ed591"));}
					if(antiFraudIndexJSON.containsKey("hed766c5c4c0de31")&& antiFraudIndexJSON.getString("hed766c5c4c0de31")!=null && !"".equals(antiFraudIndexJSON.getString("hed766c5c4c0de31")) && !"null".equals(antiFraudIndexJSON.getString("hed766c5c4c0de31"))){ mulBorAntifraudIndex.setANTIFRAUD_66c5c4c0de31(antiFraudIndexJSON.getString("hed766c5c4c0de31"));}
					if(antiFraudIndexJSON.containsKey("ea8123b3de194d81")&& antiFraudIndexJSON.getString("ea8123b3de194d81")!=null && !"".equals(antiFraudIndexJSON.getString("ea8123b3de194d81")) && !"null".equals(antiFraudIndexJSON.getString("ea8123b3de194d81"))){ mulBorAntifraudIndex.setANTIFRAUD_23b3de194d81(antiFraudIndexJSON.getString("ea8123b3de194d81"));}
					if(antiFraudIndexJSON.containsKey("c09f677cd4b9af21")&& antiFraudIndexJSON.getString("c09f677cd4b9af21")!=null && !"".equals(antiFraudIndexJSON.getString("c09f677cd4b9af21")) && !"null".equals(antiFraudIndexJSON.getString("c09f677cd4b9af21"))){ mulBorAntifraudIndex.setANTIFRAUD_677cd4b9af21(antiFraudIndexJSON.getString("c09f677cd4b9af21"));}
					if(antiFraudIndexJSON.containsKey("he721db660e01470")&& antiFraudIndexJSON.getString("he721db660e01470")!=null && !"".equals(antiFraudIndexJSON.getString("he721db660e01470")) && !"null".equals(antiFraudIndexJSON.getString("he721db660e01470"))){ mulBorAntifraudIndex.setANTIFRAUD_1db660e01470(antiFraudIndexJSON.getString("he721db660e01470"));}
					if(antiFraudIndexJSON.containsKey("ebda9160b72273f0")&& antiFraudIndexJSON.getString("ebda9160b72273f0")!=null && !"".equals(antiFraudIndexJSON.getString("ebda9160b72273f0")) && !"null".equals(antiFraudIndexJSON.getString("ebda9160b72273f0"))){ mulBorAntifraudIndex.setANTIFRAUD_9160b72273f0(antiFraudIndexJSON.getString("ebda9160b72273f0"));}
					if(antiFraudIndexJSON.containsKey("g3eb7e292bb6f130")&& antiFraudIndexJSON.getString("g3eb7e292bb6f130")!=null && !"".equals(antiFraudIndexJSON.getString("g3eb7e292bb6f130")) && !"null".equals(antiFraudIndexJSON.getString("g3eb7e292bb6f130"))){ mulBorAntifraudIndex.setANTIFRAUD_7e292bb6f130(antiFraudIndexJSON.getString("g3eb7e292bb6f130"));}
					if(antiFraudIndexJSON.containsKey("d190bd3985043c30")&& antiFraudIndexJSON.getString("d190bd3985043c30")!=null && !"".equals(antiFraudIndexJSON.getString("d190bd3985043c30")) && !"null".equals(antiFraudIndexJSON.getString("d190bd3985043c30"))){ mulBorAntifraudIndex.setANTIFRAUD_bd3985043c30(antiFraudIndexJSON.getString("d190bd3985043c30"));}
					if(antiFraudIndexJSON.containsKey("f549fa268e1ce520")&& antiFraudIndexJSON.getString("f549fa268e1ce520")!=null && !"".equals(antiFraudIndexJSON.getString("f549fa268e1ce520")) && !"null".equals(antiFraudIndexJSON.getString("f549fa268e1ce520"))){ mulBorAntifraudIndex.setANTIFRAUD_fa268e1ce520(antiFraudIndexJSON.getString("f549fa268e1ce520"));}
					if(antiFraudIndexJSON.containsKey("e4ca1e56549b4d40")&& antiFraudIndexJSON.getString("e4ca1e56549b4d40")!=null && !"".equals(antiFraudIndexJSON.getString("e4ca1e56549b4d40")) && !"null".equals(antiFraudIndexJSON.getString("e4ca1e56549b4d40"))){ mulBorAntifraudIndex.setANTIFRAUD_1e56549b4d40(antiFraudIndexJSON.getString("e4ca1e56549b4d40"));}
					if(antiFraudIndexJSON.containsKey("d5eeb69d97c53570")&& antiFraudIndexJSON.getString("d5eeb69d97c53570")!=null && !"".equals(antiFraudIndexJSON.getString("d5eeb69d97c53570")) && !"null".equals(antiFraudIndexJSON.getString("d5eeb69d97c53570"))){ mulBorAntifraudIndex.setANTIFRAUD_b69d97c53570(antiFraudIndexJSON.getString("d5eeb69d97c53570"));}
					if(antiFraudIndexJSON.containsKey("h8fffb7e7da3d670")&& antiFraudIndexJSON.getString("h8fffb7e7da3d670")!=null && !"".equals(antiFraudIndexJSON.getString("h8fffb7e7da3d670")) && !"null".equals(antiFraudIndexJSON.getString("h8fffb7e7da3d670"))){ mulBorAntifraudIndex.setANTIFRAUD_fb7e7da3d670(antiFraudIndexJSON.getString("h8fffb7e7da3d670"));}
					if(antiFraudIndexJSON.containsKey("b123f1fc1d33c0f0")&& antiFraudIndexJSON.getString("b123f1fc1d33c0f0")!=null && !"".equals(antiFraudIndexJSON.getString("b123f1fc1d33c0f0")) && !"null".equals(antiFraudIndexJSON.getString("b123f1fc1d33c0f0"))){ mulBorAntifraudIndex.setANTIFRAUD_f1fc1d33c0f0(antiFraudIndexJSON.getString("b123f1fc1d33c0f0"));}
					if(antiFraudIndexJSON.containsKey("ef859f8618f2d0e0")&& antiFraudIndexJSON.getString("ef859f8618f2d0e0")!=null && !"".equals(antiFraudIndexJSON.getString("ef859f8618f2d0e0")) && !"null".equals(antiFraudIndexJSON.getString("ef859f8618f2d0e0"))){ mulBorAntifraudIndex.setANTIFRAUD_9f8618f2d0e0(antiFraudIndexJSON.getString("ef859f8618f2d0e0"));}
					if(antiFraudIndexJSON.containsKey("b87f681952a89ff0")&& antiFraudIndexJSON.getString("b87f681952a89ff0")!=null && !"".equals(antiFraudIndexJSON.getString("b87f681952a89ff0")) && !"null".equals(antiFraudIndexJSON.getString("b87f681952a89ff0"))){ mulBorAntifraudIndex.setANTIFRAUD_681952a89ff0(antiFraudIndexJSON.getString("b87f681952a89ff0"));}
					if(antiFraudIndexJSON.containsKey("f10f8d1df12ce690")&& antiFraudIndexJSON.getString("f10f8d1df12ce690")!=null && !"".equals(antiFraudIndexJSON.getString("f10f8d1df12ce690")) && !"null".equals(antiFraudIndexJSON.getString("f10f8d1df12ce690"))){ mulBorAntifraudIndex.setANTIFRAUD_8d1df12ce690(antiFraudIndexJSON.getString("f10f8d1df12ce690"));}
					if(antiFraudIndexJSON.containsKey("b0d31a3a932f9b01")&& antiFraudIndexJSON.getString("b0d31a3a932f9b01")!=null && !"".equals(antiFraudIndexJSON.getString("b0d31a3a932f9b01")) && !"null".equals(antiFraudIndexJSON.getString("b0d31a3a932f9b01"))){ mulBorAntifraudIndex.setANTIFRAUD_1a3a932f9b01(antiFraudIndexJSON.getString("b0d31a3a932f9b01"));}
					if(antiFraudIndexJSON.containsKey("j5efe03aba035c61")&& antiFraudIndexJSON.getString("j5efe03aba035c61")!=null && !"".equals(antiFraudIndexJSON.getString("j5efe03aba035c61")) && !"null".equals(antiFraudIndexJSON.getString("j5efe03aba035c61"))){ mulBorAntifraudIndex.setANTIFRAUD_e03aba035c61(antiFraudIndexJSON.getString("j5efe03aba035c61"));}
					if(antiFraudIndexJSON.containsKey("a6843dea83e7b431")&& antiFraudIndexJSON.getString("a6843dea83e7b431")!=null && !"".equals(antiFraudIndexJSON.getString("a6843dea83e7b431")) && !"null".equals(antiFraudIndexJSON.getString("a6843dea83e7b431"))){ mulBorAntifraudIndex.setANTIFRAUD_3dea83e7b431(antiFraudIndexJSON.getString("a6843dea83e7b431"));}
					if(antiFraudIndexJSON.containsKey("d5a1d0d0d3a1afe0")&& antiFraudIndexJSON.getString("d5a1d0d0d3a1afe0")!=null && !"".equals(antiFraudIndexJSON.getString("d5a1d0d0d3a1afe0")) && !"null".equals(antiFraudIndexJSON.getString("d5a1d0d0d3a1afe0"))){ mulBorAntifraudIndex.setANTIFRAUD_d0d0d3a1afe0(antiFraudIndexJSON.getString("d5a1d0d0d3a1afe0"));}
					if(antiFraudIndexJSON.containsKey("gcba727c2b9eef50")&& antiFraudIndexJSON.getString("gcba727c2b9eef50")!=null && !"".equals(antiFraudIndexJSON.getString("gcba727c2b9eef50")) && !"null".equals(antiFraudIndexJSON.getString("gcba727c2b9eef50"))){ mulBorAntifraudIndex.setANTIFRAUD_727c2b9eef50(antiFraudIndexJSON.getString("gcba727c2b9eef50"));}
					if(antiFraudIndexJSON.containsKey("f25106bf8ab91910")&& antiFraudIndexJSON.getString("f25106bf8ab91910")!=null && !"".equals(antiFraudIndexJSON.getString("f25106bf8ab91910")) && !"null".equals(antiFraudIndexJSON.getString("f25106bf8ab91910"))){ mulBorAntifraudIndex.setANTIFRAUD_06bf8ab91910(antiFraudIndexJSON.getString("f25106bf8ab91910"));}
					if(antiFraudIndexJSON.containsKey("a512b563fa4a8aa0")&& antiFraudIndexJSON.getString("a512b563fa4a8aa0")!=null && !"".equals(antiFraudIndexJSON.getString("a512b563fa4a8aa0")) && !"null".equals(antiFraudIndexJSON.getString("a512b563fa4a8aa0"))){ mulBorAntifraudIndex.setANTIFRAUD_b563fa4a8aa0(antiFraudIndexJSON.getString("a512b563fa4a8aa0"));}
					if(antiFraudIndexJSON.containsKey("c8a1395dfd22f26d")&& antiFraudIndexJSON.getString("c8a1395dfd22f26d")!=null && !"".equals(antiFraudIndexJSON.getString("c8a1395dfd22f26d")) && !"null".equals(antiFraudIndexJSON.getString("c8a1395dfd22f26d"))){ mulBorAntifraudIndex.setANTIFRAUD_395dfd22f26d(antiFraudIndexJSON.getString("c8a1395dfd22f26d"));}
					if(antiFraudIndexJSON.containsKey("adb92dbdf137424f")&& antiFraudIndexJSON.getString("adb92dbdf137424f")!=null && !"".equals(antiFraudIndexJSON.getString("adb92dbdf137424f")) && !"null".equals(antiFraudIndexJSON.getString("adb92dbdf137424f"))){ mulBorAntifraudIndex.setANTIFRAUD_2dbdf137424f(antiFraudIndexJSON.getString("adb92dbdf137424f"));}
					if(antiFraudIndexJSON.containsKey("af66000b8adf3484")&& antiFraudIndexJSON.getString("af66000b8adf3484")!=null && !"".equals(antiFraudIndexJSON.getString("af66000b8adf3484")) && !"null".equals(antiFraudIndexJSON.getString("af66000b8adf3484"))){ mulBorAntifraudIndex.setANTIFRAUD_000b8adf3484(antiFraudIndexJSON.getString("af66000b8adf3484"));}
					if(antiFraudIndexJSON.containsKey("17aff5b35b30910c")&& antiFraudIndexJSON.getString("17aff5b35b30910c")!=null && !"".equals(antiFraudIndexJSON.getString("17aff5b35b30910c")) && !"null".equals(antiFraudIndexJSON.getString("17aff5b35b30910c"))){ mulBorAntifraudIndex.setANTIFRAUD_f5b35b30910c(antiFraudIndexJSON.getString("17aff5b35b30910c"));}
					if(antiFraudIndexJSON.containsKey("13594daf6e6d17d9")&& antiFraudIndexJSON.getString("13594daf6e6d17d9")!=null && !"".equals(antiFraudIndexJSON.getString("13594daf6e6d17d9")) && !"null".equals(antiFraudIndexJSON.getString("13594daf6e6d17d9"))){ mulBorAntifraudIndex.setANTIFRAUD_4daf6e6d17d9(antiFraudIndexJSON.getString("13594daf6e6d17d9"));}
					if(antiFraudIndexJSON.containsKey("2b4e09e30f820b20")&& antiFraudIndexJSON.getString("2b4e09e30f820b20")!=null && !"".equals(antiFraudIndexJSON.getString("2b4e09e30f820b20")) && !"null".equals(antiFraudIndexJSON.getString("2b4e09e30f820b20"))){ mulBorAntifraudIndex.setANTIFRAUD_09e30f820b20(antiFraudIndexJSON.getString("2b4e09e30f820b20"));}
					if(antiFraudIndexJSON.containsKey("09ba80a75fbf9e92")&& antiFraudIndexJSON.getString("09ba80a75fbf9e92")!=null && !"".equals(antiFraudIndexJSON.getString("09ba80a75fbf9e92")) && !"null".equals(antiFraudIndexJSON.getString("09ba80a75fbf9e92"))){ mulBorAntifraudIndex.setANTIFRAUD_80a75fbf9e92(antiFraudIndexJSON.getString("09ba80a75fbf9e92"));}
					if(antiFraudIndexJSON.containsKey("0b5bc82d025af778")&& antiFraudIndexJSON.getString("0b5bc82d025af778")!=null && !"".equals(antiFraudIndexJSON.getString("0b5bc82d025af778")) && !"null".equals(antiFraudIndexJSON.getString("0b5bc82d025af778"))){ mulBorAntifraudIndex.setANTIFRAUD_c82d025af778(antiFraudIndexJSON.getString("0b5bc82d025af778"));}
					if(antiFraudIndexJSON.containsKey("86442bf1553fd109")&& antiFraudIndexJSON.getString("86442bf1553fd109")!=null && !"".equals(antiFraudIndexJSON.getString("86442bf1553fd109")) && !"null".equals(antiFraudIndexJSON.getString("86442bf1553fd109"))){ mulBorAntifraudIndex.setANTIFRAUD_2bf1553fd109(antiFraudIndexJSON.getString("86442bf1553fd109"));}
					if(antiFraudIndexJSON.containsKey("1c55f0745989f331")&& antiFraudIndexJSON.getString("1c55f0745989f331")!=null && !"".equals(antiFraudIndexJSON.getString("1c55f0745989f331")) && !"null".equals(antiFraudIndexJSON.getString("1c55f0745989f331"))){ mulBorAntifraudIndex.setANTIFRAUD_f0745989f331(antiFraudIndexJSON.getString("1c55f0745989f331"));}
					if(antiFraudIndexJSON.containsKey("5e7e10848867ef88")&& antiFraudIndexJSON.getString("5e7e10848867ef88")!=null && !"".equals(antiFraudIndexJSON.getString("5e7e10848867ef88")) && !"null".equals(antiFraudIndexJSON.getString("5e7e10848867ef88"))){ mulBorAntifraudIndex.setANTIFRAUD_10848867ef88(antiFraudIndexJSON.getString("5e7e10848867ef88"));}
					if(antiFraudIndexJSON.containsKey("44e0d9d16344e7b6")&& antiFraudIndexJSON.getString("44e0d9d16344e7b6")!=null && !"".equals(antiFraudIndexJSON.getString("44e0d9d16344e7b6")) && !"null".equals(antiFraudIndexJSON.getString("44e0d9d16344e7b6"))){ mulBorAntifraudIndex.setANTIFRAUD_d9d16344e7b6(antiFraudIndexJSON.getString("44e0d9d16344e7b6"));}
					if(antiFraudIndexJSON.containsKey("532a809320c9ea49")&& antiFraudIndexJSON.getString("532a809320c9ea49")!=null && !"".equals(antiFraudIndexJSON.getString("532a809320c9ea49")) && !"null".equals(antiFraudIndexJSON.getString("532a809320c9ea49"))){ mulBorAntifraudIndex.setANTIFRAUD_809320c9ea49(antiFraudIndexJSON.getString("532a809320c9ea49"));}
					if(antiFraudIndexJSON.containsKey("2799dd5b8c368641")&& antiFraudIndexJSON.getString("2799dd5b8c368641")!=null && !"".equals(antiFraudIndexJSON.getString("2799dd5b8c368641")) && !"null".equals(antiFraudIndexJSON.getString("2799dd5b8c368641"))){ mulBorAntifraudIndex.setANTIFRAUD_dd5b8c368641(antiFraudIndexJSON.getString("2799dd5b8c368641"));}
					if(antiFraudIndexJSON.containsKey("22922410e2596228")&& antiFraudIndexJSON.getString("22922410e2596228")!=null && !"".equals(antiFraudIndexJSON.getString("22922410e2596228")) && !"null".equals(antiFraudIndexJSON.getString("22922410e2596228"))){ mulBorAntifraudIndex.setANTIFRAUD_2410e2596228(antiFraudIndexJSON.getString("22922410e2596228"));}
					if(antiFraudIndexJSON.containsKey("0a5fe57dd0908fe5")&& antiFraudIndexJSON.getString("0a5fe57dd0908fe5")!=null && !"".equals(antiFraudIndexJSON.getString("0a5fe57dd0908fe5")) && !"null".equals(antiFraudIndexJSON.getString("0a5fe57dd0908fe5"))){ mulBorAntifraudIndex.setANTIFRAUD_e57dd0908fe5(antiFraudIndexJSON.getString("0a5fe57dd0908fe5"));}
	
//					System.err.println(mulBorAntifraudIndex.toString());
					mulborInfo.setMulBorAntifraudIndex(mulBorAntifraudIndex);

				}
			}
			
			if (resultDescJSON.containsKey("error_info") && resultDescJSON.getString("error_info") != null
					&& !"".equals(resultDescJSON.getString("error_info"))) {
				basetable.setErrorInfo(resultDescJSON.getString("error_info"));
//				System.err.println(basetable.toString());
				mulborInfo.setMulBorBase(basetable);
				return mulborInfo;
			}
			if (resultDescJSON.containsKey("final_score") && resultDescJSON.getString("final_score") != null
					&& !"".equals(resultDescJSON.getString("final_score"))) {
				basetable.setFinalScore(resultDescJSON.getInt("final_score"));
			}
			if (resultDescJSON.containsKey("final_decision") && resultDescJSON.getString("final_decision") != null
					&& !"".equals(resultDescJSON.getString("final_decision"))) {
				basetable.setFinalDecision(resultDescJSON.getString("final_decision"));
			}
			JSONObject outputJSON = new JSONObject();
			if (resultDescJSON.containsKey("output_fields") && resultDescJSON.getString("output_fields") != null
					&& !"".equals(resultDescJSON.getString("output_fields"))) {
				outputJSON = JSONObject.fromObject(resultDescJSON.getString("output_fields"));
			}
			JSONArray riskItems = new JSONArray();
			if (resultDescJSON.containsKey("risk_items") && resultDescJSON.getString("risk_items") != null
					&& !"".equals(resultDescJSON.getString("risk_items"))) {
				riskItems = JSONArray.fromObject(resultDescJSON.getString("risk_items"));
			}

			if (outputJSON.containsKey("ext_id_court_close_risk_1")
					&& outputJSON.getString("ext_id_court_close_risk_1") != null
					&& !"".equals(outputJSON.getString("ext_id_court_close_risk_1"))) {
				basetable.setCourtCloseRisk1(outputJSON.getString("ext_id_court_close_risk_1"));
			}
			if (outputJSON.containsKey("ext_id_overdue_risk_2") && outputJSON.getString("ext_id_overdue_risk_2") != null
					&& !"".equals(outputJSON.getString("ext_id_overdue_risk_2"))) {
				basetable.setOverdueRisk2(outputJSON.getString("ext_id_overdue_risk_2"));
			}
			if (outputJSON.containsKey("ext_id_court_risk_3") && outputJSON.getString("ext_id_court_risk_3") != null
					&& !"".equals(outputJSON.getString("ext_id_court_risk_3"))) {
				basetable.setCourtRisk3(outputJSON.getString("ext_id_court_risk_3"));
			}
			if (outputJSON.containsKey("ext_id_overdue_repay_risk_4")
					&& outputJSON.getString("ext_id_overdue_repay_risk_4") != null
					&& !"".equals(outputJSON.getString("ext_id_overdue_repay_risk_4"))) {
				basetable.setOverdueRepayRisk4(outputJSON.getString("ext_id_overdue_repay_risk_4"));
			}
			if (outputJSON.containsKey("ext_id_company_taxowing_risk_5")
					&& outputJSON.getString("ext_id_company_taxowing_risk_5") != null
					&& !"".equals(outputJSON.getString("ext_id_company_taxowing_risk_5"))) {
				basetable.setCompanyTaxowingRisk5(outputJSON.getString("ext_id_company_taxowing_risk_5"));
			}
			if (outputJSON.containsKey("ext_id_court_zhixing_risk_6")
					&& outputJSON.getString("ext_id_court_zhixing_risk_6") != null
					&& !"".equals(outputJSON.getString("ext_id_court_zhixing_risk_6"))) {
				basetable.setCourtZhixingRisk6(outputJSON.getString("ext_id_court_zhixing_risk_6"));
			}
			if (outputJSON.containsKey("ext_id_car_loan_risk_7")
					&& outputJSON.getString("ext_id_car_loan_risk_7") != null
					&& !"".equals(outputJSON.getString("ext_id_car_loan_risk_7"))) {
				basetable.setCarLoanRisk7(outputJSON.getString("ext_id_car_loan_risk_7"));
			}
			if (outputJSON.containsKey("ext_id_tax_owing_risk_8")
					&& outputJSON.getString("ext_id_tax_owing_risk_8") != null
					&& !"".equals(outputJSON.getString("ext_id_tax_owing_risk_8"))) {
				basetable.setTaxOwingRisk8(outputJSON.getString("ext_id_tax_owing_risk_8"));
			}
			if (outputJSON.containsKey("ext_id_crime_risk_9") && outputJSON.getString("ext_id_crime_risk_9") != null
					&& !"".equals(outputJSON.getString("ext_id_crime_risk_9"))) {
				basetable.setCrimeRisk9(outputJSON.getString("ext_id_crime_risk_9"));
			}
			if (outputJSON.containsKey("ext_id_student_loan_risk_10")
					&& outputJSON.getString("ext_id_student_loan_risk_10") != null
					&& !"".equals(outputJSON.getString("ext_id_student_loan_risk_10"))) {
				basetable.setStudentLoanRisk10(outputJSON.getString("ext_id_student_loan_risk_10"));
			}
			if (outputJSON.containsKey("ext_id_vehicle_lease_default_risk_11")
					&& outputJSON.getString("ext_id_vehicle_lease_default_risk_11") != null
					&& !"".equals(outputJSON.getString("ext_id_vehicle_lease_default_risk_11"))) {
				basetable.setVehicleLeaseDefaultRisk11(outputJSON.getString("ext_id_vehicle_lease_default_risk_11"));
			}
			if (outputJSON.containsKey("ext_id_company_paying_risk_12")
					&& outputJSON.getString("ext_id_company_paying_risk_12") != null
					&& !"".equals(outputJSON.getString("ext_id_company_paying_risk_12"))) {
				basetable.setCompanyPayingRisk12(outputJSON.getString("ext_id_company_paying_risk_12"));
			}
			if (outputJSON.containsKey("ext_id_deliberate_violation_risk_13")
					&& outputJSON.getString("ext_id_deliberate_violation_risk_13") != null
					&& !"".equals(outputJSON.getString("ext_id_deliberate_violation_risk_13"))) {
				basetable.setDeliberateViolationRisk13(outputJSON.getString("ext_id_deliberate_violation_risk_13"));
			}
			if (outputJSON.containsKey("ext_m_false_mobile_risk_14")
					&& outputJSON.getString("ext_m_false_mobile_risk_14") != null
					&& !"".equals(outputJSON.getString("ext_m_false_mobile_risk_14"))) {
				basetable.setFalseMobileRisk14(outputJSON.getString("ext_m_false_mobile_risk_14"));
			}
			if (outputJSON.containsKey("ext_m_alimobile_risk_15")
					&& outputJSON.getString("ext_m_alimobile_risk_15") != null
					&& !"".equals(outputJSON.getString("ext_m_alimobile_risk_15"))) {
				basetable.setAlimobileRisk15(outputJSON.getString("ext_m_alimobile_risk_15"));
			}
			if (outputJSON.containsKey("ext_m_overdue_risk_16") && outputJSON.getString("ext_m_overdue_risk_16") != null
					&& !"".equals(outputJSON.getString("ext_m_overdue_risk_16"))) {
				basetable.setOverdueRisk16(outputJSON.getString("ext_m_overdue_risk_16"));
			}
			if (outputJSON.containsKey("ext_m_vehicle_lease_default_risk_17")
					&& outputJSON.getString("ext_m_vehicle_lease_default_risk_17") != null
					&& !"".equals(outputJSON.getString("ext_m_vehicle_lease_default_risk_17"))) {
				basetable.setVehicleLeaseDefaultRisk17(outputJSON.getString("ext_m_vehicle_lease_default_risk_17"));
			}
			if (outputJSON.containsKey("ext_m_company_paying_risk_18")
					&& outputJSON.getString("ext_m_company_paying_risk_18") != null
					&& !"".equals(outputJSON.getString("ext_m_company_paying_risk_18"))) {
				basetable.setCompanyPayingRisk18(outputJSON.getString("ext_m_company_paying_risk_18"));
			}
			if (outputJSON.containsKey("ext_m_overdue_repay_risk_19")
					&& outputJSON.getString("ext_m_overdue_repay_risk_19") != null
					&& !"".equals(outputJSON.getString("ext_m_overdue_repay_risk_19"))) {
				basetable.setOverdueRepayRisk19(outputJSON.getString("ext_m_overdue_repay_risk_19"));
			}
			if (outputJSON.containsKey("ext_id_follow_high_20") && outputJSON.getString("ext_id_follow_high_20") != null
					&& !"".equals(outputJSON.getString("ext_id_follow_high_20"))) {
				basetable.setFollowHigh20(outputJSON.getString("ext_id_follow_high_20"));
			}
			if (outputJSON.containsKey("ext_id_follow_medium_21")
					&& outputJSON.getString("ext_id_follow_medium_21") != null
					&& !"".equals(outputJSON.getString("ext_id_follow_medium_21"))) {
				basetable.setFollowMedium21(outputJSON.getString("ext_id_follow_medium_21"));
			}
			if (outputJSON.containsKey("ext_id_follow_low_22") && outputJSON.getString("ext_id_follow_low_22") != null
					&& !"".equals(outputJSON.getString("ext_id_follow_low_22"))) {
				basetable.setFollowLow22(outputJSON.getString("ext_id_follow_low_22"));
			}
			if (outputJSON.containsKey("ext_m_follow_high_23") && outputJSON.getString("ext_m_follow_high_23") != null
					&& !"".equals(outputJSON.getString("ext_m_follow_high_23"))) {
				basetable.setFollowHigh23(outputJSON.getString("ext_m_follow_high_23"));
			}
			if (outputJSON.containsKey("ext_m_follow_medium_24")
					&& outputJSON.getString("ext_m_follow_medium_24") != null
					&& !"".equals(outputJSON.getString("ext_m_follow_medium_24"))) {
				basetable.setFollowMedium24(outputJSON.getString("ext_m_follow_medium_24"));
			}
			if (outputJSON.containsKey("ext_m_follow_low_25") && outputJSON.getString("ext_m_follow_low_25") != null
					&& !"".equals(outputJSON.getString("ext_m_follow_low_25"))) {
				basetable.setFollowLow25(outputJSON.getString("ext_m_follow_low_25"));
			}
			if (outputJSON.containsKey("ext_search_result") && outputJSON.getString("ext_search_result") != null
					&& !"".equals(outputJSON.getString("ext_search_result"))) {
				basetable.setExtSearchResult(outputJSON.getString("ext_search_result"));
			}
//			System.err.println(basetable.toString());
			mulborInfo.setMulBorBase(basetable);

			
			for (int i = 0; i < riskItems.size(); i++) {
				if (riskItems.get(i) != null) {
					MulBorRiskItem mulborRiskItem = new MulBorRiskItem();
					String uuidOfRiskItem = UUIDGen.getUUID();// 自动生成基础表的ID，不重复
					mulborRiskItem.setUuid(uuidOfRiskItem);
					mulborRiskItem.setCrtTime(crtTime);
					mulborRiskItem.setCrtUser(crtUser);
					String pkUuidOfRiskItem = UUIDGen.getUUID();// 自动生成基础表的ID，
					mulborRiskItem.setPkUuid(pkUuidOfRiskItem);
					mulborRiskItem.setRefUuid(basetable.getPkUuid());
					mulborRiskItem.setAppId(appId);
					mulborRiskItem.setTrnId(trnId);
					JSONObject riskItemJSON = (JSONObject) riskItems.get(i);
					JSONArray riskDetails = new JSONArray();
					if (riskItemJSON.containsKey("rule_id") && riskItemJSON.getString("rule_id") != null
							&& !"".equals(riskItemJSON.getString("rule_id"))) {
						mulborRiskItem.setRuleId(riskItemJSON.getInt("rule_id"));
					}
					// 风险项目评价结果
					if (riskItemJSON.containsKey("score") && riskItemJSON.getString("score") != null
							&& !"".equals(riskItemJSON.getString("score"))) {
						mulborRiskItem.setScore(riskItemJSON.getInt("score"));
					}
					// items的决策结果
					if (riskItemJSON.containsKey("decision") && riskItemJSON.getString("decision") != null
							&& !"".equals(riskItemJSON.getString("decision"))) {
						mulborRiskItem.setDecision(riskItemJSON.getString("decision"));
					}
					// 设置风险项目的名称
					if (riskItemJSON.containsKey("risk_name") && riskItemJSON.getString("risk_name") != null
							&& !"".equals(riskItemJSON.getString("risk_name"))) {
						mulborRiskItem.setRiskName(riskItemJSON.getString("risk_name"));
					}
					// 策略决策结果
					if (riskItemJSON.containsKey("policy_decision") && riskItemJSON.getString("policy_decision") != null
							&& !"".equals(riskItemJSON.getString("policy_decision"))) {
						mulborRiskItem.setPolicyDecision(riskItemJSON.getString("policy_decision"));
					}
					// 策略模式
					if (riskItemJSON.containsKey("policy_mode") && riskItemJSON.getString("policy_mode") != null
							&& !"".equals(riskItemJSON.getString("policy_mode"))) {
						mulborRiskItem.setPolicyMode(riskItemJSON.getString("policy_mode"));
					}
					// 策略分数
					if (riskItemJSON.containsKey("policy_score") && riskItemJSON.getString("policy_score") != null
							&& !"".equals(riskItemJSON.getString("policy_score"))) {
						mulborRiskItem.setPolicyScore(riskItemJSON.getString("policy_score"));
					}
					// 策略名称
					if (riskItemJSON.containsKey("policy_name") && riskItemJSON.getString("policy_name") != null
							&& !"".equals(riskItemJSON.getString("policy_name"))) {
						mulborRiskItem.setPolicyName(riskItemJSON.getString("policy_name"));
					}

					// 风险详情
					if (riskItemJSON.containsKey("risk_detail") && riskItemJSON.getString("risk_detail") != null
							&& !"".equals(riskItemJSON.getString("risk_detail"))) {
						riskDetails = JSONArray.fromObject(riskItemJSON.getString("risk_detail"));
					}

//					System.err.println(mulborRiskItem);
					mulBorRiskItemrList.add(mulborRiskItem);
					mulborInfo.setMulBorRiskItemList(mulBorRiskItemrList);

					for (int j = 0; j < riskDetails.size(); j++) {
						if (riskDetails.get(j) != null) {
							JSONObject riskDetailJSON = (JSONObject) riskDetails.get(j);
							// 判断类型进行存取不同的数据库，type共有十六种类型取值
							if (riskDetailJSON.getString("type").equals("black_list")) {
								JSONArray courtDetailsArray = new JSONArray();
								
								// 是一个数组，进行解析
								if (riskDetailJSON.containsKey("court_details")
										&& riskDetailJSON.getString("court_details") != null
										&& !"".equals(riskDetailJSON.getString("court_details"))) {
									courtDetailsArray = JSONArray.fromObject(riskDetailJSON.getString("court_details"));
								}
								if(1 <= courtDetailsArray.size()){
								// 信息列表的显示
								for (int k = 0; k < courtDetailsArray.size(); k++) {
									if (courtDetailsArray.get(k) != null) {
										JSONObject courtDetailJSON= (JSONObject) courtDetailsArray.get(k);

										MulBorBlackList mulBorBlack = new MulBorBlackList();
										String uuidOfBlackList = UUIDGen.getUUID();// 自动生成基础表的ID，不重复
										mulBorBlack.setUuid(uuidOfBlackList);
										mulBorBlack.setCrtTime(crtTime);
										mulBorBlack.setCrtUser(crtUser);
										mulBorBlack.setRefUuid(mulborRiskItem.getPkUuid());
										mulBorBlack.setAppId(appId);
										mulBorBlack.setTrnId(trnId);
										
										// 设置风险项目的名称
										if (riskDetailJSON.containsKey("hit_type_display_name")
												&& riskDetailJSON.getString("hit_type_display_name") != null
												&& !"".equals(riskDetailJSON.getString("hit_type_display_name"))) {
											mulBorBlack.setHitTypeDisplayName(
													riskDetailJSON.getString("hit_type_display_name"));
										}
										// 名称信息
										if (riskDetailJSON.containsKey("fraud_type_display_name")
												&& riskDetailJSON.getString("fraud_type_display_name") != null
												&& !"".equals(riskDetailJSON.getString("fraud_type_display_name"))) {
											mulBorBlack.setFraudTypeDisplayName(
													riskDetailJSON.getString("fraud_type_display_name"));
										}
										//子类型
										if (courtDetailJSON.containsKey("fraud_type_display_name")
												&& courtDetailJSON.getString("fraud_type_display_name") != null
												&& !"".equals(courtDetailJSON.getString("fraud_type_display_name"))) {
											mulBorBlack.setFraudTypeDisplayName(
													courtDetailJSON.getString("fraud_type_display_name"));
										}
										
										// 描述
										if (riskDetailJSON.containsKey("description")
												&& riskDetailJSON.getString("description") != null
												&& !"".equals(riskDetailJSON.getString("description"))) {
											mulBorBlack.setDescription(riskDetailJSON.getString("description"));
										}
										// 类型
										if (riskDetailJSON.containsKey("type")
												&& riskDetailJSON.getString("type") != null
												&& !"".equals(riskDetailJSON.getString("type"))) {
											mulBorBlack.setType(riskDetailJSON.getString("type"));
										}

										// 值的类型
										if (courtDetailJSON.containsKey("value")
												&& courtDetailJSON.getString("value") != null
												&& !"".equals(courtDetailJSON.getString("value"))) {
											mulBorBlack.setValue(courtDetailJSON.getString("value"));
										}
										// 类型，法院
										if (courtDetailJSON.containsKey("fraud_type")
												&& courtDetailJSON.getString("fraud_type") != null
												&& !"".equals(courtDetailJSON.getString("fraud_type"))) {
											mulBorBlack.setFraudType(courtDetailJSON.getString("fraud_type"));
										}
										// 姓名
										if (courtDetailJSON.containsKey("executed_name")
												&& courtDetailJSON.getString("executed_name") != null
												&& !"".equals(courtDetailJSON.getString("executed_name"))) {
											mulBorBlack.setExecutedName(courtDetailJSON.getString("executed_name"));
										}
										// 年龄
										if (courtDetailJSON.containsKey("age")
												&& courtDetailJSON.getString("age") != null
												&& !"".equals(courtDetailJSON.getString("age"))) {
											mulBorBlack.setAge(courtDetailJSON.getString("age"));
										}
										// 性别
										if (courtDetailJSON.containsKey("gender")
												&& courtDetailJSON.getString("gender") != null
												&& !"".equals(courtDetailJSON.getString("gender"))) {
											mulBorBlack.setGender(courtDetailJSON.getString("gender"));
										}
										// 省份
										if (courtDetailJSON.containsKey("province")
												&& courtDetailJSON.getString("province") != null
												&& !"".equals(courtDetailJSON.getString("province"))) {
											mulBorBlack.setProvince(courtDetailJSON.getString("province"));
										}
										// 执行日期
										if (courtDetailJSON.containsKey("case_date")
												&& courtDetailJSON.getString("case_date") != null
												&& !"".equals(courtDetailJSON.getString("case_date"))) {
											mulBorBlack.setCaseDate(courtDetailJSON.getString("case_date"));
										}
										// 执行法院姓名
										if (courtDetailJSON.containsKey("execute_court")
												&& courtDetailJSON.getString("execute_court") != null
												&& !"".equals(courtDetailJSON.getString("execute_court"))) {
											mulBorBlack.setExecuteCourt(courtDetailJSON.getString("execute_court"));
										}
										// 需要负的责任
										if (courtDetailJSON.containsKey("term_duty")
												&& courtDetailJSON.getString("term_duty") != null
												&& !"".equals(courtDetailJSON.getString("term_duty"))) {
											mulBorBlack.setTermDuty(courtDetailJSON.getString("term_duty"));
										}
										// 执行项目编号
										if (courtDetailJSON.containsKey("execute_subject")
												&& courtDetailJSON.getString("execute_subject") != null
												&& !"".equals(courtDetailJSON.getString("execute_subject"))) {
											mulBorBlack.setExecuteSubjec(courtDetailJSON.getString("execute_subject"));
										}
										// hi行的状态
										if (courtDetailJSON.containsKey("execute_status")
												&& courtDetailJSON.getString("execute_status") != null
												&& !"".equals(courtDetailJSON.getString("execute_status"))) {
											mulBorBlack.setExecuteStatus(courtDetailJSON.getString("execute_status"));
										}
										// 法院
										if (courtDetailJSON.containsKey("evidence_court")
												&& courtDetailJSON.getString("evidence_court") != null
												&& !"".equals(courtDetailJSON.getString("evidence_court"))) {
											mulBorBlack.setEvidenceCoutt(courtDetailJSON.getString("evidence_court"));
										}
										// 原因
										if (courtDetailJSON.containsKey("carry_out")
												&& courtDetailJSON.getString("carry_out") != null
												&& !"".equals(courtDetailJSON.getString("carry_out"))) {
											mulBorBlack.setCarryOut(courtDetailJSON.getString("carry_out"));
										}
										// 原因
										if (courtDetailJSON.containsKey("specific_circumstances")
												&& courtDetailJSON.getString("specific_circumstances") != null
												&& !"".equals(courtDetailJSON.getString("specific_circumstances"))) {
											mulBorBlack.setSpecificCircumstances(
													courtDetailJSON.getString("specific_circumstances"));
										}
										// 一些编号
										if (courtDetailJSON.containsKey("execute_code")
												&& courtDetailJSON.getString("execute_code") != null
												&& !"".equals(courtDetailJSON.getString("execute_code"))) {
											mulBorBlack.setExecuteCode(courtDetailJSON.getString("execute_code"));
										}
										// 证据时间
										if (courtDetailJSON.containsKey("evidence_time")
												&& courtDetailJSON.getString("evidence_time") != null
												&& !"".equals(courtDetailJSON.getString("evidence_time"))) {
											mulBorBlack.setEvidenceTime(courtDetailJSON.getString("evidence_time"));
										}
										// 案例编号
										if (courtDetailJSON.containsKey("case_code")
												&& courtDetailJSON.getString("case_code") != null
												&& !"".equals(courtDetailJSON.getString("case_code"))) {
											mulBorBlack.setCaseCode(courtDetailJSON.getString("case_code"));
										}
//										System.err.println(mulBorBlack);
										mulBorBlackList.add(mulBorBlack);
									}
								}
								}else{
									//不包含court_detail
									MulBorBlackList mulBorBlack = new MulBorBlackList();
									String uuidOfBlackList = UUIDGen.getUUID();// 自动生成基础表的ID，不重复
									mulBorBlack.setUuid(uuidOfBlackList);
									mulBorBlack.setCrtTime(crtTime);
									mulBorBlack.setCrtUser(crtUser);
									mulBorBlack.setRefUuid(mulborRiskItem.getPkUuid());
									mulBorBlack.setAppId(appId);
									mulBorBlack.setTrnId(trnId);
									
									// 设置风险项目的名称
									if (riskDetailJSON.containsKey("hit_type_display_name")
											&& riskDetailJSON.getString("hit_type_display_name") != null
											&& !"".equals(riskDetailJSON.getString("hit_type_display_name"))) {
										mulBorBlack.setHitTypeDisplayName(
												riskDetailJSON.getString("hit_type_display_name"));
									}
									// 名称信息
									if (riskDetailJSON.containsKey("fraud_type_display_name")
											&& riskDetailJSON.getString("fraud_type_display_name") != null
											&& !"".equals(riskDetailJSON.getString("fraud_type_display_name"))) {
										mulBorBlack.setFraudTypeDisplayName(
												riskDetailJSON.getString("fraud_type_display_name"));
									}
									// 描述
									if (riskDetailJSON.containsKey("description")
											&& riskDetailJSON.getString("description") != null
											&& !"".equals(riskDetailJSON.getString("description"))) {
										mulBorBlack.setDescription(riskDetailJSON.getString("description"));
									}
									// 类型
									if (riskDetailJSON.containsKey("type")
											&& riskDetailJSON.getString("type") != null
											&& !"".equals(riskDetailJSON.getString("type"))) {
										mulBorBlack.setType(riskDetailJSON.getString("type"));
									}
									mulBorBlackList.add(mulBorBlack);
								}
								
								mulborInfo.setMulBorBlackListList(mulBorBlackList);
							}
							if (riskDetailJSON.getString("type").equals("grey_list")) {
								JSONArray greyListArray = new JSONArray();
								
								// 关注名单细则
								if (riskDetailJSON.containsKey("grey_list_details")
										&& riskDetailJSON.getString("grey_list_details") != null
										&& !"".equals(riskDetailJSON.getString("grey_list_details"))) {
									greyListArray = JSONArray.fromObject(riskDetailJSON.getString("grey_list_details"));
								}
								if(1 <= greyListArray.size()){
									// 信息列表的显示
								// 关注名单详情细则表
								for (int p = 0; p < greyListArray.size(); p++) {
									if (greyListArray.get(p) != null) {
										JSONObject geryListDetailJSON  = (JSONObject) greyListArray.get(p);
										MulBorGreyList greyList = new MulBorGreyList();
										String uid = UUIDGen.getUUID();// 自动生成基础表的ID，不重复
										greyList.setUuid(uid);
										greyList.setCrtTime(crtTime);
										greyList.setCrtUser(crtUser);
										greyList.setRefUuid(mulborRiskItem.getPkUuid());
										greyList.setAppId(appId);
										greyList.setTrnId(trnId);
										
										// 类型
										if (riskDetailJSON.containsKey("type")
												&& riskDetailJSON.getString("type") != null
												&& !"".equals(riskDetailJSON.getString("type"))) {
											greyList.setType(riskDetailJSON.getString("type"));
										}
										// 描述
										if (riskDetailJSON.containsKey("description")
												&& riskDetailJSON.getString("description") != null
												&& !"".equals(riskDetailJSON.getString("description"))) {
											greyList.setDescription(riskDetailJSON.getString("description"));
										}
										// 匹配类型
										if (riskDetailJSON.containsKey("hit_type_display_name")
												&& riskDetailJSON.getString("hit_type_display_name") != null
												&& !"".equals(riskDetailJSON.getString("hit_type_display_name"))) {
											greyList.setHitTypeDisplayName(
													riskDetailJSON.getString("hit_type_display_name"));
										}
										
										// 风险类型显示名
										if (riskDetailJSON.containsKey("fraud_type_display_name")
												&& riskDetailJSON.getString("fraud_type_display_name") != null
												&& !"".equals(riskDetailJSON.getString("fraud_type_display_name"))) {
											greyList.setFraudTypeDisplayName(
													riskDetailJSON.getString("fraud_type_display_name"));
										}
										// 风险类型子显示名
										if (geryListDetailJSON.containsKey("fraud_type_display_name")
												&& geryListDetailJSON.getString("fraud_type_display_name") != null
												&& !"".equals(geryListDetailJSON.getString("fraud_type_display_name"))) {
											greyList.setFraudTypeDisplayName(
													geryListDetailJSON.getString("fraud_type_display_name"));
										}
										// 命中关注名单的属性值
										if (geryListDetailJSON.containsKey("value")
												&& geryListDetailJSON.getString("value") != null
												&& !"".equals(geryListDetailJSON.getString("value"))) {
											greyList.setValue(geryListDetailJSON.getString("value"));
										}

										// 风险等级
										if (geryListDetailJSON.containsKey("risk_level")
												&& geryListDetailJSON.getString("risk_level") != null
												&& !"".equals(geryListDetailJSON.getString("risk_level"))) {
											greyList.setRiskLevel(geryListDetailJSON.getString("risk_level"));
										}
										// 风险类型
										if (geryListDetailJSON.containsKey("fraud_type")
												&& geryListDetailJSON.getString("fraud_type") != null
												&& !"".equals(geryListDetailJSON.getString("fraud_type"))) {
											greyList.setFraudType(geryListDetailJSON.getString("fraud_type"));
										}
										// 证据时间戳形式
										if (geryListDetailJSON.containsKey("evidence_time")
												&& geryListDetailJSON.getString("evidence_time") != null
												&& !"".equals(geryListDetailJSON.getString("evidence_time"))) {
											greyList.setEvidenceTime(geryListDetailJSON.getString("evidence_time"));
										}
//										System.err.println(greyList.toString());
										mulBorGreyList.add(greyList);
									}
								}
								}else{
									MulBorGreyList greyList = new MulBorGreyList();
									String uid = UUIDGen.getUUID();// 自动生成基础表的ID，不重复
									greyList.setUuid(uid);
									greyList.setCrtTime(crtTime);
									greyList.setCrtUser(crtUser);
									greyList.setRefUuid(mulborRiskItem.getPkUuid());
									greyList.setAppId(appId);
									greyList.setTrnId(trnId);
									
									// 类型
									if (riskDetailJSON.containsKey("type")
											&& riskDetailJSON.getString("type") != null
											&& !"".equals(riskDetailJSON.getString("type"))) {
										greyList.setType(riskDetailJSON.getString("type"));
									}
									// 描述
									if (riskDetailJSON.containsKey("description")
											&& riskDetailJSON.getString("description") != null
											&& !"".equals(riskDetailJSON.getString("description"))) {
										greyList.setDescription(riskDetailJSON.getString("description"));
									}
									// 匹配类型
									if (riskDetailJSON.containsKey("hit_type_display_name")
											&& riskDetailJSON.getString("hit_type_display_name") != null
											&& !"".equals(riskDetailJSON.getString("hit_type_display_name"))) {
										greyList.setHitTypeDisplayName(
												riskDetailJSON.getString("hit_type_display_name"));
									}
									// 风险类型显示名
									if (riskDetailJSON.containsKey("fraud_type_display_name")
											&& riskDetailJSON.getString("fraud_type_display_name") != null
											&& !"".equals(riskDetailJSON.getString("fraud_type_display_name"))) {
										greyList.setFraudTypeDisplayName(
												riskDetailJSON.getString("fraud_type_display_name"));
									}
									mulBorGreyList.add(greyList);
								}
								mulborInfo.setMulBorGreyListList(mulBorGreyList);
							}
							if (riskDetailJSON.getString("type").equals("discredit_count")) {
								JSONArray discreditCountArray = new JSONArray();
								
								// 信贷逾期统计细则
								if (riskDetailJSON.containsKey("overdue_details")
										&& riskDetailJSON.getString("overdue_details") != null
										&& !"".equals(riskDetailJSON.getString("overdue_details"))) {
									discreditCountArray = JSONArray
											.fromObject(riskDetailJSON.getString("overdue_details"));
								}
								if(1 <= discreditCountArray.size()){
								// 解析数组
								for (int o = 0; o < discreditCountArray.size(); o++) {
									if (discreditCountArray.get(o) != null) {
										JSONObject overdueDetailJSON = (JSONObject) discreditCountArray.get(o);
										MulBorDescreditCount discrecourt = new MulBorDescreditCount();
										String uid = UUIDGen.getUUID();// 自动生成基础表的ID，不重复
										discrecourt.setUuid(uid);
										discrecourt.setCrtTime(crtTime);
										discrecourt.setCrtUser(crtUser);
										discrecourt.setRefUuid(mulborRiskItem.getPkUuid());
										discrecourt.setAppId(appId);
										discrecourt.setTrnId(trnId);
										// 设置描述
										if (riskDetailJSON.containsKey("description")
												&& riskDetailJSON.getString("description") != null
												&& !"".equals(riskDetailJSON.getString("description"))) {
											discrecourt.setDescription(riskDetailJSON.getString("description"));
										}
										// 设置类型
										if (riskDetailJSON.containsKey("type")
												&& riskDetailJSON.getString("type") != null
												&& !"".equals(riskDetailJSON.getString("type"))) {
											discrecourt.setType(riskDetailJSON.getString("type"));
										}
										// 信贷逾期次数
										if (riskDetailJSON.containsKey("discredit_times")
												&& riskDetailJSON.getString("discredit_times") != null
												&& !"".equals(riskDetailJSON.getString("discredit_times"))) {
											discrecourt.setDiscreditTimes(riskDetailJSON.getInt("discredit_times"));
										}
										// 平台个数
										if (riskDetailJSON.containsKey("platform_count")
												&& riskDetailJSON.getString("platform_count") != null
												&& !"".equals(riskDetailJSON.getString("platform_count"))) {
											discrecourt.setPlatformCount(riskDetailJSON.getInt("platform_count"));
										}

										// 逾期时间
										if (overdueDetailJSON.containsKey("overdue_time")
												&& overdueDetailJSON.getString("overdue_time") != null
												&& !"".equals(overdueDetailJSON.getString("overdue_time"))) {
											discrecourt.setOverdueTime(overdueDetailJSON.getString("overdue_time"));
										}
										// 逾期金额区间
										if (overdueDetailJSON.containsKey("overdue_amount_range")
												&& overdueDetailJSON.getString("overdue_amount_range") != null
												&& !"".equals(overdueDetailJSON.getString("overdue_amount_range"))) {
											discrecourt.setOverdueAmountRange(
													overdueDetailJSON.getString("overdue_amount_range"));
										}
										// 逾期时间区间
										if (overdueDetailJSON.containsKey("overdue_day_range")
												&& overdueDetailJSON.getString("overdue_day_range") != null
												&& !"".equals(overdueDetailJSON.getString("overdue_day_range"))) {
											discrecourt.setOverdueDayRange(
													overdueDetailJSON.getString("overdue_day_range"));
										}
										// 逾期笔数
										if (overdueDetailJSON.containsKey("overdue_count")
												&& overdueDetailJSON.getString("overdue_count") != null
												&& !"".equals(overdueDetailJSON.getString("overdue_count"))) {
											discrecourt.setOverdueCount(overdueDetailJSON.getInt("overdue_count"));
										}
//										System.err.println(discrecourt.toString());
										mulBorDescreditCountList.add(discrecourt);
									}
								}
								}else{
									MulBorDescreditCount discrecourt = new MulBorDescreditCount();
									String uid = UUIDGen.getUUID();// 自动生成基础表的ID，不重复
									discrecourt.setUuid(uid);
									discrecourt.setCrtTime(crtTime);
									discrecourt.setCrtUser(crtUser);
									discrecourt.setRefUuid(mulborRiskItem.getPkUuid());
									discrecourt.setAppId(appId);
									discrecourt.setTrnId(trnId);
									// 设置描述
									if (riskDetailJSON.containsKey("description")
											&& riskDetailJSON.getString("description") != null
											&& !"".equals(riskDetailJSON.getString("description"))) {
										discrecourt.setDescription(riskDetailJSON.getString("description"));
									}
									// 设置类型
									if (riskDetailJSON.containsKey("type")
											&& riskDetailJSON.getString("type") != null
											&& !"".equals(riskDetailJSON.getString("type"))) {
										discrecourt.setType(riskDetailJSON.getString("type"));
									}
									// 信贷逾期次数
									if (riskDetailJSON.containsKey("discredit_times")
											&& riskDetailJSON.getString("discredit_times") != null
											&& !"".equals(riskDetailJSON.getString("discredit_times"))) {
										discrecourt.setDiscreditTimes(riskDetailJSON.getInt("discredit_times"));
									}
									// 平台个数
									if (riskDetailJSON.containsKey("platform_count")
											&& riskDetailJSON.getString("platform_count") != null
											&& !"".equals(riskDetailJSON.getString("platform_count"))) {
										discrecourt.setPlatformCount(riskDetailJSON.getInt("platform_count"));
									}
									mulBorDescreditCountList.add(discrecourt);
								}
								mulborInfo.setMulBorDescreditCountList(mulBorDescreditCountList);
							}

						}
					}
				} else {
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return mulborInfo;
	}

}
