package com.acorn2.FinalProject.notice.dto;

import org.apache.ibatis.type.Alias;

@Alias("noticeDto")
public class NoticeDto {
	private int notiNum;
	private String title;
	private String content;
	private int viewCount;
	private String regdate;
	private String notiWriter;
	private String updateRegdate;
	private String updateId;
	private String deleteYNCode;
	private int prevNum;
	private int nextNum;
	
	public NoticeDto() {}

	public NoticeDto(int notiNum, String title, String content, int viewCount, String regdate, String notiWriter,
			String updateRegdate, String updateId, String deleteYNCode, int prevNum,
			int nextNum) {
		super();
		this.notiNum = notiNum;
		this.title = title;
		this.content = content;
		this.viewCount = viewCount;
		this.regdate = regdate;
		this.notiWriter = notiWriter;
		this.updateRegdate = updateRegdate;
		this.updateId = updateId;
		this.deleteYNCode = deleteYNCode;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
	}

	public int getNotiNum() {
		return notiNum;
	}

	public void setNotiNum(int notiNum) {
		this.notiNum = notiNum;
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

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getNotiWriter() {
		return notiWriter;
	}

	public void setNotiWriter(String notiWriter) {
		this.notiWriter = notiWriter;
	}

	public String getUpdateRegdate() {
		return updateRegdate;
	}

	public void setUpdateRegdate(String updateRegdate) {
		this.updateRegdate = updateRegdate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getDeleteYNCode() {
		return deleteYNCode;
	}

	public void setDeleteYNCode(String deleteYNCode) {
		this.deleteYNCode = deleteYNCode;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}
		
}
