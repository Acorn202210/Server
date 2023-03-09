package com.acorn2.plec.api.qnafree.controller;

import javax.servlet.http.HttpServletRequest;

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
	@ApiOperation(value = "자유게시판 목록보기", notes = "자유게시판 목록을 출력한다.")
	@GetMapping("/list")
	public ComResponseEntity<QnaFreeReadListResDto> getCdList(
			@Parameter(hidden = true) QnaFreeReadReqDto qnaFreeReqDto){
		QnaFreeReadListResDto qnaFreeReadListResDto = service.selectQnaFreeList(qnaFreeReqDto);
		logger.debug("qnaFreeReqDto parameter : {}", qnaFreeReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(qnaFreeReadListResDto));
	}
	
	//상세보기
	@ApiOperation(value = "자유게시판 상세보기", notes = "자유게시판 글 한개 자세히 보기")
	@GetMapping(value = "/{freeQuestionNum}")
	public ComResponseEntity<QnaFreeReadDetailResDto> getData(@Parameter(hidden = true) QnaFreeReadReqDto qnaFreeReadReqDto) {
		QnaFreeReadDetailResDto qnaFreeReadDetailResDto=service.selectOne(qnaFreeReadReqDto);
		return new ComResponseEntity<QnaFreeReadDetailResDto>(new ComResponseDto<>(qnaFreeReadDetailResDto));
	}
	
	//문의 등록
	@ApiOperation(value = "자유게시판 등록", notes = "자유게시판을 등록한다.")
	@Transactional
	@PostMapping("/insert")
	public ComResponseEntity<Void> QnaFreeInsert(@RequestBody QnaFreeCreateReqDto qnaFreeCreateReqDto, HttpServletRequest request){
		service.QnaFreeInsert(qnaFreeCreateReqDto, request);
		return new ComResponseEntity<Void>();
	}
	
	//수정
	@ApiOperation(value = "자유게시판 수정", notes = "자유게시판을 수정한다.")
	@Transactional
	@PutMapping("/{freeQuestionNum}/update")
	public ComResponseEntity<Void> QnaFreeUpdate(@RequestBody QnaFreeUpdateReqDto qnaFreeUpdateReqDto, HttpServletRequest request){
		service.QnaFreeUpdate(qnaFreeUpdateReqDto, request);
		return new ComResponseEntity<Void>();
	}
	
	//삭제(deleted Y) 처리
	@ApiOperation(value = "자유게시판 삭제처리", notes = "자유게시판의 DELETE_YN_CODE를 Y로 바꾼다.")
	@Transactional
	@PutMapping("/{freeQuestionNum}/delete")
	public ComResponseEntity<Void> QnaFreeDelete(@PathVariable("freeQuestionNum") Integer freeQuestionNum){
		service.QnaFreeUpdateDelete(freeQuestionNum);
		return new ComResponseEntity<Void>();
	}
	
}
