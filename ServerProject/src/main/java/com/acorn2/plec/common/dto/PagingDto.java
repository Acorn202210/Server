package com.acorn2.plec.common.dto;

import com.acorn2.plec.common.constant.PagingConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(value = JsonInclude.Include.NON_ABSENT, content = JsonInclude.Include.NON_EMPTY)
public class PagingDto {
	
	@JsonIgnore
	private Integer currentPage;
	@JsonIgnore
	private Integer limit;

	public PagingDto() {
		this.currentPage = PagingConstant.DEFAULT_PAGE;
		this.limit = PagingConstant.DEFAULT_LIMIT;
	}

	public Integer getCurrentPage() {
		if (this.currentPage == null) {
			this.currentPage = PagingConstant.DEFAULT_PAGE;
		}
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getLimit() {
		if (this.limit == null) {
			this.limit = PagingConstant.DEFAULT_LIMIT;
		}
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@JsonIgnore
	public Integer getRowStart() {
		if (this.currentPage == null) {
			this.currentPage = PagingConstant.DEFAULT_PAGE;
		}
		if (this.limit == null) {
			this.limit = PagingConstant.DEFAULT_LIMIT;
		}
		return (this.currentPage - 1) * limit + 1;
	}
	
	@JsonIgnore
	public Integer getRowEnd() {
		return (getRowStart()-1)+limit;
	}
}
