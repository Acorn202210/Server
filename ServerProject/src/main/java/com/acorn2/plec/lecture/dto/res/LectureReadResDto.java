package com.acorn2.plec.lecture.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

public class LectureReadResDto {
	@Schema(description = "강의 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int lecNum;
	@Schema(description = "강의 선생님", example = "seodongmin", required = true, minLength = 1, maxLength = 50)
	private String teacher;
	@Schema(description = "강의 작성자", example = "admin", required = true, minLength = 1, maxLength = 50)
	private String lecWriter;
	@Schema(description = "강의 제목", example = "자바 강의", required = true, minLength = 1, maxLength = 50)
	private String title;
	@Schema(description = "강의 설명", example = "강의 설명", required = true, minLength = 1, maxLength = 10000)
	private String describe;
	@Schema(description = "강의 링크", example = "naver.com", required = true, minLength = 1, maxLength = 500)
	private String videoPath;
	@Schema(description = "강의 조회수", example = "0", required = true, minLength = 1, maxLength = 50)
	private int viewCount;
	@Schema(description = "강의 등록일", example = "2022-01-01", required = true, minLength = 1, maxLength = 30)
	private String userRegdate;
	@Schema(description = "강의 대분류", example = "front", required = true, minLength = 1, maxLength = 10)
	private String largeCategory;
	@Schema(description = "강의 소분류", example = "js", required = true, minLength = 1, maxLength = 10)
	private String smallCategory;
	@Schema(description = "강의 수정 작성자", example = "admin", required = true, minLength = 1, maxLength = 50)
	private String updateId;
	@Schema(description = "강의 서비스 여부", example = "Y", required = true, minLength = 1, maxLength = 3)
	private String serviceYnCode;
	
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
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getuserRegdate() {
		return userRegdate;
	}
	public void setuserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
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
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getServiceYnCode() {
		return serviceYnCode;
	}
	public void setServiceYnCode(String serviceYnCode) {
		this.serviceYnCode = serviceYnCode;
	}
	
	

	
	
}
