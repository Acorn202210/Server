package com.acorn2.plec.api.lecture.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.acorn2.plec.api.lecture.Service.LectureService;
import com.acorn2.plec.api.lecture.dto.LectureDto;
import com.acorn2.plec.api.lecture.dto.req.LectureCreateReqDto;
import com.acorn2.plec.api.lecture.dto.req.LectureReadReqDto;
import com.acorn2.plec.api.lecture.dto.req.LectureUpdateReqDto;
import com.acorn2.plec.api.lecture.dto.res.LectureReadListResDto;
import com.acorn2.plec.api.lecture.image.dto.ImageDto;
import com.acorn2.plec.api.lecture.image.dto.ImageNumDto;
import com.acorn2.plec.api.lecture.image.service.ImageService;
import com.acorn2.plec.common.ComResponseEntity;
import com.acorn2.plec.common.dto.ComResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;

@Api(value = "Lecture")
@RestController
@RequestMapping("/api/lecture")
public class LectureController {
	@Autowired private LectureService service;
	@Autowired private ImageService imageService;
	@Value("${file.location}")
	private String fileLocation;
	
	
	@ApiOperation(value="?????? ??????", notes = "?????? ????????? ????????????.")
	@GetMapping("/lectureList")
	public ComResponseEntity<LectureReadListResDto> getLectureList(@RequestParam String largeCategory,
												@RequestParam(required = false) String smallCategory,
												@Parameter(hidden = true) LectureReadReqDto lectureReadReqDto){
		
		LectureReadListResDto lectureReadListResDto = service.LectureList(lectureReadReqDto);
		
		return new ComResponseEntity<>(new ComResponseDto<>(lectureReadListResDto));
	}
	@ApiOperation(value="?????? ????????? ??????", notes = "?????? ????????? ????????? ????????????.") 
	@GetMapping("/{lecNum}/lecture-one")
	public ComResponseEntity<LectureDto> LectureOne(@PathVariable int lecNum){
		
		LectureDto dtoOne = service.LectureOne(lecNum);
		
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));
	}
	
	@ApiOperation(value="?????? ????????? ?????????", notes = "?????? ????????? ?????????")
	@Transactional
	@PostMapping(value="/lecture-img-upload")
	public ComResponseEntity<ImageNumDto> insertImage(@Parameter(
            description = "multipart/form-data ????????? ????????? ???????????? input?????? ????????????. ?????? key ?????? multipartFile ?????????.",
            content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE))
			@RequestPart(value = "multipartFile", required = false) MultipartFile file){
		
		return new ComResponseEntity<>(new ComResponseDto<>(imageService.insertImage(file)));
	}
	
	@ApiOperation(value="?????? ??????", notes = "?????? ????????????")
	@PostMapping(value="/lecture-insert")
	public ComResponseEntity<Void> lectureInsert(@RequestBody LectureCreateReqDto lectureCreateReqDto) {
		service.LectureInsert(lectureCreateReqDto);
		return new ComResponseEntity<Void>();
	}
	
	
	
	@ApiOperation(value="?????? ????????? ????????????", notes = "????????? ???????????? ")
	@GetMapping("/{lecNum}/image")
	public ResponseEntity<byte[]> getImage(int lecNum){
		Map<String, Object> map = imageService.selectImage(lecNum);
		ImageDto imageDto = (ImageDto) map.get("imageDto");
		HttpHeaders headers = (HttpHeaders) map.get("headers");
		
		return new ResponseEntity<byte[]>(imageDto.getData(), headers, HttpStatus.OK);
	}
	
	@ApiOperation(value="?????? ??????", notes = "?????? ????????????")
	@PutMapping(value="/{lecNum}")
	public ComResponseEntity<Void> lectureUpdate(@Parameter(
            description = "multipart/form-data ????????? ????????? ???????????? input?????? ????????????. ?????? key ?????? multipartFile ?????????.",
            content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE))
			@RequestPart(value = "multipartFile", required = false) MultipartFile file, @RequestBody LectureUpdateReqDto lectureUpdateReqDto){
		service.LectureUpdate(lectureUpdateReqDto, file);
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="?????? ??????", notes = "?????? ????????????")
	@PutMapping("/{lecNum}/lecture-delete")
    public ComResponseEntity<Void> LectureDelete(@RequestParam(value = "lecNum", required = true) int lecNum){
	   
	    service.LectureDelete(lecNum);
	   
	    return new ComResponseEntity<Void>();
   }
		
}