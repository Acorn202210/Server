package com.acorn2.FinalProject.lectureReview.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "리뷰 정보")
public class LectureReviewReadResDto {
	@Schema(description = "num", example = "1", required = true, minLength = 1, maxLength = 100)
	private int num;
	
	@Schema(description = "writer", example = "sdm", required = true, minLength = 1, maxLength = 50)
	private String writer;
	
	@Schema(description = "content", example = "어쩌구", required = true, minLength = 1, maxLength = 500)
	private String content;
	
	@Schema(description = "target_id", example = "seo", required = true, minLength = 1, maxLength = 50)
	private String target_id;
	
	@Schema(description = "ref_group", example = "1", required = true, minLength = 1, maxLength = 100)
	private int ref_group;
	
	@Schema(description = "comment_group", example = "1", required = true, minLength = 1, maxLength = 100)
	private int comment_group;
	
	@Schema(description = "deleted", example = "NO", required = true, minLength = 1, maxLength = 3)
	private String deleted;
	
	@Schema(description = "regdate", example = "2022-10-12", required = true, minLength = 1, maxLength = 50)
	private String regdate;
	
	@Schema(description = "prfile", example = "이미지 등록", required = true, minLength = 1, maxLength = 100)
	private String profile;
	
	@Schema(description = "star", example = "1", required = true, minLength = 1, maxLength = 1)
	private int star;

	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}

	public int getRef_group() {
		return ref_group;
	}

	public void setRef_group(int ref_group) {
		this.ref_group = ref_group;
	}

	public int getComment_group() {
		return comment_group;
	}

	public void setComment_group(int comment_group) {
		this.comment_group = comment_group;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
	
	
	
}
