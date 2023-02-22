package com.acorn2.FinalProject.users.dto.res;

import java.util.List;

import com.acorn2.FinalProject.common.dto.PagingDto;
import com.acorn2.FinalProject.common.dto.PagingResponseDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "회원 목록")
public class UsersReadListResDto extends PagingResponseDto{
	public UsersReadListResDto() {
		super(0, new PagingDto());
	}

	public UsersReadListResDto(Integer totalCount, PagingDto pageDto) {
		super(totalCount, pageDto);
	}
	
	@Schema(description = "회원 목록", example = "", required = true, minLength = 1, maxLength = 50)
	private List<UsersReadResDto> data;

	public List<UsersReadResDto> getData() {
		return data;
	}

	public void setData(List<UsersReadResDto> data) {
		this.data = data;
	}

}
