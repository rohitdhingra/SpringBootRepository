package com.poc.controllers;

import java.io.FileOutputStream;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	@ModelAttribute
	public void setUserDetails(@RequestParam("userName") String userName,Model model)
	{
		model.addAttribute("userName",userName);
		model.addAttribute("userRole", "Technical Lead");
	}
	
	@RequestMapping(value="/createAccount")
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
	
	@RequestMapping(value="/doCreate")
	public String doCreate(@ModelAttribute("aNewAccount") Account account)
	{
		System.out.println("New Account Info:::::"+account);
		return "redirect:accConfirm";
	}
	
	@RequestMapping(value="/accConfirm")
	public String accountConfirmation(@ModelAttribute("aNewAccount") Account account)
	{
		System.out.println("New Account Info:::::"+account);
		return "accountConfirmed";
	}
	
	@RequestMapping(value="/accountCreated")
	public String performCreate(Account account)
	{
		System.out.println("New Account Info:::::"+account);
		return "accountCreated";
	}
	
	@RequestMapping(value="/myForm")
	public String myForm()
	{
		return "myForm";
	}
	
	@RequestMapping(value="/handleForm")
	public String handleForm(@RequestParam("file") MultipartFile file)
	{
	try {
		if(!file.isEmpty())
		{
			byte[] bytes = file.getBytes();
			FileOutputStream fos = new FileOutputStream("C:\\rohit\\rohit.txt");
			fos.write(bytes);
			fos.close();
			System.out.println("File Saved Successfully!!");
		}
		else
		{
			System.out.println("No file available to save");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return "operationComplete";
	}
}
