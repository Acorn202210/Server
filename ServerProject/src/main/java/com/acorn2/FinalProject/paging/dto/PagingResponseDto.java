package com.acorn2.FinalProject.paging.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author : LaVega
 * @ProgramName : ComPagingResponseDto
 * @description : 공통 페이징 조회 결과 응답 Dto
 */
public class PagingResponseDto {
	public PagingResponseDto(Integer totalCount, PagingDto pageDto) {
		setPagingInfo(totalCount, pageDto.getLimit(), pageDto.getCurrentPage());
	}

	@JsonInclude(Include.NON_NULL)
	private Integer totalPage;

	@JsonInclude(Include.NON_NULL)
	private Integer totalCount;

	@JsonInclude(Include.NON_NULL)
	private Integer currentPage;

	@JsonInclude(Include.NON_NULL)
	private Integer limit;

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public void setPagingInfo(Integer totalCount, Integer limit, Integer currentPage) {
		this.totalCount = totalCount;
		this.limit = limit;
		this.totalPage = totalCount / limit;
		if (totalCount % limit > 0) {
			this.totalPage++;
		}
		this.currentPage = currentPage;
	}
}
