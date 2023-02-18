package com.acorn2.FinalProject.faq.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.faq.dto.FaqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqCreateReqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqReadReqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqUpdateReqDto;
import com.acorn2.FinalProject.faq.dto.res.FaqReadListResDto;
import com.acorn2.FinalProject.faq.service.FaqService;
import com.acorn2.FinalProject.notice.dto.req.NoticeReadReqDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadListResDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Api("FaqController")
@RequestMapping("/api/faq")
public class Faq {
	@Autowired private FaqService service;
	
	@GetMapping("/Faqlist")
	public ComResponseEntity<FaqReadListResDto> FaqList(
			@Parameter(hidden = true) FaqReadReqDto faqReadReqDto) {
		FaqReadListResDto faqReadListResDto = service.selectFaqList(faqReadReqDto);
		
		return new ComResponseEntity<>(new ComResponseDto<>(faqReadListResDto));
	}
	
	@GetMapping("/{faq_num}/faqOne")
	public ComResponseEntity<FaqDto> FaqOne(@PathVariable int faq_num){
		FaqDto dtoOne = service.FaqOne(faq_num);
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));
	}
	
	@PostMapping("/Faqinsert")
	public ComResponseEntity<Void> FaqInsert(@Valid @RequestBody FaqCreateReqDto faqCreateReqDto){
		service.FaqInsert(faqCreateReqDto);
		return new ComResponseEntity<Void>();
	}
	
	@PutMapping("/{faq_num}/update")
	public ComResponseEntity<Void> FaqUpdate(@RequestParam(value = "faq_num", required = true) int faq_num,
								@Valid @RequestBody FaqUpdateReqDto faqUpdateReqDto){
		service.FaqUpdate(faqUpdateReqDto);
		return new ComResponseEntity<Void>();		
	}
	
	@DeleteMapping("/{faq_num}/delete")
	public ComResponseEntity<Void> FaqDelete(@RequestParam(value = "faq_num", required = true) int faq_num){
		service.FaqDelete(faq_num);
		return new ComResponseEntity<Void>();
	}
	
}