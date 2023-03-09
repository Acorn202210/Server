package com.acorn2.plec.api.faq.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.plec.api.faq.dao.FaqDao;
import com.acorn2.plec.api.faq.dto.FaqDto;
import com.acorn2.plec.api.faq.dto.req.FaqCreateReqDto;
import com.acorn2.plec.api.faq.dto.req.FaqReadReqDto;
import com.acorn2.plec.api.faq.dto.req.FaqUpdateReqDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadListResDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadResDto;



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
	
	@Transactional
	@Override
	public void FaqInsert(FaqCreateReqDto faqCreateReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		FaqDto dto = new FaqDto();
		dto.setFaqNum(faqCreateReqDto.getFaqNum());
		dto.setQuestion(faqCreateReqDto.getQuestion());
		dto.setContent(faqCreateReqDto.getContent());
		dto.setFaqWriter(session.getAttribute("id").toString());
		faqDao.insertFaq(dto);
	}

	@Transactional
	@Override
	public void FaqUpdate(FaqUpdateReqDto faqUpdateReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		FaqDto dto = new FaqDto();
		dto.setFaqNum(faqUpdateReqDto.getFaqNum());
		dto.setUpdateId(session.getAttribute("id").toString());
		dto.setQuestion(faqUpdateReqDto.getQuestion());
		dto.setContent(faqUpdateReqDto.getContent());
		
		faqDao.updateFaq(dto);
	}

	@Transactional
	@Override
	public void FaqDelete(Integer faqNum) {

		faqDao.deleteFaq(faqNum);
	}

	@Transactional
	@Override
	public void deleteFaq() {
	
		faqDao.Faqdelete();
	}
	
}
