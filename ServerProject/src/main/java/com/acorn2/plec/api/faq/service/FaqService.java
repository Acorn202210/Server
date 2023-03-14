package com.acorn2.plec.api.faq.service;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.plec.api.faq.dto.req.FaqCreateReqDto;
import com.acorn2.plec.api.faq.dto.req.FaqReadReqDto;
import com.acorn2.plec.api.faq.dto.req.FaqUpdateReqDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadDetailResDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadListResDto;

public interface FaqService {
	FaqReadListResDto selectFaqList(FaqReadReqDto faqReadReqDto);

	FaqReadDetailResDto selectFaqOne(FaqReadReqDto faqReadReqDto);

	void insertFaq(FaqCreateReqDto faqCreateReqDto, HttpServletRequest request);

	void updateFaq(FaqUpdateReqDto faqUpdateReqDto, HttpServletRequest request);

	void deleteUpdateFaq(Integer faqNum);

	void deleteFaq();
}
