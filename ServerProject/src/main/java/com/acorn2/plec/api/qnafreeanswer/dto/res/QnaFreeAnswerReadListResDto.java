package com.acorn2.plec.api.qnafreeanswer.dto.res;

import java.util.List;

import com.acorn2.plec.common.dto.PagingDto;
import com.acorn2.plec.common.dto.PagingResponseDto;

import io.swagger.v3.oas.annotations.media.Schema;

public class QnaFreeAnswerReadListResDto extends PagingResponseDto {
	public QnaFreeAnswerReadListResDto() {
		super(0, new PagingDto());
	}

	public QnaFreeAnswerReadListResDto(Integer totalCount, PagingDto PageDto) {
		super(totalCount, PageDto);
	}

	@Schema(description = "자유게시판 댓글 목록", example = "", required = true, minLength = 1, maxLength = 50)
	private List<QnaFreeAnswerReadResDto> data;

	public List<QnaFreeAnswerReadResDto> getData() {
		return data;
	}

	public void setData(List<QnaFreeAnswerReadResDto> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "QnaFreeAnswerReadListResDto{" + "data=" + data + '}';
	}

}
