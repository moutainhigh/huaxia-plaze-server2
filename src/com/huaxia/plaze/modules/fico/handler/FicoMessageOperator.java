package com.huaxia.plaze.modules.fico.handler;



import com.huaxia.plaze.modules.fico.domain.Fico;
import com.huaxia.plaze.modules.fico.parser.FicoMessageParser;
import com.huaxia.plaze.modules.fico.parser.MessageParser;



public class FicoMessageOperator extends MessageOperator<Fico>  {
	
	private MessageParser<Fico> messageParser;
	
	
	public FicoMessageOperator() {
		this.messageParser =  new FicoMessageParser();
	}

	public MessageParser<Fico> getMessageParser() {
		return messageParser;
	}

	public void setMessageParser(MessageParser<Fico> messageParser) {
		this.messageParser = messageParser;
	}

	@Override
	public Fico operate(String message) throws Exception {
		return getMessageParser().parse(message);
	}


}
