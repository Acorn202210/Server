package com.acorn2.plec.api.qnafreeanswer.dto;

import org.apache.ibatis.type.Alias;

@Alias("qnaFreeAnswerDto")
public class QnaFreeAnswerDto {
	private int freeCommentNum;
	private String freeCommentWriter;
	private String content;
	private String targetId;
	private int freeCommentRefGroup;
	private int commentGroup;
	private String userRegdate;
	private String updateDate;
	private String updateId;
	private String deleteYnCode;

	public QnaFreeAnswerDto() {
	}

	public QnaFreeAnswerDto(int freeCommentNum, String freeCommentWriter, String content, String targetId,
			int freeCommentRefGroup, int commentGroup, String userRegdate, String updateDate, String updateId,
			String deleteYnCode) {
		super();
		this.freeCommentNum = freeCommentNum;
		this.freeCommentWriter = freeCommentWriter;
		this.content = content;
		this.targetId = targetId;
		this.freeCommentRefGroup = freeCommentRefGroup;
		this.commentGroup = commentGroup;
		this.userRegdate = userRegdate;
		this.updateDate = updateDate;
		this.updateId = updateId;
		this.deleteYnCode = deleteYnCode;
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

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public int getFreeCommentRefGroup() {
		return freeCommentRefGroup;
	}

	public void setFreeCommentRefGroup(int freeCommentRefGroup) {
		this.freeCommentRefGroup = freeCommentRefGroup;
	}

	public int getCommentGroup() {
		return commentGroup;
	}

	public void setCommentGroup(int commentGroup) {
		this.commentGroup = commentGroup;
	}

	public String getUserRegdate() {
		return userRegdate;
	}

	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getDeleteYnCode() {
		return deleteYnCode;
	}

	public void setDeleteYnCode(String deleteYnCode) {
		this.deleteYnCode = deleteYnCode;
	}

}
