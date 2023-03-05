package com.acorn2.plec.api.lectureReview.dto;

import org.apache.ibatis.type.Alias;

import com.acorn2.plec.common.dto.PagingDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Alias("lectureReviewDto")
public class LectureReviewDto extends PagingDto{ 
    private int lecReNum;
    private String lecReWriter;
    private int lecReStuRefGroup;
    private String deleteYn;
    private int star;
    private String userRegdate;
    private String content;
    private String updateDate;
    private String UpdateId;
    
    public LectureReviewDto() {}

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

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getUserRegdate() {
		return userRegdate;
	}

	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateId() {
		return UpdateId;
	}

	public void setUpdateId(String updateId) {
		UpdateId = updateId;
	}

	
    
}
