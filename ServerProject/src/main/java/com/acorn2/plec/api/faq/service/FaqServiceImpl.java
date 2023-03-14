package com.acorn2.plec.api.faq.service;

import java.util.List;

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
import com.acorn2.plec.api.faq.dto.res.FaqReadDetailResDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadListResDto;
import com.acorn2.plec.api.faq.dto.res.FaqReadResDto;
import com.acorn2.plec.api.faq.exception.FaqNotFoundException;
import com.acorn2.plec.common.utils.SessionUtils;

@EnableCaching
@Service
public class FaqServiceImpl implements FaqService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String SESSION_USERT_ID = "id";

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
	public FaqReadDetailResDto selectFaqOne(FaqReadReqDto faqReadReqDto) {
		if (faqDao.selectFaq(faqReadReqDto) == null) {
			throw new FaqNotFoundException("자주묻는질문이 없습니다.");
		}
		return faqDao.selectFaq(faqReadReqDto);
	}

	@Transactional
	@Override
	public void insertFaq(FaqCreateReqDto faqCreateReqDto) {
		String id = SessionUtils.getUserId();
		FaqDto dto = new FaqDto();
		dto.setQuestion(faqCreateReqDto.getQuestion());
		dto.setContent(faqCreateReqDto.getContent());
		dto.setFaqWriter(id);
		faqDao.insertFaq(dto);
	}

	@Transactional
	@Override
	public void updateFaq(FaqUpdateReqDto faqUpdateReqDto) {
		String id = SessionUtils.getUserId();
		FaqDto dto = new FaqDto();
		dto.setFaqNum(faqUpdateReqDto.getFaqNum());
		dto.setQuestion(faqUpdateReqDto.getQuestion());
		dto.setContent(faqUpdateReqDto.getContent());
		dto.setUpdateId(id);

		faqDao.updateFaq(dto);
	}

	@Transactional
	@Override
	public void deleteUpdateFaq(Integer faqNum) {

		faqDao.deleteUpdateFaq(faqNum);
	}

	@Transactional
	@Override
	public void deleteFaq() {

		faqDao.deleteFaq();
	}

}
