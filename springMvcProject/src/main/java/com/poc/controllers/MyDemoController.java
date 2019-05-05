package com.poc.controllers;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poc.model.Account;

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
	
	@RequestMapping(value="createAccount")
	public String createAccount(@Valid @ModelAttribute("aNewAccount") Account account,BindingResult result)
	{
		
		if(result.hasErrors())
		{
			System.out.println("Form has errors");
			return "createAccount";
		}
		System.out.println("Form was validated");
		System.out.println(account);
		return "createAccount";
	}
	
	@RequestMapping(value="/accountCreated")
	public String performCreate(Account account)
	{
		System.out.println(account);
		return "accountCreated";
	}
	
	
}
