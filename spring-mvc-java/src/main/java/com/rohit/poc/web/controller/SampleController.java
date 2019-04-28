package com.rohit.poc.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
//	@ExceptionHandler(IllegalArgumentException.class)
//	@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Some Parameters are invalid")
//	public void onIllegalArgumentException(IllegalArgumentException exception)
//	{
//		
//	}
	@GetMapping("/hello")
	ResponseEntity<String> hello(){
//		return new ResponseEntity<>("Hello World!",HttpStatus.OK);
		return ResponseEntity.ok("Hello World 2!!");
		
	}
	
	
	@GetMapping("/age")
	ResponseEntity<String> age(@RequestParam(name="yearOfBirth",required=false) int yearOfBirth )
	{
		if(yearOfBirth>2019)
		{
			return ResponseEntity.badRequest().body("Year of Birth cannot be future date22");
//			return new ResponseEntity<>("Year of Birth cannot be future date",HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body("Year of Birth 222is "+yearOfBirth);
//		return new ResponseEntity<>("Year of Birth is"+yearOfBirth,HttpStatus.OK);
	}
	
	@GetMapping("/customHeader")
	ResponseEntity<String> customHeader()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "fooo");
		return ResponseEntity.ok().header("Custom-Header", "fooo232223").body("Custom Header Set22");
//		return new ResponseEntity<>("Custom Header Set",headers,HttpStatus.OK);
	}
	
	
	@GetMapping("/manual")
	void manual(HttpServletResponse response) throws IOException
	{
		response.setHeader("Custom-Header", "foo");
		response.setStatus(200);
		response.getWriter().println("Hello World!!");
	}
}
