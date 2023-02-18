package com.acorn2.FinalProject.faq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.acorn2.FinalProject.faq.dto.FaqSampleDto;
//import com.acorn2.FinalProject.faq.dto.FaqSampleListDto;
//import com.acorn2.FinalProject.faq.service.FaqSampleSvc;

import io.swagger.v3.oas.annotations.Parameter;

/**
 * @systemName : Project
 * @programName : FaqCtrl
 * @author : 이성진
 * @createDate : 2023. 2. 15.
 * @description :
 */
//@RestController
//@RequestMapping("/faqSample")
//public class FaqSampleCtrl {
//	@Autowired
//	private FaqSampleSvc faqSvc;
//
//	@GetMapping
//	public ResponseEntity<FaqSampleListDto> getFaqList(@Parameter @Validated(InsertFaq.class) FaqSampleDto faqDto) {
//		FaqSampleListDto faqSampleListDto = faqSvc.getFaqList(faqDto);
//		return new ResponseEntity<>(faqSampleListDto, HttpStatus.OK);
//	}
//
//	@GetMapping(value = "/{faqId}")
//	public ResponseEntity<FaqSampleDto> getFaq(@PathVariable(value = "faqId", required = true) Integer faqId) {
//		FaqSampleDto faqSampleDto = faqSvc.getFaq(faqId);
//		return new ResponseEntity<>(faqSampleDto, HttpStatus.OK);
//	}
//
//	@PostMapping
//	public ResponseEntity<Void> insertFaq(@Parameter @Validated(InsertFaq.class) FaqSampleDto faqDto) {
//		faqSvc.insertFaq(faqDto);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//
//}

