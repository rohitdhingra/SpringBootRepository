package com.rohit.poc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
