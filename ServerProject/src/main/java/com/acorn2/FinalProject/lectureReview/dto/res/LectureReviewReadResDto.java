package com.acorn2.FinalProject.lectureReview.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "후기 정보")
public class LectureReviewReadResDto {
	private int lecReNum;
    private String lecReWriter;
    private int lecReStuRefGroup;
    private String deleteYn;
    private int star;
    private String userRegdate;
    private String content;
    private String updateDate;
    
	public int getLecReNum() {
		return lecReNum;
	}
	public void setLecReNum(int lecReNum) {
		this.lecReNum = lecReNum;
	}
	public String getLecReWriter() {
		return lecReWriter;
	}
	public void setLecReWriter(String lecReWriter) {
		this.lecReWriter = lecReWriter;
	}
	public int getLecReStuRefGroup() {
		return lecReStuRefGroup;
	}
	public void setLecReStuRefGroup(int lecReStuRefGroup) {
		this.lecReStuRefGroup = lecReStuRefGroup;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
    
	 @Override
	 public String toString() {
		 return "LectureReviewReadResDto{" +
	                "lecReWriter=" + lecReWriter +
	                ", content='" + content + '\'' +
	                ", star='" + star + '\'' +
	                '}';
		 
	 }
	
	
	
	
	
	
}
