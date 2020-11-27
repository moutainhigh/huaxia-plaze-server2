package com.huaxia.plaze.modules.fico.parser;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.plaze.modules.fico.domain.Fico;

public class FicoMessageParser implements MessageParser<Fico> {


	private static final Logger logger = LoggerFactory.getLogger(FicoMessageParser.class);

	@Override
	public Fico parse(String message) throws Exception {
		if (message == null || "".equals(message)) {
			return null;
			//throw new IllegalArgumentException("fico大数据报文为空");
		}
		Document document = null;
		try {
			document = DocumentHelper.parseText(message);
		} catch (DocumentException e) {
			if (logger.isErrorEnabled()) {
				logger.error("[FICO大数据评分解析] 构建XML解析异常：{}", e.getMessage());
			}
			e.printStackTrace();
			throw e;
		}
		Fico fico = new Fico();
		Element root = document.getRootElement();
		if (root != null ) {
			Attribute attr = root.attribute("retCode");
			if (attr != null) {
				fico.setRetCoode(attr.getText());
			}
			attr = root.attribute("errMsg");
			if (attr != null) {
				fico.setErrMsg(attr.getText());
			}
			attr = root.attribute("scoreID");
			if (attr != null  && !attr.getText().equals("")) {
				fico.setScoreId(Long.parseLong(attr.getText()));
			}
			attr = root.attribute("score");
			if (attr != null && !attr.getText().equals("")) {
				fico.setScore(Integer.parseInt(attr.getText()));
			}
			attr = root.attribute("reason");
			if (attr != null) {
				fico.setReason(attr.getText());
			}
			attr = root.attribute("fraud");
			if (attr != null) {
				fico.setFraud(attr.getText());
			}
			
			attr = null;
		}

		return fico;
	}
	
	/*public static void main(String[] args) throws Exception {
		String message="<Response retCode=\"000\" scoreID=\"\" score=\"733\"  reason=\"3001,2001,2002\"/>";
		new FicoMessageParser().parse(message);
		
	}*/
	
}
