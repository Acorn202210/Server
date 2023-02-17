package com.acorn2.FinalProject.lectureStudent.dto;

import org.apache.ibatis.type.Alias;

@Alias("lectureStudentDto")
public class LectureStudentDto {
	private int lec_Stu_Num;
	private String lec_Stu_User_Id;
	private int lec_Stu_Ref_Group;
	private String Complete_Yn;
	private String User_Regdate;
	private String Update_Date;
	private String email;
	private String phone;
	private String birth;
	private String large_category;
	private String small_category;
 
	
	public LectureStudentDto() {}


	public LectureStudentDto(int lec_Stu_Num, String lec_Stu_User_Id, int lec_Stu_Ref_Group, String complete_Yn,
			String user_Regdate, String update_Date, String email, String phone, String birth, String large_category,
			String small_category) {
		super();
		this.lec_Stu_Num = lec_Stu_Num;
		this.lec_Stu_User_Id = lec_Stu_User_Id;
		this.lec_Stu_Ref_Group = lec_Stu_Ref_Group;
		Complete_Yn = complete_Yn;
		User_Regdate = user_Regdate;
		Update_Date = update_Date;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.large_category = large_category;
		this.small_category = small_category;
	}


	public int getLec_Stu_Num() {
		return lec_Stu_Num;
	}


	public void setLec_Stu_Num(int lec_Stu_Num) {
		this.lec_Stu_Num = lec_Stu_Num;
	}


	public String getLec_Stu_User_Id() {
		return lec_Stu_User_Id;
	}


	public void setLec_Stu_User_Id(String lec_Stu_User_Id) {
		this.lec_Stu_User_Id = lec_Stu_User_Id;
	}


	public int getLec_Stu_Ref_Group() {
		return lec_Stu_Ref_Group;
	}


	public void setLec_Stu_Ref_Group(int lec_Stu_Ref_Group) {
		this.lec_Stu_Ref_Group = lec_Stu_Ref_Group;
	}


	public String getComplete_Yn() {
		return Complete_Yn;
	}


	public void setComplete_Yn(String complete_Yn) {
		Complete_Yn = complete_Yn;
	}


	public String getUser_Regdate() {
		return User_Regdate;
	}


	public void setUser_Regdate(String user_Regdate) {
		User_Regdate = user_Regdate;
	}


	public String getUpdate_Date() {
		return Update_Date;
	}


	public void setUpdate_Date(String update_Date) {
		Update_Date = update_Date;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getLarge_category() {
		return large_category;
	}


	public void setLarge_category(String large_category) {
		this.large_category = large_category;
	}


	public String getSmall_category() {
		return small_category;
	}


	public void setSmall_category(String small_category) {
		this.small_category = small_category;
	}

	
	
	
}
