package com.acorn2.FinalProject.notice.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

public class NoticeReadDetailResDto{
	@Schema(description = "공지사항 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int noti_num;
	@Schema(description = "공지사항 제목", example = "제목", required = true, minLength = 1, maxLength = 50)
	private String title;
	@Schema(description = "공지사항 내용", example = "공지사항", required = true, minLength = 1, maxLength = 10000)
	private String content;
	@Schema(description = "공지사항 조회수", example = "0", required = true, minLength = 1, maxLength = 10000)
	private Integer viewCount;
	@Schema(description = "공지사항 등록일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String regdate;
	@Schema(description = "공지사항 등록자", example = "관리자", required = true, minLength = 1, maxLength = 50)
	private String noti_writer;
	@Schema(description = "공지사항 수정일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String update_regdate;
	@Schema(description = "공지사항 수정자", example = "관리자2", required = true, minLength = 1, maxLength = 50)
	private String update_id;
	@Schema(description = "공지사항 삭제여부", example = "N", required = true, minLength = 1, maxLength = 3)
	private String delete_yn_code;
	@Schema(description = "다음 공지사항", example = "1", required = true, minLength = 1, maxLength = 3)
	private int nextNum;
	@Schema(description = "이전 공지사항", example = "3", required = true, minLength = 1, maxLength = 3)
	private int prevNum;
	public NoticeReadDetailResDto(int noti_num, String title, String content, Integer viewCount, String regdate,
			String noti_writer, String update_regdate, String update_id, String delete_yn_code, int nextNum,
			int prevNum) {
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
		this.nextNum = nextNum;
		this.prevNum = prevNum;
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
