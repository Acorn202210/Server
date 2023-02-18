package com.acorn2.FinalProject.notice.dto.req;

import com.acorn2.FinalProject.common.dto.PagingDto;

public class NoticeReadReqDto extends PagingDto {
	private int noti_num;
	private String keyword;
	private String condition;
	private String title;
	private String content;
	
	public NoticeReadReqDto() {}

	public NoticeReadReqDto(int noti_num, String keyword, String condition, String title, String content) {
		super();
		this.noti_num = noti_num;
		this.keyword = keyword;
		this.condition = condition;
		this.title = title;
		this.content = content;
	}

	public int getNoti_num() {
		return noti_num;
	}

	public void setNoti_num(int noti_num) {
		this.noti_num = noti_num;
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
