package com.acorn2.FinalProject.notice.dto;

import org.apache.ibatis.type.Alias;

@Alias("noticeDto")
public class NoticeDto {
	private int noti_num;
	private String title;
	private String content;
	private int viewCount;
	private String regdate;
	private String noti_writer;
	private String update_regdate;
	private String update_id;
	private String delete_yn_code;
	private int startRowNum;
	private int endRowNum;
	private int prevNum;
	private int nextNum;
	
	public NoticeDto() {}

	public NoticeDto(int noti_num, String title, String content, int viewCount, String regdate, String noti_writer,
			String update_regdate, String update_id, String delete_yn_code, int startRowNum, int endRowNum, int prevNum,
			int nextNum) {
		super();
		this.noti_num = noti_num;
		this.title = title;
		this.content = content;
		this.viewCount = viewCount;
		this.regdate = regdate;
		this.noti_writer = noti_writer;
		this.update_regdate = update_regdate;
		this.update_id = update_id;
		this.delete_yn_code = delete_yn_code;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
	}

	public int getNoti_num() {
		return noti_num;
	}

	public void setNoti_num(int noti_num) {
		this.noti_num = noti_num;
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

	public String getNoti_writer() {
		return noti_writer;
	}

	public void setNoti_writer(String noti_writer) {
		this.noti_writer = noti_writer;
	}

	public String getUpdate_regdate() {
		return update_regdate;
	}

	public void setUpdate_regdate(String update_regdate) {
		this.update_regdate = update_regdate;
	}

	public String getUpdate_id() {
		return update_id;
	}

	public void setUpdate_id(String update_id) {
		this.update_id = update_id;
	}

	public String getDelete_yn_code() {
		return delete_yn_code;
	}

	public void setDelete_yn_code(String delete_yn_code) {
		this.delete_yn_code = delete_yn_code;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
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
