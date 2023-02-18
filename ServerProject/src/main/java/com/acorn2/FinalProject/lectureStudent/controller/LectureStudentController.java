package com.acorn2.FinalProject.lectureStudent.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentCreateReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentOneReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentUpdateReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentReadListResDto;
import com.acorn2.FinalProject.lectureStudent.service.LectureStudentService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Api(value = "LectureStudent")
@RestController
@RequestMapping(value = "/api/lectureStudent")
public class LectureStudentController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired private LectureStudentService service;
	
	@GetMapping("/LectureStudentList")
	public ComResponseEntity<LectureStudentReadListResDto> getStudentList(@RequestParam String largeCategory,	
												@RequestParam String smallCategory,				
												@Parameter(hidden=true)LectureStudentReadReqDto studentReadReqDto){
		LectureStudentReadListResDto studentReadListResDto = service.LectureStudentList(studentReadReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(studentReadListResDto));
	}
	
	//한 명의 정보
	@GetMapping("/{lecStuNum}/lectureStudentOne")
	public ComResponseEntity<LectureStudentOneReadReqDto> LectureStudentOne(@RequestParam int lecStuNum){
		LectureStudentOneReadReqDto dtoOne = service.LectureStudentOne(lecStuNum);
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));
		
	}
	
	//수강 신청
	@PostMapping("/LectureSignup")
	public ComResponseEntity<Void> LectureSignup(@RequestParam int lecStuNum,
												@RequestParam String lecStuUserId,
												@RequestParam int lecStuRefGroup,
												@Valid @RequestBody LectureStudentCreateReqDto studentCreateReqDto){
		service.LectureSignup(studentCreateReqDto);
		return new ComResponseEntity<Void>();
	}
	//수강 완료 or 취소
	@PutMapping("/lectureCompleteYn")
	public ComResponseEntity<Void> LectureCompleteYn (@RequestParam String completeYn,
												@RequestParam int lecStuNum,
												@Valid @RequestBody LectureStudentUpdateReqDto studentUpdateReqDto){
		service.LectureCompleteYn(studentUpdateReqDto);
		return new ComResponseEntity<Void>();
	}

	
}
