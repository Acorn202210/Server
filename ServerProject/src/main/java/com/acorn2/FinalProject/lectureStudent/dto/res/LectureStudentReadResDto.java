package com.acorn2.FinalProject.lectureStudent.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "수강 학생 정보")
public class LectureStudentReadResDto {
	private String id;
	private String birth;
	private String phone;
	private String email;
	private String userRegdate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}
	
	

	
	
	
	
}
