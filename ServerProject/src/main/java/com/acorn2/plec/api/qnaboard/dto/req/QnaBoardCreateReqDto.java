package com.acorn2.plec.api.qnaboard.dto.req;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "1:1문의 입력")
public class QnaBoardCreateReqDto {
		
	@Schema(description = "1:1문의 제목", example = "제목", required = true, minLength = 1, maxLength = 50)
	@NotEmpty
	@Size(min = 1,max = 50)
	private String title;	
	@Schema(description = "1:1문의 내용", example = "내용", required = true, minLength = 1, maxLength = 10000)
	@NotEmpty
	@Size(min = 1,max = 10000)
	private String content;
			
	public QnaBoardCreateReqDto(@NotEmpty @Size(min = 1, max = 50) String title, @NotEmpty @Size(min = 1, max = 10000) String content) {
		super();
				
		this.title = title;
		this.content = content;
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
