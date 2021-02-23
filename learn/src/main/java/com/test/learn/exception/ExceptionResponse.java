package com.test.learn.exception;

import java.util.Date;


public class ExceptionResponse
{
	private Date timeStamp;
	private String message;
	private String details;
	
	protected ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public ExceptionResponse(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	
}
