package com.acorn2.plec.api.faq.dto.res;

import java.util.List;

import com.acorn2.plec.common.dto.PagingDto;
import com.acorn2.plec.common.dto.PagingResponseDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "코드 목록")
public class FaqReadListResDto extends PagingResponseDto {
	public FaqReadListResDto() {
		super(0, new PagingDto());
	}

	public FaqReadListResDto(Integer totalCount, PagingDto comPageDto) {
		super(totalCount, comPageDto);
	}

	@Schema(description = "코드 목록", example = "", required = true, minLength = 1, maxLength = 50)
	private List<FaqReadResDto> data;

	public List<FaqReadResDto> getData() {
		return data;
	}

	public void setData(List<FaqReadResDto> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
	    return "FaqReadListResDto{" +
	            "data=" + data +
	            '}';
	}
}
