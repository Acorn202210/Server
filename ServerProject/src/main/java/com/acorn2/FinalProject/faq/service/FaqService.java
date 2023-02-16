package com.acorn2.FinalProject.faq.service;

import com.acorn2.FinalProject.faq.dto.req.FaqReadReqDto;
import com.acorn2.FinalProject.faq.dto.res.FaqReadListResDto;

public interface FaqService {
//	public Map<String, String> saveContent(FaqRes dto);
//	public Map<String, String> updateContent(FaqReadReqDto dto);
//	public Map<String, String> deleteContent(int num);
//	public Map<String, Object> getData(int num);
//	public Map<String, Object> list(int pageNum, String question, String content);
	
	FaqReadListResDto selectFaqList(FaqReadReqDto faqReadReq);
}
