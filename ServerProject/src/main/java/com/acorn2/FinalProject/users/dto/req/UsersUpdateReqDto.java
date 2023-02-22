package com.acorn2.FinalProject.users.dto.req;

public class UsersUpdateReqDto {
	private String lecUserId;
	private String userEmail;
	private String userPhone;
	private String userNickname;
	private String userProfile;

	public UsersUpdateReqDto() {}

	public UsersUpdateReqDto(String lecUserId, String userEmail, String userPhone, String userNickname,
			String userProfile) {
		super();
		this.lecUserId = lecUserId;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userNickname = userNickname;
		this.userProfile = userProfile;
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

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	
}
