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
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReq;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewRes;
import com.acorn2.FinalProject.lectureReview.service.LectureReviewService;
import com.acorn2.FinalProject.notice.exception.NoticeNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "LectureReview")
@RestController
@RequestMapping(value = "/api")
public class LectureReview {
	@Autowired
	private LectureReviewService service;

	@ApiOperation(value = "리뷰 리스트", notes = "댓글 리스트를 출력함.")
	@GetMapping("/lectureReview/LectureReviewList")
	public ResponseEntity<List<LectureReviewDto>> LectureReviewList(
			@RequestParam(value = "pageNum", required = true, defaultValue = "0") int pageNum,
			@RequestParam(value = "ref_group", required = true) int ref_group) {

		return service.LectureReviewList(pageNum, ref_group);
	}

	@ApiOperation(value = "리뷰 입력")
	@PutMapping(value = "/lectureReview/insert")
	public ResponseEntity<Object> LectureSignup(@RequestBody LectureReviewRes res) {
		return service.saveReview(res);
	}

	
	@ApiOperation(value = "리뷰 수정")  
	@PutMapping("/lectureReview/{num}/update") 
	public ResponseEntity<Object> updateReview(@RequestParam(value = "num", required = true,  defaultValue = "0")int num ,
							@RequestBody LectureReviewRes res){
		ResponseEntity<LectureReviewDto> dto = service.getData(num);
		
		LectureReviewReq req = new LectureReviewReq(); 
		req.setNum(num);
	    req.setContent(res.getContent()); 
		req.setStar(res.getStar());
		  
		 return service.updateReview(req); }
	 

	@ApiOperation(value = "리뷰 수정 전 상세")
	@GetMapping("/lectureReview/{num}/ReviewData")
	public ResponseEntity<LectureReviewDto> ReviewData(@RequestParam(value = "num", required = true,  defaultValue = "0")int num) {
		return service.getData(num);
	}

	@ApiOperation(value = "댓글 삭제")
	@DeleteMapping(value = "/lectureReview/{num}/delete")
	public ResponseEntity<Object> ReviewDelete(@RequestParam(value = "num", required = true,  defaultValue = "0")int num) {
		return service.deleteReview(num);
	}
}
