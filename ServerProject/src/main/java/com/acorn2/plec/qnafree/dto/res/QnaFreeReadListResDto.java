package com.acorn2.plec.qnafree.dto.res;

import java.util.List;

import com.acorn2.plec.common.dto.PagingDto;
import com.acorn2.plec.common.dto.PagingResponseDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "코드 목록")
public class QnaFreeReadListResDto extends PagingResponseDto {

	public QnaFreeReadListResDto() {
		super(0, new PagingDto());
	}
	
	public QnaFreeReadListResDto(Integer totalCount, PagingDto comPageDto) {
		super(totalCount, comPageDto);		
	}

	@Schema(description = "코드 목록", example = "", required = true, minLength = 1, maxLength = 50)
	private List<QnaFreeReadResDto> data;
	
	public List<QnaFreeReadResDto> getData() {
		return data;
	}

	public void setData(List<QnaFreeReadResDto> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
	    return "QnaFreeReadListResDto{" +
	            "data=" + data +
	            '}';
	}
}
