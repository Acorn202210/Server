package com.acorn2.plec.lectureStudent.dto.req;



import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "강의 완료")
public class LectureStudentUpdateReqDto {
	
	private int lecStuNum;
	
	public int getLecStuNum() {
		return lecStuNum;
	}
	public void setLecStuNum(int lecStuNum) {
		this.lecStuNum = lecStuNum;
	}

	
}
