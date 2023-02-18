package com.acorn2.FinalProject.faq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn2.FinalProject.faq.dao.FaqDao;
import com.acorn2.FinalProject.faq.dto.FaqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqCreateReqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqReadReqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqUpdateReqDto;
import com.acorn2.FinalProject.faq.dto.res.FaqReadListResDto;
import com.acorn2.FinalProject.faq.dto.res.FaqReadResDto;


@Service
public class FaqServiceImpl implements FaqService{
	@Autowired
	private FaqDao faqDao;

	@Override
	public FaqReadListResDto selectFaqList(FaqReadReqDto faqReadReqDto) {
		Integer totalCount = faqDao.selectFaqCount(faqReadReqDto);
		List<FaqReadResDto> faqReadResDtoList = faqDao.selectFaqList(faqReadReqDto);
		FaqReadListResDto faqReadListResDto = new FaqReadListResDto(totalCount, faqReadReqDto);
		faqReadListResDto.setData(faqReadResDtoList);
		return faqReadListResDto;
	}

	@Override
	public FaqDto FaqOne(int faq_num) {
		
		return faqDao.FaqOne(faq_num);
	}
	
	@Override
	public void FaqInsert(FaqCreateReqDto faqCreateReqDto) {
		FaqDto dto = new FaqDto();
		dto.setFaq_num(faqCreateReqDto.getFaq_num());
		dto.setFaq_writer(faqCreateReqDto.getFaq_writer());
		dto.setQuestion(faqCreateReqDto.getQuestion());
		dto.setContent(faqCreateReqDto.getContent());
		
		faqDao.insertFaq(dto);
	}

	@Override
	public void FaqUpdate(FaqUpdateReqDto faqUpdateReqDto) {
		FaqDto dto = new FaqDto();
		dto.setFaq_num(faqUpdateReqDto.getFaq_num());
		dto.setUpdate_id(faqUpdateReqDto.getUpdate_id());
		dto.setQuestion(faqUpdateReqDto.getQuestion());
		dto.setContent(faqUpdateReqDto.getContent());
		
		faqDao.updateFaq(dto);
	}

	@Override
	public void FaqDelete(int faq_num) {

		faqDao.deleteFaq(faq_num);
	}
	
}
