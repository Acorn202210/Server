package com.acorn2.FinalProject.faq.dto;

import org.apache.ibatis.type.Alias;


@Alias("faqDto")
public class FaqDto{
	private int faq_num;
	private String question;
	private String content;
	private String user_regdate;
	private String update_date;
	private String update_id;
	private String faq_writer;
	private String delete_yn_code;
	private int startRowNum;
	private int endRowNum;
	private int prevNum;
	private int nextNum;	
	
	public FaqDto() {}

	public FaqDto(int faq_num, String question, String content, String user_regdate, String update_date,
			String update_id, String faq_writer, String delete_yn_code, int startRowNum, int endRowNum, int prevNum,
			int nextNum) {
		super();
		this.faq_num = faq_num;
		this.question = question;
		this.content = content;
		this.user_regdate = user_regdate;
		this.update_date = update_date;
		this.update_id = update_id;
		this.faq_writer = faq_writer;
		this.delete_yn_code = delete_yn_code;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
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

	public String getUser_regdate() {
		return user_regdate;
	}

	public void setUser_regdate(String user_regdate) {
		this.user_regdate = user_regdate;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getUpdate_id() {
		return update_id;
	}

	public void setUpdate_id(String update_id) {
		this.update_id = update_id;
	}

	public String getFaq_writer() {
		return faq_writer;
	}

	public void setFaq_writer(String faq_writer) {
		this.faq_writer = faq_writer;
	}

	public String getDelete_yn_code() {
		return delete_yn_code;
	}

	public void setDelete_yn_code(String delete_yn_code) {
		this.delete_yn_code = delete_yn_code;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

}
