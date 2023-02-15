package com.acorn2.FinalProject.lectureStudent.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.lecture.dto.LectureDto;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentDto;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentReq;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentRes;
import com.acorn2.FinalProject.lectureStudent.service.LectureStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "LectureStudent")
@RestController
@RequestMapping(value = "/api")
public class LectureStudent {
	@Autowired private LectureStudentService service;
	
	@ApiOperation(value = "강의 리스트")	
    @GetMapping(value = "/lectureStudent/studentlist")
    public ResponseEntity<List<LectureStudentDto>> Studentlist(@RequestParam(value = "pageNum", required = true)int pageNum,
							@RequestParam(value = "large_category", required = false)String large_category,
							@RequestParam(value = "small_category", required = false)String small_category){
		
		return service.studentList(pageNum, large_category, small_category);
	}
	@ApiOperation(value = "강의 수강 신청")	
	@GetMapping(value = "/lectureStudent/lectureSignup")
	public ResponseEntity<Object> LectureSignup(@RequestBody LectureStudentRes res, int num){
        return service.lectureSignup(res);
    }
	
	@ApiOperation(value="강의 완료", notes = "강의 완료되었는지 ")
	@PutMapping("/lectureStudent/lectureComplete")
	public ResponseEntity<Object> update(@RequestBody LectureStudentRes res){
		
		LectureStudentReq req = new LectureStudentReq();
		req.setId(res.getId());
		req.setRef_group(res.getRef_group());
		req.setComplete(res.getComplete());
		
		return service.lectureComplete(req);
	}
}
