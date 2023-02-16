package com.acorn2.FinalProject.faq.dto.req;

import org.apache.ibatis.type.Alias;

import com.acorn2.FinalProject.common.dto.PagingDto;

@Alias("faqReq")
public class FaqReadReqDto extends PagingDto{
	private int num;
	private String question;
	private String content;
	
	public FaqReadReqDto() {}

	public FaqReadReqDto(int num, String question, String content) {
		super();
		this.num = num;
		this.question = question;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
