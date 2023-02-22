package com.acorn2.FinalProject.qnaboard.dto.req;

public class QnaBoardUpdateReqDto {
	private int boardQuestionNum;
	private String title;	
	private String content;
	
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
	
}
