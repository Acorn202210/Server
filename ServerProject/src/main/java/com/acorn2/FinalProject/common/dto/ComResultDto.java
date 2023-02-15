package com.acorn2.FinalProject.common.dto;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @programName : ResultDto
 * @author : cwcho
 * @description : 응답 전문 공통부분 구조
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComResultDto {
	@Schema(description = "http status code", example = "200")
	private int httpStatusCode = HttpStatus.OK.value();
	@Schema(description = "결과 코드", example = "20000000")
	private String code = "20000000";
	@Schema(description = "결과 메세지", example = "정상 처리 되었습니다.")
	private String message = "정상 처리 되었습니다.";
	@Schema(description = "에러 상세 메세지", example = "에러 상세 메세지")
	private String detailMessage = null;

	@JsonInclude(Include.NON_NULL)
	@Hidden
	private String status = null;
	@JsonIgnore
	private HttpHeaders httpHeaders;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}

	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}
}
