package com.acorn2.FinalProject.lecture.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("lectureDto")
public class LectureDto {
	private int lec_Num;
	private String teacher;
	private String lec_Writer;
	private String title;
	private String describe;
	private String videoPath;
	private String imagePath;
	private String users_regdate;
	private String update_Date;
	private int viewCount;
	private String large_category;
	private String small_category;
	private String update_Id;
	private String service_Yn_Code;
	private MultipartFile image;	
	
	public LectureDto() {}

	public LectureDto(int lec_Num_, String teacher, String lec_Writer, String title, String describe, String videoPath,
			String imagePath, String users_regdate, String update_Date, int viewCount, String large_category,
			String small_category, String update_Id, String service_Yn_Code, MultipartFile image) {
		super();
		this.lec_Num = lec_Num_;
		this.teacher = teacher;
		this.lec_Writer = lec_Writer;
		this.title = title;
		this.describe = describe;
		this.videoPath = videoPath;
		this.imagePath = imagePath;
		this.users_regdate = users_regdate;
		this.update_Date = update_Date;
		this.viewCount = viewCount;
		this.large_category = large_category;
		this.small_category = small_category;
		this.update_Id = update_Id;
		this.service_Yn_Code = service_Yn_Code;
		this.image = image;
	}

	public int getLec_Num_() {
		return lec_Num;
	}

	public void setLec_Num_(int lec_Num_) {
		this.lec_Num = lec_Num_;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getLec_Writer() {
		return lec_Writer;
	}

	public void setLec_Writer(String lec_Writer) {
		this.lec_Writer = lec_Writer;
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

	public String getUsers_regdate() {
		return users_regdate;
	}

	public void setUsers_regdate(String users_regdate) {
		this.users_regdate = users_regdate;
	}

	public String getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(String update_Date) {
		this.update_Date = update_Date;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getLarge_category() {
		return large_category;
	}

	public void setLarge_category(String large_category) {
		this.large_category = large_category;
	}

	public String getSmall_category() {
		return small_category;
	}

	public void setSmall_category(String small_category) {
		this.small_category = small_category;
	}

	public String getUpdate_Id() {
		return update_Id;
	}

	public void setUpdate_Id(String update_Id) {
		this.update_Id = update_Id;
	}

	public String getService_Yn_Code() {
		return service_Yn_Code;
	}

	public void setService_Yn_Code(String service_Yn_Code) {
		this.service_Yn_Code = service_Yn_Code;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	

	

	
	
}
