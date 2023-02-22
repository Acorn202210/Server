package com.acorn2.FinalProject.lecture.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	
	@PostMapping("LectureInsert")
	public ComResponseEntity<Void> LectureInsert(@Valid @ModelAttribute LectureCreateReqDto lectureCreateReqDto){
		String imagePath = null;
		MultipartFile image = lectureCreateReqDto.getImage();
		if (image == null) {
		    // handle the error
		} else {
		    imagePath = "/C:/data/" + image.getOriginalFilename();
		    lectureCreateReqDto.setImagePath(imagePath);
		    // rest of your code
		}
		
		try {
		    File file = new File(imagePath);
		    if (file.exists()) {  // 파일이 이미 존재하는지 확인합니다.
		        boolean deleted = file.delete();  // 파일을 삭제합니다.
		        if (!deleted) {
		            System.out.println("파일 삭제에 실패하였습니다.");
		        }
		    }
		    boolean created = file.createNewFile();  // 파일을 생성합니다.
		    if (created) {
		        System.out.println("파일이 성공적으로 생성되었습니다.");
		    } else {
		        System.out.println("파일 생성에 실패하였습니다.");
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		service.LectureInsert(lectureCreateReqDto);
		
		return new ComResponseEntity<Void>();
	}
	
    
    @DeleteMapping("/{lecNum}")
    public ComResponseEntity<Void> LectureDelete(@RequestParam(value = "lecNum", required = true) int lecNum){
	   
	    service.LectureDelete(lecNum);
	   
	    return new ComResponseEntity<Void>();
   }
}