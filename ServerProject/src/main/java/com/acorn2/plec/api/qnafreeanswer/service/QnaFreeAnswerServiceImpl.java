package com.acorn2.plec.api.qnafreeanswer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.plec.api.qnafreeanswer.dao.QnaFreeAnswerDao;
import com.acorn2.plec.api.qnafreeanswer.dto.QnaFreeAnswerDto;
import com.acorn2.plec.api.qnafreeanswer.dto.req.QnaFreeAnswerCreateReqDto;
import com.acorn2.plec.api.qnafreeanswer.dto.req.QnaFreeAnswerReadReqDto;
import com.acorn2.plec.api.qnafreeanswer.dto.req.QnaFreeAnswerUpdateReqDto;
import com.acorn2.plec.api.qnafreeanswer.dto.res.QnaFreeAnswerReadDetailResDto;
import com.acorn2.plec.api.qnafreeanswer.dto.res.QnaFreeAnswerReadListResDto;
import com.acorn2.plec.api.qnafreeanswer.dto.res.QnaFreeAnswerReadResDto;
import com.acorn2.plec.api.qnafreeanswer.exception.QnaFreeAnswerNotFoundException;

@EnableCaching
@Service
public class QnaFreeAnswerServiceImpl implements QnaFreeAnswerService{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private QnaFreeAnswerDao qnaFreeAnswerDao;

	@Override
	@Cacheable(value = "qnaFreeAnswer", key = "#qnaFreeAnswerReadReq.hashCode()")
	public QnaFreeAnswerReadListResDto selectQnaFreeAnswerList(QnaFreeAnswerReadReqDto qnaFreeAnswerReadReqDto) {
		Integer totalCount = qnaFreeAnswerDao.selectQnaFreeAnswerCount(qnaFreeAnswerReadReqDto);
		List<QnaFreeAnswerReadResDto> qnaFreeAnswerReadResDtoList = qnaFreeAnswerDao.selectQnaFreeAnswerList(qnaFreeAnswerReadReqDto);
		QnaFreeAnswerReadListResDto qnaFreeAnswerReadListResDto = new QnaFreeAnswerReadListResDto(totalCount, qnaFreeAnswerReadReqDto);
		qnaFreeAnswerReadListResDto.setData(qnaFreeAnswerReadResDtoList);
		logger.debug("Cached value for key {} is {}", qnaFreeAnswerReadReqDto.hashCode(), qnaFreeAnswerReadListResDto.toString());
		return qnaFreeAnswerReadListResDto;
	}

	@Override
	public QnaFreeAnswerReadDetailResDto selectQnaFreeAnswerOne(QnaFreeAnswerReadReqDto qnaFreeAnswerReadReqDto) {
		if (qnaFreeAnswerDao.selectQnaFreeAnswer(qnaFreeAnswerReadReqDto) == null) {
			throw new QnaFreeAnswerNotFoundException("자유게시판 댓글이 없습니다.");
		}
		return qnaFreeAnswerDao.selectQnaFreeAnswer(qnaFreeAnswerReadReqDto);
	}

	@Transactional
	@Override
	public void insertQnaFreeAnswer(QnaFreeAnswerCreateReqDto qnaFreeAnswerCreateReqDto, String id) {
		QnaFreeAnswerDto dto = new QnaFreeAnswerDto();
		dto.setFreeCommentRefGroup(qnaFreeAnswerCreateReqDto.getFreeCommentRefGroup());
		dto.setContent(qnaFreeAnswerCreateReqDto.getContent());
		dto.setFreeCommentWriter(id);
		qnaFreeAnswerDao.insertQnaFreeAnswer(dto);
		
	}

	@Transactional
	@Override
	public void updateQnaFreeAnswer(QnaFreeAnswerUpdateReqDto qnaFreeAnswerUpdateReqDto, String id) {
		QnaFreeAnswerDto dto = new QnaFreeAnswerDto();
		dto.setFreeCommentNum(qnaFreeAnswerUpdateReqDto.getFreeCommentNum());
		dto.setContent(qnaFreeAnswerUpdateReqDto.getContent());
		dto.setUpdateId(id);

		qnaFreeAnswerDao.updateQnaFreeAnswer(dto);
		
	}

	@Transactional
	@Override
	public void deleteUpdateQnaFreeAnswer(Integer freeCommentNum) {
		qnaFreeAnswerDao.deleteUpdateQnaFreeAnswer(freeCommentNum);
		
	}

	@Transactional
	@Override
	public void deleteQnaFreeAnswer() {
		qnaFreeAnswerDao.deleteQnaFreeAnswer();
		
	}
	
}
