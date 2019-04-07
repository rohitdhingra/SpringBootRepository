package com.rohit.poc.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.rohit.poc.model.Message;
import com.rohit.poc.model.OutputMessage;

@Controller
public class MessageController {

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(final Message message)
	{
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		return new OutputMessage(message.getFrom(),message.getText(),time);
	}
}
