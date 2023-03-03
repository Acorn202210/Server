package com.acorn2.plec.lectureStudent.dto.req;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "수강 신청")
public class LectureStudentCreateReqDto {
	@Schema(description = "강의의 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	@NotEmpty
	@Size(min = 1, max = 50)
	private int lecStuRefGroup;

	public int getLecStuRefGroup() {
		return lecStuRefGroup;
	}
	public void setLecStuRefGroup(int lecStuRefGroup) {
		this.lecStuRefGroup = lecStuRefGroup;
	}

	
	
	
	
}
