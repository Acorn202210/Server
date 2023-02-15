package com.acorn2.FinalProject.notice.service;


import com.acorn2.FinalProject.notice.dto.req.NoticeReadReqDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadListResDto;


public interface NoticeService {
//	public ResponseEntity<Map<String, Object>> getList(int pageNum, String keyword, String condition);
//	public Map<String, String> saveContent(NoticeResDto dto);
//	public Map<String, String> updateContent(NoticeReq dto);
//	public Map<String, String> deleteContent(int num);
//	public Map<String, Object> getData(int num);
//	public Map<String, Object> getDetail(int num, String keyword, String condition);
	
	NoticeReadListResDto selectNoticeList(NoticeReadReqDto noticeReadReq);
}
