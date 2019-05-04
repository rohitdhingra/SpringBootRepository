package com.poc.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyDemoController {

	private String quotes[] = {"To be or not to be Shakespeare","Spring is nature way of saying party","the time is always right"};
	//http://localhost:8080/springMvcProject/getQuote.html
	@RequestMapping(value="/getQuote")
	public String getRandomQuote(Model model)
	{
		int random = new Random().nextInt(quotes.length);
		
		String randomQuote = quotes[random];
		model.addAttribute("randomQuote",randomQuote);
		return "quote";
	}
	
}
