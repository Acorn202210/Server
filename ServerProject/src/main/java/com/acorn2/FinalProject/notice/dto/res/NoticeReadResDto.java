package com.acorn2.FinalProject.notice.dto.res;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;



@Alias("noticeRes")
@Schema(description = "공지사항 정보")
public class NoticeReadResDto {
	@Schema(description = "공지사항 조건", example = "제목", required = true, minLength = 1, maxLength = 50)
	private String title;
	@Schema(description = "공지사항 조건 내용", example = "공지사항", required = true, minLength = 1, maxLength = 10000)
	private String content;
	
	public NoticeReadResDto(){}
	
	public NoticeReadResDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
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
