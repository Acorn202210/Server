package com.acorn2.plec.api.qnafree.dto.req;

import org.apache.ibatis.type.Alias;

import com.acorn2.plec.common.dto.PagingDto;

@Alias("qnaFreeReq")
public class QnaFreeReadReqDto extends PagingDto {
	private int freeQuestionNum;
	private String freeQuestionWriter;
	private String title;
	private String content;
	private String keyword;
	private String condition;
	
	public QnaFreeReadReqDto () {}

	public QnaFreeReadReqDto(int freeQuestionNum, String freeQuestionWriter, String title, String content,
			String keyword, String condition) {
		super();
		this.freeQuestionNum = freeQuestionNum;
		this.freeQuestionWriter = freeQuestionWriter;
		this.title = title;
		this.content = content;
		this.keyword = keyword;
		this.condition = condition;
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
