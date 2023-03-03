package com.acorn2.plec.notice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoticeNotFoundException extends RuntimeException{
	public NoticeNotFoundException(String message) {
		super(message);
	}
}
