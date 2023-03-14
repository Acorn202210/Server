package com.acorn2.plec.api.faq.dto.req;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "자주묻는질문 등록")
public class FaqCreateReqDto {
	@Schema(description = "자주묻는질문의 질문", example = "질문", required = true, minLength = 1, maxLength = 50)
	@NotEmpty
	@Size(min = 1, max = 50)
	private String question;
	@NotEmpty
	@Size(min = 1, max = 10000)
	@Schema(description = "자주묻는질문 답변", example = "답변", required = true, minLength = 1, maxLength = 10000)
	private String content;

	public FaqCreateReqDto(@NotEmpty @Size(min = 1, max = 50) String question,
			@NotEmpty @Size(min = 1, max = 10000) String content) {
		super();
		this.question = question;
		this.content = content;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
