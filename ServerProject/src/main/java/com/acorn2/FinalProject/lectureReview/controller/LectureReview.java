package com.acorn2.FinalProject.lectureReview.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewCreateReqDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadListResDto;
import com.acorn2.FinalProject.lectureReview.service.LectureReviewService;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Api(value = "LectureReview")
@RestController
@RequestMapping("/api/lectureReview")
public class LectureReview {
	@Autowired
	private LectureReviewService service;

	@GetMapping
	public ComResponseEntity<LectureReviewReadListResDto> getReviewList(@RequestParam(value = "lec_re_stu_ref_group",required = true ,defaultValue = "1") int lec_re_stu_ref_group, 
					@Parameter(hidden = true) LectureReviewReadReqDto reviewReq) {
		LectureReviewReadListResDto revicewReadListRes = service.LectureReviewList(lec_re_stu_ref_group,reviewReq);
		
		return new ComResponseEntity<>(new ComResponseDto<>(revicewReadListRes));
	}
	
	@PostMapping
	public ComResponseEntity<Void> LectureReviewInsert(@Valid @RequestBody LectureReviewCreateReqDto reviewCreatereqDto ){
		service.LectureReviewInsert(reviewCreatereqDto);
		return new ComResponseEntity<Void>();
	}



	

	

	
}
