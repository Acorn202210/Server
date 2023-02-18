package com.acorn2.FinalProject.faq.dto.res;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;

@Alias("faqRes")
@Schema(description = "자주묻는질문 정보")
public class FaqReadResDto {
	private int faq_num;
	@Schema(description = "자주묻는질문 조건", example = "질문", required = true, minLength = 1, maxLength = 50)
	private String question;
	@Schema(description = "자주묻는질문 조건 내용", example = "자주묻는질문", required = true, minLength = 1, maxLength = 10000)
	private String content;
	
	public FaqReadResDto(){}

	public int getFaq_num() {
		return faq_num;
	}

	public void setFaq_num(int faq_num) {
		this.faq_num = faq_num;
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
