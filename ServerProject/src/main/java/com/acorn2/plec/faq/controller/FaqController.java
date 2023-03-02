package com.acorn2.plec.faq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.plec.common.ComResponseEntity;
import com.acorn2.plec.common.dto.ComResponseDto;
import com.acorn2.plec.faq.dto.FaqDto;
import com.acorn2.plec.faq.dto.req.FaqCreateReqDto;
import com.acorn2.plec.faq.dto.req.FaqReadReqDto;
import com.acorn2.plec.faq.dto.req.FaqUpdateReqDto;
import com.acorn2.plec.faq.dto.res.FaqReadListResDto;
import com.acorn2.plec.faq.service.FaqService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Api("FaqController")
@RequestMapping("/api/faq")
public class FaqController {
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
	public ComResponseEntity<Void> FaqInsert(@Valid @RequestBody FaqCreateReqDto faqCreateReqDto, HttpServletRequest request){
		service.FaqInsert(faqCreateReqDto, request);
		return new ComResponseEntity<Void>();
	}
	
	@PutMapping("/{faqNum}/update")
	public ComResponseEntity<Void> FaqUpdate(@Valid @RequestBody FaqUpdateReqDto faqUpdateReqDto, HttpServletRequest request){
		service.FaqUpdate(faqUpdateReqDto, request);
		return new ComResponseEntity<Void>();		
	}
	
	@PutMapping("/{faqNum}/delete")
	public ComResponseEntity<Void> FaqDelete(@RequestParam(value = "faqNum", required = true) int faqNum){
		service.FaqDelete(faqNum);
		return new ComResponseEntity<Void>();
	}
	
}