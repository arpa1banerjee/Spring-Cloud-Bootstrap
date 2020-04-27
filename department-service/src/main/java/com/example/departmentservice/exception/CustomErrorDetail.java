package com.example.departmentservice.exception;

import java.util.Date;

public class CustomErrorDetail {
	
	private Date timestamp;
	private String message;
	private String details;
	
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	public CustomErrorDetail(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
}