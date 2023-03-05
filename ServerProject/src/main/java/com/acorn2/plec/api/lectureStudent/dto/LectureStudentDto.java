package com.acorn2.plec.api.lectureStudent.dto;

public class LectureStudentDto {
	private int lecStuNum;
	private String lecStuUserId;
	private int lecStuRefGroup;
	private String completeYn;
	private String userRegdate;
	private String updateDate;
	private String email;
	private String phone;
	private String birth;
	private String largeCategory;
	private String smallCategory;
 
	
	public LectureStudentDto() {}


	public LectureStudentDto(int lecStuNum, String lecStuUserId, int lecStuRefGroup, String completeYn,
			String userRegdate, String updateDate, String email, String phone, String birth, String largeCategory,
			String smallCategory) {
		super();
		this.lecStuNum = lecStuNum;
		this.lecStuUserId = lecStuUserId;
		this.lecStuRefGroup = lecStuRefGroup;
		this.completeYn = completeYn;
		this.userRegdate = userRegdate;
		this.updateDate = updateDate;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.largeCategory = largeCategory;
		this.smallCategory = smallCategory;
	}


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


	

	
	
	
}
