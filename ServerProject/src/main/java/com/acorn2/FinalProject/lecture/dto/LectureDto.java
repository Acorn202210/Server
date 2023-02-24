package com.acorn2.FinalProject.lecture.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("lectureDto")
public class LectureDto {
	private String teacher;
	private String lecWriter;
	private String title;
	private String describe;
	private String videoPath;
	private String usersRegdate;
	private String updateDate;
	private int viewCount;
	private String largeCategory;
	private String smallCategory;
	private String updateId;
	private String serviceYnCode;
	
	public LectureDto() {}

	public LectureDto( String teacher, String lecWriter, String title, String describe, String videoPath,
			String usersRegdate, String updateDate, int viewCount, String largeCategory, String smallCategory,
			String updateId, String serviceYnCode) {
		super();
		this.teacher = teacher;
		this.lecWriter = lecWriter;
		this.title = title;
		this.describe = describe;
		this.videoPath = videoPath;
		this.usersRegdate = usersRegdate;
		this.updateDate = updateDate;
		this.viewCount = viewCount;
		this.largeCategory = largeCategory;
		this.smallCategory = smallCategory;
		this.updateId = updateId;
		this.serviceYnCode = serviceYnCode;
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

	public String getUsersRegdate() {
		return usersRegdate;
	}

	public void setUsersRegdate(String usersRegdate) {
		this.usersRegdate = usersRegdate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
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
