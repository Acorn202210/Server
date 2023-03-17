package com.acorn2.plec.api.users.dto.res;

public class MyLectureReadResDto {
	private Integer imageNum;
	private String Complete_Yn;
	
	public MyLectureReadResDto() {}
		
	public MyLectureReadResDto(Integer imageNum, String complete_Yn) {
		super();
		this.imageNum = imageNum;
		Complete_Yn = complete_Yn;
	}

	public Integer getImageNum() {
		return imageNum;
	}
	public void setImageNum(Integer imageNum) {
		this.imageNum = imageNum;
	}
	public String getComplete_Yn() {
		return Complete_Yn;
	}
	public void setComplete_Yn(String complete_Yn) {
		Complete_Yn = complete_Yn;
	}
	
	
}
