package com.devdesk.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devdesk.response.CommonResponse;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<String> errorList = new ArrayList<>();
		for(ObjectError error : ex.getBindingResult().getAllErrors())
				errorList.add(error.getDefaultMessage());
		
		CommonResponse response = new CommonResponse(HttpStatus.BAD_REQUEST.toString(), "", errorList.toString());
		
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
		return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
	}
	
}
