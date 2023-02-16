package com.acorn2.FinalProject.faq.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FaqNotFoundException extends RuntimeException{
	public FaqNotFoundException(String message) {
		super(message);
	}
}
