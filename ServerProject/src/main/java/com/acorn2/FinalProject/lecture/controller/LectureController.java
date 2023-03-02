package com.acorn2.FinalProject.lecture.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.lecture.Service.LectureService;
import com.acorn2.FinalProject.lecture.dto.LectureDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureCreateReqDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureReadReqDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureUpdateReqDto;
import com.acorn2.FinalProject.lecture.dto.res.LectureReadListResDto;
import com.acorn2.FinalProject.lecture.image.dto.ImageDto;
import com.acorn2.FinalProject.lecture.image.service.ImageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "Lecture")
@RestController
@RequestMapping("/api/lecture")
public class LectureController {
	@Autowired private LectureService service;
	@Autowired private ImageService imageService;
	
	@ApiOperation(value="강의 목록", notes = "강의 목록을 가져온다.")
	@GetMapping("/lectureList")
	public ComResponseEntity<LectureReadListResDto> getLectureList(@RequestParam String largeCategory,
												@RequestParam String smallCategory,
												@Parameter(hidden = true) LectureReadReqDto lectureReadReqDto){
		
		LectureReadListResDto lectureReadListResDto = service.LectureList(lectureReadReqDto);
		
		return new ComResponseEntity<>(new ComResponseDto<>(lectureReadListResDto));
	}
	@ApiOperation(value="강의 하나의 정보", notes = "강의 하나의 정보를 가져온다.") 
	@GetMapping("/{lecNum}/lectureOne")
	public ComResponseEntity<LectureDto> LectureOne(@PathVariable int lecNum){
		
		LectureDto dtoOne = service.LectureOne(lecNum);
		
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));
	}
	
	@ApiOperation(value="강의 등록", notes = "강의 등록하기")
	@PutMapping(value="/lectureInsert")
	public ComResponseEntity<Void> update(@Parameter(
            description = "multipart/form-data 형식의 이미지 리스트를 input으로 받습니다. 이때 key 값은 multipartFile 입니다.",
            content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE))
			@RequestPart(value = "multipartFile", required = false) MultipartFile file, @RequestBody LectureCreateReqDto lectureCreateReqDto, HttpServletRequest request){
		service.LectureInsert(lectureCreateReqDto, file, request);
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="강의 이미지 가져오기", notes = "이미지 가져오기 ")
	@GetMapping("/{lecNum}/Image")
	public ResponseEntity<byte[]> getImage(int lecNum){
		Map<String, Object> map = imageService.selectImage(lecNum);
		ImageDto imageDto = (ImageDto) map.get("imageDto");
		HttpHeaders headers = (HttpHeaders) map.get("headers");
		
		return new ResponseEntity<byte[]>(imageDto.getData(), headers, HttpStatus.OK);
	}
	
	@ApiOperation(value="강의 수정", notes = "강의 수정하기")
	@PutMapping(value="/{lecNum}")
	public ComResponseEntity<Void> lectureUpdate(@Parameter(
            description = "multipart/form-data 형식의 이미지 리스트를 input으로 받습니다. 이때 key 값은 multipartFile 입니다.",
            content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE))
			@RequestPart(value = "multipartFile", required = false) MultipartFile file, @RequestBody LectureUpdateReqDto lectureUpdateReqDto, HttpServletRequest request){
		service.LectureUpdate(lectureUpdateReqDto, file, request);
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="강의 삭제", notes = "강의 삭제하기")
    @DeleteMapping("/{lecNum}/lectureDelete")
    public ComResponseEntity<Void> LectureDelete(@RequestParam(value = "lecNum", required = true) int lecNum){
	   
	    service.LectureDelete(lecNum);
	   
	    return new ComResponseEntity<Void>();
   }
}