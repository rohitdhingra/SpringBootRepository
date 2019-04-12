package com.rohit.poc.websocket.client;

import java.lang.reflect.Type;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {
	private Logger logger = LogManager.getLogger(MyStompSessionHandler.class);

	@Override
	public Type getPayloadType(StompHeaders headers) {
		// TODO Auto-generated method stub
		return Message.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		// TODO Auto-generated method stub
		Message msg = (Message) payload;
		logger.info("Received : "+ msg.getText()+"from : "+msg.getFrom());
	}

	@Override
	public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
	logger.info("New Session established:"+session.getSessionId());
	session.subscribe("/topic/messages",this);
	logger.info("Subscibed to /topic/messages");
	session.send("/app/chat", getSampleMessage());
	}

	private Message getSampleMessage() {
		// TODO Auto-generated method stub
		Message msg = new Message();
		msg.setFrom("Rohit");
		msg.setText("Hi");
		return msg;
	}

	@Override
	public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload,
			Throwable exception) {
		// TODO Auto-generated method stub
		super.handleException(session, command, headers, payload, exception);
	}

	
}
