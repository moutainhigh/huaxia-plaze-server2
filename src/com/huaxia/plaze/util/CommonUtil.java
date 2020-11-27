package com.huaxia.plaze.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gaohui
 */
public class CommonUtil {
	private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	/**
	 *@Title:downLoadMessageContent
	 *@Description:下载报文内容
	 *@param responseMessage 报文内容
	 *@param fileSavePath  文件路径 
	 *@param appId  申请件编号
	 *@param taskStyle  任务类型
	 *@param fileStyle 文件类型
	 *@param errorPrompt 错误提示
	 *@author: gaohui
	 *@Date:2017年11月14日下午5:48:49
	 */
	public static void downLoadMessageContent(String responseMessage,
			String fileSavePath,String appId,String taskStyle,String fileStyle,String errorPrompt) {
		BufferedWriter writer = null;
		try {
			Date currDate=new Date();	
			SimpleDateFormat currDateFormat=new SimpleDateFormat("yyyyMMdd");
			String currDateUse=currDateFormat.format(currDate);
			String currXmlSavePath=fileSavePath+currDateUse+File.separator;
			File dir=new File(currXmlSavePath);
			if(!dir.exists()){
				dir.setWritable(true, false);//设置写权限 
				dir.mkdirs();
			}
			String messageName="";
			if(taskStyle!=null){
				messageName=currXmlSavePath + appId +"_" +taskStyle+fileStyle;
			}else{
				messageName=currXmlSavePath + appId + fileStyle;
			}
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(messageName, false)));
			writer.write(responseMessage);
			}catch (Exception e) {
				if (logger.isErrorEnabled()) {
					logger.error("[客户端 & "+errorPrompt+"] 下载报文文件异常, 申请件编号: {}", appId);
				}
				
			}finally {
				if (writer != null) {
					try {
						writer.close();
						writer.flush();
					} catch (IOException e) {
					}
				}
			}
	}
	
	/**
	 *@Title:rmHardDiskFile
	 *@Description:删除硬盘上的文件
	 *@param filePath 文件目录
	 *@param fileName 文件名
	 *@param appId 申请件编号
	 *@param deletePrompt 删除提示
	 *@author: gaohui
	 *@Date:2017年11月23日下午4:18:16
	 */
	public static void rmHardDiskFile(String filePath,String fileName,String appId,String deletePrompt){
		try {
		String path=filePath+fileName;
		String[] cmd=new String[]{"/bin/sh","-c","rm -rf "+path};
		Runtime.getRuntime().exec(cmd);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("[客户端 & "+deletePrompt+"] 文件删除异常,文件名: {},申请件编号: {}",fileName,appId);
			}
		}
	}
	
}
