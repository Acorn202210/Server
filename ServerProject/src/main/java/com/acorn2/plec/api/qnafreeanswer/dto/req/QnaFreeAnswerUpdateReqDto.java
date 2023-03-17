package com.acorn2.plec.api.qnafreeanswer.dto.req;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "자유게시판 댓글 수정")
public class QnaFreeAnswerUpdateReqDto {
	private Integer freeCommentNum;
	@Schema(description = "자유게시판 댓글 내용", example = "good", required = true, minLength = 1, maxLength = 10000)
	@Size(min = 1, max = 10000)
	private String content;

	public Integer getFreeCommentNum() {
		return freeCommentNum;
	}

	public void setFreeCommentNum(Integer freeCommentNum) {
		this.freeCommentNum = freeCommentNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
