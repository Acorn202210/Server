package com.acorn2.plec.api.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UsersNotLoginException extends RuntimeException{
	public UsersNotLoginException(String message) {
		super(message);
	}
}
