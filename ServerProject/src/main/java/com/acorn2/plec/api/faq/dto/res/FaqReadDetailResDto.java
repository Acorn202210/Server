package com.acorn2.plec.api.faq.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

public class FaqReadDetailResDto {
	@Schema(description = "자주묻는질문 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int faqNum;
	@Schema(description = "자주묻는질문의 질문", example = "질문", required = true, minLength = 1, maxLength = 50)
	private String question;
	@Schema(description = "자주묻는질문 답변", example = "답변", required = true, minLength = 1, maxLength = 10000)
	private String content;
	@Schema(description = "자주묻는질문 등록일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String userRegdate;
	@Schema(description = "자주묻는질문 등록자", example = "관리자", required = true, minLength = 1, maxLength = 50)
	private String faqWriter;
	@Schema(description = "자주묻는질문 수정일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String updateDate;
	@Schema(description = "자주묻는질문 수정자", example = "관리자2", required = true, minLength = 1, maxLength = 50)
	private String updateId;
	@Schema(description = "자주묻는질문 삭제여부", example = "N", required = true, minLength = 1, maxLength = 3)
	private String deleteYNCode;

	public FaqReadDetailResDto() {
	}

	public FaqReadDetailResDto(int faqNum, String question, String content, String userRegdate, String faqWriter,
			String updateDate, String updateId, String deleteYNCode) {
		super();
		this.faqNum = faqNum;
		this.question = question;
		this.content = content;
		this.userRegdate = userRegdate;
		this.faqWriter = faqWriter;
		this.updateDate = updateDate;
		this.updateId = updateId;
		this.deleteYNCode = deleteYNCode;
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

	public String getFaqWriter() {
		return faqWriter;
	}

	public void setFaqWriter(String faqWriter) {
		this.faqWriter = faqWriter;
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

	public String getDeleteYNCode() {
		return deleteYNCode;
	}

	public void setDeleteYNCode(String deleteYNCode) {
		this.deleteYNCode = deleteYNCode;
	}

}
