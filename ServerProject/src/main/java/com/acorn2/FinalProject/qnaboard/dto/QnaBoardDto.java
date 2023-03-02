package com.acorn2.FinalProject.qnaboard.dto;

import org.apache.ibatis.type.Alias;

import com.acorn2.FinalProject.common.dto.PagingDto;

@Alias("QnaBoardDto")
public class QnaBoardDto extends PagingDto {	
		private int boardQuestionNum;
		private String boardQuestionWriter;
		private String title;		
		private int viewCount;
		private String userRegdate;
		private String answeredYn;
		private String content;
		private String updateDate;
		private String deleteYnCode;		
		
		public QnaBoardDto() {}

		public QnaBoardDto(int boardQuestionNum, String boardQuestionWriter, String title, int viewCount,
				String userRegdate, String answeredYn, String content, String updateDate, String deleteYnCode) {
			super();
			this.boardQuestionNum = boardQuestionNum;
			this.boardQuestionWriter = boardQuestionWriter;
			this.title = title;
			this.viewCount = viewCount;
			this.userRegdate = userRegdate;
			this.answeredYn = answeredYn;
			this.content = content;
			this.updateDate = updateDate;
			this.deleteYnCode = deleteYnCode;
		}

		public int getBoardQuestionNum() {
			return boardQuestionNum;
		}

		public void setBoardQuestionNum(int boardQuestionNum) {
			this.boardQuestionNum = boardQuestionNum;
		}

		public String getBoardQuestionWriter() {
			return boardQuestionWriter;
		}

		public void setBoardQuestionWriter(String boardQuestionWriter) {
			this.boardQuestionWriter = boardQuestionWriter;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getViewCount() {
			return viewCount;
		}

		public void setViewCount(int viewCount) {
			this.viewCount = viewCount;
		}

		public String getUserRegdate() {
			return userRegdate;
		}

		public void setUserRegdate(String userRegdate) {
			this.userRegdate = userRegdate;
		}

		public String getAnsweredYn() {
			return answeredYn;
		}

		public void setAnsweredYn(String answeredYn) {
			this.answeredYn = answeredYn;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(String updateDate) {
			this.updateDate = updateDate;
		}

		public String getDeleteYnCode() {
			return deleteYnCode;
		}

		public void setDeleteYnCode(String deleteYnCode) {
			this.deleteYnCode = deleteYnCode;
		}
		
}
