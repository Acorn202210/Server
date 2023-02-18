package com.acorn2.FinalProject.faq.dto.req;

import org.apache.ibatis.type.Alias;

import com.acorn2.FinalProject.common.dto.PagingDto;

@Alias("faqReq")
public class FaqReadReqDto extends PagingDto{
	private int faq_num;
	private String question;
	private String content;
	
	public FaqReadReqDto() {}

	public FaqReadReqDto(int faq_num, String question, String content) {
		super();
		this.faq_num = faq_num;
		this.question = question;
		this.content = content;
	}

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
