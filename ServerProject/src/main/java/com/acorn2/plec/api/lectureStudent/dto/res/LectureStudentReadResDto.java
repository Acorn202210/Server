package com.acorn2.plec.api.lectureStudent.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "수강 학생 정보")
public class LectureStudentReadResDto {
	private String lecUserId;
	private String userBirth;
	private String userPhone;
	private String userEmail;
	private String userRegdate;
	
	public String getLecUserId() {
		return lecUserId;
	}
	public void setLecUserId(String lecUserId) {
		this.lecUserId = lecUserId;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}
	
	
	
	
	
	
	
}
