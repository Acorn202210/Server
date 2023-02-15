package com.acorn2.FinalProject.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComResponseDto<T> extends ComResultDto {

	public ComResponseDto() {
	}

	public ComResponseDto(T body) {
		this.setBody(body);
	}

	private T body;

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		// 조회결과가 null 일경우, 404 조회결과가 없습니다. 리턴
//		if (HttpMethod.GET.toString().equals(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getMethod())
//				&& body == null) {
//			throw new RestException("data_not_found");
//		}
		this.body = body;
	}
}
