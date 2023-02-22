package com.acorn2.FinalProject.qnaboard.dto.res;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;

@Alias("qnaBoardRes")
@Schema(description = "1:1문의 정보")
public class QnaBoardReadResDto {
	
	@Schema(description = "1:1문의 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int boardQuestionNum;
	@Schema(description = "1:1문의 작성자", example = "admin", required = true, minLength = 1, maxLength = 50)
	private String boardQuestionWriter;
	@Schema(description = "1:1문의 제목", example = "제목", required = true, minLength = 1, maxLength = 50)
	private String title;
	@Schema(description = "1:1문의 조회수", example = "0", required = true, minLength = 1, maxLength = 10000)
	private int viewCount;
	@Schema(description = "1:1문의 작성일", example = "2023-02-21", required = true, minLength = 1, maxLength = 30)
	private String userRegdate;
	@Schema(description = "1:1문의 답변여부", example = "N", required = true, minLength = 1, maxLength = 50)
	private String answeredYn;	
	
	public QnaBoardReadResDto() {}

	public QnaBoardReadResDto(int boardQuestionNum, String boardQuestionWriter, String title, int viewCount,
			String userRegdate, String answeredYn) {
		super();
		this.boardQuestionNum = boardQuestionNum;
		this.boardQuestionWriter = boardQuestionWriter;
		this.title = title;
		this.viewCount = viewCount;
		this.userRegdate = userRegdate;
		this.answeredYn = answeredYn;
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

	@Override
	 public String toString() {
		 return "QnaBoardReadResDto{" +
	                "board_question_writer=" + boardQuestionWriter +
	                ", title='" + title + '\'' +	                
	                '}';
		 
	 }
}
