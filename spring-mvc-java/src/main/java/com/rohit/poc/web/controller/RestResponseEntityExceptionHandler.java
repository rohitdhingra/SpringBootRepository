package com.rohit.poc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Some Parameters are invalid222")
	public void onIllegalArgumentException(IllegalArgumentException exception)
	{
		
	}

	
}
