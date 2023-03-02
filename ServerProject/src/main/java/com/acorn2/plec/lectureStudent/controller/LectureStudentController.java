package com.acorn2.plec.lectureStudent.controller;

import javax.servlet.http.HttpServletRequest;
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

import com.acorn2.plec.common.ComResponseEntity;
import com.acorn2.plec.common.dto.ComResponseDto;
import com.acorn2.plec.lectureStudent.dto.req.LectureStudentCreateReqDto;
import com.acorn2.plec.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.plec.lectureStudent.dto.req.LectureStudentUpdateReqDto;
import com.acorn2.plec.lectureStudent.dto.res.LectureStudentOneReadResDto;
import com.acorn2.plec.lectureStudent.dto.res.LectureStudentReadListResDto;
import com.acorn2.plec.lectureStudent.service.LectureStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Api(value = "LectureStudent")
@RestController
@RequestMapping(value = "/api/lectureStudent")
public class LectureStudentController {

	@Autowired private LectureStudentService service;
	
	@ApiOperation(value="강의 수강생 목록", notes = "강의 수강생 목록 가져오기")
	@GetMapping("/LectureStudentList")
	public ComResponseEntity<LectureStudentReadListResDto> getStudentList(@RequestParam String largeCategory,	
												@RequestParam(required = false) String smallCategory,				
												@Parameter(hidden=true)LectureStudentReadReqDto studentReadReqDto){
		LectureStudentReadListResDto studentReadListResDto = service.LectureStudentList(studentReadReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(studentReadListResDto));
	}
	
	@ApiOperation(value="강의 수강생 한 명의 정보", notes = "강의 수강생 한 명의 정보 가져오기")
	@GetMapping("/{lecStuNum}/lectureStudentOne")
	public ComResponseEntity<LectureStudentOneReadResDto> LectureStudentOne(@RequestParam int lecStuNum){
		LectureStudentOneReadResDto dtoOne = service.LectureStudentOne(lecStuNum);
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));
		
	}
	
	@ApiOperation(value="강의 수강 신청", notes = "강의 수강 신청하기")
	@PostMapping("/LectureSignup")
	public ComResponseEntity<Void> LectureSignup(@RequestParam int lecStuRefGroup, HttpServletRequest request){
		service.LectureSignup(lecStuRefGroup, request);
		return new ComResponseEntity<Void>();
	}
	@ApiOperation(value="강의 수강 완료", notes = "강의 수강 완료하기")
	@PutMapping("/lectureCompleteYn")
	public ComResponseEntity<Void> LectureCompleteYn (@RequestParam int lecStuNum,
												@Valid @RequestBody LectureStudentUpdateReqDto studentUpdateReqDto, HttpServletRequest request){
		service.LectureCompleteYn(studentUpdateReqDto, request);
		return new ComResponseEntity<Void>();
	}

	
}
