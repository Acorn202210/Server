package com.acorn2.plec.api.qnaboard.dto.req;

public class QnaBoardAnswerCreateReqDto {
	
	private int boardCommentRefGroup;	
	private String content;
	
	public int getBoardCommentRefGroup() {
		return boardCommentRefGroup;
	}
	public void setBoardCommentRefGroup(int boardCommentRefGroup) {
		this.boardCommentRefGroup = boardCommentRefGroup;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
}
