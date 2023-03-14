package com.acorn2.plec.api.qnafree.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.plec.api.qnafree.dto.req.QnaFreeCreateReqDto;
import com.acorn2.plec.api.qnafree.dto.req.QnaFreeReadReqDto;
import com.acorn2.plec.api.qnafree.dto.req.QnaFreeUpdateReqDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadDetailResDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadListResDto;
import com.acorn2.plec.api.qnafree.service.QnaFreeService;
import com.acorn2.plec.common.ComResponseEntity;
import com.acorn2.plec.common.dto.ComResponseDto;
import com.acorn2.plec.common.utils.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@Api(value = "QnaFreeController")
@RequestMapping("/api/qna-free")
public class QnaFreeController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired private QnaFreeService service;
		
	@ApiResponse(responseCode = "200", description = "성공!")
	
	@Cacheable(cacheNames = "qnaFree")
	@ApiOperation(value = "자유게시판 목록", notes = "자유게시판 목록을 가져온다.")
	@GetMapping("/list")
	public ComResponseEntity<QnaFreeReadListResDto> getCdList(
			@Parameter(hidden = true) QnaFreeReadReqDto qnaFreeReqDto){
		QnaFreeReadListResDto qnaFreeReadListResDto = service.selectQnaFreeList(qnaFreeReqDto);
		logger.debug("qnaFreeReqDto parameter : {}", qnaFreeReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(qnaFreeReadListResDto));
	}
	
	@ApiOperation(value = "단일 자유게시판 상세", notes = "하나의 자유게시판 상세 정보를 가져온다.")
	@GetMapping(value = "/{freeQuestionNum}")
	public ComResponseEntity<QnaFreeReadDetailResDto> getData(@Parameter(hidden = true) QnaFreeReadReqDto qnaFreeReadReqDto) {
		QnaFreeReadDetailResDto qnaFreeReadDetailResDto=service.selectQnaFreeOne(qnaFreeReadReqDto);
		return new ComResponseEntity<QnaFreeReadDetailResDto>(new ComResponseDto<>(qnaFreeReadDetailResDto));
	}
	
	@ApiOperation(value = "자유게시판 등록", notes = "자유게시판을 등록한다.")
	@Transactional
	@PostMapping("/insert")
	public ComResponseEntity<Void> QnaFreeInsert(@RequestBody QnaFreeCreateReqDto qnaFreeCreateReqDto, String id){
		service.insertQnaFree(qnaFreeCreateReqDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value = "자유게시판 수정", notes = "자유게시판을 수정한다.")
	@Transactional
	@PutMapping("/{freeQuestionNum}/update")
	public ComResponseEntity<Void> QnaFreeUpdate(@RequestBody QnaFreeUpdateReqDto qnaFreeUpdateReqDto){
		service.updateQnaFree(qnaFreeUpdateReqDto);
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value = "자유게시판 삭제", notes = "자유게시판의 DELETE_YN_CODE를 'Y'로 수정한다.")
	@Transactional
	@PutMapping("/{freeQuestionNum}/delete")
	public ComResponseEntity<Void> QnaFreeDelete(@PathVariable("freeQuestionNum") Integer freeQuestionNum){
		service.deleteUpdateQnaFree(freeQuestionNum);
		return new ComResponseEntity<Void>();
	}
	
}
