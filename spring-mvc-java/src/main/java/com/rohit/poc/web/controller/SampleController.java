package com.rohit.poc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/spring-mvc-java")
public class SampleController {
	@GetMapping("/sample")
	public String showForm() {
		return "sample";
	}
	
	@RequestMapping(value="/ex/foos",headers={"key1=val1","key2=val2"},method=RequestMethod.GET	)
	@ResponseBody
	public String getFoosBySimplePath()
	{
		return "Get some Foos with headers";
	}
	
	@RequestMapping(value="/ex/foos/acce",headers="Accept=application/json",
			method=RequestMethod.GET, produces="application/json"	)
	@ResponseBody
	public String getFoosBySimplePathAccept()
	{
		return "Get some Foos with headers";
	}
	
	@RequestMapping(value = "*", method = RequestMethod.GET)
	@ResponseBody
	public String getFallback() {
		return "Fallback for GET Requests";
	}
	
	@RequestMapping(value="/exceptionCheck",method=RequestMethod.POST)
	@ResponseBody
	public String exceptionCheck(@RequestParam("id") String id )
	{
		if(id.equals("123"))
		{
			throw new IllegalArgumentException();
		}
		return "Get some Foos with headers"+id;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void onIllegalArgumentException(IllegalArgumentException exception)
	{
		
	}
}
