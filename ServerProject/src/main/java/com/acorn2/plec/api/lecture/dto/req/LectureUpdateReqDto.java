package com.acorn2.plec.api.lecture.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;

public class LectureUpdateReqDto {
	@Schema(description = "강의 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int lecNum;
	@Schema(description = "강의 선생님", example = "seodongmin", required = true, minLength = 1, maxLength = 50)
	private String teacher;
	@Schema(description = "강의 제목", example = "자바 강의", required = true, minLength = 1, maxLength = 50)
	private String title;
	@Schema(description = "강의 설명", example = "강의 설명", required = true, minLength = 1, maxLength = 10000)
	private String describe;
	@Schema(description = "강의 링크", example = "naver.com", required = true, minLength = 1, maxLength = 500)
	private String videoPath;
	@Schema(description = "강의 대분류", example = "front", required = true, minLength = 1, maxLength = 10)
	private String largeCategory;
	@Schema(description = "강의 소분류", example = "js", required = true, minLength = 1, maxLength = 10)
	private String smallCategory;
	
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
