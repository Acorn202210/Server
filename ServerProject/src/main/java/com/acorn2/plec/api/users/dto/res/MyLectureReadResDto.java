package com.acorn2.plec.api.users.dto.res;

public class MyLectureReadResDto {
	private Integer imageNum;
	private Integer lecNum;
	
	public MyLectureReadResDto() {}
		
	public MyLectureReadResDto(Integer imageNum, Integer lecNum) {
		super();
		this.imageNum = imageNum;
		this.lecNum = lecNum;
	}

	public Integer getImageNum() {
		return imageNum;
	}
	public void setImageNum(Integer imageNum) {
		this.imageNum = imageNum;
	}

	public Integer getLecNum() {
		return lecNum;
	}

	public void setLecNum(Integer lecNum) {
		this.lecNum = lecNum;
	}
	
	
	
}
