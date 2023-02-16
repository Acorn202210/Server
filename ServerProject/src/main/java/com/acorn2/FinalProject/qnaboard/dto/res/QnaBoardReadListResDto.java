package com.acorn2.FinalProject.qnaboard.dto.res;

import java.util.List;

import com.acorn2.FinalProject.common.dto.PagingDto;
import com.acorn2.FinalProject.common.dto.PagingResponseDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "코드 목록")
public class QnaBoardReadListResDto extends PagingResponseDto {

	public QnaBoardReadListResDto() {
		super(0, new PagingDto());
	}
	
	public QnaBoardReadListResDto(Integer totalCount, PagingDto comPageDto) {
		super(totalCount, comPageDto);		
	}

	@Schema(description = "코드 목록", example = "", required = true, minLength = 1, maxLength = 50)
	private List<QnaBoardReadResDto> data;
	
	public List<QnaBoardReadResDto> getData() {
		return data;
	}

	public void setData(List<QnaBoardReadResDto> data) {
		this.data = data;
	}
}
