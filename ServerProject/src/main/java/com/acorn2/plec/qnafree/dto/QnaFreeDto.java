package com.acorn2.plec.qnafree.dto;

import org.apache.ibatis.type.Alias;

import com.acorn2.plec.common.dto.PagingDto;

@Alias("QnaFreeDto")
public class QnaFreeDto extends PagingDto {	
		private int freeQuestionNum;
		private String freeQuestionWriter;
		private String title;		
		private int viewCount;
		private String userRegdate;
		private String answeredYn;
		private String content;
		private String updateDate;
		private String deleteYnCode;		
		
		public QnaFreeDto() {}

		public QnaFreeDto(int freeQuestionNum, String freeQuestionWriter, String title, int viewCount,
				String userRegdate, String answeredYn, String content, String updateDate, String deleteYnCode) {
			super();
			this.freeQuestionNum = freeQuestionNum;
			this.freeQuestionWriter = freeQuestionWriter;
			this.title = title;
			this.viewCount = viewCount;
			this.userRegdate = userRegdate;
			this.answeredYn = answeredYn;
			this.content = content;
			this.updateDate = updateDate;
			this.deleteYnCode = deleteYnCode;
		}

		public int getFreeQuestionNum() {
			return freeQuestionNum;
		}

		public void setFreeQuestionNum(int freeQuestionNum) {
			this.freeQuestionNum = freeQuestionNum;
		}

		public String getFreeQuestionWriter() {
			return freeQuestionWriter;
		}

		public void setFreeQuestionWriter(String freeQuestionWriter) {
			this.freeQuestionWriter = freeQuestionWriter;
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
