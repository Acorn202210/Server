package com.acorn2.FinalProject.qnaboard.dto.req;

import org.apache.ibatis.type.Alias;

import com.acorn2.FinalProject.common.dto.PagingDto;

@Alias("qnaBoardReq")
public class QnaBoardReadReqDto extends PagingDto {
	private int board_question_num;
	private String board_question_writer;
	private String title;
	private String content;
	
	public QnaBoardReadReqDto () {}

	public QnaBoardReadReqDto(int board_question_num, String board_question_writer, String title, String content) {
		super();
		this.board_question_num = board_question_num;
		this.board_question_writer = board_question_writer;
		this.title = title;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}
