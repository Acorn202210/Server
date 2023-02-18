package com.acorn2.FinalProject.faq.dto.req;

public class FaqCreateReqDto {
	private int faq_num;
	private String faq_writer;
	private String question;
	private String content;
	public int getFaq_num() {
		return faq_num;
	}
	public void setFaq_num(int faq_num) {
		this.faq_num = faq_num;
	}
	public String getFaq_writer() {
		return faq_writer;
	}
	public void setFaq_writer(String faq_writer) {
		this.faq_writer = faq_writer;
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
