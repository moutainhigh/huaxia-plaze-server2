package com.huaxia.plaze.datasource.interfaces;

import java.util.Map;

import com.huaxia.plaze.aspect.DataSourceAspectSupport;

/**
 * 数据源回调处理接口。该接口的作用是：通过<em>渠道名称简称 </em>
 * {@link DataSourceAspectSupport#REQUEST_CHANNEL} 调用各数据源的 <em>查询数量限制</em>
 * 配置信息，验证当前查询请求是否允许执行。如果返回 {@code 1} 则允许当前查询请求通过；如果返回 {@code -1} 或 {@code 0}
 * 则禁止当前查询请求执行。
 * 
 * @author zhiguo.li
 *
 */
public interface DataSourceCallback {

	/**
	 * 数据源回调方法
	 * 
	 * @param args
	 *            请求报文参数
	 * 
	 *            <pre>
	 *            [ TRN_ID          ] 交易编号
	 *            [ REQUEST_CHANNEL ] 请求渠道
	 *            </pre>
	 * 
	 * @return
	 * 
	 *         <pre>
	 *            [ RESULTSET_TYPE  ] 结果集类型
	 *         </pre>
	 */
	Map<String, String> callback(Map<String, String> args);

}
