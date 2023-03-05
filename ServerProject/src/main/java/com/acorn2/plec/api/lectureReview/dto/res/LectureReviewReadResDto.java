package com.acorn2.plec.api.lectureReview.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "강의 후기 정보")
public class LectureReviewReadResDto {
	@Schema(description = "강의 후기 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int lecReNum;
	@Schema(description = "강의 후기 작성자", example = "admin", required = true, minLength = 1, maxLength = 10)
    private String lecReWriter;
	@Schema(description = "강의 번호", example = "1", required = true, minLength = 1, maxLength = 50)
    private int lecReStuRefGroup;
	@Schema(description = "강의 후기 삭제 여부", example = "N", required = true, minLength = 1, maxLength = 3)
    private String deleteYn;
	@Schema(description = "강의 후기 별점", example = "1", required = true, minLength = 1, maxLength = 3)
    private int star;
	@Schema(description = "강의 후기 등록일", example = "2022-01-01", required = true, minLength = 1, maxLength = 30)
    private String userRegdate;
	@Schema(description = "강의 후기 내용", example = "강의 후기", required = true, minLength = 1, maxLength = 10000)
    private String content;
	@Schema(description = "강의 후기 등록일", example = "2022-01-02", required = true, minLength = 1, maxLength = 30)
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
