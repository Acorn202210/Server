package com.acorn2.plec.api.qnafreeanswer.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

public class QnaFreeAnswerReadDetailResDto {
	@Schema(description = "자유게시판 댓글 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int freeCommentNum;
	@Schema(description = "자유게시판 댓글 작성자", example = "user", required = true, minLength = 1, maxLength = 50)
	private String freeCommentWriter;
	@Schema(description = "자유게시판 댓글 내용", example = "답변", required = true, minLength = 1, maxLength = 10000)
	private String content;
	@Schema(description = "자유게시판 댓글 그룹 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int freeCommentRefGroup;
	@Schema(description = "자유게시판 댓글 등록일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String userRegdate;
	@Schema(description = "자유게시판 댓글 수정일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String updateDate;
	@Schema(description = "자유게시판 댓글 수정자", example = "user2", required = true, minLength = 1, maxLength = 50)
	private String updateId;
	@Schema(description = "자유게시판 댓글 삭제여부", example = "N", required = true, minLength = 1, maxLength = 3)
	private String deleteYNCode;

	public QnaFreeAnswerReadDetailResDto() {
	}

	public QnaFreeAnswerReadDetailResDto(int freeCommentNum, String freeCommentWriter, String content,
			int freeCommentRefGroup, String userRegdate, String updateDate, String updateId, String deleteYNCode) {
		super();
		this.freeCommentNum = freeCommentNum;
		this.freeCommentWriter = freeCommentWriter;
		this.content = content;
		this.freeCommentRefGroup = freeCommentRefGroup;
		this.userRegdate = userRegdate;
		this.updateDate = updateDate;
		this.updateId = updateId;
		this.deleteYNCode = deleteYNCode;
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

	public String getDeleteYNCode() {
		return deleteYNCode;
	}

	public void setDeleteYNCode(String deleteYNCode) {
		this.deleteYNCode = deleteYNCode;
	}

}
