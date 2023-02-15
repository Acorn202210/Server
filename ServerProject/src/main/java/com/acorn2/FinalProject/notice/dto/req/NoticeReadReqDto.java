package com.acorn2.FinalProject.notice.dto.req;

import org.apache.ibatis.type.Alias;

import com.acorn2.FinalProject.common.dto.PagingDto;

@Alias("noticeReq")
public class NoticeReadReqDto extends PagingDto {
	private int num;
	private String title;
	private String content;
	
	public NoticeReadReqDto() {}
	
	public NoticeReadReqDto(int num, String title, String content) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
