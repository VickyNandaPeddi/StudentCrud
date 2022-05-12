package com.example.studentcrud.Exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * handles global exception returns error response
	 * 
	 * @return
	 */
	public ErrorResponse handleGlobalException(Exception e, HttpServletResponse response) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(e.getMessage());
		errorResponse.setSucess(false);
		return errorResponse;
	}

}
