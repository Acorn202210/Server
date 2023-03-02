package com.acorn2.FinalProject.qnaboard.dto;

import org.apache.ibatis.type.Alias;

@Alias("qnaBoardAnswerDto")
public class QnaBoardAnswerDto {
	private int boardCommentNum;
	private String boardCommentWriter;
	private String content;	
	private int boardCommentRefGroup;	
	private String userRegdate;
	private String updateDate;
	private String updateId;
	private String deleteYnCode;
	
	public QnaBoardAnswerDto () {}

	public QnaBoardAnswerDto(int boardCommentNum, String boardCommentWriter, String content, int boardCommentRefGroup,
			String userRegdate, String updateDate, String updateId, String deleteYnCode) {
		super();
		this.boardCommentNum = boardCommentNum;
		this.boardCommentWriter = boardCommentWriter;
		this.content = content;
		this.boardCommentRefGroup = boardCommentRefGroup;
		this.userRegdate = userRegdate;
		this.updateDate = updateDate;
		this.updateId = updateId;
		this.deleteYnCode = deleteYnCode;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getBoardCommentRefGroup() {
		return boardCommentRefGroup;
	}

	public void setBoardCommentRefGroup(int boardCommentRefGroup) {
		this.boardCommentRefGroup = boardCommentRefGroup;
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
	