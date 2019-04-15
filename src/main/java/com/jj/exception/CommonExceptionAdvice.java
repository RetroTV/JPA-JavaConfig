package com.jj.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CommonExceptionAdvice {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		
		log.error("Exception......" + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		
		return "error/commonerror";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex, Model model) {
		
		log.error("Exception......" + ex.getMessage());
		model.addAttribute(model);
		log.error(model);
		
		return "error/404error";
	}
}