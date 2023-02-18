package com.acorn2.FinalProject.notice.dto.res;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "공지사항 정보")
public class NoticeReadResDto {
	@Schema(description = "공지사항 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int noti_num;
	@Schema(description = "공지사항 제목", example = "제목", required = true, minLength = 1, maxLength = 50)
	private String title;
	@Schema(description = "공지사항 조회수", example = "0", required = true, minLength = 1, maxLength = 10000)
	private Integer viewCount;
	@Schema(description = "공지사항 등록일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String regdate;
	@Schema(description = "공지사항 등록자", example = "관리자", required = true, minLength = 1, maxLength = 50)
	private String noti_writer;
	
	public NoticeReadResDto(){}

	public NoticeReadResDto(int noti_num, String title, Integer viewCount, String regdate, String noti_writer) {
		super();
		this.noti_num = noti_num;
		this.title = title;
		this.viewCount = viewCount;
		this.regdate = regdate;
		this.noti_writer = noti_writer;
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

}
