package com.acorn2.plec.api.lectureStudent.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.plec.api.lectureStudent.dto.req.LectureStudentCreateReqDto;
import com.acorn2.plec.api.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.plec.api.lectureStudent.dto.req.LectureStudentUpdateReqDto;
import com.acorn2.plec.api.lectureStudent.dto.res.LectureStudentOneReadResDto;
import com.acorn2.plec.api.lectureStudent.dto.res.LectureStudentReadListResDto;
import com.acorn2.plec.api.lectureStudent.service.LectureStudentService;
import com.acorn2.plec.common.ComResponseEntity;
import com.acorn2.plec.common.dto.ComResponseDto;
import com.acorn2.plec.common.utils.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;


@Api(value = "LectureStudent")
@RestController
@RequestMapping(value = "/api/lecture-student")
public class LectureStudentController {

	@Autowired private LectureStudentService service;
	
	@ApiOperation(value="강의 수강생 목록", notes = "강의 수강생 목록 가져오기")
	@GetMapping("/lecture-student-list")
	public ComResponseEntity<LectureStudentReadListResDto> getStudentList(@RequestParam String largeCategory,	
												@RequestParam(required = false) String smallCategory,				
												@Parameter(hidden=true)LectureStudentReadReqDto studentReadReqDto){
		LectureStudentReadListResDto studentReadListResDto = service.LectureStudentList(studentReadReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(studentReadListResDto));
	}
	
	@ApiOperation(value="강의 수강생 한 명의 정보", notes = "강의 수강생 한 명의 정보 가져오기")
	@GetMapping("/{lecStuNum}/lecture-student-one")
	public ComResponseEntity<LectureStudentOneReadResDto> LectureStudentOne(int lecStuRefGroup){
		LectureStudentOneReadResDto dtoOne = service.LectureStudentOne(SessionUtils.getUserId(), lecStuRefGroup);
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));
		
	}
	
	@ApiOperation(value="수강생 확인", notes = "수강생 확인한다.")
	@GetMapping(value = "/checkStudent/")
	public ComResponseEntity<Map<String, Object>> checkStudent(int lecStuRefGroup) {
		
		return new ComResponseEntity<>(new ComResponseDto<>(service.isStudent(SessionUtils.getUserId(), lecStuRefGroup)));
	}

	
	@ApiOperation(value="강의 수강 신청", notes = "강의 수강 신청하기")
	@PostMapping("/lecture-signup")
	public ComResponseEntity<Void> LectureSignup(@RequestBody LectureStudentCreateReqDto lecstudentCreateDto){
		service.LectureSignup(lecstudentCreateDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}
	@ApiOperation(value="강의 수강 완료", notes = "강의 수강 완료하기")
	@PostMapping("/lecture-complete")
	public ComResponseEntity<Void> LectureCompleteYn (@RequestBody LectureStudentUpdateReqDto studentUpdateReqDto){
		service.LectureCompleteYn(studentUpdateReqDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}

	
}
