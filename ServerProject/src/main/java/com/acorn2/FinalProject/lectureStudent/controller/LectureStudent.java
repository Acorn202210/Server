package com.acorn2.FinalProject.lectureStudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadListResDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentReadListResDto;
import com.acorn2.FinalProject.lectureStudent.service.LectureStudentService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Parameter;


@Api(value = "LectureStudent")
@RestController
@RequestMapping(value = "/api/lectureStudent")
public class LectureStudent {
	@Autowired private LectureStudentService service;
	
	@GetMapping("/LectureStudentList")
	public ComResponseEntity<LectureStudentReadListResDto> getStudentList(@RequestParam int lec_Stu_Ref_Group,
												@RequestParam String lec_Stu_User_Id,
												@RequestParam String large_category,	
												@RequestParam String small_category,				
												@Parameter(hidden=true)LectureStudentReadReqDto studentReadReqDto){
		
		LectureStudentReadListResDto studentReadListResDto = service.LectureStudentList(studentReadReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(studentReadListResDto));
	}
	
}
