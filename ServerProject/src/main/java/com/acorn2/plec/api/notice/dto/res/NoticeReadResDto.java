package com.acorn2.plec.api.notice.dto.res;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "공지사항 정보")
public class NoticeReadResDto {
	@Schema(description = "공지사항 번호", example = "1", required = true, minLength = 1, maxLength = 50)
	private int notiNum;
	@Schema(description = "공지사항 제목", example = "제목", required = true, minLength = 1, maxLength = 50)
	private String title;
	@Schema(description = "공지사항 조회수", example = "0", required = true, minLength = 1, maxLength = 10000)
	private Integer viewCount;
	@Schema(description = "공지사항 등록일", example = "2023-02-15", required = true, minLength = 1, maxLength = 30)
	private String regdate;
	@Schema(description = "공지사항 등록자", example = "관리자", required = true, minLength = 1, maxLength = 50)
	private String notiWriter;
	
	public NoticeReadResDto(){}

	public NoticeReadResDto(int notiNum, String title, Integer viewCount, String regdate, String notiWriter) {
		super();
		this.notiNum = notiNum;
		this.title = title;
		this.viewCount = viewCount;
		this.regdate = regdate;
		this.notiWriter = notiWriter;
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
	
	
}
