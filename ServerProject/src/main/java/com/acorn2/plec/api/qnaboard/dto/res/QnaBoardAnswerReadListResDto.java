package com.acorn2.plec.api.qnaboard.dto.res;

import java.util.List;

import com.acorn2.plec.common.dto.PagingDto;
import com.acorn2.plec.common.dto.PagingResponseDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "1:1문의 댓글 목록")
public class QnaBoardAnswerReadListResDto extends PagingResponseDto {
	public QnaBoardAnswerReadListResDto() {
		super(0, new PagingDto());
	}
	
	public QnaBoardAnswerReadListResDto(Integer totalCount, PagingDto pageDto) {
		super(totalCount, pageDto);		
	}
	
	@Schema(description = "1:1문의 답변 목록", example = "", required = true, minLength = 1, maxLength = 50)
	private List<QnaBoardAnswerReadResDto> data;

	public List<QnaBoardAnswerReadResDto> getData() {
		return data;
	}

	public void setData(List<QnaBoardAnswerReadResDto> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {		
		return "QnaBoardAnswerReadListResDto{" +
				"data=" + data +
				'}';
	}
}
