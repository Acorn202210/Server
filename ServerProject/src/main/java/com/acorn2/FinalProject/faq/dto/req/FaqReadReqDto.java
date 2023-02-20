package com.acorn2.FinalProject.faq.dto.req;

import org.apache.ibatis.type.Alias;

import com.acorn2.FinalProject.common.dto.PagingDto;

@Alias("faqReq")
public class FaqReadReqDto extends PagingDto{
	private int faqNum;
	private String question;
	private String content;
	
	public FaqReadReqDto() {}

	public FaqReadReqDto(int faqNum, String question, String content) {
		super();
		this.faqNum = faqNum;
		this.question = question;
		this.content = content;
	}

	public int getFaqNum() {
		return faqNum;
	}

	public void setFaqNum(int faqNum) {
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
	
}
