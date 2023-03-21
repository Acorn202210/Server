package com.acorn2.plec.api.qnaboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QnaNotFoundException extends RuntimeException{
	public QnaNotFoundException(String msg) {
		super(msg);
	}
}
