package com.acorn2.FinalProject.notice.controller;



import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.notice.dto.req.NoticeCreateReqDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeReadReqDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeUpdateReqDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadDetailResDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadListResDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadResDto;
import com.acorn2.FinalProject.notice.service.NoticeService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Api("Notice")
@RequestMapping("/api/notice")
public class Notice {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired private NoticeService service;

	@ApiOperation(value="공지사항 목록", notes = "모든 공지사항의 목록을 가져온다.")
	@Cacheable(cacheNames = "notice")
	@GetMapping
	public ComResponseEntity<NoticeReadListResDto> getNoticeList(@Parameter(hidden = true) NoticeReadReqDto noticeReadReqDto) {
		NoticeReadListResDto noticeReadListResDto = service.selectNoticeList(noticeReadReqDto);
		logger.debug("noticeReadReqDto parameter:{}", noticeReadReqDto.getNotiNum());
		return new ComResponseEntity<>(new ComResponseDto<>(noticeReadListResDto));
	}
	
	@ApiOperation(value="단일 공지사항 상세", notes = "하나의 공지사항의 상세 정보를 가져온다.")
	@GetMapping(value = "/{notiNum}")
	public ComResponseEntity<NoticeReadDetailResDto> getNotice(@Parameter(hidden = true) NoticeReadReqDto noticeReadReqDto) {
		NoticeReadDetailResDto noticeReadResDto = service.selectNoticeOne(noticeReadReqDto);
		return new ComResponseEntity<>(new ComResponseDto<>(noticeReadResDto));
	}
	
	@ApiOperation(value="공지사항 등록", notes = "공지사항을 등록한다.")
	@PostMapping
	public ComResponseEntity<Void> insertNotice(@RequestBody NoticeCreateReqDto noticeCreateReqDto){
		service.insertNotice(noticeCreateReqDto);
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="공지사항 수정", notes = "공지사항을 수정한다.")
	@PutMapping(value="/{notiNum}")
	public ComResponseEntity<Void> updateNotice(@RequestBody NoticeUpdateReqDto noticeUpdateReqDto){
		service.updateNotice(noticeUpdateReqDto);
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="공지사항 삭제", notes = "공지사항의 delete_YN_code를 'Y'로 수정한다.")
	@PutMapping(value="/{notiNum}/delete")
	public ComResponseEntity<Void> deleteNotice(@PathVariable("notiNum") Integer notiNum){
		service.deleteUpdateNotice(notiNum);
		return new ComResponseEntity<Void>();
	}
}