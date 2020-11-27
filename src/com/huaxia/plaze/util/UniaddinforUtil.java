package com.huaxia.plaze.util;

import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 联通地址类信息工具类
 * 
 * @author lipengfei
 *
 */
public class UniaddinforUtil {

	private final static Logger logger = LoggerFactory.getLogger(UniaddinforUtil.class);

	// 获取校验结果中文描述
	public static String gainCheckDesc(String checkResult, String carrier, String apiKey) {
		// 校验结果中文描述
		String CheckDesc = null;
		try {
			if (checkResult != null && !"".equals(checkResult)) {
				if (carrier != null && !"".equals(carrier)) {
					if ("360015".equals(apiKey)) {
						// 工作地址类信息,判断手机运营商
						if ("UNICOM".equals(carrier)) { // 联通号
							DecimalFormat df = new DecimalFormat("0.0");
							// 切分校验结果,获取校验结果中的数字部分
							String num = checkResult.substring(2);
							int num1 = Integer.parseInt(num);
							// 对数字部分计算后,拼接成接口文件中的返回文字描述
							String num2 = df.format((float) num1 / 2);
							CheckDesc = "填写地址与工作地地址距离小于等于" + num2 + "千米";
							return CheckDesc;
						} else if ("TELECOM".equals(carrier) || "MOBILE".equals(carrier)) { // 电信号或移动号
							// 切分校验结果,获取校验结果中的数字部分
							String num = checkResult.substring(2);
							int num1 = Integer.parseInt(num);
							// 对数字部分计算后,拼接成接口文件中的返回文字描述
							int num2 = num1 - 1;
							CheckDesc = "填写地址与工作地地址距离差距约为" + num2 + "-" + num1 + "千米";
							return CheckDesc;
						} else { // 其他情况
							CheckDesc = "无法识别手机运营商";
							return CheckDesc;
						}
					} else {
						// 居住地址类信息,判断手机运营商
						if ("UNICOM".equals(carrier)) { // 联通号
							DecimalFormat df = new DecimalFormat("0.0");
							// 切分校验结果,获取校验结果中的数字部分
							String num = checkResult.substring(2);
							int num1 = Integer.parseInt(num);
							// 对数字部分计算后,拼接成接口文件中的返回文字描述
							String num2 = df.format((float) num1 / 2);
							CheckDesc = "填写地址与居住地地址距离小于等于" + num2 + "千米";
							return CheckDesc;
						} else if ("TELECOM".equals(carrier) || "MOBILE".equals(carrier)) { // 电信号或移动号
							// 切分校验结果,获取校验结果中的数字部分
							String num = checkResult.substring(2);
							int num1 = Integer.parseInt(num);
							// 对数字部分计算后,拼接成接口文件中的返回文字描述
							int num2 = num1 - 1;
							CheckDesc = "填写地址与居住地地址距离差距约为" + num2 + "-" + num1 + "千米";
							return CheckDesc;
						} else { // 其他情况
							CheckDesc = "无法识别手机运营商";
							return CheckDesc;
						}
					}
				} else {
					CheckDesc = "手机运营商为null";
					return CheckDesc;
				}
			} else {
				CheckDesc = "校验结果为null";
				return CheckDesc;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "校验结果为null";
		}
	}
	
	
	public static void main(String[] args) {
		String desc = gainCheckDesc("CT100","MOBILE","360015");
		System.out.println(desc);
	}
	
	
}
