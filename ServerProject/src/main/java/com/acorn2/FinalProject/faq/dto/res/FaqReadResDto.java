package com.acorn2.FinalProject.faq.dto.res;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;

@Alias("faqRes")
@Schema(description = "자주묻는질문 정보")
public class FaqReadResDto {
	@Schema(description = "자주묻는질문 조건", example = "질문", required = true, minLength = 1, maxLength = 50)
	private String question;
	@Schema(description = "자주묻는질문 조건 내용", example = "자주묻는질문", required = true, minLength = 1, maxLength = 10000)
	private String content;
	
	public FaqReadResDto(){}

	public FaqReadResDto(String question, String content) {
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
