package com.test.learn.user.h2jpa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserJPANotFoundException extends RuntimeException 
{
	public UserJPANotFoundException(String msg) 
	{
		super(msg);
	}
}
