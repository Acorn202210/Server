package com.acorn2.FinalProject.lectureStudent.dto.req;

import com.acorn2.FinalProject.common.dto.PagingDto;

public class LectureStudentReadReqDto extends PagingDto{

	private String lecStuUserId;
	private int lecStuRefGroup;
	private String largeCategory;
	private String smallCategory;
	private String id;
	private String birth;
	private String phone;
	private String email;
	private String userRegdate;

	
	public LectureStudentReadReqDto() {}


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


	public String getLargeCategory() {
		return largeCategory;
	}


	public void setLargeCategory(String largeCategory) {
		this.largeCategory = largeCategory;
	}


	public String getSmallCategory() {
		return smallCategory;
	}


	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
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


	public String getUserRegdate() {
		return userRegdate;
	}


	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}


	


	
	
	
}
