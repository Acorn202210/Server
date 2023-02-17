package com.acorn2.FinalProject.lectureStudent.dto.req;

import com.acorn2.FinalProject.common.dto.PagingDto;

public class LectureStudentReadReqDto extends PagingDto{

	private String Lec_Stu_User_Id;
	private int lec_Stu_Ref_Group;
	private String large_category;
	private String small_category;
	private String id;
	private String birth;
	private String phone;
	private String email;
	private String User_Regdate;

	
	public LectureStudentReadReqDto() {}


	public LectureStudentReadReqDto(String lec_Stu_User_Id, int lec_Stu_Ref_Group, String large_category,
			String small_category, String id, String birth, String phone, String email, String user_Regdate) {
		super();
		Lec_Stu_User_Id = lec_Stu_User_Id;
		this.lec_Stu_Ref_Group = lec_Stu_Ref_Group;
		this.large_category = large_category;
		this.small_category = small_category;
		this.id = id;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		User_Regdate = user_Regdate;
	}


	public String getLec_Stu_User_Id() {
		return Lec_Stu_User_Id;
	}


	public void setLec_Stu_User_Id(String lec_Stu_User_Id) {
		Lec_Stu_User_Id = lec_Stu_User_Id;
	}


	public int getLec_Stu_Ref_Group() {
		return lec_Stu_Ref_Group;
	}


	public void setLec_Stu_Ref_Group(int lec_Stu_Ref_Group) {
		this.lec_Stu_Ref_Group = lec_Stu_Ref_Group;
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


	public String getUser_Regdate() {
		return User_Regdate;
	}


	public void setUser_Regdate(String user_Regdate) {
		User_Regdate = user_Regdate;
	}


	
	
}
