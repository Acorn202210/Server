package com.acorn2.plec.api.qnaboard.dto.req;

import com.acorn2.plec.common.dto.PagingDto;

public class QnaBoardAnswerReadReqDto extends PagingDto {

	private int boardCommentNum;
	private String boardCommentWriter;
	private int boardCommentRefGroup;
	
	public QnaBoardAnswerReadReqDto () {}

	public QnaBoardAnswerReadReqDto(int boardCommentNum, String boardCommentWriter, int boardCommentRefGroup) {
		super();
		this.boardCommentNum = boardCommentNum;
		this.boardCommentWriter = boardCommentWriter;
		this.boardCommentRefGroup = boardCommentRefGroup;
	}

	public int getBoardCommentNum() {
		return boardCommentNum;
	}

	public void setBoardCommentNum(int boardCommentNum) {
		this.boardCommentNum = boardCommentNum;
	}

	public String getBoardCommentWriter() {
		return boardCommentWriter;
	}

	public void setBoardCommentWriter(String boardCommentWriter) {
		this.boardCommentWriter = boardCommentWriter;
	}

	public int getBoardCommentRefGroup() {
		return boardCommentRefGroup;
	}

	public void setBoardCommentRefGroup(int boardCommentRefGroup) {
		this.boardCommentRefGroup = boardCommentRefGroup;
	}	
}
