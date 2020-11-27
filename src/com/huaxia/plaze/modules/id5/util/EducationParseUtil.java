package com.huaxia.plaze.modules.id5.util;

import java.security.PrivateKey;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.id5.domain.Education;

import cn.id5.gboss.client.api.codec.HexCodec;
import cn.id5.gboss.client.api.codec.StringUtils;
import cn.id5.gboss.client.api.codec.security.AesCodec;
import cn.id5.gboss.client.api.codec.security.Base64;
import cn.id5.gboss.client.api.codec.security.RsaCodec;

public class EducationParseUtil {
	private final static Logger logger = LoggerFactory.getLogger(EducationParseUtil.class);
	private static RsaCodec rsa;
	private static HexCodec hex;
	private static AesCodec aes;
	// 初始化加密算法
	static {
		rsa = new RsaCodec();
		hex = new HexCodec();
		aes = new AesCodec();
	}
	
	public static Education parseEducationChsi(String message) {
		Education education = new Education();
		try {
			Document document = DocumentHelper.parseText(message);
			Node eduNodeKeyinfo = document.selectSingleNode("/xjxl/keyinfo");
			if (eduNodeKeyinfo != null) {// 有学历时
				String keyinfoKey = document.selectSingleNode("/xjxl/keyinfo/key").getText();
				String keydata = AppConfig.getInstance().getValue("id5.edu.private_key");
				// 使用rsa对私钥密文解密
				PrivateKey privateKey = rsa.loadPrivateKey(keydata);
				byte[] decdata = rsa.decrypt(Base64.decode(keyinfoKey), privateKey, 1024, "");
				String enEduData = document.selectSingleNode("/xjxl/xlinfos").getText();
				byte[] eduDataArray = hex.hexStringToByte(enEduData);
				// 使用aes对学历密文进行解密
				byte[] eduData = aes.decrypt(eduDataArray, Base64.decode(new String(decdata)));
				String decEduData = StringUtils.newString(eduData, "UTF-8");
				// System.err.println(decEduData);
				Document dom = DocumentHelper.parseText(decEduData);
				Node eduNodeXL = dom.selectSingleNode("/xl");
				if (eduNodeXL != null) {
					Node eduNodeXm = eduNodeXL.selectSingleNode("xm");
					// 姓名 USERNAME
					if (eduNodeXm != null) {
						education.setXm(eduNodeXm.getText());
					}
					// 证件号码 IDENTITYCARD
					Node eduNodeZjhm = eduNodeXL.selectSingleNode("zjhm");
					if (eduNodeZjhm != null) {
						education.setZjhm(eduNodeZjhm.getText());
					}

					// 学历层次 EDUCATIONDEGREE
					Node eduNodeCc = eduNodeXL.selectSingleNode("cc");
					if (eduNodeCc != null) {
						education.setCc(eduNodeCc.getText());
					}
					// 院校名称 GRADUATE
					Node eduNodeYxmc = eduNodeXL.selectSingleNode("yxmc");
					if (eduNodeYxmc != null) {
						education.setYxmc(eduNodeYxmc.getText());
					}
					// 毕结业结论 STUDYRESULT
					Node eduNodeBjyjl = eduNodeXL.selectSingleNode("bjyjl");
					if (eduNodeBjyjl != null) {
						education.setBjyjl(eduNodeBjyjl.getText());
					}
					// 毕业年份 GRADUATETIME
					Node eduNodeByrq = eduNodeXL.selectSingleNode("byrq");
					if (eduNodeByrq != null) {
						education.setByrq(eduNodeByrq.getText());
					}
					// 学习形式 DSTUDYSTYLE
					Node eduNodeXxxs = eduNodeXL.selectSingleNode("xxxs");
					if (eduNodeXxxs != null) {
						education.setXxxs(eduNodeXxxs.getText());
					}
					// 学历照片
					Node eduNodePhoto = eduNodeXL.selectSingleNode("photo");
					if (eduNodePhoto != null) {
						education.setPhoto(eduNodePhoto.getText());
					}
					education.setCrtUser("system");
					education.setQueryStatus("0");
					education.setQueryResult("查询成功");
				}
			} else {// 无学历时
				education.setCrtUser("system");
				education.setQueryStatus("1");
				education.setQueryResult("未查到数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[客户端 & 学历] 学历报文解析异常   " + education.getTrnId() + " Exception:{}", e);
			return null;
		}
		return education;
	}
}
