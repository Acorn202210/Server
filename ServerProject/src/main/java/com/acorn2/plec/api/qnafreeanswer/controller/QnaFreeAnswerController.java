package com.acorn2.plec.api.qnafreeanswer.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.plec.api.qnafreeanswer.dto.req.QnaFreeAnswerCreateReqDto;
import com.acorn2.plec.api.qnafreeanswer.dto.req.QnaFreeAnswerReadReqDto;
import com.acorn2.plec.api.qnafreeanswer.dto.req.QnaFreeAnswerUpdateReqDto;
import com.acorn2.plec.api.qnafreeanswer.dto.res.QnaFreeAnswerReadDetailResDto;
import com.acorn2.plec.api.qnafreeanswer.dto.res.QnaFreeAnswerReadListResDto;
import com.acorn2.plec.api.qnafreeanswer.service.QnaFreeAnswerService;
import com.acorn2.plec.common.ComResponseEntity;
import com.acorn2.plec.common.dto.ComResponseDto;
import com.acorn2.plec.common.utils.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@Api(value = "QnaFreeAnswerController")
@RequestMapping("/api/qna-free-answer")
public class QnaFreeAnswerController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private QnaFreeAnswerService service;

	@ApiOperation(value = "자유게시판 댓글 목록", notes = "모든 자주묻는질문의 목록을 가져온다.")
	@GetMapping("list")
	public ComResponseEntity<QnaFreeAnswerReadListResDto> getQnaFreeAnswerList(@Parameter(hidden = true) QnaFreeAnswerReadReqDto qnaFreeAnswerReadReqDto) {
		QnaFreeAnswerReadListResDto qnaFreeAnswerReadListResDto = service.selectQnaFreeAnswerList(qnaFreeAnswerReadReqDto);
		logger.debug("qnaFreeAnswerReadReqDto parameter : {}", qnaFreeAnswerReadReqDto.getFreeCommentNum());
		return new ComResponseEntity<>(new ComResponseDto<>(qnaFreeAnswerReadListResDto));
	}

	@ApiOperation(value = "단일 자유게시판 댓글 상세", notes = "하나의 자유게시판 댓글의 상세 정보를 가져온다.")
	@GetMapping(value = "/{freeCommentNum}")
	public ComResponseEntity<QnaFreeAnswerReadDetailResDto> getQnaFreeAnswer(@Parameter(hidden = true)QnaFreeAnswerReadReqDto qnaFreeAnswerReadReqDto) {
		QnaFreeAnswerReadDetailResDto qnaFreeAnswerReadResDto = service.selectQnaFreeAnswerOne(qnaFreeAnswerReadReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(qnaFreeAnswerReadResDto));
	}

	@ApiOperation(value = "자유게시판 댓글 등록", notes = "자유게시판 댓글을 등록한다.")
	@Transactional
	@PostMapping
	public ComResponseEntity<Void> insertQnaFreeAnswer(@RequestBody QnaFreeAnswerCreateReqDto qnaFreeAnswerCreateReqDto) {
		service.insertQnaFreeAnswer(qnaFreeAnswerCreateReqDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}

	@ApiOperation(value = "자유게시판 댓글 수정", notes = "자유게시판 댓글을 수정한다.")
	@Transactional
	@PutMapping(value = "/{freeCommentNum}/update")
	public ComResponseEntity<Void> updateQnaFreeAnswer(@RequestBody QnaFreeAnswerUpdateReqDto qnaFreeAnswerUpdateReqDto, String id) {
		service.updateQnaFreeAnswer(qnaFreeAnswerUpdateReqDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}

	@ApiOperation(value = "자유게시판 댓글 삭제", notes = "자유게시판 댓글의 delete_YN_code를 'Y'로 수정한다.")
	@Transactional
	@PutMapping(value = "/{freeCommentNum}/delete")
	public ComResponseEntity<Void> deleteQnaFreeAnswer(@PathVariable("freeCommentNum") Integer freeCommentNum) {
		service.deleteUpdateQnaFreeAnswer(freeCommentNum);
		return new ComResponseEntity<Void>();
	}
}
