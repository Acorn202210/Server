package com.acorn2.FinalProject.lectureReview.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.lectureReview.service.LectureReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "LectureReview")
@RestController
@RequestMapping(value = "/api")
public class LectureReview {
	@Autowired private LectureReviewService service;
	
	@ApiOperation(value="댓글 리스트", notes = "댓글 리스트를 출력함.")
	@GetMapping("/lectureReview/list")
	public Map<String, Object> list(@RequestParam(value = "pageNum", required = true)int pageNum,
				@RequestParam(value = "ref_group", required = false)int ref_group){	
		
		
		return service.getList(pageNum,ref_group);
	}
}
