package com.acorn2.FinalProject.faq.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private final Logger logger = LoggerFactory.getLogger(getClass());


	@Autowired private FaqService service;
	
	@GetMapping("/Faqlist")
	public ComResponseEntity<FaqReadListResDto> FaqList(
			@Parameter(hidden = true) FaqReadReqDto faqReadReqDto) {
		FaqReadListResDto faqReadListResDto = service.selectFaqList(faqReadReqDto);
		logger.debug("faqReadReqDto parameter : {}", faqReadReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(faqReadListResDto));
	}
	
	@GetMapping("/{faqNum}/faqOne")
	public ComResponseEntity<FaqDto> FaqOne(@PathVariable int faqNum){
		FaqDto dtoOne = service.FaqOne(faqNum);
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));
	}
	
	@PostMapping("/Faqinsert")
	public ComResponseEntity<Void> FaqInsert(@Valid @RequestBody FaqCreateReqDto faqCreateReqDto){
		service.FaqInsert(faqCreateReqDto);
		return new ComResponseEntity<Void>();
	}
	
	@PutMapping("/{faqNum}/update")
	public ComResponseEntity<Void> FaqUpdate(@RequestParam(value = "faqNum", required = true) int faqNum,
								@Valid @RequestBody FaqUpdateReqDto faqUpdateReqDto){
		service.FaqUpdate(faqUpdateReqDto);
		return new ComResponseEntity<Void>();		
	}
	
	@DeleteMapping("/{faqNum}/delete")
	public ComResponseEntity<Void> FaqDelete(@RequestParam(value = "faqNum", required = true) int faqNum){
		service.FaqDelete(faqNum);
		return new ComResponseEntity<Void>();
	}
	
}