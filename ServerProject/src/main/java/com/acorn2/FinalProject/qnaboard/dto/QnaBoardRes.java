package com.acorn2.FinalProject.qnaboard.dto;

import org.apache.ibatis.type.Alias;

@Alias("qnaBoardRes")
public class QnaBoardRes {
	private String writer;
	private String title;
	private String content;
	
	public QnaBoardRes() {}

	public QnaBoardRes(String writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
