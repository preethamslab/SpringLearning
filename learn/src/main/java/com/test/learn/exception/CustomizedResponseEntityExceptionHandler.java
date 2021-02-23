package com.test.learn.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.test.learn.user.UserNotFoundException;
import com.test.learn.user.posts.UserPostNotExistsException;


@ControllerAdvice
//across all the other controllers available
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	 @ExceptionHandler(Exception.class)
	 public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest request)
	 {
		  ExceptionResponse exResponse = new ExceptionResponse(new Date(), 
				  ex.getMessage(), request.getDescription(false));
		  return new ResponseEntity(exResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	 
	 @ExceptionHandler(UserNotFoundException.class)
	 public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,
			 WebRequest request)
	 {
		 ExceptionResponse exResponse = new ExceptionResponse(new Date(), 
				  ex.getMessage(), request.getDescription(false));
		 
		 return new ResponseEntity(exResponse,HttpStatus.NOT_FOUND);
	 }
	 
	 @ExceptionHandler(UserPostNotExistsException.class)
	 public final ResponseEntity<Object> handleUserPostNotFoundException(
			 UserNotFoundException ex,WebRequest request)
	 {
		 ExceptionResponse exResponse = new ExceptionResponse(new Date(), 
				  ex.getMessage(), request.getDescription(false));
		 
		 return new ResponseEntity(exResponse,HttpStatus.NOT_FOUND);
	 }
	
	 @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) 
	 {
		 ExceptionResponse exResponse = new ExceptionResponse(new Date(), 
				  " Name must be minimum of 2 characters", ex.getBindingResult().toString());
		return new ResponseEntity(exResponse,HttpStatus.BAD_REQUEST);
	 }
	 
	 
} 
