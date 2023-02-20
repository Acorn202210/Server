package com.acorn2.FinalProject.qnaboard.dto.req;

public class QnaBoardUpdateReqDto {
	private int board_question_num;
	private String title;	
	private String content;
	
	public int getBoard_question_num() {
		return board_question_num;
	}
	public void setBoard_question_num(int board_question_num) {
		this.board_question_num = board_question_num;
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
