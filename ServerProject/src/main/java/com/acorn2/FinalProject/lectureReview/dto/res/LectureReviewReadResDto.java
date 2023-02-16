package com.acorn2.FinalProject.lectureReview.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "리뷰 정보")
public class LectureReviewReadResDto {
	private int lec_re_num;
    private String lec_re_writer;
    private int lec_re_stu_ref_group;
    private String delete_Yn;
    private int star;
    private String user_regdate;
    private String content;
    private String update_date;
	public int getlec_re_num() {
		return lec_re_num;
	}
	public void setlec_re_num(int lec_re_num) {
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
	public String getDelete_Yn() {
		return delete_Yn;
	}
	public void setDelete_Yn(String delete_Yn) {
		this.delete_Yn = delete_Yn;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(String user_regdate) {
		this.user_regdate = user_regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
    
	

	
	
	
	
	
	
}
