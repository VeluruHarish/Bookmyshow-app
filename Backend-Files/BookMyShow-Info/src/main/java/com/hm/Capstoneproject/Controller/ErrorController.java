package com.hm.Capstoneproject.Controller;



import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hm.Capstoneproject.Exception.NoSuchElementException;
import com.hm.Capstoneproject.dto.ErrorResponse;

@RestControllerAdvice
public class ErrorController {
	
	
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {NoSuchElementException.class})
	public ErrorResponse handleNoSuchElementException(Exception ex,HttpServletRequest request) {
		
		LocalDateTime timestamp=LocalDateTime.now();
		int status=HttpStatus.NOT_FOUND.value();
		String error=HttpStatus.NOT_FOUND.getReasonPhrase();
		String message=ex.getMessage();
		String path=request.getRequestURI();
		return new ErrorResponse (timestamp,status,error,message,path);	
	}
	
	
}
