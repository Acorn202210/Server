package com.acorn2.FinalProject.lectureReview.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewCreateReqDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewUpdateReqDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadListResDto;
import com.acorn2.FinalProject.lectureReview.service.LectureReviewService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Api(value = "LectureReview")
@RestController
@RequestMapping("/api/lectureReview")
public class LectureReviewController {
	@Autowired
	private LectureReviewService service;

	@ApiOperation(value="강의 후기 목록", notes = "강의 후기 목록 가져오기")
	@GetMapping("/LectureReviewList")
	public ComResponseEntity<LectureReviewReadListResDto> getReviewList(@RequestParam(value = "lecReStuRefGroup",required = true ,defaultValue = "1") int lecReStuRefGroup, 
					@Parameter(hidden = true) LectureReviewReadReqDto reviewReadReqDto) {
		
		LectureReviewReadListResDto revicewReadListResDto = service.LectureReviewList(reviewReadReqDto);
		
		return new ComResponseEntity<>(new ComResponseDto<>(revicewReadListResDto));
	}
	@ApiOperation(value="강의 후기 하나의 정보", notes = "강의 후기 하나의 정보 가져오기")
	@GetMapping("/{lecReNum}/lectureReviewOne")
	public ComResponseEntity<LectureReviewDto> LectureReviewOne(@PathVariable int lecReNum){
		LectureReviewDto dtoOne =  service.LectureReviewOne(lecReNum);
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));	
	}
	@ApiOperation(value="강의 후기 등록", notes = "강의 후기 등록하기")
	@PostMapping("/LectureReviewinsert")
	public ComResponseEntity<Void> LectureReviewInsert(@Valid @RequestBody LectureReviewCreateReqDto reviewCreateReqDto, HttpServletRequest request){
		service.LectureReviewInsert(reviewCreateReqDto, request);
		return new ComResponseEntity<Void>();
	}
	@ApiOperation(value="강의 후기 수정", notes = "강의 후기 수정하기")
	@PutMapping("/{lecReNum}/update")
	public ComResponseEntity<Void> LectureReviewUpdate(@RequestParam(value = "lecReNum", required = true) int lecReNum,
											@Valid @RequestBody LectureReviewUpdateReqDto reviewUpdateReqDto){
		service.LectureReviewUpdate(reviewUpdateReqDto);
		return new ComResponseEntity<Void>();	
	}
	@ApiOperation(value="강의 후기 삭제", notes = "강의 후기 삭제하기")
	@DeleteMapping("/{lecReNum}/lectureReviewDelete")
	public ComResponseEntity<Void> LectureReviewDelete(@RequestParam(value = "lecReNum", required = true) int lecReNum){
		service.LectureReviewDelete(lecReNum);
		return new ComResponseEntity<Void>();
	}

	

	

	
}
