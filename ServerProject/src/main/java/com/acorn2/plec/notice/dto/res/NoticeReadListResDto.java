package com.acorn2.plec.notice.dto.res;

import java.util.List;

import com.acorn2.plec.common.dto.PagingDto;
import com.acorn2.plec.common.dto.PagingResponseDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "공지사항 목록")
public class NoticeReadListResDto extends PagingResponseDto {
	public NoticeReadListResDto() {
		super(0, new PagingDto());
	}

	public NoticeReadListResDto(Integer totalCount, PagingDto comPageDto) {
		super(totalCount, comPageDto);
	}

	@Schema(description = "공지사항 목록", example = "", required = true, minLength = 1, maxLength = 50)
	private List<NoticeReadResDto> data;

	public List<NoticeReadResDto> getData() {
		return data;
	}

	public void setData(List<NoticeReadResDto> data) {
		this.data = data;
	}
}
