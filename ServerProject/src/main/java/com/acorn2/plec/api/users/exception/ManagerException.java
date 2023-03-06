package com.acorn2.plec.api.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ManagerException extends RuntimeException{
	public ManagerException(String message) {
		super(message);
	}
}
