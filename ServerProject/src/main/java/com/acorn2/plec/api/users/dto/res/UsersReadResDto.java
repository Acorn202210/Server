package com.acorn2.plec.api.users.dto.res;



import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "회원 정보")
public class UsersReadResDto {
	@Schema(description = "아이디", example = "acorn", required = true, minLength = 1, maxLength = 50)
	private String lecUserId;
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
	
	public UsersReadResDto() {}

	public UsersReadResDto(String lecUserId, String userEmail, String userRegdate, String userPhone, String userBirth,
			String userNickname) {
		super();
		this.lecUserId = lecUserId;
		this.userEmail = userEmail;
		this.userRegdate = userRegdate;
		this.userPhone = userPhone;
		this.userBirth = userBirth;
		this.userNickname = userNickname;
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
	
	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
}
