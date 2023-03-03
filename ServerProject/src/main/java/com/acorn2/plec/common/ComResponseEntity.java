package com.acorn2.plec.common;

import org.springframework.http.HttpStatus;

import com.acorn2.plec.common.dto.ComResponseDto;

public class ComResponseEntity<T> extends org.springframework.http.ResponseEntity<ComResponseDto<T>> {
	public ComResponseEntity() {
		super(new ComResponseDto<T>(), HttpStatus.OK);
	}

	public ComResponseEntity(ComResponseDto<T> body) {
		super(body, HttpStatus.OK);
		body.setHttpStatusCode(HttpStatus.OK.value());
	}

	public ComResponseEntity(ComResponseDto<T> body, HttpStatus httpStatus) {
		super(body, httpStatus);
		body.setHttpStatusCode(httpStatus.value());
	}

	public ComResponseEntity(HttpStatus httpStatus) {
		super(httpStatus);
	}
}
