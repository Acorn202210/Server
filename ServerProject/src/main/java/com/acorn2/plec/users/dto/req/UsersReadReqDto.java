package com.acorn2.plec.users.dto.req;

import com.acorn2.plec.common.dto.PagingDto;

import io.swagger.v3.oas.annotations.media.Schema;

public class UsersReadReqDto extends PagingDto{
	private String lecUserId;
	private String userEmail;
	private String userRegdate;
	private String userPhone;
	private String userBirth;
	
	public UsersReadReqDto() {}

	public UsersReadReqDto(String lecUserId, String userEmail, String userRegdate, String userPhone, String userBirth) {
		super();
		this.lecUserId = lecUserId;
		this.userEmail = userEmail;
		this.userRegdate = userRegdate;
		this.userPhone = userPhone;
		this.userBirth = userBirth;
	}

	public String getLecUserId() {
		return lecUserId;
	}

	public void setLecUserId(String lecUserId) {
		this.lecUserId = lecUserId;
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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	
	
}
