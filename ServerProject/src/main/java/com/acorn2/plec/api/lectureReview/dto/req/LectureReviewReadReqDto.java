package com.acorn2.plec.api.lectureReview.dto.req;



import com.acorn2.plec.common.dto.PagingDto;


public class LectureReviewReadReqDto extends PagingDto{
	private int lecReNum;
    private String lecReWriter;
    private int lecReStuRefGroup;
	private int star;

	public LectureReviewReadReqDto() {}

	public LectureReviewReadReqDto(int lecReNum, String lecReWriter, int lecReStuRefGroup, int star) {
		super();
		this.lecReNum = lecReNum;
		this.lecReWriter = lecReWriter;
		this.lecReStuRefGroup = lecReStuRefGroup;
		this.star = star;
	}

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

	

	

	
	
	
}
