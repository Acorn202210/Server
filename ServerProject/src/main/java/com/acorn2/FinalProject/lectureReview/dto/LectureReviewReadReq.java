package com.acorn2.FinalProject.lectureReview.dto;

import org.apache.ibatis.type.Alias;

import com.acorn2.FinalProject.common.dto.PagingDto;

@Alias("lectureReviewReq")
public class LectureReviewReadReq extends PagingDto{
	private int num;
	private String content;
	private int star;
	
	public LectureReviewReadReq() {}

	public LectureReviewReadReq(int num, String content, int star) {
		super();
		this.num = num;
		this.content = content;
		this.star = star;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
