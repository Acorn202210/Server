package com.acorn2.plec.api.faq.service;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.plec.api.faq.dto.FaqDto;
import com.acorn2.plec.api.faq.dto.req.FaqCreateReqDto;
import com.acorn2.plec.api.faq.dto.req.FaqReadReqDto;
import com.acorn2.plec.api.faq.dto.req.FaqUpdateReqDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadListResDto;


public interface FaqService {
	FaqReadListResDto selectFaqList(FaqReadReqDto faqReadReq);
	FaqDto FaqOne(int faqNum);
	
	void FaqInsert(FaqCreateReqDto faqCreateReqDto, HttpServletRequest request);
	
	void FaqUpdate(FaqUpdateReqDto faqUpdateReqDto, HttpServletRequest request);
	
	void FaqDelete(Integer faqNum);
	
	void deleteFaq();
}
