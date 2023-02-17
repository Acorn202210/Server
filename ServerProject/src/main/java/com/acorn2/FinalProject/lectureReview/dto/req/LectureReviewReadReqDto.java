package com.acorn2.FinalProject.lectureReview.dto.req;



import com.acorn2.FinalProject.common.dto.PagingDto;


public class LectureReviewReadReqDto extends PagingDto{
	private int lec_re_num;
	private String content;
	private int star;
	private int lec_re_stu_ref_group;
	
	public LectureReviewReadReqDto() {}

	public LectureReviewReadReqDto(int lec_re_num, String content, int star, int lec_re_stu_ref_group) {
		super();
		this.lec_re_num = lec_re_num;
		this.content = content;
		this.star = star;
		this.lec_re_stu_ref_group = lec_re_stu_ref_group;
	}

	public int getlec_re_num() {
		return lec_re_num;
	}

	public void setlec_re_num(int lec_re_num) {
		this.lec_re_num = lec_re_num;
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

	public int getLec_re_stu_ref_group() {
		return lec_re_stu_ref_group;
	}

	public void setLec_re_stu_ref_group(int lec_re_stu_ref_group) {
		this.lec_re_stu_ref_group = lec_re_stu_ref_group;
	}

	

	
	
	
}
