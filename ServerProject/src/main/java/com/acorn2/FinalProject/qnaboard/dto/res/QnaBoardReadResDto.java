package com.acorn2.FinalProject.qnaboard.dto.res;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;

@Alias("qnaBoardRes")
@Schema(description = "1:1문의 정보")
public class QnaBoardReadResDto {

	@Schema(description = "1:1문의 조건", example = "작성자", required = true, minLength = 1, maxLength = 50)
	private String writer;
	@Schema(description = "1:1문의 조건", example = "제목", required = true, minLength = 1, maxLength = 50)
	private String title;
	@Schema(description = "1:1문의 조건", example = "내용", required = true, minLength = 1, maxLength = 10000)
	private String content;
	
	public QnaBoardReadResDto() {}

	public QnaBoardReadResDto(String writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
