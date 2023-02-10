package com.acorn2.FinalProject.notice.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.FinalProject.notice.dto.NoticeDto;
import com.acorn2.FinalProject.notice.dto.NoticeReq;
import com.acorn2.FinalProject.notice.dto.NoticeRes;


public interface NoticeService {
	public Map<String, Object> getList(int pageNum, String keyword, String condition);
	public Map<String, String> saveContent(NoticeRes dto);
	public Map<String, String> updateContent(NoticeReq dto);
	public Map<String, String> deleteContent(int num);
	public Map<String, Object> getData(int num);
	public Map<String, Object> getDetail(int num, String keyword, String condition);
}
