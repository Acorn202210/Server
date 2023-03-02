package com.acorn2.plec.lectureStudent.dto.req;

import com.acorn2.plec.common.dto.PagingDto;

public class LectureStudentReadReqDto extends PagingDto{

	private String lecStuUserId;
	private int lecStuRefGroup;
	private String largeCategory;
	private String smallCategory;
	private String lecUserId;
	private String userBirth;
	private String userPhone;
	private String userEmail;
	private String userRegdate;
	private String generalUserCode;
	private String keyword;
	private String condition;

	
	public LectureStudentReadReqDto() {}


	public LectureStudentReadReqDto(String lecStuUserId, int lecStuRefGroup, String largeCategory, String smallCategory,
			String lecUserId, String userBirth, String userPhone, String userEmail, String userRegdate,
			String generalUserCode, String keyword, String condition) {
		super();
		this.lecStuUserId = lecStuUserId;
		this.lecStuRefGroup = lecStuRefGroup;
		this.largeCategory = largeCategory;
		this.smallCategory = smallCategory;
		this.lecUserId = lecUserId;
		this.userBirth = userBirth;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userRegdate = userRegdate;
		this.generalUserCode = generalUserCode;
		this.keyword = keyword;
		this.condition = condition;
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


	public String getGeneralUserCode() {
		return generalUserCode;
	}


	public void setGeneralUserCode(String generalUserCode) {
		this.generalUserCode = generalUserCode;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	

	
	
}
