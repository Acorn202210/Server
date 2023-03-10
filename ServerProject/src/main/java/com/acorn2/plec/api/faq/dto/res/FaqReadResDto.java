package com.acorn2.plec.api.faq.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "자주묻는질문 정보")
public class FaqReadResDto {
	@Schema(description = "자주묻는질문 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int faqNum;
	@Schema(description = "자주묻는질문의 질문", example = "질문", required = true, minLength = 1, maxLength = 50)
	private String question;
	@Schema(description = "자주묻는질문 답변", example = "답변", required = true, minLength = 1, maxLength = 10000)
	private String content;
	
	public FaqReadResDto(){}

	public FaqReadResDto(int faqNum, String question, String content) {
		super();
		this.faqNum = faqNum;
		this.question = question;
		this.content = content;
	}
	
	public int getFaqNum() {
		return faqNum;
	}

	public void setFaq_num(int faqNum) {
		this.faqNum = faqNum;
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
	
	@Override
	 public String toString() {
		 return "FaqReadResDto{" +
	                "faqNum=" + faqNum +
	                ", question='" + question + '\'' +
	                ", content='" + content + '\'' +
	                '}';
		 
	 }
	
}
