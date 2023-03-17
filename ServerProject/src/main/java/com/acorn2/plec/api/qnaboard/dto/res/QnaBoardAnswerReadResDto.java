package com.acorn2.plec.api.qnaboard.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "1:1문의 댓글 정보")
public class QnaBoardAnswerReadResDto {
	@Schema(description = "1:1문의 댓글 번호", example = "1", required = true, minLength = 1, maxLength = 100)
	private int boardCommentNum;
	@Schema(description = "1:1문의 댓글 작성자", example = "admin", required = true, minLength = 1, maxLength = 10)
	private String boardCommentWriter;
	@Schema(description = "1:1문의 댓글 내용", example = "답변입니다.", required = true, minLength = 1, maxLength = 10000)
	private String content;
	@Schema(description = "1:1문의글 번호", example = "1", required = true, minLength = 1, maxLength = 100)
	private int boardCommentRefGroup;
	@Schema(description = "1:1문의 답변 등록일", example = "2022-01-01", required = true, minLength = 1, maxLength = 30)
	private String userRegdate;
	@Schema(description = "1:1문의 답변 수정일", example = "2022-01-01", required = true, minLength = 1, maxLength = 30)
	private String updateDate;
	@Schema(description = "1:1문의 댓글 수정자", example = "admin2", required = true, minLength = 1, maxLength = 10)
	private String updateId;
		
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

	@Override
	public String toString() {		
		return "QnaBoardAnswerReadResDto{" + 
				"boardCommentWriter=" + boardCommentWriter +
				", content='"+ content + '\'' + 
				'}';
	}
}
