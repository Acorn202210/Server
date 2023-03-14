package com.acorn2.plec.api.notice.service;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.plec.api.notice.dao.NoticeDao;
import com.acorn2.plec.api.notice.dto.NoticeDto;
import com.acorn2.plec.api.notice.dto.req.NoticeCreateReqDto;
import com.acorn2.plec.api.notice.dto.req.NoticeReadReqDto;
import com.acorn2.plec.api.notice.dto.req.NoticeUpdateReqDto;
import com.acorn2.plec.api.notice.dto.res.NoticeReadDetailResDto;
import com.acorn2.plec.api.notice.dto.res.NoticeReadListResDto;
import com.acorn2.plec.api.notice.dto.res.NoticeReadResDto;
import com.acorn2.plec.api.notice.exception.NoticeNotFoundException;




@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public NoticeReadListResDto selectNoticeList(NoticeReadReqDto noticeReadReqDto) {		
		if(noticeReadReqDto.getKeyword() != null){
			String condition = noticeReadReqDto.getCondition();
			String keyword = noticeReadReqDto.getKeyword();
			if("title_content".equals(condition)){
				noticeReadReqDto.setTitle(keyword);
				noticeReadReqDto.setContent(noticeReadReqDto.getKeyword());
			}else if("title".equals(condition)){ 
				noticeReadReqDto.setTitle(keyword);
			}else if("content".equals(condition)){ 
				noticeReadReqDto.setContent(keyword);
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
		
		if(noticeReadReqDto.getKeyword() != null){
			String condition = noticeReadReqDto.getCondition();
			String keyword = noticeReadReqDto.getKeyword();
			if("title_content".equals(condition)){
				noticeReadReqDto.setTitle(keyword);
				noticeReadReqDto.setContent(noticeReadReqDto.getKeyword());
			}else if("title".equals(condition)){ 
				noticeReadReqDto.setTitle(keyword);
			}else if("content".equals(condition)){ 
				noticeReadReqDto.setContent(keyword);
			}
		}
		
		noticeDao.addViewCount(noticeReadReqDto.getNotiNum());
		return noticeDao.selectNotice(noticeReadReqDto);
	}

	@Transactional
	@Override
	public void insertNotice(NoticeCreateReqDto noticeCreateReqDto, String id) {
		
		NoticeDto dto = new NoticeDto();
		dto.setTitle(noticeCreateReqDto.getTitle());
		dto.setContent(noticeCreateReqDto.getContent());
		dto.setNotiWriter(id);
		noticeDao.insertNotice(dto);
	}

	@Transactional
	@Override
	public void updateNotice(NoticeUpdateReqDto noticeUpdateReqDto, String id) {
	
		NoticeDto dto = new NoticeDto();
		dto.setNotiNum(noticeUpdateReqDto.getNotiNum());
		dto.setTitle(noticeUpdateReqDto.getTitle());
		dto.setContent(noticeUpdateReqDto.getContent());
		dto.setUpdateId(id);
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
