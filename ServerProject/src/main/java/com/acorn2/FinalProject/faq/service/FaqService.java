package com.acorn2.FinalProject.faq.service;

import com.acorn2.FinalProject.faq.dto.FaqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqCreateReqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqReadReqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqUpdateReqDto;
import com.acorn2.FinalProject.faq.dto.res.FaqReadListResDto;

public interface FaqService {
	
	FaqReadListResDto selectFaqList(FaqReadReqDto faqReadReq);
	
	FaqDto FaqOne(int faqNum);
	
	void FaqInsert(FaqCreateReqDto faqCreateReqDto);
	
	void FaqUpdate(FaqUpdateReqDto faqUpdateReqDto);
	
	void FaqDelete(int faqNum);
}
