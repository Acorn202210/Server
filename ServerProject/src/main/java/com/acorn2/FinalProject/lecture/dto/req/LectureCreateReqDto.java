package com.acorn2.FinalProject.lecture.dto.req;

import org.springframework.web.multipart.MultipartFile;

public class LectureCreateReqDto {
	private int lecNum;
	private String teacher;
	private String title;
	private String describe;
	private String videoPath;
	private String largeCategory;
	private String smallCategory;
	
	public LectureCreateReqDto(int lecNum, String teacher, String title, String describe,
			String videoPath, String largeCategory, String smallCategory) {
		super();
		this.lecNum = lecNum;
		this.teacher = teacher;
		this.title = title;
		this.describe = describe;
		this.videoPath = videoPath;
		this.largeCategory = largeCategory;
		this.smallCategory = smallCategory;
	}
	
	
	
	public int getLecNum() {
		return lecNum;
	}

	public void setLecNum(int lecNum) {
		this.lecNum = lecNum;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}


	public String getLargeCategory() {
		return largeCategory;
	}

	public void setLargeCategory(String largeCategory) {
		this.largeCategory = largeCategory;
	}

	public String getSmallCategory() {
		return smallCategory;
	}

	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
	}

	
	
	
	
}
