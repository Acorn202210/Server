package com.acorn2.plec.api.qnaboard.controller;

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

import com.acorn2.plec.api.qnaboard.dto.QnaBoardAnswerDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardAnswerCreateReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardAnswerReadReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardAnswerUpdateReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardReadReqDto;
import com.acorn2.plec.api.qnaboard.dto.res.QnaBoardAnswerReadListResDto;
import com.acorn2.plec.api.qnaboard.dto.res.QnaBoardReadListResDto;
import com.acorn2.plec.api.qnaboard.service.QnaBoardService;
import com.acorn2.plec.common.ComResponseEntity;
import com.acorn2.plec.common.dto.ComResponseDto;
import com.acorn2.plec.common.utils.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@Api(value = "QnaBoardAnswerController")
@RequestMapping("/api/qna-answer")
public class QnaBoardAnswerController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired private QnaBoardService service;
	
	@ApiResponse(responseCode = "200", description = "성공!")
	
	//1:1문의 답변 목록
	@ApiOperation(value = "1:1문의 답변 보기", notes = "1:1문의 답변 목록을 출력한다.(boardCommentRefGroup 글 번호 입력 필요)")
	@GetMapping("/list")
	public ComResponseEntity<QnaBoardAnswerReadListResDto> getCdList(
			@Parameter(hidden = true) QnaBoardAnswerReadReqDto qnaAnswerReqDto){
		QnaBoardAnswerReadListResDto qnaAnswerReadListResDto = service.qnaAnswerList(qnaAnswerReqDto);
		logger.debug("qnaBoardAnswerReqDto parameter : {}", qnaAnswerReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(qnaAnswerReadListResDto));
	}	
	
	//1:1문의 답변보기 (1개)
	@ApiOperation(value = "1:1문의 답변(1개)", notes = "1:1문의 답변 한개 보기")
	@GetMapping("/{boardCommentNum}")
	public ComResponseEntity<QnaBoardAnswerDto> getAnswerData(@PathVariable int boardCommentNum) {
		QnaBoardAnswerDto qnaBoardReadAnswerResDto=service.selectComment(boardCommentNum);
		return new ComResponseEntity<>(new ComResponseDto<>(qnaBoardReadAnswerResDto));
	}
	
	//1:1문의 답변 등록
	@ApiOperation(value = "1:1문의 답변 등록", notes = "1:1문의 답변 등록 (boardCommentRefGroup, content만 작성)")
	@Transactional
	@PostMapping("/insert")
	public void qnaAnswerInsert(@RequestBody QnaBoardAnswerCreateReqDto qnaAnswerCreateReqDto){
		service.saveComment(qnaAnswerCreateReqDto, SessionUtils.getUserId());
		
	}	
	
	//1:1문의 답변 수정
	@ApiOperation(value = "1:1 문의 답변 수정", notes = "1:1문의 답변을 수정한다.")
	@Transactional
	@PutMapping("/{boardCommentNum}/update")
	public ComResponseEntity<Void> qnaAnswerUpdate(@RequestBody QnaBoardAnswerUpdateReqDto answerUpdateReqDto){
		service.updateComment(answerUpdateReqDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}
	
	//1:1문의 답변 삭제(deleted Y)
	@ApiOperation(value = "1:1 문의 답변 삭제처리", notes = "1:1문의 답변의 DELETE_YN_CODE를 Y로 바꾼다.")
	@Transactional
	@PutMapping("/{boardCommentNum}/delete")
	public ComResponseEntity<Void> qnaAnswerDelete(@PathVariable("boardCommentNum") Integer boardCommentNum){
		service.updateDeleteComment(boardCommentNum);		
		return new ComResponseEntity<Void>();
	}
		
	
}
