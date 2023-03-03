package com.acorn2.plec.common.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 *
 * @ProgramName : SortPageDto
 * @Author : LaVega
 * @Version : 1.0
 * @Description : 리스트형 데이터 조회 공통
 */
public class PagingSortDto extends PagingDto {
	/**
	 * 정렬 기준 컬럼
	 */
	@JsonIgnore
	private String sort;

	/**
	 * 정렬 방법(asc, desc)
	 */
	@JsonIgnore
	private String order;

	/**
	 * 검색 시작 일자
	 */
	@JsonIgnore
	private String searchFromDate;

	/**
	 * 검색 종료 일자
	 */
	@JsonIgnore
	private String searchToDate;

	/**
	 * Mysql에서 넘버링할 때, order by 내림차순 정렬관련 sub쿼리를 한번 줄이기 위함
	 */
	@JsonIgnore
	private Integer totalCount;

	/**
	 * 정렬 기준 컬럼 목록
	 */
	@JsonIgnore
	private List<String> sortList;

	/**
	 * 정렬 방법 목록
	 */
	@JsonIgnore
	private List<String> orderList;

	

	public String getSearchFromDate() {
		return searchFromDate;
	}

	public void setSearchFromDate(String searchFromDate) {
		this.searchFromDate = searchFromDate;
	}

	public String getSearchToDate() {
		return searchToDate;
	}

	public void setSearchToDate(String searchToDate) {
		this.searchToDate = searchToDate;
	}

	public List<String> getSortList() {
		return this.sortList;
	}

	public List<String> getOrderList() {
		return this.orderList;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
