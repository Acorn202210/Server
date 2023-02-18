package com.acorn2.FinalProject.qnaboard.dto.req;

public class QnaBoardCreateReqDto {
	
	private String board_question_writer;
	private String title;	
	private String content;	
			
	public  QnaBoardCreateReqDto () {}

	public QnaBoardCreateReqDto(String board_question_writer, String title, String content) {
		super();
		
		this.board_question_writer = board_question_writer;
		this.title = title;
		this.content = content;
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
