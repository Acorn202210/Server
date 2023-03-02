package com.acorn2.plec.common;

import java.util.Date;

public class ExceptionResponse {
	 private String isSuccess;
	 private Date timestamp; // 에러가 발생한 시간
	 private String message; // 메세지 담을 필드
	 private String details; // 상세내용 담을 필드
	
	 public ExceptionResponse() {}

	public ExceptionResponse(String isSuccess, Date timestamp, String message, String details) {
		super();
		this.isSuccess = isSuccess;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	 
	
}
