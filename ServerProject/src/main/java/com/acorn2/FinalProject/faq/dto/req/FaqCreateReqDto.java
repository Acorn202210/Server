package com.acorn2.FinalProject.faq.dto.req;

public class FaqCreateReqDto {
	private int faqNum;
	private String faqWriter;
	private String question;
	private String content;
	
	public int getFaqNum() {
		return faqNum;
	}
	public void setFaqNum(int faqNum) {
		this.faqNum = faqNum;
	}
	public String getFaqWriter() {
		return faqWriter;
	}
	public void setFaqWriter(String faqWriter) {
		this.faqWriter = faqWriter;
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
