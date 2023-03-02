package com.acorn2.plec.qnaboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.plec.common.ComResponseEntity;
import com.acorn2.plec.common.dto.ComResponseDto;
import com.acorn2.plec.qnaboard.dto.QnaBoardAnswerDto;
import com.acorn2.plec.qnaboard.dto.req.QnaBoardCreateReqDto;
import com.acorn2.plec.qnaboard.dto.req.QnaBoardReadReqDto;
import com.acorn2.plec.qnaboard.dto.req.QnaBoardUpdateReqDto;
import com.acorn2.plec.qnaboard.dto.res.QnaBoardReadDetailResDto;
import com.acorn2.plec.qnaboard.dto.res.QnaBoardReadListResDto;
import com.acorn2.plec.qnaboard.service.QnaBoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@Api(value = "QnaBoardController")
@RequestMapping("/api/qna_board")
public class QnaBoardController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired private QnaBoardService service;
		
	@ApiResponse(responseCode = "200", description = "성공!")
	
	@Cacheable(cacheNames = "qnaBoard")
	@ApiOperation(value = "1:1 문의 목록보기", notes = "1:1문의 목록을 출력한다.")
	@GetMapping("/list")
	public ComResponseEntity<QnaBoardReadListResDto> getCdList(
			@Parameter(hidden = true) QnaBoardReadReqDto qnaBoardReqDto){
		QnaBoardReadListResDto qnaBoardReadListResDto = service.selectQnaBoardList(qnaBoardReqDto);
		logger.debug("qnaBoardReqDto parameter : {}", qnaBoardReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(qnaBoardReadListResDto));
	}
	
	//상세보기
	@ApiOperation(value = "1:1문의 상세보기", notes = "1:1문의 글 한개 자세히 보기")
	@GetMapping(value = "/{boardQuestionNum}")
	public ComResponseEntity<QnaBoardReadDetailResDto> getData(@Parameter(hidden = true) QnaBoardReadReqDto qnaBoardReadReqDto) {
		QnaBoardReadDetailResDto qnaBoardReadDetailResDto=service.selectOne(qnaBoardReadReqDto);
		return new ComResponseEntity<QnaBoardReadDetailResDto>(new ComResponseDto<>(qnaBoardReadDetailResDto));
	}
	
	//문의 등록
	@ApiOperation(value = "1:1 문의 등록", notes = "1:1문의를 등록한다.")
	@PostMapping("/insert")
	public ComResponseEntity<Void> QnaBoardInsert(@RequestBody QnaBoardCreateReqDto qnaBoardCreateReqDto, HttpServletRequest request){
		service.QnaBoardInsert(qnaBoardCreateReqDto, request);
		return new ComResponseEntity<Void>();
	}
	
	//수정
	@ApiOperation(value = "1:1 문의 수정", notes = "1:1문의를 수정한다.")
	@PutMapping("/{boardQuestionNum}/update")
	public ComResponseEntity<Void> QnaBoardUpdate(@RequestBody QnaBoardUpdateReqDto qnaBoardUpdateReqDto, HttpServletRequest request){
		service.QnaBoardUpdate(qnaBoardUpdateReqDto, request);
		return new ComResponseEntity<Void>();
	}
	
	//삭제(deleted Y) 처리
	@ApiOperation(value = "1:1 문의 삭제처리", notes = "1:1문의의 DELETE_YN_CODE를 Y로 바꾼다.")
	@PutMapping("/{boardQuestionNum}/delete")
	public ComResponseEntity<Void> QnaBoardDelete(@PathVariable("boardQuestionNum") int boardQuestionNum){
		service.QnaBoardUpdateDelete(boardQuestionNum);
		return new ComResponseEntity<Void>();
	}
	
	//1:1문의 답변 출력
	@ApiOperation(value = "1:1문의 답변", notes = "1:1문의 답변 한개 보기")
	@GetMapping("/{refGroup}/answer")
	public ComResponseEntity<QnaBoardAnswerDto> getAnswerData(@PathVariable int refGroup) {
		QnaBoardAnswerDto qnaBoardReadAnswerResDto=service.selectComment(refGroup);
		return new ComResponseEntity<>(new ComResponseDto<>(qnaBoardReadAnswerResDto));
	}
	
	
	/*
	@GetMapping("/list")
	public ResponseEntity<List<QnaBoardDto>> list(@RequestParam(value = "pageNum", required = false)int pageNum,
			@RequestParam(value = "keyword", required = false)String keyword,
			@RequestParam(value = "condition", required = false)String condition){	
		return ResponseEntity.ok(service.getList(pageNum, keyword, condition));
	}
	
	//게시물 등록
	@ApiOperation(value = "1:1문의 등록", notes = "문의 등록하기")
	@PostMapping(value = "/insert")
	public Map<String, String> saveContent(@RequestBody QnaBoardRes qnaBoardRes){		
		return service.saveContent(qnaBoardRes);
	}
	
	
	@ApiOperation(value="1:1문의 상세", notes = "1:1문의 상세 (검색에 대한 값도 포함되어 있음)")
	@GetMapping("/{num}/detail")
	public Map<String, Object> detail(@PathVariable int num, 
			@RequestParam(value = "keyword", required = false)String keyword,
			@RequestParam(value = "condition", required = false)String condition) {

		return service.getDetail(num, keyword, condition);
	}	
	
	@ApiOperation(value="1:1문의 수정", notes = "1:1문의 수정")
	@PutMapping("/{num}/update")
	public Map<String, String> update(@PathVariable int num, @RequestParam(value = "title", required = false)String title,
			@RequestParam(value = "content", required = false)String content){

		QnaBoardReq qnaBoardRes = new QnaBoardReq();
		qnaBoardRes.setNum(num);
		qnaBoardRes.setTitle(title);
		qnaBoardRes.setContent(content);

		return service.updateContent(qnaBoardRes);
	}
	
	@ApiOperation(value="1:1문의 수정 전 상세", notes = "1:1문의 수정 전 상세")
	@GetMapping("/{num}/update")
	public Map<String, Object> update(@PathVariable int num){

		return service.getData(num);
	}
	
	@ApiOperation(value="1:1문의 삭제", notes = "1:1문의 삭제")
	@DeleteMapping("/{num}/delete")
	public Map<String, String> delete(@PathVariable int num){
		System.out.println(service.deleteContent(num));
				
		return service.deleteContent(num);
	}
	*/
}
