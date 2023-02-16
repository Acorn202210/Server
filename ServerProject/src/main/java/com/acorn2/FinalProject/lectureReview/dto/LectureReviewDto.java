package com.acorn2.FinalProject.lectureReview.dto;

import org.apache.ibatis.type.Alias;

import com.acorn2.FinalProject.common.dto.PagingDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Alias("lectureReviewDto")
public class LectureReviewDto extends PagingDto{ 
    private int lec_re_num;
    private String lec_re_writer;
    private int lec_re_stu_ref_group;
    private String delete_Yn;
    private int star;
    private String user_regdate;
    private String profile;
    private String content;
    private String update_date;
    private String Update_id;
    
    public LectureReviewDto() {}

	public LectureReviewDto(int lec_re_num, String lec_re_writer, int lec_re_stu_ref_group, String delete_Yn, int star,
			String user_regdate, String profile, String content, String update_date, String update_id) {
		super();
		this.lec_re_num = lec_re_num;
		this.lec_re_writer = lec_re_writer;
		this.lec_re_stu_ref_group = lec_re_stu_ref_group;
		this.delete_Yn = delete_Yn;
		this.star = star;
		this.user_regdate = user_regdate;
		this.profile = profile;
		this.content = content;
		this.update_date = update_date;
		Update_id = update_id;
	}

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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
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

	public String getUpdate_id() {
		return Update_id;
	}

	public void setUpdate_id(String update_id) {
		Update_id = update_id;
	}
    
}
