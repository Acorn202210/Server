package com.acorn2.plec.api.qnafree.dto.res;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;

@Alias("qnaFreeRes")
@Schema(description = "자유게시판 정보")
public class QnaFreeReadResDto {
	
	@Schema(description = "자유게시판 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int freeQuestionNum;
	@Schema(description = "자유게시판 작성자", example = "admin", required = true, minLength = 1, maxLength = 50)
	private String freeQuestionWriter;
	@Schema(description = "자유게시판 제목", example = "제목", required = true, minLength = 1, maxLength = 50)
	private String title;
	@Schema(description = "자유게시판 조회수", example = "0", required = true, minLength = 1, maxLength = 10000)
	private int viewCount;
	@Schema(description = "자유게시판 작성일", example = "2023-03-03", required = true, minLength = 1, maxLength = 30)
	private String userRegdate;
	@Schema(description = "자유게시판 답변여부", example = "N", required = true, minLength = 1, maxLength = 50)
	private String answeredYn;	
	
	public QnaFreeReadResDto() {}

	public QnaFreeReadResDto(int freeQuestionNum, String freeQuestionWriter, String title, int viewCount,
			String userRegdate, String answeredYn) {
		super();
		this.freeQuestionNum = freeQuestionNum;
		this.freeQuestionWriter = freeQuestionWriter;
		this.title = title;
		this.viewCount = viewCount;
		this.userRegdate = userRegdate;
		this.answeredYn = answeredYn;
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

	@Override
	 public String toString() {
		 return "QnaFreeReadResDto{" +
	                "free_question_writer=" + freeQuestionWriter +
	                ", title='" + title + '\'' +	                
	                '}';
		 
	 }
}
