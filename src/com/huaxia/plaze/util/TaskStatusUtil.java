package com.huaxia.plaze.util;
/**
 * 三方任务状态
 * @author gaoh
 *
 */
public class TaskStatusUtil {
	public final static String  CURR_USER = "PLAZE";//系统默认用户名
	public final static String  INITIAL = "0";//初始化状态
	public final static String  START = "1";//单笔请求开始
	public final static String  SUCCESS = "2";//请求成功
	public final static String  PARAM_ERROE = "3";//参数错误
	public final static String  START_BATCH = "4";//批量请求开始
	public final static String  PARSE_SAVE_BATCH_ERROE = "5";//批量解析入库异常
	public final static String  COPY_ERROE = "6";//复制异常
	public final static String  SERVE_RESPOSE_ERROE = "7";//对方服务响应异常
	public final static String  PARSE_ERROE = "8";//解析异常
	public final static String  STREAM_CALL_ERROE = "9";//调流异常
	public final static String  INTERNAL_CALL_ERROE = "10";//内部连接异常
	public final static String  RESPOSE_CODE_ERROR = "11";//报文响应码异常
	public final static String  SAVE_ERROE = "12";//入库异常
	public final static String  NOT_RETURN = "13";//单笔报文没返回
	public final static String  NOT_RETURN_BATCH = "14";//批量报文没返回
	public final static String  CALL_QUERY_ERROE = "15";//调用请求接口异常
	public final static String  USERANDPWD_ERROR = "16";//二代人行获取查询用户名和密码异常
	public final static String  GET_SIGN_ERROR = "17";//获取数字签名错误
}
