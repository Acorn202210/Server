package com.acorn2.plec.api.lectureStudent.dto.req;



import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "강의 완료")
public class LectureStudentUpdateReqDto {
	
	private Integer lecStuRefGroup;

	public Integer getLecStuRefGroup() {
		return lecStuRefGroup;
	}

	public void setLecStuRefGroup(Integer lecStuRefGroup) {
		this.lecStuRefGroup = lecStuRefGroup;
	}
	
}
