package com.acorn2.plec.api.users.dto.res;

public class MyLectureReadResDto {
	private Integer imageNum;
	private String CompleteYn;
	
	public MyLectureReadResDto() {}
		
	public MyLectureReadResDto(Integer imageNum, String completeYn) {
		super();
		this.imageNum = imageNum;
		CompleteYn = completeYn;
	}

	public Integer getImageNum() {
		return imageNum;
	}
	public void setImageNum(Integer imageNum) {
		this.imageNum = imageNum;
	}
	public String getCompleteYn() {
		return CompleteYn;
	}
	public void setComplete_Yn(String completeYn) {
		CompleteYn = completeYn;
	}
	
	
}
