package com.acorn2.plec.api.users.dto.req;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "회원 가입")
public class UsersCreateReqDto {
	@Schema(description = "아이디", example = "acorn", required = true, minLength = 1, maxLength = 50)
	@NotEmpty
	@Size(min = 1, max = 50)
	private String lecUserId;
	@NotEmpty
	@Size(min = 1, max = 100)
	@Schema(description = "비밀번호", example = "sss", required = true, minLength = 1, maxLength = 100)
	private String userPwd;
	@NotEmpty
	@Size(min = 1, max = 100)
	@Schema(description = "이메일", example = "aaa@google.com", required = true, minLength = 1, maxLength = 100)
	private String userEmail;
	@NotEmpty
	@Size(min = 1, max = 32)
	@Schema(description = "핸드폰 번호", example = "010-1234-5678", required = true, minLength = 1, maxLength = 32)
	private String userPhone;
	@NotEmpty
	@Size(min = 1, max = 50)
	@Schema(description = "생년월일", example = "2023.02.20", required = true, minLength = 1, maxLength = 50)
	private String userBirth;
	@NotEmpty
	@Size(min = 1, max = 3)
	@Schema(description = "관리자여부", example = "Y", required = true, minLength = 1, maxLength = 3)
	private String managerYn;
	
	public UsersCreateReqDto() {}

	public UsersCreateReqDto(@NotEmpty @Size(min = 1, max = 50) String lecUserId,
			@NotEmpty @Size(min = 1, max = 100) String userPwd, @NotEmpty @Size(min = 1, max = 100) String userEmail,
			@NotEmpty @Size(min = 1, max = 32) String userPhone, @NotEmpty @Size(min = 1, max = 50) String userBirth,
			@NotEmpty @Size(min = 1, max = 3) String managerYn) {
		super();
		this.lecUserId = lecUserId;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userBirth = userBirth;
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

	public String getManagerYn() {
		return managerYn;
	}

	public void setManagerYn(String managerYn) {
		this.managerYn = managerYn;
	}

	
	
	
}
