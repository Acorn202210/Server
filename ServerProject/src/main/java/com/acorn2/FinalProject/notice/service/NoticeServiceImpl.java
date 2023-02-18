package com.acorn2.FinalProject.notice.service;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acorn2.FinalProject.notice.dao.NoticeDao;
import com.acorn2.FinalProject.notice.dto.NoticeDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeCreateReqDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeReadReqDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeUpdateReqDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadDetailResDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadListResDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadResDto;


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
		return noticeDao.selectNotice(noticeReadReqDto);
	}

	@Override
	public void insertNotice(NoticeCreateReqDto noticeCreateReqDto) {
		NoticeDto dto = new NoticeDto();
		dto.setTitle(noticeCreateReqDto.getTitle());
		dto.setContent(noticeCreateReqDto.getContent());
		dto.setNoti_writer("관리자1");
		noticeDao.insertNotice(dto);
	}


	@Override
	public void updateNotice(NoticeUpdateReqDto noticeUpdateReqDto) {
		NoticeDto dto = new NoticeDto();
		dto.setNoti_num(noticeUpdateReqDto.getNoti_num());
		dto.setTitle(noticeUpdateReqDto.getTitle());
		dto.setContent(noticeUpdateReqDto.getContent());
		dto.setUpdate_id("관리자2");
		noticeDao.updateNotice(dto);
	}


	@Override
	public void deleteNotice(Integer noti_num) {
		noticeDao.deleteNotice(noti_num);
	}

	
//	@Override
//	public ResponseEntity<Map<String, Object>> getList(int pageNum, String keyword, String condition) {
//		final int PAGE_ROW_COUNT=5;
//		final int PAGE_DISPLAY_COUNT=5;
//		
//		int num=1;
//		String strPageNum=Integer.toString(pageNum);
//		if(strPageNum != null){
//			num=Integer.parseInt(strPageNum);
//		}
//		
//		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
//		int endRowNum=pageNum*PAGE_ROW_COUNT;
//	
//		if(keyword==null){
//			keyword="";
//			condition=""; 
//		}
//
//		String encodedK=URLEncoder.encode(keyword);
//			
//		NoticeDto dto=new NoticeDto();
//		dto.setStartRowNum(startRowNum);
//		dto.setEndRowNum(endRowNum);
//
//		if(!keyword.equals("")){
//			if(condition.equals("title_content")){
//				
//				dto.setTitle(keyword);
//				dto.setContent(keyword);
//			}else if(condition.equals("title")){ 
//				dto.setTitle(keyword);
//			}
//		}
//		
//		List<NoticeDto> list=noticeDao.getList(dto);
//		
//		int totalRow=noticeDao.getCount(dto);
//		
//		
//		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
//		
//		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
//		
//
//		
//		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
//		
//		if(endPageNum > totalPageCount){
//			endPageNum=totalPageCount; 
//		}
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("pageNum", pageNum);
//		map.put("startPageNum", startPageNum);
//		map.put("endPageNum", endPageNum);
//		map.put("condition", condition);
//		map.put("keyword", keyword);
//		map.put("encodedK", encodedK);
//		map.put("totalPageCount", totalPageCount);
//		map.put("totalRow", totalRow);
//		map.put("list", list);
//		
//		return ResponseEntity.ok().body(map);
//	}
//
//	@Override
//	public Map<String, Object> getDetail(int num, String keyword, String condition) {
//				
//		noticeDao.addViewCount(num);
//		
//		if(keyword==null){
//			
//			keyword="";
//			condition=""; 
//		}
//		
//		NoticeDto dto=new NoticeDto();
//		
//		dto.setNum(num);
//		
//		if(!keyword.equals("")){
//			if(condition.equals("title_content")){
//				
//				dto.setTitle(keyword);
//				dto.setContent(keyword);			
//			}else if(condition.equals("title")){ 
//				dto.setTitle(keyword);	
//			}
//		}
//		
//		NoticeDto resultDto=noticeDao.getData(dto);
//
//		String encodedK=URLEncoder.encode(keyword);
//		
//		final int PAGE_ROW_COUNT=10;
//
//		int pageNum=1;
//
//		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
//
//		int endRowNum=pageNum*PAGE_ROW_COUNT;
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("condition", condition);
//		map.put("keyword", keyword);
//		map.put("encodedK", encodedK);
//		map.put("dto", resultDto);
//
//		return map;
//		
//	}
//
//	@Override
//	public Map<String, String> saveContent(NoticeReadResDto dto) {
//		noticeDao.insert(dto);
//
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("isSuccess","success");
//				
//		return map;
//		
//	}
//
//	@Override
//	public Map<String, String> updateContent(NoticeReadReqDto dto) {
//		noticeDao.update(dto);
//		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("isSuccess","success");
//				
//		return map;
//	}
//
//	@Override
//	public Map<String, String> deleteContent(int num) {
//		noticeDao.delete(num);
//		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("isSuccess","success");
//				
//		return map;
//		
//	}
//
//	@Override
//	public Map<String, Object> getData(int num) {
//		NoticeDto dto = noticeDao.getData(num);
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//				
//		map.put("isSuccess","success");
//		map.put("dto", dto);
//		
//		return map;
//	}

}
