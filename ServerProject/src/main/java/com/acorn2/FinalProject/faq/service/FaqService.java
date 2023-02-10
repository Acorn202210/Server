package com.acorn2.FinalProject.faq.service;

import java.util.Map;

import com.acorn2.FinalProject.faq.dto.FaqReq;
import com.acorn2.FinalProject.faq.dto.FaqRes;

public interface FaqService {
	public Map<String, String> saveContent(FaqRes dto);
	public Map<String, String> updateContent(FaqReq dto);
	public Map<String, String> deleteContent(int num);
	public Map<String, Object> getData(int num);
	public Map<String, Object> list(int pageNum, String question, String content);
	
}
