package com.acorn2.FinalProject.lectureReview.dto;

import java.util.List;

import com.acorn2.FinalProject.common.dto.PagingDto;
import com.acorn2.FinalProject.common.dto.PagingResponseDto;

import io.swagger.v3.oas.annotations.media.Schema;



public class LectureReviewReadListRes extends PagingResponseDto{
	public LectureReviewReadListRes() {
		super(0, new PagingDto());
	}
	
	public LectureReviewReadListRes(Integer totalCount, PagingDto PageDto) {
		super(totalCount, PageDto);
	}
	
	@Schema(description = "코드 목록", example = "", required = true, minLength = 1, maxLength = 50)
	private List<LectureReviewReadRes> data;

	public List<LectureReviewReadRes> getData() {
		return data;
	}

	public void setData(List<LectureReviewReadRes> data) {
		this.data = data;
	}

}
