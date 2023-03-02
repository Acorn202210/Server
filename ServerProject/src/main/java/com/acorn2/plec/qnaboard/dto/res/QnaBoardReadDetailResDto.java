package com.acorn2.plec.qnaboard.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

public class QnaBoardReadDetailResDto {

	@Schema(description = "1:1문의 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int boardQuestionNum;
	@Schema(description = "1:1문의 제목", example = "제목", required = true, minLength = 1, maxLength = 50)
	private String title;
	@Schema(description = "1:1문의 내용", example = "내용", required = true, minLength = 1, maxLength = 10000)
	private String content;
	@Schema(description = "1:1문의 조회수", example = "0", required = true, minLength = 1, maxLength = 10000)
	private Integer viewCount;
	@Schema(description = "1:1문의 등록일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String userRegdate;
	@Schema(description = "1:1문의 등록자", example = "writer", required = true, minLength = 1, maxLength = 50)
	private String boardQuestionWriter;
	@Schema(description = "1:1문의 수정일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String updateDate;	
	@Schema(description = "1:1문의 삭제여부", example = "N", required = true, minLength = 1, maxLength = 3)
	private String deleteYnCode;
	@Schema(description = "다음 1:1문의", example = "1", required = true, minLength = 1, maxLength = 3)
	private int nextNum;
	@Schema(description = "이전 1:1문의", example = "3", required = true, minLength = 1, maxLength = 3)
	private int prevNum;
	
	public QnaBoardReadDetailResDto() {}

	public QnaBoardReadDetailResDto(int boardQuestionNum, String title, String content, Integer viewCount,
			String userRegdate, String boardQuestionWriter, String updateDate, String deleteYnCode, int nextNum,
			int prevNum) {
		super();
		this.boardQuestionNum = boardQuestionNum;
		this.title = title;
		this.content = content;
		this.viewCount = viewCount;
		this.userRegdate = userRegdate;
		this.boardQuestionWriter = boardQuestionWriter;
		this.updateDate = updateDate;
		this.deleteYnCode = deleteYnCode;
		this.nextNum = nextNum;
		this.prevNum = prevNum;
	}

	public int getBoardQuestionNum() {
		return boardQuestionNum;
	}

	public void setBoardQuestionNum(int boardQuestionNum) {
		this.boardQuestionNum = boardQuestionNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public String getUserRegdate() {
		return userRegdate;
	}

	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}

	public String getBoardQuestionWriter() {
		return boardQuestionWriter;
	}

	public void setBoardQuestionWriter(String boardQuestionWriter) {
		this.boardQuestionWriter = boardQuestionWriter;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getDeleteYnCode() {
		return deleteYnCode;
	}

	public void setDeleteYnCode(String deleteYnCode) {
		this.deleteYnCode = deleteYnCode;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}	
	
}
