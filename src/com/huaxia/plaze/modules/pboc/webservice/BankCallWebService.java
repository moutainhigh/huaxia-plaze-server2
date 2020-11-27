package com.huaxia.plaze.modules.pboc.webservice;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface BankCallWebService {
    /**
     *@Title:queryBankMessage
     *@Description:查询人行信息
     *@param arg0
     *@author: gaohui
     *@Date:2018年12月26日下午4:17:35
     */
	@WebMethod
	public void queryBankMessage(String arg0);
}
