package com.acorn2.FinalProject.notice.dto.req;

import com.acorn2.FinalProject.common.dto.PagingDto;

public class NoticeReadReqDto extends PagingDto {
	private int notiNum;
	private String keyword;
	private String condition;
	private String title;
	private String content;
	
	public NoticeReadReqDto() {}

	public NoticeReadReqDto(int notiNum, String keyword, String condition, String title, String content) {
		super();
		this.notiNum = notiNum;
		this.keyword = keyword;
		this.condition = condition;
		this.title = title;
		this.content = content;
	}

	public int getNotiNum() {
		return notiNum;
	}

	public void setNotiNum(int notiNum) {
		this.notiNum = notiNum;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
