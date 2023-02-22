package com.acorn2.FinalProject.faq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.acorn2.FinalProject.faq.dao.FaqDao;
import com.acorn2.FinalProject.faq.dto.FaqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqCreateReqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqReadReqDto;
import com.acorn2.FinalProject.faq.dto.req.FaqUpdateReqDto;
import com.acorn2.FinalProject.faq.dto.res.FaqReadListResDto;
import com.acorn2.FinalProject.faq.dto.res.FaqReadResDto;

@EnableCaching
@Service
public class FaqServiceImpl implements FaqService{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private FaqDao faqDao;

	@Override
	@Cacheable(value = "faq", key = "#faqReadReqDto.hashCode()")
	public FaqReadListResDto selectFaqList(FaqReadReqDto faqReadReqDto) {
		Integer totalCount = faqDao.selectFaqCount(faqReadReqDto);
		List<FaqReadResDto> faqReadResDtoList = faqDao.selectFaqList(faqReadReqDto);
		FaqReadListResDto faqReadListResDto = new FaqReadListResDto(totalCount, faqReadReqDto);
		faqReadListResDto.setData(faqReadResDtoList);
		logger.debug("Cached value for key {} is {}", faqReadReqDto.hashCode(), faqReadListResDto.toString());
		return faqReadListResDto;
	}

	@Override
	public FaqDto FaqOne(int faqNum) {
		
		return faqDao.FaqOne(faqNum);
	}
	
	@Override
	public void FaqInsert(FaqCreateReqDto faqCreateReqDto) {
		FaqDto dto = new FaqDto();
		dto.setFaqNum(faqCreateReqDto.getFaqNum());
		dto.setFaqWriter(faqCreateReqDto.getFaqWriter());
		dto.setQuestion(faqCreateReqDto.getQuestion());
		dto.setContent(faqCreateReqDto.getContent());
		
		faqDao.insertFaq(dto);
	}

	@Override
	public void FaqUpdate(FaqUpdateReqDto faqUpdateReqDto) {
		FaqDto dto = new FaqDto();
		dto.setFaqNum(faqUpdateReqDto.getFaqNum());
		dto.setUpdateId(faqUpdateReqDto.getUpdateId());
		dto.setQuestion(faqUpdateReqDto.getQuestion());
		dto.setContent(faqUpdateReqDto.getContent());
		
		faqDao.updateFaq(dto);
	}

	@Override
	public void FaqDelete(int faqNum) {

		faqDao.deleteFaq(faqNum);
	}

	@Override
	public void deleteFaq() {
	
		faqDao.Faqdelete();
	}
	
}
