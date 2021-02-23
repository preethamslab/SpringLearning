package com.restaurant.qrcode;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QRNotFoundException extends RuntimeException
{
	public QRNotFoundException(String msg) 
	{
		super(msg);
	}
}
