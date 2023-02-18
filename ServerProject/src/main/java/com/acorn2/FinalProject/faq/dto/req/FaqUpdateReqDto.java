package com.acorn2.FinalProject.faq.dto.req;

public class FaqUpdateReqDto {
	private int faq_num;
	private String question;
	private String content;
	private String update_id;
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
	public String getUpdate_id() {
		return update_id;
	}
	public void setUpdate_id(String update_id) {
		this.update_id = update_id;
	}
	
}
