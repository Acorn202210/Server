package com.acorn2.plec.users.dto.req;

public class UsersLoginReqDto {
	private String lecUserId;
	private String userPwd;
	
	public UsersLoginReqDto() {}

	public UsersLoginReqDto(String lecUserId, String userPwd) {
		super();
		this.lecUserId = lecUserId;
		this.userPwd = userPwd;
	}

	public String getLecUserId() {
		return lecUserId;
	}

	public void setLecUserId(String lecUserId) {
		this.lecUserId = lecUserId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
}
