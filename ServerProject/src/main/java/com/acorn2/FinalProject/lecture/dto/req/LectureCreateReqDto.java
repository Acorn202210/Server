package com.acorn2.FinalProject.lecture.dto.req;

import org.springframework.web.multipart.MultipartFile;

public class LectureCreateReqDto {
	private int lecNum;
	private String teacher;
	private String lecWriter;
	private String title;
	private String describe;
	private String videoPath;
	private String imagePath;
	private String largeCategory;
	private String smallCategory;
	private MultipartFile image;
	
	public LectureCreateReqDto(int lecNum, String teacher, String lecWriter, String title, String describe,
			String videoPath, String imagePath, String largeCategory, String smallCategory,
			MultipartFile image) {
		super();
		this.lecNum = lecNum;
		this.teacher = teacher;
		this.lecWriter = lecWriter;
		this.title = title;
		this.describe = describe;
		this.videoPath = videoPath;
		this.imagePath = imagePath;
		this.largeCategory = largeCategory;
		this.smallCategory = smallCategory;
		this.image = image;
	}
	
	public LectureCreateReqDto() {
        this.imagePath = "";
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

	public String getLecWriter() {
		return lecWriter;
	}

	public void setLecWriter(String lecWriter) {
		this.lecWriter = lecWriter;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	
	
	
	
}
