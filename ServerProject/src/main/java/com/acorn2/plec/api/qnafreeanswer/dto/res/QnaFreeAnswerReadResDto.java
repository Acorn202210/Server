package com.acorn2.plec.api.qnafreeanswer.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "자유게시판 댓글 정보")
public class QnaFreeAnswerReadResDto {
	@Schema(description = "자유게시판 댓글 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int freeCommentNum;
	@Schema(description = "자유게시판 댓글 작성자", example = "admin", required = true, minLength = 1, maxLength = 10)
	private String freeCommentWriter;
	@Schema(description = "자유게시판 댓글 내용", example = "댓글", required = true, minLength = 1, maxLength = 10000)
	private String content;
	@Schema(description = "자유게시판 댓글 대상 아이디", example = "user", required = true, minLength = 1, maxLength = 50)
	private String targetId;
	@Schema(description = "자유게시판 댓글 그룹 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int freeCommentRefGroup;
	@Schema(description = "자유게시판 댓글 그룹 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int commentGroup;
	@Schema(description = "자유게시판 댓글 등록일", example = "2022-01-01", required = true, minLength = 1, maxLength = 30)
	private String userRegdate;
	@Schema(description = "자유게시판 댓글 수정일", example = "2022-01-02", required = true, minLength = 1, maxLength = 30)
	private String updateDate;
	@Schema(description = "자유게시판 댓글 수정자", example = "admin2", required = true, minLength = 1, maxLength = 50)
	private String updateId;
	@Schema(description = "자유게시판 댓글 삭제 여부", example = "N", required = true, minLength = 1, maxLength = 3)
	private String deleteYn;

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

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	@Override
	public String toString() {
		return "QnaFreeAnswerReviewReadResDto{" + "freeCommentWriter=" + freeCommentWriter + ", content='" + content
				+ '\'' + '}';

	}

}
