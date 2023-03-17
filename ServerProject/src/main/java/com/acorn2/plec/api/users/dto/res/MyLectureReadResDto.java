package com.acorn2.plec.api.users.dto.res;

public class MyLectureReadResDto {
	private Integer imageNum;
	private String completeYn;
	private Integer lecNum;
	
	public MyLectureReadResDto() {}
		
	public MyLectureReadResDto(Integer imageNum, String completeYn, Integer lecNum) {
		super();
		this.imageNum = imageNum;
		this.completeYn = completeYn;
		this.lecNum = lecNum;
	}

	public Integer getImageNum() {
		return imageNum;
	}
	public void setImageNum(Integer imageNum) {
		this.imageNum = imageNum;
	}

	public String getCompleteYn() {
		return completeYn;
	}

	public void setCompleteYn(String completeYn) {
		this.completeYn = completeYn;
	}

	public Integer getLecNum() {
		return lecNum;
	}

	public void setLecNum(Integer lecNum) {
		this.lecNum = lecNum;
	}
	
	
	
}
