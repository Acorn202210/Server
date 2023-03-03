package com.acorn2.plec.lectureStudent.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

public class LectureStudentOneReadResDto {
	@Schema(description = "수강생 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int lecStuNum;
	@Schema(description = "수강생 아이디", example = "admin", required = true, minLength = 1, maxLength = 50)
	private String lecStuUserId;
	@Schema(description = "강의의 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int lecStuRefGroup;
	@Schema(description = "강의 완료 여부", example = "N", required = true, minLength = 1, maxLength = 3)
	private String completeYn;
	@Schema(description = "수강 시작 날짜", example = "2022-01-01", required = true, minLength = 1, maxLength = 30)
	private String userRegdate;
	@Schema(description = "수강 변경 날짜", example = "2022-01-02", required = true, minLength = 1, maxLength = 30)
	private String updateDate;
	public int getLecStuNum() {
		return lecStuNum;
	}
	public void setLecStuNum(int lecStuNum) {
		this.lecStuNum = lecStuNum;
	}
	public String getLecStuUserId() {
		return lecStuUserId;
	}
	public void setLecStuUserId(String lecStuUserId) {
		this.lecStuUserId = lecStuUserId;
	}
	public int getLecStuRefGroup() {
		return lecStuRefGroup;
	}
	public void setLecStuRefGroup(int lecStuRefGroup) {
		this.lecStuRefGroup = lecStuRefGroup;
	}
	public String getCompleteYn() {
		return completeYn;
	}
	public void setCompleteYn(String completeYn) {
		this.completeYn = completeYn;
	}
	public String getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	
}
