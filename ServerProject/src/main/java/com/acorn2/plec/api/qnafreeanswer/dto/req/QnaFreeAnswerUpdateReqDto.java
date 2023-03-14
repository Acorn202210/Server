package com.acorn2.plec.api.qnafreeanswer.dto.req;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "자유게시판 댓글 수정")
public class QnaFreeAnswerUpdateReqDto {
	private int freeCommentNum;
	@Schema(description = "자유게시판 댓글 내용", example = "good", required = true, minLength = 1, maxLength = 10000)
	@Size(min = 1, max = 10000)
	private String content;

	public int getFreeCommentNum() {
		return freeCommentNum;
	}

	public void setFreeCommentNum(int freeCommentNum) {
		this.freeCommentNum = freeCommentNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
