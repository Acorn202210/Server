package com.acorn2.FinalProject.lectureReview.dto.req;

public class LectureReviewCreateReqDto {
	private int lecReNum;
    private String lecReWriter;
    private int lecReStuRefGroup;
    private int star;
    private String content;
    
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
