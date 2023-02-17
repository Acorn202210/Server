package com.acorn2.FinalProject.lectureStudent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadListResDto;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentDto;
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
public class LectureStudent {
	@Autowired private LectureStudentService service;
	
	@GetMapping("/LectureStudentList")
	public ComResponseEntity<LectureStudentReadListResDto> getStudentList(@RequestParam String large_category,	
												@RequestParam String small_category,				
												@Parameter(hidden=true)LectureStudentReadReqDto studentReadReqDto){
		
		LectureStudentReadListResDto studentReadListResDto = service.LectureStudentList(studentReadReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(studentReadListResDto));
	}
	
	//한 명의 정보
	@GetMapping("/{lec_Stu_Num}/lectureStudentOne")
	public ComResponseEntity<LectureStudentOneReadReqDto> LectureStudentOne(@RequestParam int lec_Stu_Num){
		LectureStudentOneReadReqDto dtoOne = service.LectureStudentOne(lec_Stu_Num);
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));
		
	}
	
	//수강 신청
	@PostMapping("/LectureSignup")
	public ComResponseEntity<Void> LectureSignup(@RequestParam int lec_Stu_Num,
												@RequestParam String lec_Stu_User_Id,
												@RequestParam int lec_Stu_Ref_Group,
												@Valid @RequestBody LectureStudentCreateReqDto studentCreateReqDto){
		service.LectureSignup(studentCreateReqDto);
		return new ComResponseEntity<Void>();
	}
	//수강 완료 or 취소
	@PutMapping("/lectureCompleteYn")
	public ComResponseEntity<Void> LectureCompleteYn (@RequestParam String Complete_Yn,
												@RequestParam String lec_Stu_User_Id,
												@RequestParam int lec_Stu_Ref_Group,
												@Valid @RequestBody LectureStudentUpdateReqDto studentUpdateReqDto){
		service.LectureCompleteYn(studentUpdateReqDto);
		return new ComResponseEntity<Void>();
	}

	
}
