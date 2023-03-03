package com.acorn2.plec.common;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	 private HttpStatus httpStatus;
	 private String code;
	 private Date timestamp; // 에러가 발생한 시간
	 private String message; // 메세지 담을 필드
	 private String details; // 상세내용 담을 필드
	
	 public ExceptionResponse() {}

	public ExceptionResponse(HttpStatus httpStatus, String code, Date timestamp, String message, String details) {
		super();
		this.httpStatus = httpStatus;
		this.code = code;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
