package com.acorn2.plec.api.lectureReview.dto.res;

import java.util.List;

import com.acorn2.plec.common.dto.PagingDto;
import com.acorn2.plec.common.dto.PagingResponseDto;

import io.swagger.v3.oas.annotations.media.Schema;



public class LectureReviewReadListResDto extends PagingResponseDto{
	public LectureReviewReadListResDto() {
		super(0, new PagingDto());
	}
	
	public LectureReviewReadListResDto(Integer totalCount, PagingDto PageDto) {
		super(totalCount, PageDto);
	}
	
	@Schema(description = "강의 후기 목록", example = "", required = true, minLength = 1, maxLength = 50)
	private List<LectureReviewReadResDto> data;

	public List<LectureReviewReadResDto> getData() {
		return data;
	}

	public void setData(List<LectureReviewReadResDto> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
	    return "LectureReviewReadListResDto{" +
	            "data=" + data +
	            '}';
	}

}
