package com.acorn2.plec.api.users.dto.req;

public class UsersUpdateReqDto {
	private String lecUserId;
	private String userEmail;
	private String userPhone;
	private String profile_num;

	public UsersUpdateReqDto() {}

	public UsersUpdateReqDto(String lecUserId, String userEmail, String userPhone, String profile_num) {
		super();
		this.lecUserId = lecUserId;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.profile_num = profile_num;
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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getProfile_num() {
		return profile_num;
	}

	public void setProfile_num(String profile_num) {
		this.profile_num = profile_num;
	}


}
