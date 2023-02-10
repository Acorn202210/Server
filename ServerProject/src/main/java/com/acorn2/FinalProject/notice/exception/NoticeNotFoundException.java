package com.acorn2.FinalProject.notice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoticeNotFoundException extends RuntimeException{
	public NoticeNotFoundException(String message) {
		System.out.println("ss");
		super(message);
	}
}
