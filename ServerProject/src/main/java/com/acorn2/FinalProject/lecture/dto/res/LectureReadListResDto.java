package com.acorn2.FinalProject.lecture.dto.res;

import java.util.List;

import com.acorn2.FinalProject.common.dto.PagingDto;
import com.acorn2.FinalProject.common.dto.PagingResponseDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "강의 목록")
public class LectureReadListResDto extends PagingResponseDto{
	public LectureReadListResDto() {
		super(0, new PagingDto());
	}

	public LectureReadListResDto(Integer totalCount, PagingDto PageDto) {
		super(totalCount, PageDto);
	}

	@Schema(description = "강의 목록", example = "", required = true, minLength = 1, maxLength = 50)
	private List<LectureReadResDto> data;

	public List<LectureReadResDto> getData() {
		return data;
	}

	public void setData(List<LectureReadResDto> data) {
		this.data = data;
	}

}
