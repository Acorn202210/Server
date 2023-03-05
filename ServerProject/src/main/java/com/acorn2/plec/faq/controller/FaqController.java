package com.acorn2.plec.faq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@Api("FaqController")
@RequestMapping("/api/faq")
public class FaqController {
	private final Logger logger = LoggerFactory.getLogger(getClass());


	@Autowired private FaqService service;
	//목록은 엑셀로 받아보기 아파치poi이용해서 엑셀만들어서 다운로드하게끔. db조회하고 엑셀만들고 다운로드.
	@ApiOperation(value="자주묻는질문 목록", notes = "모든 자주묻는질문의 목록을 가져온다.")
	@GetMapping("/faqlist")
	public ComResponseEntity<FaqReadListResDto> FaqList(
			@Parameter(hidden = true) FaqReadReqDto faqReadReqDto) {
		FaqReadListResDto faqReadListResDto = service.selectFaqList(faqReadReqDto);
		logger.debug("faqReadReqDto parameter : {}", faqReadReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(faqReadListResDto));
	}
	
	@ApiOperation(value="단일 자주묻는질문 상세", notes = "하나의 자주묻는질문의 상세 정보를 가져온다.")
	@GetMapping("/{faqNum}/faqOne")
	public ComResponseEntity<FaqDto> FaqOne(@PathVariable Integer faqNum){
		FaqDto dtoOne = service.FaqOne(faqNum);
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));
	}
	
	@ApiOperation(value="자주묻는질문 등록", notes = "자주묻는질문을 등록한다.")
	@Transactional
	@PostMapping("/faqinsert")
	public ComResponseEntity<Void> FaqInsert(@Valid @RequestBody FaqCreateReqDto faqCreateReqDto, HttpServletRequest request){
		service.FaqInsert(faqCreateReqDto, request);
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="자주묻는질문 수정", notes = "자주묻는질문을 수정한다.")
	@Transactional
	@PutMapping("/{faqNum}/update")
	public ComResponseEntity<Void> FaqUpdate(@Valid @RequestBody FaqUpdateReqDto faqUpdateReqDto, HttpServletRequest request){
		service.FaqUpdate(faqUpdateReqDto, request);
		return new ComResponseEntity<Void>();		
	}
	
	@ApiOperation(value="자주묻는질문 삭제", notes = "자주묻는질문의 delete_YN_code를 'Y'로 수정한다.")
	@Transactional
	@PutMapping("/{faqNum}/delete")
	public ComResponseEntity<Void> FaqDelete(@PathVariable("faqNum") Integer faqNum){
		service.FaqDelete(faqNum);
		return new ComResponseEntity<Void>();
	}
	
}