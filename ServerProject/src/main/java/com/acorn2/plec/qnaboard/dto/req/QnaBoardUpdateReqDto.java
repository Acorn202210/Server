package com.acorn2.plec.qnaboard.dto.req;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "1:1문의 수정")
public class QnaBoardUpdateReqDto {
	
	private Integer boardQuestionNum;
	@Schema(description = "1:1문의 제목", example = "제목", required = true, minLength = 1, maxLength = 50)
	@Size(min = 1, max = 50)
	private String title;	
	@Schema(description = "1:1문의 내용", example = "내용", required = true, minLength = 1, maxLength = 10000)
	@Size(min = 1, max = 10000)
	private String content;
		
	public QnaBoardUpdateReqDto(@NotEmpty @Size(min = 1, max = 50) String title,
			@NotEmpty @Size(min = 1, max = 10000) String content) {
		super();		
		this.title = title;
		this.content = content;
	}
	public Integer getBoardQuestionNum() {
		return boardQuestionNum;
	}
	public void setBoardQuestionNum(Integer boardQuestionNum) {
		this.boardQuestionNum = boardQuestionNum;
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
