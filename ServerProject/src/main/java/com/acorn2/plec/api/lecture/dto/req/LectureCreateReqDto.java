package com.acorn2.plec.api.lecture.dto.req;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "강의 등록")
public class LectureCreateReqDto {
	@Schema(description = "강의 제목", example = "제목", required = true, minLength = 1, maxLength = 50)
	@NotEmpty
	@Size(min = 1, max = 50)
	private String title;
	@Schema(description = "강의 선생님", example = "서동민", required = true, minLength = 1, maxLength = 10)
	@NotEmpty
	@Size(min = 1, max = 10)
	private String teacher;
	@Schema(description = "강의 설명", example = "강의 설명~", required = true, minLength = 1, maxLength = 10000)
	@NotEmpty
	@Size(min = 1, max = 10000)
	private String describe;
	@Schema(description = "강의 링크", example = "naver.com", required = true, minLength = 1, maxLength = 500)
	@NotEmpty
	@Size(min = 1, max = 500)
	private String videoPath;
	
	@Schema(description = "강의 대분류", example = "front", required = true, minLength = 1, maxLength = 10)
	@NotEmpty
	@Size(min = 1, max = 10)
	private String largeCategory;
	
	@Schema(description = "강의 소분류", example = "js", required = true, minLength = 1, maxLength = 10)
	@NotEmpty
	@Size(min = 1, max = 10)
	private String smallCategory;
	private int imageNum;
	public LectureCreateReqDto(@NotEmpty @Size(min = 1, max = 50) String title,
			@NotEmpty @Size(min = 1, max = 10) String teacher, @NotEmpty @Size(min = 1, max = 10000) String describe,
			@NotEmpty @Size(min = 1, max = 500) String videoPath,
			@NotEmpty @Size(min = 1, max = 10) String largeCategory,
			@NotEmpty @Size(min = 1, max = 10) String smallCategory, int imageNum) {
		super();
		this.title = title;
		this.teacher = teacher;
		this.describe = describe;
		this.videoPath = videoPath;
		this.largeCategory = largeCategory;
		this.smallCategory = smallCategory;
		this.imageNum = imageNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
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
	public int getImageNum() {
		return imageNum;
	}
	public void setImageNum(int imageNum) {
		this.imageNum = imageNum;
	}
	

	
	
	
	
	
	
}
