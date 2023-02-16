package com.acorn2.FinalProject.lectureReview.dto.req;

public class LectureReviewCreateReqDto {
	private int lec_re_num;
    private String lec_re_writer;
    private int lec_re_stu_ref_group;
    private int star;
    private String content;
	public int getLec_re_num() {
		return lec_re_num;
	}
	public void setLec_re_num(int lec_re_num) {
		this.lec_re_num = lec_re_num;
	}
	public String getLec_re_writer() {
		return lec_re_writer;
	}
	public void setLec_re_writer(String lec_re_writer) {
		this.lec_re_writer = lec_re_writer;
	}
	public int getLec_re_stu_ref_group() {
		return lec_re_stu_ref_group;
	}
	public void setLec_re_stu_ref_group(int lec_re_stu_ref_group) {
		this.lec_re_stu_ref_group = lec_re_stu_ref_group;
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
