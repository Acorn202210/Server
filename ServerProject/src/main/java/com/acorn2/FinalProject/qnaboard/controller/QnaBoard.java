package com.acorn2.FinalProject.qnaboard.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.qnaboard.dto.req.QnaBoardCreateReqDto;
import com.acorn2.FinalProject.qnaboard.dto.req.QnaBoardReadReqDto;
import com.acorn2.FinalProject.qnaboard.dto.req.QnaBoardUpdateReqDto;
import com.acorn2.FinalProject.qnaboard.dto.res.QnaBoardReadListResDto;
//import com.acorn2.FinalProject.qnaboard.dto.QnaBoardRes;
import com.acorn2.FinalProject.qnaboard.service.QnaBoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@Api(value = "QnaBoardController")
@RequestMapping("/api/qna_board")
public class QnaBoard {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private QnaBoardService service;
	
	@ApiOperation(value = "QnaBoard")
	@ApiResponse(responseCode = "200", description = "성공!")
	
	@GetMapping("/list")
	public com.acorn2.FinalProject.common.dto.ComResponseEntity<QnaBoardReadListResDto> getCdList(
			@Parameter(hidden = true) QnaBoardReadReqDto qnaBoardReqDto){
		QnaBoardReadListResDto qnaBoardReadListResDto = service.selectQnaBoardList(qnaBoardReqDto);
		logger.debug("qnaBoardReqDto parameter : {}", qnaBoardReqDto);
		return new com.acorn2.FinalProject.common.dto.ComResponseEntity<>(new ComResponseDto<>(qnaBoardReadListResDto));
	}
	
	@PostMapping("/insert")
	public ComResponseEntity<Void> QnaBoardInsert(@Valid @RequestBody QnaBoardCreateReqDto qnaBoardCreateReqDto){
		service.QnaBoardInsert(qnaBoardCreateReqDto);
		return new ComResponseEntity<Void>();
	}
	
	//수정
	@PutMapping("/{board_question_num}/update")
	public ComResponseEntity<Void> QnaBoardUpdate(@RequestParam(value = "board_question_num", required = true) int board_question_num, 
											@Valid @RequestBody QnaBoardUpdateReqDto qnaBoardUpdateReqDto){
		service.QnaBoardUpdate(qnaBoardUpdateReqDto);
		return new ComResponseEntity<Void>();
	}
	
	//삭제(deleted N) 처리
//	@PutMapping("/{board_question_num}/delete")
//	public ComResponseEntity<Void> QnaBoardDelete(@RequestParam(value = "board_question_num", required = true) int board_question_num, 
//											@Valid @RequestBody QnaBoardUpdateReqDto qnaBoardUpdateReqDto){
//		service.QnaBoardUpdate(qnaBoardUpdateReqDto);
//		return new ComResponseEntity<Void>();
//	}	
	
	
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
