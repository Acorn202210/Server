package com.acorn2.plec.api.faq.service;

import com.acorn2.plec.api.faq.dto.req.FaqCreateReqDto;
import com.acorn2.plec.api.faq.dto.req.FaqReadReqDto;
import com.acorn2.plec.api.faq.dto.req.FaqUpdateReqDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadDetailResDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadListResDto;

public interface FaqService {
	FaqReadListResDto selectFaqList(FaqReadReqDto faqReadReqDto);

	FaqReadDetailResDto selectFaqOne(FaqReadReqDto faqReadReqDto);

	void insertFaq(FaqCreateReqDto faqCreateReqDto, String id);

	void updateFaq(FaqUpdateReqDto faqUpdateReqDto, String id);

	void deleteUpdateFaq(Integer faqNum);

	void deleteFaq();

}
