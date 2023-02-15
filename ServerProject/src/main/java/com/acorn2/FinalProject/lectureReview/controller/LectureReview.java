package com.acorn2.FinalProject.lectureReview.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReadListRes;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReadReq;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewRes;
import com.acorn2.FinalProject.lectureReview.service.LectureReviewService;
import com.acorn2.FinalProject.notice.exception.NoticeNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(value = "LectureReview")
@RestController
@RequestMapping(value = "/api")
public class LectureReview {
	@Autowired
	private LectureReviewService service;

	@Operation(summary = "리뷰 목록 조회")
	@Parameters({
		@Parameter(name = "cd", description = "코드 아이디", required = false, in = ParameterIn.QUERY, schema = @Schema(type = "string")),
		@Parameter(name = "cdNm", description = "코드 명", required = false, in = ParameterIn.QUERY, schema = @Schema(type = "string")),
		@Parameter(name = "cdGrp", description = "코드그룹 아이디", required = false, in = ParameterIn.QUERY, schema = @Schema(type = "string")),
		@Parameter(name = "useYn", description = "사용여부(옵션)", required = false, in = ParameterIn.QUERY, schema = @Schema(type = "string")),
		@Parameter(name = "searchFromDate", description = "날짜검색 시작(YYYY-MM-DD)(옵션)", required = false, in = ParameterIn.QUERY, schema = @Schema(type = "date")),
		@Parameter(name = "searchToDate", description = "날짜검색 끝(YYYY-MM-DD)(옵션)", required = false, in = ParameterIn.QUERY, schema = @Schema(type = "date")),
		@Parameter(name = "currentPage", description = "현재 페이지(옵션, 빈값일 경우 1 기본세팅)", required = false, in = ParameterIn.QUERY, schema = @Schema(type = "integer")),
		@Parameter(name = "limit", description = "페이지 사이즈(옵션, 빈값일 경우 20 기본세팅)", required = false, in = ParameterIn.QUERY, schema = @Schema(type = "integer"))
	})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "성공", content = {
					@Content(mediaType = "application/json" )})
	})
	@GetMapping("/lecture/lectureList")
	public ResponseEntity<LectureReviewReadListRes> getReviewList(
			@Parameter(hidden = true) LectureReviewReadReq reviewReq) {
		LectureReviewReadListRes revicewReadListRes = service.LectureReviewList(reviewReq);
		
		return null;
	}



	

	

	
}
