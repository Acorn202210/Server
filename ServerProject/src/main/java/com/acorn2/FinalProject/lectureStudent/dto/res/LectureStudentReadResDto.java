package com.acorn2.FinalProject.lectureStudent.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "수강 학생 정보")
public class LectureStudentReadResDto {
	private String id;
	private String birth;
	private String phone;
	private String email;
	private String User_Regdate;
	public String getLec_Stu_User_Id() {
		return id;
	}
	public void setLec_Stu_User_Id(String lec_Stu_User_Id) {
		this.id = lec_Stu_User_Id;
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
	public String getUser_Regdate() {
		return User_Regdate;
	}
	public void setUser_Regdate(String user_Regdate) {
		User_Regdate = user_Regdate;
	}

	
	
	
	
}
