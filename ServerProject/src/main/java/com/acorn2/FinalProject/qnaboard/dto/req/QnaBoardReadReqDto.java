package com.acorn2.FinalProject.qnaboard.dto.req;

import org.apache.ibatis.type.Alias;

import com.acorn2.FinalProject.common.dto.PagingDto;

@Alias("qnaBoardReq")
public class QnaBoardReadReqDto extends PagingDto {
	private int boardQuestionNum;
	private String boardQuestionWriter;
	private String title;
	private String content;
	private String keyword;
	private String condition;
	
	public QnaBoardReadReqDto () {}

	public QnaBoardReadReqDto(int boardQuestionNum, String boardQuestionWriter, String title, String content,
			String keyword, String condition) {
		super();
		this.boardQuestionNum = boardQuestionNum;
		this.boardQuestionWriter = boardQuestionWriter;
		this.title = title;
		this.content = content;
		this.keyword = keyword;
		this.condition = condition;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}	
	
}
