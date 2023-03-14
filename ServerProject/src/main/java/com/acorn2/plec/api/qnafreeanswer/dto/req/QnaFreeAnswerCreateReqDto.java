package com.acorn2.plec.api.qnafreeanswer.dto.req;

public class QnaFreeAnswerCreateReqDto {
	private int freeCommentRefGroup;
	private String content;

	public int getFreeCommentRefGroup() {
		return freeCommentRefGroup;
	}

	public void setFreeCommentRefGroup(int freeCommentRefGroup) {
		this.freeCommentRefGroup = freeCommentRefGroup;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
