package com.acorn2.plec.api.qnaboard.dto.req;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "1:1문의 답변 수정")
public class QnaBoardAnswerUpdateReqDto {
	
	private int boardCommentRefGroup;
	
	@Schema(description = "1:1문의 답변 내용", example = "답변입니다.", required = true, minLength = 1, maxLength = 10000)
	@Size(min = 1, max = 10000)
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
