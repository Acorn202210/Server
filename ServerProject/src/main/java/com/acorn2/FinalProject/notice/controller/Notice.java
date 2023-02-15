package com.acorn2.FinalProject.notice.controller;



import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeReadReqDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadListResDto;
import com.acorn2.FinalProject.notice.service.NoticeService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Api("NoticeController")
@RequestMapping("/api/notice")
public class Notice {
	@Autowired private NoticeService service;
	
	@GetMapping
	public com.acorn2.FinalProject.common.dto.ComResponseEntity<NoticeReadListResDto> getCdList(
			@Parameter(hidden = true) NoticeReadReqDto noticeReadReqDto) {
		NoticeReadListResDto noticeReadListResDto = service.selectNoticeList(noticeReadReqDto);
		return new com.acorn2.FinalProject.common.dto.ComResponseEntity<>(new ComResponseDto<>(noticeReadListResDto));
	}
	
//	
//	@ApiOperation(value="공지 사항 상세", notes = "공지사항 상세 (검색에 대한 값도 포함되어 있음)")
//	@GetMapping("/{num}")
//	public Map<String, Object> detail(@PathVariable int num, @RequestParam(value = "keyword", required = false)String keyword,
//			@RequestParam(value = "condition", required = false)String condition) {
//		
//		NoticeDto dto = (NoticeDto) service.getData(num).get("dto");
//		
//		if(dto == null) {
//			throw new NoticeNotFoundException(String.format("%d은 등록되어 있지 않은 num입니다!", num));
//		}
//		
//		return service.getDetail(num, keyword, condition);
//	}
//	
//	@ApiOperation(value="공지 사항 등록", notes = "공지사항을 입력 받아 등록한다.")
//	@PostMapping("/insert")
//	public Map<String, String> insert(@RequestBody NoticeRes noticeRes) {
//		return service.saveContent(noticeRes);
//	}
//	
//	@ApiOperation(value="공지 사항 수정", notes = "공지사항을 입력 받아 등록한다.")
//	@PutMapping("/{num}/update")
//	public Map<String, String> update(@PathVariable int num, @RequestBody NoticeRes noticeRes){
//		
//		NoticeDto dto = (NoticeDto) service.getData(num).get("dto");
//		
//		if(dto == null) {
//			throw new NoticeNotFoundException(String.format("%d은 등록되어 있지 않은 num입니다!", num));
//		}
//		
//		NoticeReq notice = new NoticeReq();
//		notice.setNum(num);
//		notice.setTitle(noticeRes.getTitle());
//		notice.setContent(noticeRes.getContent());
//		
//		return service.updateContent(notice);
//	}
//	
//	@ApiOperation(value="공지 사항 업데이트 전 상세", notes = "공지사항의 업데이트 전 그 상세 데이터 내용을 가져온다.")
//	@GetMapping("/{num}/update")
//	public Map<String, Object> update(@PathVariable int num){
//		NoticeDto dto = (NoticeDto) service.getData(num).get("dto");
//		
//		if(dto == null) {
//			throw new NoticeNotFoundException(String.format("%d은 등록되어 있지 않은 num입니다!", num));
//		}
//		return service.getData(num);
//	}
//	
//	@ApiOperation(value="공지 사항 삭제", notes = "공지사항의 데이터를 삭제한다.")
//	@DeleteMapping("/{num}/delete")
//	public Map<String, String> delete(@PathVariable int num){
//		NoticeDto dto = (NoticeDto) service.getData(num).get("dto");
//		
//		if(dto == null) {
//			throw new NoticeNotFoundException(String.format("%d은 등록되어 있지 않은 num입니다!", num));
//		}
//		
//		return service.deleteContent(num);
//	}
}