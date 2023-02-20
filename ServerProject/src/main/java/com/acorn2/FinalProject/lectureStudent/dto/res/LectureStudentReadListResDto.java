package com.acorn2.FinalProject.lectureStudent.dto.res;

import java.util.List;

import com.acorn2.FinalProject.common.dto.PagingDto;
import com.acorn2.FinalProject.common.dto.PagingResponseDto;

import io.swagger.v3.oas.annotations.media.Schema;

public class LectureStudentReadListResDto extends PagingResponseDto{
	public LectureStudentReadListResDto() {
		super(0, new PagingDto());
	}
	public LectureStudentReadListResDto(Integer totalCount, PagingDto PageDto) {
		super(totalCount, PageDto);
	}
	
	@Schema(description = "수강 학생 목록", example = "", required = true, minLength = 1, maxLength = 50)
	private List<LectureStudentReadResDto> data;
	
	public List<LectureStudentReadResDto> getData(){
		return data;
	}
	
	public void setData(List<LectureStudentReadResDto> data) {
		this.data = data;
	}
}
