package com.hospitalmanagementsystem.exception;

import java.util.Date;

public class ErrorDetails {

	private Date TimeStamp;
	private String message;
	private String Details;
	
	public ErrorDetails(Date timeStamp, String message, String details) {
		super();
		this.TimeStamp = timeStamp;
		this.message = message;
		this.Details = details;
	}
	
	public Date getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.TimeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		this.Details = details;
	}
	
	
	
}
