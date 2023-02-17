package com.acorn2.FinalProject.qnaboard.dto;

import org.apache.ibatis.type.Alias;

import com.acorn2.FinalProject.common.dto.PagingDto;

@Alias("QnaBoardDto")
public class QnaBoardDto extends PagingDto {	
		private int board_question_num;
		private String board_question_writer;
		private String title;		
		private int viewCount;
		private String user_regdate;
		private String answered_yn;
		private String content;
		private String update_date;
		private String delete_yn_code;		
		
		public QnaBoardDto() {}

		public QnaBoardDto(int board_question_num, String board_question_writer, String title, int viewCount,
				String user_regdate, String answered_yn, String content, String update_date, String delete_yn_code) {
			super();
			this.board_question_num = board_question_num;
			this.board_question_writer = board_question_writer;
			this.title = title;
			this.viewCount = viewCount;
			this.user_regdate = user_regdate;
			this.answered_yn = answered_yn;
			this.content = content;
			this.update_date = update_date;
			this.delete_yn_code = delete_yn_code;
		}

		public int getBoard_question_num() {
			return board_question_num;
		}

		public void setBoard_question_num(int board_question_num) {
			this.board_question_num = board_question_num;
		}

		public String getBoard_question_writer() {
			return board_question_writer;
		}

		public void setBoard_question_writer(String board_question_writer) {
			this.board_question_writer = board_question_writer;
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

		public String getUser_regdate() {
			return user_regdate;
		}

		public void setUser_regdate(String user_regdate) {
			this.user_regdate = user_regdate;
		}

		public String getAnswered_yn() {
			return answered_yn;
		}

		public void setAnswered_yn(String answered_yn) {
			this.answered_yn = answered_yn;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getUpdate_date() {
			return update_date;
		}

		public void setUpdate_date(String update_date) {
			this.update_date = update_date;
		}

		public String getDelete_yn_code() {
			return delete_yn_code;
		}

		public void setDelete_yn_code(String delete_yn_code) {
			this.delete_yn_code = delete_yn_code;
		}
		
}
