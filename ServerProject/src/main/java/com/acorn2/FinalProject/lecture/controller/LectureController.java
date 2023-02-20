package com.acorn2.FinalProject.lecture.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.lecture.Service.LectureService;
import com.acorn2.FinalProject.lecture.dto.LectureDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureCreateReqDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureReadReqDto;
import com.acorn2.FinalProject.lecture.dto.res.LectureReadListResDto;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "Lecture")
@RestController
@RequestMapping("/api/lecture")
public class LectureController {
	@Autowired
	private LectureService service;
	
	@GetMapping("/LectureList")
	public ComResponseEntity<LectureReadListResDto> getLectureList(@RequestParam String largeCategory,
												@RequestParam String smallCategory,
												@Parameter(hidden = true) LectureReadReqDto lectureReadReqDto){
		
		LectureReadListResDto lectureReadListResDto = service.LectureList(lectureReadReqDto);
		
		return new ComResponseEntity<>(new ComResponseDto<>(lectureReadListResDto));
	}
	 
	@GetMapping("/{lecNum}/LectureOne")
	public ComResponseEntity<LectureDto> LectureOne(@PathVariable int lecNum){
		
		LectureDto dtoOne = service.LectureOne(lecNum);
		
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));
	}
	
//	@PostMapping("LectureInsert")
//	public ComResponseEntity<Void> LectureInsert(@Valid @RequestBody LectureCreateReqDto lectureCreateReqDto){
//		
//		service.LectureInsert(lectureCreateReqDto);
//		
//		return new ComResponseEntity<Void>();
//	}
	
    
    @DeleteMapping("/{lecNum}")
    public ComResponseEntity<Void> LectureDelete(@RequestParam(value = "lecNum", required = true) int lecNum){
	   
	    service.LectureDelete(lecNum);
	   
	    return new ComResponseEntity<Void>();
   }
}