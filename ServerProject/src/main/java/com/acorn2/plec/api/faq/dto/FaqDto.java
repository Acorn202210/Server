package com.acorn2.plec.api.faq.dto;

import org.apache.ibatis.type.Alias;


@Alias("faqDto")
public class FaqDto{
	private int faqNum;
	private String question;
	private String content;
	private String userRegdate;
	private String updateDate;
	private String updateId;
	private String faqWriter;
	private String deleteYnCode;
	private int startRowNum;
	private int endRowNum;
	private int prevNum;
	private int nextNum;	
	
	public FaqDto() {}

	public FaqDto(int faqNum, String question, String content, String userRegdate, String updateDate, String updateId,
			String faqWriter, String deleteYnCode, int startRowNum, int endRowNum, int prevNum, int nextNum) {
		super();
		this.faqNum = faqNum;
		this.question = question;
		this.content = content;
		this.userRegdate = userRegdate;
		this.updateDate = updateDate;
		this.updateId = updateId;
		this.faqWriter = faqWriter;
		this.deleteYnCode = deleteYnCode;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
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

	public String getUserRegdate() {
		return userRegdate;
	}

	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getFaqWriter() {
		return faqWriter;
	}

	public void setFaqWriter(String faqWriter) {
		this.faqWriter = faqWriter;
	}

	public String getDeleteYnCode() {
		return deleteYnCode;
	}

	public void setDeleteYnCode(String deleteYnCode) {
		this.deleteYnCode = deleteYnCode;
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
