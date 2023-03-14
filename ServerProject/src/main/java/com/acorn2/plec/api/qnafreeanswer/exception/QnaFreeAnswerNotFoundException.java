package com.acorn2.plec.api.qnafreeanswer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QnaFreeAnswerNotFoundException extends RuntimeException{
	public QnaFreeAnswerNotFoundException(String message) {
		super(message);
	}
}
