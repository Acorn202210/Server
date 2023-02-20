package com.acorn2.FinalProject.notice.service;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.FinalProject.notice.dao.NoticeDao;
import com.acorn2.FinalProject.notice.dto.NoticeDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeCreateReqDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeReadReqDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeUpdateReqDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadDetailResDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadListResDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadResDto;
import com.acorn2.FinalProject.notice.exception.NoticeNotFoundException;


@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public NoticeReadListResDto selectNoticeList(NoticeReadReqDto noticeReadReqDto) {		
		if(noticeReadReqDto.getKeyword() != null){
			if(noticeReadReqDto.getCondition().equals("title_content")){
				noticeReadReqDto.setTitle(noticeReadReqDto.getKeyword());
				noticeReadReqDto.setContent(noticeReadReqDto.getKeyword());
			}else if(noticeReadReqDto.getCondition().equals("title")){ 
				noticeReadReqDto.setTitle(noticeReadReqDto.getKeyword());
			}else if(noticeReadReqDto.getCondition().equals("content")){ 
				noticeReadReqDto.setContent(noticeReadReqDto.getKeyword());
			}
		}
		
		Integer totalCount = noticeDao.selectNoticeCount(noticeReadReqDto);
		List<NoticeReadResDto> noticeReadResDtoList = noticeDao.selectNoticeList(noticeReadReqDto);
		NoticeReadListResDto noticeReadListResDto = new NoticeReadListResDto(totalCount, noticeReadReqDto);
		noticeReadListResDto.setData(noticeReadResDtoList);
		return noticeReadListResDto;
	}
	

	@Override
	public NoticeReadDetailResDto selectNoticeOne(NoticeReadReqDto noticeReadReqDto) {
		if(noticeDao.selectNotice(noticeReadReqDto)== null) {
			throw new NoticeNotFoundException("공지사항이 없습니다.");
		}
		return noticeDao.selectNotice(noticeReadReqDto);
	}

	@Transactional
	@Override
	public void insertNotice(NoticeCreateReqDto noticeCreateReqDto) {
		NoticeDto dto = new NoticeDto();
		dto.setTitle(noticeCreateReqDto.getTitle());
		dto.setContent(noticeCreateReqDto.getContent());
		dto.setNotiWriter("관리자1");
		noticeDao.insertNotice(dto);
	}

	@Transactional
	@Override
	public void updateNotice(NoticeUpdateReqDto noticeUpdateReqDto) {
		NoticeDto dto = new NoticeDto();
		dto.setNotiNum(noticeUpdateReqDto.getNotiNum());
		dto.setTitle(noticeUpdateReqDto.getTitle());
		dto.setContent(noticeUpdateReqDto.getContent());
		dto.setUpdateId("관리자2");
		noticeDao.updateNotice(dto);
	}

	@Transactional
	@Override
	public void deleteUpdateNotice(Integer notiNum) {
		noticeDao.deleteUpdateNotice(notiNum);
	}
	
	@Transactional
	@Override
	public void deleteNotice() {
		noticeDao.deleteNotice();
	}

}
