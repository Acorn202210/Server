package com.acorn2.plec.api.qnafree.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QnaFreeNotFoundException extends RuntimeException {
	public QnaFreeNotFoundException(String message) {
		super(message);
	}
}
