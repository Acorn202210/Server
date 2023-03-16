package com.acorn2.plec.api.qnafreeanswer.dto.req;

import com.acorn2.plec.common.dto.PagingDto;

public class QnaFreeAnswerReadReqDto extends PagingDto {
	private int freeCommentNum;
	private String freeCommentWriter;
	private String content;
	private int freeCommentRefGroup;

	public QnaFreeAnswerReadReqDto() {
	}

	public QnaFreeAnswerReadReqDto(int freeCommentNum, String freeCommentWriter, String content,
			int freeCommentRefGroup) {
		super();
		this.freeCommentNum = freeCommentNum;
		this.freeCommentWriter = freeCommentWriter;
		this.content = content;
		this.freeCommentRefGroup = freeCommentRefGroup;
	}

	public int getFreeCommentNum() {
		return freeCommentNum;
	}

	public void setFreeCommentNum(int freeCommentNum) {
		this.freeCommentNum = freeCommentNum;
	}

	public String getFreeCommentWriter() {
		return freeCommentWriter;
	}

	public void setFreeCommentWriter(String freeCommentWriter) {
		this.freeCommentWriter = freeCommentWriter;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFreeCommentRefGroup() {
		return freeCommentRefGroup;
	}

	public void setFreeCommentRefGroup(int freeCommentRefGroup) {
		this.freeCommentRefGroup = freeCommentRefGroup;
	}

}
