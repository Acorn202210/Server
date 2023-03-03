package com.acorn2.plec.lectureReview.dto.req;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "강의 후기 수정")
public class LectureReviewUpdateReqDto {
	private int lecReNum;
	@Schema(description = "강의 후기 내용", example = "good", required = true, minLength = 1, maxLength = 10000)
	@Size(min = 1, max = 10000)
	private String content;
	@Schema(description = "강의 후기 별점", example = "5", required = true, minLength = 1, maxLength = 5)
	@Size(min = 1, max = 5)
	private int star;
	
	public int getLecReNum() {
		return lecReNum;
	}
	public void setLecReNum(int lecReNum) {
		this.lecReNum = lecReNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
	

	
	
	
}
