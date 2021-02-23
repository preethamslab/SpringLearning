package com.test.learn.user.posts;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserPostNotExistsException extends RuntimeException 
{
	public UserPostNotExistsException(String msg) 
	{
		super(msg);
	}
}
