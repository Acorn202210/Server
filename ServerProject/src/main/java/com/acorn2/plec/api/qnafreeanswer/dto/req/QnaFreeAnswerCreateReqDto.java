package com.acorn2.plec.api.qnafreeanswer.dto.req;

public class QnaFreeAnswerCreateReqDto {
	private Integer freeCommentRefGroup;
	private String targetId;
	private String content;
	private Integer commentGroup;

	public Integer getFreeCommentRefGroup() {
		return freeCommentRefGroup;
	}

	public void setFreeCommentRefGroup(Integer freeCommentRefGroup) {
		this.freeCommentRefGroup = freeCommentRefGroup;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCommentGroup() {
		return commentGroup;
	}

	public void setCommentGroup(Integer commentGroup) {
		this.commentGroup = commentGroup;
	}
	
}
