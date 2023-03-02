package com.acorn2.plec.notice.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

public class NoticeReadDetailResDto {
	@Schema(description = "공지사항 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int notiNum;
	@Schema(description = "공지사항 제목", example = "제목", required = true, minLength = 1, maxLength = 50)
	private String title;
	@Schema(description = "공지사항 내용", example = "공지사항", required = true, minLength = 1, maxLength = 10000)
	private String content;
	@Schema(description = "공지사항 조회수", example = "0", required = true, minLength = 1, maxLength = 10000)
	private Integer viewCount;
	@Schema(description = "공지사항 등록일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String regdate;
	@Schema(description = "공지사항 등록자", example = "관리자", required = true, minLength = 1, maxLength = 50)
	private String notiWriter;
	@Schema(description = "공지사항 수정일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String updateRegdate;
	@Schema(description = "공지사항 수정자", example = "관리자2", required = true, minLength = 1, maxLength = 50)
	private String updateId;
	@Schema(description = "공지사항 삭제여부", example = "N", required = true, minLength = 1, maxLength = 3)
	private String deleteYNCode;
	@Schema(description = "다음 공지사항", example = "1", required = true, minLength = 1, maxLength = 3)
	private int nextNum;
	@Schema(description = "이전 공지사항", example = "3", required = true, minLength = 1, maxLength = 3)
	private int prevNum;
	
	public NoticeReadDetailResDto() {}
	
	public NoticeReadDetailResDto(int notiNum, String title, String content, Integer viewCount, String regdate,
			String notiWriter, String updateRegdate, String updateId, String deleteYNCode, int nextNum, int prevNum) {
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
		this.nextNum = nextNum;
		this.prevNum = prevNum;
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
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
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
	public int getNextNum() {
		return nextNum;
	}
	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}
	public int getPrevNum() {
		return prevNum;
	}
	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}
	
	
}
