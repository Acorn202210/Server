package com.acorn2.FinalProject.notice.dto.req;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "공지사항 생성")
public class NoticeCreateReqDto {
	@Schema(description = "공지사항 조건", example = "제목", required = true, minLength = 1, maxLength = 50)
	@NotEmpty
	@Size(min = 1, max = 50)
	private String title;
	@NotEmpty
	@Size(min = 1, max = 10000)
	@Schema(description = "공지사항 조건 내용", example = "공지사항", required = true, minLength = 1, maxLength = 10000)
	private String content;
	public NoticeCreateReqDto(@NotEmpty @Size(min = 1, max = 50) String title,
			@NotEmpty @Size(min = 1, max = 10000) String content) {
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
