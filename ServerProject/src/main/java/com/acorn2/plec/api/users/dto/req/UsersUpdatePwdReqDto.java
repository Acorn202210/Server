package com.acorn2.plec.api.users.dto.req;

public class UsersUpdatePwdReqDto {
	private String lecUserId;
	private String userPwd;
	private String newPwd;

	public UsersUpdatePwdReqDto() {}

	public UsersUpdatePwdReqDto(String lecUserId, String userPwd, String newPwd) {
		super();
		this.lecUserId = lecUserId;
		this.userPwd = userPwd;
		this.newPwd = newPwd;
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

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	
}
