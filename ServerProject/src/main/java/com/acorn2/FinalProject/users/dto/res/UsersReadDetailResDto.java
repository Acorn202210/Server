package com.acorn2.FinalProject.users.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

public class UsersReadDetailResDto {
	@Schema(description = "아이디", example = "acorn", required = true, minLength = 1, maxLength = 50)
	private String lecUserId;
	@Schema(description = "비밀번호", example = "xxxx", required = true, minLength = 1, maxLength = 100)
	private String userPwd;
	@Schema(description = "이메일", example = "aaa@google.com", required = true, minLength = 1, maxLength = 100)
	private String userEmail;
	@Schema(description = "회원 등록일", example = "2023.02.20", required = true, minLength = 1, maxLength = 50)
	private String userRegdate;
	@Schema(description = "핸드폰 번호", example = "010-1234-5678", required = true, minLength = 1, maxLength = 32)
	private String userPhone;
	@Schema(description = "생년월일", example = "2023.02.20", required = true, minLength = 1, maxLength = 50)
	private String userBirth;
	@Schema(description = "닉네임", example = "에이콘", required = true, minLength = 1, maxLength = 50)
	private String userNickname;
	@Schema(description = "매니저 여부", example = "Y", required = true, minLength = 1, maxLength = 3)
	private String managerYn;
	
	
	public UsersReadDetailResDto() {}


	public UsersReadDetailResDto(String lecUserId, String userPwd, String userEmail, String userRegdate,
			String userPhone, String userBirth, String userNickname, String managerYn) {
		super();
		this.lecUserId = lecUserId;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userRegdate = userRegdate;
		this.userPhone = userPhone;
		this.userBirth = userBirth;
		this.userNickname = userNickname;
		this.managerYn = managerYn;
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


	public String getUserNickname() {
		return userNickname;
	}


	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}


	public String getManagerYn() {
		return managerYn;
	}


	public void setManagerYn(String managerYn) {
		this.managerYn = managerYn;
	}

	
}
