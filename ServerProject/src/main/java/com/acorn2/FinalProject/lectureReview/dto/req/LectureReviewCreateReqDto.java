package com.acorn2.FinalProject.lectureReview.dto.req;

public class LectureReviewCreateReqDto {
    private int lecReStuRefGroup;
    private int star;
    private String content;
    
	public int getLecReStuRefGroup() {
		return lecReStuRefGroup;
	}
	public void setLecReStuRefGroup(int lecReStuRefGroup) {
		this.lecReStuRefGroup = lecReStuRefGroup;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
    
	
    
}
