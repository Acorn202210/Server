package com.acorn2.FinalProject.notice.service;


import com.acorn2.FinalProject.notice.dto.req.NoticeCreateReqDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeReadReqDto;
import com.acorn2.FinalProject.notice.dto.req.NoticeUpdateReqDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadDetailResDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadListResDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadResDto;


public interface NoticeService {
//	public ResponseEntity<Map<String, Object>> getList(int pageNum, String keyword, String condition);
//	public Map<String, String> saveContent(NoticeResDto dto);
//	public Map<String, String> updateContent(NoticeReq dto);
//	public Map<String, String> deleteContent(int num);
//	public Map<String, Object> getData(int num);
//	public Map<String, Object> getDetail(int num, String keyword, String condition);
	
	NoticeReadListResDto selectNoticeList(NoticeReadReqDto noticeReadReqDto);
	NoticeReadDetailResDto selectNoticeOne(NoticeReadReqDto noticeReadReqDto);
	void insertNotice(NoticeCreateReqDto noticeCreateReqDto);
	void updateNotice(NoticeUpdateReqDto noticeUpdateReqDto);
	void deleteNotice(Integer notiNum);

}
